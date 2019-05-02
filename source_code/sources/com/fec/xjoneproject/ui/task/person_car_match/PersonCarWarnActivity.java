package com.fec.xjoneproject.ui.task.person_car_match;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.ui.task.FeedBackBaseActivity;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.task.person_car_match.bean.PersonCarResponse;
import com.fec.xjoneproject.ui.task.person_car_match.bean.PersonnelCarMismatchEntity;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.hbfec.xjoneinformation.databinding.ActivityPersonCarWarnBinding;
import com.hbfec.xjoneproject.R;

public class PersonCarWarnActivity extends FeedBackBaseActivity {
    private ActivityPersonCarWarnBinding mBinding;
    private String warnId;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mBinding = (ActivityPersonCarWarnBinding) DataBindingUtil.setContentView(this, R.layout.activity_person_car_warn);
        this.mBinding.setActivity(this);
        this.warnId = getIntent().getStringExtra(TaskConstant.ARG_KEY_WARN_ID);
        try {
            getWarnEntityByNet();
        } catch (RetrofitUrlNullException e) {
            this.mWaitingDialog.dismiss();
        }
    }

    public int getTaskState() {
        return 10;
    }

    public void getWarnEntityByNet() throws RetrofitUrlNullException {
        this.mWaitingDialog.show("正在加载……");
        AttendanceService.getApi().getPersonCarWarnEntity(this.warnId).enqueue(new OneProjectCallback<PersonCarResponse>(this) {
            public void onResponse(PersonCarResponse bean) {
                PersonCarWarnActivity.this.mWaitingDialog.dismiss();
                if (bean.getRes().size() > 0) {
                    PersonCarWarnActivity.this.mBinding.setWarn((PersonnelCarMismatchEntity) bean.getRes().get(0));
                }
            }

            public void onFailed(String errorMessage) {
                super.onFailed(errorMessage);
                PersonCarWarnActivity.this.mWaitingDialog.dismiss();
            }
        });
    }
}
