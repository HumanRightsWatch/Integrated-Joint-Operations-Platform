package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fec.xjoneproject.ui.supervise.CollectionListFragment;
import com.fec.xjoneproject.ui.supervise.TasksListFragment;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class LocalNoCarTrackEntityDao extends AbstractDao<LocalNoCarTrackEntity, Long> {
    public static final String TABLENAME = "LOCAL_NO_CAR_TRACK_ENTITY";

    public static class Properties {
        public static final Property AddTime = new Property(21, String.class, "addTime", false, "ADD_TIME");
        public static final Property AddTimeEnd = new Property(22, String.class, "addTimeEnd", false, "ADD_TIME_END");
        public static final Property AddUser = new Property(19, String.class, "addUser", false, "ADD_USER");
        public static final Property AddUserName = new Property(20, String.class, CollectionListFragment.ADDUSERNAME, false, "ADD_USER_NAME");
        public static final Property DataId = new Property(2, String.class, "dataId", false, "DATA_ID");
        public static final Property Description = new Property(12, String.class, "description", false, "DESCRIPTION");
        public static final Property DistrictAreaCode = new Property(7, String.class, "districtAreaCode", false, "DISTRICT_AREA_CODE");
        public static final Property EndTime = new Property(28, String.class, TasksListFragment.TASK_ETIME, false, "END_TIME");
        public static final Property FeedbackTime = new Property(16, String.class, "feedbackTime", false, "FEEDBACK_TIME");
        public static final Property FkCm = new Property(14, String.class, "fkCm", false, "FK_CM");
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property Index = new Property(3, String.class, "index", false, "INDEX");
        public static final Property IsChecked = new Property(13, Integer.class, "isChecked", false, "IS_CHECKED");
        public static final Property IsLogicDelete = new Property(29, Integer.class, "isLogicDelete", false, "IS_LOGIC_DELETE");
        public static final Property LicensePlate = new Property(8, String.class, "licensePlate", false, "LICENSE_PLATE");
        public static final Property LocalID = new Property(0, Long.class, "localID", true, "LOCAL_ID");
        public static final Property MissTrailDate = new Property(10, String.class, "missTrailDate", false, "MISS_TRAIL_DATE");
        public static final Property Modifier = new Property(25, String.class, "modifier", false, "MODIFIER");
        public static final Property ModifierName = new Property(26, String.class, "modifierName", false, "MODIFIER_NAME");
        public static final Property ModifyTime = new Property(27, String.class, "modifyTime", false, "MODIFY_TIME");
        public static final Property Note = new Property(18, String.class, "note", false, "NOTE");
        public static final Property OwnerAddress = new Property(9, String.class, "ownerAddress", false, "OWNER_ADDRESS");
        public static final Property OwnerIdCard = new Property(6, String.class, "ownerIdCard", false, "OWNER_ID_CARD");
        public static final Property OwnerName = new Property(4, String.class, "ownerName", false, "OWNER_NAME");
        public static final Property OwnerPhone = new Property(5, String.class, "ownerPhone", false, "OWNER_PHONE");
        public static final Property PoliceCheck = new Property(17, String.class, "policeCheck", false, "POLICE_CHECK");
        public static final Property PushTime = new Property(11, String.class, "pushTime", false, "PUSH_TIME");
        public static final Property SendTime = new Property(15, String.class, "sendTime", false, "SEND_TIME");
        public static final Property UserOrgName = new Property(24, String.class, "userOrgName", false, "USER_ORG_NAME");
        public static final Property UserOrganizationId = new Property(23, String.class, "userOrganizationId", false, "USER_ORGANIZATION_ID");
    }

    public LocalNoCarTrackEntityDao(DaoConfig config) {
        super(config);
    }

    public LocalNoCarTrackEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"LOCAL_NO_CAR_TRACK_ENTITY\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"DATA_ID\" TEXT,\"INDEX\" TEXT,\"OWNER_NAME\" TEXT,\"OWNER_PHONE\" TEXT,\"OWNER_ID_CARD\" TEXT,\"DISTRICT_AREA_CODE\" TEXT,\"LICENSE_PLATE\" TEXT,\"OWNER_ADDRESS\" TEXT,\"MISS_TRAIL_DATE\" TEXT,\"PUSH_TIME\" TEXT,\"DESCRIPTION\" TEXT,\"IS_CHECKED\" INTEGER,\"FK_CM\" TEXT,\"SEND_TIME\" TEXT,\"FEEDBACK_TIME\" TEXT,\"POLICE_CHECK\" TEXT,\"NOTE\" TEXT,\"ADD_USER\" TEXT,\"ADD_USER_NAME\" TEXT,\"ADD_TIME\" TEXT,\"ADD_TIME_END\" TEXT,\"USER_ORGANIZATION_ID\" TEXT,\"USER_ORG_NAME\" TEXT,\"MODIFIER\" TEXT,\"MODIFIER_NAME\" TEXT,\"MODIFY_TIME\" TEXT,\"END_TIME\" TEXT,\"IS_LOGIC_DELETE\" INTEGER);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCAL_NO_CAR_TRACK_ENTITY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, LocalNoCarTrackEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        String dataId = entity.getDataId();
        if (dataId != null) {
            stmt.bindString(3, dataId);
        }
        String index = entity.getIndex();
        if (index != null) {
            stmt.bindString(4, index);
        }
        String ownerName = entity.getOwnerName();
        if (ownerName != null) {
            stmt.bindString(5, ownerName);
        }
        String ownerPhone = entity.getOwnerPhone();
        if (ownerPhone != null) {
            stmt.bindString(6, ownerPhone);
        }
        String ownerIdCard = entity.getOwnerIdCard();
        if (ownerIdCard != null) {
            stmt.bindString(7, ownerIdCard);
        }
        String districtAreaCode = entity.getDistrictAreaCode();
        if (districtAreaCode != null) {
            stmt.bindString(8, districtAreaCode);
        }
        String licensePlate = entity.getLicensePlate();
        if (licensePlate != null) {
            stmt.bindString(9, licensePlate);
        }
        String ownerAddress = entity.getOwnerAddress();
        if (ownerAddress != null) {
            stmt.bindString(10, ownerAddress);
        }
        String missTrailDate = entity.getMissTrailDate();
        if (missTrailDate != null) {
            stmt.bindString(11, missTrailDate);
        }
        String pushTime = entity.getPushTime();
        if (pushTime != null) {
            stmt.bindString(12, pushTime);
        }
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(13, description);
        }
        Integer isChecked = entity.getIsChecked();
        if (isChecked != null) {
            stmt.bindLong(14, (long) isChecked.intValue());
        }
        String fkCm = entity.getFkCm();
        if (fkCm != null) {
            stmt.bindString(15, fkCm);
        }
        String sendTime = entity.getSendTime();
        if (sendTime != null) {
            stmt.bindString(16, sendTime);
        }
        String feedbackTime = entity.getFeedbackTime();
        if (feedbackTime != null) {
            stmt.bindString(17, feedbackTime);
        }
        String policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindString(18, policeCheck);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(19, note);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(20, addUser);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(21, addUserName);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(22, addTime);
        }
        String addTimeEnd = entity.getAddTimeEnd();
        if (addTimeEnd != null) {
            stmt.bindString(23, addTimeEnd);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(24, userOrganizationId);
        }
        String userOrgName = entity.getUserOrgName();
        if (userOrgName != null) {
            stmt.bindString(25, userOrgName);
        }
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(26, modifier);
        }
        String modifierName = entity.getModifierName();
        if (modifierName != null) {
            stmt.bindString(27, modifierName);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(28, modifyTime);
        }
        String endTime = entity.getEndTime();
        if (endTime != null) {
            stmt.bindString(29, endTime);
        }
        Integer isLogicDelete = entity.getIsLogicDelete();
        if (isLogicDelete != null) {
            stmt.bindLong(30, (long) isLogicDelete.intValue());
        }
    }

    protected final void bindValues(SQLiteStatement stmt, LocalNoCarTrackEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        String dataId = entity.getDataId();
        if (dataId != null) {
            stmt.bindString(3, dataId);
        }
        String index = entity.getIndex();
        if (index != null) {
            stmt.bindString(4, index);
        }
        String ownerName = entity.getOwnerName();
        if (ownerName != null) {
            stmt.bindString(5, ownerName);
        }
        String ownerPhone = entity.getOwnerPhone();
        if (ownerPhone != null) {
            stmt.bindString(6, ownerPhone);
        }
        String ownerIdCard = entity.getOwnerIdCard();
        if (ownerIdCard != null) {
            stmt.bindString(7, ownerIdCard);
        }
        String districtAreaCode = entity.getDistrictAreaCode();
        if (districtAreaCode != null) {
            stmt.bindString(8, districtAreaCode);
        }
        String licensePlate = entity.getLicensePlate();
        if (licensePlate != null) {
            stmt.bindString(9, licensePlate);
        }
        String ownerAddress = entity.getOwnerAddress();
        if (ownerAddress != null) {
            stmt.bindString(10, ownerAddress);
        }
        String missTrailDate = entity.getMissTrailDate();
        if (missTrailDate != null) {
            stmt.bindString(11, missTrailDate);
        }
        String pushTime = entity.getPushTime();
        if (pushTime != null) {
            stmt.bindString(12, pushTime);
        }
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(13, description);
        }
        Integer isChecked = entity.getIsChecked();
        if (isChecked != null) {
            stmt.bindLong(14, (long) isChecked.intValue());
        }
        String fkCm = entity.getFkCm();
        if (fkCm != null) {
            stmt.bindString(15, fkCm);
        }
        String sendTime = entity.getSendTime();
        if (sendTime != null) {
            stmt.bindString(16, sendTime);
        }
        String feedbackTime = entity.getFeedbackTime();
        if (feedbackTime != null) {
            stmt.bindString(17, feedbackTime);
        }
        String policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindString(18, policeCheck);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(19, note);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(20, addUser);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(21, addUserName);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(22, addTime);
        }
        String addTimeEnd = entity.getAddTimeEnd();
        if (addTimeEnd != null) {
            stmt.bindString(23, addTimeEnd);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(24, userOrganizationId);
        }
        String userOrgName = entity.getUserOrgName();
        if (userOrgName != null) {
            stmt.bindString(25, userOrgName);
        }
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(26, modifier);
        }
        String modifierName = entity.getModifierName();
        if (modifierName != null) {
            stmt.bindString(27, modifierName);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(28, modifyTime);
        }
        String endTime = entity.getEndTime();
        if (endTime != null) {
            stmt.bindString(29, endTime);
        }
        Integer isLogicDelete = entity.getIsLogicDelete();
        if (isLogicDelete != null) {
            stmt.bindLong(30, (long) isLogicDelete.intValue());
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public LocalNoCarTrackEntity readEntity(Cursor cursor, int offset) {
        return new LocalNoCarTrackEntity(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : Integer.valueOf(cursor.getInt(offset + 13)), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), cursor.isNull(offset + 29) ? null : Integer.valueOf(cursor.getInt(offset + 29)));
    }

    public void readEntity(Cursor cursor, LocalNoCarTrackEntity entity, int offset) {
        Integer num = null;
        entity.setLocalID(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDataId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIndex(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setOwnerName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setOwnerPhone(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setOwnerIdCard(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDistrictAreaCode(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setLicensePlate(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setOwnerAddress(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setMissTrailDate(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setPushTime(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setDescription(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setIsChecked(cursor.isNull(offset + 13) ? null : Integer.valueOf(cursor.getInt(offset + 13)));
        entity.setFkCm(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setSendTime(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setFeedbackTime(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setPoliceCheck(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setNote(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setAddUser(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setAddUserName(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setAddTime(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setAddTimeEnd(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setUserOrganizationId(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setUserOrgName(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setModifier(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setModifierName(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setModifyTime(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setEndTime(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        if (!cursor.isNull(offset + 29)) {
            num = Integer.valueOf(cursor.getInt(offset + 29));
        }
        entity.setIsLogicDelete(num);
    }

    protected final Long updateKeyAfterInsert(LocalNoCarTrackEntity entity, long rowId) {
        entity.setLocalID(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(LocalNoCarTrackEntity entity) {
        if (entity != null) {
            return entity.getLocalID();
        }
        return null;
    }

    public boolean hasKey(LocalNoCarTrackEntity entity) {
        return entity.getLocalID() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
