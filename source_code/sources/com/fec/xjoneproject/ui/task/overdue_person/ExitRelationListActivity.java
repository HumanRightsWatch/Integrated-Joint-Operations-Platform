package com.fec.xjoneproject.ui.task.overdue_person;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.fec.xjoneproject.ui.SingleFragmentActivity;
import com.fec.xjoneproject.ui.task.overdue_person.ExitRelationListFragment.PeerItem;
import java.util.ArrayList;

public class ExitRelationListActivity extends SingleFragmentActivity {
    public Fragment createFragment() {
        return ExitRelationListFragment.newInstance((ArrayList) getIntent().getSerializableExtra("item_list"));
    }

    public void finish() {
        ArrayList<PeerItem> itemList = (ArrayList) ((ExitRelationListFragment) getSupportFragmentManager().getFragments().get(0)).getItemList();
        Intent intent = new Intent();
        intent.putExtra("item_list", itemList);
        setResult(-1, intent);
        super.finish();
    }
}
