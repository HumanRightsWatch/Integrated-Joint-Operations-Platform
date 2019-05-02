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

public class InvestigateBankCardDao extends AbstractDao<InvestigateBankCard, Long> {
    public static final String TABLENAME = "INVESTIGATE_BANK_CARD";
    private Query<InvestigateBankCard> investigationInfo_InvestigateBankCardListQuery;

    public static class Properties {
        public static final Property Account = new Property(4, String.class, "account", false, "ACCOUNT");
        public static final Property Bank = new Property(3, String.class, "bank", false, "BANK");
        public static final Property Id = new Property(1, String.class, "id", false, "ID");
        public static final Property Local_fkIr = new Property(2, Long.class, "local_fkIr", false, "LOCAL_FK_IR");
        public static final Property Local_id = new Property(0, Long.class, "local_id", true, "LOCAL_ID");
        public static final Property Note = new Property(7, String.class, "note", false, "NOTE");
        public static final Property Passport = new Property(6, String.class, "passport", false, "PASSPORT");
        public static final Property Phone = new Property(5, String.class, "phone", false, "PHONE");
    }

    public InvestigateBankCardDao(DaoConfig config) {
        super(config);
    }

    public InvestigateBankCardDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    public static void createTable(Database db, boolean ifNotExists) {
        db.execSQL("CREATE TABLE " + (ifNotExists ? "IF NOT EXISTS " : "") + "\"INVESTIGATE_BANK_CARD\" (\"LOCAL_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ID\" TEXT,\"LOCAL_FK_IR\" INTEGER,\"BANK\" TEXT,\"ACCOUNT\" TEXT,\"PHONE\" TEXT,\"PASSPORT\" TEXT,\"NOTE\" TEXT);");
    }

    public static void dropTable(Database db, boolean ifExists) {
        db.execSQL("DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"INVESTIGATE_BANK_CARD\"");
    }

    protected final void bindValues(DatabaseStatement stmt, InvestigateBankCard entity) {
        stmt.clearBindings();
        Long local_id = entity.getLocal_id();
        if (local_id != null) {
            stmt.bindLong(1, local_id.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        Long local_fkIr = entity.getLocal_fkIr();
        if (local_fkIr != null) {
            stmt.bindLong(3, local_fkIr.longValue());
        }
        String bank = entity.getBank();
        if (bank != null) {
            stmt.bindString(4, bank);
        }
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(5, account);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(6, phone);
        }
        String passport = entity.getPassport();
        if (passport != null) {
            stmt.bindString(7, passport);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(8, note);
        }
    }

    protected final void bindValues(SQLiteStatement stmt, InvestigateBankCard entity) {
        stmt.clearBindings();
        Long local_id = entity.getLocal_id();
        if (local_id != null) {
            stmt.bindLong(1, local_id.longValue());
        }
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(2, id);
        }
        Long local_fkIr = entity.getLocal_fkIr();
        if (local_fkIr != null) {
            stmt.bindLong(3, local_fkIr.longValue());
        }
        String bank = entity.getBank();
        if (bank != null) {
            stmt.bindString(4, bank);
        }
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(5, account);
        }
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(6, phone);
        }
        String passport = entity.getPassport();
        if (passport != null) {
            stmt.bindString(7, passport);
        }
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(8, note);
        }
    }

    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
    }

    public InvestigateBankCard readEntity(Cursor cursor, int offset) {
        String str = null;
        Long valueOf = cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0));
        String string = cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
        Long valueOf2 = cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2));
        String string2 = cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3);
        String string3 = cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4);
        String string4 = cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5);
        String string5 = cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6);
        if (!cursor.isNull(offset + 7)) {
            str = cursor.getString(offset + 7);
        }
        return new InvestigateBankCard(valueOf, string, valueOf2, string2, string3, string4, string5, str);
    }

    public void readEntity(Cursor cursor, InvestigateBankCard entity, int offset) {
        String str = null;
        entity.setLocal_id(cursor.isNull(offset + 0) ? null : Long.valueOf(cursor.getLong(offset + 0)));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLocal_fkIr(cursor.isNull(offset + 2) ? null : Long.valueOf(cursor.getLong(offset + 2)));
        entity.setBank(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAccount(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPhone(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPassport(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        if (!cursor.isNull(offset + 7)) {
            str = cursor.getString(offset + 7);
        }
        entity.setNote(str);
    }

    protected final Long updateKeyAfterInsert(InvestigateBankCard entity, long rowId) {
        entity.setLocal_id(Long.valueOf(rowId));
        return Long.valueOf(rowId);
    }

    public Long getKey(InvestigateBankCard entity) {
        if (entity != null) {
            return entity.getLocal_id();
        }
        return null;
    }

    public boolean hasKey(InvestigateBankCard entity) {
        return entity.getLocal_id() != null;
    }

    protected final boolean isEntityUpdateable() {
        return true;
    }

    public List<InvestigateBankCard> _queryInvestigationInfo_InvestigateBankCardList(Long local_fkIr) {
        synchronized (this) {
            if (this.investigationInfo_InvestigateBankCardListQuery == null) {
                QueryBuilder<InvestigateBankCard> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Local_fkIr.eq(null), new WhereCondition[0]);
                this.investigationInfo_InvestigateBankCardListQuery = queryBuilder.build();
            }
        }
        Query<InvestigateBankCard> query = this.investigationInfo_InvestigateBankCardListQuery.forCurrentThread();
        query.setParameter(0, local_fkIr);
        return query.list();
    }
}
