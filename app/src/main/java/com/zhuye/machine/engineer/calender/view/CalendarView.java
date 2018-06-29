package com.zhuye.machine.engineer.calender.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;


import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.calender.adapter.CalendarAdapter;
import com.zhuye.machine.engineer.calender.utils.DateUtils;
import com.zhuye.machine.engineer.calender.utils.TimeUtil;
import com.zhuye.machine.engineer.calender.utils.ViewUtils;
import com.zhuye.machine.engineer.calender.view.decoration.GroupListener;
import com.zhuye.machine.engineer.calender.view.decoration.StickyDecoration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日历控件
 * Created by peng on 2017/8/3.
 */

public class CalendarView extends LinearLayout {
    private final CalendarAdapter calendarAdapter = new CalendarAdapter();
    private final RecyclerView bodyView;
    private String desc= "";
    private Context context;

    public CalendarView(Context context) {
        this(context, null);
        this.context = context;
    }

    public CalendarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;

    }

    public CalendarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setOrientation(VERTICAL);
        inflate(context, R.layout.layout_calendar_view, this);
        //初始化星期标头
        initWeekGridView(context);
        //月份列表
        bodyView = (RecyclerView) findViewById(R.id.bodyView);
        bodyView.setLayoutManager(new LinearLayoutManager(context));
        bodyView.setAdapter(getAdapter());
        initDecoration(bodyView);
    }

    private void initWeekGridView(Context context) {
        String[] from = new String[]{"week"};
        int[] to = new int[]{R.id.tvWeekDay};
        String[] strings = new String[]{
                "日", "一", "二", "三", "四", "五", "六"
        };
        List<Map<String, String>> weeks = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put(from[0], strings[i]);
            weeks.add(map);
        }
        ListAdapter adapter = new SimpleAdapter(context, weeks, R.layout.layout_week_view, from, to);
        GridView weekView = (GridView) findViewById(R.id.weekView);
        weekView.setNumColumns(adapter.getCount());
        weekView.setAdapter(adapter);
        weekView.setSelector(new ColorDrawable(Color.TRANSPARENT));
    }

    public void initDecoration(RecyclerView bodyView) {
        GroupListener groupListener = new GroupListener() {
            @Override
            public String getGroupName(int position) {
                Date date = getAdapter().value(position);
                return TimeUtil.dateText(date.getTime(), TimeUtil.YY_M_CN);
            }
        };
        StickyDecoration decoration = StickyDecoration.Builder
                .init(groupListener)
                .setGroupBackground(ContextCompat.getColor(getContext(), R.color.colorView))     //背景色
                .setGroupHeight(100)     //高度
                .setDivideColor(ContextCompat.getColor(getContext(), R.color.colorSmallTitle))           //分割线颜色
                .setDivideHeight(1)  //分割线高度 (默认没有分割线)
                .setGroupTextColor(ContextCompat.getColor(getContext(), R.color.colorMiddleTitle))                        //字体颜色
                .setTypeface(Typeface.defaultFromStyle(Typeface.BOLD)) //加粗
                .setGroupTextSize(40)   //字体大小
                .setTextSideMargin(ViewUtils.dp2px(getContext(), 10))  //边距   靠左时为左边距  靠右时为右边距
                .setTextAlign(Paint.Align.CENTER)                      //居中显示
                .build();
        bodyView.addItemDecoration(decoration);
    }

    public void show(Date sDate, Date eDate,String desc) {
        this.desc = desc;
        List<Date> dates = DateUtils.fillMonths(sDate, eDate);
        getAdapter().update(context,dates,desc);
    }

    public void show(String sTime, String eTime, String format) {
        Date[] dates = new Date[2];
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            dates[0] = sdf.parse(sTime);
            dates[1] = sdf.parse(eTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        show(dates[0], dates[1],desc);
    }

    public CalendarAdapter getAdapter() {
        return calendarAdapter;
    }

    public RecyclerView bodyView() {
        return bodyView;
    }
}