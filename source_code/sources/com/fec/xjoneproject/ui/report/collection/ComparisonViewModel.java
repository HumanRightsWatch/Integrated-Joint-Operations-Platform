package com.fec.xjoneproject.ui.report.collection;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Base64;
import com.fec.xjoneproject.http.response.AttendanceService;
import com.fec.xjoneproject.ui.report.bean.ComparisonResult;
import com.fec.xjoneproject.ui.report.bean.MapHumanResult;
import com.fec.xjoneproject.util.ToastUtil;
import com.hbfec.xjoneproject.R;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComparisonViewModel {
    public ObservableBoolean editable = new ObservableBoolean();
    ComparisonFragment fragment;
    public ObservableBoolean queryError = new ObservableBoolean();
    public ObservableBoolean querySuccess = new ObservableBoolean();
    public ObservableBoolean showComparisonButton = new ObservableBoolean();
    public ObservableBoolean showOtherImage = new ObservableBoolean();
    public ObservableField<String> similarityText = new ObservableField();

    public ComparisonViewModel(ComparisonFragment fragment) {
        this.fragment = fragment;
    }

    public void takePhoto() {
        ArrayList<String> mFileList = new ArrayList();
        mFileList.add(this.fragment.getFilePath());
        ComparisonFragment.startSelectPictureActivity(this.fragment.getActivity(), mFileList, this.fragment, 10000);
    }

    public void selectPhoto(int select) {
        List<ComparisonResult> mResultList = this.fragment.getResultList();
        if (mResultList != null && select < mResultList.size()) {
            ComparisonResult result = (ComparisonResult) mResultList.get(select);
            mResultList.remove(result);
            mResultList.add(0, result);
            this.fragment.querySuccess(mResultList);
        }
    }

    public void queryAgain() {
        try {
            File file = new File(this.fragment.getFilePath());
            if (file.exists()) {
                this.showComparisonButton.set(false);
                this.querySuccess.set(false);
                this.queryError.set(false);
                this.similarityText.set(this.fragment.getString(R.string.check_person_query));
                String fileBase64 = encodeBase64File(file);
                JSONObject object = new JSONObject();
                object.put("file64", fileBase64);
                object.put("resultSize", "3");
                object.put("pageNum", "1");
                object.put("pageSize", "3");
                AttendanceService.getHumanApi().finHumansFromUploadPicOfferToOther(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), object.toString())).enqueue(new Callback<MapHumanResult>() {
                    public void onResponse(Call<MapHumanResult> call, Response<MapHumanResult> response) {
                        if (!ComparisonViewModel.this.fragment.isAdded()) {
                            return;
                        }
                        if (response == null || response.body() == null || ((MapHumanResult) response.body()).getResult() == null || ((MapHumanResult) response.body()).getResult().getRet() != 0) {
                            ComparisonViewModel.this.queryError.set(true);
                            ComparisonViewModel.this.similarityText.set(ComparisonViewModel.this.fragment.getString(R.string.check_person_error));
                            return;
                        }
                        ComparisonViewModel.this.fragment.addQueryCount();
                        ComparisonViewModel.this.fragment.querySuccess(((MapHumanResult) response.body()).getPage().getList());
                        ComparisonViewModel.this.querySuccess.set(true);
                    }

                    public void onFailure(Call<MapHumanResult> call, Throwable t) {
                        ComparisonViewModel.this.fragment.addQueryCount();
                        ComparisonViewModel.this.queryError.set(true);
                        ComparisonViewModel.this.similarityText.set(ComparisonViewModel.this.fragment.getString(R.string.check_person_error));
                        ToastUtil.showToast("人脸比对失败，失败原因：" + t.getMessage());
                    }
                });
                return;
            }
            ToastUtil.showToast("请选择要比对的照片");
            takePhoto();
        } catch (Exception e) {
            ToastUtil.showToast("请选择要比对的照片");
            takePhoto();
        }
    }

    public String encodeBase64File(File file) throws Exception {
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[((int) file.length())];
        inputFile.read(buffer);
        inputFile.close();
        return Base64.encodeToString(buffer, 0);
    }
}
