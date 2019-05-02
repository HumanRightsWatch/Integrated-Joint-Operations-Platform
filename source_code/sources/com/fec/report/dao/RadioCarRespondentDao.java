package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class RadioCarRespondentDao extends AbstractDao<RadioCarRespondent, Long> {
    public static final String TABLENAME = "RADIO_CAR_RESPONDENT";
    private DaoSession daoSession;

    public static class Properties {
        public static final Property Check_name = new Property(13, String.class, "check_name", false, "CHECK_NAME");
        public static final Property Check_photo = new Property(14, String.class, "check_photo", false, "CHECK_PHOTO");
        public static final Property Check_relation_to_driver = new Property(15, Integer.class, "check_relation_to_driver", false, "CHECK_RELATION_TO_DRIVER");
        public static final Property CheckedReason = new Property(20, Integer.class, "checkedReason", false, "CHECKED_REASON");
        public static final Property Contraband_photo = new Property(6, String.class, "contraband_photo", false, "CONTRABAND_PHOTO");
        public static final Property Driver_id_number = new Property(7, String.class, "driver_id_number", false, "DRIVER_ID_NUMBER");
        public static final Property Driver_phone = new Property(8, String.class, "driver_phone", false, "DRIVER_PHONE");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property IsNeedSecondcheck = new Property(19, Integer.class, "isNeedSecondcheck", false, "IS_NEED_SECONDCHECK");
        public static final Property NoNeedCheckedReason = new Property(21, String.class, "noNeedCheckedReason", false, "NO_NEED_CHECKED_REASON");
        public static final Property Other_reason = new Property(12, String.class, "other_reason", false, "OTHER_REASON");
        public static final Property Person_to_card = new Property(16, Boolean.class, "person_to_card", false, "PERSON_TO_CARD");
        public static final Property Problem_type = new Property(10, Integer.class, "problem_type", false, "PROBLEM_TYPE");
        public static final Property Push_owner_id_number = new Property(4, String.class, "push_owner_id_number", false, "PUSH_OWNER_ID_NUMBER");
        public static final Property Push_owner_name = new Property(3, String.class, "push_owner_name", false, "PUSH_OWNER_NAME");
        public static final Property Push_photo = new Property(5, String.class, "push_photo", false, "PUSH_PHOTO");
        public static final Property Push_plate_number = new Property(2, String.class, "push_plate_number", false, "PUSH_PLATE_NUMBER");
        public static final Property Reason_for_differ = new Property(11, Integer.class, "reason_for_differ", false, "REASON_FOR_DIFFER");
        public static final Property Task_id = new Property(1, String.class, "task_id", false, "TASK_ID");
        public static final Property VehicleOrgName = new Property(18, String.class, "vehicleOrgName", false, "VEHICLE_ORG_NAME");
        public static final Property VehicleProperty = new Property(17, Integer.class, "vehicleProperty", false, "VEHICLE_PROPERTY");
        public static final Property Whether_contraband = new Property(9, Boolean.class, "whether_contraband", false, "WHETHER_CONTRABAND");
    }

    public RadioCarRespondentDao(DaoConfig config) {
        super(config);
    }

    public RadioCarRespondentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"RADIO_CAR_RESPONDENT\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TASK_ID\" TEXT,\"PUSH_PLATE_NUMBER\" TEXT,\"PUSH_OWNER_NAME\" TEXT,\"PUSH_OWNER_ID_NUMBER\" TEXT,\"PUSH_PHOTO\" TEXT,\"CONTRABAND_PHOTO\" TEXT,\"DRIVER_ID_NUMBER\" TEXT,\"DRIVER_PHONE\" TEXT,\"WHETHER_CONTRABAND\" INTEGER,\"PROBLEM_TYPE\" INTEGER,\"REASON_FOR_DIFFER\" INTEGER,\"OTHER_REASON\" TEXT,\"CHECK_NAME\" TEXT,\"CHECK_PHOTO\" TEXT,\"CHECK_RELATION_TO_DRIVER\" INTEGER,\"PERSON_TO_CARD\" INTEGER,\"VEHICLE_PROPERTY\" INTEGER,\"VEHICLE_ORG_NAME\" TEXT,\"IS_NEED_SECONDCHECK\" INTEGER,\"CHECKED_REASON\" INTEGER,\"NO_NEED_CHECKED_REASON\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RADIO_CAR_RESPONDENT\"");
    }

    protected final void bindValues(DatabaseStatement stmt, RadioCarRespondent entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String task_id = entity.getTask_id();
        if (task_id != null) {
            stmt.bindString(2, task_id);
        }
        String push_plate_number = entity.getPush_plate_number();
        if (push_plate_number != null) {
            stmt.bindString(3, push_plate_number);
        }
        String push_owner_name = entity.getPush_owner_name();
        if (push_owner_name != null) {
            stmt.bindString(4, push_owner_name);
        }
        String push_owner_id_number = entity.getPush_owner_id_number();
        if (push_owner_id_number != null) {
            stmt.bindString(5, push_owner_id_number);
        }
        String push_photo = entity.getPush_photo();
        if (push_photo != null) {
            stmt.bindString(6, push_photo);
        }
        String contraband_photo = entity.getContraband_photo();
        if (contraband_photo != null) {
            stmt.bindString(7, contraband_photo);
        }
        String driver_id_number = entity.getDriver_id_number();
        if (driver_id_number != null) {
            stmt.bindString(8, driver_id_number);
        }
        String driver_phone = entity.getDriver_phone();
        if (driver_phone != null) {
            stmt.bindString(9, driver_phone);
        }
        Boolean whether_contraband = entity.getWhether_contraband();
        if (whether_contraband != null) {
            stmt.bindLong(10, whether_contraband.booleanValue() ? 1 : 0);
        }
        Integer problem_type = entity.getProblem_type();
        if (problem_type != null) {
            stmt.bindLong(11, (long) problem_type.intValue());
        }
        Integer reason_for_differ = entity.getReason_for_differ();
        if (reason_for_differ != null) {
            stmt.bindLong(12, (long) reason_for_differ.intValue());
        }
        String other_reason = entity.getOther_reason();
        if (other_reason != null) {
            stmt.bindString(13, other_reason);
        }
        String check_name = entity.getCheck_name();
        if (check_name != null) {
            stmt.bindString(14, check_name);
        }
        String check_photo = entity.getCheck_photo();
        if (check_photo != null) {
            stmt.bindString(15, check_photo);
        }
        Integer check_relation_to_driver = entity.getCheck_relation_to_driver();
        if (check_relation_to_driver != null) {
            stmt.bindLong(16, (long) check_relation_to_driver.intValue());
        }
        Boolean person_to_card = entity.getPerson_to_card();
        if (person_to_card != null) {
            stmt.bindLong(17, person_to_card.booleanValue() ? 1 : 0);
        }
        Integer vehicleProperty = entity.getVehicleProperty();
        if (vehicleProperty != null) {
            stmt.bindLong(18, (long) vehicleProperty.intValue());
        }
        String vehicleOrgName = entity.getVehicleOrgName();
        if (vehicleOrgName != null) {
            stmt.bindString(19, vehicleOrgName);
        }
        Integer isNeedSecondcheck = entity.getIsNeedSecondcheck();
        if (isNeedSecondcheck != null) {
            stmt.bindLong(20, (long) isNeedSecondcheck.intValue());
        }
        Integer checkedReason = entity.getCheckedReason();
        if (checkedReason != null) {
            stmt.bindLong(21, (long) checkedReason.intValue());
        }
        String noNeedCheckedReason = entity.getNoNeedCheckedReason();
        if (noNeedCheckedReason != null) {
            stmt.bindString(22, noNeedCheckedReason);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, RadioCarRespondent entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String task_id = entity.getTask_id();
        if (task_id != null) {
            stmt.bindString(2, task_id);
        }
        String push_plate_number = entity.getPush_plate_number();
        if (push_plate_number != null) {
            stmt.bindString(3, push_plate_number);
        }
        String push_owner_name = entity.getPush_owner_name();
        if (push_owner_name != null) {
            stmt.bindString(4, push_owner_name);
        }
        String push_owner_id_number = entity.getPush_owner_id_number();
        if (push_owner_id_number != null) {
            stmt.bindString(5, push_owner_id_number);
        }
        String push_photo = entity.getPush_photo();
        if (push_photo != null) {
            stmt.bindString(6, push_photo);
        }
        String contraband_photo = entity.getContraband_photo();
        if (contraband_photo != null) {
            stmt.bindString(7, contraband_photo);
        }
        String driver_id_number = entity.getDriver_id_number();
        if (driver_id_number != null) {
            stmt.bindString(8, driver_id_number);
        }
        String driver_phone = entity.getDriver_phone();
        if (driver_phone != null) {
            stmt.bindString(9, driver_phone);
        }
        Boolean whether_contraband = entity.getWhether_contraband();
        if (whether_contraband != null) {
            stmt.bindLong(10, whether_contraband.booleanValue() ? 1 : 0);
        }
        Integer problem_type = entity.getProblem_type();
        if (problem_type != null) {
            stmt.bindLong(11, (long) problem_type.intValue());
        }
        Integer reason_for_differ = entity.getReason_for_differ();
        if (reason_for_differ != null) {
            stmt.bindLong(12, (long) reason_for_differ.intValue());
        }
        String other_reason = entity.getOther_reason();
        if (other_reason != null) {
            stmt.bindString(13, other_reason);
        }
        String check_name = entity.getCheck_name();
        if (check_name != null) {
            stmt.bindString(14, check_name);
        }
        String check_photo = entity.getCheck_photo();
        if (check_photo != null) {
            stmt.bindString(15, check_photo);
        }
        Integer check_relation_to_driver = entity.getCheck_relation_to_driver();
        if (check_relation_to_driver != null) {
            stmt.bindLong(16, (long) check_relation_to_driver.intValue());
        }
        Boolean person_to_card = entity.getPerson_to_card();
        if (person_to_card != null) {
            stmt.bindLong(17, person_to_card.booleanValue() ? 1 : 0);
        }
        Integer vehicleProperty = entity.getVehicleProperty();
        if (vehicleProperty != null) {
            stmt.bindLong(18, (long) vehicleProperty.intValue());
        }
        String vehicleOrgName = entity.getVehicleOrgName();
        if (vehicleOrgName != null) {
            stmt.bindString(19, vehicleOrgName);
        }
        Integer isNeedSecondcheck = entity.getIsNeedSecondcheck();
        if (isNeedSecondcheck != null) {
            stmt.bindLong(20, (long) isNeedSecondcheck.intValue());
        }
        Integer checkedReason = entity.getCheckedReason();
        if (checkedReason != null) {
            stmt.bindLong(21, (long) checkedReason.intValue());
        }
        String noNeedCheckedReason = entity.getNoNeedCheckedReason();
        if (noNeedCheckedReason != null) {
            stmt.bindString(22, noNeedCheckedReason);
        }
    }

    protected final void attachEntity(RadioCarRespondent entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(this.daoSession);
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public RadioCarRespondent readEntity(Cursor cursor, int offset) {
        Boolean bool;
        Boolean bool2;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        String string2 = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        String string3 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string4 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string5 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        String string6 = cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6);
        String string7 = cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7);
        String string8 = cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8);
        if (cursor.isNull(offset + 9)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(offset + 9) != (short) 0);
        }
        Integer valueOf2 = cursor.isNull(offset + 10) ? null : Integer.valueOf(cursor.getInt(offset + 10));
        Integer valueOf3 = cursor.isNull(offset + 11) ? null : Integer.valueOf(cursor.getInt(offset + 11));
        String string9 = cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12);
        String string10 = cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13);
        String string11 = cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14);
        Integer valueOf4 = cursor.isNull(offset + 15) ? null : Integer.valueOf(cursor.getInt(offset + 15));
        if (cursor.isNull(offset + 16)) {
            bool2 = null;
        } else {
            bool2 = Boolean.valueOf(cursor.getShort(offset + 16) != (short) 0);
        }
        return new RadioCarRespondent(valueOf, string, string2, string3, string4, string5, string6, string7, string8, bool, valueOf2, valueOf3, string9, string10, string11, valueOf4, bool2, cursor.isNull(offset + 17) ? null : Integer.valueOf(cursor.getInt(offset + 17)), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : Integer.valueOf(cursor.getInt(offset + 19)), cursor.isNull(offset + 20) ? null : Integer.valueOf(cursor.getInt(offset + 20)), cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
    }

    public void readEntity(Cursor cursor, RadioCarRespondent entity, int offset) {
        Boolean bool;
        boolean z = true;
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setTask_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPush_plate_number(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPush_owner_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPush_owner_id_number(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPush_photo(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setContraband_photo(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDriver_id_number(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDriver_phone(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        if (cursor.isNull(offset + 9)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(offset + 9) != (short) 0);
        }
        entity.setWhether_contraband(bool);
        entity.setProblem_type(cursor.isNull(offset + 10) ? null : Integer.valueOf(cursor.getInt(offset + 10)));
        entity.setReason_for_differ(cursor.isNull(offset + 11) ? null : Integer.valueOf(cursor.getInt(offset + 11)));
        entity.setOther_reason(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setCheck_name(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setCheck_photo(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setCheck_relation_to_driver(cursor.isNull(offset + 15) ? null : Integer.valueOf(cursor.getInt(offset + 15)));
        if (cursor.isNull(offset + 16)) {
            bool = null;
        } else {
            if (cursor.getShort(offset + 16) == (short) 0) {
                z = false;
            }
            bool = Boolean.valueOf(z);
        }
        entity.setPerson_to_card(bool);
        entity.setVehicleProperty(cursor.isNull(offset + 17) ? null : Integer.valueOf(cursor.getInt(offset + 17)));
        entity.setVehicleOrgName(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setIsNeedSecondcheck(cursor.isNull(offset + 19) ? null : Integer.valueOf(cursor.getInt(offset + 19)));
        entity.setCheckedReason(cursor.isNull(offset + 20) ? null : Integer.valueOf(cursor.getInt(offset + 20)));
        if (!cursor.isNull(offset + 21)) {
            str = cursor.getString(offset + 21);
        }
        entity.setNoNeedCheckedReason(str);
    }

    protected final Long updateKeyAfterInsert(RadioCarRespondent entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(RadioCarRespondent entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(RadioCarRespondent entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
