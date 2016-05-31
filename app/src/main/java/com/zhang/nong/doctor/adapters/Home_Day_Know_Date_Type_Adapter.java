package com.zhang.nong.doctor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhang.nong.R;

import java.util.List;

/**
 * Created by zhangyunzhen on 2016/5/28.
 */
public class Home_Day_Know_Date_Type_Adapter extends BaseAdapter {
private Context mContext;
private List<String> mList;
private LayoutInflater mInflater;
private TextView tv_day_know_date_type;
private TextView tv_day_know_date_item;

public Home_Day_Know_Date_Type_Adapter(Context context, List<String> list) {
	this.mContext = context;
	this.mList = list;
	mInflater=LayoutInflater.from(context);
}

@Override
public int getCount() {
	return mList.size();
}

@Override
public Object getItem(int position) {
	return mList.get(position);
}

@Override
public long getItemId(int position) {
	return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
	convertView=mInflater.inflate(R.layout.home_day_know_date_type_item,null);

	tv_day_know_date_item = (TextView) convertView.findViewById(R.id.tv_day_know_date_item);

	//添加
	tv_day_know_date_item.setText(mList.get(position).toString());


	return convertView;
}
}
