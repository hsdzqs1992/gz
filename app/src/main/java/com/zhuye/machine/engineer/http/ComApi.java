package com.zhuye.machine.engineer.http;


import com.zhuye.machine.engineer.base.Base;
import com.zhuye.machine.engineer.base.CityBean;
import com.zhuye.machine.engineer.entity.AllTribe;
import com.zhuye.machine.engineer.entity.Brand;
import com.zhuye.machine.engineer.entity.Code;
import com.zhuye.machine.engineer.entity.DongDetail;
import com.zhuye.machine.engineer.entity.Index;
import com.zhuye.machine.engineer.entity.Login;
import com.zhuye.machine.engineer.entity.Model;
import com.zhuye.machine.engineer.entity.ModelType;
import com.zhuye.machine.engineer.entity.SixTopic;
import com.zhuye.machine.engineer.entity.Topic;
import com.zhuye.machine.engineer.entity.Tribe;
import com.zhuye.machine.engineer.entity.User;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018\5\26 0026.
 */

public class ComApi {
    public static ComApi instance;
    public static Map<String, RequestBody> map;
    public static List<MultipartBody.Part> body;

    public static ComApi getInstance() {
        if (instance == null)
            instance = new ComApi();
        return instance;
    }

    private ComApiService service;

    public ComApi() {
        service = HttpUtils.getRetrofit(HttpUtils.getOkhttp()).create(ComApiService.class);
    }

    /**
     * 登录
     *
     * @param mobile
     * @param password
     * @return
     */
    public Observable<Login> login(String mobile, String password) {
        return service.login(mobile, password);
    }

    /**
     * 注册
     *
     * @param mobile
     * @param password
     * @param repass
     * @return
     */
    public Observable<Base> register(String mobile, String password, String repass) {
        return service.register(mobile, password, repass);
    }

    /**
     * 修改密码  忘记密码
     *
     * @param mobile
     * @param password
     * @param repass
     * @return
     */
    public Observable<Base> editPass(String mobile, String password, String repass) {
        return service.editPass(mobile, password, repass);

    }

    /**
     * 获取验证码
     *
     * @param mobile
     * @return
     */
    public Observable<Code> getCode(String mobile) {
        return service.getCode(mobile);
    }

    /**
     * 用户中心
     *
     * @param token
     * @return
     */
    public Observable<User> userCenter(String token) {
        return service.userCenter(token);
    }

    /* 获取省市区
     * @param token
     * @return
     */
    public Observable<CityBean> getCity() {
        return service.getCity();
    }

    /* 获取品牌
    * @param token
    * @return
    */
    public Observable<Brand> getBrand() {
        return service.getBrand();
    }

    /**
     * 获取型号
     *
     * @param brand_id
     * @return
     */
    public Observable<Model> getModel(String brand_id) {
        return service.getModel(brand_id);
    }

    /**
     * 获取类型
     *
     * @param
     * @return
     */
    public Observable<ModelType> getModelType(String model_id) {
        return service.getModelType(model_id);
    }

