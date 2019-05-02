package com.fec.report.dao;

public class BuildingInfo {
    private String address;
    private Long id;
    private Double latitude;
    private Double longitude;
    private Integer modify_type;
    private String photo;
    private String prefecture_id;
    private String prefecture_name;
    private Integer purpose;
    private String service_id;
    private String village_id;
    private String village_name;

    public BuildingInfo(Long id) {
        this.id = id;
    }

    public BuildingInfo(Long id, String service_id, String prefecture_id, String prefecture_name, String village_id, String village_name, String address, Integer purpose, String photo, Integer modify_type, Double longitude, Double latitude) {
        this.id = id;
        this.service_id = service_id;
        this.prefecture_id = prefecture_id;
        this.prefecture_name = prefecture_name;
        this.village_id = village_id;
        this.village_name = village_name;
        this.address = address;
        this.purpose = purpose;
        this.photo = photo;
        this.modify_type = modify_type;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService_id() {
        return this.service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getPrefecture_id() {
        return this.prefecture_id;
    }

    public void setPrefecture_id(String prefecture_id) {
        this.prefecture_id = prefecture_id;
    }

    public String getPrefecture_name() {
        return this.prefecture_name;
    }

    public void setPrefecture_name(String prefecture_name) {
        this.prefecture_name = prefecture_name;
    }

    public String getVillage_id() {
        return this.village_id;
    }

    public void setVillage_id(String village_id) {
        this.village_id = village_id;
    }

    public String getVillage_name() {
        return this.village_name;
    }

    public void setVillage_name(String village_name) {
        this.village_name = village_name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPurpose() {
        return this.purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getModify_type() {
        return this.modify_type;
    }

    public void setModify_type(Integer modify_type) {
        this.modify_type = modify_type;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
