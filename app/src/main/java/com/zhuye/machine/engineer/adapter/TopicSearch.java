package com.zhuye.machine.engineer.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.machine.engineer.entity.SixTopic;

import java.util.List;

/**
 * Created by lcc2018 on 2018/6/13.
 */

public class TopicSearch extends BaseQuickAdapter<SixTopic, BaseViewHolder> {
    public TopicSearch(int layoutResId, @Nullable List<SixTopic> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SixTopic item) {

    }
}
