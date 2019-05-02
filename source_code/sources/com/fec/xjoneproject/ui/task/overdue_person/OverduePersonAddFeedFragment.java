package com.fec.xjoneproject.ui.task.overdue_person;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.fec.report.dao.OverduePersonContact;
import com.fec.report.dao.OverduePersonInfo;
import com.fec.report.dao.OverduePersonInfoDao.Properties;
import com.fec.report.dao.OverduePersonVisitor;
import com.fec.xjoneproject.dao.OneProjectDao;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.http.response.ReportResult;
import com.fec.xjoneproject.privilege.service.GetPrivilegeService;
import com.fec.xjoneproject.ui.WaitingDialogBaseFragment;
import com.fec.xjoneproject.ui.supervise.TasksListFragment;
import com.fec.xjoneproject.ui.task.FeedBackBaseFragment;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.task.bean.OverduePersonBean;
import com.fec.xjoneproject.ui.task.bean.OverduePersonResponse;
import com.fec.xjoneproject.ui.task.overdue_person.ExitRelationListFragment.PeerItem;
import com.fec.xjoneproject.ui.view.PhoneListView;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.fec.xjoneproject.ui.view.SelectPhotoView.CompressUploadFile;
import com.fec.xjoneproject.ui.view.SelectPhotoView.PhotoCompress;
import com.fec.xjoneproject.util.CheckUtils;
import com.fec.xjoneproject.util.CheckUtils.DefaultMaterialEditTextCheckCard;
import com.fec.xjoneproject.util.FecUtil;
import com.fec.xjoneproject.util.ISavePhoto;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.fec.xjoneproject.util.ToastUtil;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneinformation.MainTab;
import com.hbfec.xjoneinformation.Utils.Constants;
import com.hbfec.xjoneinformation.Utils.XMPPConfiguration;
import com.hbfec.xjoneproject.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.METValidator;
import fr.ganfra.materialspinner.MaterialSpinner;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.greenrobot.greendao.query.WhereCondition;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OverduePersonAddFeedFragment extends FeedBackBaseFragment {
    public static final int RELATION_FLAG = 1111;
    private static final String TAG = "OverduePersonAddFeed";
    @Bind({2131296650})
    MaterialEditText mAddHouseMaterialEditText;
    @Bind({2131298069})
    TextView mAddHouseholdTextView;
    @Bind({2131296654})
    MaterialEditText mAddIdentityMaterialEditText;
    @Bind({2131298079})
    TextView mAddIdentityTextView;
    @Bind({2131296662})
    MaterialEditText mAddNameMaterialEditText;
    @Bind({2131298121})
    TextView mAddNameTextView;
    @Bind({2131296302})
    PhoneListView mAddPhonePhoneListView;
    @Bind({2131298173})
    TextView mAddPhoneTextView;
    @Bind({2131297096})
    LinearLayout mAddVisitorLayout;
    @Bind({2131296888})
    ImageButton mBackButton;
    @Bind({2131297108})
    LinearLayout mCheckPhoneLayout;
    @Bind({2131296644})
    MaterialEditText mCountryDestinationMaterialEditText;
    @Bind({2131296645})
    MaterialEditText mCountryEntryMaterialEditText;
    @Bind({2131298034})
    TextView mCountryEntryTextView;
    private OverduePersonBean mEntity;
    @Bind({2131297522})
    RadioGroup mExitEventRg;
    @Bind({2131297122})
    LinearLayout mExitOtherCountryLinearLayout;
    @Bind({2131296646})
    MaterialEditText mExitReasonMaterialEditText;
    @Bind({2131297620})
    MaterialSpinner mExitReasonSpinner;
    @Bind({2131298055})
    TextView mExitReasonTextView;
    @Bind({2131298054})
    TextView mExitRelationCountTv;
    @Bind({2131297123})
    LinearLayout mExitRelationErrorLinearLayout;
    @Bind({2131297547})
    RelativeLayout mExitRelationLayout;
    @Bind({2131297521})
    RadioGroup mExitRg;
    @Bind({2131297124})
    LinearLayout mExitSuspiciousEventsLinearLayout;
    @Bind({2131297125})
    LinearLayout mFamilyAndSocietyLayout;
    @Bind({2131297621})
    Spinner mFamilySpinner;
    @Bind({2131297492})
    RadioButton mFemaleRb;
    @Bind({2131297531})
    RadioGroup mGender;
    private MyHandler mHandler;
    @Bind({2131297996})
    TextView mHouseHoldText;
    @Bind({2131296721})
    TextView mIdentityText;
    @Bind({2131297206})
    LinearLayout mIsSuspiciousInfoLinearLayout;
    @Bind({2131297524})
    RadioGroup mIsSuspiciousRg;
    private OverduePersonVisitor mLocalAddVisitor;
    private List<PeerItem> mLocalRelationList = new ArrayList();
    private OverduePersonInfo mLocalRespondent;
    @Bind({2131297493})
    RadioButton mManRb;
    @Bind({2131296722})
    TextView mNameText;
    @Bind({2131297156})
    LinearLayout mOtherFamilyLinearLayout;
    @Bind({2131296669})
    MaterialEditText mOtherFamilyMaterialEditText;
    @Bind({2131298175})
    TextView mPhoneRelationTextView;
    @Bind({2131296725})
    TextView mPhoneText;
    @Bind({2131297029})
    ImageView mPicture;
    @Bind({2131297170})
    LinearLayout mReasonLinearLayout;
    @Bind({2131296734})
    MaterialEditText mReasonMaterialEditText;
    @Bind({2131297172})
    LinearLayout mRecentEventsInfoLinearLayout;
    @Bind({2131296735})
    MaterialEditText mRecentEventsInfoMaterialEditText;
    private List<OverduePersonContact> mRelationList = new ArrayList();
    @Bind({2131297623})
    MaterialSpinner mRelationMaterialSpinner;
    @Bind({2131296848})
    SelectPhotoView mReportPicIv;
    @Bind({2131297760})
    ScrollView mScrollView;
    private ArrayList<String> mSelectedImages = new ArrayList();
    @Bind({2131296753})
    MaterialEditText mSuspiciousEventsMaterialEditText;
    @Bind({2131297164})
    LinearLayout mSuspiciousInfoLayout;
    @Bind({2131296754})
    MaterialEditText mSuspiciousInfoMaterialEditText;
    @Bind({2131297624})
    MaterialSpinner mSuspiciousInfoMaterialSpinner;
    @Bind({2131297529})
    RadioGroup mSuspiciousRg;
    @Bind({2131298313})
    TextView mTitle;
    private WaitingDialogBaseFragment mWaitingDialog;
    private String mWarnId;
    private XMPPConfiguration mXmppConfig;

    private static class MyHandler extends Handler {
        private ISavePhoto listener;
        private WeakReference<OverduePersonAddFeedFragment> reference;

        public MyHandler(OverduePersonAddFeedFragment context) {
            this.reference = new WeakReference(context);
        }

        public void handleMessage(Message msg) {
            OverduePersonAddFeedFragment context = (OverduePersonAddFeedFragment) this.reference.get();
            if (context != null) {
                context.handleMessage(msg);
            }
        }

        public ISavePhoto getListener() {
            return this.listener;
        }

        public void setListener(ISavePhoto listener) {
            this.listener = listener;
        }
    }

    public static OverduePersonAddFeedFragment newInstance(String id) {
        OverduePersonAddFeedFragment fragment = new OverduePersonAddFeedFragment();
        Bundle args = new Bundle();
        args.putString(TaskConstant.ARG_KEY_WARN_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    public int getTaskState() {
        return 9;
    }

    private void handleMessage(Message msg) {
        switch (msg.what) {
            case 1000:
                if (this.mEntity != null) {
                    setNetData();
                    loadLocalSave();
                    setLocalData();
                }
                this.mWaitingDialog.dismiss();
                return;
            default:
                this.mWaitingDialog.dismiss();
                return;
        }
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mWaitingDialog = new WaitingDialogBaseFragment(getActivity());
        this.mHandler = new MyHandler(this);
        initData();
        this.mXmppConfig = new XMPPConfiguration(IMSDroid.getContext());
    }

    private void initData() {
        this.mWarnId = getActivity().getIntent().getStringExtra(TaskConstant.ARG_KEY_WARN_ID);
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_overdue_person, container, false);
        ButterKnife.bind((Object) this, view);
        this.mTitle.setText(R.string.respondent_info);
        this.mReportPicIv.setFragmentReference(this);
        this.mReportPicIv.setSinglePhoto(true);
        this.mAddIdentityMaterialEditText.setValidateOnFocusLost(true);
        this.mAddIdentityMaterialEditText.addValidator(new METValidator(IMSDroid.getContext().getString(R.string.error_wrong_identity)) {
            public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
                return CheckUtils.isIdCardNo(String.valueOf(text));
            }
        });
        this.mRelationMaterialSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                OverduePersonAddFeedFragment.this.mReasonLinearLayout.setVisibility(8);
                OverduePersonAddFeedFragment.this.mFamilyAndSocietyLayout.setVisibility(8);
                OverduePersonAddFeedFragment.this.mOtherFamilyLinearLayout.setVisibility(8);
                OverduePersonAddFeedFragment.this.mCheckPhoneLayout.setVisibility(8);
                OverduePersonAddFeedFragment.this.mSuspiciousInfoLayout.setVisibility(8);
                if (1 == position) {
                    OverduePersonAddFeedFragment.this.mCheckPhoneLayout.setVisibility(0);
                    if (OverduePersonAddFeedFragment.this.mSuspiciousRg.getCheckedRadioButtonId() == R.id.rb_suspicious_yes) {
                        OverduePersonAddFeedFragment.this.mSuspiciousInfoLayout.setVisibility(0);
                    }
                }
                if (3 == position) {
                    OverduePersonAddFeedFragment.this.mOtherFamilyLinearLayout.setVisibility(0);
                }
                if (2 == position) {
                    OverduePersonAddFeedFragment.this.mFamilyAndSocietyLayout.setVisibility(0);
                }
                if (4 == position) {
                    OverduePersonAddFeedFragment.this.mReasonLinearLayout.setVisibility(0);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), 17367048, getResources().getStringArray(R.array.relation_for_family));
        adapter.setDropDownViewResource(17367049);
        this.mFamilySpinner.setAdapter(adapter);
        this.mFamilySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                OverduePersonAddFeedFragment.this.mOtherFamilyLinearLayout.setVisibility(8);
                if (9 == position) {
                    OverduePersonAddFeedFragment.this.mOtherFamilyLinearLayout.setVisibility(0);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.mSuspiciousRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.rb_suspicious_yes) {
                    OverduePersonAddFeedFragment.this.mSuspiciousInfoLayout.setVisibility(0);
                } else if (i == R.id.rb_suspicious_no) {
                    OverduePersonAddFeedFragment.this.mSuspiciousInfoLayout.setVisibility(8);
                }
            }
        });
        this.mExitRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.rb_exit_yes) {
                    OverduePersonAddFeedFragment.this.mExitOtherCountryLinearLayout.setVisibility(0);
                    OverduePersonAddFeedFragment.this.mRecentEventsInfoLinearLayout.setVisibility(8);
                } else if (i == R.id.rb_exit_no) {
                    OverduePersonAddFeedFragment.this.mExitOtherCountryLinearLayout.setVisibility(8);
                    OverduePersonAddFeedFragment.this.mRecentEventsInfoLinearLayout.setVisibility(0);
                }
            }
        });
        this.mExitReasonSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                OverduePersonAddFeedFragment.this.mExitReasonMaterialEditText.setVisibility(8);
                if (4 == position) {
                    OverduePersonAddFeedFragment.this.mExitReasonMaterialEditText.setVisibility(0);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.mExitEventRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.rb_exit_suspicious_yes) {
                    OverduePersonAddFeedFragment.this.mExitSuspiciousEventsLinearLayout.setVisibility(0);
                } else if (i == R.id.rb_exit_suspicious_no) {
                    OverduePersonAddFeedFragment.this.mExitSuspiciousEventsLinearLayout.setVisibility(8);
                }
            }
        });
        this.mExitRelationLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(OverduePersonAddFeedFragment.this.getActivity(), ExitRelationListActivity.class);
                intent.putExtra("item_list", (ArrayList) OverduePersonAddFeedFragment.this.mLocalRelationList);
                OverduePersonAddFeedFragment.this.startActivityForResult(intent, 1111);
            }
        });
        this.mIsSuspiciousRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i == R.id.rb_issuspicious_yes) {
                    OverduePersonAddFeedFragment.this.mIsSuspiciousInfoLinearLayout.setVisibility(0);
                } else if (i == R.id.rb_issuspicious_no) {
                    OverduePersonAddFeedFragment.this.mIsSuspiciousInfoLinearLayout.setVisibility(8);
                }
            }
        });
        getDataFromNet(this.mWarnId);
        return view;
    }

    private void getDataFromNet(String id) {
        try {
            this.mWaitingDialog.show();
            AttendanceService.getApi().getOverduePersonWarn(id).enqueue(new OneProjectCallback<OverduePersonResponse>(this) {
                public void onResponse(OverduePersonResponse bean) {
                    List<OverduePersonBean> list = bean.getRes();
                    if (!(list == null || list.size() == 0)) {
                        OverduePersonAddFeedFragment.this.mEntity = (OverduePersonBean) list.get(0);
                    }
                    Message msg = new Message();
                    msg.what = 1000;
                    OverduePersonAddFeedFragment.this.mHandler.sendMessage(msg);
                }
            });
        } catch (RetrofitUrlNullException e) {
            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
            this.mHandler.sendEmptyMessage(0);
        }
    }

    private void setNetData() {
        this.mNameText.setText(this.mEntity.getName());
        this.mIdentityText.setText(this.mEntity.getIdCard());
        this.mPhoneText.setText(this.mEntity.getPhone());
        this.mHouseHoldText.setText(this.mEntity.getCensusRegisterDetial());
        if (!TextUtils.isEmpty(this.mEntity.getSpotPhoto())) {
            Glide.with(IMSDroid.getContext()).load(this.mEntity.getSpotPhoto()).error((int) R.drawable.default_error).into(this.mPicture);
        }
    }

    public void loadLocalSave() {
        this.mLocalRespondent = (OverduePersonInfo) OneProjectDao.getInstance().getDaoSession().getOverduePersonInfoDao().queryBuilder().where(Properties.Task_id.like(this.mWarnId), new WhereCondition[0]).build().unique();
        if (this.mLocalRespondent != null) {
            List<OverduePersonVisitor> visitorList = this.mLocalRespondent.getOverduePersonVisitorList();
            if (visitorList != null && visitorList.size() > 0) {
                this.mLocalAddVisitor = (OverduePersonVisitor) visitorList.get(0);
            }
            this.mRelationList = this.mLocalRespondent.getOverduePersonContactList();
        }
    }

    private void setLocalData() {
        if (this.mLocalRespondent != null) {
            if (this.mLocalAddVisitor != null) {
                if (!TextUtils.isEmpty(this.mLocalAddVisitor.getPhoto())) {
                    this.mSelectedImages = FecUtil.getStringItems(this.mLocalAddVisitor.getPhoto());
                    this.mReportPicIv.setSelectedPhotoList(this.mSelectedImages);
                }
                this.mAddNameMaterialEditText.setText(this.mLocalAddVisitor.getName());
                this.mAddHouseMaterialEditText.setText(this.mLocalAddVisitor.getAddress());
                this.mAddPhonePhoneListView.setText(this.mLocalAddVisitor.getPhone());
                if (this.mLocalAddVisitor.getSex() != null) {
                    if (this.mLocalAddVisitor.getSex().intValue() == 1) {
                        this.mManRb.setChecked(true);
                    } else if (this.mLocalAddVisitor.getSex().intValue() == 0) {
                        this.mFemaleRb.setChecked(true);
                    }
                }
                this.mAddIdentityMaterialEditText.setText(this.mLocalAddVisitor.getIdCard());
                this.mRelationMaterialSpinner.setSelection(this.mLocalAddVisitor.getRelation().intValue(), false);
                if (2 == this.mLocalAddVisitor.getRelation().intValue()) {
                    this.mFamilySpinner.setSelection(this.mLocalAddVisitor.getKinship().intValue(), false);
                    if (9 == this.mLocalAddVisitor.getKinship().intValue()) {
                        this.mOtherFamilyMaterialEditText.setText(this.mLocalAddVisitor.getOtherRelation());
                    }
                } else if (3 == this.mLocalAddVisitor.getRelation().intValue()) {
                    this.mOtherFamilyMaterialEditText.setText(this.mLocalAddVisitor.getOtherRelation());
                } else if (4 == this.mLocalAddVisitor.getRelation().intValue()) {
                    this.mReasonMaterialEditText.setText(this.mLocalAddVisitor.getReson());
                } else if (1 == this.mLocalAddVisitor.getRelation().intValue()) {
                    if (this.mLocalRespondent.getSuspiciousInfo().intValue() != 0) {
                        this.mSuspiciousRg.check(R.id.rb_suspicious_yes);
                        this.mSuspiciousInfoMaterialSpinner.setSelection(this.mLocalRespondent.getSuspiciousInfo().intValue(), false);
                    } else {
                        this.mSuspiciousRg.check(R.id.rb_suspicious_no);
                    }
                }
            }
            this.mLocalRelationList = new ArrayList();
            for (OverduePersonContact contact : this.mRelationList) {
                PeerItem item = new PeerItem();
                item.setNote(contact.getNote());
                item.setName(contact.getName());
                item.setPhone(contact.getPhone());
                item.setRelation(contact.getRelation());
                item.setId(contact.getId().longValue());
                this.mLocalRelationList.add(item);
            }
            showCountInfo(this.mLocalRelationList, this.mExitRelationCountTv);
            if (this.mLocalRespondent.getIsLeaveCountyr().intValue() == 1) {
                this.mExitRg.check(R.id.rb_exit_yes);
                this.mCountryDestinationMaterialEditText.setText(this.mLocalRespondent.getLeaveFor());
                this.mCountryEntryMaterialEditText.setText(this.mLocalRespondent.getEnter());
                this.mExitReasonSpinner.setSelection(this.mLocalRespondent.getLeaveReason().intValue(), false);
            } else {
                this.mRecentEventsInfoMaterialEditText.setText(this.mLocalRespondent.getActivityDetail());
            }
            if (this.mLocalRespondent.getIsSuspicious().intValue() == 1) {
                this.mExitEventRg.check(R.id.rb_exit_suspicious_yes);
                this.mSuspiciousEventsMaterialEditText.setText(this.mLocalRespondent.getSuspiciousAction());
            }
            if (this.mLocalRespondent.getActionSuspicous() != null) {
                if (this.mLocalRespondent.getActionSuspicous().intValue() == 1) {
                    this.mIsSuspiciousRg.check(R.id.rb_issuspicious_yes);
                }
                if (this.mLocalRespondent.getActionSuspicous().intValue() == 0) {
                    this.mIsSuspiciousRg.check(R.id.rb_issuspicious_no);
                }
            }
            this.mSuspiciousInfoMaterialEditText.setText(this.mLocalRespondent.getActionInfo());
        }
    }

    @OnClick({2131296888, 2131296372, 2131296371})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_miss_commit:
                submitAction();
                return;
            case R.id.btn_miss_save:
                localSave();
                return;
            case R.id.ibtn_back:
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    private void submitAction() {
        savePhoto(new ISavePhoto() {
            public String checkInput() {
                String result = null;
                if (!CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mAddNameMaterialEditText, true)) {
                    OverduePersonAddFeedFragment.this.mAddNameMaterialEditText.requestFocus();
                    OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mAddVisitorLayout.getTop() + OverduePersonAddFeedFragment.this.mAddNameTextView.getTop());
                    result = OverduePersonAddFeedFragment.this.mAddNameMaterialEditText.getError().toString();
                }
                if (!CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mAddHouseMaterialEditText, false) && TextUtils.isEmpty(result)) {
                    OverduePersonAddFeedFragment.this.mAddHouseMaterialEditText.requestFocus();
                    OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mAddVisitorLayout.getTop() + OverduePersonAddFeedFragment.this.mAddHouseholdTextView.getTop());
                    result = OverduePersonAddFeedFragment.this.mAddHouseMaterialEditText.getError().toString();
                }
                String phoneError = OverduePersonAddFeedFragment.this.mAddPhonePhoneListView.check(false, TextUtils.isEmpty(result));
                if (!TextUtils.isEmpty(phoneError) && TextUtils.isEmpty(result)) {
                    OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mAddVisitorLayout.getTop() + OverduePersonAddFeedFragment.this.mAddPhoneTextView.getTop());
                    result = phoneError;
                }
                if (!CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mAddIdentityMaterialEditText, DefaultMaterialEditTextCheckCard.newInstance(false)) && TextUtils.isEmpty(result)) {
                    OverduePersonAddFeedFragment.this.mAddIdentityMaterialEditText.requestFocus();
                    OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mAddVisitorLayout.getTop() + OverduePersonAddFeedFragment.this.mAddIdentityTextView.getTop());
                    result = OverduePersonAddFeedFragment.this.mAddIdentityMaterialEditText.getError().toString();
                }
                if (OverduePersonAddFeedFragment.this.mRelationMaterialSpinner.getSelectedItemPosition() == 0) {
                    OverduePersonAddFeedFragment.this.mRelationMaterialSpinner.setError((CharSequence) "请选择调查对象与走访对象关系");
                    if (TextUtils.isEmpty(result)) {
                        OverduePersonAddFeedFragment.this.mRelationMaterialSpinner.requestFocus();
                        OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mPhoneRelationTextView.getTop());
                        result = "请选择调查对象与走访对象关系";
                    }
                }
                if (OverduePersonAddFeedFragment.this.mOtherFamilyLinearLayout.getVisibility() == 0 && !CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mOtherFamilyMaterialEditText, false) && TextUtils.isEmpty(result)) {
                    OverduePersonAddFeedFragment.this.mOtherFamilyMaterialEditText.requestFocus();
                    OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mOtherFamilyLinearLayout.getTop());
                    result = OverduePersonAddFeedFragment.this.mOtherFamilyMaterialEditText.getError().toString();
                }
                if (OverduePersonAddFeedFragment.this.mReasonLinearLayout.getVisibility() == 0 && !CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mReasonMaterialEditText, false) && TextUtils.isEmpty(result)) {
                    OverduePersonAddFeedFragment.this.mReasonMaterialEditText.requestFocus();
                    OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mReasonLinearLayout.getTop());
                    result = OverduePersonAddFeedFragment.this.mReasonMaterialEditText.getError().toString();
                }
                if (OverduePersonAddFeedFragment.this.mRecentEventsInfoLinearLayout.getVisibility() == 0) {
                    if (!CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mRecentEventsInfoMaterialEditText, false) && TextUtils.isEmpty(result)) {
                        OverduePersonAddFeedFragment.this.mRecentEventsInfoMaterialEditText.requestFocus();
                        OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mRecentEventsInfoLinearLayout.getTop());
                        result = OverduePersonAddFeedFragment.this.mRecentEventsInfoMaterialEditText.getError().toString();
                    }
                    if (OverduePersonAddFeedFragment.this.mIsSuspiciousInfoLinearLayout.getVisibility() == 0 && !CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mSuspiciousInfoMaterialEditText, false) && TextUtils.isEmpty(result)) {
                        OverduePersonAddFeedFragment.this.mSuspiciousInfoMaterialEditText.requestFocus();
                        OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mRecentEventsInfoLinearLayout.getTop() + OverduePersonAddFeedFragment.this.mIsSuspiciousInfoLinearLayout.getTop());
                        result = OverduePersonAddFeedFragment.this.mSuspiciousInfoMaterialEditText.getError().toString();
                    }
                }
                if (OverduePersonAddFeedFragment.this.mExitOtherCountryLinearLayout.getVisibility() != 0) {
                    return result;
                }
                if (!CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mCountryDestinationMaterialEditText, false) && TextUtils.isEmpty(result)) {
                    OverduePersonAddFeedFragment.this.mCountryDestinationMaterialEditText.requestFocus();
                    OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mExitOtherCountryLinearLayout.getTop());
                    result = OverduePersonAddFeedFragment.this.mCountryDestinationMaterialEditText.getError().toString();
                }
                if (!CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mCountryEntryMaterialEditText, false) && TextUtils.isEmpty(result)) {
                    OverduePersonAddFeedFragment.this.mCountryEntryMaterialEditText.requestFocus();
                    OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mExitOtherCountryLinearLayout.getTop() + OverduePersonAddFeedFragment.this.mCountryEntryTextView.getTop());
                    result = OverduePersonAddFeedFragment.this.mCountryEntryMaterialEditText.getError().toString();
                }
                if (!CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mExitReasonMaterialEditText, false) && TextUtils.isEmpty(result)) {
                    OverduePersonAddFeedFragment.this.mExitReasonMaterialEditText.requestFocus();
                    OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mExitOtherCountryLinearLayout.getTop() + OverduePersonAddFeedFragment.this.mExitReasonTextView.getTop());
                    result = OverduePersonAddFeedFragment.this.mExitReasonMaterialEditText.getError().toString();
                }
                if (OverduePersonAddFeedFragment.this.mExitSuspiciousEventsLinearLayout.getVisibility() != 0 || CheckUtils.isMaterialEditTextInputRight(OverduePersonAddFeedFragment.this.mSuspiciousEventsMaterialEditText, false) || !TextUtils.isEmpty(result)) {
                    return result;
                }
                OverduePersonAddFeedFragment.this.mExitReasonMaterialEditText.requestFocus();
                OverduePersonAddFeedFragment.this.mScrollView.scrollTo(0, OverduePersonAddFeedFragment.this.mExitSuspiciousEventsLinearLayout.getTop());
                return OverduePersonAddFeedFragment.this.mSuspiciousEventsMaterialEditText.getError().toString();
            }

            public void afterSave(List<PhotoCompress> uploadFileList) {
                try {
                    Map<String, RequestBody> params = new HashMap();
                    params.put("visitor", RequestBody.create(null, OverduePersonAddFeedFragment.this.packageVisitor().toString()));
                    params.put("res", RequestBody.create(null, OverduePersonAddFeedFragment.this.packageBaseInfo().toString()));
                    if (OverduePersonAddFeedFragment.this.mExitRg.getCheckedRadioButtonId() == R.id.rb_exit_yes) {
                        params.put("foreigners", RequestBody.create(null, OverduePersonAddFeedFragment.this.packageForeigners().toString()));
                    }
                    for (PhotoCompress imgPath : uploadFileList) {
                        params.put(imgPath.getKey() + imgPath.getName(), RequestBody.create(MediaType.parse("image/jpeg"), new File(imgPath.getPath())));
                    }
                    AttendanceService.getApi().submitOverduePersonFeeds(params).enqueue(new OneProjectCallback<ReportResult>(OverduePersonAddFeedFragment.this) {
                        public void onResponse(ReportResult bean) {
                            OverduePersonAddFeedFragment.this.mWaitingDialog.dismiss();
                            ToastUtil.showToast("反馈成功");
                            Intent intent = new Intent(OverduePersonAddFeedFragment.this.getActivity(), MainTab.class);
                            intent.setFlags(67108864);
                            intent.putExtra(TasksListFragment.TASK_TYPE, 12);
                            OverduePersonAddFeedFragment.this.startActivity(intent);
                        }

                        public void onFailed(String errorMessage) {
                            super.onFailed(errorMessage);
                            OverduePersonAddFeedFragment.this.mWaitingDialog.dismiss();
                        }
                    });
                } catch (JSONException e) {
                    ToastUtil.showToast(e.getMessage());
                    OverduePersonAddFeedFragment.this.mWaitingDialog.dismiss();
                } catch (RetrofitUrlNullException e2) {
                    FecUtil.showUrlIsNullToast(IMSDroid.getContext());
                    OverduePersonAddFeedFragment.this.mWaitingDialog.dismiss();
                }
            }
        }, "正在上传");
    }

    public void savePhoto(final ISavePhoto listener, final String progressText) {
        String error = listener.checkInput();
        if (TextUtils.isEmpty(error)) {
            this.mWaitingDialog.show((int) R.string.compressing_images);
            SelectPhotoView.compressUploadFile(getActivity(), new CompressUploadFile() {
                public List<PhotoCompress> onStart() {
                    return OverduePersonAddFeedFragment.this.mReportPicIv.getUpdatePhotoCompress("visitor_photo\"; filename=\"");
                }

                public void onFinish(List<PhotoCompress> uploadFileList) {
                    if (OverduePersonAddFeedFragment.this.isAdded()) {
                        OverduePersonAddFeedFragment.this.mWaitingDialog.show(progressText);
                        listener.afterSave(uploadFileList);
                    }
                }

                public void onFailed() {
                    if (OverduePersonAddFeedFragment.this.isAdded()) {
                        OverduePersonAddFeedFragment.this.reportFailAction(IMSDroid.getContext().getString(R.string.image_conversion_failed));
                    }
                }
            });
            return;
        }
        ToastUtil.showToast(error);
    }

    private void reportFailAction(String toastStr) {
        this.mWaitingDialog.dismiss();
        ToastUtil.showToast(toastStr);
    }

    private void localSave() {
        if (this.mLocalRespondent == null) {
            this.mLocalRespondent = new OverduePersonInfo();
        }
        this.mLocalRespondent.setTask_id(this.mWarnId);
        this.mLocalRespondent.setName(this.mNameText.getText().toString());
        this.mLocalRespondent.setIdCard(this.mIdentityText.getText().toString());
        this.mLocalRespondent.setPhone(this.mPhoneText.getText().toString());
        this.mLocalRespondent.setAddress(this.mHouseHoldText.getText().toString());
        if (1 != this.mRelationMaterialSpinner.getSelectedItemPosition()) {
            this.mLocalRespondent.setSuspiciousInfo(Integer.valueOf(0));
        } else if (this.mSuspiciousRg.getCheckedRadioButtonId() == R.id.rb_suspicious_yes) {
            this.mLocalRespondent.setSuspiciousInfo(Integer.valueOf(this.mSuspiciousInfoMaterialSpinner.getSelectedItemPosition()));
        } else {
            this.mLocalRespondent.setSuspiciousInfo(Integer.valueOf(0));
        }
        if (this.mExitRg.getCheckedRadioButtonId() == R.id.rb_exit_yes) {
            this.mLocalRespondent.setIsLeaveCountyr(Integer.valueOf(1));
            this.mLocalRespondent.setLeaveFor(this.mCountryDestinationMaterialEditText.getText().toString());
            this.mLocalRespondent.setEnter(this.mCountryEntryMaterialEditText.getText().toString());
            this.mLocalRespondent.setLeaveReason(Integer.valueOf(this.mExitReasonSpinner.getSelectedItemPosition()));
            this.mLocalRespondent.setOtherReason(this.mReasonMaterialEditText.getText().toString());
        } else {
            this.mLocalRespondent.setIsLeaveCountyr(Integer.valueOf(0));
            this.mLocalRespondent.setActivityDetail(this.mRecentEventsInfoMaterialEditText.getText().toString());
        }
        if (this.mExitEventRg.getCheckedRadioButtonId() == R.id.rb_exit_suspicious_yes) {
            this.mLocalRespondent.setIsSuspicious(Integer.valueOf(1));
            this.mLocalRespondent.setSuspiciousAction(this.mSuspiciousEventsMaterialEditText.getText().toString());
        } else {
            this.mLocalRespondent.setIsSuspicious(Integer.valueOf(0));
        }
        int issuspicious = -1;
        if (this.mIsSuspiciousRg.getCheckedRadioButtonId() == R.id.rb_issuspicious_yes) {
            issuspicious = 1;
        }
        if (this.mIsSuspiciousRg.getCheckedRadioButtonId() == R.id.rb_issuspicious_no) {
            issuspicious = 0;
        }
        this.mLocalRespondent.setActionSuspicous(Integer.valueOf(issuspicious));
        this.mLocalRespondent.setActionInfo(this.mSuspiciousInfoMaterialEditText.getText().toString());
        long respondentId = OneProjectDao.getInstance().getDaoSession().getOverduePersonInfoDao().insertOrReplace(this.mLocalRespondent);
        OneProjectDao.getInstance().getDaoSession().getOverduePersonContactDao().deleteInTx(this.mRelationList);
        if (this.mLocalAddVisitor == null) {
            this.mLocalAddVisitor = new OverduePersonVisitor();
        }
        this.mLocalAddVisitor.setFkOp(Long.valueOf(respondentId));
        this.mLocalAddVisitor.setName(this.mAddNameMaterialEditText.getText().toString());
        this.mLocalAddVisitor.setIdCard(this.mAddIdentityMaterialEditText.getText().toString());
        this.mLocalAddVisitor.setAddress(this.mAddHouseMaterialEditText.getText().toString());
        this.mLocalAddVisitor.setPhone(this.mAddPhonePhoneListView.getText());
        this.mLocalAddVisitor.setSex(Integer.valueOf(sexInfo()));
        this.mLocalAddVisitor.setRelation(Integer.valueOf(this.mRelationMaterialSpinner.getSelectedItemPosition()));
        if (this.mSelectedImages.size() > 0) {
            this.mLocalAddVisitor.setPhoto(FecUtil.listToString(this.mSelectedImages, ','));
        }
        if (2 == this.mRelationMaterialSpinner.getSelectedItemPosition()) {
            this.mLocalAddVisitor.setKinship(Integer.valueOf(this.mFamilySpinner.getSelectedItemPosition()));
            if (9 == this.mFamilySpinner.getSelectedItemPosition()) {
                this.mLocalAddVisitor.setOtherRelation(this.mOtherFamilyMaterialEditText.getText().toString());
            }
        } else if (3 == this.mRelationMaterialSpinner.getSelectedItemPosition()) {
            this.mLocalAddVisitor.setOtherRelation(this.mOtherFamilyMaterialEditText.getText().toString());
        } else if (4 == this.mRelationMaterialSpinner.getSelectedItemPosition()) {
            this.mLocalAddVisitor.setReson(this.mReasonMaterialEditText.getText().toString());
        }
        OneProjectDao.getInstance().getDaoSession().getOverduePersonVisitorDao().insertOrReplaceInTx(new OverduePersonVisitor[]{this.mLocalAddVisitor});
        List<OverduePersonContact> contactList = new ArrayList();
        for (PeerItem item : this.mLocalRelationList) {
            OverduePersonContact contact = new OverduePersonContact();
            contact.setFkOpv(Long.valueOf(respondentId));
            contact.setName(item.getName());
            contact.setPhone(item.getPhone());
            contact.setRelation(item.getRelation());
            contact.setNote(item.getNote());
            if (item.getId() != -1) {
                contact.setId(Long.valueOf(item.getId()));
            }
            contactList.add(contact);
        }
        OneProjectDao.getInstance().getDaoSession().getOverduePersonContactDao().insertOrReplaceInTx(contactList);
        getActivity().finish();
    }

    private int sexInfo() {
        if (this.mManRb.isChecked()) {
            return 1;
        }
        if (this.mFemaleRb.isChecked()) {
            return 0;
        }
        return -1;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case 1111:
                    if (data.getSerializableExtra("item_list") != null) {
                        this.mLocalRelationList = (List) data.getSerializableExtra("item_list");
                    }
                    showCountInfo(this.mLocalRelationList, this.mExitRelationCountTv);
                    return;
                case 10000:
                    this.mSelectedImages = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                    this.mReportPicIv.setSelectedPhotoList(this.mSelectedImages);
                    return;
                default:
                    return;
            }
        }
    }

    private void showCountInfo(List list, TextView tv) {
        String phoneCount = "无";
        if (list.size() > 0) {
            phoneCount = list.size() + "个";
        }
        tv.setText(phoneCount);
    }

    private JSONObject packageBaseInfo() throws JSONException {
        JSONObject object = new JSONObject();
        String userName = this.mXmppConfig.getString(Constants.XMPP_USERNAME, "");
        String organizationId = this.mXmppConfig.getString(Constants.UUM_USER_ORGANIZATION_ID, "");
        String type = new GetPrivilegeService(IMSDroid.getContext()).getString(GetPrivilegeService.PRIVILEGE, "");
        object.put("addUser", userName);
        object.put("userOrganizationId", organizationId);
        object.put("userType", type);
        if (1 == this.mRelationMaterialSpinner.getSelectedItemPosition()) {
            if (this.mSuspiciousRg.getCheckedRadioButtonId() == R.id.rb_suspicious_yes) {
                object.put("suspiciousInfo", this.mSuspiciousInfoMaterialSpinner.getSelectedItemPosition());
            } else {
                object.put("suspiciousInfo", 0);
            }
            object.put("suspiciousInfo", this.mSuspiciousInfoMaterialSpinner.getSelectedItemPosition());
        } else {
            object.put("suspiciousInfo", 0);
        }
        if (this.mExitRg.getCheckedRadioButtonId() == R.id.rb_exit_yes) {
            object.put("isLeaveCountry", 1);
            object.put("leaveFor", this.mCountryDestinationMaterialEditText.getText().toString());
            object.put("enter", this.mCountryEntryMaterialEditText.getText().toString());
            object.put("leaveReason", this.mExitReasonSpinner.getSelectedItemPosition());
            object.put("otherReason", this.mExitReasonMaterialEditText.getText().toString());
        } else {
            object.put("isLeaveCountry", 0);
            object.put("activityDetail", this.mRecentEventsInfoMaterialEditText.getText().toString());
        }
        if (this.mExitEventRg.getCheckedRadioButtonId() == R.id.rb_exit_suspicious_yes) {
            object.put("isSuspicious", 1);
            object.put("suspiciousActivity", this.mSuspiciousEventsMaterialEditText.getText().toString());
        } else {
            object.put("isSuspicious", 0);
        }
        if (this.mIsSuspiciousRg.getCheckedRadioButtonId() == R.id.rb_issuspicious_yes) {
            object.put("isActionSuspicious", 1);
            object.put("actionSuspiciousInfo", this.mSuspiciousInfoMaterialEditText.getText().toString());
        } else {
            object.put("isActionSuspicious", 0);
        }
        object.put("longitude", getLongitude());
        object.put("latitude", getLatitude());
        object.put("locationDescription", getLocationDescription());
        return object;
    }

    private JSONObject packageVisitor() throws JSONException {
        JSONObject object = new JSONObject();
        String userName = this.mXmppConfig.getString(Constants.XMPP_USERNAME, "");
        String organizationId = this.mXmppConfig.getString(Constants.UUM_USER_ORGANIZATION_ID, "");
        String type = new GetPrivilegeService(IMSDroid.getContext()).getString(GetPrivilegeService.PRIVILEGE, "");
        object.put("fkOp", this.mWarnId);
        object.put("name", this.mAddNameMaterialEditText.getText().toString());
        object.put("idCard", this.mAddIdentityMaterialEditText.getText().toString());
        object.put("censusRegisterDetial", this.mAddHouseMaterialEditText.getText().toString());
        object.put("phone", this.mAddPhonePhoneListView.getText());
        object.put("sex", sexInfo());
        object.put("relation", this.mRelationMaterialSpinner.getSelectedItemPosition() + "");
        if (2 == this.mRelationMaterialSpinner.getSelectedItemPosition()) {
            object.put("kinship", this.mFamilySpinner.getSelectedItemPosition() + "");
            if (9 == this.mFamilySpinner.getSelectedItemPosition()) {
                object.put("otherRelation", this.mOtherFamilyMaterialEditText.getText().toString());
            }
        } else if (3 == this.mRelationMaterialSpinner.getSelectedItemPosition()) {
            object.put("otherRelation", this.mOtherFamilyMaterialEditText.getText().toString());
        } else if (4 == this.mRelationMaterialSpinner.getSelectedItemPosition()) {
            object.put("reson", this.mReasonMaterialEditText.getText().toString());
        }
        object.put("addUser", userName);
        object.put("userOrganizationId", organizationId);
        object.put("type", "2");
        return object;
    }

    private JSONArray packageForeigners() throws JSONException {
        String userName = this.mXmppConfig.getString(Constants.XMPP_USERNAME, "");
        String organizationId = this.mXmppConfig.getString(Constants.UUM_USER_ORGANIZATION_ID, "");
        JSONArray array = new JSONArray();
        for (PeerItem item : this.mLocalRelationList) {
            JSONObject object = new JSONObject();
            object.put("name", item.getName());
            object.put("phone", item.getPhone());
            object.put("relation", item.getRelation() + "");
            object.put("note", item.getNote());
            object.put("addUser", userName);
            object.put("userOrganizationId", organizationId);
            array.put(object);
        }
        return array;
    }
}
