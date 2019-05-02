package com.fec.xjoneproject.ui.report.collection.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.fec.report.dao.CommonSaveInfo;
import com.fec.xjoneproject.privilege.util.PrivilegeUtil;
import com.fec.xjoneproject.ui.report.bean.ReportInfoEntity;
import com.fec.xjoneproject.ui.report.collection.fragment.CollectionBaseFragment;
import com.fec.xjoneproject.ui.report.collection.fragment.CollectionForeignFragment;
import com.fec.xjoneproject.ui.report.collection.fragment.CollectionPersonFragment;
import com.fec.xjoneproject.ui.report.collection.fragment.CollectionPersonFragment.CollectionPersonListener;
import com.fec.xjoneproject.ui.task.CommonLocalSaveHelper;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleSpinnerFieldView;
import com.fec.xjoneproject.ui.view.field.OneProjectSimpleSpinnerFieldView.OnItemSelectedListener;
import com.fec.xjoneproject.util.SpinnerItem;
import com.hbfec.xjoneproject.R;
import java.util.ArrayList;
import java.util.List;

public class CollectionActivity extends AppCompatActivity implements OnItemSelectedListener, CollectionPersonListener {
    @Bind({2131296382})
    ImageButton btnSave;
    private int foreignSpinnerItemID = 7;
    private Boolean fromNet = Boolean.valueOf(false);
    private CommonSaveInfo mCommonSaveInfo;
    private CollectionBaseFragment mFragment;
    private ReportInfoEntity reportInfoEntity;
    @Bind({2131297760})
    ScrollView scrollView;
    @Bind({2131297905})
    OneProjectSimpleSpinnerFieldView themeOneProjectSimpleSpinnerFieldView;
    @Bind({2131298191})
    TextView tvPopulationQueryNew;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_collection);
        ButterKnife.bind((Activity) this);
        this.mCommonSaveInfo = (CommonSaveInfo) getIntent().getParcelableExtra(TaskConstant.ARG_KEY_ENTITY);
        this.reportInfoEntity = (ReportInfoEntity) getIntent().getSerializableExtra("ReportInfoEntity");
        List<SpinnerItem> themeList = new ArrayList();
        if (PrivilegeUtil.isHavePrivilege(PrivilegeUtil.PRIVILEGE_RIGHT_REPORT_COLLECTION)) {
            themeList.add(new SpinnerItem(Integer.valueOf(1), "入户采集"));
            themeList.add(new SpinnerItem(Integer.valueOf(2), "街面采集"));
            themeList.add(new SpinnerItem(Integer.valueOf(3), "教育培训中心采集"));
            themeList.add(new SpinnerItem(Integer.valueOf(4), "出境人员报备"));
            themeList.add(new SpinnerItem(Integer.valueOf(5), "内地新疆籍人员采集"));
        }
        if (PrivilegeUtil.isHavePrivilege(PrivilegeUtil.PRIVILEGE_RIGHT_REPORT_FOREIGN)) {
            themeList.add(new SpinnerItem(Integer.valueOf(this.foreignSpinnerItemID), "外籍人员入境信息采集"));
        }
        if (themeList.size() != 1) {
            themeList.add(0, new SpinnerItem(Integer.valueOf(0), "未选择"));
        }
        this.themeOneProjectSimpleSpinnerFieldView.setSpinnerEntries(themeList);
        this.themeOneProjectSimpleSpinnerFieldView.setOnItemSelectedListener(this);
        if (this.mCommonSaveInfo != null) {
            this.themeOneProjectSimpleSpinnerFieldView.setValue((Integer) CommonLocalSaveHelper.getEntity(this.mCommonSaveInfo, "theme", Integer.class));
            if (this.mCommonSaveInfo.getStatus().intValue() == 1) {
                this.btnSave.setVisibility(8);
                this.themeOneProjectSimpleSpinnerFieldView.setEditable(false);
            } else {
                this.btnSave.setVisibility(0);
                this.themeOneProjectSimpleSpinnerFieldView.setEditable(true);
            }
        }
        if (this.reportInfoEntity != null) {
            this.themeOneProjectSimpleSpinnerFieldView.setValue(this.reportInfoEntity.getPersonInfoEntity().getInfoCollectionType());
            if (this.mCommonSaveInfo == null) {
                this.fromNet = Boolean.valueOf(true);
                this.btnSave.setVisibility(8);
                this.themeOneProjectSimpleSpinnerFieldView.setEditable(false);
            }
        }
    }

    @OnClick({2131296999, 2131296382, 2131298191})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                showSaveDialog();
                return;
            case R.id.iv_back:
                finish();
                return;
            case R.id.tv_population_query_new:
                if (this.mFragment instanceof CollectionPersonFragment) {
                    ((CollectionPersonFragment) this.mFragment).searchPersonInTheSameHouse();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onItemSelected(SpinnerItem item) {
        showCheck(false);
        if (item.getId().intValue() == 0) {
            if (PrivilegeUtil.isHavePrivilege(PrivilegeUtil.PRIVILEGE_RIGHT_REPORT_COLLECTION)) {
                showCollectionPersonFragment();
            } else if (PrivilegeUtil.isHavePrivilege(PrivilegeUtil.PRIVILEGE_RIGHT_REPORT_FOREIGN)) {
                showCollectionForeignFragment();
            }
        } else if (item.getId().intValue() == this.foreignSpinnerItemID) {
            if (!(this.mFragment instanceof CollectionForeignFragment)) {
                showCollectionForeignFragment();
            }
        } else if (this.mFragment instanceof CollectionPersonFragment) {
            ((CollectionPersonFragment) this.mFragment).setTheme(item.getId().intValue());
        } else {
            showCollectionPersonFragment();
        }
        int state = 0;
        if (this.mCommonSaveInfo != null) {
            state = this.mCommonSaveInfo.getStatus().intValue();
        }
        if (this.mFragment != null) {
            if (state == 1) {
                this.mFragment.setEditable(Boolean.valueOf(false));
            } else {
                this.mFragment.setEditable(Boolean.valueOf(true));
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.collectionFragmentContainer, this.mFragment).commit();
        }
        if (this.fromNet.booleanValue()) {
            this.mFragment.setEditable(Boolean.valueOf(false));
        }
    }

    private void showCollectionForeignFragment() {
        this.mFragment = CollectionForeignFragment.newInstance(this.mCommonSaveInfo);
    }

    private void showCollectionPersonFragment() {
        this.mFragment = CollectionPersonFragment.newInstance(this.mCommonSaveInfo);
    }

    private void showSaveDialog() {
        Builder builder = new Builder(this, R.style.CommonDialog);
        builder.setItems((int) R.array.report_operation_type, new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        CollectionActivity.this.mFragment.submitWithUploadPhoto(CollectionActivity.this.scrollView);
                        return;
                    case 1:
                        CollectionActivity.this.mFragment.localSaveInfo();
                        CollectionActivity.this.setResult(-1, new Intent());
                        CollectionActivity.this.finish();
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

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.collectionFragmentContainer);
        if (fragment instanceof CollectionPersonFragment) {
            ((CollectionPersonFragment) fragment).onNewIntent(intent);
        }
    }

    public void showCheck(boolean show) {
        this.tvPopulationQueryNew.setVisibility(show ? 0 : 8);
    }
}
