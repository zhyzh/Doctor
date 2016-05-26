package com.zhang.nong.doctor.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.nong.MainActivity;
import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.FroumAdapter;
import com.zhang.nong.doctor.adapters.Froum_replyAdapter;
import com.zhang.nong.doctor.adapters.Froum_replyobjectAdapter;
import com.zhang.nong.doctor.com.java.beans.ForumMyData;
import com.zhang.nong.doctor.com.java.beans.Reply;
import com.zhang.nong.doctor.com.java.beans.Zhutei;
import com.zhang.nong.doctor.httpXutils.MyApplication;

import org.w3c.dom.Text;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;


public class ForumReplyActivity extends AppCompatActivity implements Froum_replyAdapter.Mgetlist {
    //第一步：找数据
    List<Reply> mList, m2list;
    String mPath;
    Reply test = null;


    //第二步：找每行的视图
    //第三步：找适配器
    Froum_replyAdapter froum_replyAdapter;
    Froum_replyobjectAdapter froum_replyobjectAdapter;
    ListView mListView, m2ListView;
    //设置只看楼主的单击事件
    ImageButton mlouzhuImageButton;
    //设置只看楼主的标志位、收藏的标志位（到网络获取数据后可以用获取数据时是否收藏该对象来决定这个标志位这里先默认是false）
    boolean louzhu = false, shoucang = false;
    //声明一个回复、收藏的按钮
    ImageButton mImageButton, mshoucangImageButton;
    //声明回复框
    EditText mEditText;
    Zhutei zhutei;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_reply);
        //接收zhutei传递过来的zhutei对象
        Intent intent = getIntent();
        //获取intent携带的bundle
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            //第一个参数：建值名称，第二个参数：找不到建值时使用默认值
//            String username=bundle.getString("name","找不到此建值");这是传递参数的时候
            zhutei = (Zhutei) bundle.getSerializable("zhutei");

        }

        initView();
        initData();
//        froum_replyAdapter=new Froum_replyAdapter(this,mList);
        //只看楼主的单击事件
        initLou();
          //这需要到网络异步中初始化
//        froum_replyAdapter = new Froum_replyAdapter(this, m2list, zhutei);
//        mListView.setAdapter(froum_replyAdapter);
        //mlistview的单击事件监听
        initListview();

//        froum_replyobjectAdapter=new Froum_replyobjectAdapter(this,m2list);
        //通过传值的方式


    }

    private void initListview() {
        //listview的监听事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //要适配器中的对象reply，而这个对象来自本activity
                //如果不是新楼就弹出键盘、设置部分内容、获取焦点、
                if (!m2list.get(position).getNewFloor().equals("true")) {

                    //获 取焦点还要弹出键盘
                    InputMethodManager m = (InputMethodManager) mEditText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    mEditText.setText("回复  " + m2list.get(position).getUserName() + "  :");
                    //把选择的光标放到内容的最后边
                    String text = "回复  " + m2list.get(position).getUserName() + "  :";
                    mEditText.setSelection(text.length());
                    //设置mEditText获取焦点
                    mEditText.requestFocus();

                }

            }
        });
    }

    private void initHuifu() {
        //这里可以使用m2list获取他的回复对象，但是需要传postion
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置mEditText获取焦点
                mEditText.requestFocus();
                //获 取焦点还要弹出键盘
                InputMethodManager m = (InputMethodManager) mEditText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

            }
        });
    }
    //这里是只看楼主的单击事件

    private void initLou() {
        mlouzhuImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!louzhu) {
                    m2list.clear();

                    //加一条无用数据给1楼占位

                    m2list.add(test);
                    for (int i = 0; i < mList.size(); i++) {
                        //这里的楼主id应该是reply界面的适配器的一楼传值过来的，这里先假设id为1
                        if (mList.get(i).getUserId() == 1 && mList.get(i).getNewFloor().equals("true")) {

                            m2list.add(mList.get(i));
                        }

                    }
                    froum_replyAdapter.notifyDataSetChanged();
                    louzhu = true;

                } else {
                    m2list.clear();
                    //加一条无用数据给1楼占位

                    m2list.add(test);

                    froum_replyAdapter.notifyDataSetChanged();
                    louzhu = false;

                }


            }
        });

    }

    private void initData() {
        //这里极易包类型转换异常
        MyApplication myApplication = (MyApplication) getApplication();
        mPath = myApplication.getUrl();

        mList = new ArrayList<>();
        m2list = new ArrayList<>();


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

        test = new Reply(1, 1, 1, "2016-5-26", "范德萨发斯sr蒂芬", "R.drawable.abcman", "true", 1, 1, "true");


        //加一条无用数据给1楼占位
        m2list.add(test);
        //访问网络获取数据
        //get请求
        //第一步：设置访问路径以及携带数据
        RequestParams params = new RequestParams(mPath);
//      RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
//        biaoname=user&req=demand&sum=1
        params.addQueryStringParameter("biaoname", "reply");
        params.addQueryStringParameter("req", "demand");
        params.addQueryStringParameter("sum", "1");
        //第二步：开始请求，设置请求方式，同时实现回调函数，这是异步操作
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //访问成功，参数其实就是PrintWriter写回的值
                //把JSON格式的字符串改为Student对象
                Gson gson = new Gson();
                Type type = new TypeToken<List<Reply>>() {
                }.getType();
                mList = gson.fromJson(result, type);
                m2list.addAll(mList);
//                show(mlist.toString());
                //应该放在获取数据的异步操作中
                froum_replyAdapter = new Froum_replyAdapter(ForumReplyActivity.this, m2list, zhutei);
                mListView.setAdapter(froum_replyAdapter);
                Log.e("获取了reply","已经获取"+m2list.toString());



            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //访问失败
                Log.e("fsd", "错误原因：reply" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                //访问取消
            }

            @Override
            public void onFinished() {
                //访问完成
            }
        });


    }


    private void initView() {
        //这是1楼二楼三楼
        mListView = (ListView) findViewById(R.id.forum_reply_listview);
        mlouzhuImageButton = (ImageButton) findViewById(R.id.forum_louzhu);
        mEditText = (EditText) findViewById(R.id.edittext_forumhuifu);


    }

    public void onback(View view) {
        //单击返回之前的界面
        onBackPressed();
    }

    @Override
    public void getadapter(ImageButton imageButton) {
        //获取传递出来的控件
        mImageButton = imageButton;
        //必须放在这里才能保证不会在创建布局的时候报空
        //回复按钮的单击事件
        initHuifu();

    }

    @Override
    public void getshoucang(ImageButton imageButton) {
        //获取回调来的控件
        mshoucangImageButton = imageButton;
        //必须放在这里才能保证不会在创建布局的时候报空
        //收藏按钮的单击事件
        initShoucang();

    }

    //收藏按钮的单击事件
    private void initShoucang() {
        mshoucangImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!shoucang) {
                    show("收藏成功");
                    shoucang = true;
                } else {
                    show("取消收藏");
                    shoucang = false;
                }

            }
        });
    }

    private void show(String text) {
        Toast.makeText(ForumReplyActivity.this, text, Toast.LENGTH_LONG).show();
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
