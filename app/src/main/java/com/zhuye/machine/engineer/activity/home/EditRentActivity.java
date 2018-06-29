package com.zhuye.machine.engineer.activity.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.Base;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.base.CityBean;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.entity.Brand;
import com.zhuye.machine.engineer.entity.Code;
import com.zhuye.machine.engineer.entity.JsonBean;
import com.zhuye.machine.engineer.entity.Model;
import com.zhuye.machine.engineer.entity.ModelType;
import com.zhuye.machine.engineer.http.GetData;
import com.zhuye.machine.engineer.util.FilesUtil;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;
import com.zhuye.machine.engineer.widget.BrandAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;
import retrofit2.http.GET;

/**
 * 出租 发布
 */
public class EditRentActivity extends BaseActivity {

    @BindView(R.id.iv_rent_back)
    ImageView ivRentBack;
    @BindView(R.id.tv_rent_fa)
    TextView tvRentFa;
    @BindView(R.id.layout_title_rent)
    RelativeLayout layoutTitleRent;
    @BindView(R.id.edt_rent_title)
    EditText edtRentTitle;
    @BindView(R.id.iv_brand_type)
    ImageView ivBrandType;
    @BindView(R.id.iv_model)
    ImageView ivModel;
    @BindView(R.id.iv_type)
    ImageView ivType;
    @BindView(R.id.tv_rent_time)
    TextView tvRentTime;
    @BindView(R.id.edt_rent_hour)
    EditText edtRentHour;
    @BindView(R.id.radio_day_money)
    RadioButton radioDayMoney;
    @BindView(R.id.radio_mouth_money)
    RadioButton radioMouthMoney;
    @BindView(R.id.radio_discuss_money)
    RadioButton radioDiscussMoney;
    @BindView(R.id.radio_rent_money)
    RadioGroup radioRentMoney;
    @BindView(R.id.edt_rent_money)
    EditText edtRentMoney;
    @BindView(R.id.radio_day)
    RadioButton radioDay;
    @BindView(R.id.radio_mouth)
    RadioButton radioMouth;
    @BindView(R.id.radio_rent)
    RadioGroup radioRent;
    @BindView(R.id.edt_rent_time)
    EditText edtRentTime;
    @BindView(R.id.iv_rent_address)
    ImageView ivRentAddress;
    @BindView(R.id.edt_rent_dec_detail)
    EditText edtRentDecDetail;
    @BindView(R.id.iv_add_pic)
    ImageView ivAddPic;
    @BindView(R.id.layout_pics)
    LinearLayout layoutPics;
    @BindView(R.id.edt_advertise_tel_name)
    EditText edtAdvertiseTelName;
    @BindView(R.id.edt_advertise_tel)
    EditText edtAdvertiseTel;
    @BindView(R.id.tv_dai_add_group)
    TextView tvDaiAddGroup;
    @BindView(R.id.tv_brand)
    TextView tvBrand;
    @BindView(R.id.tv_model)
    TextView tvModel;
    @BindView(R.id.tv_model_type)
    TextView tvModelType;
    @BindView(R.id.tv_rent_address)
    TextView tvRentAddress;
    //    @BindView(R.id.tv_dai_address)
//    TextView tvDaiAddress
    private List<Brand.BrandData> brand_list = new ArrayList<>();
    private List<Model.ModelData> model_list = new ArrayList<>();
    private List<ModelType.ModelTypeData> modelType_list = new ArrayList<>();
    private String brand_id = "";
    private String model_id = "";
    private String lat = "34.7568711";
    private String lng = "113.663221";
    private String city_name = "郑州";
    private String token = "";
    private SharedPreferencesUtil sharedPreferencesUtil;
    private CityBean cityBean;
    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private String zu_prcie_type = "";//租金类型
    private String zu_time_type = "";//时间类型
    private List<File> file_list = new ArrayList<>();
    private File picFile;
    private ImageView iv;

    @Override
    protected int getResId() {
        return R.layout.activity_edit_rent;
    }

