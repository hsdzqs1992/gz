package com.zhuye.machine.engineer.activity.home;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.base.Base;
import com.zhuye.machine.engineer.base.BaseActivity;
import com.zhuye.machine.engineer.base.CityBean;
import com.zhuye.machine.engineer.contants.Contans;
import com.zhuye.machine.engineer.entity.Code;
import com.zhuye.machine.engineer.entity.JsonBean;
import com.zhuye.machine.engineer.http.GetData;
import com.zhuye.machine.engineer.util.SharedPreferencesUtil;
import com.zhuye.machine.engineer.widget.PicSelectAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 招聘 发布
 */
public class EditAdvertiseActivity extends BaseActivity {


    @BindView(R.id.iv_find_job_back)
    ImageView ivFindJobBack;
    @BindView(R.id.tv_find_job_fa)
    TextView tvFindJobFa;
    @BindView(R.id.layout_title_dai)
    RelativeLayout layoutTitleDai;
    @BindView(R.id.edt_advertise_title)
    EditText edtAdvertiseTitle;
    @BindView(R.id.tv_advertise_time)
    TextView tvAdvertiseTime;
    @BindView(R.id.edt_advertise_zhi)
    EditText edtAdvertiseZhi;
    @BindView(R.id.edt_advertise_salary)
    EditText edtAdvertiseSalary;
    @BindView(R.id.edt_advertise_person_count)
    EditText edtAdvertisePersonCount;
    @BindView(R.id.iv_advertise_region)
    ImageView ivAdvertiseRegion;
    @BindView(R.id.edt_advertise_jinyan)
    EditText edtAdvertiseJinyan;
    @BindView(R.id.edt_advertise_tel_name)
    EditText edtAdvertiseTelName;
    @BindView(R.id.edt_advertise_tel)
    EditText edtAdvertiseTel;
    @BindView(R.id.tv_dai_add_group)
    TextView tvDaiAddGroup;
    @BindView(R.id.tv_advertise_address)
    TextView tvAdvertiseAddress;
    private List<String> time_list = new ArrayList<>();
    private String lat = "34.7568711";
    private String lng = "113.663221";
    private String city_name = "郑州";
    private String token = "";
    private SharedPreferencesUtil sharedPreferencesUtil;
    private CityBean cityBean;
    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();

    @Override
    protected int getResId() {
        return R.layout.activity_edit_advertise;
    }

    @Override
    protected void initData() {
        super.initData();
        sharedPreferencesUtil = new SharedPreferencesUtil(EditAdvertiseActivity.this, "user");
        token = sharedPreferencesUtil.getValue("token", "");
        time_list.add("一年以内");
        time_list.add("一年");
        time_list.add("二年");
        time_list.add("三年");
        time_list.add("三年以上");
        GetData.getCity(EditAdvertiseActivity.this, Contans.Get_City);
    }

    @OnClick({R.id.iv_find_job_back, R.id.tv_find_job_fa, R.id.tv_advertise_time, R.id.iv_advertise_region, R.id.tv_dai_add_group})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_find_job_back:
                finish();
                break;
            case R.id.tv_find_job_fa://发布
                String title = edtAdvertiseTitle.getText().toString();
                String age = tvAdvertiseTime.getText().toString();
                String position = edtAdvertiseZhi.getText().toString();
                String price = edtAdvertiseSalary.getText().toString();
                String region = tvAdvertiseAddress.getText().toString();
                String man_sum = edtAdvertisePersonCount.getText().toString();
                String require = edtAdvertiseJinyan.getText().toString();
                String user_name = edtAdvertiseTelName.getText().toString();
                String user_mobile = edtAdvertiseTel.getText().toString();
                GetData.faBu(token,lat,lng,"4",city_name,"","",title
                ,"",region,age,require,"","",price,user_name,
                        user_mobile,position,man_sum,"","","",""
                        ,"","", "","","",
                        null,EditAdvertiseActivity.this, Contans.Fa_Advertise);
                break;
            case R.id.tv_advertise_time://工作经验
                showTimeOrFee(time_list, 0);
                break;
            case R.id.iv_advertise_region://地区选择
                selectCity();
                break;
            case R.id.tv_dai_add_group:
                break;
        }
    }

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode){
            case Contans.Fa_Advertise://发布
                Code code = (Code) o;
                toast(code.getMessage());
                finish();
                break;
            case Contans.Get_City://获取省市区
                cityBean = (CityBean) o;
                if (cityBean != null) {
                    handleCityData(cityBean);
                }
                break;

        }
    }

    private void selectCity() {
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(EditAdvertiseActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
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
                        tvAdvertiseAddress.setText(province + " " + city + " " + area);
                    }
                } else {
                    tvAdvertiseAddress.setText(province + " " + city);
                }
//

            }
        })
                .setTitleText("城市选择")
                .setDividerColor(Color.BLUE)
                .setTextColorCenter(Color.BLUE) //设置选中项文字颜色
                .setContentTextSize(18)
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
            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);

            options1Items.add(data);
        }

    }
    private void showTimeOrFee(final List<String> list, final int flag) {
        // 找到popup的布局
        View rootview = LayoutInflater.from(EditAdvertiseActivity.this).inflate(R.layout.group_dialog_layout, null);
        // 找到布局中的取消按钮
        Button cancel = (Button) rootview.findViewById(R.id.btn_cancel);
        LinearLayout llLvParent = (LinearLayout) rootview.findViewById(R.id.ll_lv_parent);
        ListView commonListView = new ListView(EditAdvertiseActivity.this);//this为获取当前的上下文
        commonListView.setFadingEdgeLength(0);
        PicSelectAdapter picSelectAdapter = new PicSelectAdapter(EditAdvertiseActivity.this, list);
        commonListView.setAdapter(picSelectAdapter);
        commonListView.requestFocus();
        commonListView.setBackgroundDrawable(getResources().getDrawable(R.drawable.group_dialog_button_bg));
        llLvParent.addView(commonListView);//往这个布局中加入listview
        final AlertDialog dialog = new AlertDialog.Builder(EditAdvertiseActivity.this)
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
                tvAdvertiseTime.setText(list.get(position));
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
