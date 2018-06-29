package com.zhuye.machine.engineer.entity;

import com.zhuye.machine.engineer.base.Base;

import java.util.List;

/**
 * Created by lcc2018 on 2018/6/28.
 */

public class AllTribe extends Base {

    private List<AllData> data;

    public List<AllData> getData() {
        return data;
    }

    public void setData(List<AllData> data) {
        this.data = data;
    }

    public class AllData {

        private String name;
        private String img_path;
        private String tribe_id;
        private int count;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg_path() {
            return img_path;
        }

        public void setImg_path(String img_path) {
            this.img_path = img_path;
        }

        public String getTribe_id() {
            return tribe_id;
        }

        public void setTribe_id(String tribe_id) {
            this.tribe_id = tribe_id;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
