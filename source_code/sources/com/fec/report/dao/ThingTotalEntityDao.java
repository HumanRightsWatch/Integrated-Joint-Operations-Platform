package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fec.xjoneproject.message.util.MessageConstant;
import com.turui.bank.ocr.Intents.WifiConnect;
import org.apache.commons.net.ntp.NtpV3Packet;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class ThingTotalEntityDao extends AbstractDao<ThingTotalEntity, Long> {
    public static final String TABLENAME = "THING_TOTAL_ENTITY";

    public static class Properties {
        public static final Property Content = new Property(4, String.class, "content", false, "CONTENT");
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property IsSend = new Property(6, Integer.class, "isSend", false, "IS_SEND");
        public static final Property Name = new Property(5, String.class, "name", false, "NAME");
        public static final Property Picture = new Property(2, String.class, MessageConstant.IMAGE_DESCRIPTION, false, "PICTURE");
        public static final Property SubmitUCId = new Property(7, String.class, "submitUCId", false, "SUBMIT_UCID");
        public static final Property Time = new Property(3, String.class, "time", false, NtpV3Packet.TYPE_TIME);
        public static final Property Type = new Property(1, Integer.class, "type", false, WifiConnect.TYPE);
    }

    public ThingTotalEntityDao(DaoConfig config) {
        super(config);
    }

    public ThingTotalEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"THING_TOTAL_ENTITY\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TYPE\" INTEGER,\"PICTURE\" TEXT,\"TIME\" TEXT,\"CONTENT\" TEXT,\"NAME\" TEXT,\"IS_SEND\" INTEGER,\"SUBMIT_UCID\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"THING_TOTAL_ENTITY\"");
    }

    protected final void bindValues(DatabaseStatement stmt, ThingTotalEntity entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, (long) type.intValue());
        }
        String picture = entity.getPicture();
        if (picture != null) {
            stmt.bindString(3, picture);
        }
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(4, time);
        }
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(5, content);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
        Integer isSend = entity.getIsSend();
        if (isSend != null) {
            stmt.bindLong(7, (long) isSend.intValue());
        }
        String submitUCId = entity.getSubmitUCId();
        if (submitUCId != null) {
            stmt.bindString(8, submitUCId);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, ThingTotalEntity entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, (long) type.intValue());
        }
        String picture = entity.getPicture();
        if (picture != null) {
            stmt.bindString(3, picture);
        }
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(4, time);
        }
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(5, content);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(6, name);
        }
        Integer isSend = entity.getIsSend();
        if (isSend != null) {
            stmt.bindLong(7, (long) isSend.intValue());
        }
        String submitUCId = entity.getSubmitUCId();
        if (submitUCId != null) {
            stmt.bindString(8, submitUCId);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public ThingTotalEntity readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        Integer valueOf2 = cursor.isNull(offset + 1) ? null : Integer.valueOf(cursor.getInt(offset + 1));
        String string = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string4 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        Integer valueOf3 = cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6));
        if (!cursor.isNull(offset + 7)) {
            str = cursor.getString(offset + 7);
        }
        return new ThingTotalEntity(valueOf, valueOf2, string, string2, string3, string4, valueOf3, str);
    }

    public void readEntity(Cursor cursor, ThingTotalEntity entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setType(cursor.isNull(offset + 1) ? null : Integer.valueOf(cursor.getInt(offset + 1)));
        entity.setPicture(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setContent(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setIsSend(cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)));
        if (!cursor.isNull(offset + 7)) {
            str = cursor.getString(offset + 7);
        }
        entity.setSubmitUCId(str);
    }

    protected final Long updateKeyAfterInsert(ThingTotalEntity entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(ThingTotalEntity entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(ThingTotalEntity entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
