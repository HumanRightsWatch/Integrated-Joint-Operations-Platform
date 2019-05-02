package com.fec.xjoneproject.ui.task.overdue_person;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import com.hbfec.xjoneproject.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import fr.ganfra.materialspinner.MaterialSpinner;

public class ExitRelationAddFragment$$ViewBinder<T extends ExitRelationAddFragment> implements ViewBinder<T> {
    public void bind(Finder finder, T target, Object source) {
        target.mBack = (ImageButton) finder.castView((View) finder.findRequiredView(source, R.id.ibtn_back, "field 'mBack'"), R.id.ibtn_back, "field 'mBack'");
        target.mTitleTv = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_title, "field 'mTitleTv'"), R.id.tv_title, "field 'mTitleTv'");
        target.mFamily = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_add, "field 'mFamily'"), R.id.tv_add, "field 'mFamily'");
        target.mNameMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_name, "field 'mNameMaterialEditText'"), R.id.et_name, "field 'mNameMaterialEditText'");
        target.mPhoneMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_phone, "field 'mPhoneMaterialEditText'"), R.id.et_phone, "field 'mPhoneMaterialEditText'");
        target.mRelationMaterialSpinner = (MaterialSpinner) finder.castView((View) finder.findRequiredView(source, R.id.spinner_relation, "field 'mRelationMaterialSpinner'"), R.id.spinner_relation, "field 'mRelationMaterialSpinner'");
        target.mNoteTextMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_problem_family_note, "field 'mNoteTextMaterialEditText'"), R.id.et_problem_family_note, "field 'mNoteTextMaterialEditText'");
    }

    public void unbind(T target) {
        target.mBack = null;
        target.mTitleTv = null;
        target.mFamily = null;
        target.mNameMaterialEditText = null;
        target.mPhoneMaterialEditText = null;
        target.mRelationMaterialSpinner = null;
        target.mNoteTextMaterialEditText = null;
    }
}
