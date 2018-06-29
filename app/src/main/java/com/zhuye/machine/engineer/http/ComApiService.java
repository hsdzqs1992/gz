package com.zhuye.machine.engineer.http;


import com.zhuye.machine.engineer.base.Base;
import com.zhuye.machine.engineer.base.CityBean;
import com.zhuye.machine.engineer.contants.NetWorkUrl;
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

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by Administrator on 2018\5\26 0026.
 */

public interface ComApiService {
    /**
     * 登录
     *
     * @param mobile
     * @param pass
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.USER_LOGIN)
    Observable<Login> login(@Field("mobile") String mobile, @Field("pass") String pass);

    /**
     * 注册
     *
     * @param mobile
     * @param pass
     * @param repass
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.REGISTER)
    Observable<Base> register(@Field("mobile") String mobile, @Field("pass") String pass, @Field("repass") String repass);

    /**
     * 获取验证码
     *
     * @param mobile
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.GET_CODE)
    Observable<Code> getCode(@Field("mobile ") String mobile);

    /**
     * 修改密码 忘记密码
     *
     * @param mobile
     * @param pass
     * @param repass
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.PSD_Edt)
    Observable<Base> editPass(@Field("mobile") String mobile, @Field("pass") String pass, @Field("repass") String repass);

    /**
     * 个人中心
     *
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.User_Center)
    Observable<User> userCenter(@Field("token") String token);

    /**
     * 获取品牌
     *
     * @return
     */
    @POST(NetWorkUrl.Get_Brand)
    Observable<Brand> getBrand();

    /**
     * 获取型号
     *
     * @param brand_id
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.Get_Model)
    Observable<Model> getModel(@Field("brand_id") String brand_id);

    /**
     * 获取类型
     *
     * @param model_id
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.Get_Model_type)
    Observable<ModelType> getModelType(@Field("model_id ") String model_id);

    /**
     * 发布
     */
    @Multipart
    @POST(NetWorkUrl.Fa_Bu)
    Observable<Code> faBu(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> file);

    /**
     * 话题检索
     *
     * @param title
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.Search_Topic)
    Observable<Base> searchTopic(@Field("title ") String title);

    /**
     * 每日话题
     *
     * @param page
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.Topic_list)
    Observable<Topic> topicList(@Field("page ") int page);

    /**
     * 获取省市区
     *
     * @return
     */
//    @FormUrlEncoded
    @POST(NetWorkUrl.Get_City)
    Observable<CityBean> getCity();

    /**
     * 获取省市区
     *
     * @return
     */
//    page		是	当前总条数
//    lat		是	经度
//    lng		是	纬度
//    type		是	类型
//    city_id		是	城市id
    @FormUrlEncoded
    @POST(NetWorkUrl.Index)
    Observable<Index> index(@Field("page") int page, @Field("lat") String lat, @Field("lng") String lng,
                            @Field("type") String type, @Field("city_id") String city_id);
//    dynamic_id		是	动态id
//            token

    @FormUrlEncoded
    @POST(NetWorkUrl.Dong_detail)
    Observable<DongDetail> detailDong(@Field("dynamic_id") String dynamic_id, @Field("token") String token);

    /**
     * 推荐部落
     *
     * @return
     */
    @POST(NetWorkUrl.Tui_Tribe_list)
    Observable<Tribe> tuiTribeList();

    /**
     * 我加入的部落
     *
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.My_Tribe_list)
    Observable<Tribe> myTribeList(@Field("token") String token);

    /**
     * 加入部落
     *
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.Add_Tribe)
    Observable<Code> addTribe(@Field("token") String token, @Field("tribe_id") String tribe_id);

    /**
     * 全部部落
     *
     * @return
     */
    @FormUrlEncoded
    @POST(NetWorkUrl.All_Tribe_list)
    Observable<AllTribe> allTribeList(@Field("page") int page);

    /**
     * 部落详情
     *
     * @return
     */

//    key	参数类型	是否必须	参数解释
//    tribe_id		是	部落id
//    token		否	用户唯一标示
//    page		是	当前总条数 默认0
//    lat		是	lat
//    lng		是	lng
//    city_id		是	城市id
    @FormUrlEncoded
    @POST(NetWorkUrl.Tribe_Detail)
    Observable<DongDetail> tribeDetail(@Field("tribe_id") String tribe_id, @Field("token") String token,
                                       @Field("page") int page, @Field("lat") String lat,
                                       @Field("lng") String lng, @Field("city_id") String city_id);
}
