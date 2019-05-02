package com.fec.report.dao;

import java.util.List;
import org.greenrobot.greendao.DaoException;

public class RadioPersonnelRespondent {
    private transient DaoSession daoSession;
    private Long id;
    private String id_number;
    private Integer leavev_local;
    private transient RadioPersonnelRespondentDao myDao;
    private String other_to_inner_land_reason;
    private String phone;
    private Integer push_action;
    private String push_disposition;
    private String push_home_address;
    private String push_id_number;
    private Integer push_match_type;
    private String push_name;
    private Integer push_people_type;
    private String push_photo;
    private List<RadioPersonnelPeer> radioPersonnelPeerList;
    private String return_date;
    private String task_id;
    private Integer to_inner_land_reason;
    private Integer whether_consistent;
    private Integer whether_dubious;
    private Integer whether_leave;
    private Integer whether_warning;

    public RadioPersonnelRespondent(Long id) {
        this.id = id;
    }

    public RadioPersonnelRespondent(Long id, String task_id, String push_name, String push_id_number, String push_home_address, String push_photo, Integer push_match_type, Integer push_people_type, String id_number, String phone, Integer whether_leave, Integer whether_warning, String push_disposition, Integer push_action, Integer whether_consistent, Integer whether_dubious, Integer to_inner_land_reason, String other_to_inner_land_reason, String return_date, Integer leavev_local) {
        this.id = id;
        this.task_id = task_id;
        this.push_name = push_name;
        this.push_id_number = push_id_number;
        this.push_home_address = push_home_address;
        this.push_photo = push_photo;
        this.push_match_type = push_match_type;
        this.push_people_type = push_people_type;
        this.id_number = id_number;
        this.phone = phone;
        this.whether_leave = whether_leave;
        this.whether_warning = whether_warning;
        this.push_disposition = push_disposition;
        this.push_action = push_action;
        this.whether_consistent = whether_consistent;
        this.whether_dubious = whether_dubious;
        this.to_inner_land_reason = to_inner_land_reason;
        this.other_to_inner_land_reason = other_to_inner_land_reason;
        this.return_date = return_date;
        this.leavev_local = leavev_local;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getRadioPersonnelRespondentDao() : null;
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

    public String getPush_name() {
        return this.push_name;
    }

    public void setPush_name(String push_name) {
        this.push_name = push_name;
    }

    public String getPush_id_number() {
        return this.push_id_number;
    }

    public void setPush_id_number(String push_id_number) {
        this.push_id_number = push_id_number;
    }

    public String getPush_home_address() {
        return this.push_home_address;
    }

    public void setPush_home_address(String push_home_address) {
        this.push_home_address = push_home_address;
    }

    public String getPush_photo() {
        return this.push_photo;
    }

    public void setPush_photo(String push_photo) {
        this.push_photo = push_photo;
    }

    public Integer getPush_match_type() {
        return this.push_match_type;
    }

    public void setPush_match_type(Integer push_match_type) {
        this.push_match_type = push_match_type;
    }

    public Integer getPush_people_type() {
        return this.push_people_type;
    }

    public void setPush_people_type(Integer push_people_type) {
        this.push_people_type = push_people_type;
    }

    public String getId_number() {
        return this.id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getWhether_leave() {
        return this.whether_leave;
    }

    public void setWhether_leave(Integer whether_leave) {
        this.whether_leave = whether_leave;
    }

    public Integer getWhether_warning() {
        return this.whether_warning;
    }

    public void setWhether_warning(Integer whether_warning) {
        this.whether_warning = whether_warning;
    }

    public String getPush_disposition() {
        return this.push_disposition;
    }

    public void setPush_disposition(String push_disposition) {
        this.push_disposition = push_disposition;
    }

    public Integer getPush_action() {
        return this.push_action;
    }

    public void setPush_action(Integer push_action) {
        this.push_action = push_action;
    }

    public Integer getWhether_consistent() {
        return this.whether_consistent;
    }

    public void setWhether_consistent(Integer whether_consistent) {
        this.whether_consistent = whether_consistent;
    }

    public Integer getWhether_dubious() {
        return this.whether_dubious;
    }

    public void setWhether_dubious(Integer whether_dubious) {
        this.whether_dubious = whether_dubious;
    }

    public Integer getTo_inner_land_reason() {
        return this.to_inner_land_reason;
    }

    public void setTo_inner_land_reason(Integer to_inner_land_reason) {
        this.to_inner_land_reason = to_inner_land_reason;
    }

    public String getOther_to_inner_land_reason() {
        return this.other_to_inner_land_reason;
    }

    public void setOther_to_inner_land_reason(String other_to_inner_land_reason) {
        this.other_to_inner_land_reason = other_to_inner_land_reason;
    }

    public String getReturn_date() {
        return this.return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public Integer getLeavev_local() {
        return this.leavev_local;
    }

    public void setLeavev_local(Integer leavev_local) {
        this.leavev_local = leavev_local;
    }

    public List<RadioPersonnelPeer> getRadioPersonnelPeerList() {
        if (this.radioPersonnelPeerList == null) {
            __throwIfDetached();
            List<RadioPersonnelPeer> radioPersonnelPeerListNew = this.daoSession.getRadioPersonnelPeerDao()._queryRadioPersonnelRespondent_RadioPersonnelPeerList(this.id);
            synchronized (this) {
                if (this.radioPersonnelPeerList == null) {
                    this.radioPersonnelPeerList = radioPersonnelPeerListNew;
                }
            }
        }
        return this.radioPersonnelPeerList;
    }

    public synchronized void resetRadioPersonnelPeerList() {
        this.radioPersonnelPeerList = null;
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
