package com.zhuye.machine.engineer.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * 首页 底部导航的适配器
 * Created by ${lcc} on 2017/12/4.
 */

public class FragmentsAdapter extends FragmentPagerAdapter {
    private List<Fragment> lst_fragment;
    public FragmentsAdapter(FragmentManager fm, List<Fragment> lists ) {
        super(fm);
        this.lst_fragment = lists;
    }

    @Override
    public Fragment getItem(int position) {
        return lst_fragment.get(position);
    }

    @Override
    public int getCount() {
        return lst_fragment.size();
    }

//    @Override
//    public int getItemPosition(Object object) {
//        return -1;
//    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
