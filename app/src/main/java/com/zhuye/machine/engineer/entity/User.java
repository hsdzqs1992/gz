package com.zhuye.machine.engineer.entity;

import com.zhuye.machine.engineer.base.Base;

/**
 * Created by Administrator on 2018\6\8 0008.
 */

public class User extends Base {
    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public class UserData{

        private String face;
        private String usename;
        private int sex;
        private int is_chengyi;
        private int is_shi;
        private int dynamic_count;
        private int attention_count;
        private int be_focused_count;
        private int chengyi_price;
        private int user_money;
        private int integral ;
        private String  city;

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getUsename() {
            return usename;
        }

        public void setUsename(String usename) {
            this.usename = usename;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getIs_chengyi() {
            return is_chengyi;
        }

        public void setIs_chengyi(int is_chengyi) {
            this.is_chengyi = is_chengyi;
        }

        public int getIs_shi() {
            return is_shi;
        }

        public void setIs_shi(int is_shi) {
            this.is_shi = is_shi;
        }

        public int getDynamic_count() {
            return dynamic_count;
        }

        public void setDynamic_count(int dynamic_count) {
            this.dynamic_count = dynamic_count;
        }

        public int getAttention_count() {
            return attention_count;
        }

        public void setAttention_count(int attention_count) {
            this.attention_count = attention_count;
        }

        public int getBe_focused_count() {
            return be_focused_count;
        }

        public void setBe_focused_count(int be_focused_count) {
            this.be_focused_count = be_focused_count;
        }

        public int getChengyi_price() {
            return chengyi_price;
        }

        public void setChengyi_price(int chengyi_price) {
            this.chengyi_price = chengyi_price;
        }

        public int getUser_money() {
            return user_money;
        }

        public void setUser_money(int user_money) {
            this.user_money = user_money;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
