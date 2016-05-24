package com.zhang.nong.doctor.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhang.nong.MainActivity;
import com.zhang.nong.R;
import com.zhang.nong.doctor.activity.ActivityNews;
import com.zhang.nong.doctor.activity.DemandManActivity;
import com.zhang.nong.doctor.activity.ForumReplyActivity;
import com.zhang.nong.doctor.activity.ForumnewteiActivity;
import com.zhang.nong.doctor.adapters.FroumAdapter;
import com.zhang.nong.doctor.com.java.beans.ForumMyData;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by XCF on 2016/5/12.
 */
public class ForumFragment extends Fragment {
    //第一步：找数据
    List<ForumMyData> mlist;
    //第二步：找每行的视图
    //第三步：确定适配器
    FroumAdapter froumAdapter;
    ListView mListView;
    View mView;

    //发帖按钮s
    ImageButton mwriteImageButton;
    //消息的按钮
    ImageButton mnewsImageButton;


    //回调：简单的观察者模式
    public interface  ListItemClick{
        public  abstract  void setOnListItemClickListener(String text);
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView =inflater.inflate(R.layout.forum_tei,null);
        mwriteImageButton= (ImageButton) mView.findViewById(R.id.forum_writetei);
        mnewsImageButton= (ImageButton) mView.findViewById(R.id.forum_fragmentteinews);
        //跳转到发帖的监听事件
        intiWrite();
        //跳转到消息的监听
        initNews();




        mListView= (ListView) mView.findViewById(R.id.forum_listview);
        initData();
        froumAdapter=new FroumAdapter(getActivity(),mlist);
        mListView.setAdapter(froumAdapter);
        //查看帖子的监听事件
        initReply();



        return mView;





    }



    private void initNews() {
        mnewsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ActivityNews.class);
                startActivity(intent);
            }
        });

    }

    //查看帖子的监听事件
    private void initReply() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //
                Intent intent=new Intent(getActivity(),ForumReplyActivity.class);
                startActivity(intent);
//                startActivityForResult(intent,1);

            }
        });

    }

    //查看帖子的监听事件
    private void intiWrite() {
        mwriteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到写帖子的布局
                Intent intent=new Intent(getActivity(), ForumnewteiActivity.class);
                startActivity(intent);
            }
        });

    }
    //贴吧数据


    private void initData() {
        mlist =new ArrayList<>();
        //int manimage, String username, int zansum, int huisum, String fatime, String title, String content, int pic1, int pic2, int pic3
       //先获取置顶部分的内容
        ForumMyData fordata1=new ForumMyData(R.drawable.abcman,"一个人的f梦想ok","35","7451","三小时前","大家聊聊自己的爱好","为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图",
                R.drawable.text_forum, R.drawable.test_forum2, R.drawable.text_forumtow,true
                );
        ForumMyData fordata2=new ForumMyData(R.drawable.abcman,"一个人的f梦想ok","35","7451","三小时前","测试置顶贴","为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图",
                R.drawable.text_forum, R.drawable.test_forum2, R.drawable.text_forumtow,true
        );
       //再获取非置顶部分的内容
        ForumMyData fordata3=new ForumMyData(R.drawable.abcman,"一个人的fs梦想ok","30","7451","三小时前","虎吧升级专贴三","为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图",
                R.drawable.text_forum, R.drawable.test_forum2, R.drawable.text_forumtow,false
        );
        ForumMyData fordata4=new ForumMyData(R.drawable.abcman,"一个人的f梦想ok","60","79","三小时前","虎吧升级专贴三","为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图",
                R.drawable.text_forum, R.drawable.test_forum2, R.drawable.text_forumtow,false
        );
        ForumMyData fordata5=new ForumMyData(R.drawable.abcman,"一个人的梦想ok","35","61","三小时前","虎吧升级专贴三","为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图",
                R.drawable.text_forum, R.drawable.test_forum2, R.drawable.text_forumtow,false
        );


        mlist.add(fordata1);
        mlist.add(fordata2);
        mlist.add(fordata3);
        mlist.add(fordata4);
        mlist.add(fordata5);
        mlist.add(fordata4);

    }



}
