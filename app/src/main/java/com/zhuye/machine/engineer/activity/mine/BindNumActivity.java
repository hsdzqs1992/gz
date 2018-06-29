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
import butterknife.OnClick;

/**
 * 实名认证 绑定手机号
 */
public class BindNumActivity extends BaseActivity {

    @BindView(R.id.iv_bind_back)
    ImageView ivBindBack;
    @BindView(R.id.layout_bind)
    RelativeLayout layoutBind;
    @BindView(R.id.edt_bind_num)
    EditText edtBindNum;
    @BindView(R.id.edt_code)
    EditText edtCode;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;
    @BindView(R.id.btn_bind_sure)
    Button btnBindSure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getResId() {
        return R.layout.activity_bind_num;
    }

    @OnClick({R.id.iv_bind_back, R.id.tv_get_code, R.id.btn_bind_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_bind_back:
                finish();
                break;
            case R.id.tv_get_code:
                break;
            case R.id.btn_bind_sure:
                break;
        }
    }
}
