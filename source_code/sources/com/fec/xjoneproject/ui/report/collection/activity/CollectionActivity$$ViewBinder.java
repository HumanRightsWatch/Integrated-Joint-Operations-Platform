package com.fec.xjoneproject.ui.report.collection.activity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import butterknife.internal.DebouncingOnClickListener;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleSpinnerFieldView;
import com.hbfec.xjoneproject.R;

public class CollectionActivity$$ViewBinder<T extends CollectionActivity> implements ViewBinder<T> {
    public void bind(Finder finder, final T target, Object source) {
        View view = (View) finder.findRequiredView(source, R.id.btn_save, "field 'btnSave' and method 'onViewClicked'");
        target.btnSave = (ImageButton) finder.castView(view, R.id.btn_save, "field 'btnSave'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        target.themeOneProjectSimpleSpinnerFieldView = (OneProjectSimpleSpinnerFieldView) finder.castView((View) finder.findRequiredView(source, R.id.themeOneProjectSimpleSpinnerFieldView, "field 'themeOneProjectSimpleSpinnerFieldView'"), R.id.themeOneProjectSimpleSpinnerFieldView, "field 'themeOneProjectSimpleSpinnerFieldView'");
        target.scrollView = (ScrollView) finder.castView((View) finder.findRequiredView(source, R.id.scrollView, "field 'scrollView'"), R.id.scrollView, "field 'scrollView'");
        view = (View) finder.findRequiredView(source, R.id.tv_population_query_new, "field 'tvPopulationQueryNew' and method 'onViewClicked'");
        target.tvPopulationQueryNew = (TextView) finder.castView(view, R.id.tv_population_query_new, "field 'tvPopulationQueryNew'");
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
        ((View) finder.findRequiredView(source, R.id.iv_back, "method 'onViewClicked'")).setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target.onViewClicked(p0);
            }
        });
    }

    public void unbind(T target) {
        target.btnSave = null;
        target.themeOneProjectSimpleSpinnerFieldView = null;
        target.scrollView = null;
        target.tvPopulationQueryNew = null;
    }
}
