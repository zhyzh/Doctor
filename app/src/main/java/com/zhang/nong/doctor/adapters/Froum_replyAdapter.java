package com.zhang.nong.doctor.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.activity.DemandManActivity;
import com.zhang.nong.doctor.com.java.beans.Reply;

import java.util.List;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class Froum_replyAdapter extends BaseAdapter {
    //标志为
    boolean fale=true;
    Context context;
    List<Reply> mList;
    //layoutinflater主要是用来初始化布局文件，而findviewbyid主要用来初始化布局中的控件
    LayoutInflater mInflater;

    //简单的回调函数
//    Mgetlist mgetlist;
//    public interface Mgetlist{public abstract void getadapter(ListView view);}



    public Froum_replyAdapter(Context context, List<Reply> mList) {
        this.context = context;
        this.mList = mList;
        mInflater=LayoutInflater.from(context);//初始化

//        //初始化mgelist
//        Activity activity= (Activity) context;
//        mgetlist= (Mgetlist) activity;
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

//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        mcontext=activity;
//        //初始化mlistitemclick
//        mListItemClick=(ListItemClick)activity;
//    }
    /*
    * position表示当前显示的是第几行数据，从0开始
    * convertview表示当前显示的布局是哪个布局
    * parent包含当前行布局的父布局
    * */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //视图缓存暂时没做
        //确定每一行的布局，并且把对应的数据显示到布局中
        //第一个参数：要显示的布局的索引，第二个参数，包含每一行布局的父布局，这里直接用null
        //确定每一行布局控件中显示的内容
        //先把置顶的内容填充完
        //回复人、楼主的照片
        convertView=mInflater.inflate(R.layout.forum_replyitem,null);
ImageButton mlouzImageButton= (ImageButton) convertView.findViewById(R.id.forum_replylouzhubiao);
        ImageView handimageView= (ImageView) convertView.findViewById(R.id.forum_replyitemage_2);
        //用户名
        TextView mforumTextView= (TextView) convertView.findViewById(R.id.forum_replyusername);
        //回复楼层的按钮
        ImageButton mhuifuImageButton= (ImageButton) convertView.findViewById(R.id.forum_replyban);
        ImageButton mcollectImageButton= (ImageButton) convertView.findViewById(R.id.forum_collect);
        //楼主图标
        ImageButton mlouzbiaoImageButton= (ImageButton) convertView.findViewById(R.id.forum_replylouzhubiao);
        //回复的时间
        TextView mtimeTextView= (TextView) convertView.findViewById(R.id.forum_replytime);
        //帖子的标题
        TextView mreplytetleTextView= (TextView) convertView.findViewById(R.id.forum_replytitle);
        //帖子的内容
        TextView mcontentTextView= (TextView) convertView.findViewById(R.id.forum_replycontent);
        //帖子的图片（一楼的根据帖子的id到图片表去找）
        ImageView mreplyImageView= (ImageView) convertView.findViewById(R.id.forum_replyimage1);
        //回帖的listview
//        ListView mreplylouListView= (ListView) convertView.findViewById(R.id.forum_reply_listobject);
        //填充数据mList.get(position).getImg()先用本地的图片，以后用网络的图片就不需要这样了
        //        handimageView.setImageResource(Integer.parseInt(mList.get(position).getImg()));
        //几楼
        TextView mreplylouTextView= (TextView) convertView.findViewById(R.id.forum_reply_louceng);
       // 楼层的回复
        TextView mreplyloTextView= (TextView) convertView.findViewById(R.id.forum_loureply_textview);

        if (mList.get(position).getUserName().equals("true")){
            //如果传值的话
            //这里先写死
            handimageView.setImageResource(R.drawable.abcman);
            mforumTextView.setText("如果一个人的梦想ok");
            mtimeTextView.setText("2016-5-12");
            mreplytetleTextView.setText("虎吧升级专贴三");
            mcontentTextView.setText("为了吧友升级,专开水经验贴，其他无任何大师们的精华缩写或者截图");
            mreplyImageView.setImageResource(R.drawable.test_forum2);
            //隐藏回复
            mreplyloTextView.setVisibility(View.GONE);
            fale=false;
        }else if (mList.get(position).getNewFloor().equals("true")){

            //如果非一楼显示回复楼层的按钮、以及收藏按钮

            mlouzbiaoImageButton.setVisibility(View.VISIBLE);
            mcollectImageButton.setVisibility(View.VISIBLE);
            //隐藏楼主标志
            mlouzImageButton.setVisibility(View.GONE);
            //隐藏回复
            mreplyloTextView.setVisibility(View.GONE);
            //隐藏标题
            mreplytetleTextView.setVisibility(View.GONE);


            //这是写死头像

            handimageView.setImageResource(R.drawable.abcman);
            mforumTextView.setText(mList.get(position).getUserName());
            mtimeTextView.setText(mList.get(position).getDate().toString());
            mcontentTextView.setText(mList.get(position).getContent());
            mreplyImageView.setImageResource(R.drawable.test_forum2);
            mreplylouTextView.setText("第" + mList.get(position).getFloorNum() + "楼");
            mreplylouTextView.setVisibility(View.VISIBLE);
            //设置回复按钮可见
            mhuifuImageButton.setVisibility(View.VISIBLE);

        }else if (!mList.get(position).getNewFloor().equals("true")&&position!=mList.size()-1){
            //隐藏楼主标志
            mlouzImageButton.setVisibility(View.GONE);
            //隐藏楼层
            LinearLayout mnewlouLinearLayout= (LinearLayout) convertView.findViewById(R.id.forumreply_newlou);
            mnewlouLinearLayout.setVisibility(View.GONE);
            //显示布局
            //显示回复内容
            mreplyloTextView.setVisibility(View.VISIBLE);

            mreplyloTextView.setText(mList.get(position).getUserName()+" :"+mList.get(position).getContent()+" "+
                    mList.get(position).getDate().toString());


        }else if (position==mList.size()-1){
            //隐藏其他部分
            //隐藏楼层
            LinearLayout mnewlouLinearLayout= (LinearLayout) convertView.findViewById(R.id.forumreply_newlou);
            mnewlouLinearLayout.setVisibility(View.GONE);
            //显示暂无更多
            TextView mTextView= (TextView) convertView.findViewById(R.id.forum_mowei);
            mTextView.setVisibility(View.VISIBLE);

        }
//        mgetlist.getadapter(mreplylouListView);
        //设置item中用户头像、用户名的的监听事件
        handimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取被单击用户id查询出用户信息然后通过activity传值传递到demandmanactivity

                Intent intent=new Intent(context, DemandManActivity.class);
                context.startActivity(intent);

            }
        });
        mforumTextView.setOnClickListener(new View.OnClickListener() {
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
