package com.zhuye.machine.engineer.mainfragment.tui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.adapter.IndexAdapter;
import com.zhuye.machine.engineer.base.Base;
import com.zhuye.machine.engineer.base.BaseFragment;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.entity.Index;
import com.zhuye.machine.engineer.http.GetData;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 推荐  招聘
 * A simple {@link Fragment} subclass.
 */
public class AdvertisekFragment extends BaseFragment {


    @BindView(R.id.recycler_advertise)
    RecyclerView recyclerAdvertise;
    @BindView(R.id.smartRefresh_advertise)
    SmartRefreshLayout smartRefreshAdvertise;
    Unbinder unbinder;
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

    public AdvertisekFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initView() {
//1 动态 2 代班 3 求职  4招聘 5 出租  6求租
    }

    @Override
    protected void initData() {
        super.initData();
        recyclerAdvertise.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        indexAdapter = new IndexAdapter(R.layout.layout_index_item, all_daiban_list, 4);
        recyclerAdvertise.setAdapter(indexAdapter);//1 动态 2 代班 3 求职  4招聘 5 出租  6求租
        indexAdapter.setEmptyView(R.layout.layout_empty,recyclerAdvertise);
        GetData.index(page, lat, lng, "4", city_id, AdvertisekFragment.this, Contans.Index_Advertise);
    }

    @Override
    protected void initListener() {
        super.initListener();
        indexAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {//列表点击事件
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {//招聘详情

            }
        });

        indexAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {//列表中的按钮点击事件
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.layout_zan) {//点赞

                } else if (view.getId() == R.id.layout_comment) {//评论

                } else {

                }
            }
        });
        smartRefreshAdvertise.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                GetData.index(page, lat, lng, "4", city_id, AdvertisekFragment.this, Contans.Index_Advertise);
                smartRefreshAdvertise.finishRefresh();
            }
        });
        smartRefreshAdvertise.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                GetData.index(page, lat, lng, "4", city_id, AdvertisekFragment.this, Contans.Index_Advertise);
                smartRefreshAdvertise.finishLoadmore();
            }
        });

    }

    @Override
    protected int getResId() {
        return R.layout.fragment_advertisek;
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case Contans.Index_Advertise:
                Index index = (Index) o;
                daiban_list = index.getDataIndex();
                all_daiban_list.addAll(daiban_list);
                indexAdapter = new IndexAdapter(R.layout.layout_index_item, all_daiban_list, 0);
                recyclerAdvertise.setAdapter(indexAdapter);
                indexAdapter.notifyDataSetChanged();
                break;
        }
    }

}
