package com.zhuye.machine.engineer.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 实名认证
 */
public class IdentityActivity extends BaseActivity {

    @BindView(R.id.iv_identity_back)
    ImageView ivIdentityBack;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.radio_girl)
    RadioButton radioGirl;
    @BindView(R.id.radio_boy)
    RadioButton radioBoy;
    @BindView(R.id.radio_sex)
    RadioGroup radioSex;
    @BindView(R.id.tv_birth)
    TextView tvBirth;
    @BindView(R.id.edt_address)
    EditText edtAddress;
    @BindView(R.id.edt_card)
    EditText edtCard;
    @BindView(R.id.iv_identity_zheng)
    ImageView ivIdentityZheng;
    @BindView(R.id.iv_identity_fan)
    ImageView ivIdentityFan;
    @BindView(R.id.btn_identity_sure)
    Button btnIdentitySure;

    @Override
    protected int getResId() {
        return R.layout.activity_identity;
    }

    @OnClick({R.id.iv_identity_back, R.id.tv_birth, R.id.iv_identity_zheng, R.id.iv_identity_fan, R.id.btn_identity_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_identity_back:
                finish();
                break;
            case R.id.tv_birth:
                break;
            case R.id.iv_identity_zheng:
                break;
            case R.id.iv_identity_fan:
                break;
            case R.id.btn_identity_sure:
                break;
        }
    }
}
