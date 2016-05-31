package com.zhang.nong.doctor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.Farmmessage;

import java.util.List;

/**
 * Created by zhangyunzhen on 2016/5/27.
 */
public class Home_Agricultural_Tool_Adapter extends BaseAdapter {
private Context mContext;
private List<Farmmessage> mFarmmessageList;
private LayoutInflater mInflater;

public Home_Agricultural_Tool_Adapter(Context context, List<Farmmessage> farmmessageList) {
	mContext = context;
	mFarmmessageList = farmmessageList;
	mInflater=LayoutInflater.from(context);
}

@Override
public int getCount() {
	return mFarmmessageList.size();
}

@Override
public Object getItem(int position) {
	return mFarmmessageList.get(position);
}

@Override
public long getItemId(int position) {
	return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
	convertView=mInflater.inflate(R.layout.home_agricultural_tool_item,null);
	//获取数据
	TextView tv_agricultural_tool_title= (TextView)
			convertView.findViewById(R.id.tv_agricultural_tool_title);
	TextView tv_agricultural_tool_address= (TextView)
			convertView.findViewById(R.id.tv_agricultural_tool_address);
	//获取数据库中的数据
	//农资部的名称
	tv_agricultural_tool_title.setText(mFarmmessageList.get(position).getFarmname());
	//农资部的地址
	tv_agricultural_tool_address.setText(mFarmmessageList.get(position).getArea());



	return convertView;
}
}
