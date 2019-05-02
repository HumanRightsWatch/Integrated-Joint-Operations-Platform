package com.fec.report.dao;

public class NineOneThreeOverseas {
    private String account;
    private Long id;
    private String name;
    private String note;
    private String phone;
    private Long phone_id;
    private String relation;
    private String service_id;
    private Integer software_type;

    public NineOneThreeOverseas(Long id) {
        this.id = id;
    }

    public NineOneThreeOverseas(Long id, String service_id, Long phone_id, String name, String phone, String relation, String note, Integer software_type, String account) {
        this.id = id;
        this.service_id = service_id;
        this.phone_id = phone_id;
        this.name = name;
        this.phone = phone;
        this.relation = relation;
        this.note = note;
        this.software_type = software_type;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSoftware_type() {
        return this.software_type;
    }

    public void setSoftware_type(Integer software_type) {
        this.software_type = software_type;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
