package com.zhuye.machine.engineer.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.machine.engineer.entity.AllTribe;

import java.util.List;

/**
 * 部落详情的列表
 * Created by lcc2018 on 2018/6/28.
 */

public class TribeDetailAdapter  extends BaseQuickAdapter<AllTribe.AllData, BaseViewHolder> {
    public TribeDetailAdapter(int layoutResId, @Nullable List<AllTribe.AllData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AllTribe.AllData item) {

    }
}
