package com.zhang.nong.doctor.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zhang.nong.R;
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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView =inflater.inflate(R.layout.forum_tei,null);

        mListView= (ListView) mView.findViewById(R.id.forum_listview);
        initData();
        froumAdapter=new FroumAdapter(getActivity(),mlist);
        mListView.setAdapter(froumAdapter);

        return mView;



    }
    //贴吧数据

    private void initData() {
        mlist =new ArrayList<>();
        //int manimage, String username, int zansum, int huisum, String fatime, String title, String content, int pic1, int pic2, int pic3
       //先获取置顶部分的内容
        ForumMyData fordata1=new ForumMyData(R.drawable.abcman,"一个人的梦想ok","35","7451","三小时前","大家聊聊自己的爱好","为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图",
                R.drawable.text_forum, R.drawable.test_forum2, R.drawable.text_forumtow,true
                );
        ForumMyData fordata2=new ForumMyData(R.drawable.abcman,"一个人的梦想ok","35","7451","三小时前","测试置顶贴","为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图",
                R.drawable.text_forum, R.drawable.test_forum2, R.drawable.text_forumtow,true
        );
       //再获取非置顶部分的内容
        ForumMyData fordata3=new ForumMyData(R.drawable.abcman,"一个人的梦想ok","30","7451","三小时前","虎吧升级专贴三","为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图",
                R.drawable.text_forum, R.drawable.test_forum2, R.drawable.text_forumtow,false
        );
        ForumMyData fordata4=new ForumMyData(R.drawable.abcman,"一个人的梦想ok","60","79","三小时前","虎吧升级专贴三","为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图",
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

    }
}
