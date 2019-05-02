package com.fec.xjoneproject.ui.task.overdue_person;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.hbfec.xjoneproject.R;

public class OverduePersonDetailFragment$$ViewBinder<T extends OverduePersonDetailFragment> implements ViewBinder<T> {
    public void bind(Finder finder, T target, Object source) {
        target.mBackBtn = (ImageButton) finder.castView((View) finder.findRequiredView(source, R.id.ibtn_back, "field 'mBackBtn'"), R.id.ibtn_back, "field 'mBackBtn'");
        target.mNameTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_name, "field 'mNameTv'"), R.id.tv_name, "field 'mNameTv'");
        target.mSexTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_sex, "field 'mSexTv'"), R.id.tv_sex, "field 'mSexTv'");
        target.mNationTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_nation, "field 'mNationTv'"), R.id.tv_nation, "field 'mNationTv'");
        target.mPhoneTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_phone, "field 'mPhoneTv'"), R.id.tv_phone, "field 'mPhoneTv'");
        target.mAddressTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_address, "field 'mAddressTv'"), R.id.tv_address, "field 'mAddressTv'");
        target.mIdCardTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_id_card, "field 'mIdCardTv'"), R.id.tv_id_card, "field 'mIdCardTv'");
        target.mCardTypeTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_card_type, "field 'mCardTypeTv'"), R.id.tv_card_type, "field 'mCardTypeTv'");
        target.mCardNumberTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_card_number, "field 'mCardNumberTv'"), R.id.tv_card_number, "field 'mCardNumberTv'");
        target.mExitPortTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_exit_port, "field 'mExitPortTv'"), R.id.tv_exit_port, "field 'mExitPortTv'");
        target.mExitTimeTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_exit_time, "field 'mExitTimeTv'"), R.id.tv_exit_time, "field 'mExitTimeTv'");
        target.mEnterCountryTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_enter_country, "field 'mEnterCountryTv'"), R.id.tv_enter_country, "field 'mEnterCountryTv'");
        target.mExitReasonTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_exit_reason, "field 'mExitReasonTv'"), R.id.tv_exit_reason, "field 'mExitReasonTv'");
        target.mTrackTimeTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_last_track_time, "field 'mTrackTimeTv'"), R.id.tv_last_track_time, "field 'mTrackTimeTv'");
        target.mTrackLocationTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_last_track_location, "field 'mTrackLocationTv'"), R.id.tv_last_track_location, "field 'mTrackLocationTv'");
        target.mSelectPhotoView = (SelectPhotoView) finder.castView((View) finder.findRequiredView(source, R.id.iv_report_pic, "field 'mSelectPhotoView'"), R.id.iv_report_pic, "field 'mSelectPhotoView'");
        target.mNote = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_note, "field 'mNote'"), R.id.tv_note, "field 'mNote'");
    }

    public void unbind(T target) {
        target.mBackBtn = null;
        target.mNameTv = null;
        target.mSexTv = null;
        target.mNationTv = null;
        target.mPhoneTv = null;
        target.mAddressTv = null;
        target.mIdCardTv = null;
        target.mCardTypeTv = null;
        target.mCardNumberTv = null;
        target.mExitPortTv = null;
        target.mExitTimeTv = null;
        target.mEnterCountryTv = null;
        target.mExitReasonTv = null;
        target.mTrackTimeTv = null;
        target.mTrackLocationTv = null;
        target.mSelectPhotoView = null;
        target.mNote = null;
    }
}
