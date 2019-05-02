package com.fec.report.dao;

public class Notice {
    private String add_time;
    private String add_user;
    private String announcement_content;
    private String announcement_name;
    private Long id;
    private Boolean is_read;
    private String owner_id;
    private String service_id;

    public Notice(Long id) {
        this.id = id;
    }

    public Notice(Long id, String service_id, String announcement_name, String announcement_content, String add_time, String add_user, Boolean is_read, String owner_id) {
        this.id = id;
        this.service_id = service_id;
        this.announcement_name = announcement_name;
        this.announcement_content = announcement_content;
        this.add_time = add_time;
        this.add_user = add_user;
        this.is_read = is_read;
        this.owner_id = owner_id;
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

    public String getAnnouncement_name() {
        return this.announcement_name;
    }

    public void setAnnouncement_name(String announcement_name) {
        this.announcement_name = announcement_name;
    }

    public String getAnnouncement_content() {
        return this.announcement_content;
    }

    public void setAnnouncement_content(String announcement_content) {
        this.announcement_content = announcement_content;
    }

    public String getAdd_time() {
        return this.add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getAdd_user() {
        return this.add_user;
    }

    public void setAdd_user(String add_user) {
        this.add_user = add_user;
    }

    public Boolean getIs_read() {
        return this.is_read;
    }

    public void setIs_read(Boolean is_read) {
        this.is_read = is_read;
    }

    public String getOwner_id() {
        return this.owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }
}
