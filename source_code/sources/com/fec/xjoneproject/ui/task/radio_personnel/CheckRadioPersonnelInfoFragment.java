package com.fec.xjoneproject.ui.task.radio_personnel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.fec.report.dao.RadioPersonnelPeer;
import com.fec.report.dao.RadioPersonnelRespondent;
import com.fec.report.dao.RadioPersonnelRespondentDao.Properties;
import com.fec.xjoneproject.dao.OneProjectDao;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.http.response.ReportResult;
import com.fec.xjoneproject.privilege.service.GetPrivilegeService;
import com.fec.xjoneproject.ui.WaitingDialogBaseFragment;
import com.fec.xjoneproject.ui.map.MapRadioPersonnelResponse;
import com.fec.xjoneproject.ui.supervise.TasksListFragment;
import com.fec.xjoneproject.ui.task.FeedBackBaseFragment;
import com.fec.xjoneproject.ui.task.ImageActivity;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.task.bean.MatchPerWarnEntity;
import com.fec.xjoneproject.ui.task.radio_personnel.PeerPersonnelListFragment.PeerItem;
import com.fec.xjoneproject.ui.view.field.OneProjectMoreFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleDateSelectFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleEditTextFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleRadioGroupWithTwoButtonFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleRadioGroupWithTwoButtonFieldView.OnCheckedChangeListener;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleSpinnerFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleTextFieldView;
import com.fec.xjoneproject.ui.view.field.multiEditText.OneProjectMultiEditTextFieldView;
import com.fec.xjoneproject.util.CheckUtils;
import com.fec.xjoneproject.util.FecUtil;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.fec.xjoneproject.util.ToastUtil;
import com.hbfec.asmack.im.comm.ConnectionUtils;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneinformation.MainTab;
import com.hbfec.xjoneinformation.Utils.Constants;
import com.hbfec.xjoneinformation.Utils.XMPPConfiguration;
import com.hbfec.xjoneproject.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.greendao.query.WhereCondition;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckRadioPersonnelInfoFragment extends FeedBackBaseFragment {
    private static final int HANDLER_FLAG = 1000;
    @Bind({2131296274})
    OneProjectSimpleTextFieldView actionOneProjectSimpleTextFieldView;
    @Bind({2131296293})
    OneProjectSimpleDateSelectFieldView activityOneProjectSimpleDateSelectFieldView;
    @Bind({2131296299})
    OneProjectSimpleTextFieldView addressOneProjectSimpleTextFieldView;
    @Bind({2131296414})
    OneProjectSimpleEditTextFieldView cardOneProjectSimpleEditTextFieldView;
    @Bind({2131296415})
    OneProjectSimpleTextFieldView cardOneProjectSimpleTextFieldView;
    @Bind({2131296566})
    OneProjectSimpleRadioGroupWithTwoButtonFieldView dubiousOneProjectSimpleRadioGroupWithTwoButtonFieldView;
    @Bind({2131297074})
    OneProjectSimpleRadioGroupWithTwoButtonFieldView leaveOneProjectSimpleRadioGroupWithTwoButtonFieldView;
    @Bind({2131297218})
    OneProjectSimpleRadioGroupWithTwoButtonFieldView localOneProjectSimpleRadioGroupWithTwoButtonFieldView;
    @Bind({2131296423})
    CheckBox mArrestCheckBox;
    private MatchPerWarnEntity mEntity;
    private Handler mHandler;
    private String mId;
    @Bind({2131297135})
    LinearLayout mImmediateArrestLinearLayout;
    @Bind({2131297136})
    LinearLayout mInfoCollectionLinearLayout;
    private List<PeerItem> mItemList = new ArrayList();
    @Bind({2131297140})
    LinearLayout mKeepCheckLinearLayout;
    private RadioPersonnelRespondent mLocalRespondent;
    private List<RadioPersonnelPeer> mPeerList = new ArrayList();
    @Bind({2131297028})
    ImageView mPhotoImageView;
    @Bind({2131297760})
    ScrollView mScrollView;
    @Bind({2131298313})
    TextView mTitleText;
    private WaitingDialogBaseFragment mWaitingDialog;
    @Bind({2131297322})
    OneProjectSimpleTextFieldView nameOneProjectSimpleTextFieldView;
    @Bind({2131297397})
    OneProjectMoreFieldView peerOneProjectMoreFieldView;
    @Bind({2131297424})
    OneProjectMultiEditTextFieldView phoneOneProjectMultiEditTextFieldView;
    @Bind({2131297500})
    OneProjectSimpleSpinnerFieldView reasonOneProjectSimpleSpinnerFieldView;
    @Bind({2131297626})
    OneProjectSimpleRadioGroupWithTwoButtonFieldView sameOneProjectSimpleRadioGroupWithTwoButtonFieldView;
    @Bind({2131298337})
    OneProjectSimpleTextFieldView typeOneProjectSimpleTextViewField;
    @Bind({2131298366})
    LinearLayout warnLinearLayout;
    @Bind({2131298367})
    OneProjectSimpleRadioGroupWithTwoButtonFieldView warningOneProjectSimpleRadioGroupWithTwoButtonFieldView;

    public static CheckRadioPersonnelInfoFragment newInstance(String id) {
        CheckRadioPersonnelInfoFragment fragment = new CheckRadioPersonnelInfoFragment();
        Bundle args = new Bundle();
        args.putString(TaskConstant.ARG_KEY_WARN_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mId = getArguments().getString(TaskConstant.ARG_KEY_WARN_ID);
        }
        this.mHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1000:
                        if (CheckRadioPersonnelInfoFragment.this.mEntity != null) {
                            CheckRadioPersonnelInfoFragment.this.setData(CheckRadioPersonnelInfoFragment.this.mEntity, CheckRadioPersonnelInfoFragment.this.mEntity.getIdCard(), null, null, null, null, null, null, null, null, null);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_check_radio_personnel_info, container, false);
        ButterKnife.bind((Object) this, rootView);
        this.mTitleText.setText(R.string.task_ratio_personnel_feedback);
        this.warnLinearLayout.setVisibility(8);
        this.warningOneProjectSimpleRadioGroupWithTwoButtonFieldView.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(Integer value) {
                if (value.equals(CheckRadioPersonnelInfoFragment.this.warningOneProjectSimpleRadioGroupWithTwoButtonFieldView.getYesValue())) {
                    CheckRadioPersonnelInfoFragment.this.warnLinearLayout.setVisibility(0);
                } else {
                    CheckRadioPersonnelInfoFragment.this.warnLinearLayout.setVisibility(8);
                }
            }
        });
        RadioPersonnelRespondent respondent = getLocalRespondentByCheckMissionID(this.mId);
        if (respondent == null) {
            getDataFromNet(this.mId);
        } else {
            this.mLocalRespondent = respondent;
            this.mPeerList = respondent.getRadioPersonnelPeerList();
            setData();
        }
        return rootView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private RadioPersonnelRespondent getLocalRespondentByCheckMissionID(String checkMissionID) {
        return (RadioPersonnelRespondent) OneProjectDao.getInstance().getDaoSession().getRadioPersonnelRespondentDao().queryBuilder().where(Properties.Task_id.like(checkMissionID), new WhereCondition[0]).build().unique();
    }

    private void getDataFromNet(String id) {
        try {
            AttendanceService.getApi().getRadioPersonDetail(id).enqueue(new OneProjectCallback<MapRadioPersonnelResponse>(this) {
                public void onResponse(MapRadioPersonnelResponse bean) {
                    List<MatchPerWarnEntity> list = bean.getRes();
                    if (list != null && list.size() != 0) {
                        CheckRadioPersonnelInfoFragment.this.mEntity = (MatchPerWarnEntity) list.get(0);
                        Message msg = new Message();
                        msg.what = 1000;
                        CheckRadioPersonnelInfoFragment.this.mHandler.sendMessage(msg);
                    }
                }
            });
        } catch (RetrofitUrlNullException e) {
            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
        }
    }

    private void setData() {
        this.mEntity = new MatchPerWarnEntity();
        this.mEntity.setId(this.mLocalRespondent.getTask_id());
        this.mEntity.setName(this.mLocalRespondent.getPush_name());
        this.mEntity.setIdCard(this.mLocalRespondent.getPush_id_number());
        this.mEntity.setHomeAddress(this.mLocalRespondent.getPush_home_address());
        this.mEntity.setIdCardPhoto(this.mLocalRespondent.getPush_photo());
        this.mEntity.setMatchType(this.mLocalRespondent.getPush_match_type());
        this.mEntity.setPeopleType(this.mLocalRespondent.getPush_people_type());
        this.mEntity.setAction(this.mLocalRespondent.getPush_action());
        this.mItemList = new ArrayList();
        for (RadioPersonnelPeer personnelPeer : this.mPeerList) {
            PeerItem item = new PeerItem();
            item.setCard(personnelPeer.getId_card());
            item.setInfo(personnelPeer.getPhone());
            item.setId(personnelPeer.getId().longValue());
            item.setName(personnelPeer.getName());
            item.setMobile(personnelPeer.getPhone2());
            this.mItemList.add(item);
        }
        setData(this.mEntity, this.mLocalRespondent.getId_number(), this.mLocalRespondent.getPhone(), this.mLocalRespondent.getWhether_warning(), this.mLocalRespondent.getWhether_consistent(), this.mLocalRespondent.getWhether_dubious(), this.mLocalRespondent.getWhether_leave(), this.mLocalRespondent.getTo_inner_land_reason(), this.mLocalRespondent.getOther_to_inner_land_reason(), this.mLocalRespondent.getReturn_date(), this.mLocalRespondent.getLeavev_local());
    }

    private void setData(MatchPerWarnEntity mEntity, String idNumber, String phone, Integer whetherWarning, Integer whetherConsistent, Integer whetherDubious, Integer whetherLeave, Integer reason, String otherReason, String returnDate, Integer localLeave) {
        this.nameOneProjectSimpleTextFieldView.setText(mEntity.getName());
        this.cardOneProjectSimpleTextFieldView.setText(mEntity.getIdCard());
        this.addressOneProjectSimpleTextFieldView.setText(mEntity.getHomeAddress());
        if (!TextUtils.isEmpty(mEntity.getIdCardPhoto())) {
            Glide.with(getActivity()).load(AttendanceService.getBaseUrl() + mEntity.getIdCardPhoto()).centerCrop().skipMemoryCache(true).placeholder((int) R.drawable.electricity_detail_photoicon).into(this.mPhotoImageView);
        }
        this.typeOneProjectSimpleTextViewField.setText(mEntity.getMatchTypeName());
        this.warningOneProjectSimpleRadioGroupWithTwoButtonFieldView.setValue(whetherWarning);
        this.actionOneProjectSimpleTextFieldView.setText(mEntity.getActionName());
        this.mInfoCollectionLinearLayout.setVisibility(8);
        this.mKeepCheckLinearLayout.setVisibility(8);
        this.mImmediateArrestLinearLayout.setVisibility(8);
        if (mEntity.getAction() != null) {
            if (mEntity.getAction().intValue() == 1) {
                this.mInfoCollectionLinearLayout.setVisibility(0);
            }
            if (mEntity.getAction().intValue() == 2) {
                this.mKeepCheckLinearLayout.setVisibility(0);
            }
            if (mEntity.getAction().intValue() == 3) {
                this.mImmediateArrestLinearLayout.setVisibility(0);
            }
        }
        if (this.mInfoCollectionLinearLayout.getVisibility() == 0) {
            this.cardOneProjectSimpleEditTextFieldView.setText(idNumber);
            this.phoneOneProjectMultiEditTextFieldView.setText(phone);
            this.sameOneProjectSimpleRadioGroupWithTwoButtonFieldView.setValue(whetherConsistent);
            this.peerOneProjectMoreFieldView.setText(this.mItemList.size() + "人");
            this.dubiousOneProjectSimpleRadioGroupWithTwoButtonFieldView.setValue(whetherDubious);
        }
        if (this.mKeepCheckLinearLayout.getVisibility() == 0) {
            this.leaveOneProjectSimpleRadioGroupWithTwoButtonFieldView.setValue(whetherLeave);
            this.reasonOneProjectSimpleSpinnerFieldView.setValue(reason);
            this.reasonOneProjectSimpleSpinnerFieldView.setOtherText(otherReason);
            this.activityOneProjectSimpleDateSelectFieldView.setText((CharSequence) returnDate);
            this.localOneProjectSimpleRadioGroupWithTwoButtonFieldView.setValue(localLeave);
        }
    }

    private JSONArray packagePeerPersonnel(List<PeerItem> itemList) throws JSONException {
        String organizationId = new XMPPConfiguration(IMSDroid.getContext()).getString(Constants.UUM_USER_ORGANIZATION_ID, "");
        JSONArray array = new JSONArray();
        for (PeerItem item : itemList) {
            JSONObject object = new JSONObject();
            object.put("name", item.getName());
            object.put("idCard", item.getCard());
            object.put("phone", item.getMobile());
            object.put("info", item.getInfo());
            object.put("addUser", ConnectionUtils.getLoginName());
            object.put("userOrganizationId", organizationId);
            array.put(object);
        }
        return array;
    }

    private String checkInput() {
        String result = CheckUtils.check(this.mScrollView);
        if (this.mImmediateArrestLinearLayout.getVisibility() == 0 && !this.mArrestCheckBox.isChecked() && TextUtils.isEmpty(result)) {
            return "请选择反馈已抓捕";
        }
        return result;
    }

    private JSONObject packageRadioPersonnelResult() throws JSONException {
        JSONObject object = new JSONObject();
        object.put("fkMp", this.mId);
        object.put("name", "");
        object.put("addUser", ConnectionUtils.getLoginName());
        XMPPConfiguration mXmppConfig = new XMPPConfiguration(IMSDroid.getContext());
        String userName = mXmppConfig.getString(Constants.UUM_USER_NAME, "");
        String organizationId = mXmppConfig.getString(Constants.UUM_USER_ORGANIZATION_ID, "");
        String organizationName = mXmppConfig.getString(Constants.UUM_USER_ORGANIZATION_NAME, "");
        object.put("userOrganizationId", organizationId);
        object.put("userIdCard", "");
        object.put("username", userName);
        object.put("userOrgName", organizationName);
        object.put("userType", new GetPrivilegeService(IMSDroid.getContext()).getString(GetPrivilegeService.PRIVILEGE, ""));
        object.put("isWarnObj", this.warningOneProjectSimpleRadioGroupWithTwoButtonFieldView.getValue());
        if (this.mEntity == null) {
            ToastUtil.showToast("未查询到预警信息");
            return null;
        }
        object.put("action", this.mEntity.getAction());
        if (this.mInfoCollectionLinearLayout.getVisibility() == 0) {
            object.put("idCard", this.cardOneProjectSimpleEditTextFieldView.getText());
            object.put("phone", this.phoneOneProjectMultiEditTextFieldView.getText());
            object.put("isMatch", this.sameOneProjectSimpleRadioGroupWithTwoButtonFieldView.getValue());
            if (this.mPeerList.size() == 0) {
                object.put("ifHavePeer", 2);
            } else {
                object.put("ifHavePeer", 1);
            }
            object.put("isDubious", this.dubiousOneProjectSimpleRadioGroupWithTwoButtonFieldView.getValue());
        }
        if (this.mKeepCheckLinearLayout.getVisibility() == 0) {
            object.put("leave", this.leaveOneProjectSimpleRadioGroupWithTwoButtonFieldView.getValue());
            object.put("toInlandRes", this.reasonOneProjectSimpleSpinnerFieldView.getValue());
            object.put("toInlandDesc", this.reasonOneProjectSimpleSpinnerFieldView.getOtherText());
            object.put("returnTime", this.activityOneProjectSimpleDateSelectFieldView.getText());
            object.put("leaveLocal", this.localOneProjectSimpleRadioGroupWithTwoButtonFieldView.getValue());
        }
        if (this.mImmediateArrestLinearLayout.getVisibility() == 0) {
            if (this.mArrestCheckBox.isChecked()) {
                object.put("arrest", 1);
            } else {
                object.put("arrest", 2);
            }
        }
        object.put("longitude", getLongitude());
        object.put("latitude", getLatitude());
        object.put("locationDescription", getLocationDescription());
        return object;
    }

    private void submitRadioPersonnelRes() {
        try {
            Map<String, String> params = new HashMap();
            String error = checkInput();
            if (TextUtils.isEmpty(error)) {
                JSONObject result = packageRadioPersonnelResult();
                if (result != null) {
                    if (this.mWaitingDialog == null) {
                        this.mWaitingDialog = new WaitingDialogBaseFragment(getActivity());
                    }
                    this.mWaitingDialog.setCancelable(false);
                    this.mWaitingDialog.show();
                    params.put("matchPerRes", result.toString());
                    params.put("matchPersonPeers", packagePeerPersonnel(this.mItemList).toString());
                    AttendanceService.getApi().submitRadioPersonnelRes(params).enqueue(new OneProjectCallback<ReportResult>(this) {
                        public void onResponse(ReportResult bean) {
                            CheckRadioPersonnelInfoFragment.this.mWaitingDialog.dismiss();
                            ToastUtil.showToast("反馈成功");
                            Intent intent = new Intent(CheckRadioPersonnelInfoFragment.this.getActivity(), MainTab.class);
                            intent.setFlags(67108864);
                            intent.putExtra(TasksListFragment.TASK_TYPE, 6);
                            CheckRadioPersonnelInfoFragment.this.startActivity(intent);
                        }

                        public void onFailed(String errorMessage) {
                            super.onFailed(errorMessage);
                            CheckRadioPersonnelInfoFragment.this.mWaitingDialog.dismiss();
                        }
                    });
                    return;
                }
                return;
            }
            ToastUtil.showToast(error);
        } catch (JSONException e) {
            ToastUtil.showToast(e.getMessage());
            this.mWaitingDialog.dismiss();
        } catch (RetrofitUrlNullException e2) {
            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
            this.mWaitingDialog.dismiss();
        }
    }

    public void localSave() {
        if (this.mLocalRespondent == null) {
            this.mLocalRespondent = new RadioPersonnelRespondent();
        }
        this.mLocalRespondent.setTask_id(this.mId);
        this.mLocalRespondent.setPush_name(this.mEntity.getName());
        this.mLocalRespondent.setPush_id_number(this.mEntity.getIdCard());
        this.mLocalRespondent.setPush_home_address(this.mEntity.getHomeAddress());
        this.mLocalRespondent.setPush_photo(this.mEntity.getIdCardPhoto());
        this.mLocalRespondent.setPush_match_type(this.mEntity.getMatchType());
        this.mLocalRespondent.setPush_people_type(this.mEntity.getPeopleType());
        this.mLocalRespondent.setId_number(this.cardOneProjectSimpleEditTextFieldView.getText());
        this.mLocalRespondent.setPhone(this.phoneOneProjectMultiEditTextFieldView.getText());
        this.mLocalRespondent.setPush_action(this.mEntity.getAction());
        this.mLocalRespondent.setWhether_warning(this.warningOneProjectSimpleRadioGroupWithTwoButtonFieldView.getValue());
        this.mLocalRespondent.setWhether_consistent(this.sameOneProjectSimpleRadioGroupWithTwoButtonFieldView.getValue());
        this.mLocalRespondent.setWhether_dubious(this.dubiousOneProjectSimpleRadioGroupWithTwoButtonFieldView.getValue());
        this.mLocalRespondent.setWhether_leave(this.leaveOneProjectSimpleRadioGroupWithTwoButtonFieldView.getValue());
        this.mLocalRespondent.setTo_inner_land_reason(this.reasonOneProjectSimpleSpinnerFieldView.getValue());
        this.mLocalRespondent.setOther_to_inner_land_reason(this.reasonOneProjectSimpleSpinnerFieldView.getOtherText());
        this.mLocalRespondent.setReturn_date(this.activityOneProjectSimpleDateSelectFieldView.getText());
        this.mLocalRespondent.setLeavev_local(this.localOneProjectSimpleRadioGroupWithTwoButtonFieldView.getValue());
        long respondentId = OneProjectDao.getInstance().getDaoSession().getRadioPersonnelRespondentDao().insertOrReplace(this.mLocalRespondent);
        OneProjectDao.getInstance().getDaoSession().getRadioPersonnelPeerDao().deleteInTx(this.mPeerList);
        List<RadioPersonnelPeer> peerList = new ArrayList();
        for (PeerItem item : this.mItemList) {
            RadioPersonnelPeer peer = new RadioPersonnelPeer();
            peer.setRadio_id(Long.valueOf(respondentId));
            peer.setName(item.getName());
            peer.setPhone(item.getInfo());
            peer.setPhone2(item.getMobile());
            peer.setId_card(item.getCard());
            if (item.getId() != -1) {
                peer.setId(Long.valueOf(item.getId()));
            }
            peerList.add(peer);
        }
        OneProjectDao.getInstance().getDaoSession().getRadioPersonnelPeerDao().insertOrReplaceInTx(peerList);
        getActivity().finish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (data.getSerializableExtra("item_list") != null) {
                this.mItemList = (ArrayList) data.getSerializableExtra("item_list");
            }
            this.peerOneProjectMoreFieldView.setText(this.mItemList.size() + "人");
        }
    }

    @OnClick({2131296888, 2131296389, 2131296382, 2131297028, 2131297397})
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_save:
                localSave();
                return;
            case R.id.btn_submit:
                submitRadioPersonnelRes();
                return;
            case R.id.ibtn_back:
                getActivity().finish();
                return;
            case R.id.iv_photo:
                if (this.mEntity == null || TextUtils.isEmpty(this.mEntity.getIdCardPhoto())) {
                    ToastUtil.showToast("当前无照片");
                    return;
                }
                intent = new Intent(getActivity(), ImageActivity.class);
                ArrayList<String> images = new ArrayList();
                images.add(AttendanceService.getBaseUrl() + this.mEntity.getIdCardPhoto());
                intent.putExtra(ImageActivity.EXTRA_IMG_TASK_PATH, images);
                intent.putExtra(ImageActivity.EXTRA_IMG_TASK_FILENAME, "");
                startActivity(intent);
                return;
            case R.id.peerOneProjectMoreFieldView:
                intent = new Intent(getActivity(), PeerPersonnelListActivity.class);
                intent.putExtra("item_list", (ArrayList) this.mItemList);
                startActivityForResult(intent, 0);
                return;
            default:
                return;
        }
    }

    public int getTaskState() {
        return 9;
    }
}
