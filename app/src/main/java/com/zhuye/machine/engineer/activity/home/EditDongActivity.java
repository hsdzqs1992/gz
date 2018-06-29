package com.zhuye.machine.engineer.activity.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.entity.Code;
import com.zhuye.machine.engineer.http.GetData;
import com.zhuye.machine.engineer.util.FilesUtil;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

/**
 * 编辑动态
 */
public class EditDongActivity extends BaseActivity {


    @BindView(R.id.iv_dong_back)
    ImageView ivDongBack;
    @BindView(R.id.tv_fa_dong)
    TextView tvFaDong;
    @BindView(R.id.layout_title_dong)
    RelativeLayout layoutTitleDong;
    @BindView(R.id.edt_content_dong)
    EditText edtContentDong;
    @BindView(R.id.iv_dong_pic)
    ImageView ivDongPic;
    @BindView(R.id.tv_add_group)
    TextView tvAddGroup;
    @BindView(R.id.tv_choose_topic)
    TextView tvChooseTopic;
    @BindView(R.id.tv_tile)
    TextView tvTile;
    private Intent intent;
    private int flag = 0;
    private File picFile;
    private String lat = "34.7568711";
    private String lng = "113.663221";
    private String city_name = "郑州市";
    private String token ="";
    private SharedPreferencesUtil sharedPreferencesUtil;
    private  String topic = "";
    private List<File> file_list = new ArrayList<>();


    @Override
    protected int getResId() {
        return R.layout.activity_edit_dong;
    }

    @Override
    protected void initData() {
        super.initData();
        sharedPreferencesUtil = new SharedPreferencesUtil(EditDongActivity.this,"user");
        token = sharedPreferencesUtil.getValue("token","");
        intent = getIntent();
        flag = intent.getIntExtra("flag", 0);
        if (flag == 1) {//动态
            tvTile.setText("编辑动态");
        } else if (flag == 2) {//话题
            tvTile.setText("编辑话题");
        }
    }

    @OnClick({R.id.iv_dong_back, R.id.tv_fa_dong, R.id.iv_dong_pic, R.id.tv_add_group, R.id.tv_choose_topic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_dong_back:
                finish();
                break;
            case R.id.tv_fa_dong://发布
                String content = edtContentDong.getText().toString();
                if (TextUtils.isEmpty(content)) {
                    toast("请填写动态内容");
                    return;
                }
                GetData.faBu(token,lat,lng,"1",city_name,content,topic,"",
                        "","", "","","","",
                        "","","","","","",
                        "","","","","","",
                        "","",file_list,EditDongActivity.this,Contans.Fa_Dong);
                break;
            case R.id.iv_dong_pic://选择图片
                selectzheng();
                break;
            case R.id.tv_add_group://加入部落
                break;
            case R.id.tv_choose_topic://选择话题
                intent = new Intent(EditDongActivity.this, SearchTopicActivity.class);
                startActivityForResult(intent, 1001);
                break;
        }
    }

    private void selectzheng() {
        PhotoPicker.builder()
                .setPhotoCount(1)//可选择图片数量
                .setShowCamera(true)//是否显示拍照按钮
                .setShowGif(false)//是否显示动态图
                .setPreviewEnabled(true)//是否可以预览
                .start(EditDongActivity.this, Contans.Pic_Dong);
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode){
            case Contans.Fa_Dong:
                Code code = (Code) o;
                toast(code.getMessage());
                finish();
                break;
                default:
                    break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {
                if (requestCode == Contans.Pic_Dong) {
                    ArrayList<String> photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                    //可以同时插入多张图片
                    for (String imagePath : photos) {
                        //Log.i("NewActivity", "###path=" + imagePath);
                        picFile = FilesUtil.getSmallBitmap(EditDongActivity.this, imagePath);//压缩图片
                        ivDongPic.setImageURI(Uri.fromFile(picFile));
                        file_list.add(picFile);
                    }
                }else if (requestCode == 1001){

                }
            }
        }
    }
}
