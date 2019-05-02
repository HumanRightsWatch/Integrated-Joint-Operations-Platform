package com.fec.report.dao;

import java.util.List;
import org.greenrobot.greendao.DaoException;

public class OverduePersonInfo {
    private String actionInfo;
    private Integer actionSuspicous;
    private String activityDetail;
    private String addTime;
    private String addUser;
    private String address;
    private transient DaoSession daoSession;
    private String enter;
    private Long id;
    private String idCard;
    private Integer isDelete;
    private Integer isLeaveCountyr;
    private Integer isSuspicious;
    private String leaveFor;
    private Integer leaveReason;
    private String modifyTime;
    private transient OverduePersonInfoDao myDao;
    private String name;
    private String note;
    private String otherReason;
    private List<OverduePersonContact> overduePersonContactList;
    private List<OverduePersonVisitor> overduePersonVisitorList;
    private String phone;
    private String service_id;
    private String spotPhoto;
    private String suspiciousAction;
    private Integer suspiciousInfo;
    private String task_id;

    public OverduePersonInfo(Long id) {
        this.id = id;
    }

    public OverduePersonInfo(Long id, String service_id, String task_id, Integer suspiciousInfo, Integer isLeaveCountyr, String activityDetail, String leaveFor, String enter, Integer leaveReason, String otherReason, Integer isSuspicious, String suspiciousAction, String note, String addUser, String addTime, String modifyTime, Integer isDelete, Integer actionSuspicous, String actionInfo, String name, String idCard, String phone, String address, String spotPhoto) {
        this.id = id;
        this.service_id = service_id;
        this.task_id = task_id;
        this.suspiciousInfo = suspiciousInfo;
        this.isLeaveCountyr = isLeaveCountyr;
        this.activityDetail = activityDetail;
        this.leaveFor = leaveFor;
        this.enter = enter;
        this.leaveReason = leaveReason;
        this.otherReason = otherReason;
        this.isSuspicious = isSuspicious;
        this.suspiciousAction = suspiciousAction;
        this.note = note;
        this.addUser = addUser;
        this.addTime = addTime;
        this.modifyTime = modifyTime;
        this.isDelete = isDelete;
        this.actionSuspicous = actionSuspicous;
        this.actionInfo = actionInfo;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.address = address;
        this.spotPhoto = spotPhoto;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getOverduePersonInfoDao() : null;
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

    public String getTask_id() {
        return this.task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public Integer getSuspiciousInfo() {
        return this.suspiciousInfo;
    }

    public void setSuspiciousInfo(Integer suspiciousInfo) {
        this.suspiciousInfo = suspiciousInfo;
    }

    public Integer getIsLeaveCountyr() {
        return this.isLeaveCountyr;
    }

    public void setIsLeaveCountyr(Integer isLeaveCountyr) {
        this.isLeaveCountyr = isLeaveCountyr;
    }

    public String getActivityDetail() {
        return this.activityDetail;
    }

    public void setActivityDetail(String activityDetail) {
        this.activityDetail = activityDetail;
    }

    public String getLeaveFor() {
        return this.leaveFor;
    }

    public void setLeaveFor(String leaveFor) {
        this.leaveFor = leaveFor;
    }

    public String getEnter() {
        return this.enter;
    }

    public void setEnter(String enter) {
        this.enter = enter;
    }

    public Integer getLeaveReason() {
        return this.leaveReason;
    }

    public void setLeaveReason(Integer leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getOtherReason() {
        return this.otherReason;
    }

    public void setOtherReason(String otherReason) {
        this.otherReason = otherReason;
    }

    public Integer getIsSuspicious() {
        return this.isSuspicious;
    }

    public void setIsSuspicious(Integer isSuspicious) {
        this.isSuspicious = isSuspicious;
    }

    public String getSuspiciousAction() {
        return this.suspiciousAction;
    }

    public void setSuspiciousAction(String suspiciousAction) {
        this.suspiciousAction = suspiciousAction;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAddUser() {
        return this.addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public String getAddTime() {
        return this.addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getActionSuspicous() {
        return this.actionSuspicous;
    }

    public void setActionSuspicous(Integer actionSuspicous) {
        this.actionSuspicous = actionSuspicous;
    }

    public String getActionInfo() {
        return this.actionInfo;
    }

    public void setActionInfo(String actionInfo) {
        this.actionInfo = actionInfo;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpotPhoto() {
        return this.spotPhoto;
    }

    public void setSpotPhoto(String spotPhoto) {
        this.spotPhoto = spotPhoto;
    }

    public List<OverduePersonVisitor> getOverduePersonVisitorList() {
        if (this.overduePersonVisitorList == null) {
            __throwIfDetached();
            List<OverduePersonVisitor> overduePersonVisitorListNew = this.daoSession.getOverduePersonVisitorDao()._queryOverduePersonInfo_OverduePersonVisitorList(this.id);
            synchronized (this) {
                if (this.overduePersonVisitorList == null) {
                    this.overduePersonVisitorList = overduePersonVisitorListNew;
                }
            }
        }
        return this.overduePersonVisitorList;
    }

    public synchronized void resetOverduePersonVisitorList() {
        this.overduePersonVisitorList = null;
    }

    public List<OverduePersonContact> getOverduePersonContactList() {
        if (this.overduePersonContactList == null) {
            __throwIfDetached();
            List<OverduePersonContact> overduePersonContactListNew = this.daoSession.getOverduePersonContactDao()._queryOverduePersonInfo_OverduePersonContactList(this.id);
            synchronized (this) {
                if (this.overduePersonContactList == null) {
                    this.overduePersonContactList = overduePersonContactListNew;
                }
            }
        }
        return this.overduePersonContactList;
    }

    public synchronized void resetOverduePersonContactList() {
        this.overduePersonContactList = null;
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
