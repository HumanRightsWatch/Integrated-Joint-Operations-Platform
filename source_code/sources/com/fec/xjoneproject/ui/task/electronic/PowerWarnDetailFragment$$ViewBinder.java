package com.fec.xjoneproject.ui.task.electronic;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import com.hbfec.xjoneproject.R;

public class PowerWarnDetailFragment$$ViewBinder<T extends PowerWarnDetailFragment> implements ViewBinder<T> {
    public void bind(Finder finder, T target, Object source) {
        target.mBackView = (ImageButton) finder.castView((View) finder.findRequiredView(source, R.id.ibtn_back, "field 'mBackView'"), R.id.ibtn_back, "field 'mBackView'");
        target.mIdNumberTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_idnum, "field 'mIdNumberTv'"), R.id.tv_check_electronic_idnum, "field 'mIdNumberTv'");
        target.mTelNumberTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_tel, "field 'mTelNumberTv'"), R.id.tv_check_electronic_tel, "field 'mTelNumberTv'");
        target.mPhotoIv = (ImageView) finder.castView((View) finder.findRequiredView(source, R.id.iv_electricitydetai_photo, "field 'mPhotoIv'"), R.id.iv_electricitydetai_photo, "field 'mPhotoIv'");
        target.mUserNameTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_name, "field 'mUserNameTv'"), R.id.tv_check_electronic_name, "field 'mUserNameTv'");
        target.mMeterNumberTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_meternum, "field 'mMeterNumberTv'"), R.id.tv_check_electronic_meternum, "field 'mMeterNumberTv'");
        target.mAddressTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_address, "field 'mAddressTv'"), R.id.tv_check_electronic_address, "field 'mAddressTv'");
        target.mTime1Tv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_time1, "field 'mTime1Tv'"), R.id.tv_check_electronic_time1, "field 'mTime1Tv'");
        target.mDegree1Tv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_degree1, "field 'mDegree1Tv'"), R.id.tv_check_electronic_degree1, "field 'mDegree1Tv'");
        target.mTime2Tv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_time2, "field 'mTime2Tv'"), R.id.tv_check_electronic_time2, "field 'mTime2Tv'");
        target.mDegree2Tv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_degree2, "field 'mDegree2Tv'"), R.id.tv_check_electronic_degree2, "field 'mDegree2Tv'");
        target.mTime3Tv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_time3, "field 'mTime3Tv'"), R.id.tv_check_electronic_time3, "field 'mTime3Tv'");
        target.mDegree3Tv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_degree3, "field 'mDegree3Tv'"), R.id.tv_check_electronic_degree3, "field 'mDegree3Tv'");
        target.mNormalAverageTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_electronic_normalaverage, "field 'mNormalAverageTv'"), R.id.tv_check_electronic_normalaverage, "field 'mNormalAverageTv'");
        target.mProblemDescTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_problem_desc, "field 'mProblemDescTv'"), R.id.tv_check_problem_desc, "field 'mProblemDescTv'");
        target.mTimeStartTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_time_start, "field 'mTimeStartTv'"), R.id.tv_check_time_start, "field 'mTimeStartTv'");
        target.mTimeAnalyseTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_time_analyse, "field 'mTimeAnalyseTv'"), R.id.tv_check_time_analyse, "field 'mTimeAnalyseTv'");
        target.mAddUserTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_adduser, "field 'mAddUserTv'"), R.id.tv_check_adduser, "field 'mAddUserTv'");
        target.mAddTimeTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_addtime, "field 'mAddTimeTv'"), R.id.tv_check_addtime, "field 'mAddTimeTv'");
        target.mIsCheckTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_ischeck, "field 'mIsCheckTv'"), R.id.tv_check_ischeck, "field 'mIsCheckTv'");
    }

    public void unbind(T target) {
        target.mBackView = null;
        target.mIdNumberTv = null;
        target.mTelNumberTv = null;
        target.mPhotoIv = null;
        target.mUserNameTv = null;
        target.mMeterNumberTv = null;
        target.mAddressTv = null;
        target.mTime1Tv = null;
        target.mDegree1Tv = null;
        target.mTime2Tv = null;
        target.mDegree2Tv = null;
        target.mTime3Tv = null;
        target.mDegree3Tv = null;
        target.mNormalAverageTv = null;
        target.mProblemDescTv = null;
        target.mTimeStartTv = null;
        target.mTimeAnalyseTv = null;
        target.mAddUserTv = null;
        target.mAddTimeTv = null;
        target.mIsCheckTv = null;
    }
}
