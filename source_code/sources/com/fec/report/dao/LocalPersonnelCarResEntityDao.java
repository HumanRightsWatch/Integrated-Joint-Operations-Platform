package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class LocalPersonnelCarResEntityDao extends AbstractDao<LocalPersonnelCarResEntity, Long> {
    public static final String TABLENAME = "LOCAL_PERSONNEL_CAR_RES_ENTITY";

    public static class Properties {
        public static final Property Id = new Property(1, Long.class, "id", false, "ID");
        public static final Property IsMatch = new Property(3, String.class, "isMatch", false, "IS_MATCH");
        public static final Property Latitude = new Property(14, Double.class, "latitude", false, "LATITUDE");
        public static final Property LocalFkPcv = new Property(2, Long.class, "localFkPcv", false, "LOCAL_FK_PCV");
        public static final Property LocalID = new Property(0, Long.class, "localID", true, "LOCAL_ID");
        public static final Property LocationDescription = new Property(15, String.class, "locationDescription", false, "LOCATION_DESCRIPTION");
        public static final Property Longitude = new Property(13, Double.class, "longitude", false, "LONGITUDE");
        public static final Property MismatchReason = new Property(4, String.class, "mismatchReason", false, "MISMATCH_REASON");
        public static final Property Note = new Property(12, String.class, "note", false, "NOTE");
        public static final Property OtherMismatchReason = new Property(5, String.class, "otherMismatchReason", false, "OTHER_MISMATCH_REASON");
        public static final Property OwnerAddress = new Property(9, String.class, "ownerAddress", false, "OWNER_ADDRESS");
        public static final Property OwnerIdCard = new Property(7, String.class, "ownerIdCard", false, "OWNER_ID_CARD");
        public static final Property OwnerName = new Property(6, String.class, "ownerName", false, "OWNER_NAME");
        public static final Property OwnerPhone = new Property(8, String.class, "ownerPhone", false, "OWNER_PHONE");
        public static final Property PoliceCheck = new Property(10, String.class, "policeCheck", false, "POLICE_CHECK");
        public static final Property PoliceReason = new Property(11, String.class, "policeReason", false, "POLICE_REASON");
    }

    public LocalPersonnelCarResEntityDao(DaoConfig config) {
        super(config);
    }

    public LocalPersonnelCarResEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"LOCAL_PERSONNEL_CAR_RES_ENTITY\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" INTEGER,\"LOCAL_FK_PCV\" INTEGER,\"IS_MATCH\" TEXT,\"MISMATCH_REASON\" TEXT,\"OTHER_MISMATCH_REASON\" TEXT,\"OWNER_NAME\" TEXT,\"OWNER_ID_CARD\" TEXT,\"OWNER_PHONE\" TEXT,\"OWNER_ADDRESS\" TEXT,\"POLICE_CHECK\" TEXT,\"POLICE_REASON\" TEXT,\"NOTE\" TEXT,\"LONGITUDE\" REAL,\"LATITUDE\" REAL,\"LOCATION_DESCRIPTION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCAL_PERSONNEL_CAR_RES_ENTITY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, LocalPersonnelCarResEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(2, id.longValue());
        }
        Long localFkPcv = entity.getLocalFkPcv();
        if (localFkPcv != null) {
            stmt.bindLong(3, localFkPcv.longValue());
        }
        String isMatch = entity.getIsMatch();
        if (isMatch != null) {
            stmt.bindString(4, isMatch);
        }
        String mismatchReason = entity.getMismatchReason();
        if (mismatchReason != null) {
            stmt.bindString(5, mismatchReason);
        }
        String otherMismatchReason = entity.getOtherMismatchReason();
        if (otherMismatchReason != null) {
            stmt.bindString(6, otherMismatchReason);
        }
        String ownerName = entity.getOwnerName();
        if (ownerName != null) {
            stmt.bindString(7, ownerName);
        }
        String ownerIdCard = entity.getOwnerIdCard();
        if (ownerIdCard != null) {
            stmt.bindString(8, ownerIdCard);
        }
        String ownerPhone = entity.getOwnerPhone();
        if (ownerPhone != null) {
            stmt.bindString(9, ownerPhone);
        }
        String ownerAddress = entity.getOwnerAddress();
        if (ownerAddress != null) {
            stmt.bindString(10, ownerAddress);
        }
        String policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindString(11, policeCheck);
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(12, policeReason);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(13, note);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(14, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(15, latitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(16, locationDescription);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, LocalPersonnelCarResEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(2, id.longValue());
        }
        Long localFkPcv = entity.getLocalFkPcv();
        if (localFkPcv != null) {
            stmt.bindLong(3, localFkPcv.longValue());
        }
        String isMatch = entity.getIsMatch();
        if (isMatch != null) {
            stmt.bindString(4, isMatch);
        }
        String mismatchReason = entity.getMismatchReason();
        if (mismatchReason != null) {
            stmt.bindString(5, mismatchReason);
        }
        String otherMismatchReason = entity.getOtherMismatchReason();
        if (otherMismatchReason != null) {
            stmt.bindString(6, otherMismatchReason);
        }
        String ownerName = entity.getOwnerName();
        if (ownerName != null) {
            stmt.bindString(7, ownerName);
        }
        String ownerIdCard = entity.getOwnerIdCard();
        if (ownerIdCard != null) {
            stmt.bindString(8, ownerIdCard);
        }
        String ownerPhone = entity.getOwnerPhone();
        if (ownerPhone != null) {
            stmt.bindString(9, ownerPhone);
        }
        String ownerAddress = entity.getOwnerAddress();
        if (ownerAddress != null) {
            stmt.bindString(10, ownerAddress);
        }
        String policeCheck = entity.getPoliceCheck();
        if (policeCheck != null) {
            stmt.bindString(11, policeCheck);
        }
        String policeReason = entity.getPoliceReason();
        if (policeReason != null) {
            stmt.bindString(12, policeReason);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(13, note);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(14, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(15, latitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(16, locationDescription);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public LocalPersonnelCarResEntity readEntity(Cursor cursor, int offset) {
        return new LocalPersonnelCarResEntity(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)), cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : Double.valueOf(cursor.getDouble(offset + 13)), cursor.isNull(offset + 14) ? null : Double.valueOf(cursor.getDouble(offset + 14)), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
    }

    public void readEntity(Cursor cursor, LocalPersonnelCarResEntity entity, int offset) {
        String str = null;
        entity.setLocalID(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)));
        entity.setLocalFkPcv(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setIsMatch(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMismatchReason(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setOtherMismatchReason(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setOwnerName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setOwnerIdCard(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setOwnerPhone(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setOwnerAddress(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPoliceCheck(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setPoliceReason(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setNote(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setLongitude(cursor.isNull(offset + 13) ? null : Double.valueOf(cursor.getDouble(offset + 13)));
        entity.setLatitude(cursor.isNull(offset + 14) ? null : Double.valueOf(cursor.getDouble(offset + 14)));
        if (!cursor.isNull(offset + 15)) {
            str = cursor.getString(offset + 15);
        }
        entity.setLocationDescription(str);
    }

    protected final Long updateKeyAfterInsert(LocalPersonnelCarResEntity entity, long rowId) {
        entity.setLocalID(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(LocalPersonnelCarResEntity entity) {
        if (entity != null) {
            return entity.getLocalID();
        }
        return null;
    }

    public boolean hasKey(LocalPersonnelCarResEntity entity) {
        return entity.getLocalID() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
