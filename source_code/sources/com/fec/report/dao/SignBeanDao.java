package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hms.support.api.entity.hwid.HwIDConstant.Req_access_token_parm;
import com.turui.bank.ocr.Intents.WifiConnect;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class SignBeanDao extends AbstractDao<SignBean, Long> {
    public static final String TABLENAME = "SIGN_BEAN";

    public static class Properties {
        public static final Property Datetime = new Property(4, String.class, "datetime", false, "DATETIME");
        public static final Property Dept = new Property(3, String.class, "dept", false, "DEPT");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Lang = new Property(7, String.class, Req_access_token_parm.LANGUAGE_LABEL, false, "LANG");
        public static final Property Lat = new Property(8, String.class, "lat", false, "LAT");
        public static final Property Latitude1 = new Property(14, String.class, "latitude1", false, "LATITUDE1");
        public static final Property Location = new Property(6, String.class, "location", false, "LOCATION");
        public static final Property LocationDescription = new Property(10, String.class, "locationDescription", false, "LOCATION_DESCRIPTION");
        public static final Property Longitude1 = new Property(13, String.class, "longitude1", false, "LONGITUDE1");
        public static final Property Name = new Property(1, String.class, "name", false, "NAME");
        public static final Property Note = new Property(11, String.class, "note", false, "NOTE");
        public static final Property PreinstallLocation = new Property(12, String.class, "preinstallLocation", false, "PREINSTALL_LOCATION");
        public static final Property Type = new Property(5, String.class, "type", false, WifiConnect.TYPE);
        public static final Property UcId = new Property(2, String.class, "ucId", false, "UC_ID");
        public static final Property UserOrganizationId = new Property(9, String.class, "userOrganizationId", false, "USER_ORGANIZATION_ID");
    }

    public SignBeanDao(DaoConfig config) {
        super(config);
    }

    public SignBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"SIGN_BEAN\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"NAME\" TEXT,\"UC_ID\" TEXT,\"DEPT\" TEXT,\"DATETIME\" TEXT,\"TYPE\" TEXT,\"LOCATION\" TEXT,\"LANG\" TEXT,\"LAT\" TEXT,\"USER_ORGANIZATION_ID\" TEXT,\"LOCATION_DESCRIPTION\" TEXT,\"NOTE\" TEXT,\"PREINSTALL_LOCATION\" TEXT,\"LONGITUDE1\" TEXT,\"LATITUDE1\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SIGN_BEAN\"");
    }

    protected final void bindValues(DatabaseStatement stmt, SignBean entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        String ucId = entity.getUcId();
        if (ucId != null) {
            stmt.bindString(3, ucId);
        }
        String dept = entity.getDept();
        if (dept != null) {
            stmt.bindString(4, dept);
        }
        String datetime = entity.getDatetime();
        if (datetime != null) {
            stmt.bindString(5, datetime);
        }
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(6, type);
        }
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(7, location);
        }
        String lang = entity.getLang();
        if (lang != null) {
            stmt.bindString(8, lang);
        }
        String lat = entity.getLat();
        if (lat != null) {
            stmt.bindString(9, lat);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(10, userOrganizationId);
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(11, locationDescription);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(12, note);
        }
        String preinstallLocation = entity.getPreinstallLocation();
        if (preinstallLocation != null) {
            stmt.bindString(13, preinstallLocation);
        }
        String longitude1 = entity.getLongitude1();
        if (longitude1 != null) {
            stmt.bindString(14, longitude1);
        }
        String latitude1 = entity.getLatitude1();
        if (latitude1 != null) {
            stmt.bindString(15, latitude1);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, SignBean entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        String ucId = entity.getUcId();
        if (ucId != null) {
            stmt.bindString(3, ucId);
        }
        String dept = entity.getDept();
        if (dept != null) {
            stmt.bindString(4, dept);
        }
        String datetime = entity.getDatetime();
        if (datetime != null) {
            stmt.bindString(5, datetime);
        }
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(6, type);
        }
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(7, location);
        }
        String lang = entity.getLang();
        if (lang != null) {
            stmt.bindString(8, lang);
        }
        String lat = entity.getLat();
        if (lat != null) {
            stmt.bindString(9, lat);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(10, userOrganizationId);
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(11, locationDescription);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(12, note);
        }
        String preinstallLocation = entity.getPreinstallLocation();
        if (preinstallLocation != null) {
            stmt.bindString(13, preinstallLocation);
        }
        String longitude1 = entity.getLongitude1();
        if (longitude1 != null) {
            stmt.bindString(14, longitude1);
        }
        String latitude1 = entity.getLatitude1();
        if (latitude1 != null) {
            stmt.bindString(15, latitude1);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public SignBean readEntity(Cursor cursor, int offset) {
        return new SignBean(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
    }

    public void readEntity(Cursor cursor, SignBean entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUcId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDept(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDatetime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setType(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setLocation(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLang(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setLat(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setUserOrganizationId(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setLocationDescription(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setNote(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setPreinstallLocation(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setLongitude1(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        if (!cursor.isNull(offset + 14)) {
            str = cursor.getString(offset + 14);
        }
        entity.setLatitude1(str);
    }

    protected final Long updateKeyAfterInsert(SignBean entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(SignBean entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(SignBean entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
