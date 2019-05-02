package com.fec.xjoneproject.ui.task.radio_personnel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.fec.xjoneproject.ui.task.radio_personnel.PeerPersonnelListFragment.PeerItem;
import com.fec.xjoneproject.util.CheckUtils;
import com.fec.xjoneproject.util.CheckUtils.DefaultMaterialEditTextCheckCard;
import com.fec.xjoneproject.util.ToastUtil;
import com.hbfec.xjoneinformation.IMSDroid;
import com.hbfec.xjoneproject.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.METValidator;

public class PeerPersonnelAddFragment extends Fragment {
    public static final String ARG_BEAN_POSITION = "bean_position";
    public static final String ARG_PEER_BEAN = "peer_bean";
    @Bind({2131296888})
    ImageButton mBack;
    private Integer mBeanPosition;
    @Bind({2131296603})
    MaterialEditText mCardMaterialEditText;
    @Bind({2131296655})
    MaterialEditText mInfoMaterialEditText;
    private PeerItem mItem;
    @Bind({2131296660})
    MaterialEditText mMobileMaterialEditText;
    @Bind({2131296662})
    MaterialEditText mNameMaterialEditText;
    @Bind({2131297946})
    TextView mPeer;

    public static PeerPersonnelAddFragment newInstance(PeerItem item, int position) {
        PeerPersonnelAddFragment fragment = new PeerPersonnelAddFragment();
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
            this.mBeanPosition = Integer.valueOf(getArguments().getInt("bean_position"));
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_peer_personnel_add, container, false);
        ButterKnife.bind((Object) this, rootView);
        this.mCardMaterialEditText.setValidateOnFocusLost(true);
        this.mCardMaterialEditText.addValidator(new METValidator(IMSDroid.getContext().getString(R.string.error_wrong_identity)) {
            public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
                return !isEmpty && CheckUtils.isIdCardNo(String.valueOf(text));
            }
        });
        this.mPeer.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String error = PeerPersonnelAddFragment.this.setErrorText();
                if (TextUtils.isEmpty(error)) {
                    if (PeerPersonnelAddFragment.this.mItem == null) {
                        PeerPersonnelAddFragment.this.mItem = new PeerItem();
                        PeerPersonnelAddFragment.this.mItem.setId(-1);
                    }
                    PeerPersonnelAddFragment.this.mItem.setName(PeerPersonnelAddFragment.this.mNameMaterialEditText.getText().toString());
                    PeerPersonnelAddFragment.this.mItem.setCard(PeerPersonnelAddFragment.this.mCardMaterialEditText.getText().toString());
                    PeerPersonnelAddFragment.this.mItem.setInfo(PeerPersonnelAddFragment.this.mInfoMaterialEditText.getText().toString());
                    PeerPersonnelAddFragment.this.mItem.setMobile(PeerPersonnelAddFragment.this.mMobileMaterialEditText.getText().toString());
                    PeerPersonnelAddFragment.this.mItem.setError(Boolean.valueOf(false));
                    Intent intent = new Intent();
                    intent.putExtra("peer_bean", PeerPersonnelAddFragment.this.mItem);
                    intent.putExtra("bean_position", PeerPersonnelAddFragment.this.mBeanPosition);
                    PeerPersonnelAddFragment.this.getActivity().setResult(-1, intent);
                    PeerPersonnelAddFragment.this.getActivity().finish();
                    return;
                }
                ToastUtil.showToast(error);
            }
        });
        this.mBack.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PeerPersonnelAddFragment.this.getActivity().finish();
            }
        });
        if (this.mItem != null) {
            this.mNameMaterialEditText.setText(this.mItem.getName());
            this.mCardMaterialEditText.setText(this.mItem.getCard());
            this.mInfoMaterialEditText.setText(this.mItem.getInfo());
            this.mMobileMaterialEditText.setText(this.mItem.getMobile());
            if (this.mItem.getError().booleanValue()) {
                setErrorText();
            }
        }
        return rootView;
    }

    private String setErrorText() {
        String result = null;
        if (!CheckUtils.isMaterialEditTextInputRight(this.mNameMaterialEditText, true)) {
            result = this.mNameMaterialEditText.getError().toString();
        }
        if (!CheckUtils.isMaterialEditTextInputRight(this.mInfoMaterialEditText, true) && TextUtils.isEmpty(result)) {
            result = this.mInfoMaterialEditText.getError().toString();
        }
        if (CheckUtils.isMaterialEditTextInputRight(this.mCardMaterialEditText, DefaultMaterialEditTextCheckCard.newInstance(true)) || !TextUtils.isEmpty(result)) {
            return result;
        }
        return this.mCardMaterialEditText.getError().toString();
    }
}
