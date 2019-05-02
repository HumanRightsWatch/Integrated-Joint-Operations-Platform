package com.fec.report.dao;

public class LocalPersonnelIdMismatchEntity {
    private String description;
    private String id;
    private Boolean isNewVisitor;
    private Long localID;
    private String track;
    private Integer type;

    public LocalPersonnelIdMismatchEntity(Long localID) {
        this.localID = localID;
    }

    public LocalPersonnelIdMismatchEntity(Long localID, String id, String description, Boolean isNewVisitor, Integer type, String track) {
        this.localID = localID;
        this.id = id;
        this.description = description;
        this.isNewVisitor = isNewVisitor;
        this.type = type;
        this.track = track;
    }

    public Long getLocalID() {
        return this.localID;
    }

    public void setLocalID(Long localID) {
        this.localID = localID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsNewVisitor() {
        return this.isNewVisitor;
    }

    public void setIsNewVisitor(Boolean isNewVisitor) {
        this.isNewVisitor = isNewVisitor;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTrack() {
        return this.track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}
