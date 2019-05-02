package com.fec.report.dao;

public class SignBean {
    private String datetime;
    private String dept;
    private Long id;
    private String lang;
    private String lat;
    private String latitude1;
    private String location;
    private String locationDescription;
    private String longitude1;
    private String name;
    private String note;
    private String preinstallLocation;
    private String type;
    private String ucId;
    private String userOrganizationId;

    public SignBean(Long id) {
        this.id = id;
    }

    public SignBean(Long id, String name, String ucId, String dept, String datetime, String type, String location, String lang, String lat, String userOrganizationId, String locationDescription, String note, String preinstallLocation, String longitude1, String latitude1) {
        this.id = id;
        this.name = name;
        this.ucId = ucId;
        this.dept = dept;
        this.datetime = datetime;
        this.type = type;
        this.location = location;
        this.lang = lang;
        this.lat = lat;
        this.userOrganizationId = userOrganizationId;
        this.locationDescription = locationDescription;
        this.note = note;
        this.preinstallLocation = preinstallLocation;
        this.longitude1 = longitude1;
        this.latitude1 = latitude1;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUcId() {
        return this.ucId;
    }

    public void setUcId(String ucId) {
        this.ucId = ucId;
    }

    public String getDept() {
        return this.dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getUserOrganizationId() {
        return this.userOrganizationId;
    }

    public void setUserOrganizationId(String userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }

    public String getLocationDescription() {
        return this.locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPreinstallLocation() {
        return this.preinstallLocation;
    }

    public void setPreinstallLocation(String preinstallLocation) {
        this.preinstallLocation = preinstallLocation;
    }

    public String getLongitude1() {
        return this.longitude1;
    }

    public void setLongitude1(String longitude1) {
        this.longitude1 = longitude1;
    }

    public String getLatitude1() {
        return this.latitude1;
    }

    public void setLatitude1(String latitude1) {
        this.latitude1 = latitude1;
    }
}
