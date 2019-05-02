package com.fec.xjoneproject.ui.task.radio_personnel;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;
import com.fec.xjoneproject.ui.task.radio_personnel.PeerPersonnelListFragment.PeerItem;
import java.util.ArrayList;

public class PeerPersonnelListActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return PeerPersonnelListFragment.newInstance((ArrayList) getIntent().getSerializableExtra("item_list"));
    }

    public void finish() {
        ArrayList<PeerItem> itemList = (ArrayList) ((PeerPersonnelListFragment) getSupportFragmentManager().getFragments().get(0)).getItemList();
        Intent intent = new Intent();
        intent.putExtra("item_list", itemList);
        setResult(-1, intent);
        super.finish();
    }
}
