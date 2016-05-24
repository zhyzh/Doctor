package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.zhang.nong.MainActivity;
import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Froum_replyAdapter;
import com.zhang.nong.doctor.adapters.Froum_replyobjectAdapter;
import com.zhang.nong.doctor.com.java.beans.ForumMyData;
import com.zhang.nong.doctor.com.java.beans.Reply;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;


public class ForumReplyActivity extends AppCompatActivity  {
    //第一步：找数据
    List<Reply> mList,m2list;


    //第二步：找每行的视图
    //第三步：找适配器
    Froum_replyAdapter froum_replyAdapter;
    Froum_replyobjectAdapter froum_replyobjectAdapter;
    ListView mListView,m2ListView;
    //设置只看楼主的单击事件
    ImageButton mlouzhuImageButton;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_reply);
        initView();
        initData();
//        froum_replyAdapter=new Froum_replyAdapter(this,mList);
        //只看楼主的单击事件
        initLou();
        froum_replyAdapter=new Froum_replyAdapter(this,m2list);
        mListView.setAdapter(froum_replyAdapter);

//        froum_replyobjectAdapter=new Froum_replyobjectAdapter(this,m2list);
        //通过传值的方式








    }

    private void initLou() {
        mlouzhuImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2list.clear();
                for (int i=0;i<mList.size();i++) {
                    //这里的楼主id应该是reply界面的适配器的一楼传值过来的，这里先假设id为1
                    if (mList.get(i).getUserId()==1&&mList.get(i).getNewFloor().equals("true")){

                        m2list.add(mList.get(i));
                    }

                }
                froum_replyAdapter.notifyDataSetChanged();



            }
        });

    }

    private void initData() {
        mList=new ArrayList<>();
        m2list=new ArrayList<>();


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
        Reply test=new Reply(1,1,2,"2016-5-26","范德萨发斯sr蒂芬", "R.drawable.abcman","true",1,1,"true");
        Reply re=new  Reply(2,2,2,"2016-5-26","范德萨发斯f蒂芬", "R.drawable.abcman","true",1,1,"张三");
        Reply re1=new Reply(3,3,2,"2016-5-26","范德萨发ffds斯蒂芬", "R.drawable.abcman","false",1,1,"李四1");
        Reply re2=new Reply(4,4,2,"2016-5-26","范德萨发斯蒂芬", "R.drawable.abcman","false",2,1,"王五2");
        Reply re3=new Reply(5,1,2,"2016-5-26","范德萨发斯f蒂芬", "R.drawable.abcman","false",2,1,"赵六3");
        Reply re4=new Reply(6,2,3,"2016-5-26","范德萨发斯fsd蒂芬", "R.drawable.abcman","true",1,1,"张三");
        Reply re5=new Reply(7,3,3,"2016-5-26","范德萨发s斯蒂芬测试换范德萨发对方是否行是什么样的的方式付款了还是开发速度发货时看到了好看的开发建设可浪费时间的分类考试", "R.drawable.abcman","false",1,1,"李四24");
        Reply re6=new Reply(8,4,3,"2016-5-26","范德萨发斯f蒂芬", "R.drawable.abcman","false",2,1,"王五5");
        Reply re7=new Reply(9,1,3,"2016-5-26","范德萨发斯f蒂f芬", "R.drawable.abcman","false",2,1,"赵六6");
        Reply re8=new Reply(10,2,4,"2016-5-26","范德萨发斯f蒂芬", "R.drawable.abcman","true",1,1,"张三7");
        Reply re9=new Reply(11,3,4,"2016-5-26","范德萨发斯f蒂芬", "R.drawable.abcman","false",1,1,"李四8");
        Reply re10=new Reply(12,4,4,"2016-5-26","范德萨发斯f蒂芬", "R.drawable.abcman","flase",2,1,"王五9");
        Reply re11=new Reply(4,1,4,"2016-5-26","范德萨发af斯蒂芬", "R.drawable.abcman","false",2,1,"赵六10");
        //后面加一个长度用来显示刷新或者暂无更多
        Reply re13=new Reply(4,1,4,"2016-5-26","范德萨发af斯蒂芬", "R.drawable.abcman","false",2,1,"赵六10");
        Reply re12=new Reply(4,1,5,"2016-5-26","测试只看楼主", "R.drawable.abcman","true",2,1,"一个人的梦想ok");



//        mList.add(test);
        mList.add(re);
        mList.add(re1);
        mList.add(re2);
        mList.add(re3);
        mList.add(re4);
        mList.add(re5);
        mList.add(re6);
        mList.add(re7);
        mList.add(re8);
        mList.add(re9);
        mList.add(re10);
        mList.add(re11);
        //
        mList.add(re12);
        mList.add(re13);

        //加一条无用数据给1楼占位
        m2list.add(test);

        //这里需要对获取的数据进行排序先按楼层排序（楼层实际上都是按时间的先后输入的，只要到时候按时间的顺序进行排序查询就好）
        for (int i=2;i<=mList.size()+1;i++){
            for (int j=0;j<mList.size();j++) {
                if (mList.get(j).getFloorNum() == i) {
                    //按楼层的顺序把添加到集合2中，由于是按时间查询的所以这样排序已经可以了
                    m2list.add(mList.get(j));
                }
            }
        }






//        if (re.getNewFloor().equals("true")){
//            mList.add(re);
//        }else {
//            m2list.add(re);
//        }
//        if (re1.getNewFloor().equals("true")){
//            mList.add(re1);
//        }else {
//            m2list.add(re1);
//        }
//        if (re2.getNewFloor().equals("true")){
//            mList.add(re2);
//        }else {
//            m2list.add(re2);
//        }
//        if (re3.getNewFloor().equals("true")){
//            mList.add(re3);
//        }else {
//            m2list.add(re3);
//        }if (re4.getNewFloor().equals("true")){
//            mList.add(re4);
//        }else {
//            m2list.add(re4);
//        }
//        if (re5.getNewFloor().equals("true")){
//            mList.add(re5);
//        }else {
//            m2list.add(re5);
//        }
//        if (re6.getNewFloor().equals("true")){
//            mList.add(re6);
//        }else {
//            m2list.add(re6);
//        }
//        if (re7.getNewFloor().equals("true")){
//            mList.add(re7);
//        }else {
//            m2list.add(re7);
//        }
//        if (re8.getNewFloor().equals("true")){
//            mList.add(re8);
//        }else {
//            m2list.add(re8);
//        }if (re9.getNewFloor().equals("true")){
//            mList.add(re9);
//        }else {
//            m2list.add(re9);
//        }if (re10.getNewFloor().equals("true")){
//            mList.add(re10);
//        }else {
//            m2list.add(re10);
//        }if (re11.getNewFloor().equals("true")){
//            mList.add(re11);
//        }else {
//            m2list.add(re11);
//        }






    }

    private void initView() {
        //这是1楼二楼三楼
        mListView= (ListView) findViewById(R.id.forum_reply_listview);
        mlouzhuImageButton= (ImageButton) findViewById(R.id.forum_louzhu);


    }


//    @Override
//    public void getadapter(ListView view) {
//
//        //这是回复楼层的
//        m2ListView=view;
//        m2ListView.setAdapter(froum_replyobjectAdapter);
////        m2ListView.setAdapter(froum_replyAdapter);
//    }
}
