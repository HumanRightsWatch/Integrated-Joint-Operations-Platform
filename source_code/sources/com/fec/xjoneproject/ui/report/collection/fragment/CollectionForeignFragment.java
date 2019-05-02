package com.fec.xjoneproject.ui.report.collection.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.fec.report.dao.CommonSaveInfo;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.ui.WaitingDialogBaseFragment;
import com.fec.xjoneproject.ui.report.bean.ComparisonResult;
import com.fec.xjoneproject.ui.report.bean.ReportResultResponse;
import com.fec.xjoneproject.ui.report.collection.ComparisonFragment;
import com.fec.xjoneproject.ui.report.collection.bean.PersonInfoForeignEntity;
import com.fec.xjoneproject.ui.task.CommonLocalSaveHelper;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.fec.xjoneproject.ui.view.SelectPhotoView.CompressUploadFile;
import com.fec.xjoneproject.ui.view.SelectPhotoView.PhotoCompress;
import com.fec.xjoneproject.ui.view.fieldGroup.scan.OneProjectScanViewGroup.OnFinishScan;
import com.fec.xjoneproject.util.CheckUtils;
import com.fec.xjoneproject.util.FecUtil;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.fec.xjoneproject.util.ToastUtil;
import com.google.gson.Gson;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneinformation.Utils.XMPPConfiguration;
import com.hbfec.xjoneinformation.databinding.FragmentCollectionForeignBinding;
import com.hbfec.xjoneproject.R;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

public class CollectionForeignFragment extends CollectionBaseFragment {
    private FragmentCollectionForeignBinding mBinding;
    private CommonSaveInfo mCommonSaveInfo = new CommonSaveInfo();
    private ComparisonFragment mComparisonFragment;
    private PersonInfoForeignEntity mEntity = new PersonInfoForeignEntity();
    private WaitingDialogBaseFragment mWaitingDialog;

