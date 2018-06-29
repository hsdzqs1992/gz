package com.zhuye.machine.engineer.entity;

import com.zhuye.machine.engineer.base.Base;

/**
 * Created by Administrator on 2018\6\8 0008.
 */

public class Login extends Base {

    private LoginData data;

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
    }

   public class LoginData {
        private String token;
        private String uid;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
