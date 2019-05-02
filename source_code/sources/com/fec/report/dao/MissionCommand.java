package com.fec.report.dao;

public class MissionCommand {
    private String addTime;
    private String addUserName;
    private String addUserOrgId;
    private String addUserUcid;
    private String content;
    private String family;
    private String finishTime;
    private String id;
    private String other;
    private String photo;
    private Integer state;
    private String submitTime;
    private Integer type;
    private Integer urgency;

    public MissionCommand(String id) {
        this.id = id;
    }

    public MissionCommand(String id, Integer type, String content, Integer urgency, String addTime, String finishTime, String addUserUcid, String addUserName, String addUserOrgId, Integer state, String submitTime, String family, String photo, String other) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.urgency = urgency;
        this.addTime = addTime;
        this.finishTime = finishTime;
        this.addUserUcid = addUserUcid;
        this.addUserName = addUserName;
        this.addUserOrgId = addUserOrgId;
        this.state = state;
        this.submitTime = submitTime;
        this.family = family;
        this.photo = photo;
        this.other = other;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUrgency() {
        return this.urgency;
    }

    public void setUrgency(Integer urgency) {
        this.urgency = urgency;
    }

    public String getAddTime() {
        return this.addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getFinishTime() {
        return this.finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getAddUserUcid() {
        return this.addUserUcid;
    }

    public void setAddUserUcid(String addUserUcid) {
        this.addUserUcid = addUserUcid;
    }

    public String getAddUserName() {
        return this.addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public String getAddUserOrgId() {
        return this.addUserOrgId;
    }

    public void setAddUserOrgId(String addUserOrgId) {
        this.addUserOrgId = addUserOrgId;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSubmitTime() {
        return this.submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getFamily() {
        return this.family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getOther() {
        return this.other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
