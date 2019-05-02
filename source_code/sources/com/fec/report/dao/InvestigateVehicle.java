package com.fec.report.dao;

public class InvestigateVehicle {
    private String id;
    private Long local_fkIr;
    private Long local_id;
    private String note;
    private String photo;
    private String plateNumber;
    private Integer vehicleColor;
    private Integer vehicleType;

    public InvestigateVehicle(Long local_id) {
        this.local_id = local_id;
    }

    public InvestigateVehicle(Long local_id, String id, Long local_fkIr, String plateNumber, String photo, Integer vehicleColor, Integer vehicleType, String note) {
        this.local_id = local_id;
        this.id = id;
        this.local_fkIr = local_fkIr;
        this.plateNumber = plateNumber;
        this.photo = photo;
        this.vehicleColor = vehicleColor;
        this.vehicleType = vehicleType;
        this.note = note;
    }

    public Long getLocal_id() {
        return this.local_id;
    }

    public void setLocal_id(Long local_id) {
        this.local_id = local_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLocal_fkIr() {
        return this.local_fkIr;
    }

    public void setLocal_fkIr(Long local_fkIr) {
        this.local_fkIr = local_fkIr;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getVehicleColor() {
        return this.vehicleColor;
    }

    public void setVehicleColor(Integer vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public Integer getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(Integer vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
