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

public class RadioPersonnelPeerDao extends AbstractDao<RadioPersonnelPeer, Long> {
    public static final String TABLENAME = "RADIO_PERSONNEL_PEER";
    private Query<RadioPersonnelPeer> radioPersonnelRespondent_RadioPersonnelPeerListQuery;

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Id_card = new Property(3, String.class, "id_card", false, "ID_CARD");
        public static final Property Name = new Property(2, String.class, "name", false, "NAME");
        public static final Property Phone = new Property(4, String.class, "phone", false, "PHONE");
        public static final Property Phone2 = new Property(5, String.class, "phone2", false, "PHONE2");
        public static final Property Radio_id = new Property(1, Long.class, "radio_id", false, "RADIO_ID");
    }

    public RadioPersonnelPeerDao(DaoConfig config) {
        super(config);
    }

    public RadioPersonnelPeerDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"RADIO_PERSONNEL_PEER\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"RADIO_ID\" INTEGER,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"PHONE\" TEXT,\"PHONE2\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RADIO_PERSONNEL_PEER\"");
    }

    protected final void bindValues(DatabaseStatement stmt, RadioPersonnelPeer entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Long radio_id = entity.getRadio_id();
        if (radio_id != null) {
            stmt.bindLong(2, radio_id.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
        String id_card = entity.getId_card();
        if (id_card != null) {
            stmt.bindString(4, id_card);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        String phone2 = entity.getPhone2();
        if (phone2 != null) {
            stmt.bindString(6, phone2);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, RadioPersonnelPeer entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Long radio_id = entity.getRadio_id();
        if (radio_id != null) {
            stmt.bindLong(2, radio_id.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
        String id_card = entity.getId_card();
        if (id_card != null) {
            stmt.bindString(4, id_card);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        String phone2 = entity.getPhone2();
        if (phone2 != null) {
            stmt.bindString(6, phone2);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public RadioPersonnelPeer readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        Long valueOf2 = cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1));
        String string = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        return new RadioPersonnelPeer(valueOf, valueOf2, string, string2, string3, str);
    }

    public void readEntity(Cursor cursor, RadioPersonnelPeer entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setRadio_id(cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setId_card(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhone(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        entity.setPhone2(str);
    }

    protected final Long updateKeyAfterInsert(RadioPersonnelPeer entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(RadioPersonnelPeer entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(RadioPersonnelPeer entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<RadioPersonnelPeer> _queryRadioPersonnelRespondent_RadioPersonnelPeerList(Long radio_id) {
        synchronized (this) {
            if (this.radioPersonnelRespondent_RadioPersonnelPeerListQuery == null) {
                QueryBuilder<RadioPersonnelPeer> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Radio_id.eq(null), new WhereCondition[0]);
                this.radioPersonnelRespondent_RadioPersonnelPeerListQuery = queryBuilder.build();
            }
        }
        Query<RadioPersonnelPeer> query = this.radioPersonnelRespondent_RadioPersonnelPeerListQuery.forCurrentThread();
        query.setParameter(0, radio_id);
        return query.list();
    }
}
