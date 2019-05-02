package com.fec.xjoneproject.ui.report.collection.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.fec.report.dao.CommonSaveInfo;
import com.fec.xjoneproject.ui.report.collection.activity.CollectionActivity;
import com.fec.xjoneproject.ui.report.collection.adapter.ReportListAdapter;
import com.fec.xjoneproject.ui.task.CommonLocalSaveHelper;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.hbfec.xjoneproject.R;
import java.util.List;

public class ReportListFragment extends Fragment {
    ReportListAdapter adapter;
    @Bind({2131297085})
    ListView listView;
    List<CommonSaveInfo> saveInfoList;
    private int status;

    public static ReportListFragment newInstance(int status) {
        ReportListFragment fragment = new ReportListFragment();
        Bundle args = new Bundle();
        args.putInt(TaskConstant.ARG_KEY_STATE, status);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.status = getArguments().getInt(TaskConstant.ARG_KEY_STATE);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report_list, container, false);
        ButterKnife.bind((Object) this, view);
        this.adapter = new ReportListAdapter(getActivity());
        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ReportListFragment.this.getActivity(), CollectionActivity.class);
                intent.putExtra(TaskConstant.ARG_KEY_ENTITY, (Parcelable) ReportListFragment.this.saveInfoList.get(i));
                ReportListFragment.this.startActivity(intent);
            }
        });
        return view;
    }

    public void onResume() {
        super.onResume();
        this.saveInfoList = CommonLocalSaveHelper.getCommonSaveInfoList(new int[]{1005, 1006}, this.status);
        this.adapter.setInfoList(this.saveInfoList);
        this.adapter.notifyDataSetChanged();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
