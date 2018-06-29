package com.zhuye.machine.engineer.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * \
 * 新增银行卡
 */
public class AddBankActivity extends BaseActivity {


    @BindView(R.id.iv_add_bank_back)
    ImageView ivAddBankBack;
    @BindView(R.id.add_bank)
    RelativeLayout addBank;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.iv_choose_card)
    ImageView ivChooseCard;
    @BindView(R.id.edt_bank_num)
    EditText edtBankNum;
    @BindView(R.id.edt_id_card)
    EditText edtIdCard;
    @BindView(R.id.edt_tel)
    EditText edtTel;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.edt_code)
    EditText edtCode;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.btn_add_bank)
    Button btnAddBank;

    @Override
    protected int getResId() {
        return R.layout.activity_add_bank;
    }

    @OnClick({R.id.iv_add_bank_back, R.id.iv_choose_card, R.id.tv_get_code, R.id.btn_add_bank})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_add_bank_back:
                finish();
                break;
            case R.id.iv_choose_card:
                break;
            case R.id.tv_get_code:
                break;
            case R.id.btn_add_bank:
                break;
        }
    }
}
