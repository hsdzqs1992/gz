package com.zhuye.machine.engineer.calender;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.calender.protocol.OnCalendarSelectListener;
import com.zhuye.machine.engineer.calender.utils.DateUtils;
import com.zhuye.machine.engineer.calender.utils.TimeUtil;
import com.zhuye.machine.engineer.calender.utils.ViewUtils;
import com.zhuye.machine.engineer.calender.view.CalendarView;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 日历选择PopWindow
 *
 */

public class CalendarPopWindow extends PopupWindow implements OnCalendarSelectListener {

    private CalendarView mCalendarView;
    private String beforeDate;
    private String afterDate;

    public CalendarPopWindow(Context context, final OnCalendarPopSelectListener listener,String price) {
        View view = LayoutInflater.from(context).inflate(R.layout.calendar_popwindow_layout, null, false);
        ImageView cancel = (ImageView) view.findViewById(R.id.iv_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        TextView button = (TextView) view.findViewById(R.id.bt_sure);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (beforeDate != null && afterDate != null) {
                    listener.onSelect(beforeDate, afterDate);
                    dismiss();
                }
            }
        });
        mCalendarView = (CalendarView) view.findViewById(R.id.cv_calendar);
        Date currentDate = new Date(System.currentTimeMillis());
//        Date endDate = DateUtils.getLastDayFromMonth(currentDate);
        Date startDate = DateUtils.getDayYearAgo(currentDate);
        mCalendarView.getAdapter().valid(null, TimeUtil.dateText(currentDate.getTime(), TimeUtil.YY_MD));
        mCalendarView.getAdapter().setOnCalendarSelectListener(this);
        mCalendarView.getAdapter().intervalNotes("开始", "结束");
        mCalendarView.show(currentDate, startDate,price);
        DisplayMetrics metrics = ViewUtils.getDisplayMetrics(context);
        setWidth(metrics.widthPixels);
        setHeight(metrics.heightPixels - ViewUtils.getStateBarHeight(context));
        setContentView(view);
        setFocusable(true);
    }

    public void onShow(View parent) {
        if (!this.isShowing()) {
            showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        } else {
            this.dismiss();
        }
    }

    public void onShow(View parent, Date before, Date after) {
        mCalendarView.getAdapter().select(before, after);
        onShow(parent);
    }

    @Override
    public void onCalendarSingleSelect(@NonNull Date date) {
        beforeDate = null;
        afterDate = null;
    }

    @Override
    public void onCalendarBothSelect(@NonNull Date before, @NonNull Date after) {
        beforeDate = Stringdate(before);
        afterDate = Stringdate(after);
    }
    // 时间转字符串
    public  String Stringdate(Date cc_time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(cc_time);
    }
}
