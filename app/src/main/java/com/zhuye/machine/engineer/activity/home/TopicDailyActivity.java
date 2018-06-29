package com.zhuye.machine.engineer.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.adapter.SixTopicAdapter;
import com.zhuye.machine.engineer.base.Base;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.entity.SixTopic;
import com.zhuye.machine.engineer.entity.Topic;
import com.zhuye.machine.engineer.http.GetData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 每日话题
 */
public class TopicDailyActivity extends BaseActivity {


    @BindView(R.id.iv_topic_back)
    ImageView ivTopicBack;
    @BindView(R.id.tv_fa)
    TextView tvFa;
    @BindView(R.id.recycler_view_tui)
    RecyclerView recyclerViewTui;
    @BindView(R.id.recycler_topic)
    RecyclerView recyclerTopic;
    @BindView(R.id.refresh_topic)
    SmartRefreshLayout refreshTopic;
    private Intent intent;
    private SixTopicAdapter sixTopicAdapter;
    private List<SixTopic> list = new ArrayList<>();
    private List<SixTopic> all_list = new ArrayList<>();
    private int page = 0;

    @Override
    protected int getResId() {
        return R.layout.activity_topic_daily;
    }

    @Override
    protected void initData() {
        super.initData();
        GetData.topicList(page, TopicDailyActivity.this, Contans.Topic_List);
    }

    @Override
    protected void initView() {
        super.initView();
//        SixTopic sixTopic = new SixTopic();
//        sixTopic.setCount("12");
//        sixTopic.setTopic_name("#养花#  喜欢一朵花会把他摘下，而一朵花则会。。。");
//        list.add(sixTopic);
        recyclerViewTui.setLayoutManager(new GridLayoutManager(this, 2));
        sixTopicAdapter = new SixTopicAdapter(R.layout.layout_six_topic, list);
        recyclerViewTui.setAdapter(sixTopicAdapter);
        sixTopicAdapter.notifyDataSetChanged();
        sixTopicAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Go(TopicDetailActivity.class, false);
            }
        });
    }

    @OnClick({R.id.iv_topic_back, R.id.tv_fa})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_topic_back:
                finish();
                break;
            case R.id.tv_fa://发布话题
                intent = new Intent(TopicDailyActivity.this, EditDongActivity.class);
                intent.putExtra("flag", 2);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case Contans.Topic_List:
                Topic topic = (Topic) o;
                list = topic.getData().getList();
                break;
        }
    }

}
