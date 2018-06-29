package com.zhuye.machine.engineer.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.activity.home.EditRequireRentActivity;
import com.zhuye.machine.engineer.activity.home.EditAdvertiseActivity;
import com.zhuye.machine.engineer.activity.home.EditDaibanActivity;
import com.zhuye.machine.engineer.activity.home.EditDongActivity;
import com.zhuye.machine.engineer.activity.home.EditRentActivity;
import com.zhuye.machine.engineer.activity.home.EditfindJobActivity;

/**
 * Created by Administrator on 2018\5\28 0028.
 */

public class FabuPop extends PopupWindow implements View.OnClickListener {
    private Intent intent;
    private Context context;
    private Button btn_cancle;
    private TextView tv_fa_dong, tv_fa_dai, tv_fa_find_job, tv_fa_job, tv_fa_cent, tv_fa_cent_require;

    public FabuPop(Activity context) {
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.main_fabu, null, false);
        btn_cancle = view.findViewById(R.id.btn_cancle);
        tv_fa_dong = view.findViewById(R.id.tv_fa_dong);
        tv_fa_dai = view.findViewById(R.id.tv_fa_dai);
        tv_fa_find_job = view.findViewById(R.id.tv_fa_find_job);
        tv_fa_job = view.findViewById(R.id.tv_fa_job);
        tv_fa_cent = view.findViewById(R.id.tv_fa_cent);
        tv_fa_cent_require = view.findViewById(R.id.tv_fa_cent_require);
        btn_cancle.setOnClickListener(this);
        tv_fa_dong.setOnClickListener(this);
        tv_fa_dai.setOnClickListener(this);
        tv_fa_find_job.setOnClickListener(this);
        tv_fa_job.setOnClickListener(this);
        tv_fa_cent.setOnClickListener(this);
        tv_fa_cent_require.setOnClickListener(this);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        setContentView(view);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
//        setFocusable(true);
    }

    public void onShow(View parent) {
        if (!this.isShowing()) {
            showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        } else {
            this.dismiss();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancle:
                dismiss();
                break;
            case R.id.tv_fa_dong://动态
                intent = new Intent(context, EditDongActivity.class);
                intent.putExtra("flag", 1);
                context.startActivity(intent);
                break;
            case R.id.tv_fa_dai://代班
                intent = new Intent(context, EditDaibanActivity.class);
                context.startActivity(intent);
                break;
            case R.id.tv_fa_find_job://求职
                intent = new Intent(context, EditfindJobActivity.class);
                context.startActivity(intent);
                break;
            case R.id.tv_fa_job://招聘
                intent = new Intent(context, EditAdvertiseActivity.class);
                context.startActivity(intent);
                break;
            case R.id.tv_fa_cent://出租
                intent = new Intent(context, EditRentActivity.class);
                context.startActivity(intent);
                break;
            case R.id.tv_fa_cent_require://求租
                intent = new Intent(context, EditRequireRentActivity.class);
                context.startActivity(intent);
                break;
        }
        dismiss();
    }
}
