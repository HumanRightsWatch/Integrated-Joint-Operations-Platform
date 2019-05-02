package com.fec.xjoneproject.ui.task.radio_personnel;

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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.fec.xjoneproject.ui.ListViewItemDeleteAnimation;
import com.hbfec.xjoneproject.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PeerPersonnelListFragment extends Fragment implements OnItemClickListener {
    public static final String ARG_ITEM_LIST = "item_list";
    ListViewAdapter mAdapter = new ListViewAdapter();
    @Bind({2131297946})
    TextView mAddPeer;
    @Bind({2131296888})
    ImageButton mBack;
    private List<PeerItem> mItemList = new ArrayList();
    @Bind({2131297085})
    ListView mListView;

    public class ListViewAdapter extends BaseAdapter implements OnClickListener {
        public int getCount() {
            return PeerPersonnelListFragment.this.mItemList.size();
        }

        public Object getItem(int position) {
            return PeerPersonnelListFragment.this.mItemList.get(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        @SuppressLint({"InflateParams"})
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = PeerPersonnelListFragment.this.getActivity().getLayoutInflater().inflate(R.layout.item_peer_personnel, null);
            TextView name = (TextView) convertView.findViewById(R.id.tv_name);
            TextView phone = (TextView) convertView.findViewById(R.id.tv_phone);
            TextView id = (TextView) convertView.findViewById(R.id.tv_id);
            ImageView delete = (ImageView) convertView.findViewById(R.id.iv_delete);
            PeerItem item = (PeerItem) PeerPersonnelListFragment.this.mItemList.get(position);
            convertView.setTag(item);
            name.setText(item.getName());
            phone.setText(item.getInfo());
            id.setText(item.getCard());
            delete.setVisibility(0);
            delete.setTag(convertView);
            delete.setOnClickListener(this);
            return convertView;
        }

        public void onClick(View view) {
            View convertView = (View) view.getTag();
            final PeerItem item = (PeerItem) convertView.getTag();
            ListViewItemDeleteAnimation.deletePatternWithDialog(PeerPersonnelListFragment.this.getActivity(), "删除同行人员 " + item.getName() + " 的信息？", convertView, new Runnable() {
                public void run() {
                    PeerPersonnelListFragment.this.mItemList.remove(item);
                    ListViewAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    public static class PeerItem implements Serializable {
        private String card;
        private long id = -1;
        private String info;
        private Boolean isError = Boolean.valueOf(false);
        private String mobile;
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return this.id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Boolean getError() {
            return this.isError;
        }

        public void setError(Boolean error) {
            this.isError = error;
        }

        public String getCard() {
            return this.card;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public String getInfo() {
            return this.info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getMobile() {
            return this.mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }

    public List<PeerItem> getItemList() {
        List<PeerItem> copyItemList = new ArrayList();
        copyItemList.addAll(this.mItemList);
        return copyItemList;
    }

    public static PeerPersonnelListFragment newInstance(List<PeerItem> itemList) {
        PeerPersonnelListFragment fragment = new PeerPersonnelListFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_peer_personnel_list, container, false);
        ButterKnife.bind((Object) this, rootView);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this);
        this.mAddPeer.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PeerPersonnelListFragment.this.startActivityForResult(new Intent(PeerPersonnelListFragment.this.getActivity(), PeerPersonnelAddActivity.class), 0);
            }
        });
        this.mBack.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PeerPersonnelListFragment.this.getActivity().finish();
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
        Intent intent = new Intent(getActivity(), PeerPersonnelAddActivity.class);
        intent.putExtra("peer_bean", (Serializable) this.mItemList.get(position));
        intent.putExtra("bean_position", position);
        startActivityForResult(intent, 0);
    }
}
