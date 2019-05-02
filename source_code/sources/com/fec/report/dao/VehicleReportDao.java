package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

public class VehicleReportDao extends AbstractDao<VehicleReport, Long> {
    public static final String TABLENAME = "VEHICLE_REPORT";

    public static class Properties {
        public static final Property CertificatePhotos = new Property(12, String.class, "certificatePhotos", false, "CERTIFICATE_PHOTOS");
        public static final Property CompanyAddress = new Property(11, String.class, "companyAddress", false, "COMPANY_ADDRESS");
        public static final Property CompanyName = new Property(8, String.class, "companyName", false, "COMPANY_NAME");
        public static final Property CompanyPhone = new Property(10, String.class, "companyPhone", false, "COMPANY_PHONE");
        public static final Property Corporate = new Property(9, String.class, "corporate", false, "CORPORATE");
        public static final Property FkVr = new Property(1, String.class, "fkVr", false, "FK_VR");
        public static final Property Id = new Property(0, Long.class, "id", true, "ID");
        public static final Property OwnerIdCard = new Property(5, String.class, "ownerIdCard", false, "OWNER_ID_CARD");
        public static final Property OwnerName = new Property(4, String.class, "ownerName", false, "OWNER_NAME");
        public static final Property OwnerPhone = new Property(6, String.class, "ownerPhone", false, "OWNER_PHONE");
        public static final Property OwnerPhotos = new Property(7, String.class, "ownerPhotos", false, "OWNER_PHOTOS");
        public static final Property RelationWithOwner = new Property(3, Integer.class, "relationWithOwner", false, "RELATION_WITH_OWNER");
        public static final Property UserPhotos = new Property(2, String.class, "userPhotos", false, "USER_PHOTOS");
    }

    public VehicleReportDao(DaoConfig config) {
        super(config);
    }

    public VehicleReportDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"VEHICLE_REPORT\" (\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"FK_VR\" TEXT,\"USER_PHOTOS\" TEXT,\"RELATION_WITH_OWNER\" INTEGER,\"OWNER_NAME\" TEXT,\"OWNER_ID_CARD\" TEXT,\"OWNER_PHONE\" TEXT,\"OWNER_PHOTOS\" TEXT,\"COMPANY_NAME\" TEXT,\"CORPORATE\" TEXT,\"COMPANY_PHONE\" TEXT,\"COMPANY_ADDRESS\" TEXT,\"CERTIFICATE_PHOTOS\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"VEHICLE_REPORT\"");
    }

    protected final void bindValues(DatabaseStatement stmt, VehicleReport entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String fkVr = entity.getFkVr();
        if (fkVr != null) {
            stmt.bindString(2, fkVr);
        }
        String userPhotos = entity.getUserPhotos();
        if (userPhotos != null) {
            stmt.bindString(3, userPhotos);
        }
        Integer relationWithOwner = entity.getRelationWithOwner();
        if (relationWithOwner != null) {
            stmt.bindLong(4, (long) relationWithOwner.intValue());
        }
        String ownerName = entity.getOwnerName();
        if (ownerName != null) {
            stmt.bindString(5, ownerName);
        }
        String ownerIdCard = entity.getOwnerIdCard();
        if (ownerIdCard != null) {
            stmt.bindString(6, ownerIdCard);
        }
        String ownerPhone = entity.getOwnerPhone();
        if (ownerPhone != null) {
            stmt.bindString(7, ownerPhone);
        }
        String ownerPhotos = entity.getOwnerPhotos();
        if (ownerPhotos != null) {
            stmt.bindString(8, ownerPhotos);
        }
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(9, companyName);
        }
        String corporate = entity.getCorporate();
        if (corporate != null) {
            stmt.bindString(10, corporate);
        }
        String companyPhone = entity.getCompanyPhone();
        if (companyPhone != null) {
            stmt.bindString(11, companyPhone);
        }
        String companyAddress = entity.getCompanyAddress();
        if (companyAddress != null) {
            stmt.bindString(12, companyAddress);
        }
        String certificatePhotos = entity.getCertificatePhotos();
        if (certificatePhotos != null) {
            stmt.bindString(13, certificatePhotos);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, VehicleReport entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        String fkVr = entity.getFkVr();
        if (fkVr != null) {
            stmt.bindString(2, fkVr);
        }
        String userPhotos = entity.getUserPhotos();
        if (userPhotos != null) {
            stmt.bindString(3, userPhotos);
        }
        Integer relationWithOwner = entity.getRelationWithOwner();
        if (relationWithOwner != null) {
            stmt.bindLong(4, (long) relationWithOwner.intValue());
        }
        String ownerName = entity.getOwnerName();
        if (ownerName != null) {
            stmt.bindString(5, ownerName);
        }
        String ownerIdCard = entity.getOwnerIdCard();
        if (ownerIdCard != null) {
            stmt.bindString(6, ownerIdCard);
        }
        String ownerPhone = entity.getOwnerPhone();
        if (ownerPhone != null) {
            stmt.bindString(7, ownerPhone);
        }
        String ownerPhotos = entity.getOwnerPhotos();
        if (ownerPhotos != null) {
            stmt.bindString(8, ownerPhotos);
        }
        String companyName = entity.getCompanyName();
        if (companyName != null) {
            stmt.bindString(9, companyName);
        }
        String corporate = entity.getCorporate();
        if (corporate != null) {
            stmt.bindString(10, corporate);
        }
        String companyPhone = entity.getCompanyPhone();
        if (companyPhone != null) {
            stmt.bindString(11, companyPhone);
        }
        String companyAddress = entity.getCompanyAddress();
        if (companyAddress != null) {
            stmt.bindString(12, companyAddress);
        }
        String certificatePhotos = entity.getCertificatePhotos();
        if (certificatePhotos != null) {
            stmt.bindString(13, certificatePhotos);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public VehicleReport readEntity(Cursor cursor, int offset) {
        return new VehicleReport(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)), cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)), cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
    }

    public void readEntity(Cursor cursor, VehicleReport entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setFkVr(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUserPhotos(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRelationWithOwner(cursor.isNull(offset + 3) ? null : Integer.valueOf(cursor.getInt(offset + 3)));
        entity.setOwnerName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setOwnerIdCard(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setOwnerPhone(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setOwnerPhotos(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCompanyName(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setCorporate(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setCompanyPhone(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setCompanyAddress(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        if (!cursor.isNull(offset + 12)) {
            str = cursor.getString(offset + 12);
        }
        entity.setCertificatePhotos(str);
    }

    protected final Long updateKeyAfterInsert(VehicleReport entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(VehicleReport entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(VehicleReport entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }
}
