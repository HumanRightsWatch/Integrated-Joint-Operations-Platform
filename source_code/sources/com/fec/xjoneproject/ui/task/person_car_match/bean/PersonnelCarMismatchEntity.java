package com.fec.xjoneproject.ui.task.person_car_match.bean;

import com.fec.xjoneproject.sign.DateUtil;

public class PersonnelCarMismatchEntity {
    private String addUser;
    private String addUserName;
    private String description;
    private String feedbackTime;
    private String fillAddress;
    private Integer fillCount;
    private String fillTime;
    private String fillerAddress;
    private String fillerIdCard;
    private String fillerName;
    private String fillerNation;
    private Integer fillerSex;
    private String fkCm;
    private String gasStationName;
    private String id;
    private Integer isChecked;
    private String licensePlate;
    private String note;
    private String ownerAddress;
    private String ownerIdCard;
    private String ownerName;
    private String ownerPhone;
    private String policeReason;
    private String pushTime;
    private String sendTime;
    private String userOrgName;
    private String userOrganizationId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerIdCard() {
        return this.ownerIdCard;
    }

    public void setOwnerIdCard(String ownerIdCard) {
        this.ownerIdCard = ownerIdCard;
    }

    public String getOwnerPhone() {
        return this.ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerAddress() {
        return this.ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getFillerName() {
        return this.fillerName;
    }

    public void setFillerName(String fillerName) {
        this.fillerName = fillerName;
    }

    public Integer getFillerSex() {
        return this.fillerSex;
    }

    public void setFillerSex(Integer fillerSex) {
        this.fillerSex = fillerSex;
    }

    public String getFillerNation() {
        return this.fillerNation;
    }

    public void setFillerNation(String fillerNation) {
        this.fillerNation = fillerNation;
    }

    public String getFillerIdCard() {
        return this.fillerIdCard;
    }

    public void setFillerIdCard(String fillerIdCard) {
        this.fillerIdCard = fillerIdCard;
    }

    public String getFillerAddress() {
        return this.fillerAddress;
    }

    public void setFillerAddress(String fillerAddress) {
        this.fillerAddress = fillerAddress;
    }

    public String getGasStationName() {
        return this.gasStationName;
    }

    public void setGasStationName(String gasStationName) {
        this.gasStationName = gasStationName;
    }

    public String getFillAddress() {
        return this.fillAddress;
    }

    public void setFillAddress(String fillAddress) {
        this.fillAddress = fillAddress;
    }

    public String getFillTime() {
        return DateUtil.friendlyTime(this.fillTime);
    }

    public void setFillTime(String fillTime) {
        this.fillTime = fillTime;
    }

    public Integer getFillCount() {
        return this.fillCount;
    }

    public void setFillCount(Integer fillCount) {
        this.fillCount = fillCount;
    }

    public String getPushTime() {
        return DateUtil.friendlyTime(this.pushTime);
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

    public String getPoliceReason() {
        return this.policeReason;
    }

    public void setPoliceReason(String policeReason) {
        this.policeReason = policeReason;
    }
}
