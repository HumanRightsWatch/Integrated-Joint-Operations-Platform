package com.fec.xjoneproject.ui.task.miss_phone_trail.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.ui.task.FeedBackBaseActivity;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.task.miss_phone_trail.bean.MissPhoneResponse;
import com.fec.xjoneproject.ui.task.miss_phone_trail.bean.MissPhoneTrailWarnEntity;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.fec.xjoneproject.util.ToastUtil;
import com.hbfec.xjoneinformation.databinding.ActivityMissPhoneTrailWarnBinding;
import com.hbfec.xjoneproject.R;

public class MissPhoneTrailWarnActivity extends FeedBackBaseActivity {
    ActivityMissPhoneTrailWarnBinding mBinding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mBinding = (ActivityMissPhoneTrailWarnBinding) DataBindingUtil.setContentView(this, R.layout.activity_miss_phone_trail_warn);
        this.mBinding.backImageButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MissPhoneTrailWarnActivity.this.finish();
            }
        });
        getDataFromNet(getIntent().getStringExtra(TaskConstant.ARG_KEY_WARN_ID));
    }

    public int getTaskState() {
        return 10;
    }

    private void getDataFromNet(String warnId) {
        try {
            this.mWaitingDialog.show("正在获取……");
            AttendanceService.getApi().getMissPhoneTrailWarnEntity(warnId).enqueue(new OneProjectCallback<MissPhoneResponse>(this) {
                public void onResponse(MissPhoneResponse bean) {
                    MissPhoneTrailWarnActivity.this.mWaitingDialog.dismiss();
                    if (bean.getRes() != null && bean.getRes().size() > 0) {
                        MissPhoneTrailWarnActivity.this.mBinding.setWarn((MissPhoneTrailWarnEntity) bean.getRes().get(0));
                    }
                }

                public void onFailed(String error) {
                    MissPhoneTrailWarnActivity.this.mWaitingDialog.dismiss();
                    ToastUtil.showToast(error);
                }
            });
        } catch (RetrofitUrlNullException e) {
            this.mWaitingDialog.dismiss();
            ToastUtil.showToast(e.getMessage());
            e.printStackTrace();
        }
    }
}
