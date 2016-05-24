package com.zhang.nong.doctor.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhang.nong.MainActivity;
import com.zhang.nong.R;
import com.zhang.nong.doctor.activity.DemandManActivity;
import com.zhang.nong.doctor.activity.ForumReplyActivity;
import com.zhang.nong.doctor.com.java.beans.ForumMyData;

import java.util.List;


/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class FroumAdapter extends BaseAdapter{
    Context context;
    List<ForumMyData> mList;
    //layoutinflater主要是用来初始化布局文件，而findviewbyid主要用来初始化布局中的控件

    LayoutInflater mInflater;

    public FroumAdapter(Context context, List<ForumMyData> mList) {
        this.context = context;
        this.mList = mList;
        mInflater=LayoutInflater.from(context);//初始化
    }

    @Override
    public int getCount() {
        //返回数据数量
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        //返回每一行的数据结果

        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //返回每一行视图的id
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
        convertView=mInflater.inflate(R.layout.forum_itema,null);
        //确定每一行布局控件中显示的内容
        //先把置顶的内容填充完
        final LinearLayout mLinearLayout= (LinearLayout) convertView.findViewById(R.id.forum_zhidinglayout);
        ImageView mZhiImageView= (ImageView) convertView.findViewById(R.id.forum_itema_1);
        TextView mZhiTextView= (TextView) convertView.findViewById(R.id.forum_text_1);
        mZhiTextView.setText(mList.get(position).getTitle());




        //头像
        ImageView mImageView= (ImageView) convertView.findViewById(R.id.forum_itemage_2);
        //用户名
        TextView mNameTextView= (TextView) convertView.findViewById(R.id.forum_username);
        //回复的数量
        TextView mHuinumTextView= (TextView) convertView.findViewById(R.id.huifunum);
        //点赞数量
        TextView mZanTextView= (TextView) convertView.findViewById(R.id.forum_zannum);
        //发帖时间
        TextView mtimeTextView=(TextView) convertView.findViewById(R.id.forum_teitime);
        //发帖的标题
        TextView mTitleTextView=(TextView)convertView.findViewById(R.id.forum_teititle);
        //贴的内容
        TextView mContentTextView=(TextView)convertView.findViewById(R.id.forum_teicontent);
        //发帖的图片
        ImageView mPic1ImageView= (ImageView) convertView.findViewById(R.id.forum_image1);
        ImageView mPic2ImageView= (ImageView) convertView.findViewById(R.id.forum_image2);
        ImageView mPic3ImageView= (ImageView) convertView.findViewById(R.id.forum_image3);
        //把内容填冲到具体的布局中
        mImageView.setImageResource(mList.get(position).getManimage());
        mNameTextView.setText(mList.get(position).getUsername());
        mHuinumTextView.setText(mList.get(position).getHuisum());
        mZanTextView.setText(mList.get(position).getZansum());
         mTitleTextView.setText(mList.get(position).getTitle());
        mContentTextView.setText(mList.get(position).getContent());
        mPic1ImageView.setImageResource(mList.get(position).getPic1());
        mPic2ImageView.setImageResource(mList.get(position).getPic2());
        mPic3ImageView.setImageResource(mList.get(position).getPic3());
        //根据是否置顶进行修改显示部分
        if (mList.get(position).getZhiding()){
            //显示置顶部分
            mLinearLayout.setVisibility(View.VISIBLE);
//            mZhiImageView.setVisibility(View.VISIBLE);
//            mZhiTextView.setVisibility(View.VISIBLE);
            //隐藏非置顶的布局
//            mImageView.setVisibility(View.GONE);
//            mNameTextView.setVisibility(View.GONE);
//            mHuinumTextView.setVisibility(View.GONE);
//            mZanTextView.setVisibility(View.GONE);
//            mtimeTextView.setVisibility(View.GONE);
//            mTitleTextView.setVisibility(View.GONE);
//            mContentTextView.setVisibility(View.GONE);
//            mPic1ImageView.setVisibility(View.GONE);
//            mPic2ImageView.setVisibility(View.GONE);
//            mPic3ImageView.setVisibility(View.GONE);
            LinearLayout mfeiLinearLayout= (LinearLayout) convertView.findViewById(R.id.forum_feilayout);
            mfeiLinearLayout.setVisibility(View.GONE);
            mLinearLayout.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                    //这是单击listv中的组件进行的监听跳转
//                    Intent intent=new Intent(context, ForumReplyActivity.class);
                }
            });
        }
//        switch (position){
//            case 3:
//            mPic3ImageView.setVisibility(View.GONE);
//                break;
//            case 4:
//                mPic1ImageView.setVisibility(View.GONE);
//                mPic3ImageView.setVisibility(View.GONE);
//        }
        //设置item中用户头像、用户名的的监听事件
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取被单击用户id查询出用户信息然后通过activity传值传递到demandmanactivity

                Intent intent=new Intent(context, DemandManActivity.class);
                context.startActivity(intent);

            }
        });
        mNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取被单击用户id
                //获取被单击用户id查询出用户信息然后通过activity传值传递到demandmanactivity
                Intent intent=new Intent(context, DemandManActivity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

}
