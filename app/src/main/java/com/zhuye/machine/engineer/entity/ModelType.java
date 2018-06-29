package com.zhuye.machine.engineer.entity;

import com.zhuye.machine.engineer.base.Base;

import java.util.List;

/**
 * Created by Administrator on 2018\6\8 0008.
 */

public class ModelType extends Base {

    private List<ModelTypeData> data;

    public List<ModelTypeData> getData() {
        return data;
    }

    public void setData(List<ModelTypeData> data) {
        this.data = data;
    }

    public class ModelTypeData{

        private String model_type;

        public String getModel_type() {
            return model_type;
        }

        public void setModel_type(String model_type) {
            this.model_type = model_type;
        }
    }
}

