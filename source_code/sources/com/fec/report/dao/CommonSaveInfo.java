package com.fec.report.dao;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CommonSaveInfo implements Parcelable {
    public static final Creator<CommonSaveInfo> CREATOR = new Creator<CommonSaveInfo>() {
        public CommonSaveInfo createFromParcel(Parcel source) {
            return new CommonSaveInfo(source);
        }

        public CommonSaveInfo[] newArray(int size) {
            return new CommonSaveInfo[size];
        }
    };
    private Long id;
    private String json;
    private String serviceID;
    private Integer status;
    private Integer type;
    private String ucID;
    private Integer version;
    private String warnID;

    public CommonSaveInfo(Long id) {
        this.id = id;
    }

    public CommonSaveInfo(Long id, String warnID, String ucID, Integer type, String serviceID, String json, Integer version, Integer status) {
        this.id = id;
        this.warnID = warnID;
        this.ucID = ucID;
        this.type = type;
        this.serviceID = serviceID;
        this.json = json;
        this.version = version;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarnID() {
        return this.warnID;
    }

    public void setWarnID(String warnID) {
        this.warnID = warnID;
    }

    public String getUcID() {
        return this.ucID;
    }

    public void setUcID(String ucID) {
        this.ucID = ucID;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getJson() {
        return this.json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.warnID);
        dest.writeString(this.ucID);
        dest.writeValue(this.type);
        dest.writeString(this.serviceID);
        dest.writeString(this.json);
        dest.writeValue(this.version);
        dest.writeValue(this.status);
    }

    protected CommonSaveInfo(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.warnID = in.readString();
        this.ucID = in.readString();
        this.type = (Integer) in.readValue(Integer.class.getClassLoader());
        this.serviceID = in.readString();
        this.json = in.readString();
        this.version = (Integer) in.readValue(Integer.class.getClassLoader());
        this.status = (Integer) in.readValue(Integer.class.getClassLoader());
    }
}
