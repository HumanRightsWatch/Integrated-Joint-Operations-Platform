package com.fec.report.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 42;

    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String name) {
            super(context, name, 42);
        }

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, 42);
        }

        public void onCreate(Database db) {
            Log.i("greenDAO", "Creating tables for schema version 42");
            DaoMaster.createAllTables(db, false);
        }
    }

    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name) {
            super(context, name);
        }

        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            DaoMaster.dropAllTables(db, true);
            onCreate(db);
        }
    }

    public static void createAllTables(Database db, boolean ifNotExists) {
        IllegalPersonDao.createTable(db, ifNotExists);
        IllegalCarDao.createTable(db, ifNotExists);
        ThingTotalEntityDao.createTable(db, ifNotExists);
        ReportThingDao.createTable(db, ifNotExists);
        DeliveryControlDao.createTable(db, ifNotExists);
        IllegalThingDao.createTable(db, ifNotExists);
        PopulationFamilyDao.createTable(db, ifNotExists);
        PopulationHouseDao.createTable(db, ifNotExists);
        MissionCommandDao.createTable(db, ifNotExists);
        ElecCheckFeedbackDao.createTable(db, ifNotExists);
        NineOneThreeRespondentDao.createTable(db, ifNotExists);
        NineOneThreeVisitorDao.createTable(db, ifNotExists);
        NineOneThreePhoneDao.createTable(db, ifNotExists);
        NineOneThreeSoftwareDao.createTable(db, ifNotExists);
        NineOneThreeOverseasDao.createTable(db, ifNotExists);
        NineOneThreeResultDao.createTable(db, ifNotExists);
        RadioPersonnelRespondentDao.createTable(db, ifNotExists);
        RadioPersonnelPeerDao.createTable(db, ifNotExists);
        RadioCarRespondentDao.createTable(db, ifNotExists);
        RadioCarPeerDao.createTable(db, ifNotExists);
        SuspiciousPhoneDao.createTable(db, ifNotExists);
        InvestigationInfoDao.createTable(db, ifNotExists);
        InvestigateVehicleDao.createTable(db, ifNotExists);
        InvestigateBankCardDao.createTable(db, ifNotExists);
        InvestigateFamilyDao.createTable(db, ifNotExists);
        InvestigateSoftDao.createTable(db, ifNotExists);
        BuildingInfoDao.createTable(db, ifNotExists);
        HouseInfoDao.createTable(db, ifNotExists);
        PersonInfoDao.createTable(db, ifNotExists);
        ComparisonDao.createTable(db, ifNotExists);
        OverduePersonInfoDao.createTable(db, ifNotExists);
        OverduePersonVisitorDao.createTable(db, ifNotExists);
        OverduePersonContactDao.createTable(db, ifNotExists);
        ManualInfoDao.createTable(db, ifNotExists);
        ManualVehicleDao.createTable(db, ifNotExists);
        ManualBankCardDao.createTable(db, ifNotExists);
        ManualFamilyDao.createTable(db, ifNotExists);
        ManualteSoftDao.createTable(db, ifNotExists);
        NoticeDao.createTable(db, ifNotExists);
        VehicleReportDao.createTable(db, ifNotExists);
        WifiDetectorDao.createTable(db, ifNotExists);
        SignPlaceDao.createTable(db, ifNotExists);
        SignBeanDao.createTable(db, ifNotExists);
        OutOfPersonInfoDao.createTable(db, ifNotExists);
        OutOfPersonRelativeDao.createTable(db, ifNotExists);
        OutOfPersonPeerDao.createTable(db, ifNotExists);
        InfluxPersonInfoDao.createTable(db, ifNotExists);
        InfluxPersonRelativeDao.createTable(db, ifNotExists);
        LocalPersonnelCarResEntityDao.createTable(db, ifNotExists);
        LocalPersonnelCarMismatchEntityDao.createTable(db, ifNotExists);
        LocalPersonnelCarVisitorEntityDao.createTable(db, ifNotExists);
        LocalPersonnelIdMismatchEntityDao.createTable(db, ifNotExists);
        LocalPersonnelIdVisitorEntityDao.createTable(db, ifNotExists);
        LocalPersonnelIdResEntityDao.createTable(db, ifNotExists);
        LocalPersonPhoneEntityDao.createTable(db, ifNotExists);
        LocalPersonPhoneVisitorEntityDao.createTable(db, ifNotExists);
        LocalPersonPhoneResEntityDao.createTable(db, ifNotExists);
        LocalNoIdCardTrackEntityDao.createTable(db, ifNotExists);
        LocalNoIdCardTrackResEntityDao.createTable(db, ifNotExists);
        LocalNoIdCardTrackVisitorEntityDao.createTable(db, ifNotExists);
        LocalNoCarTrackEntityDao.createTable(db, ifNotExists);
        LocalNoCarTrackResEntityDao.createTable(db, ifNotExists);
        LocalNoCarTrackVisitorEntityDao.createTable(db, ifNotExists);
        CommonSaveInfoDao.createTable(db, ifNotExists);
    }

    public static void dropAllTables(Database db, boolean ifExists) {
        IllegalPersonDao.dropTable(db, ifExists);
        IllegalCarDao.dropTable(db, ifExists);
        ThingTotalEntityDao.dropTable(db, ifExists);
        ReportThingDao.dropTable(db, ifExists);
        DeliveryControlDao.dropTable(db, ifExists);
        IllegalThingDao.dropTable(db, ifExists);
        PopulationFamilyDao.dropTable(db, ifExists);
        PopulationHouseDao.dropTable(db, ifExists);
        MissionCommandDao.dropTable(db, ifExists);
        ElecCheckFeedbackDao.dropTable(db, ifExists);
        NineOneThreeRespondentDao.dropTable(db, ifExists);
        NineOneThreeVisitorDao.dropTable(db, ifExists);
        NineOneThreePhoneDao.dropTable(db, ifExists);
        NineOneThreeSoftwareDao.dropTable(db, ifExists);
        NineOneThreeOverseasDao.dropTable(db, ifExists);
        NineOneThreeResultDao.dropTable(db, ifExists);
        RadioPersonnelRespondentDao.dropTable(db, ifExists);
        RadioPersonnelPeerDao.dropTable(db, ifExists);
        RadioCarRespondentDao.dropTable(db, ifExists);
        RadioCarPeerDao.dropTable(db, ifExists);
        SuspiciousPhoneDao.dropTable(db, ifExists);
        InvestigationInfoDao.dropTable(db, ifExists);
        InvestigateVehicleDao.dropTable(db, ifExists);
        InvestigateBankCardDao.dropTable(db, ifExists);
        InvestigateFamilyDao.dropTable(db, ifExists);
        InvestigateSoftDao.dropTable(db, ifExists);
        BuildingInfoDao.dropTable(db, ifExists);
        HouseInfoDao.dropTable(db, ifExists);
        PersonInfoDao.dropTable(db, ifExists);
        ComparisonDao.dropTable(db, ifExists);
        OverduePersonInfoDao.dropTable(db, ifExists);
        OverduePersonVisitorDao.dropTable(db, ifExists);
        OverduePersonContactDao.dropTable(db, ifExists);
        ManualInfoDao.dropTable(db, ifExists);
        ManualVehicleDao.dropTable(db, ifExists);
        ManualBankCardDao.dropTable(db, ifExists);
        ManualFamilyDao.dropTable(db, ifExists);
        ManualteSoftDao.dropTable(db, ifExists);
        NoticeDao.dropTable(db, ifExists);
        VehicleReportDao.dropTable(db, ifExists);
        WifiDetectorDao.dropTable(db, ifExists);
        SignPlaceDao.dropTable(db, ifExists);
        SignBeanDao.dropTable(db, ifExists);
        OutOfPersonInfoDao.dropTable(db, ifExists);
        OutOfPersonRelativeDao.dropTable(db, ifExists);
        OutOfPersonPeerDao.dropTable(db, ifExists);
        InfluxPersonInfoDao.dropTable(db, ifExists);
        InfluxPersonRelativeDao.dropTable(db, ifExists);
        LocalPersonnelCarResEntityDao.dropTable(db, ifExists);
        LocalPersonnelCarMismatchEntityDao.dropTable(db, ifExists);
        LocalPersonnelCarVisitorEntityDao.dropTable(db, ifExists);
        LocalPersonnelIdMismatchEntityDao.dropTable(db, ifExists);
        LocalPersonnelIdVisitorEntityDao.dropTable(db, ifExists);
        LocalPersonnelIdResEntityDao.dropTable(db, ifExists);
        LocalPersonPhoneEntityDao.dropTable(db, ifExists);
        LocalPersonPhoneVisitorEntityDao.dropTable(db, ifExists);
        LocalPersonPhoneResEntityDao.dropTable(db, ifExists);
        LocalNoIdCardTrackEntityDao.dropTable(db, ifExists);
        LocalNoIdCardTrackResEntityDao.dropTable(db, ifExists);
        LocalNoIdCardTrackVisitorEntityDao.dropTable(db, ifExists);
        LocalNoCarTrackEntityDao.dropTable(db, ifExists);
        LocalNoCarTrackResEntityDao.dropTable(db, ifExists);
        LocalNoCarTrackVisitorEntityDao.dropTable(db, ifExists);
        CommonSaveInfoDao.dropTable(db, ifExists);
    }

    public static DaoSession newDevSession(Context context, String name) {
        return new DaoMaster(new DevOpenHelper(context, name).getWritableDb()).newSession();
    }

    public DaoMaster(SQLiteDatabase db) {
        this(new StandardDatabase(db));
    }

    public DaoMaster(Database db) {
        super(db, 42);
        registerDaoClass(IllegalPersonDao.class);
        registerDaoClass(IllegalCarDao.class);
        registerDaoClass(ThingTotalEntityDao.class);
        registerDaoClass(ReportThingDao.class);
        registerDaoClass(DeliveryControlDao.class);
        registerDaoClass(IllegalThingDao.class);
        registerDaoClass(PopulationFamilyDao.class);
        registerDaoClass(PopulationHouseDao.class);
        registerDaoClass(MissionCommandDao.class);
        registerDaoClass(ElecCheckFeedbackDao.class);
        registerDaoClass(NineOneThreeRespondentDao.class);
        registerDaoClass(NineOneThreeVisitorDao.class);
        registerDaoClass(NineOneThreePhoneDao.class);
        registerDaoClass(NineOneThreeSoftwareDao.class);
        registerDaoClass(NineOneThreeOverseasDao.class);
        registerDaoClass(NineOneThreeResultDao.class);
        registerDaoClass(RadioPersonnelRespondentDao.class);
        registerDaoClass(RadioPersonnelPeerDao.class);
        registerDaoClass(RadioCarRespondentDao.class);
        registerDaoClass(RadioCarPeerDao.class);
        registerDaoClass(SuspiciousPhoneDao.class);
        registerDaoClass(InvestigationInfoDao.class);
        registerDaoClass(InvestigateVehicleDao.class);
        registerDaoClass(InvestigateBankCardDao.class);
        registerDaoClass(InvestigateFamilyDao.class);
        registerDaoClass(InvestigateSoftDao.class);
        registerDaoClass(BuildingInfoDao.class);
        registerDaoClass(HouseInfoDao.class);
        registerDaoClass(PersonInfoDao.class);
        registerDaoClass(ComparisonDao.class);
        registerDaoClass(OverduePersonInfoDao.class);
        registerDaoClass(OverduePersonVisitorDao.class);
        registerDaoClass(OverduePersonContactDao.class);
        registerDaoClass(ManualInfoDao.class);
        registerDaoClass(ManualVehicleDao.class);
        registerDaoClass(ManualBankCardDao.class);
        registerDaoClass(ManualFamilyDao.class);
        registerDaoClass(ManualteSoftDao.class);
        registerDaoClass(NoticeDao.class);
        registerDaoClass(VehicleReportDao.class);
        registerDaoClass(WifiDetectorDao.class);
        registerDaoClass(SignPlaceDao.class);
        registerDaoClass(SignBeanDao.class);
        registerDaoClass(OutOfPersonInfoDao.class);
        registerDaoClass(OutOfPersonRelativeDao.class);
        registerDaoClass(OutOfPersonPeerDao.class);
        registerDaoClass(InfluxPersonInfoDao.class);
        registerDaoClass(InfluxPersonRelativeDao.class);
        registerDaoClass(LocalPersonnelCarResEntityDao.class);
        registerDaoClass(LocalPersonnelCarMismatchEntityDao.class);
        registerDaoClass(LocalPersonnelCarVisitorEntityDao.class);
        registerDaoClass(LocalPersonnelIdMismatchEntityDao.class);
        registerDaoClass(LocalPersonnelIdVisitorEntityDao.class);
        registerDaoClass(LocalPersonnelIdResEntityDao.class);
        registerDaoClass(LocalPersonPhoneEntityDao.class);
        registerDaoClass(LocalPersonPhoneVisitorEntityDao.class);
        registerDaoClass(LocalPersonPhoneResEntityDao.class);
        registerDaoClass(LocalNoIdCardTrackEntityDao.class);
        registerDaoClass(LocalNoIdCardTrackResEntityDao.class);
        registerDaoClass(LocalNoIdCardTrackVisitorEntityDao.class);
        registerDaoClass(LocalNoCarTrackEntityDao.class);
        registerDaoClass(LocalNoCarTrackResEntityDao.class);
        registerDaoClass(LocalNoCarTrackVisitorEntityDao.class);
        registerDaoClass(CommonSaveInfoDao.class);
    }

    public DaoSession newSession() {
        return new DaoSession(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(this.db, type, this.daoConfigMap);
    }
}
