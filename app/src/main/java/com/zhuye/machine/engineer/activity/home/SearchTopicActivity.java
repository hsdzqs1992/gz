package com.zhuye.machine.engineer.activity.home;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.adapter.TopicSearch;
import com.zhuye.machine.engineer.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 检索 新增话题
 */
public class SearchTopicActivity extends BaseActivity {


    @BindView(R.id.edt_topic)
    EditText edtTopic;
    @BindView(R.id.tv_topic_cancel)
    TextView tvTopicCancel;
    @BindView(R.id.tv_topic_hot)
    TextView tvTopicHot;
    @BindView(R.id.recycler_topic_result)
    RelativeLayout recyclerTopicResult;
    @BindView(R.id.refersh_search_topic)
    SmartRefreshLayout refershSearchTopic;
    private TopicSearch topicSearch;

    @Override
    protected int getResId() {
        return R.layout.activity_search_topic;
    }

    @OnClick(R.id.tv_topic_cancel)
    public void onViewClicked() {
        edtTopic.setText("");
        finish();
    }
}
