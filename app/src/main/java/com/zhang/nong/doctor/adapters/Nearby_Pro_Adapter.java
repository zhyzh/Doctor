package com.zhang.nong.doctor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.Expert;

import java.util.List;

/**
 * Created by zhangyunzhen on 2016/5/26.
 */
public class Nearby_Pro_Adapter extends BaseAdapter {
private Context mContext;
private List<Expert> mList;
//layoutinflater主要是用来初始化布局文件
private LayoutInflater mInflater;

public Nearby_Pro_Adapter(Context context, List<Expert> list) {
	mContext = context;
	mList = list;
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
	convertView=mInflater.inflate(R.layout.nearby_professor_item,null);
	//专家头像
	ImageView iv_nearby_professor_head= (ImageView)
		 	convertView.findViewById(R.id.iv_nearby_professor_head);
	//专家名字
	TextView tv_nearby_pro_title= (TextView)
			convertView.findViewById(R.id.tv_nearby_pro_title);
	//专家特长
	TextView tv_nearby_pro_skillname= (TextView)
			convertView.findViewById(R.id.tv_nearby_pro_skillname);

	//把内容填充到具体位置
	iv_nearby_professor_head.setImageResource
			(R.drawable.nearby_professor_exm);
	tv_nearby_pro_title.setText(mList.get(position).getExname());
	tv_nearby_pro_skillname.setText(R.string.nearby_pro_skill);
	return convertView;
}
}
