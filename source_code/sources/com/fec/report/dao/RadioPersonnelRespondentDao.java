package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class RadioPersonnelRespondentDao extends AbstractDao<RadioPersonnelRespondent, Long> {
    public static final String TABLENAME = "RADIO_PERSONNEL_RESPONDENT";
    private DaoSession daoSession;

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property Id_number = new Property(8, String.class, "id_number", false, "ID_NUMBER");
        public static final Property Leavev_local = new Property(19, Integer.class, "leavev_local", false, "LEAVEV_LOCAL");
        public static final Property Other_to_inner_land_reason = new Property(17, String.class, "other_to_inner_land_reason", false, "OTHER_TO_INNER_LAND_REASON");
        public static final Property Phone = new Property(9, String.class, "phone", false, "PHONE");
        public static final Property Push_action = new Property(13, Integer.class, "push_action", false, "PUSH_ACTION");
        public static final Property Push_disposition = new Property(12, String.class, "push_disposition", false, "PUSH_DISPOSITION");
        public static final Property Push_home_address = new Property(4, String.class, "push_home_address", false, "PUSH_HOME_ADDRESS");
        public static final Property Push_id_number = new Property(3, String.class, "push_id_number", false, "PUSH_ID_NUMBER");
        public static final Property Push_match_type = new Property(6, Integer.class, "push_match_type", false, "PUSH_MATCH_TYPE");
        public static final Property Push_name = new Property(2, String.class, "push_name", false, "PUSH_NAME");
        public static final Property Push_people_type = new Property(7, Integer.class, "push_people_type", false, "PUSH_PEOPLE_TYPE");
        public static final Property Push_photo = new Property(5, String.class, "push_photo", false, "PUSH_PHOTO");
        public static final Property Return_date = new Property(18, String.class, "return_date", false, "RETURN_DATE");
        public static final Property Task_id = new Property(1, String.class, "task_id", false, "TASK_ID");
        public static final Property To_inner_land_reason = new Property(16, Integer.class, "to_inner_land_reason", false, "TO_INNER_LAND_REASON");
        public static final Property Whether_consistent = new Property(14, Integer.class, "whether_consistent", false, "WHETHER_CONSISTENT");
        public static final Property Whether_dubious = new Property(15, Integer.class, "whether_dubious", false, "WHETHER_DUBIOUS");
        public static final Property Whether_leave = new Property(10, Integer.class, "whether_leave", false, "WHETHER_LEAVE");
        public static final Property Whether_warning = new Property(11, Integer.class, "whether_warning", false, "WHETHER_WARNING");
    }

    public RadioPersonnelRespondentDao(DaoConfig config) {
        super(config);
    }

    public RadioPersonnelRespondentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"RADIO_PERSONNEL_RESPONDENT\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TASK_ID\" TEXT,\"PUSH_NAME\" TEXT,\"PUSH_ID_NUMBER\" TEXT,\"PUSH_HOME_ADDRESS\" TEXT,\"PUSH_PHOTO\" TEXT,\"PUSH_MATCH_TYPE\" INTEGER,\"PUSH_PEOPLE_TYPE\" INTEGER,\"ID_NUMBER\" TEXT,\"PHONE\" TEXT,\"WHETHER_LEAVE\" INTEGER,\"WHETHER_WARNING\" INTEGER,\"PUSH_DISPOSITION\" TEXT,\"PUSH_ACTION\" INTEGER,\"WHETHER_CONSISTENT\" INTEGER,\"WHETHER_DUBIOUS\" INTEGER,\"TO_INNER_LAND_REASON\" INTEGER,\"OTHER_TO_INNER_LAND_REASON\" TEXT,\"RETURN_DATE\" TEXT,\"LEAVEV_LOCAL\" INTEGER);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RADIO_PERSONNEL_RESPONDENT\"");
    }

    protected final void bindValues(DatabaseStatement stmt, RadioPersonnelRespondent entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String task_id = entity.getTask_id();
        if (task_id != null) {
            stmt.bindString(2, task_id);
        }
        String push_name = entity.getPush_name();
        if (push_name != null) {
            stmt.bindString(3, push_name);
        }
        String push_id_number = entity.getPush_id_number();
        if (push_id_number != null) {
            stmt.bindString(4, push_id_number);
        }
        String push_home_address = entity.getPush_home_address();
        if (push_home_address != null) {
            stmt.bindString(5, push_home_address);
        }
        String push_photo = entity.getPush_photo();
        if (push_photo != null) {
            stmt.bindString(6, push_photo);
        }
        Integer push_match_type = entity.getPush_match_type();
        if (push_match_type != null) {
            stmt.bindLong(7, (long) push_match_type.intValue());
        }
        Integer push_people_type = entity.getPush_people_type();
        if (push_people_type != null) {
            stmt.bindLong(8, (long) push_people_type.intValue());
        }
        String id_number = entity.getId_number();
        if (id_number != null) {
            stmt.bindString(9, id_number);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(10, phone);
        }
        Integer whether_leave = entity.getWhether_leave();
        if (whether_leave != null) {
            stmt.bindLong(11, (long) whether_leave.intValue());
        }
        Integer whether_warning = entity.getWhether_warning();
        if (whether_warning != null) {
            stmt.bindLong(12, (long) whether_warning.intValue());
        }
        String push_disposition = entity.getPush_disposition();
        if (push_disposition != null) {
            stmt.bindString(13, push_disposition);
        }
        Integer push_action = entity.getPush_action();
        if (push_action != null) {
            stmt.bindLong(14, (long) push_action.intValue());
        }
        Integer whether_consistent = entity.getWhether_consistent();
        if (whether_consistent != null) {
            stmt.bindLong(15, (long) whether_consistent.intValue());
        }
        Integer whether_dubious = entity.getWhether_dubious();
        if (whether_dubious != null) {
            stmt.bindLong(16, (long) whether_dubious.intValue());
        }
        Integer to_inner_land_reason = entity.getTo_inner_land_reason();
        if (to_inner_land_reason != null) {
            stmt.bindLong(17, (long) to_inner_land_reason.intValue());
        }
        String other_to_inner_land_reason = entity.getOther_to_inner_land_reason();
        if (other_to_inner_land_reason != null) {
            stmt.bindString(18, other_to_inner_land_reason);
        }
        String return_date = entity.getReturn_date();
        if (return_date != null) {
            stmt.bindString(19, return_date);
        }
        Integer leavev_local = entity.getLeavev_local();
        if (leavev_local != null) {
            stmt.bindLong(20, (long) leavev_local.intValue());
        }
    }

    protected final void bindValues(SQLiteStatement stmt, RadioPersonnelRespondent entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String task_id = entity.getTask_id();
        if (task_id != null) {
            stmt.bindString(2, task_id);
        }
        String push_name = entity.getPush_name();
        if (push_name != null) {
            stmt.bindString(3, push_name);
        }
        String push_id_number = entity.getPush_id_number();
        if (push_id_number != null) {
            stmt.bindString(4, push_id_number);
        }
        String push_home_address = entity.getPush_home_address();
        if (push_home_address != null) {
            stmt.bindString(5, push_home_address);
        }
        String push_photo = entity.getPush_photo();
        if (push_photo != null) {
            stmt.bindString(6, push_photo);
        }
        Integer push_match_type = entity.getPush_match_type();
        if (push_match_type != null) {
            stmt.bindLong(7, (long) push_match_type.intValue());
        }
        Integer push_people_type = entity.getPush_people_type();
        if (push_people_type != null) {
            stmt.bindLong(8, (long) push_people_type.intValue());
        }
        String id_number = entity.getId_number();
        if (id_number != null) {
            stmt.bindString(9, id_number);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(10, phone);
        }
        Integer whether_leave = entity.getWhether_leave();
        if (whether_leave != null) {
            stmt.bindLong(11, (long) whether_leave.intValue());
        }
        Integer whether_warning = entity.getWhether_warning();
        if (whether_warning != null) {
            stmt.bindLong(12, (long) whether_warning.intValue());
        }
        String push_disposition = entity.getPush_disposition();
        if (push_disposition != null) {
            stmt.bindString(13, push_disposition);
        }
        Integer push_action = entity.getPush_action();
        if (push_action != null) {
            stmt.bindLong(14, (long) push_action.intValue());
        }
        Integer whether_consistent = entity.getWhether_consistent();
        if (whether_consistent != null) {
            stmt.bindLong(15, (long) whether_consistent.intValue());
        }
        Integer whether_dubious = entity.getWhether_dubious();
        if (whether_dubious != null) {
            stmt.bindLong(16, (long) whether_dubious.intValue());
        }
        Integer to_inner_land_reason = entity.getTo_inner_land_reason();
        if (to_inner_land_reason != null) {
            stmt.bindLong(17, (long) to_inner_land_reason.intValue());
        }
        String other_to_inner_land_reason = entity.getOther_to_inner_land_reason();
        if (other_to_inner_land_reason != null) {
            stmt.bindString(18, other_to_inner_land_reason);
        }
        String return_date = entity.getReturn_date();
        if (return_date != null) {
            stmt.bindString(19, return_date);
        }
        Integer leavev_local = entity.getLeavev_local();
        if (leavev_local != null) {
            stmt.bindLong(20, (long) leavev_local.intValue());
        }
    }

    protected final void attachEntity(RadioPersonnelRespondent entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(this.daoSession);
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public RadioPersonnelRespondent readEntity(Cursor cursor, int offset) {
        return new RadioPersonnelRespondent(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)), cursor.isNull(offset + 7) ? null : Integer.valueOf(cursor.getInt(offset + 7)), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : Integer.valueOf(cursor.getInt(offset + 10)), cursor.isNull(offset + 11) ? null : Integer.valueOf(cursor.getInt(offset + 11)), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : Integer.valueOf(cursor.getInt(offset + 13)), cursor.isNull(offset + 14) ? null : Integer.valueOf(cursor.getInt(offset + 14)), cursor.isNull(offset + 15) ? null : Integer.valueOf(cursor.getInt(offset + 15)), cursor.isNull(offset + 16) ? null : Integer.valueOf(cursor.getInt(offset + 16)), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : Integer.valueOf(cursor.getInt(offset + 19)));
    }

    public void readEntity(Cursor cursor, RadioPersonnelRespondent entity, int offset) {
        Integer num = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setTask_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPush_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPush_id_number(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPush_home_address(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPush_photo(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPush_match_type(cursor.isNull(offset + 6) ? null : Integer.valueOf(cursor.getInt(offset + 6)));
        entity.setPush_people_type(cursor.isNull(offset + 7) ? null : Integer.valueOf(cursor.getInt(offset + 7)));
        entity.setId_number(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPhone(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setWhether_leave(cursor.isNull(offset + 10) ? null : Integer.valueOf(cursor.getInt(offset + 10)));
        entity.setWhether_warning(cursor.isNull(offset + 11) ? null : Integer.valueOf(cursor.getInt(offset + 11)));
        entity.setPush_disposition(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setPush_action(cursor.isNull(offset + 13) ? null : Integer.valueOf(cursor.getInt(offset + 13)));
        entity.setWhether_consistent(cursor.isNull(offset + 14) ? null : Integer.valueOf(cursor.getInt(offset + 14)));
        entity.setWhether_dubious(cursor.isNull(offset + 15) ? null : Integer.valueOf(cursor.getInt(offset + 15)));
        entity.setTo_inner_land_reason(cursor.isNull(offset + 16) ? null : Integer.valueOf(cursor.getInt(offset + 16)));
        entity.setOther_to_inner_land_reason(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setReturn_date(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        if (!cursor.isNull(offset + 19)) {
            num = Integer.valueOf(cursor.getInt(offset + 19));
        }
        entity.setLeavev_local(num);
    }

    protected final Long updateKeyAfterInsert(RadioPersonnelRespondent entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(RadioPersonnelRespondent entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(RadioPersonnelRespondent entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
