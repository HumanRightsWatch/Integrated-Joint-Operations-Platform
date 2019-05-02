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

public class InvestigateSoftDao extends AbstractDao<InvestigateSoft, Long> {
    public static final String TABLENAME = "INVESTIGATE_SOFT";
    private Query<InvestigateSoft> investigationInfo_InvestigateSoftListQuery;

    public static class Properties {
        public static final Property Account = new Property(4, String.class, "account", false, "ACCOUNT");
        public static final Property FkSDic = new Property(3, Integer.class, "fkSDic", false, "FK_SDIC");
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property Local_fkIr = new Property(2, Long.class, "local_fkIr", false, "LOCAL_FK_IR");
        public static final Property Local_id = new Property(0, Long.class, "local_id", true, "LOCAL_ID");
        public static final Property Note = new Property(5, String.class, "note", false, "NOTE");
    }

    public InvestigateSoftDao(DaoConfig config) {
        super(config);
    }

    public InvestigateSoftDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"INVESTIGATE_SOFT\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"LOCAL_FK_IR\" INTEGER,\"FK_SDIC\" INTEGER,\"ACCOUNT\" TEXT,\"NOTE\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"INVESTIGATE_SOFT\"");
    }

    protected final void bindValues(DatabaseStatement stmt, InvestigateSoft entity) {
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
        Integer fkSDic = entity.getFkSDic();
        if (fkSDic != null) {
            stmt.bindLong(4, (long) fkSDic.intValue());
        }
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(5, account);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(6, note);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, InvestigateSoft entity) {
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
        Integer fkSDic = entity.getFkSDic();
        if (fkSDic != null) {
            stmt.bindLong(4, (long) fkSDic.intValue());
        }
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(5, account);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(6, note);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public InvestigateSoft readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Long valueOf2 = cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2));
        Integer valueOf3 = cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3));
        String string2 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        return new InvestigateSoft(valueOf, string, valueOf2, valueOf3, string2, str);
    }

    public void readEntity(Cursor cursor, InvestigateSoft entity, int offset) {
        String str = null;
        entity.setLocal_id(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLocal_fkIr(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setFkSDic(cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)));
        entity.setAccount(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        entity.setNote(str);
    }

    protected final Long updateKeyAfterInsert(InvestigateSoft entity, long rowId) {
        entity.setLocal_id(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(InvestigateSoft entity) {
        if (entity != null) {
            return entity.getLocal_id();
        }
        return null;
    }

    public boolean hasKey(InvestigateSoft entity) {
        return entity.getLocal_id() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<InvestigateSoft> _queryInvestigationInfo_InvestigateSoftList(Long local_fkIr) {
        synchronized (this) {
            if (this.investigationInfo_InvestigateSoftListQuery == null) {
                QueryBuilder<InvestigateSoft> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Local_fkIr.eq(null), new WhereCondition[0]);
                this.investigationInfo_InvestigateSoftListQuery = queryBuilder.build();
            }
        }
        Query<InvestigateSoft> query = this.investigationInfo_InvestigateSoftListQuery.forCurrentThread();
        query.setParameter(0, local_fkIr);
        return query.list();
    }
}
