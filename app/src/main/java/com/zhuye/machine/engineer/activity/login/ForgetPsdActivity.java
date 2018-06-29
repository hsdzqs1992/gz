package com.zhuye.machine.engineer.activity.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.Base;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.entity.Code;
import com.zhuye.machine.engineer.http.GetData;
import com.zhuye.machine.engineer.util.CountDownTimerUtils;
import com.zhuye.machine.engineer.util.VertifyUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 忘记密码
 */
public class ForgetPsdActivity extends BaseActivity {

    @BindView(R.id.layout_title_psd)
    RelativeLayout layoutTitlePsd;
    @BindView(R.id.edt_forget_tel)
    EditText edtForgetTel;
    @BindView(R.id.edt_forget_ps_code)
    EditText edtForgetPsCode;
    @BindView(R.id.btn_forget_get_code)
    Button btnForgetGetCode;
    @BindView(R.id.layout_up)
    LinearLayout layoutUp;
    @BindView(R.id.edt_psd)
    EditText edtPsd;
    @BindView(R.id.edt_psd_again)
    EditText edtPsdAgain;
    @BindView(R.id.layout_next)
    LinearLayout layoutNext;
    @BindView(R.id.btn_next_finish)
    Button btnNextFinish;
    @BindView(R.id.iv_psd_back)
    ImageView ivPsdBack;

    private int flag = 0;//用于区分 0下一步 与 1 完成 按钮
    private String codes = "";

    @Override
    protected int getResId() {
        return R.layout.activity_forget_psd;
    }

    @Override
    protected void initView() {
        super.initView();
        flag = 0;
        btnNextFinish.setText("下一步");
        layoutUp.setVisibility(View.VISIBLE);
        layoutNext.setVisibility(View.GONE);
    }

    @OnClick({R.id.btn_forget_get_code, R.id.btn_next_finish, R.id.iv_psd_back})
    public void onViewClicked(View view) {
        String phone = edtForgetTel.getText().toString();
        switch (view.getId()) {
            case R.id.iv_psd_back:
                finish();
                break;
            case R.id.btn_forget_get_code://获取验证码
                if (phone.equals("")) {
                    toast(getString(R.string.telNotNull));
                    return;
                }
                if (!VertifyUtil.isMobileExact(phone)) {
                    toast(getString(R.string.tel_error));
                    return;
                }
                CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(btnForgetGetCode, 30000, 1000);
                countDownTimerUtils.start();
                GetData.getCode(phone, ForgetPsdActivity.this, Contans.Get_Code);
                break;
            case R.id.btn_next_finish://下一步  或者 完成

                if (flag == 0) {
                    if (!codes.equals(edtForgetPsCode.getText().toString())) {
                        toast(getString(R.string.code_error));
                        return;
                    }
                    layoutNext.setVisibility(View.VISIBLE);
                    layoutUp.setVisibility(View.GONE);
                    btnNextFinish.setText("完成");
                } else if (flag == 1) {
                    String code = edtForgetPsCode.getText().toString();
                    String psd = edtPsd.getText().toString();
                    String psdAgain = edtPsdAgain.getText().toString();
                    if (!psd.equals(psdAgain)){
                        toast(getString(R.string.psd_no_same));
                        return;
                    }
                    //提交信息
                    GetData.editPass(phone,psd,psdAgain,ForgetPsdActivity.this,Contans.Edit_Pass);
                }
                flag = 1;
                break;
        }
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case Contans.Get_Code:
                Code code = (Code) o;
                codes = code.getData();
                toast(code.getMessage());
                break;
            case Contans.Edit_Pass:
                Base base = (Base) o;
                toast(base.getMessage());
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void error(Object o) {
        super.error(o);
        Base base = (Base) o;
        toast(base.getMessage());
    }
}
