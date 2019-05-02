package com.fec.report.dao;

public class OutOfPersonPeer {
    private String idCard;
    private Long localId;
    private Long localfkPod;
    private String mobilePhone;
    private String name;

    public OutOfPersonPeer(Long localId) {
        this.localId = localId;
    }

    public OutOfPersonPeer(Long localId, Long localfkPod, String name, String idCard, String mobilePhone) {
        this.localId = localId;
        this.localfkPod = localfkPod;
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

    public Long getLocalfkPod() {
        return this.localfkPod;
    }

    public void setLocalfkPod(Long localfkPod) {
        this.localfkPod = localfkPod;
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
