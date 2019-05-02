package com.fec.report.dao;

public class ElecCheckFeedback {
    private String addTime;
    private String addUser;
    private String addr;
    private String checkMissionId;
    private String fkPw;
    private String id;
    private String idCard;
    private String isSuspicious;
    private Double latitude;
    private String locationDescription;
    private Double longitude;
    private String modifyTime;
    private String note;
    private String phone;
    private String policCheck;
    private String policeReason;
    private String reson;
    private String resonType;
    private String tool;
    private String userOrganizationId;

    public ElecCheckFeedback(String id) {
        this.id = id;
    }

    public ElecCheckFeedback(String id, String checkMissionId, String fkPw, String idCard, String phone, String addr, String tool, String resonType, String reson, String policCheck, Double longitude, Double latitude, String note, String addUser, String userOrganizationId, String addTime, String modifyTime, String isSuspicious, String policeReason, String locationDescription) {
        this.id = id;
        this.checkMissionId = checkMissionId;
        this.fkPw = fkPw;
        this.idCard = idCard;
        this.phone = phone;
        this.addr = addr;
        this.tool = tool;
        this.resonType = resonType;
        this.reson = reson;
        this.policCheck = policCheck;
        this.longitude = longitude;
        this.latitude = latitude;
        this.note = note;
        this.addUser = addUser;
        this.userOrganizationId = userOrganizationId;
        this.addTime = addTime;
        this.modifyTime = modifyTime;
        this.isSuspicious = isSuspicious;
        this.policeReason = policeReason;
        this.locationDescription = locationDescription;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckMissionId() {
        return this.checkMissionId;
    }

    public void setCheckMissionId(String checkMissionId) {
        this.checkMissionId = checkMissionId;
    }

    public String getFkPw() {
        return this.fkPw;
    }

    public void setFkPw(String fkPw) {
        this.fkPw = fkPw;
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

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTool() {
        return this.tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getResonType() {
        return this.resonType;
    }

    public void setResonType(String resonType) {
        this.resonType = resonType;
    }

    public String getReson() {
        return this.reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }

    public String getPolicCheck() {
        return this.policCheck;
    }

    public void setPolicCheck(String policCheck) {
        this.policCheck = policCheck;
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

    public String getUserOrganizationId() {
        return this.userOrganizationId;
    }

    public void setUserOrganizationId(String userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }

    public String getAddTime() {
        return this.addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getIsSuspicious() {
        return this.isSuspicious;
    }

    public void setIsSuspicious(String isSuspicious) {
        this.isSuspicious = isSuspicious;
    }

    public String getPoliceReason() {
        return this.policeReason;
    }

    public void setPoliceReason(String policeReason) {
        this.policeReason = policeReason;
    }

    public String getLocationDescription() {
        return this.locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }
}
