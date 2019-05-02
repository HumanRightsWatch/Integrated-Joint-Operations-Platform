package com.fec.xjoneproject.ui.task.person_car_match;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.text.TextUtils;
import com.fec.report.dao.LocalPersonnelCarMismatchEntity;
import com.fec.report.dao.LocalPersonnelCarMismatchEntityDao.Properties;
import com.fec.report.dao.LocalPersonnelCarResEntity;
import com.fec.report.dao.LocalPersonnelCarResEntityDao;
import com.fec.report.dao.LocalPersonnelCarVisitorEntity;
import com.fec.report.dao.LocalPersonnelCarVisitorEntityDao;
import com.fec.xjoneproject.dao.OneProjectDao;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.http.response.ReportResult;
import com.fec.xjoneproject.ui.supervise.TasksListFragment;
import com.fec.xjoneproject.ui.task.person_car_match.bean.PersonCarResponse;
import com.fec.xjoneproject.ui.task.person_car_match.bean.PersonnelCarMismatchEntity;
import com.fec.xjoneproject.ui.task.person_car_match.bean.PersonnelCarResEntity;
import com.fec.xjoneproject.ui.task.person_car_match.bean.PersonnelCarVisitorEntity;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.fec.xjoneproject.util.ToastUtil;
import com.google.gson.Gson;
import com.hbfec.xjoneinformation.MainTab;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import org.greenrobot.greendao.query.WhereCondition;

public class PersonCarViewModel extends BaseObservable {
    private LocalPersonnelCarResEntity feedbackEntity;
    private Integer isMatch = Integer.valueOf(0);
    public ObservableBoolean isNewVisitor = new ObservableBoolean();
    private Integer isPolice = Integer.valueOf(0);
    private PersonCarActivity mActivity;
    private Integer mismatchReason = Integer.valueOf(0);
    private LocalPersonnelCarVisitorEntity newEntity;
    private LocalPersonnelCarVisitorEntity pushEntity;
    private LocalPersonnelCarMismatchEntity warnEntity;

    public PersonCarViewModel(PersonCarActivity activity) {
        this.mActivity = activity;
        getLocalWarnEntity();
    }

    public void finish() {
        this.mActivity.finish();
    }

    public void changeVisitorType() {
        this.isNewVisitor.set(!this.isNewVisitor.get());
    }

    @Bindable
    public Integer getIsMatch() {
        return this.isMatch;
    }

    public void setIsMatch(Integer isMatch) {
        this.isMatch = isMatch;
        this.feedbackEntity.setIsMatch(String.valueOf(isMatch));
        notifyPropertyChanged(24);
    }

    @Bindable
    public Integer getIsPolice() {
        return this.isPolice;
    }

    public void setIsPolice(Integer isPolice) {
        this.isPolice = isPolice;
        this.feedbackEntity.setPoliceCheck(String.valueOf(isPolice));
        notifyPropertyChanged(26);
    }

    private void getLocalWarnEntity() {
        LocalPersonnelCarMismatchEntity warnEntity = (LocalPersonnelCarMismatchEntity) OneProjectDao.getInstance().getDaoSession().getLocalPersonnelCarMismatchEntityDao().queryBuilder().where(Properties.Id.eq(this.mActivity.getWarnId()), new WhereCondition[0]).unique();
        if (warnEntity != null) {
            Long fkId;
            setWarnEntity(warnEntity);
            this.isNewVisitor.set(warnEntity.getIsNewVisitor().booleanValue());
            for (LocalPersonnelCarVisitorEntity localVisitor : OneProjectDao.getInstance().getDaoSession().getLocalPersonnelCarVisitorEntityDao().queryBuilder().where(LocalPersonnelCarVisitorEntityDao.Properties.FkPcmh.eq(this.mActivity.getWarnId()), new WhereCondition[0]).list()) {
                if (localVisitor.getType().equals("1")) {
                    setPushEntity(localVisitor);
                }
                if (localVisitor.getType().equals("2")) {
                    setNewEntity(localVisitor);
                }
            }
            if (this.newEntity == null) {
                this.newEntity = new LocalPersonnelCarVisitorEntity();
            }
            if (warnEntity.getIsNewVisitor().booleanValue()) {
                fkId = getNewEntity().getLocalID();
            } else {
                fkId = getPushEntity().getLocalID();
            }
            setFeedbackEntity((LocalPersonnelCarResEntity) OneProjectDao.getInstance().getDaoSession().getLocalPersonnelCarResEntityDao().queryBuilder().where(LocalPersonnelCarResEntityDao.Properties.LocalFkPcv.eq(fkId), new WhereCondition[0]).unique());
            if (getFeedbackEntity() != null) {
                if (!TextUtils.isEmpty(getFeedbackEntity().getIsMatch())) {
                    setIsMatch(Integer.valueOf(getFeedbackEntity().getIsMatch()));
                }
                if (!TextUtils.isEmpty(getFeedbackEntity().getPoliceCheck())) {
                    setIsPolice(Integer.valueOf(getFeedbackEntity().getPoliceCheck()));
                    return;
                }
                return;
            }
            return;
        }
        this.warnEntity = new LocalPersonnelCarMismatchEntity();
        this.pushEntity = new LocalPersonnelCarVisitorEntity();
        this.newEntity = new LocalPersonnelCarVisitorEntity();
        this.feedbackEntity = new LocalPersonnelCarResEntity();
        this.isNewVisitor.set(false);
        try {
            getWarnEntityByNet();
        } catch (RetrofitUrlNullException e) {
            e.printStackTrace();
        }
    }

