package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.nong.MainActivity;
import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.User;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

public class ForumnewteiActivity extends AppCompatActivity {
    //发帖的布局
    //声明控件
    EditText mtitleEditText,mcontentEditText;
    //假设我已经拿到了userid，用户名
    String id,username;
    //标题。内容
    String title,content;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_newtei);
        initData();

    }

    private void initData() {
        mtitleEditText= (EditText) findViewById(R.id.forum_newteititle);
        mcontentEditText= (EditText) findViewById(R.id.forum_newcontent);
        //假设我已经拿到了userid，用户名
        id="2";
        username="张三";

    }

    public void onbak(View view) {
        onBackPressed();
    }



    public void newsTei(View view) {
        //单击发帖的时候我们需要判断用户是否有发帖的权限（是否登录），再判断内容是否为空
        title=mtitleEditText.getText().toString();
        content=mcontentEditText.getText().toString();
        if (title==null&&content!=null){
            //标题是空提示标题不能为空
            show("标题不能为空");

        }else if (content==null&&title!=null){
            //内容为空提示内容不能为空
            show("内容不能为空");

        }else if (title==null&&content==null){
            //都是空，提示标题、内容不能为空
            show("标题、内容不能为空");


        }else {
            //如果用户是登录状态（就的username，id不等于空），并且标题、内容不是空就开始发帖
            if (username!=null&&id!=null){
                //准备发帖
                //get请求
                //第一步：设置访问路径以及携带数据
//                RequestParams params=new RequestParams(mPath);http://10.201.1.254:8080/nongboshi_web_001
                RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
//                RequestParams params = new RequestParams("http://10.201.1.254:8080/nongboshi_web_001/testServlet");
                //biaoname=user&req=demand&sum=1
                params.addQueryStringParameter("biaoname","zhutei");
                params.addQueryStringParameter("req","add");
                //a是用户的id，b是用户名、c是标题，d是内容，e是用户位置信息（f是图片、要操作图片表）
                params.addQueryStringParameter("a",id);
                params.addQueryStringParameter("b",username);
                params.addQueryStringParameter("c",title);
                params.addQueryStringParameter("d",content);
                params.addQueryStringParameter("e","苏州");

                //第二步：开始请求，设置请求方式，同时实现回调函数
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        //访问成功，参数其实就是PrintWriter写回的值
                        //把JSON格式的字符串改为Student对象
                        //说明发帖成功，提示成功(以后可以做一个好一点的提示框)并且跳转到帖子的界面
                        show("发帖成功");
                        Intent intent=new Intent(ForumnewteiActivity.this, MainActivity.class);





                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        //访问失败
                        Log.e("发帖错误","错误原因：" + ex.getMessage() );
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                        //访问取消
                        Log.e("发帖错误","错误原因：" +"onCancelled");
                    }

                    @Override
                    public void onFinished() {
                        //访问完成
                        Log.e("发帖错误","错误原因：" + "onFinished" );
                    }
                });

            }

        }

    }

    private void show(String text) {
        Toast.makeText(ForumnewteiActivity.this,text,Toast.LENGTH_LONG).show();
    }
}
