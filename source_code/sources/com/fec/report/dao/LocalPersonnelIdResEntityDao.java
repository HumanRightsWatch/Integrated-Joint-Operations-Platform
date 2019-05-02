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

public class LocalPersonnelIdResEntityDao extends AbstractDao<LocalPersonnelIdResEntity, Long> {
    public static final String TABLENAME = "LOCAL_PERSONNEL_ID_RES_ENTITY";

    public static class Properties {
        public static final Property AddUser = new Property(20, String.class, "addUser", false, "ADD_USER");
        public static final Property AddUserName = new Property(21, String.class, CollectionListFragment.ADDUSERNAME, false, "ADD_USER_NAME");
        public static final Property DeadTrackReason = new Property(4, String.class, "deadTrackReason", false, "DEAD_TRACK_REASON");
        public static final Property EnterTime = new Property(6, String.class, "enterTime", false, "ENTER_TIME");
        public static final Property EnterWay = new Property(7, String.class, "enterWay", false, "ENTER_WAY");
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property IsInbound = new Property(5, String.class, "isInbound", false, "IS_INBOUND");
        public static final Property IsMatch = new Property(3, String.class, "isMatch", false, "IS_MATCH");
        public static final Property Latitude = new Property(25, Double.class, "latitude", false, "LATITUDE");
        public static final Property LeaveReason = new Property(9, String.class, "leaveReason", false, "LEAVE_REASON");
        public static final Property LocalFkPim = new Property(2, Long.class, "localFkPim", false, "LOCAL_FK_PIM");
        public static final Property LocalID = new Property(0, Long.class, "localID", true, "LOCAL_ID");
        public static final Property LocationDescription = new Property(26, String.class, "locationDescription", false, "LOCATION_DESCRIPTION");
        public static final Property Longitude = new Property(24, Double.class, "longitude", false, "LONGITUDE");
        public static final Property Note = new Property(19, String.class, "note", false, "NOTE");
        public static final Property OtherEnterWay = new Property(8, String.class, "otherEnterWay", false, "OTHER_ENTER_WAY");
        public static final Property OtherLeaveReason = new Property(10, String.class, "otherLeaveReason", false, "OTHER_LEAVE_REASON");
        public static final Property OtherTrackReason = new Property(12, String.class, "otherTrackReason", false, "OTHER_TRACK_REASON");
        public static final Property PoliceCheck = new Property(17, String.class, "policeCheck", false, "POLICE_CHECK");
        public static final Property PoliceReason = new Property(18, String.class, "policeReason", false, "POLICE_REASON");
        public static final Property TrackReason = new Property(11, String.class, "trackReason", false, "TRACK_REASON");
        public static final Property UserAddress = new Property(16, String.class, "userAddress", false, "USER_ADDRESS");
        public static final Property UserIdCard = new Property(14, String.class, "userIdCard", false, "USER_ID_CARD");
        public static final Property UserName = new Property(13, String.class, TasksListFragment.PERSON_NAME, false, "USER_NAME");
        public static final Property UserOrgName = new Property(23, String.class, "userOrgName", false, "USER_ORG_NAME");
        public static final Property UserOrganizationId = new Property(22, String.class, "userOrganizationId", false, "USER_ORGANIZATION_ID");
        public static final Property UserPhone = new Property(15, String.class, "userPhone", false, "USER_PHONE");
    }

    public LocalPersonnelIdResEntityDao(DaoConfig config) {
        super(config);
    }

