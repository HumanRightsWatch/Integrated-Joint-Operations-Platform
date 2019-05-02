package com.fec.xjoneproject.ui.report.collection.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import butterknife.internal.DebouncingOnClickListener;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.fec.xjoneproject.ui.view.field.OneProjectFieldCommonLayout;
import com.fec.xjoneproject.ui.view.field.OneProjectMoreFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleEditTextFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleSpinnerFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleTextFieldView;
import com.fec.xjoneproject.ui.view.field.multiEditText.OneProjectMultiEditTextFieldView;
import com.hbfec.xjoneproject.R;
import com.rengwuxian.materialedittext.MaterialEditText;

public class CollectionPersonFragment$$ViewBinder<T extends CollectionPersonFragment> implements ViewBinder<T> {
    public void bind(Finder finder, final T target, Object source) {
        target.mRootView = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.rootView, "field 'mRootView'"), R.id.rootView, "field 'mRootView'");
        target.nameOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.nameOneProjectSimpleEditTextFieldView, "field 'nameOneProjectSimpleEditTextFieldView'"), R.id.nameOneProjectSimpleEditTextFieldView, "field 'nameOneProjectSimpleEditTextFieldView'");
        target.mFieldCardOneProjectFieldCommonLayout = (OneProjectFieldCommonLayout) finder.castView((View) finder.findRequiredView(source, R.id.field_card, "field 'mFieldCardOneProjectFieldCommonLayout'"), R.id.field_card, "field 'mFieldCardOneProjectFieldCommonLayout'");
        target.mCardMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_card, "field 'mCardMaterialEditText'"), R.id.et_card, "field 'mCardMaterialEditText'");
        View view = (View) finder.findRequiredView(source, R.id.iv_card_photo, "field 'mCardPhotoImageButton' and method 'onClick'");
        target.mCardPhotoImageButton = (ImageButton) finder.castView(view, R.id.iv_card_photo, "field 'mCardPhotoImageButton'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        target.nationOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.nationOneProjectSimpleEditTextFieldView, "field 'nationOneProjectSimpleEditTextFieldView'"), R.id.nationOneProjectSimpleEditTextFieldView, "field 'nationOneProjectSimpleEditTextFieldView'");
        target.personCardMatchOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.personCardMatchOneProjectSimpleSpinnerFieldView, "field 'personCardMatchOneProjectSimpleSpinnerFieldView'"), R.id.personCardMatchOneProjectSimpleSpinnerFieldView, "field 'personCardMatchOneProjectSimpleSpinnerFieldView'");
        target.addressOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.addressOneProjectSimpleEditTextFieldView, "field 'addressOneProjectSimpleEditTextFieldView'"), R.id.addressOneProjectSimpleEditTextFieldView, "field 'addressOneProjectSimpleEditTextFieldView'");
        target.phoneOneProjectMultiEditTextFieldView = (OneProjectMultiEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.phoneOneProjectMultiEditTextFieldView, "field 'phoneOneProjectMultiEditTextFieldView'"), R.id.phoneOneProjectMultiEditTextFieldView, "field 'phoneOneProjectMultiEditTextFieldView'");
        target.addressHomeOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.addressHomeOneProjectSimpleEditTextFieldView, "field 'addressHomeOneProjectSimpleEditTextFieldView'"), R.id.addressHomeOneProjectSimpleEditTextFieldView, "field 'addressHomeOneProjectSimpleEditTextFieldView'");
        target.heightOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.heightOneProjectSimpleSpinnerFieldView, "field 'heightOneProjectSimpleSpinnerFieldView'"), R.id.heightOneProjectSimpleSpinnerFieldView, "field 'heightOneProjectSimpleSpinnerFieldView'");
        target.bloodOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.bloodOneProjectSimpleSpinnerFieldView, "field 'bloodOneProjectSimpleSpinnerFieldView'"), R.id.bloodOneProjectSimpleSpinnerFieldView, "field 'bloodOneProjectSimpleSpinnerFieldView'");
        target.educationOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.educationOneProjectSimpleSpinnerFieldView, "field 'educationOneProjectSimpleSpinnerFieldView'"), R.id.educationOneProjectSimpleSpinnerFieldView, "field 'educationOneProjectSimpleSpinnerFieldView'");
        target.professionOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.professionOneProjectSimpleEditTextFieldView, "field 'professionOneProjectSimpleEditTextFieldView'"), R.id.professionOneProjectSimpleEditTextFieldView, "field 'professionOneProjectSimpleEditTextFieldView'");
        target.politicalOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.politicalOneProjectSimpleSpinnerFieldView, "field 'politicalOneProjectSimpleSpinnerFieldView'"), R.id.politicalOneProjectSimpleSpinnerFieldView, "field 'politicalOneProjectSimpleSpinnerFieldView'");
        view = (View) finder.findRequiredView(source, R.id.buildingOneProjectMoreFieldView, "field 'buildingOneProjectMoreFieldView' and method 'onClick'");
        target.buildingOneProjectMoreFieldView = (OneProjectMoreFieldView) finder.castView(view, R.id.buildingOneProjectMoreFieldView, "field 'buildingOneProjectMoreFieldView'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        view = (View) finder.findRequiredView(source, R.id.houseOneProjectMoreFieldView, "field 'houseOneProjectMoreFieldView' and method 'onClick'");
        target.houseOneProjectMoreFieldView = (OneProjectMoreFieldView) finder.castView(view, R.id.houseOneProjectMoreFieldView, "field 'houseOneProjectMoreFieldView'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        target.changeIdentityOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.changeIdentityOneProjectSimpleSpinnerFieldView, "field 'changeIdentityOneProjectSimpleSpinnerFieldView'"), R.id.changeIdentityOneProjectSimpleSpinnerFieldView, "field 'changeIdentityOneProjectSimpleSpinnerFieldView'");
        target.nameNowOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.nameNowOneProjectSimpleEditTextFieldView, "field 'nameNowOneProjectSimpleEditTextFieldView'"), R.id.nameNowOneProjectSimpleEditTextFieldView, "field 'nameNowOneProjectSimpleEditTextFieldView'");
        target.cardNowOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.cardNowOneProjectSimpleEditTextFieldView, "field 'cardNowOneProjectSimpleEditTextFieldView'"), R.id.cardNowOneProjectSimpleEditTextFieldView, "field 'cardNowOneProjectSimpleEditTextFieldView'");
        target.nationNowOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.nationNowOneProjectSimpleEditTextFieldView, "field 'nationNowOneProjectSimpleEditTextFieldView'"), R.id.nationNowOneProjectSimpleEditTextFieldView, "field 'nationNowOneProjectSimpleEditTextFieldView'");
        target.addressNowOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.addressNowOneProjectSimpleEditTextFieldView, "field 'addressNowOneProjectSimpleEditTextFieldView'"), R.id.addressNowOneProjectSimpleEditTextFieldView, "field 'addressNowOneProjectSimpleEditTextFieldView'");
        target.passportOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.passportOneProjectSimpleEditTextFieldView, "field 'passportOneProjectSimpleEditTextFieldView'"), R.id.passportOneProjectSimpleEditTextFieldView, "field 'passportOneProjectSimpleEditTextFieldView'");
        target.carOneProjectMultiEditTextFieldView = (OneProjectMultiEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.carOneProjectMultiEditTextFieldView, "field 'carOneProjectMultiEditTextFieldView'"), R.id.carOneProjectMultiEditTextFieldView, "field 'carOneProjectMultiEditTextFieldView'");
        target.locationOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.locationOneProjectSimpleEditTextFieldView, "field 'locationOneProjectSimpleEditTextFieldView'"), R.id.locationOneProjectSimpleEditTextFieldView, "field 'locationOneProjectSimpleEditTextFieldView'");
        target.descriptionOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.descriptionOneProjectSimpleEditTextFieldView, "field 'descriptionOneProjectSimpleEditTextFieldView'"), R.id.descriptionOneProjectSimpleEditTextFieldView, "field 'descriptionOneProjectSimpleEditTextFieldView'");
        target.jiaopeiReasonOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.jiaopeiReasonOneProjectSimpleEditTextFieldView, "field 'jiaopeiReasonOneProjectSimpleEditTextFieldView'"), R.id.jiaopeiReasonOneProjectSimpleEditTextFieldView, "field 'jiaopeiReasonOneProjectSimpleEditTextFieldView'");
        target.jiaopeiActionOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.jiaopeiActionOneProjectSimpleEditTextFieldView, "field 'jiaopeiActionOneProjectSimpleEditTextFieldView'"), R.id.jiaopeiActionOneProjectSimpleEditTextFieldView, "field 'jiaopeiActionOneProjectSimpleEditTextFieldView'");
        view = (View) finder.findRequiredView(source, R.id.typeOneProjectSimpleTextViewField, "field 'typeOneProjectSimpleTextFieldView' and method 'onClick'");
        target.typeOneProjectSimpleTextFieldView = (OneProjectSimpleTextFieldView) finder.castView(view, R.id.typeOneProjectSimpleTextViewField, "field 'typeOneProjectSimpleTextFieldView'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        target.passportTypeOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.passportTypeOneProjectSimpleSpinnerFieldView, "field 'passportTypeOneProjectSimpleSpinnerFieldView'"), R.id.passportTypeOneProjectSimpleSpinnerFieldView, "field 'passportTypeOneProjectSimpleSpinnerFieldView'");
        target.passportNumberOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.passportNumberOneProjectSimpleEditTextFieldView, "field 'passportNumberOneProjectSimpleEditTextFieldView'"), R.id.passportNumberOneProjectSimpleEditTextFieldView, "field 'passportNumberOneProjectSimpleEditTextFieldView'");
        target.destinationCountryOneProjectSimpleEditTextFieldView = (OneProjectSimpleEditTextFieldView) finder.castView((View) finder.findRequiredView(source, R.id.destinationCountryOneProjectSimpleEditTextFieldView, "field 'destinationCountryOneProjectSimpleEditTextFieldView'"), R.id.destinationCountryOneProjectSimpleEditTextFieldView, "field 'destinationCountryOneProjectSimpleEditTextFieldView'");
        view = (View) finder.findRequiredView(source, R.id.exitTimeOneProjectSimpleTextViewField, "field 'exitTimeOneProjectSimpleTextFieldView' and method 'onClick'");
        target.exitTimeOneProjectSimpleTextFieldView = (OneProjectSimpleTextFieldView) finder.castView(view, R.id.exitTimeOneProjectSimpleTextViewField, "field 'exitTimeOneProjectSimpleTextFieldView'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        target.exitReasonOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.exitReasonOneProjectSimpleSpinnerFieldView, "field 'exitReasonOneProjectSimpleSpinnerFieldView'"), R.id.exitReasonOneProjectSimpleSpinnerFieldView, "field 'exitReasonOneProjectSimpleSpinnerFieldView'");
        target.religiousOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.religiousOneProjectSimpleSpinnerFieldView, "field 'religiousOneProjectSimpleSpinnerFieldView'"), R.id.religiousOneProjectSimpleSpinnerFieldView, "field 'religiousOneProjectSimpleSpinnerFieldView'");
        target.religionNameOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.religionOneProjectSimpleSpinnerFieldView, "field 'religionNameOneProjectSimpleSpinnerFieldView'"), R.id.religionOneProjectSimpleSpinnerFieldView, "field 'religionNameOneProjectSimpleSpinnerFieldView'");
        target.relationOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.relationOneProjectSimpleSpinnerFieldView, "field 'relationOneProjectSimpleSpinnerFieldView'"), R.id.relationOneProjectSimpleSpinnerFieldView, "field 'relationOneProjectSimpleSpinnerFieldView'");
        target.mReportPicture = (SelectPhotoView) finder.castView((View) finder.findRequiredView(source, R.id.gv_report_pic, "field 'mReportPicture'"), R.id.gv_report_pic, "field 'mReportPicture'");
        view = (View) finder.findRequiredView(source, R.id.tv_edit_photo, "field 'mEditPhotoTv' and method 'onClick'");
        target.mEditPhotoTv = (TextView) finder.castView(view, R.id.tv_edit_photo, "field 'mEditPhotoTv'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        target.mOtherTypeEt = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_type_other, "field 'mOtherTypeEt'"), R.id.et_type_other, "field 'mOtherTypeEt'");
        target.mPersonTypeOverseaLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_person_type_oversea, "field 'mPersonTypeOverseaLayout'"), R.id.ll_person_type_oversea, "field 'mPersonTypeOverseaLayout'");
        target.mChangeIdLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_is_change_identity, "field 'mChangeIdLayout'"), R.id.ll_is_change_identity, "field 'mChangeIdLayout'");
        target.JiaoPeiLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_jiaopei, "field 'JiaoPeiLayout'"), R.id.ll_jiaopei, "field 'JiaoPeiLayout'");
        target.mCheckPersonContainerFrameLayout = (FrameLayout) finder.castView((View) finder.findRequiredView(source, R.id.fl_check_person_container, "field 'mCheckPersonContainerFrameLayout'"), R.id.fl_check_person_container, "field 'mCheckPersonContainerFrameLayout'");
    }

    public void unbind(T target) {
        target.mRootView = null;
        target.nameOneProjectSimpleEditTextFieldView = null;
        target.mFieldCardOneProjectFieldCommonLayout = null;
        target.mCardMaterialEditText = null;
        target.mCardPhotoImageButton = null;
        target.nationOneProjectSimpleEditTextFieldView = null;
        target.personCardMatchOneProjectSimpleSpinnerFieldView = null;
        target.addressOneProjectSimpleEditTextFieldView = null;
        target.phoneOneProjectMultiEditTextFieldView = null;
        target.addressHomeOneProjectSimpleEditTextFieldView = null;
        target.heightOneProjectSimpleSpinnerFieldView = null;
        target.bloodOneProjectSimpleSpinnerFieldView = null;
        target.educationOneProjectSimpleSpinnerFieldView = null;
        target.professionOneProjectSimpleEditTextFieldView = null;
        target.politicalOneProjectSimpleSpinnerFieldView = null;
        target.buildingOneProjectMoreFieldView = null;
        target.houseOneProjectMoreFieldView = null;
        target.changeIdentityOneProjectSimpleSpinnerFieldView = null;
        target.nameNowOneProjectSimpleEditTextFieldView = null;
        target.cardNowOneProjectSimpleEditTextFieldView = null;
        target.nationNowOneProjectSimpleEditTextFieldView = null;
        target.addressNowOneProjectSimpleEditTextFieldView = null;
        target.passportOneProjectSimpleEditTextFieldView = null;
        target.carOneProjectMultiEditTextFieldView = null;
        target.locationOneProjectSimpleEditTextFieldView = null;
        target.descriptionOneProjectSimpleEditTextFieldView = null;
        target.jiaopeiReasonOneProjectSimpleEditTextFieldView = null;
        target.jiaopeiActionOneProjectSimpleEditTextFieldView = null;
        target.typeOneProjectSimpleTextFieldView = null;
        target.passportTypeOneProjectSimpleSpinnerFieldView = null;
        target.passportNumberOneProjectSimpleEditTextFieldView = null;
        target.destinationCountryOneProjectSimpleEditTextFieldView = null;
        target.exitTimeOneProjectSimpleTextFieldView = null;
        target.exitReasonOneProjectSimpleSpinnerFieldView = null;
        target.religiousOneProjectSimpleSpinnerFieldView = null;
        target.religionNameOneProjectSimpleSpinnerFieldView = null;
        target.relationOneProjectSimpleSpinnerFieldView = null;
        target.mReportPicture = null;
        target.mEditPhotoTv = null;
        target.mOtherTypeEt = null;
        target.mPersonTypeOverseaLayout = null;
        target.mChangeIdLayout = null;
        target.JiaoPeiLayout = null;
        target.mCheckPersonContainerFrameLayout = null;
    }
}
