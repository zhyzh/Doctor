package com.zhang.nong.doctor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.Reply;

import java.util.List;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class Froum_replyobjectAdapter  extends BaseAdapter {
    Context context;
    //放的是回复楼层的内容
    List<Reply> mList;
    //layoutinflater主要是用来初始化布局文件，而findviewbyid主要用来初始化布局中的控件
    LayoutInflater mInflater;

    public Froum_replyobjectAdapter(Context context, List<Reply> mList) {
        this.context = context;
        this.mList = mList;
        mInflater=LayoutInflater.from(context);//初始化
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
        //视图缓存暂时没做
        //确定每一行的布局，并且把对应的数据显示到布局中
        //第一个参数：要显示的布局的索引，第二个参数，包含每一行布局的父布局，这里直接用null
        //确定每一行布局控件中显示的内容
        convertView=mInflater.inflate(R.layout.fragmentreply_item,null);
        //确定每一行布局控件中显示的内容
        //头像
        ImageView mImageview= (ImageView) convertView.findViewById(R.id.forum_itemage_2);

        //姓名
        TextView musernameTextView= (TextView) convertView.findViewById(R.id.forum_username);
        //时间
        TextView mtimeTextView= (TextView) convertView.findViewById(R.id.forum_teitime);
        //回复用户的那条贴子，或者用户的那条回复
        TextView mobjectcontentTextView= (TextView) convertView.findViewById(R.id.forum_contentitem);
        //这个的内容需要从表中查询根据贴的id，
        mobjectcontentTextView.setText("为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图");
        //回复内容
        TextView mcontentTextView= (TextView) convertView.findViewById(R.id.forum_replyconobjie);

        mImageview.setImageResource(R.drawable.abcman);
        musernameTextView.setText(mList.get(position).getUserName());
        mtimeTextView.setText(mList.get(position).getDate().toString());
        //回复 *** ：内容；是因为在回复他的时候，系统自动填充回复对象的；
        mcontentTextView.setText(mList.get(position).getContent());

        return convertView;
    }
}
