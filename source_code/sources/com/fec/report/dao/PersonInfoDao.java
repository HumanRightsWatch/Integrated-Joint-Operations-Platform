package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.codetroopers.betterpickers.calendardatepicker.MonthView;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class PersonInfoDao extends AbstractDao<PersonInfo, Long> {
    public static final String TABLENAME = "PERSON_INFO";
    private DaoSession daoSession;

    public static class Properties {
        public static final Property Action = new Property(43, String.class, "action", false, "ACTION");
        public static final Property Add_user = new Property(24, String.class, "add_user", false, "ADD_USER");
        public static final Property Address = new Property(6, String.class, "address", false, "ADDRESS");
        public static final Property AsylumEducateReason = new Property(42, String.class, "AsylumEducateReason", false, "ASYLUM_EDUCATE_REASON");
        public static final Property Birthday = new Property(18, String.class, "birthday", false, "BIRTHDAY");
        public static final Property Blood = new Property(20, Integer.class, "blood", false, "BLOOD");
        public static final Property Building_id = new Property(2, Long.class, "building_id", false, "BUILDING_ID");
        public static final Property Car = new Property(10, String.class, "car", false, "CAR");
        public static final Property Card = new Property(5, String.class, "card", false, "CARD");
        public static final Property Card_number = new Property(28, String.class, "card_number", false, "CARD_NUMBER");
        public static final Property Card_type = new Property(27, Integer.class, "card_type", false, "CARD_TYPE");
        public static final Property Certi_agree = new Property(34, Integer.class, "certi_agree", false, "CERTI_AGREE");
        public static final Property Collection_theme = new Property(33, Integer.class, "collection_theme", false, "COLLECTION_THEME");
        public static final Property Count = new Property(47, Integer.class, "count", false, "COUNT");
        public static final Property Current_address = new Property(45, String.class, "current_address", false, "CURRENT_ADDRESS");
        public static final Property Description = new Property(44, String.class, "description", false, "DESCRIPTION");
        public static final Property Destination_country = new Property(29, String.class, "destination_country", false, "DESTINATION_COUNTRY");
        public static final Property Educational = new Property(12, Integer.class, "educational", false, "EDUCATIONAL");
        public static final Property Exit_other_reason = new Property(32, String.class, "exit_other_reason", false, "EXIT_OTHER_REASON");
        public static final Property Exit_reason = new Property(31, Integer.class, "exit_reason", false, "EXIT_REASON");
        public static final Property Exit_time = new Property(30, String.class, "exit_time", false, "EXIT_TIME");
        public static final Property Height = new Property(19, String.class, MonthView.VIEW_PARAMS_HEIGHT, false, "HEIGHT");
        public static final Property House_id = new Property(3, Long.class, "house_id", false, "HOUSE_ID");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property IsChangeIdin = new Property(36, Integer.class, "isChangeIdin", false, "IS_CHANGE_IDIN");
        public static final Property Modify_type = new Property(8, Integer.class, "modify_type", false, "MODIFY_TYPE");
        public static final Property Name = new Property(4, String.class, "name", false, "NAME");
        public static final Property Nation = new Property(21, String.class, "nation", false, "NATION");
        public static final Property NewCensus = new Property(38, String.class, "newCensus", false, "NEW_CENSUS");
        public static final Property NewIdCard = new Property(39, String.class, "newIdCard", false, "NEW_ID_CARD");
        public static final Property NewName = new Property(37, String.class, "newName", false, "NEW_NAME");
        public static final Property NewNation = new Property(40, String.class, "newNation", false, "NEW_NATION");
        public static final Property Passport = new Property(41, String.class, "passport", false, "PASSPORT");
        public static final Property Person_type = new Property(25, String.class, "person_type", false, "PERSON_TYPE");
        public static final Property Person_type_other = new Property(26, String.class, "person_type_other", false, "PERSON_TYPE_OTHER");
        public static final Property Phone = new Property(9, String.class, "phone", false, "PHONE");
        public static final Property Photo = new Property(7, String.class, "photo", false, "PHOTO");
        public static final Property Political_status = new Property(16, Integer.class, "political_status", false, "POLITICAL_STATUS");
        public static final Property Political_status_other = new Property(17, String.class, "political_status_other", false, "POLITICAL_STATUS_OTHER");
        public static final Property Relationship = new Property(22, Integer.class, "relationship", false, "RELATIONSHIP");
        public static final Property Relationshipother = new Property(23, String.class, "relationshipother", false, "RELATIONSHIPOTHER");
        public static final Property Religious_atmosphere = new Property(13, Integer.class, "religious_atmosphere", false, "RELIGIOUS_ATMOSPHERE");
        public static final Property Religious_name = new Property(14, Integer.class, "religious_name", false, "RELIGIOUS_NAME");
        public static final Property Religious_name_other = new Property(15, String.class, "religious_name_other", false, "RELIGIOUS_NAME_OTHER");
        public static final Property SendPhoto = new Property(46, String.class, "sendPhoto", false, "SEND_PHOTO");
        public static final Property Service_id = new Property(1, String.class, "service_id", false, "SERVICE_ID");
        public static final Property ToCensus = new Property(35, String.class, "toCensus", false, "TO_CENSUS");
        public static final Property Work = new Property(11, String.class, "work", false, "WORK");
    }

    public PersonInfoDao(DaoConfig config) {
        super(config);
    }

    public PersonInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"PERSON_INFO\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SERVICE_ID\" TEXT,\"BUILDING_ID\" INTEGER,\"HOUSE_ID\" INTEGER,\"NAME\" TEXT,\"CARD\" TEXT,\"ADDRESS\" TEXT,\"PHOTO\" TEXT,\"MODIFY_TYPE\" INTEGER,\"PHONE\" TEXT,\"CAR\" TEXT,\"WORK\" TEXT,\"EDUCATIONAL\" INTEGER,\"RELIGIOUS_ATMOSPHERE\" INTEGER,\"RELIGIOUS_NAME\" INTEGER,\"RELIGIOUS_NAME_OTHER\" TEXT,\"POLITICAL_STATUS\" INTEGER,\"POLITICAL_STATUS_OTHER\" TEXT,\"BIRTHDAY\" TEXT,\"HEIGHT\" TEXT,\"BLOOD\" INTEGER,\"NATION\" TEXT,\"RELATIONSHIP\" INTEGER,\"RELATIONSHIPOTHER\" TEXT,\"ADD_USER\" TEXT,\"PERSON_TYPE\" TEXT,\"PERSON_TYPE_OTHER\" TEXT,\"CARD_TYPE\" INTEGER,\"CARD_NUMBER\" TEXT,\"DESTINATION_COUNTRY\" TEXT,\"EXIT_TIME\" TEXT,\"EXIT_REASON\" INTEGER,\"EXIT_OTHER_REASON\" TEXT,\"COLLECTION_THEME\" INTEGER,\"CERTI_AGREE\" INTEGER,\"TO_CENSUS\" TEXT,\"IS_CHANGE_IDIN\" INTEGER,\"NEW_NAME\" TEXT,\"NEW_CENSUS\" TEXT,\"NEW_ID_CARD\" TEXT,\"NEW_NATION\" TEXT,\"PASSPORT\" TEXT,\"ASYLUM_EDUCATE_REASON\" TEXT,\"ACTION\" TEXT,\"DESCRIPTION\" TEXT,\"CURRENT_ADDRESS\" TEXT,\"SEND_PHOTO\" TEXT,\"COUNT\" INTEGER);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PERSON_INFO\"");
    }

    protected final void bindValues(DatabaseStatement stmt, PersonInfo entity) {
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
        Long house_id = entity.getHouse_id();
        if (house_id != null) {
            stmt.bindLong(4, house_id.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
        String card = entity.getCard();
        if (card != null) {
            stmt.bindString(6, card);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(7, address);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(8, photo);
        }
        Integer modify_type = entity.getModify_type();
        if (modify_type != null) {
            stmt.bindLong(9, (long) modify_type.intValue());
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(10, phone);
        }
        String car = entity.getCar();
        if (car != null) {
            stmt.bindString(11, car);
        }
        String work = entity.getWork();
        if (work != null) {
            stmt.bindString(12, work);
        }
        Integer educational = entity.getEducational();
        if (educational != null) {
            stmt.bindLong(13, (long) educational.intValue());
        }
        Integer religious_atmosphere = entity.getReligious_atmosphere();
        if (religious_atmosphere != null) {
            stmt.bindLong(14, (long) religious_atmosphere.intValue());
        }
        Integer religious_name = entity.getReligious_name();
        if (religious_name != null) {
            stmt.bindLong(15, (long) religious_name.intValue());
        }
        String religious_name_other = entity.getReligious_name_other();
        if (religious_name_other != null) {
            stmt.bindString(16, religious_name_other);
        }
        Integer political_status = entity.getPolitical_status();
        if (political_status != null) {
            stmt.bindLong(17, (long) political_status.intValue());
        }
        String political_status_other = entity.getPolitical_status_other();
        if (political_status_other != null) {
            stmt.bindString(18, political_status_other);
        }
        String birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindString(19, birthday);
        }
        String height = entity.getHeight();
        if (height != null) {
            stmt.bindString(20, height);
        }
        Integer blood = entity.getBlood();
        if (blood != null) {
            stmt.bindLong(21, (long) blood.intValue());
        }
        String nation = entity.getNation();
        if (nation != null) {
            stmt.bindString(22, nation);
        }
        Integer relationship = entity.getRelationship();
        if (relationship != null) {
            stmt.bindLong(23, (long) relationship.intValue());
        }
        String relationshipother = entity.getRelationshipother();
        if (relationshipother != null) {
            stmt.bindString(24, relationshipother);
        }
        String add_user = entity.getAdd_user();
        if (add_user != null) {
            stmt.bindString(25, add_user);
        }
        String person_type = entity.getPerson_type();
        if (person_type != null) {
            stmt.bindString(26, person_type);
        }
        String person_type_other = entity.getPerson_type_other();
        if (person_type_other != null) {
            stmt.bindString(27, person_type_other);
        }
        Integer card_type = entity.getCard_type();
        if (card_type != null) {
            stmt.bindLong(28, (long) card_type.intValue());
        }
        String card_number = entity.getCard_number();
        if (card_number != null) {
            stmt.bindString(29, card_number);
        }
        String destination_country = entity.getDestination_country();
        if (destination_country != null) {
            stmt.bindString(30, destination_country);
        }
        String exit_time = entity.getExit_time();
        if (exit_time != null) {
            stmt.bindString(31, exit_time);
        }
        Integer exit_reason = entity.getExit_reason();
        if (exit_reason != null) {
            stmt.bindLong(32, (long) exit_reason.intValue());
        }
        String exit_other_reason = entity.getExit_other_reason();
        if (exit_other_reason != null) {
            stmt.bindString(33, exit_other_reason);
        }
        Integer collection_theme = entity.getCollection_theme();
        if (collection_theme != null) {
            stmt.bindLong(34, (long) collection_theme.intValue());
        }
        Integer certi_agree = entity.getCerti_agree();
        if (certi_agree != null) {
            stmt.bindLong(35, (long) certi_agree.intValue());
        }
        String toCensus = entity.getToCensus();
        if (toCensus != null) {
            stmt.bindString(36, toCensus);
        }
        Integer isChangeIdin = entity.getIsChangeIdin();
        if (isChangeIdin != null) {
            stmt.bindLong(37, (long) isChangeIdin.intValue());
        }
        String newName = entity.getNewName();
        if (newName != null) {
            stmt.bindString(38, newName);
        }
        String newCensus = entity.getNewCensus();
        if (newCensus != null) {
            stmt.bindString(39, newCensus);
        }
        String newIdCard = entity.getNewIdCard();
        if (newIdCard != null) {
            stmt.bindString(40, newIdCard);
        }
        String newNation = entity.getNewNation();
        if (newNation != null) {
            stmt.bindString(41, newNation);
        }
        String passport = entity.getPassport();
        if (passport != null) {
            stmt.bindString(42, passport);
        }
        String AsylumEducateReason = entity.getAsylumEducateReason();
        if (AsylumEducateReason != null) {
            stmt.bindString(43, AsylumEducateReason);
        }
        String action = entity.getAction();
        if (action != null) {
            stmt.bindString(44, action);
        }
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(45, description);
        }
        String current_address = entity.getCurrent_address();
        if (current_address != null) {
            stmt.bindString(46, current_address);
        }
        String sendPhoto = entity.getSendPhoto();
        if (sendPhoto != null) {
            stmt.bindString(47, sendPhoto);
        }
        Integer count = entity.getCount();
        if (count != null) {
            stmt.bindLong(48, (long) count.intValue());
        }
    }

    protected final void bindValues(SQLiteStatement stmt, PersonInfo entity) {
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
        Long house_id = entity.getHouse_id();
        if (house_id != null) {
            stmt.bindLong(4, house_id.longValue());
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
        String card = entity.getCard();
        if (card != null) {
            stmt.bindString(6, card);
        }
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(7, address);
        }
        String photo = entity.getPhoto();
        if (photo != null) {
            stmt.bindString(8, photo);
        }
        Integer modify_type = entity.getModify_type();
        if (modify_type != null) {
            stmt.bindLong(9, (long) modify_type.intValue());
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(10, phone);
        }
        String car = entity.getCar();
        if (car != null) {
            stmt.bindString(11, car);
        }
        String work = entity.getWork();
        if (work != null) {
            stmt.bindString(12, work);
        }
        Integer educational = entity.getEducational();
        if (educational != null) {
            stmt.bindLong(13, (long) educational.intValue());
        }
        Integer religious_atmosphere = entity.getReligious_atmosphere();
        if (religious_atmosphere != null) {
            stmt.bindLong(14, (long) religious_atmosphere.intValue());
        }
        Integer religious_name = entity.getReligious_name();
        if (religious_name != null) {
            stmt.bindLong(15, (long) religious_name.intValue());
        }
        String religious_name_other = entity.getReligious_name_other();
        if (religious_name_other != null) {
            stmt.bindString(16, religious_name_other);
        }
        Integer political_status = entity.getPolitical_status();
        if (political_status != null) {
            stmt.bindLong(17, (long) political_status.intValue());
        }
        String political_status_other = entity.getPolitical_status_other();
        if (political_status_other != null) {
            stmt.bindString(18, political_status_other);
        }
        String birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindString(19, birthday);
        }
        String height = entity.getHeight();
        if (height != null) {
            stmt.bindString(20, height);
        }
        Integer blood = entity.getBlood();
        if (blood != null) {
            stmt.bindLong(21, (long) blood.intValue());
        }
        String nation = entity.getNation();
        if (nation != null) {
            stmt.bindString(22, nation);
        }
        Integer relationship = entity.getRelationship();
        if (relationship != null) {
            stmt.bindLong(23, (long) relationship.intValue());
        }
        String relationshipother = entity.getRelationshipother();
        if (relationshipother != null) {
            stmt.bindString(24, relationshipother);
        }
        String add_user = entity.getAdd_user();
        if (add_user != null) {
            stmt.bindString(25, add_user);
        }
        String person_type = entity.getPerson_type();
        if (person_type != null) {
            stmt.bindString(26, person_type);
        }
        String person_type_other = entity.getPerson_type_other();
        if (person_type_other != null) {
            stmt.bindString(27, person_type_other);
        }
        Integer card_type = entity.getCard_type();
        if (card_type != null) {
            stmt.bindLong(28, (long) card_type.intValue());
        }
        String card_number = entity.getCard_number();
        if (card_number != null) {
            stmt.bindString(29, card_number);
        }
        String destination_country = entity.getDestination_country();
        if (destination_country != null) {
            stmt.bindString(30, destination_country);
        }
        String exit_time = entity.getExit_time();
        if (exit_time != null) {
            stmt.bindString(31, exit_time);
        }
        Integer exit_reason = entity.getExit_reason();
        if (exit_reason != null) {
            stmt.bindLong(32, (long) exit_reason.intValue());
        }
        String exit_other_reason = entity.getExit_other_reason();
        if (exit_other_reason != null) {
            stmt.bindString(33, exit_other_reason);
        }
        Integer collection_theme = entity.getCollection_theme();
        if (collection_theme != null) {
            stmt.bindLong(34, (long) collection_theme.intValue());
        }
        Integer certi_agree = entity.getCerti_agree();
        if (certi_agree != null) {
            stmt.bindLong(35, (long) certi_agree.intValue());
        }
        String toCensus = entity.getToCensus();
        if (toCensus != null) {
            stmt.bindString(36, toCensus);
        }
        Integer isChangeIdin = entity.getIsChangeIdin();
        if (isChangeIdin != null) {
            stmt.bindLong(37, (long) isChangeIdin.intValue());
        }
        String newName = entity.getNewName();
        if (newName != null) {
            stmt.bindString(38, newName);
        }
        String newCensus = entity.getNewCensus();
        if (newCensus != null) {
            stmt.bindString(39, newCensus);
        }
        String newIdCard = entity.getNewIdCard();
        if (newIdCard != null) {
            stmt.bindString(40, newIdCard);
        }
        String newNation = entity.getNewNation();
        if (newNation != null) {
            stmt.bindString(41, newNation);
        }
        String passport = entity.getPassport();
        if (passport != null) {
            stmt.bindString(42, passport);
        }
        String AsylumEducateReason = entity.getAsylumEducateReason();
        if (AsylumEducateReason != null) {
            stmt.bindString(43, AsylumEducateReason);
        }
        String action = entity.getAction();
        if (action != null) {
            stmt.bindString(44, action);
        }
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(45, description);
        }
        String current_address = entity.getCurrent_address();
        if (current_address != null) {
            stmt.bindString(46, current_address);
        }
        String sendPhoto = entity.getSendPhoto();
        if (sendPhoto != null) {
            stmt.bindString(47, sendPhoto);
        }
        Integer count = entity.getCount();
        if (count != null) {
            stmt.bindLong(48, (long) count.intValue());
        }
    }

    protected final void attachEntity(PersonInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(this.daoSession);
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public PersonInfo readEntity(Cursor cursor, int offset) {
        return new PersonInfo(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)), cursor.isNull(offset + 3) ? null : Long.valueOf(cursor.getLong(offset + 3)), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : Integer.valueOf(cursor.getInt(offset + 8)), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : Integer.valueOf(cursor.getInt(offset + 12)), cursor.isNull(offset + 13) ? null : Integer.valueOf(cursor.getInt(offset + 13)), cursor.isNull(offset + 14) ? null : Integer.valueOf(cursor.getInt(offset + 14)), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), cursor.isNull(offset + 16) ? null : Integer.valueOf(cursor.getInt(offset + 16)), cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), cursor.isNull(offset + 20) ? null : Integer.valueOf(cursor.getInt(offset + 20)), cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), cursor.isNull(offset + 22) ? null : Integer.valueOf(cursor.getInt(offset + 22)), cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), cursor.isNull(offset + 27) ? null : Integer.valueOf(cursor.getInt(offset + 27)), cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), cursor.isNull(offset + 31) ? null : Integer.valueOf(cursor.getInt(offset + 31)), cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32), cursor.isNull(offset + 33) ? null : Integer.valueOf(cursor.getInt(offset + 33)), cursor.isNull(offset + 34) ? null : Integer.valueOf(cursor.getInt(offset + 34)), cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35), cursor.isNull(offset + 36) ? null : Integer.valueOf(cursor.getInt(offset + 36)), cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37), cursor.isNull(offset + 38) ? null : cursor.getString(offset + 38), cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39), cursor.isNull(offset + 40) ? null : cursor.getString(offset + 40), cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41), cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42), cursor.isNull(offset + 43) ? null : cursor.getString(offset + 43), cursor.isNull(offset + 44) ? null : cursor.getString(offset + 44), cursor.isNull(offset + 45) ? null : cursor.getString(offset + 45), cursor.isNull(offset + 46) ? null : cursor.getString(offset + 46), cursor.isNull(offset + 47) ? null : Integer.valueOf(cursor.getInt(offset + 47)));
    }

    public void readEntity(Cursor cursor, PersonInfo entity, int offset) {
        Integer num = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setService_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setBuilding_id(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setHouse_id(cursor.isNull(offset + 3) ? null : Long.valueOf(cursor.getLong(offset + 3)));
        entity.setName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCard(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAddress(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPhoto(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setModify_type(cursor.isNull(offset + 8) ? null : Integer.valueOf(cursor.getInt(offset + 8)));
        entity.setPhone(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setCar(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setWork(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setEducational(cursor.isNull(offset + 12) ? null : Integer.valueOf(cursor.getInt(offset + 12)));
        entity.setReligious_atmosphere(cursor.isNull(offset + 13) ? null : Integer.valueOf(cursor.getInt(offset + 13)));
        entity.setReligious_name(cursor.isNull(offset + 14) ? null : Integer.valueOf(cursor.getInt(offset + 14)));
        entity.setReligious_name_other(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setPolitical_status(cursor.isNull(offset + 16) ? null : Integer.valueOf(cursor.getInt(offset + 16)));
        entity.setPolitical_status_other(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setBirthday(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setHeight(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setBlood(cursor.isNull(offset + 20) ? null : Integer.valueOf(cursor.getInt(offset + 20)));
        entity.setNation(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setRelationship(cursor.isNull(offset + 22) ? null : Integer.valueOf(cursor.getInt(offset + 22)));
        entity.setRelationshipother(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setAdd_user(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setPerson_type(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setPerson_type_other(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setCard_type(cursor.isNull(offset + 27) ? null : Integer.valueOf(cursor.getInt(offset + 27)));
        entity.setCard_number(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setDestination_country(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setExit_time(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setExit_reason(cursor.isNull(offset + 31) ? null : Integer.valueOf(cursor.getInt(offset + 31)));
        entity.setExit_other_reason(cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32));
        entity.setCollection_theme(cursor.isNull(offset + 33) ? null : Integer.valueOf(cursor.getInt(offset + 33)));
        entity.setCerti_agree(cursor.isNull(offset + 34) ? null : Integer.valueOf(cursor.getInt(offset + 34)));
        entity.setToCensus(cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35));
        entity.setIsChangeIdin(cursor.isNull(offset + 36) ? null : Integer.valueOf(cursor.getInt(offset + 36)));
        entity.setNewName(cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37));
        entity.setNewCensus(cursor.isNull(offset + 38) ? null : cursor.getString(offset + 38));
        entity.setNewIdCard(cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39));
        entity.setNewNation(cursor.isNull(offset + 40) ? null : cursor.getString(offset + 40));
        entity.setPassport(cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41));
        entity.setAsylumEducateReason(cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42));
        entity.setAction(cursor.isNull(offset + 43) ? null : cursor.getString(offset + 43));
        entity.setDescription(cursor.isNull(offset + 44) ? null : cursor.getString(offset + 44));
        entity.setCurrent_address(cursor.isNull(offset + 45) ? null : cursor.getString(offset + 45));
        entity.setSendPhoto(cursor.isNull(offset + 46) ? null : cursor.getString(offset + 46));
        if (!cursor.isNull(offset + 47)) {
            num = Integer.valueOf(cursor.getInt(offset + 47));
        }
        entity.setCount(num);
    }

    protected final Long updateKeyAfterInsert(PersonInfo entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(PersonInfo entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(PersonInfo entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
