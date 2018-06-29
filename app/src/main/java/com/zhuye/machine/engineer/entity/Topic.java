package com.zhuye.machine.engineer.entity;

import com.zhuye.machine.engineer.base.Base;

import java.util.List;

/**
 * Created by lcc2018 on 2018/6/21.
 */

public class Topic extends Base {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        private List<SixTopic> list;
        private List<SixTopic> recommend;

        public List<SixTopic> getList() {
            return list;
        }

        public void setList(List<SixTopic> list) {
            this.list = list;
        }

        public List<SixTopic> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<SixTopic> recommend) {
            this.recommend = recommend;
        }

    }
}
