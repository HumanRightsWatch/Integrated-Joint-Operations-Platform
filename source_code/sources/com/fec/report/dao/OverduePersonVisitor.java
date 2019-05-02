package com.fec.report.dao;

public class OverduePersonVisitor {
    private String activeAres;
    private String address;
    private Integer checkFlag;
    private Long fkOp;
    private Long id;
    private String idCard;
    private Integer isPush;
    private Integer kinship;
    private String name;
    private String note;
    private String otherRelation;
    private String phone;
    private String photo;
    private Integer relation;
    private String reson;
    private String service_id;
    private Integer sex;
    private Integer type;

    public OverduePersonVisitor(Long id) {
        this.id = id;
    }

    public OverduePersonVisitor(Long id, String service_id, Long fkOp, String name, Integer isPush, String idCard, String address, String activeAres, String phone, String photo, Integer relation, Integer kinship, String otherRelation, String reson, Integer type, Integer checkFlag, Integer sex, String note) {
        this.id = id;
        this.service_id = service_id;
        this.fkOp = fkOp;
        this.name = name;
        this.isPush = isPush;
        this.idCard = idCard;
        this.address = address;
        this.activeAres = activeAres;
        this.phone = phone;
        this.photo = photo;
        this.relation = relation;
        this.kinship = kinship;
        this.otherRelation = otherRelation;
        this.reson = reson;
        this.type = type;
        this.checkFlag = checkFlag;
        this.sex = sex;
        this.note = note;
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

    public Long getFkOp() {
        return this.fkOp;
    }

    public void setFkOp(Long fkOp) {
        this.fkOp = fkOp;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsPush() {
        return this.isPush;
    }

    public void setIsPush(Integer isPush) {
        this.isPush = isPush;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getActiveAres() {
        return this.activeAres;
    }

    public void setActiveAres(String activeAres) {
        this.activeAres = activeAres;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getRelation() {
        return this.relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public Integer getKinship() {
        return this.kinship;
    }

    public void setKinship(Integer kinship) {
        this.kinship = kinship;
    }

    public String getOtherRelation() {
        return this.otherRelation;
    }

    public void setOtherRelation(String otherRelation) {
        this.otherRelation = otherRelation;
    }

    public String getReson() {
        return this.reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCheckFlag() {
        return this.checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
