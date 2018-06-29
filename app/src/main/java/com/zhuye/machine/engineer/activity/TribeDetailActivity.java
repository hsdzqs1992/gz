package com.zhuye.machine.engineer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.adapter.TribeDetailAdapter;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.entity.Code;
import com.zhuye.machine.engineer.http.GetData;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 部落详情
 */
public class TribeDetailActivity extends BaseActivity {


    @BindView(R.id.iv_tribe_detail_back)
    ImageView ivTribeDetailBack;
    @BindView(R.id.tv_tribe_detail_title)
    TextView tvTribeDetailTitle;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.ic_tribe_pic)
    ImageView icTribePic;
    @BindView(R.id.iv_tribe_detail_pic)
    ImageView ivTribeDetailPic;
    @BindView(R.id.tv_tribe_detail_name)
    TextView tvTribeDetailName;
    @BindView(R.id.tv_tribe_detail_count)
    TextView tvTribeDetailCount;
    @BindView(R.id.btn_add_tribe)
    Button btnAddTribe;
    @BindView(R.id.recycler_tribe_detail)
    RecyclerView recyclerTribeDetail;
    @BindView(R.id.refresh_tribe_detail)
    SmartRefreshLayout refreshTribeDetail;
    private Intent intent;
    private SharedPreferencesUtil sharedPreferencesUtil;
    private String token = "";
    private String tribe_id = "";
    private String tribe_name = "";
    private int page = 0;
    private String lat = "34.7568711";
    private String lng = "113.663221";
    private String city_name = "郑州";
    private String city_id = "41388";
    private TribeDetailAdapter tribeDetailAdapter;
    @Override
    protected void initData() {
        super.initData();
        sharedPreferencesUtil = new SharedPreferencesUtil(TribeDetailActivity.this, "user");
        token = sharedPreferencesUtil.getValue("token", "");
        tribe_id = getIntent().getStringExtra("tribe_id");
        tribe_name = getIntent().getStringExtra("tribe_name");
        tvTribeDetailTitle.setText("部落 - " + tribe_name);
        GetData.tribeDetail(tribe_id,token,page,lat,lng,city_id,TribeDetailActivity.this, Contans.Tribe_Detail);
//        tribeDetailAdapter = new TribeDetailAdapter(R.layout.layout_tribe_detail_item,)
    }

    @Override
    protected int getResId() {
        return R.layout.activity_tribe_detail;
    }

    @OnClick({R.id.iv_tribe_detail_back, R.id.btn_add_tribe})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_tribe_detail_back:
                finish();
                break;
            case R.id.btn_add_tribe://加入部落
                GetData.addTribe(token,tribe_id,TribeDetailActivity.this,Contans.Tribe_Add);
                break;
        }
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode){
            case Contans.Tribe_Detail:

                break;
            case Contans.Tribe_Add:
                Code code = (Code) o;
                toast(code.getMessage());
                break;
        }
    }
}
