package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.turui.bank.ocr.Intents.WifiConnect;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class LocalPersonnelCarVisitorEntityDao extends AbstractDao<LocalPersonnelCarVisitorEntity, Long> {
    public static final String TABLENAME = "LOCAL_PERSONNEL_CAR_VISITOR_ENTITY";

    public static class Properties {
        public static final Property Address = new Property(7, String.class, "address", false, "ADDRESS");
        public static final Property FkPcmh = new Property(2, String.class, "fkPcmh", false, "FK_PCMH");
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property IdCard = new Property(5, String.class, "idCard", false, "ID_CARD");
        public static final Property Latitude = new Property(10, Double.class, "latitude", false, "LATITUDE");
        public static final Property LicensePlate = new Property(3, String.class, "licensePlate", false, "LICENSE_PLATE");
        public static final Property LocalID = new Property(0, Long.class, "localID", true, "LOCAL_ID");
        public static final Property LocationDescription = new Property(11, String.class, "locationDescription", false, "LOCATION_DESCRIPTION");
        public static final Property Longitude = new Property(9, Double.class, "longitude", false, "LONGITUDE");
        public static final Property Name = new Property(4, String.class, "name", false, "NAME");
        public static final Property Phone = new Property(6, String.class, "phone", false, "PHONE");
        public static final Property Type = new Property(8, String.class, "type", false, WifiConnect.TYPE);
    }

    public LocalPersonnelCarVisitorEntityDao(DaoConfig config) {
        super(config);
    }

    public LocalPersonnelCarVisitorEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"LOCAL_PERSONNEL_CAR_VISITOR_ENTITY\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"FK_PCMH\" TEXT,\"LICENSE_PLATE\" TEXT,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"PHONE\" TEXT,\"ADDRESS\" TEXT,\"TYPE\" TEXT,\"LONGITUDE\" REAL,\"LATITUDE\" REAL,\"LOCATION_DESCRIPTION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCAL_PERSONNEL_CAR_VISITOR_ENTITY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, LocalPersonnelCarVisitorEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        String fkPcmh = entity.getFkPcmh();
        if (fkPcmh != null) {
            stmt.bindString(3, fkPcmh);
        }
        String licensePlate = entity.getLicensePlate();
        if (licensePlate != null) {
            stmt.bindString(4, licensePlate);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(6, idCard);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(7, phone);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(8, address);
        }
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(9, type);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(10, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(11, latitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(12, locationDescription);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, LocalPersonnelCarVisitorEntity entity) {
        stmt.clearBindings();
        Long localID = entity.getLocalID();
        if (localID != null) {
            stmt.bindLong(1, localID.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        String fkPcmh = entity.getFkPcmh();
        if (fkPcmh != null) {
            stmt.bindString(3, fkPcmh);
        }
        String licensePlate = entity.getLicensePlate();
        if (licensePlate != null) {
            stmt.bindString(4, licensePlate);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(6, idCard);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(7, phone);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(8, address);
        }
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(9, type);
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(10, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(11, latitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(12, locationDescription);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public LocalPersonnelCarVisitorEntity readEntity(Cursor cursor, int offset) {
        return new LocalPersonnelCarVisitorEntity(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : Double.valueOf(cursor.getDouble(offset + 9)), cursor.isNull(offset + 10) ? null : Double.valueOf(cursor.getDouble(offset + 10)), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
    }

    public void readEntity(Cursor cursor, LocalPersonnelCarVisitorEntity entity, int offset) {
        String str = null;
        entity.setLocalID(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFkPcmh(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLicensePlate(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIdCard(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPhone(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setAddress(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setType(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setLongitude(cursor.isNull(offset + 9) ? null : Double.valueOf(cursor.getDouble(offset + 9)));
        entity.setLatitude(cursor.isNull(offset + 10) ? null : Double.valueOf(cursor.getDouble(offset + 10)));
        if (!cursor.isNull(offset + 11)) {
            str = cursor.getString(offset + 11);
        }
        entity.setLocationDescription(str);
    }

    protected final Long updateKeyAfterInsert(LocalPersonnelCarVisitorEntity entity, long rowId) {
        entity.setLocalID(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(LocalPersonnelCarVisitorEntity entity) {
        if (entity != null) {
            return entity.getLocalID();
        }
        return null;
    }

    public boolean hasKey(LocalPersonnelCarVisitorEntity entity) {
        return entity.getLocalID() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
