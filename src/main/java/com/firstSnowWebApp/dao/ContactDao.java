package com.firstSnowWebApp.dao;

import com.google.inject.Singleton;
import com.google.inject.Inject;
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

import com.firstSnowWebApp.entity.Contact;
import com.firstSnowWebApp.entity.Group;

@Singleton
public class ContactDao extends BaseDao<Contact, Long>{

    @Inject
    private GroupDao groupDao;

    // --------- Create --------- //
    /**
     * Create a Contact with group
     * @param groupId
     * @param map for contact other values
     * @return
     */
    public Long createContact(Map map){
        if(map == null || map.get("groupId") == null || map.get("contactName") == null)
            return new Long(-1);
        Group group = groupDao.getGroupById(Long.parseLong(map.get("groupId").toString()));
        if(group == null)
            return new Long(-1);
        Contact newContact = new Contact();
        newContact.setGroupId(group.getId());
        newContact.setContactName(map.get("contactName").toString());
        newContact.setPhoneNO(map.get("phoneNO") == null ? null : map.get("phoneNO").toString());
        newContact.setOfficePhone(map.get("officePhone") == null ? null : map.get("officePhone").toString());
        newContact.setFamilyPhone(map.get("familyPhone") == null ? null : map.get("familyPhone").toString());
        newContact.setContactAdd(map.get("contactAdd") == null ? null : map.get("contactAdd").toString());
        return super.create(null, newContact);
    }
    // --------- /Create --------- //

    // --------- List --------- //
    /**
     * get user group contacts
     * @param groupId
     * @return
     */
    public List<Contact> getContactsByGroupId(Long groupId) {
        SelectQuery<Contact> selectQuery = Query.select(entityClass).where("groupId;=",groupId);
        return daoHelper.list(selectQuery);
    }
    // --------- /List --------- //
}