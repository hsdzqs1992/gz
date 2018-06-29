package com.zhuye.machine.engineer.activity.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.adapter.AllTribeAdapter;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.entity.AllTribe;
import com.zhuye.machine.engineer.http.GetData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllTribeActivity extends BaseActivity {

    @BindView(R.id.iv_all_tribe_back)
    ImageView ivAllTribeBack;
    @BindView(R.id.recycler_all_tribe)
    RecyclerView recyclerAllTribe;
    @BindView(R.id.refresh_all_tribe)
    SmartRefreshLayout refreshAllTribe;
    private int page = 0;
    private List<AllTribe.AllData> all_tribe_list = new ArrayList<>();
    private List<AllTribe.AllData> all_tribe_list_all = new ArrayList<>();
    private AllTribeAdapter allTribeAdapter;

    @Override
    protected int getResId() {
        return R.layout.activity_all_tribe;
    }

    @Override
    protected void initData() {
        super.initData();
        recyclerAllTribe.setLayoutManager(new LinearLayoutManager(AllTribeActivity.this, LinearLayoutManager.VERTICAL, false));
        GetData.allTribeList(page, AllTribeActivity.this, Contans.Tribe_All);
        allTribeAdapter = new AllTribeAdapter(R.layout.layout_all_tribe_item, all_tribe_list_all);
        recyclerAllTribe.setAdapter(allTribeAdapter);
    }

    @Override
    protected void initListener() {
        super.initListener();
        refreshAllTribe.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                all_tribe_list_all.clear();
                page = 1;
                GetData.allTribeList(page, AllTribeActivity.this, Contans.Tribe_All);
                refreshlayout.finishRefresh();

            }
        });
        refreshAllTribe.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                GetData.allTribeList(page, AllTribeActivity.this, Contans.Tribe_All);
                refreshlayout.finishLoadmore();
            }
        });
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        AllTribe allTribe = (AllTribe) o;
        all_tribe_list = allTribe.getData();
        if (all_tribe_list!= null){
            all_tribe_list_all.addAll(all_tribe_list);
        }
        allTribeAdapter = new AllTribeAdapter(R.layout.layout_all_tribe_item, all_tribe_list_all);
        allTribeAdapter.setEmptyView(R.layout.layout_calendar_view, recyclerAllTribe);
        recyclerAllTribe.setAdapter(allTribeAdapter);
        allTribeAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_all_tribe_back)
    public void onViewClicked() {
        finish();
    }
}
