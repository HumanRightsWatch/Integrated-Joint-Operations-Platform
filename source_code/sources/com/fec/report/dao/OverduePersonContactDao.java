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

public class OverduePersonContactDao extends AbstractDao<OverduePersonContact, Long> {
    public static final String TABLENAME = "OVERDUE_PERSON_CONTACT";
    private Query<OverduePersonContact> overduePersonInfo_OverduePersonContactListQuery;

    public static class Properties {
        public static final Property FkOpv = new Property(2, Long.class, "fkOpv", false, "FK_OPV");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property IdCard = new Property(6, String.class, "idCard", false, "ID_CARD");
        public static final Property Name = new Property(3, String.class, "name", false, "NAME");
        public static final Property Note = new Property(5, String.class, "note", false, "NOTE");
        public static final Property OtherRelation = new Property(9, String.class, "otherRelation", false, "OTHER_RELATION");
        public static final Property Phone = new Property(4, String.class, "phone", false, "PHONE");
        public static final Property Relation = new Property(8, Integer.class, "relation", false, "RELATION");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property Sex = new Property(7, Integer.class, "sex", false, "SEX");
    }

    public OverduePersonContactDao(DaoConfig config) {
        super(config);
    }

    public OverduePersonContactDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"OVERDUE_PERSON_CONTACT\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"FK_OPV\" INTEGER,\"NAME\" TEXT,\"PHONE\" TEXT,\"NOTE\" TEXT,\"ID_CARD\" TEXT,\"SEX\" INTEGER,\"RELATION\" INTEGER,\"OTHER_RELATION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"OVERDUE_PERSON_CONTACT\"");
    }

    protected final void bindValues(DatabaseStatement stmt, OverduePersonContact entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Long fkOpv = entity.getFkOpv();
        if (fkOpv != null) {
            stmt.bindLong(3, fkOpv.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(6, note);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(7, idCard);
        }
        Integer sex = entity.getSex();
        if (sex != null) {
            stmt.bindLong(8, (long) sex.intValue());
        }
        Integer relation = entity.getRelation();
        if (relation != null) {
            stmt.bindLong(9, (long) relation.intValue());
        }
        String otherRelation = entity.getOtherRelation();
        if (otherRelation != null) {
            stmt.bindString(10, otherRelation);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, OverduePersonContact entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Long fkOpv = entity.getFkOpv();
        if (fkOpv != null) {
            stmt.bindLong(3, fkOpv.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(6, note);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(7, idCard);
        }
        Integer sex = entity.getSex();
        if (sex != null) {
            stmt.bindLong(8, (long) sex.intValue());
        }
        Integer relation = entity.getRelation();
        if (relation != null) {
            stmt.bindLong(9, (long) relation.intValue());
        }
        String otherRelation = entity.getOtherRelation();
        if (otherRelation != null) {
            stmt.bindString(10, otherRelation);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public OverduePersonContact readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Long valueOf2 = cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2));
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string4 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        String string5 = cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6);
        Integer valueOf3 = cursor.isNull(offset + 7) ? null : Integer.valueOf(cursor.getInt(offset + 7));
        Integer valueOf4 = cursor.isNull(offset + 8) ? null : Integer.valueOf(cursor.getInt(offset + 8));
        if (!cursor.isNull(offset + 9)) {
            str = cursor.getString(offset + 9);
        }
        return new OverduePersonContact(valueOf, string, valueOf2, string2, string3, string4, string5, valueOf3, valueOf4, str);
    }

    public void readEntity(Cursor cursor, OverduePersonContact entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFkOpv(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhone(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setNote(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setIdCard(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSex(cursor.isNull(offset + 7) ? null : Integer.valueOf(cursor.getInt(offset + 7)));
        entity.setRelation(cursor.isNull(offset + 8) ? null : Integer.valueOf(cursor.getInt(offset + 8)));
        if (!cursor.isNull(offset + 9)) {
            str = cursor.getString(offset + 9);
        }
        entity.setOtherRelation(str);
    }

    protected final Long updateKeyAfterInsert(OverduePersonContact entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(OverduePersonContact entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(OverduePersonContact entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<OverduePersonContact> _queryOverduePersonInfo_OverduePersonContactList(Long fkOpv) {
        synchronized (this) {
            if (this.overduePersonInfo_OverduePersonContactListQuery == null) {
                QueryBuilder<OverduePersonContact> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.FkOpv.eq(null), new WhereCondition[0]);
                this.overduePersonInfo_OverduePersonContactListQuery = queryBuilder.build();
            }
        }
        Query<OverduePersonContact> query = this.overduePersonInfo_OverduePersonContactListQuery.forCurrentThread();
        query.setParameter(0, fkOpv);
        return query.list();
    }
}
