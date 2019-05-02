package com.fec.report.dao;

public class LocalNoIdCardTrackVisitorEntity {
    private String addTime;
    private String addUser;
    private String addUserName;
    private String address;
    private String checkFlag;
    private String fkMit;
    private String id;
    private String idCard;
    private Double latitude;
    private Long localID;
    private String locationDescription;
    private Double longitude;
    private String modifier;
    private String modifierName;
    private String modifyTime;
    private String name;
    private String phone;
    private String type;
    private String userOrgName;
    private String userOrganizationId;

    public LocalNoIdCardTrackVisitorEntity(Long localID) {
        this.localID = localID;
    }

    public LocalNoIdCardTrackVisitorEntity(Long localID, String id, String fkMit, String name, String idCard, String phone, String address, String type, String checkFlag, String addUser, String addUserName, String addTime, String userOrganizationId, String userOrgName, String modifier, String modifierName, String modifyTime, Double longitude, Double latitude, String locationDescription) {
        this.localID = localID;
        this.id = id;
        this.fkMit = fkMit;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.address = address;
        this.type = type;
        this.checkFlag = checkFlag;
        this.addUser = addUser;
        this.addUserName = addUserName;
        this.addTime = addTime;
        this.userOrganizationId = userOrganizationId;
        this.userOrgName = userOrgName;
        this.modifier = modifier;
        this.modifierName = modifierName;
        this.modifyTime = modifyTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationDescription = locationDescription;
    }

    public Long getLocalID() {
        return this.localID;
    }

    public void setLocalID(Long localID) {
        this.localID = localID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkMit() {
        return this.fkMit;
    }

    public void setFkMit(String fkMit) {
        this.fkMit = fkMit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheckFlag() {
        return this.checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getAddUser() {
        return this.addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public String getAddUserName() {
        return this.addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public String getAddTime() {
        return this.addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUserOrganizationId() {
        return this.userOrganizationId;
    }

    public void setUserOrganizationId(String userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }

    public String getUserOrgName() {
        return this.userOrgName;
    }

    public void setUserOrgName(String userOrgName) {
        this.userOrgName = userOrgName;
    }

    public String getModifier() {
        return this.modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifierName() {
        return this.modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getLocationDescription() {
        return this.locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }
}
