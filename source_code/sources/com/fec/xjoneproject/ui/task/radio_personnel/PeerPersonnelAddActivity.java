package com.fec.xjoneproject.ui.task.radio_personnel;

import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;
import com.fec.xjoneproject.ui.task.radio_personnel.PeerPersonnelListFragment.PeerItem;

public class PeerPersonnelAddActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return PeerPersonnelAddFragment.newInstance((PeerItem) getIntent().getSerializableExtra("peer_bean"), getIntent().getIntExtra("bean_position", -1));
    }
}
