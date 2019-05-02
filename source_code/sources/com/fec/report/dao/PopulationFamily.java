package com.fec.report.dao;

public class PopulationFamily {
    private String addTime;
    private String fkId;
    private String headPortrait;
    private String id;
    private String idCard;
    private String isSend;
    private String modifier;
    private String modifyTime;
    private String name;
    private String note;
    private String phone;
    private String relationWithFloatingPopulation;
    private String residence;
    private String userOrganizationId;

    public PopulationFamily(String id) {
        this.id = id;
    }

    public PopulationFamily(String id, String fkId, String name, String idCard, String residence, String relationWithFloatingPopulation, String note, String headPortrait, String isSend, String addTime, String phone, String modifier, String modifyTime, String userOrganizationId) {
        this.id = id;
        this.fkId = fkId;
        this.name = name;
        this.idCard = idCard;
        this.residence = residence;
        this.relationWithFloatingPopulation = relationWithFloatingPopulation;
        this.note = note;
        this.headPortrait = headPortrait;
        this.isSend = isSend;
        this.addTime = addTime;
        this.phone = phone;
        this.modifier = modifier;
        this.modifyTime = modifyTime;
        this.userOrganizationId = userOrganizationId;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkId() {
        return this.fkId;
    }

    public void setFkId(String fkId) {
        this.fkId = fkId;
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

    public String getResidence() {
        return this.residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getRelationWithFloatingPopulation() {
        return this.relationWithFloatingPopulation;
    }

    public void setRelationWithFloatingPopulation(String relationWithFloatingPopulation) {
        this.relationWithFloatingPopulation = relationWithFloatingPopulation;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getHeadPortrait() {
        return this.headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getIsSend() {
        return this.isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    public String getAddTime() {
        return this.addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getModifier() {
        return this.modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getUserOrganizationId() {
        return this.userOrganizationId;
    }

    public void setUserOrganizationId(String userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }
}
