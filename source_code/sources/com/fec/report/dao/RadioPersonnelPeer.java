package com.fec.report.dao;

public class RadioPersonnelPeer {
    private Long id;
    private String id_card;
    private String name;
    private String phone;
    private String phone2;
    private Long radio_id;

    public RadioPersonnelPeer(Long id) {
        this.id = id;
    }

    public RadioPersonnelPeer(Long id, Long radio_id, String name, String id_card, String phone, String phone2) {
        this.id = id;
        this.radio_id = radio_id;
        this.name = name;
        this.id_card = id_card;
        this.phone = phone;
        this.phone2 = phone2;
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

    public String getPhone2() {
        return this.phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
}
