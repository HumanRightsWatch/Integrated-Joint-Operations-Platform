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

public class RadioCarPeerDao extends AbstractDao<RadioCarPeer, Long> {
    public static final String TABLENAME = "RADIO_CAR_PEER";
    private Query<RadioCarPeer> radioCarRespondent_RadioCarPeerListQuery;

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Id_card = new Property(3, String.class, "id_card", false, "ID_CARD");
        public static final Property Name = new Property(2, String.class, "name", false, "NAME");
        public static final Property Person_to_card = new Property(5, Boolean.class, "person_to_card", false, "PERSON_TO_CARD");
        public static final Property Phone = new Property(4, String.class, "phone", false, "PHONE");
        public static final Property Radio_id = new Property(1, Long.class, "radio_id", false, "RADIO_ID");
    }

    public RadioCarPeerDao(DaoConfig config) {
        super(config);
    }

    public RadioCarPeerDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"RADIO_CAR_PEER\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"RADIO_ID\" INTEGER,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"PHONE\" TEXT,\"PERSON_TO_CARD\" INTEGER);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RADIO_CAR_PEER\"");
    }

    protected final void bindValues(DatabaseStatement stmt, RadioCarPeer entity) {
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
        Boolean person_to_card = entity.getPerson_to_card();
        if (person_to_card != null) {
            stmt.bindLong(6, person_to_card.booleanValue() ? 1 : 0);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, RadioCarPeer entity) {
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
        Boolean person_to_card = entity.getPerson_to_card();
        if (person_to_card != null) {
            stmt.bindLong(6, person_to_card.booleanValue() ? 1 : 0);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public RadioCarPeer readEntity(Cursor cursor, int offset) {
        Boolean bool = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        Long valueOf2 = cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1));
        String string = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        if (!cursor.isNull(offset + 5)) {
            bool = Boolean.valueOf(cursor.getShort(offset + 5) != (short) 0);
        }
        return new RadioCarPeer(valueOf, valueOf2, string, string2, string3, bool);
    }

    public void readEntity(Cursor cursor, RadioCarPeer entity, int offset) {
        Boolean bool = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setRadio_id(cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setId_card(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhone(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        if (!cursor.isNull(offset + 5)) {
            bool = Boolean.valueOf(cursor.getShort(offset + 5) != (short) 0);
        }
        entity.setPerson_to_card(bool);
    }

    protected final Long updateKeyAfterInsert(RadioCarPeer entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(RadioCarPeer entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(RadioCarPeer entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<RadioCarPeer> _queryRadioCarRespondent_RadioCarPeerList(Long radio_id) {
        synchronized (this) {
            if (this.radioCarRespondent_RadioCarPeerListQuery == null) {
                QueryBuilder<RadioCarPeer> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Radio_id.eq(null), new WhereCondition[0]);
                this.radioCarRespondent_RadioCarPeerListQuery = queryBuilder.build();
            }
        }
        Query<RadioCarPeer> query = this.radioCarRespondent_RadioCarPeerListQuery.forCurrentThread();
        query.setParameter(0, radio_id);
        return query.list();
    }
}
