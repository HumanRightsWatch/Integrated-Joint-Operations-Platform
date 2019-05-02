package com.fec.report.dao;

public class InvestigateFamily {
    private String id;
    private String idCard;
    private Long local_fkIr;
    private Long local_id;
    private String name;
    private String note;
    private String phone;
    private Integer relation;

    public InvestigateFamily(Long local_id) {
        this.local_id = local_id;
    }

    public InvestigateFamily(Long local_id, String id, Long local_fkIr, String name, String idCard, String phone, Integer relation, String note) {
        this.local_id = local_id;
        this.id = id;
        this.local_fkIr = local_fkIr;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.relation = relation;
        this.note = note;
    }

    public Long getLocal_id() {
        return this.local_id;
    }

    public void setLocal_id(Long local_id) {
        this.local_id = local_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLocal_fkIr() {
        return this.local_fkIr;
    }

    public void setLocal_fkIr(Long local_fkIr) {
        this.local_fkIr = local_fkIr;
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

    public Integer getRelation() {
        return this.relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
