package com.fec.xjoneproject.ui.report.collection;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fec.report.dao.Comparison;
import com.fec.report.dao.ComparisonDao.Properties;
import com.fec.xjoneproject.dao.OneProjectDao;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.ui.report.bean.ComparisonResult;
import com.fec.xjoneproject.ui.report.bean.MapHumanResult;
import com.fec.xjoneproject.ui.task.TaskConstant;
import com.fec.xjoneproject.ui.view.SelectPhotoView;
import com.fec.xjoneproject.ui.view.SelectPhotoView.OnSimpleFragment;
import com.fec.xjoneproject.util.ToastUtil;
import com.hbfec.xjoneinformation.databinding.FragmentComparisonNewBinding;
import com.hbfec.xjoneproject.R;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.greenrobot.greendao.query.WhereCondition;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewComparisonFragment extends Fragment {
    private static final String ARG_FILE_PATH = "filePath";
    private static final String ARG_FRAGMENT_EDITABLE = "fragment_editable";
    FragmentComparisonNewBinding binding;
    private Boolean mEditable;
    private String mFilePath;
    private Long mPersonId;
    List<ComparisonResult> mResultList = null;

    public ComparisonResult getResult() {
        if (this.mResultList == null || this.mResultList.size() == 0) {
            return null;
        }
        return (ComparisonResult) this.mResultList.get(0);
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public static NewComparisonFragment newInstance(Long id, String filePath, Boolean editable) {
        NewComparisonFragment fragment = new NewComparisonFragment();
        Bundle args = new Bundle();
        if (id != null) {
            args.putLong(TaskConstant.ARG_KEY_ID, id.longValue());
        }
        args.putString(ARG_FILE_PATH, filePath);
        args.putBoolean(ARG_FRAGMENT_EDITABLE, editable.booleanValue());
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mFilePath = getArguments().getString(ARG_FILE_PATH);
            this.mPersonId = Long.valueOf(getArguments().getLong(TaskConstant.ARG_KEY_ID));
            this.mEditable = Boolean.valueOf(getArguments().getBoolean(ARG_FRAGMENT_EDITABLE));
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = (FragmentComparisonNewBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_comparison_new, container, false);
        this.binding.setListener(this);
        this.binding.setEditable(this.mEditable);
        if (TextUtils.isEmpty(this.mFilePath)) {
            takePhoto();
        } else {
            initFragment();
        }
        return this.binding.getRoot();
    }

    public void initFragment() {
        this.binding.postPhotoImageView.setImageURI(Uri.fromFile(new File(this.mFilePath)));
        if (this.mPersonId == null || this.mPersonId.longValue() == -1) {
            queryAgain();
            return;
        }
        if (this.mResultList == null) {
            List<Comparison> comparisonList = getLocalComparisonList(this.mPersonId.longValue());
            this.mResultList = new ArrayList();
            for (Comparison comparison : comparisonList) {
                this.mResultList.add(new ComparisonResult(comparison));
            }
        }
        if (this.mResultList.size() == 0) {
            queryAgain();
        } else {
            querySuccess(this.mResultList);
        }
    }

    public static List<Comparison> getLocalComparisonList(long personId) {
        return OneProjectDao.getInstance().getDaoSession().getComparisonDao().queryBuilder().where(Properties.PersonId.eq(Long.valueOf(personId)), new WhereCondition[0]).list();
    }

    public String encodeBase64File(File file) throws Exception {
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[((int) file.length())];
        inputFile.read(buffer);
        inputFile.close();
        return Base64.encodeToString(buffer, 0);
    }

    private void querySuccess(List<ComparisonResult> result) {
        if (result.size() > 2) {
            this.binding.setState(Integer.valueOf(1));
            this.mResultList = result;
            this.binding.face1PhotoImageView.setImageBitmap(SelectPhotoView.base64ToBitmap(((ComparisonResult) this.mResultList.get(0)).getFacePicUrl()));
            this.binding.face2PhotoImageView.setImageBitmap(SelectPhotoView.base64ToBitmap(((ComparisonResult) this.mResultList.get(1)).getFacePicUrl()));
            this.binding.face3PhotoImageView.setImageBitmap(SelectPhotoView.base64ToBitmap(((ComparisonResult) this.mResultList.get(2)).getFacePicUrl()));
            this.binding.setResultList(this.mResultList);
            return;
        }
        this.binding.setState(Integer.valueOf(2));
    }

    public void queryAgain() {
        try {
            File file = new File(this.mFilePath);
            this.binding.setState(Integer.valueOf(0));
            String fileBase64 = encodeBase64File(file);
            JSONObject object = new JSONObject();
            object.put("file64", fileBase64);
            object.put("resultSize", "3");
            object.put("pageNum", "1");
            object.put("pageSize", "3");
            AttendanceService.getHumanApi().finHumansFromUploadPicOfferToOther(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), object.toString())).enqueue(new Callback<MapHumanResult>() {
                public void onResponse(Call<MapHumanResult> call, Response<MapHumanResult> response) {
                    if (response == null || response.body() == null || ((MapHumanResult) response.body()).getResult() == null || ((MapHumanResult) response.body()).getResult().getRet() != 0 || !NewComparisonFragment.this.isAdded()) {
                        NewComparisonFragment.this.binding.setState(Integer.valueOf(2));
                    } else {
                        NewComparisonFragment.this.querySuccess(((MapHumanResult) response.body()).getPage().getList());
                    }
                }

                public void onFailure(Call<MapHumanResult> call, Throwable t) {
                    NewComparisonFragment.this.binding.setState(Integer.valueOf(2));
                    ToastUtil.showToast("人脸比对失败，失败原因：" + t.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void takePhoto() {
        ArrayList<String> mFileList = new ArrayList();
        mFileList.add(this.mFilePath);
        startSelectPictureActivity(getActivity(), mFileList, this, 10000);
    }

    public static void startSelectPictureActivity(Context context, ArrayList<String> fileList, Fragment fragment, int requestCode) {
        SelectPhotoView.selectPicture(context, true, true, 1, fileList, new OnSimpleFragment(fragment), requestCode);
    }

    public void save(final long personInfoId) {
        final List<Comparison> comparisonList = new ArrayList();
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
                OneProjectDao.getInstance().getDaoSession().getComparisonDao().deleteInTx(NewComparisonFragment.getLocalComparisonList(personInfoId));
                OneProjectDao.getInstance().getDaoSession().getComparisonDao().insertOrReplaceInTx(comparisonList);
            }
        });
    }

    public void selectPhoto(int select) {
        this.binding.setSelect(Integer.valueOf(select));
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
}
