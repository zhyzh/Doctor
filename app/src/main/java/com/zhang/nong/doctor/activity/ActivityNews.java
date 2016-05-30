package com.zhang.nong.doctor.activity;






import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Froum_newsAdapter;

import com.zhang.nong.doctor.fragments.Forum_fragmentnews;
import com.zhang.nong.doctor.fragments.Forum_fragmentreply;


public class ActivityNews extends AppCompatActivity {

    //声明顶部导航的两个布局

    //声明两个布局的按钮
    Button mNewsButton,mReplyButton;
    //声明两个碎片对象

   FragmentManager mfragmentManager;
    FragmentTransaction mFragmentTransaction;

    List<Fragment> mList;
    ViewPager mViewPager;
    Froum_newsAdapter newsAdapter;
    Forum_fragmentnews newsLayout;
    Forum_fragmentreply replyLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_activity_activity_news);

        initViews();


        initData();
        initDefault();

    }




    private void initDefault() {
    }

    private void initData() {
        mList=new ArrayList<>();

        newsLayout=new Forum_fragmentnews();
        replyLayout=new Forum_fragmentreply();


        mList.add(newsLayout);
        mList.add(replyLayout);
        //初始化适配器
        mfragmentManager=getSupportFragmentManager();
        newsAdapter=new Froum_newsAdapter(mfragmentManager,mList);
       mViewPager.setAdapter(newsAdapter);




    }





    private void initViews() {
        mViewPager= (ViewPager) findViewById(R.id.forum_viewnewspager);

    }

    public void onclick(View view) {
        switch (view.getId()){
            case R.id.forum_fragmadnnews:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.forum_fragmanreply:
                mViewPager.setCurrentItem(1);
                break;

        }
    }

    public void onback(View view) {
        onBackPressed();
    }
}
