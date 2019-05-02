package com.fec.report.dao;

public class DeliveryControl {
    private String afterOpenPhoto;
    private String beforeOpenPhoto;
    private String companyAddress;
    private String companyName;
    private Long id;
    private String packageNumber;
    private Integer packageType;
    private String receiveCard;
    private String receiveName;
    private String receivePhone;
    private String receivePhoto;
    private Integer selfReceive;
    private String signDate;
    private String signTime;
    private Long totalID;
    private String xRayPhoto;

    public DeliveryControl(Long id) {
        this.id = id;
    }

    public DeliveryControl(Long id, Long totalID, String companyName, String companyAddress, Integer selfReceive, String receiveName, String receiveCard, String receivePhone, String packageNumber, Integer packageType, String signDate, String signTime, String receivePhoto, String xRayPhoto, String beforeOpenPhoto, String afterOpenPhoto) {
        this.id = id;
        this.totalID = totalID;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.selfReceive = selfReceive;
        this.receiveName = receiveName;
        this.receiveCard = receiveCard;
        this.receivePhone = receivePhone;
        this.packageNumber = packageNumber;
        this.packageType = packageType;
        this.signDate = signDate;
        this.signTime = signTime;
        this.receivePhoto = receivePhoto;
        this.xRayPhoto = xRayPhoto;
        this.beforeOpenPhoto = beforeOpenPhoto;
        this.afterOpenPhoto = afterOpenPhoto;
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

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return this.companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Integer getSelfReceive() {
        return this.selfReceive;
    }

    public void setSelfReceive(Integer selfReceive) {
        this.selfReceive = selfReceive;
    }

    public String getReceiveName() {
        return this.receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveCard() {
        return this.receiveCard;
    }

    public void setReceiveCard(String receiveCard) {
        this.receiveCard = receiveCard;
    }

    public String getReceivePhone() {
        return this.receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getPackageNumber() {
        return this.packageNumber;
    }

    public void setPackageNumber(String packageNumber) {
        this.packageNumber = packageNumber;
    }

    public Integer getPackageType() {
        return this.packageType;
    }

    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }

    public String getSignDate() {
        return this.signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getSignTime() {
        return this.signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getReceivePhoto() {
        return this.receivePhoto;
    }

    public void setReceivePhoto(String receivePhoto) {
        this.receivePhoto = receivePhoto;
    }

    public String getXRayPhoto() {
        return this.xRayPhoto;
    }

    public void setXRayPhoto(String xRayPhoto) {
        this.xRayPhoto = xRayPhoto;
    }

    public String getBeforeOpenPhoto() {
        return this.beforeOpenPhoto;
    }

    public void setBeforeOpenPhoto(String beforeOpenPhoto) {
        this.beforeOpenPhoto = beforeOpenPhoto;
    }

    public String getAfterOpenPhoto() {
        return this.afterOpenPhoto;
    }

    public void setAfterOpenPhoto(String afterOpenPhoto) {
        this.afterOpenPhoto = afterOpenPhoto;
    }
}
