package com.zhuye.machine.engineer.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 编辑 个人信息
 */
public class EditPersonInfoActivity extends BaseActivity {


    @BindView(R.id.iv_edit_info_back)
    ImageView ivEditInfoBack;
    @BindView(R.id.tv_finish)
    TextView tvFinish;
    @BindView(R.id.iv_user_pic)
    ImageView ivUserPic;
    @BindView(R.id.tv_change_pic)
    TextView tvChangePic;
    @BindView(R.id.edt_user_nick_name)
    EditText edtUserNickName;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_bind_tel)
    TextView tvBindTel;
    @BindView(R.id.tv_recive_address)
    TextView tvReciveAddress;
    @BindView(R.id.edt_user_sign_content)
    EditText edtUserSignContent;

    @Override
    protected int getResId() {
        return R.layout.activity_edit_person_info;
    }


    @OnClick({R.id.iv_edit_info_back, R.id.tv_finish, R.id.tv_change_pic, R.id.tv_address, R.id.tv_bind_tel, R.id.tv_recive_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_edit_info_back:
                finish();
                break;
            case R.id.tv_finish:
                break;
            case R.id.tv_change_pic:
                break;
            case R.id.tv_address:
                break;
            case R.id.tv_bind_tel:
                break;
            case R.id.tv_recive_address:
                break;
        }
    }
}
