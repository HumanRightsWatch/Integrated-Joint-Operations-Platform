package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class HouseInfoDao extends AbstractDao<HouseInfo, Long> {
    public static final String TABLENAME = "HOUSE_INFO";

    public static class Properties {
        public static final Property Building_id = new Property(2, Long.class, "building_id", false, "BUILDING_ID");
        public static final Property Electricity_meter = new Property(4, String.class, "electricity_meter", false, "ELECTRICITY_METER");
        public static final Property Gas_meter = new Property(6, String.class, "gas_meter", false, "GAS_METER");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Num = new Property(3, String.class, "num", false, "NUM");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property Water_meter = new Property(5, String.class, "water_meter", false, "WATER_METER");
    }

    public HouseInfoDao(DaoConfig config) {
        super(config);
    }

    public HouseInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"HOUSE_INFO\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"BUILDING_ID\" INTEGER,\"NUM\" TEXT,\"ELECTRICITY_METER\" TEXT,\"WATER_METER\" TEXT,\"GAS_METER\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HOUSE_INFO\"");
    }

    protected final void bindValues(DatabaseStatement stmt, HouseInfo entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Long building_id = entity.getBuilding_id();
        if (building_id != null) {
            stmt.bindLong(3, building_id.longValue());
        }
        String num = entity.getNum();
        if (num != null) {
            stmt.bindString(4, num);
        }
        String electricity_meter = entity.getElectricity_meter();
        if (electricity_meter != null) {
            stmt.bindString(5, electricity_meter);
        }
        String water_meter = entity.getWater_meter();
        if (water_meter != null) {
            stmt.bindString(6, water_meter);
        }
        String gas_meter = entity.getGas_meter();
        if (gas_meter != null) {
            stmt.bindString(7, gas_meter);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, HouseInfo entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String service_id = entity.getService_id();
        if (service_id != null) {
            stmt.bindString(2, service_id);
        }
        Long building_id = entity.getBuilding_id();
        if (building_id != null) {
            stmt.bindLong(3, building_id.longValue());
        }
        String num = entity.getNum();
        if (num != null) {
            stmt.bindString(4, num);
        }
        String electricity_meter = entity.getElectricity_meter();
        if (electricity_meter != null) {
            stmt.bindString(5, electricity_meter);
        }
        String water_meter = entity.getWater_meter();
        if (water_meter != null) {
            stmt.bindString(6, water_meter);
        }
        String gas_meter = entity.getGas_meter();
        if (gas_meter != null) {
            stmt.bindString(7, gas_meter);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public HouseInfo readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Long valueOf2 = cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2));
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string4 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        if (!cursor.isNull(offset + 6)) {
            str = cursor.getString(offset + 6);
        }
        return new HouseInfo(valueOf, string, valueOf2, string2, string3, string4, str);
    }

    public void readEntity(Cursor cursor, HouseInfo entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setBuilding_id(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setNum(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setElectricity_meter(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setWater_meter(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        if (!cursor.isNull(offset + 6)) {
            str = cursor.getString(offset + 6);
        }
        entity.setGas_meter(str);
    }

    protected final Long updateKeyAfterInsert(HouseInfo entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(HouseInfo entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(HouseInfo entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
