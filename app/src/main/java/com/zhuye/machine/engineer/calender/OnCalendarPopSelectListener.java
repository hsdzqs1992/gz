package com.zhuye.machine.engineer.calender;

import android.support.annotation.NonNull;

/**
 * 日历Popwindow选择监听器
 * Created by wangcheng on 2017/8/4.
 */

public interface OnCalendarPopSelectListener {
    void onSelect(@NonNull String before, @NonNull String after);
}
