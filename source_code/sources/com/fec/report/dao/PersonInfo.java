package com.fec.report.dao;

import java.util.List;
import org.greenrobot.greendao.DaoException;

public class PersonInfo {
    private String AsylumEducateReason;
    private String action;
    private String add_user;
    private String address;
    private String birthday;
    private Integer blood;
    private Long building_id;
    private String car;
    private String card;
    private String card_number;
    private Integer card_type;
    private Integer certi_agree;
    private Integer collection_theme;
    private List<Comparison> comparisonList;
    private Integer count;
    private String current_address;
    private transient DaoSession daoSession;
    private String description;
    private String destination_country;
    private Integer educational;
    private String exit_other_reason;
    private Integer exit_reason;
    private String exit_time;
    private String height;
    private Long house_id;
    private Long id;
    private Integer isChangeIdin;
    private Integer modify_type;
    private transient PersonInfoDao myDao;
    private String name;
    private String nation;
    private String newCensus;
    private String newIdCard;
    private String newName;
    private String newNation;
    private String passport;
    private String person_type;
    private String person_type_other;
    private String phone;
    private String photo;
    private Integer political_status;
    private String political_status_other;
    private Integer relationship;
    private String relationshipother;
    private Integer religious_atmosphere;
    private Integer religious_name;
    private String religious_name_other;
    private String sendPhoto;
    private String service_id;
    private String toCensus;
    private String work;

    public PersonInfo(Long id) {
        this.id = id;
    }

