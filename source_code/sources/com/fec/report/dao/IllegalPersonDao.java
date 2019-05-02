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

public class IllegalPersonDao extends AbstractDao<IllegalPerson, Long> {
    public static final String TABLENAME = "ILLEGAL_PERSON";

    public static class Properties {
        public static final Property Address = new Property(3, String.class, "address", false, "ADDRESS");
        public static final Property Car_identity = new Property(18, String.class, "car_identity", false, "CAR_IDENTITY");
        public static final Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public static final Property Current_address = new Property(21, String.class, "current_address", false, "CURRENT_ADDRESS");
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Identity = new Property(9, String.class, "identity", false, "IDENTITY");
        public static final Property IsSend = new Property(8, String.class, "isSend", false, "IS_SEND");
        public static final Property Note = new Property(15, String.class, "note", false, "NOTE");
        public static final Property Phone = new Property(20, String.class, "phone", false, "PHONE");
        public static final Property Picture = new Property(7, String.class, MessageConstant.IMAGE_DESCRIPTION, false, "PICTURE");
        public static final Property Power_number = new Property(19, String.class, "power_number", false, "POWER_NUMBER");
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

    public IllegalPersonDao(DaoConfig config) {
        super(config);
    }

    public IllegalPersonDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"ILLEGAL_PERSON\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TYPE\" INTEGER,\"CONTENT\" TEXT,\"ADDRESS\" TEXT,\"SUBMIT_LATITUDE\" TEXT,\"SUBMIT_LONGITUDE\" TEXT,\"VOICE\" TEXT,\"PICTURE\" TEXT,\"IS_SEND\" TEXT,\"IDENTITY\" TEXT,\"RELATIVE_PERSON\" TEXT,\"RELATIVE_THING\" TEXT,\"URGENCY\" INTEGER,\"SUBMITER\" TEXT,\"VIDEO\" TEXT,\"NOTE\" TEXT,\"SUBMIT_TIME\" TEXT,\"SUBMITER_UCID\" TEXT,\"CAR_IDENTITY\" TEXT,\"POWER_NUMBER\" TEXT,\"PHONE\" TEXT,\"CURRENT_ADDRESS\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ILLEGAL_PERSON\"");
    }

    protected final void bindValues(DatabaseStatement stmt, IllegalPerson entity) {
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
        String car_identity = entity.getCar_identity();
        if (car_identity != null) {
            stmt.bindString(19, car_identity);
        }
        String power_number = entity.getPower_number();
        if (power_number != null) {
            stmt.bindString(20, power_number);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(21, phone);
        }
        String current_address = entity.getCurrent_address();
        if (current_address != null) {
            stmt.bindString(22, current_address);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, IllegalPerson entity) {
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
        String car_identity = entity.getCar_identity();
        if (car_identity != null) {
            stmt.bindString(19, car_identity);
        }
        String power_number = entity.getPower_number();
        if (power_number != null) {
            stmt.bindString(20, power_number);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(21, phone);
        }
        String current_address = entity.getCurrent_address();
        if (current_address != null) {
            stmt.bindString(22, current_address);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public IllegalPerson readEntity(Cursor cursor, int offset) {
        return new IllegalPerson(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : Integer.valueOf(cursor.getInt(offset + 1)), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : Integer.valueOf(cursor.getInt(offset + 12)), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
    }

    public void readEntity(Cursor cursor, IllegalPerson entity, int offset) {
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
        entity.setCar_identity(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setPower_number(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setPhone(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        if (!cursor.isNull(offset + 21)) {
            str = cursor.getString(offset + 21);
        }
        entity.setCurrent_address(str);
    }

    protected final Long updateKeyAfterInsert(IllegalPerson entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(IllegalPerson entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(IllegalPerson entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
