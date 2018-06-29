package com.zhuye.machine.engineer.activity.mine.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/1/10.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragment;
    private String[] str;
    public TabAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] str) {
        super(fm);
        this.listFragment = fragmentList;
        this.str = str;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
