package com.zhuye.machine.engineer.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.entity.TopicUse;

import java.util.List;

/**
 * Created by Administrator on 2018\6\1 0001.
 */

public class TopicUseAdapter extends BaseQuickAdapter<TopicUse, BaseViewHolder> {
    public TopicUseAdapter(int layoutResId, @Nullable List<TopicUse> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TopicUse item) {
        helper.setText(R.id.tv_nick_name,item.getNickname());
        helper.setText(R.id.tv_time,item.getTime());
        helper.setText(R.id.tv_use_content,"一个美丽又可爱的小姑娘");
        helper.setText(R.id.tv_comment,item.getCommentcount());
        helper.setText(R.id.tv_zan,item.getZancount());
        helper.setText(R.id.tv_view,item.getViewcount());

    }
}
