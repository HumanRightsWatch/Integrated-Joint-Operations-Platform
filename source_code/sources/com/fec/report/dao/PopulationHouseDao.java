package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fec.xjoneproject.message.util.MessageConstant;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class PopulationHouseDao extends AbstractDao<PopulationHouse, String> {
    public static final String TABLENAME = "POPULATION_HOUSE";

    public static class Properties {
        public static final Property AddTime = new Property(3, String.class, "addTime", false, "ADD_TIME");
        public static final Property Community = new Property(5, String.class, "community", false, "COMMUNITY");
        public static final Property CommunityCode = new Property(4, String.class, "communityCode", false, "COMMUNITY_CODE");
        public static final Property DistanceToFloatingPopulation = new Property(6, String.class, "distanceToFloatingPopulation", false, "DISTANCE_TO_FLOATING_POPULATION");
        public static final Property FkId = new Property(7, String.class, "fkId", false, "FK_ID");
        public static final Property HouseAddress = new Property(2, String.class, "houseAddress", false, "HOUSE_ADDRESS");
        public static final Property HouseLatitude = new Property(16, Double.class, "houseLatitude", false, "HOUSE_LATITUDE");
        public static final Property HouseLongitude = new Property(15, Double.class, "houseLongitude", false, "HOUSE_LONGITUDE");
        public static final Property Id = new Property(0, String.class, "id", true, "ID");
        public static final Property IsSend = new Property(9, String.class, "isSend", false, "IS_SEND");
        public static final Property Manager = new Property(10, String.class, "manager", false, "MANAGER");
        public static final Property ManagerPhone = new Property(11, String.class, "managerPhone", false, "MANAGER_PHONE");
        public static final Property Modifier = new Property(17, String.class, "modifier", false, "MODIFIER");
        public static final Property ModifyTime = new Property(18, String.class, "modifyTime", false, "MODIFY_TIME");
        public static final Property Note = new Property(13, String.class, "note", false, "NOTE");
        public static final Property OwnerIdCard = new Property(8, String.class, "ownerIdCard", false, "OWNER_ID_CARD");
        public static final Property OwnerName = new Property(1, String.class, "ownerName", false, "OWNER_NAME");
        public static final Property OwnerPhone = new Property(14, String.class, "ownerPhone", false, "OWNER_PHONE");
        public static final Property Picture = new Property(12, String.class, MessageConstant.IMAGE_DESCRIPTION, false, "PICTURE");
        public static final Property UserOrganizationId = new Property(19, String.class, "userOrganizationId", false, "USER_ORGANIZATION_ID");
    }

    public PopulationHouseDao(DaoConfig config) {
        super(config);
    }

    public PopulationHouseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"POPULATION_HOUSE\" (\"ID\" TEXT PRIMARY KEY NOT NULL ,\"OWNER_NAME\" TEXT,\"HOUSE_ADDRESS\" TEXT,\"ADD_TIME\" TEXT,\"COMMUNITY_CODE\" TEXT,\"COMMUNITY\" TEXT,\"DISTANCE_TO_FLOATING_POPULATION\" TEXT,\"FK_ID\" TEXT,\"OWNER_ID_CARD\" TEXT,\"IS_SEND\" TEXT,\"MANAGER\" TEXT,\"MANAGER_PHONE\" TEXT,\"PICTURE\" TEXT,\"NOTE\" TEXT,\"OWNER_PHONE\" TEXT,\"HOUSE_LONGITUDE\" REAL,\"HOUSE_LATITUDE\" REAL,\"MODIFIER\" TEXT,\"MODIFY_TIME\" TEXT,\"USER_ORGANIZATION_ID\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"POPULATION_HOUSE\"");
    }

    protected final void bindValues(DatabaseStatement stmt, PopulationHouse entity) {
        stmt.clearBindings();
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
        String ownerName = entity.getOwnerName();
        if (ownerName != null) {
            stmt.bindString(2, ownerName);
        }
        String houseAddress = entity.getHouseAddress();
        if (houseAddress != null) {
            stmt.bindString(3, houseAddress);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(4, addTime);
        }
        String communityCode = entity.getCommunityCode();
        if (communityCode != null) {
            stmt.bindString(5, communityCode);
        }
        String community = entity.getCommunity();
        if (community != null) {
            stmt.bindString(6, community);
        }
        String distanceToFloatingPopulation = entity.getDistanceToFloatingPopulation();
        if (distanceToFloatingPopulation != null) {
            stmt.bindString(7, distanceToFloatingPopulation);
        }
        String fkId = entity.getFkId();
        if (fkId != null) {
            stmt.bindString(8, fkId);
        }
        String ownerIdCard = entity.getOwnerIdCard();
        if (ownerIdCard != null) {
            stmt.bindString(9, ownerIdCard);
        }
        String isSend = entity.getIsSend();
        if (isSend != null) {
            stmt.bindString(10, isSend);
        }
        String manager = entity.getManager();
        if (manager != null) {
            stmt.bindString(11, manager);
        }
        String managerPhone = entity.getManagerPhone();
        if (managerPhone != null) {
            stmt.bindString(12, managerPhone);
        }
        String picture = entity.getPicture();
        if (picture != null) {
            stmt.bindString(13, picture);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(14, note);
        }
        String ownerPhone = entity.getOwnerPhone();
        if (ownerPhone != null) {
            stmt.bindString(15, ownerPhone);
        }
        Double houseLongitude = entity.getHouseLongitude();
        if (houseLongitude != null) {
            stmt.bindDouble(16, houseLongitude.doubleValue());
        }
        Double houseLatitude = entity.getHouseLatitude();
        if (houseLatitude != null) {
            stmt.bindDouble(17, houseLatitude.doubleValue());
        }
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(18, modifier);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(19, modifyTime);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(20, userOrganizationId);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, PopulationHouse entity) {
        stmt.clearBindings();
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
        String ownerName = entity.getOwnerName();
        if (ownerName != null) {
            stmt.bindString(2, ownerName);
        }
        String houseAddress = entity.getHouseAddress();
        if (houseAddress != null) {
            stmt.bindString(3, houseAddress);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(4, addTime);
        }
        String communityCode = entity.getCommunityCode();
        if (communityCode != null) {
            stmt.bindString(5, communityCode);
        }
        String community = entity.getCommunity();
        if (community != null) {
            stmt.bindString(6, community);
        }
        String distanceToFloatingPopulation = entity.getDistanceToFloatingPopulation();
        if (distanceToFloatingPopulation != null) {
            stmt.bindString(7, distanceToFloatingPopulation);
        }
        String fkId = entity.getFkId();
        if (fkId != null) {
            stmt.bindString(8, fkId);
        }
        String ownerIdCard = entity.getOwnerIdCard();
        if (ownerIdCard != null) {
            stmt.bindString(9, ownerIdCard);
        }
        String isSend = entity.getIsSend();
        if (isSend != null) {
            stmt.bindString(10, isSend);
        }
        String manager = entity.getManager();
        if (manager != null) {
            stmt.bindString(11, manager);
        }
        String managerPhone = entity.getManagerPhone();
        if (managerPhone != null) {
            stmt.bindString(12, managerPhone);
        }
        String picture = entity.getPicture();
        if (picture != null) {
            stmt.bindString(13, picture);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(14, note);
        }
        String ownerPhone = entity.getOwnerPhone();
        if (ownerPhone != null) {
            stmt.bindString(15, ownerPhone);
        }
        Double houseLongitude = entity.getHouseLongitude();
        if (houseLongitude != null) {
            stmt.bindDouble(16, houseLongitude.doubleValue());
        }
        Double houseLatitude = entity.getHouseLatitude();
        if (houseLatitude != null) {
            stmt.bindDouble(17, houseLatitude.doubleValue());
        }
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(18, modifier);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(19, modifyTime);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(20, userOrganizationId);
        }
    }

    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    public PopulationHouse readEntity(Cursor cursor, int offset) {
        return new PopulationHouse(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : Double.valueOf(cursor.getDouble(offset + 15)), cursor.isNull(offset + 16) ? null : Double.valueOf(cursor.getDouble(offset + 16)), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
    }

    public void readEntity(Cursor cursor, PopulationHouse entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setOwnerName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setHouseAddress(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAddTime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCommunityCode(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCommunity(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDistanceToFloatingPopulation(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setFkId(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setOwnerIdCard(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setIsSend(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setManager(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setManagerPhone(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setPicture(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setNote(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setOwnerPhone(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setHouseLongitude(cursor.isNull(offset + 15) ? null : Double.valueOf(cursor.getDouble(offset + 15)));
        entity.setHouseLatitude(cursor.isNull(offset + 16) ? null : Double.valueOf(cursor.getDouble(offset + 16)));
        entity.setModifier(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setModifyTime(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        if (!cursor.isNull(offset + 19)) {
            str = cursor.getString(offset + 19);
        }
        entity.setUserOrganizationId(str);
    }

    protected final String updateKeyAfterInsert(PopulationHouse entity, long rowId) {
        return entity.getId();
    }

    public String getKey(PopulationHouse entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(PopulationHouse entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
