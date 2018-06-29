package com.zhuye.machine.engineer.entity;

import com.zhuye.machine.engineer.base.Base;

import java.util.List;

/**
 * Created by Administrator on 2018\6\8 0008.
 */

public class Model extends Base {
    private List<ModelData> data;

    public List<ModelData> getData() {
        return data;
    }

    public void setData(List<ModelData> data) {
        this.data = data;
    }

    public class ModelData{
        private String model;
        private String model_id;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getModel_id() {
            return model_id;
        }

        public void setModel_id(String model_id) {
            this.model_id = model_id;
        }
    }
}
