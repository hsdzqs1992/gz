package com.zhuye.machine.engineer.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.entity.SixTopic;
import com.zhuye.machine.engineer.entity.TopicUse;

import java.util.List;

/**
 * Created by Administrator on 2018\6\2 0002.
 */

public class SixTopicAdapter extends BaseQuickAdapter<SixTopic, BaseViewHolder> {
    public SixTopicAdapter(int layoutResId, @Nullable List<SixTopic> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SixTopic item) {

//        helper.setText(R.id.tv_use_count,item.getCount());
//        helper.setText(R.id.tv_use_topic_name,item.getTopic_name());
    }
}
