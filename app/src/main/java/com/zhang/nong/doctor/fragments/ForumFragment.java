package com.zhang.nong.doctor.fragments;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.nong.R;
import com.zhang.nong.doctor.MyService.ReqService;
import com.zhang.nong.doctor.activity.ActivityNews;

import com.zhang.nong.doctor.activity.ForumnewteiActivity;
import com.zhang.nong.doctor.adapters.FroumAdapter;
import com.zhang.nong.doctor.com.java.beans.Zhutei;
import com.zhang.nong.doctor.httpXutils.MyApplication;
import com.zhang.nong.doctor.httpXutils.ReplyDemand;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by XCF on 2016/5/12.
 */
public class ForumFragment extends Fragment {
    //第一步：找数据
    List<Zhutei> mlist;
    //第二步：找每行的视图
    //第三步：确定适配器
    FroumAdapter froumAdapter;
    ListView mListView;
    View mView;

    //发帖按钮s
    ImageButton mwriteImageButton;
    //消息的按钮
    ImageButton mnewsImageButton;
    //对搜索框文字改变的监听
    EditText mseachEditText;
    //搜索图标
    ImageView mseachImageView;
    //刷新图标
    ImageButton mrefleshImageButton;
    //设置一个用来模拟刷新的标志位
    boolean refleshma = false;
    //声明一个链接网络工具类
    ReplyDemand replydemand;
    String mPath;
    Intent intent;
    ReqService.MyBinder mBinder;
    //
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            //一个回调方法，一旦service中onBind方法返回了结果，就回调次方法，第二个service就是是onBind方法的返回值
            mBinder = (ReqService.MyBinder) service;
            //通过MyBinder内部类中的共有方法获取服务的一个对象，进而可以获取服务的属性和方法
            ReqService myService = mBinder.getMyService();
            //获取帖子数据
            mlist = myService.getTeizhi();
            Log.e("mlist服务的", "是" + mlist);
//            show(myService.getservice());


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //意外情况发生，导致服务突然中断，回调的方法，例如服务抛出异常，或者系统杀死服务进程

        }
    };


    //回调：简单的观察者模式
    public interface ListItemClick {
        public abstract void setOnListItemClickListener(String text);
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.forum_tei, null);
        initViews();

        //跳转到发帖的监听事件
        intiWrite();
        //跳转到消息的监听
        initNews();
        //搜索框的监听
        initEfditext();
        //刷新按钮的单击事件
        initRelesh();


        mListView = (ListView) mView.findViewById(R.id.forum_listview);
        initData();
//        //应该放在获取数据的异步操作中
//        froumAdapter = new FroumAdapter(getActivity(), mlist, mListView);
//        mListView.setAdapter(froumAdapter);
        //查看帖子的监听事件


        return mView;


    }

    private void initRelesh() {
        mrefleshImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //假设刷新时候添加了几条数据
                mlist.clear();
                //重新重网路获取数据，这里还是只能模拟
                refleshma = true;
                initData();
                //刷新布局
                froumAdapter.notifyDataSetChanged();


            }
        });

    }

    //初始化控件
    private void initViews() {
        //初始化帖子集合

        mlist = new ArrayList<>();
        //控件
        mwriteImageButton = (ImageButton) mView.findViewById(R.id.forum_writetei);
        mnewsImageButton = (ImageButton) mView.findViewById(R.id.forum_fragmentteinews);
        mseachEditText = (EditText) mView.findViewById(R.id.searchforumedittext);
        mseachImageView = (ImageView) mView.findViewById(R.id.forumsearch_ima);
        //初始化刷新按钮
        mrefleshImageButton = (ImageButton) mView.findViewById(R.id.forum_reflesh);
        //初始化获取网络数据类的对象
        replydemand = new ReplyDemand();


    }

    private void initEfditext() {
        //这是文本改变监听
        mseachEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //这是获取焦点监听
        mseachEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //获取焦点是设置搜索图标为隐藏
                if (mseachEditText.isFocused()) {
                    mseachImageView.setVisibility(View.GONE);
                } else {
                    //失去焦点就显示
                    mseachEditText.setVisibility(View.VISIBLE);
                }

            }
        });

    }


    private void initNews() {
        mnewsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityNews.class);
                startActivity(intent);
            }
        });

    }


    //查看帖子的监听事件
    private void intiWrite() {
        mwriteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到写帖子的布局
                Intent intent = new Intent(getActivity(), ForumnewteiActivity.class);
                startActivity(intent);
            }
        });

    }
    //贴吧数据


    private void initData() {
        //这里极易包类型转换异常
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        mPath = myApplication.getUrl();

        //用star方法启动的服务只能通过广播传值

//        //启动一个服务（不是绑定服务）在通过启动一个子线程获取数据
//        intent = new Intent(getActivity(), ReqService.class);
//
//
//        //通过服务中的一个内部类进行获取数据
//        getActivity().startService(intent);
//        show("启动了服务");
        //绑定服务：第一个参数，意图，第二个参数，用于获取服务返回值IBinder对象，通过此对象，不能为null
        //第三个是个标志位，一般用Service.BIND_AUTO_CREATE,用途是服务没有创建时自动创建服务
        intent = new Intent(getActivity(), ReqService.class);
        getActivity().bindService(intent, conn, Service.BIND_AUTO_CREATE);


//        List<Zhutei> list;
////        list=replydemand.getTeizhi("1",mPath);
////        show(list.toString());

        //get请求
        //第一步：设置访问路径以及携带数据
        RequestParams params = new RequestParams(mPath);
//      RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
//        biaoname=user&req=demand&sum=1
        params.addQueryStringParameter("biaoname", "zhutei");
        params.addQueryStringParameter("req", "demand");
        params.addQueryStringParameter("sum", "1");
        //第二步：开始请求，设置请求方式，同时实现回调函数，这是异步操作
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //访问成功，参数其实就是PrintWriter写回的值
                //把JSON格式的字符串改为Student对象
                Gson gson = new Gson();
                Type type = new TypeToken<List<Zhutei>>() {
                }.getType();
                mlist = gson.fromJson(result, type);
//                show(mlist.toString());
                //应该放在获取数据的异步操作中
                froumAdapter = new FroumAdapter(getActivity(), mlist, mListView);
                mListView.setAdapter(froumAdapter);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //访问失败
                Log.e("fsd", "zhutei错误原因：" + ex.getMessage());
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

    public void show(String te) {
        Toast.makeText(getActivity(), te, Toast.LENGTH_LONG).show();
    }
}
