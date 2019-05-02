package com.fec.report.dao;

public class ThingTotalEntity {
    private String content;
    private Long id;
    private Integer isSend;
    private String name;
    private String picture;
    private String submitUCId;
    private String time;
    private Integer type;

    public ThingTotalEntity(Long id) {
        this.id = id;
    }

    public ThingTotalEntity(Long id, Integer type, String picture, String time, String content, String name, Integer isSend, String submitUCId) {
        this.id = id;
        this.type = type;
        this.picture = picture;
        this.time = time;
        this.content = content;
        this.name = name;
        this.isSend = isSend;
        this.submitUCId = submitUCId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsSend() {
        return this.isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public String getSubmitUCId() {
        return this.submitUCId;
    }

    public void setSubmitUCId(String submitUCId) {
        this.submitUCId = submitUCId;
    }
}
