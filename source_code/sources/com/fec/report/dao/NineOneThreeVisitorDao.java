package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hms.support.api.entity.hwid.HwIDConstant.RETKEY;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

public class NineOneThreeVisitorDao extends AbstractDao<NineOneThreeVisitor, Long> {
    public static final String TABLENAME = "NINE_ONE_THREE_VISITOR";
    private Query<NineOneThreeVisitor> nineOneThreeRespondent_NineOneThreeVisitorListQuery;

    public static class Properties {
        public static final Property Domicile = new Property(4, String.class, "domicile", false, "DOMICILE");
        public static final Property Gender = new Property(12, Integer.class, "gender", false, RETKEY.GENDER);
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Is_push = new Property(11, Integer.class, "is_push", false, "IS_PUSH");
        public static final Property Name = new Property(3, String.class, "name", false, "NAME");
        public static final Property Phone = new Property(5, String.class, "phone", false, "PHONE");
        public static final Property Photo = new Property(8, String.class, "photo", false, "PHOTO");
        public static final Property Pin_code = new Property(7, String.class, "pin_code", false, "PIN_CODE");
        public static final Property Reason = new Property(10, String.class, "reason", false, "REASON");
        public static final Property Rel_info = new Property(9, String.class, "rel_info", false, "REL_INFO");
        public static final Property Relation = new Property(6, Integer.class, "relation", false, "RELATION");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property Task_id = new Property(2, Long.class, "task_id", false, "TASK_ID");
    }

    public NineOneThreeVisitorDao(DaoConfig config) {
        super(config);
    }

    public NineOneThreeVisitorDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"NINE_ONE_THREE_VISITOR\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"TASK_ID\" INTEGER,\"NAME\" TEXT,\"DOMICILE\" TEXT,\"PHONE\" TEXT,\"RELATION\" INTEGER,\"PIN_CODE\" TEXT,\"PHOTO\" TEXT,\"REL_INFO\" TEXT,\"REASON\" TEXT,\"IS_PUSH\" INTEGER,\"GENDER\" INTEGER);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NINE_ONE_THREE_VISITOR\"");
    }

    protected final void bindValues(DatabaseStatement stmt, NineOneThreeVisitor entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Long task_id = entity.getTask_id();
        if (task_id != null) {
            stmt.bindLong(3, task_id.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        String domicile = entity.getDomicile();
        if (domicile != null) {
            stmt.bindString(5, domicile);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(6, phone);
        }
        Integer relation = entity.getRelation();
        if (relation != null) {
            stmt.bindLong(7, (long) relation.intValue());
        }
        String pin_code = entity.getPin_code();
        if (pin_code != null) {
            stmt.bindString(8, pin_code);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(9, photo);
        }
        String rel_info = entity.getRel_info();
        if (rel_info != null) {
            stmt.bindString(10, rel_info);
        }
        String reason = entity.getReason();
        if (reason != null) {
            stmt.bindString(11, reason);
        }
        Integer is_push = entity.getIs_push();
        if (is_push != null) {
            stmt.bindLong(12, (long) is_push.intValue());
        }
        Integer gender = entity.getGender();
        if (gender != null) {
            stmt.bindLong(13, (long) gender.intValue());
        }
    }

    protected final void bindValues(SQLiteStatement stmt, NineOneThreeVisitor entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Long task_id = entity.getTask_id();
        if (task_id != null) {
            stmt.bindLong(3, task_id.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        String domicile = entity.getDomicile();
        if (domicile != null) {
            stmt.bindString(5, domicile);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(6, phone);
        }
        Integer relation = entity.getRelation();
        if (relation != null) {
            stmt.bindLong(7, (long) relation.intValue());
        }
        String pin_code = entity.getPin_code();
        if (pin_code != null) {
            stmt.bindString(8, pin_code);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(9, photo);
        }
        String rel_info = entity.getRel_info();
        if (rel_info != null) {
            stmt.bindString(10, rel_info);
        }
        String reason = entity.getReason();
        if (reason != null) {
            stmt.bindString(11, reason);
        }
        Integer is_push = entity.getIs_push();
        if (is_push != null) {
            stmt.bindLong(12, (long) is_push.intValue());
        }
        Integer gender = entity.getGender();
        if (gender != null) {
            stmt.bindLong(13, (long) gender.intValue());
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public NineOneThreeVisitor readEntity(Cursor cursor, int offset) {
        return new NineOneThreeVisitor(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : Integer.valueOf(cursor.getInt(offset + 11)), cursor.isNull(offset + 12) ? null : Integer.valueOf(cursor.getInt(offset + 12)));
    }

    public void readEntity(Cursor cursor, NineOneThreeVisitor entity, int offset) {
        Integer num = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTask_id(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDomicile(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPhone(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRelation(cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)));
        entity.setPin_code(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPhoto(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setRel_info(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setReason(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setIs_push(cursor.isNull(offset + 11) ? null : Integer.valueOf(cursor.getInt(offset + 11)));
        if (!cursor.isNull(offset + 12)) {
            num = Integer.valueOf(cursor.getInt(offset + 12));
        }
        entity.setGender(num);
    }

    protected final Long updateKeyAfterInsert(NineOneThreeVisitor entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(NineOneThreeVisitor entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(NineOneThreeVisitor entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<NineOneThreeVisitor> _queryNineOneThreeRespondent_NineOneThreeVisitorList(Long task_id) {
        synchronized (this) {
            if (this.nineOneThreeRespondent_NineOneThreeVisitorListQuery == null) {
                QueryBuilder<NineOneThreeVisitor> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Task_id.eq(null), new WhereCondition[0]);
                this.nineOneThreeRespondent_NineOneThreeVisitorListQuery = queryBuilder.build();
            }
        }
        Query<NineOneThreeVisitor> query = this.nineOneThreeRespondent_NineOneThreeVisitorListQuery.forCurrentThread();
        query.setParameter(0, task_id);
        return query.list();
    }
}
