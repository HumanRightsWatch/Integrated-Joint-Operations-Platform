package com.fec.xjoneproject.ui.task.radio_personnel;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import butterknife.internal.DebouncingOnClickListener;
import com.fec.xjoneproject.ui.view.field.OneProjectMoreFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleDateSelectFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleEditTextFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleRadioGroupWithTwoButtonFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleSpinnerFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleTextFieldView;
import com.fec.xjoneproject.ui.view.field.multiEditText.OneProjectMultiEditTextFieldView;
import com.hbfec.xjoneproject.R;

public class CheckRadioPersonnelInfoFragment$$ViewBinder<T extends CheckRadioPersonnelInfoFragment> implements ViewBinder<T> {
    public void bind(Finder finder, final T target, Object source) {
        target.mTitleText = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_title, "field 'mTitleText'"), R.id.tv_title, "field 'mTitleText'");
        target.mScrollView = (ScrollView) finder.castView((View) finder.findRequiredView(source, R.id.scrollView, "field 'mScrollView'"), R.id.scrollView, "field 'mScrollView'");
        target.nameOneProjectSimpleTextFieldView = (OneProjectSimpleTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.nameOneProjectSimpleTextFieldView, "field 'nameOneProjectSimpleTextFieldView'"), R.id.nameOneProjectSimpleTextFieldView, "field 'nameOneProjectSimpleTextFieldView'");
        target.cardOneProjectSimpleTextFieldView = (OneProjectSimpleTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.cardOneProjectSimpleTextFieldView, "field 'cardOneProjectSimpleTextFieldView'"), R.id.cardOneProjectSimpleTextFieldView, "field 'cardOneProjectSimpleTextFieldView'");
        target.addressOneProjectSimpleTextFieldView = (OneProjectSimpleTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.addressOneProjectSimpleTextFieldView, "field 'addressOneProjectSimpleTextFieldView'"), R.id.addressOneProjectSimpleTextFieldView, "field 'addressOneProjectSimpleTextFieldView'");
        View view = (View) finder.findRequiredView(source, R.id.iv_photo, "field 'mPhotoImageView' and method 'onClick'");
        target.mPhotoImageView = (ImageView) finder.castView(view, R.id.iv_photo, "field 'mPhotoImageView'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        target.typeOneProjectSimpleTextViewField = (OneProjectSimpleTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.typeOneProjectSimpleTextViewField, "field 'typeOneProjectSimpleTextViewField'"), R.id.typeOneProjectSimpleTextViewField, "field 'typeOneProjectSimpleTextViewField'");
        target.warningOneProjectSimpleRadioGroupWithTwoButtonFieldView = (OneProjectSimpleRadioGroupWithTwoButtonFieldView) finder.castView((View) finder.findRequiredView(source, R.id.warningOneProjectSimpleRadioGroupWithTwoButtonFieldView, "field 'warningOneProjectSimpleRadioGroupWithTwoButtonFieldView'"), R.id.warningOneProjectSimpleRadioGroupWithTwoButtonFieldView, "field 'warningOneProjectSimpleRadioGroupWithTwoButtonFieldView'");
        target.warnLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.warnLinearLayout, "field 'warnLinearLayout'"), R.id.warnLinearLayout, "field 'warnLinearLayout'");
        target.actionOneProjectSimpleTextFieldView = (OneProjectSimpleTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.actionOneProjectSimpleTextFieldView, "field 'actionOneProjectSimpleTextFieldView'"), R.id.actionOneProjectSimpleTextFieldView, "field 'actionOneProjectSimpleTextFieldView'");
        target.mInfoCollectionLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_info_collection, "field 'mInfoCollectionLinearLayout'"), R.id.ll_info_collection, "field 'mInfoCollectionLinearLayout'");
        target.cardOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.cardOneProjectSimpleEditTextFieldView, "field 'cardOneProjectSimpleEditTextFieldView'"), R.id.cardOneProjectSimpleEditTextFieldView, "field 'cardOneProjectSimpleEditTextFieldView'");
        target.phoneOneProjectMultiEditTextFieldView = (OneProjectMultiEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.phoneOneProjectMultiEditTextFieldView, "field 'phoneOneProjectMultiEditTextFieldView'"), R.id.phoneOneProjectMultiEditTextFieldView, "field 'phoneOneProjectMultiEditTextFieldView'");
        target.sameOneProjectSimpleRadioGroupWithTwoButtonFieldView = (OneProjectSimpleRadioGroupWithTwoButtonFieldView) finder.castView((View) finder.findRequiredView(source, R.id.sameOneProjectSimpleRadioGroupWithTwoButtonFieldView, "field 'sameOneProjectSimpleRadioGroupWithTwoButtonFieldView'"), R.id.sameOneProjectSimpleRadioGroupWithTwoButtonFieldView, "field 'sameOneProjectSimpleRadioGroupWithTwoButtonFieldView'");
        view = (View) finder.findRequiredView(source, R.id.peerOneProjectMoreFieldView, "field 'peerOneProjectMoreFieldView' and method 'onClick'");
        target.peerOneProjectMoreFieldView = (OneProjectMoreFieldView) finder.castView(view, R.id.peerOneProjectMoreFieldView, "field 'peerOneProjectMoreFieldView'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        target.dubiousOneProjectSimpleRadioGroupWithTwoButtonFieldView = (OneProjectSimpleRadioGroupWithTwoButtonFieldView) finder.castView((View) finder.findRequiredView(source, R.id.dubiousOneProjectSimpleRadioGroupWithTwoButtonFieldView, "field 'dubiousOneProjectSimpleRadioGroupWithTwoButtonFieldView'"), R.id.dubiousOneProjectSimpleRadioGroupWithTwoButtonFieldView, "field 'dubiousOneProjectSimpleRadioGroupWithTwoButtonFieldView'");
        target.mKeepCheckLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_keep_check, "field 'mKeepCheckLinearLayout'"), R.id.ll_keep_check, "field 'mKeepCheckLinearLayout'");
        target.leaveOneProjectSimpleRadioGroupWithTwoButtonFieldView = (OneProjectSimpleRadioGroupWithTwoButtonFieldView) finder.castView((View) finder.findRequiredView(source, R.id.leaveOneProjectSimpleRadioGroupWithTwoButtonFieldView, "field 'leaveOneProjectSimpleRadioGroupWithTwoButtonFieldView'"), R.id.leaveOneProjectSimpleRadioGroupWithTwoButtonFieldView, "field 'leaveOneProjectSimpleRadioGroupWithTwoButtonFieldView'");
        target.reasonOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.reasonOneProjectSimpleSpinnerFieldView, "field 'reasonOneProjectSimpleSpinnerFieldView'"), R.id.reasonOneProjectSimpleSpinnerFieldView, "field 'reasonOneProjectSimpleSpinnerFieldView'");
        target.mImmediateArrestLinearLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_immediate_arrest, "field 'mImmediateArrestLinearLayout'"), R.id.ll_immediate_arrest, "field 'mImmediateArrestLinearLayout'");
        target.activityOneProjectSimpleDateSelectFieldView = (OneProjectSimpleDateSelectFieldView) finder.castView((View) finder.findRequiredView(source, R.id.activityOneProjectSimpleDateSelectFieldView, "field 'activityOneProjectSimpleDateSelectFieldView'"), R.id.activityOneProjectSimpleDateSelectFieldView, "field 'activityOneProjectSimpleDateSelectFieldView'");
        target.localOneProjectSimpleRadioGroupWithTwoButtonFieldView = (OneProjectSimpleRadioGroupWithTwoButtonFieldView) finder.castView((View) finder.findRequiredView(source, R.id.localOneProjectSimpleRadioGroupWithTwoButtonFieldView, "field 'localOneProjectSimpleRadioGroupWithTwoButtonFieldView'"), R.id.localOneProjectSimpleRadioGroupWithTwoButtonFieldView, "field 'localOneProjectSimpleRadioGroupWithTwoButtonFieldView'");
        target.mArrestCheckBox = (CheckBox) finder.castView((View) finder.findRequiredView(source, R.id.cb_arrest, "field 'mArrestCheckBox'"), R.id.cb_arrest, "field 'mArrestCheckBox'");
        ((View) finder.findRequiredView(source, R.id.ibtn_back, "method 'onClick'")).setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        ((View) finder.findRequiredView(source, R.id.btn_submit, "method 'onClick'")).setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        ((View) finder.findRequiredView(source, R.id.btn_save, "method 'onClick'")).setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
    }

    public void unbind(T target) {
        target.mTitleText = null;
        target.mScrollView = null;
        target.nameOneProjectSimpleTextFieldView = null;
        target.cardOneProjectSimpleTextFieldView = null;
        target.addressOneProjectSimpleTextFieldView = null;
        target.mPhotoImageView = null;
        target.typeOneProjectSimpleTextViewField = null;
        target.warningOneProjectSimpleRadioGroupWithTwoButtonFieldView = null;
        target.warnLinearLayout = null;
        target.actionOneProjectSimpleTextFieldView = null;
        target.mInfoCollectionLinearLayout = null;
        target.cardOneProjectSimpleEditTextFieldView = null;
        target.phoneOneProjectMultiEditTextFieldView = null;
        target.sameOneProjectSimpleRadioGroupWithTwoButtonFieldView = null;
        target.peerOneProjectMoreFieldView = null;
        target.dubiousOneProjectSimpleRadioGroupWithTwoButtonFieldView = null;
        target.mKeepCheckLinearLayout = null;
        target.leaveOneProjectSimpleRadioGroupWithTwoButtonFieldView = null;
        target.reasonOneProjectSimpleSpinnerFieldView = null;
        target.mImmediateArrestLinearLayout = null;
        target.activityOneProjectSimpleDateSelectFieldView = null;
        target.localOneProjectSimpleRadioGroupWithTwoButtonFieldView = null;
        target.mArrestCheckBox = null;
    }
}
