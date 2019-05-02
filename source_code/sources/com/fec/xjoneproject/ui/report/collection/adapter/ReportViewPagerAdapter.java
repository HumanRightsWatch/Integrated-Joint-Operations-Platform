package com.fec.xjoneproject.ui.report.collection.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.fec.xjoneproject.ui.report.collection.fragment.ReportListFragment;

public class ReportViewPagerAdapter extends FragmentPagerAdapter {
    public ReportViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        return ReportListFragment.newInstance(position);
    }

    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "未发送";
        }
        return "已发送";
    }
}
