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
 * 我的余额
 */
public class MyRestMoneyActivity extends BaseActivity {


    @BindView(R.id.iv_rest_money_back)
    ImageView ivRestMoneyBack;
    @BindView(R.id.tv_rest_money)
    TextView tvRestMoney;
    @BindView(R.id.btn_get_money)
    Button btnGetMoney;
    @BindView(R.id.ic_records)
    ImageView icRecords;

    @Override
    protected int getResId() {
        return R.layout.activity_my_rest_money;
    }


    @OnClick({R.id.iv_rest_money_back, R.id.btn_get_money, R.id.ic_records})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_rest_money_back:
                finish();
                break;
            case R.id.btn_get_money://提现
                Go(GetMoneyActivity.class,false);
                break;
            case R.id.ic_records:
                Go(MoneyRecordActivity.class,false);
                break;
        }
    }
}
