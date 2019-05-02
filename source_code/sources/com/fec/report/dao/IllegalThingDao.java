package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fec.xjoneproject.message.util.MessageConstant;
import com.turui.bank.ocr.Intents.WifiConnect;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class IllegalThingDao extends AbstractDao<IllegalThing, Long> {
    public static final String TABLENAME = "ILLEGAL_THING";

    public static class Properties {
        public static final Property Address = new Property(3, String.class, "address", false, "ADDRESS");
        public static final Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Identity = new Property(9, String.class, "identity", false, "IDENTITY");
        public static final Property IsSend = new Property(8, String.class, "isSend", false, "IS_SEND");
        public static final Property Note = new Property(15, String.class, "note", false, "NOTE");
        public static final Property ObjectIdentifier = new Property(19, String.class, "objectIdentifier", false, "OBJECT_IDENTIFIER");
        public static final Property ObjectName = new Property(18, String.class, "objectName", false, "OBJECT_NAME");
        public static final Property Picture = new Property(7, String.class, MessageConstant.IMAGE_DESCRIPTION, false, "PICTURE");
        public static final Property RelativePerson = new Property(10, String.class, "relativePerson", false, "RELATIVE_PERSON");
        public static final Property RelativeThing = new Property(11, String.class, "relativeThing", false, "RELATIVE_THING");
        public static final Property SubmitLatitude = new Property(4, String.class, "submitLatitude", false, "SUBMIT_LATITUDE");
        public static final Property SubmitLongitude = new Property(5, String.class, "submitLongitude", false, "SUBMIT_LONGITUDE");
        public static final Property SubmitTime = new Property(16, String.class, "submitTime", false, "SUBMIT_TIME");
        public static final Property Submiter = new Property(13, String.class, "submiter", false, "SUBMITER");
        public static final Property SubmiterUCId = new Property(17, String.class, "submiterUCId", false, "SUBMITER_UCID");
        public static final Property Type = new Property(1, Integer.class, "type", false, WifiConnect.TYPE);
        public static final Property Urgency = new Property(12, Integer.class, "urgency", false, "URGENCY");
        public static final Property Video = new Property(14, String.class, "video", false, "VIDEO");
        public static final Property Voice = new Property(6, String.class, MessageConstant.VOCIE_DESCRIPTION, false, "VOICE");
    }

    public IllegalThingDao(DaoConfig config) {
        super(config);
    }

    public IllegalThingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"ILLEGAL_THING\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TYPE\" INTEGER,\"CONTENT\" TEXT,\"ADDRESS\" TEXT,\"SUBMIT_LATITUDE\" TEXT,\"SUBMIT_LONGITUDE\" TEXT,\"VOICE\" TEXT,\"PICTURE\" TEXT,\"IS_SEND\" TEXT,\"IDENTITY\" TEXT,\"RELATIVE_PERSON\" TEXT,\"RELATIVE_THING\" TEXT,\"URGENCY\" INTEGER,\"SUBMITER\" TEXT,\"VIDEO\" TEXT,\"NOTE\" TEXT,\"SUBMIT_TIME\" TEXT,\"SUBMITER_UCID\" TEXT,\"OBJECT_NAME\" TEXT,\"OBJECT_IDENTIFIER\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ILLEGAL_THING\"");
    }

    protected final void bindValues(DatabaseStatement stmt, IllegalThing entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, (long) type.intValue());
        }
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(4, address);
        }
        String submitLatitude = entity.getSubmitLatitude();
        if (submitLatitude != null) {
            stmt.bindString(5, submitLatitude);
        }
        String submitLongitude = entity.getSubmitLongitude();
        if (submitLongitude != null) {
            stmt.bindString(6, submitLongitude);
        }
        String voice = entity.getVoice();
        if (voice != null) {
            stmt.bindString(7, voice);
        }
        String picture = entity.getPicture();
        if (picture != null) {
            stmt.bindString(8, picture);
        }
        String isSend = entity.getIsSend();
        if (isSend != null) {
            stmt.bindString(9, isSend);
        }
        String identity = entity.getIdentity();
        if (identity != null) {
            stmt.bindString(10, identity);
        }
        String relativePerson = entity.getRelativePerson();
        if (relativePerson != null) {
            stmt.bindString(11, relativePerson);
        }
        String relativeThing = entity.getRelativeThing();
        if (relativeThing != null) {
            stmt.bindString(12, relativeThing);
        }
        Integer urgency = entity.getUrgency();
        if (urgency != null) {
            stmt.bindLong(13, (long) urgency.intValue());
        }
        String submiter = entity.getSubmiter();
        if (submiter != null) {
            stmt.bindString(14, submiter);
        }
        String video = entity.getVideo();
        if (video != null) {
            stmt.bindString(15, video);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(16, note);
        }
        String submitTime = entity.getSubmitTime();
        if (submitTime != null) {
            stmt.bindString(17, submitTime);
        }
        String submiterUCId = entity.getSubmiterUCId();
        if (submiterUCId != null) {
            stmt.bindString(18, submiterUCId);
        }
        String objectName = entity.getObjectName();
        if (objectName != null) {
            stmt.bindString(19, objectName);
        }
        String objectIdentifier = entity.getObjectIdentifier();
        if (objectIdentifier != null) {
            stmt.bindString(20, objectIdentifier);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, IllegalThing entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(2, (long) type.intValue());
        }
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(4, address);
        }
        String submitLatitude = entity.getSubmitLatitude();
        if (submitLatitude != null) {
            stmt.bindString(5, submitLatitude);
        }
        String submitLongitude = entity.getSubmitLongitude();
        if (submitLongitude != null) {
            stmt.bindString(6, submitLongitude);
        }
        String voice = entity.getVoice();
        if (voice != null) {
            stmt.bindString(7, voice);
        }
        String picture = entity.getPicture();
        if (picture != null) {
            stmt.bindString(8, picture);
        }
        String isSend = entity.getIsSend();
        if (isSend != null) {
            stmt.bindString(9, isSend);
        }
        String identity = entity.getIdentity();
        if (identity != null) {
            stmt.bindString(10, identity);
        }
        String relativePerson = entity.getRelativePerson();
        if (relativePerson != null) {
            stmt.bindString(11, relativePerson);
        }
        String relativeThing = entity.getRelativeThing();
        if (relativeThing != null) {
            stmt.bindString(12, relativeThing);
        }
        Integer urgency = entity.getUrgency();
        if (urgency != null) {
            stmt.bindLong(13, (long) urgency.intValue());
        }
        String submiter = entity.getSubmiter();
        if (submiter != null) {
            stmt.bindString(14, submiter);
        }
        String video = entity.getVideo();
        if (video != null) {
            stmt.bindString(15, video);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(16, note);
        }
        String submitTime = entity.getSubmitTime();
        if (submitTime != null) {
            stmt.bindString(17, submitTime);
        }
        String submiterUCId = entity.getSubmiterUCId();
        if (submiterUCId != null) {
            stmt.bindString(18, submiterUCId);
        }
        String objectName = entity.getObjectName();
        if (objectName != null) {
            stmt.bindString(19, objectName);
        }
        String objectIdentifier = entity.getObjectIdentifier();
        if (objectIdentifier != null) {
            stmt.bindString(20, objectIdentifier);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public IllegalThing readEntity(Cursor cursor, int offset) {
        return new IllegalThing(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : Integer.valueOf(cursor.getInt(offset + 1)), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : Integer.valueOf(cursor.getInt(offset + 12)), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
    }

    public void readEntity(Cursor cursor, IllegalThing entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setType(cursor.isNull(offset + 1) ? null : Integer.valueOf(cursor.getInt(offset + 1)));
        entity.setContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAddress(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSubmitLatitude(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSubmitLongitude(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setVoice(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPicture(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setIsSend(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setIdentity(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setRelativePerson(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setRelativeThing(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setUrgency(cursor.isNull(offset + 12) ? null : Integer.valueOf(cursor.getInt(offset + 12)));
        entity.setSubmiter(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setVideo(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setNote(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setSubmitTime(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setSubmiterUCId(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setObjectName(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        if (!cursor.isNull(offset + 19)) {
            str = cursor.getString(offset + 19);
        }
        entity.setObjectIdentifier(str);
    }

    protected final Long updateKeyAfterInsert(IllegalThing entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(IllegalThing entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(IllegalThing entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
