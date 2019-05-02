package com.fec.report.dao;

public class NineOneThreeVisitor {
    private String domicile;
    private Integer gender;
    private Long id;
    private Integer is_push;
    private String name;
    private String phone;
    private String photo;
    private String pin_code;
    private String reason;
    private String rel_info;
    private Integer relation;
    private String service_id;
    private Long task_id;

    public NineOneThreeVisitor(Long id) {
        this.id = id;
    }

    public NineOneThreeVisitor(Long id, String service_id, Long task_id, String name, String domicile, String phone, Integer relation, String pin_code, String photo, String rel_info, String reason, Integer is_push, Integer gender) {
        this.id = id;
        this.service_id = service_id;
        this.task_id = task_id;
        this.name = name;
        this.domicile = domicile;
        this.phone = phone;
        this.relation = relation;
        this.pin_code = pin_code;
        this.photo = photo;
        this.rel_info = rel_info;
        this.reason = reason;
        this.is_push = is_push;
        this.gender = gender;
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

    public Long getTask_id() {
        return this.task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomicile() {
        return this.domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRelation() {
        return this.relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public String getPin_code() {
        return this.pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRel_info() {
        return this.rel_info;
    }

    public void setRel_info(String rel_info) {
        this.rel_info = rel_info;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getIs_push() {
        return this.is_push;
    }

    public void setIs_push(Integer is_push) {
        this.is_push = is_push;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
