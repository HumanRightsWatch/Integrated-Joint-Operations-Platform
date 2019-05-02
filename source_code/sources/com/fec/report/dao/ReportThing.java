package com.fec.report.dao;

public class ReportThing {
    private String address;
    private String content;
    private Long id;
    private String identity;
    private String note;
    private String objectIdentifier;
    private String objectName;
    private String picture;
    private String submitLatitude;
    private String submitLongitude;
    private Long totalID;
    private String voice;

    public ReportThing(Long id) {
        this.id = id;
    }

    public ReportThing(Long id, Long totalID, String identity, String content, String address, String submitLatitude, String submitLongitude, String voice, String picture, String note, String objectName, String objectIdentifier) {
        this.id = id;
        this.totalID = totalID;
        this.identity = identity;
        this.content = content;
        this.address = address;
        this.submitLatitude = submitLatitude;
        this.submitLongitude = submitLongitude;
        this.voice = voice;
        this.picture = picture;
        this.note = note;
        this.objectName = objectName;
        this.objectIdentifier = objectIdentifier;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalID() {
        return this.totalID;
    }

    public void setTotalID(Long totalID) {
        this.totalID = totalID;
    }

    public String getIdentity() {
        return this.identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubmitLatitude() {
        return this.submitLatitude;
    }

    public void setSubmitLatitude(String submitLatitude) {
        this.submitLatitude = submitLatitude;
    }

    public String getSubmitLongitude() {
        return this.submitLongitude;
    }

    public void setSubmitLongitude(String submitLongitude) {
        this.submitLongitude = submitLongitude;
    }

    public String getVoice() {
        return this.voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public void setObjectIdentifier(String objectIdentifier) {
        this.objectIdentifier = objectIdentifier;
    }
}
