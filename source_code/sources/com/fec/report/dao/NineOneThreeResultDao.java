package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class NineOneThreeResultDao extends AbstractDao<NineOneThreeResult, Long> {
    public static final String TABLENAME = "NINE_ONE_THREE_RESULT";

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Is_need_polic = new Property(2, Integer.class, "is_need_polic", false, "IS_NEED_POLIC");
        public static final Property PoliceReason = new Property(3, String.class, "policeReason", false, "POLICE_REASON");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property WarnResLatitude = new Property(4, String.class, "warnResLatitude", false, "WARN_RES_LATITUDE");
        public static final Property WarnResLongitude = new Property(5, String.class, "warnResLongitude", false, "WARN_RES_LONGITUDE");
    }

    public NineOneThreeResultDao(DaoConfig config) {
        super(config);
    }

    public NineOneThreeResultDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"NINE_ONE_THREE_RESULT\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"IS_NEED_POLIC\" INTEGER,\"POLICE_REASON\" TEXT,\"WARN_RES_LATITUDE\" TEXT,\"WARN_RES_LONGITUDE\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NINE_ONE_THREE_RESULT\"");
    }

    protected final void bindValues(DatabaseStatement stmt, NineOneThreeResult entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Integer is_need_polic = entity.getIs_need_polic();
        if (is_need_polic != null) {
            stmt.bindLong(3, (long) is_need_polic.intValue());
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(4, policeReason);
        }
        String warnResLatitude = entity.getWarnResLatitude();
        if (warnResLatitude != null) {
            stmt.bindString(5, warnResLatitude);
        }
        String warnResLongitude = entity.getWarnResLongitude();
        if (warnResLongitude != null) {
            stmt.bindString(6, warnResLongitude);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, NineOneThreeResult entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Integer is_need_polic = entity.getIs_need_polic();
        if (is_need_polic != null) {
            stmt.bindLong(3, (long) is_need_polic.intValue());
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(4, policeReason);
        }
        String warnResLatitude = entity.getWarnResLatitude();
        if (warnResLatitude != null) {
            stmt.bindString(5, warnResLatitude);
        }
        String warnResLongitude = entity.getWarnResLongitude();
        if (warnResLongitude != null) {
            stmt.bindString(6, warnResLongitude);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public NineOneThreeResult readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Integer valueOf2 = cursor.isNull(offset + 2) ? null : Integer.valueOf(cursor.getInt(offset + 2));
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        return new NineOneThreeResult(valueOf, string, valueOf2, string2, string3, str);
    }

    public void readEntity(Cursor cursor, NineOneThreeResult entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIs_need_polic(cursor.isNull(offset + 2) ? null : Integer.valueOf(cursor.getInt(offset + 2)));
        entity.setPoliceReason(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setWarnResLatitude(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        entity.setWarnResLongitude(str);
    }

    protected final Long updateKeyAfterInsert(NineOneThreeResult entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(NineOneThreeResult entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(NineOneThreeResult entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
