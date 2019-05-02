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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.fec.report.dao.PopulationFamily;
import com.fec.xjoneproject.ui.report.dao.ReportDao;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneproject.R;
import java.io.File;

public class PopFamilyDetailFragment extends Fragment {
    public static final String FAMILY_ID = "family_id";
    private static final String TAG = "PopFamilyDetailFragment";
    private final int HANDLER_FLAG = 100000;
    private TextView mAddressText;
    private Handler mHandler;
    private String mId;
    private TextView mIdentityText;
    private ImageView mImageView;
    private TextView mNameText;
    private TextView mNoteText;
    private TextView mPhoneText;
    private TextView mRelationText;
    private PopulationFamily populationFamily;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 100000:
                        if (PopFamilyDetailFragment.this.populationFamily != null) {
                            PopFamilyDetailFragment.this.setData();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        initData();
    }

    private void setData() {
        this.mNameText.setText(this.populationFamily.getName());
        this.mIdentityText.setText(this.populationFamily.getIdCard());
        this.mAddressText.setText(this.populationFamily.getResidence());
        this.mRelationText.setText(this.populationFamily.getRelationWithFloatingPopulation());
        this.mNoteText.setText(this.populationFamily.getNote());
        this.mPhoneText.setText(this.populationFamily.getPhone());
        String mPortraitPath = this.populationFamily.getHeadPortrait();
        if (mPortraitPath != null && !TextUtils.isEmpty(mPortraitPath)) {
            if (mPortraitPath.startsWith("http://")) {
                Glide.with(IMSDroid.getContext()).load(mPortraitPath).error((int) R.drawable.defaout_no_pic).into(this.mImageView);
            } else {
                Glide.with(IMSDroid.getContext()).load(new File(mPortraitPath)).error((int) R.drawable.defaout_no_pic).into(this.mImageView);
            }
        }
    }

    private void initData() {
        this.mId = getActivity().getIntent().getStringExtra(FAMILY_ID);
        Log.d(TAG, "Id: " + this.mId);
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pop_family_detail_fragment, container, false);
        this.mNameText = (TextView) view.findViewById(R.id.tv_population_family_name);
        this.mIdentityText = (TextView) view.findViewById(R.id.tv_population_family_identity);
        this.mPhoneText = (TextView) view.findViewById(R.id.tv_population_family_phone);
        this.mAddressText = (TextView) view.findViewById(R.id.tv_population_family_address);
        this.mRelationText = (TextView) view.findViewById(R.id.tv_population_family_relationship);
        this.mNoteText = (TextView) view.findViewById(R.id.tv_population_family_note);
        this.mImageView = (ImageView) view.findViewById(R.id.iv_population_family_portrait);
        ((ImageButton) view.findViewById(R.id.iv_back)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PopFamilyDetailFragment.this.getActivity().finish();
            }
        });
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPopulationFamily(this.mId);
    }

    private void getPopulationFamily(final String id) {
        new AsyncTask() {
            protected Object doInBackground(Object[] params) {
                PopFamilyDetailFragment.this.populationFamily = ReportDao.getInstance().getPopulationFamilyById(id);
                return null;
            }

            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                Message msg = new Message();
                msg.what = 100000;
                PopFamilyDetailFragment.this.mHandler.sendMessage(msg);
            }
        }.execute(new Object[0]);
    }
}
