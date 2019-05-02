package com.fec.xjoneproject.ui.task.miss_phone_trail.bean;

import com.fec.xjoneproject.ui.view.fieldGroup.visitor.OneProjectVisitorViewModel.Visitor;
import com.hbfec.asmack.im.comm.ConnectionUtils;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneinformation.Utils.Constants;
import com.hbfec.xjoneinformation.Utils.XMPPConfiguration;

public class MissPhoneTrailVisitorEntity extends Visitor {
    private String addUser;
    private String addUserName;
    private String fkMpt;
    private Double latitude;
    private String locationDescription;
    private Double longitude;
    private String userOrgName;
    private String userOrganizationId;

    public String getFkMpt() {
        return this.fkMpt;
    }

    public void setFkMpt(String fkMit) {
        this.fkMpt = fkMit;
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

    public void setAddUser() {
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
