package com.zhang.nong.doctor.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Froum_replyobjectAdapter;
import com.zhang.nong.doctor.com.java.beans.ForumMyData;
import com.zhang.nong.doctor.com.java.beans.Reply;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/23 0023.
 */
public class Forum_fragmentreply extends Fragment {
    //第一步：找数据
    List<Reply> mList;
    //第二步：找每一行的视图
    //第三步：确定适配器
    Froum_replyobjectAdapter replyobjectAdapter;
    ListView mListView;
    View mView;
    //回复的按钮
    ImageButton mImageButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.forum_fragmentreply,null);
        mListView= (ListView) mView.findViewById(R.id.forum_fragmaentlistview);
        initData();
        replyobjectAdapter=new Froum_replyobjectAdapter(getActivity(),mList);
        mListView.setAdapter(replyobjectAdapter);
        return mView;

    }

    private void initData() {
        mList=new ArrayList<>();
        /** 本表id **/
        /** 用户的id **/
        /** 几楼 **/
        /** 回复间（time） **/
        /** 内容 **/
        /** 回复人的头像Integer.parseInt("R.drawable.abcman") **/
        /** 是否是新楼 **/
        /** 回复对象 **/
        /** 帖子id **/
        /** 回复者的姓名 **/
        ForumMyData fordata1=new ForumMyData(R.drawable.abcman,"一个人的梦想ok","35","7451","三小时前","大家聊聊自己的爱好","为了吧友升级，专开水经验贴，其他无任何大师们的精华缩写或者截图",
                R.drawable.text_forum, R.drawable.test_forum2, R.drawable.text_forumtow,true
        );

        //这里查询到的是回复于用户id是1的回复，
        Reply re=new  Reply(1,2,2,"2016-5-26","范德萨发斯f蒂芬", "R.drawable.abcman","true",1,1,"张三");

        Reply re1=new Reply(1,2,3,"2016-5-26","范德萨发斯fsd蒂芬", "R.drawable.abcman","true",1,1,"张三");

        Reply re2=new Reply(1,2,4,"2016-5-26","范德萨发斯f蒂芬", "R.drawable.abcman","true",1,1,"张三7");

        mList.add(re);
        mList.add(re1);
        mList.add(re2);


    }
}
