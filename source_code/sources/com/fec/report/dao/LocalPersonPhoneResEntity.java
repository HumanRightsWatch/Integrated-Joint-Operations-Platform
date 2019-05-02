package com.fec.report.dao;

public class LocalPersonPhoneResEntity {
    private String addTime;
    private String addUser;
    private String addUserName;
    private String fkPPV;
    private String holderAddress;
    private String holderIdCard;
    private String holderName;
    private String holderPhone;
    private String id;
    private String isMatch;
    private Double latitude;
    private Long localFkPPV;
    private Long localID;
    private String locationDescription;
    private Double longitude;
    private String mismatchReason;
    private String modifier;
    private String modifierName;
    private String modifyTime;
    private String note;
    private String otherMismatchReason;
    private String policeCheck;
    private String userOrgName;
    private String userOrganizationId;

    public LocalPersonPhoneResEntity(Long localID) {
        this.localID = localID;
    }

    public LocalPersonPhoneResEntity(Long localID, String id, Long localFkPPV, String fkPPV, String isMatch, String mismatchReason, String otherMismatchReason, String holderName, String holderIdCard, String holderPhone, String holderAddress, String policeCheck, String note, String addUser, String addUserName, String addTime, String userOrganizationId, String userOrgName, String modifier, String modifierName, String modifyTime, Double longitude, Double latitude, String locationDescription) {
        this.localID = localID;
        this.id = id;
        this.localFkPPV = localFkPPV;
        this.fkPPV = fkPPV;
        this.isMatch = isMatch;
        this.mismatchReason = mismatchReason;
        this.otherMismatchReason = otherMismatchReason;
        this.holderName = holderName;
        this.holderIdCard = holderIdCard;
        this.holderPhone = holderPhone;
        this.holderAddress = holderAddress;
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

    public Long getLocalFkPPV() {
        return this.localFkPPV;
    }

    public void setLocalFkPPV(Long localFkPPV) {
        this.localFkPPV = localFkPPV;
    }

    public String getFkPPV() {
        return this.fkPPV;
    }

    public void setFkPPV(String fkPPV) {
        this.fkPPV = fkPPV;
    }

    public String getIsMatch() {
        return this.isMatch;
    }

    public void setIsMatch(String isMatch) {
        this.isMatch = isMatch;
    }

    public String getMismatchReason() {
        return this.mismatchReason;
    }

    public void setMismatchReason(String mismatchReason) {
        this.mismatchReason = mismatchReason;
    }

    public String getOtherMismatchReason() {
        return this.otherMismatchReason;
    }

    public void setOtherMismatchReason(String otherMismatchReason) {
        this.otherMismatchReason = otherMismatchReason;
    }

    public String getHolderName() {
        return this.holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderIdCard() {
        return this.holderIdCard;
    }

    public void setHolderIdCard(String holderIdCard) {
        this.holderIdCard = holderIdCard;
    }

    public String getHolderPhone() {
        return this.holderPhone;
    }

    public void setHolderPhone(String holderPhone) {
        this.holderPhone = holderPhone;
    }

    public String getHolderAddress() {
        return this.holderAddress;
    }

    public void setHolderAddress(String holderAddress) {
        this.holderAddress = holderAddress;
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
