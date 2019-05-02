package com.fec.report.dao;

public class OverduePersonContact {
    private Long fkOpv;
    private Long id;
    private String idCard;
    private String name;
    private String note;
    private String otherRelation;
    private String phone;
    private Integer relation;
    private String service_id;
    private Integer sex;

    public OverduePersonContact(Long id) {
        this.id = id;
    }

    public OverduePersonContact(Long id, String service_id, Long fkOpv, String name, String phone, String note, String idCard, Integer sex, Integer relation, String otherRelation) {
        this.id = id;
        this.service_id = service_id;
        this.fkOpv = fkOpv;
        this.name = name;
        this.phone = phone;
        this.note = note;
        this.idCard = idCard;
        this.sex = sex;
        this.relation = relation;
        this.otherRelation = otherRelation;
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

    public Long getFkOpv() {
        return this.fkOpv;
    }

    public void setFkOpv(Long fkOpv) {
        this.fkOpv = fkOpv;
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

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getRelation() {
        return this.relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public String getOtherRelation() {
        return this.otherRelation;
    }

    public void setOtherRelation(String otherRelation) {
        this.otherRelation = otherRelation;
    }
}
