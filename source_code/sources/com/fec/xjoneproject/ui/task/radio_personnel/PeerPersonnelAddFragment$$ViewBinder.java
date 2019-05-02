package com.fec.xjoneproject.ui.task.radio_personnel;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import com.hbfec.xjoneproject.R;
import com.rengwuxian.materialedittext.MaterialEditText;

public class PeerPersonnelAddFragment$$ViewBinder<T extends PeerPersonnelAddFragment> implements ViewBinder<T> {
    public void bind(Finder finder, T target, Object source) {
        target.mBack = (ImageButton) finder.castView((View) finder.findRequiredView(source, R.id.ibtn_back, "field 'mBack'"), R.id.ibtn_back, "field 'mBack'");
        target.mNameMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_name, "field 'mNameMaterialEditText'"), R.id.et_name, "field 'mNameMaterialEditText'");
        target.mCardMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_card, "field 'mCardMaterialEditText'"), R.id.et_card, "field 'mCardMaterialEditText'");
        target.mInfoMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_info, "field 'mInfoMaterialEditText'"), R.id.et_info, "field 'mInfoMaterialEditText'");
        target.mMobileMaterialEditText = (MaterialEditText) finder.castView((View) finder.findRequiredView(source, R.id.et_mobile_phone1, "field 'mMobileMaterialEditText'"), R.id.et_mobile_phone1, "field 'mMobileMaterialEditText'");
        target.mPeer = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_add_peer, "field 'mPeer'"), R.id.tv_add_peer, "field 'mPeer'");
    }

    public void unbind(T target) {
        target.mBack = null;
        target.mNameMaterialEditText = null;
        target.mCardMaterialEditText = null;
        target.mInfoMaterialEditText = null;
        target.mMobileMaterialEditText = null;
        target.mPeer = null;
    }
}
