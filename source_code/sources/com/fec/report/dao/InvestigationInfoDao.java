package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class InvestigationInfoDao extends AbstractDao<InvestigationInfo, Long> {
    public static final String TABLENAME = "INVESTIGATION_INFO";
    private DaoSession daoSession;

    public static class Properties {
        public static final Property Address = new Property(11, String.class, "address", false, "ADDRESS");
        public static final Property Description = new Property(4, String.class, "description", false, "DESCRIPTION");
        public static final Property FkIi = new Property(2, String.class, "fkIi", false, "FK_II");
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property IdCard = new Property(6, String.class, "idCard", false, "ID_CARD");
        public static final Property InfoType = new Property(3, String.class, "infoType", false, "INFO_TYPE");
        public static final Property IsPushed = new Property(15, Integer.class, "isPushed", false, "IS_PUSHED");
        public static final Property Latitude = new Property(18, String.class, "latitude", false, "LATITUDE");
        public static final Property Local_id = new Property(0, Long.class, "local_id", true, "LOCAL_ID");
        public static final Property Longitude = new Property(19, String.class, "longitude", false, "LONGITUDE");
        public static final Property Name = new Property(5, String.class, "name", false, "NAME");
        public static final Property Note = new Property(16, String.class, "note", false, "NOTE");
        public static final Property Passport = new Property(8, String.class, "passport", false, "PASSPORT");
        public static final Property Phone = new Property(7, String.class, "phone", false, "PHONE");
        public static final Property Photo = new Property(12, String.class, "photo", false, "PHOTO");
        public static final Property PoliceCheck = new Property(14, Integer.class, "policeCheck", false, "POLICE_CHECK");
        public static final Property PoliceReason = new Property(17, String.class, "policeReason", false, "POLICE_REASON");
        public static final Property Response = new Property(13, String.class, "response", false, "RESPONSE");
        public static final Property Work = new Property(9, String.class, "work", false, "WORK");
        public static final Property WorkUnit = new Property(10, String.class, "workUnit", false, "WORK_UNIT");
    }

    public InvestigationInfoDao(DaoConfig config) {
        super(config);
    }

    public InvestigationInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"INVESTIGATION_INFO\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"FK_II\" TEXT,\"INFO_TYPE\" TEXT,\"DESCRIPTION\" TEXT,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"PHONE\" TEXT,\"PASSPORT\" TEXT,\"WORK\" TEXT,\"WORK_UNIT\" TEXT,\"ADDRESS\" TEXT,\"PHOTO\" TEXT,\"RESPONSE\" TEXT,\"POLICE_CHECK\" INTEGER,\"IS_PUSHED\" INTEGER,\"NOTE\" TEXT,\"POLICE_REASON\" TEXT,\"LATITUDE\" TEXT,\"LONGITUDE\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"INVESTIGATION_INFO\"");
    }

    protected final void bindValues(DatabaseStatement stmt, InvestigationInfo entity) {
        stmt.clearBindings();
        Long local_id = entity.getLocal_id();
        if (local_id != null) {
            stmt.bindLong(1, local_id.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        String fkIi = entity.getFkIi();
        if (fkIi != null) {
            stmt.bindString(3, fkIi);
        }
        String infoType = entity.getInfoType();
        if (infoType != null) {
            stmt.bindString(4, infoType);
        }
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(5, description);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(7, idCard);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(8, phone);
        }
        String passport = entity.getPassport();
        if (passport != null) {
            stmt.bindString(9, passport);
        }
        String work = entity.getWork();
        if (work != null) {
            stmt.bindString(10, work);
        }
        String workUnit = entity.getWorkUnit();
        if (workUnit != null) {
            stmt.bindString(11, workUnit);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(12, address);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(13, photo);
        }
        String response = entity.getResponse();
        if (response != null) {
            stmt.bindString(14, response);
        }
        Integer policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindLong(15, (long) policeCheck.intValue());
        }
        Integer isPushed = entity.getIsPushed();
        if (isPushed != null) {
            stmt.bindLong(16, (long) isPushed.intValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(17, note);
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(18, policeReason);
        }
        String latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindString(19, latitude);
        }
        String longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindString(20, longitude);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, InvestigationInfo entity) {
        stmt.clearBindings();
        Long local_id = entity.getLocal_id();
        if (local_id != null) {
            stmt.bindLong(1, local_id.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        String fkIi = entity.getFkIi();
        if (fkIi != null) {
            stmt.bindString(3, fkIi);
        }
        String infoType = entity.getInfoType();
        if (infoType != null) {
            stmt.bindString(4, infoType);
        }
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(5, description);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(7, idCard);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(8, phone);
        }
        String passport = entity.getPassport();
        if (passport != null) {
            stmt.bindString(9, passport);
        }
        String work = entity.getWork();
        if (work != null) {
            stmt.bindString(10, work);
        }
        String workUnit = entity.getWorkUnit();
        if (workUnit != null) {
            stmt.bindString(11, workUnit);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(12, address);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(13, photo);
        }
        String response = entity.getResponse();
        if (response != null) {
            stmt.bindString(14, response);
        }
        Integer policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindLong(15, (long) policeCheck.intValue());
        }
        Integer isPushed = entity.getIsPushed();
        if (isPushed != null) {
            stmt.bindLong(16, (long) isPushed.intValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(17, note);
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(18, policeReason);
        }
        String latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindString(19, latitude);
        }
        String longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindString(20, longitude);
        }
    }

    protected final void attachEntity(InvestigationInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(this.daoSession);
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public InvestigationInfo readEntity(Cursor cursor, int offset) {
        return new InvestigationInfo(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : Integer.valueOf(cursor.getInt(offset + 14)), cursor.isNull(offset + 15) ? null : Integer.valueOf(cursor.getInt(offset + 15)), cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
    }

    public void readEntity(Cursor cursor, InvestigationInfo entity, int offset) {
        String str = null;
        entity.setLocal_id(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFkIi(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setInfoType(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDescription(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setIdCard(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPhone(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPassport(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setWork(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setWorkUnit(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setAddress(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setPhoto(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setResponse(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setPoliceCheck(cursor.isNull(offset + 14) ? null : Integer.valueOf(cursor.getInt(offset + 14)));
        entity.setIsPushed(cursor.isNull(offset + 15) ? null : Integer.valueOf(cursor.getInt(offset + 15)));
        entity.setNote(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setPoliceReason(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setLatitude(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        if (!cursor.isNull(offset + 19)) {
            str = cursor.getString(offset + 19);
        }
        entity.setLongitude(str);
    }

    protected final Long updateKeyAfterInsert(InvestigationInfo entity, long rowId) {
        entity.setLocal_id(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(InvestigationInfo entity) {
        if (entity != null) {
            return entity.getLocal_id();
        }
        return null;
    }

    public boolean hasKey(InvestigationInfo entity) {
        return entity.getLocal_id() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
