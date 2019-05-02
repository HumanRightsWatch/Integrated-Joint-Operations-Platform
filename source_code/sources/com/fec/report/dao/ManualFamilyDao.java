package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

public class ManualFamilyDao extends AbstractDao<ManualFamily, Long> {
    public static final String TABLENAME = "MANUAL_FAMILY";
    private Query<ManualFamily> manualInfo_ManualFamilyListQuery;

    public static class Properties {
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property IdCard = new Property(4, String.class, "idCard", false, "ID_CARD");
        public static final Property Local_fkIr = new Property(2, Long.class, "local_fkIr", false, "LOCAL_FK_IR");
        public static final Property Local_id = new Property(0, Long.class, "local_id", true, "LOCAL_ID");
        public static final Property Name = new Property(3, String.class, "name", false, "NAME");
        public static final Property Note = new Property(7, String.class, "note", false, "NOTE");
        public static final Property Phone = new Property(5, String.class, "phone", false, "PHONE");
        public static final Property Relation = new Property(6, Integer.class, "relation", false, "RELATION");
    }

    public ManualFamilyDao(DaoConfig config) {
        super(config);
    }

    public ManualFamilyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"MANUAL_FAMILY\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"LOCAL_FK_IR\" INTEGER,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"PHONE\" TEXT,\"RELATION\" INTEGER,\"NOTE\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MANUAL_FAMILY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, ManualFamily entity) {
        stmt.clearBindings();
        Long local_id = entity.getLocal_id();
        if (local_id != null) {
            stmt.bindLong(1, local_id.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        Long local_fkIr = entity.getLocal_fkIr();
        if (local_fkIr != null) {
            stmt.bindLong(3, local_fkIr.longValue());
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
        Integer relation = entity.getRelation();
        if (relation != null) {
            stmt.bindLong(7, (long) relation.intValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(8, note);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, ManualFamily entity) {
        stmt.clearBindings();
        Long local_id = entity.getLocal_id();
        if (local_id != null) {
            stmt.bindLong(1, local_id.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        Long local_fkIr = entity.getLocal_fkIr();
        if (local_fkIr != null) {
            stmt.bindLong(3, local_fkIr.longValue());
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
        Integer relation = entity.getRelation();
        if (relation != null) {
            stmt.bindLong(7, (long) relation.intValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(8, note);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public ManualFamily readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Long valueOf2 = cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2));
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string4 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        Integer valueOf3 = cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6));
        if (!cursor.isNull(offset + 7)) {
            str = cursor.getString(offset + 7);
        }
        return new ManualFamily(valueOf, string, valueOf2, string2, string3, string4, valueOf3, str);
    }

    public void readEntity(Cursor cursor, ManualFamily entity, int offset) {
        String str = null;
        entity.setLocal_id(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLocal_fkIr(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setIdCard(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPhone(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRelation(cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)));
        if (!cursor.isNull(offset + 7)) {
            str = cursor.getString(offset + 7);
        }
        entity.setNote(str);
    }

    protected final Long updateKeyAfterInsert(ManualFamily entity, long rowId) {
        entity.setLocal_id(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(ManualFamily entity) {
        if (entity != null) {
            return entity.getLocal_id();
        }
        return null;
    }

    public boolean hasKey(ManualFamily entity) {
        return entity.getLocal_id() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<ManualFamily> _queryManualInfo_ManualFamilyList(Long local_fkIr) {
        synchronized (this) {
            if (this.manualInfo_ManualFamilyListQuery == null) {
                QueryBuilder<ManualFamily> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Local_fkIr.eq(null), new WhereCondition[0]);
                this.manualInfo_ManualFamilyListQuery = queryBuilder.build();
            }
        }
        Query<ManualFamily> query = this.manualInfo_ManualFamilyListQuery.forCurrentThread();
        query.setParameter(0, local_fkIr);
        return query.list();
    }
}
