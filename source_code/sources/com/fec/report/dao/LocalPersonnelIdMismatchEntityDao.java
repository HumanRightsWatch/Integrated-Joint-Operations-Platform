package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.turui.bank.ocr.Intents.WifiConnect;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class LocalPersonnelIdMismatchEntityDao extends AbstractDao<LocalPersonnelIdMismatchEntity, Long> {
    public static final String TABLENAME = "LOCAL_PERSONNEL_ID_MISMATCH_ENTITY";

    public static class Properties {
        public static final Property Description = new Property(2, String.class, "description", false, "DESCRIPTION");
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property IsNewVisitor = new Property(3, Boolean.class, "isNewVisitor", false, "IS_NEW_VISITOR");
        public static final Property LocalID = new Property(0, Long.class, "localID", true, "LOCAL_ID");
        public static final Property Track = new Property(5, String.class, "track", false, "TRACK");
        public static final Property Type = new Property(4, Integer.class, "type", false, WifiConnect.TYPE);
    }

    public LocalPersonnelIdMismatchEntityDao(DaoConfig config) {
        super(config);
    }

    public LocalPersonnelIdMismatchEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"LOCAL_PERSONNEL_ID_MISMATCH_ENTITY\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"DESCRIPTION\" TEXT,\"IS_NEW_VISITOR\" INTEGER,\"TYPE\" INTEGER,\"TRACK\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCAL_PERSONNEL_ID_MISMATCH_ENTITY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, LocalPersonnelIdMismatchEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }
        Boolean isNewVisitor = entity.getIsNewVisitor();
        if (isNewVisitor != null) {
            stmt.bindLong(4, isNewVisitor.booleanValue() ? 1 : 0);
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(5, (long) type.intValue());
        }
        String track = entity.getTrack();
        if (track != null) {
            stmt.bindString(6, track);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, LocalPersonnelIdMismatchEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }
        Boolean isNewVisitor = entity.getIsNewVisitor();
        if (isNewVisitor != null) {
            stmt.bindLong(4, isNewVisitor.booleanValue() ? 1 : 0);
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(5, (long) type.intValue());
        }
        String track = entity.getTrack();
        if (track != null) {
            stmt.bindString(6, track);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public LocalPersonnelIdMismatchEntity readEntity(Cursor cursor, int offset) {
        Boolean bool;
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        String string2 = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        if (cursor.isNull(offset + 3)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(offset + 3) != (short) 0);
        }
        Integer valueOf2 = cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4));
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        return new LocalPersonnelIdMismatchEntity(valueOf, string, string2, bool, valueOf2, str);
    }

    public void readEntity(Cursor cursor, LocalPersonnelIdMismatchEntity entity, int offset) {
        Boolean bool;
        String str = null;
        entity.setLocalID(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDescription(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        if (cursor.isNull(offset + 3)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(offset + 3) != (short) 0);
        }
        entity.setIsNewVisitor(bool);
        entity.setType(cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)));
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        entity.setTrack(str);
    }

    protected final Long updateKeyAfterInsert(LocalPersonnelIdMismatchEntity entity, long rowId) {
        entity.setLocalID(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(LocalPersonnelIdMismatchEntity entity) {
        if (entity != null) {
            return entity.getLocalID();
        }
        return null;
    }

    public boolean hasKey(LocalPersonnelIdMismatchEntity entity) {
        return entity.getLocalID() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
