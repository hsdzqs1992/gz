package com.zhuye.machine.engineer.homefragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.activity.SearchActivity;
import com.zhuye.machine.engineer.activity.home.SignActivity;
import com.zhuye.machine.engineer.activity.home.TopicDailyActivity;
import com.zhuye.machine.engineer.base.BaseFragment;
import com.zhuye.machine.engineer.mainfragment.tui.AdvertisekFragment;
import com.zhuye.machine.engineer.mainfragment.tui.DaiLiFragment;
import com.zhuye.machine.engineer.mainfragment.tui.FindJobFragment;
import com.zhuye.machine.engineer.mainfragment.tui.RentFragment;
import com.zhuye.machine.engineer.mainfragment.tui.RequireRentFragment;
import com.zhuye.machine.engineer.mainfragment.tui.ZongFragment;
import com.zhuye.machine.engineer.widget.ChildViewPager;
import com.zhuye.machine.engineer.widget.MyAdGallery;
import com.zhuye.machine.engineer.widget.TuiTabAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 推荐
 * A simple {@link Fragment} subclass.
 */
public class TuiFragment extends BaseFragment {


    @BindView(R.id.tui_tab_layout)
    TabLayout tuiTabLayout;
    @BindView(R.id.tui_view_pager)
    ChildViewPager tuiViewPager;
    @BindView(R.id.tv_search_content)
    TextView tvSearchContent;
    @BindView(R.id.banner_tui)
    MyAdGallery bannerTui;
    @BindView(R.id.ovalLayout)
    LinearLayout ovalLayout;
    @BindView(R.id.iv_sign)
    ImageView ivSign;
    @BindView(R.id.iv_topic)
    ImageView ivTopic;
    private String[] strs = new String[]{"综合", "代理", "招聘", "求职", "出租", "求租"};
    private List<Fragment> lists = new ArrayList<>();
    private Intent intent;

    public TuiFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView() {
        lists.clear();
        lists.add(new ZongFragment());//综合
        lists.add(new DaiLiFragment());//代班
        lists.add(new AdvertisekFragment());//招聘
        lists.add(new FindJobFragment());//求职
//        lists.add(new RequireRentFragment());//出租
        lists.add(new RentFragment());//出租
        tuiViewPager.setAdapter(new TuiTabAdapter(getChildFragmentManager(), lists, strs));
        tuiTabLayout.setupWithViewPager(tuiViewPager);
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_tui;
    }



    @OnClick({R.id.iv_sign, R.id.iv_topic,R.id.tv_search_content})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_sign://每日签到
                intent = new Intent(getActivity(), SignActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_topic://每日话题
                intent = new Intent(getActivity(), TopicDailyActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.tv_search_content://检索
                intent = new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(intent);
                break;
                default:
                    break;
        }
    }
}
