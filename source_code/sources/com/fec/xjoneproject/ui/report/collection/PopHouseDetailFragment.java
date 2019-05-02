package com.fec.xjoneproject.ui.report.collection;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fec.report.dao.PopulationHouse;
import com.fec.xjoneproject.ui.report.dao.ReportDao;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.fec.xjoneproject.util.FecUtil;
import com.hbfec.xjoneproject.R;

public class PopHouseDetailFragment extends Fragment {
    public static final String POPULATION_HOUSE_ID = "population_house_id";
    private static final String TAG = "PopulationHouse";
    private final int FLAG_HANDLER_DATABASE = 10001;
    private TextView mAddressText;
    private TextView mCommunityCodeText;
    private TextView mCommunityText;
    private TextView mDistanceText;
    private Handler mHandler;
    private String mId;
    private TextView mIdentityText;
    private TextView mManagerPhoneText;
    private TextView mManagerText;
    private TextView mNameText;
    private TextView mNoteText;
    private TextView mPhoneText;
    private SelectPhotoView mReportPicsGv;
    private PopulationHouse populationHouse;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        this.mHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 10001:
                        if (PopHouseDetailFragment.this.populationHouse != null) {
                            PopHouseDetailFragment.this.setData();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private void setData() {
        this.mNameText.setText(this.populationHouse.getOwnerName());
        this.mIdentityText.setText(this.populationHouse.getOwnerIdCard());
        this.mPhoneText.setText(this.populationHouse.getOwnerPhone());
        this.mAddressText.setText(this.populationHouse.getHouseAddress());
        this.mCommunityText.setText(this.populationHouse.getCommunity());
        this.mCommunityCodeText.setText(this.populationHouse.getCommunityCode());
        this.mManagerText.setText(this.populationHouse.getManager());
        this.mManagerPhoneText.setText(this.populationHouse.getManagerPhone());
        this.mDistanceText.setText(this.populationHouse.getDistanceToFloatingPopulation());
        this.mNoteText.setText(this.populationHouse.getNote());
        String mPictures = this.populationHouse.getPicture();
        if (mPictures != null && !TextUtils.isEmpty(mPictures)) {
            this.mReportPicsGv.setFragmentReference(this);
            this.mReportPicsGv.setEditable(false);
            this.mReportPicsGv.setSelectedPhotoList(FecUtil.getFilePaths(mPictures));
        }
    }

    private void initData() {
        this.mId = getActivity().getIntent().getStringExtra(POPULATION_HOUSE_ID);
        Log.d(TAG, "Id: " + this.mId);
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pop_house_detail_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        this.mNameText = (TextView) view.findViewById(R.id.et_population_house_name);
        this.mIdentityText = (TextView) view.findViewById(R.id.et_population_house_identity);
        this.mPhoneText = (TextView) view.findViewById(R.id.et_population_house_phone);
        this.mAddressText = (TextView) view.findViewById(R.id.et_population_house_address);
        this.mCommunityText = (TextView) view.findViewById(R.id.et_population_house_community);
        this.mCommunityCodeText = (TextView) view.findViewById(R.id.et_population_house_community_code);
        this.mManagerText = (TextView) view.findViewById(R.id.et_population_house_manager);
        this.mManagerPhoneText = (TextView) view.findViewById(R.id.et_population_house_manager_phone);
        this.mDistanceText = (TextView) view.findViewById(R.id.et_population_house_distance);
        this.mNoteText = (TextView) view.findViewById(R.id.et_population_house_note);
        ((ImageView) view.findViewById(R.id.iv_back)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PopHouseDetailFragment.this.getActivity().finish();
            }
        });
        this.mReportPicsGv = (SelectPhotoView) view.findViewById(R.id.gv_report_pic);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getFromDataBase(this.mId);
    }

    private void getFromDataBase(final String id) {
        new AsyncTask() {
            protected Object doInBackground(Object[] params) {
                PopHouseDetailFragment.this.populationHouse = ReportDao.getInstance().getHouse(id);
                return null;
            }

            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                Message msg = new Message();
                msg.what = 10001;
                PopHouseDetailFragment.this.mHandler.sendMessage(msg);
            }
        }.execute(new Object[0]);
    }
}
