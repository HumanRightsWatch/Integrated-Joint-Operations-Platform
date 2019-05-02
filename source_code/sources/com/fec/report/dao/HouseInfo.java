package com.fec.report.dao;

public class HouseInfo {
    private Long building_id;
    private String electricity_meter;
    private String gas_meter;
    private Long id;
    private String num;
    private String service_id;
    private String water_meter;

    public HouseInfo(Long id) {
        this.id = id;
    }

    public HouseInfo(Long id, String service_id, Long building_id, String num, String electricity_meter, String water_meter, String gas_meter) {
        this.id = id;
        this.service_id = service_id;
        this.building_id = building_id;
        this.num = num;
        this.electricity_meter = electricity_meter;
        this.water_meter = water_meter;
        this.gas_meter = gas_meter;
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

    public Long getBuilding_id() {
        return this.building_id;
    }

    public void setBuilding_id(Long building_id) {
        this.building_id = building_id;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getElectricity_meter() {
        return this.electricity_meter;
    }

    public void setElectricity_meter(String electricity_meter) {
        this.electricity_meter = electricity_meter;
    }

    public String getWater_meter() {
        return this.water_meter;
    }

    public void setWater_meter(String water_meter) {
        this.water_meter = water_meter;
    }

    public String getGas_meter() {
        return this.gas_meter;
    }

    public void setGas_meter(String gas_meter) {
        this.gas_meter = gas_meter;
    }
}
