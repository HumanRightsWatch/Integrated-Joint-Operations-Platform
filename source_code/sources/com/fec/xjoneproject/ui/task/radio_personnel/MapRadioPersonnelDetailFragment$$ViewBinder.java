package com.fec.xjoneproject.ui.task.radio_personnel;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import butterknife.internal.DebouncingOnClickListener;
import com.hbfec.xjoneproject.R;

public class MapRadioPersonnelDetailFragment$$ViewBinder<T extends MapRadioPersonnelDetailFragment> implements ViewBinder<T> {
    public void bind(Finder finder, final T target, Object source) {
        target.mBack = (ImageButton) finder.castView((View) finder.findRequiredView(source, R.id.ibtn_back, "field 'mBack'"), R.id.ibtn_back, "field 'mBack'");
        target.mTypeTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_type, "field 'mTypeTextView'"), R.id.tv_type, "field 'mTypeTextView'");
        target.mNameTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_name, "field 'mNameTextView'"), R.id.tv_name, "field 'mNameTextView'");
        target.mIdentityTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_identity, "field 'mIdentityTextView'"), R.id.tv_identity, "field 'mIdentityTextView'");
        View view = (View) finder.findRequiredView(source, R.id.iv_id_card_photo, "field 'mIdCardPhotoImageView' and method 'onClick'");
        target.mIdCardPhotoImageView = (ImageView) finder.castView(view, R.id.iv_id_card_photo, "field 'mIdCardPhotoImageView'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        view = (View) finder.findRequiredView(source, R.id.iv_collect_photo, "field 'mCollectPhoto' and method 'onClick'");
        target.mCollectPhoto = (ImageView) finder.castView(view, R.id.iv_collect_photo, "field 'mCollectPhoto'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onClick(p0);
            }
        });
        target.mSimilarityTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_similarity, "field 'mSimilarityTextView'"), R.id.tv_similarity, "field 'mSimilarityTextView'");
        target.mDeviceLocationTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_acquisition_device_location, "field 'mDeviceLocationTextView'"), R.id.tv_acquisition_device_location, "field 'mDeviceLocationTextView'");
        target.mDeviceCodeTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_door_device_code, "field 'mDeviceCodeTextView'"), R.id.tv_door_device_code, "field 'mDeviceCodeTextView'");
        target.mStationIdTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_door_station_id, "field 'mStationIdTextView'"), R.id.tv_door_station_id, "field 'mStationIdTextView'");
        target.mGatherTimeTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_acquisition_time, "field 'mGatherTimeTextView'"), R.id.tv_acquisition_time, "field 'mGatherTimeTextView'");
        target.mIdTagsTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_id_tags, "field 'mIdTagsTextView'"), R.id.tv_id_tags, "field 'mIdTagsTextView'");
        target.mDisposalMeansTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_disposal_means, "field 'mDisposalMeansTextView'"), R.id.tv_disposal_means, "field 'mDisposalMeansTextView'");
        target.mImeiTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_imei, "field 'mImeiTextView'"), R.id.tv_imei, "field 'mImeiTextView'");
        target.mImsiTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_imsi, "field 'mImsiTextView'"), R.id.tv_imsi, "field 'mImsiTextView'");
        target.mMacTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_mac, "field 'mMacTextView'"), R.id.tv_mac, "field 'mMacTextView'");
        target.mNoteTextView = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_note, "field 'mNoteTextView'"), R.id.tv_note, "field 'mNoteTextView'");
    }

    public void unbind(T target) {
        target.mBack = null;
        target.mTypeTextView = null;
        target.mNameTextView = null;
        target.mIdentityTextView = null;
        target.mIdCardPhotoImageView = null;
        target.mCollectPhoto = null;
        target.mSimilarityTextView = null;
        target.mDeviceLocationTextView = null;
        target.mDeviceCodeTextView = null;
        target.mStationIdTextView = null;
        target.mGatherTimeTextView = null;
        target.mIdTagsTextView = null;
        target.mDisposalMeansTextView = null;
        target.mImeiTextView = null;
        target.mImsiTextView = null;
        target.mMacTextView = null;
        target.mNoteTextView = null;
    }
}
