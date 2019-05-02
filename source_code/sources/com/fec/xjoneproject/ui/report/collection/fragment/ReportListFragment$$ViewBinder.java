package com.fec.xjoneproject.ui.report.collection.fragment;

import android.view.View;
import android.widget.ListView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import com.hbfec.xjoneproject.R;

public class ReportListFragment$$ViewBinder<T extends ReportListFragment> implements ViewBinder<T> {
    public void bind(Finder finder, T target, Object source) {
        target.listView = (ListView) finder.castView((View) finder.findRequiredView(source, R.id.listView, "field 'listView'"), R.id.listView, "field 'listView'");
    }

    public void unbind(T target) {
        target.listView = null;
    }
}
