package com.fec.report.dao;

import java.util.List;
import org.greenrobot.greendao.DaoException;

public class ManualInfo {
    private String address;
    private transient DaoSession daoSession;
    private String description;
    private String fkIi;
    private String id;
    private String idCard;
    private String infoType;
    private Integer isPushed;
    private String latitude;
    private Long local_id;
    private String longitude;
    private List<ManualBankCard> manualBankCardList;
    private List<ManualFamily> manualFamilyList;
    private List<ManualVehicle> manualVehicleList;
    private List<ManualteSoft> manualteSoftList;
    private transient ManualInfoDao myDao;
    private String name;
    private String note;
    private String passport;
    private String phone;
    private String photo;
    private Integer policeCheck;
    private String policeReason;
    private String response;
    private String work;
    private String workUnit;

    public ManualInfo(Long local_id) {
        this.local_id = local_id;
    }

    public ManualInfo(Long local_id, String id, String fkIi, String infoType, String description, String name, String idCard, String phone, String passport, String work, String workUnit, String address, String photo, String response, Integer policeCheck, Integer isPushed, String note, String policeReason, String latitude, String longitude) {
        this.local_id = local_id;
        this.id = id;
        this.fkIi = fkIi;
        this.infoType = infoType;
        this.description = description;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.passport = passport;
        this.work = work;
        this.workUnit = workUnit;
        this.address = address;
        this.photo = photo;
        this.response = response;
        this.policeCheck = policeCheck;
        this.isPushed = isPushed;
        this.note = note;
        this.policeReason = policeReason;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getManualInfoDao() : null;
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

    public String getFkIi() {
        return this.fkIi;
    }

    public void setFkIi(String fkIi) {
        this.fkIi = fkIi;
    }

    public String getInfoType() {
        return this.infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getWork() {
        return this.work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getWorkUnit() {
        return this.workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getPoliceCheck() {
        return this.policeCheck;
    }

    public void setPoliceCheck(Integer policeCheck) {
        this.policeCheck = policeCheck;
    }

    public Integer getIsPushed() {
        return this.isPushed;
    }

    public void setIsPushed(Integer isPushed) {
        this.isPushed = isPushed;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPoliceReason() {
        return this.policeReason;
    }

    public void setPoliceReason(String policeReason) {
        this.policeReason = policeReason;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<ManualVehicle> getManualVehicleList() {
        if (this.manualVehicleList == null) {
            __throwIfDetached();
            List<ManualVehicle> manualVehicleListNew = this.daoSession.getManualVehicleDao()._queryManualInfo_ManualVehicleList(this.local_id);
            synchronized (this) {
                if (this.manualVehicleList == null) {
                    this.manualVehicleList = manualVehicleListNew;
                }
            }
        }
        return this.manualVehicleList;
    }

    public synchronized void resetManualVehicleList() {
        this.manualVehicleList = null;
    }

    public List<ManualBankCard> getManualBankCardList() {
        if (this.manualBankCardList == null) {
            __throwIfDetached();
            List<ManualBankCard> manualBankCardListNew = this.daoSession.getManualBankCardDao()._queryManualInfo_ManualBankCardList(this.local_id);
            synchronized (this) {
                if (this.manualBankCardList == null) {
                    this.manualBankCardList = manualBankCardListNew;
                }
            }
        }
        return this.manualBankCardList;
    }

    public synchronized void resetManualBankCardList() {
        this.manualBankCardList = null;
    }

    public List<ManualFamily> getManualFamilyList() {
        if (this.manualFamilyList == null) {
            __throwIfDetached();
            List<ManualFamily> manualFamilyListNew = this.daoSession.getManualFamilyDao()._queryManualInfo_ManualFamilyList(this.local_id);
            synchronized (this) {
                if (this.manualFamilyList == null) {
                    this.manualFamilyList = manualFamilyListNew;
                }
            }
        }
        return this.manualFamilyList;
    }

    public synchronized void resetManualFamilyList() {
        this.manualFamilyList = null;
    }

    public List<ManualteSoft> getManualteSoftList() {
        if (this.manualteSoftList == null) {
            __throwIfDetached();
            List<ManualteSoft> manualteSoftListNew = this.daoSession.getManualteSoftDao()._queryManualInfo_ManualteSoftList(this.local_id);
            synchronized (this) {
                if (this.manualteSoftList == null) {
                    this.manualteSoftList = manualteSoftListNew;
                }
            }
        }
        return this.manualteSoftList;
    }

    public synchronized void resetManualteSoftList() {
        this.manualteSoftList = null;
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
