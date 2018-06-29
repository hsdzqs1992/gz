package com.zhuye.machine.engineer;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.baidu.mapapi.SDKInitializer;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.List;

/**
 * Created by lcc2018 on 2018/6/13.
 */

public class MyApplication  extends Application {

    public static int Itemindex = 0;
    public static Handler handler;
    public static int flag = 0;
    public static Handler getHandler() {
        return handler;
    }

    public static void bindHandler(Handler h) {
        handler = h;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //百度地图
//        SDKInitializer.initialize(getApplicationContext());
        //极光推送
//        JPushInterface.init(this);
//        JPushInterface.setDebugMode(true);


//        //设置全局的Header构建器
//        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
//            @Override
//            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                return new ClassicsHeader(context).
//                        setDrawableSize(15).
//                        setTimeFormat(new DynamicTimeFormat("最后更新： %s"));//指定为经典Header，默认是 贝塞尔雷达Header
//            }
//        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(15);
            }
        });
    }

//    public void registerToWX() {
//        //第二个参数是指你应用在微信开放平台上的AppID
//        mWxApi = WXAPIFactory.createWXAPI(this, NetWorkUrl.WEIXIN_APP_ID, false);
//        // 将该app注册到微信
//        mWxApi.registerApp(NetWorkUrl.WEIXIN_APP_ID);
//    }
}
