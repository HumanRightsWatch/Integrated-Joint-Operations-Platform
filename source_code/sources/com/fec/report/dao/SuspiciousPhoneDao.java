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

public class SuspiciousPhoneDao extends AbstractDao<SuspiciousPhone, Long> {
    public static final String TABLENAME = "SUSPICIOUS_PHONE";
    private Query<SuspiciousPhone> radioCarRespondent_SuspiciousPhoneListQuery;

    public static class Properties {
        public static final Property Description = new Property(4, Integer.class, "description", false, "DESCRIPTION");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Id_card = new Property(2, String.class, "id_card", false, "ID_CARD");
        public static final Property Other_description = new Property(5, String.class, "other_description", false, "OTHER_DESCRIPTION");
        public static final Property Phone = new Property(3, String.class, "phone", false, "PHONE");
        public static final Property Radio_id = new Property(1, Long.class, "radio_id", false, "RADIO_ID");
    }

    public SuspiciousPhoneDao(DaoConfig config) {
        super(config);
    }

    public SuspiciousPhoneDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"SUSPICIOUS_PHONE\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"RADIO_ID\" INTEGER,\"ID_CARD\" TEXT,\"PHONE\" TEXT,\"DESCRIPTION\" INTEGER,\"OTHER_DESCRIPTION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SUSPICIOUS_PHONE\"");
    }

    protected final void bindValues(DatabaseStatement stmt, SuspiciousPhone entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Long radio_id = entity.getRadio_id();
        if (radio_id != null) {
            stmt.bindLong(2, radio_id.longValue());
        }
        String id_card = entity.getId_card();
        if (id_card != null) {
            stmt.bindString(3, id_card);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(4, phone);
        }
        Integer description = entity.getDescription();
        if (description != null) {
            stmt.bindLong(5, (long) description.intValue());
        }
        String other_description = entity.getOther_description();
        if (other_description != null) {
            stmt.bindString(6, other_description);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, SuspiciousPhone entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Long radio_id = entity.getRadio_id();
        if (radio_id != null) {
            stmt.bindLong(2, radio_id.longValue());
        }
        String id_card = entity.getId_card();
        if (id_card != null) {
            stmt.bindString(3, id_card);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(4, phone);
        }
        Integer description = entity.getDescription();
        if (description != null) {
            stmt.bindLong(5, (long) description.intValue());
        }
        String other_description = entity.getOther_description();
        if (other_description != null) {
            stmt.bindString(6, other_description);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public SuspiciousPhone readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        Long valueOf2 = cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1));
        String string = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        Integer valueOf3 = cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4));
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        return new SuspiciousPhone(valueOf, valueOf2, string, string2, valueOf3, str);
    }

    public void readEntity(Cursor cursor, SuspiciousPhone entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setRadio_id(cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)));
        entity.setId_card(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPhone(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDescription(cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)));
        if (!cursor.isNull(offset + 5)) {
            str = cursor.getString(offset + 5);
        }
        entity.setOther_description(str);
    }

    protected final Long updateKeyAfterInsert(SuspiciousPhone entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(SuspiciousPhone entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(SuspiciousPhone entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<SuspiciousPhone> _queryRadioCarRespondent_SuspiciousPhoneList(Long radio_id) {
        synchronized (this) {
            if (this.radioCarRespondent_SuspiciousPhoneListQuery == null) {
                QueryBuilder<SuspiciousPhone> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Radio_id.eq(null), new WhereCondition[0]);
                this.radioCarRespondent_SuspiciousPhoneListQuery = queryBuilder.build();
            }
        }
        Query<SuspiciousPhone> query = this.radioCarRespondent_SuspiciousPhoneListQuery.forCurrentThread();
        query.setParameter(0, radio_id);
        return query.list();
    }
}
