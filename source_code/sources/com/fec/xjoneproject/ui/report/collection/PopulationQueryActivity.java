package com.fec.xjoneproject.ui.report.collection;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;
import com.hbfec.xjoneproject.R;

public class PopulationQueryActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return new PopulationQueryFragment();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ((PopulationQueryFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container)).onNewIntent(intent);
    }
}
