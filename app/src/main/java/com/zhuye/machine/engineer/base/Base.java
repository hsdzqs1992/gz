package com.zhuye.machine.engineer.base;

/**
 * Created by Administrator on 2018/2/3 0003.
 */

public class Base {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int code ;

    public String message;


    public Notify notify;
        public Notify getNotify() {
        return notify;
    }

    public void setNotify(Notify notify) {
        this.notify = notify;
    }
}