    public void getWarnEntityByNet() throws RetrofitUrlNullException {
        this.mActivity.mWaitingDialog.show("正在加载……");
        AttendanceService.getApi().getPersonCarWarnEntity(this.mActivity.getWarnId()).enqueue(new OneProjectCallback<PersonCarResponse>(this.mActivity) {
            public void onResponse(PersonCarResponse bean) {
                PersonCarViewModel.this.mActivity.mWaitingDialog.dismiss();
                LocalPersonnelCarMismatchEntity localWarnEntity = PersonCarViewModel.this.getWarnEntity();
                if (localWarnEntity == null) {
                    localWarnEntity = new LocalPersonnelCarMismatchEntity();
                }
                if (bean.getRes().size() > 0) {
                    PersonnelCarMismatchEntity entity = (PersonnelCarMismatchEntity) bean.getRes().get(0);
                    localWarnEntity.setId(entity.getId());
                    localWarnEntity.setDescription(entity.getDescription());
                }
                boolean isNewVisitor = true;
                if (bean.getVisitor().size() > 0) {
                    Gson gson = new Gson();
                    Object entity2 = (PersonnelCarVisitorEntity) bean.getVisitor().get(0);
                    if (entity2 != null) {
                        isNewVisitor = false;
                        PersonCarViewModel.this.setPushEntity((LocalPersonnelCarVisitorEntity) gson.fromJson(gson.toJson(entity2), LocalPersonnelCarVisitorEntity.class));
                    }
                }
                localWarnEntity.setIsNewVisitor(Boolean.valueOf(isNewVisitor));
                PersonCarViewModel.this.setWarnEntity(localWarnEntity);
            }

            public void onFailed(String errorMessage) {
                super.onFailed(errorMessage);
                PersonCarViewModel.this.mActivity.mWaitingDialog.dismiss();
            }
        });
    }

    public void submit() {
        String result = this.mActivity.check();
        if (TextUtils.isEmpty(result)) {
            this.mActivity.mWaitingDialog.show("正在提交……");
            packageEntity();
            Map<String, RequestBody> params = new HashMap();
            Gson gson = new Gson();
            params.put("warnId", RequestBody.create(null, this.mActivity.getWarnId()));
            Object feedbackEntity = (PersonnelCarResEntity) gson.fromJson(gson.toJson(this.feedbackEntity), PersonnelCarResEntity.class);
            if (this.isNewVisitor.get()) {
                Object newEntity = (PersonnelCarVisitorEntity) gson.fromJson(gson.toJson(this.newEntity), PersonnelCarVisitorEntity.class);
                newEntity.setCheckFlag("2");
                params.put("pcrv3Vistor", RequestBody.create(null, gson.toJson(newEntity)));
            } else {
                feedbackEntity.setFkPcv(this.pushEntity.getId());
            }
            params.put("pcrv3Res", RequestBody.create(null, gson.toJson(feedbackEntity)));
            try {
                AttendanceService.getApi().submitPersonCarFeedback(params).enqueue(new OneProjectCallback<ReportResult>(this.mActivity) {
                    public void onResponse(ReportResult bean) {
                        PersonCarViewModel.this.mActivity.mWaitingDialog.dismiss();
                        ToastUtil.showToast("反馈成功");
                        Intent intent = new Intent(PersonCarViewModel.this.mActivity, MainTab.class);
                        intent.setFlags(67108864);
                        intent.putExtra(TasksListFragment.TASK_TYPE, 9);
                        PersonCarViewModel.this.mActivity.startActivity(intent);
                    }

                    public void onFailed(String errorMessage) {
                        super.onFailed(errorMessage);
                        PersonCarViewModel.this.mActivity.mWaitingDialog.dismiss();
                    }
                });
                return;
            } catch (RetrofitUrlNullException e) {
                e.printStackTrace();
                return;
            }
        }
        ToastUtil.showToast(result);
    }

