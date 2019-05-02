package com.fec.xjoneproject.ui.report.collection.fragment;

import android.support.v4.app.Fragment;
import android.widget.ScrollView;

public abstract class CollectionBaseFragment extends Fragment {
    private Boolean editable;

    public abstract void localSaveInfo();

    public abstract void submitWithUploadPhoto(ScrollView scrollView);

    public Boolean getEditable() {
        return this.editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
}
