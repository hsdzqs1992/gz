package com.zhuye.machine.engineer.http;

import android.content.Context;
import android.widget.Toast;

import com.zhuye.machine.engineer.base.Base;
import com.zhuye.machine.engineer.base.BaseView;
import com.zhuye.machine.engineer.base.CityBean;
import com.zhuye.machine.engineer.contants.Contans;
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
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;

import java.io.File;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.GET;

/**
 * 获取网络数据
 */

public class GetData {


    public static void loginWarn(String token) {
        if (token.equals("")) {

        }
    }

    public static void login(String mobile, String password, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().login(mobile, password).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Login>(baseView) {
                    @Override
                    public void onNext(@NonNull Login base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    public static void register(String mobile, String password, String repass, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().register(mobile, password, repass).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Base>(baseView) {
                    @Override
                    public void onNext(@NonNull Base base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    public static void getCode(String mobile, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().getCode(mobile).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Code>(baseView) {
                    @Override
                    public void onNext(@NonNull Code base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    public static void editPass(String mobile, String password, String repass, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().editPass(mobile, password, repass).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Base>(baseView) {
                    @Override
                    public void onNext(@NonNull Base base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    public static void userCenter(String token, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().userCenter(token).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<User>(baseView) {
                    @Override
                    public void onNext(@NonNull User base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    public static void getBrand(final BaseView baseView, final int requestcode) {
        ComApi.getInstance().getBrand().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Brand>(baseView) {
                    @Override
                    public void onNext(@NonNull Brand base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    /**
     * 获取城市区
     *
     * @param baseView
     * @param requestcode
     */
    public static void getCity(final BaseView baseView, final int requestcode) {
        ComApi.getInstance().getCity().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<CityBean>(baseView) {
                    @Override
                    public void onNext(@NonNull CityBean base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    public static void getModel(String brand_id, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().getModel(brand_id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Model>(baseView) {
                    @Override
                    public void onNext(@NonNull Model base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    public static void getModelType(String model_id, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().getModelType(model_id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<ModelType>(baseView) {
                    @Override
                    public void onNext(@NonNull ModelType base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    public static void faBu(String token, String lat, String lng, String type, String city_name,
                            String content, String topic, String title, String data_time,
                            String region, String age, String require, String operation_direction,
                            String welfare, String price, String user_name, String user_mobile,
                            String position, String man_sum, String brand, String model, String model_type,
                            String year, String hour, String zu_price_type, String zu_price,
                            String zu_time_type, String zu_time, List<File> filepath, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().faBu(token, lat, lng, type, city_name, content, topic, title, data_time, region, age,
                require, operation_direction, welfare, price, user_name, user_mobile, position, man_sum, brand, model, model_type,
                year, hour, zu_price_type, zu_price, zu_time_type, zu_time, filepath).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Code>(baseView) {
                    @Override
                    public void onNext(@NonNull Code base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    public static void topicList(int page, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().topicList(page).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Topic>(baseView) {
                    @Override
                    public void onNext(@NonNull Topic base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }

    //    int page,String lat,String lng,String type,String city_id
    public static void index(int page, String lat, String lng, String type, String city_id, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().index(page, lat, lng, type, city_id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Index>(baseView) {
                    @Override
                    public void onNext(@NonNull Index base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }
    //动态详情
    public static void detailDong( String dynamic_id, String token, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().detailDong(dynamic_id, token).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<DongDetail>(baseView) {
                    @Override
                    public void onNext(@NonNull DongDetail base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }
    //推荐部落
    public static void tuiTribeList(  final BaseView baseView, final int requestcode) {
        ComApi.getInstance().tuiTribeList().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Tribe>(baseView) {
                    @Override
                    public void onNext(@NonNull Tribe base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }
    //我加入的部落
    public static void myTribeList(String token, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().myTribeList(token).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Tribe>(baseView) {
                    @Override
                    public void onNext(@NonNull Tribe base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }
    //加入部落
    public static void addTribe(String token,String tribe_id, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().addTribe(token,tribe_id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<Code>(baseView) {
                    @Override
                    public void onNext(@NonNull Code base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }
    //全部部落
    public static void allTribeList(int page, final BaseView baseView, final int requestcode) {
        ComApi.getInstance().allTribeList(page).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<AllTribe>(baseView) {
                    @Override
                    public void onNext(@NonNull AllTribe base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }
    //部落详情
    public static void tribeDetail(String tribe_id,String token,int page,String lat,String lng,
                                    String city_id,final BaseView baseView, final int requestcode) {
        ComApi.getInstance().tribeDetail(tribe_id,token,page,lat,lng,city_id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MyObserver<DongDetail>(baseView) {
                    @Override
                    public void onNext(@NonNull DongDetail base) {
                        if (base.getCode() == 200) {
                            baseView.success(requestcode, base);
                        } else {
                            baseView.error(base);
                        }
                        baseView.finishLoding();
                    }
                });
    }
}
