package com.fec.xjoneproject.ui.task.person_car_match;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.fec.xjoneproject.ui.task.FeedBackBaseActivity;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.util.CheckUtils;
import com.hbfec.xjoneinformation.databinding.ActivityPersonCarBinding;
import com.hbfec.xjoneproject.R;

public class PersonCarActivity extends FeedBackBaseActivity {
    private ActivityPersonCarBinding mBinding;
    private String warnId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.warnId = getIntent().getStringExtra(TaskConstant.ARG_KEY_WARN_ID);
        this.mBinding = (ActivityPersonCarBinding) DataBindingUtil.setContentView(this, R.layout.activity_person_car);
        this.mBinding.setViewModel(new PersonCarViewModel(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mBinding.unbind();
    }

    public int getTaskState() {
        return 9;
    }

    public String check() {
        return CheckUtils.check(this.mBinding.scrollView, null);
    }

    public String getWarnId() {
        return this.warnId;
    }

    public ActivityPersonCarBinding getBinding() {
        return this.mBinding;
    }
}
