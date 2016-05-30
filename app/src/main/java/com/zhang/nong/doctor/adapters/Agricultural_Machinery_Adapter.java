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
 * Created by zhangyunzhen on 2016/5/27.
 */
public class Agricultural_Machinery_Adapter extends BaseAdapter {
    private Context mContext;
    private List<Machine> mMachineList;
    private LayoutInflater mInflater;

    public Agricultural_Machinery_Adapter(Context context, List<Machine> machineList) {
        mContext = context;
        mMachineList = machineList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mMachineList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMachineList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.home_agricultural_machinery_item, null);
        //农机图片
        ImageView iv_agricultural_machinery_picture = (ImageView)
                convertView.findViewById(R.id.iv_agricultural_machinery_picture);
        //农机类型
        TextView tv_agricultural_machinery_type = (TextView)
                convertView.findViewById(R.id.tv_agricultural_machinery_type);
        //农机使用价格
        TextView tv_agricultural_machinery_priceday = (TextView)
                convertView.findViewById(R.id.tv_agricultural_machinery_priceday);
        //农机发布地点
        TextView tv_agricultural_machinery_address = (TextView)
                convertView.findViewById(R.id.tv_agricultural_machinery_address);
        //农机发布时间
        TextView tv_agricultural_machinery_publish_time = (TextView)
                convertView.findViewById(R.id.tv_agricultural_machinery_publish_time);

        //把需要获取的数据获取到
        iv_agricultural_machinery_picture.setImageResource(R.drawable.home_mac_recommend);
        //农机类型
        tv_agricultural_machinery_type.setText(mMachineList.get(position).getType());
        //农机服务价格
        tv_agricultural_machinery_priceday.setText(mMachineList.get(position).getPrices() + ":");
        //农机主的地理位置
        tv_agricultural_machinery_address.setText(mMachineList.get(position).getLoaction());
        //农机主发布的时间
        tv_agricultural_machinery_publish_time.setText(mMachineList.get(position).getDate() + ":");


        return convertView;
    }
}
