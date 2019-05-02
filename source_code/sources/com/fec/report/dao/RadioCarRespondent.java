package com.fec.report.dao;

import java.util.List;
import org.greenrobot.greendao.DaoException;

public class RadioCarRespondent {
    private String check_name;
    private String check_photo;
    private Integer check_relation_to_driver;
    private Integer checkedReason;
    private String contraband_photo;
    private transient DaoSession daoSession;
    private String driver_id_number;
    private String driver_phone;
    private Long id;
    private Integer isNeedSecondcheck;
    private transient RadioCarRespondentDao myDao;
    private String noNeedCheckedReason;
    private String other_reason;
    private Boolean person_to_card;
    private Integer problem_type;
    private String push_owner_id_number;
    private String push_owner_name;
    private String push_photo;
    private String push_plate_number;
    private List<RadioCarPeer> radioCarPeerList;
    private Integer reason_for_differ;
    private List<SuspiciousPhone> suspiciousPhoneList;
    private String task_id;
    private String vehicleOrgName;
    private Integer vehicleProperty;
    private Boolean whether_contraband;

    public RadioCarRespondent(Long id) {
        this.id = id;
    }

    public RadioCarRespondent(Long id, String task_id, String push_plate_number, String push_owner_name, String push_owner_id_number, String push_photo, String contraband_photo, String driver_id_number, String driver_phone, Boolean whether_contraband, Integer problem_type, Integer reason_for_differ, String other_reason, String check_name, String check_photo, Integer check_relation_to_driver, Boolean person_to_card, Integer vehicleProperty, String vehicleOrgName, Integer isNeedSecondcheck, Integer checkedReason, String noNeedCheckedReason) {
        this.id = id;
        this.task_id = task_id;
        this.push_plate_number = push_plate_number;
        this.push_owner_name = push_owner_name;
        this.push_owner_id_number = push_owner_id_number;
        this.push_photo = push_photo;
        this.contraband_photo = contraband_photo;
        this.driver_id_number = driver_id_number;
        this.driver_phone = driver_phone;
        this.whether_contraband = whether_contraband;
        this.problem_type = problem_type;
        this.reason_for_differ = reason_for_differ;
        this.other_reason = other_reason;
        this.check_name = check_name;
        this.check_photo = check_photo;
        this.check_relation_to_driver = check_relation_to_driver;
        this.person_to_card = person_to_card;
        this.vehicleProperty = vehicleProperty;
        this.vehicleOrgName = vehicleOrgName;
        this.isNeedSecondcheck = isNeedSecondcheck;
        this.checkedReason = checkedReason;
        this.noNeedCheckedReason = noNeedCheckedReason;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getRadioCarRespondentDao() : null;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask_id() {
        return this.task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getPush_plate_number() {
        return this.push_plate_number;
    }

    public void setPush_plate_number(String push_plate_number) {
        this.push_plate_number = push_plate_number;
    }

    public String getPush_owner_name() {
        return this.push_owner_name;
    }

    public void setPush_owner_name(String push_owner_name) {
        this.push_owner_name = push_owner_name;
    }

    public String getPush_owner_id_number() {
        return this.push_owner_id_number;
    }

    public void setPush_owner_id_number(String push_owner_id_number) {
        this.push_owner_id_number = push_owner_id_number;
    }

    public String getPush_photo() {
        return this.push_photo;
    }

    public void setPush_photo(String push_photo) {
        this.push_photo = push_photo;
    }

    public String getContraband_photo() {
        return this.contraband_photo;
    }

    public void setContraband_photo(String contraband_photo) {
        this.contraband_photo = contraband_photo;
    }

    public String getDriver_id_number() {
        return this.driver_id_number;
    }

    public void setDriver_id_number(String driver_id_number) {
        this.driver_id_number = driver_id_number;
    }

    public String getDriver_phone() {
        return this.driver_phone;
    }

    public void setDriver_phone(String driver_phone) {
        this.driver_phone = driver_phone;
    }

    public Boolean getWhether_contraband() {
        return this.whether_contraband;
    }

    public void setWhether_contraband(Boolean whether_contraband) {
        this.whether_contraband = whether_contraband;
    }

    public Integer getProblem_type() {
        return this.problem_type;
    }

    public void setProblem_type(Integer problem_type) {
        this.problem_type = problem_type;
    }

    public Integer getReason_for_differ() {
        return this.reason_for_differ;
    }

    public void setReason_for_differ(Integer reason_for_differ) {
        this.reason_for_differ = reason_for_differ;
    }

    public String getOther_reason() {
        return this.other_reason;
    }

    public void setOther_reason(String other_reason) {
        this.other_reason = other_reason;
    }

    public String getCheck_name() {
        return this.check_name;
    }

    public void setCheck_name(String check_name) {
        this.check_name = check_name;
    }

    public String getCheck_photo() {
        return this.check_photo;
    }

    public void setCheck_photo(String check_photo) {
        this.check_photo = check_photo;
    }

    public Integer getCheck_relation_to_driver() {
        return this.check_relation_to_driver;
    }

    public void setCheck_relation_to_driver(Integer check_relation_to_driver) {
        this.check_relation_to_driver = check_relation_to_driver;
    }

    public Boolean getPerson_to_card() {
        return this.person_to_card;
    }

    public void setPerson_to_card(Boolean person_to_card) {
        this.person_to_card = person_to_card;
    }

    public Integer getVehicleProperty() {
        return this.vehicleProperty;
    }

    public void setVehicleProperty(Integer vehicleProperty) {
        this.vehicleProperty = vehicleProperty;
    }

    public String getVehicleOrgName() {
        return this.vehicleOrgName;
    }

    public void setVehicleOrgName(String vehicleOrgName) {
        this.vehicleOrgName = vehicleOrgName;
    }

    public Integer getIsNeedSecondcheck() {
        return this.isNeedSecondcheck;
    }

    public void setIsNeedSecondcheck(Integer isNeedSecondcheck) {
        this.isNeedSecondcheck = isNeedSecondcheck;
    }

    public Integer getCheckedReason() {
        return this.checkedReason;
    }

    public void setCheckedReason(Integer checkedReason) {
        this.checkedReason = checkedReason;
    }

    public String getNoNeedCheckedReason() {
        return this.noNeedCheckedReason;
    }

    public void setNoNeedCheckedReason(String noNeedCheckedReason) {
        this.noNeedCheckedReason = noNeedCheckedReason;
    }

    public List<RadioCarPeer> getRadioCarPeerList() {
        if (this.radioCarPeerList == null) {
            __throwIfDetached();
            List<RadioCarPeer> radioCarPeerListNew = this.daoSession.getRadioCarPeerDao()._queryRadioCarRespondent_RadioCarPeerList(this.id);
            synchronized (this) {
                if (this.radioCarPeerList == null) {
                    this.radioCarPeerList = radioCarPeerListNew;
                }
            }
        }
        return this.radioCarPeerList;
    }

    public synchronized void resetRadioCarPeerList() {
        this.radioCarPeerList = null;
    }

    public List<SuspiciousPhone> getSuspiciousPhoneList() {
        if (this.suspiciousPhoneList == null) {
            __throwIfDetached();
            List<SuspiciousPhone> suspiciousPhoneListNew = this.daoSession.getSuspiciousPhoneDao()._queryRadioCarRespondent_SuspiciousPhoneList(this.id);
            synchronized (this) {
                if (this.suspiciousPhoneList == null) {
                    this.suspiciousPhoneList = suspiciousPhoneListNew;
                }
            }
        }
        return this.suspiciousPhoneList;
    }

    public synchronized void resetSuspiciousPhoneList() {
        this.suspiciousPhoneList = null;
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
