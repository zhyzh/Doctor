package com.zhang.nong.doctor.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.Collect;
import com.zhang.nong.doctor.com.java.beans.Zhutei;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27 0027.
 */
public class Froum_userinfoAdapter extends BaseAdapter{
    List<Zhutei> mZhuteis;
    Context context;
    //layoutinflater主要是用来初始化布局文件，而findviewbyid主要用来初始化布局中的控件

    LayoutInflater mInflater;
    ListView mListView;

    public Froum_userinfoAdapter(Context context, List<Zhutei> mZhuteis) {
        this.context = context;
        this.mZhuteis = mZhuteis;
        mInflater = LayoutInflater.from(context);//初始化
    }

    @Override
    public int getCount() {
        return mZhuteis.size();
    }

    @Override
    public Object getItem(int position) {
        return mZhuteis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    /*
    * position表示当前显示的是第几行数据，从0开始
    * convertview表示当前显示的布局是哪个布局
    * parent包含当前行布局的父布局
    * */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //视图缓存暂时没做
        //确定每一行的布局，并且把对应的数据显示到布局中
        //第一个参数：要显示的布局索引，第二个参数，包含每一行布局的父布局，这里直接用null
        convertView=mInflater.inflate(R.layout.forum_userinfoitem,null);
        //确定每一行布局控件中显示的内容
        //先把置顶的内容填充完
        //初始化控件
        //头像
        ImageView mhanderImageView= (ImageView) convertView.findViewById(R.id.forum_itemage_2);
        //用户名
        TextView mnameTextView= (TextView) convertView.findViewById(R.id.forum_username);
        //标题
        TextView mTetilTextView= (TextView) convertView.findViewById(R.id.forum_replytitle);
        //内容
        TextView mneiTextView= (TextView) convertView.findViewById(R.id.forum_replycontent);
        //时间
        TextView mtimeTextView= (TextView) convertView.findViewById(R.id.forum_teitime);
        //点赞数
        TextView zannumTextView= (TextView) convertView.findViewById(R.id.forum_zannum);
        //回帖数
        TextView huinumTextView= (TextView) convertView.findViewById(R.id.huifunum);
        //填值
        mhanderImageView.setImageResource(R.drawable.abcman);
        mnameTextView.setText(mZhuteis.get(position).getUserName());
        mTetilTextView.setText(mZhuteis.get(position).getTitle());
        mneiTextView.setText(mZhuteis.get(position).getZnei());
        mtimeTextView.setText(mZhuteis.get(position).getDate().toString());
        zannumTextView.setText(mZhuteis.get(position).getZan());
        huinumTextView.setText(mZhuteis.get(position).getHui());




        return convertView;
    }
}
