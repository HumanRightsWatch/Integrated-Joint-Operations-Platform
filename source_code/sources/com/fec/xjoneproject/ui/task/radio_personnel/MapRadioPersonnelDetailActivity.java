package com.fec.xjoneproject.ui.task.radio_personnel;

import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;

public class MapRadioPersonnelDetailActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return MapRadioPersonnelDetailFragment.newInstance(getIntent().getStringExtra("population_base_id"));
    }
}
