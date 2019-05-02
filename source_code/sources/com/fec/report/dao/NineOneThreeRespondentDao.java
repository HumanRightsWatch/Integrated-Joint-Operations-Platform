package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.support.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.SqlUtils;

public class NineOneThreeRespondentDao extends AbstractDao<NineOneThreeRespondent, Long> {
    public static final String TABLENAME = "NINE_ONE_THREE_RESPONDENT";
    private DaoSession daoSession;
    private String selectDeep;

    public static class Properties {
        public static final Property Activity = new Property(6, String.class, "activity", false, "ACTIVITY");
        public static final Property Domicile = new Property(5, String.class, "domicile", false, "DOMICILE");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Name = new Property(2, String.class, "name", false, "NAME");
        public static final Property Phone = new Property(4, String.class, "phone", false, "PHONE");
        public static final Property Phone_code = new Property(7, String.class, "phone_code", false, "PHONE_CODE");
        public static final Property Phone_id = new Property(8, Long.class, "phone_id", false, "PHONE_ID");
        public static final Property Pin_code = new Property(3, String.class, "pin_code", false, "PIN_CODE");
        public static final Property Result_id = new Property(9, Long.class, "result_id", false, "RESULT_ID");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
    }

    public NineOneThreeRespondentDao(DaoConfig config) {
        super(config);
    }

    public NineOneThreeRespondentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"NINE_ONE_THREE_RESPONDENT\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"NAME\" TEXT,\"PIN_CODE\" TEXT,\"PHONE\" TEXT,\"DOMICILE\" TEXT,\"ACTIVITY\" TEXT,\"PHONE_CODE\" TEXT,\"PHONE_ID\" INTEGER,\"RESULT_ID\" INTEGER);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NINE_ONE_THREE_RESPONDENT\"");
    }

    protected final void bindValues(DatabaseStatement stmt, NineOneThreeRespondent entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
        String pin_code = entity.getPin_code();
        if (pin_code != null) {
            stmt.bindString(4, pin_code);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        String domicile = entity.getDomicile();
        if (domicile != null) {
            stmt.bindString(6, domicile);
        }
        String activity = entity.getActivity();
        if (activity != null) {
            stmt.bindString(7, activity);
        }
        String phone_code = entity.getPhone_code();
        if (phone_code != null) {
            stmt.bindString(8, phone_code);
        }
        Long phone_id = entity.getPhone_id();
        if (phone_id != null) {
            stmt.bindLong(9, phone_id.longValue());
        }
        Long result_id = entity.getResult_id();
        if (result_id != null) {
            stmt.bindLong(10, result_id.longValue());
        }
    }

    protected final void bindValues(SQLiteStatement stmt, NineOneThreeRespondent entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
        String pin_code = entity.getPin_code();
        if (pin_code != null) {
            stmt.bindString(4, pin_code);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(5, phone);
        }
        String domicile = entity.getDomicile();
        if (domicile != null) {
            stmt.bindString(6, domicile);
        }
        String activity = entity.getActivity();
        if (activity != null) {
            stmt.bindString(7, activity);
        }
        String phone_code = entity.getPhone_code();
        if (phone_code != null) {
            stmt.bindString(8, phone_code);
        }
        Long phone_id = entity.getPhone_id();
        if (phone_id != null) {
            stmt.bindLong(9, phone_id.longValue());
        }
        Long result_id = entity.getResult_id();
        if (result_id != null) {
            stmt.bindLong(10, result_id.longValue());
        }
    }

    protected final void attachEntity(NineOneThreeRespondent entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(this.daoSession);
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public NineOneThreeRespondent readEntity(Cursor cursor, int offset) {
        return new NineOneThreeRespondent(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : Long.valueOf(cursor.getLong(offset + 8)), cursor.isNull(offset + 9) ? null : Long.valueOf(cursor.getLong(offset + 9)));
    }

    public void readEntity(Cursor cursor, NineOneThreeRespondent entity, int offset) {
        Long l = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPin_code(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhone(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDomicile(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setActivity(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPhone_code(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPhone_id(cursor.isNull(offset + 8) ? null : Long.valueOf(cursor.getLong(offset + 8)));
        if (!cursor.isNull(offset + 9)) {
            l = Long.valueOf(cursor.getLong(offset + 9));
        }
        entity.setResult_id(l);
    }

    protected final Long updateKeyAfterInsert(NineOneThreeRespondent entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(NineOneThreeRespondent entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(NineOneThreeRespondent entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    protected String getSelectDeep() {
        if (this.selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, ExifInterface.GPS_DIRECTION_TRUE, getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", this.daoSession.getNineOneThreePhoneDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", this.daoSession.getNineOneThreeResultDao().getAllColumns());
            builder.append(" FROM NINE_ONE_THREE_RESPONDENT T");
            builder.append(" LEFT JOIN NINE_ONE_THREE_PHONE T0 ON T.\"PHONE_ID\"=T0.\"ID\"");
            builder.append(" LEFT JOIN NINE_ONE_THREE_RESULT T1 ON T.\"RESULT_ID\"=T1.\"ID\"");
            builder.append(' ');
            this.selectDeep = builder.toString();
        }
        return this.selectDeep;
    }

    protected NineOneThreeRespondent loadCurrentDeep(Cursor cursor, boolean lock) {
        NineOneThreeRespondent entity = (NineOneThreeRespondent) loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;
        entity.setNineOneThreePhone((NineOneThreePhone) loadCurrentOther(this.daoSession.getNineOneThreePhoneDao(), cursor, offset));
        entity.setNineOneThreeResult((NineOneThreeResult) loadCurrentOther(this.daoSession.getNineOneThreeResultDao(), cursor, offset + this.daoSession.getNineOneThreePhoneDao().getAllColumns().length));
        return entity;
    }

    public NineOneThreeRespondent loadDeep(Long key) {
        NineOneThreeRespondent nineOneThreeRespondent = null;
        assertSinglePk();
        if (key != null) {
            StringBuilder builder = new StringBuilder(getSelectDeep());
            builder.append("WHERE ");
            SqlUtils.appendColumnsEqValue(builder, ExifInterface.GPS_DIRECTION_TRUE, getPkColumns());
            Cursor cursor = this.db.rawQuery(builder.toString(), new String[]{key.toString()});
            try {
                if (cursor.moveToFirst()) {
                    if (cursor.isLast()) {
                        nineOneThreeRespondent = loadCurrentDeep(cursor, true);
                        cursor.close();
                    } else {
                        throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
                    }
                }
            } finally {
                cursor.close();
            }
        }
        return nineOneThreeRespondent;
    }

    public List<NineOneThreeRespondent> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<NineOneThreeRespondent> list = new ArrayList(count);
        if (cursor.moveToFirst()) {
            if (this.identityScope != null) {
                this.identityScope.lock();
                this.identityScope.reserveRoom(count);
            }
            while (true) {
                try {
                    list.add(loadCurrentDeep(cursor, false));
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } finally {
                    if (this.identityScope != null) {
                        this.identityScope.unlock();
                    }
                }
            }
        }
        return list;
    }

    protected List<NineOneThreeRespondent> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            List<NineOneThreeRespondent> loadAllDeepFromCursor = loadAllDeepFromCursor(cursor);
            return loadAllDeepFromCursor;
        } finally {
            cursor.close();
        }
    }

    public List<NineOneThreeRespondent> queryDeep(String where, String... selectionArg) {
        return loadDeepAllAndCloseCursor(this.db.rawQuery(getSelectDeep() + where, selectionArg));
    }
}
