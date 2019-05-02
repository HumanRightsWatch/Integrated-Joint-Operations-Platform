package com.fec.report.dao;

public class LocalPersonnelCarMismatchEntity {
    private String description;
    private String id;
    private Boolean isNewVisitor;
    private Long localID;

    public LocalPersonnelCarMismatchEntity(Long localID) {
        this.localID = localID;
    }

    public LocalPersonnelCarMismatchEntity(Long localID, String id, String description, Boolean isNewVisitor) {
        this.localID = localID;
        this.id = id;
        this.description = description;
        this.isNewVisitor = isNewVisitor;
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
}
