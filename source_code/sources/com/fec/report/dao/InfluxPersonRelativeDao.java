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

public class InfluxPersonRelativeDao extends AbstractDao<InfluxPersonRelative, Long> {
    public static final String TABLENAME = "INFLUX_PERSON_RELATIVE";
    private Query<InfluxPersonRelative> influxPersonInfo_InfluxPersonRelativeListQuery;

    public static class Properties {
        public static final Property IdCard = new Property(3, String.class, "idCard", false, "ID_CARD");
        public static final Property LocalId = new Property(0, Long.class, "localId", true, "LOCAL_ID");
        public static final Property LocalfkPoi = new Property(1, Long.class, "localfkPoi", false, "LOCALFK_POI");
        public static final Property MobilePhone = new Property(4, String.class, "mobilePhone", false, "MOBILE_PHONE");
        public static final Property Name = new Property(2, String.class, "name", false, "NAME");
    }

    public InfluxPersonRelativeDao(DaoConfig config) {
        super(config);
    }

    public InfluxPersonRelativeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"INFLUX_PERSON_RELATIVE\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"LOCALFK_POI\" INTEGER,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"MOBILE_PHONE\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"INFLUX_PERSON_RELATIVE\"");
    }

    protected final void bindValues(DatabaseStatement stmt, InfluxPersonRelative entity) {
        stmt.clearBindings();
        Long localId = entity.getLocalId();
        if (localId != null) {
            stmt.bindLong(1, localId.longValue());
        }
        Long localfkPoi = entity.getLocalfkPoi();
        if (localfkPoi != null) {
            stmt.bindLong(2, localfkPoi.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(4, idCard);
        }
        String mobilePhone = entity.getMobilePhone();
        if (mobilePhone != null) {
            stmt.bindString(5, mobilePhone);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, InfluxPersonRelative entity) {
        stmt.clearBindings();
        Long localId = entity.getLocalId();
        if (localId != null) {
            stmt.bindLong(1, localId.longValue());
        }
        Long localfkPoi = entity.getLocalfkPoi();
        if (localfkPoi != null) {
            stmt.bindLong(2, localfkPoi.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(4, idCard);
        }
        String mobilePhone = entity.getMobilePhone();
        if (mobilePhone != null) {
            stmt.bindString(5, mobilePhone);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public InfluxPersonRelative readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        Long valueOf2 = cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1));
        String string = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        if (!cursor.isNull(offset + 4)) {
            str = cursor.getString(offset + 4);
        }
        return new InfluxPersonRelative(valueOf, valueOf2, string, string2, str);
    }

    public void readEntity(Cursor cursor, InfluxPersonRelative entity, int offset) {
        String str = null;
        entity.setLocalId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setLocalfkPoi(cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIdCard(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        if (!cursor.isNull(offset + 4)) {
            str = cursor.getString(offset + 4);
        }
        entity.setMobilePhone(str);
    }

    protected final Long updateKeyAfterInsert(InfluxPersonRelative entity, long rowId) {
        entity.setLocalId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(InfluxPersonRelative entity) {
        if (entity != null) {
            return entity.getLocalId();
        }
        return null;
    }

    public boolean hasKey(InfluxPersonRelative entity) {
        return entity.getLocalId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<InfluxPersonRelative> _queryInfluxPersonInfo_InfluxPersonRelativeList(Long localfkPoi) {
        synchronized (this) {
            if (this.influxPersonInfo_InfluxPersonRelativeListQuery == null) {
                QueryBuilder<InfluxPersonRelative> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.LocalfkPoi.eq(null), new WhereCondition[0]);
                this.influxPersonInfo_InfluxPersonRelativeListQuery = queryBuilder.build();
            }
        }
        Query<InfluxPersonRelative> query = this.influxPersonInfo_InfluxPersonRelativeListQuery.forCurrentThread();
        query.setParameter(0, localfkPoi);
        return query.list();
    }
}
