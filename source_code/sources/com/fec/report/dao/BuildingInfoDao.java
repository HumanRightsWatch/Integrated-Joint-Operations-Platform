package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class BuildingInfoDao extends AbstractDao<BuildingInfo, Long> {
    public static final String TABLENAME = "BUILDING_INFO";

    public static class Properties {
        public static final Property Address = new Property(6, String.class, "address", false, "ADDRESS");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Latitude = new Property(11, Double.class, "latitude", false, "LATITUDE");
        public static final Property Longitude = new Property(10, Double.class, "longitude", false, "LONGITUDE");
        public static final Property Modify_type = new Property(9, Integer.class, "modify_type", false, "MODIFY_TYPE");
        public static final Property Photo = new Property(8, String.class, "photo", false, "PHOTO");
        public static final Property Prefecture_id = new Property(2, String.class, "prefecture_id", false, "PREFECTURE_ID");
        public static final Property Prefecture_name = new Property(3, String.class, "prefecture_name", false, "PREFECTURE_NAME");
        public static final Property Purpose = new Property(7, Integer.class, "purpose", false, "PURPOSE");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property Village_id = new Property(4, String.class, "village_id", false, "VILLAGE_ID");
        public static final Property Village_name = new Property(5, String.class, "village_name", false, "VILLAGE_NAME");
    }

    public BuildingInfoDao(DaoConfig config) {
        super(config);
    }

    public BuildingInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"BUILDING_INFO\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"PREFECTURE_ID\" TEXT,\"PREFECTURE_NAME\" TEXT,\"VILLAGE_ID\" TEXT,\"VILLAGE_NAME\" TEXT,\"ADDRESS\" TEXT,\"PURPOSE\" INTEGER,\"PHOTO\" TEXT,\"MODIFY_TYPE\" INTEGER,\"LONGITUDE\" REAL,\"LATITUDE\" REAL);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BUILDING_INFO\"");
    }

    protected final void bindValues(DatabaseStatement stmt, BuildingInfo entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        String prefecture_id = entity.getPrefecture_id();
        if (prefecture_id != null) {
            stmt.bindString(3, prefecture_id);
        }
        String prefecture_name = entity.getPrefecture_name();
        if (prefecture_name != null) {
            stmt.bindString(4, prefecture_name);
        }
        String village_id = entity.getVillage_id();
        if (village_id != null) {
            stmt.bindString(5, village_id);
        }
        String village_name = entity.getVillage_name();
        if (village_name != null) {
            stmt.bindString(6, village_name);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(7, address);
        }
        Integer purpose = entity.getPurpose();
        if (purpose != null) {
            stmt.bindLong(8, (long) purpose.intValue());
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(9, photo);
        }
        Integer modify_type = entity.getModify_type();
        if (modify_type != null) {
            stmt.bindLong(10, (long) modify_type.intValue());
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(11, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(12, latitude.doubleValue());
        }
    }

    protected final void bindValues(SQLiteStatement stmt, BuildingInfo entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        String prefecture_id = entity.getPrefecture_id();
        if (prefecture_id != null) {
            stmt.bindString(3, prefecture_id);
        }
        String prefecture_name = entity.getPrefecture_name();
        if (prefecture_name != null) {
            stmt.bindString(4, prefecture_name);
        }
        String village_id = entity.getVillage_id();
        if (village_id != null) {
            stmt.bindString(5, village_id);
        }
        String village_name = entity.getVillage_name();
        if (village_name != null) {
            stmt.bindString(6, village_name);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(7, address);
        }
        Integer purpose = entity.getPurpose();
        if (purpose != null) {
            stmt.bindLong(8, (long) purpose.intValue());
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(9, photo);
        }
        Integer modify_type = entity.getModify_type();
        if (modify_type != null) {
            stmt.bindLong(10, (long) modify_type.intValue());
        }
        Double longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindDouble(11, longitude.doubleValue());
        }
        Double latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindDouble(12, latitude.doubleValue());
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public BuildingInfo readEntity(Cursor cursor, int offset) {
        return new BuildingInfo(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : Integer.valueOf(cursor.getInt(offset + 7)), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : Integer.valueOf(cursor.getInt(offset + 9)), cursor.isNull(offset + 10) ? null : Double.valueOf(cursor.getDouble(offset + 10)), cursor.isNull(offset + 11) ? null : Double.valueOf(cursor.getDouble(offset + 11)));
    }

    public void readEntity(Cursor cursor, BuildingInfo entity, int offset) {
        Double d = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPrefecture_id(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPrefecture_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setVillage_id(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setVillage_name(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAddress(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPurpose(cursor.isNull(offset + 7) ? null : Integer.valueOf(cursor.getInt(offset + 7)));
        entity.setPhoto(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setModify_type(cursor.isNull(offset + 9) ? null : Integer.valueOf(cursor.getInt(offset + 9)));
        entity.setLongitude(cursor.isNull(offset + 10) ? null : Double.valueOf(cursor.getDouble(offset + 10)));
        if (!cursor.isNull(offset + 11)) {
            d = Double.valueOf(cursor.getDouble(offset + 11));
        }
        entity.setLatitude(d);
    }

    protected final Long updateKeyAfterInsert(BuildingInfo entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(BuildingInfo entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(BuildingInfo entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
