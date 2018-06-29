package com.zhuye.machine.engineer.calender.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.zhuye.machine.engineer.calender.annotation.DayStatus.INVALID;
import static com.zhuye.machine.engineer.calender.annotation.DayStatus.NORMAL;
import static com.zhuye.machine.engineer.calender.annotation.DayStatus.RANGE;
import static com.zhuye.machine.engineer.calender.annotation.DayStatus.BOUND_L;
import static com.zhuye.machine.engineer.calender.annotation.DayStatus.BOUND_R;
import static com.zhuye.machine.engineer.calender.annotation.DayStatus.STRESS;


/**
 * Created by peng on 2017/8/2.
 */

@IntDef(value = {NORMAL, INVALID, RANGE, BOUND_L, BOUND_R, STRESS})
@Retention(RetentionPolicy.RUNTIME)
public @interface DayStatus {
    //正常
    int NORMAL = 0;
    //不可用
    int INVALID = 1;
    //范围内
    int RANGE = 2;
    //左边界
    int BOUND_L = 3;
    //右边界
    int BOUND_R = 4;
    //强调
    int STRESS = 5;
}