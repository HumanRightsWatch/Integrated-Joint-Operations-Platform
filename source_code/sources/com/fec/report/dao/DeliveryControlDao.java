package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class DeliveryControlDao extends AbstractDao<DeliveryControl, Long> {
    public static final String TABLENAME = "DELIVERY_CONTROL";

    public static class Properties {
        public static final Property AfterOpenPhoto = new Property(15, String.class, "afterOpenPhoto", false, "AFTER_OPEN_PHOTO");
        public static final Property BeforeOpenPhoto = new Property(14, String.class, "beforeOpenPhoto", false, "BEFORE_OPEN_PHOTO");
        public static final Property CompanyAddress = new Property(3, String.class, "companyAddress", false, "COMPANY_ADDRESS");
        public static final Property CompanyName = new Property(2, String.class, "companyName", false, "COMPANY_NAME");
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property PackageNumber = new Property(8, String.class, "packageNumber", false, "PACKAGE_NUMBER");
        public static final Property PackageType = new Property(9, Integer.class, "packageType", false, "PACKAGE_TYPE");
        public static final Property ReceiveCard = new Property(6, String.class, "receiveCard", false, "RECEIVE_CARD");
        public static final Property ReceiveName = new Property(5, String.class, "receiveName", false, "RECEIVE_NAME");
        public static final Property ReceivePhone = new Property(7, String.class, "receivePhone", false, "RECEIVE_PHONE");
        public static final Property ReceivePhoto = new Property(12, String.class, "receivePhoto", false, "RECEIVE_PHOTO");
        public static final Property SelfReceive = new Property(4, Integer.class, "selfReceive", false, "SELF_RECEIVE");
        public static final Property SignDate = new Property(10, String.class, "signDate", false, "SIGN_DATE");
        public static final Property SignTime = new Property(11, String.class, "signTime", false, "SIGN_TIME");
        public static final Property TotalID = new Property(1, Long.class, "totalID", false, "TOTAL_ID");
        public static final Property XRayPhoto = new Property(13, String.class, "xRayPhoto", false, "X_RAY_PHOTO");
    }

    public DeliveryControlDao(DaoConfig config) {
        super(config);
    }

    public DeliveryControlDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"DELIVERY_CONTROL\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"TOTAL_ID\" INTEGER,\"COMPANY_NAME\" TEXT,\"COMPANY_ADDRESS\" TEXT,\"SELF_RECEIVE\" INTEGER,\"RECEIVE_NAME\" TEXT,\"RECEIVE_CARD\" TEXT,\"RECEIVE_PHONE\" TEXT,\"PACKAGE_NUMBER\" TEXT,\"PACKAGE_TYPE\" INTEGER,\"SIGN_DATE\" TEXT,\"SIGN_TIME\" TEXT,\"RECEIVE_PHOTO\" TEXT,\"X_RAY_PHOTO\" TEXT,\"BEFORE_OPEN_PHOTO\" TEXT,\"AFTER_OPEN_PHOTO\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DELIVERY_CONTROL\"");
    }

    protected final void bindValues(DatabaseStatement stmt, DeliveryControl entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Long totalID = entity.getTotalID();
        if (totalID != null) {
            stmt.bindLong(2, totalID.longValue());
        }
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(3, companyName);
        }
        String companyAddress = entity.getCompanyAddress();
        if (companyAddress != null) {
            stmt.bindString(4, companyAddress);
        }
        Integer selfReceive = entity.getSelfReceive();
        if (selfReceive != null) {
            stmt.bindLong(5, (long) selfReceive.intValue());
        }
        String receiveName = entity.getReceiveName();
        if (receiveName != null) {
            stmt.bindString(6, receiveName);
        }
        String receiveCard = entity.getReceiveCard();
        if (receiveCard != null) {
            stmt.bindString(7, receiveCard);
        }
        String receivePhone = entity.getReceivePhone();
        if (receivePhone != null) {
            stmt.bindString(8, receivePhone);
        }
        String packageNumber = entity.getPackageNumber();
        if (packageNumber != null) {
            stmt.bindString(9, packageNumber);
        }
        Integer packageType = entity.getPackageType();
        if (packageType != null) {
            stmt.bindLong(10, (long) packageType.intValue());
        }
        String signDate = entity.getSignDate();
        if (signDate != null) {
            stmt.bindString(11, signDate);
        }
        String signTime = entity.getSignTime();
        if (signTime != null) {
            stmt.bindString(12, signTime);
        }
        String receivePhoto = entity.getReceivePhoto();
        if (receivePhoto != null) {
            stmt.bindString(13, receivePhoto);
        }
        String xRayPhoto = entity.getXRayPhoto();
        if (xRayPhoto != null) {
            stmt.bindString(14, xRayPhoto);
        }
        String beforeOpenPhoto = entity.getBeforeOpenPhoto();
        if (beforeOpenPhoto != null) {
            stmt.bindString(15, beforeOpenPhoto);
        }
        String afterOpenPhoto = entity.getAfterOpenPhoto();
        if (afterOpenPhoto != null) {
            stmt.bindString(16, afterOpenPhoto);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, DeliveryControl entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Long totalID = entity.getTotalID();
        if (totalID != null) {
            stmt.bindLong(2, totalID.longValue());
        }
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(3, companyName);
        }
        String companyAddress = entity.getCompanyAddress();
        if (companyAddress != null) {
            stmt.bindString(4, companyAddress);
        }
        Integer selfReceive = entity.getSelfReceive();
        if (selfReceive != null) {
            stmt.bindLong(5, (long) selfReceive.intValue());
        }
        String receiveName = entity.getReceiveName();
        if (receiveName != null) {
            stmt.bindString(6, receiveName);
        }
        String receiveCard = entity.getReceiveCard();
        if (receiveCard != null) {
            stmt.bindString(7, receiveCard);
        }
        String receivePhone = entity.getReceivePhone();
        if (receivePhone != null) {
            stmt.bindString(8, receivePhone);
        }
        String packageNumber = entity.getPackageNumber();
        if (packageNumber != null) {
            stmt.bindString(9, packageNumber);
        }
        Integer packageType = entity.getPackageType();
        if (packageType != null) {
            stmt.bindLong(10, (long) packageType.intValue());
        }
        String signDate = entity.getSignDate();
        if (signDate != null) {
            stmt.bindString(11, signDate);
        }
        String signTime = entity.getSignTime();
        if (signTime != null) {
            stmt.bindString(12, signTime);
        }
        String receivePhoto = entity.getReceivePhoto();
        if (receivePhoto != null) {
            stmt.bindString(13, receivePhoto);
        }
        String xRayPhoto = entity.getXRayPhoto();
        if (xRayPhoto != null) {
            stmt.bindString(14, xRayPhoto);
        }
        String beforeOpenPhoto = entity.getBeforeOpenPhoto();
        if (beforeOpenPhoto != null) {
            stmt.bindString(15, beforeOpenPhoto);
        }
        String afterOpenPhoto = entity.getAfterOpenPhoto();
        if (afterOpenPhoto != null) {
            stmt.bindString(16, afterOpenPhoto);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public DeliveryControl readEntity(Cursor cursor, int offset) {
        return new DeliveryControl(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : Integer.valueOf(cursor.getInt(offset + 9)), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
    }

    public void readEntity(Cursor cursor, DeliveryControl entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setTotalID(cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)));
        entity.setCompanyName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCompanyAddress(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSelfReceive(cursor.isNull(offset + 4) ? null : Integer.valueOf(cursor.getInt(offset + 4)));
        entity.setReceiveName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setReceiveCard(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setReceivePhone(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPackageNumber(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPackageType(cursor.isNull(offset + 9) ? null : Integer.valueOf(cursor.getInt(offset + 9)));
        entity.setSignDate(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setSignTime(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setReceivePhoto(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setXRayPhoto(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setBeforeOpenPhoto(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        if (!cursor.isNull(offset + 15)) {
            str = cursor.getString(offset + 15);
        }
        entity.setAfterOpenPhoto(str);
    }

    protected final Long updateKeyAfterInsert(DeliveryControl entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(DeliveryControl entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(DeliveryControl entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
