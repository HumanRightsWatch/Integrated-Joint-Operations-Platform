package com.fec.xjoneproject.ui.task.miss_phone_trail.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.fec.xjoneproject.ui.task.FeedBackBaseActivity;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.task.miss_phone_trail.viewModel.MissPhoneTrailFeedbackViewModel;
import com.fec.xjoneproject.ui.view.fieldGroup.visitor.OneProjectVisitorViewModel.Visitor;
import com.fec.xjoneproject.util.CheckUtils;
import com.hbfec.xjoneinformation.databinding.ActivityMissPhoneTrailFeedbackBinding;
import com.hbfec.xjoneproject.R;

public class MissPhoneTrailFeedbackActivity extends FeedBackBaseActivity {
    private ActivityMissPhoneTrailFeedbackBinding mBinding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mBinding = (ActivityMissPhoneTrailFeedbackBinding) DataBindingUtil.setContentView(this, R.layout.activity_miss_phone_trail_feedback);
        setViewModel(new MissPhoneTrailFeedbackViewModel(this, getIntent().getStringExtra(TaskConstant.ARG_KEY_WARN_ID), 28));
        this.mBinding.setViewModel((MissPhoneTrailFeedbackViewModel) getViewModel());
    }

    public int getTaskState() {
        return 9;
    }

    public String check() {
        return CheckUtils.check(this.mBinding.scrollView, null);
    }

    public void setNewVisitor(Boolean newVisitor) {
        this.mBinding.oneProjectVisitorViewGroup.setNewVisitor(newVisitor);
    }

    public Boolean getNewVisitor() {
        return this.mBinding.oneProjectVisitorViewGroup.getNewVisitor();
    }

    public void setAddVisitor(Visitor visitor) {
        this.mBinding.oneProjectVisitorViewGroup.setAddVisitor(visitor);
    }

    public Visitor getAddVisitor() {
        return this.mBinding.oneProjectVisitorViewGroup.getAddVisitor();
    }

    public void setPushVisitor(Visitor visitor) {
        this.mBinding.oneProjectVisitorViewGroup.setPushVisitor(visitor);
    }

    public Visitor getPushVisitor() {
        return this.mBinding.oneProjectVisitorViewGroup.getPushVisitor();
    }
}
