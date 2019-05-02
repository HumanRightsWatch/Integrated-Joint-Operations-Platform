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

public class NineOneThreeOverseasDao extends AbstractDao<NineOneThreeOverseas, Long> {
    public static final String TABLENAME = "NINE_ONE_THREE_OVERSEAS";
    private Query<NineOneThreeOverseas> nineOneThreePhone_NineOneThreeOverseasListQuery;

    public static class Properties {
        public static final Property Account = new Property(8, String.class, "account", false, "ACCOUNT");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Name = new Property(3, String.class, "name", false, "NAME");
        public static final Property Note = new Property(6, String.class, "note", false, "NOTE");
        public static final Property Phone = new Property(4, String.class, "phone", false, "PHONE");
        public static final Property Phone_id = new Property(2, Long.class, "phone_id", false, "PHONE_ID");
        public static final Property Relation = new Property(5, String.class, "relation", false, "RELATION");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property Software_type = new Property(7, Integer.class, "software_type", false, "SOFTWARE_TYPE");
    }

    public NineOneThreeOverseasDao(DaoConfig config) {
        super(config);
    }

    public NineOneThreeOverseasDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"NINE_ONE_THREE_OVERSEAS\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"PHONE_ID\" INTEGER,\"NAME\" TEXT,\"PHONE\" TEXT,\"RELATION\" TEXT,\"NOTE\" TEXT,\"SOFTWARE_TYPE\" INTEGER,\"ACCOUNT\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NINE_ONE_THREE_OVERSEAS\"");
    }

    protected final void bindValues(DatabaseStatement stmt, NineOneThreeOverseas entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Long phone_id = entity.getPhone_id();
        if (phone_id != null) {
            stmt.bindLong(3, phone_id.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        String relation = entity.getRelation();
        if (relation != null) {
            stmt.bindString(6, relation);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(7, note);
        }
        Integer software_type = entity.getSoftware_type();
        if (software_type != null) {
            stmt.bindLong(8, (long) software_type.intValue());
        }
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(9, account);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, NineOneThreeOverseas entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Long phone_id = entity.getPhone_id();
        if (phone_id != null) {
            stmt.bindLong(3, phone_id.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        String relation = entity.getRelation();
        if (relation != null) {
            stmt.bindString(6, relation);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(7, note);
        }
        Integer software_type = entity.getSoftware_type();
        if (software_type != null) {
            stmt.bindLong(8, (long) software_type.intValue());
        }
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(9, account);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public NineOneThreeOverseas readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Long valueOf2 = cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2));
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string4 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        String string5 = cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6);
        Integer valueOf3 = cursor.isNull(offset + 7) ? null : Integer.valueOf(cursor.getInt(offset + 7));
        if (!cursor.isNull(offset + 8)) {
            str = cursor.getString(offset + 8);
        }
        return new NineOneThreeOverseas(valueOf, string, valueOf2, string2, string3, string4, string5, valueOf3, str);
    }

    public void readEntity(Cursor cursor, NineOneThreeOverseas entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPhone_id(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhone(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRelation(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setNote(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSoftware_type(cursor.isNull(offset + 7) ? null : Integer.valueOf(cursor.getInt(offset + 7)));
        if (!cursor.isNull(offset + 8)) {
            str = cursor.getString(offset + 8);
        }
        entity.setAccount(str);
    }

    protected final Long updateKeyAfterInsert(NineOneThreeOverseas entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(NineOneThreeOverseas entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(NineOneThreeOverseas entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<NineOneThreeOverseas> _queryNineOneThreePhone_NineOneThreeOverseasList(Long phone_id) {
        synchronized (this) {
            if (this.nineOneThreePhone_NineOneThreeOverseasListQuery == null) {
                QueryBuilder<NineOneThreeOverseas> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Phone_id.eq(null), new WhereCondition[0]);
                this.nineOneThreePhone_NineOneThreeOverseasListQuery = queryBuilder.build();
            }
        }
        Query<NineOneThreeOverseas> query = this.nineOneThreePhone_NineOneThreeOverseasListQuery.forCurrentThread();
        query.setParameter(0, phone_id);
        return query.list();
    }
}
