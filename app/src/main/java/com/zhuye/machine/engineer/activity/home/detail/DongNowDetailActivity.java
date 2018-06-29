package com.zhuye.machine.engineer.activity.home.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 此刻 动态详情
 */
public class DongNowDetailActivity extends BaseActivity {

    @BindView(R.id.iv_now_detail_back)
    ImageView ivNowDetailBack;
    @BindView(R.id.iv_now_detail_share)
    ImageView ivNowDetailShare;
    @BindView(R.id.layout_title_now)
    RelativeLayout layoutTitleNow;
    @BindView(R.id.iv_index_pic)
    ImageView ivIndexPic;
    @BindView(R.id.tv_tv_now_detail_username)
    TextView tvTvNowDetailUsername;
    @BindView(R.id.iv_now_detail_sex)
    ImageView ivNowDetailSex;
    @BindView(R.id.iv_now_detail_bind_tel)
    ImageView ivNowDetailBindTel;
    @BindView(R.id.iv_now_detail_identity)
    ImageView ivNowDetailIdentity;
    @BindView(R.id.tv_now_detail_cheng)
    TextView tvNowDetailCheng;
    @BindView(R.id.tv_now_detail_time)
    TextView tvNowDetailTime;
    @BindView(R.id.tv_now_detail_city)
    TextView tvNowDetailCity;
    @BindView(R.id.btn_now_detail_attention)
    Button btnNowDetailAttention;
    @BindView(R.id.tv_now_detail_content)
    TextView tvNowDetailContent;
    @BindView(R.id.iv_now_detail_pic)
    ImageView ivNowDetailPic;
    @BindView(R.id.ic_now_detail_collection)
    ImageView icNowDetailCollection;
    @BindView(R.id.layout_collection)
    LinearLayout layoutCollection;

    @Override
    protected int getResId() {
        return R.layout.activity_dong_now_detail;
    }


    @OnClick({R.id.iv_now_detail_back, R.id.iv_now_detail_share, R.id.btn_now_detail_attention, R.id.layout_collection})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_now_detail_back:
                finish();
                break;
            case R.id.iv_now_detail_share://分享
                break;
            case R.id.btn_now_detail_attention://关注
                break;
            case R.id.layout_collection://收藏
                break;
        }
    }
}
