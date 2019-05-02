package com.fec.xjoneproject.ui.task.miss_phone_trail.viewModel;

import android.content.Intent;
import android.databinding.ObservableField;
import android.text.TextUtils;
import com.fec.report.dao.CommonSaveInfo;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.http.response.ReportResult;
import com.fec.xjoneproject.ui.supervise.TasksListFragment;
import com.fec.xjoneproject.ui.task.CommonLocalSaveHelper;
import com.fec.xjoneproject.ui.task.FeedbackBaseViewModel;
import com.fec.xjoneproject.ui.task.miss_phone_trail.activity.MissPhoneTrailFeedbackActivity;
import com.fec.xjoneproject.ui.task.miss_phone_trail.bean.MissPhoneResponse;
import com.fec.xjoneproject.ui.task.miss_phone_trail.bean.MissPhoneTrailResEntity;
import com.fec.xjoneproject.ui.task.miss_phone_trail.bean.MissPhoneTrailVisitorEntity;
import com.fec.xjoneproject.ui.task.miss_phone_trail.bean.MissPhoneTrailWarnEntity;
import com.fec.xjoneproject.ui.view.fieldGroup.visitor.OneProjectVisitorViewModel.Visitor;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.fec.xjoneproject.util.ToastUtil;
import com.google.gson.Gson;
import com.hbfec.xjoneinformation.MainTab;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

public class MissPhoneTrailFeedbackViewModel extends FeedbackBaseViewModel {
    public ObservableField<MissPhoneTrailResEntity> resEntity = new ObservableField();
    public ObservableField<MissPhoneTrailWarnEntity> warnEntity = new ObservableField();

    public MissPhoneTrailFeedbackViewModel(MissPhoneTrailFeedbackActivity activity, String warnId, int type) {
        super(activity, warnId, type);
        this.resEntity.set(new MissPhoneTrailResEntity());
    }

