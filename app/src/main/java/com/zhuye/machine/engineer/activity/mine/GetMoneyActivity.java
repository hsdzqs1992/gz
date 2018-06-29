package com.zhuye.machine.engineer.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 提现
 */
public class GetMoneyActivity extends BaseActivity {


    @BindView(R.id.iv_get_money_back)
    ImageView ivGetMoneyBack;
    @BindView(R.id.tv_bank_card)
    TextView tvBankCard;
    @BindView(R.id.edt_get_money)
    EditText edtGetMoney;
    @BindView(R.id.tv_get_all_money)
    TextView tvGetAllMoney;
    @BindView(R.id.get_all_money)
    TextView getAllMoney;
    @BindView(R.id.btn_get_money)
    Button btnGetMoney;

    @Override
    protected int getResId() {
        return R.layout.activity_get_money;
    }

    @OnClick({R.id.iv_get_money_back, R.id.tv_bank_card, R.id.get_all_money, R.id.btn_get_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_get_money_back:
                finish();
                break;
            case R.id.tv_bank_card://银行账号

                break;
            case R.id.get_all_money:
                break;
            case R.id.btn_get_money:
                break;
        }
    }
}
