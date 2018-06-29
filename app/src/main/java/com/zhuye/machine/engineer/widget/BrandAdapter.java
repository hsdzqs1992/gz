package com.zhuye.machine.engineer.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;
import com.zhuye.machine.engineer.entity.Brand;
import com.zhuye.machine.engineer.entity.Model;
import com.zhuye.machine.engineer.entity.ModelType;

import java.util.List;

/**
 * Created by lcc2018 on 2018/6/14.
 */

public class BrandAdapter extends BaseAdapter {
    private List<Brand.BrandData> brand_list;
    private List<Model.ModelData> model_list;
    private List<ModelType.ModelTypeData> modelType_list;
    private int flag = 0;
    private Context context;
    private LayoutInflater inflater;

    public BrandAdapter(Context context, List<Brand.BrandData> brand_list, List<Model.ModelData> model_list
            , List<ModelType.ModelTypeData> modelType_list, int flag) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.brand_list = brand_list;
        this.model_list = model_list;
        this.modelType_list = modelType_list;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        if (flag ==1){
            return brand_list.size();
        }else if (flag == 2){
            return model_list.size();
        }else if (flag == 3){
            return modelType_list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        private TextView tvSpText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.group_dialog_spinner_layout, null);
            holder.tvSpText = (TextView) convertView.findViewById(R.id.sp_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (flag == 1) {
            holder.tvSpText.setText(brand_list.get(position).getBrand());// 设置对话框显示文本
        }else if (flag == 2){
            holder.tvSpText.setText(model_list.get(position).getModel());// 设置对话框显示文本
        }else if (flag == 3){
            holder.tvSpText.setText(modelType_list.get(position).getModel_type());// 设置对话框显示文本
        }
        return convertView;
    }
}
