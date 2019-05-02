package com.fec.report.dao;

import java.util.List;
import org.greenrobot.greendao.DaoException;

public class NineOneThreePhone {
    private transient DaoSession daoSession;
    private Long id;
    private Integer is_support_phone;
    private transient NineOneThreePhoneDao myDao;
    private List<NineOneThreeOverseas> nineOneThreeOverseasList;
    private List<NineOneThreeSoftware> nineOneThreeSoftwareList;
    private String phone_code;
    private String service_id;
    private String use_soft_other_reason;
    private String use_soft_reason;

    public NineOneThreePhone(Long id) {
        this.id = id;
    }

    public NineOneThreePhone(Long id, String service_id, Integer is_support_phone, String phone_code, String use_soft_reason, String use_soft_other_reason) {
        this.id = id;
        this.service_id = service_id;
        this.is_support_phone = is_support_phone;
        this.phone_code = phone_code;
        this.use_soft_reason = use_soft_reason;
        this.use_soft_other_reason = use_soft_other_reason;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getNineOneThreePhoneDao() : null;
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

    public Integer getIs_support_phone() {
        return this.is_support_phone;
    }

    public void setIs_support_phone(Integer is_support_phone) {
        this.is_support_phone = is_support_phone;
    }

    public String getPhone_code() {
        return this.phone_code;
    }

    public void setPhone_code(String phone_code) {
        this.phone_code = phone_code;
    }

    public String getUse_soft_reason() {
        return this.use_soft_reason;
    }

    public void setUse_soft_reason(String use_soft_reason) {
        this.use_soft_reason = use_soft_reason;
    }

    public String getUse_soft_other_reason() {
        return this.use_soft_other_reason;
    }

    public void setUse_soft_other_reason(String use_soft_other_reason) {
        this.use_soft_other_reason = use_soft_other_reason;
    }

    public List<NineOneThreeSoftware> getNineOneThreeSoftwareList() {
        if (this.nineOneThreeSoftwareList == null) {
            __throwIfDetached();
            List<NineOneThreeSoftware> nineOneThreeSoftwareListNew = this.daoSession.getNineOneThreeSoftwareDao()._queryNineOneThreePhone_NineOneThreeSoftwareList(this.id);
            synchronized (this) {
                if (this.nineOneThreeSoftwareList == null) {
                    this.nineOneThreeSoftwareList = nineOneThreeSoftwareListNew;
                }
            }
        }
        return this.nineOneThreeSoftwareList;
    }

    public synchronized void resetNineOneThreeSoftwareList() {
        this.nineOneThreeSoftwareList = null;
    }

    public List<NineOneThreeOverseas> getNineOneThreeOverseasList() {
        if (this.nineOneThreeOverseasList == null) {
            __throwIfDetached();
            List<NineOneThreeOverseas> nineOneThreeOverseasListNew = this.daoSession.getNineOneThreeOverseasDao()._queryNineOneThreePhone_NineOneThreeOverseasList(this.id);
            synchronized (this) {
                if (this.nineOneThreeOverseasList == null) {
                    this.nineOneThreeOverseasList = nineOneThreeOverseasListNew;
                }
            }
        }
        return this.nineOneThreeOverseasList;
    }

    public synchronized void resetNineOneThreeOverseasList() {
        this.nineOneThreeOverseasList = null;
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
