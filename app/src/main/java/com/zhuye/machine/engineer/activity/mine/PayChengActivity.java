package com.zhuye.machine.engineer.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 实名认证 支付诚意金
 */
public class PayChengActivity extends BaseActivity {


    @BindView(R.id.iv_pay_cheng_back)
    ImageView ivPayChengBack;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.btn_go_pay)
    Button btnGoPay;

    @Override
    protected int getResId() {
        return R.layout.activity_pay_cheng;
    }

    @OnClick({R.id.iv_pay_cheng_back, R.id.btn_go_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_pay_cheng_back:
                finish();
                break;
            case R.id.btn_go_pay:
                break;
        }
    }
}
