package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fec.xjoneproject.ui.supervise.CollectionListFragment;
import com.turui.bank.ocr.Intents.WifiConnect;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class LocalPersonPhoneVisitorEntityDao extends AbstractDao<LocalPersonPhoneVisitorEntity, Long> {
    public static final String TABLENAME = "LOCAL_PERSON_PHONE_VISITOR_ENTITY";

    public static class Properties {
        public static final Property AddTime = new Property(11, String.class, "addTime", false, "ADD_TIME");
        public static final Property AddUser = new Property(9, String.class, "addUser", false, "ADD_USER");
        public static final Property AddUserName = new Property(10, String.class, CollectionListFragment.ADDUSERNAME, false, "ADD_USER_NAME");
        public static final Property Address = new Property(6, String.class, "address", false, "ADDRESS");
        public static final Property CheckFlag = new Property(8, String.class, "checkFlag", false, "CHECK_FLAG");
        public static final Property FkPPM = new Property(2, String.class, "fkPPM", false, "FK_PPM");
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property IdCard = new Property(4, String.class, "idCard", false, "ID_CARD");
        public static final Property Latitude = new Property(18, Double.class, "latitude", false, "LATITUDE");
        public static final Property LocalID = new Property(0, Long.class, "localID", true, "LOCAL_ID");
        public static final Property LocationDescription = new Property(19, String.class, "locationDescription", false, "LOCATION_DESCRIPTION");
        public static final Property Longitude = new Property(17, Double.class, "longitude", false, "LONGITUDE");
        public static final Property Modifier = new Property(14, String.class, "modifier", false, "MODIFIER");
        public static final Property ModifierName = new Property(15, String.class, "modifierName", false, "MODIFIER_NAME");
        public static final Property ModifyTime = new Property(16, String.class, "modifyTime", false, "MODIFY_TIME");
        public static final Property Name = new Property(3, String.class, "name", false, "NAME");
        public static final Property Phone = new Property(5, String.class, "phone", false, "PHONE");
        public static final Property Type = new Property(7, String.class, "type", false, WifiConnect.TYPE);
        public static final Property UserOrgName = new Property(13, String.class, "userOrgName", false, "USER_ORG_NAME");
        public static final Property UserOrganizationId = new Property(12, String.class, "userOrganizationId", false, "USER_ORGANIZATION_ID");
    }

    public LocalPersonPhoneVisitorEntityDao(DaoConfig config) {
        super(config);
    }

    public LocalPersonPhoneVisitorEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"LOCAL_PERSON_PHONE_VISITOR_ENTITY\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"FK_PPM\" TEXT,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"PHONE\" TEXT,\"ADDRESS\" TEXT,\"TYPE\" TEXT,\"CHECK_FLAG\" TEXT,\"ADD_USER\" TEXT,\"ADD_USER_NAME\" TEXT,\"ADD_TIME\" TEXT,\"USER_ORGANIZATION_ID\" TEXT,\"USER_ORG_NAME\" TEXT,\"MODIFIER\" TEXT,\"MODIFIER_NAME\" TEXT,\"MODIFY_TIME\" TEXT,\"LONGITUDE\" REAL,\"LATITUDE\" REAL,\"LOCATION_DESCRIPTION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCAL_PERSON_PHONE_VISITOR_ENTITY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, LocalPersonPhoneVisitorEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        String fkPPM = entity.getFkPPM();
        if (fkPPM != null) {
            stmt.bindString(3, fkPPM);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(5, idCard);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(6, phone);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(7, address);
        }
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(8, type);
        }
        String checkFlag = entity.getCheckFlag();
        if (checkFlag != null) {
            stmt.bindString(9, checkFlag);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(10, addUser);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(11, addUserName);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(12, addTime);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(13, userOrganizationId);
        }
        String userOrgName = entity.getUserOrgName();
        if (userOrgName != null) {
            stmt.bindString(14, userOrgName);
        }
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(15, modifier);
        }
        String modifierName = entity.getModifierName();
        if (modifierName != null) {
            stmt.bindString(16, modifierName);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(17, modifyTime);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(18, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(19, latitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(20, locationDescription);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, LocalPersonPhoneVisitorEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        String fkPPM = entity.getFkPPM();
        if (fkPPM != null) {
            stmt.bindString(3, fkPPM);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(5, idCard);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(6, phone);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(7, address);
        }
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(8, type);
        }
        String checkFlag = entity.getCheckFlag();
        if (checkFlag != null) {
            stmt.bindString(9, checkFlag);
        }
        String addUser = entity.getAddUser();
        if (addUser != null) {
            stmt.bindString(10, addUser);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(11, addUserName);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(12, addTime);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(13, userOrganizationId);
        }
        String userOrgName = entity.getUserOrgName();
        if (userOrgName != null) {
            stmt.bindString(14, userOrgName);
        }
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(15, modifier);
        }
        String modifierName = entity.getModifierName();
        if (modifierName != null) {
            stmt.bindString(16, modifierName);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(17, modifyTime);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(18, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(19, latitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(20, locationDescription);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public LocalPersonPhoneVisitorEntity readEntity(Cursor cursor, int offset) {
        return new LocalPersonPhoneVisitorEntity(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), cursor.isNull(offset + 17) ? null : Double.valueOf(cursor.getDouble(offset + 17)), cursor.isNull(offset + 18) ? null : Double.valueOf(cursor.getDouble(offset + 18)), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
    }

    public void readEntity(Cursor cursor, LocalPersonPhoneVisitorEntity entity, int offset) {
        String str = null;
        entity.setLocalID(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFkPPM(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setIdCard(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPhone(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAddress(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setType(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCheckFlag(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setAddUser(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setAddUserName(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setAddTime(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setUserOrganizationId(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setUserOrgName(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setModifier(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setModifierName(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setModifyTime(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setLongitude(cursor.isNull(offset + 17) ? null : Double.valueOf(cursor.getDouble(offset + 17)));
        entity.setLatitude(cursor.isNull(offset + 18) ? null : Double.valueOf(cursor.getDouble(offset + 18)));
        if (!cursor.isNull(offset + 19)) {
            str = cursor.getString(offset + 19);
        }
        entity.setLocationDescription(str);
    }

    protected final Long updateKeyAfterInsert(LocalPersonPhoneVisitorEntity entity, long rowId) {
        entity.setLocalID(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(LocalPersonPhoneVisitorEntity entity) {
        if (entity != null) {
            return entity.getLocalID();
        }
        return null;
    }

    public boolean hasKey(LocalPersonPhoneVisitorEntity entity) {
        return entity.getLocalID() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
