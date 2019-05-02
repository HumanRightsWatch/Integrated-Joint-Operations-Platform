package com.fec.report.dao;

public class NineOneThreeResult {
    private Long id;
    private Integer is_need_polic;
    private String policeReason;
    private String service_id;
    private String warnResLatitude;
    private String warnResLongitude;

    public NineOneThreeResult(Long id) {
        this.id = id;
    }

    public NineOneThreeResult(Long id, String service_id, Integer is_need_polic, String policeReason, String warnResLatitude, String warnResLongitude) {
        this.id = id;
        this.service_id = service_id;
        this.is_need_polic = is_need_polic;
        this.policeReason = policeReason;
        this.warnResLatitude = warnResLatitude;
        this.warnResLongitude = warnResLongitude;
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

    public Integer getIs_need_polic() {
        return this.is_need_polic;
    }

    public void setIs_need_polic(Integer is_need_polic) {
        this.is_need_polic = is_need_polic;
    }

    public String getPoliceReason() {
        return this.policeReason;
    }

    public void setPoliceReason(String policeReason) {
        this.policeReason = policeReason;
    }

    public String getWarnResLatitude() {
        return this.warnResLatitude;
    }

    public void setWarnResLatitude(String warnResLatitude) {
        this.warnResLatitude = warnResLatitude;
    }

    public String getWarnResLongitude() {
        return this.warnResLongitude;
    }

    public void setWarnResLongitude(String warnResLongitude) {
        this.warnResLongitude = warnResLongitude;
    }
}
