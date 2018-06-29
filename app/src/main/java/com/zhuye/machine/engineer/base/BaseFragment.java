package com.zhuye.machine.engineer.base;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuye.machine.engineer.activity.login.LoginActivity;
import com.zhuye.machine.engineer.contants.NetWorkUrl;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;
import com.zhuye.machine.engineer.widget.CustomProgressDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * fragment的父类
 */
public abstract class BaseFragment extends Fragment implements BaseView {
    private CustomProgressDialog dialog;
    public View rootView;
    private Unbinder unbinder;
    public SharedPreferencesUtil sharedPreferencesUtil;
    public String token = "";


    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), getResId(), null);
        unbinder = ButterKnife.bind(this, view);
        rootView = view;
        sharedPreferencesUtil = new SharedPreferencesUtil(getActivity(), "user");
        token = sharedPreferencesUtil.getValue("token", "");
        isNetworkConnected(getActivity());
        initView();
        initData();
        initListener();
        dialog = new CustomProgressDialog(getActivity(), "加载中");
        dialog.setCanceledOnTouchOutside(false);

        return view;
    }

    protected void initListener() {
    }

    protected void initData() {
    }

    protected abstract void initView();

    protected abstract int getResId();

    @Override
    public void loding() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void finishLoding() {
        if (dialog != null && !dialog.isShowing()) {
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
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        } else {
            toast(base.getMessage());
        }
    }

    @Override
    public void success(int requestcode, Object o) {

    }

    @Override
    public void empty() {

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

    public void toast(String content) {
        ((BaseActivity) getActivity()).toast(content);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
