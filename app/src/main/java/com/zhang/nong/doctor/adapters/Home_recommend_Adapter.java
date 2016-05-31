package com.zhang.nong.doctor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.Machine;

import java.util.List;

/**
 * Created by zhangyunzhen on 2016/5/25.
 */
public class Home_recommend_Adapter extends BaseAdapter {
//
 Context mContext;
private List<Machine> mList;
//layoutinflater主要是用来初始化布局文件
private LayoutInflater mInflater;

public Home_recommend_Adapter(Context context,
                              List<Machine> list ) {
	this.mContext = context;
	this.mList = list;
	//初始化
	mInflater = LayoutInflater.from(context);

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
	convertView = mInflater.inflate(R.layout.home_recommend_item, null);
	ImageView iv_home_recommend_item = (ImageView) convertView.findViewById
			(R.id.iv_home_recommend_item);
	TextView tv_home_mac_typename = (TextView) convertView.findViewById
			(R.id.tv_home_mac_typename);
	TextView tv_home_mac_addrname= (TextView) convertView.findViewById
			(R.id.tv_home_mac_addrname);
	TextView tv_home_mac_ownername= (TextView) convertView.findViewById
			(R.id.tv_home_mac_ownername);
	TextView tv_home_mac_phoneNum= (TextView) convertView.findViewById
			(R.id.tv_home_mac_phoneNum);

	//把内容填充到具体的位置
	iv_home_recommend_item.setImageResource(R.drawable.home_mac_recommend);
	tv_home_mac_typename.setText(mList.get(position).getType());
	tv_home_mac_addrname.setText(mList.get(position).getLoaction());
	tv_home_mac_ownername.setId(mList.get(position).getUserId());
	tv_home_mac_phoneNum.setText(mList.get(position).getPhone());


	return convertView;
}

}
