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
 * 注册
 */
public class RegisterActivity extends BaseActivity {

    @BindView(R.id.iv_register_back)
    ImageView ivRegisterBack;
    @BindView(R.id.layout_title_psd)
    RelativeLayout layoutTitlePsd;
    @BindView(R.id.edt_register_tel)
    EditText edtRegisterTel;
    @BindView(R.id.edt_register_code)
    EditText edtRegisterCode;
    @BindView(R.id.btn_register_code)
    Button btnRegisterCode;
    @BindView(R.id.layout_up)
    LinearLayout layoutUp;
    @BindView(R.id.edt_register_psd)
    EditText edtRegisterPsd;
    @BindView(R.id.edt_register_psd_again)
    EditText edtRegisterPsdAgain;
    @BindView(R.id.layout_next)
    LinearLayout layoutNext;
    @BindView(R.id.btn_register_next_finish)
    Button btnRegisterNextFinish;
    private int flag = 0;//用于区分 0下一步 与 1 完成 按钮
    private String codes = "";

    @Override
    protected int getResId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        super.initView();
        flag = 0;
        btnRegisterNextFinish.setText("下一步");
        layoutUp.setVisibility(View.VISIBLE);
        layoutNext.setVisibility(View.GONE);
    }

    @OnClick({R.id.iv_register_back, R.id.btn_register_code, R.id.btn_register_next_finish})
    public void onViewClicked(View view) {
        String phone = edtRegisterTel.getText().toString();
        switch (view.getId()) {
            case R.id.iv_register_back:
                finish();
                break;
            case R.id.btn_register_code://获取验证码
                if (phone.equals("")) {
                    toast(getString(R.string.telNotNull));
                    return;
                }
                if (!VertifyUtil.isMobileExact(phone)) {
                    toast(getString(R.string.tel_error));
                    return;
                }
                CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(btnRegisterCode, 30000, 1000);
                countDownTimerUtils.start();
                GetData.getCode(phone, RegisterActivity.this, Contans.Get_Code);
                break;
            case R.id.btn_register_next_finish://下一步  完成
                if (flag == 0) {//
                    if (!edtRegisterCode.getText().toString().equals(codes)) {
                        toast(getString(R.string.code_error));
                        return;
                    }
                    layoutNext.setVisibility(View.VISIBLE);
                    layoutUp.setVisibility(View.GONE);
                    btnRegisterNextFinish.setText("完成");
                } else if (flag == 1) {

                    String code = edtRegisterCode.getText().toString();
                    String psd = edtRegisterPsd.getText().toString();
                    String psdAgain = edtRegisterPsdAgain.getText().toString();
                  if (!psd.equals(psdAgain)){
                      toast(getString(R.string.psd_no_same));
                      return;
                  }
                    //提交信息
                    GetData.register(phone, psd, psdAgain, RegisterActivity.this, Contans.Register);
                }
                flag = 1;
                break;
            default:
                break;
        }
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case Contans.Get_Code://获取验证码
                Code code = (Code) o;
                toast(code.getMessage());
                codes = code.getData();
                break;
            case Contans.Register://注册
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
