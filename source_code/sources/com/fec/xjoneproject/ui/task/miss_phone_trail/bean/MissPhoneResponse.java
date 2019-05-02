package com.fec.xjoneproject.ui.task.miss_phone_trail.bean;

import com.fec.xjoneproject.http.response.ReportResult;
import java.util.List;

public class MissPhoneResponse extends ReportResult {
    private List<MissPhoneTrailWarnEntity> res;
    private List<MissPhoneTrailVisitorEntity> visitor;

    public List<MissPhoneTrailWarnEntity> getRes() {
        return this.res;
    }

    public void setRes(List<MissPhoneTrailWarnEntity> res) {
        this.res = res;
    }

    public List<MissPhoneTrailVisitorEntity> getVisitor() {
        return this.visitor;
    }

    public void setVisitor(List<MissPhoneTrailVisitorEntity> visitor) {
        this.visitor = visitor;
    }
}
