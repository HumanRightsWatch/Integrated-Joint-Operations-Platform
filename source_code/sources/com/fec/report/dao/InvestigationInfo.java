package com.fec.report.dao;

import java.util.List;
import org.greenrobot.greendao.DaoException;

public class InvestigationInfo {
    private String address;
    private transient DaoSession daoSession;
    private String description;
    private String fkIi;
    private String id;
    private String idCard;
    private String infoType;
    private List<InvestigateBankCard> investigateBankCardList;
    private List<InvestigateFamily> investigateFamilyList;
    private List<InvestigateSoft> investigateSoftList;
    private List<InvestigateVehicle> investigateVehicleList;
    private Integer isPushed;
    private String latitude;
    private Long local_id;
    private String longitude;
    private transient InvestigationInfoDao myDao;
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

    public InvestigationInfo(Long local_id) {
        this.local_id = local_id;
    }

    public InvestigationInfo(Long local_id, String id, String fkIi, String infoType, String description, String name, String idCard, String phone, String passport, String work, String workUnit, String address, String photo, String response, Integer policeCheck, Integer isPushed, String note, String policeReason, String latitude, String longitude) {
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
        this.myDao = daoSession != null ? daoSession.getInvestigationInfoDao() : null;
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

    public List<InvestigateVehicle> getInvestigateVehicleList() {
        if (this.investigateVehicleList == null) {
            __throwIfDetached();
            List<InvestigateVehicle> investigateVehicleListNew = this.daoSession.getInvestigateVehicleDao()._queryInvestigationInfo_InvestigateVehicleList(this.local_id);
            synchronized (this) {
                if (this.investigateVehicleList == null) {
                    this.investigateVehicleList = investigateVehicleListNew;
                }
            }
        }
        return this.investigateVehicleList;
    }

    public synchronized void resetInvestigateVehicleList() {
        this.investigateVehicleList = null;
    }

    public List<InvestigateBankCard> getInvestigateBankCardList() {
        if (this.investigateBankCardList == null) {
            __throwIfDetached();
            List<InvestigateBankCard> investigateBankCardListNew = this.daoSession.getInvestigateBankCardDao()._queryInvestigationInfo_InvestigateBankCardList(this.local_id);
            synchronized (this) {
                if (this.investigateBankCardList == null) {
                    this.investigateBankCardList = investigateBankCardListNew;
                }
            }
        }
        return this.investigateBankCardList;
    }

    public synchronized void resetInvestigateBankCardList() {
        this.investigateBankCardList = null;
    }

    public List<InvestigateFamily> getInvestigateFamilyList() {
        if (this.investigateFamilyList == null) {
            __throwIfDetached();
            List<InvestigateFamily> investigateFamilyListNew = this.daoSession.getInvestigateFamilyDao()._queryInvestigationInfo_InvestigateFamilyList(this.local_id);
            synchronized (this) {
                if (this.investigateFamilyList == null) {
                    this.investigateFamilyList = investigateFamilyListNew;
                }
            }
        }
        return this.investigateFamilyList;
    }

    public synchronized void resetInvestigateFamilyList() {
        this.investigateFamilyList = null;
    }

    public List<InvestigateSoft> getInvestigateSoftList() {
        if (this.investigateSoftList == null) {
            __throwIfDetached();
            List<InvestigateSoft> investigateSoftListNew = this.daoSession.getInvestigateSoftDao()._queryInvestigationInfo_InvestigateSoftList(this.local_id);
            synchronized (this) {
                if (this.investigateSoftList == null) {
                    this.investigateSoftList = investigateSoftListNew;
                }
            }
        }
        return this.investigateSoftList;
    }

    public synchronized void resetInvestigateSoftList() {
        this.investigateSoftList = null;
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
