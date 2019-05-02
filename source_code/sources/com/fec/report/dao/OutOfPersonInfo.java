package com.fec.report.dao;

import java.util.List;
import org.greenrobot.greendao.DaoException;

public class OutOfPersonInfo {
    private String address;
    private String aimCity;
    private String aimDetail;
    private transient DaoSession daoSession;
    private String fkPod;
    private String flowPhone;
    private String idCard;
    private String infoType;
    private Double latitude;
    private String leaveReason;
    private String leaveTime;
    private Long localId;
    private String locationDescription;
    private Double longitude;
    private String mobilePhone;
    private transient OutOfPersonInfoDao myDao;
    private String name;
    private String noTouchReason;
    private String otherTripMode;
    private List<OutOfPersonPeer> outOfPersonPeerList;
    private List<OutOfPersonRelative> outOfPersonRelativeList;
    private String photo;
    private String policeCheck;
    private String returnTime;
    private String suspecDescription;
    private Integer touchType;
    private Integer tripMode;

    public OutOfPersonInfo(Long localId) {
        this.localId = localId;
    }

    public OutOfPersonInfo(Long localId, String infoType, String fkPod, Integer touchType, String noTouchReason, String name, String idCard, String mobilePhone, String address, String leaveTime, Integer tripMode, String otherTripMode, String aimCity, String aimDetail, String returnTime, String leaveReason, String suspecDescription, String policeCheck, Double latitude, Double longitude, String locationDescription, String photo, String flowPhone) {
        this.localId = localId;
        this.infoType = infoType;
        this.fkPod = fkPod;
        this.touchType = touchType;
        this.noTouchReason = noTouchReason;
        this.name = name;
        this.idCard = idCard;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.leaveTime = leaveTime;
        this.tripMode = tripMode;
        this.otherTripMode = otherTripMode;
        this.aimCity = aimCity;
        this.aimDetail = aimDetail;
        this.returnTime = returnTime;
        this.leaveReason = leaveReason;
        this.suspecDescription = suspecDescription;
        this.policeCheck = policeCheck;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationDescription = locationDescription;
        this.photo = photo;
        this.flowPhone = flowPhone;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getOutOfPersonInfoDao() : null;
    }

    public Long getLocalId() {
        return this.localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getInfoType() {
        return this.infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getFkPod() {
        return this.fkPod;
    }

    public void setFkPod(String fkPod) {
        this.fkPod = fkPod;
    }

    public Integer getTouchType() {
        return this.touchType;
    }

    public void setTouchType(Integer touchType) {
        this.touchType = touchType;
    }

    public String getNoTouchReason() {
        return this.noTouchReason;
    }

    public void setNoTouchReason(String noTouchReason) {
        this.noTouchReason = noTouchReason;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLeaveTime() {
        return this.leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Integer getTripMode() {
        return this.tripMode;
    }

    public void setTripMode(Integer tripMode) {
        this.tripMode = tripMode;
    }

    public String getOtherTripMode() {
        return this.otherTripMode;
    }

    public void setOtherTripMode(String otherTripMode) {
        this.otherTripMode = otherTripMode;
    }

    public String getAimCity() {
        return this.aimCity;
    }

    public void setAimCity(String aimCity) {
        this.aimCity = aimCity;
    }

    public String getAimDetail() {
        return this.aimDetail;
    }

    public void setAimDetail(String aimDetail) {
        this.aimDetail = aimDetail;
    }

    public String getReturnTime() {
        return this.returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getLeaveReason() {
        return this.leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getSuspecDescription() {
        return this.suspecDescription;
    }

    public void setSuspecDescription(String suspecDescription) {
        this.suspecDescription = suspecDescription;
    }

    public String getPoliceCheck() {
        return this.policeCheck;
    }

    public void setPoliceCheck(String policeCheck) {
        this.policeCheck = policeCheck;
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

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFlowPhone() {
        return this.flowPhone;
    }

    public void setFlowPhone(String flowPhone) {
        this.flowPhone = flowPhone;
    }

    public List<OutOfPersonRelative> getOutOfPersonRelativeList() {
        if (this.outOfPersonRelativeList == null) {
            __throwIfDetached();
            List<OutOfPersonRelative> outOfPersonRelativeListNew = this.daoSession.getOutOfPersonRelativeDao()._queryOutOfPersonInfo_OutOfPersonRelativeList(this.localId);
            synchronized (this) {
                if (this.outOfPersonRelativeList == null) {
                    this.outOfPersonRelativeList = outOfPersonRelativeListNew;
                }
            }
        }
        return this.outOfPersonRelativeList;
    }

    public synchronized void resetOutOfPersonRelativeList() {
        this.outOfPersonRelativeList = null;
    }

    public List<OutOfPersonPeer> getOutOfPersonPeerList() {
        if (this.outOfPersonPeerList == null) {
            __throwIfDetached();
            List<OutOfPersonPeer> outOfPersonPeerListNew = this.daoSession.getOutOfPersonPeerDao()._queryOutOfPersonInfo_OutOfPersonPeerList(this.localId);
            synchronized (this) {
                if (this.outOfPersonPeerList == null) {
                    this.outOfPersonPeerList = outOfPersonPeerListNew;
                }
            }
        }
        return this.outOfPersonPeerList;
    }

    public synchronized void resetOutOfPersonPeerList() {
        this.outOfPersonPeerList = null;
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
