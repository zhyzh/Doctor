package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Froum_userinfoAdapter;
import com.zhang.nong.doctor.com.java.beans.Zhutei;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

public class UserTeiActivity extends AppCompatActivity {
    //第一步找数据
    List<Zhutei> mZhuteis;
    String mPath;
    //第二步：找每行的视图
    //第三步：找适配器
    Froum_userinfoAdapter userinfoAdapter;
    ListView minfoListView;
    //用户id
    String id;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tei);
        initViews();
        initData();



    }

    private void initData() {
        //获取来自贴吧查询用户界面id或者是来自用户个人中心自己的id
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        if (bundle!=null){
            Log.e("usertei是否拿到userid","userid"+bundle.getSerializable("id"));
            id= bundle.getSerializable("id").toString();
            Log.e("usertei是否拿到userid","是的id是"+id);
        }

//        //初始化
//        userinfoAdapter=new Froum_userinfoAdapter(UserTeiActivity.this,mZhuteis);
//        minfoListView.setAdapter(userinfoAdapter);
        //获取数据
        //查询用户的贴子（从sum开始取10条）
        //根据id去查询用户信息
        //get请求
        //第一步：设置访问路径以及携带数据
//        RequestParams params = new RequestParams(mPath);
        RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
//        biaoname=user&req=demand&sum=1
        params.addQueryStringParameter("biaoname", "zhutei");
        params.addQueryStringParameter("req", "demand");
        params.addQueryStringParameter("id", id);
        params.addQueryStringParameter("sum", 0+"");
        //第二步：开始请求，设置请求方式，同时实现回调函数，这是异步操作
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //访问成功，参数其实就是PrintWriter写回的值
                //把JSON格式的字符串改为zhutei集合
                Gson gson = new Gson();
                //这是获取一个对象的解析二不是集合
                Type type = new TypeToken<List<Zhutei>>(){}.getType();
                mZhuteis = gson.fromJson(result,type);



//                show(mlist.toString());
                //应该放在获取数据的异步操作中
                //根据网路数据填充到相应的控件中
                Log.e("usertei获取了user的帖子","已经获取"+mZhuteis.toString());
                //初始化
                userinfoAdapter=new Froum_userinfoAdapter(UserTeiActivity.this,mZhuteis);
                minfoListView.setAdapter(userinfoAdapter);




            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //访问失败
                Log.e("fsd", "错误原因：user_teizhi" + ex.getMessage());

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

    private void initViews() {
        minfoListView= (ListView) findViewById(R.id.forum_UserInfolistview);


    }

    public void onback(View view) {
        //返回上一级
        onBackPressed();

    }
}
