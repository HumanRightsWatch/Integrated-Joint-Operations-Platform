package com.fec.xjoneproject.ui.task.overdue_person;

import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;
import com.fec.xjoneproject.ui.task.overdue_person.ExitRelationListFragment.PeerItem;

public class ExitRelationAddActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return ExitRelationAddFragment.newInstance((PeerItem) getIntent().getSerializableExtra("peer_bean"), getIntent().getIntExtra("bean_position", -1));
    }
}
