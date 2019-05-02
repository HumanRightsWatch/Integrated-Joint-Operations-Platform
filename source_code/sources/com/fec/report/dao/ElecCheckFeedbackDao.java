package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class ElecCheckFeedbackDao extends AbstractDao<ElecCheckFeedback, String> {
    public static final String TABLENAME = "ELEC_CHECK_FEEDBACK";

    public static class Properties {
        public static final Property AddTime = new Property(15, String.class, "addTime", false, "ADD_TIME");
        public static final Property AddUser = new Property(13, String.class, "addUser", false, "ADD_USER");
        public static final Property Addr = new Property(5, String.class, "addr", false, "ADDR");
        public static final Property CheckMissionId = new Property(1, String.class, "checkMissionId", false, "CHECK_MISSION_ID");
        public static final Property FkPw = new Property(2, String.class, "fkPw", false, "FK_PW");
        public static final Property Id = new Property(0, String.class, "id", true, "ID");
        public static final Property IdCard = new Property(3, String.class, "idCard", false, "ID_CARD");
        public static final Property IsSuspicious = new Property(17, String.class, "isSuspicious", false, "IS_SUSPICIOUS");
        public static final Property Latitude = new Property(11, Double.class, "latitude", false, "LATITUDE");
        public static final Property LocationDescription = new Property(19, String.class, "locationDescription", false, "LOCATION_DESCRIPTION");
        public static final Property Longitude = new Property(10, Double.class, "longitude", false, "LONGITUDE");
        public static final Property ModifyTime = new Property(16, String.class, "modifyTime", false, "MODIFY_TIME");
        public static final Property Note = new Property(12, String.class, "note", false, "NOTE");
        public static final Property Phone = new Property(4, String.class, "phone", false, "PHONE");
        public static final Property PolicCheck = new Property(9, String.class, "policCheck", false, "POLIC_CHECK");
        public static final Property PoliceReason = new Property(18, String.class, "policeReason", false, "POLICE_REASON");
        public static final Property Reson = new Property(8, String.class, "reson", false, "RESON");
        public static final Property ResonType = new Property(7, String.class, "resonType", false, "RESON_TYPE");
        public static final Property Tool = new Property(6, String.class, "tool", false, "TOOL");
        public static final Property UserOrganizationId = new Property(14, String.class, "userOrganizationId", false, "USER_ORGANIZATION_ID");
    }

    public ElecCheckFeedbackDao(DaoConfig config) {
        super(config);
    }

    public ElecCheckFeedbackDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"ELEC_CHECK_FEEDBACK\" (\"ID\" TEXT PRIMARY KEY NOT NULL ,\"CHECK_MISSION_ID\" TEXT,\"FK_PW\" TEXT,\"ID_CARD\" TEXT,\"PHONE\" TEXT,\"ADDR\" TEXT,\"TOOL\" TEXT,\"RESON_TYPE\" TEXT,\"RESON\" TEXT,\"POLIC_CHECK\" TEXT,\"LONGITUDE\" REAL,\"LATITUDE\" REAL,\"NOTE\" TEXT,\"ADD_USER\" TEXT,\"USER_ORGANIZATION_ID\" TEXT,\"ADD_TIME\" TEXT,\"MODIFY_TIME\" TEXT,\"IS_SUSPICIOUS\" TEXT,\"POLICE_REASON\" TEXT,\"LOCATION_DESCRIPTION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ELEC_CHECK_FEEDBACK\"");
    }

    protected final void bindValues(DatabaseStatement stmt, ElecCheckFeedback entity) {
        stmt.clearBindings();
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
        String checkMissionId = entity.getCheckMissionId();
        if (checkMissionId != null) {
            stmt.bindString(2, checkMissionId);
        }
        String fkPw = entity.getFkPw();
        if (fkPw != null) {
            stmt.bindString(3, fkPw);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(4, idCard);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        String addr = entity.getAddr();
        if (addr != null) {
            stmt.bindString(6, addr);
        }
        String tool = entity.getTool();
        if (tool != null) {
            stmt.bindString(7, tool);
        }
        String resonType = entity.getResonType();
        if (resonType != null) {
            stmt.bindString(8, resonType);
        }
        String reson = entity.getReson();
        if (reson != null) {
            stmt.bindString(9, reson);
        }
        String policCheck = entity.getPolicCheck();
        if (policCheck != null) {
            stmt.bindString(10, policCheck);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(11, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(12, latitude.doubleValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(13, note);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(14, addUser);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(15, userOrganizationId);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(16, addTime);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(17, modifyTime);
        }
        String isSuspicious = entity.getIsSuspicious();
        if (isSuspicious != null) {
            stmt.bindString(18, isSuspicious);
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(19, policeReason);
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(20, locationDescription);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, ElecCheckFeedback entity) {
        stmt.clearBindings();
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
        String checkMissionId = entity.getCheckMissionId();
        if (checkMissionId != null) {
            stmt.bindString(2, checkMissionId);
        }
        String fkPw = entity.getFkPw();
        if (fkPw != null) {
            stmt.bindString(3, fkPw);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(4, idCard);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        String addr = entity.getAddr();
        if (addr != null) {
            stmt.bindString(6, addr);
        }
        String tool = entity.getTool();
        if (tool != null) {
            stmt.bindString(7, tool);
        }
        String resonType = entity.getResonType();
        if (resonType != null) {
            stmt.bindString(8, resonType);
        }
        String reson = entity.getReson();
        if (reson != null) {
            stmt.bindString(9, reson);
        }
        String policCheck = entity.getPolicCheck();
        if (policCheck != null) {
            stmt.bindString(10, policCheck);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(11, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(12, latitude.doubleValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(13, note);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(14, addUser);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(15, userOrganizationId);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(16, addTime);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(17, modifyTime);
        }
        String isSuspicious = entity.getIsSuspicious();
        if (isSuspicious != null) {
            stmt.bindString(18, isSuspicious);
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(19, policeReason);
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(20, locationDescription);
        }
    }

    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    public ElecCheckFeedback readEntity(Cursor cursor, int offset) {
        return new ElecCheckFeedback(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : Double.valueOf(cursor.getDouble(offset + 10)), cursor.isNull(offset + 11) ? null : Double.valueOf(cursor.getDouble(offset + 11)), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
    }

    public void readEntity(Cursor cursor, ElecCheckFeedback entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCheckMissionId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFkPw(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIdCard(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhone(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAddr(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTool(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setResonType(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setReson(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPolicCheck(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setLongitude(cursor.isNull(offset + 10) ? null : Double.valueOf(cursor.getDouble(offset + 10)));
        entity.setLatitude(cursor.isNull(offset + 11) ? null : Double.valueOf(cursor.getDouble(offset + 11)));
        entity.setNote(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setAddUser(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setUserOrganizationId(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setAddTime(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setModifyTime(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setIsSuspicious(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setPoliceReason(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        if (!cursor.isNull(offset + 19)) {
            str = cursor.getString(offset + 19);
        }
        entity.setLocationDescription(str);
    }

    protected final String updateKeyAfterInsert(ElecCheckFeedback entity, long rowId) {
        return entity.getId();
    }

    public String getKey(ElecCheckFeedback entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(ElecCheckFeedback entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
