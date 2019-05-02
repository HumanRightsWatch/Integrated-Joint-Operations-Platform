package com.fec.xjoneproject.ui.task.person_car_match.bean;

import com.hbfec.asmack.im.comm.ConnectionUtils;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneinformation.Utils.Constants;
import com.hbfec.xjoneinformation.Utils.XMPPConfiguration;

public class PersonnelCarVisitorEntity {
    private String addUser;
    private String addUserName;
    private String address;
    private String checkFlag;
    private String fkPcmh;
    private String id;
    private String idCard;
    private Double latitude;
    private String licensePlate;
    private String locationDescription;
    private Double longitude;
    private String name;
    private String phone;
    private String type;
    private String userOrgName;
    private String userOrganizationId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkPcmh() {
        return this.fkPcmh;
    }

    public void setFkPcmh(String fkPcmh) {
        this.fkPcmh = fkPcmh;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheckFlag() {
        return this.checkFlag;
    }

    public void setCheckFlag(String checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getAddUser() {
        return this.addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public String getAddUserName() {
        return this.addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public String getUserOrganizationId() {
        return this.userOrganizationId;
    }

    public void setUserOrganizationId(String userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }

    public String getUserOrgName() {
        return this.userOrgName;
    }

    public void setUserOrgName(String userOrgName) {
        this.userOrgName = userOrgName;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getLocationDescription() {
        return this.locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public PersonnelCarVisitorEntity() {
        XMPPConfiguration mXmppConfig = new XMPPConfiguration(IMSDroid.getContext());
        String userName = mXmppConfig.getString(Constants.UUM_USER_NAME, "");
        String organizationId = mXmppConfig.getString(Constants.UUM_USER_ORGANIZATION_ID, "");
        String organizationName = mXmppConfig.getString(Constants.UUM_USER_ORGANIZATION_NAME, "");
        setAddUser(ConnectionUtils.getLoginName());
        setAddUserName(userName);
        setUserOrganizationId(organizationId);
        setUserOrgName(organizationName);
    }
}
