package com.zhuye.machine.engineer.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.activity.home.calendar.CalendarCardView;
import com.zhuye.machine.engineer.activity.home.calendar.CustomDate;
import com.zhuye.machine.engineer.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 签到 日历
 */
public class SignActivity extends BaseActivity {

    @BindView(R.id.iv_sign_back)
    ImageView ivSignBack;
    @BindView(R.id.layout_title_dong)
    RelativeLayout layoutTitleDong;
    @BindView(R.id.tv_sign)
    TextView tvSign;
    @BindView(R.id.tv_cur_date)
    TextView tvCurDate;
    @BindView(R.id.tv_signed_days)
    TextView tvSignedDays;
    @BindView(R.id.sign_calendar_card_current_day_tv)
    TextView signCalendarCardCurrentDayTv;
    @BindView(R.id.sign_calendar)
    CalendarCardView signCalendar;
    private CustomDate mCustomDate;
    List<String> mAlreadySignDate = new ArrayList<>();
   private String default_year = "2018-";//默认的年份

    @Override
    protected void initView() {
        super.initView();
        //初始化当前月份的日历
        mAlreadySignDate.add(default_year +"5-25");
        mAlreadySignDate.add(default_year +"5-26");
        mAlreadySignDate.add(default_year +"5-28");
        mAlreadySignDate.add(default_year +"5-30");
        mAlreadySignDate.add(default_year +"5-31");
        mCustomDate = new CustomDate();
        signCalendar.setNewMounth(mCustomDate);
    }

    @Override
    protected void initListener() {
        super.initListener();
        signCalendar.setOnCellClickListener(new CalendarCardView.OnCellClickListener() {
            @Override
            public void clickDate(CustomDate date) {//日期点击
                mAlreadySignDate.add(String.valueOf(date));
                signCalendar.setSignDateList(mAlreadySignDate);
                toast(String.valueOf(date));
            }

            @Override
            public void changeDate(CustomDate date) {

            }

            @Override
            public void currentTotalDay(int totalday) {

            }

            @Override
            public void touchToLastMounth(boolean isLastMounth) {
                if (isLastMounth){
                  signCalendar.leftSlide();//滑动上个月
                } else {
                    signCalendar.rightSlide();//滑动下个月
                }
            }
        });
    }

    @Override
    protected int getResId() {
        return R.layout.activity_sign;
    }
    // 从左往右划，上一个月
    public void leftSlide() {
        if (mCustomDate.month == 1) {
            mCustomDate.month = 12;
            mCustomDate.year -= 1;
        } else {
            mCustomDate.month -= 1;
        }

        initData();
    }

    // 从右往左划，下一个月
    public void rightSlide() {
        if (mCustomDate.month == 12) {
            mCustomDate.month = 1;
            mCustomDate.year += 1;
        } else {
            mCustomDate.month += 1;
        }

        initData();
    }

    @OnClick({R.id.iv_sign_back, R.id.tv_sign, R.id.tv_cur_date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_sign_back:
                finish();
                break;
            case R.id.tv_sign:
                break;
            case R.id.tv_cur_date:
                break;
        }
    }
}
