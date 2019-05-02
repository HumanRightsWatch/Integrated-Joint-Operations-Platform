package com.fec.xjoneproject.ui.task.person_car_match.bean;

import com.fec.xjoneproject.http.response.ReportResult;
import java.util.List;

public class PersonCarResponse extends ReportResult {
    private List<PersonnelCarMismatchEntity> res;
    private List<PersonnelCarVisitorEntity> visitor;

    public List<PersonnelCarMismatchEntity> getRes() {
        return this.res;
    }

    public void setRes(List<PersonnelCarMismatchEntity> res) {
        this.res = res;
    }

    public List<PersonnelCarVisitorEntity> getVisitor() {
        return this.visitor;
    }

    public void setVisitor(List<PersonnelCarVisitorEntity> visitor) {
        this.visitor = visitor;
    }
}
