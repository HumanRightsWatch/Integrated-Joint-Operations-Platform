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

public class OverduePersonVisitorDao extends AbstractDao<OverduePersonVisitor, Long> {
    public static final String TABLENAME = "OVERDUE_PERSON_VISITOR";
    private Query<OverduePersonVisitor> overduePersonInfo_OverduePersonVisitorListQuery;

    public static class Properties {
        public static final Property ActiveAres = new Property(7, String.class, "activeAres", false, "ACTIVE_ARES");
        public static final Property Address = new Property(6, String.class, "address", false, "ADDRESS");
        public static final Property CheckFlag = new Property(15, Integer.class, "checkFlag", false, "CHECK_FLAG");
        public static final Property FkOp = new Property(2, Long.class, "fkOp", false, "FK_OP");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property IdCard = new Property(5, String.class, "idCard", false, "ID_CARD");
        public static final Property IsPush = new Property(4, Integer.class, "isPush", false, "IS_PUSH");
        public static final Property Kinship = new Property(11, Integer.class, "kinship", false, "KINSHIP");
        public static final Property Name = new Property(3, String.class, "name", false, "NAME");
        public static final Property Note = new Property(17, String.class, "note", false, "NOTE");
        public static final Property OtherRelation = new Property(12, String.class, "otherRelation", false, "OTHER_RELATION");
        public static final Property Phone = new Property(8, String.class, "phone", false, "PHONE");
        public static final Property Photo = new Property(9, String.class, "photo", false, "PHOTO");
        public static final Property Relation = new Property(10, Integer.class, "relation", false, "RELATION");
        public static final Property Reson = new Property(13, String.class, "reson", false, "RESON");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property Sex = new Property(16, Integer.class, "sex", false, "SEX");
        public static final Property Type = new Property(14, Integer.class, "type", false, WifiConnect.TYPE);
    }

    public OverduePersonVisitorDao(DaoConfig config) {
        super(config);
    }

