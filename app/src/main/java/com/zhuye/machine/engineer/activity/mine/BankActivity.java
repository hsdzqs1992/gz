package com.zhuye.machine.engineer.activity.mine;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 银行列表
 */
public class BankActivity extends BaseActivity {


    @BindView(R.id.iv_bank_back)
    ImageView ivBankBack;
    @BindView(R.id.bank)
    RelativeLayout bank;
    @BindView(R.id.recycler_bank)
    RecyclerView recyclerBank;
    @BindView(R.id.refresh_bank)
    SmartRefreshLayout refreshBank;
    @BindView(R.id.btn_add_bank)
    Button btnAddBank;

    @Override
    protected int getResId() {
        return R.layout.activity_bank;
    }

    @OnClick({R.id.iv_bank_back, R.id.btn_add_bank})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_bank_back:
                finish();
                break;
            case R.id.btn_add_bank://新增银行卡

                break;
        }
    }
}
