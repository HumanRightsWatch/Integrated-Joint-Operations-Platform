package com.fec.report.dao;

public class VehicleReport {
    private String certificatePhotos;
    private String companyAddress;
    private String companyName;
    private String companyPhone;
    private String corporate;
    private String fkVr;
    private Long id;
    private String ownerIdCard;
    private String ownerName;
    private String ownerPhone;
    private String ownerPhotos;
    private Integer relationWithOwner;
    private String userPhotos;

    public VehicleReport(Long id) {
        this.id = id;
    }

    public VehicleReport(Long id, String fkVr, String userPhotos, Integer relationWithOwner, String ownerName, String ownerIdCard, String ownerPhone, String ownerPhotos, String companyName, String corporate, String companyPhone, String companyAddress, String certificatePhotos) {
        this.id = id;
        this.fkVr = fkVr;
        this.userPhotos = userPhotos;
        this.relationWithOwner = relationWithOwner;
        this.ownerName = ownerName;
        this.ownerIdCard = ownerIdCard;
        this.ownerPhone = ownerPhone;
        this.ownerPhotos = ownerPhotos;
        this.companyName = companyName;
        this.corporate = corporate;
        this.companyPhone = companyPhone;
        this.companyAddress = companyAddress;
        this.certificatePhotos = certificatePhotos;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFkVr() {
        return this.fkVr;
    }

    public void setFkVr(String fkVr) {
        this.fkVr = fkVr;
    }

    public String getUserPhotos() {
        return this.userPhotos;
    }

    public void setUserPhotos(String userPhotos) {
        this.userPhotos = userPhotos;
    }

    public Integer getRelationWithOwner() {
        return this.relationWithOwner;
    }

    public void setRelationWithOwner(Integer relationWithOwner) {
        this.relationWithOwner = relationWithOwner;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerIdCard() {
        return this.ownerIdCard;
    }

    public void setOwnerIdCard(String ownerIdCard) {
        this.ownerIdCard = ownerIdCard;
    }

    public String getOwnerPhone() {
        return this.ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerPhotos() {
        return this.ownerPhotos;
    }

    public void setOwnerPhotos(String ownerPhotos) {
        this.ownerPhotos = ownerPhotos;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCorporate() {
        return this.corporate;
    }

    public void setCorporate(String corporate) {
        this.corporate = corporate;
    }

    public String getCompanyPhone() {
        return this.companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyAddress() {
        return this.companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCertificatePhotos() {
        return this.certificatePhotos;
    }

    public void setCertificatePhotos(String certificatePhotos) {
        this.certificatePhotos = certificatePhotos;
    }
}
