package com.fec.xjoneproject.ui.task.overdue_person;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.fec.xjoneproject.http.RetrofitUrlNullException;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.ui.WaitingDialogBaseFragment;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.task.bean.OverduePersonBean;
import com.fec.xjoneproject.ui.task.bean.OverduePersonResponse;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.fec.xjoneproject.util.DateUtil;
import com.fec.xjoneproject.util.FecUtil;
import com.fec.xjoneproject.util.OneProjectCallback;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneproject.R;
import java.lang.ref.WeakReference;
import java.util.List;
import retrofit2.Call;

public class OverduePersonDetailFragment extends Fragment {
    private String id;
    @Bind({2131297951})
    TextView mAddressTv;
    @Bind({2131296888})
    ImageButton mBackBtn;
    private OverduePersonBean mBean;
    private Call<OverduePersonResponse> mCall;
    @Bind({2131297974})
    TextView mCardNumberTv;
    @Bind({2131297975})
    TextView mCardTypeTv;
    @Bind({2131298049})
    TextView mEnterCountryTv;
    @Bind({2131298052})
    TextView mExitPortTv;
    @Bind({2131298053})
    TextView mExitReasonTv;
    @Bind({2131298056})
    TextView mExitTimeTv;
    private FragmentHandler mHandler = new FragmentHandler(this);
    @Bind({2131298075})
    TextView mIdCardTv;
    @Bind({2131298121})
    TextView mNameTv;
    @Bind({2131298122})
    TextView mNationTv;
    @Bind({2131298131})
    TextView mNote;
    @Bind({2131298173})
    TextView mPhoneTv;
    @Bind({2131297033})
    SelectPhotoView mSelectPhotoView;
    @Bind({2131298232})
    TextView mSexTv;
    @Bind({2131298095})
    TextView mTrackLocationTv;
    @Bind({2131298096})
    TextView mTrackTimeTv;
    private WaitingDialogBaseFragment mWaitingDialog;

    private static class FragmentHandler extends Handler {
        private WeakReference<OverduePersonDetailFragment> reference;

        FragmentHandler(OverduePersonDetailFragment fragment) {
            this.reference = new WeakReference(fragment);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            OverduePersonDetailFragment taskFragment = (OverduePersonDetailFragment) this.reference.get();
            switch (msg.what) {
                case 1000:
                    if (taskFragment != null && taskFragment.isAdded()) {
                        taskFragment.setDate();
                        taskFragment.mWaitingDialog.dismiss();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static OverduePersonDetailFragment newInstance(String id) {
        OverduePersonDetailFragment fragment = new OverduePersonDetailFragment();
        Bundle args = new Bundle();
        args.putString(TaskConstant.ARG_KEY_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.id = getArguments().getString(TaskConstant.ARG_KEY_ID);
        }
        this.mWaitingDialog = new WaitingDialogBaseFragment(getActivity(), "", true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_overdue_person_details, container, false);
        ButterKnife.bind((Object) this, rootView);
        this.mSelectPhotoView.setFragmentReference(this);
        this.mSelectPhotoView.setEditable(false);
        this.mBackBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                OverduePersonDetailFragment.this.cancelCall();
                OverduePersonDetailFragment.this.getActivity().finish();
            }
        });
        getDataFromNet(this.id);
        return rootView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void cancelCall() {
        if (this.mCall != null && this.mCall.isExecuted()) {
            this.mCall.cancel();
            this.mCall = null;
        }
    }

    private void getDataFromNet(String id) {
        this.mWaitingDialog.show();
        cancelCall();
        final WeakReference<OverduePersonDetailFragment> weakSelf = new WeakReference(this);
        try {
            this.mCall = AttendanceService.getApi().getOverduePersonWarn(id);
            this.mCall.enqueue(new OneProjectCallback<OverduePersonResponse>(this) {
                public void onResponse(OverduePersonResponse bean) {
                    OverduePersonDetailFragment fragment = (OverduePersonDetailFragment) weakSelf.get();
                    if (fragment != null) {
                        List<OverduePersonBean> beanList = bean.getRes();
                        if (beanList != null && beanList.size() > 0) {
                            fragment.mBean = (OverduePersonBean) beanList.get(0);
                        }
                        fragment.mHandler.sendEmptyMessage(1000);
                    }
                }
            });
        } catch (RetrofitUrlNullException e) {
            FecUtil.showUrlIsNullToast(IMSDroid.getContext());
            OverduePersonDetailFragment fragment = (OverduePersonDetailFragment) weakSelf.get();
            if (fragment != null) {
                fragment.mHandler.sendEmptyMessage(1000);
            }
        }
    }

    private void setDate() {
        if (this.mBean != null) {
            this.mNameTv.setText(this.mBean.getName());
            if (this.mBean.getSex() != null) {
                if (this.mBean.getSex().intValue() == 1) {
                    this.mSexTv.setText("男");
                } else if (this.mBean.getSex().intValue() == 0) {
                    this.mSexTv.setText("女");
                }
            }
            this.mNationTv.setText(this.mBean.getNationality());
            this.mPhoneTv.setText(this.mBean.getPhone());
            this.mAddressTv.setText(this.mBean.getCensusRegisterDetial());
            this.mIdCardTv.setText(this.mBean.getIdCard());
            this.mCardTypeTv.setText(this.mBean.getIdType());
            this.mCardNumberTv.setText(this.mBean.getIdNo());
            this.mExitPortTv.setText(this.mBean.getExitPort());
            this.mExitTimeTv.setText(DateUtil.friendlyTime(this.mBean.getExitTime()));
            this.mEnterCountryTv.setText(this.mBean.getDestCtry());
            this.mExitReasonTv.setText(this.mBean.getExitReason());
            this.mTrackTimeTv.setText(DateUtil.friendlyTime(this.mBean.getLastTrailTime()));
            this.mTrackLocationTv.setText(this.mBean.getLastTrailPosition());
            this.mSelectPhotoView.setSelectedPhotoList(this.mBean.getSpotPhoto());
            this.mNote.setText(this.mBean.getNote());
        }
    }
}
