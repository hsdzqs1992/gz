package com.zhuye.machine.engineer.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.adapter.TopicUseAdapter;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.entity.TopicUse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopicDetailActivity extends BaseActivity {


    @BindView(R.id.iv_topic_use_back)
    ImageView ivTopicUseBack;
    @BindView(R.id.iv_topic_pic)
    ImageView ivTopicPic;
    @BindView(R.id.tv_topic_name)
    TextView tvTopicName;
    @BindView(R.id.tv_topic_num)
    TextView tvTopicNum;
    @BindView(R.id.tv_topic_content)
    TextView tvTopicContent;
    @BindView(R.id.recycler_topic_use)
    RecyclerView recyclerTopicUse;
    @BindView(R.id.refresh_topic_use)
    SmartRefreshLayout refreshTopicUse;
    @BindView(R.id.btn_topic)
    Button btnTopic;
    private Intent intent;
    private String topic_id = "";
    private TopicUseAdapter topicUseAdapter;
    private List<TopicUse> topic_list = new ArrayList<>();

    @Override
    protected int getResId() {
        return R.layout.activity_topic_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        TopicUse topicUse = new TopicUse();
        topicUse.setCommentcount("12");
        topicUse.setNickname("小李");
        topicUse.setViewcount("23");
        topicUse.setTime("2018-6-1");
        topic_list.add(topicUse);
        recyclerTopicUse.setLayoutManager(new LinearLayoutManager(TopicDetailActivity.this, LinearLayoutManager.VERTICAL, false));

        topicUseAdapter = new TopicUseAdapter(R.layout.topic_use_item, topic_list);
        recyclerTopicUse.setAdapter(topicUseAdapter);
        topicUseAdapter.notifyDataSetChanged();

    }

    @OnClick({R.id.iv_topic_use_back, R.id.btn_topic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_topic_use_back:
                finish();
                break;
            case R.id.btn_topic://编辑话题
                intent = new Intent(TopicDetailActivity.this, EditDongActivity.class);
                intent.putExtra("flag", 3);
                intent.putExtra("topic_id", topic_id);
                startActivity(intent);
                break;
        }
    }
}
