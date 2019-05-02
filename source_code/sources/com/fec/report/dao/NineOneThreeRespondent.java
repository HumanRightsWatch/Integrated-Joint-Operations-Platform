package com.fec.report.dao;

import java.util.List;
import org.greenrobot.greendao.DaoException;

public class NineOneThreeRespondent {
    private String activity;
    private transient DaoSession daoSession;
    private String domicile;
    private Long id;
    private transient NineOneThreeRespondentDao myDao;
    private String name;
    private NineOneThreePhone nineOneThreePhone;
    private transient Long nineOneThreePhone__resolvedKey;
    private NineOneThreeResult nineOneThreeResult;
    private transient Long nineOneThreeResult__resolvedKey;
    private List<NineOneThreeVisitor> nineOneThreeVisitorList;
    private String phone;
    private String phone_code;
    private Long phone_id;
    private String pin_code;
    private Long result_id;
    private String service_id;

    public NineOneThreeRespondent(Long id) {
        this.id = id;
    }

    public NineOneThreeRespondent(Long id, String service_id, String name, String pin_code, String phone, String domicile, String activity, String phone_code, Long phone_id, Long result_id) {
        this.id = id;
        this.service_id = service_id;
        this.name = name;
        this.pin_code = pin_code;
        this.phone = phone;
        this.domicile = domicile;
        this.activity = activity;
        this.phone_code = phone_code;
        this.phone_id = phone_id;
        this.result_id = result_id;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getNineOneThreeRespondentDao() : null;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin_code() {
        return this.pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDomicile() {
        return this.domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getActivity() {
        return this.activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPhone_code() {
        return this.phone_code;
    }

    public void setPhone_code(String phone_code) {
        this.phone_code = phone_code;
    }

    public Long getPhone_id() {
        return this.phone_id;
    }

    public void setPhone_id(Long phone_id) {
        this.phone_id = phone_id;
    }

    public Long getResult_id() {
        return this.result_id;
    }

    public void setResult_id(Long result_id) {
        this.result_id = result_id;
    }

    public NineOneThreePhone getNineOneThreePhone() {
        Long __key = this.phone_id;
        if (this.nineOneThreePhone__resolvedKey == null || !this.nineOneThreePhone__resolvedKey.equals(__key)) {
            __throwIfDetached();
            NineOneThreePhone nineOneThreePhoneNew = (NineOneThreePhone) this.daoSession.getNineOneThreePhoneDao().load(__key);
            synchronized (this) {
                this.nineOneThreePhone = nineOneThreePhoneNew;
                this.nineOneThreePhone__resolvedKey = __key;
            }
        }
        return this.nineOneThreePhone;
    }

    public void setNineOneThreePhone(NineOneThreePhone nineOneThreePhone) {
        synchronized (this) {
            this.nineOneThreePhone = nineOneThreePhone;
            this.phone_id = nineOneThreePhone == null ? null : nineOneThreePhone.getId();
            this.nineOneThreePhone__resolvedKey = this.phone_id;
        }
    }

    public NineOneThreeResult getNineOneThreeResult() {
        Long __key = this.result_id;
        if (this.nineOneThreeResult__resolvedKey == null || !this.nineOneThreeResult__resolvedKey.equals(__key)) {
            __throwIfDetached();
            NineOneThreeResult nineOneThreeResultNew = (NineOneThreeResult) this.daoSession.getNineOneThreeResultDao().load(__key);
            synchronized (this) {
                this.nineOneThreeResult = nineOneThreeResultNew;
                this.nineOneThreeResult__resolvedKey = __key;
            }
        }
        return this.nineOneThreeResult;
    }

    public void setNineOneThreeResult(NineOneThreeResult nineOneThreeResult) {
        synchronized (this) {
            this.nineOneThreeResult = nineOneThreeResult;
            this.result_id = nineOneThreeResult == null ? null : nineOneThreeResult.getId();
            this.nineOneThreeResult__resolvedKey = this.result_id;
        }
    }

    public List<NineOneThreeVisitor> getNineOneThreeVisitorList() {
        if (this.nineOneThreeVisitorList == null) {
            __throwIfDetached();
            List<NineOneThreeVisitor> nineOneThreeVisitorListNew = this.daoSession.getNineOneThreeVisitorDao()._queryNineOneThreeRespondent_NineOneThreeVisitorList(this.id);
            synchronized (this) {
                if (this.nineOneThreeVisitorList == null) {
                    this.nineOneThreeVisitorList = nineOneThreeVisitorListNew;
                }
            }
        }
        return this.nineOneThreeVisitorList;
    }

    public synchronized void resetNineOneThreeVisitorList() {
        this.nineOneThreeVisitorList = null;
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
