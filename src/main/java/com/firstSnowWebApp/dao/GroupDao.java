package com.firstSnowWebApp.dao;

import com.google.inject.Singleton;
import org.apache.commons.lang.StringUtils;
import org.j8ql.Record;
import org.j8ql.Runner;
import org.j8ql.query.Condition;
import org.j8ql.query.Query;
import org.j8ql.query.SelectQuery;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.firstSnowWebApp.entity.User;
import com.firstSnowWebApp.entity.Group;

@Singleton
public class GroupDao extends BaseDao<Group, Long>{
    // --------- Create --------- //
    /**
     * Create a Group with name
     * @param user
     * @param groupName
     * @return
     */
    public Long createGroup(User user, String groupName){
        Group group = new Group();
        group.setGroupName(groupName);
        return super.create(user, group);
    }
    // --------- /Create --------- //

    // --------- get --------- //
    /**
     * get group by groupName
     * @param user
     * @param groupName
     * @return
     */
    public Group getGroupByName(User user, String groupName){
        SelectQuery<Group> selectQuery = Query.select(entityClass).where("groupName",groupName);
        if (user != null) {
            Condition userCondition = Query.and("group.userId", user.getId());
            Condition where = selectQuery.getWhere();
            where = (where == null) ? userCondition : where.and(userCondition);
            selectQuery = selectQuery.where(where);
        }
        return  daoHelper.first(selectQuery).orElse(null);
    }

    /**
     * get group by groupId
     * @param user
     * @param groupId
     * @return
     */
    public Group getGroupById(Long groupId){
        return daoHelper.first(Query.select(entityClass).where("id", groupId)).orElse(null);
    }
    // --------- /get --------- //

    // --------- List --------- //
    /**
     * get user groups
     * @param user
     * @return
     */
    public List<Group> getGroups(User user) {
        if (user != null) {
            SelectQuery<Group> selectQuery = Query.select(entityClass).where("userId;=",user.getId());
            return daoHelper.list(selectQuery);
        }
        return null;
    }
    // --------- /List --------- //
}