package com.fec.xjoneproject.ui.task.radio_personnel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.ui.map.MapRadioPersonnelResponse;
import com.fec.xjoneproject.ui.task.bean.MatchPerWarnEntity;
import com.fec.xjoneproject.util.FecUtil;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.fec.xjoneproject.util.ToastUtil;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneproject.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MapRadioPersonnelDetailFragment extends Fragment {
    private static final int HANDLER_FLAG = 1000;
    public static final String POPULATION_BASEINFO_ID = "population_base_id";
    private static final String TAG = "MapRadioPersonnelDetailFragment";
    @Bind({2131296888})
    ImageButton mBack;
    @Bind({2131297003})
    ImageView mCollectPhoto;
    @Bind({2131298044})
    TextView mDeviceCodeTextView;
    @Bind({2131297940})
    TextView mDeviceLocationTextView;
    @Bind({2131298042})
    TextView mDisposalMeansTextView;
    private MatchPerWarnEntity mEntity;
    @Bind({2131297941})
    TextView mGatherTimeTextView;
    private Handler mHandler;
    private String mId;
    @Bind({2131297015})
    ImageView mIdCardPhotoImageView;
    @Bind({2131298077})
    TextView mIdTagsTextView;
    @Bind({2131298078})
    TextView mIdentityTextView;
    @Bind({2131298080})
    TextView mImeiTextView;
    @Bind({2131298081})
    TextView mImsiTextView;
    @Bind({2131298111})
    TextView mMacTextView;
    @Bind({2131298121})
    TextView mNameTextView;
    @Bind({2131298131})
    TextView mNoteTextView;
    @Bind({2131298238})
    TextView mSimilarityTextView;
    @Bind({2131298045})
    TextView mStationIdTextView;
    @Bind({2131298316})
    TextView mTypeTextView;

    public static MapRadioPersonnelDetailFragment newInstance(String id) {
        MapRadioPersonnelDetailFragment fragment = new MapRadioPersonnelDetailFragment();
        Bundle args = new Bundle();
        args.putString("population_base_id", id);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mId = getArguments().getString("population_base_id");
        }
        this.mHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1000:
                        if (MapRadioPersonnelDetailFragment.this.mEntity != null && !MapRadioPersonnelDetailFragment.this.getActivity().isFinishing()) {
                            MapRadioPersonnelDetailFragment.this.setData();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map_radio_personnel_detail, container, false);
        ButterKnife.bind((Object) this, rootView);
        this.mBack.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                MapRadioPersonnelDetailFragment.this.getActivity().finish();
            }
        });
        getDataFromNet(this.mId);
        return rootView;
    }

    private void getDataFromNet(String id) {
        try {
            AttendanceService.getApi().getRadioPersonDetail(id).enqueue(new OneProjectCallback<MapRadioPersonnelResponse>(this) {
                public void onResponse(MapRadioPersonnelResponse bean) {
                    List<MatchPerWarnEntity> list = bean.getRes();
                    if (list != null && list.size() != 0) {
                        MapRadioPersonnelDetailFragment.this.mEntity = (MatchPerWarnEntity) list.get(0);
                        Message msg = new Message();
                        msg.what = 1000;
                        MapRadioPersonnelDetailFragment.this.mHandler.sendMessage(msg);
                    }
                }
            });
        } catch (RetrofitUrlNullException e) {
            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
        }
    }

    @OnClick({2131297015, 2131297003})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_collect_photo:
                if (this.mEntity == null || TextUtils.isEmpty(this.mEntity.getGatherPhoto())) {
                    ToastUtil.showToast("当前无照片");
                    return;
                } else {
                    FecUtil.startImageActivity(getActivity(), this.mEntity.getGatherPhoto());
                    return;
                }
            case R.id.iv_id_card_photo:
                if (this.mEntity == null || TextUtils.isEmpty(this.mEntity.getIdCardPhoto())) {
                    ToastUtil.showToast("当前无照片");
                    return;
                } else {
                    FecUtil.startImageActivity(getActivity(), this.mEntity.getIdCardPhoto());
                    return;
                }
            default:
                return;
        }
    }

    private void setData() {
        this.mNameTextView.setText(this.mEntity.getName());
        this.mIdentityTextView.setText(this.mEntity.getIdCard());
        if (!TextUtils.isEmpty(this.mEntity.getIdCardPhoto())) {
            Glide.with(getActivity()).load(AttendanceService.getBaseUrl() + this.mEntity.getIdCardPhoto()).centerCrop().skipMemoryCache(true).placeholder((int) R.drawable.electricity_detail_photoicon).into(this.mIdCardPhotoImageView);
        }
        if (!TextUtils.isEmpty(this.mEntity.getGatherPhoto())) {
            Glide.with(getActivity()).load(AttendanceService.getBaseUrl() + this.mEntity.getGatherPhoto()).centerCrop().skipMemoryCache(true).placeholder((int) R.drawable.electricity_detail_photoicon).into(this.mCollectPhoto);
        }
        this.mSimilarityTextView.setText(this.mEntity.getSimilarity());
        this.mDeviceLocationTextView.setText(this.mEntity.getLocation());
        this.mDeviceCodeTextView.setText(this.mEntity.getDeviceCode());
        this.mStationIdTextView.setText(this.mEntity.getStationId());
        if (!TextUtils.isEmpty(this.mEntity.getGatherTime())) {
            Date data = new Date(Long.parseLong(this.mEntity.getGatherTime()));
            this.mGatherTimeTextView.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(data));
        }
        this.mIdTagsTextView.setText(this.mEntity.getLabel());
        this.mDisposalMeansTextView.setText(this.mEntity.getActionName());
        this.mImeiTextView.setText(this.mEntity.getImei());
        this.mImsiTextView.setText(this.mEntity.getImsi());
        this.mMacTextView.setText(this.mEntity.getMac());
        this.mNoteTextView.setText(this.mEntity.getNote());
        this.mTypeTextView.setText(this.mEntity.getMatchTypeName());
    }
}
