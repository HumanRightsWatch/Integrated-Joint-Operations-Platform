package com.fec.xjoneproject.ui.task.overdue_person;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.fec.xjoneproject.ui.task.overdue_person.ExitRelationListFragment.PeerItem;
import com.fec.xjoneproject.util.CheckUtils;
import com.fec.xjoneproject.util.CheckUtils.DefaultMaterialEditTextCheckPhone;
import com.fec.xjoneproject.util.ToastUtil;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneproject.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.METValidator;
import fr.ganfra.materialspinner.MaterialSpinner;

public class ExitRelationAddFragment extends Fragment {
    @Bind({2131296888})
    ImageButton mBack;
    @Bind({2131297943})
    TextView mFamily;
    private PeerItem mItem;
    @Bind({2131296662})
    MaterialEditText mNameMaterialEditText;
    @Bind({2131296730})
    MaterialEditText mNoteTextMaterialEditText;
    @Bind({2131296691})
    MaterialEditText mPhoneMaterialEditText;
    private Integer mPosition;
    @Bind({2131297827})
    MaterialSpinner mRelationMaterialSpinner;
    @Bind({2131298313})
    TextView mTitleTv;

    public static ExitRelationAddFragment newInstance(PeerItem item, int position) {
        ExitRelationAddFragment fragment = new ExitRelationAddFragment();
        Bundle args = new Bundle();
        args.putSerializable("peer_bean", item);
        args.putInt("bean_position", position);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mItem = (PeerItem) getArguments().getSerializable("peer_bean");
            this.mPosition = Integer.valueOf(getArguments().getInt("bean_position"));
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_family_add_warning, container, false);
        ButterKnife.bind((Object) this, rootView);
        this.mTitleTv.setText("添加境外联系人");
        SpinnerAdapter adapter = new ArrayAdapter(getActivity(), 17367048, getResources().getStringArray(R.array.relation_for_family));
        adapter.setDropDownViewResource(17367049);
        this.mRelationMaterialSpinner.setAdapter(adapter);
        this.mFamily.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String error = ExitRelationAddFragment.this.setErrorText();
                if (TextUtils.isEmpty(error)) {
                    if (ExitRelationAddFragment.this.mItem == null) {
                        ExitRelationAddFragment.this.mItem = new PeerItem();
                        ExitRelationAddFragment.this.mItem.setId(-1);
                    }
                    ExitRelationAddFragment.this.mItem.setPhone(ExitRelationAddFragment.this.mPhoneMaterialEditText.getText().toString());
                    ExitRelationAddFragment.this.mItem.setName(ExitRelationAddFragment.this.mNameMaterialEditText.getText().toString());
                    ExitRelationAddFragment.this.mItem.setRelation(Integer.valueOf(ExitRelationAddFragment.this.mRelationMaterialSpinner.getSelectedItemPosition()));
                    ExitRelationAddFragment.this.mItem.setNote(ExitRelationAddFragment.this.mNoteTextMaterialEditText.getText().toString());
                    Intent intent = new Intent();
                    intent.putExtra("peer_bean", ExitRelationAddFragment.this.mItem);
                    intent.putExtra("bean_position", ExitRelationAddFragment.this.mPosition);
                    ExitRelationAddFragment.this.getActivity().setResult(-1, intent);
                    ExitRelationAddFragment.this.getActivity().finish();
                    return;
                }
                ToastUtil.showToast(error);
            }
        });
        this.mBack.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ExitRelationAddFragment.this.getActivity().finish();
            }
        });
        this.mPhoneMaterialEditText.setValidateOnFocusLost(true);
        this.mPhoneMaterialEditText.addValidator(new METValidator(IMSDroid.getContext().getString(R.string.error_wrong_phone)) {
            public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
                return !isEmpty && CheckUtils.isMobileNo(String.valueOf(text));
            }
        });
        if (this.mItem != null) {
            this.mPhoneMaterialEditText.setText(this.mItem.getPhone());
            this.mNameMaterialEditText.setText(this.mItem.getName());
            this.mRelationMaterialSpinner.setSelection(this.mItem.getRelation().intValue(), false);
            this.mNoteTextMaterialEditText.setText(this.mItem.getNote());
            if (this.mItem.getError().booleanValue()) {
                setErrorText();
            }
        }
        return rootView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private String setErrorText() {
        String result = null;
        if (!CheckUtils.isMaterialEditTextInputRight(this.mNameMaterialEditText, true)) {
            result = this.mNameMaterialEditText.getError().toString();
        }
        if (!CheckUtils.isMaterialEditTextInputRight(this.mPhoneMaterialEditText, DefaultMaterialEditTextCheckPhone.newInstance(true)) && TextUtils.isEmpty(result)) {
            result = this.mPhoneMaterialEditText.getError().toString();
        }
        if (CheckUtils.isMaterialEditTextInputRight(this.mNoteTextMaterialEditText, false) || !TextUtils.isEmpty(result)) {
            return result;
        }
        return this.mNoteTextMaterialEditText.getError().toString();
    }
}
