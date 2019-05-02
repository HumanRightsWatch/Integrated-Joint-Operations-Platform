package com.fec.xjoneproject.ui.task.radio_personnel;

import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;
import com.fec.xjoneproject.ui.task.TaskConstant;

public class CheckRadioPersonnelInfoActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return CheckRadioPersonnelInfoFragment.newInstance(getIntent().getStringExtra(TaskConstant.ARG_KEY_WARN_ID));
    }
}