    public static CollectionForeignFragment newInstance(CommonSaveInfo commonSaveInfo) {
        CollectionForeignFragment fragment = new CollectionForeignFragment();
        Bundle args = new Bundle();
        args.putParcelable(TaskConstant.ARG_KEY_ENTITY, commonSaveInfo);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mCommonSaveInfo = (CommonSaveInfo) getArguments().getParcelable(TaskConstant.ARG_KEY_ENTITY);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mWaitingDialog = new WaitingDialogBaseFragment();
        this.mBinding = (FragmentCollectionForeignBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_collection_foreign, container, false);
        if (this.mCommonSaveInfo != null) {
            this.mEntity = (PersonInfoForeignEntity) CommonLocalSaveHelper.getEntity(this.mCommonSaveInfo, "entity", PersonInfoForeignEntity.class);
            if (this.mEntity == null) {
                this.mEntity = new PersonInfoForeignEntity();
            } else {
                this.mComparisonFragment = ComparisonFragment.newInstance(this.mCommonSaveInfo.getId(), this.mEntity.getCount().intValue(), this.mEntity.getAppPic(), getEditable());
            }
        }
        this.mBinding.setEditable(getEditable().booleanValue());
        this.mBinding.setEntity(this.mEntity);
        if (this.mComparisonFragment == null) {
            this.mComparisonFragment = ComparisonFragment.newInstance(getEditable().booleanValue());
        }
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, this.mComparisonFragment).commit();
        }
        this.mBinding.passportOneProjectScanViewGroup.setOnFinishScan(new OnFinishScan() {
            public void finishScan(JSONObject object) {
                try {
                    CollectionForeignFragment.this.mEntity.setName(object.getString("本国姓名"));
                    String sex = object.getString("性别");
                    if (sex.equals("男")) {
                        CollectionForeignFragment.this.mEntity.setSex(Integer.valueOf(1));
                    }
                    if (sex.equals("女")) {
                        CollectionForeignFragment.this.mEntity.setSex(Integer.valueOf(0));
                    }
                    CollectionForeignFragment.this.mEntity.setCountry(object.getString("持证人国籍代码"));
                    CollectionForeignFragment.this.mEntity.setBirthDay(object.getString("出生日期"));
                    CollectionForeignFragment.this.mBinding.setEntity(CollectionForeignFragment.this.mEntity);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return this.mBinding.getRoot();
    }

    public void submitWithUploadPhoto(ScrollView scrollView) {
        String error = CheckUtils.check(scrollView, null);
        if (TextUtils.isEmpty(error)) {
            this.mWaitingDialog.show((int) R.string.compressing_images);
            SelectPhotoView.compressUploadFile(getActivity(), new CompressUploadFile() {
                public List<PhotoCompress> onStart() {
                    List<PhotoCompress> uploadPhotoCompress = new ArrayList();
                    PhotoCompress appPicCompress = new PhotoCompress();
                    String visaPhoto = CollectionForeignFragment.this.mEntity.getVisaPic();
                    if (!TextUtils.isEmpty(visaPhoto)) {
                        String visaKey = "personInfoForeignEntity_visaPic";
                        for (String photo : visaPhoto.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                            PhotoCompress photoCompress = new PhotoCompress();
                            if (!TextUtils.isEmpty(photo)) {
                                photoCompress.setKey(visaKey + "\"; filename=\"");
                                photoCompress.setPath(photo);
                                uploadPhotoCompress.add(photoCompress);
                            }
                        }
                    }
                    String appPhoto = CollectionForeignFragment.this.mComparisonFragment.getFilePath();
                    if (!TextUtils.isEmpty(appPhoto)) {
                        String appKeyPre = "personInfoForeignEntity_appPic";
                        if (new File(appPhoto).exists()) {
                            if (!TextUtils.isEmpty(appPhoto)) {
                                appPicCompress.setKey(appKeyPre + "\"; filename=\"");
                                appPicCompress.setPath(appPhoto);
                                uploadPhotoCompress.add(appPicCompress);
                            }
                            PhotoCompress hkPicCompress = new PhotoCompress();
                            ComparisonResult result = CollectionForeignFragment.this.mComparisonFragment.getResult();
                            if (result != null) {
                                String hkKeyPre = "personInfoForeignEntity_hkPic";
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
                    }
                    return uploadPhotoCompress;
                }

                public void onFinish(List<PhotoCompress> uploadFileList) {
                    CollectionForeignFragment.this.mWaitingDialog.show("正在上传");
                    CollectionForeignFragment.this.localSaveInfo();
                    CollectionForeignFragment.this.submitInfo(uploadFileList);
                }

                public void onFailed() {
                    CollectionForeignFragment.this.mWaitingDialog.dismiss();
                }
            });
            return;
        }
        ToastUtil.showToast(error);
    }

    public void localSaveInfo() {
        JSONObject object = new JSONObject();
        try {
            object.put("entity", makePersonInfo());
            object.put("theme", 7);
            this.mCommonSaveInfo = CommonLocalSaveHelper.save(this.mCommonSaveInfo, 1005, null, object.toString());
            this.mComparisonFragment.save(this.mCommonSaveInfo.getId().longValue());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String makePersonInfo() {
        XMPPConfiguration mXmppConfig = new XMPPConfiguration(IMSDroid.getContext());
        String userName = mXmppConfig.getString(com.hbfec.xjoneinformation.Utils.Constants.XMPP_USERNAME, "");
        String organizationId = mXmppConfig.getString(com.hbfec.xjoneinformation.Utils.Constants.UUM_USER_ORGANIZATION_ID, "");
        this.mEntity.setAddUser(userName);
        this.mEntity.setUserOrganizationId(organizationId);
        ComparisonResult result = this.mComparisonFragment.getResult();
        this.mEntity.setAppPic(this.mComparisonFragment.getFilePath());
        this.mEntity.setCount(Integer.valueOf(this.mComparisonFragment.getHiklfInterfaceCount()));
        if (result != null) {
            this.mEntity.setHkPic(result.getFacePicUrl());
            this.mEntity.setHkSimilarity(Double.valueOf(result.getSimilarity()));
            this.mEntity.setHkName(result.getHumanName());
            this.mEntity.setHkIdcard(result.getCredentialsNum());
            this.mEntity.setHkAction(result.getDisposalmeasures());
        }
        return new Gson().toJson(this.mEntity);
    }

    private void submitInfo(List<PhotoCompress> uploadPhotoCompress) {
        try {
            this.mWaitingDialog.show("正在上传");
            Map<String, RequestBody> params = new HashMap();
            params.put("foreignEntity", RequestBody.create(null, new Gson().toJson(this.mEntity)));
            for (PhotoCompress photoCompress : uploadPhotoCompress) {
                params.put(photoCompress.getKey() + photoCompress.getName(), RequestBody.create(MediaType.parse("image/jpeg"), new File(photoCompress.getPath())));
            }
            AttendanceService.getApi().submitForeignPersonInfo(params).enqueue(new OneProjectCallback<ReportResultResponse>(this) {
                public void onResponse(ReportResultResponse bean) {
                    CollectionForeignFragment.this.mWaitingDialog.dismiss();
                    if (bean == null) {
                        return;
                    }
                    if ("0".equals(bean.getFlag())) {
                        String res = bean.getRes();
                        ToastUtil.showToast("采集成功");
                        CollectionForeignFragment.this.mCommonSaveInfo.setServiceID(res);
                        CommonLocalSaveHelper.updateCommonSaveToUploaded(CollectionForeignFragment.this.mCommonSaveInfo);
                        CollectionForeignFragment.this.getActivity().setResult(-1, new Intent());
                        CollectionForeignFragment.this.getActivity().finish();
                        return;
                    }
                    ToastUtil.showToast("上传失败");
                }

                public void onFailed(String errorMessage) {
                    super.onFailed(errorMessage);
                    CollectionForeignFragment.this.mWaitingDialog.dismiss();
                }
            });
        } catch (RetrofitUrlNullException e) {
            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
        } finally {
            this.mWaitingDialog.dismiss();
        }
    }
}
