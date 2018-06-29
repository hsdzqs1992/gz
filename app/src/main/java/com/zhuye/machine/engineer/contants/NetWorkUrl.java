package com.zhuye.machine.engineer.contants;

/**
 * Created by Administrator on 2018/1/2.
 */

public class NetWorkUrl {
    public static final int SDK_PAY_FLAG = 101;
    public static final String SUCCESS = "200";
    public static final String ERROR = "201";
    public static final String HINT = "303";
    public static final String Invalidate = "288";//token失效
    public static final String CentCode = "244";//
    public static final String WEIXIN_APP_ID = "wxd5adc715f0b00d71";
    public static final String WEIXIN_APP_SECRET = "5097145cb4866edc1aacf0ba6bb5937b";
    public static final String QQ_APP_ID = "1106578310";
    //人脸识别
    public static String apiKey = "Qjkyc2zCGaGzTsHdGFDLUATn";
    public static String secretKey = "QrUATm0TZk2hg1xpSQPlIBVUpnKMlmcj";
    public static String licenseID = "zhihuishequzhuye-face-android";
    public static String licenseFileName = "idl-license.face-android";
    public static String BASE_URL = "https://aip.baidubce.com";
    public static String ACCESS_TOEKN_URL = BASE_URL + "/oauth/2.0/token?";

    // 网络地址头部
    public static final String SERVER_LOCATION =
            "http://192.168.1.37/gcjx/";
    //            "http://zhihui.zyeo.net";
    public static final String Pic_Url_Append =
            "http://192.168.1.37/gcjx";
    public static final String USER_LOGIN = "api/user/login";// 登录
    public static final String GET_CODE = "api/user/getVerify";// 验证码
    public static final String REGISTER = "api/user/register";// 注册
    public static final String PSD_Edt = "api/user/modify_pass";// 修改密码
    public static final String User_Center = "api/user/user";// 个人中心 token
    public static final String Get_Brand = "api/dynamic/get_brand  ";// 获取品牌
    public static final String Get_Model = "api/dynamic/getmodel"; // 获取型号
    public static final String Get_Model_type = "api/dynamic/get_model_type"; // 获取类型
    public static final String Fa_Bu = "api/dynamic/add_dynamic"; // 发布
    public static final String Search_Topic = "api/dynamic/search_topic "; // 检索话题
    public static final String Topic_list = "api/index/topic_list"; // 每日话题列表
    public static final String Get_City = "api/common/get_region"; // 获取省市区
    public static final String Index = "api/index/index"; // 首页
    public static final String Dong_detail = "api/index/dynamic_detail"; // 动态详情
    public static final String My_Tribe_list = "api/user/my_tribe_list"; // 我加入的部落列表
    public static final String Add_Tribe = "api/user/add_user_tribe"; // 加入部落
    public static final String All_Tribe_list = "api/index/tribe_list_all"; // 全部部落
    public static final String Tui_Tribe_list = "api/index/index_tribe_list"; // 推荐部落
    public static final String Tribe_Detail = "api/index/tribe_detail"; // 部落详情

}