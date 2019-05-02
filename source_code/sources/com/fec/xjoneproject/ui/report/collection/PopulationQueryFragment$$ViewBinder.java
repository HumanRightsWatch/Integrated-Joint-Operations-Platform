package com.fec.xjoneproject.ui.report.collection;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.hbfec.xjoneproject.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import fr.ganfra.materialspinner.MaterialSpinner;

public class PopulationQueryFragment$$ViewBinder<T extends PopulationQueryFragment> implements ViewBinder<T> {
    public void bind(Finder finder, T target, Object source) {
        target.mBackBtn = (ImageButton) finder.castView((View) finder.findRequiredView(source, R.id.ibtn_back, "field 'mBackBtn'"), R.id.ibtn_back, "field 'mBackBtn'");
        target.mTitleText = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_title, "field 'mTitleText'"), R.id.tv_title, "field 'mTitleText'");
        target.mAddressText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_building_address, "field 'mAddressText'"), R.id.et_building_address, "field 'mAddressText'");
        target.mUseSpinner = (MaterialSpinner) finder.castView((View) finder.findRequiredView(source, R.id.spinner_building_use, "field 'mUseSpinner'"), R.id.spinner_building_use, "field 'mUseSpinner'");
        target.mReportPicture = (SelectPhotoView) finder.castView((View) finder.findRequiredView(source, R.id.gv_report_pic, "field 'mReportPicture'"), R.id.gv_report_pic, "field 'mReportPicture'");
        target.mBuildingAreaTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_building_area, "field 'mBuildingAreaTv'"), R.id.tv_building_area, "field 'mBuildingAreaTv'");
        target.mAddBtn = (ImageButton) finder.castView((View) finder.findRequiredView(source, R.id.btn_save, "field 'mAddBtn'"), R.id.btn_save, "field 'mAddBtn'");
        target.mEditBtn = (ImageButton) finder.castView((View) finder.findRequiredView(source, R.id.btn_edit, "field 'mEditBtn'"), R.id.btn_edit, "field 'mEditBtn'");
        target.mEditPhotoTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_edit_photo, "field 'mEditPhotoTv'"), R.id.tv_edit_photo, "field 'mEditPhotoTv'");
        target.mBuildingAreaErrorLayout = (LinearLayout) finder.castView((View) finder.findRequiredView(source, R.id.ll_building_area_error, "field 'mBuildingAreaErrorLayout'"), R.id.ll_building_area_error, "field 'mBuildingAreaErrorLayout'");
    }

    public void unbind(T target) {
        target.mBackBtn = null;
        target.mTitleText = null;
        target.mAddressText = null;
        target.mUseSpinner = null;
        target.mReportPicture = null;
        target.mBuildingAreaTv = null;
        target.mAddBtn = null;
        target.mEditBtn = null;
        target.mEditPhotoTv = null;
        target.mBuildingAreaErrorLayout = null;
    }
}
