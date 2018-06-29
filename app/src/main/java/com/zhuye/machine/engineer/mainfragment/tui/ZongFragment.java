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
 * 推荐 综合
 * A simple {@link Fragment} subclass.
 */
public class ZongFragment extends BaseFragment {

    @BindView(R.id.recycler_zong)
    RecyclerView recyclerZong;
    @BindView(R.id.smartRefresh_zong)
    SmartRefreshLayout smartRefreshZong;
    Unbinder unbinder;
    private String lat = "34.7568711";
    private String lng = "113.663221";
    private String city_name = "郑州";
    private String city_id = "410101";
    private String token = "";
    private int page = 0;
    private SharedPreferencesUtil sharedPreferencesUtil;
    private List<Index.DataIndex> zong_list = new ArrayList<>();
    private List<Index.DataIndex> all_zong_list = new ArrayList<>();
    private IndexAdapter indexAdapter;

    public ZongFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView() {

    }

    @Override
    protected int getResId() {
        return R.layout.fragment_zong;
    }

    @Override
    protected void initData() {
        super.initData();
        recyclerZong.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        indexAdapter = new IndexAdapter(R.layout.layout_index_item, all_zong_list,0);
        indexAdapter.setEmptyView(R.layout.layout_empty,recyclerZong);
        recyclerZong.setAdapter(indexAdapter);

        GetData.index(page, lat, lng, "", city_id, ZongFragment.this, Contans.Index_Zong);
    }

    @Override
    protected void initListener() {
        super.initListener();

        indexAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {//列表点击事件
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {//详情
                //详情
                int type = all_zong_list.get(position).getType(); //1 动态 2 代班 3 求职  4招聘 5 出租  6求租
                if (type == 1) {//动态

                } else if (type == 2) {//代班

                } else if (type == 3) {//求职

                } else if (type == 4) {//招聘

                } else if (type == 5) {//出租

                } else if (type == 6) {//求租

                }
            }
        });

        indexAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {//列表中的按钮点击事件
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.layout_zan){//点赞

                }else if (view.getId() == R.id.layout_comment){//评论

                }else{

                }
            }
        });
        smartRefreshZong.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                GetData.index(page, lat, lng, "", city_id, ZongFragment.this, Contans.Index_Zong);
                smartRefreshZong.finishRefresh();
            }
        });
        smartRefreshZong.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                GetData.index(page, lat, lng, "", city_id, ZongFragment.this, Contans.Index_Zong);
                smartRefreshZong.finishLoadmore();
            }
        });
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case Contans.Index_Zong:
                Index index = (Index) o;
                zong_list = index.getDataIndex();
                all_zong_list.addAll(zong_list);
                indexAdapter = new IndexAdapter(R.layout.layout_index_item, all_zong_list,0);
                recyclerZong.setAdapter(indexAdapter);
                indexAdapter.notifyDataSetChanged();
                break;
        }
    }

}
