package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.turui.bank.ocr.Intents.WifiConnect;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

public class NineOneThreeSoftwareDao extends AbstractDao<NineOneThreeSoftware, Long> {
    public static final String TABLENAME = "NINE_ONE_THREE_SOFTWARE";
    private Query<NineOneThreeSoftware> nineOneThreePhone_NineOneThreeSoftwareListQuery;

    public static class Properties {
        public static final Property Account = new Property(4, String.class, "account", false, "ACCOUNT");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Phone_id = new Property(2, Long.class, "phone_id", false, "PHONE_ID");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property Type = new Property(3, Integer.class, "type", false, WifiConnect.TYPE);
    }

    public NineOneThreeSoftwareDao(DaoConfig config) {
        super(config);
    }

    public NineOneThreeSoftwareDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"NINE_ONE_THREE_SOFTWARE\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"PHONE_ID\" INTEGER,\"TYPE\" INTEGER,\"ACCOUNT\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NINE_ONE_THREE_SOFTWARE\"");
    }

    protected final void bindValues(DatabaseStatement stmt, NineOneThreeSoftware entity) {
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
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(4, (long) type.intValue());
        }
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(5, account);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, NineOneThreeSoftware entity) {
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
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(4, (long) type.intValue());
        }
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(5, account);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public NineOneThreeSoftware readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Long valueOf2 = cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2));
        Integer valueOf3 = cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3));
        if (!cursor.isNull(offset + 4)) {
            str = cursor.getString(offset + 4);
        }
        return new NineOneThreeSoftware(valueOf, string, valueOf2, valueOf3, str);
    }

    public void readEntity(Cursor cursor, NineOneThreeSoftware entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPhone_id(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setType(cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)));
        if (!cursor.isNull(offset + 4)) {
            str = cursor.getString(offset + 4);
        }
        entity.setAccount(str);
    }

    protected final Long updateKeyAfterInsert(NineOneThreeSoftware entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(NineOneThreeSoftware entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(NineOneThreeSoftware entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<NineOneThreeSoftware> _queryNineOneThreePhone_NineOneThreeSoftwareList(Long phone_id) {
        synchronized (this) {
            if (this.nineOneThreePhone_NineOneThreeSoftwareListQuery == null) {
                QueryBuilder<NineOneThreeSoftware> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Phone_id.eq(null), new WhereCondition[0]);
                this.nineOneThreePhone_NineOneThreeSoftwareListQuery = queryBuilder.build();
            }
        }
        Query<NineOneThreeSoftware> query = this.nineOneThreePhone_NineOneThreeSoftwareListQuery.forCurrentThread();
        query.setParameter(0, phone_id);
        return query.list();
    }
}
