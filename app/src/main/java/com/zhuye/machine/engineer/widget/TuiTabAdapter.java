package com.zhuye.machine.engineer.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018\5\31 0031.
 */

public class TuiTabAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragment;
    private String[] strs;
    public TuiTabAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] str) {
        super(fm);
        this.listFragment = fragmentList;
        this.strs = str;
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
        return strs[position];
    }
}
