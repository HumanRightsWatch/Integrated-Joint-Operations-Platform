package com.fec.xjoneproject.ui.report.collection;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.fec.report.dao.Comparison;
import com.fec.report.dao.ComparisonDao.Properties;
import com.fec.xjoneproject.dao.OneProjectDao;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.ui.report.bean.ComparisonResult;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.fec.xjoneproject.ui.view.SelectPhotoView.OnSimpleFragment;
import com.hbfec.xjoneinformation.databinding.FragmentComparisonBinding;
import com.hbfec.xjoneproject.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import org.greenrobot.greendao.query.WhereCondition;

public class ComparisonFragment extends Fragment {
    private static final String ARG_FILE_PATH = "filePath";
    private static final String ARG_FRAGMENT_EDITABLE = "fragment_editable";
    private static final String ARG_INTERFACE_COUNT = "hiklf_interface_count";
    FragmentComparisonBinding binding;
    private boolean mEditable = true;
    private String mFilePath;
    private int mHiklfInterfaceCount = 0;
    private Long mPersonId;
    List<ComparisonResult> mResultList = null;
    ComparisonViewModel mViewModel;

    public List<ComparisonResult> getResultList() {
        return this.mResultList;
    }

    public ComparisonResult getResult() {
        if (this.mResultList == null || this.mResultList.size() == 0) {
            return null;
        }
        return (ComparisonResult) this.mResultList.get(0);
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public static ComparisonFragment newInstance(Long id, int count, String filePath, Boolean editable) {
        ComparisonFragment fragment = new ComparisonFragment();
        Bundle args = new Bundle();
        if (id != null) {
            args.putLong(TaskConstant.ARG_KEY_ID, id.longValue());
        }
        args.putInt(ARG_INTERFACE_COUNT, count);
        args.putString(ARG_FILE_PATH, filePath);
        args.putBoolean(ARG_FRAGMENT_EDITABLE, editable.booleanValue());
        fragment.setArguments(args);
        return fragment;
    }

    public static ComparisonFragment newInstance(boolean editable) {
        ComparisonFragment fragment = new ComparisonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INTERFACE_COUNT, 3);
        args.putBoolean(ARG_FRAGMENT_EDITABLE, editable);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mFilePath = getArguments().getString(ARG_FILE_PATH);
            this.mHiklfInterfaceCount = getArguments().getInt(ARG_INTERFACE_COUNT);
            this.mPersonId = Long.valueOf(getArguments().getLong(TaskConstant.ARG_KEY_ID));
            this.mEditable = getArguments().getBoolean(ARG_FRAGMENT_EDITABLE);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = (FragmentComparisonBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_comparison, container, false);
        this.mViewModel = new ComparisonViewModel(this);
        this.binding.setViewModel(this.mViewModel);
        this.mViewModel.editable.set(this.mEditable);
        initFragment();
        return this.binding.getRoot();
    }

    public void initFragment() {
        this.mViewModel.showComparisonButton.set(true);
        this.mViewModel.showOtherImage.set(false);
        this.mViewModel.queryError.set(false);
        this.mViewModel.querySuccess.set(false);
        if (!TextUtils.isEmpty(this.mFilePath)) {
            File file = new File(this.mFilePath);
            if (file.exists()) {
                this.binding.postPhotoImageView.setImageURI(Uri.fromFile(file));
            } else if (!this.mFilePath.startsWith("FileManager")) {
                this.mFilePath = null;
                return;
            }
            if (this.mPersonId != null && this.mPersonId.longValue() != -1) {
                if (this.mResultList == null) {
                    List<Comparison> comparisonList = getLocalComparisonList(this.mPersonId.longValue());
                    this.mResultList = new ArrayList();
                    for (Comparison comparison : comparisonList) {
                        this.mResultList.add(new ComparisonResult(comparison));
                    }
                }
                if (this.mResultList.size() == 0) {
                    return;
                }
                if (file.exists()) {
                    querySuccess(this.mResultList);
                } else {
                    showComparisonResult((ComparisonResult) this.mResultList.get(0), this.mFilePath);
                }
            }
        }
    }

    public static List<Comparison> getLocalComparisonList(long personId) {
        return OneProjectDao.getInstance().getDaoSession().getComparisonDao().queryBuilder().where(Properties.PersonId.eq(Long.valueOf(personId)), new WhereCondition[0]).list();
    }

