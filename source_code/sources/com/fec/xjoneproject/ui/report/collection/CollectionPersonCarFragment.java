package com.fec.xjoneproject.ui.report.collection;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog.Builder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.fec.xjoneproject.ui.report.HomeInfoFragment;
import com.fec.xjoneproject.util.AllCapTransformationMethod;
import com.fec.xjoneproject.util.CheckUtils;
import com.fec.xjoneproject.util.ToastUtil;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneproject.R;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class CollectionPersonCarFragment extends Fragment implements OnClickListener {
    public static String ARG_LIST = "list";
    public static String ARG_RESULT = "result";
    ArrayAdapter<String> adapter;
    @Bind({2131297947})
    TextView mAddPhone;
    @Bind({2131296888})
    ImageButton mBack;
    @Bind({2131296575})
    FrameLayout mEmptyView;
    @Bind({2131297085})
    ListView mListView;
    Boolean mReadOnlyMode;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_problem_query_car, container, false);
        ButterKnife.bind((Object) this, rootView);
        this.mBack.setOnClickListener(this);
        this.adapter = new ArrayAdapter(getActivity(), 17367046);
        String[] list = getActivity().getIntent().getStringArrayExtra(ARG_LIST);
        this.mReadOnlyMode = Boolean.valueOf(getActivity().getIntent().getBooleanExtra(HomeInfoFragment.ARG_READ_ONLY_MODE, false));
        this.adapter.addAll(list);
        this.mListView.setAdapter(this.adapter);
        this.mListView.setEmptyView(this.mEmptyView);
        if (this.mReadOnlyMode.booleanValue()) {
            this.mAddPhone.setVisibility(8);
        } else {
            this.mAddPhone.setOnClickListener(this);
            this.mListView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    CollectionPersonCarFragment.this.showEditCarDialog(position);
                }
            });
        }
        return rootView;
    }

    @OnClick({2131296888, 2131297947})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibtn_back:
                getActivity().finish();
                return;
            case R.id.tv_add_phone:
                showAddCarDialog();
                return;
            default:
                return;
        }
    }

    protected void showAddCarDialog() {
        final View editText = new EditText(getActivity());
        editText.setTransformationMethod(new AllCapTransformationMethod());
        Builder builder = new Builder(getActivity());
        builder.setTitle((int) R.string.hint);
        builder.setMessage((CharSequence) "添加车牌号：");
        builder.setView(editText);
        builder.setPositiveButton((int) R.string.string_sure, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String car = editText.getText().toString().toUpperCase();
                if (CheckUtils.isCarId(car)) {
                    CollectionPersonCarFragment.this.adapter.add(car);
                    CollectionPersonCarFragment.this.adapter.notifyDataSetChanged();
                    return;
                }
                ToastUtil.showToast(IMSDroid.getContext().getString(R.string.input_right_plate_number));
            }
        });
        builder.setNegativeButton((CharSequence) "取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
        LayoutParams editLayoutParams = (LayoutParams) editText.getLayoutParams();
        editLayoutParams.setMargins(120, 0, 120, 0);
        editText.setLayoutParams(editLayoutParams);
    }

    protected void showEditCarDialog(final int position) {
        final View editText = new EditText(getActivity());
        editText.setTransformationMethod(new AllCapTransformationMethod());
        Builder builder = new Builder(getActivity());
        builder.setTitle((int) R.string.hint);
        builder.setMessage((CharSequence) "修改手机号：");
        builder.setView(editText);
        builder.setPositiveButton((int) R.string.string_sure, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String car = editText.getText().toString().toUpperCase();
                if (TextUtils.isEmpty(car) || !CheckUtils.isCarId(car)) {
                    ToastUtil.showToast(IMSDroid.getContext().getString(R.string.input_right_plate_number));
                    return;
                }
                CollectionPersonCarFragment.this.adapter.remove(CollectionPersonCarFragment.this.adapter.getItem(position));
                CollectionPersonCarFragment.this.adapter.insert(car, position);
                CollectionPersonCarFragment.this.adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton((CharSequence) "删除", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                CollectionPersonCarFragment.this.adapter.remove(CollectionPersonCarFragment.this.adapter.getItem(position));
                CollectionPersonCarFragment.this.adapter.notifyDataSetChanged();
            }
        });
        builder.create().show();
        LayoutParams editLayoutParams = (LayoutParams) editText.getLayoutParams();
        editLayoutParams.setMargins(120, 0, 120, 0);
        editText.setLayoutParams(editLayoutParams);
        editText.setText((CharSequence) this.adapter.getItem(position));
    }
}
