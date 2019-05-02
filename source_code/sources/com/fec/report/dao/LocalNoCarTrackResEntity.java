package com.fec.report.dao;

public class LocalNoCarTrackResEntity {
    private String addTime;
    private String addUser;
    private String addUserName;
    private Integer expression;
    private String expressionDesc;
    private String fkMctv;
    private String id;
    private Double latitude;
    private Long localFkMctv;
    private Long localID;
    private String locationDescription;
    private Double longitude;
    private Integer missTrailReason;
    private String modifier;
    private String modifierName;
    private String modifyTime;
    private String note;
    private String otherReason;
    private String policeCheck;
    private String policeReason;
    private Integer relationship;
    private String telNumber;
    private String userOrgName;
    private String userOrganizationId;

    public LocalNoCarTrackResEntity(Long localID) {
        this.localID = localID;
    }

    public LocalNoCarTrackResEntity(Long localID, String id, Long localFkMctv, String fkMctv, Integer relationship, Integer missTrailReason, String otherReason, String telNumber, Integer expression, String expressionDesc, String policeCheck, String policeReason, String note, String addUser, String addUserName, String addTime, String userOrganizationId, String userOrgName, String modifier, String modifierName, String modifyTime, Double longitude, Double latitude, String locationDescription) {
        this.localID = localID;
        this.id = id;
        this.localFkMctv = localFkMctv;
        this.fkMctv = fkMctv;
        this.relationship = relationship;
        this.missTrailReason = missTrailReason;
        this.otherReason = otherReason;
        this.telNumber = telNumber;
        this.expression = expression;
        this.expressionDesc = expressionDesc;
        this.policeCheck = policeCheck;
        this.policeReason = policeReason;
        this.note = note;
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

    public Long getLocalFkMctv() {
        return this.localFkMctv;
    }

    public void setLocalFkMctv(Long localFkMctv) {
        this.localFkMctv = localFkMctv;
    }

    public String getFkMctv() {
        return this.fkMctv;
    }

    public void setFkMctv(String fkMctv) {
        this.fkMctv = fkMctv;
    }

    public Integer getRelationship() {
        return this.relationship;
    }

    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
    }

    public Integer getMissTrailReason() {
        return this.missTrailReason;
    }

    public void setMissTrailReason(Integer missTrailReason) {
        this.missTrailReason = missTrailReason;
    }

    public String getOtherReason() {
        return this.otherReason;
    }

    public void setOtherReason(String otherReason) {
        this.otherReason = otherReason;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Integer getExpression() {
        return this.expression;
    }

    public void setExpression(Integer expression) {
        this.expression = expression;
    }

    public String getExpressionDesc() {
        return this.expressionDesc;
    }

    public void setExpressionDesc(String expressionDesc) {
        this.expressionDesc = expressionDesc;
    }

    public String getPoliceCheck() {
        return this.policeCheck;
    }

    public void setPoliceCheck(String policeCheck) {
        this.policeCheck = policeCheck;
    }

    public String getPoliceReason() {
        return this.policeReason;
    }

    public void setPoliceReason(String policeReason) {
        this.policeReason = policeReason;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
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
