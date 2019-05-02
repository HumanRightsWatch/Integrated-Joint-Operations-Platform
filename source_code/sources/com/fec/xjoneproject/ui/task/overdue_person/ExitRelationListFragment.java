package com.fec.xjoneproject.ui.task.overdue_person;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.fec.xjoneproject.ui.ListViewItemDeleteAnimation;
import com.hbfec.xjoneproject.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExitRelationListFragment extends Fragment implements OnItemClickListener {
    ListViewAdapter mAdapter = new ListViewAdapter();
    TextView mAddPeer;
    ImageButton mBack;
    FrameLayout mEmptyView;
    private List<PeerItem> mItemList = new ArrayList();
    ListView mListView;
    TextView mTitleTv;

    public class ListViewAdapter extends BaseAdapter implements OnClickListener {
        public int getCount() {
            return ExitRelationListFragment.this.mItemList.size();
        }

        public Object getItem(int position) {
            return ExitRelationListFragment.this.mItemList.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        @SuppressLint({"InflateParams"})
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = ExitRelationListFragment.this.getActivity().getLayoutInflater().inflate(R.layout.item_investigate_family_with_delete, null);
            TextView name = (TextView) convertView.findViewById(R.id.tv_name);
            TextView phone = (TextView) convertView.findViewById(R.id.tv_phone);
            TextView relation = (TextView) convertView.findViewById(R.id.tv_relation);
            ImageView delete = (ImageView) convertView.findViewById(R.id.iv_delete);
            PeerItem item = (PeerItem) ExitRelationListFragment.this.mItemList.get(position);
            convertView.setTag(item);
            name.setText(item.getName());
            phone.setText(item.getPhone());
            relation.setText(ExitRelationListFragment.this.getRelationName(item.getRelation()));
            delete.setVisibility(0);
            delete.setTag(convertView);
            delete.setOnClickListener(this);
            return convertView;
        }

        public void onClick(View view) {
            View convertView = (View) view.getTag();
            final PeerItem item = (PeerItem) convertView.getTag();
            ListViewItemDeleteAnimation.deletePatternWithDialog(ExitRelationListFragment.this.getActivity(), "删除境外联系人 " + item.getName() + " 的信息？", convertView, new Runnable() {
                public void run() {
                    ExitRelationListFragment.this.mItemList.remove(item);
                    ListViewAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    public static class PeerItem implements Serializable {
        private long id = -1;
        private Boolean isError = Boolean.valueOf(false);
        private String name;
        private String note;
        private String phone;
        private Integer relation;

        public String getNote() {
            return this.note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public long getId() {
            return this.id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Integer getRelation() {
            return this.relation;
        }

        public void setRelation(Integer relation) {
            this.relation = relation;
        }

        public Boolean getError() {
            return this.isError;
        }

        public void setError(Boolean error) {
            this.isError = error;
        }
    }

    public List<PeerItem> getItemList() {
        List<PeerItem> copyItemList = new ArrayList();
        copyItemList.addAll(this.mItemList);
        return copyItemList;
    }

    public static ExitRelationListFragment newInstance(List<PeerItem> itemList) {
        ExitRelationListFragment fragment = new ExitRelationListFragment();
        Bundle args = new Bundle();
        args.putSerializable("item_list", (ArrayList) itemList);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mItemList = (ArrayList) getArguments().getSerializable("item_list");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_family_list, container, false);
        this.mListView = (ListView) rootView.findViewById(R.id.listView);
        this.mBack = (ImageButton) rootView.findViewById(R.id.ibtn_back);
        this.mEmptyView = (FrameLayout) rootView.findViewById(R.id.emptyView);
        this.mAddPeer = (TextView) rootView.findViewById(R.id.tv_add_family);
        this.mTitleTv = (TextView) rootView.findViewById(R.id.tv_title);
        this.mTitleTv.setText("境外联系人");
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setEmptyView(this.mEmptyView);
        this.mAddPeer.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ExitRelationListFragment.this.startActivityForResult(new Intent(ExitRelationListFragment.this.getActivity(), ExitRelationAddActivity.class), 0);
            }
        });
        this.mBack.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ExitRelationListFragment.this.getActivity().finish();
            }
        });
        return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            PeerItem item = (PeerItem) data.getSerializableExtra("peer_bean");
            int position = data.getIntExtra("bean_position", -1);
            if (position == -1) {
                this.mItemList.add(item);
            } else {
                this.mItemList.set(position, item);
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), ExitRelationAddActivity.class);
        intent.putExtra("peer_bean", (Serializable) this.mItemList.get(position));
        intent.putExtra("bean_position", position);
        startActivityForResult(intent, 0);
    }

    private String getRelationName(Integer relation) {
        if (relation != null) {
            switch (relation.intValue()) {
                case 0:
                    return "未选择";
                case 1:
                    return "夫妻";
                case 2:
                    return "父子";
                case 3:
                    return "父女";
                case 4:
                    return "母女";
                case 5:
                    return "母子";
                case 6:
                    return "祖孙";
                case 7:
                    return "兄弟";
                case 8:
                    return "兄妹";
                case 9:
                    return "其他";
            }
        }
        return "未选择";
    }
}