    public LocalPersonnelIdResEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"LOCAL_PERSONNEL_ID_RES_ENTITY\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"LOCAL_FK_PIM\" INTEGER,\"IS_MATCH\" TEXT,\"DEAD_TRACK_REASON\" TEXT,\"IS_INBOUND\" TEXT,\"ENTER_TIME\" TEXT,\"ENTER_WAY\" TEXT,\"OTHER_ENTER_WAY\" TEXT,\"LEAVE_REASON\" TEXT,\"OTHER_LEAVE_REASON\" TEXT,\"TRACK_REASON\" TEXT,\"OTHER_TRACK_REASON\" TEXT,\"USER_NAME\" TEXT,\"USER_ID_CARD\" TEXT,\"USER_PHONE\" TEXT,\"USER_ADDRESS\" TEXT,\"POLICE_CHECK\" TEXT,\"POLICE_REASON\" TEXT,\"NOTE\" TEXT,\"ADD_USER\" TEXT,\"ADD_USER_NAME\" TEXT,\"USER_ORGANIZATION_ID\" TEXT,\"USER_ORG_NAME\" TEXT,\"LONGITUDE\" REAL,\"LATITUDE\" REAL,\"LOCATION_DESCRIPTION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCAL_PERSONNEL_ID_RES_ENTITY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, LocalPersonnelIdResEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        Long localFkPim = entity.getLocalFkPim();
        if (localFkPim != null) {
            stmt.bindLong(3, localFkPim.longValue());
        }
        String isMatch = entity.getIsMatch();
        if (isMatch != null) {
            stmt.bindString(4, isMatch);
        }
        String deadTrackReason = entity.getDeadTrackReason();
        if (deadTrackReason != null) {
            stmt.bindString(5, deadTrackReason);
        }
        String isInbound = entity.getIsInbound();
        if (isInbound != null) {
            stmt.bindString(6, isInbound);
        }
        String enterTime = entity.getEnterTime();
        if (enterTime != null) {
            stmt.bindString(7, enterTime);
        }
        String enterWay = entity.getEnterWay();
        if (enterWay != null) {
            stmt.bindString(8, enterWay);
        }
        String otherEnterWay = entity.getOtherEnterWay();
        if (otherEnterWay != null) {
            stmt.bindString(9, otherEnterWay);
        }
        String leaveReason = entity.getLeaveReason();
        if (leaveReason != null) {
            stmt.bindString(10, leaveReason);
        }
        String otherLeaveReason = entity.getOtherLeaveReason();
        if (otherLeaveReason != null) {
            stmt.bindString(11, otherLeaveReason);
        }
        String trackReason = entity.getTrackReason();
        if (trackReason != null) {
            stmt.bindString(12, trackReason);
        }
        String otherTrackReason = entity.getOtherTrackReason();
        if (otherTrackReason != null) {
            stmt.bindString(13, otherTrackReason);
        }
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(14, userName);
        }
        String userIdCard = entity.getUserIdCard();
        if (userIdCard != null) {
            stmt.bindString(15, userIdCard);
        }
        String userPhone = entity.getUserPhone();
        if (userPhone != null) {
            stmt.bindString(16, userPhone);
        }
        String userAddress = entity.getUserAddress();
        if (userAddress != null) {
            stmt.bindString(17, userAddress);
        }
        String policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindString(18, policeCheck);
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(19, policeReason);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(20, note);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(21, addUser);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(22, addUserName);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(23, userOrganizationId);
        }
        String userOrgName = entity.getUserOrgName();
        if (userOrgName != null) {
            stmt.bindString(24, userOrgName);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(25, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(26, latitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(27, locationDescription);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, LocalPersonnelIdResEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        Long localFkPim = entity.getLocalFkPim();
        if (localFkPim != null) {
            stmt.bindLong(3, localFkPim.longValue());
        }
        String isMatch = entity.getIsMatch();
        if (isMatch != null) {
            stmt.bindString(4, isMatch);
        }
        String deadTrackReason = entity.getDeadTrackReason();
        if (deadTrackReason != null) {
            stmt.bindString(5, deadTrackReason);
        }
        String isInbound = entity.getIsInbound();
        if (isInbound != null) {
            stmt.bindString(6, isInbound);
        }
        String enterTime = entity.getEnterTime();
        if (enterTime != null) {
            stmt.bindString(7, enterTime);
        }
        String enterWay = entity.getEnterWay();
        if (enterWay != null) {
            stmt.bindString(8, enterWay);
        }
        String otherEnterWay = entity.getOtherEnterWay();
        if (otherEnterWay != null) {
            stmt.bindString(9, otherEnterWay);
        }
        String leaveReason = entity.getLeaveReason();
        if (leaveReason != null) {
            stmt.bindString(10, leaveReason);
        }
        String otherLeaveReason = entity.getOtherLeaveReason();
        if (otherLeaveReason != null) {
            stmt.bindString(11, otherLeaveReason);
        }
        String trackReason = entity.getTrackReason();
        if (trackReason != null) {
            stmt.bindString(12, trackReason);
        }
        String otherTrackReason = entity.getOtherTrackReason();
        if (otherTrackReason != null) {
            stmt.bindString(13, otherTrackReason);
        }
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(14, userName);
        }
        String userIdCard = entity.getUserIdCard();
        if (userIdCard != null) {
            stmt.bindString(15, userIdCard);
        }
        String userPhone = entity.getUserPhone();
        if (userPhone != null) {
            stmt.bindString(16, userPhone);
        }
        String userAddress = entity.getUserAddress();
        if (userAddress != null) {
            stmt.bindString(17, userAddress);
        }
        String policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindString(18, policeCheck);
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(19, policeReason);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(20, note);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(21, addUser);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(22, addUserName);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(23, userOrganizationId);
        }
        String userOrgName = entity.getUserOrgName();
        if (userOrgName != null) {
            stmt.bindString(24, userOrgName);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(25, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(26, latitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(27, locationDescription);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public LocalPersonnelIdResEntity readEntity(Cursor cursor, int offset) {
        return new LocalPersonnelIdResEntity(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), cursor.isNull(offset + 24) ? null : Double.valueOf(cursor.getDouble(offset + 24)), cursor.isNull(offset + 25) ? null : Double.valueOf(cursor.getDouble(offset + 25)), cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
    }

    public void readEntity(Cursor cursor, LocalPersonnelIdResEntity entity, int offset) {
        String str = null;
        entity.setLocalID(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLocalFkPim(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setIsMatch(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDeadTrackReason(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIsInbound(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setEnterTime(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setEnterWay(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setOtherEnterWay(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setLeaveReason(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setOtherLeaveReason(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setTrackReason(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setOtherTrackReason(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setUserName(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setUserIdCard(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setUserPhone(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setUserAddress(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setPoliceCheck(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setPoliceReason(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setNote(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setAddUser(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setAddUserName(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setUserOrganizationId(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setUserOrgName(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setLongitude(cursor.isNull(offset + 24) ? null : Double.valueOf(cursor.getDouble(offset + 24)));
        entity.setLatitude(cursor.isNull(offset + 25) ? null : Double.valueOf(cursor.getDouble(offset + 25)));
        if (!cursor.isNull(offset + 26)) {
            str = cursor.getString(offset + 26);
        }
        entity.setLocationDescription(str);
    }

    protected final Long updateKeyAfterInsert(LocalPersonnelIdResEntity entity, long rowId) {
        entity.setLocalID(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(LocalPersonnelIdResEntity entity) {
        if (entity != null) {
            return entity.getLocalID();
        }
        return null;
    }

    public boolean hasKey(LocalPersonnelIdResEntity entity) {
        return entity.getLocalID() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
