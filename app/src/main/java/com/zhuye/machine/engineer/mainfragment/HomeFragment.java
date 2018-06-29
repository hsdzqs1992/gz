package com.zhuye.machine.engineer.mainfragment;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.activity.mine.adapter.TabAdapter;
import com.zhuye.machine.engineer.base.BaseFragment;
import com.zhuye.machine.engineer.homefragment.AttentionFragment;
import com.zhuye.machine.engineer.homefragment.GroupFragment;
import com.zhuye.machine.engineer.homefragment.NowFragment;
import com.zhuye.machine.engineer.homefragment.TuiFragment;
import com.zhuye.machine.engineer.widget.FabuPop;
import com.zhuye.machine.engineer.widget.FragmentsAdapter;
import com.zhuye.machine.engineer.widget.MyViewPager;
import com.zhuye.machine.engineer.widget.TuiTabAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 首页 frament
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.btn_fabu)
    Button btnFabu;
        @BindView(R.id.home_tab_layout)
    TabLayout homeTabLayout;
    @BindView(R.id.home_view_pager)
    ViewPager homeViewPager;
//    @BindView(R.id.tv_tuijian)
//    TextView tvTuijian;
//    @BindView(R.id.tv_attention)
//    TextView tvAttention;
//    @BindView(R.id.tv_now)
//    TextView tvNow;
//    @BindView(R.id.tv_group)
//    TextView tvGroup;
    @BindView(R.id.tile)
    LinearLayout tile;
    private FabuPop fabuPop;
    private FragmentsAdapter fragmentsAdapter;
        private String[] str = new String[]{"推荐", "关注", "此刻","部落"};
    private List<Fragment> list = new ArrayList<>();
    private int flag = 0;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView() {
        list.add(new TuiFragment());//推荐
        list.add(new AttentionFragment());//关注
        list.add(new NowFragment());//此刻
        list.add(new GroupFragment());//部落
        homeViewPager.setAdapter(new TuiTabAdapter(getChildFragmentManager(), list, str));
        homeTabLayout.setupWithViewPager(homeViewPager);
//        fragmentsAdapter = new FragmentsAdapter(getChildFragmentManager(), list);
//        homeViewPager.setAdapter(fragmentsAdapter);
//        homeViewPager.setCurrentItem(0, false);
//        fragmentsAdapter.notifyDataSetChanged();
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_home;
    }


    @OnClick({R.id.btn_fabu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.tv_tuijian:
//                flag = 1;
//                changeState(flag);
//                homeViewPager.setCurrentItem(0, false);
//                break;
//            case R.id.tv_attention:
//                flag = 2;
//                changeState(flag);
//                homeViewPager.setCurrentItem(1, false);
//                break;
//            case R.id.tv_now:
//                flag = 3;
//                changeState(flag);
//                homeViewPager.setCurrentItem(2, false);
//                break;
//            case R.id.tv_group:
//                flag = 4;
//                changeState(flag);
//                homeViewPager.setCurrentItem(3, false);
//                break;
            case R.id.btn_fabu:
                fabuPop = new FabuPop(getActivity());
                fabuPop.onShow(view);
                break;
        }
    }
//    private void changeState(int flag) {
//        switch (flag) {
//            case 1:
//                tvTuijian.setTextColor(Color.parseColor("#F7B016"));
//                tvAttention.setTextColor(Color.parseColor("#FFFFFF"));
//                tvNow.setTextColor(Color.parseColor("#FFFFFF"));
//                tvGroup.setTextColor(Color.parseColor("#FFFFFF"));
//                break;
//            case 2:
//                tvTuijian.setTextColor(Color.parseColor("#FFFFFF"));
//                tvAttention.setTextColor(Color.parseColor("#F7B016"));
//                tvNow.setTextColor(Color.parseColor("#FFFFFF"));
//                tvGroup.setTextColor(Color.parseColor("#FFFFFF"));
//                break;
//            case 3:
//                tvTuijian.setTextColor(Color.parseColor("#FFFFFF"));
//                tvAttention.setTextColor(Color.parseColor("#FFFFFF"));
//                tvNow.setTextColor(Color.parseColor("#F7B016"));
//                tvGroup.setTextColor(Color.parseColor("#FFFFFF"));
//                break;
//            case 4:
//                tvTuijian.setTextColor(Color.parseColor("#FFFFFF"));
//                tvAttention.setTextColor(Color.parseColor("#FFFFFF"));
//                tvNow.setTextColor(Color.parseColor("#FFFFFF"));
//                tvGroup.setTextColor(Color.parseColor("#F7B016"));
//                break;
//        }
//    }


}
