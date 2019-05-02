package com.fec.xjoneproject.ui.task.radio_personnel;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;
import com.hbfec.xjoneproject.R;

public class PeerPersonnelListFragment$$ViewBinder<T extends PeerPersonnelListFragment> implements ViewBinder<T> {
    public void bind(Finder finder, T target, Object source) {
        target.mBack = (ImageButton) finder.castView((View) finder.findRequiredView(source, R.id.ibtn_back, "field 'mBack'"), R.id.ibtn_back, "field 'mBack'");
        target.mListView = (ListView) finder.castView((View) finder.findRequiredView(source, R.id.listView, "field 'mListView'"), R.id.listView, "field 'mListView'");
        target.mAddPeer = (TextView) finder.castView((View) finder.findRequiredView(source, R.id.tv_add_peer, "field 'mAddPeer'"), R.id.tv_add_peer, "field 'mAddPeer'");
    }

    public void unbind(T target) {
        target.mBack = null;
        target.mListView = null;
        target.mAddPeer = null;
    }
}
