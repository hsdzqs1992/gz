package com.zhuye.machine.engineer.activity.mine;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.activity.mine.adapter.TabAdapter;
import com.zhuye.machine.engineer.activity.mine.fragment.msg.ComZanFragment;
import com.zhuye.machine.engineer.activity.mine.fragment.msg.FansFragment;
import com.zhuye.machine.engineer.activity.mine.fragment.msg.NotificationFragment;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.widget.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 消息
 */
public class MessageActivity extends BaseActivity {

    @BindView(R.id.msg_tab_layout)
    TabLayout msgTabLayout;
    @BindView(R.id.msg_view_pager)
    ViewPager msgViewPager;
    private String[] str = new String[]{"通知", "粉丝", "评论和赞"};
    private List<Fragment> list = new ArrayList<>();
    @Override
    protected void initView() {
        super.initView();
        list.add(new NotificationFragment());//通知
        list.add(new FansFragment());//粉丝
        list.add(new ComZanFragment());//评论和赞
        msgViewPager.setAdapter(new TabAdapter(getSupportFragmentManager(), list, str));
        msgTabLayout.setupWithViewPager(msgViewPager);
    }

    @Override
    protected int getResId() {
        return R.layout.activity_message;
    }
}
