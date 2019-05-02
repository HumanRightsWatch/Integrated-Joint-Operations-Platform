package com.fec.xjoneproject.ui.report.collection.fragment;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.baidu.location.BDLocation;
import com.fec.report.dao.BuildingInfo;
import com.fec.report.dao.BuildingInfoDao.Properties;
import com.fec.report.dao.CommonSaveInfo;
import com.fec.report.dao.HouseInfo;
import com.fec.report.dao.HouseInfoDao;
import com.fec.xjoneproject.dao.OneProjectDao;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.ui.WaitingDialogBaseFragment;
import com.fec.xjoneproject.ui.report.BuildingListActivity;
import com.fec.xjoneproject.ui.report.HomeInfoActivity;
import com.fec.xjoneproject.ui.report.HomeInfoFragment;
import com.fec.xjoneproject.ui.report.HouseListActivity;
import com.fec.xjoneproject.ui.report.InfoSearchActivity;
import com.fec.xjoneproject.ui.report.InfoSearchFragment;
import com.fec.xjoneproject.ui.report.bean.BuildingInfoEntity;
import com.fec.xjoneproject.ui.report.bean.ComparisonResult;
import com.fec.xjoneproject.ui.report.bean.HouseInfoEntity;
import com.fec.xjoneproject.ui.report.bean.MapReportInfoResponse;
import com.fec.xjoneproject.ui.report.bean.PersonInfoEntity;
import com.fec.xjoneproject.ui.report.bean.ReportInfoEntity;
import com.fec.xjoneproject.ui.report.bean.ReportResultResponse;
import com.fec.xjoneproject.ui.report.collection.ComparisonFragment;
import com.fec.xjoneproject.ui.report.collection.PopulationQueryActivity;
import com.fec.xjoneproject.ui.task.CommonLocalSaveHelper;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.view.MultiSelectPopWindow.Builder;
import com.fec.xjoneproject.ui.view.MultiSelectPopWindow.OnConfirmClickListener;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.fec.xjoneproject.ui.view.SelectPhotoView.CompressUploadFile;
import com.fec.xjoneproject.ui.view.SelectPhotoView.PhotoCompress;
import com.fec.xjoneproject.ui.view.field.OneProjectCheckable;
import com.fec.xjoneproject.ui.view.field.OneProjectFieldCommonLayout;
import com.fec.xjoneproject.ui.view.field.OneProjectMoreFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleEditTextFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleSpinnerFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleSpinnerFieldView.OnItemSelectedListener;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleTextFieldView;
import com.fec.xjoneproject.ui.view.field.multiEditText.OneProjectMultiEditTextFieldView;
import com.fec.xjoneproject.util.CheckUtils;
import com.fec.xjoneproject.util.CheckUtils.DefaultMaterialEditTextCheckCard;
import com.fec.xjoneproject.util.CheckUtils.DefaultMaterialEditTextCheckNone;
import com.fec.xjoneproject.util.DateUtil;
import com.fec.xjoneproject.util.FecUtil;
import com.fec.xjoneproject.util.ISavePhoto;
import com.fec.xjoneproject.util.LocationHelper;
import com.fec.xjoneproject.util.LocationHelper.LocationListener;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.fec.xjoneproject.util.SpinnerItem;
import com.fec.xjoneproject.util.ToastUtil;
import com.google.gson.Gson;
import com.hbfec.asmack.im.comm.ConnectionUtils;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneinformation.Utils.XMPPConfiguration;
import com.hbfec.xjoneproject.R;
import com.idcard.CardInfo;
import com.idcard.TFieldID;
import com.idcard.TRECAPIImpl;
import com.idcard.TengineID;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.turui.bank.ocr.CaptureActivity;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.greenrobot.greendao.query.WhereCondition;
import org.json.JSONException;
import org.json.JSONObject;

public class CollectionPersonFragment extends CollectionBaseFragment {
    public static final String CHAR_DAY = "日";
    public static final String CHAR_MONTH = "月";
    public static final String CHAR_YEAR = "年";
    public static final String[] STRINGS = new String[0];
    private final int FLAG_LOCATION = 100;
    @Bind({2131297139})
    LinearLayout JiaoPeiLayout;
    @Bind({2131296296})
    OneProjectSimpleEditTextFieldView addressHomeOneProjectSimpleEditTextFieldView;
    @Bind({2131296297})
    OneProjectSimpleEditTextFieldView addressNowOneProjectSimpleEditTextFieldView;
    @Bind({2131296298})
    OneProjectSimpleEditTextFieldView addressOneProjectSimpleEditTextFieldView;
    @Bind({2131296329})
    OneProjectSimpleSpinnerFieldView bloodOneProjectSimpleSpinnerFieldView;
    @Bind({2131296401})
    OneProjectMoreFieldView buildingOneProjectMoreFieldView;
    @Bind({2131296411})
    OneProjectMultiEditTextFieldView carOneProjectMultiEditTextFieldView;
    @Bind({2131296413})
    OneProjectSimpleEditTextFieldView cardNowOneProjectSimpleEditTextFieldView;
    @Bind({2131296449})
    OneProjectSimpleSpinnerFieldView changeIdentityOneProjectSimpleSpinnerFieldView;
    private CommonSaveInfo commonSaveInfo = null;
    @Bind({2131296546})
    OneProjectSimpleEditTextFieldView descriptionOneProjectSimpleEditTextFieldView;
    @Bind({2131296552})
    OneProjectSimpleEditTextFieldView destinationCountryOneProjectSimpleEditTextFieldView;
    @Bind({2131296574})
    OneProjectSimpleSpinnerFieldView educationOneProjectSimpleSpinnerFieldView;
    @Bind({2131296795})
    OneProjectSimpleSpinnerFieldView exitReasonOneProjectSimpleSpinnerFieldView;
    @Bind({2131296796})
    OneProjectSimpleTextFieldView exitTimeOneProjectSimpleTextFieldView;
    @Bind({2131296860})
    OneProjectSimpleSpinnerFieldView heightOneProjectSimpleSpinnerFieldView;
    @Bind({2131296880})
    OneProjectMoreFieldView houseOneProjectMoreFieldView;
    @Bind({2131297047})
    OneProjectSimpleEditTextFieldView jiaopeiActionOneProjectSimpleEditTextFieldView;
    @Bind({2131297048})
    OneProjectSimpleEditTextFieldView jiaopeiReasonOneProjectSimpleEditTextFieldView;
    @Bind({2131297221})
    OneProjectSimpleEditTextFieldView locationOneProjectSimpleEditTextFieldView;
    private BuildingInfoEntity mBuildingInfoEntity = null;
    private List<String> mBuildingUploadImgs = new ArrayList();
    private String[] mCarArray = STRINGS;
    @Bind({2131296603})
    MaterialEditText mCardMaterialEditText;
    @Bind({2131297001})
    ImageButton mCardPhotoImageButton;
    @Bind({2131297138})
    LinearLayout mChangeIdLayout;
    @Bind({2131296826})
    FrameLayout mCheckPersonContainerFrameLayout;
    private int mCollectionTheme = 0;
    private ComparisonFragment mComparisonFragment = null;
    @Bind({2131298046})
    TextView mEditPhotoTv;
    TRECAPIImpl mEngineDemo = new TRECAPIImpl();
    @Bind({2131296812})
    OneProjectFieldCommonLayout mFieldCardOneProjectFieldCommonLayout;
    private Handler mHandler = null;
    private HouseInfoEntity mHouseInfoEntity = null;
    private double mLatitude;
    private LocationListener mLocationListener;
    private String mLocationString;
    private double mLongitude;
    private boolean mOnlinePhoto = false;
    @Bind({2131296760})
    MaterialEditText mOtherTypeEt;
    private PersonInfoEntity mPersonInfoEntity = null;
    private List<Integer> mPersonTypeIndexList = new ArrayList();
    @Bind({2131297161})
    LinearLayout mPersonTypeOverseaLayout;
    private ReportInfoEntity mReportInfo = null;
    @Bind({2131296848})
    SelectPhotoView mReportPicture;
    @Bind({2131297595})
    LinearLayout mRootView;
    private WaitingDialogBaseFragment mWaitingDialog = null;
    @Bind({2131297320})
    OneProjectSimpleEditTextFieldView nameNowOneProjectSimpleEditTextFieldView;
    @Bind({2131297321})
    OneProjectSimpleEditTextFieldView nameOneProjectSimpleEditTextFieldView;
    @Bind({2131297326})
    OneProjectSimpleEditTextFieldView nationNowOneProjectSimpleEditTextFieldView;
    @Bind({2131297327})
    OneProjectSimpleEditTextFieldView nationOneProjectSimpleEditTextFieldView;
    @Bind({2131297390})
    OneProjectSimpleEditTextFieldView passportNumberOneProjectSimpleEditTextFieldView;
    @Bind({2131297392})
    OneProjectSimpleEditTextFieldView passportOneProjectSimpleEditTextFieldView;
    @Bind({2131297393})
    OneProjectSimpleSpinnerFieldView passportTypeOneProjectSimpleSpinnerFieldView;
    @Bind({2131297400})
    OneProjectSimpleSpinnerFieldView personCardMatchOneProjectSimpleSpinnerFieldView;
    @Bind({2131297424})
    OneProjectMultiEditTextFieldView phoneOneProjectMultiEditTextFieldView;
    @Bind({2131297440})
    OneProjectSimpleSpinnerFieldView politicalOneProjectSimpleSpinnerFieldView;
    @Bind({2131297448})
    OneProjectSimpleEditTextFieldView professionOneProjectSimpleEditTextFieldView;
    @Bind({2131297510})
    OneProjectSimpleSpinnerFieldView relationOneProjectSimpleSpinnerFieldView;
    @Bind({2131297512})
    OneProjectSimpleSpinnerFieldView religionNameOneProjectSimpleSpinnerFieldView;
    @Bind({2131297513})
    OneProjectSimpleSpinnerFieldView religiousOneProjectSimpleSpinnerFieldView;
    @Bind({2131298337})
    OneProjectSimpleTextFieldView typeOneProjectSimpleTextFieldView;

