package com.zhuye.machine.engineer.calender.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.calender.annotation.DayStatus;
import com.zhuye.machine.engineer.calender.protocol.DayEntity;


/**
 * 日期控件
 * Created by peng on 2017/8/2.
 */

public final class DayView extends LinearLayout {
    private TextView tvDesc;
    private TextView tvDay;
    private DayEntity entity;

    public DayView(Context context) {
        super(context);
        initialize(context);
    }

    public DayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public DayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void initialize(Context context) {
        setOrientation(VERTICAL);
        inflate(context, R.layout.layout_day_view, this);
        setBackgroundColor(Color.WHITE);
        tvDesc = (TextView) findViewById(R.id.tvDesc);
        tvDay = (TextView) findViewById(R.id.tvDay);
    }

    public void value(DayEntity entity) {
        if (null != value()) {
            value().recycle();
        }
        this.entity = entity;
        //内容
        tvDay.setText(entity.value());
        setTextStatusColor(tvDay, entity.valueStatus());
        //描述
        if (entity.status() == DayStatus.RANGE) {
            tvDesc.setText(entity.desc());
        } else {
            tvDesc.setText("");
        }
        setTextStatusColor(tvDesc, entity.descStatus());
        //背景
        setBackgroundStatus(entity);
    }

    public DayEntity value() {
        return entity;
    }

    /**
     * 设置文本状态颜色
     *
     * @param tv
     * @param status
     */
    private void setTextStatusColor(TextView tv, @DayStatus int status) {
        switch (status) {
            //正常
            case DayStatus.NORMAL:
                tv.setTextColor(ContextCompat.getColor(getContext(), R.color.colorMiddleTitle));
                break;
            //不可用
            case DayStatus.INVALID:
//                tv.setTextColor(ContextCompat.getColor(getContext(), R.color.day_text_invalid_color));
                tv.setTextColor(ContextCompat.getColor(getContext(), R.color.colorSmallTitle));
                break;
            //范围内
            case DayStatus.RANGE:
                tv.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                break;
            //左边界
            case DayStatus.BOUND_L:
                tv.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                break;
            //右边界
            case DayStatus.BOUND_R:
                tv.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                break;
            //强调
            case DayStatus.STRESS:
                tv.setTextColor(ContextCompat.getColor(getContext(), R.color.colorMiddleTitle));
                break;
        }
    }

    /**
     * 设置背景状态
     *
     * @param entity
     */
    private void setBackgroundStatus(DayEntity entity) {
        switch (entity.status()) {
            //正常
            case DayStatus.NORMAL:
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                setEnabled(true);
                break;
            //不可用
            case DayStatus.INVALID:
//                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.day_background_invalid_color));
//                setTextStatusColor(tvDay, entity.status());
//                setEnabled(false);
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorSmallTitle));
                setEnabled(true);
                break;
            //范围内
            case DayStatus.RANGE:
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorGreen));
                tvDay.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                tvDesc.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                setEnabled(true);
                break;
            //左边界
            case DayStatus.BOUND_L:
                tvDay.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                tvDesc.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                tvDesc.setText(entity.note());
                setBackgroundResource(R.drawable.shape_calendar_bg_blue);
                break;
            //右边界
            case DayStatus.BOUND_R:
                tvDay.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                tvDesc.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                tvDesc.setText(entity.note());
                setBackgroundResource(R.drawable.shape_calendar_bg_blue);
                break;
            //强调
            case DayStatus.STRESS:
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorWrite));
                setEnabled(true);
                break;
        }
    }
}