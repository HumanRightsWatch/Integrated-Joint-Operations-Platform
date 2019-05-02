package com.fec.xjoneproject.ui.report.collection.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.fec.report.dao.CommonSaveInfo;
import com.fec.xjoneproject.ui.ListViewItemDeleteAnimation;
import com.fec.xjoneproject.ui.report.bean.PersonInfoEntity;
import com.fec.xjoneproject.ui.report.collection.bean.PersonInfoForeignEntity;
import com.fec.xjoneproject.ui.task.CommonLocalSaveHelper;
import com.hbfec.xjoneproject.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

public class ReportListAdapter extends BaseAdapter {
    private List<CommonSaveInfo> infoList = new ArrayList();
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public ReportListAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
    }

    public int getCount() {
        return this.infoList.size();
    }

    public Object getItem(int i) {
        return this.infoList.get(i);
    }

    public long getItemId(int i) {
        return ((CommonSaveInfo) this.infoList.get(i)).getId().longValue();
    }

    public void setInfoList(List<CommonSaveInfo> infoList) {
        this.infoList = infoList;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        String path;
        String[] images;
        convertView = this.mLayoutInflater.inflate(R.layout.fragment_population_list_item, null);
        ImageView mPortraitView = (ImageView) convertView.findViewById(R.id.image_suspicious_person);
        TextView mNameText = (TextView) convertView.findViewById(R.id.tv_population_info_name);
        TextView mStatusText = (TextView) convertView.findViewById(R.id.tv_population_info_status);
        TextView mAddressText = (TextView) convertView.findViewById(R.id.tv_population_info_address);
        TextView mIdentityText = (TextView) convertView.findViewById(R.id.tv_population_info_identity);
        ImageView mDelete = (ImageView) convertView.findViewById(R.id.iv_delete);
        CommonSaveInfo info = (CommonSaveInfo) this.infoList.get(position);
        if (info.getType().intValue() == 1005) {
            final PersonInfoForeignEntity entity = (PersonInfoForeignEntity) CommonLocalSaveHelper.getEntity(info, "entity", PersonInfoForeignEntity.class);
            if (entity != null) {
                path = entity.getVisaPic();
                if (!(path == null || TextUtils.isEmpty(path))) {
                    images = path.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (images.length > 0) {
                        Glide.with(this.mContext).load(images[0]).placeholder((int) R.drawable.defaout_no_pic).error((int) R.drawable.defaout_no_pic).into(mPortraitView);
                    }
                }
                mNameText.setText(entity.getName());
                mAddressText.setText(entity.getAddress());
                mIdentityText.setText(entity.getVisaNo());
                if (((CommonSaveInfo) this.infoList.get(position)).getStatus().intValue() == 0) {
                    mStatusText.setText("未发送");
                    mStatusText.setTextColor(this.mContext.getResources().getColor(R.color.black));
                } else {
                    mStatusText.setText("已发送");
                }
                mDelete.setVisibility(0);
                final View finalConvertView = convertView;
                final int i = position;
                mDelete.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        String name = "";
                        if (!TextUtils.isEmpty(entity.getName())) {
                            name = entity.getName() + "的";
                        }
                        ListViewItemDeleteAnimation.deletePatternWithDialog(ReportListAdapter.this.mContext, "删除 " + name + " 信息？", finalConvertView, new Runnable() {
                            public void run() {
                                if (ReportListAdapter.this.infoList != null) {
                                    CommonLocalSaveHelper.delete((CommonSaveInfo) ReportListAdapter.this.infoList.get(i));
                                    ReportListAdapter.this.infoList.remove(ReportListAdapter.this.infoList.get(i));
                                    ReportListAdapter.this.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                });
            }
        }
        if (info.getType().intValue() == 1006) {
            final PersonInfoEntity entity2 = (PersonInfoEntity) CommonLocalSaveHelper.getEntity(info, "entity", PersonInfoEntity.class);
            if (entity2 != null) {
                path = entity2.getPhoto();
                if (!(path == null || TextUtils.isEmpty(path))) {
                    images = path.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (images.length > 0) {
                        Glide.with(this.mContext).load(images[0]).placeholder((int) R.drawable.defaout_no_pic).error((int) R.drawable.defaout_no_pic).into(mPortraitView);
                    }
                }
                mNameText.setText(entity2.getName());
                mAddressText.setText(entity2.getAddress());
                mIdentityText.setText(entity2.getIdCard());
                if (((CommonSaveInfo) this.infoList.get(position)).getStatus().intValue() == 0) {
                    mStatusText.setText("未发送");
                    mStatusText.setTextColor(this.mContext.getResources().getColor(R.color.black));
                } else {
                    mStatusText.setText("已发送");
                }
                mDelete.setVisibility(0);
                finalConvertView = convertView;
                i = position;
                mDelete.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        String name = "";
                        if (!TextUtils.isEmpty(entity2.getName())) {
                            name = entity2.getName() + "的";
                        }
                        ListViewItemDeleteAnimation.deletePatternWithDialog(ReportListAdapter.this.mContext, "删除 " + name + " 信息？", finalConvertView, new Runnable() {
                            public void run() {
                                if (ReportListAdapter.this.infoList != null) {
                                    CommonLocalSaveHelper.delete((CommonSaveInfo) ReportListAdapter.this.infoList.get(i));
                                    ReportListAdapter.this.infoList.remove(ReportListAdapter.this.infoList.get(i));
                                    ReportListAdapter.this.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                });
            }
        }
        return convertView;
    }
}
