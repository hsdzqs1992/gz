package com.zhuye.machine.engineer.entity;

import com.zhuye.machine.engineer.base.Base;

import java.util.List;

/**
 * Created by lcc2018 on 2018/6/21.
 */

public class Index extends Base {
    private List<DataIndex> dataIndex;

    public List<DataIndex> getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(List<DataIndex> dataIndex) {
        this.dataIndex = dataIndex;
    }

    public class DataIndex {
        private String face;
        private String nickname;
        private String title;
        private String price;
        private int is_shi;
        private int sex;
        private int is_chengyi;
        private int type;
        private int zan;
        private int show_count;
        private int commentCont;
        private int juli;
        private List<String> imgs;

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getIs_shi() {
            return is_shi;
        }

        public void setIs_shi(int is_shi) {
            this.is_shi = is_shi;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public int getShow_count() {
            return show_count;
        }

        public void setShow_count(int show_count) {
            this.show_count = show_count;
        }

        public int getCommentCont() {
            return commentCont;
        }

        public void setCommentCont(int commentCont) {
            this.commentCont = commentCont;
        }

        public int getJuli() {
            return juli;
        }

        public void setJuli(int juli) {
            this.juli = juli;
        }

        public List<String> getImgs() {
            return imgs;
        }

        public void setImgs(List<String> imgs) {
            this.imgs = imgs;
        }
    }
}
