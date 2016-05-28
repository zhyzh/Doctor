package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.User;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class TestActivity extends Activity {
    String phone, password;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onclick(View view) {
        //POST请求
        //第一步：设置访问路径以及携带数据
        RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
//                RequestParams params=new RequestParams(mPath);
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
                TextView mTextView= (TextView) findViewById(R.id.texttext);
                mTextView.setText("获取的登录信息"+user.toString());




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
