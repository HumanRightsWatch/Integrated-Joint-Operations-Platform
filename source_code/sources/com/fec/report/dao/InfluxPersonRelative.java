package com.fec.report.dao;

public class InfluxPersonRelative {
    private String idCard;
    private Long localId;
    private Long localfkPoi;
    private String mobilePhone;
    private String name;

    public InfluxPersonRelative(Long localId) {
        this.localId = localId;
    }

    public InfluxPersonRelative(Long localId, Long localfkPoi, String name, String idCard, String mobilePhone) {
        this.localId = localId;
        this.localfkPoi = localfkPoi;
        this.name = name;
        this.idCard = idCard;
        this.mobilePhone = mobilePhone;
    }

    public Long getLocalId() {
        return this.localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public Long getLocalfkPoi() {
        return this.localfkPoi;
    }

    public void setLocalfkPoi(Long localfkPoi) {
        this.localfkPoi = localfkPoi;
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

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
