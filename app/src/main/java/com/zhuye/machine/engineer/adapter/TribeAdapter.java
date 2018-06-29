package com.zhuye.machine.engineer.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.contants.NetWorkUrl;
import com.zhuye.machine.engineer.entity.SixTopic;
import com.zhuye.machine.engineer.entity.Tribe;
import com.zhuye.machine.engineer.widget.CropSquareTransformation;

import java.util.List;

/**
 * 部落  推荐与我加入的部落
 * Created by lcc2018 on 2018/6/28.
 */

public class TribeAdapter extends BaseQuickAdapter<Tribe.Data, BaseViewHolder> {
    public TribeAdapter(int layoutResId, @Nullable List<Tribe.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Tribe.Data item) {

        helper.setText(R.id.tv_tribe_name, item.getName());
        Picasso.with(mContext).load(NetWorkUrl.SERVER_LOCATION + item.getImg_path())
                .transform(new CropSquareTransformation())
                .placeholder(R.drawable.ic_defult) //设占位图
                .into((ImageView) helper.getView(R.id.iv_tribe_pic));
    }
}
