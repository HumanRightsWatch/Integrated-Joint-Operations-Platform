package com.fec.xjoneproject.ui.report.collection;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;
import com.hbfec.xjoneproject.R;

public class CollectionPersonPhoneActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return new CollectionPersonPhoneFragment();
    }

    public void finish() {
        CollectionPersonPhoneFragment fragment = (CollectionPersonPhoneFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        Intent intent = new Intent();
        String[] cars = new String[fragment.adapter.getCount()];
        for (int i = 0; i < fragment.adapter.getCount(); i++) {
            cars[i] = (String) fragment.adapter.getItem(i);
        }
        intent.putExtra(CollectionPersonPhoneFragment.ARG_RESULT, cars);
        setResult(-1, intent);
        super.finish();
    }
}