    /**
     * 获取类型
     *
     * @param
     * @return
     */
    public Observable<Code> faBu(String token, String lat, String lng, String type, String city_name,
                                 String content, String topic, String title, String data_time,
                                 String region, String age, String require, String operation_direction,
                                 String welfare, String price, String user_name, String user_mobile,
                                 String position, String man_sum, String brand, String model, String model_type,
                                 String year, String hour, String zu_price_type, String zu_price,
                                 String zu_time_type, String zu_time, List<File> filepath) {
        map = new HashMap<>();
        RequestBody fa_token = RequestBody.create(MediaType.parse("multipart/form-data"), token);
        RequestBody fa_lat = RequestBody.create(MediaType.parse("multipart/form-data"), lat);
        RequestBody fa_lng = RequestBody.create(MediaType.parse("multipart/form-data"), lng);
        RequestBody fa_type = RequestBody.create(MediaType.parse("multipart/form-data"), type);
        RequestBody fa_city_name = RequestBody.create(MediaType.parse("multipart/form-data"), city_name);
        RequestBody fa_content = RequestBody.create(MediaType.parse("multipart/form-data"), content);
        RequestBody fa_topic = RequestBody.create(MediaType.parse("multipart/form-data"), topic);
        RequestBody fa_tile = RequestBody.create(MediaType.parse("multipart/form-data"), title);
        RequestBody fa_data_time = RequestBody.create(MediaType.parse("multipart/form-data"), data_time);
        RequestBody fa_region = RequestBody.create(MediaType.parse("multipart/form-data"), region);
        RequestBody fa_require = RequestBody.create(MediaType.parse("multipart/form-data"), require);
        RequestBody fa_age = RequestBody.create(MediaType.parse("multipart/form-data"), age);
        RequestBody fa_operation_direction = RequestBody.create(MediaType.parse("multipart/form-data"), operation_direction);
        RequestBody fa_welfare = RequestBody.create(MediaType.parse("multipart/form-data"), welfare);
        RequestBody fa_price = RequestBody.create(MediaType.parse("multipart/form-data"), price);
        RequestBody fa_user_name = RequestBody.create(MediaType.parse("multipart/form-data"), user_name);
        RequestBody fa_user_mobile = RequestBody.create(MediaType.parse("multipart/form-data"), user_mobile);
        RequestBody fa_position = RequestBody.create(MediaType.parse("multipart/form-data"), position);
        RequestBody fa_man_sum = RequestBody.create(MediaType.parse("multipart/form-data"), man_sum);
        RequestBody fa_brand = RequestBody.create(MediaType.parse("multipart/form-data"), brand);
        RequestBody fa_model = RequestBody.create(MediaType.parse("multipart/form-data"), model);
        RequestBody fa_model_type = RequestBody.create(MediaType.parse("multipart/form-data"), model_type);
        RequestBody fa_year = RequestBody.create(MediaType.parse("multipart/form-data"), year);
        RequestBody fa_hour = RequestBody.create(MediaType.parse("multipart/form-data"), hour);
        RequestBody fa_zu_price_type = RequestBody.create(MediaType.parse("multipart/form-data"), zu_price_type);
        RequestBody fa_zu_price = RequestBody.create(MediaType.parse("multipart/form-data"), zu_price);
        RequestBody fa_zu_time_type = RequestBody.create(MediaType.parse("multipart/form-data"), zu_time_type);
        RequestBody fa_zu_time = RequestBody.create(MediaType.parse("multipart/form-data"), zu_time);
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part files = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        map.put("token", fa_token);
        map.put("lat", fa_lat);
        map.put("lng", fa_lng);
        map.put("type", fa_type);
        map.put("city_name", fa_city_name);
        map.put("content", fa_content);
        map.put("topic", fa_topic);
        map.put("title", fa_tile);
        map.put("date_time", fa_data_time);
        map.put("region", fa_region);
        map.put("age", fa_age);
        map.put("require", fa_require);
        map.put("operation_direction", fa_operation_direction);
        map.put("welfare", fa_welfare);
        map.put("price", fa_price);
        map.put("user_name", fa_user_name);
        map.put("user_mobile", fa_user_mobile);
        map.put("position", fa_position);
        map.put("brand", fa_brand);
        map.put("model", fa_model);
        map.put("model_type", fa_model_type);
        map.put("year", fa_year);
        map.put("hour", fa_hour);
        map.put("zu_prcie_type", fa_zu_price_type);
        map.put("zu_price", fa_zu_price);
        map.put("zu_time_type", fa_zu_time_type);
        map.put("zu_time", fa_zu_time);
//        map.put("model_type", fa_model_type);
        if (filepath != null) {
            body = filesToMultipartBodyParts(filepath);
        }
            return service.faBu(map, body);
    }

