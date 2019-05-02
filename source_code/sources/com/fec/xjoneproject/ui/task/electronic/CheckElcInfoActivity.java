package com.fec.xjoneproject.ui.task.electronic;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;
import com.hbfec.xjoneproject.R;

public class CheckElcInfoActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return new ElectronicAddFeedFragment();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ((ElectronicAddFeedFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container)).onNewIntent(intent);
    }
}
