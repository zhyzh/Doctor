package com.zhang.nong.doctor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.MyDataaa;

import java.util.List;

/**
 * Created by XCF on 2016/4/25.
 */
public class UpdateAdapter extends BaseAdapter {
    List<MyDataaa> mList;
    Context mContext;
    //LayoutInflater只要用来初始化布局文件，而findViewById主要用来初始化布局中的控件
    //找到整个布局中的控件，findViewById是找到布局里面单个的id
    LayoutInflater mInflater;

    public UpdateAdapter(Context context, List<MyDataaa> list) {
        mContext = context;
        mList = list;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        //返回数据数量（共多少行）
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        //返回每一行的数据结果（就是MyData对象）
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //返回每一行的数据id
        return position;
    }
    //缓存布局中的控件
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

    /**
     *
     * @param position 表示当前显示的是第几行数据，从0开始
     * @param convertView 表示当前行显示的布局是哪个布局(缓存每一行的布局)
     * @param parent 包含当前行布局的父布局
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //确定每一行的布局，并且把对应的数据显示到布局
        //第一步：找到每一行的布局
        if(convertView == null){
            //说明是第一次绘制整屏列表
            //第一个参数：每一行要显示的布局索引,第二个参数：包含每一行布局的父布局，这里直接用null
            convertView = mInflater.inflate(R.layout.item_list, null);
            viewHolder = new ViewHolder();
            //确定每一行布局中每个控件显示的内容
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tw);
            //把当前的控件缓存到布局视图中
            convertView.setTag(viewHolder);
        }else{
            //说明开始上下滑动，后面的所有行布局采用第一次绘制时的缓存布局
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //显示内容
       // viewHolder.imageView.setImageResource(mList.get(position).getPic());
        //viewHolder.textView.setText(mList.get(position).getContent());
        final MyDataaa myData = mList.get(position);
        viewHolder.imageView.setImageResource(myData.getPic());
        viewHolder.textView.setText(myData.getContent());

        //监听每一行的按钮单击事件
      /*  Button button = (Button) convertView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,SexActivity.class);
                intent.putExtra("data",myData);
                mContext.startActivity(intent);
            }
        });*/
        return convertView;
    }
}
