package com.fec.xjoneproject.ui.task.miss_phone_trail.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.hbfec.asmack.im.comm.ConnectionUtils;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneinformation.Utils.Constants;
import com.hbfec.xjoneinformation.Utils.XMPPConfiguration;

public class MissPhoneTrailResEntity extends BaseObservable {
    private String addUser;
    private String addUserName;
    private Integer expression;
    private String expressionDesc;
    private String fkMptv;
    private String id;
    private Double latitude;
    private String locationDescription;
    private Double longitude;
    private Integer missTrailReason;
    private String note;
    private String otherReason;
    private Integer police;
    private String policeCheck;
    private String policeReason;
    private Integer relationship;
    private String telNumber;
    private String userOrgName;
    private String userOrganizationId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkMptv() {
        return this.fkMptv;
    }

    public void setFkMptv(String fkMitv) {
        this.fkMptv = fkMitv;
    }

    public Integer getRelationship() {
        return this.relationship;
    }

    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
    }

    public Integer getMissTrailReason() {
        return this.missTrailReason;
    }

    public void setMissTrailReason(Integer missTrailReason) {
        this.missTrailReason = missTrailReason;
    }

    public String getOtherReason() {
        return this.otherReason;
    }

    public void setOtherReason(String otherReason) {
        this.otherReason = otherReason;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Integer getExpression() {
        return this.expression;
    }

    public void setExpression(Integer expression) {
        this.expression = expression;
    }

    public String getExpressionDesc() {
        return this.expressionDesc;
    }

    public void setExpressionDesc(String expressionDesc) {
        this.expressionDesc = expressionDesc;
    }

    @Bindable
    public Integer getPolice() {
        return this.police;
    }

    public void setPolice(Integer police) {
        this.police = police;
        setPoliceCheck(String.valueOf(police));
        notifyPropertyChanged(38);
    }

    public String getPoliceCheck() {
        return this.policeCheck;
    }

    public void setPoliceCheck(String policeCheck) {
        this.policeCheck = policeCheck;
    }

    public String getPoliceReason() {
        return this.policeReason;
    }

    public void setPoliceReason(String policeReason) {
        this.policeReason = policeReason;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
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
