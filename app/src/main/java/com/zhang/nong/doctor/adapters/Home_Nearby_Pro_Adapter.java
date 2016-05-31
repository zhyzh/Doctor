package com.zhang.nong.doctor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.Expert;

import java.util.List;

/**
 * Created by zhangyunzhen on 2016/5/26.
 */
public class Home_Nearby_Pro_Adapter extends ArrayAdapter<Expert> {
private int resourceId;

public Home_Nearby_Pro_Adapter(Context context, int resource, List<Expert> objects, int resourceId) {
	super(context, resource, objects);
	this.resourceId = resource;

}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
	Expert expert=getItem(position);//获取当前项的expert的实例
	View view;
	ViewHolder viewHolder;
	if (convertView == null) {
		view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		viewHolder=new ViewHolder();
		viewHolder.iv_nearby_professor_head= (ImageView) view.findViewById
				(R.id.iv_nearby_professor_head);
		viewHolder.tv_nearby_pro_title= (TextView) view.findViewById
				(R.id.tv_nearby_pro_title);
		viewHolder.tv_nearby_pro_skillname= (TextView) view.findViewById
				(R.id.tv_nearby_pro_skillname);
		view.setTag(viewHolder);//将viewholder存储在view中

	} else {
		view=convertView;
		viewHolder= (ViewHolder) view.getTag();//重新获取viewholder
	}

	//把内容填充到具体位置
	viewHolder.iv_nearby_professor_head.setImageResource
			(R.drawable.nearby_professor_exm);
	viewHolder.tv_nearby_pro_title.setText(expert.getExname());
	viewHolder.tv_nearby_pro_skillname.setText(R.string.nearby_pro_skill);

	return view;
}
//用于对控件的实例进行缓存，当convertView为空的时候，创建一个viewholder对象并将控件的实例都放在viewholder里面，
// 然后调用view的settag方法将viewholder对象存储在view中。
class  ViewHolder{
	ImageView iv_nearby_professor_head;
	TextView tv_nearby_pro_title;
	TextView tv_nearby_pro_skillname;

}
}
