package com.zhuye.machine.engineer.activity.home;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.zhuye.machine.engineer.calender.CalendarPopWindow;
import com.zhuye.machine.engineer.calender.OnCalendarPopSelectListener;
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
 * 编辑代班
 */
public class EditDaibanActivity extends BaseActivity implements OnCalendarPopSelectListener {

    @BindView(R.id.iv_daiban_back)
    ImageView ivDaibanBack;
    @BindView(R.id.tv_daiban_fa)
    TextView tvDaibanFa;
    @BindView(R.id.layout_title_dai)
    RelativeLayout layoutTitleDai;
    @BindView(R.id.edt_dai_title)
    EditText edtDaiTitle;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.layout_calender)
    RelativeLayout layoutCalender;
    @BindView(R.id.iv_dai_zhao_address)
    ImageView ivDaiZhaoAddress;
    @BindView(R.id.tv_dai_time)
    TextView tvDaiTime;
    @BindView(R.id.edt_jinyan)
    EditText edtJinyan;
    @BindView(R.id.tv_dai_cao)
    TextView tvDaiCao;
    @BindView(R.id.edt_fuli)
    EditText edtFuli;
    @BindView(R.id.iv_dai_salary)
    EditText ivDaiSalary;
    @BindView(R.id.iv_dai_tel_name)
    EditText ivDaiTelName;
    @BindView(R.id.iv_dai_tel)
    EditText ivDaiTel;
    @BindView(R.id.tv_dai_add_group)
    TextView tvDaiAddGroup;
    @BindView(R.id.tv_dai_zhao_address)
    TextView tvDaiZhaoAddress;
    private String startTime = "";
    private String endTime = "";
    private CalendarPopWindow mCalendarPopWindow;
    private List<String> time_list = new ArrayList<>();
    private List<String> cao_list = new ArrayList<>();
    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private CityBean cityBean;
    private String lat = "34.7568711";
    private String lng = "113.663221";
    private String city_name = "郑州";
    private String token = "";
    private SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    protected int getResId() {
        return R.layout.activity_edit_daiban;
    }

    @Override
    protected void initData() {
        super.initData();
        sharedPreferencesUtil = new SharedPreferencesUtil(EditDaibanActivity.this, "user");
        token = sharedPreferencesUtil.getValue("token", "");
        time_list.add("一年以内");
        time_list.add("一年");
        time_list.add("二年");
        time_list.add("三年");
        time_list.add("三年以上");
        cao_list.add("正手");
        cao_list.add("反手");
        GetData.getCity(EditDaibanActivity.this, Contans.Get_City);
    }

    @Override
    public void onSelect(@NonNull String before, @NonNull String after) {
        startTime = before;
        endTime = after;
        tvStartTime.setText(startTime);
        tvEndTime.setText(endTime);
    }

    @OnClick({R.id.iv_daiban_back, R.id.tv_daiban_fa, R.id.layout_calender, R.id.tv_dai_time,
            R.id.tv_dai_cao, R.id.tv_dai_add_group, R.id.iv_dai_zhao_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_daiban_back:
                finish();
                break;
            case R.id.tv_daiban_fa:
                String title = edtDaiTitle.getText().toString();
                String data_time = startTime + " - " + endTime;
                String region = tvDaiZhaoAddress.getText().toString();
                String age = tvDaiTime.getText().toString();
                String require = edtJinyan.getText().toString();
                String operation_direction = tvDaiCao.getText().toString();
                String welfare = edtFuli.getText().toString();
                String price = ivDaiSalary.getText().toString();
                String user_name = ivDaiTelName.getText().toString();
                String user_mobile = ivDaiTel.getText().toString();
                GetData.faBu(token, lat, lng, "2", city_name, "", "",
                        title, data_time, region, age, require, operation_direction, welfare, price,
                        user_name, user_mobile, "", "", "", "",
                        "", "", "", "", "",
                        "", "", null,
                        EditDaibanActivity.this, Contans.Fa_Daiban);
                break;
            case R.id.layout_calender:
                mCalendarPopWindow = new CalendarPopWindow(this, this, "");
                mCalendarPopWindow.onShow(view);
                break;
            case R.id.tv_dai_time:
                showTimeOrFee(time_list, 1);
                break;
            case R.id.tv_dai_cao:
                showTimeOrFee(cao_list, 2);
                break;
            case R.id.iv_dai_zhao_address:
                selectCity();

                break;
            case R.id.tv_dai_add_group:
                break;
        }
    }

    private void selectCity() {
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(EditDaibanActivity.this, new OptionsPickerView.OnOptionsSelectListener() {
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
                        tvDaiZhaoAddress.setText(province + " " + city + " " + area);

                    }
                } else {
                    tvDaiZhaoAddress.setText(province + " " + city);
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

    @Override
    public void success(int requestcode, Object o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case Contans.Get_City://获取省市区
                cityBean = (CityBean) o;
                if (cityBean != null) {
                    handleCityData(cityBean);
                }
                break;
            case Contans.Fa_Daiban://代班发布
                Code code = (Code) o;
                toast(code.getMessage());
                finish();
                break;
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
        View rootview = LayoutInflater.from(EditDaibanActivity.this).inflate(R.layout.group_dialog_layout, null);
        // 找到布局中的取消按钮
        Button cancel = (Button) rootview.findViewById(R.id.btn_cancel);
        LinearLayout llLvParent = (LinearLayout) rootview.findViewById(R.id.ll_lv_parent);
        ListView commonListView = new ListView(EditDaibanActivity.this);//this为获取当前的上下文
        commonListView.setFadingEdgeLength(0);
        PicSelectAdapter picSelectAdapter = new PicSelectAdapter(EditDaibanActivity.this, list);
        commonListView.setAdapter(picSelectAdapter);
        commonListView.requestFocus();
        commonListView.setBackgroundDrawable(getResources().getDrawable(R.drawable.group_dialog_button_bg));
        llLvParent.addView(commonListView);//往这个布局中加入listview
        final AlertDialog dialog = new AlertDialog.Builder(EditDaibanActivity.this)
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
                if (flag == 1) {//驾龄年限
                    tvDaiTime.setText(list.get(position));
                } else if (flag == 2) {//操作方向
                    tvDaiCao.setText(list.get(position));
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
