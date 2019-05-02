package com.fec.xjoneproject.ui.task.overdue_person;

import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;
import com.fec.xjoneproject.ui.task.TaskConstant;

public class OverduePersonAddFeedActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return OverduePersonAddFeedFragment.newInstance(getIntent().getStringExtra(TaskConstant.ARG_KEY_ID));
    }
}
