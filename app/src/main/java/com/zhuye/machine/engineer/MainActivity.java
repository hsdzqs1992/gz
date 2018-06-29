package com.zhuye.machine.engineer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.mainfragment.ChooseFragment;
import com.zhuye.machine.engineer.mainfragment.DaiBanFragment;
import com.zhuye.machine.engineer.mainfragment.HomeFragment;
import com.zhuye.machine.engineer.mainfragment.MineFragment;
import com.zhuye.machine.engineer.mainfragment.ShopFragment;
import com.zhuye.machine.engineer.widget.FabuPop;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.main_tabView)
    TabView mainTabView;
    private FabuPop fabuPop;

    @Override
    protected int getResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();



    }

    @Override
    protected void initData() {
        super.initData();
        List<TabViewChild> tabViewChildList = new ArrayList<>();
        TabViewChild tabViewChild01 = new TabViewChild(R.drawable.bottom_home_blue, R.drawable.bottom_home_gray, "首页", new HomeFragment());
        TabViewChild tabViewChild02 = new TabViewChild(R.drawable.bottom_choose_blue, R.drawable.bottom_choose_gray, "选机", new ChooseFragment());
        TabViewChild tabViewChild03 = new TabViewChild(R.drawable.bottom_dai_blue, R.drawable.bottom_dai_gray, "代班", new DaiBanFragment());
        TabViewChild tabViewChild04 = new TabViewChild(R.drawable.bottom_buy_car_blue, R.drawable.bottom_buy_car_gray, "商城", new ShopFragment());
        TabViewChild tabViewChild05 = new TabViewChild(R.drawable.bottom_mine_blue, R.drawable.bottom_mine_gray, "我的", new MineFragment());
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild04);
        tabViewChildList.add(tabViewChild05);
        mainTabView.setTabViewChild(tabViewChildList, getSupportFragmentManager());
    }

    @Override
    protected void initListener() {
        super.initListener();
//        btnFabu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fabuPop = new FabuPop(MainActivity.this);
//                fabuPop.onShow(view);
//            }
//        });
    }
}
