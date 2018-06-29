package com.zhuye.machine.engineer.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.contants.NetWorkUrl;
import com.zhuye.machine.engineer.entity.Index;
import com.zhuye.machine.engineer.entity.TopicUse;
import com.zhuye.machine.engineer.widget.CircleTransform;

import java.util.List;

/**
 * Created by lcc2018 on 2018/6/21.
 */

public class IndexAdapter extends BaseQuickAdapter<Index.DataIndex, BaseViewHolder> {
    private int is_shi;
    private int sex;
    private int is_chengyi;
    private int flag = 0;

    public IndexAdapter(int layoutResId, @Nullable List<Index.DataIndex> data, int flag) {
        super(layoutResId, data);
        this.flag = flag;
    }

    @Override
    protected void convert(BaseViewHolder helper, Index.DataIndex item) {
        Picasso.with(mContext).load(NetWorkUrl.Pic_Url_Append + item.getFace())
                .transform(new CircleTransform())
                .placeholder(R.drawable.ic_defult) //设占位图
                .into((ImageView) helper.getView(R.id.iv_index_pic));

        helper.setText(R.id.tv_index_username, item.getNickname());
        helper.setText(R.id.tv_index_price, item.getPrice());
        helper.setText(R.id.tv_index_juli, item.getJuli() + "");
        //        "sex": "0",  性别  0保密 1 男 2女
//        是否绑定电话 就是手机注册的...
//        "is_shi": "0",  是否实名
//        "is_chengyi": "0"  是否交诚意金   不显示余额
        is_chengyi = item.getIs_chengyi();
        sex = item.getSex();
        is_shi = item.getIs_shi();
        if (sex == 1) {
            helper.getView(R.id.iv_index_sex).setBackgroundResource(R.drawable.ic_boy);
        } else if (sex == 0) {
            helper.getView(R.id.iv_index_sex).setVisibility(View.GONE);
        } else {

        }
        if (is_chengyi == 0) {
            helper.getView(R.id.tv_index_cheng).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.tv_index_cheng).setVisibility(View.VISIBLE);
        }
        if (is_shi == 0) {
            helper.getView(R.id.iv_index_identity).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.iv_index_identity).setVisibility(View.VISIBLE);
        }
        int type = item.getType();
        //1 动态 2 代班 3 求职  4招聘 5 出租  6求租
        if (flag == 0) {
            if (type == 1) {
                helper.setText(R.id.tv_index_type, "动态");
            } else if (type == 2) {
                helper.setText(R.id.tv_index_type, "代班");
            } else if (type == 3) {
                helper.setText(R.id.tv_index_type, "求职");
            } else if (type == 4) {
                helper.setText(R.id.tv_index_type, "招聘");
            } else if (type == 5) {
                helper.setText(R.id.tv_index_type, "出租");
            } else if (type == 6) {
                helper.setText(R.id.tv_index_type, "求租");
            }
        } else if (flag == 2) {
            helper.setText(R.id.tv_index_type, "代班");
        } else if (flag == 3) {
            helper.setText(R.id.tv_index_type, "求职");
        } else if (flag == 4) {
            helper.setText(R.id.tv_index_type, "招聘");
        } else if (flag == 5) {
            helper.setText(R.id.tv_index_type, "出租");
        }
        helper.setText(R.id.tv_index_content, item.getTitle());
        helper.setText(R.id.tv_index_zan, item.getZan());
        helper.setText(R.id.tv_index_comment, item.getCommentCont());
        helper.setText(R.id.tv_index_view, item.getShow_count());
        helper.addOnClickListener(R.id.layout_zan);
        helper.addOnClickListener(R.id.layout_comment);
        helper.addOnClickListener(R.id.iv_index_pic);

    }
}
