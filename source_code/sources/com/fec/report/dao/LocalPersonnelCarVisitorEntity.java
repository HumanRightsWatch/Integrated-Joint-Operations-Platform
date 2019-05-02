package com.fec.report.dao;

public class LocalPersonnelCarVisitorEntity {
    private String address;
    private String fkPcmh;
    private String id;
    private String idCard;
    private Double latitude;
    private String licensePlate;
    private Long localID;
    private String locationDescription;
    private Double longitude;
    private String name;
    private String phone;
    private String type;

    public LocalPersonnelCarVisitorEntity(Long localID) {
        this.localID = localID;
    }

    public LocalPersonnelCarVisitorEntity(Long localID, String id, String fkPcmh, String licensePlate, String name, String idCard, String phone, String address, String type, Double longitude, Double latitude, String locationDescription) {
        this.localID = localID;
        this.id = id;
        this.fkPcmh = fkPcmh;
        this.licensePlate = licensePlate;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.address = address;
        this.type = type;
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

    public String getFkPcmh() {
        return this.fkPcmh;
    }

    public void setFkPcmh(String fkPcmh) {
        this.fkPcmh = fkPcmh;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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
