/**
 * Copyright (c) 2015 Changchun Sunao Software Co., Ltd. All Rights Reserved
 */
package com.zhuye.machine.engineer.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhuye.machine.engineer.R;

import java.util.List;


/**
：
 */
public class PicSelectAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public PicSelectAdapter(Context context, List<String> list) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        holder.tvSpText.setText(list.get(position));// 设置对话框显示文本
        return convertView;
    }
}
