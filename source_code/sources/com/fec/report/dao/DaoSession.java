package com.fec.report.dao;

import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class DaoSession extends AbstractDaoSession {
    private final BuildingInfoDao buildingInfoDao = new BuildingInfoDao(this.buildingInfoDaoConfig, this);
    private final DaoConfig buildingInfoDaoConfig;
    private final CommonSaveInfoDao commonSaveInfoDao = new CommonSaveInfoDao(this.commonSaveInfoDaoConfig, this);
    private final DaoConfig commonSaveInfoDaoConfig;
    private final ComparisonDao comparisonDao = new ComparisonDao(this.comparisonDaoConfig, this);
    private final DaoConfig comparisonDaoConfig;
    private final DeliveryControlDao deliveryControlDao = new DeliveryControlDao(this.deliveryControlDaoConfig, this);
    private final DaoConfig deliveryControlDaoConfig;
    private final ElecCheckFeedbackDao elecCheckFeedbackDao = new ElecCheckFeedbackDao(this.elecCheckFeedbackDaoConfig, this);
    private final DaoConfig elecCheckFeedbackDaoConfig;
    private final HouseInfoDao houseInfoDao = new HouseInfoDao(this.houseInfoDaoConfig, this);
    private final DaoConfig houseInfoDaoConfig;
    private final IllegalCarDao illegalCarDao = new IllegalCarDao(this.illegalCarDaoConfig, this);
    private final DaoConfig illegalCarDaoConfig;
    private final IllegalPersonDao illegalPersonDao = new IllegalPersonDao(this.illegalPersonDaoConfig, this);
    private final DaoConfig illegalPersonDaoConfig;
    private final IllegalThingDao illegalThingDao = new IllegalThingDao(this.illegalThingDaoConfig, this);
    private final DaoConfig illegalThingDaoConfig;
    private final InfluxPersonInfoDao influxPersonInfoDao = new InfluxPersonInfoDao(this.influxPersonInfoDaoConfig, this);
    private final DaoConfig influxPersonInfoDaoConfig;
    private final InfluxPersonRelativeDao influxPersonRelativeDao = new InfluxPersonRelativeDao(this.influxPersonRelativeDaoConfig, this);
    private final DaoConfig influxPersonRelativeDaoConfig;
    private final InvestigateBankCardDao investigateBankCardDao = new InvestigateBankCardDao(this.investigateBankCardDaoConfig, this);
    private final DaoConfig investigateBankCardDaoConfig;
    private final InvestigateFamilyDao investigateFamilyDao = new InvestigateFamilyDao(this.investigateFamilyDaoConfig, this);
    private final DaoConfig investigateFamilyDaoConfig;
    private final InvestigateSoftDao investigateSoftDao = new InvestigateSoftDao(this.investigateSoftDaoConfig, this);
    private final DaoConfig investigateSoftDaoConfig;
    private final InvestigateVehicleDao investigateVehicleDao = new InvestigateVehicleDao(this.investigateVehicleDaoConfig, this);
    private final DaoConfig investigateVehicleDaoConfig;
    private final InvestigationInfoDao investigationInfoDao = new InvestigationInfoDao(this.investigationInfoDaoConfig, this);
    private final DaoConfig investigationInfoDaoConfig;
    private final LocalNoCarTrackEntityDao localNoCarTrackEntityDao = new LocalNoCarTrackEntityDao(this.localNoCarTrackEntityDaoConfig, this);
    private final DaoConfig localNoCarTrackEntityDaoConfig;
    private final LocalNoCarTrackResEntityDao localNoCarTrackResEntityDao = new LocalNoCarTrackResEntityDao(this.localNoCarTrackResEntityDaoConfig, this);
    private final DaoConfig localNoCarTrackResEntityDaoConfig;
    private final LocalNoCarTrackVisitorEntityDao localNoCarTrackVisitorEntityDao = new LocalNoCarTrackVisitorEntityDao(this.localNoCarTrackVisitorEntityDaoConfig, this);
    private final DaoConfig localNoCarTrackVisitorEntityDaoConfig;
    private final LocalNoIdCardTrackEntityDao localNoIdCardTrackEntityDao = new LocalNoIdCardTrackEntityDao(this.localNoIdCardTrackEntityDaoConfig, this);
    private final DaoConfig localNoIdCardTrackEntityDaoConfig;
    private final LocalNoIdCardTrackResEntityDao localNoIdCardTrackResEntityDao = new LocalNoIdCardTrackResEntityDao(this.localNoIdCardTrackResEntityDaoConfig, this);
    private final DaoConfig localNoIdCardTrackResEntityDaoConfig;
    private final LocalNoIdCardTrackVisitorEntityDao localNoIdCardTrackVisitorEntityDao = new LocalNoIdCardTrackVisitorEntityDao(this.localNoIdCardTrackVisitorEntityDaoConfig, this);
    private final DaoConfig localNoIdCardTrackVisitorEntityDaoConfig;
    private final LocalPersonPhoneEntityDao localPersonPhoneEntityDao = new LocalPersonPhoneEntityDao(this.localPersonPhoneEntityDaoConfig, this);
    private final DaoConfig localPersonPhoneEntityDaoConfig;
    private final LocalPersonPhoneResEntityDao localPersonPhoneResEntityDao = new LocalPersonPhoneResEntityDao(this.localPersonPhoneResEntityDaoConfig, this);
    private final DaoConfig localPersonPhoneResEntityDaoConfig;
    private final LocalPersonPhoneVisitorEntityDao localPersonPhoneVisitorEntityDao = new LocalPersonPhoneVisitorEntityDao(this.localPersonPhoneVisitorEntityDaoConfig, this);
    private final DaoConfig localPersonPhoneVisitorEntityDaoConfig;
    private final LocalPersonnelCarMismatchEntityDao localPersonnelCarMismatchEntityDao = new LocalPersonnelCarMismatchEntityDao(this.localPersonnelCarMismatchEntityDaoConfig, this);
    private final DaoConfig localPersonnelCarMismatchEntityDaoConfig;
    private final LocalPersonnelCarResEntityDao localPersonnelCarResEntityDao = new LocalPersonnelCarResEntityDao(this.localPersonnelCarResEntityDaoConfig, this);
    private final DaoConfig localPersonnelCarResEntityDaoConfig;
    private final LocalPersonnelCarVisitorEntityDao localPersonnelCarVisitorEntityDao = new LocalPersonnelCarVisitorEntityDao(this.localPersonnelCarVisitorEntityDaoConfig, this);
    private final DaoConfig localPersonnelCarVisitorEntityDaoConfig;
    private final LocalPersonnelIdMismatchEntityDao localPersonnelIdMismatchEntityDao = new LocalPersonnelIdMismatchEntityDao(this.localPersonnelIdMismatchEntityDaoConfig, this);
    private final DaoConfig localPersonnelIdMismatchEntityDaoConfig;
    private final LocalPersonnelIdResEntityDao localPersonnelIdResEntityDao = new LocalPersonnelIdResEntityDao(this.localPersonnelIdResEntityDaoConfig, this);
    private final DaoConfig localPersonnelIdResEntityDaoConfig;
    private final LocalPersonnelIdVisitorEntityDao localPersonnelIdVisitorEntityDao = new LocalPersonnelIdVisitorEntityDao(this.localPersonnelIdVisitorEntityDaoConfig, this);
    private final DaoConfig localPersonnelIdVisitorEntityDaoConfig;
    private final ManualBankCardDao manualBankCardDao = new ManualBankCardDao(this.manualBankCardDaoConfig, this);
    private final DaoConfig manualBankCardDaoConfig;
    private final ManualFamilyDao manualFamilyDao = new ManualFamilyDao(this.manualFamilyDaoConfig, this);
    private final DaoConfig manualFamilyDaoConfig;
    private final ManualInfoDao manualInfoDao = new ManualInfoDao(this.manualInfoDaoConfig, this);
    private final DaoConfig manualInfoDaoConfig;
    private final ManualVehicleDao manualVehicleDao = new ManualVehicleDao(this.manualVehicleDaoConfig, this);
    private final DaoConfig manualVehicleDaoConfig;
    private final ManualteSoftDao manualteSoftDao = new ManualteSoftDao(this.manualteSoftDaoConfig, this);
    private final DaoConfig manualteSoftDaoConfig;
    private final MissionCommandDao missionCommandDao = new MissionCommandDao(this.missionCommandDaoConfig, this);
    private final DaoConfig missionCommandDaoConfig;
    private final NineOneThreeOverseasDao nineOneThreeOverseasDao = new NineOneThreeOverseasDao(this.nineOneThreeOverseasDaoConfig, this);
    private final DaoConfig nineOneThreeOverseasDaoConfig;
    private final NineOneThreePhoneDao nineOneThreePhoneDao = new NineOneThreePhoneDao(this.nineOneThreePhoneDaoConfig, this);
    private final DaoConfig nineOneThreePhoneDaoConfig;
    private final NineOneThreeRespondentDao nineOneThreeRespondentDao = new NineOneThreeRespondentDao(this.nineOneThreeRespondentDaoConfig, this);
    private final DaoConfig nineOneThreeRespondentDaoConfig;
    private final NineOneThreeResultDao nineOneThreeResultDao = new NineOneThreeResultDao(this.nineOneThreeResultDaoConfig, this);
    private final DaoConfig nineOneThreeResultDaoConfig;
    private final NineOneThreeSoftwareDao nineOneThreeSoftwareDao = new NineOneThreeSoftwareDao(this.nineOneThreeSoftwareDaoConfig, this);
    private final DaoConfig nineOneThreeSoftwareDaoConfig;
    private final NineOneThreeVisitorDao nineOneThreeVisitorDao = new NineOneThreeVisitorDao(this.nineOneThreeVisitorDaoConfig, this);
    private final DaoConfig nineOneThreeVisitorDaoConfig;
    private final NoticeDao noticeDao = new NoticeDao(this.noticeDaoConfig, this);
    private final DaoConfig noticeDaoConfig;
    private final OutOfPersonInfoDao outOfPersonInfoDao = new OutOfPersonInfoDao(this.outOfPersonInfoDaoConfig, this);
    private final DaoConfig outOfPersonInfoDaoConfig;
    private final OutOfPersonPeerDao outOfPersonPeerDao = new OutOfPersonPeerDao(this.outOfPersonPeerDaoConfig, this);
    private final DaoConfig outOfPersonPeerDaoConfig;
    private final OutOfPersonRelativeDao outOfPersonRelativeDao = new OutOfPersonRelativeDao(this.outOfPersonRelativeDaoConfig, this);
    private final DaoConfig outOfPersonRelativeDaoConfig;
    private final OverduePersonContactDao overduePersonContactDao = new OverduePersonContactDao(this.overduePersonContactDaoConfig, this);
    private final DaoConfig overduePersonContactDaoConfig;
    private final OverduePersonInfoDao overduePersonInfoDao = new OverduePersonInfoDao(this.overduePersonInfoDaoConfig, this);
    private final DaoConfig overduePersonInfoDaoConfig;
    private final OverduePersonVisitorDao overduePersonVisitorDao = new OverduePersonVisitorDao(this.overduePersonVisitorDaoConfig, this);
    private final DaoConfig overduePersonVisitorDaoConfig;
    private final PersonInfoDao personInfoDao = new PersonInfoDao(this.personInfoDaoConfig, this);
    private final DaoConfig personInfoDaoConfig;
    private final PopulationFamilyDao populationFamilyDao = new PopulationFamilyDao(this.populationFamilyDaoConfig, this);
    private final DaoConfig populationFamilyDaoConfig;
    private final PopulationHouseDao populationHouseDao = new PopulationHouseDao(this.populationHouseDaoConfig, this);
    private final DaoConfig populationHouseDaoConfig;
    private final RadioCarPeerDao radioCarPeerDao = new RadioCarPeerDao(this.radioCarPeerDaoConfig, this);
    private final DaoConfig radioCarPeerDaoConfig;
    private final RadioCarRespondentDao radioCarRespondentDao = new RadioCarRespondentDao(this.radioCarRespondentDaoConfig, this);
    private final DaoConfig radioCarRespondentDaoConfig;
    private final RadioPersonnelPeerDao radioPersonnelPeerDao = new RadioPersonnelPeerDao(this.radioPersonnelPeerDaoConfig, this);
    private final DaoConfig radioPersonnelPeerDaoConfig;
    private final RadioPersonnelRespondentDao radioPersonnelRespondentDao = new RadioPersonnelRespondentDao(this.radioPersonnelRespondentDaoConfig, this);
    private final DaoConfig radioPersonnelRespondentDaoConfig;
    private final ReportThingDao reportThingDao = new ReportThingDao(this.reportThingDaoConfig, this);
    private final DaoConfig reportThingDaoConfig;
    private final SignBeanDao signBeanDao = new SignBeanDao(this.signBeanDaoConfig, this);
    private final DaoConfig signBeanDaoConfig;
    private final SignPlaceDao signPlaceDao = new SignPlaceDao(this.signPlaceDaoConfig, this);
    private final DaoConfig signPlaceDaoConfig;
    private final SuspiciousPhoneDao suspiciousPhoneDao = new SuspiciousPhoneDao(this.suspiciousPhoneDaoConfig, this);
    private final DaoConfig suspiciousPhoneDaoConfig;
    private final ThingTotalEntityDao thingTotalEntityDao = new ThingTotalEntityDao(this.thingTotalEntityDaoConfig, this);
    private final DaoConfig thingTotalEntityDaoConfig;
    private final VehicleReportDao vehicleReportDao = new VehicleReportDao(this.vehicleReportDaoConfig, this);
    private final DaoConfig vehicleReportDaoConfig;
    private final WifiDetectorDao wifiDetectorDao = new WifiDetectorDao(this.wifiDetectorDaoConfig, this);
    private final DaoConfig wifiDetectorDaoConfig;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap) {
        super(db);
        this.illegalPersonDaoConfig = ((DaoConfig) daoConfigMap.get(IllegalPersonDao.class)).clone();
        this.illegalPersonDaoConfig.initIdentityScope(type);
        this.illegalCarDaoConfig = ((DaoConfig) daoConfigMap.get(IllegalCarDao.class)).clone();
        this.illegalCarDaoConfig.initIdentityScope(type);
        this.thingTotalEntityDaoConfig = ((DaoConfig) daoConfigMap.get(ThingTotalEntityDao.class)).clone();
        this.thingTotalEntityDaoConfig.initIdentityScope(type);
        this.reportThingDaoConfig = ((DaoConfig) daoConfigMap.get(ReportThingDao.class)).clone();
        this.reportThingDaoConfig.initIdentityScope(type);
        this.deliveryControlDaoConfig = ((DaoConfig) daoConfigMap.get(DeliveryControlDao.class)).clone();
        this.deliveryControlDaoConfig.initIdentityScope(type);
        this.illegalThingDaoConfig = ((DaoConfig) daoConfigMap.get(IllegalThingDao.class)).clone();
        this.illegalThingDaoConfig.initIdentityScope(type);
        this.populationFamilyDaoConfig = ((DaoConfig) daoConfigMap.get(PopulationFamilyDao.class)).clone();
        this.populationFamilyDaoConfig.initIdentityScope(type);
        this.populationHouseDaoConfig = ((DaoConfig) daoConfigMap.get(PopulationHouseDao.class)).clone();
        this.populationHouseDaoConfig.initIdentityScope(type);
        this.missionCommandDaoConfig = ((DaoConfig) daoConfigMap.get(MissionCommandDao.class)).clone();
        this.missionCommandDaoConfig.initIdentityScope(type);
        this.elecCheckFeedbackDaoConfig = ((DaoConfig) daoConfigMap.get(ElecCheckFeedbackDao.class)).clone();
        this.elecCheckFeedbackDaoConfig.initIdentityScope(type);
        this.nineOneThreeRespondentDaoConfig = ((DaoConfig) daoConfigMap.get(NineOneThreeRespondentDao.class)).clone();
        this.nineOneThreeRespondentDaoConfig.initIdentityScope(type);
        this.nineOneThreeVisitorDaoConfig = ((DaoConfig) daoConfigMap.get(NineOneThreeVisitorDao.class)).clone();
        this.nineOneThreeVisitorDaoConfig.initIdentityScope(type);
        this.nineOneThreePhoneDaoConfig = ((DaoConfig) daoConfigMap.get(NineOneThreePhoneDao.class)).clone();
        this.nineOneThreePhoneDaoConfig.initIdentityScope(type);
        this.nineOneThreeSoftwareDaoConfig = ((DaoConfig) daoConfigMap.get(NineOneThreeSoftwareDao.class)).clone();
        this.nineOneThreeSoftwareDaoConfig.initIdentityScope(type);
        this.nineOneThreeOverseasDaoConfig = ((DaoConfig) daoConfigMap.get(NineOneThreeOverseasDao.class)).clone();
        this.nineOneThreeOverseasDaoConfig.initIdentityScope(type);
        this.nineOneThreeResultDaoConfig = ((DaoConfig) daoConfigMap.get(NineOneThreeResultDao.class)).clone();
        this.nineOneThreeResultDaoConfig.initIdentityScope(type);
        this.radioPersonnelRespondentDaoConfig = ((DaoConfig) daoConfigMap.get(RadioPersonnelRespondentDao.class)).clone();
        this.radioPersonnelRespondentDaoConfig.initIdentityScope(type);
        this.radioPersonnelPeerDaoConfig = ((DaoConfig) daoConfigMap.get(RadioPersonnelPeerDao.class)).clone();
        this.radioPersonnelPeerDaoConfig.initIdentityScope(type);
        this.radioCarRespondentDaoConfig = ((DaoConfig) daoConfigMap.get(RadioCarRespondentDao.class)).clone();
        this.radioCarRespondentDaoConfig.initIdentityScope(type);
        this.radioCarPeerDaoConfig = ((DaoConfig) daoConfigMap.get(RadioCarPeerDao.class)).clone();
        this.radioCarPeerDaoConfig.initIdentityScope(type);
        this.suspiciousPhoneDaoConfig = ((DaoConfig) daoConfigMap.get(SuspiciousPhoneDao.class)).clone();
        this.suspiciousPhoneDaoConfig.initIdentityScope(type);
        this.investigationInfoDaoConfig = ((DaoConfig) daoConfigMap.get(InvestigationInfoDao.class)).clone();
        this.investigationInfoDaoConfig.initIdentityScope(type);
        this.investigateVehicleDaoConfig = ((DaoConfig) daoConfigMap.get(InvestigateVehicleDao.class)).clone();
        this.investigateVehicleDaoConfig.initIdentityScope(type);
        this.investigateBankCardDaoConfig = ((DaoConfig) daoConfigMap.get(InvestigateBankCardDao.class)).clone();
        this.investigateBankCardDaoConfig.initIdentityScope(type);
        this.investigateFamilyDaoConfig = ((DaoConfig) daoConfigMap.get(InvestigateFamilyDao.class)).clone();
        this.investigateFamilyDaoConfig.initIdentityScope(type);
        this.investigateSoftDaoConfig = ((DaoConfig) daoConfigMap.get(InvestigateSoftDao.class)).clone();
        this.investigateSoftDaoConfig.initIdentityScope(type);
        this.buildingInfoDaoConfig = ((DaoConfig) daoConfigMap.get(BuildingInfoDao.class)).clone();
        this.buildingInfoDaoConfig.initIdentityScope(type);
        this.houseInfoDaoConfig = ((DaoConfig) daoConfigMap.get(HouseInfoDao.class)).clone();
        this.houseInfoDaoConfig.initIdentityScope(type);
        this.personInfoDaoConfig = ((DaoConfig) daoConfigMap.get(PersonInfoDao.class)).clone();
        this.personInfoDaoConfig.initIdentityScope(type);
        this.comparisonDaoConfig = ((DaoConfig) daoConfigMap.get(ComparisonDao.class)).clone();
        this.comparisonDaoConfig.initIdentityScope(type);
        this.overduePersonInfoDaoConfig = ((DaoConfig) daoConfigMap.get(OverduePersonInfoDao.class)).clone();
        this.overduePersonInfoDaoConfig.initIdentityScope(type);
        this.overduePersonVisitorDaoConfig = ((DaoConfig) daoConfigMap.get(OverduePersonVisitorDao.class)).clone();
        this.overduePersonVisitorDaoConfig.initIdentityScope(type);
        this.overduePersonContactDaoConfig = ((DaoConfig) daoConfigMap.get(OverduePersonContactDao.class)).clone();
        this.overduePersonContactDaoConfig.initIdentityScope(type);
        this.manualInfoDaoConfig = ((DaoConfig) daoConfigMap.get(ManualInfoDao.class)).clone();
        this.manualInfoDaoConfig.initIdentityScope(type);
        this.manualVehicleDaoConfig = ((DaoConfig) daoConfigMap.get(ManualVehicleDao.class)).clone();
        this.manualVehicleDaoConfig.initIdentityScope(type);
        this.manualBankCardDaoConfig = ((DaoConfig) daoConfigMap.get(ManualBankCardDao.class)).clone();
        this.manualBankCardDaoConfig.initIdentityScope(type);
        this.manualFamilyDaoConfig = ((DaoConfig) daoConfigMap.get(ManualFamilyDao.class)).clone();
        this.manualFamilyDaoConfig.initIdentityScope(type);
        this.manualteSoftDaoConfig = ((DaoConfig) daoConfigMap.get(ManualteSoftDao.class)).clone();
        this.manualteSoftDaoConfig.initIdentityScope(type);
        this.noticeDaoConfig = ((DaoConfig) daoConfigMap.get(NoticeDao.class)).clone();
        this.noticeDaoConfig.initIdentityScope(type);
        this.vehicleReportDaoConfig = ((DaoConfig) daoConfigMap.get(VehicleReportDao.class)).clone();
        this.vehicleReportDaoConfig.initIdentityScope(type);
        this.wifiDetectorDaoConfig = ((DaoConfig) daoConfigMap.get(WifiDetectorDao.class)).clone();
        this.wifiDetectorDaoConfig.initIdentityScope(type);
        this.signPlaceDaoConfig = ((DaoConfig) daoConfigMap.get(SignPlaceDao.class)).clone();
        this.signPlaceDaoConfig.initIdentityScope(type);
        this.signBeanDaoConfig = ((DaoConfig) daoConfigMap.get(SignBeanDao.class)).clone();
        this.signBeanDaoConfig.initIdentityScope(type);
        this.outOfPersonInfoDaoConfig = ((DaoConfig) daoConfigMap.get(OutOfPersonInfoDao.class)).clone();
        this.outOfPersonInfoDaoConfig.initIdentityScope(type);
        this.outOfPersonRelativeDaoConfig = ((DaoConfig) daoConfigMap.get(OutOfPersonRelativeDao.class)).clone();
        this.outOfPersonRelativeDaoConfig.initIdentityScope(type);
        this.outOfPersonPeerDaoConfig = ((DaoConfig) daoConfigMap.get(OutOfPersonPeerDao.class)).clone();
        this.outOfPersonPeerDaoConfig.initIdentityScope(type);
        this.influxPersonInfoDaoConfig = ((DaoConfig) daoConfigMap.get(InfluxPersonInfoDao.class)).clone();
        this.influxPersonInfoDaoConfig.initIdentityScope(type);
        this.influxPersonRelativeDaoConfig = ((DaoConfig) daoConfigMap.get(InfluxPersonRelativeDao.class)).clone();
        this.influxPersonRelativeDaoConfig.initIdentityScope(type);
        this.localPersonnelCarResEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalPersonnelCarResEntityDao.class)).clone();
        this.localPersonnelCarResEntityDaoConfig.initIdentityScope(type);
        this.localPersonnelCarMismatchEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalPersonnelCarMismatchEntityDao.class)).clone();
        this.localPersonnelCarMismatchEntityDaoConfig.initIdentityScope(type);
        this.localPersonnelCarVisitorEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalPersonnelCarVisitorEntityDao.class)).clone();
        this.localPersonnelCarVisitorEntityDaoConfig.initIdentityScope(type);
        this.localPersonnelIdMismatchEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalPersonnelIdMismatchEntityDao.class)).clone();
        this.localPersonnelIdMismatchEntityDaoConfig.initIdentityScope(type);
        this.localPersonnelIdVisitorEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalPersonnelIdVisitorEntityDao.class)).clone();
        this.localPersonnelIdVisitorEntityDaoConfig.initIdentityScope(type);
        this.localPersonnelIdResEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalPersonnelIdResEntityDao.class)).clone();
        this.localPersonnelIdResEntityDaoConfig.initIdentityScope(type);
        this.localPersonPhoneEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalPersonPhoneEntityDao.class)).clone();
        this.localPersonPhoneEntityDaoConfig.initIdentityScope(type);
        this.localPersonPhoneVisitorEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalPersonPhoneVisitorEntityDao.class)).clone();
        this.localPersonPhoneVisitorEntityDaoConfig.initIdentityScope(type);
        this.localPersonPhoneResEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalPersonPhoneResEntityDao.class)).clone();
        this.localPersonPhoneResEntityDaoConfig.initIdentityScope(type);
        this.localNoIdCardTrackEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalNoIdCardTrackEntityDao.class)).clone();
        this.localNoIdCardTrackEntityDaoConfig.initIdentityScope(type);
        this.localNoIdCardTrackResEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalNoIdCardTrackResEntityDao.class)).clone();
        this.localNoIdCardTrackResEntityDaoConfig.initIdentityScope(type);
        this.localNoIdCardTrackVisitorEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalNoIdCardTrackVisitorEntityDao.class)).clone();
        this.localNoIdCardTrackVisitorEntityDaoConfig.initIdentityScope(type);
        this.localNoCarTrackEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalNoCarTrackEntityDao.class)).clone();
        this.localNoCarTrackEntityDaoConfig.initIdentityScope(type);
        this.localNoCarTrackResEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalNoCarTrackResEntityDao.class)).clone();
        this.localNoCarTrackResEntityDaoConfig.initIdentityScope(type);
        this.localNoCarTrackVisitorEntityDaoConfig = ((DaoConfig) daoConfigMap.get(LocalNoCarTrackVisitorEntityDao.class)).clone();
        this.localNoCarTrackVisitorEntityDaoConfig.initIdentityScope(type);
        this.commonSaveInfoDaoConfig = ((DaoConfig) daoConfigMap.get(CommonSaveInfoDao.class)).clone();
        this.commonSaveInfoDaoConfig.initIdentityScope(type);
        registerDao(IllegalPerson.class, this.illegalPersonDao);
        registerDao(IllegalCar.class, this.illegalCarDao);
        registerDao(ThingTotalEntity.class, this.thingTotalEntityDao);
        registerDao(ReportThing.class, this.reportThingDao);
        registerDao(DeliveryControl.class, this.deliveryControlDao);
        registerDao(IllegalThing.class, this.illegalThingDao);
        registerDao(PopulationFamily.class, this.populationFamilyDao);
        registerDao(PopulationHouse.class, this.populationHouseDao);
        registerDao(MissionCommand.class, this.missionCommandDao);
        registerDao(ElecCheckFeedback.class, this.elecCheckFeedbackDao);
        registerDao(NineOneThreeRespondent.class, this.nineOneThreeRespondentDao);
        registerDao(NineOneThreeVisitor.class, this.nineOneThreeVisitorDao);
        registerDao(NineOneThreePhone.class, this.nineOneThreePhoneDao);
        registerDao(NineOneThreeSoftware.class, this.nineOneThreeSoftwareDao);
        registerDao(NineOneThreeOverseas.class, this.nineOneThreeOverseasDao);
        registerDao(NineOneThreeResult.class, this.nineOneThreeResultDao);
        registerDao(RadioPersonnelRespondent.class, this.radioPersonnelRespondentDao);
        registerDao(RadioPersonnelPeer.class, this.radioPersonnelPeerDao);
        registerDao(RadioCarRespondent.class, this.radioCarRespondentDao);
        registerDao(RadioCarPeer.class, this.radioCarPeerDao);
        registerDao(SuspiciousPhone.class, this.suspiciousPhoneDao);
        registerDao(InvestigationInfo.class, this.investigationInfoDao);
        registerDao(InvestigateVehicle.class, this.investigateVehicleDao);
        registerDao(InvestigateBankCard.class, this.investigateBankCardDao);
        registerDao(InvestigateFamily.class, this.investigateFamilyDao);
        registerDao(InvestigateSoft.class, this.investigateSoftDao);
        registerDao(BuildingInfo.class, this.buildingInfoDao);
        registerDao(HouseInfo.class, this.houseInfoDao);
        registerDao(PersonInfo.class, this.personInfoDao);
        registerDao(Comparison.class, this.comparisonDao);
        registerDao(OverduePersonInfo.class, this.overduePersonInfoDao);
        registerDao(OverduePersonVisitor.class, this.overduePersonVisitorDao);
        registerDao(OverduePersonContact.class, this.overduePersonContactDao);
        registerDao(ManualInfo.class, this.manualInfoDao);
        registerDao(ManualVehicle.class, this.manualVehicleDao);
        registerDao(ManualBankCard.class, this.manualBankCardDao);
        registerDao(ManualFamily.class, this.manualFamilyDao);
        registerDao(ManualteSoft.class, this.manualteSoftDao);
        registerDao(Notice.class, this.noticeDao);
        registerDao(VehicleReport.class, this.vehicleReportDao);
        registerDao(WifiDetector.class, this.wifiDetectorDao);
        registerDao(SignPlace.class, this.signPlaceDao);
        registerDao(SignBean.class, this.signBeanDao);
        registerDao(OutOfPersonInfo.class, this.outOfPersonInfoDao);
        registerDao(OutOfPersonRelative.class, this.outOfPersonRelativeDao);
        registerDao(OutOfPersonPeer.class, this.outOfPersonPeerDao);
        registerDao(InfluxPersonInfo.class, this.influxPersonInfoDao);
        registerDao(InfluxPersonRelative.class, this.influxPersonRelativeDao);
        registerDao(LocalPersonnelCarResEntity.class, this.localPersonnelCarResEntityDao);
        registerDao(LocalPersonnelCarMismatchEntity.class, this.localPersonnelCarMismatchEntityDao);
        registerDao(LocalPersonnelCarVisitorEntity.class, this.localPersonnelCarVisitorEntityDao);
        registerDao(LocalPersonnelIdMismatchEntity.class, this.localPersonnelIdMismatchEntityDao);
        registerDao(LocalPersonnelIdVisitorEntity.class, this.localPersonnelIdVisitorEntityDao);
        registerDao(LocalPersonnelIdResEntity.class, this.localPersonnelIdResEntityDao);
        registerDao(LocalPersonPhoneEntity.class, this.localPersonPhoneEntityDao);
        registerDao(LocalPersonPhoneVisitorEntity.class, this.localPersonPhoneVisitorEntityDao);
        registerDao(LocalPersonPhoneResEntity.class, this.localPersonPhoneResEntityDao);
        registerDao(LocalNoIdCardTrackEntity.class, this.localNoIdCardTrackEntityDao);
        registerDao(LocalNoIdCardTrackResEntity.class, this.localNoIdCardTrackResEntityDao);
        registerDao(LocalNoIdCardTrackVisitorEntity.class, this.localNoIdCardTrackVisitorEntityDao);
        registerDao(LocalNoCarTrackEntity.class, this.localNoCarTrackEntityDao);
        registerDao(LocalNoCarTrackResEntity.class, this.localNoCarTrackResEntityDao);
        registerDao(LocalNoCarTrackVisitorEntity.class, this.localNoCarTrackVisitorEntityDao);
        registerDao(CommonSaveInfo.class, this.commonSaveInfoDao);
    }

    public void clear() {
        this.illegalPersonDaoConfig.clearIdentityScope();
        this.illegalCarDaoConfig.clearIdentityScope();
        this.thingTotalEntityDaoConfig.clearIdentityScope();
        this.reportThingDaoConfig.clearIdentityScope();
        this.deliveryControlDaoConfig.clearIdentityScope();
        this.illegalThingDaoConfig.clearIdentityScope();
        this.populationFamilyDaoConfig.clearIdentityScope();
        this.populationHouseDaoConfig.clearIdentityScope();
        this.missionCommandDaoConfig.clearIdentityScope();
        this.elecCheckFeedbackDaoConfig.clearIdentityScope();
        this.nineOneThreeRespondentDaoConfig.clearIdentityScope();
        this.nineOneThreeVisitorDaoConfig.clearIdentityScope();
        this.nineOneThreePhoneDaoConfig.clearIdentityScope();
        this.nineOneThreeSoftwareDaoConfig.clearIdentityScope();
        this.nineOneThreeOverseasDaoConfig.clearIdentityScope();
        this.nineOneThreeResultDaoConfig.clearIdentityScope();
        this.radioPersonnelRespondentDaoConfig.clearIdentityScope();
        this.radioPersonnelPeerDaoConfig.clearIdentityScope();
        this.radioCarRespondentDaoConfig.clearIdentityScope();
        this.radioCarPeerDaoConfig.clearIdentityScope();
        this.suspiciousPhoneDaoConfig.clearIdentityScope();
        this.investigationInfoDaoConfig.clearIdentityScope();
        this.investigateVehicleDaoConfig.clearIdentityScope();
        this.investigateBankCardDaoConfig.clearIdentityScope();
        this.investigateFamilyDaoConfig.clearIdentityScope();
        this.investigateSoftDaoConfig.clearIdentityScope();
        this.buildingInfoDaoConfig.clearIdentityScope();
        this.houseInfoDaoConfig.clearIdentityScope();
        this.personInfoDaoConfig.clearIdentityScope();
        this.comparisonDaoConfig.clearIdentityScope();
        this.overduePersonInfoDaoConfig.clearIdentityScope();
        this.overduePersonVisitorDaoConfig.clearIdentityScope();
        this.overduePersonContactDaoConfig.clearIdentityScope();
        this.manualInfoDaoConfig.clearIdentityScope();
        this.manualVehicleDaoConfig.clearIdentityScope();
        this.manualBankCardDaoConfig.clearIdentityScope();
        this.manualFamilyDaoConfig.clearIdentityScope();
        this.manualteSoftDaoConfig.clearIdentityScope();
        this.noticeDaoConfig.clearIdentityScope();
        this.vehicleReportDaoConfig.clearIdentityScope();
        this.wifiDetectorDaoConfig.clearIdentityScope();
        this.signPlaceDaoConfig.clearIdentityScope();
        this.signBeanDaoConfig.clearIdentityScope();
        this.outOfPersonInfoDaoConfig.clearIdentityScope();
        this.outOfPersonRelativeDaoConfig.clearIdentityScope();
        this.outOfPersonPeerDaoConfig.clearIdentityScope();
        this.influxPersonInfoDaoConfig.clearIdentityScope();
        this.influxPersonRelativeDaoConfig.clearIdentityScope();
        this.localPersonnelCarResEntityDaoConfig.clearIdentityScope();
        this.localPersonnelCarMismatchEntityDaoConfig.clearIdentityScope();
        this.localPersonnelCarVisitorEntityDaoConfig.clearIdentityScope();
        this.localPersonnelIdMismatchEntityDaoConfig.clearIdentityScope();
        this.localPersonnelIdVisitorEntityDaoConfig.clearIdentityScope();
        this.localPersonnelIdResEntityDaoConfig.clearIdentityScope();
        this.localPersonPhoneEntityDaoConfig.clearIdentityScope();
        this.localPersonPhoneVisitorEntityDaoConfig.clearIdentityScope();
        this.localPersonPhoneResEntityDaoConfig.clearIdentityScope();
        this.localNoIdCardTrackEntityDaoConfig.clearIdentityScope();
        this.localNoIdCardTrackResEntityDaoConfig.clearIdentityScope();
        this.localNoIdCardTrackVisitorEntityDaoConfig.clearIdentityScope();
        this.localNoCarTrackEntityDaoConfig.clearIdentityScope();
        this.localNoCarTrackResEntityDaoConfig.clearIdentityScope();
        this.localNoCarTrackVisitorEntityDaoConfig.clearIdentityScope();
        this.commonSaveInfoDaoConfig.clearIdentityScope();
    }

    public IllegalPersonDao getIllegalPersonDao() {
        return this.illegalPersonDao;
    }

    public IllegalCarDao getIllegalCarDao() {
        return this.illegalCarDao;
    }

    public ThingTotalEntityDao getThingTotalEntityDao() {
        return this.thingTotalEntityDao;
    }

    public ReportThingDao getReportThingDao() {
        return this.reportThingDao;
    }

    public DeliveryControlDao getDeliveryControlDao() {
        return this.deliveryControlDao;
    }

    public IllegalThingDao getIllegalThingDao() {
        return this.illegalThingDao;
    }

    public PopulationFamilyDao getPopulationFamilyDao() {
        return this.populationFamilyDao;
    }

    public PopulationHouseDao getPopulationHouseDao() {
        return this.populationHouseDao;
    }

    public MissionCommandDao getMissionCommandDao() {
        return this.missionCommandDao;
    }

    public ElecCheckFeedbackDao getElecCheckFeedbackDao() {
        return this.elecCheckFeedbackDao;
    }

    public NineOneThreeRespondentDao getNineOneThreeRespondentDao() {
        return this.nineOneThreeRespondentDao;
    }

    public NineOneThreeVisitorDao getNineOneThreeVisitorDao() {
        return this.nineOneThreeVisitorDao;
    }

    public NineOneThreePhoneDao getNineOneThreePhoneDao() {
        return this.nineOneThreePhoneDao;
    }

    public NineOneThreeSoftwareDao getNineOneThreeSoftwareDao() {
        return this.nineOneThreeSoftwareDao;
    }

    public NineOneThreeOverseasDao getNineOneThreeOverseasDao() {
        return this.nineOneThreeOverseasDao;
    }

    public NineOneThreeResultDao getNineOneThreeResultDao() {
        return this.nineOneThreeResultDao;
    }

    public RadioPersonnelRespondentDao getRadioPersonnelRespondentDao() {
        return this.radioPersonnelRespondentDao;
    }

    public RadioPersonnelPeerDao getRadioPersonnelPeerDao() {
        return this.radioPersonnelPeerDao;
    }

    public RadioCarRespondentDao getRadioCarRespondentDao() {
        return this.radioCarRespondentDao;
    }

    public RadioCarPeerDao getRadioCarPeerDao() {
        return this.radioCarPeerDao;
    }

    public SuspiciousPhoneDao getSuspiciousPhoneDao() {
        return this.suspiciousPhoneDao;
    }

    public InvestigationInfoDao getInvestigationInfoDao() {
        return this.investigationInfoDao;
    }

    public InvestigateVehicleDao getInvestigateVehicleDao() {
        return this.investigateVehicleDao;
    }

    public InvestigateBankCardDao getInvestigateBankCardDao() {
        return this.investigateBankCardDao;
    }

    public InvestigateFamilyDao getInvestigateFamilyDao() {
        return this.investigateFamilyDao;
    }

    public InvestigateSoftDao getInvestigateSoftDao() {
        return this.investigateSoftDao;
    }

    public BuildingInfoDao getBuildingInfoDao() {
        return this.buildingInfoDao;
    }

    public HouseInfoDao getHouseInfoDao() {
        return this.houseInfoDao;
    }

    public PersonInfoDao getPersonInfoDao() {
        return this.personInfoDao;
    }

    public ComparisonDao getComparisonDao() {
        return this.comparisonDao;
    }

    public OverduePersonInfoDao getOverduePersonInfoDao() {
        return this.overduePersonInfoDao;
    }

    public OverduePersonVisitorDao getOverduePersonVisitorDao() {
        return this.overduePersonVisitorDao;
    }

    public OverduePersonContactDao getOverduePersonContactDao() {
        return this.overduePersonContactDao;
    }

    public ManualInfoDao getManualInfoDao() {
        return this.manualInfoDao;
    }

    public ManualVehicleDao getManualVehicleDao() {
        return this.manualVehicleDao;
    }

    public ManualBankCardDao getManualBankCardDao() {
        return this.manualBankCardDao;
    }

    public ManualFamilyDao getManualFamilyDao() {
        return this.manualFamilyDao;
    }

    public ManualteSoftDao getManualteSoftDao() {
        return this.manualteSoftDao;
    }

    public NoticeDao getNoticeDao() {
        return this.noticeDao;
    }

    public VehicleReportDao getVehicleReportDao() {
        return this.vehicleReportDao;
    }

    public WifiDetectorDao getWifiDetectorDao() {
        return this.wifiDetectorDao;
    }

    public SignPlaceDao getSignPlaceDao() {
        return this.signPlaceDao;
    }

    public SignBeanDao getSignBeanDao() {
        return this.signBeanDao;
    }

    public OutOfPersonInfoDao getOutOfPersonInfoDao() {
        return this.outOfPersonInfoDao;
    }

    public OutOfPersonRelativeDao getOutOfPersonRelativeDao() {
        return this.outOfPersonRelativeDao;
    }

    public OutOfPersonPeerDao getOutOfPersonPeerDao() {
        return this.outOfPersonPeerDao;
    }

    public InfluxPersonInfoDao getInfluxPersonInfoDao() {
        return this.influxPersonInfoDao;
    }

    public InfluxPersonRelativeDao getInfluxPersonRelativeDao() {
        return this.influxPersonRelativeDao;
    }

    public LocalPersonnelCarResEntityDao getLocalPersonnelCarResEntityDao() {
        return this.localPersonnelCarResEntityDao;
    }

    public LocalPersonnelCarMismatchEntityDao getLocalPersonnelCarMismatchEntityDao() {
        return this.localPersonnelCarMismatchEntityDao;
    }

    public LocalPersonnelCarVisitorEntityDao getLocalPersonnelCarVisitorEntityDao() {
        return this.localPersonnelCarVisitorEntityDao;
    }

    public LocalPersonnelIdMismatchEntityDao getLocalPersonnelIdMismatchEntityDao() {
        return this.localPersonnelIdMismatchEntityDao;
    }

    public LocalPersonnelIdVisitorEntityDao getLocalPersonnelIdVisitorEntityDao() {
        return this.localPersonnelIdVisitorEntityDao;
    }

    public LocalPersonnelIdResEntityDao getLocalPersonnelIdResEntityDao() {
        return this.localPersonnelIdResEntityDao;
    }

    public LocalPersonPhoneEntityDao getLocalPersonPhoneEntityDao() {
        return this.localPersonPhoneEntityDao;
    }

    public LocalPersonPhoneVisitorEntityDao getLocalPersonPhoneVisitorEntityDao() {
        return this.localPersonPhoneVisitorEntityDao;
    }

    public LocalPersonPhoneResEntityDao getLocalPersonPhoneResEntityDao() {
        return this.localPersonPhoneResEntityDao;
    }

    public LocalNoIdCardTrackEntityDao getLocalNoIdCardTrackEntityDao() {
        return this.localNoIdCardTrackEntityDao;
    }

    public LocalNoIdCardTrackResEntityDao getLocalNoIdCardTrackResEntityDao() {
        return this.localNoIdCardTrackResEntityDao;
    }

    public LocalNoIdCardTrackVisitorEntityDao getLocalNoIdCardTrackVisitorEntityDao() {
        return this.localNoIdCardTrackVisitorEntityDao;
    }

    public LocalNoCarTrackEntityDao getLocalNoCarTrackEntityDao() {
        return this.localNoCarTrackEntityDao;
    }

    public LocalNoCarTrackResEntityDao getLocalNoCarTrackResEntityDao() {
        return this.localNoCarTrackResEntityDao;
    }

    public LocalNoCarTrackVisitorEntityDao getLocalNoCarTrackVisitorEntityDao() {
        return this.localNoCarTrackVisitorEntityDao;
    }

    public CommonSaveInfoDao getCommonSaveInfoDao() {
        return this.commonSaveInfoDao;
    }
}
