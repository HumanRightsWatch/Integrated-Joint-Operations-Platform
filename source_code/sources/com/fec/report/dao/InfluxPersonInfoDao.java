package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fec.xjoneproject.ui.supervise.CollectionListFragment;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class InfluxPersonInfoDao extends AbstractDao<InfluxPersonInfo, Long> {
    public static final String TABLENAME = "INFLUX_PERSON_INFO";
    private DaoSession daoSession;

    public static class Properties {
        public static final Property AddTime = new Property(18, String.class, "addTime", false, "ADD_TIME");
        public static final Property AddUser = new Property(16, String.class, "addUser", false, "ADD_USER");
        public static final Property AddUserName = new Property(17, String.class, CollectionListFragment.ADDUSERNAME, false, "ADD_USER_NAME");
        public static final Property ContactAddress = new Property(12, String.class, "contactAddress", false, "CONTACT_ADDRESS");
        public static final Property ContactDetail = new Property(6, Integer.class, "contactDetail", false, "CONTACT_DETAIL");
        public static final Property ContactIDCard = new Property(10, String.class, "contactIDCard", false, "CONTACT_IDCARD");
        public static final Property ContactMobile = new Property(11, String.class, "contactMobile", false, "CONTACT_MOBILE");
        public static final Property ContactName = new Property(9, String.class, "contactName", false, "CONTACT_NAME");
        public static final Property EnterReason = new Property(5, String.class, "enterReason", false, "ENTER_REASON");
        public static final Property EnterTime = new Property(2, String.class, "enterTime", false, "ENTER_TIME");
        public static final Property FkPoi = new Property(1, String.class, "fkPoi", false, "FK_POI");
        public static final Property Latitude = new Property(19, Double.class, "latitude", false, "LATITUDE");
        public static final Property LeaveTime = new Property(4, String.class, "leaveTime", false, "LEAVE_TIME");
        public static final Property LocalId = new Property(0, Long.class, "localId", true, "LOCAL_ID");
        public static final Property LocationDescription = new Property(21, String.class, "locationDescription", false, "LOCATION_DESCRIPTION");
        public static final Property Longitude = new Property(20, Double.class, "longitude", false, "LONGITUDE");
        public static final Property NoContactReason = new Property(7, String.class, "noContactReason", false, "NO_CONTACT_REASON");
        public static final Property PoliceCheck = new Property(14, Integer.class, "policeCheck", false, "POLICE_CHECK");
        public static final Property SubmitScenePicture = new Property(15, String.class, "submitScenePicture", false, "SUBMIT_SCENE_PICTURE");
        public static final Property SuspecDescription = new Property(13, String.class, "suspecDescription", false, "SUSPEC_DESCRIPTION");
        public static final Property TemStayAddress = new Property(8, String.class, "temStayAddress", false, "TEM_STAY_ADDRESS");
        public static final Property TripMode = new Property(3, Integer.class, "tripMode", false, "TRIP_MODE");
    }

    public InfluxPersonInfoDao(DaoConfig config) {
        super(config);
    }

    public InfluxPersonInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"INFLUX_PERSON_INFO\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"FK_POI\" TEXT,\"ENTER_TIME\" TEXT,\"TRIP_MODE\" INTEGER,\"LEAVE_TIME\" TEXT,\"ENTER_REASON\" TEXT,\"CONTACT_DETAIL\" INTEGER,\"NO_CONTACT_REASON\" TEXT,\"TEM_STAY_ADDRESS\" TEXT,\"CONTACT_NAME\" TEXT,\"CONTACT_IDCARD\" TEXT,\"CONTACT_MOBILE\" TEXT,\"CONTACT_ADDRESS\" TEXT,\"SUSPEC_DESCRIPTION\" TEXT,\"POLICE_CHECK\" INTEGER,\"SUBMIT_SCENE_PICTURE\" TEXT,\"ADD_USER\" TEXT,\"ADD_USER_NAME\" TEXT,\"ADD_TIME\" TEXT,\"LATITUDE\" REAL,\"LONGITUDE\" REAL,\"LOCATION_DESCRIPTION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"INFLUX_PERSON_INFO\"");
    }

    protected final void bindValues(DatabaseStatement stmt, InfluxPersonInfo entity) {
        stmt.clearBindings();
        Long localId = entity.getLocalId();
        if (localId != null) {
            stmt.bindLong(1, localId.longValue());
        }
        String fkPoi = entity.getFkPoi();
        if (fkPoi != null) {
            stmt.bindString(2, fkPoi);
        }
        String enterTime = entity.getEnterTime();
        if (enterTime != null) {
            stmt.bindString(3, enterTime);
        }
        Integer tripMode = entity.getTripMode();
        if (tripMode != null) {
            stmt.bindLong(4, (long) tripMode.intValue());
        }
        String leaveTime = entity.getLeaveTime();
        if (leaveTime != null) {
            stmt.bindString(5, leaveTime);
        }
        String enterReason = entity.getEnterReason();
        if (enterReason != null) {
            stmt.bindString(6, enterReason);
        }
        Integer contactDetail = entity.getContactDetail();
        if (contactDetail != null) {
            stmt.bindLong(7, (long) contactDetail.intValue());
        }
        String noContactReason = entity.getNoContactReason();
        if (noContactReason != null) {
            stmt.bindString(8, noContactReason);
        }
        String temStayAddress = entity.getTemStayAddress();
        if (temStayAddress != null) {
            stmt.bindString(9, temStayAddress);
        }
        String contactName = entity.getContactName();
        if (contactName != null) {
            stmt.bindString(10, contactName);
        }
        String contactIDCard = entity.getContactIDCard();
        if (contactIDCard != null) {
            stmt.bindString(11, contactIDCard);
        }
        String contactMobile = entity.getContactMobile();
        if (contactMobile != null) {
            stmt.bindString(12, contactMobile);
        }
        String contactAddress = entity.getContactAddress();
        if (contactAddress != null) {
            stmt.bindString(13, contactAddress);
        }
        String suspecDescription = entity.getSuspecDescription();
        if (suspecDescription != null) {
            stmt.bindString(14, suspecDescription);
        }
        Integer policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindLong(15, (long) policeCheck.intValue());
        }
        String submitScenePicture = entity.getSubmitScenePicture();
        if (submitScenePicture != null) {
            stmt.bindString(16, submitScenePicture);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(17, addUser);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(18, addUserName);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(19, addTime);
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(20, latitude.doubleValue());
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(21, longitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(22, locationDescription);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, InfluxPersonInfo entity) {
        stmt.clearBindings();
        Long localId = entity.getLocalId();
        if (localId != null) {
            stmt.bindLong(1, localId.longValue());
        }
        String fkPoi = entity.getFkPoi();
        if (fkPoi != null) {
            stmt.bindString(2, fkPoi);
        }
        String enterTime = entity.getEnterTime();
        if (enterTime != null) {
            stmt.bindString(3, enterTime);
        }
        Integer tripMode = entity.getTripMode();
        if (tripMode != null) {
            stmt.bindLong(4, (long) tripMode.intValue());
        }
        String leaveTime = entity.getLeaveTime();
        if (leaveTime != null) {
            stmt.bindString(5, leaveTime);
        }
        String enterReason = entity.getEnterReason();
        if (enterReason != null) {
            stmt.bindString(6, enterReason);
        }
        Integer contactDetail = entity.getContactDetail();
        if (contactDetail != null) {
            stmt.bindLong(7, (long) contactDetail.intValue());
        }
        String noContactReason = entity.getNoContactReason();
        if (noContactReason != null) {
            stmt.bindString(8, noContactReason);
        }
        String temStayAddress = entity.getTemStayAddress();
        if (temStayAddress != null) {
            stmt.bindString(9, temStayAddress);
        }
        String contactName = entity.getContactName();
        if (contactName != null) {
            stmt.bindString(10, contactName);
        }
        String contactIDCard = entity.getContactIDCard();
        if (contactIDCard != null) {
            stmt.bindString(11, contactIDCard);
        }
        String contactMobile = entity.getContactMobile();
        if (contactMobile != null) {
            stmt.bindString(12, contactMobile);
        }
        String contactAddress = entity.getContactAddress();
        if (contactAddress != null) {
            stmt.bindString(13, contactAddress);
        }
        String suspecDescription = entity.getSuspecDescription();
        if (suspecDescription != null) {
            stmt.bindString(14, suspecDescription);
        }
        Integer policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindLong(15, (long) policeCheck.intValue());
        }
        String submitScenePicture = entity.getSubmitScenePicture();
        if (submitScenePicture != null) {
            stmt.bindString(16, submitScenePicture);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(17, addUser);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(18, addUserName);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(19, addTime);
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(20, latitude.doubleValue());
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(21, longitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(22, locationDescription);
        }
    }

    protected final void attachEntity(InfluxPersonInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(this.daoSession);
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public InfluxPersonInfo readEntity(Cursor cursor, int offset) {
        return new InfluxPersonInfo(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : Integer.valueOf(cursor.getInt(offset + 14)), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : Double.valueOf(cursor.getDouble(offset + 19)), cursor.isNull(offset + 20) ? null : Double.valueOf(cursor.getDouble(offset + 20)), cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
    }

    public void readEntity(Cursor cursor, InfluxPersonInfo entity, int offset) {
        String str = null;
        entity.setLocalId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setFkPoi(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setEnterTime(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTripMode(cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)));
        entity.setLeaveTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setEnterReason(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setContactDetail(cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)));
        entity.setNoContactReason(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setTemStayAddress(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setContactName(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setContactIDCard(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setContactMobile(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setContactAddress(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setSuspecDescription(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setPoliceCheck(cursor.isNull(offset + 14) ? null : Integer.valueOf(cursor.getInt(offset + 14)));
        entity.setSubmitScenePicture(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setAddUser(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setAddUserName(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setAddTime(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setLatitude(cursor.isNull(offset + 19) ? null : Double.valueOf(cursor.getDouble(offset + 19)));
        entity.setLongitude(cursor.isNull(offset + 20) ? null : Double.valueOf(cursor.getDouble(offset + 20)));
        if (!cursor.isNull(offset + 21)) {
            str = cursor.getString(offset + 21);
        }
        entity.setLocationDescription(str);
    }

    protected final Long updateKeyAfterInsert(InfluxPersonInfo entity, long rowId) {
        entity.setLocalId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(InfluxPersonInfo entity) {
        if (entity != null) {
            return entity.getLocalId();
        }
        return null;
    }

    public boolean hasKey(InfluxPersonInfo entity) {
        return entity.getLocalId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