    public Observable<Code> weight_img(String token, List<File> filepath, String order_id, String type
            , String f_unit, String s_unit, String good_name, String car_card, String m_weight
            , String p_weight, String weight, String driver_name) {
        map = new HashMap<>();
        RequestBody tokenbo = RequestBody.create(MediaType.parse("multipart/form-data"), token);
        RequestBody order_idbo = RequestBody.create(MediaType.parse("multipart/form-data"), order_id);
        RequestBody typebo = RequestBody.create(MediaType.parse("multipart/form-data"), type);
        RequestBody f_unitbo = RequestBody.create(MediaType.parse("multipart/form-data"), f_unit);
        RequestBody s_unitbo = RequestBody.create(MediaType.parse("multipart/form-data"), s_unit);
        RequestBody good_namebo = RequestBody.create(MediaType.parse("multipart/form-data"), good_name);
        RequestBody car_cardbo = RequestBody.create(MediaType.parse("multipart/form-data"), car_card);
        RequestBody m_weightbo = RequestBody.create(MediaType.parse("multipart/form-data"), m_weight);
        RequestBody p_weightbo = RequestBody.create(MediaType.parse("multipart/form-data"), p_weight);
        RequestBody weightbo = RequestBody.create(MediaType.parse("multipart/form-data"), weight);
        RequestBody driver_namebo = RequestBody.create(MediaType.parse("multipart/form-data"), driver_name);
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part files = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        body = filesToMultipartBodyParts(filepath);

        map.put("token", tokenbo);
        map.put("order_id", order_idbo);
        map.put("type", typebo);
        map.put("f_unit", f_unitbo);
        map.put("s_unit", s_unitbo);
        map.put("good_name", good_namebo);
        map.put("car_card", car_cardbo);
        map.put("m_weight", m_weightbo);
        map.put("p_weight", p_weightbo);
        map.put("weight", weightbo);
        map.put("driver_name", driver_namebo);
//        return service.weight_img(map, body);
        return null;
    }

    /**
     * 多文件
     *
     * @param files
     * @return
     */
    private List<MultipartBody.Part> filesToMultipartBodyParts(List<File> files) {
        List<MultipartBody.Part> parts = new ArrayList<>(files.size());
        for (File file : files) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("file[]", file.getName(), requestBody);
            parts.add(part);
        }
        return parts;
    }
    /**
     * 获取话题列表
     *
     * @param page
     * @return
     */
    public Observable<Topic> topicList(int page) {
        return service.topicList(page);
    }
    public Observable<Index> index(int page,String lat,String lng,String type,String city_id){
        return service.index(page,lat,lng,type,city_id);
    }

    /**
     * 动态详情 此刻
     * @param dynamic_id
     * @param token
     * @return
     */
    public Observable<DongDetail> detailDong(String dynamic_id, String token){
        return service.detailDong(dynamic_id,token);
    }

    /**
     * 推荐部落
     * @return
     */
    public Observable<Tribe> tuiTribeList(){
        return service.tuiTribeList();
    }

    /**
     * 我加入的部落
     * @param token
     * @return
     */
    public Observable<Tribe> myTribeList(String token){
        return service.myTribeList(token);
    }

    /**
     * 加入部落
     * @param token
     * @param tribe_id
     * @return
     */
    public Observable<Code> addTribe(String token,String tribe_id){
        return service.addTribe(token,tribe_id);
    }

    /**
     * 全部部落
     * @param page
     * @return
     */
    public Observable<AllTribe> allTribeList(int page){
        return service.allTribeList(page);
    }

    /**
     * 部落详情
     * @param tribe_id
     * @param token
     * @param page
     * @param lat
     * @param lng
     * @param city_id
     * @return
     */
    public Observable<DongDetail> tribeDetail(String tribe_id,String token,int page,String lat,String lng,String city_id){
        return service.tribeDetail(tribe_id,token,page,lat,lng,city_id);
    }
}
