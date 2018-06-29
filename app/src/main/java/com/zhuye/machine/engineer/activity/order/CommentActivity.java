package com.zhuye.machine.engineer.activity.order;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 评价
 */
public class CommentActivity extends BaseActivity {


    @BindView(R.id.iv_comment_back)
    ImageView ivCommentBack;
    @BindView(R.id.comment)
    RelativeLayout comment;
    @BindView(R.id.iv_user_pic)
    ImageView ivUserPic;
    @BindView(R.id.rating_fen)
    RatingBar ratingFen;
    @BindView(R.id.tv_comment_status)
    TextView tvCommentStatus;
    @BindView(R.id.edt_comment_content)
    EditText edtCommentContent;
    @BindView(R.id.layout_comment_pics)
    LinearLayout layoutCommentPics;
    @BindView(R.id.iv_add_comment_pic)
    ImageView ivAddCommentPic;
    @BindView(R.id.btn_comment)
    Button btnComment;

    @Override
    protected int getResId() {
        return R.layout.activity_comment;
    }


    @OnClick({R.id.iv_comment_back, R.id.iv_add_comment_pic, R.id.btn_comment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_comment_back:
                finish();
                break;
            case R.id.iv_add_comment_pic://添加图片
                break;
            case R.id.btn_comment://发布评论
                break;
        }
    }
}
