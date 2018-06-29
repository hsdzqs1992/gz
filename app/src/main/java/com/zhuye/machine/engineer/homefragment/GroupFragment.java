package com.zhuye.machine.engineer.homefragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.activity.TribeDetailActivity;
import com.zhuye.machine.engineer.activity.home.AllTribeActivity;
import com.zhuye.machine.engineer.adapter.TribeAdapter;
import com.zhuye.machine.engineer.base.BaseFragment;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.entity.Tribe;
import com.zhuye.machine.engineer.http.GetData;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 部落
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends BaseFragment {


    @BindView(R.id.tv_all_tribe)
    TextView tvAllTribe;
    @BindView(R.id.recycler_tui_tribe)
    RecyclerView recyclerTuiTribe;
    @BindView(R.id.recycler_my_tribe)
    RecyclerView recyclerMyTribe;
    private SharedPreferencesUtil spUtil;
    private String token = "";
    private List<Tribe.Data> tui_list = new ArrayList<>();
    private List<Tribe.Data> my_list = new ArrayList<>();

    private TribeAdapter tuiAdapter;
    private TribeAdapter myAdapter;
    private Intent intent;

    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView() {
        spUtil = new SharedPreferencesUtil(getActivity(), "user");
        token = spUtil.getValue("token", "");
        recyclerTuiTribe.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerMyTribe.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        //推荐部落
        GetData.tuiTribeList(GroupFragment.this, Contans.Tribe_Tui);
        //我加入部落
        GetData.myTribeList(token, GroupFragment.this, Contans.Tribe_My);
        tuiAdapter = new TribeAdapter(R.layout.layout_tribe_item, tui_list);
        tuiAdapter.setEmptyView(R.layout.layout_empty, recyclerTuiTribe);
        myAdapter = new TribeAdapter(R.layout.layout_tribe_item, my_list);
        myAdapter.setEmptyView(R.layout.layout_empty, recyclerMyTribe);
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_group;
    }

    @Override
    protected void initListener() {
        super.initListener();

    }

    @OnClick(R.id.tv_all_tribe)
    public void onViewClicked() {
        //全部部落
        Intent intent = new Intent(getActivity(), AllTribeActivity.class);
        startActivity(intent);

    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case Contans.Tribe_Tui:
                Tribe tribe = (Tribe) o;
                tui_list = tribe.getData();
                tuiAdapter = new TribeAdapter(R.layout.layout_tribe_item, tui_list);
                recyclerTuiTribe.setAdapter(tuiAdapter);
                tuiAdapter.notifyDataSetChanged();
                tuiAdapter.setEmptyView(R.layout.layout_empty, recyclerTuiTribe);
                break;
            case Contans.Tribe_My:
                Tribe mytribe = (Tribe) o;
                my_list = mytribe.getData();
                myAdapter = new TribeAdapter(R.layout.layout_tribe_item, my_list);
                recyclerMyTribe.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();
                myAdapter.setEmptyView(R.layout.layout_empty, recyclerMyTribe);
                break;
        }

        //推荐详情
        tuiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String tribe_id = tui_list.get(position).getTribe_id();
                String tribe_name = tui_list.get(position).getName();
                intent = new Intent(getActivity(),TribeDetailActivity.class);
                intent.putExtra("tribe_id",tribe_id);
                intent.putExtra("tribe_name",tribe_name);
                getActivity().startActivity(intent);
            }
        });
        // 我加入的部落详情
        myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String tribe_id = my_list.get(position).getTribe_id();
                String tribe_name = my_list.get(position).getName();
                intent = new Intent(getActivity(),TribeDetailActivity.class);
                intent.putExtra("tribe_id",tribe_id);
                intent.putExtra("tribe_name",tribe_name);
                getActivity().startActivity(intent);

            }
        });
    }
}
