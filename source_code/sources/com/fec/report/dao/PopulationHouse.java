package com.fec.report.dao;

public class PopulationHouse {
    private String addTime;
    private String community;
    private String communityCode;
    private String distanceToFloatingPopulation;
    private String fkId;
    private String houseAddress;
    private Double houseLatitude;
    private Double houseLongitude;
    private String id;
    private String isSend;
    private String manager;
    private String managerPhone;
    private String modifier;
    private String modifyTime;
    private String note;
    private String ownerIdCard;
    private String ownerName;
    private String ownerPhone;
    private String picture;
    private String userOrganizationId;

    public PopulationHouse(String id) {
        this.id = id;
    }

    public PopulationHouse(String id, String ownerName, String houseAddress, String addTime, String communityCode, String community, String distanceToFloatingPopulation, String fkId, String ownerIdCard, String isSend, String manager, String managerPhone, String picture, String note, String ownerPhone, Double houseLongitude, Double houseLatitude, String modifier, String modifyTime, String userOrganizationId) {
        this.id = id;
        this.ownerName = ownerName;
        this.houseAddress = houseAddress;
        this.addTime = addTime;
        this.communityCode = communityCode;
        this.community = community;
        this.distanceToFloatingPopulation = distanceToFloatingPopulation;
        this.fkId = fkId;
        this.ownerIdCard = ownerIdCard;
        this.isSend = isSend;
        this.manager = manager;
        this.managerPhone = managerPhone;
        this.picture = picture;
        this.note = note;
        this.ownerPhone = ownerPhone;
        this.houseLongitude = houseLongitude;
        this.houseLatitude = houseLatitude;
        this.modifier = modifier;
        this.modifyTime = modifyTime;
        this.userOrganizationId = userOrganizationId;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getHouseAddress() {
        return this.houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getAddTime() {
        return this.addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getCommunityCode() {
        return this.communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public String getCommunity() {
        return this.community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getDistanceToFloatingPopulation() {
        return this.distanceToFloatingPopulation;
    }

    public void setDistanceToFloatingPopulation(String distanceToFloatingPopulation) {
        this.distanceToFloatingPopulation = distanceToFloatingPopulation;
    }

    public String getFkId() {
        return this.fkId;
    }

    public void setFkId(String fkId) {
        this.fkId = fkId;
    }

    public String getOwnerIdCard() {
        return this.ownerIdCard;
    }

    public void setOwnerIdCard(String ownerIdCard) {
        this.ownerIdCard = ownerIdCard;
    }

    public String getIsSend() {
        return this.isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    public String getManager() {
        return this.manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagerPhone() {
        return this.managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOwnerPhone() {
        return this.ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public Double getHouseLongitude() {
        return this.houseLongitude;
    }

    public void setHouseLongitude(Double houseLongitude) {
        this.houseLongitude = houseLongitude;
    }

    public Double getHouseLatitude() {
        return this.houseLatitude;
    }

    public void setHouseLatitude(Double houseLatitude) {
        this.houseLatitude = houseLatitude;
    }

    public String getModifier() {
        return this.modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getUserOrganizationId() {
        return this.userOrganizationId;
    }

    public void setUserOrganizationId(String userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }
}
