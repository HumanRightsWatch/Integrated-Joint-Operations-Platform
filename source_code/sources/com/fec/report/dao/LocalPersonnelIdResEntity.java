package com.fec.report.dao;

public class LocalPersonnelIdResEntity {
    private String addUser;
    private String addUserName;
    private String deadTrackReason;
    private String enterTime;
    private String enterWay;
    private String id;
    private String isInbound;
    private String isMatch;
    private Double latitude;
    private String leaveReason;
    private Long localFkPim;
    private Long localID;
    private String locationDescription;
    private Double longitude;
    private String note;
    private String otherEnterWay;
    private String otherLeaveReason;
    private String otherTrackReason;
    private String policeCheck;
    private String policeReason;
    private String trackReason;
    private String userAddress;
    private String userIdCard;
    private String userName;
    private String userOrgName;
    private String userOrganizationId;
    private String userPhone;

    public LocalPersonnelIdResEntity(Long localID) {
        this.localID = localID;
    }

    public LocalPersonnelIdResEntity(Long localID, String id, Long localFkPim, String isMatch, String deadTrackReason, String isInbound, String enterTime, String enterWay, String otherEnterWay, String leaveReason, String otherLeaveReason, String trackReason, String otherTrackReason, String userName, String userIdCard, String userPhone, String userAddress, String policeCheck, String policeReason, String note, String addUser, String addUserName, String userOrganizationId, String userOrgName, Double longitude, Double latitude, String locationDescription) {
        this.localID = localID;
        this.id = id;
        this.localFkPim = localFkPim;
        this.isMatch = isMatch;
        this.deadTrackReason = deadTrackReason;
        this.isInbound = isInbound;
        this.enterTime = enterTime;
        this.enterWay = enterWay;
        this.otherEnterWay = otherEnterWay;
        this.leaveReason = leaveReason;
        this.otherLeaveReason = otherLeaveReason;
        this.trackReason = trackReason;
        this.otherTrackReason = otherTrackReason;
        this.userName = userName;
        this.userIdCard = userIdCard;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.policeCheck = policeCheck;
        this.policeReason = policeReason;
        this.note = note;
        this.addUser = addUser;
        this.addUserName = addUserName;
        this.userOrganizationId = userOrganizationId;
        this.userOrgName = userOrgName;
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

    public Long getLocalFkPim() {
        return this.localFkPim;
    }

    public void setLocalFkPim(Long localFkPim) {
        this.localFkPim = localFkPim;
    }

    public String getIsMatch() {
        return this.isMatch;
    }

    public void setIsMatch(String isMatch) {
        this.isMatch = isMatch;
    }

    public String getDeadTrackReason() {
        return this.deadTrackReason;
    }

    public void setDeadTrackReason(String deadTrackReason) {
        this.deadTrackReason = deadTrackReason;
    }

    public String getIsInbound() {
        return this.isInbound;
    }

    public void setIsInbound(String isInbound) {
        this.isInbound = isInbound;
    }

    public String getEnterTime() {
        return this.enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getEnterWay() {
        return this.enterWay;
    }

    public void setEnterWay(String enterWay) {
        this.enterWay = enterWay;
    }

    public String getOtherEnterWay() {
        return this.otherEnterWay;
    }

    public void setOtherEnterWay(String otherEnterWay) {
        this.otherEnterWay = otherEnterWay;
    }

    public String getLeaveReason() {
        return this.leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getOtherLeaveReason() {
        return this.otherLeaveReason;
    }

    public void setOtherLeaveReason(String otherLeaveReason) {
        this.otherLeaveReason = otherLeaveReason;
    }

    public String getTrackReason() {
        return this.trackReason;
    }

    public void setTrackReason(String trackReason) {
        this.trackReason = trackReason;
    }

    public String getOtherTrackReason() {
        return this.otherTrackReason;
    }

    public void setOtherTrackReason(String otherTrackReason) {
        this.otherTrackReason = otherTrackReason;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdCard() {
        return this.userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return this.userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
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
}
