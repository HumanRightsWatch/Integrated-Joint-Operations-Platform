package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class NoticeDao extends AbstractDao<Notice, Long> {
    public static final String TABLENAME = "NOTICE";

    public static class Properties {
        public static final Property Add_time = new Property(4, String.class, "add_time", false, "ADD_TIME");
        public static final Property Add_user = new Property(5, String.class, "add_user", false, "ADD_USER");
        public static final Property Announcement_content = new Property(3, String.class, "announcement_content", false, "ANNOUNCEMENT_CONTENT");
        public static final Property Announcement_name = new Property(2, String.class, "announcement_name", false, "ANNOUNCEMENT_NAME");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Is_read = new Property(6, Boolean.class, "is_read", false, "IS_READ");
        public static final Property Owner_id = new Property(7, String.class, "owner_id", false, "OWNER_ID");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
    }

    public NoticeDao(DaoConfig config) {
        super(config);
    }

    public NoticeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"NOTICE\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"ANNOUNCEMENT_NAME\" TEXT,\"ANNOUNCEMENT_CONTENT\" TEXT,\"ADD_TIME\" TEXT,\"ADD_USER\" TEXT,\"IS_READ\" INTEGER,\"OWNER_ID\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NOTICE\"");
    }

    protected final void bindValues(DatabaseStatement stmt, Notice entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        String announcement_name = entity.getAnnouncement_name();
        if (announcement_name != null) {
            stmt.bindString(3, announcement_name);
        }
        String announcement_content = entity.getAnnouncement_content();
        if (announcement_content != null) {
            stmt.bindString(4, announcement_content);
        }
        String add_time = entity.getAdd_time();
        if (add_time != null) {
            stmt.bindString(5, add_time);
        }
        String add_user = entity.getAdd_user();
        if (add_user != null) {
            stmt.bindString(6, add_user);
        }
        Boolean is_read = entity.getIs_read();
        if (is_read != null) {
            stmt.bindLong(7, is_read.booleanValue() ? 1 : 0);
        }
        String owner_id = entity.getOwner_id();
        if (owner_id != null) {
            stmt.bindString(8, owner_id);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, Notice entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        String announcement_name = entity.getAnnouncement_name();
        if (announcement_name != null) {
            stmt.bindString(3, announcement_name);
        }
        String announcement_content = entity.getAnnouncement_content();
        if (announcement_content != null) {
            stmt.bindString(4, announcement_content);
        }
        String add_time = entity.getAdd_time();
        if (add_time != null) {
            stmt.bindString(5, add_time);
        }
        String add_user = entity.getAdd_user();
        if (add_user != null) {
            stmt.bindString(6, add_user);
        }
        Boolean is_read = entity.getIs_read();
        if (is_read != null) {
            stmt.bindLong(7, is_read.booleanValue() ? 1 : 0);
        }
        String owner_id = entity.getOwner_id();
        if (owner_id != null) {
            stmt.bindString(8, owner_id);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public Notice readEntity(Cursor cursor, int offset) {
        Boolean bool;
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        String string2 = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        String string3 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string4 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string5 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        if (cursor.isNull(offset + 6)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(offset + 6) != (short) 0);
        }
        if (!cursor.isNull(offset + 7)) {
            str = cursor.getString(offset + 7);
        }
        return new Notice(valueOf, string, string2, string3, string4, string5, bool, str);
    }

    public void readEntity(Cursor cursor, Notice entity, int offset) {
        Boolean bool;
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAnnouncement_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAnnouncement_content(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAdd_time(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAdd_user(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        if (cursor.isNull(offset + 6)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(offset + 6) != (short) 0);
        }
        entity.setIs_read(bool);
        if (!cursor.isNull(offset + 7)) {
            str = cursor.getString(offset + 7);
        }
        entity.setOwner_id(str);
    }

    protected final Long updateKeyAfterInsert(Notice entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(Notice entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(Notice entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
