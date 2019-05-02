package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.fec.xjoneproject.message.util.MessageConstant;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class ReportThingDao extends AbstractDao<ReportThing, Long> {
    public static final String TABLENAME = "REPORT_THING";

    public static class Properties {
        public static final Property Address = new Property(4, String.class, "address", false, "ADDRESS");
        public static final Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Identity = new Property(2, String.class, "identity", false, "IDENTITY");
        public static final Property Note = new Property(9, String.class, "note", false, "NOTE");
        public static final Property ObjectIdentifier = new Property(11, String.class, "objectIdentifier", false, "OBJECT_IDENTIFIER");
        public static final Property ObjectName = new Property(10, String.class, "objectName", false, "OBJECT_NAME");
        public static final Property Picture = new Property(8, String.class, MessageConstant.IMAGE_DESCRIPTION, false, "PICTURE");
        public static final Property SubmitLatitude = new Property(5, String.class, "submitLatitude", false, "SUBMIT_LATITUDE");
        public static final Property SubmitLongitude = new Property(6, String.class, "submitLongitude", false, "SUBMIT_LONGITUDE");
        public static final Property TotalID = new Property(1, Long.class, "totalID", false, "TOTAL_ID");
        public static final Property Voice = new Property(7, String.class, MessageConstant.VOCIE_DESCRIPTION, false, "VOICE");
    }

    public ReportThingDao(DaoConfig config) {
        super(config);
    }

    public ReportThingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"REPORT_THING\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TOTAL_ID\" INTEGER,\"IDENTITY\" TEXT,\"CONTENT\" TEXT,\"ADDRESS\" TEXT,\"SUBMIT_LATITUDE\" TEXT,\"SUBMIT_LONGITUDE\" TEXT,\"VOICE\" TEXT,\"PICTURE\" TEXT,\"NOTE\" TEXT,\"OBJECT_NAME\" TEXT,\"OBJECT_IDENTIFIER\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"REPORT_THING\"");
    }

    protected final void bindValues(DatabaseStatement stmt, ReportThing entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Long totalID = entity.getTotalID();
        if (totalID != null) {
            stmt.bindLong(2, totalID.longValue());
        }
        String identity = entity.getIdentity();
        if (identity != null) {
            stmt.bindString(3, identity);
        }
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
        String submitLatitude = entity.getSubmitLatitude();
        if (submitLatitude != null) {
            stmt.bindString(6, submitLatitude);
        }
        String submitLongitude = entity.getSubmitLongitude();
        if (submitLongitude != null) {
            stmt.bindString(7, submitLongitude);
        }
        String voice = entity.getVoice();
        if (voice != null) {
            stmt.bindString(8, voice);
        }
        String picture = entity.getPicture();
        if (picture != null) {
            stmt.bindString(9, picture);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(10, note);
        }
        String objectName = entity.getObjectName();
        if (objectName != null) {
            stmt.bindString(11, objectName);
        }
        String objectIdentifier = entity.getObjectIdentifier();
        if (objectIdentifier != null) {
            stmt.bindString(12, objectIdentifier);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, ReportThing entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Long totalID = entity.getTotalID();
        if (totalID != null) {
            stmt.bindLong(2, totalID.longValue());
        }
        String identity = entity.getIdentity();
        if (identity != null) {
            stmt.bindString(3, identity);
        }
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
        String submitLatitude = entity.getSubmitLatitude();
        if (submitLatitude != null) {
            stmt.bindString(6, submitLatitude);
        }
        String submitLongitude = entity.getSubmitLongitude();
        if (submitLongitude != null) {
            stmt.bindString(7, submitLongitude);
        }
        String voice = entity.getVoice();
        if (voice != null) {
            stmt.bindString(8, voice);
        }
        String picture = entity.getPicture();
        if (picture != null) {
            stmt.bindString(9, picture);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(10, note);
        }
        String objectName = entity.getObjectName();
        if (objectName != null) {
            stmt.bindString(11, objectName);
        }
        String objectIdentifier = entity.getObjectIdentifier();
        if (objectIdentifier != null) {
            stmt.bindString(12, objectIdentifier);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public ReportThing readEntity(Cursor cursor, int offset) {
        return new ReportThing(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
    }

    public void readEntity(Cursor cursor, ReportThing entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setTotalID(cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)));
        entity.setIdentity(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setContent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAddress(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSubmitLatitude(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSubmitLongitude(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setVoice(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPicture(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setNote(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setObjectName(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        if (!cursor.isNull(offset + 11)) {
            str = cursor.getString(offset + 11);
        }
        entity.setObjectIdentifier(str);
    }

    protected final Long updateKeyAfterInsert(ReportThing entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(ReportThing entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(ReportThing entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
