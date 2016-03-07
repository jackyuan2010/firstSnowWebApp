package com.firstSnowWebApp.dao;

import com.google.common.base.Throwables;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.j8ql.DB;
import org.j8ql.DBBuilder;
import org.j8ql.Runner;
import org.j8ql.query.*;
import org.jomni.JomniMapper;
import org.postgresql.ds.PGSimpleDataSource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.*;
import java.util.stream.Stream;

import static org.j8ql.query.Query.*;

/**
 * Created by Administrator on 2/27/2016.
 */
@Singleton
public class DaoHelper {
    final DB db;
    final HikariDataSource ds;
    public final JomniMapper jomni;

    MBeanServer beanServer;
    ObjectName poolObjectName;

    @Inject
    public DaoHelper(@Named("db.server") String server,
                     @Named("db.port") String portStr,
                     @Named("db.name") String name,
                     @Named("db.user") String user,
                     @Named("db.pwd") String pwd,
                     @Named("db.pool.maxsize") String maxPoolSizeStr) {

        //System.out.println("DaoHelper ..... create pool START");
        String poolName = "default";

        int port = Integer.parseInt(portStr);
        int poolMaxSize = Integer.parseInt(maxPoolSizeStr);

        // create the HikariCP datasource
        HikariConfig config = new HikariConfig();
        PGSimpleDataSource pg = new PGSimpleDataSource();
        pg.setPortNumber(port);
        pg.setServerName(server);
        pg.setDatabaseName(name);
        pg.setUser(user);
        pg.setPassword(pwd);
        config.setDataSource(pg);
        config.setMaximumPoolSize(poolMaxSize);
        config.setRegisterMbeans(true);
        config.setPoolName(poolName);
        ds = new HikariDataSource(config);

        // initialize the beanServer used in getPoolInfo
        // (to know IdleConnections, ActiveConnections, TotalConnections, ThreadsAwaitingConnection).
        // Also, can set : connectionTimeout, idleTimeout, maxLifetime, minimumIdle, maximumPoolSize
        beanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            poolObjectName = new ObjectName("com.zaxxer.hikari:type=Pool (" + poolName + ")");
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }

        db = new DBBuilder().build(ds);
        jomni = db.mapper;
        //System.out.println("DaoHelper ..... create pool END");
    }

    public Map getPoolInfo(){
        Map poolInfo = new HashMap();
        try {
            Integer idleConnections = (Integer) beanServer.getAttribute(poolObjectName, "IdleConnections");
            Integer activeConnections = (Integer) beanServer.getAttribute(poolObjectName, "ActiveConnections");
            Integer totalConnections = (Integer) beanServer.getAttribute(poolObjectName, "TotalConnections");

            poolInfo.put("numConnections", totalConnections);
            poolInfo.put("numBusyConnections",activeConnections);
            poolInfo.put("numIdleConnections",idleConnections);
        } catch (Exception e) {
            // TODO: need to use logger.warn
            System.out.println(poolObjectName + " : " + ds.getPoolName() + " : " + e.getClass() + " : " +e.getMessage());

        }
        return poolInfo;
    }

    // --------- DML Query --------- //
    public <T> T execute(InsertQuery<T> query){
        try (Runner runner = db.openRunner()) {
            return runner.exec(query);
        }
    }


    public <T> T execute(UpdateQuery<T> query){
        try (Runner runner = db.openRunner()) {
            return runner.exec(query);
        }
    }


    public <T> T execute(DeleteQuery<T> query){
        try (Runner runner = db.openRunner()) {
            return runner.exec(query);
        }
    }
    // --------- /DML Query --------- //

    // --------- SelectQuery --------- //
    public <T> Optional<T> first(SelectQuery<T> query){
        try (Runner runner = db.openRunner()) {
            return runner.first(query);
        }
    }

    public long count(SelectQuery query){
        try (Runner runner = db.openRunner()) {
            return runner.count(query);
        }
    }

    public <T> Stream<T> stream(SelectQuery<T> query){
        try (Runner runner = db.openRunner()) {
            return runner.stream(query);
        }
    }
    public <T> List<T> list(SelectQuery<T> query){
        try (Runner runner = db.openRunner()) {
            return runner.list(query);
        }
    }
    // --------- /SelectQuery --------- //

    // --------- DB Proxy --------- //
    public List<String> getValidColumns(BaseQuery baseQuery, Collection<String> columnNames) {
        return db.getValidColumns(baseQuery, columnNames);
    }
    // --------- /DB Proxy --------- //

    public int executeUpdate(String sql,Object... values) {
        try (Runner runner = db.openRunner()){
            return runner.executeUpdate(sql,values);
        }
    }

    /**
     * WARNING: Call this only in application shutdown
     */
    public void closeDataSource(){
        ds.shutdown();
    }
}
