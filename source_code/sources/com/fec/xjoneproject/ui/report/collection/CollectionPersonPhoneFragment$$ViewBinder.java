package com.fec.xjoneproject.ui.report.collection;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import com.hbfec.xjoneproject.R;

public class CollectionPersonPhoneFragment$$ViewBinder<T extends CollectionPersonPhoneFragment> implements ViewBinder<T> {
    public void bind(Finder finder, T target, Object source) {
        target.mBack = (ImageButton) finder.castView((View) finder.findRequiredView(source, R.id.ibtn_back, "field 'mBack'"), R.id.ibtn_back, "field 'mBack'");
        target.mAddPhone = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_add_phone, "field 'mAddPhone'"), R.id.tv_add_phone, "field 'mAddPhone'");
        target.mListView = (ListView) finder.castView((View) finder.findRequiredView(source, R.id.listView, "field 'mListView'"), R.id.listView, "field 'mListView'");
        target.mEmptyView = (FrameLayout) finder.castView((View) finder.findRequiredView(source, R.id.emptyView, "field 'mEmptyView'"), R.id.emptyView, "field 'mEmptyView'");
    }

    public void unbind(T target) {
        target.mBack = null;
        target.mAddPhone = null;
        target.mListView = null;
        target.mEmptyView = null;
    }
}