    public OverduePersonVisitorDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"OVERDUE_PERSON_VISITOR\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"FK_OP\" INTEGER,\"NAME\" TEXT,\"IS_PUSH\" INTEGER,\"ID_CARD\" TEXT,\"ADDRESS\" TEXT,\"ACTIVE_ARES\" TEXT,\"PHONE\" TEXT,\"PHOTO\" TEXT,\"RELATION\" INTEGER,\"KINSHIP\" INTEGER,\"OTHER_RELATION\" TEXT,\"RESON\" TEXT,\"TYPE\" INTEGER,\"CHECK_FLAG\" INTEGER,\"SEX\" INTEGER,\"NOTE\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"OVERDUE_PERSON_VISITOR\"");
    }

    protected final void bindValues(DatabaseStatement stmt, OverduePersonVisitor entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Long fkOp = entity.getFkOp();
        if (fkOp != null) {
            stmt.bindLong(3, fkOp.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        Integer isPush = entity.getIsPush();
        if (isPush != null) {
            stmt.bindLong(5, (long) isPush.intValue());
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(6, idCard);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(7, address);
        }
        String activeAres = entity.getActiveAres();
        if (activeAres != null) {
            stmt.bindString(8, activeAres);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(9, phone);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(10, photo);
        }
        Integer relation = entity.getRelation();
        if (relation != null) {
            stmt.bindLong(11, (long) relation.intValue());
        }
        Integer kinship = entity.getKinship();
        if (kinship != null) {
            stmt.bindLong(12, (long) kinship.intValue());
        }
        String otherRelation = entity.getOtherRelation();
        if (otherRelation != null) {
            stmt.bindString(13, otherRelation);
        }
        String reson = entity.getReson();
        if (reson != null) {
            stmt.bindString(14, reson);
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(15, (long) type.intValue());
        }
        Integer checkFlag = entity.getCheckFlag();
        if (checkFlag != null) {
            stmt.bindLong(16, (long) checkFlag.intValue());
        }
        Integer sex = entity.getSex();
        if (sex != null) {
            stmt.bindLong(17, (long) sex.intValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(18, note);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, OverduePersonVisitor entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Long fkOp = entity.getFkOp();
        if (fkOp != null) {
            stmt.bindLong(3, fkOp.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        Integer isPush = entity.getIsPush();
        if (isPush != null) {
            stmt.bindLong(5, (long) isPush.intValue());
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(6, idCard);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(7, address);
        }
        String activeAres = entity.getActiveAres();
        if (activeAres != null) {
            stmt.bindString(8, activeAres);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(9, phone);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(10, photo);
        }
        Integer relation = entity.getRelation();
        if (relation != null) {
            stmt.bindLong(11, (long) relation.intValue());
        }
        Integer kinship = entity.getKinship();
        if (kinship != null) {
            stmt.bindLong(12, (long) kinship.intValue());
        }
        String otherRelation = entity.getOtherRelation();
        if (otherRelation != null) {
            stmt.bindString(13, otherRelation);
        }
        String reson = entity.getReson();
        if (reson != null) {
            stmt.bindString(14, reson);
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(15, (long) type.intValue());
        }
        Integer checkFlag = entity.getCheckFlag();
        if (checkFlag != null) {
            stmt.bindLong(16, (long) checkFlag.intValue());
        }
        Integer sex = entity.getSex();
        if (sex != null) {
            stmt.bindLong(17, (long) sex.intValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(18, note);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public OverduePersonVisitor readEntity(Cursor cursor, int offset) {
        return new OverduePersonVisitor(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : Integer.valueOf(cursor.getInt(offset + 10)), cursor.isNull(offset + 11) ? null : Integer.valueOf(cursor.getInt(offset + 11)), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : Integer.valueOf(cursor.getInt(offset + 14)), cursor.isNull(offset + 15) ? null : Integer.valueOf(cursor.getInt(offset + 15)), cursor.isNull(offset + 16) ? null : Integer.valueOf(cursor.getInt(offset + 16)), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
    }

    public void readEntity(Cursor cursor, OverduePersonVisitor entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFkOp(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setIsPush(cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)));
        entity.setIdCard(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAddress(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setActiveAres(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPhone(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPhoto(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setRelation(cursor.isNull(offset + 10) ? null : Integer.valueOf(cursor.getInt(offset + 10)));
        entity.setKinship(cursor.isNull(offset + 11) ? null : Integer.valueOf(cursor.getInt(offset + 11)));
        entity.setOtherRelation(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setReson(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setType(cursor.isNull(offset + 14) ? null : Integer.valueOf(cursor.getInt(offset + 14)));
        entity.setCheckFlag(cursor.isNull(offset + 15) ? null : Integer.valueOf(cursor.getInt(offset + 15)));
        entity.setSex(cursor.isNull(offset + 16) ? null : Integer.valueOf(cursor.getInt(offset + 16)));
        if (!cursor.isNull(offset + 17)) {
            str = cursor.getString(offset + 17);
        }
        entity.setNote(str);
    }

    protected final Long updateKeyAfterInsert(OverduePersonVisitor entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(OverduePersonVisitor entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(OverduePersonVisitor entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<OverduePersonVisitor> _queryOverduePersonInfo_OverduePersonVisitorList(Long fkOp) {
        synchronized (this) {
            if (this.overduePersonInfo_OverduePersonVisitorListQuery == null) {
                QueryBuilder<OverduePersonVisitor> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.FkOp.eq(null), new WhereCondition[0]);
                this.overduePersonInfo_OverduePersonVisitorListQuery = queryBuilder.build();
            }
        }
        Query<OverduePersonVisitor> query = this.overduePersonInfo_OverduePersonVisitorListQuery.forCurrentThread();
        query.setParameter(0, fkOp);
        return query.list();
    }
}
