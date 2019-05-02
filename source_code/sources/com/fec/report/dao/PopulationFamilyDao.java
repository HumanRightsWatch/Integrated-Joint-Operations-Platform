package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class PopulationFamilyDao extends AbstractDao<PopulationFamily, String> {
    public static final String TABLENAME = "POPULATION_FAMILY";

    public static class Properties {
        public static final Property AddTime = new Property(9, String.class, "addTime", false, "ADD_TIME");
        public static final Property FkId = new Property(1, String.class, "fkId", false, "FK_ID");
        public static final Property HeadPortrait = new Property(7, String.class, "headPortrait", false, "HEAD_PORTRAIT");
        public static final Property Id = new Property(0, String.class, "id", true, "ID");
        public static final Property IdCard = new Property(3, String.class, "idCard", false, "ID_CARD");
        public static final Property IsSend = new Property(8, String.class, "isSend", false, "IS_SEND");
        public static final Property Modifier = new Property(11, String.class, "modifier", false, "MODIFIER");
        public static final Property ModifyTime = new Property(12, String.class, "modifyTime", false, "MODIFY_TIME");
        public static final Property Name = new Property(2, String.class, "name", false, "NAME");
        public static final Property Note = new Property(6, String.class, "note", false, "NOTE");
        public static final Property Phone = new Property(10, String.class, "phone", false, "PHONE");
        public static final Property RelationWithFloatingPopulation = new Property(5, String.class, "relationWithFloatingPopulation", false, "RELATION_WITH_FLOATING_POPULATION");
        public static final Property Residence = new Property(4, String.class, "residence", false, "RESIDENCE");
        public static final Property UserOrganizationId = new Property(13, String.class, "userOrganizationId", false, "USER_ORGANIZATION_ID");
    }

    public PopulationFamilyDao(DaoConfig config) {
        super(config);
    }

    public PopulationFamilyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"POPULATION_FAMILY\" (\"ID\" TEXT PRIMARY KEY NOT NULL ,\"FK_ID\" TEXT,\"NAME\" TEXT,\"ID_CARD\" TEXT,\"RESIDENCE\" TEXT,\"RELATION_WITH_FLOATING_POPULATION\" TEXT,\"NOTE\" TEXT,\"HEAD_PORTRAIT\" TEXT,\"IS_SEND\" TEXT,\"ADD_TIME\" TEXT,\"PHONE\" TEXT,\"MODIFIER\" TEXT,\"MODIFY_TIME\" TEXT,\"USER_ORGANIZATION_ID\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"POPULATION_FAMILY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, PopulationFamily entity) {
        stmt.clearBindings();
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
        String fkId = entity.getFkId();
        if (fkId != null) {
            stmt.bindString(2, fkId);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(4, idCard);
        }
        String residence = entity.getResidence();
        if (residence != null) {
            stmt.bindString(5, residence);
        }
        String relationWithFloatingPopulation = entity.getRelationWithFloatingPopulation();
        if (relationWithFloatingPopulation != null) {
            stmt.bindString(6, relationWithFloatingPopulation);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(7, note);
        }
        String headPortrait = entity.getHeadPortrait();
        if (headPortrait != null) {
            stmt.bindString(8, headPortrait);
        }
        String isSend = entity.getIsSend();
        if (isSend != null) {
            stmt.bindString(9, isSend);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(10, addTime);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(11, phone);
        }
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(12, modifier);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(13, modifyTime);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(14, userOrganizationId);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, PopulationFamily entity) {
        stmt.clearBindings();
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
        String fkId = entity.getFkId();
        if (fkId != null) {
            stmt.bindString(2, fkId);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
        String idCard = entity.getIdCard();
        if (idCard != null) {
            stmt.bindString(4, idCard);
        }
        String residence = entity.getResidence();
        if (residence != null) {
            stmt.bindString(5, residence);
        }
        String relationWithFloatingPopulation = entity.getRelationWithFloatingPopulation();
        if (relationWithFloatingPopulation != null) {
            stmt.bindString(6, relationWithFloatingPopulation);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(7, note);
        }
        String headPortrait = entity.getHeadPortrait();
        if (headPortrait != null) {
            stmt.bindString(8, headPortrait);
        }
        String isSend = entity.getIsSend();
        if (isSend != null) {
            stmt.bindString(9, isSend);
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(10, addTime);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(11, phone);
        }
        String modifier = entity.getModifier();
        if (modifier != null) {
            stmt.bindString(12, modifier);
        }
        String modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindString(13, modifyTime);
        }
        String userOrganizationId = entity.getUserOrganizationId();
        if (userOrganizationId != null) {
            stmt.bindString(14, userOrganizationId);
        }
    }

    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    public PopulationFamily readEntity(Cursor cursor, int offset) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        if (cursor.isNull(offset + 0)) {
            str = null;
        } else {
            str = cursor.getString(offset + 0);
        }
        if (cursor.isNull(offset + 1)) {
            str2 = null;
        } else {
            str2 = cursor.getString(offset + 1);
        }
        if (cursor.isNull(offset + 2)) {
            str3 = null;
        } else {
            str3 = cursor.getString(offset + 2);
        }
        if (cursor.isNull(offset + 3)) {
            str4 = null;
        } else {
            str4 = cursor.getString(offset + 3);
        }
        if (cursor.isNull(offset + 4)) {
            str5 = null;
        } else {
            str5 = cursor.getString(offset + 4);
        }
        if (cursor.isNull(offset + 5)) {
            str6 = null;
        } else {
            str6 = cursor.getString(offset + 5);
        }
        if (cursor.isNull(offset + 6)) {
            str7 = null;
        } else {
            str7 = cursor.getString(offset + 6);
        }
        if (cursor.isNull(offset + 7)) {
            str8 = null;
        } else {
            str8 = cursor.getString(offset + 7);
        }
        if (cursor.isNull(offset + 8)) {
            str9 = null;
        } else {
            str9 = cursor.getString(offset + 8);
        }
        if (cursor.isNull(offset + 9)) {
            str10 = null;
        } else {
            str10 = cursor.getString(offset + 9);
        }
        if (cursor.isNull(offset + 10)) {
            str11 = null;
        } else {
            str11 = cursor.getString(offset + 10);
        }
        if (cursor.isNull(offset + 11)) {
            str12 = null;
        } else {
            str12 = cursor.getString(offset + 11);
        }
        if (cursor.isNull(offset + 12)) {
            str13 = null;
        } else {
            str13 = cursor.getString(offset + 12);
        }
        if (cursor.isNull(offset + 13)) {
            str14 = null;
        } else {
            str14 = cursor.getString(offset + 13);
        }
        return new PopulationFamily(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public void readEntity(Cursor cursor, PopulationFamily entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setFkId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIdCard(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setResidence(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRelationWithFloatingPopulation(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setNote(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setHeadPortrait(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setIsSend(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setAddTime(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPhone(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setModifier(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setModifyTime(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        if (!cursor.isNull(offset + 13)) {
            str = cursor.getString(offset + 13);
        }
        entity.setUserOrganizationId(str);
    }

    protected final String updateKeyAfterInsert(PopulationFamily entity, long rowId) {
        return entity.getId();
    }

    public String getKey(PopulationFamily entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(PopulationFamily entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
