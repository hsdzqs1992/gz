package com.zhuye.machine.engineer.base;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import com.zhuye.machine.engineer.activity.login.LoginActivity;
import com.zhuye.machine.engineer.contants.NetWorkUrl;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;
import com.zhuye.machine.engineer.widget.CustomProgressDialog;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private Unbinder unbinder;
    private CustomProgressDialog dialog;
    public SharedPreferencesUtil sharedPreferencesUtil;
    public String token = "";
    public static List<FragmentActivity> activityList = new LinkedList<FragmentActivity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResId());
        unbinder = ButterKnife.bind(this);
        sharedPreferencesUtil = new SharedPreferencesUtil(this, "user");
        token = sharedPreferencesUtil.getValue("token", "");
        isNetworkConnected(this);
        setActivity(this);
        dialog = new CustomProgressDialog(this, "加载中");
        dialog.setCanceledOnTouchOutside(false);
        initView();
        initListener();
        initData();
    }

    protected abstract int getResId();

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView() {
    }

    public void toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    //  baseView  开始 - 复写方法
    @Override
    public void loding() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void finishLoding() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void error(Object o) {
        Base base = (Base) o;
        int code = base.getCode();
        if (code == Integer.valueOf(NetWorkUrl.Invalidate)) {
            toast(base.getMessage());
            sharedPreferencesUtil.clear();
            Intent intent = new Intent(BaseActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            toast(base.getMessage());
        }
    }

    @Override
    public void success(int requestcode, Object o) {

    }

    // baseView  结束 - 复写方法
    @Override
    public void empty() {

    }

    /**
     * 不需要传值
     *
     * @param cls
     * @param isFinish
     * @description
     * @date 2015-10-20下午2:14:19
     */
    public void Go(Class<?> cls, Boolean isFinish) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
        if (isFinish)
            finish();
        overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    /**
     * 点击空白位置 隐藏软键盘
     */
    public boolean onTouchEvent(MotionEvent event) {
        if (null != this.getCurrentFocus()) {
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this
                    .getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }

    /**
     * 检测网络是否可用
     *
     * @return
     */
    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            } else {
                toast("网络不给力，请稍后重试");
            }
        }
        return false;
    }

    // 添加Activity到容器中
    public static void setActivity(FragmentActivity activity) {
        activityList.add(activity);
    }

    public int getActivitySize() {
        return activityList.size();
    }

    // 循环所有Activity并finish
    public static void exit() {
        for (FragmentActivity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
