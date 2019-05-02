package com.fec.xjoneproject.ui.task.electronic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.fec.report.dao.ElecCheckFeedback;
import com.fec.xjoneproject.dao.OneProjectDao;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.http.response.ReportResult;
import com.fec.xjoneproject.privilege.service.GetPrivilegeService;
import com.fec.xjoneproject.ui.WaitingDialogBaseFragment;
import com.fec.xjoneproject.ui.map.util.MapElecResponse;
import com.fec.xjoneproject.ui.report.AreaListActivity;
import com.fec.xjoneproject.ui.report.AreaListFragment;
import com.fec.xjoneproject.ui.supervise.TasksListFragment;
import com.fec.xjoneproject.ui.task.FeedBackBaseFragment;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.task.bean.PowerFeedbackResult;
import com.fec.xjoneproject.ui.task.bean.PowerWarnBean;
import com.fec.xjoneproject.ui.view.RequiredTextView;
import com.fec.xjoneproject.util.CheckUtils;
import com.fec.xjoneproject.util.CheckUtils.DefaultMaterialEditTextCheckCard;
import com.fec.xjoneproject.util.CheckUtils.DefaultMaterialEditTextCheckPhone;
import com.fec.xjoneproject.util.FecUtil;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.fec.xjoneproject.util.ToastUtil;
import com.google.gson.Gson;
import com.hbfec.asmack.im.comm.ConnectionUtils;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneinformation.MainTab;
import com.hbfec.xjoneinformation.Utils.XMPPConfiguration;
import com.hbfec.xjoneproject.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.METValidator;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

