package com.zhuye.machine.engineer.calender.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhuye.machine.engineer.calender.view.MonthView;


/**
 * Created by peng on 2017/8/3.
 */

public class CalendarViewHolder extends RecyclerView.ViewHolder {
    private final MonthView view;

    public CalendarViewHolder(View itemView) {
        super(itemView);
        view = (MonthView) itemView;
    }

    public MonthView view() {
        return view;
    }
}
