package com.zhuye.machine.engineer.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我要代班
 */
public class DaiBanActivity extends BaseActivity {


    @BindView(R.id.iv_daiban_back)
    ImageView ivDaibanBack;
    @BindView(R.id.title_dai)
    RelativeLayout titleDai;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_number)
    EditText edtNumber;
    @BindView(R.id.edt_remark)
    EditText edtRemark;
    @BindView(R.id.view)
    LinearLayout view;
    @BindView(R.id.btn_dai_commit)
    Button btnDaiCommit;

    @Override
    protected int getResId() {
        return R.layout.activity_edit_dai_ban;
    }


    @OnClick({R.id.iv_daiban_back, R.id.btn_dai_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_daiban_back:
                finish();
                break;
            case R.id.btn_dai_commit:
                break;
        }
    }
}