    public Call<MissPhoneResponse> getNetInterfaceCall(String warnId) {
        try {
            return AttendanceService.getApi().getMissPhoneTrailWarnEntity(warnId);
        } catch (RetrofitUrlNullException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getDataFromNet(ReportResult response) {
        MissPhoneTrailFeedbackActivity mActivity = (MissPhoneTrailFeedbackActivity) getActivity();
        MissPhoneResponse bean = null;
        if (response instanceof MissPhoneResponse) {
            bean = (MissPhoneResponse) response;
        }
        if (bean != null) {
            if (bean.getVisitor().size() > 0) {
                mActivity.setPushVisitor((Visitor) bean.getVisitor().get(0));
            }
            if (bean.getRes().size() > 0) {
                this.warnEntity.set(bean.getRes().get(0));
            }
        }
    }

    public void getDataFromLocal(CommonSaveInfo commonSaveInfo) {
        MissPhoneTrailFeedbackActivity mActivity = (MissPhoneTrailFeedbackActivity) getActivity();
        this.warnEntity.set((MissPhoneTrailWarnEntity) CommonLocalSaveHelper.getEntity(commonSaveInfo, "warnEntity", MissPhoneTrailWarnEntity.class));
        Boolean newVisitor = (Boolean) CommonLocalSaveHelper.getEntity(commonSaveInfo, "newVisitor", Boolean.class);
        if (newVisitor == null) {
            newVisitor = Boolean.valueOf(false);
        }
        mActivity.setNewVisitor(newVisitor);
        mActivity.setPushVisitor((Visitor) CommonLocalSaveHelper.getEntity(commonSaveInfo, "pushVisitor", MissPhoneTrailVisitorEntity.class));
        mActivity.setAddVisitor((Visitor) CommonLocalSaveHelper.getEntity(commonSaveInfo, "addVisitor", MissPhoneTrailVisitorEntity.class));
        MissPhoneTrailResEntity fourRelevanceResEntity = (MissPhoneTrailResEntity) CommonLocalSaveHelper.getEntity(commonSaveInfo, "resEntity", MissPhoneTrailResEntity.class);
        if (this.resEntity == null) {
            this.resEntity = new ObservableField();
        }
        this.resEntity.set(fourRelevanceResEntity);
    }

    public void submit() {
        MissPhoneTrailFeedbackActivity mActivity = (MissPhoneTrailFeedbackActivity) getActivity();
        String error = mActivity.check();
        if (TextUtils.isEmpty(error)) {
            getActivity().mWaitingDialog.show("正在上传……");
            Gson gson = new Gson();
            Map<String, RequestBody> partMap = new HashMap();
            ((MissPhoneTrailResEntity) this.resEntity.get()).setAddUser();
            ((MissPhoneTrailResEntity) this.resEntity.get()).setLongitude(getActivity().getLongitude());
            ((MissPhoneTrailResEntity) this.resEntity.get()).setLatitude(getActivity().getLatitude());
            ((MissPhoneTrailResEntity) this.resEntity.get()).setLocationDescription(getActivity().getLocationDescription());
            if (mActivity.getNewVisitor().booleanValue()) {
                Object visitorEntity = new MissPhoneTrailVisitorEntity();
                visitorEntity.setFkMpt(getWarnId());
                visitorEntity.setVisitor(mActivity.getAddVisitor());
                visitorEntity.setAddUser();
                visitorEntity.setLongitude(getActivity().getLongitude());
                visitorEntity.setLatitude(getActivity().getLatitude());
                visitorEntity.setLocationDescription(getActivity().getLocationDescription());
                partMap.put("missPhoneTrailVisitorEntity", RequestBody.create(null, gson.toJson(visitorEntity)));
            } else {
                ((MissPhoneTrailResEntity) this.resEntity.get()).setFkMptv(mActivity.getPushVisitor().getId());
            }
            partMap.put("warnId", RequestBody.create(null, getWarnId()));
            partMap.put("missPhoneTrailResEntity", RequestBody.create(null, gson.toJson(this.resEntity.get())));
            try {
                AttendanceService.getApi().submitMissPhoneTrailFeedback(partMap).enqueue(new OneProjectCallback<ReportResult>(getActivity()) {
                    public void onResponse(ReportResult bean) {
                        MissPhoneTrailFeedbackViewModel.this.getActivity().mWaitingDialog.dismiss();
                        ToastUtil.showToast("反馈成功");
                        Intent intent = new Intent(MissPhoneTrailFeedbackViewModel.this.getActivity(), MainTab.class);
                        intent.setFlags(67108864);
                        intent.putExtra(TasksListFragment.TASK_TYPE, 28);
                        MissPhoneTrailFeedbackViewModel.this.getActivity().startActivity(intent);
                    }

                    public void onFailed(String error) {
                        super.onFailed(error);
                        MissPhoneTrailFeedbackViewModel.this.getActivity().mWaitingDialog.dismiss();
                    }
                });
                return;
            } catch (RetrofitUrlNullException e) {
                ToastUtil.showToast(e.getMessage());
                getActivity().mWaitingDialog.dismiss();
                return;
            }
        }
        ToastUtil.showToast(error);
    }

    public void save() {
        MissPhoneTrailFeedbackActivity mActivity = (MissPhoneTrailFeedbackActivity) getActivity();
        JSONObject jsonObject = new JSONObject();
        Gson gson = new Gson();
        try {
            jsonObject.put("warnEntity", gson.toJson(this.warnEntity.get()));
            jsonObject.put("pushVisitor", gson.toJson(mActivity.getPushVisitor()));
            jsonObject.put("newVisitor", gson.toJson(mActivity.getNewVisitor()));
            jsonObject.put("addVisitor", gson.toJson(mActivity.getAddVisitor()));
            jsonObject.put("resEntity", gson.toJson(this.resEntity.get()));
            setCommonSaveInfo(CommonLocalSaveHelper.save(getCommonSaveInfo(), 28, getWarnId(), jsonObject.toString()));
            ToastUtil.showToast("保存成功");
            finish();
        } catch (JSONException e) {
        }
    }
}
