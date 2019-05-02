package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class LocalPersonnelCarMismatchEntityDao extends AbstractDao<LocalPersonnelCarMismatchEntity, Long> {
    public static final String TABLENAME = "LOCAL_PERSONNEL_CAR_MISMATCH_ENTITY";

    public static class Properties {
        public static final Property Description = new Property(2, String.class, "description", false, "DESCRIPTION");
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property IsNewVisitor = new Property(3, Boolean.class, "isNewVisitor", false, "IS_NEW_VISITOR");
        public static final Property LocalID = new Property(0, Long.class, "localID", true, "LOCAL_ID");
    }

    public LocalPersonnelCarMismatchEntityDao(DaoConfig config) {
        super(config);
    }

    public LocalPersonnelCarMismatchEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"LOCAL_PERSONNEL_CAR_MISMATCH_ENTITY\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"DESCRIPTION\" TEXT,\"IS_NEW_VISITOR\" INTEGER);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCAL_PERSONNEL_CAR_MISMATCH_ENTITY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, LocalPersonnelCarMismatchEntity entity) {
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
    }

    protected final void bindValues(SQLiteStatement stmt, LocalPersonnelCarMismatchEntity entity) {
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
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public LocalPersonnelCarMismatchEntity readEntity(Cursor cursor, int offset) {
        Boolean bool = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        String string2 = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        if (!cursor.isNull(offset + 3)) {
            bool = Boolean.valueOf(cursor.getShort(offset + 3) != (short) 0);
        }
        return new LocalPersonnelCarMismatchEntity(valueOf, string, string2, bool);
    }

    public void readEntity(Cursor cursor, LocalPersonnelCarMismatchEntity entity, int offset) {
        Boolean bool = null;
        entity.setLocalID(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDescription(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        if (!cursor.isNull(offset + 3)) {
            bool = Boolean.valueOf(cursor.getShort(offset + 3) != (short) 0);
        }
        entity.setIsNewVisitor(bool);
    }

    protected final Long updateKeyAfterInsert(LocalPersonnelCarMismatchEntity entity, long rowId) {
        entity.setLocalID(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(LocalPersonnelCarMismatchEntity entity) {
        if (entity != null) {
            return entity.getLocalID();
        }
        return null;
    }

    public boolean hasKey(LocalPersonnelCarMismatchEntity entity) {
        return entity.getLocalID() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
