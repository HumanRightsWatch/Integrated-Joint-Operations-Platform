package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fec.xjoneproject.ui.supervise.CollectionListFragment;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class LocalNoIdCardTrackResEntityDao extends AbstractDao<LocalNoIdCardTrackResEntity, Long> {
    public static final String TABLENAME = "LOCAL_NO_ID_CARD_TRACK_RES_ENTITY";

    public static class Properties {
        public static final Property AddTime = new Property(16, String.class, "addTime", false, "ADD_TIME");
        public static final Property AddUser = new Property(14, String.class, "addUser", false, "ADD_USER");
        public static final Property AddUserName = new Property(15, String.class, CollectionListFragment.ADDUSERNAME, false, "ADD_USER_NAME");
        public static final Property Expression = new Property(9, Integer.class, "expression", false, "EXPRESSION");
        public static final Property ExpressionDesc = new Property(10, String.class, "expressionDesc", false, "EXPRESSION_DESC");
        public static final Property FkMitv = new Property(3, String.class, "fkMitv", false, "FK_MITV");
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property Latitude = new Property(23, Double.class, "latitude", false, "LATITUDE");
        public static final Property LocalFkMitv = new Property(2, Long.class, "localFkMitv", false, "LOCAL_FK_MITV");
        public static final Property LocalID = new Property(0, Long.class, "localID", true, "LOCAL_ID");
        public static final Property LocationDescription = new Property(24, String.class, "locationDescription", false, "LOCATION_DESCRIPTION");
        public static final Property Longitude = new Property(22, Double.class, "longitude", false, "LONGITUDE");
        public static final Property MissTrailReason = new Property(5, Integer.class, "missTrailReason", false, "MISS_TRAIL_REASON");
        public static final Property Modifier = new Property(19, String.class, "modifier", false, "MODIFIER");
        public static final Property ModifierName = new Property(20, String.class, "modifierName", false, "MODIFIER_NAME");
        public static final Property ModifyTime = new Property(21, String.class, "modifyTime", false, "MODIFY_TIME");
        public static final Property Note = new Property(13, String.class, "note", false, "NOTE");
        public static final Property OtherReason = new Property(6, String.class, "otherReason", false, "OTHER_REASON");
        public static final Property PoliceCheck = new Property(11, String.class, "policeCheck", false, "POLICE_CHECK");
        public static final Property PoliceReason = new Property(12, String.class, "policeReason", false, "POLICE_REASON");
        public static final Property Profession = new Property(8, String.class, "profession", false, "PROFESSION");
        public static final Property Relationship = new Property(4, Integer.class, "relationship", false, "RELATIONSHIP");
        public static final Property TelNumber = new Property(7, String.class, "telNumber", false, "TEL_NUMBER");
        public static final Property UserOrgName = new Property(18, String.class, "userOrgName", false, "USER_ORG_NAME");
        public static final Property UserOrganizationId = new Property(17, String.class, "userOrganizationId", false, "USER_ORGANIZATION_ID");
    }

    public LocalNoIdCardTrackResEntityDao(DaoConfig config) {
        super(config);
    }

    public LocalNoIdCardTrackResEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"LOCAL_NO_ID_CARD_TRACK_RES_ENTITY\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"LOCAL_FK_MITV\" INTEGER,\"FK_MITV\" TEXT,\"RELATIONSHIP\" INTEGER,\"MISS_TRAIL_REASON\" INTEGER,\"OTHER_REASON\" TEXT,\"TEL_NUMBER\" TEXT,\"PROFESSION\" TEXT,\"EXPRESSION\" INTEGER,\"EXPRESSION_DESC\" TEXT,\"POLICE_CHECK\" TEXT,\"POLICE_REASON\" TEXT,\"NOTE\" TEXT,\"ADD_USER\" TEXT,\"ADD_USER_NAME\" TEXT,\"ADD_TIME\" TEXT,\"USER_ORGANIZATION_ID\" TEXT,\"USER_ORG_NAME\" TEXT,\"MODIFIER\" TEXT,\"MODIFIER_NAME\" TEXT,\"MODIFY_TIME\" TEXT,\"LONGITUDE\" REAL,\"LATITUDE\" REAL,\"LOCATION_DESCRIPTION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCAL_NO_ID_CARD_TRACK_RES_ENTITY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, LocalNoIdCardTrackResEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        Long localFkMitv = entity.getLocalFkMitv();
        if (localFkMitv != null) {
            stmt.bindLong(3, localFkMitv.longValue());
        }
        String fkMitv = entity.getFkMitv();
        if (fkMitv != null) {
            stmt.bindString(4, fkMitv);
        }
        Integer relationship = entity.getRelationship();
        if (relationship != null) {
            stmt.bindLong(5, (long) relationship.intValue());
        }
        Integer missTrailReason = entity.getMissTrailReason();
        if (missTrailReason != null) {
            stmt.bindLong(6, (long) missTrailReason.intValue());
        }
        String otherReason = entity.getOtherReason();
        if (otherReason != null) {
            stmt.bindString(7, otherReason);
        }
        String telNumber = entity.getTelNumber();
        if (telNumber != null) {
            stmt.bindString(8, telNumber);
        }
        String profession = entity.getProfession();
        if (profession != null) {
            stmt.bindString(9, profession);
        }
        Integer expression = entity.getExpression();
        if (expression != null) {
            stmt.bindLong(10, (long) expression.intValue());
        }
        String expressionDesc = entity.getExpressionDesc();
        if (expressionDesc != null) {
            stmt.bindString(11, expressionDesc);
        }
        String policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindString(12, policeCheck);
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(13, policeReason);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(14, note);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(15, addUser);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(16, addUserName);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(17, addTime);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(18, userOrganizationId);
        }
        String userOrgName = entity.getUserOrgName();
        if (userOrgName != null) {
            stmt.bindString(19, userOrgName);
        }
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(20, modifier);
        }
        String modifierName = entity.getModifierName();
        if (modifierName != null) {
            stmt.bindString(21, modifierName);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(22, modifyTime);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(23, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(24, latitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(25, locationDescription);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, LocalNoIdCardTrackResEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        Long localFkMitv = entity.getLocalFkMitv();
        if (localFkMitv != null) {
            stmt.bindLong(3, localFkMitv.longValue());
        }
        String fkMitv = entity.getFkMitv();
        if (fkMitv != null) {
            stmt.bindString(4, fkMitv);
        }
        Integer relationship = entity.getRelationship();
        if (relationship != null) {
            stmt.bindLong(5, (long) relationship.intValue());
        }
        Integer missTrailReason = entity.getMissTrailReason();
        if (missTrailReason != null) {
            stmt.bindLong(6, (long) missTrailReason.intValue());
        }
        String otherReason = entity.getOtherReason();
        if (otherReason != null) {
            stmt.bindString(7, otherReason);
        }
        String telNumber = entity.getTelNumber();
        if (telNumber != null) {
            stmt.bindString(8, telNumber);
        }
        String profession = entity.getProfession();
        if (profession != null) {
            stmt.bindString(9, profession);
        }
        Integer expression = entity.getExpression();
        if (expression != null) {
            stmt.bindLong(10, (long) expression.intValue());
        }
        String expressionDesc = entity.getExpressionDesc();
        if (expressionDesc != null) {
            stmt.bindString(11, expressionDesc);
        }
        String policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindString(12, policeCheck);
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(13, policeReason);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(14, note);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(15, addUser);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(16, addUserName);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(17, addTime);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(18, userOrganizationId);
        }
        String userOrgName = entity.getUserOrgName();
        if (userOrgName != null) {
            stmt.bindString(19, userOrgName);
        }
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(20, modifier);
        }
        String modifierName = entity.getModifierName();
        if (modifierName != null) {
            stmt.bindString(21, modifierName);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(22, modifyTime);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(23, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(24, latitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(25, locationDescription);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public LocalNoIdCardTrackResEntity readEntity(Cursor cursor, int offset) {
        return new LocalNoIdCardTrackResEntity(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)), cursor.isNull(offset + 5) ? null : Integer.valueOf(cursor.getInt(offset + 5)), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : Integer.valueOf(cursor.getInt(offset + 9)), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), cursor.isNull(offset + 22) ? null : Double.valueOf(cursor.getDouble(offset + 22)), cursor.isNull(offset + 23) ? null : Double.valueOf(cursor.getDouble(offset + 23)), cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
    }

    public void readEntity(Cursor cursor, LocalNoIdCardTrackResEntity entity, int offset) {
        String str = null;
        entity.setLocalID(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLocalFkMitv(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setFkMitv(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setRelationship(cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)));
        entity.setMissTrailReason(cursor.isNull(offset + 5) ? null : Integer.valueOf(cursor.getInt(offset + 5)));
        entity.setOtherReason(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setTelNumber(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setProfession(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setExpression(cursor.isNull(offset + 9) ? null : Integer.valueOf(cursor.getInt(offset + 9)));
        entity.setExpressionDesc(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setPoliceCheck(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setPoliceReason(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setNote(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setAddUser(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setAddUserName(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setAddTime(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setUserOrganizationId(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setUserOrgName(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setModifier(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setModifierName(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setModifyTime(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setLongitude(cursor.isNull(offset + 22) ? null : Double.valueOf(cursor.getDouble(offset + 22)));
        entity.setLatitude(cursor.isNull(offset + 23) ? null : Double.valueOf(cursor.getDouble(offset + 23)));
        if (!cursor.isNull(offset + 24)) {
            str = cursor.getString(offset + 24);
        }
        entity.setLocationDescription(str);
    }

    protected final Long updateKeyAfterInsert(LocalNoIdCardTrackResEntity entity, long rowId) {
        entity.setLocalID(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(LocalNoIdCardTrackResEntity entity) {
        if (entity != null) {
            return entity.getLocalID();
        }
        return null;
    }

    public boolean hasKey(LocalNoIdCardTrackResEntity entity) {
        return entity.getLocalID() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