    @Override
    protected void initListener() {
        super.initListener();
        //租金
        radioRentMoney.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (radioDayMoney.getId() == i) {
                    zu_prcie_type = "天";
                } else if (radioMouthMoney.getId() == i) {
                    zu_prcie_type = "月";
                } else {
                    zu_prcie_type = "面议";
                }
            }
        });
        //租期
        radioRent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioDay.getId() == i) {
                    zu_time_type = "天";
                } else if (radioMouth.getId() == i) {
                    zu_time_type = "月";
                }
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        sharedPreferencesUtil = new SharedPreferencesUtil(EditRentActivity.this, "user");
        token = sharedPreferencesUtil.getValue("token", "");
        GetData.getCity(EditRentActivity.this, Contans.Get_City);
        GetData.getBrand(EditRentActivity.this, Contans.Get_Brand);
    }

    @OnClick({R.id.iv_rent_back, R.id.tv_rent_fa, R.id.iv_brand_type, R.id.iv_model, R.id.iv_type, R.id.iv_rent_address, R.id.iv_add_pic, R.id.tv_dai_add_group})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_rent_back://返回
                finish();
                break;
            case R.id.tv_rent_fa://发布
                String title = edtRentTitle.getText().toString();
                String brand = tvBrand.getText().toString();
                String model = tvModel.getText().toString();
                String model_Type = tvModelType.getText().toString();
                String year = tvRentTime.getText().toString();
                String hour = edtRentHour.getText().toString();
                String zu_price = edtRentMoney.getText().toString();
                String zu_time = edtRentTime.getText().toString();
                String region = tvRentAddress.getText().toString();
                String content = edtRentDecDetail.getText().toString();
                String user_name = edtAdvertiseTelName.getText().toString();
                String user_mobile = edtAdvertiseTel.getText().toString();
                if (TextUtils.isEmpty(title)) {
                    toast(getString(R.string.fa_title));
                    return;
                }
                if (zu_prcie_type.equals("")) {
                    toast("请选择租金类型");
                    return;
                }
                if (TextUtils.isEmpty(zu_price)) {
                    toast("请输入租金");
                    return;
                }
                if (zu_time_type.equals("")) {
                    toast("请选择时间类型");
                    return;
                }
                if (TextUtils.isEmpty(zu_time)) {
                    toast("请输入租期");
                    return;
                }
                if (TextUtils.isEmpty(region)) {
                    toast("请选择所在地");
                    return;
                }
                if (TextUtils.isEmpty(user_name)) {
                    toast(getString(R.string.fa_tel_user));
                    return;
                }
                if (TextUtils.isEmpty(user_mobile)) {
                    toast(getString(R.string.fa_tel_num));
                    return;
                }
                GetData.faBu(token, lat, lng, "5", city_name, content, "", title, "", region, "",
                        "", "", "", "", user_name, user_mobile,
                        "", "", brand, model, model_Type, year, hour, zu_prcie_type, zu_price,
                        zu_time_type, zu_time, file_list, EditRentActivity.this, Contans.Fa_Rent);
                break;
            case R.id.iv_brand_type://品牌
                if (brand_list != null) {
                    showData(brand_list, null, null, 1);
                }
                break;
            case R.id.iv_model://型号
                if (model_list != null) {
                    showData(null, model_list, null, 2);
                }
                break;
            case R.id.iv_type://类型
                showData(null, null, modelType_list, 3);
                break;
            case R.id.iv_rent_address://所在地
                selectCity();
                break;
            case R.id.iv_add_pic://添加图片
