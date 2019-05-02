package com.fec.report.dao;

public class LocalPersonnelCarResEntity {
    private Long id;
    private String isMatch;
    private Double latitude;
    private Long localFkPcv;
    private Long localID;
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

    public LocalPersonnelCarResEntity(Long localID) {
        this.localID = localID;
    }

    public LocalPersonnelCarResEntity(Long localID, Long id, Long localFkPcv, String isMatch, String mismatchReason, String otherMismatchReason, String ownerName, String ownerIdCard, String ownerPhone, String ownerAddress, String policeCheck, String policeReason, String note, Double longitude, Double latitude, String locationDescription) {
        this.localID = localID;
        this.id = id;
        this.localFkPcv = localFkPcv;
        this.isMatch = isMatch;
        this.mismatchReason = mismatchReason;
        this.otherMismatchReason = otherMismatchReason;
        this.ownerName = ownerName;
        this.ownerIdCard = ownerIdCard;
        this.ownerPhone = ownerPhone;
        this.ownerAddress = ownerAddress;
        this.policeCheck = policeCheck;
        this.policeReason = policeReason;
        this.note = note;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLocalFkPcv() {
        return this.localFkPcv;
    }

    public void setLocalFkPcv(Long localFkPcv) {
        this.localFkPcv = localFkPcv;
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
