package com.zhuye.machine.engineer.activity.mine;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.activity.mine.adapter.TabAdapter;
import com.zhuye.machine.engineer.activity.mine.fragment.MouthCommentFragment;
import com.zhuye.machine.engineer.activity.mine.fragment.PersonDongFragment;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.homefragment.GroupFragment;
import com.zhuye.machine.engineer.homefragment.NowFragment;
import com.zhuye.machine.engineer.widget.TuiTabAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人主页
 */
public class PersonCenterActivity extends BaseActivity {

    @BindView(R.id.iv_person_center)
    ImageView ivPersonCenter;
    @BindView(R.id.iv_user_pic)
    ImageView ivUserPic;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_edt_info)
    TextView tvEdtInfo;
    @BindView(R.id.iv_sex)
    ImageView ivSex;
    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.iv_identity)
    ImageView ivIdentity;
    @BindView(R.id.tv_user_address)
    TextView tvUserAddress;
    @BindView(R.id.tv_user_say)
    TextView tvUserSay;
    @BindView(R.id.tv_attention)
    TextView tvAttention;
    @BindView(R.id.layout_attention)
    LinearLayout layoutAttention;
    @BindView(R.id.tv_fans)
    TextView tvFans;
    @BindView(R.id.layout_fan)
    LinearLayout layoutFan;
    @BindView(R.id.person_tab_layout)
    TabLayout personTabLayout;
    @BindView(R.id.person_view_pager)
    ViewPager personViewPager;
    private String[] strs = new String[]{"个人动态", "口碑评价"};
    private List<Fragment> lists = new ArrayList<>();

    @Override
    protected int getResId() {
        return R.layout.activity_person_center;
    }

    @Override
    protected void initView() {
        super.initView();
        lists.add(new PersonDongFragment());//个人动态
        lists.add(new MouthCommentFragment());//口碑评价
        personViewPager.setAdapter(new TabAdapter(getSupportFragmentManager(), lists, strs));
        personTabLayout.setupWithViewPager(personViewPager);
    }

    @OnClick({R.id.iv_person_center, R.id.tv_edt_info, R.id.layout_attention, R.id.layout_fan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_person_center:
                finish();
                break;
            case R.id.tv_edt_info://编辑
                break;
            case R.id.layout_attention://关注
                break;
            case R.id.layout_fan://粉丝
                break;
        }
    }
}
