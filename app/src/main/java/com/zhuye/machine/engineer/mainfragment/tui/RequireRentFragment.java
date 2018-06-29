package com.zhuye.machine.engineer.mainfragment.tui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.adapter.IndexAdapter;
import com.zhuye.machine.engineer.base.BaseFragment;
import com.zhuye.machine.engineer.entity.Index;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐 求职
 * A simple {@link Fragment} subclass.
 */
public class RequireRentFragment extends BaseFragment {
    private String lat = "34.7568711";
    private String lng = "113.663221";
    private String city_name = "郑州";
    private String city_id = "410101";
    private String token = "";
    private int page = 0;
    private SharedPreferencesUtil sharedPreferencesUtil;
    private List<Index.DataIndex> daiban_list = new ArrayList<>();
    private List<Index.DataIndex> all_daiban_list = new ArrayList<>();
    private IndexAdapter indexAdapter;

    public RequireRentFragment() {
        // Required empty public constructor
    }

    
    @Override
    protected void initView() {

    }

    @Override
    protected int getResId() {
        return R.layout.fragment_require_rent;
    }

}
