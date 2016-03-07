package com.firstSnowWebApp.entity;

public class Contact extends BaseEntity<Long>{
    private Long groupId;
    private String contactName;
    private String phoneNO;
    private String officePhone;
    private String familyPhone;
    private String contactAdd;

    public Contact(){};

    public Long getGroupId() { return this.groupId; }
    public void setGroupId(Long groupId) { this.groupId = groupId; }

    public String getContactName() { return this.contactName; }
    public void  setContactName(String contactName) { this.contactName = contactName; }

    public String getPhoneNO() { return this.phoneNO; }
    public  void  setPhoneNO(String phoneNO) { this.phoneNO = phoneNO; }

    public String getOfficePhone() { return this.officePhone; }
    public void setOfficePhone(String officePhone) { this.officePhone = officePhone; }

    public String getFamilyPhone() { return this.familyPhone; }
    public void setFamilyPhone(String familyPhone) { this.familyPhone = familyPhone; }

    public String getContactAdd() { return this.contactAdd; }
    public void setContactAdd(String contactAdd) { this.contactAdd = contactAdd; }

}
