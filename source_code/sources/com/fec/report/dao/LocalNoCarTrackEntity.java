package com.fec.report.dao;

public class LocalNoCarTrackEntity {
    private String addTime;
    private String addTimeEnd;
    private String addUser;
    private String addUserName;
    private String dataId;
    private String description;
    private String districtAreaCode;
    private String endTime;
    private String feedbackTime;
    private String fkCm;
    private String id;
    private String index;
    private Integer isChecked;
    private Integer isLogicDelete;
    private String licensePlate;
    private Long localID;
    private String missTrailDate;
    private String modifier;
    private String modifierName;
    private String modifyTime;
    private String note;
    private String ownerAddress;
    private String ownerIdCard;
    private String ownerName;
    private String ownerPhone;
    private String policeCheck;
    private String pushTime;
    private String sendTime;
    private String userOrgName;
    private String userOrganizationId;

    public LocalNoCarTrackEntity(Long localID) {
        this.localID = localID;
    }

    public LocalNoCarTrackEntity(Long localID, String id, String dataId, String index, String ownerName, String ownerPhone, String ownerIdCard, String districtAreaCode, String licensePlate, String ownerAddress, String missTrailDate, String pushTime, String description, Integer isChecked, String fkCm, String sendTime, String feedbackTime, String policeCheck, String note, String addUser, String addUserName, String addTime, String addTimeEnd, String userOrganizationId, String userOrgName, String modifier, String modifierName, String modifyTime, String endTime, Integer isLogicDelete) {
        this.localID = localID;
        this.id = id;
        this.dataId = dataId;
        this.index = index;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.ownerIdCard = ownerIdCard;
        this.districtAreaCode = districtAreaCode;
        this.licensePlate = licensePlate;
        this.ownerAddress = ownerAddress;
        this.missTrailDate = missTrailDate;
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
        this.addTimeEnd = addTimeEnd;
        this.userOrganizationId = userOrganizationId;
        this.userOrgName = userOrgName;
        this.modifier = modifier;
        this.modifierName = modifierName;
        this.modifyTime = modifyTime;
        this.endTime = endTime;
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

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return this.ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerIdCard() {
        return this.ownerIdCard;
    }

    public void setOwnerIdCard(String ownerIdCard) {
        this.ownerIdCard = ownerIdCard;
    }

    public String getDistrictAreaCode() {
        return this.districtAreaCode;
    }

    public void setDistrictAreaCode(String districtAreaCode) {
        this.districtAreaCode = districtAreaCode;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getOwnerAddress() {
        return this.ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getMissTrailDate() {
        return this.missTrailDate;
    }

    public void setMissTrailDate(String missTrailDate) {
        this.missTrailDate = missTrailDate;
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

    public String getAddTimeEnd() {
        return this.addTimeEnd;
    }

    public void setAddTimeEnd(String addTimeEnd) {
        this.addTimeEnd = addTimeEnd;
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

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getIsLogicDelete() {
        return this.isLogicDelete;
    }

    public void setIsLogicDelete(Integer isLogicDelete) {
        this.isLogicDelete = isLogicDelete;
    }
}
