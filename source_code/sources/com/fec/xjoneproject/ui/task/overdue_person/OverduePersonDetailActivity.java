package com.fec.xjoneproject.ui.task.overdue_person;

import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;
import com.fec.xjoneproject.ui.task.TaskConstant;

public class OverduePersonDetailActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return OverduePersonDetailFragment.newInstance(getIntent().getStringExtra(TaskConstant.ARG_KEY_ID));
    }
}
