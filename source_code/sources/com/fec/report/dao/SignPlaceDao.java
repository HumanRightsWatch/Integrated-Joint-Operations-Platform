package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.turui.bank.ocr.Intents.WifiConnect;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class SignPlaceDao extends AbstractDao<SignPlace, Long> {
    public static final String TABLENAME = "SIGN_PLACE";

    public static class Properties {
        public static final Property Address = new Property(4, String.class, "address", false, "ADDRESS");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Latitude = new Property(2, Double.class, "latitude", false, "LATITUDE");
        public static final Property Location = new Property(5, String.class, "location", false, "LOCATION");
        public static final Property Longitude = new Property(3, Double.class, "longitude", false, "LONGITUDE");
        public static final Property Other = new Property(6, String.class, "other", false, "OTHER");
        public static final Property Placename = new Property(1, String.class, "placename", false, "PLACENAME");
        public static final Property Type = new Property(7, Integer.class, "type", false, WifiConnect.TYPE);
    }

    public SignPlaceDao(DaoConfig config) {
        super(config);
    }

    public SignPlaceDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"SIGN_PLACE\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"PLACENAME\" TEXT,\"LATITUDE\" REAL,\"LONGITUDE\" REAL,\"ADDRESS\" TEXT,\"LOCATION\" TEXT,\"OTHER\" TEXT,\"TYPE\" INTEGER);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SIGN_PLACE\"");
    }

    protected final void bindValues(DatabaseStatement stmt, SignPlace entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String placename = entity.getPlacename();
        if (placename != null) {
            stmt.bindString(2, placename);
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(3, latitude.doubleValue());
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(4, longitude.doubleValue());
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(6, location);
        }
        String other = entity.getOther();
        if (other != null) {
            stmt.bindString(7, other);
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(8, (long) type.intValue());
        }
    }

    protected final void bindValues(SQLiteStatement stmt, SignPlace entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String placename = entity.getPlacename();
        if (placename != null) {
            stmt.bindString(2, placename);
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(3, latitude.doubleValue());
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(4, longitude.doubleValue());
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(6, location);
        }
        String other = entity.getOther();
        if (other != null) {
            stmt.bindString(7, other);
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(8, (long) type.intValue());
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public SignPlace readEntity(Cursor cursor, int offset) {
        Integer num = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Double valueOf2 = cursor.isNull(offset + 2) ? null : Double.valueOf(cursor.getDouble(offset + 2));
        Double valueOf3 = cursor.isNull(offset + 3) ? null : Double.valueOf(cursor.getDouble(offset + 3));
        String string2 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string3 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        String string4 = cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6);
        if (!cursor.isNull(offset + 7)) {
            num = Integer.valueOf(cursor.getInt(offset + 7));
        }
        return new SignPlace(valueOf, string, valueOf2, valueOf3, string2, string3, string4, num);
    }

    public void readEntity(Cursor cursor, SignPlace entity, int offset) {
        Integer num = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setPlacename(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLatitude(cursor.isNull(offset + 2) ? null : Double.valueOf(cursor.getDouble(offset + 2)));
        entity.setLongitude(cursor.isNull(offset + 3) ? null : Double.valueOf(cursor.getDouble(offset + 3)));
        entity.setAddress(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setLocation(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setOther(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        if (!cursor.isNull(offset + 7)) {
            num = Integer.valueOf(cursor.getInt(offset + 7));
        }
        entity.setType(num);
    }

    protected final Long updateKeyAfterInsert(SignPlace entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(SignPlace entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(SignPlace entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
