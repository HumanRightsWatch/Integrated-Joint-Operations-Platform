package com.fec.report.dao;

public class Comparison {
    private String action;
    private String card;
    private String facePhoto;
    private Long id;
    private String name;
    private Long personId;
    private String similarity;

    public Comparison(Long id) {
        this.id = id;
    }

    public Comparison(Long id, Long personId, String similarity, String facePhoto, String name, String card, String action) {
        this.id = id;
        this.personId = personId;
        this.similarity = similarity;
        this.facePhoto = facePhoto;
        this.name = name;
        this.card = card;
        this.action = action;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getSimilarity() {
        return this.similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }

    public String getFacePhoto() {
        return this.facePhoto;
    }

    public void setFacePhoto(String facePhoto) {
        this.facePhoto = facePhoto;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return this.card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
