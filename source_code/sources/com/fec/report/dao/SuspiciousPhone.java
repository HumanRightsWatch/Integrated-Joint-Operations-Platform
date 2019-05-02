package com.fec.report.dao;

public class SuspiciousPhone {
    private Integer description;
    private Long id;
    private String id_card;
    private String other_description;
    private String phone;
    private Long radio_id;

    public SuspiciousPhone(Long id) {
        this.id = id;
    }

    public SuspiciousPhone(Long id, Long radio_id, String id_card, String phone, Integer description, String other_description) {
        this.id = id;
        this.radio_id = radio_id;
        this.id_card = id_card;
        this.phone = phone;
        this.description = description;
        this.other_description = other_description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRadio_id() {
        return this.radio_id;
    }

    public void setRadio_id(Long radio_id) {
        this.radio_id = radio_id;
    }

    public String getId_card() {
        return this.id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDescription() {
        return this.description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public String getOther_description() {
        return this.other_description;
    }

    public void setOther_description(String other_description) {
        this.other_description = other_description;
    }
}
