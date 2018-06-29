package com.zhuye.machine.engineer.entity;

import com.zhuye.machine.engineer.base.Base;

import java.util.List;

/**
 * Created by Administrator on 2018\6\8 0008.
 */

public class Brand extends Base {
    private List<BrandData> data;

    public List<BrandData> getData() {
        return data;
    }

    public void setData(List<BrandData> data) {
        this.data = data;
    }

    public class BrandData{
        private String brand;
        private String brand_id;

        public String getBrand() {

            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getBrand_id() {
            return brand_id;
        }

        public void setBrand_id(String brand_id) {
            this.brand_id = brand_id;
        }
    }
}
