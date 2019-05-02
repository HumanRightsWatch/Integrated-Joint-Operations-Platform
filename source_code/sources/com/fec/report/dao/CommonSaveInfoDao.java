package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hms.support.api.entity.hwid.HwIDConstant.RETKEY;
import com.turui.bank.ocr.Intents.WifiConnect;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class CommonSaveInfoDao extends AbstractDao<CommonSaveInfo, Long> {
    public static final String TABLENAME = "COMMON_SAVE_INFO";

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Json = new Property(5, String.class, "json", false, "JSON");
        public static final Property ServiceID = new Property(4, String.class, "serviceID", false, "SERVICE_ID");
        public static final Property Status = new Property(7, Integer.class, "status", false, RETKEY.STATUS);
        public static final Property Type = new Property(3, Integer.class, "type", false, WifiConnect.TYPE);
        public static final Property UcID = new Property(2, String.class, "ucID", false, "UC_ID");
        public static final Property Version = new Property(6, Integer.class, "version", false, "VERSION");
        public static final Property WarnID = new Property(1, String.class, "warnID", false, "WARN_ID");
    }

    public CommonSaveInfoDao(DaoConfig config) {
        super(config);
    }

    public CommonSaveInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"COMMON_SAVE_INFO\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"WARN_ID\" TEXT,\"UC_ID\" TEXT,\"TYPE\" INTEGER,\"SERVICE_ID\" TEXT,\"JSON\" TEXT,\"VERSION\" INTEGER,\"STATUS\" INTEGER);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COMMON_SAVE_INFO\"");
    }

    protected final void bindValues(DatabaseStatement stmt, CommonSaveInfo entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String warnID = entity.getWarnID();
        if (warnID != null) {
            stmt.bindString(2, warnID);
        }
        String ucID = entity.getUcID();
        if (ucID != null) {
            stmt.bindString(3, ucID);
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(4, (long) type.intValue());
        }
        String serviceID = entity.getServiceID();
        if (serviceID != null) {
            stmt.bindString(5, serviceID);
        }
        String json = entity.getJson();
        if (json != null) {
            stmt.bindString(6, json);
        }
        Integer version = entity.getVersion();
        if (version != null) {
            stmt.bindLong(7, (long) version.intValue());
        }
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(8, (long) status.intValue());
        }
    }

    protected final void bindValues(SQLiteStatement stmt, CommonSaveInfo entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String warnID = entity.getWarnID();
        if (warnID != null) {
            stmt.bindString(2, warnID);
        }
        String ucID = entity.getUcID();
        if (ucID != null) {
            stmt.bindString(3, ucID);
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(4, (long) type.intValue());
        }
        String serviceID = entity.getServiceID();
        if (serviceID != null) {
            stmt.bindString(5, serviceID);
        }
        String json = entity.getJson();
        if (json != null) {
            stmt.bindString(6, json);
        }
        Integer version = entity.getVersion();
        if (version != null) {
            stmt.bindLong(7, (long) version.intValue());
        }
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(8, (long) status.intValue());
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public CommonSaveInfo readEntity(Cursor cursor, int offset) {
        Integer num = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        String string2 = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        Integer valueOf2 = cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3));
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string4 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        Integer valueOf3 = cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6));
        if (!cursor.isNull(offset + 7)) {
            num = Integer.valueOf(cursor.getInt(offset + 7));
        }
        return new CommonSaveInfo(valueOf, string, string2, valueOf2, string3, string4, valueOf3, num);
    }

    public void readEntity(Cursor cursor, CommonSaveInfo entity, int offset) {
        Integer num = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setWarnID(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUcID(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setType(cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)));
        entity.setServiceID(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setJson(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setVersion(cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)));
        if (!cursor.isNull(offset + 7)) {
            num = Integer.valueOf(cursor.getInt(offset + 7));
        }
        entity.setStatus(num);
    }

    protected final Long updateKeyAfterInsert(CommonSaveInfo entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(CommonSaveInfo entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(CommonSaveInfo entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
