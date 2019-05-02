package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class NineOneThreePhoneDao extends AbstractDao<NineOneThreePhone, Long> {
    public static final String TABLENAME = "NINE_ONE_THREE_PHONE";
    private DaoSession daoSession;

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Is_support_phone = new Property(2, Integer.class, "is_support_phone", false, "IS_SUPPORT_PHONE");
        public static final Property Phone_code = new Property(3, String.class, "phone_code", false, "PHONE_CODE");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property Use_soft_other_reason = new Property(5, String.class, "use_soft_other_reason", false, "USE_SOFT_OTHER_REASON");
        public static final Property Use_soft_reason = new Property(4, String.class, "use_soft_reason", false, "USE_SOFT_REASON");
    }

    public NineOneThreePhoneDao(DaoConfig config) {
        super(config);
    }

    public NineOneThreePhoneDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"NINE_ONE_THREE_PHONE\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"IS_SUPPORT_PHONE\" INTEGER,\"PHONE_CODE\" TEXT,\"USE_SOFT_REASON\" TEXT,\"USE_SOFT_OTHER_REASON\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NINE_ONE_THREE_PHONE\"");
    }

    protected final void bindValues(DatabaseStatement stmt, NineOneThreePhone entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Integer is_support_phone = entity.getIs_support_phone();
        if (is_support_phone != null) {
            stmt.bindLong(3, (long) is_support_phone.intValue());
        }
        String phone_code = entity.getPhone_code();
        if (phone_code != null) {
            stmt.bindString(4, phone_code);
        }
        String use_soft_reason = entity.getUse_soft_reason();
        if (use_soft_reason != null) {
            stmt.bindString(5, use_soft_reason);
        }
        String use_soft_other_reason = entity.getUse_soft_other_reason();
        if (use_soft_other_reason != null) {
            stmt.bindString(6, use_soft_other_reason);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, NineOneThreePhone entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Integer is_support_phone = entity.getIs_support_phone();
        if (is_support_phone != null) {
            stmt.bindLong(3, (long) is_support_phone.intValue());
        }
        String phone_code = entity.getPhone_code();
        if (phone_code != null) {
            stmt.bindString(4, phone_code);
        }
        String use_soft_reason = entity.getUse_soft_reason();
        if (use_soft_reason != null) {
            stmt.bindString(5, use_soft_reason);
        }
        String use_soft_other_reason = entity.getUse_soft_other_reason();
        if (use_soft_other_reason != null) {
            stmt.bindString(6, use_soft_other_reason);
        }
    }

    protected final void attachEntity(NineOneThreePhone entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(this.daoSession);
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public NineOneThreePhone readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Integer valueOf2 = cursor.isNull(offset + 2) ? null : Integer.valueOf(cursor.getInt(offset + 2));
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        return new NineOneThreePhone(valueOf, string, valueOf2, string2, string3, str);
    }

    public void readEntity(Cursor cursor, NineOneThreePhone entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIs_support_phone(cursor.isNull(offset + 2) ? null : Integer.valueOf(cursor.getInt(offset + 2)));
        entity.setPhone_code(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUse_soft_reason(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        entity.setUse_soft_other_reason(str);
    }

    protected final Long updateKeyAfterInsert(NineOneThreePhone entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(NineOneThreePhone entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(NineOneThreePhone entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
