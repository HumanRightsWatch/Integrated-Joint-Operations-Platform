package com.fec.report.dao;

public class NineOneThreeSoftware {
    private String account;
    private Long id;
    private Long phone_id;
    private String service_id;
    private Integer type;

    public NineOneThreeSoftware(Long id) {
        this.id = id;
    }

    public NineOneThreeSoftware(Long id, String service_id, Long phone_id, Integer type, String account) {
        this.id = id;
        this.service_id = service_id;
        this.phone_id = phone_id;
        this.type = type;
        this.account = account;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService_id() {
        return this.service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public Long getPhone_id() {
        return this.phone_id;
    }

    public void setPhone_id(Long phone_id) {
        this.phone_id = phone_id;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