    public void save() {
        packageEntity();
        OneProjectDao.getInstance().getDaoSession().runInTx(new Runnable() {
            public void run() {
                OneProjectDao.getInstance().getDaoSession().getLocalPersonnelCarMismatchEntityDao().insertOrReplace(PersonCarViewModel.this.warnEntity);
                long pushID = OneProjectDao.getInstance().getDaoSession().getLocalPersonnelCarVisitorEntityDao().insertOrReplace(PersonCarViewModel.this.pushEntity);
                if (PersonCarViewModel.this.isNewVisitor.get()) {
                    PersonCarViewModel.this.feedbackEntity.setLocalFkPcv(Long.valueOf(OneProjectDao.getInstance().getDaoSession().getLocalPersonnelCarVisitorEntityDao().insertOrReplace(PersonCarViewModel.this.newEntity)));
                } else {
                    PersonCarViewModel.this.feedbackEntity.setLocalFkPcv(Long.valueOf(pushID));
                }
                OneProjectDao.getInstance().getDaoSession().getLocalPersonnelCarResEntityDao().insertOrReplace(PersonCarViewModel.this.feedbackEntity);
            }
        });
        ToastUtil.showToast("保存成功");
        this.mActivity.finish();
    }

    private void packageEntity() {
        this.warnEntity.setIsNewVisitor(Boolean.valueOf(this.isNewVisitor.get()));
        if (this.isNewVisitor != null && this.isNewVisitor.get()) {
            this.newEntity.setFkPcmh(this.mActivity.getWarnId());
            this.newEntity.setType("2");
            this.newEntity.setLatitude(this.mActivity.getLatitude());
            this.newEntity.setLongitude(this.mActivity.getLongitude());
            this.newEntity.setLocationDescription(this.mActivity.getLocationDescription());
        }
        this.feedbackEntity.setLatitude(this.mActivity.getLatitude());
        this.feedbackEntity.setLongitude(this.mActivity.getLongitude());
        this.feedbackEntity.setLocationDescription(this.mActivity.getLocationDescription());
    }

    public void setWarnEntity(LocalPersonnelCarMismatchEntity warnEntity) {
        this.warnEntity = warnEntity;
        this.mActivity.getBinding().setWarnEntity(warnEntity);
    }

    public void setPushEntity(LocalPersonnelCarVisitorEntity pushEntity) {
        this.pushEntity = pushEntity;
        this.mActivity.getBinding().setPushEntity(pushEntity);
    }

    public void setNewEntity(LocalPersonnelCarVisitorEntity newEntity) {
        this.newEntity = newEntity;
        this.mActivity.getBinding().setNewEntity(newEntity);
    }

    public void setFeedbackEntity(LocalPersonnelCarResEntity feedbackEntity) {
        this.feedbackEntity = feedbackEntity;
        this.mActivity.getBinding().setFeedbackEntity(feedbackEntity);
    }

    public LocalPersonnelCarMismatchEntity getWarnEntity() {
        return this.warnEntity;
    }

    public LocalPersonnelCarVisitorEntity getPushEntity() {
        return this.pushEntity;
    }

    public LocalPersonnelCarVisitorEntity getNewEntity() {
        return this.newEntity;
    }

    public LocalPersonnelCarResEntity getFeedbackEntity() {
        return this.feedbackEntity;
    }

    @Bindable
    public Integer getMismatchReason() {
        return this.mismatchReason;
    }

    public void setMismatchReason(Integer mismatchReason) {
        this.mismatchReason = mismatchReason;
        this.feedbackEntity.setMismatchReason(String.valueOf(mismatchReason));
        notifyPropertyChanged(29);
    }
}
