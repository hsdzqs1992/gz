package com.zhuye.machine.engineer.activity.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.machine.engineer.MainActivity;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.Base;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.entity.Login;
import com.zhuye.machine.engineer.http.GetData;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;
import com.zhuye.machine.engineer.util.VertifyUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.layout_logo)
    LinearLayout layoutLogo;
    @BindView(R.id.edt_login_username)
    EditText edtLoginUsername;
    @BindView(R.id.edt_login_password)
    EditText edtLoginPassword;
    @BindView(R.id.tv_forget_password)
    TextView tvForgetPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private SharedPreferencesUtil sharedPreferencesUtil;
    private boolean isLogin = false;

    @Override
    protected int getResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();
        sharedPreferencesUtil = new SharedPreferencesUtil(LoginActivity.this, "user");
        isLogin = sharedPreferencesUtil.getValue("isLogin", false);
        if (isLogin) {
            Go(MainActivity.class, false);
        }
    }

    @OnClick({R.id.tv_forget_password, R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_forget_password://忘记密码
                Go(ForgetPsdActivity.class, false);
                break;
            case R.id.btn_login://登录
                String user = edtLoginUsername.getText().toString();
                String psd = edtLoginPassword.getText().toString();
                if (TextUtils.isEmpty(user)) {
                    toast(getString(R.string.user_name));
                    return;
                }
                if (!VertifyUtil.isMobileExact(user)) {
                    toast(getString(R.string.tel_error));
                    return;
                }
                if (TextUtils.isEmpty(psd)) {
                    toast(getString(R.string.psd));
                    return;
                }
                GetData.login(user, psd, LoginActivity.this, Contans.Login);

                break;
            case R.id.btn_register://注册
                Go(RegisterActivity.class, false);

                break;
        }
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        Login login = (Login) o;
        String token = login.getData().getToken();
        String uid = login.getData().getUid();
        sharedPreferencesUtil.putValue("token", token);
        sharedPreferencesUtil.putValue("uid", uid);
        sharedPreferencesUtil.putValue("isLogin", true);
        Go(MainActivity.class, false);
    }

    @Override
    public void error(Object o) {
        super.error(o);
        Base base = (Base) o;
        if (base.getCode() == 288) {
            toast(getString(R.string.token_invaild));
        } else {
            toast(base.getMessage());
        }
    }
}
