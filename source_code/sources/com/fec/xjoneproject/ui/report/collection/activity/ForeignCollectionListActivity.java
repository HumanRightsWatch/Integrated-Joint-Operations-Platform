package com.fec.xjoneproject.ui.report.collection.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.fec.xjoneproject.ui.report.InfoSearchActivity;
import com.fec.xjoneproject.ui.report.collection.adapter.ReportViewPagerAdapter;
import com.hbfec.xjoneproject.R;

public class ForeignCollectionListActivity extends AppCompatActivity implements OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_foreign_collection_list);
        ((ImageView) findViewById(R.id.iv_back)).setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_window_title)).setText(R.string.collection_info);
        ImageButton mSearchBtn = (ImageButton) findViewById(R.id.btn_search);
        mSearchBtn.setVisibility(0);
        mSearchBtn.setOnClickListener(this);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ReportViewPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                startActivity(new Intent(this, InfoSearchActivity.class));
                return;
            case R.id.iv_back:
                finish();
                return;
            default:
                return;
        }
    }
}
