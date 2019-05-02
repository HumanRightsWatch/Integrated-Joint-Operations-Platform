package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class OutOfPersonInfoDao extends AbstractDao<OutOfPersonInfo, Long> {
    public static final String TABLENAME = "OUT_OF_PERSON_INFO";
    private DaoSession daoSession;

    public static class Properties {
        public static final Property Address = new Property(8, String.class, "address", false, "ADDRESS");
        public static final Property AimCity = new Property(12, String.class, "aimCity", false, "AIM_CITY");
        public static final Property AimDetail = new Property(13, String.class, "aimDetail", false, "AIM_DETAIL");
        public static final Property FkPod = new Property(2, String.class, "fkPod", false, "FK_POD");
        public static final Property FlowPhone = new Property(22, String.class, "flowPhone", false, "FLOW_PHONE");
        public static final Property IdCard = new Property(6, String.class, "idCard", false, "ID_CARD");
        public static final Property InfoType = new Property(1, String.class, "infoType", false, "INFO_TYPE");
        public static final Property Latitude = new Property(18, Double.class, "latitude", false, "LATITUDE");
        public static final Property LeaveReason = new Property(15, String.class, "leaveReason", false, "LEAVE_REASON");
        public static final Property LeaveTime = new Property(9, String.class, "leaveTime", false, "LEAVE_TIME");
        public static final Property LocalId = new Property(0, Long.class, "localId", true, "LOCAL_ID");
        public static final Property LocationDescription = new Property(20, String.class, "locationDescription", false, "LOCATION_DESCRIPTION");
        public static final Property Longitude = new Property(19, Double.class, "longitude", false, "LONGITUDE");
        public static final Property MobilePhone = new Property(7, String.class, "mobilePhone", false, "MOBILE_PHONE");
        public static final Property Name = new Property(5, String.class, "name", false, "NAME");
        public static final Property NoTouchReason = new Property(4, String.class, "noTouchReason", false, "NO_TOUCH_REASON");
        public static final Property OtherTripMode = new Property(11, String.class, "otherTripMode", false, "OTHER_TRIP_MODE");
        public static final Property Photo = new Property(21, String.class, "photo", false, "PHOTO");
        public static final Property PoliceCheck = new Property(17, String.class, "policeCheck", false, "POLICE_CHECK");
        public static final Property ReturnTime = new Property(14, String.class, "returnTime", false, "RETURN_TIME");
        public static final Property SuspecDescription = new Property(16, String.class, "suspecDescription", false, "SUSPEC_DESCRIPTION");
        public static final Property TouchType = new Property(3, Integer.class, "touchType", false, "TOUCH_TYPE");
        public static final Property TripMode = new Property(10, Integer.class, "tripMode", false, "TRIP_MODE");
    }

    public OutOfPersonInfoDao(DaoConfig config) {
        super(config);
    }

    public OutOfPersonInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"OUT_OF_PERSON_INFO\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"INFO_TYPE\" TEXT,\"FK_POD\" TEXT,\"TOUCH_TYPE\" INTEGER,\"NO_TOUCH_REASON\" TEXT,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"MOBILE_PHONE\" TEXT,\"ADDRESS\" TEXT,\"LEAVE_TIME\" TEXT,\"TRIP_MODE\" INTEGER,\"OTHER_TRIP_MODE\" TEXT,\"AIM_CITY\" TEXT,\"AIM_DETAIL\" TEXT,\"RETURN_TIME\" TEXT,\"LEAVE_REASON\" TEXT,\"SUSPEC_DESCRIPTION\" TEXT,\"POLICE_CHECK\" TEXT,\"LATITUDE\" REAL,\"LONGITUDE\" REAL,\"LOCATION_DESCRIPTION\" TEXT,\"PHOTO\" TEXT,\"FLOW_PHONE\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"OUT_OF_PERSON_INFO\"");
    }

    protected final void bindValues(DatabaseStatement stmt, OutOfPersonInfo entity) {
        stmt.clearBindings();
        Long localId = entity.getLocalId();
        if (localId != null) {
            stmt.bindLong(1, localId.longValue());
        }
        String infoType = entity.getInfoType();
        if (infoType != null) {
            stmt.bindString(2, infoType);
        }
        String fkPod = entity.getFkPod();
        if (fkPod != null) {
            stmt.bindString(3, fkPod);
        }
        Integer touchType = entity.getTouchType();
        if (touchType != null) {
            stmt.bindLong(4, (long) touchType.intValue());
        }
        String noTouchReason = entity.getNoTouchReason();
        if (noTouchReason != null) {
            stmt.bindString(5, noTouchReason);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(7, idCard);
        }
        String mobilePhone = entity.getMobilePhone();
        if (mobilePhone != null) {
            stmt.bindString(8, mobilePhone);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(9, address);
        }
        String leaveTime = entity.getLeaveTime();
        if (leaveTime != null) {
            stmt.bindString(10, leaveTime);
        }
        Integer tripMode = entity.getTripMode();
        if (tripMode != null) {
            stmt.bindLong(11, (long) tripMode.intValue());
        }
        String otherTripMode = entity.getOtherTripMode();
        if (otherTripMode != null) {
            stmt.bindString(12, otherTripMode);
        }
        String aimCity = entity.getAimCity();
        if (aimCity != null) {
            stmt.bindString(13, aimCity);
        }
        String aimDetail = entity.getAimDetail();
        if (aimDetail != null) {
            stmt.bindString(14, aimDetail);
        }
        String returnTime = entity.getReturnTime();
        if (returnTime != null) {
            stmt.bindString(15, returnTime);
        }
        String leaveReason = entity.getLeaveReason();
        if (leaveReason != null) {
            stmt.bindString(16, leaveReason);
        }
        String suspecDescription = entity.getSuspecDescription();
        if (suspecDescription != null) {
            stmt.bindString(17, suspecDescription);
        }
        String policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindString(18, policeCheck);
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(19, latitude.doubleValue());
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(20, longitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(21, locationDescription);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(22, photo);
        }
        String flowPhone = entity.getFlowPhone();
        if (flowPhone != null) {
            stmt.bindString(23, flowPhone);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, OutOfPersonInfo entity) {
        stmt.clearBindings();
        Long localId = entity.getLocalId();
        if (localId != null) {
            stmt.bindLong(1, localId.longValue());
        }
        String infoType = entity.getInfoType();
        if (infoType != null) {
            stmt.bindString(2, infoType);
        }
        String fkPod = entity.getFkPod();
        if (fkPod != null) {
            stmt.bindString(3, fkPod);
        }
        Integer touchType = entity.getTouchType();
        if (touchType != null) {
            stmt.bindLong(4, (long) touchType.intValue());
        }
        String noTouchReason = entity.getNoTouchReason();
        if (noTouchReason != null) {
            stmt.bindString(5, noTouchReason);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(7, idCard);
        }
        String mobilePhone = entity.getMobilePhone();
        if (mobilePhone != null) {
            stmt.bindString(8, mobilePhone);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(9, address);
        }
        String leaveTime = entity.getLeaveTime();
        if (leaveTime != null) {
            stmt.bindString(10, leaveTime);
        }
        Integer tripMode = entity.getTripMode();
        if (tripMode != null) {
            stmt.bindLong(11, (long) tripMode.intValue());
        }
        String otherTripMode = entity.getOtherTripMode();
        if (otherTripMode != null) {
            stmt.bindString(12, otherTripMode);
        }
        String aimCity = entity.getAimCity();
        if (aimCity != null) {
            stmt.bindString(13, aimCity);
        }
        String aimDetail = entity.getAimDetail();
        if (aimDetail != null) {
            stmt.bindString(14, aimDetail);
        }
        String returnTime = entity.getReturnTime();
        if (returnTime != null) {
            stmt.bindString(15, returnTime);
        }
        String leaveReason = entity.getLeaveReason();
        if (leaveReason != null) {
            stmt.bindString(16, leaveReason);
        }
        String suspecDescription = entity.getSuspecDescription();
        if (suspecDescription != null) {
            stmt.bindString(17, suspecDescription);
        }
        String policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindString(18, policeCheck);
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(19, latitude.doubleValue());
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(20, longitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(21, locationDescription);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(22, photo);
        }
        String flowPhone = entity.getFlowPhone();
        if (flowPhone != null) {
            stmt.bindString(23, flowPhone);
        }
    }

    protected final void attachEntity(OutOfPersonInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(this.daoSession);
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public OutOfPersonInfo readEntity(Cursor cursor, int offset) {
        return new OutOfPersonInfo(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : Integer.valueOf(cursor.getInt(offset + 10)), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : Double.valueOf(cursor.getDouble(offset + 18)), cursor.isNull(offset + 19) ? null : Double.valueOf(cursor.getDouble(offset + 19)), cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
    }

    public void readEntity(Cursor cursor, OutOfPersonInfo entity, int offset) {
        String str = null;
        entity.setLocalId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setInfoType(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFkPod(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTouchType(cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)));
        entity.setNoTouchReason(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setIdCard(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMobilePhone(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setAddress(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setLeaveTime(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setTripMode(cursor.isNull(offset + 10) ? null : Integer.valueOf(cursor.getInt(offset + 10)));
        entity.setOtherTripMode(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setAimCity(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setAimDetail(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setReturnTime(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setLeaveReason(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setSuspecDescription(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setPoliceCheck(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setLatitude(cursor.isNull(offset + 18) ? null : Double.valueOf(cursor.getDouble(offset + 18)));
        entity.setLongitude(cursor.isNull(offset + 19) ? null : Double.valueOf(cursor.getDouble(offset + 19)));
        entity.setLocationDescription(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setPhoto(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        if (!cursor.isNull(offset + 22)) {
            str = cursor.getString(offset + 22);
        }
        entity.setFlowPhone(str);
    }

    protected final Long updateKeyAfterInsert(OutOfPersonInfo entity, long rowId) {
        entity.setLocalId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(OutOfPersonInfo entity) {
        if (entity != null) {
            return entity.getLocalId();
        }
        return null;
    }

    public boolean hasKey(OutOfPersonInfo entity) {
        return entity.getLocalId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