    public interface CollectionPersonListener {
        void showCheck(boolean z);
    }

    private static class MyHandler extends Handler {
        private ISavePhoto listener;
        private WeakReference<CollectionPersonFragment> reference;

        MyHandler(CollectionPersonFragment context) {
            this.reference = new WeakReference(context);
        }

        public void handleMessage(Message msg) {
            CollectionPersonFragment context = (CollectionPersonFragment) this.reference.get();
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

    private void initData() {
        if (getActivity() != null) {
            this.mReportInfo = (ReportInfoEntity) getActivity().getIntent().getSerializableExtra("ReportInfoEntity");
            this.mHandler = new MyHandler(this);
        }
    }

    public static CollectionPersonFragment newInstance(CommonSaveInfo commonSaveInfo) {
        CollectionPersonFragment fragment = new CollectionPersonFragment();
        Bundle args = new Bundle();
        args.putParcelable(TaskConstant.ARG_KEY_ENTITY, commonSaveInfo);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.commonSaveInfo = (CommonSaveInfo) getArguments().getParcelable(TaskConstant.ARG_KEY_ENTITY);
        }
        initData();
        this.mWaitingDialog = new WaitingDialogBaseFragment(getActivity());
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_problem_query, container, false);
        ButterKnife.bind((Object) this, view);
        this.mReportPicture.setFragmentReference(this);
        this.mReportPicture.setSinglePhoto(false);
        Integer theme = (Integer) CommonLocalSaveHelper.getEntity(this.commonSaveInfo, "theme", Integer.class);
        if (theme == null) {
            theme = Integer.valueOf(0);
        }
        setTheme(theme.intValue());
        if (getEditable().booleanValue()) {
            this.mEngineDemo.TR_StartUP(getActivity(), this.mEngineDemo.TR_GetEngineTimeKey());
            this.mFieldCardOneProjectFieldCommonLayout.setCheckable(new OneProjectCheckable() {
                public String check() {
                    if (CheckUtils.isMaterialEditTextInputRight(CollectionPersonFragment.this.mFieldCardOneProjectFieldCommonLayout, CollectionPersonFragment.this.mCardMaterialEditText, DefaultMaterialEditTextCheckCard.newInstance(true))) {
                        return null;
                    }
                    return CollectionPersonFragment.this.mFieldCardOneProjectFieldCommonLayout.getError();
                }
            });
            this.mCardMaterialEditText.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                public void afterTextChanged(Editable editable) {
                    CollectionPersonFragment.this.mFieldCardOneProjectFieldCommonLayout.hideError();
                }
            });
            this.mCardMaterialEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus && CollectionPersonFragment.this.mCardMaterialEditText != null) {
                        String card = CollectionPersonFragment.this.mCardMaterialEditText.getText().toString();
                        if (TextUtils.isEmpty(card) || !CheckUtils.isIdCardNo(card)) {
                            CollectionPersonFragment.this.mFieldCardOneProjectFieldCommonLayout.setError(CollectionPersonFragment.this.getString(R.string.error_wrong_identity));
                            return;
                        }
                        try {
                            CollectionPersonFragment.this.getInfoByIdCard(card);
                        } catch (RetrofitUrlNullException e) {
                            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
                        }
                    }
                }
            });
        } else {
            this.mReportPicture.setEditable(false);
            this.mOtherTypeEt.setEnabled(false);
            this.passportTypeOneProjectSimpleSpinnerFieldView.setEditable(false);
            this.passportNumberOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.destinationCountryOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.locationOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.descriptionOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.addressHomeOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.changeIdentityOneProjectSimpleSpinnerFieldView.setEditable(false);
            this.nameNowOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.cardNowOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.nationNowOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.addressNowOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.passportOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.jiaopeiReasonOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.jiaopeiActionOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.phoneOneProjectMultiEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.carOneProjectMultiEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.nameOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.mCardMaterialEditText.setEnabled(false);
            this.mCardPhotoImageButton.setVisibility(8);
            this.nationOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.addressOneProjectSimpleEditTextFieldView.setEnabled(false);
            this.typeOneProjectSimpleTextFieldView.setClickable(false);
            this.mEditPhotoTv.setVisibility(8);
            this.professionOneProjectSimpleEditTextFieldView.setEditable(Boolean.valueOf(false));
            this.educationOneProjectSimpleSpinnerFieldView.setEditable(false);
            this.religiousOneProjectSimpleSpinnerFieldView.setEditable(false);
            this.relationOneProjectSimpleSpinnerFieldView.setEditable(false);
            this.politicalOneProjectSimpleSpinnerFieldView.setEditable(false);
            this.bloodOneProjectSimpleSpinnerFieldView.setEditable(false);
            this.relationOneProjectSimpleSpinnerFieldView.setEditable(false);
            this.exitReasonOneProjectSimpleSpinnerFieldView.setEditable(false);
            this.heightOneProjectSimpleSpinnerFieldView.setEditable(false);
            this.personCardMatchOneProjectSimpleSpinnerFieldView.setEditable(false);
        }
        this.mPersonInfoEntity = (PersonInfoEntity) CommonLocalSaveHelper.getEntity(this.commonSaveInfo, "entity", PersonInfoEntity.class);
        if (this.mPersonInfoEntity != null) {
            if (this.mPersonInfoEntity.getInfoCollectionType() != null) {
                this.mCollectionTheme = this.mPersonInfoEntity.getInfoCollectionType().intValue();
            }
            this.nameOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getName());
            this.mCardMaterialEditText.setText(this.mPersonInfoEntity.getIdCard());
            this.nationOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getNation());
            this.addressOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getAddress());
            Integer modifyType = (Integer) CommonLocalSaveHelper.getEntity(this.commonSaveInfo, "modify_type", Integer.class);
            if (modifyType == null || 1 != modifyType.intValue()) {
                setOnlinePhoto(false);
                if (!TextUtils.isEmpty(this.mPersonInfoEntity.getPhoto())) {
                    this.mReportPicture.setSelectedPhotoList(this.mPersonInfoEntity.getPhoto().split(Constants.ACCEPT_TIME_SEPARATOR_SP));
                }
            } else {
                ArrayList<String> photos = FecUtil.getStringItems(this.mPersonInfoEntity.getPhoto());
                if (photos.size() > 0) {
                    setOnlinePhoto(true);
                    List temp = new ArrayList();
                    Iterator it = photos.iterator();
                    while (it.hasNext()) {
                        temp.add(AttendanceService.getBaseUrl() + ((String) it.next()));
                    }
                    this.mReportPicture.setSelectedPhotoList(temp);
                } else {
                    setOnlinePhoto(false);
                }
            }
            if (this.mPersonInfoEntity.getCarNumber() != null) {
                this.carOneProjectMultiEditTextFieldView.setText(this.mPersonInfoEntity.getCarNumber());
            }
            this.professionOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getProfession());
            if (this.mPersonInfoEntity.getEducation() != null) {
                this.educationOneProjectSimpleSpinnerFieldView.setSelection(this.mPersonInfoEntity.getEducation());
            }
            if (this.mPersonInfoEntity.getReligionAtmosphere() != null) {
                this.religiousOneProjectSimpleSpinnerFieldView.setSelection(this.mPersonInfoEntity.getReligionAtmosphere());
            }
            if (this.mPersonInfoEntity.getReligion() != null) {
                this.religionNameOneProjectSimpleSpinnerFieldView.setSelection(this.mPersonInfoEntity.getReligion());
            }
            if (this.mPersonInfoEntity.getPoliticsStatus() != null) {
                this.politicalOneProjectSimpleSpinnerFieldView.setSelection(this.mPersonInfoEntity.getPoliticsStatus());
            }
            if (this.mPersonInfoEntity.getBloodType() != null) {
                this.bloodOneProjectSimpleSpinnerFieldView.setSelection(this.mPersonInfoEntity.getBloodType());
            }
            if (this.mPersonInfoEntity.getStature() != null) {
                this.heightOneProjectSimpleSpinnerFieldView.setContentText(this.mPersonInfoEntity.getStature());
            }
            if (this.mPersonInfoEntity.getRelationWithHousehold() != null) {
                this.relationOneProjectSimpleSpinnerFieldView.setSelection(this.mPersonInfoEntity.getRelationWithHousehold());
            }
            if (this.mPersonInfoEntity.getReligion() != null && 5 == this.mPersonInfoEntity.getReligion().intValue()) {
                this.religionNameOneProjectSimpleSpinnerFieldView.setOtherText(this.mPersonInfoEntity.getReligionother());
            }
            if (this.mPersonInfoEntity.getPhoneNumber() != null) {
                this.phoneOneProjectMultiEditTextFieldView.setText(this.mPersonInfoEntity.getPhoneNumber());
            }
            this.politicalOneProjectSimpleSpinnerFieldView.setOtherText(this.mPersonInfoEntity.getPoliticsstatusother());
            if (this.mPersonInfoEntity.getRelationWithHousehold() == null || 20 != this.mPersonInfoEntity.getRelationWithHousehold().intValue()) {
                this.relationOneProjectSimpleSpinnerFieldView.setVisibility(8);
            } else {
                this.relationOneProjectSimpleSpinnerFieldView.setVisibility(0);
                this.relationOneProjectSimpleSpinnerFieldView.setOtherText(this.mPersonInfoEntity.getRelationother());
            }
            this.addressHomeOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getToCensus());
            this.passportOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getPassport());
            if (this.mPersonInfoEntity.getIsChangeIdin() != null) {
                if (this.mPersonInfoEntity.getIsChangeIdin() != null) {
                    this.changeIdentityOneProjectSimpleSpinnerFieldView.setSelection(Integer.valueOf(this.mPersonInfoEntity.getIsChangeIdin()));
                }
                if (this.mPersonInfoEntity.getIsChangeIdin().equals("1")) {
                    this.mChangeIdLayout.setVisibility(0);
                    this.nameNowOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getNewName());
                    this.nationNowOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getNewNation());
                    this.cardNowOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getNewIdCard());
                    this.addressNowOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getNewCensus());
                }
            }
            if (this.mPersonInfoEntity.getIsConsistency() != null) {
                this.personCardMatchOneProjectSimpleSpinnerFieldView.setSelection(Integer.valueOf(this.mPersonInfoEntity.getIsConsistency().intValue() + 1));
            }
            if (!TextUtils.isEmpty(this.mPersonInfoEntity.getPersonType())) {
                String[] types = this.mPersonInfoEntity.getPersonType().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (types.length == 0) {
                    this.typeOneProjectSimpleTextFieldView.setText(null);
                } else {
                    this.mPersonTypeIndexList = new ArrayList();
                    for (String type : types) {
                        this.mPersonTypeIndexList.add(Integer.valueOf(FecUtil.StringToInt(type)));
                    }
                    this.typeOneProjectSimpleTextFieldView.setText(SpinnerItem.getCollectionPersonTypeNameByID(this.mPersonTypeIndexList));
                    if (this.mPersonTypeIndexList.contains(Integer.valueOf(MultiImageSelectorActivity.REQUEST_PREVIEW))) {
                        this.mOtherTypeEt.setVisibility(0);
                        this.mOtherTypeEt.setText(this.mPersonInfoEntity.getPersonTypeOtherDesc());
                    } else {
                        this.mOtherTypeEt.setVisibility(8);
                    }
                }
            }
            this.jiaopeiReasonOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getAsylumEducateReason());
            this.jiaopeiActionOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getAction());
            this.descriptionOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getPersonDescription());
            this.locationOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getLocationDescription());
            if (this.mPersonInfoEntity.getIdType() != null) {
                this.passportTypeOneProjectSimpleSpinnerFieldView.setSelection(this.mPersonInfoEntity.getIdType());
            }
            this.passportNumberOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getIdNo());
            this.destinationCountryOneProjectSimpleEditTextFieldView.setText(this.mPersonInfoEntity.getDestCtry());
            this.exitTimeOneProjectSimpleTextFieldView.setText(this.mPersonInfoEntity.getExitTime());
            if (this.mPersonInfoEntity.getLeaveReason() != null) {
                this.exitReasonOneProjectSimpleSpinnerFieldView.setSelection(this.mPersonInfoEntity.getLeaveReason());
            }
            this.exitReasonOneProjectSimpleSpinnerFieldView.setOtherText(this.mPersonInfoEntity.getOtherReason());
            int count = 0;
            if (this.mPersonInfoEntity.getCount() != null) {
                count = this.mPersonInfoEntity.getCount().intValue();
            } else if (this.mPersonInfoEntity.getAppPic() != null) {
                count = 1;
            }
            showComparison(this.mPersonInfoEntity.getAppPic(), count);
            HouseInfo houseInfo = (HouseInfo) OneProjectDao.getInstance().getDaoSession().getHouseInfoDao().load((Long) CommonLocalSaveHelper.getEntity(this.commonSaveInfo, "house_id", Long.class));
            if (houseInfo != null) {
                this.mHouseInfoEntity = new HouseInfoEntity();
                this.mHouseInfoEntity.setValueFromLocal(houseInfo);
                showHouseInfo();
            }
            BuildingInfo buildingInfo = (BuildingInfo) OneProjectDao.getInstance().getDaoSession().getBuildingInfoDao().load((Long) CommonLocalSaveHelper.getEntity(this.commonSaveInfo, "building_id", Long.class));
            if (buildingInfo != null) {
                this.mBuildingInfoEntity = new BuildingInfoEntity();
                this.mBuildingInfoEntity.setValueFromLocal(buildingInfo);
                showBuildingInfo();
            }
        } else if (this.mReportInfo != null) {
            this.mBuildingInfoEntity = this.mReportInfo.getBuildingInfoEntity();
            this.mHouseInfoEntity = this.mReportInfo.getHouseInfoEntity();
            makeBuildingModifyType();
            showPersonInfo();
            showBuildingInfo();
            showHouseInfo();
        } else {
            showComparison(null, 0);
        }
        this.changeIdentityOneProjectSimpleSpinnerFieldView.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(SpinnerItem item) {
                int i = item.getId().intValue();
                if (i == 1) {
                    CollectionPersonFragment.this.mChangeIdLayout.setVisibility(0);
                } else if (i == 2) {
                    CollectionPersonFragment.this.mChangeIdLayout.setVisibility(8);
                }
            }
        });
        this.mLocationListener = new LocationListener() {
            public void onLocationSuccess(BDLocation location) {
                CollectionPersonFragment.this.mLatitude = location.getLatitude();
                CollectionPersonFragment.this.mLongitude = location.getLongitude();
                CollectionPersonFragment.this.mLocationString = location.getAddrStr();
                CollectionPersonFragment.this.mHandler.sendEmptyMessage(100);
            }

            public void onLocationFail(BDLocation location, String msg) {
                CollectionPersonFragment.this.locationOneProjectSimpleEditTextFieldView.setText("定位失败");
            }
        };
        return view;
    }

    public void setTheme(int theme) {
        this.mCollectionTheme = theme;
        showStarByCollectionTheme();
        if (theme == 4) {
            this.mPersonTypeOverseaLayout.setVisibility(0);
            this.passportOneProjectSimpleEditTextFieldView.setVisibility(8);
        } else {
            this.mPersonTypeOverseaLayout.setVisibility(8);
            this.passportOneProjectSimpleEditTextFieldView.setVisibility(0);
        }
        if (theme == 3) {
            this.JiaoPeiLayout.setVisibility(0);
        } else {
            this.JiaoPeiLayout.setVisibility(8);
        }
        if (theme == 5 || theme == 3) {
            this.houseOneProjectMoreFieldView.setVisibility(8);
            this.buildingOneProjectMoreFieldView.setVisibility(8);
        } else {
            this.houseOneProjectMoreFieldView.setVisibility(0);
            this.buildingOneProjectMoreFieldView.setVisibility(0);
        }
        if (theme != 5) {
            this.mChangeIdLayout.setVisibility(8);
        }
    }

    private void showStarByCollectionTheme() {
        if (2 == this.mCollectionTheme || 3 == this.mCollectionTheme || 4 == this.mCollectionTheme) {
            this.relationOneProjectSimpleSpinnerFieldView.setRequired(false);
            this.typeOneProjectSimpleTextFieldView.setRequired(true);
        } else if (5 == this.mCollectionTheme) {
            this.relationOneProjectSimpleSpinnerFieldView.setRequired(false);
            this.typeOneProjectSimpleTextFieldView.setRequired(false);
        } else {
            this.relationOneProjectSimpleSpinnerFieldView.setRequired(true);
            this.typeOneProjectSimpleTextFieldView.setRequired(false);
        }
    }

    private void showPersonTypes() {
        new Builder(getActivity()).setNameArray(SpinnerItem.CollectionPersonTypeS).setOtherMode(true).setConfirmListener(new OnConfirmClickListener() {
            public void onClick(ArrayList<Integer> indexList, ArrayList<SpinnerItem> selectedList) {
                if (indexList.size() > 0) {
                    CollectionPersonFragment.this.mPersonTypeIndexList.clear();
                    CollectionPersonFragment.this.typeOneProjectSimpleTextFieldView.setText(FecUtil.listToString((List) selectedList, ';'));
                }
                CollectionPersonFragment.this.mOtherTypeEt.setVisibility(8);
                Iterator it = selectedList.iterator();
                while (it.hasNext()) {
                    SpinnerItem item = (SpinnerItem) it.next();
                    CollectionPersonFragment.this.mPersonTypeIndexList.add(item.getId());
                    switch (item.getId().intValue()) {
                        case MultiImageSelectorActivity.REQUEST_PREVIEW /*300*/:
                            CollectionPersonFragment.this.mOtherTypeEt.setVisibility(0);
                            break;
                        default:
                            break;
                    }
                }
            }
        }).setCancel("取消").setConfirm("完成").setTitle("人员类型").build().show(this.mRootView);
    }

    private String personTypeIndexString() {
        return FecUtil.listToString(this.mPersonTypeIndexList, ',');
    }

    public void searchPersonInTheSameHouse() {
        Intent intent = new Intent(getActivity(), InfoSearchActivity.class);
        intent.putExtra(InfoSearchFragment.HOUSENUMBER, this.mHouseInfoEntity.getHouseNumber());
        intent.putExtra(InfoSearchFragment.VILLAGECODE, this.mBuildingInfoEntity.getVillageCode());
        intent.putExtra("address", this.mBuildingInfoEntity.getAddress());
        startActivity(intent);
    }

    public void onResume() {
        super.onResume();
        if (this.mBuildingInfoEntity == null || this.mHouseInfoEntity == null || this.mBuildingInfoEntity.getAddress() == null || this.mBuildingInfoEntity.getVillageCode() == null || this.mHouseInfoEntity.getHouseNumber() == null) {
            if (getActivity() != null) {
                ((CollectionPersonListener) getActivity()).showCheck(false);
            }
        } else if (getActivity() != null) {
            ((CollectionPersonListener) getActivity()).showCheck(true);
        }
        addLocationListener();
    }

    public void onPause() {
        super.onPause();
        LocationHelper.getInstance().removeLocationListener(this.mLocationListener);
    }

    private void addLocationListener() {
        if (getEditable().booleanValue() && this.commonSaveInfo == null) {
            LocationHelper.getInstance().addLocationListener(this.mLocationListener);
        }
    }

    private void setOnlinePhoto(boolean onlinePhoto) {
        this.mOnlinePhoto = onlinePhoto;
        if (!getEditable().booleanValue()) {
            this.mEditPhotoTv.setVisibility(8);
            this.mReportPicture.setEditable(false);
        } else if (this.mOnlinePhoto) {
            this.mEditPhotoTv.setVisibility(0);
            this.mReportPicture.setEditable(false);
        } else {
            this.mEditPhotoTv.setVisibility(8);
            this.mReportPicture.setEditable(true);
            this.mReportPicture.clear();
        }
    }

    @OnClick({2131297001, 2131296880, 2131296401, 2131296796, 2131298337, 2131298046})
    public void onClick(View v) {
        boolean z = true;
        boolean z2 = false;
        String str;
        switch (v.getId()) {
            case R.id.buildingOneProjectMoreFieldView:
                if (this.mBuildingInfoEntity == null) {
                    startActivityForResult(new Intent(getActivity(), BuildingListActivity.class), 2001);
                    return;
                }
                Intent buildingIntent = new Intent(getActivity(), PopulationQueryActivity.class);
                buildingIntent.putExtra("peer_bean", this.mBuildingInfoEntity);
                if (this.mBuildingUploadImgs.size() > 0) {
                    buildingIntent.putExtra("item_list", FecUtil.listToString(this.mBuildingUploadImgs, ','));
                }
                str = HomeInfoFragment.ARG_READ_ONLY_MODE;
                if (!getEditable().booleanValue()) {
                    z2 = true;
                }
                buildingIntent.putExtra(str, z2);
                startActivityForResult(buildingIntent, 1001);
                return;
            case R.id.exitTimeOneProjectSimpleTextViewField:
                if (isAdded() && getActivity() != null) {
                    Calendar c = Calendar.getInstance();
                    new DatePickerDialog(getActivity(), new OnDateSetListener() {
                        public void onDateSet(DatePicker dp, int year, int month, int dayOfMonth) {
                            CollectionPersonFragment.this.exitTimeOneProjectSimpleTextFieldView.setText(year + CollectionPersonFragment.CHAR_YEAR + (month + 1) + CollectionPersonFragment.CHAR_MONTH + dayOfMonth + CollectionPersonFragment.CHAR_DAY);
                        }
                    }, c.get(1), c.get(2), c.get(5)).show();
                    return;
                }
                return;
            case R.id.houseOneProjectMoreFieldView:
                if (this.mBuildingInfoEntity == null) {
                    this.buildingOneProjectMoreFieldView.setError("请先录入建筑信息");
                    ToastUtil.showToast("请先录入建筑信息");
                    return;
                } else if (this.mHouseInfoEntity != null) {
                    houseIntent = new Intent(getActivity(), HomeInfoActivity.class);
                    houseIntent.putExtra("peer_bean", this.mHouseInfoEntity);
                    str = HomeInfoFragment.ARG_READ_ONLY_MODE;
                    if (getEditable().booleanValue()) {
                        z = false;
                    }
                    houseIntent.putExtra(str, z);
                    startActivityForResult(houseIntent, 1002);
                    return;
                } else if (TextUtils.isEmpty(this.mBuildingInfoEntity.getPkBi())) {
                    startActivityForResult(new Intent(getActivity(), HomeInfoActivity.class), 1002);
                    return;
                } else {
                    houseIntent = new Intent(getActivity(), HouseListActivity.class);
                    houseIntent.putExtra("fkBi", this.mBuildingInfoEntity.getPkBi());
                    startActivityForResult(houseIntent, 2002);
                    return;
                }
            case R.id.iv_card_photo:
                CaptureActivity.tengineID = TengineID.TIDCARD2;
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                intent.putExtra("engine", this.mEngineDemo);
                startActivityForResult(intent, 0);
                return;
            case R.id.tv_edit_photo:
                setOnlinePhoto(false);
                return;
            case R.id.typeOneProjectSimpleTextViewField:
                showPersonTypes();
                return;
            default:
                return;
        }
    }

    public void localSaveInfo() {
        OneProjectDao.getInstance().getDaoSession().runInTx(new Runnable() {
            public void run() {
                Long buildingID = CollectionPersonFragment.this.saveBuilding();
                try {
                    CollectionPersonFragment.this.mComparisonFragment.save(CollectionPersonFragment.this.savePersonInfo(buildingID, CollectionPersonFragment.this.saveHouseInfo(buildingID.longValue())).longValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void showComparison(String filePath, int count) {
        FragmentManager manager = getFragmentManager();
        Long id = null;
        if (this.commonSaveInfo != null) {
            id = this.commonSaveInfo.getId();
        }
        this.mComparisonFragment = ComparisonFragment.newInstance(id, count, filePath, getEditable());
        if (manager != null) {
            manager.beginTransaction().replace(R.id.fl_check_person_container, this.mComparisonFragment).commit();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (resultCode == -1) {
                if (requestCode == 10000) {
                    this.mReportPicture.setSelectedPhotoList(data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT));
                    return;
                } else if (requestCode == 1002) {
                    this.mHouseInfoEntity = (HouseInfoEntity) data.getSerializableExtra("house");
                    this.mBuildingInfoEntity = (BuildingInfoEntity) data.getSerializableExtra(HomeInfoFragment.ARG_BUILDING);
                    String buidingImgs = data.getStringExtra("item_list");
                    if (!TextUtils.isEmpty(buidingImgs)) {
                        this.mBuildingUploadImgs = FecUtil.getStringItems(buidingImgs);
                    } else if (this.mBuildingUploadImgs != null) {
                        this.mBuildingUploadImgs.clear();
                    }
                    if (this.mHouseInfoEntity != null) {
                        showHouseInfo();
                    }
                } else if (requestCode == 2001) {
                    this.mBuildingInfoEntity = (BuildingInfoEntity) data.getSerializableExtra("peer_bean");
                    showBuildingInfo();
                    makeBuildingModifyType();
                } else if (requestCode == 2002) {
                    this.mHouseInfoEntity = (HouseInfoEntity) data.getSerializableExtra("peer_bean");
                    showHouseInfo();
                }
            }
            if (resultCode == CaptureActivity.RESULT_SCAN_IDCAD_OK) {
                CardInfo cardInfo = (CardInfo) data.getSerializableExtra("cardinfo");
                if (cardInfo.GetError() != null) {
                    ToastUtil.showToast("error=" + cardInfo.GetError());
                    return;
                }
                String card = cardInfo.getFieldString(TFieldID.NUM);
                if (TextUtils.isEmpty(card)) {
                    ToastUtil.showToast("请扫描身份证反面，获取身份号码");
                    return;
                }
                this.nameOneProjectSimpleEditTextFieldView.setText(cardInfo.getFieldString(TFieldID.NAME));
                this.mCardMaterialEditText.setText(card);
                this.addressOneProjectSimpleEditTextFieldView.setText(cardInfo.getFieldString(TFieldID.ADDRESS));
                this.nationOneProjectSimpleEditTextFieldView.setText(cardInfo.getFieldString(TFieldID.FOLK));
                try {
                    getInfoByIdCard(card);
                } catch (RetrofitUrlNullException e) {
                    FecUtil.showUrlIsNullToast(IMSDroid.getContext());
                }
            }
        }
    }

    public void onDestroy() {
        this.mEngineDemo.TR_ClearUP();
        ButterKnife.unbind(this);
        super.onDestroy();
    }

    void getInfoByIdCard(String idcard) throws RetrofitUrlNullException {
        this.mWaitingDialog.setCancelable(true);
        this.mWaitingDialog.show("正在查询人员信息");
        if (AttendanceService.getBaseUrl() != null) {
            AttendanceService.getApi().getInfosByIdCard(idcard).enqueue(new OneProjectCallback<MapReportInfoResponse>(this) {
                public void onResponse(MapReportInfoResponse bean) {
                    if (bean.getRes() != null) {
                        CollectionPersonFragment.this.mReportInfo = bean.getRes();
                        Message msg = new Message();
                        msg.what = 1000;
                        CollectionPersonFragment.this.mHandler.sendMessage(msg);
                    }
                }

                public void onFailed(String errorMessage) {
                    CollectionPersonFragment.this.reportFailAction(errorMessage);
                }
            });
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void submitWithUploadPhoto(ScrollView scrollView) {
        String error = checkAction(scrollView);
        if (TextUtils.isEmpty(error)) {
            this.mWaitingDialog.show((int) R.string.compressing_images);
            SelectPhotoView.compressUploadFile(getActivity(), new CompressUploadFile() {
                public List<PhotoCompress> onStart() {
                    int i;
                    PhotoCompress photoCompress;
                    String keyPre;
                    String photo;
                    List<PhotoCompress> uploadPhotoCompress = new ArrayList();
                    if (!CollectionPersonFragment.this.mOnlinePhoto) {
                        for (i = 0; i < CollectionPersonFragment.this.mReportPicture.getSelectedPhotoList().size(); i++) {
                            photoCompress = new PhotoCompress();
                            keyPre = "personInfoEntity_photo";
                            photo = (String) CollectionPersonFragment.this.mReportPicture.getSelectedPhotoList().get(i);
                            if (!TextUtils.isEmpty(photo)) {
                                photoCompress.setKey(keyPre + "\"; filename=\"");
                                photoCompress.setPath(photo);
                                uploadPhotoCompress.add(photoCompress);
                            }
                        }
                    }
                    if (CollectionPersonFragment.this.mBuildingUploadImgs.size() > 0) {
                        for (i = 0; i < CollectionPersonFragment.this.mBuildingUploadImgs.size(); i++) {
                            photoCompress = new PhotoCompress();
                            keyPre = "buildingInfoEntity_photo";
                            photo = (String) CollectionPersonFragment.this.mBuildingUploadImgs.get(i);
                            if (!TextUtils.isEmpty(photo)) {
                                photoCompress.setKey(keyPre + "\"; filename=\"");
                                photoCompress.setPath(photo);
                                uploadPhotoCompress.add(photoCompress);
                            }
                        }
                    } else if (!(CollectionPersonFragment.this.mBuildingInfoEntity == null || CollectionPersonFragment.this.mBuildingInfoEntity.getModifyType() != 0 || TextUtils.isEmpty(CollectionPersonFragment.this.mBuildingInfoEntity.getPhoto()))) {
                        photoCompress = new PhotoCompress();
                        List<String> imgs = FecUtil.getStringItems(CollectionPersonFragment.this.mBuildingInfoEntity.getPhoto());
                        for (i = 0; i < imgs.size(); i++) {
                            keyPre = "buildingInfoEntity_photo";
                            photo = (String) imgs.get(i);
                            if (!TextUtils.isEmpty(photo)) {
                                photoCompress.setKey(keyPre + "\"; filename=\"");
                                photoCompress.setPath(photo);
                                uploadPhotoCompress.add(photoCompress);
                            }
                        }
                    }
                    PhotoCompress appPicCompress = new PhotoCompress();
                    String appKeyPre = "personInfoEntity_appPic";
                    String appPhoto = CollectionPersonFragment.this.mComparisonFragment.getFilePath();
                    if (!TextUtils.isEmpty(appPhoto) && new File(appPhoto).exists()) {
                        if (!TextUtils.isEmpty(appPhoto)) {
                            appPicCompress.setKey(appKeyPre + "\"; filename=\"");
                            appPicCompress.setPath(appPhoto);
                            uploadPhotoCompress.add(appPicCompress);
                        }
                        PhotoCompress hkPicCompress = new PhotoCompress();
                        ComparisonResult result = CollectionPersonFragment.this.mComparisonFragment.getResult();
                        if (result != null) {
                            String hkKeyPre = "personInfoEntity_hkPic";
                            String hkPhoto = result.getFacePicUrl();
                            if (!TextUtils.isEmpty(hkPhoto)) {
                                hkPicCompress.setKey(hkKeyPre + "\"; filename=\"");
                                hkPicCompress.setPath(hkPhoto);
                                hkPicCompress.setName("HKCardPhoto.jpg");
                                hkPicCompress.setBase64(Boolean.valueOf(true));
                                uploadPhotoCompress.add(hkPicCompress);
                            }
                        }
                    }
                    return uploadPhotoCompress;
                }

                public void onFinish(List<PhotoCompress> uploadFileList) {
                    if (CollectionPersonFragment.this.isAdded()) {
                        CollectionPersonFragment.this.mWaitingDialog.show("正在上传");
                        CollectionPersonFragment.this.localSaveInfo();
                        CollectionPersonFragment.this.submitInfo(uploadFileList);
                    }
                }

                public void onFailed() {
                    if (CollectionPersonFragment.this.isAdded()) {
                        CollectionPersonFragment.this.reportFailAction(IMSDroid.getContext().getString(R.string.image_conversion_failed));
                    }
                }
            });
            return;
        }
        ToastUtil.showToast(error);
    }

    private void handleMessage(Message msg) {
        switch (msg.what) {
            case 100:
                this.locationOneProjectSimpleEditTextFieldView.setText(this.mLocationString);
                return;
            case 1000:
                this.mWaitingDialog.dismiss();
                if (this.mReportInfo != null) {
                    this.mHouseInfoEntity = this.mReportInfo.getHouseInfoEntity();
                    this.mBuildingInfoEntity = this.mReportInfo.getBuildingInfoEntity();
                    makeBuildingModifyType();
                } else {
                    this.mHouseInfoEntity = null;
                    this.mBuildingInfoEntity = null;
                }
                showBuildingInfo();
                showHouseInfo();
                showPersonInfo();
                return;
            default:
                return;
        }
    }

    private void makeBuildingModifyType() {
        if (this.mBuildingInfoEntity != null) {
            this.mBuildingInfoEntity.setModifyType(0);
            if (!TextUtils.isEmpty(this.mBuildingInfoEntity.getPkBi()) && !TextUtils.isEmpty(this.mBuildingInfoEntity.getPhoto()) && FecUtil.getStringItems(this.mBuildingInfoEntity.getPhoto()).size() > 0) {
                this.mBuildingInfoEntity.setModifyType(1);
            }
        }
    }

    public String checkAction(ScrollView scrollView) {
        Map checkMaterialEditText = new HashMap();
        checkMaterialEditText.put(this.mOtherTypeEt, DefaultMaterialEditTextCheckNone.newInstance(this.typeOneProjectSimpleTextFieldView.isRequired().booleanValue()));
        return CheckUtils.check(scrollView, checkMaterialEditText);
    }

    private void submitInfo(List<PhotoCompress> uploadPhotoCompress) {
        try {
            makePersonInfo();
            if (this.commonSaveInfo == null) {
                localSaveInfo();
            }
            Map<String, RequestBody> params = new HashMap();
            Gson gson = new Gson();
            XMPPConfiguration mXmppConfig = new XMPPConfiguration(IMSDroid.getContext());
            String userName = mXmppConfig.getString(com.hbfec.xjoneinformation.Utils.Constants.XMPP_USERNAME, "");
            String organizationId = mXmppConfig.getString(com.hbfec.xjoneinformation.Utils.Constants.UUM_USER_ORGANIZATION_ID, "");
            if (this.mBuildingInfoEntity != null) {
                if (TextUtils.isEmpty(this.mBuildingInfoEntity.getPkBi())) {
                    this.mBuildingInfoEntity.setAddUser(userName);
                    this.mBuildingInfoEntity.setUserOrganizationId(organizationId);
                } else {
                    if (!TextUtils.isEmpty(this.mBuildingInfoEntity.getAddTime())) {
                        this.mBuildingInfoEntity.setAddTime(DateUtil.friendlyTime(this.mBuildingInfoEntity.getAddTime()));
                    }
                    this.mBuildingInfoEntity.setModifier(userName);
                    this.mBuildingInfoEntity.setModifyTime(null);
                }
            }
            if (this.mHouseInfoEntity != null) {
                if (TextUtils.isEmpty(this.mHouseInfoEntity.getId())) {
                    this.mHouseInfoEntity.setAddUser(userName);
                    this.mHouseInfoEntity.setUserorganizationId(organizationId);
                } else {
                    if (!TextUtils.isEmpty(this.mHouseInfoEntity.getAddTime())) {
                        this.mHouseInfoEntity.setAddTime(DateUtil.friendlyTime(this.mHouseInfoEntity.getAddTime()));
                    }
                    this.mHouseInfoEntity.setModifyTime(null);
                    this.mHouseInfoEntity.setModifier(userName);
                }
            }
            if (this.mOnlinePhoto) {
                if (this.mReportInfo != null && this.mReportInfo.getPersonInfoEntity() != null) {
                    this.mPersonInfoEntity.setPhoto(this.mReportInfo.getPersonInfoEntity().getPhoto());
                } else if (this.mPersonInfoEntity != null) {
                    this.mPersonInfoEntity.setPhoto(this.mPersonInfoEntity.getPhoto());
                }
            }
            String personStr = gson.toJson(this.mPersonInfoEntity);
            String houseStr = gson.toJson(this.mHouseInfoEntity);
            String buildingStr = gson.toJson(this.mBuildingInfoEntity);
            params.put("houseInfoEntity", RequestBody.create(null, houseStr));
            params.put("buildingInfoEntity", RequestBody.create(null, buildingStr));
            params.put("personInfoEntity", RequestBody.create(null, personStr));
            for (PhotoCompress photoCompress : uploadPhotoCompress) {
                params.put(photoCompress.getKey() + photoCompress.getName(), RequestBody.create(MediaType.parse("image/jpeg"), new File(photoCompress.getPath())));
            }
            AttendanceService.getApi().submitPersonInfos(params).enqueue(new OneProjectCallback<ReportResultResponse>(this) {
                public void onResponse(ReportResultResponse bean) {
                    CollectionPersonFragment.this.mWaitingDialog.dismiss();
                    if (bean == null) {
                        return;
                    }
                    if ("0".equals(bean.getFlag())) {
                        String res = bean.getRes();
                        ToastUtil.showToast("采集成功");
                        if (CollectionPersonFragment.this.isAdded() && CollectionPersonFragment.this.getActivity() != null) {
                            if (TextUtils.isEmpty(res)) {
                                CollectionPersonFragment.this.getActivity().finish();
                                return;
                            }
                            if (CollectionPersonFragment.this.commonSaveInfo != null) {
                                CommonLocalSaveHelper.updateCommonSaveToUploaded(CollectionPersonFragment.this.commonSaveInfo);
                            }
                            CollectionPersonFragment.this.getActivity().setResult(-1, new Intent());
                            CollectionPersonFragment.this.getActivity().finish();
                            return;
                        }
                        return;
                    }
                    ToastUtil.showToast("上传失败");
                }

                public void onFailed(String errorMessage) {
                    super.onFailed(errorMessage);
                    CollectionPersonFragment.this.mWaitingDialog.dismiss();
                }
            });
            this.mWaitingDialog.dismiss();
        } catch (RetrofitUrlNullException e) {
            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
            this.mWaitingDialog.dismiss();
        } catch (Throwable th) {
            this.mWaitingDialog.dismiss();
        }
    }

    private void makePersonInfo() {
        if (this.mPersonInfoEntity == null) {
            this.mPersonInfoEntity = new PersonInfoEntity();
        }
        XMPPConfiguration mXmppConfig = new XMPPConfiguration(IMSDroid.getContext());
        String userName = mXmppConfig.getString(com.hbfec.xjoneinformation.Utils.Constants.XMPP_USERNAME, "");
        String organizationId = mXmppConfig.getString(com.hbfec.xjoneinformation.Utils.Constants.UUM_USER_ORGANIZATION_ID, "");
        this.mPersonInfoEntity.setAddUser(userName);
        this.mPersonInfoEntity.setUserorganizationId(organizationId);
        this.mPersonInfoEntity.setName(this.nameOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setIdCard(this.mCardMaterialEditText.getText().toString());
        this.mPersonInfoEntity.setHomeAddress(this.addressOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setNation(this.nationOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setPhoneNumber(this.phoneOneProjectMultiEditTextFieldView.getText());
        this.mPersonInfoEntity.setCarNumber(this.carOneProjectMultiEditTextFieldView.getText());
        this.mPersonInfoEntity.setProfession(this.professionOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setEducation(this.educationOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setPoliticsStatus(this.politicalOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setReligionAtmosphere(this.religiousOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setStature(this.heightOneProjectSimpleSpinnerFieldView.getContentText());
        this.mPersonInfoEntity.setBloodType(this.bloodOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setReligion(this.religionNameOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setRelationWithHousehold(this.relationOneProjectSimpleSpinnerFieldView.getSelection());
        if (!TextUtils.isEmpty(this.religionNameOneProjectSimpleSpinnerFieldView.getOtherText())) {
            this.mPersonInfoEntity.setReligionother(this.religionNameOneProjectSimpleSpinnerFieldView.getOtherText());
        }
        this.mPersonInfoEntity.setPoliticsstatusother(this.politicalOneProjectSimpleSpinnerFieldView.getOtherText());
        if (!TextUtils.isEmpty(this.relationOneProjectSimpleSpinnerFieldView.getOtherText())) {
            this.mPersonInfoEntity.setRelationother(this.relationOneProjectSimpleSpinnerFieldView.getOtherText());
        }
        if (this.mPersonTypeOverseaLayout.getVisibility() == 0) {
            this.mPersonInfoEntity.setIdType(this.passportTypeOneProjectSimpleSpinnerFieldView.getSelection());
            this.mPersonInfoEntity.setIdNo(this.passportNumberOneProjectSimpleEditTextFieldView.getText());
            this.mPersonInfoEntity.setDestCtry(this.destinationCountryOneProjectSimpleEditTextFieldView.getText());
            this.mPersonInfoEntity.setExitTime(this.exitTimeOneProjectSimpleTextFieldView.getText().replace(CHAR_YEAR, Constants.ACCEPT_TIME_SEPARATOR_SERVER).replace(CHAR_MONTH, Constants.ACCEPT_TIME_SEPARATOR_SERVER).replace(CHAR_DAY, "") + " 00:00:00");
            this.mPersonInfoEntity.setLeaveReason(this.exitReasonOneProjectSimpleSpinnerFieldView.getSelection());
            if (!TextUtils.isEmpty(this.exitReasonOneProjectSimpleSpinnerFieldView.getOtherText())) {
                this.mPersonInfoEntity.setOtherReason(this.exitReasonOneProjectSimpleSpinnerFieldView.getOtherText());
            }
        }
        this.mPersonInfoEntity.setLatitude(Double.valueOf(this.mLatitude));
        this.mPersonInfoEntity.setLongitude(Double.valueOf(this.mLongitude));
        this.mPersonInfoEntity.setLocationDescription(this.mLocationString);
        this.mPersonInfoEntity.setPersonDescription(this.descriptionOneProjectSimpleEditTextFieldView.getText());
        if (this.mPersonInfoEntity.getId() == null) {
            this.mPersonInfoEntity.setPhoto(null);
        }
        this.mPersonInfoEntity.setInfoCollectionType(Integer.valueOf(this.mCollectionTheme));
        this.mPersonInfoEntity.setIsConsistency(Integer.valueOf(this.personCardMatchOneProjectSimpleSpinnerFieldView.getSelection().intValue() - 1));
        this.mPersonInfoEntity.setToCensus(this.addressHomeOneProjectSimpleEditTextFieldView.getText());
        if (this.changeIdentityOneProjectSimpleSpinnerFieldView.getVisibility() == 0) {
            this.mPersonInfoEntity.setIsChangeIdin(this.changeIdentityOneProjectSimpleSpinnerFieldView.getSelection() + "");
        }
        if (this.mChangeIdLayout.getVisibility() == 0) {
            this.mPersonInfoEntity.setNewName(this.nameNowOneProjectSimpleEditTextFieldView.getText());
            this.mPersonInfoEntity.setNewIdCard(this.cardNowOneProjectSimpleEditTextFieldView.getText());
            this.mPersonInfoEntity.setNewNation(this.nationNowOneProjectSimpleEditTextFieldView.getText());
            this.mPersonInfoEntity.setNewCensus(this.addressNowOneProjectSimpleEditTextFieldView.getText());
        }
        if (this.JiaoPeiLayout.getVisibility() == 0) {
            this.mPersonInfoEntity.setAsylumEducateReason(this.jiaopeiReasonOneProjectSimpleEditTextFieldView.getText());
            this.mPersonInfoEntity.setAction(this.jiaopeiActionOneProjectSimpleEditTextFieldView.getText());
        }
        this.mPersonInfoEntity.setPassport(this.passportOneProjectSimpleEditTextFieldView.getText());
        String personType = personTypeIndexString();
        if (!TextUtils.isEmpty(personType)) {
            this.mPersonInfoEntity.setPersonType(personType);
        }
        if (this.mOtherTypeEt.getVisibility() == 0) {
            this.mPersonInfoEntity.setPersonTypeOtherDesc(this.mOtherTypeEt.getText().toString());
        }
        ComparisonResult result = this.mComparisonFragment.getResult();
        this.mPersonInfoEntity.setCount(Integer.valueOf(this.mComparisonFragment.getHiklfInterfaceCount()));
        if (result != null) {
            this.mPersonInfoEntity.setAppPic(this.mComparisonFragment.getFilePath());
            this.mPersonInfoEntity.setHkPic(result.getFacePicUrl());
            this.mPersonInfoEntity.setHkSimilarity(Double.valueOf(result.getSimilarity()));
            this.mPersonInfoEntity.setHkName(result.getHumanName());
            this.mPersonInfoEntity.setHkIdcard(result.getCredentialsNum());
            this.mPersonInfoEntity.setHkAction(result.getDisposalmeasures());
        }
    }

    private Long saveBuilding() {
        if (this.mBuildingInfoEntity == null) {
            return Long.valueOf(-1);
        }
        BuildingInfo buildingInfo = new BuildingInfo();
        String serviceID = this.mBuildingInfoEntity.getPkBi();
        if (!TextUtils.isEmpty(serviceID)) {
            buildingInfo = (BuildingInfo) OneProjectDao.getInstance().getDaoSession().getBuildingInfoDao().queryBuilder().where(Properties.Service_id.eq(serviceID), new WhereCondition[0]).build().unique();
            if (buildingInfo == null) {
                buildingInfo = new BuildingInfo();
                buildingInfo.setService_id(serviceID);
            }
        }
        buildingInfo.setVillage_id(this.mBuildingInfoEntity.getVillageCode());
        buildingInfo.setVillage_name(this.mBuildingInfoEntity.getVillage());
        buildingInfo.setAddress(this.mBuildingInfoEntity.getAddress());
        buildingInfo.setPurpose(Integer.valueOf(this.mBuildingInfoEntity.getUse()));
        buildingInfo.setPhoto(this.mBuildingInfoEntity.getPhoto());
        buildingInfo.setLongitude(this.mBuildingInfoEntity.getLongitude());
        buildingInfo.setLatitude(this.mBuildingInfoEntity.getLatitude());
        if (this.mBuildingInfoEntity.getModifyType() != 0) {
            buildingInfo.setModify_type(Integer.valueOf(this.mBuildingInfoEntity.getModifyType()));
        } else {
            buildingInfo.setModify_type(Integer.valueOf(0));
        }
        return Long.valueOf(OneProjectDao.getInstance().getDaoSession().getBuildingInfoDao().insertOrReplace(buildingInfo));
    }

    private Long saveHouseInfo(long buildingID) {
        if (this.mHouseInfoEntity == null) {
            return Long.valueOf(-1);
        }
        HouseInfo houseInfo = new HouseInfo();
        String serviceID = this.mHouseInfoEntity.getId();
        if (!TextUtils.isEmpty(serviceID)) {
            houseInfo = (HouseInfo) OneProjectDao.getInstance().getDaoSession().getHouseInfoDao().queryBuilder().where(HouseInfoDao.Properties.Service_id.eq(serviceID), new WhereCondition[0]).build().unique();
            if (houseInfo == null) {
                houseInfo = new HouseInfo();
                houseInfo.setService_id(serviceID);
            }
        }
        houseInfo.setBuilding_id(Long.valueOf(buildingID));
        houseInfo.setNum(this.mHouseInfoEntity.getHouseNumber());
        houseInfo.setElectricity_meter(this.mHouseInfoEntity.getElectricNumber());
        houseInfo.setGas_meter(this.mHouseInfoEntity.getGasNumber());
        houseInfo.setWater_meter(this.mHouseInfoEntity.getWaterNumber());
        return Long.valueOf(OneProjectDao.getInstance().getDaoSession().getHouseInfoDao().insertOrReplace(houseInfo));
    }

    private Long savePersonInfo(Long buildingID, Long houseID) throws JSONException {
        int modifyType;
        if (this.mPersonInfoEntity == null) {
            this.mPersonInfoEntity = new PersonInfoEntity();
        }
        this.mPersonInfoEntity.setInfoCollectionType(Integer.valueOf(this.mCollectionTheme));
        this.mPersonInfoEntity.setName(this.nameOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setIdCard(this.mCardMaterialEditText.getText().toString());
        this.mPersonInfoEntity.setAddress(this.addressOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setPersonType(personTypeIndexString());
        if (this.mOtherTypeEt.getVisibility() == 0) {
            this.mPersonInfoEntity.setPersonTypeOtherDesc(this.mOtherTypeEt.getText().toString());
        }
        if (this.mOnlinePhoto) {
            modifyType = 1;
            if (!(this.mReportInfo == null || this.mReportInfo.getPersonInfoEntity() == null)) {
                this.mPersonInfoEntity.setPhoto(this.mReportInfo.getPersonInfoEntity().getPhoto());
            }
        } else {
            modifyType = 0;
            this.mPersonInfoEntity.setPhoto(FecUtil.listToString(this.mReportPicture.getSelectedPhotoList(), ','));
        }
        this.mPersonInfoEntity.setPhoneNumber(this.phoneOneProjectMultiEditTextFieldView.getText());
        this.mPersonInfoEntity.setCarNumber(this.carOneProjectMultiEditTextFieldView.getText());
        this.mPersonInfoEntity.setProfession(this.professionOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setEducation(this.educationOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setReligionAtmosphere(this.religiousOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setReligion(this.religionNameOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setPoliticsStatus(this.politicalOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setStature(this.heightOneProjectSimpleSpinnerFieldView.getContentText());
        this.mPersonInfoEntity.setNation(this.nationOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setBloodType(this.bloodOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setRelationWithHousehold(this.relationOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setIdType(this.passportTypeOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setIdNo(this.passportNumberOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setDestCtry(this.destinationCountryOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setLeaveReason(this.exitReasonOneProjectSimpleSpinnerFieldView.getSelection());
        this.mPersonInfoEntity.setExitTime(this.exitTimeOneProjectSimpleTextFieldView.getText());
        this.mPersonInfoEntity.setOtherReason(this.exitReasonOneProjectSimpleSpinnerFieldView.getOtherText());
        if (!TextUtils.isEmpty(this.religionNameOneProjectSimpleSpinnerFieldView.getOtherText())) {
            this.mPersonInfoEntity.setReligionother(this.religionNameOneProjectSimpleSpinnerFieldView.getOtherText());
        }
        this.mPersonInfoEntity.setPoliticsstatusother(this.politicalOneProjectSimpleSpinnerFieldView.getOtherText());
        if (!TextUtils.isEmpty(this.relationOneProjectSimpleSpinnerFieldView.getOtherText())) {
            this.mPersonInfoEntity.setRelationother(this.relationOneProjectSimpleSpinnerFieldView.getOtherText());
        }
        this.mPersonInfoEntity.setIsConsistency(Integer.valueOf(this.personCardMatchOneProjectSimpleSpinnerFieldView.getSelection().intValue() - 1));
        this.mPersonInfoEntity.setPassport(this.passportOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setToCensus(this.addressHomeOneProjectSimpleEditTextFieldView.getText());
        if (this.changeIdentityOneProjectSimpleSpinnerFieldView.getVisibility() == 0) {
            this.mPersonInfoEntity.setIsChangeIdin(String.valueOf(this.changeIdentityOneProjectSimpleSpinnerFieldView.getSelection()));
        }
        if (this.mChangeIdLayout.getVisibility() == 0) {
            this.mPersonInfoEntity.setNewCensus(this.addressNowOneProjectSimpleEditTextFieldView.getText());
            this.mPersonInfoEntity.setNewNation(this.nationNowOneProjectSimpleEditTextFieldView.getText());
            this.mPersonInfoEntity.setNewIdCard(this.cardNowOneProjectSimpleEditTextFieldView.getText());
            this.mPersonInfoEntity.setNewName(this.nameNowOneProjectSimpleEditTextFieldView.getText());
        }
        this.mPersonInfoEntity.setPersonDescription(this.descriptionOneProjectSimpleEditTextFieldView.getText());
        this.mPersonInfoEntity.setLocationDescription(this.locationOneProjectSimpleEditTextFieldView.getText());
        if (this.JiaoPeiLayout.getVisibility() == 0) {
            this.mPersonInfoEntity.setAsylumEducateReason(this.jiaopeiReasonOneProjectSimpleEditTextFieldView.getText());
            this.mPersonInfoEntity.setAction(this.jiaopeiActionOneProjectSimpleEditTextFieldView.getText());
        }
        this.mPersonInfoEntity.setAppPic(this.mComparisonFragment.getFilePath());
        this.mPersonInfoEntity.setCount(Integer.valueOf(this.mComparisonFragment.getHiklfInterfaceCount()));
        this.mPersonInfoEntity.setAddUser(new XMPPConfiguration(IMSDroid.getContext()).getString(com.hbfec.xjoneinformation.Utils.Constants.XMPP_USERNAME, ConnectionUtils.getLoginName()));
        JSONObject object = new JSONObject();
        Gson gson = new Gson();
        object.put("building_id", buildingID);
        object.put("house_id", houseID);
        object.put("modify_type", modifyType);
        object.put("theme", this.mCollectionTheme);
        object.put("entity", gson.toJson(this.mPersonInfoEntity));
        this.commonSaveInfo = CommonLocalSaveHelper.save(this.commonSaveInfo, 1006, null, object.toString());
        return this.commonSaveInfo.getId();
    }

    private void reportFailAction(String toastStr) {
        this.mWaitingDialog.dismiss();
        ToastUtil.showToast(toastStr);
    }

    private void showHouseInfo() {
        if (this.mHouseInfoEntity != null) {
            this.houseOneProjectMoreFieldView.setText(this.mHouseInfoEntity.getHouseNumber());
        } else {
            this.houseOneProjectMoreFieldView.setText("");
        }
    }

    private void showBuildingInfo() {
        if (this.mBuildingInfoEntity != null) {
            this.buildingOneProjectMoreFieldView.setText(this.mBuildingInfoEntity.getAddress());
        } else {
            this.buildingOneProjectMoreFieldView.setText("");
        }
    }

    private void showPersonInfo() {
        if (this.mReportInfo == null) {
            setOnlinePhoto(false);
            return;
        }
        PersonInfoEntity personInfo = this.mReportInfo.getPersonInfoEntity();
        if (personInfo != null) {
            if (!TextUtils.isEmpty(personInfo.getToCensus())) {
                this.addressOneProjectSimpleEditTextFieldView.setText(personInfo.getToCensus());
            }
            if (!TextUtils.isEmpty(personInfo.getProfession())) {
                this.professionOneProjectSimpleEditTextFieldView.setText(personInfo.getProfession());
            }
            if (!TextUtils.isEmpty(personInfo.getPassport())) {
                this.passportOneProjectSimpleEditTextFieldView.setText(personInfo.getPassport());
            }
            if (!TextUtils.isEmpty(personInfo.getCarNumber())) {
                this.carOneProjectMultiEditTextFieldView.setText(personInfo.getCarNumber());
            }
            if (!TextUtils.isEmpty(personInfo.getPersonDescription())) {
                this.descriptionOneProjectSimpleEditTextFieldView.setText(personInfo.getPersonDescription());
            }
            if (personInfo.getIsChangeIdin() != null) {
                int index = FecUtil.StringToInt(personInfo.getIsChangeIdin());
                if (index > -1) {
                    this.changeIdentityOneProjectSimpleSpinnerFieldView.setSelection(Integer.valueOf(index));
                }
                if (personInfo.getIsChangeIdin().equals("1")) {
                    this.mChangeIdLayout.setVisibility(0);
                    this.nameNowOneProjectSimpleEditTextFieldView.setText(FecUtil.noNullString(personInfo.getNewName()));
                    this.nationNowOneProjectSimpleEditTextFieldView.setText(FecUtil.noNullString(personInfo.getNewNation()));
                    this.cardNowOneProjectSimpleEditTextFieldView.setText(FecUtil.noNullString(personInfo.getNewIdCard()));
                    this.addressNowOneProjectSimpleEditTextFieldView.setText(FecUtil.noNullString(personInfo.getNewCensus()));
                }
            }
            this.heightOneProjectSimpleSpinnerFieldView.setContentText(personInfo.getStature());
            if (!TextUtils.isEmpty(personInfo.getHkPic())) {
                ComparisonResult result = new ComparisonResult();
                result.setFacePicUrl(FecUtil.noNullString(personInfo.getHkPic()));
                if (personInfo.getHkSimilarity() == null) {
                    result.setSimilarity("0.0");
                } else {
                    result.setSimilarity(FecUtil.noNullString(personInfo.getHkSimilarity() + ""));
                }
                result.setHumanName(FecUtil.noNullString(personInfo.getHkName()));
                result.setCredentialsNum(FecUtil.noNullString(personInfo.getHkIdcard()));
                result.setDisposalmeasures(FecUtil.noNullString(personInfo.getHkAction()));
                if (this.mComparisonFragment != null) {
                    this.mComparisonFragment.showComparisonResult(result, FecUtil.noNullString(personInfo.getAppPic()));
                }
            }
            if (!TextUtils.isEmpty(personInfo.getName())) {
                this.nameOneProjectSimpleEditTextFieldView.setText(personInfo.getName());
            }
            if (!TextUtils.isEmpty(personInfo.getIdCard())) {
                this.mCardMaterialEditText.setText(personInfo.getIdCard());
            }
            if (!TextUtils.isEmpty(personInfo.getNation())) {
                this.nationOneProjectSimpleEditTextFieldView.setText(personInfo.getNation());
            }
            if (!TextUtils.isEmpty(personInfo.getHomeAddress())) {
                this.addressHomeOneProjectSimpleEditTextFieldView.setText(personInfo.getHomeAddress());
            }
            if (TextUtils.isEmpty(personInfo.getPhoto()) || TextUtils.isEmpty(personInfo.getId())) {
                setOnlinePhoto(false);
            } else {
                ArrayList<String> photos = FecUtil.getStringItems(personInfo.getPhoto());
                if (photos.size() > 0) {
                    setOnlinePhoto(true);
                    List temp = new ArrayList();
                    Iterator it = photos.iterator();
                    while (it.hasNext()) {
                        temp.add(AttendanceService.getBaseUrl() + ((String) it.next()));
                    }
                    this.mReportPicture.setSelectedPhotoList(temp);
                } else {
                    setOnlinePhoto(false);
                }
            }
            if (personInfo.getPhoneNumber() != null) {
                this.phoneOneProjectMultiEditTextFieldView.setText(personInfo.getPhoneNumber());
            }
            if (personInfo.getCarNumber() != null) {
                this.carOneProjectMultiEditTextFieldView.setText(personInfo.getCarNumber());
            }
            this.professionOneProjectSimpleEditTextFieldView.setText(personInfo.getProfession());
            this.descriptionOneProjectSimpleEditTextFieldView.setText(personInfo.getPersonDescription());
            if (personInfo.getEducation() != null) {
                this.educationOneProjectSimpleSpinnerFieldView.setSelection(personInfo.getEducation());
            }
            if (personInfo.getReligionAtmosphere() != null) {
                this.religiousOneProjectSimpleSpinnerFieldView.setSelection(personInfo.getReligionAtmosphere());
            }
            if (personInfo.getReligion() != null) {
                this.religionNameOneProjectSimpleSpinnerFieldView.setSelection(personInfo.getReligion());
            }
            if (!TextUtils.isEmpty(personInfo.getReligionother())) {
                this.religionNameOneProjectSimpleSpinnerFieldView.setOtherText(personInfo.getReligionother());
            }
            this.politicalOneProjectSimpleSpinnerFieldView.setSelection(personInfo.getPoliticsStatus());
            this.politicalOneProjectSimpleSpinnerFieldView.setOtherText(personInfo.getPoliticsstatusother());
            if (personInfo.getIsConsistency() != null) {
                this.personCardMatchOneProjectSimpleSpinnerFieldView.setSelection(Integer.valueOf(personInfo.getIsConsistency().intValue() + 1));
            }
            if (personInfo.getBloodType() != null) {
                this.bloodOneProjectSimpleSpinnerFieldView.setSelection(personInfo.getBloodType());
            }
            if (personInfo.getRelationWithHousehold() != null) {
                this.relationOneProjectSimpleSpinnerFieldView.setSelection(personInfo.getRelationWithHousehold());
            }
            if (!TextUtils.isEmpty(personInfo.getRelationother())) {
                this.relationOneProjectSimpleSpinnerFieldView.setOtherText(personInfo.getRelationother());
            }
            if (!TextUtils.isEmpty(personInfo.getPersonType())) {
                String[] types = personInfo.getPersonType().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (types.length == 0) {
                    this.typeOneProjectSimpleTextFieldView.setText(null);
                } else {
                    this.mPersonTypeIndexList = new ArrayList();
                    for (String type : types) {
                        this.mPersonTypeIndexList.add(Integer.valueOf(FecUtil.StringToInt(type)));
                    }
                    this.typeOneProjectSimpleTextFieldView.setText(SpinnerItem.getCollectionPersonTypeNameByID(this.mPersonTypeIndexList));
                    if (this.mPersonTypeIndexList.contains(Integer.valueOf(MultiImageSelectorActivity.REQUEST_PREVIEW))) {
                        this.mOtherTypeEt.setVisibility(0);
                        this.mOtherTypeEt.setText(personInfo.getPersonTypeOtherDesc());
                    } else {
                        this.mOtherTypeEt.setVisibility(8);
                    }
                    if (this.mPersonTypeIndexList.contains(Integer.valueOf(21))) {
                        this.mPersonTypeOverseaLayout.setVisibility(0);
                        if (personInfo.getIdType() != null) {
                            this.passportTypeOneProjectSimpleSpinnerFieldView.setSelection(personInfo.getIdType());
                        }
                        this.passportNumberOneProjectSimpleEditTextFieldView.setText(personInfo.getIdNo());
                        this.destinationCountryOneProjectSimpleEditTextFieldView.setText(personInfo.getDestCtry());
                        if (personInfo.getExitTime() != null) {
                            this.exitTimeOneProjectSimpleTextFieldView.setText(DateUtil.birthDayTime(personInfo.getExitTime()));
                        }
                        if (personInfo.getLeaveReason() != null) {
                            this.exitReasonOneProjectSimpleSpinnerFieldView.setSelection(personInfo.getLeaveReason());
                        }
                        this.exitReasonOneProjectSimpleSpinnerFieldView.setOtherText(personInfo.getOtherReason());
                    } else {
                        this.mPersonTypeOverseaLayout.setVisibility(8);
                    }
                }
            }
            if (this.JiaoPeiLayout.getVisibility() == 0) {
                this.jiaopeiReasonOneProjectSimpleEditTextFieldView.setText(personInfo.getAsylumEducateReason());
                this.jiaopeiActionOneProjectSimpleEditTextFieldView.setText(personInfo.getAction());
                return;
            }
            return;
        }
        this.mOnlinePhoto = false;
    }

    public void onNewIntent(Intent intent) {
        if ((67108864 & intent.getFlags()) != 0) {
            int type = intent.getIntExtra(TaskConstant.ARG_KEY_ID, 0);
            if (type == 1) {
                this.mBuildingInfoEntity = (BuildingInfoEntity) intent.getSerializableExtra("peer_bean");
                String buidingImgs = intent.getStringExtra("item_list");
                if (!TextUtils.isEmpty(buidingImgs)) {
                    this.mBuildingUploadImgs = FecUtil.getStringItems(buidingImgs);
                }
                showBuildingInfo();
            } else if (type == 2) {
                this.mHouseInfoEntity = (HouseInfoEntity) intent.getSerializableExtra("peer_bean");
                showHouseInfo();
            } else if (type == 3) {
                this.mBuildingInfoEntity = null;
                this.mHouseInfoEntity = null;
                showBuildingInfo();
                showHouseInfo();
            } else if (type == 4) {
                this.mHouseInfoEntity = null;
                showHouseInfo();
            }
        }
    }
}
