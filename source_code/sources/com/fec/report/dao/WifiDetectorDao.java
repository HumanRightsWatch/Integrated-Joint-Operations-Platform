package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class WifiDetectorDao extends AbstractDao<WifiDetector, String> {
    public static final String TABLENAME = "WIFI_DETECTOR";

    public static class Properties {
        public static final Property CenterFrequency = new Property(5, Integer.class, "centerFrequency", false, "CENTER_FREQUENCY");
        public static final Property ChannelFrequency = new Property(6, Integer.class, "channelFrequency", false, "CHANNEL_FREQUENCY");
        public static final Property ChannelWidth = new Property(4, Integer.class, "channelWidth", false, "CHANNEL_WIDTH");
        public static final Property EncryptionMethod = new Property(2, String.class, "encryptionMethod", false, "ENCRYPTION_METHOD");
        public static final Property Latitude = new Property(8, Double.class, "latitude", false, "LATITUDE");
        public static final Property LocationDescription = new Property(10, String.class, "locationDescription", false, "LOCATION_DESCRIPTION");
        public static final Property Longitude = new Property(9, Double.class, "longitude", false, "LONGITUDE");
        public static final Property MacAddress = new Property(0, String.class, "macAddress", true, "MAC_ADDRESS");
        public static final Property Name = new Property(1, String.class, "name", false, "NAME");
        public static final Property Note = new Property(7, String.class, "note", false, "NOTE");
        public static final Property SignalLevel = new Property(3, Integer.class, "signalLevel", false, "SIGNAL_LEVEL");
    }

    public WifiDetectorDao(DaoConfig config) {
        super(config);
    }

    public WifiDetectorDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"WIFI_DETECTOR\" (\"MAC_ADDRESS\" TEXT PRIMARY KEY NOT NULL ,\"NAME\" TEXT,\"ENCRYPTION_METHOD\" TEXT,\"SIGNAL_LEVEL\" INTEGER,\"CHANNEL_WIDTH\" INTEGER,\"CENTER_FREQUENCY\" INTEGER,\"CHANNEL_FREQUENCY\" INTEGER,\"NOTE\" TEXT,\"LATITUDE\" REAL,\"LONGITUDE\" REAL,\"LOCATION_DESCRIPTION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"WIFI_DETECTOR\"");
    }

    protected final void bindValues(DatabaseStatement stmt, WifiDetector entity) {
        stmt.clearBindings();
        String macAddress = entity.getMacAddress();
        if (macAddress != null) {
            stmt.bindString(1, macAddress);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        String encryptionMethod = entity.getEncryptionMethod();
        if (encryptionMethod != null) {
            stmt.bindString(3, encryptionMethod);
        }
        Integer signalLevel = entity.getSignalLevel();
        if (signalLevel != null) {
            stmt.bindLong(4, (long) signalLevel.intValue());
        }
        Integer channelWidth = entity.getChannelWidth();
        if (channelWidth != null) {
            stmt.bindLong(5, (long) channelWidth.intValue());
        }
        Integer centerFrequency = entity.getCenterFrequency();
        if (centerFrequency != null) {
            stmt.bindLong(6, (long) centerFrequency.intValue());
        }
        Integer channelFrequency = entity.getChannelFrequency();
        if (channelFrequency != null) {
            stmt.bindLong(7, (long) channelFrequency.intValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(8, note);
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(9, latitude.doubleValue());
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(10, longitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(11, locationDescription);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, WifiDetector entity) {
        stmt.clearBindings();
        String macAddress = entity.getMacAddress();
        if (macAddress != null) {
            stmt.bindString(1, macAddress);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        String encryptionMethod = entity.getEncryptionMethod();
        if (encryptionMethod != null) {
            stmt.bindString(3, encryptionMethod);
        }
        Integer signalLevel = entity.getSignalLevel();
        if (signalLevel != null) {
            stmt.bindLong(4, (long) signalLevel.intValue());
        }
        Integer channelWidth = entity.getChannelWidth();
        if (channelWidth != null) {
            stmt.bindLong(5, (long) channelWidth.intValue());
        }
        Integer centerFrequency = entity.getCenterFrequency();
        if (centerFrequency != null) {
            stmt.bindLong(6, (long) centerFrequency.intValue());
        }
        Integer channelFrequency = entity.getChannelFrequency();
        if (channelFrequency != null) {
            stmt.bindLong(7, (long) channelFrequency.intValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(8, note);
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(9, latitude.doubleValue());
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(10, longitude.doubleValue());
        }
        String locationDescription = entity.getLocationDescription();
        if (locationDescription != null) {
            stmt.bindString(11, locationDescription);
        }
    }

    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    public WifiDetector readEntity(Cursor cursor, int offset) {
        return new WifiDetector(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)), cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)), cursor.isNull(offset + 5) ? null : Integer.valueOf(cursor.getInt(offset + 5)), cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : Double.valueOf(cursor.getDouble(offset + 8)), cursor.isNull(offset + 9) ? null : Double.valueOf(cursor.getDouble(offset + 9)), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
    }

    public void readEntity(Cursor cursor, WifiDetector entity, int offset) {
        String str = null;
        entity.setMacAddress(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setEncryptionMethod(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSignalLevel(cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)));
        entity.setChannelWidth(cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)));
        entity.setCenterFrequency(cursor.isNull(offset + 5) ? null : Integer.valueOf(cursor.getInt(offset + 5)));
        entity.setChannelFrequency(cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)));
        entity.setNote(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setLatitude(cursor.isNull(offset + 8) ? null : Double.valueOf(cursor.getDouble(offset + 8)));
        entity.setLongitude(cursor.isNull(offset + 9) ? null : Double.valueOf(cursor.getDouble(offset + 9)));
        if (!cursor.isNull(offset + 10)) {
            str = cursor.getString(offset + 10);
        }
        entity.setLocationDescription(str);
    }

    protected final String updateKeyAfterInsert(WifiDetector entity, long rowId) {
        return entity.getMacAddress();
    }

    public String getKey(WifiDetector entity) {
        if (entity != null) {
            return entity.getMacAddress();
        }
        return null;
    }

    public boolean hasKey(WifiDetector entity) {
        return entity.getMacAddress() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
