package com.fec.xjoneproject.ui.report.collection;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog.Builder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.baidu.location.BDLocation;
import com.fec.xjoneproject.ui.WaitingDialogBaseFragment;
import com.fec.xjoneproject.ui.report.AreaListActivity;
import com.fec.xjoneproject.ui.report.AreaListFragment;
import com.fec.xjoneproject.ui.report.HomeInfoFragment;
import com.fec.xjoneproject.ui.report.bean.BuildingInfoEntity;
import com.fec.xjoneproject.ui.report.collection.activity.CollectionActivity;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.fec.xjoneproject.util.FecUtil;
import com.fec.xjoneproject.util.LocationHelper;
import com.fec.xjoneproject.util.LocationHelper.LocationListener;
import com.fec.xjoneproject.util.ToastUtil;
import com.github.mikephil.charting.utils.Utils;
import com.hbfec.xjoneproject.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.xiaomi.mipush.sdk.Constants;
import fr.ganfra.materialspinner.MaterialSpinner;
import java.util.ArrayList;
import java.util.List;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class PopulationQueryFragment extends Fragment implements OnClickListener, LocationListener {
    public static final int BUILDING_REQUEST = 1001;
    @Bind({2131296382})
    ImageButton mAddBtn;
    @Bind({2131296602})
    MaterialEditText mAddressText;
    private String mAreaId;
    private String mAreaName;
    @Bind({2131296888})
    ImageButton mBackBtn;
    @Bind({2131297100})
    LinearLayout mBuildingAreaErrorLayout;
    @Bind({2131297964})
    TextView mBuildingAreaTv;
    private BuildingInfoEntity mBuildingInfo;
    @Bind({2131296360})
    ImageButton mEditBtn;
    @Bind({2131298046})
    TextView mEditPhotoTv;
    private Double mLatitude;
    private Double mLongitude;
    private boolean mOnlinePhoto = false;
    private Boolean mReadOnlyMode;
    @Bind({2131296848})
    SelectPhotoView mReportPicture;
    @Bind({2131298313})
    TextView mTitleText;
    private List<String> mUploadImgs = new ArrayList();
    @Bind({2131297819})
    MaterialSpinner mUseSpinner;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WaitingDialogBaseFragment mWaitingDialog = new WaitingDialogBaseFragment(getActivity());
        this.mBuildingInfo = (BuildingInfoEntity) getActivity().getIntent().getSerializableExtra("peer_bean");
        String imgs = getActivity().getIntent().getStringExtra("item_list");
        this.mReadOnlyMode = Boolean.valueOf(getActivity().getIntent().getBooleanExtra(HomeInfoFragment.ARG_READ_ONLY_MODE, false));
        if (!TextUtils.isEmpty(imgs)) {
            this.mUploadImgs = FecUtil.getStringItems(imgs);
        }
        if (this.mBuildingInfo != null) {
            this.mAreaName = this.mBuildingInfo.getVillage();
            this.mAreaId = this.mBuildingInfo.getVillageCode();
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report_building, container, false);
        ButterKnife.bind((Object) this, view);
        this.mBackBtn.setOnClickListener(this);
        this.mTitleText.setText(R.string.report_building_info);
        this.mReportPicture.setFragmentReference(this);
        this.mReportPicture.setEditable(!this.mReadOnlyMode.booleanValue());
        this.mEditPhotoTv.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PopulationQueryFragment.this.setOnlinePhoto(false, PopulationQueryFragment.this.mReadOnlyMode.booleanValue());
            }
        });
        if (!(this.mBuildingInfo == null || TextUtils.isEmpty(this.mBuildingInfo.getPkBi())) || this.mReadOnlyMode.booleanValue()) {
            setViewEnable(false);
        }
        if (this.mReadOnlyMode.booleanValue()) {
            this.mAddBtn.setVisibility(8);
            this.mEditBtn.setVisibility(8);
        } else {
            if (this.mBuildingInfo == null || TextUtils.isEmpty(this.mBuildingInfo.getPkBi())) {
                this.mEditBtn.setVisibility(8);
                this.mAddBtn.setVisibility(0);
            } else {
                this.mEditBtn.setVisibility(0);
                this.mAddBtn.setVisibility(8);
            }
            this.mAddBtn.setOnClickListener(this);
            this.mEditBtn.setOnClickListener(this);
            this.mBuildingAreaTv.setOnClickListener(this);
        }
        initData();
        return view;
    }

    private void setViewEnable(boolean isEnable) {
        this.mAddressText.setEnabled(isEnable);
        this.mUseSpinner.setEnabled(isEnable);
        this.mBuildingAreaTv.setEnabled(isEnable);
    }

    private void showSaveDialog() {
        Builder builder = new Builder(getActivity(), R.style.CommonDialog);
        builder.setItems((int) R.array.collection_operation_type, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        PopulationQueryFragment.this.saveAction();
                        return;
                    case 1:
                        dialog.cancel();
                        return;
                    default:
                        return;
                }
            }
        });
        builder.create().show();
    }

    private void showEditDialog() {
        Builder builder = new Builder(getActivity(), R.style.CommonDialog);
        builder.setItems((int) R.array.collection_edit_operation_type, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        PopulationQueryFragment.this.resetAction();
                        return;
                    case 1:
                        PopulationQueryFragment.this.mEditBtn.setVisibility(8);
                        PopulationQueryFragment.this.mAddBtn.setVisibility(0);
                        PopulationQueryFragment.this.setViewEnable(true);
                        PopulationQueryFragment.this.setOnlinePhoto(true, false);
                        return;
                    case 2:
                        dialog.cancel();
                        return;
                    default:
                        return;
                }
            }
        });
        builder.create().show();
    }

    private void initData() {
        boolean z = false;
        if (this.mBuildingInfo != null) {
            if (!TextUtils.isEmpty(this.mBuildingInfo.getVillage())) {
                this.mAreaId = this.mBuildingInfo.getVillageCode();
                this.mAreaName = this.mBuildingInfo.getVillage();
                this.mBuildingAreaTv.setText(this.mBuildingInfo.getVillage());
            }
            if (!TextUtils.isEmpty(this.mBuildingInfo.getAddress())) {
                this.mAddressText.setText(this.mBuildingInfo.getAddress());
            }
            this.mUseSpinner.setSelection(this.mBuildingInfo.getUse(), false);
            if (this.mBuildingInfo.getModifyType() == 1) {
                if (!TextUtils.isEmpty(this.mBuildingInfo.getPhoto())) {
                    List photos = FecUtil.getStringItems(this.mBuildingInfo.getPhoto());
                    if (photos.size() > 0) {
                        if (this.mReadOnlyMode.booleanValue() || !TextUtils.isEmpty(this.mBuildingInfo.getPkBi())) {
                            z = true;
                        }
                        setOnlinePhoto(true, z);
                        this.mReportPicture.setSelectedPhotoList(photos);
                    }
                }
            } else if (!TextUtils.isEmpty(this.mBuildingInfo.getPhoto())) {
                this.mReportPicture.setSelectedPhotoList(this.mBuildingInfo.getPhoto().split(Constants.ACCEPT_TIME_SEPARATOR_SP));
            }
        }
    }

    private void setOnlinePhoto(boolean onlinePhoto, boolean isReadOnlyMode) {
        this.mOnlinePhoto = onlinePhoto;
        if (isReadOnlyMode) {
            this.mEditPhotoTv.setVisibility(8);
            this.mReportPicture.setEditable(false);
            this.mBuildingInfo.setModifyType(1);
        } else if (this.mOnlinePhoto) {
            this.mEditPhotoTv.setVisibility(0);
            this.mReportPicture.setEditable(false);
            this.mBuildingInfo.setModifyType(1);
        } else {
            this.mEditPhotoTv.setVisibility(8);
            this.mReportPicture.setEditable(true);
            this.mReportPicture.clear();
            this.mBuildingInfo.setModifyType(0);
        }
    }

    public void onResume() {
        super.onResume();
        LocationHelper.getInstance().addLocationListener(this);
    }

    public void onPause() {
        super.onPause();
        LocationHelper.getInstance().removeLocationListener(this);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == -1 && requestCode == 10000) {
            this.mUploadImgs = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
            this.mReportPicture.setSelectedPhotoList(this.mUploadImgs);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_edit:
                showEditDialog();
                return;
            case R.id.btn_save:
                showSaveDialog();
                return;
            case R.id.ibtn_back:
                getActivity().finish();
                return;
            case R.id.tv_building_area:
                showAreaList();
                return;
            default:
                return;
        }
    }

    private void resetAction() {
        Intent personIntent = new Intent(getActivity(), CollectionActivity.class);
        personIntent.putExtra(TaskConstant.ARG_KEY_ID, 3);
        personIntent.addFlags(67108864);
        startActivity(personIntent);
    }

    public String checkInputAction() {
        String result = null;
        if (this.mAreaName == null) {
            this.mBuildingAreaErrorLayout.setVisibility(0);
            result = "请选择所在地区";
        }
        if (TextUtils.isEmpty(this.mAddressText.getText().toString())) {
            this.mAddressText.setError("请输入建筑地址");
            if (TextUtils.isEmpty(result)) {
                result = "请输入建筑地址";
            }
        } else if (this.mAddressText.getText().length() > 250) {
            this.mAddressText.setError("建筑地址长度不能大于250个字符");
            if (TextUtils.isEmpty(result)) {
                result = "建筑地址长度不能大于250个字符";
            }
        }
        if (this.mUseSpinner.getSelectedItemPosition() != 0) {
            return result;
        }
        this.mUseSpinner.setError((CharSequence) "请选择房屋用途");
        if (TextUtils.isEmpty(result)) {
            return "请选择房屋用途";
        }
        return result;
    }

    private void saveAction() {
        Intent personIntent;
        if (this.mBuildingInfo == null || !this.mOnlinePhoto) {
            String error = checkInputAction();
            if (TextUtils.isEmpty(error)) {
                makeBuildingInfo();
                personIntent = new Intent(getActivity(), CollectionActivity.class);
                personIntent.putExtra(TaskConstant.ARG_KEY_ID, 1);
                personIntent.putExtra("peer_bean", this.mBuildingInfo);
                personIntent.addFlags(67108864);
                if (this.mUploadImgs.size() > 0) {
                    personIntent.putExtra("item_list", FecUtil.listToString(this.mUploadImgs, ','));
                }
                startActivity(personIntent);
                return;
            }
            ToastUtil.showToast(error);
            return;
        }
        makeBuildingInfo();
        personIntent = new Intent(getActivity(), CollectionActivity.class);
        personIntent.putExtra(TaskConstant.ARG_KEY_ID, 1);
        personIntent.putExtra("peer_bean", this.mBuildingInfo);
        personIntent.addFlags(67108864);
        startActivity(personIntent);
    }

    private void makeBuildingInfo() {
        if (this.mBuildingInfo == null) {
            this.mBuildingInfo = new BuildingInfoEntity();
            this.mBuildingInfo.setPkBi(null);
        }
        this.mBuildingInfo.setVillage(this.mAreaName);
        this.mBuildingInfo.setVillageCode(this.mAreaId);
        this.mBuildingInfo.setAddress(this.mAddressText.getText().toString());
        this.mBuildingInfo.setUse(this.mUseSpinner.getSelectedItemPosition());
        if (!(this.mOnlinePhoto || this.mReportPicture.getSelectedPhotoList() == null)) {
            this.mBuildingInfo.setPhoto(FecUtil.listToString(this.mReportPicture.getSelectedPhotoList(), ','));
        }
        if (this.mBuildingInfo.getLongitude() == null || this.mBuildingInfo.getLongitude().doubleValue() == Utils.DOUBLE_EPSILON) {
            this.mBuildingInfo.setLongitude(this.mLongitude);
        }
        if (this.mBuildingInfo.getLatitude() == null || this.mBuildingInfo.getLatitude().doubleValue() == Utils.DOUBLE_EPSILON) {
            this.mBuildingInfo.setLatitude(this.mLatitude);
        }
    }

    private void showAreaList() {
        Intent intent = new Intent(getActivity(), AreaListActivity.class);
        intent.putExtra("pid", "65");
        intent.putExtra("prename", "");
        intent.putExtra("deep", 0);
        AreaListFragment.requesttype = 2;
        startActivity(intent);
    }

    public void onNewIntent(Intent intent) {
        if ((67108864 & intent.getFlags()) != 0) {
            this.mAreaName = intent.getStringExtra("areaname");
            this.mAreaId = intent.getStringExtra("areaid");
            if (this.mAreaName != null) {
                this.mBuildingAreaErrorLayout.setVisibility(8);
                this.mBuildingAreaTv.setText(this.mAreaName);
            }
        }
    }

    public void onLocationSuccess(BDLocation location) {
        this.mLatitude = Double.valueOf(location.getLatitude());
        this.mLongitude = Double.valueOf(location.getLongitude());
    }

    public void onLocationFail(BDLocation location, String msg) {
    }
}
