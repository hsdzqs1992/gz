package com.zhuye.machine.engineer.base;

/**
 * Created by Administrator on 2018\5\26 0026.
 */

public interface BaseView<T> {
    void loding();
    void finishLoding();
    void error(T t);
    void success(int requestcode, T t);
    void empty();
}
