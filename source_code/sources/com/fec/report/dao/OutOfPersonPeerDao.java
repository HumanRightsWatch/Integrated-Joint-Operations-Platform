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

public class OutOfPersonPeerDao extends AbstractDao<OutOfPersonPeer, Long> {
    public static final String TABLENAME = "OUT_OF_PERSON_PEER";
    private Query<OutOfPersonPeer> outOfPersonInfo_OutOfPersonPeerListQuery;

    public static class Properties {
        public static final Property IdCard = new Property(3, String.class, "idCard", false, "ID_CARD");
        public static final Property LocalId = new Property(0, Long.class, "localId", true, "LOCAL_ID");
        public static final Property LocalfkPod = new Property(1, Long.class, "localfkPod", false, "LOCALFK_POD");
        public static final Property MobilePhone = new Property(4, String.class, "mobilePhone", false, "MOBILE_PHONE");
        public static final Property Name = new Property(2, String.class, "name", false, "NAME");
    }

    public OutOfPersonPeerDao(DaoConfig config) {
        super(config);
    }

    public OutOfPersonPeerDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"OUT_OF_PERSON_PEER\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"LOCALFK_POD\" INTEGER,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"MOBILE_PHONE\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"OUT_OF_PERSON_PEER\"");
    }

    protected final void bindValues(DatabaseStatement stmt, OutOfPersonPeer entity) {
        stmt.clearBindings();
        Long localId = entity.getLocalId();
        if (localId != null) {
            stmt.bindLong(1, localId.longValue());
        }
        Long localfkPod = entity.getLocalfkPod();
        if (localfkPod != null) {
            stmt.bindLong(2, localfkPod.longValue());
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

    protected final void bindValues(SQLiteStatement stmt, OutOfPersonPeer entity) {
        stmt.clearBindings();
        Long localId = entity.getLocalId();
        if (localId != null) {
            stmt.bindLong(1, localId.longValue());
        }
        Long localfkPod = entity.getLocalfkPod();
        if (localfkPod != null) {
            stmt.bindLong(2, localfkPod.longValue());
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

    public OutOfPersonPeer readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        Long valueOf2 = cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1));
        String string = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        if (!cursor.isNull(offset + 4)) {
            str = cursor.getString(offset + 4);
        }
        return new OutOfPersonPeer(valueOf, valueOf2, string, string2, str);
    }

    public void readEntity(Cursor cursor, OutOfPersonPeer entity, int offset) {
        String str = null;
        entity.setLocalId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setLocalfkPod(cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIdCard(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        if (!cursor.isNull(offset + 4)) {
            str = cursor.getString(offset + 4);
        }
        entity.setMobilePhone(str);
    }

    protected final Long updateKeyAfterInsert(OutOfPersonPeer entity, long rowId) {
        entity.setLocalId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(OutOfPersonPeer entity) {
        if (entity != null) {
            return entity.getLocalId();
        }
        return null;
    }

    public boolean hasKey(OutOfPersonPeer entity) {
        return entity.getLocalId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<OutOfPersonPeer> _queryOutOfPersonInfo_OutOfPersonPeerList(Long localfkPod) {
        synchronized (this) {
            if (this.outOfPersonInfo_OutOfPersonPeerListQuery == null) {
                QueryBuilder<OutOfPersonPeer> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.LocalfkPod.eq(null), new WhereCondition[0]);
                this.outOfPersonInfo_OutOfPersonPeerListQuery = queryBuilder.build();
            }
        }
        Query<OutOfPersonPeer> query = this.outOfPersonInfo_OutOfPersonPeerListQuery.forCurrentThread();
        query.setParameter(0, localfkPod);
        return query.list();
    }
}