    public void querySuccess(List<ComparisonResult> result) {
        if (result.size() > 2) {
            this.mViewModel.showOtherImage.set(true);
            this.mViewModel.showComparisonButton.set(false);
            this.mResultList = result;
            this.binding.face1PhotoImageView.setImageBitmap(SelectPhotoView.base64ToBitmap(((ComparisonResult) this.mResultList.get(0)).getFacePicUrl()));
            this.binding.face2PhotoImageView.setImageBitmap(SelectPhotoView.base64ToBitmap(((ComparisonResult) this.mResultList.get(1)).getFacePicUrl()));
            this.binding.face3PhotoImageView.setImageBitmap(SelectPhotoView.base64ToBitmap(((ComparisonResult) this.mResultList.get(2)).getFacePicUrl()));
            this.binding.setResult((ComparisonResult) result.get(0));
            this.mViewModel.queryError.set(false);
            this.mViewModel.similarityText.set(getString(R.string.similarityFormat, Double.valueOf(100.0d * Double.parseDouble(((ComparisonResult) result.get(0)).getSimilarity()))));
            return;
        }
        this.mViewModel.queryError.set(true);
        this.mViewModel.similarityText.set(getString(R.string.check_person_error));
    }

    public static void startSelectPictureActivity(Context context, ArrayList<String> fileList, Fragment fragment, int requestCode) {
        SelectPhotoView.selectPicture(context, true, true, 1, fileList, new OnSimpleFragment(fragment), requestCode);
    }

    public void save(final long personInfoId) {
        final List<Comparison> comparisonList = new ArrayList();
        if (this.mResultList == null) {
            this.mResultList = new ArrayList();
        }
        for (ComparisonResult result : this.mResultList) {
            if (result != null) {
                Comparison comparison = new Comparison();
                comparison.setPersonId(Long.valueOf(personInfoId));
                comparison.setFacePhoto(result.getFacePicUrl());
                comparison.setSimilarity(result.getSimilarity());
                comparison.setName(result.getHumanName());
                comparison.setCard(result.getCredentialsNum());
                comparison.setAction(result.getDisposalmeasures());
                comparisonList.add(comparison);
            }
        }
        OneProjectDao.getInstance().getDaoSession().runInTx(new Runnable() {
            public void run() {
                OneProjectDao.getInstance().getDaoSession().getComparisonDao().deleteInTx(ComparisonFragment.getLocalComparisonList(personInfoId));
                OneProjectDao.getInstance().getDaoSession().getComparisonDao().insertOrReplaceInTx(comparisonList);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 10000) {
            this.mFilePath = (String) data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT).get(0);
            this.mResultList = new ArrayList();
            this.binding.face1PhotoImageView.setImageResource(R.drawable.default_useravatar);
            this.binding.face2PhotoImageView.setImageResource(R.drawable.default_useravatar);
            this.binding.face3PhotoImageView.setImageResource(R.drawable.default_useravatar);
            initFragment();
        }
    }

    public int getHiklfInterfaceCount() {
        return this.mHiklfInterfaceCount;
    }

    public void showComparisonResult(ComparisonResult result, String addPic) {
        if (!TextUtils.isEmpty(addPic)) {
            Glide.with(getContext()).load(AttendanceService.getBaseUrl() + addPic).centerCrop().skipMemoryCache(false).placeholder((int) R.drawable.default_useravatar).error((int) R.drawable.defaout_no_pic).into(this.binding.postPhotoImageView);
            Glide.with(getContext()).load(AttendanceService.getBaseUrl() + result.getFacePicUrl()).centerCrop().skipMemoryCache(false).placeholder((int) R.drawable.default_useravatar).error((int) R.drawable.defaout_no_pic).into(this.binding.face1PhotoImageView);
            this.mResultList = new ArrayList();
            this.mResultList.add(result);
            this.mFilePath = addPic;
            this.binding.setResult(result);
            this.mViewModel.queryError.set(false);
            this.mViewModel.similarityText.set(getString(R.string.similarityFormat, Double.valueOf(100.0d * Double.parseDouble(result.getSimilarity()))));
            this.mViewModel.showOtherImage.set(false);
            this.mViewModel.showComparisonButton.set(false);
            this.mViewModel.querySuccess.set(true);
        }
    }

    public void addQueryCount() {
        this.mHiklfInterfaceCount++;
    }
}
