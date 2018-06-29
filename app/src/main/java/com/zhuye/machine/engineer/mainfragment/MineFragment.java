package com.zhuye.machine.engineer.mainfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.activity.mine.IdentityVertifyActivity;
import com.zhuye.machine.engineer.activity.mine.MessageActivity;
import com.zhuye.machine.engineer.activity.mine.MyRestMoneyActivity;
import com.zhuye.machine.engineer.activity.mine.PersonCenterActivity;
import com.zhuye.machine.engineer.activity.mine.SettingActivity;
import com.zhuye.machine.engineer.base.Base;
import com.zhuye.machine.engineer.base.BaseFragment;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.contants.NetWorkUrl;
import com.zhuye.machine.engineer.entity.User;
import com.zhuye.machine.engineer.http.GetData;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;
import com.zhuye.machine.engineer.widget.CircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 个人中心
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {


    @BindView(R.id.iv_user_pic)
    ImageView ivUserPic;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.iv_sex)
    ImageView ivSex;
    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.iv_identity)
    ImageView ivIdentity;
    @BindView(R.id.tv_user_address)
    TextView tvUserAddress;
    @BindView(R.id.iv_msg)
    ImageView ivMsg;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.btn_identity)
    Button btnIdentity;
    @BindView(R.id.btn_user_home)
    Button btnUserHome;
    @BindView(R.id.tv_dong_count)
    TextView tvDongCount;
    @BindView(R.id.layout_dong)
    LinearLayout layoutDong;
    @BindView(R.id.tv_attention)
    TextView tvAttention;
    @BindView(R.id.layout_attention)
    LinearLayout layoutAttention;
    @BindView(R.id.tv_fans)
    TextView tvFans;
    @BindView(R.id.layout_fan)
    LinearLayout layoutFan;
    @BindView(R.id.iv_jifen)
    ImageView ivJifen;
    @BindView(R.id.iv_account)
    ImageView ivAccount;
    @BindView(R.id.iv_daiban)
    ImageView ivDaiban;
    @BindView(R.id.iv_comment)
    ImageView ivComment;
    @BindView(R.id.iv_she_info)
    ImageView ivSheInfo;
    @BindView(R.id.iv_collection)
    ImageView ivCollection;
    @BindView(R.id.iv_address)
    ImageView ivAddress;
    @BindView(R.id.iv_print)
    ImageView ivPrint;
    Unbinder unbinder;
    @BindView(R.id.tv_cheng)
    TextView tvCheng;
    Unbinder unbinder1;
    private Intent intent;
    private SharedPreferencesUtil sharedPreferencesUtil;
    private String token = "";
    private int chengyijin = 0;//诚意金金额
    private int yue = 0;//余额
    private int jifen = 0;
    private int sex = 0;
    private int is_shi = 0;//实名认证
    private int is_chengyi = 0;//是否缴纳诚意金

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView() {
        sharedPreferencesUtil = new SharedPreferencesUtil(getActivity(), "user");
        token = sharedPreferencesUtil.getValue("token", "");
        GetData.userCenter(token, MineFragment.this, Contans.User_Info);
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_mine;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_user_pic, R.id.iv_msg, R.id.iv_setting, R.id.btn_identity, R.id.btn_user_home, R.id.layout_dong, R.id.layout_attention, R.id.layout_fan, R.id.iv_jifen, R.id.iv_account, R.id.iv_daiban, R.id.iv_comment, R.id.iv_she_info, R.id.iv_collection, R.id.iv_address, R.id.iv_print})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_user_pic:
                break;
            case R.id.iv_msg://消息
                intent = new Intent(getActivity(), MessageActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_setting://设置
                intent = new Intent(getActivity(), SettingActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.btn_identity://实名认证
                intent = new Intent(getActivity(), IdentityVertifyActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.btn_user_home://个人主页
                intent = new Intent(getActivity(), PersonCenterActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.layout_dong://动态
                break;
            case R.id.layout_attention://关注
                break;
            case R.id.layout_fan://粉丝

                break;
            case R.id.iv_jifen://积分
                toast("123");
                break;
            case R.id.iv_account://我的余额
                intent = new Intent(getActivity(), MyRestMoneyActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_daiban://我的代班
                break;
            case R.id.iv_comment://待评论
                break;
            case R.id.iv_she_info://设备信息
                break;
            case R.id.iv_collection://我的收藏
                break;
            case R.id.iv_address://地址
                break;
            case R.id.iv_print://我的足迹
                break;
        }
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
//        "sex": "0",  性别  0保密 1 男 2女
//        是否绑定电话 就是手机注册的...
//        "is_shi": "0",  是否实名
//        "is_chengyi": "0"  是否交诚意金   不显示余额
        User user = (User) o;
        chengyijin = user.getData().getChengyi_price();
        yue = user.getData().getUser_money();
        jifen = user.getData().getIntegral();
        sex = user.getData().getSex();
        is_shi = user.getData().getIs_shi();
        is_chengyi = user.getData().getIs_chengyi();
        sharedPreferencesUtil.putValue("chengyijin", chengyijin);
        sharedPreferencesUtil.putValue("yue", yue);
        sharedPreferencesUtil.putValue("jifen", jifen);
        tvAttention.setText(user.getData().getAttention_count()+"");
        tvDongCount.setText(user.getData().getDynamic_count()+"");
        tvFans.setText(user.getData().getBe_focused_count()+"");
        tvUserAddress.setText(user.getData().getCity());
        tvUserName.setText(user.getData().getUsename());
        Picasso.with(getActivity())
                .load(NetWorkUrl.Pic_Url_Append + user.getData().getFace())
                .transform(new CircleTransform())
                .placeholder(R.drawable.ic_defult) //设占位图
                .into(ivUserPic);//头像
        if (sex == 0) {
            ivSex.setVisibility(View.GONE);
        } else if (sex == 1) {
            ivSex.setImageResource(R.drawable.ic_boy_write);
        }
        if (is_shi == 0) {
            ivIdentity.setVisibility(View.GONE);
        } else {
            ivIdentity.setImageResource(R.drawable.ic_identity);
        }
        if (is_chengyi == 0) {
            tvCheng.setVisibility(View.GONE);
        } else {
            tvCheng.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void error(Object o) {
        super.error(o);
        Base bs = (Base) o;
        toast(bs.getMessage());
    }

}
