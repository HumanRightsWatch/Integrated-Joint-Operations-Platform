package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class OverduePersonInfoDao extends AbstractDao<OverduePersonInfo, Long> {
    public static final String TABLENAME = "OVERDUE_PERSON_INFO";
    private DaoSession daoSession;

    public static class Properties {
        public static final Property ActionInfo = new Property(18, String.class, "actionInfo", false, "ACTION_INFO");
        public static final Property ActionSuspicous = new Property(17, Integer.class, "actionSuspicous", false, "ACTION_SUSPICOUS");
        public static final Property ActivityDetail = new Property(5, String.class, "activityDetail", false, "ACTIVITY_DETAIL");
        public static final Property AddTime = new Property(14, String.class, "addTime", false, "ADD_TIME");
        public static final Property AddUser = new Property(13, String.class, "addUser", false, "ADD_USER");
        public static final Property Address = new Property(22, String.class, "address", false, "ADDRESS");
        public static final Property Enter = new Property(7, String.class, "enter", false, "ENTER");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property IdCard = new Property(20, String.class, "idCard", false, "ID_CARD");
        public static final Property IsDelete = new Property(16, Integer.class, "isDelete", false, "IS_DELETE");
        public static final Property IsLeaveCountyr = new Property(4, Integer.class, "isLeaveCountyr", false, "IS_LEAVE_COUNTYR");
        public static final Property IsSuspicious = new Property(10, Integer.class, "isSuspicious", false, "IS_SUSPICIOUS");
        public static final Property LeaveFor = new Property(6, String.class, "leaveFor", false, "LEAVE_FOR");
        public static final Property LeaveReason = new Property(8, Integer.class, "leaveReason", false, "LEAVE_REASON");
        public static final Property ModifyTime = new Property(15, String.class, "modifyTime", false, "MODIFY_TIME");
        public static final Property Name = new Property(19, String.class, "name", false, "NAME");
        public static final Property Note = new Property(12, String.class, "note", false, "NOTE");
        public static final Property OtherReason = new Property(9, String.class, "otherReason", false, "OTHER_REASON");
        public static final Property Phone = new Property(21, String.class, "phone", false, "PHONE");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property SpotPhoto = new Property(23, String.class, "spotPhoto", false, "SPOT_PHOTO");
        public static final Property SuspiciousAction = new Property(11, String.class, "suspiciousAction", false, "SUSPICIOUS_ACTION");
        public static final Property SuspiciousInfo = new Property(3, Integer.class, "suspiciousInfo", false, "SUSPICIOUS_INFO");
        public static final Property Task_id = new Property(2, String.class, "task_id", false, "TASK_ID");
    }

    public OverduePersonInfoDao(DaoConfig config) {
        super(config);
    }

    public OverduePersonInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"OVERDUE_PERSON_INFO\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"TASK_ID\" TEXT,\"SUSPICIOUS_INFO\" INTEGER,\"IS_LEAVE_COUNTYR\" INTEGER,\"ACTIVITY_DETAIL\" TEXT,\"LEAVE_FOR\" TEXT,\"ENTER\" TEXT,\"LEAVE_REASON\" INTEGER,\"OTHER_REASON\" TEXT,\"IS_SUSPICIOUS\" INTEGER,\"SUSPICIOUS_ACTION\" TEXT,\"NOTE\" TEXT,\"ADD_USER\" TEXT,\"ADD_TIME\" TEXT,\"MODIFY_TIME\" TEXT,\"IS_DELETE\" INTEGER,\"ACTION_SUSPICOUS\" INTEGER,\"ACTION_INFO\" TEXT,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"PHONE\" TEXT,\"ADDRESS\" TEXT,\"SPOT_PHOTO\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"OVERDUE_PERSON_INFO\"");
    }

    protected final void bindValues(DatabaseStatement stmt, OverduePersonInfo entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        String task_id = entity.getTask_id();
        if (task_id != null) {
            stmt.bindString(3, task_id);
        }
        Integer suspiciousInfo = entity.getSuspiciousInfo();
        if (suspiciousInfo != null) {
            stmt.bindLong(4, (long) suspiciousInfo.intValue());
        }
        Integer isLeaveCountyr = entity.getIsLeaveCountyr();
        if (isLeaveCountyr != null) {
            stmt.bindLong(5, (long) isLeaveCountyr.intValue());
        }
        String activityDetail = entity.getActivityDetail();
        if (activityDetail != null) {
            stmt.bindString(6, activityDetail);
        }
        String leaveFor = entity.getLeaveFor();
        if (leaveFor != null) {
            stmt.bindString(7, leaveFor);
        }
        String enter = entity.getEnter();
        if (enter != null) {
            stmt.bindString(8, enter);
        }
        Integer leaveReason = entity.getLeaveReason();
        if (leaveReason != null) {
            stmt.bindLong(9, (long) leaveReason.intValue());
        }
        String otherReason = entity.getOtherReason();
        if (otherReason != null) {
            stmt.bindString(10, otherReason);
        }
        Integer isSuspicious = entity.getIsSuspicious();
        if (isSuspicious != null) {
            stmt.bindLong(11, (long) isSuspicious.intValue());
        }
        String suspiciousAction = entity.getSuspiciousAction();
        if (suspiciousAction != null) {
            stmt.bindString(12, suspiciousAction);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(13, note);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(14, addUser);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(15, addTime);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(16, modifyTime);
        }
        Integer isDelete = entity.getIsDelete();
        if (isDelete != null) {
            stmt.bindLong(17, (long) isDelete.intValue());
        }
        Integer actionSuspicous = entity.getActionSuspicous();
        if (actionSuspicous != null) {
            stmt.bindLong(18, (long) actionSuspicous.intValue());
        }
        String actionInfo = entity.getActionInfo();
        if (actionInfo != null) {
            stmt.bindString(19, actionInfo);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(20, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(21, idCard);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(22, phone);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(23, address);
        }
        String spotPhoto = entity.getSpotPhoto();
        if (spotPhoto != null) {
            stmt.bindString(24, spotPhoto);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, OverduePersonInfo entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        String task_id = entity.getTask_id();
        if (task_id != null) {
            stmt.bindString(3, task_id);
        }
        Integer suspiciousInfo = entity.getSuspiciousInfo();
        if (suspiciousInfo != null) {
            stmt.bindLong(4, (long) suspiciousInfo.intValue());
        }
        Integer isLeaveCountyr = entity.getIsLeaveCountyr();
        if (isLeaveCountyr != null) {
            stmt.bindLong(5, (long) isLeaveCountyr.intValue());
        }
        String activityDetail = entity.getActivityDetail();
        if (activityDetail != null) {
            stmt.bindString(6, activityDetail);
        }
        String leaveFor = entity.getLeaveFor();
        if (leaveFor != null) {
            stmt.bindString(7, leaveFor);
        }
        String enter = entity.getEnter();
        if (enter != null) {
            stmt.bindString(8, enter);
        }
        Integer leaveReason = entity.getLeaveReason();
        if (leaveReason != null) {
            stmt.bindLong(9, (long) leaveReason.intValue());
        }
        String otherReason = entity.getOtherReason();
        if (otherReason != null) {
            stmt.bindString(10, otherReason);
        }
        Integer isSuspicious = entity.getIsSuspicious();
        if (isSuspicious != null) {
            stmt.bindLong(11, (long) isSuspicious.intValue());
        }
        String suspiciousAction = entity.getSuspiciousAction();
        if (suspiciousAction != null) {
            stmt.bindString(12, suspiciousAction);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(13, note);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(14, addUser);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(15, addTime);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(16, modifyTime);
        }
        Integer isDelete = entity.getIsDelete();
        if (isDelete != null) {
            stmt.bindLong(17, (long) isDelete.intValue());
        }
        Integer actionSuspicous = entity.getActionSuspicous();
        if (actionSuspicous != null) {
            stmt.bindLong(18, (long) actionSuspicous.intValue());
        }
        String actionInfo = entity.getActionInfo();
        if (actionInfo != null) {
            stmt.bindString(19, actionInfo);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(20, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(21, idCard);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(22, phone);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(23, address);
        }
        String spotPhoto = entity.getSpotPhoto();
        if (spotPhoto != null) {
            stmt.bindString(24, spotPhoto);
        }
    }

    protected final void attachEntity(OverduePersonInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(this.daoSession);
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public OverduePersonInfo readEntity(Cursor cursor, int offset) {
        return new OverduePersonInfo(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)), cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : Integer.valueOf(cursor.getInt(offset + 8)), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : Integer.valueOf(cursor.getInt(offset + 10)), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : Integer.valueOf(cursor.getInt(offset + 16)), cursor.isNull(offset + 17) ? null : Integer.valueOf(cursor.getInt(offset + 17)), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
    }

    public void readEntity(Cursor cursor, OverduePersonInfo entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTask_id(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSuspiciousInfo(cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)));
        entity.setIsLeaveCountyr(cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)));
        entity.setActivityDetail(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setLeaveFor(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setEnter(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setLeaveReason(cursor.isNull(offset + 8) ? null : Integer.valueOf(cursor.getInt(offset + 8)));
        entity.setOtherReason(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setIsSuspicious(cursor.isNull(offset + 10) ? null : Integer.valueOf(cursor.getInt(offset + 10)));
        entity.setSuspiciousAction(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setNote(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setAddUser(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setAddTime(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setModifyTime(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setIsDelete(cursor.isNull(offset + 16) ? null : Integer.valueOf(cursor.getInt(offset + 16)));
        entity.setActionSuspicous(cursor.isNull(offset + 17) ? null : Integer.valueOf(cursor.getInt(offset + 17)));
        entity.setActionInfo(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setName(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setIdCard(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setPhone(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setAddress(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        if (!cursor.isNull(offset + 23)) {
            str = cursor.getString(offset + 23);
        }
        entity.setSpotPhoto(str);
    }

    protected final Long updateKeyAfterInsert(OverduePersonInfo entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(OverduePersonInfo entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(OverduePersonInfo entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
