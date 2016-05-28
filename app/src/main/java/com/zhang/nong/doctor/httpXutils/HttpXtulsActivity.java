package com.zhang.nong.doctor.httpXutils;


import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.User;

import java.lang.reflect.Type;





import org.apache.http.client.HttpClient;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


import java.lang.reflect.TypeVariable;
import java.util.List;


public class HttpXtulsActivity extends AppCompatActivity {
    private static final String TAG = "XUTILS";

    private TextView tv;
    private HttpClient client;
    String mPath;
    User user;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.httpxutils);
        initData();
        initView();

    }

    private void initView() {
        tv= (TextView) findViewById(R.id.tv);
    }

    private void initData() {
//        MyApplication myApplication= (MyApplication) getApplication();
        //这里极易包类型转换异常
        MyApplication myApplication= (MyApplication) getApplication();
        mPath=myApplication.getUrl();
    }


  public  void getTest(View view){
      //get请求
      //第一步：设置访问路径以及携带数据
      RequestParams params=new RequestParams(mPath);
//      RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
      //biaoname=user&req=demand&sum=1
      params.addQueryStringParameter("biaoname","user");
      params.addQueryStringParameter("req","demand");
      params.addQueryStringParameter("sum","1");
      //第二步：开始请求，设置请求方式，同时实现回调函数
      x.http().get(params, new Callback.CommonCallback<String>() {
          @Override
          public void onSuccess(String result) {
              //访问成功，参数其实就是PrintWriter写回的值
              //把JSON格式的字符串改为Student对象
              Gson gson = new Gson();
              Type type = new TypeToken<List<User>>(){}.getType();
              List<User> list  = gson.fromJson(result,type);

              tv.setText(list.toString());
          }

          @Override
          public void onError(Throwable ex, boolean isOnCallback) {
              //访问失败
              Log.e(TAG,"错误原因：" + ex.getMessage() );
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
    public void postTest(View view) {

        //POST请求
        //第一步：设置访问路径以及携带数据
//        RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
        RequestParams params=new RequestParams(mPath);
        params.addBodyParameter("req","login");
        params.addBodyParameter("password","123");
        params.addBodyParameter("phone","123");
        //第二步：开始请求，设置请求方式，同时实现回调函数
        x.http().post(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Log.e("zzia0",result);
                //访问成功，参数其实就是PrintWriter写回的值
                //把JSON格式的字符串改为Student对象
                Gson gson = new Gson();
//                Type type = new TypeToken<User>(){}.getType();
                //解析一个对象跟解析集合不一样，比较简单

                user= gson.fromJson(result,User.class);
                Log.e("zzia1",user.toString());
                tv.setText(user.toString());



            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();

            }
            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("aa","onCancelled");
            }
            @Override
                public void onFinished() {


                Log.e("aa","onFinished");
            }
        });
    }
}
