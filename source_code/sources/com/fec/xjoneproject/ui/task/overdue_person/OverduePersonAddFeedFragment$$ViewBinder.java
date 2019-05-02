package com.fec.xjoneproject.ui.task.overdue_person;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import butterknife.internal.DebouncingOnClickListener;
import com.fec.xjoneproject.ui.view.PhoneListView;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.hbfec.xjoneproject.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import fr.ganfra.materialspinner.MaterialSpinner;

public class OverduePersonAddFeedFragment$$ViewBinder<T extends OverduePersonAddFeedFragment> implements ViewBinder<T> {
    public void bind(Finder finder, final T target, Object source) {
        View view = (View) finder.findRequiredView(source, R.id.ibtn_back, "field 'mBackButton' and method 'onClick'");
        target.mBackButton = (ImageButton) finder.castView(view, R.id.ibtn_back, "field 'mBackButton'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        target.mTitle = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_title, "field 'mTitle'"), R.id.tv_title, "field 'mTitle'");
        target.mScrollView = (ScrollView) finder.castView((View) finder.findRequiredView(source, R.id.scrollView, "field 'mScrollView'"), R.id.scrollView, "field 'mScrollView'");
        target.mNameText = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.et_population_name, "field 'mNameText'"), R.id.et_population_name, "field 'mNameText'");
        target.mIdentityText = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.et_population_identity, "field 'mIdentityText'"), R.id.et_population_identity, "field 'mIdentityText'");
        target.mPhoneText = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.et_population_phone, "field 'mPhoneText'"), R.id.et_population_phone, "field 'mPhoneText'");
        target.mHouseHoldText = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_check_nine_household, "field 'mHouseHoldText'"), R.id.tv_check_nine_household, "field 'mHouseHoldText'");
        target.mPicture = (ImageView) finder.castView((View) finder.findRequiredView(source, R.id.iv_picture, "field 'mPicture'"), R.id.iv_picture, "field 'mPicture'");
        target.mAddVisitorLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_add_visitor, "field 'mAddVisitorLayout'"), R.id.ll_add_visitor, "field 'mAddVisitorLayout'");
        target.mAddNameTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_name, "field 'mAddNameTextView'"), R.id.tv_name, "field 'mAddNameTextView'");
        target.mAddNameMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_name, "field 'mAddNameMaterialEditText'"), R.id.et_name, "field 'mAddNameMaterialEditText'");
        target.mAddHouseholdTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_household, "field 'mAddHouseholdTextView'"), R.id.tv_household, "field 'mAddHouseholdTextView'");
        target.mAddHouseMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_household, "field 'mAddHouseMaterialEditText'"), R.id.et_household, "field 'mAddHouseMaterialEditText'");
        target.mAddPhoneTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_phone, "field 'mAddPhoneTextView'"), R.id.tv_phone, "field 'mAddPhoneTextView'");
        target.mAddPhonePhoneListView = (PhoneListView) finder.castView((View) finder.findRequiredView(source, R.id.aelv_phone, "field 'mAddPhonePhoneListView'"), R.id.aelv_phone, "field 'mAddPhonePhoneListView'");
        target.mGender = (RadioGroup) finder.castView((View) finder.findRequiredView(source, R.id.rg_visitor_gender, "field 'mGender'"), R.id.rg_visitor_gender, "field 'mGender'");
        target.mManRb = (RadioButton) finder.castView((View) finder.findRequiredView(source, R.id.rb_visiter_gender_man, "field 'mManRb'"), R.id.rb_visiter_gender_man, "field 'mManRb'");
        target.mFemaleRb = (RadioButton) finder.castView((View) finder.findRequiredView(source, R.id.rb_visiter_gender_girl, "field 'mFemaleRb'"), R.id.rb_visiter_gender_girl, "field 'mFemaleRb'");
        target.mAddIdentityTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_identity_number, "field 'mAddIdentityTextView'"), R.id.tv_identity_number, "field 'mAddIdentityTextView'");
        target.mAddIdentityMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_identity_number, "field 'mAddIdentityMaterialEditText'"), R.id.et_identity_number, "field 'mAddIdentityMaterialEditText'");
        target.mReportPicIv = (SelectPhotoView) finder.castView((View) finder.findRequiredView(source, R.id.gv_report_pic, "field 'mReportPicIv'"), R.id.gv_report_pic, "field 'mReportPicIv'");
        target.mPhoneRelationTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_phone_relation, "field 'mPhoneRelationTextView'"), R.id.tv_phone_relation, "field 'mPhoneRelationTextView'");
        target.mRelationMaterialSpinner = (MaterialSpinner) finder.castView((View) finder.findRequiredView(source, R.id.s_relation, "field 'mRelationMaterialSpinner'"), R.id.s_relation, "field 'mRelationMaterialSpinner'");
        target.mFamilyAndSocietyLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_family_and_society, "field 'mFamilyAndSocietyLayout'"), R.id.ll_family_and_society, "field 'mFamilyAndSocietyLayout'");
        target.mFamilySpinner = (Spinner) finder.castView((View) finder.findRequiredView(source, R.id.s_family, "field 'mFamilySpinner'"), R.id.s_family, "field 'mFamilySpinner'");
        target.mOtherFamilyLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_other_family, "field 'mOtherFamilyLinearLayout'"), R.id.ll_other_family, "field 'mOtherFamilyLinearLayout'");
        target.mOtherFamilyMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_other_family, "field 'mOtherFamilyMaterialEditText'"), R.id.et_other_family, "field 'mOtherFamilyMaterialEditText'");
        target.mReasonLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_reason, "field 'mReasonLinearLayout'"), R.id.ll_reason, "field 'mReasonLinearLayout'");
        target.mReasonMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_reason, "field 'mReasonMaterialEditText'"), R.id.et_reason, "field 'mReasonMaterialEditText'");
        target.mCheckPhoneLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_check_phone, "field 'mCheckPhoneLayout'"), R.id.ll_check_phone, "field 'mCheckPhoneLayout'");
        target.mSuspiciousRg = (RadioGroup) finder.castView((View) finder.findRequiredView(source, R.id.rg_suspicious, "field 'mSuspiciousRg'"), R.id.rg_suspicious, "field 'mSuspiciousRg'");
        target.mSuspiciousInfoLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_phone_suspicious_info, "field 'mSuspiciousInfoLayout'"), R.id.ll_phone_suspicious_info, "field 'mSuspiciousInfoLayout'");
        target.mSuspiciousInfoMaterialSpinner = (MaterialSpinner) finder.castView((View) finder.findRequiredView(source, R.id.s_suspicious_info, "field 'mSuspiciousInfoMaterialSpinner'"), R.id.s_suspicious_info, "field 'mSuspiciousInfoMaterialSpinner'");
        target.mExitRg = (RadioGroup) finder.castView((View) finder.findRequiredView(source, R.id.rg_exit, "field 'mExitRg'"), R.id.rg_exit, "field 'mExitRg'");
        target.mRecentEventsInfoLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_recent_events_info, "field 'mRecentEventsInfoLinearLayout'"), R.id.ll_recent_events_info, "field 'mRecentEventsInfoLinearLayout'");
        target.mRecentEventsInfoMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_recent_events_info, "field 'mRecentEventsInfoMaterialEditText'"), R.id.et_recent_events_info, "field 'mRecentEventsInfoMaterialEditText'");
        target.mIsSuspiciousRg = (RadioGroup) finder.castView((View) finder.findRequiredView(source, R.id.rg_issuspicious, "field 'mIsSuspiciousRg'"), R.id.rg_issuspicious, "field 'mIsSuspiciousRg'");
        target.mIsSuspiciousInfoLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_suspicous_info, "field 'mIsSuspiciousInfoLinearLayout'"), R.id.ll_suspicous_info, "field 'mIsSuspiciousInfoLinearLayout'");
        target.mSuspiciousInfoMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_suspicious_info, "field 'mSuspiciousInfoMaterialEditText'"), R.id.et_suspicious_info, "field 'mSuspiciousInfoMaterialEditText'");
        target.mExitOtherCountryLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_exit_other_country, "field 'mExitOtherCountryLinearLayout'"), R.id.ll_exit_other_country, "field 'mExitOtherCountryLinearLayout'");
        target.mCountryDestinationMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_country_destination, "field 'mCountryDestinationMaterialEditText'"), R.id.et_country_destination, "field 'mCountryDestinationMaterialEditText'");
        target.mCountryEntryTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_country_entry, "field 'mCountryEntryTextView'"), R.id.tv_country_entry, "field 'mCountryEntryTextView'");
        target.mCountryEntryMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_country_entry, "field 'mCountryEntryMaterialEditText'"), R.id.et_country_entry, "field 'mCountryEntryMaterialEditText'");
        target.mExitReasonTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_exit_reson, "field 'mExitReasonTextView'"), R.id.tv_exit_reson, "field 'mExitReasonTextView'");
        target.mExitReasonSpinner = (MaterialSpinner) finder.castView((View) finder.findRequiredView(source, R.id.s_exit_reason, "field 'mExitReasonSpinner'"), R.id.s_exit_reason, "field 'mExitReasonSpinner'");
        target.mExitReasonMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_exit_reason, "field 'mExitReasonMaterialEditText'"), R.id.et_exit_reason, "field 'mExitReasonMaterialEditText'");
        target.mExitRelationLayout = (RelativeLayout) finder.castView((View) finder.findRequiredView(source, R.id.rl_exit_relation, "field 'mExitRelationLayout'"), R.id.rl_exit_relation, "field 'mExitRelationLayout'");
        target.mExitRelationCountTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_exit_relation_count, "field 'mExitRelationCountTv'"), R.id.tv_exit_relation_count, "field 'mExitRelationCountTv'");
        target.mExitEventRg = (RadioGroup) finder.castView((View) finder.findRequiredView(source, R.id.rg_exit_event, "field 'mExitEventRg'"), R.id.rg_exit_event, "field 'mExitEventRg'");
        target.mExitSuspiciousEventsLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_exit_suspicious_events, "field 'mExitSuspiciousEventsLinearLayout'"), R.id.ll_exit_suspicious_events, "field 'mExitSuspiciousEventsLinearLayout'");
        target.mSuspiciousEventsMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_suspicious_events, "field 'mSuspiciousEventsMaterialEditText'"), R.id.et_suspicious_events, "field 'mSuspiciousEventsMaterialEditText'");
        target.mExitRelationErrorLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_exit_relation_error, "field 'mExitRelationErrorLinearLayout'"), R.id.ll_exit_relation_error, "field 'mExitRelationErrorLinearLayout'");
        ((View) finder.findRequiredView(source, R.id.btn_miss_save, "method 'onClick'")).setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        ((View) finder.findRequiredView(source, R.id.btn_miss_commit, "method 'onClick'")).setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
    }

    public void unbind(T target) {
        target.mBackButton = null;
        target.mTitle = null;
        target.mScrollView = null;
        target.mNameText = null;
        target.mIdentityText = null;
        target.mPhoneText = null;
        target.mHouseHoldText = null;
        target.mPicture = null;
        target.mAddVisitorLayout = null;
        target.mAddNameTextView = null;
        target.mAddNameMaterialEditText = null;
        target.mAddHouseholdTextView = null;
        target.mAddHouseMaterialEditText = null;
        target.mAddPhoneTextView = null;
        target.mAddPhonePhoneListView = null;
        target.mGender = null;
        target.mManRb = null;
        target.mFemaleRb = null;
        target.mAddIdentityTextView = null;
        target.mAddIdentityMaterialEditText = null;
        target.mReportPicIv = null;
        target.mPhoneRelationTextView = null;
        target.mRelationMaterialSpinner = null;
        target.mFamilyAndSocietyLayout = null;
        target.mFamilySpinner = null;
        target.mOtherFamilyLinearLayout = null;
        target.mOtherFamilyMaterialEditText = null;
        target.mReasonLinearLayout = null;
        target.mReasonMaterialEditText = null;
        target.mCheckPhoneLayout = null;
        target.mSuspiciousRg = null;
        target.mSuspiciousInfoLayout = null;
        target.mSuspiciousInfoMaterialSpinner = null;
        target.mExitRg = null;
        target.mRecentEventsInfoLinearLayout = null;
        target.mRecentEventsInfoMaterialEditText = null;
        target.mIsSuspiciousRg = null;
        target.mIsSuspiciousInfoLinearLayout = null;
        target.mSuspiciousInfoMaterialEditText = null;
        target.mExitOtherCountryLinearLayout = null;
        target.mCountryDestinationMaterialEditText = null;
        target.mCountryEntryTextView = null;
        target.mCountryEntryMaterialEditText = null;
        target.mExitReasonTextView = null;
        target.mExitReasonSpinner = null;
        target.mExitReasonMaterialEditText = null;
        target.mExitRelationLayout = null;
        target.mExitRelationCountTv = null;
        target.mExitEventRg = null;
        target.mExitSuspiciousEventsLinearLayout = null;
        target.mSuspiciousEventsMaterialEditText = null;
        target.mExitRelationErrorLinearLayout = null;
    }
}