public class ElectronicAddFeedFragment extends FeedBackBaseFragment implements OnClickListener {
    public static final int ADD_FAILED = 0;
    public static final String ARG_TASK_USERID = "task_user_id";
    @Bind({2131297982})
    TextView mAddressTv;
    @Bind({2131296888})
    ImageButton mBackView;
    private ElecCheckFeedback mBean;
    @Bind({2131297601})
    TextView mCheckAddressTextView;
    @Bind({2131297602})
    TextView mCheckCardTextView;
    @Bind({2131297603})
    TextView mCheckPhoneTextView;
    @Bind({2131296427})
    CheckBox mDecorationCb;
    @Bind({2131297983})
    TextView mDegree1Tv;
    @Bind({2131297984})
    TextView mDegree2Tv;
    @Bind({2131297985})
    TextView mDegree3Tv;
    @Bind({2131296605})
    MaterialEditText mDetailAddressEt;
    @Bind({2131296428})
    CheckBox mFarmingCb;
    @Bind({2131297132})
    LinearLayout mHaveToolErrorLayout;
    @Bind({2131297131})
    LinearLayout mHaveToolLinearLayout;
    @Bind({2131297469})
    RadioButton mHaveToolRbtn;
    @Bind({2131296607})
    MaterialEditText mIdNumberEt;
    @Bind({2131297986})
    TextView mIdNumberTv;
    @Bind({2131296429})
    CheckBox mInlegalDeviceCb;
    @Bind({2131297987})
    TextView mMeterNumberTv;
    @Bind({2131297148})
    LinearLayout mNeedSurveyErrorLayout;
    @Bind({2131297470})
    RadioButton mNeedSurveyNoRbtn;
    @Bind({2131297471})
    RadioButton mNeedSurveyYesRbtn;
    @Bind({2131296430})
    CheckBox mNewDeviceCb;
    @Bind({2131297989})
    TextView mNormalAverageTv;
    @Bind({2131297472})
    RadioButton mNotHaveToolRbtn;
    @Bind({2131296612})
    MaterialEditText mNoteEt;
    @Bind({2131296431})
    CheckBox mOtherReasonCb;
    private PowerWarnBean mPWBean;
    @Bind({2131297010})
    ImageView mPhotoIv;
    @Bind({2131297520})
    RadioGroup mPolice;
    @Bind({2131297167})
    LinearLayout mPoliceLayout;
    @Bind({2131298205})
    MaterialEditText mPoliceReasonEt;
    @Bind({2131297617})
    RequiredTextView mPoliceReasonMaterialRequiredTextView;
    @Bind({2131296380})
    Button mPostBtn;
    @Bind({2131297169})
    LinearLayout mRealAddressErrorLayout;
    @Bind({2131296606})
    TextView mRealAddressTv;
    @Bind({2131297171})
    LinearLayout mReasonErrorLayout;
    @Bind({2131297170})
    LinearLayout mReasonLinearLayout;
    @Bind({2131296382})
    Button mSaveBtn;
    @Bind({2131297760})
    ScrollView mScrollView;
    private int mState;
    @Bind({2131296432})
    CheckBox mSuspiciousCb;
    @Bind({2131296622})
    MaterialEditText mTelNumberEt;
    @Bind({2131297990})
    TextView mTelNumberTv;
    @Bind({2131297991})
    TextView mTime1Tv;
    @Bind({2131297992})
    TextView mTime2Tv;
    @Bind({2131297993})
    TextView mTime3Tv;
    @Bind({2131298313})
    TextView mTitle;
    private String mUserId;
    @Bind({2131297988})
    TextView mUserNameTv;
    private WaitingDialogBaseFragment mWaitingDialog;
    private String mWarnId;
    private XMPPConfiguration mXmppConfig;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        this.mXmppConfig = new XMPPConfiguration(IMSDroid.getContext());
    }

    private void initData() {
        this.mWarnId = getActivity().getIntent().getStringExtra(TaskConstant.ARG_KEY_WARN_ID);
        this.mState = getActivity().getIntent().getIntExtra(TaskConstant.ARG_KEY_STATE, 9);
        this.mUserId = getActivity().getIntent().getStringExtra("task_user_id");
    }

    private void setCacheData(ElecCheckFeedback mBean, boolean isShowPolice) {
        this.mIdNumberEt.setText(mBean.getIdCard());
        this.mTelNumberEt.setText(mBean.getPhone());
        String address = mBean.getAddr();
        if (!TextUtils.isEmpty(address)) {
            String[] addArray = address.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (int i = 0; i < addArray.length; i++) {
                if (i == 0) {
                    this.mRealAddressTv.setText(addArray[i]);
                } else {
                    this.mDetailAddressEt.setText(addArray[i]);
                }
            }
        }
        if ("1".equals(mBean.getTool())) {
            this.mHaveToolRbtn.setChecked(true);
        } else if ("2".equals(mBean.getTool())) {
            this.mNotHaveToolRbtn.setChecked(true);
        }
        String resonStr = mBean.getResonType();
        if (!TextUtils.isEmpty(resonStr)) {
            for (String str : resonStr.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                showReasons(str);
            }
        }
        this.mNoteEt.setText(mBean.getReson());
        this.mPoliceReasonEt.setText(mBean.getPoliceReason());
        if (!isShowPolice) {
            return;
        }
        if ("1".equals(mBean.getPolicCheck())) {
            this.mPolice.check(R.id.rb_electricityfeedback_needsurvey_yes);
        } else if ("2".equals(mBean.getPolicCheck())) {
            this.mPolice.check(R.id.rb_electricityfeedback_needsurvey_no);
        }
    }

    private void showReasons(String reason) {
        if ("1".equals(reason)) {
            this.mNewDeviceCb.setChecked(true);
        } else if ("2".equals(reason)) {
            this.mDecorationCb.setChecked(true);
        } else if ("3".equals(reason)) {
            this.mFarmingCb.setChecked(true);
        } else if ("4".equals(reason)) {
            this.mOtherReasonCb.setChecked(true);
            if (this.mState == 9) {
                this.mNoteEt.setEnabled(true);
            }
        } else if ("5".equals(reason)) {
            this.mInlegalDeviceCb.setChecked(true);
        } else if ("6".equals(reason)) {
            this.mSuspiciousCb.setChecked(true);
        }
    }

    private void getDataFromNet(String id) {
        try {
            AttendanceService.getApi().getPowerWarn(id).enqueue(new OneProjectCallback<MapElecResponse>(this) {
                public void onResponse(MapElecResponse bean) {
                    if (bean.getRes() != null && bean.getRes().size() != 0) {
                        ElectronicAddFeedFragment.this.mPWBean = (PowerWarnBean) bean.getRes().get(0);
                        ElectronicAddFeedFragment.this.getPowerWarnSuccess();
                    }
                }
            });
        } catch (RetrofitUrlNullException e) {
            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
        }
    }

    private void getFeedBackDataFromNet(String id, String addUser) {
        try {
            AttendanceService.getApi().getPowerTaskFeed(id, addUser).enqueue(new OneProjectCallback<PowerFeedbackResult>(this) {
                public void onResponse(PowerFeedbackResult bean) {
                    ElectronicAddFeedFragment.this.mPWBean = bean.getRes().getWarn();
                    ElectronicAddFeedFragment.this.mBean = bean.getRes().getRes();
                    ElectronicAddFeedFragment.this.getPowerWarnSuccess();
                    if (ElectronicAddFeedFragment.this.mBean != null) {
                        ElectronicAddFeedFragment.this.setCacheData(ElectronicAddFeedFragment.this.mBean, true);
                    }
                }
            });
        } catch (RetrofitUrlNullException e) {
            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
        }
    }

    private void getPowerWarnSuccess() {
        if (this.mPWBean != null) {
            int i;
            this.mIdNumberTv.setText(this.mPWBean.getIdCard());
            this.mTelNumberTv.setText(this.mPWBean.getPhone());
            if (!TextUtils.isEmpty(this.mPWBean.getPic())) {
                Glide.with(IMSDroid.getContext()).load(AttendanceService.getBaseUrl() + this.mPWBean.getPic()).placeholder((int) R.drawable.electricity_detail_photoicon).error((int) R.drawable.electricity_detail_photoicon).into(this.mPhotoIv);
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
            this.mNormalAverageTv.setText(String.valueOf(this.mPWBean.getPowerNumAvg()));
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.electricityfeedback_acy, container, false);
        ButterKnife.bind((Object) this, view);
        this.mWaitingDialog = new WaitingDialogBaseFragment(getActivity());
        this.mWaitingDialog.setCancelable(false);
        this.mBackView.setOnClickListener(this);
        this.mSaveBtn.setOnClickListener(this);
        this.mPostBtn.setOnClickListener(this);
        this.mPhotoIv.setOnClickListener(this);
        this.mTitle.setText("用电异常情况反馈");
        String privilege = new GetPrivilegeService(IMSDroid.getContext()).getString(GetPrivilegeService.PRIVILEGE, null);
        if ("2".equals(privilege)) {
            this.mPoliceLayout.setVisibility(8);
        } else {
            this.mPoliceLayout.setVisibility(0);
        }
        this.mPolice.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.rb_electricityfeedback_needsurvey_yes) {
                    if (ElectronicAddFeedFragment.this.mPoliceLayout.getVisibility() == 8) {
                        ElectronicAddFeedFragment.this.mPoliceReasonMaterialRequiredTextView.setVisibility(0);
                    }
                    ElectronicAddFeedFragment.this.mPoliceReasonEt.setVisibility(0);
                } else if (i == R.id.rb_electricityfeedback_needsurvey_no) {
                    ElectronicAddFeedFragment.this.mPoliceReasonEt.setVisibility(8);
                }
                ElectronicAddFeedFragment.this.mNeedSurveyErrorLayout.setVisibility(8);
            }
        });
        CompoundButton.OnCheckedChangeListener haveToolListener = new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ElectronicAddFeedFragment.this.mHaveToolErrorLayout.setVisibility(8);
                }
            }
        };
        this.mHaveToolRbtn.setOnCheckedChangeListener(haveToolListener);
        this.mNotHaveToolRbtn.setOnCheckedChangeListener(haveToolListener);
        CompoundButton.OnCheckedChangeListener reasonListener = new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ElectronicAddFeedFragment.this.mReasonErrorLayout.setVisibility(8);
                }
            }
        };
        this.mNewDeviceCb.setOnCheckedChangeListener(reasonListener);
        this.mDecorationCb.setOnCheckedChangeListener(reasonListener);
        this.mFarmingCb.setOnCheckedChangeListener(reasonListener);
        this.mInlegalDeviceCb.setOnCheckedChangeListener(reasonListener);
        this.mSuspiciousCb.setOnCheckedChangeListener(reasonListener);
        this.mOtherReasonCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ElectronicAddFeedFragment.this.mReasonErrorLayout.setVisibility(8);
                    if (ElectronicAddFeedFragment.this.mState == 9) {
                        ElectronicAddFeedFragment.this.mNoteEt.setEnabled(true);
                        return;
                    }
                    return;
                }
                ElectronicAddFeedFragment.this.mNoteEt.setText("");
                ElectronicAddFeedFragment.this.mNoteEt.setEnabled(false);
            }
        });
        if (this.mState == 9) {
            this.mIdNumberEt.setValidateOnFocusLost(true);
            this.mIdNumberEt.addValidator(new METValidator(IMSDroid.getContext().getString(R.string.error_wrong_identity)) {
                public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
                    return !isEmpty && CheckUtils.isIdCardNo(String.valueOf(text));
                }
            });
            this.mTelNumberEt.setValidateOnFocusLost(true);
            this.mTelNumberEt.addValidator(new METValidator(IMSDroid.getContext().getString(R.string.error_wrong_phone)) {
                public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
                    return !isEmpty && CheckUtils.isMobileNo(String.valueOf(text));
                }
            });
            this.mRealAddressTv.setOnClickListener(this);
            this.mBean = (ElecCheckFeedback) OneProjectDao.getInstance().getDaoSession().getElecCheckFeedbackDao().load(this.mWarnId);
            getDataFromNet(this.mWarnId);
            if (this.mBean != null) {
                if ("2".equals(privilege)) {
                    setCacheData(this.mBean, false);
                } else {
                    setCacheData(this.mBean, true);
                }
            }
        }
        if (this.mState == 10) {
            this.mSaveBtn.setVisibility(8);
            this.mPostBtn.setVisibility(8);
            this.mIdNumberEt.setEnabled(false);
            this.mTelNumberEt.setEnabled(false);
            this.mRealAddressTv.setEnabled(false);
            this.mDetailAddressEt.setEnabled(false);
            this.mHaveToolRbtn.setEnabled(false);
            this.mNotHaveToolRbtn.setEnabled(false);
            this.mNewDeviceCb.setEnabled(false);
            this.mDecorationCb.setEnabled(false);
            this.mFarmingCb.setEnabled(false);
            this.mInlegalDeviceCb.setEnabled(false);
            this.mSuspiciousCb.setEnabled(false);
            this.mOtherReasonCb.setEnabled(false);
            this.mNoteEt.setEnabled(false);
            this.mNeedSurveyNoRbtn.setEnabled(false);
            this.mNeedSurveyYesRbtn.setEnabled(false);
            this.mPoliceReasonEt.setEnabled(false);
            getFeedBackDataFromNet(this.mWarnId, this.mUserId);
        }
        return view;
    }

    private void reportSuccessAction() {
        if (getActivity() != null) {
            this.mWaitingDialog.dismiss();
            OneProjectDao.getInstance().getDaoSession().getElecCheckFeedbackDao().deleteByKey(this.mWarnId);
            ToastUtil.showToast("反馈成功");
            Intent intent = new Intent(getActivity(), MainTab.class);
            intent.setFlags(67108864);
            intent.putExtra(TasksListFragment.TASK_TYPE, 4);
            startActivity(intent);
        }
    }

    private void reportFailAction(String toastStr) {
        this.mWaitingDialog.dismiss();
        ToastUtil.showToast(toastStr);
        getActivity().setResult(0);
        getActivity().finish();
    }

    public void postAction() {
        String result = null;
        if (!CheckUtils.isMaterialEditTextInputRight(this.mIdNumberEt, DefaultMaterialEditTextCheckCard.newInstance(true))) {
            this.mIdNumberEt.requestFocus();
            this.mScrollView.scrollTo(0, this.mCheckCardTextView.getTop());
            result = this.mIdNumberEt.getError().toString();
        }
        if (!CheckUtils.isMaterialEditTextInputRight(this.mTelNumberEt, DefaultMaterialEditTextCheckPhone.newInstance(true)) && TextUtils.isEmpty(result)) {
            this.mTelNumberEt.requestFocus();
            this.mScrollView.scrollTo(0, this.mCheckPhoneTextView.getTop());
            result = this.mTelNumberEt.getError().toString();
        }
        if (TextUtils.isEmpty(this.mRealAddressTv.getText().toString())) {
            this.mRealAddressErrorLayout.setVisibility(0);
            if (TextUtils.isEmpty(result)) {
                this.mRealAddressTv.requestFocus();
                this.mScrollView.scrollTo(0, this.mCheckAddressTextView.getTop());
                result = "请选择实际电表地址";
            }
        }
        if (!CheckUtils.isMaterialEditTextInputRight(this.mDetailAddressEt, true) && TextUtils.isEmpty(result)) {
            this.mDetailAddressEt.requestFocus();
            this.mScrollView.scrollTo(0, this.mCheckAddressTextView.getTop());
            result = this.mDetailAddressEt.getError().toString();
        }
        if (!(this.mHaveToolRbtn.isChecked() || this.mNotHaveToolRbtn.isChecked())) {
            this.mHaveToolErrorLayout.setVisibility(0);
            if (TextUtils.isEmpty(result)) {
                this.mHaveToolLinearLayout.requestFocus();
                this.mScrollView.scrollTo(0, this.mHaveToolLinearLayout.getTop());
                result = "请选择是否有制爆工具或原料";
            }
        }
        if (!(this.mNewDeviceCb.isChecked() || this.mDecorationCb.isChecked() || this.mFarmingCb.isChecked() || this.mInlegalDeviceCb.isChecked() || this.mSuspiciousCb.isChecked() || this.mOtherReasonCb.isChecked())) {
            this.mReasonErrorLayout.setVisibility(0);
            if (TextUtils.isEmpty(result)) {
                this.mReasonLinearLayout.requestFocus();
                this.mScrollView.scrollTo(0, this.mReasonLinearLayout.getTop());
                result = "请选择异常原因";
            }
        }
        if (this.mOtherReasonCb.isChecked() && !CheckUtils.isMaterialEditTextInputRight(this.mNoteEt, true) && TextUtils.isEmpty(result)) {
            this.mNoteEt.requestFocus();
            this.mScrollView.scrollTo(0, this.mReasonLinearLayout.getTop());
            result = this.mNoteEt.getError().toString();
        }
        if (!(this.mPoliceLayout.getVisibility() != 0 || this.mNeedSurveyYesRbtn.isChecked() || this.mNeedSurveyNoRbtn.isChecked())) {
            this.mNeedSurveyErrorLayout.setVisibility(0);
            if (TextUtils.isEmpty(result)) {
                this.mPoliceLayout.requestFocus();
                this.mScrollView.scrollTo(0, this.mPoliceLayout.getTop());
                result = "请选择是否需要公安机关任务调查";
            }
        }
        if (!CheckUtils.isMaterialEditTextInputRight(this.mPoliceReasonEt, true) && TextUtils.isEmpty(result)) {
            this.mPoliceReasonEt.requestFocus();
            this.mScrollView.scrollTo(0, this.mPoliceLayout.getTop());
            result = this.mPoliceReasonEt.getError().toString();
        }
        if (TextUtils.isEmpty(result)) {
            if (this.mBean == null) {
                this.mBean = new ElecCheckFeedback();
            }
            this.mBean.setFkPw(this.mWarnId);
            this.mBean.setIdCard(this.mIdNumberEt.getText().toString());
            this.mBean.setPhone(this.mTelNumberEt.getText().toString());
            this.mBean.setAddr(this.mRealAddressTv.getText().toString() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mDetailAddressEt.getText().toString());
            if (this.mHaveToolRbtn.isChecked()) {
                this.mBean.setTool("1");
            } else if (this.mNotHaveToolRbtn.isChecked()) {
                this.mBean.setTool("2");
            }
            resonsMake();
            if (this.mPoliceLayout.getVisibility() != 0) {
                this.mBean.setPolicCheck("0");
            } else if (this.mNeedSurveyYesRbtn.isChecked()) {
                this.mBean.setPolicCheck("1");
                this.mBean.setPoliceReason(this.mPoliceReasonEt.getText().toString());
            } else if (this.mNeedSurveyNoRbtn.isChecked()) {
                this.mBean.setPolicCheck("2");
            }
            this.mBean.setAddUser(ConnectionUtils.getLoginName());
            this.mBean.setUserOrganizationId(this.mXmppConfig.getString(com.hbfec.xjoneinformation.Utils.Constants.UUM_USER_ORGANIZATION_ID, ""));
            if (!(getLatitude() == null || getLongitude() == null)) {
                try {
                    if (this.mBean.getLatitude() == null && this.mBean.getLongitude() == null) {
                        this.mBean.setLatitude(getLatitude());
                        this.mBean.setLongitude(getLongitude());
                        this.mBean.setLocationDescription(getLocationDescription());
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            String testStr = new Gson().toJson(this.mBean);
            Map<String, String> map = new HashMap();
            map.put("warnRes", testStr);
            this.mWaitingDialog.show();
            try {
                AttendanceService.getApi().powerResponse(map).enqueue(new OneProjectCallback<ReportResult>(this) {
                    public void onResponse(ReportResult bean) {
                        ElectronicAddFeedFragment.this.reportSuccessAction();
                    }

                    public void onFailed(String errorMessage) {
                        ElectronicAddFeedFragment.this.reportFailAction(ElectronicAddFeedFragment.this.getString(R.string.upload_failed, errorMessage));
                        ElectronicAddFeedFragment.this.saveAction();
                    }
                });
                return;
            } catch (RetrofitUrlNullException e2) {
                FecUtil.showUrlIsNullToast(IMSDroid.getContext());
                this.mWaitingDialog.dismiss();
                return;
            }
        }
        ToastUtil.showToast(result);
    }

    private void resonsMake() {
        String str = "";
        if (this.mNewDeviceCb.isChecked()) {
            str = "1";
        }
        if (this.mDecorationCb.isChecked()) {
            str = safeAddString(str, "2");
        }
        if (this.mFarmingCb.isChecked()) {
            str = safeAddString(str, "3");
        }
        if (this.mOtherReasonCb.isChecked()) {
            str = safeAddString(str, "4");
            this.mBean.setReson(this.mNoteEt.getText().toString());
        }
        if (this.mInlegalDeviceCb.isChecked()) {
            str = safeAddString(str, "5");
        }
        if (this.mSuspiciousCb.isChecked()) {
            str = safeAddString(str, "6");
        }
        this.mBean.setResonType(str);
    }

    private String safeAddString(String src, String addStr) {
        if (src.length() > 0) {
            return src + Constants.ACCEPT_TIME_SEPARATOR_SP + addStr;
        }
        return addStr;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_post:
                postAction();
                return;
            case R.id.btn_save:
                saveAction();
                return;
            case R.id.et_check_electronic_realaddress:
                showAreaList();
                return;
            case R.id.ibtn_back:
                getActivity().finish();
                return;
            case R.id.iv_electricitydetai_photo:
                if (this.mPWBean == null || TextUtils.isEmpty(this.mPWBean.getPic())) {
                    ToastUtil.showToast("当前无图片");
                    return;
                } else {
                    FecUtil.startImageActivity(getActivity(), this.mPWBean.getPic());
                    return;
                }
            default:
                return;
        }
    }

    private void saveAction() {
        getFeedBackInfo();
        try {
            OneProjectDao.getInstance().getDaoSession().getElecCheckFeedbackDao().insertOrReplace(this.mBean);
            getActivity().finish();
        } catch (Exception e) {
            ToastUtil.showToast((int) R.string.save_fail);
        }
    }

    private void getFeedBackInfo() {
        if (this.mBean == null) {
            this.mBean = new ElecCheckFeedback();
            this.mBean.setId(this.mWarnId);
        } else if (TextUtils.isEmpty(this.mBean.getId())) {
            this.mBean.setId(this.mWarnId);
        }
        this.mBean.setFkPw(this.mWarnId);
        this.mBean.setIdCard(this.mIdNumberEt.getText().toString());
        this.mBean.setPhone(this.mTelNumberEt.getText().toString());
        this.mBean.setAddr(this.mRealAddressTv.getText().toString() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mDetailAddressEt.getText().toString());
        if (this.mHaveToolRbtn.isChecked()) {
            this.mBean.setTool("1");
        } else if (this.mNotHaveToolRbtn.isChecked()) {
            this.mBean.setTool("2");
        }
        resonsMake();
        if (this.mNeedSurveyYesRbtn.isChecked()) {
            this.mBean.setPolicCheck("1");
            this.mBean.setPoliceReason(this.mPoliceReasonEt.getText().toString());
        } else if (this.mNeedSurveyNoRbtn.isChecked()) {
            this.mBean.setPolicCheck("2");
            this.mBean.setPoliceReason("");
        }
        this.mBean.setAddUser(ConnectionUtils.getLoginName());
        this.mBean.setUserOrganizationId(this.mXmppConfig.getString(com.hbfec.xjoneinformation.Utils.Constants.UUM_USER_ORGANIZATION_ID, ""));
        if (getLatitude() != null && getLongitude() != null) {
            this.mBean.setLatitude(getLatitude());
            this.mBean.setLongitude(getLongitude());
            this.mBean.setLocationDescription(getLocationDescription());
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void showAreaList() {
        Intent intent = new Intent(getActivity(), AreaListActivity.class);
        intent.putExtra("pid", "65");
        intent.putExtra("prename", "");
        intent.putExtra("deep", 0);
        AreaListFragment.requesttype = 4;
        startActivity(intent);
    }

    public void onNewIntent(Intent intent) {
        if ((67108864 & intent.getFlags()) != 0) {
            String mAreaName = intent.getStringExtra("areaname");
            if (mAreaName != null) {
                this.mRealAddressTv.setText(mAreaName);
                this.mRealAddressErrorLayout.setVisibility(8);
            }
        }
    }

    public int getTaskState() {
        return this.mState;
    }
}
