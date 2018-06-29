package com.zhuye.machine.engineer.entity;

import com.zhuye.machine.engineer.base.Base;

import java.util.List;

/**
 * Created by lcc2018 on 2018/6/26.
 */

public class DongDetail extends Base {

    private DongDetailData data;

    public DongDetailData getData() {
        return data;
    }

    public void setData(DongDetailData data) {
        this.data = data;
    }

    public class DongDetailData{
        private int zan_count;
        private String content;
        private String topic_name;
        private String img;
        private String add_time;
        private String topic_sum;
        private List<Comment> comment;
        private int is_attention;
        private int is_collect;
        private int is_zan;
        private String nickname;
        private int is_shi;
        private int sex;
        private int is_cheng;
        private String uid;

        public int getZan_count() {
            return zan_count;
        }

        public void setZan_count(int zan_count) {
            this.zan_count = zan_count;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTopic_name() {
            return topic_name;
        }

        public void setTopic_name(String topic_name) {
            this.topic_name = topic_name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getTopic_sum() {
            return topic_sum;
        }

        public void setTopic_sum(String topic_sum) {
            this.topic_sum = topic_sum;
        }

        public List<Comment> getComment() {
            return comment;
        }

        public void setComment(List<Comment> comment) {
            this.comment = comment;
        }

        public int getIs_attention() {
            return is_attention;
        }

        public void setIs_attention(int is_attention) {
            this.is_attention = is_attention;
        }

        public int getIs_collect() {
            return is_collect;
        }

        public void setIs_collect(int is_collect) {
            this.is_collect = is_collect;
        }

        public int getIs_zan() {
            return is_zan;
        }

        public void setIs_zan(int is_zan) {
            this.is_zan = is_zan;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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

        public int getIs_cheng() {
            return is_cheng;
        }

        public void setIs_cheng(int is_cheng) {
            this.is_cheng = is_cheng;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
