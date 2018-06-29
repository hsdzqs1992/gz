package com.zhuye.machine.engineer.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;

import java.util.zip.GZIPOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 实名认证
 */
public class IdentityVertifyActivity extends BaseActivity {


    @BindView(R.id.iv_identity_vertify)
    ImageView ivIdentityVertify;
    @BindView(R.id.iv_identity_info)
    ImageView ivIdentityInfo;
    @BindView(R.id.iv_bind_num)
    ImageView ivBindNum;
    @BindView(R.id.iv_pay_money)
    ImageView ivPayMoney;

    @Override
    protected int getResId() {
        return R.layout.activity_identity_vertify;
    }

    @OnClick({R.id.iv_identity_vertify, R.id.iv_identity_info, R.id.iv_bind_num, R.id.iv_pay_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_identity_vertify:
                finish();
                break;
            case R.id.iv_identity_info://实名认证
                Go(IdentityActivity.class,false);
                break;
            case R.id.iv_bind_num://绑定手机号
                Go(BindNumActivity.class,false);
                break;
            case R.id.iv_pay_money://支付诚意金
                Go(PayChengActivity.class,false);
                break;
        }
    }
}
