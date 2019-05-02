package com.fec.xjoneproject.ui.task.electronic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.ui.WaitingDialogBaseFragment;
import com.fec.xjoneproject.ui.map.util.MapElecResponse;
import com.fec.xjoneproject.ui.task.bean.PowerWarnBean;
import com.fec.xjoneproject.util.FecUtil;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.fec.xjoneproject.util.ToastUtil;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneproject.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

public class PowerWarnDetailFragment extends Fragment implements OnClickListener {
    public static final String CHECK_ELECTRON_MISSION_ID = "check_electron_misson_id";
    public static final String CHECK_ELECTRON_WARN_ID = "check_electron_warn_id";
    public static final String UPLOAD_TMP_DIR = "Acrophone/tmp/population";
    @Bind({2131297980})
    TextView mAddTimeTv;
    @Bind({2131297981})
    TextView mAddUserTv;
    @Bind({2131297982})
    TextView mAddressTv;
    @Bind({2131296888})
    ImageButton mBackView;
    @Bind({2131297983})
    TextView mDegree1Tv;
    @Bind({2131297984})
    TextView mDegree2Tv;
    @Bind({2131297985})
    TextView mDegree3Tv;
    @Bind({2131297986})
    TextView mIdNumberTv;
    @Bind({2131297995})
    TextView mIsCheckTv;
    private int mIsHave = 0;
    @Bind({2131297987})
    TextView mMeterNumberTv;
    @Bind({2131297989})
    TextView mNormalAverageTv;
    private PowerWarnBean mPWBean;
    @Bind({2131297010})
    ImageView mPhotoIv;
    @Bind({2131298004})
    TextView mProblemDescTv;
    @Bind({2131297990})
    TextView mTelNumberTv;
    @Bind({2131297991})
    TextView mTime1Tv;
    @Bind({2131297992})
    TextView mTime2Tv;
    @Bind({2131297993})
    TextView mTime3Tv;
    @Bind({2131298005})
    TextView mTimeAnalyseTv;
    @Bind({2131298006})
    TextView mTimeStartTv;
    private int mType = 1;
    private List<String> mUploadImgs = new ArrayList();
    @Bind({2131297988})
    TextView mUserNameTv;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        String mTaskID = getActivity().getIntent().getStringExtra(CHECK_ELECTRON_MISSION_ID);
        getDataFromNet(getActivity().getIntent().getStringExtra(CHECK_ELECTRON_WARN_ID));
    }

    private void getDataFromNet(String id) {
        try {
            AttendanceService.getApi().getPowerWarn(id).enqueue(new OneProjectCallback<MapElecResponse>(this) {
                public void onResponse(MapElecResponse bean) {
                    if (bean.getRes() != null && bean.getRes().size() != 0) {
                        PowerWarnDetailFragment.this.mPWBean = (PowerWarnBean) bean.getRes().get(0);
                        PowerWarnDetailFragment.this.getPowerWarnSuccess();
                    }
                }
            });
        } catch (RetrofitUrlNullException e) {
            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
        }
    }

    private void getPowerWarnSuccess() {
        int i;
        this.mIdNumberTv.setText(this.mPWBean.getIdCard());
        this.mTelNumberTv.setText(this.mPWBean.getPhone());
        if (!TextUtils.isEmpty(this.mPWBean.getPic())) {
            Glide.with(getContext()).load(AttendanceService.getBaseUrl() + this.mPWBean.getPic()).placeholder((int) R.drawable.electricity_detail_photoicon).error((int) R.drawable.electricity_detail_photoicon).into(this.mPhotoIv);
        }
        this.mUserNameTv.setText(this.mPWBean.getUserName());
        this.mMeterNumberTv.setText(this.mPWBean.getUserNo());
        this.mAddressTv.setText(this.mPWBean.getAddr());
        String maxPowerNum = this.mPWBean.getMaxPowerNum();
        String maxPowerDate = this.mPWBean.getMaxPowerDate();
        if (!TextUtils.isEmpty(maxPowerNum)) {
            String[] sourceNumArray = maxPowerNum.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (i = 0; i < sourceNumArray.length; i++) {
                if (i == 0) {
                    this.mDegree1Tv.setText(sourceNumArray[i]);
                } else if (1 == i) {
                    this.mDegree2Tv.setText(sourceNumArray[i]);
                } else if (2 == i) {
                    this.mDegree3Tv.setText(sourceNumArray[i]);
                }
            }
        }
        if (!TextUtils.isEmpty(maxPowerDate)) {
            String[] sourceDateArray = maxPowerDate.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (i = 0; i < sourceDateArray.length; i++) {
                if (i == 0) {
                    this.mTime1Tv.setText(sourceDateArray[i]);
                } else if (1 == i) {
                    this.mTime2Tv.setText(sourceDateArray[i]);
                } else if (2 == i) {
                    this.mTime3Tv.setText(sourceDateArray[i]);
                }
            }
        }
        this.mNormalAverageTv.setText(Double.toString(this.mPWBean.getPowerNumAvg().doubleValue()));
        this.mProblemDescTv.setText(this.mPWBean.getDescription());
        this.mTimeStartTv.setText(this.mPWBean.getBeginTime());
        this.mTimeAnalyseTv.setText(this.mPWBean.getAnalyseTime());
        this.mAddUserTv.setText(this.mPWBean.getAddUser());
        this.mAddTimeTv.setText(this.mPWBean.getAddTime());
        int checkstate = this.mPWBean.getIsChecked().intValue();
        if (checkstate == 0) {
            this.mIsCheckTv.setText("未核查／已流转");
        } else if (1 == checkstate) {
            this.mIsCheckTv.setText("已核查");
        } else if (2 == checkstate) {
            this.mIsCheckTv.setText("核查中");
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.electronic_warn_detail, container, false);
        ButterKnife.bind((Object) this, view);
        new WaitingDialogBaseFragment(getActivity()).setCancelable(false);
        this.mBackView.setOnClickListener(this);
        this.mPhotoIv.setOnClickListener(this);
        return view;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibtn_back:
                getActivity().finish();
                return;
            case R.id.iv_electricitydetai_photo:
                if (this.mPWBean == null || TextUtils.isEmpty(this.mPWBean.getPic())) {
                    ToastUtil.showToast("当前无照片");
                    return;
                } else {
                    FecUtil.startImageActivity(getActivity(), this.mPWBean.getPic());
                    return;
                }
            default:
                return;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
