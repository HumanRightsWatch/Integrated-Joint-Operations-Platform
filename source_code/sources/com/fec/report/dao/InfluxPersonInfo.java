package com.fec.report.dao;

import java.util.List;
import org.greenrobot.greendao.DaoException;

public class InfluxPersonInfo {
    private String addTime;
    private String addUser;
    private String addUserName;
    private String contactAddress;
    private Integer contactDetail;
    private String contactIDCard;
    private String contactMobile;
    private String contactName;
    private transient DaoSession daoSession;
    private String enterReason;
    private String enterTime;
    private String fkPoi;
    private List<InfluxPersonRelative> influxPersonRelativeList;
    private Double latitude;
    private String leaveTime;
    private Long localId;
    private String locationDescription;
    private Double longitude;
    private transient InfluxPersonInfoDao myDao;
    private String noContactReason;
    private Integer policeCheck;
    private String submitScenePicture;
    private String suspecDescription;
    private String temStayAddress;
    private Integer tripMode;

    public InfluxPersonInfo(Long localId) {
        this.localId = localId;
    }

    public InfluxPersonInfo(Long localId, String fkPoi, String enterTime, Integer tripMode, String leaveTime, String enterReason, Integer contactDetail, String noContactReason, String temStayAddress, String contactName, String contactIDCard, String contactMobile, String contactAddress, String suspecDescription, Integer policeCheck, String submitScenePicture, String addUser, String addUserName, String addTime, Double latitude, Double longitude, String locationDescription) {
        this.localId = localId;
        this.fkPoi = fkPoi;
        this.enterTime = enterTime;
        this.tripMode = tripMode;
        this.leaveTime = leaveTime;
        this.enterReason = enterReason;
        this.contactDetail = contactDetail;
        this.noContactReason = noContactReason;
        this.temStayAddress = temStayAddress;
        this.contactName = contactName;
        this.contactIDCard = contactIDCard;
        this.contactMobile = contactMobile;
        this.contactAddress = contactAddress;
        this.suspecDescription = suspecDescription;
        this.policeCheck = policeCheck;
        this.submitScenePicture = submitScenePicture;
        this.addUser = addUser;
        this.addUserName = addUserName;
        this.addTime = addTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationDescription = locationDescription;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getInfluxPersonInfoDao() : null;
    }

    public Long getLocalId() {
        return this.localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getFkPoi() {
        return this.fkPoi;
    }

    public void setFkPoi(String fkPoi) {
        this.fkPoi = fkPoi;
    }

    public String getEnterTime() {
        return this.enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public Integer getTripMode() {
        return this.tripMode;
    }

    public void setTripMode(Integer tripMode) {
        this.tripMode = tripMode;
    }

    public String getLeaveTime() {
        return this.leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getEnterReason() {
        return this.enterReason;
    }

    public void setEnterReason(String enterReason) {
        this.enterReason = enterReason;
    }

    public Integer getContactDetail() {
        return this.contactDetail;
    }

    public void setContactDetail(Integer contactDetail) {
        this.contactDetail = contactDetail;
    }

    public String getNoContactReason() {
        return this.noContactReason;
    }

    public void setNoContactReason(String noContactReason) {
        this.noContactReason = noContactReason;
    }

    public String getTemStayAddress() {
        return this.temStayAddress;
    }

    public void setTemStayAddress(String temStayAddress) {
        this.temStayAddress = temStayAddress;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactIDCard() {
        return this.contactIDCard;
    }

    public void setContactIDCard(String contactIDCard) {
        this.contactIDCard = contactIDCard;
    }

    public String getContactMobile() {
        return this.contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public String getContactAddress() {
        return this.contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getSuspecDescription() {
        return this.suspecDescription;
    }

    public void setSuspecDescription(String suspecDescription) {
        this.suspecDescription = suspecDescription;
    }

    public Integer getPoliceCheck() {
        return this.policeCheck;
    }

    public void setPoliceCheck(Integer policeCheck) {
        this.policeCheck = policeCheck;
    }

    public String getSubmitScenePicture() {
        return this.submitScenePicture;
    }

    public void setSubmitScenePicture(String submitScenePicture) {
        this.submitScenePicture = submitScenePicture;
    }

    public String getAddUser() {
        return this.addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public String getAddUserName() {
        return this.addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public String getAddTime() {
        return this.addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLocationDescription() {
        return this.locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public List<InfluxPersonRelative> getInfluxPersonRelativeList() {
        if (this.influxPersonRelativeList == null) {
            __throwIfDetached();
            List<InfluxPersonRelative> influxPersonRelativeListNew = this.daoSession.getInfluxPersonRelativeDao()._queryInfluxPersonInfo_InfluxPersonRelativeList(this.localId);
            synchronized (this) {
                if (this.influxPersonRelativeList == null) {
                    this.influxPersonRelativeList = influxPersonRelativeListNew;
                }
            }
        }
        return this.influxPersonRelativeList;
    }

    public synchronized void resetInfluxPersonRelativeList() {
        this.influxPersonRelativeList = null;
    }

    public void delete() {
        __throwIfDetached();
        this.myDao.delete(this);
    }

    public void update() {
        __throwIfDetached();
        this.myDao.update(this);
    }

    public void refresh() {
        __throwIfDetached();
        this.myDao.refresh(this);
    }

    private void __throwIfDetached() {
        if (this.myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }
}
