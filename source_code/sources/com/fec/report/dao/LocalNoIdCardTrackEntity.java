package com.fec.report.dao;

public class LocalNoIdCardTrackEntity {
    private String addTime;
    private String addUser;
    private String addUserName;
    private String dataId;
    private String description;
    private String feedbackTime;
    private String fkCm;
    private String id;
    private String idCard;
    private String index;
    private Integer isChecked;
    private Integer isLogicDelete;
    private Long localID;
    private String modifier;
    private String modifierName;
    private String modifyTime;
    private String name;
    private String note;
    private String permanentAddress;
    private String phoneNumber;
    private String policeCheck;
    private String pushTime;
    private String sendTime;
    private String userOrgName;
    private String userOrganizationId;

    public LocalNoIdCardTrackEntity(Long localID) {
        this.localID = localID;
    }

    public LocalNoIdCardTrackEntity(Long localID, String id, String dataId, String index, String phoneNumber, String idCard, String permanentAddress, String name, String pushTime, String description, Integer isChecked, String fkCm, String sendTime, String feedbackTime, String policeCheck, String note, String addUser, String addUserName, String addTime, String userOrganizationId, String userOrgName, String modifier, String modifierName, String modifyTime, Integer isLogicDelete) {
        this.localID = localID;
        this.id = id;
        this.dataId = dataId;
        this.index = index;
        this.phoneNumber = phoneNumber;
        this.idCard = idCard;
        this.permanentAddress = permanentAddress;
        this.name = name;
        this.pushTime = pushTime;
        this.description = description;
        this.isChecked = isChecked;
        this.fkCm = fkCm;
        this.sendTime = sendTime;
        this.feedbackTime = feedbackTime;
        this.policeCheck = policeCheck;
        this.note = note;
        this.addUser = addUser;
        this.addUserName = addUserName;
        this.addTime = addTime;
        this.userOrganizationId = userOrganizationId;
        this.userOrgName = userOrgName;
        this.modifier = modifier;
        this.modifierName = modifierName;
        this.modifyTime = modifyTime;
        this.isLogicDelete = isLogicDelete;
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

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getIndex() {
        return this.index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPermanentAddress() {
        return this.permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPushTime() {
        return this.pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsChecked() {
        return this.isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    public String getFkCm() {
        return this.fkCm;
    }

    public void setFkCm(String fkCm) {
        this.fkCm = fkCm;
    }

    public String getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getFeedbackTime() {
        return this.feedbackTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public String getPoliceCheck() {
        return this.policeCheck;
    }

    public void setPoliceCheck(String policeCheck) {
        this.policeCheck = policeCheck;
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

    public Integer getIsLogicDelete() {
        return this.isLogicDelete;
    }

    public void setIsLogicDelete(Integer isLogicDelete) {
        this.isLogicDelete = isLogicDelete;
    }
}
