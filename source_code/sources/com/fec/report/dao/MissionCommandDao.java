package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fec.xjoneproject.ui.supervise.CollectionListFragment;
import com.turui.bank.ocr.Intents.WifiConnect;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class MissionCommandDao extends AbstractDao<MissionCommand, String> {
    public static final String TABLENAME = "MISSION_COMMAND";

    public static class Properties {
        public static final Property AddTime = new Property(4, String.class, "addTime", false, "ADD_TIME");
        public static final Property AddUserName = new Property(7, String.class, CollectionListFragment.ADDUSERNAME, false, "ADD_USER_NAME");
        public static final Property AddUserOrgId = new Property(8, String.class, "addUserOrgId", false, "ADD_USER_ORG_ID");
        public static final Property AddUserUcid = new Property(6, String.class, CollectionListFragment.ADDUSERUCID, false, "ADD_USER_UCID");
        public static final Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public static final Property Family = new Property(11, String.class, "family", false, "FAMILY");
        public static final Property FinishTime = new Property(5, String.class, "finishTime", false, "FINISH_TIME");
        public static final Property Id = new Property(0, String.class, "id", true, "ID");
        public static final Property Other = new Property(13, String.class, "other", false, "OTHER");
        public static final Property Photo = new Property(12, String.class, "photo", false, "PHOTO");
        public static final Property State = new Property(9, Integer.class, "state", false, "STATE");
        public static final Property SubmitTime = new Property(10, String.class, "submitTime", false, "SUBMIT_TIME");
        public static final Property Type = new Property(1, Integer.class, "type", false, WifiConnect.TYPE);
        public static final Property Urgency = new Property(3, Integer.class, "urgency", false, "URGENCY");
    }

    public MissionCommandDao(DaoConfig config) {
        super(config);
    }

    public MissionCommandDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"MISSION_COMMAND\" (\"ID\" TEXT PRIMARY KEY NOT NULL ,\"TYPE\" INTEGER,\"CONTENT\" TEXT,\"URGENCY\" INTEGER,\"ADD_TIME\" TEXT,\"FINISH_TIME\" TEXT,\"ADD_USER_UCID\" TEXT,\"ADD_USER_NAME\" TEXT,\"ADD_USER_ORG_ID\" TEXT,\"STATE\" INTEGER,\"SUBMIT_TIME\" TEXT,\"FAMILY\" TEXT,\"PHOTO\" TEXT,\"OTHER\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MISSION_COMMAND\"");
    }

    protected final void bindValues(DatabaseStatement stmt, MissionCommand entity) {
        stmt.clearBindings();
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, (long) type.intValue());
        }
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
        Integer urgency = entity.getUrgency();
        if (urgency != null) {
            stmt.bindLong(4, (long) urgency.intValue());
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(5, addTime);
        }
        String finishTime = entity.getFinishTime();
        if (finishTime != null) {
            stmt.bindString(6, finishTime);
        }
        String addUserUcid = entity.getAddUserUcid();
        if (addUserUcid != null) {
            stmt.bindString(7, addUserUcid);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(8, addUserName);
        }
        String addUserOrgId = entity.getAddUserOrgId();
        if (addUserOrgId != null) {
            stmt.bindString(9, addUserOrgId);
        }
        Integer state = entity.getState();
        if (state != null) {
            stmt.bindLong(10, (long) state.intValue());
        }
        String submitTime = entity.getSubmitTime();
        if (submitTime != null) {
            stmt.bindString(11, submitTime);
        }
        String family = entity.getFamily();
        if (family != null) {
            stmt.bindString(12, family);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(13, photo);
        }
        String other = entity.getOther();
        if (other != null) {
            stmt.bindString(14, other);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, MissionCommand entity) {
        stmt.clearBindings();
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, (long) type.intValue());
        }
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
        Integer urgency = entity.getUrgency();
        if (urgency != null) {
            stmt.bindLong(4, (long) urgency.intValue());
        }
        String addTime = entity.getAddTime();
        if (addTime != null) {
            stmt.bindString(5, addTime);
        }
        String finishTime = entity.getFinishTime();
        if (finishTime != null) {
            stmt.bindString(6, finishTime);
        }
        String addUserUcid = entity.getAddUserUcid();
        if (addUserUcid != null) {
            stmt.bindString(7, addUserUcid);
        }
        String addUserName = entity.getAddUserName();
        if (addUserName != null) {
            stmt.bindString(8, addUserName);
        }
        String addUserOrgId = entity.getAddUserOrgId();
        if (addUserOrgId != null) {
            stmt.bindString(9, addUserOrgId);
        }
        Integer state = entity.getState();
        if (state != null) {
            stmt.bindLong(10, (long) state.intValue());
        }
        String submitTime = entity.getSubmitTime();
        if (submitTime != null) {
            stmt.bindString(11, submitTime);
        }
        String family = entity.getFamily();
        if (family != null) {
            stmt.bindString(12, family);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(13, photo);
        }
        String other = entity.getOther();
        if (other != null) {
            stmt.bindString(14, other);
        }
    }

    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    public MissionCommand readEntity(Cursor cursor, int offset) {
        String str;
        Integer num;
        String str2;
        Integer num2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Integer num3;
        String str8;
        String str9;
        String str10;
        String str11;
        if (cursor.isNull(offset + 0)) {
            str = null;
        } else {
            str = cursor.getString(offset + 0);
        }
        if (cursor.isNull(offset + 1)) {
            num = null;
        } else {
            num = Integer.valueOf(cursor.getInt(offset + 1));
        }
        if (cursor.isNull(offset + 2)) {
            str2 = null;
        } else {
            str2 = cursor.getString(offset + 2);
        }
        if (cursor.isNull(offset + 3)) {
            num2 = null;
        } else {
            num2 = Integer.valueOf(cursor.getInt(offset + 3));
        }
        if (cursor.isNull(offset + 4)) {
            str3 = null;
        } else {
            str3 = cursor.getString(offset + 4);
        }
        if (cursor.isNull(offset + 5)) {
            str4 = null;
        } else {
            str4 = cursor.getString(offset + 5);
        }
        if (cursor.isNull(offset + 6)) {
            str5 = null;
        } else {
            str5 = cursor.getString(offset + 6);
        }
        if (cursor.isNull(offset + 7)) {
            str6 = null;
        } else {
            str6 = cursor.getString(offset + 7);
        }
        if (cursor.isNull(offset + 8)) {
            str7 = null;
        } else {
            str7 = cursor.getString(offset + 8);
        }
        if (cursor.isNull(offset + 9)) {
            num3 = null;
        } else {
            num3 = Integer.valueOf(cursor.getInt(offset + 9));
        }
        if (cursor.isNull(offset + 10)) {
            str8 = null;
        } else {
            str8 = cursor.getString(offset + 10);
        }
        if (cursor.isNull(offset + 11)) {
            str9 = null;
        } else {
            str9 = cursor.getString(offset + 11);
        }
        if (cursor.isNull(offset + 12)) {
            str10 = null;
        } else {
            str10 = cursor.getString(offset + 12);
        }
        if (cursor.isNull(offset + 13)) {
            str11 = null;
        } else {
            str11 = cursor.getString(offset + 13);
        }
        return new MissionCommand(str, num, str2, num2, str3, str4, str5, str6, str7, num3, str8, str9, str10, str11);
    }

    public void readEntity(Cursor cursor, MissionCommand entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setType(cursor.isNull(offset + 1) ? null : Integer.valueOf(cursor.getInt(offset + 1)));
        entity.setContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUrgency(cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)));
        entity.setAddTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setFinishTime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAddUserUcid(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setAddUserName(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setAddUserOrgId(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setState(cursor.isNull(offset + 9) ? null : Integer.valueOf(cursor.getInt(offset + 9)));
        entity.setSubmitTime(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setFamily(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setPhoto(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        if (!cursor.isNull(offset + 13)) {
            str = cursor.getString(offset + 13);
        }
        entity.setOther(str);
    }

    protected final String updateKeyAfterInsert(MissionCommand entity, long rowId) {
        return entity.getId();
    }

    public String getKey(MissionCommand entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(MissionCommand entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
