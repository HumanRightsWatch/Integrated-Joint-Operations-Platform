package com.fec.report.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

public class ComparisonDao extends AbstractDao<Comparison, Long> {
    public static final String TABLENAME = "COMPARISON";
    private Query<Comparison> personInfo_ComparisonListQuery;

    public static class Properties {
        public static final Property Action = new Property(6, String.class, "action", false, "ACTION");
        public static final Property Card = new Property(5, String.class, "card", false, "CARD");
        public static final Property FacePhoto = new Property(3, String.class, "facePhoto", false, "FACE_PHOTO");
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Name = new Property(4, String.class, "name", false, "NAME");
        public static final Property PersonId = new Property(1, Long.class, "personId", false, "PERSON_ID");
        public static final Property Similarity = new Property(2, String.class, "similarity", false, "SIMILARITY");
    }

    public ComparisonDao(DaoConfig config) {
        super(config);
    }

    public ComparisonDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"COMPARISON\" (\"_id\" INTEGER PRIMARY KEY ,\"PERSON_ID\" INTEGER,\"SIMILARITY\" TEXT,\"FACE_PHOTO\" TEXT,\"NAME\" TEXT,\"CARD\" TEXT,\"ACTION\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"COMPARISON\"");
    }

    protected final void bindValues(DatabaseStatement stmt, Comparison entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Long personId = entity.getPersonId();
        if (personId != null) {
            stmt.bindLong(2, personId.longValue());
        }
        String similarity = entity.getSimilarity();
        if (similarity != null) {
            stmt.bindString(3, similarity);
        }
        String facePhoto = entity.getFacePhoto();
        if (facePhoto != null) {
            stmt.bindString(4, facePhoto);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
        String card = entity.getCard();
        if (card != null) {
            stmt.bindString(6, card);
        }
        String action = entity.getAction();
        if (action != null) {
            stmt.bindString(7, action);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, Comparison entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id.longValue());
        }
        Long personId = entity.getPersonId();
        if (personId != null) {
            stmt.bindLong(2, personId.longValue());
        }
        String similarity = entity.getSimilarity();
        if (similarity != null) {
            stmt.bindString(3, similarity);
        }
        String facePhoto = entity.getFacePhoto();
        if (facePhoto != null) {
            stmt.bindString(4, facePhoto);
        }
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
        String card = entity.getCard();
        if (card != null) {
            stmt.bindString(6, card);
        }
        String action = entity.getAction();
        if (action != null) {
            stmt.bindString(7, action);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public Comparison readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        Long valueOf2 = cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1));
        String string = cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2);
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string4 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        if (!cursor.isNull(offset + 6)) {
            str = cursor.getString(offset + 6);
        }
        return new Comparison(valueOf, valueOf2, string, string2, string3, string4, str);
    }

    public void readEntity(Cursor cursor, Comparison entity, int offset) {
        String str = null;
        entity.setId(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setPersonId(cursor.isNull(offset + 1) ? null : Long.valueOf(cursor.getLong(offset + 1)));
        entity.setSimilarity(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFacePhoto(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setCard(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        if (!cursor.isNull(offset + 6)) {
            str = cursor.getString(offset + 6);
        }
        entity.setAction(str);
    }

    protected final Long updateKeyAfterInsert(Comparison entity, long rowId) {
        entity.setId(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(Comparison entity) {
        if (entity != null) {
            return entity.getId();
        }
        return null;
    }

    public boolean hasKey(Comparison entity) {
        return entity.getId() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<Comparison> _queryPersonInfo_ComparisonList(Long personId) {
        synchronized (this) {
            if (this.personInfo_ComparisonListQuery == null) {
                QueryBuilder<Comparison> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.PersonId.eq(null), new WhereCondition[0]);
                this.personInfo_ComparisonListQuery = queryBuilder.build();
            }
        }
        Query<Comparison> query = this.personInfo_ComparisonListQuery.forCurrentThread();
        query.setParameter(0, personId);
        return query.list();
    }
}