//                if (file_list.size() == 9) {
//                    toast();
//                    return;
//                }
                if (file_list.size() > 0) {
                    file_list.clear();
                }
                selectPic();
                break;
            case R.id.tv_dai_add_group://同步到部落

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {

                if (requestCode == Contans.Pic_Rent) {
                    ArrayList<String> photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                    for (String imagePath : photos) {
                        //Log.i("NewActivity", "###path=" + imagePath);
                        picFile = FilesUtil.getSmallBitmap(EditRentActivity.this, imagePath);//压缩图片
//                        ivDongPic.setImageURI(Uri.fromFile(picFile));
                        file_list.add(picFile);
                    }
                }
            }
        }
    }

    private int index = -1;

    private void addImageView() {
        index++;
        final View time_view = LayoutInflater.from(EditRentActivity.this).inflate(R.layout.layout_tupian_delete, null);
        time_view.setId(index);
        iv = time_view.findViewById(R.id.iv_tupian);
//            ImageView iv_delete= time_view.findViewById(R.id.iv_delete);
        layoutPics.addView(time_view);
        time_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = view.getId();
                layoutPics.removeView(view);
                file_list.remove(i);
//                    if (count == 1) {
//                        if (face_list.size() > 0) {
//                            face_list.remove(face_list.get(i - 1).getId());
//                        }
//                    } else if (count == 2) {
//                        if (face_list.size() == count) {
//                            face_list.remove(face_list.get(i - 1).getId());
//                        }
//                    }
            }
        });
    }

    private void selectPic() {
        PhotoPicker.builder()
                .setPhotoCount(9)//可选择图片数量
                .setShowCamera(true)//是否显示拍照按钮
                .setShowGif(false)//是否显示动态图
                .setPreviewEnabled(true)//是否可以预览
                .start(EditRentActivity.this, Contans.Pic_Rent);
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case Contans.Get_Brand:
                Brand brand = (Brand) o;
                brand_list = brand.getData();
                break;
            case Contans.Get_Model:
                Model model = (Model) o;
                model_list = model.getData();

                break;
            case Contans.Get_Model_Type:
                ModelType modelType = (ModelType) o;
                modelType_list = modelType.getData();
                break;
            case Contans.Get_City:
                cityBean = (CityBean) o;
                if (cityBean != null) {
                    handleCityData(cityBean);
                }
                break;
            case Contans.Fa_Rent:
                Code code = (Code) o;
                toast(code.getMessage());
                finish();
                break;
            default:
                break;
        }
    }

    private void selectCity() {
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(EditRentActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                Log.i("as", options1 + "s" + options2 + "s" + options3 + "y");
//                start_provinceid = Integer.parseInt(cityBean.getData().get(options1).getProvince_id());
//                start_cityid = Integer.parseInt(cityBean.getData().get(options1).getCity().get(options2).getCity_id());
//                start_areaid = Integer.parseInt(cityBean.getData().get(options1).getCity().get(options2).getRegion().get(options3).getRegion_id());

                String province = cityBean.getData().get(options1).getProvince_name();
                String city = cityBean.getData().get(options1).getCity().get(options2).getCity_name();
                List<CityBean.DataBean.City.Regions> regionList = cityBean.getData().get(options1).getCity().get(options2).getRegion();
                if (regionList != null) {
                    if (regionList.size() > 0) {
                        String area = regionList.get(options3).getRegion_name();
                        tvRentAddress.setText(province + " " + city + " " + area);
                    }
                } else {
                    tvRentAddress.setText(province + " " + city);
                }
            }
        })
                .setTitleText("城市选择")
                .setDividerColor(Color.BLUE)
                .setTextColorCenter(Color.BLUE) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        if (options1Items.size() > 0) {
            pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
            pvOptions.show();
        }
    }

    private void handleCityData(CityBean cityBean) {
        for (int i = 0; i < cityBean.getData().size(); i++) {//遍历省份
            JsonBean data = new JsonBean();
            data.setName(cityBean.getData().get(i).getProvince_name());
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            if (cityBean.getData().get(i).getCity() != null) {
                for (int c = 0; c < cityBean.getData().get(i).getCity().size(); c++) {//遍历该省份的所有城市
                    String CityName = cityBean.getData().get(i).getCity().get(c).getCity_name();
                    CityList.add(CityName);//添加城市
                    ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                    //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                    if (cityBean.getData().get(i).getCity().get(c).getRegion() == null) {
                        City_AreaList.add("");
                    } else if (cityBean.getData().get(i).getCity().get(c).getRegion().size() == 0) {
                        City_AreaList.add("");
                    } else {

                        for (int d = 0; d < cityBean.getData().get(i).getCity().get(c).getRegion().size(); d++) {//该城市对应地区所有数据
                            String AreaName = cityBean.getData().get(i).getCity().get(c).getRegion().get(d).getRegion_name();
                            City_AreaList.add(AreaName);//添加该城市所有地区数据
                        }
                    }
                    Province_AreaList.add(City_AreaList);//添加该省所有地区数据
                }
            }
            //添加城市数据
            options2Items.add(CityList);

            //添加地区数据
            options3Items.add(Province_AreaList);
            options1Items.add(data);
        }

    }

    private void showData(final List<Brand.BrandData> brand_list, final List<Model.ModelData> model_list
            , final List<ModelType.ModelTypeData> modelType_list, final int flag) {
        // 找到popup的布局
        View rootview = LayoutInflater.from(EditRentActivity.this).inflate(R.layout.group_dialog_layout, null);
        // 找到布局中的取消按钮
        Button cancel = (Button) rootview.findViewById(R.id.btn_cancel);
        LinearLayout llLvParent = (LinearLayout) rootview.findViewById(R.id.ll_lv_parent);
        ListView commonListView = new ListView(EditRentActivity.this);//this为获取当前的上下文
        commonListView.setFadingEdgeLength(0);
        BrandAdapter picSelectAdapter = new BrandAdapter(EditRentActivity.this, brand_list, model_list, modelType_list, flag);
        commonListView.setAdapter(picSelectAdapter);
        commonListView.requestFocus();
        commonListView.setBackgroundDrawable(getResources().getDrawable(R.drawable.group_dialog_button_bg));
        llLvParent.addView(commonListView);//往这个布局中加入listview
        final AlertDialog dialog = new AlertDialog.Builder(EditRentActivity.this)
                .create();
        dialog.show();
        Window window = dialog.getWindow();
        // 为对话框设置布局
        window.setContentView(rootview);

        // 此句话兼容4.0及5.0系统的背景颜色为透明
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams wlp = window.getAttributes();
        // 设置对话框显示位置（底部显示）
        wlp.gravity = Gravity.BOTTOM;
        // 设置对话框的宽为内容适应
        wlp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        // 设置对话框的高为内容适应
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wlp);
        // 设置弹出的动画效果（底部弹出，底部消失）
        window.setWindowAnimations(R.style.AnimBottom);
        // 设置对话框外的部分不能关闭对话框
        dialog.setCanceledOnTouchOutside(true);
        commonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view1, int position, long id) {
                if (flag == 1) {//品牌
                    String brand = brand_list.get(position).getBrand();
                    tvBrand.setText(brand);
                    String brand_id = brand_list.get(position).getBrand_id();
                    GetData.getModel(brand_id, EditRentActivity.this, Contans.Get_Model);
                } else if (flag == 2) {//型号
                    String model = model_list.get(position).getModel();
                    String model_id = model_list.get(position).getModel_id();
                    tvModel.setText(model);
                    GetData.getModelType(model_id, EditRentActivity.this, Contans.Get_Model_Type);
                } else {//类型
                    tvModelType.setText(modelType_list.get(position).getModel_type());
                }

                // Dialog消失
                dialog.dismiss();
            }
        });
        // 点击取消按钮，将选项设为请选择
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}
