package com.fec.xjoneproject.ui.task.person_car_match.bean;

import com.hbfec.asmack.im.comm.ConnectionUtils;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneinformation.Utils.Constants;
import com.hbfec.xjoneinformation.Utils.XMPPConfiguration;

public class PersonnelCarResEntity {
    private String addUser;
    private String addUserName;
    private String fkPcv;
    private Long id;
    private String isMatch;
    private Double latitude;
    private String locationDescription;
    private Double longitude;
    private String mismatchReason;
    private String note;
    private String otherMismatchReason;
    private String ownerAddress;
    private String ownerIdCard;
    private String ownerName;
    private String ownerPhone;
    private String policeCheck;
    private String policeReason;
    private String userOrgName;
    private String userOrganizationId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFkPcv() {
        return this.fkPcv;
    }

    public void setFkPcv(String fkPcv) {
        this.fkPcv = fkPcv;
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

    public PersonnelCarResEntity() {
        XMPPConfiguration mXmppConfig = new XMPPConfiguration(IMSDroid.getContext());
        String userName = mXmppConfig.getString(Constants.UUM_USER_NAME, "");
        String organizationId = mXmppConfig.getString(Constants.UUM_USER_ORGANIZATION_ID, "");
        String organizationName = mXmppConfig.getString(Constants.UUM_USER_ORGANIZATION_NAME, "");
        setAddUser(ConnectionUtils.getLoginName());
        setAddUserName(userName);
        setUserOrganizationId(organizationId);
        setUserOrgName(organizationName);
    }
}
