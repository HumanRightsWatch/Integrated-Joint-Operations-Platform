package com.fec.report.dao;

public class RadioCarPeer {
    private Long id;
    private String id_card;
    private String name;
    private Boolean person_to_card;
    private String phone;
    private Long radio_id;

    public RadioCarPeer(Long id) {
        this.id = id;
    }

    public RadioCarPeer(Long id, Long radio_id, String name, String id_card, String phone, Boolean person_to_card) {
        this.id = id;
        this.radio_id = radio_id;
        this.name = name;
        this.id_card = id_card;
        this.phone = phone;
        this.person_to_card = person_to_card;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getPerson_to_card() {
        return this.person_to_card;
    }

    public void setPerson_to_card(Boolean person_to_card) {
        this.person_to_card = person_to_card;
    }
}