    public PersonInfo(Long id, String service_id, Long building_id, Long house_id, String name, String card, String address, String photo, Integer modify_type, String phone, String car, String work, Integer educational, Integer religious_atmosphere, Integer religious_name, String religious_name_other, Integer political_status, String political_status_other, String birthday, String height, Integer blood, String nation, Integer relationship, String relationshipother, String add_user, String person_type, String person_type_other, Integer card_type, String card_number, String destination_country, String exit_time, Integer exit_reason, String exit_other_reason, Integer collection_theme, Integer certi_agree, String toCensus, Integer isChangeIdin, String newName, String newCensus, String newIdCard, String newNation, String passport, String AsylumEducateReason, String action, String description, String current_address, String sendPhoto, Integer count) {
        this.id = id;
        this.service_id = service_id;
        this.building_id = building_id;
        this.house_id = house_id;
        this.name = name;
        this.card = card;
        this.address = address;
        this.photo = photo;
        this.modify_type = modify_type;
        this.phone = phone;
        this.car = car;
        this.work = work;
        this.educational = educational;
        this.religious_atmosphere = religious_atmosphere;
        this.religious_name = religious_name;
        this.religious_name_other = religious_name_other;
        this.political_status = political_status;
        this.political_status_other = political_status_other;
        this.birthday = birthday;
        this.height = height;
        this.blood = blood;
        this.nation = nation;
        this.relationship = relationship;
        this.relationshipother = relationshipother;
        this.add_user = add_user;
        this.person_type = person_type;
        this.person_type_other = person_type_other;
        this.card_type = card_type;
        this.card_number = card_number;
        this.destination_country = destination_country;
        this.exit_time = exit_time;
        this.exit_reason = exit_reason;
        this.exit_other_reason = exit_other_reason;
        this.collection_theme = collection_theme;
        this.certi_agree = certi_agree;
        this.toCensus = toCensus;
        this.isChangeIdin = isChangeIdin;
        this.newName = newName;
        this.newCensus = newCensus;
        this.newIdCard = newIdCard;
        this.newNation = newNation;
        this.passport = passport;
        this.AsylumEducateReason = AsylumEducateReason;
        this.action = action;
        this.description = description;
        this.current_address = current_address;
        this.sendPhoto = sendPhoto;
        this.count = count;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getPersonInfoDao() : null;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService_id() {
        return this.service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public Long getBuilding_id() {
        return this.building_id;
    }

    public void setBuilding_id(Long building_id) {
        this.building_id = building_id;
    }

    public Long getHouse_id() {
        return this.house_id;
    }

    public void setHouse_id(Long house_id) {
        this.house_id = house_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return this.card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getModify_type() {
        return this.modify_type;
    }

    public void setModify_type(Integer modify_type) {
        this.modify_type = modify_type;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCar() {
        return this.car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getWork() {
        return this.work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Integer getEducational() {
        return this.educational;
    }

    public void setEducational(Integer educational) {
        this.educational = educational;
    }

    public Integer getReligious_atmosphere() {
        return this.religious_atmosphere;
    }

    public void setReligious_atmosphere(Integer religious_atmosphere) {
        this.religious_atmosphere = religious_atmosphere;
    }

    public Integer getReligious_name() {
        return this.religious_name;
    }

    public void setReligious_name(Integer religious_name) {
        this.religious_name = religious_name;
    }

    public String getReligious_name_other() {
        return this.religious_name_other;
    }

    public void setReligious_name_other(String religious_name_other) {
        this.religious_name_other = religious_name_other;
    }

    public Integer getPolitical_status() {
        return this.political_status;
    }

    public void setPolitical_status(Integer political_status) {
        this.political_status = political_status;
    }

    public String getPolitical_status_other() {
        return this.political_status_other;
    }

    public void setPolitical_status_other(String political_status_other) {
        this.political_status_other = political_status_other;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getBlood() {
        return this.blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getRelationship() {
        return this.relationship;
    }

    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
    }

    public String getRelationshipother() {
        return this.relationshipother;
    }

    public void setRelationshipother(String relationshipother) {
        this.relationshipother = relationshipother;
    }

    public String getAdd_user() {
        return this.add_user;
    }

    public void setAdd_user(String add_user) {
        this.add_user = add_user;
    }

    public String getPerson_type() {
        return this.person_type;
    }

    public void setPerson_type(String person_type) {
        this.person_type = person_type;
    }

    public String getPerson_type_other() {
        return this.person_type_other;
    }

    public void setPerson_type_other(String person_type_other) {
        this.person_type_other = person_type_other;
    }

    public Integer getCard_type() {
        return this.card_type;
    }

    public void setCard_type(Integer card_type) {
        this.card_type = card_type;
    }

    public String getCard_number() {
        return this.card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getDestination_country() {
        return this.destination_country;
    }

    public void setDestination_country(String destination_country) {
        this.destination_country = destination_country;
    }

    public String getExit_time() {
        return this.exit_time;
    }

    public void setExit_time(String exit_time) {
        this.exit_time = exit_time;
    }

    public Integer getExit_reason() {
        return this.exit_reason;
    }

    public void setExit_reason(Integer exit_reason) {
        this.exit_reason = exit_reason;
    }

    public String getExit_other_reason() {
        return this.exit_other_reason;
    }

    public void setExit_other_reason(String exit_other_reason) {
        this.exit_other_reason = exit_other_reason;
    }

    public Integer getCollection_theme() {
        return this.collection_theme;
    }

    public void setCollection_theme(Integer collection_theme) {
        this.collection_theme = collection_theme;
    }

    public Integer getCerti_agree() {
        return this.certi_agree;
    }

    public void setCerti_agree(Integer certi_agree) {
        this.certi_agree = certi_agree;
    }

    public String getToCensus() {
        return this.toCensus;
    }

    public void setToCensus(String toCensus) {
        this.toCensus = toCensus;
    }

    public Integer getIsChangeIdin() {
        return this.isChangeIdin;
    }

    public void setIsChangeIdin(Integer isChangeIdin) {
        this.isChangeIdin = isChangeIdin;
    }

    public String getNewName() {
        return this.newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewCensus() {
        return this.newCensus;
    }

    public void setNewCensus(String newCensus) {
        this.newCensus = newCensus;
    }

    public String getNewIdCard() {
        return this.newIdCard;
    }

    public void setNewIdCard(String newIdCard) {
        this.newIdCard = newIdCard;
    }

    public String getNewNation() {
        return this.newNation;
    }

    public void setNewNation(String newNation) {
        this.newNation = newNation;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAsylumEducateReason() {
        return this.AsylumEducateReason;
    }

    public void setAsylumEducateReason(String AsylumEducateReason) {
        this.AsylumEducateReason = AsylumEducateReason;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrent_address() {
        return this.current_address;
    }

    public void setCurrent_address(String current_address) {
        this.current_address = current_address;
    }

    public String getSendPhoto() {
        return this.sendPhoto;
    }

    public void setSendPhoto(String sendPhoto) {
        this.sendPhoto = sendPhoto;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Comparison> getComparisonList() {
        if (this.comparisonList == null) {
            __throwIfDetached();
            List<Comparison> comparisonListNew = this.daoSession.getComparisonDao()._queryPersonInfo_ComparisonList(this.id);
            synchronized (this) {
                if (this.comparisonList == null) {
                    this.comparisonList = comparisonListNew;
                }
            }
        }
        return this.comparisonList;
    }

    public synchronized void resetComparisonList() {
        this.comparisonList = null;
    }

    public void delete() {
        __throwIfDetached();
        this.myDao.delete(this);
    }

    public void update() {
        __throwIfDetached();
        this.myDao.update(this);
    }

    public void refresh() {
        __throwIfDetached();
        this.myDao.refresh(this);
    }

    private void __throwIfDetached() {
        if (this.myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }
}
