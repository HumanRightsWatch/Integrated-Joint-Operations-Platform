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

public class ManualVehicleDao extends AbstractDao<ManualVehicle, Long> {
    public static final String TABLENAME = "MANUAL_VEHICLE";
    private Query<ManualVehicle> manualInfo_ManualVehicleListQuery;

    public static class Properties {
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property Local_fkIr = new Property(2, Long.class, "local_fkIr", false, "LOCAL_FK_IR");
        public static final Property Local_id = new Property(0, Long.class, "local_id", true, "LOCAL_ID");
        public static final Property Note = new Property(7, String.class, "note", false, "NOTE");
        public static final Property Photo = new Property(4, String.class, "photo", false, "PHOTO");
        public static final Property PlateNumber = new Property(3, String.class, "plateNumber", false, "PLATE_NUMBER");
        public static final Property VehicleColor = new Property(5, Integer.class, "vehicleColor", false, "VEHICLE_COLOR");
        public static final Property VehicleType = new Property(6, Integer.class, "vehicleType", false, "VEHICLE_TYPE");
    }

    public ManualVehicleDao(DaoConfig config) {
        super(config);
    }

    public ManualVehicleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"MANUAL_VEHICLE\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"LOCAL_FK_IR\" INTEGER,\"PLATE_NUMBER\" TEXT,\"PHOTO\" TEXT,\"VEHICLE_COLOR\" INTEGER,\"VEHICLE_TYPE\" INTEGER,\"NOTE\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MANUAL_VEHICLE\"");
    }

    protected final void bindValues(DatabaseStatement stmt, ManualVehicle entity) {
        stmt.clearBindings();
        Long local_id = entity.getLocal_id();
        if (local_id != null) {
            stmt.bindLong(1, local_id.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        Long local_fkIr = entity.getLocal_fkIr();
        if (local_fkIr != null) {
            stmt.bindLong(3, local_fkIr.longValue());
        }
        String plateNumber = entity.getPlateNumber();
        if (plateNumber != null) {
            stmt.bindString(4, plateNumber);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(5, photo);
        }
        Integer vehicleColor = entity.getVehicleColor();
        if (vehicleColor != null) {
            stmt.bindLong(6, (long) vehicleColor.intValue());
        }
        Integer vehicleType = entity.getVehicleType();
        if (vehicleType != null) {
            stmt.bindLong(7, (long) vehicleType.intValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(8, note);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, ManualVehicle entity) {
        stmt.clearBindings();
        Long local_id = entity.getLocal_id();
        if (local_id != null) {
            stmt.bindLong(1, local_id.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        Long local_fkIr = entity.getLocal_fkIr();
        if (local_fkIr != null) {
            stmt.bindLong(3, local_fkIr.longValue());
        }
        String plateNumber = entity.getPlateNumber();
        if (plateNumber != null) {
            stmt.bindString(4, plateNumber);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(5, photo);
        }
        Integer vehicleColor = entity.getVehicleColor();
        if (vehicleColor != null) {
            stmt.bindLong(6, (long) vehicleColor.intValue());
        }
        Integer vehicleType = entity.getVehicleType();
        if (vehicleType != null) {
            stmt.bindLong(7, (long) vehicleType.intValue());
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(8, note);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public ManualVehicle readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Long valueOf2 = cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2));
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        Integer valueOf3 = cursor.isNull(offset + 5) ? null : Integer.valueOf(cursor.getInt(offset + 5));
        Integer valueOf4 = cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6));
        if (!cursor.isNull(offset + 7)) {
            str = cursor.getString(offset + 7);
        }
        return new ManualVehicle(valueOf, string, valueOf2, string2, string3, valueOf3, valueOf4, str);
    }

    public void readEntity(Cursor cursor, ManualVehicle entity, int offset) {
        String str = null;
        entity.setLocal_id(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLocal_fkIr(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setPlateNumber(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPhoto(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setVehicleColor(cursor.isNull(offset + 5) ? null : Integer.valueOf(cursor.getInt(offset + 5)));
        entity.setVehicleType(cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)));
        if (!cursor.isNull(offset + 7)) {
            str = cursor.getString(offset + 7);
        }
        entity.setNote(str);
    }

    protected final Long updateKeyAfterInsert(ManualVehicle entity, long rowId) {
        entity.setLocal_id(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(ManualVehicle entity) {
        if (entity != null) {
            return entity.getLocal_id();
        }
        return null;
    }

    public boolean hasKey(ManualVehicle entity) {
        return entity.getLocal_id() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<ManualVehicle> _queryManualInfo_ManualVehicleList(Long local_fkIr) {
        synchronized (this) {
            if (this.manualInfo_ManualVehicleListQuery == null) {
                QueryBuilder<ManualVehicle> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Local_fkIr.eq(null), new WhereCondition[0]);
                this.manualInfo_ManualVehicleListQuery = queryBuilder.build();
            }
        }
        Query<ManualVehicle> query = this.manualInfo_ManualVehicleListQuery.forCurrentThread();
        query.setParameter(0, local_fkIr);
        return query.list();
    }
}
