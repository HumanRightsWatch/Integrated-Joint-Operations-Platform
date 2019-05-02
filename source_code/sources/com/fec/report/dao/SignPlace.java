package com.fec.report.dao;

public class SignPlace {
    private String address;
    private Long id;
    private Double latitude;
    private String location;
    private Double longitude;
    private String other;
    private String placename;
    private Integer type;

    public SignPlace(Long id) {
        this.id = id;
    }

    public SignPlace(Long id, String placename, Double latitude, Double longitude, String address, String location, String other, Integer type) {
        this.id = id;
        this.placename = placename;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.location = location;
        this.other = other;
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlacename() {
        return this.placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOther() {
        return this.other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
