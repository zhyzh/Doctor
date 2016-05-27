package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Froum_replyAdapter;
import com.zhang.nong.doctor.com.java.beans.Reply;
import com.zhang.nong.doctor.com.java.beans.User;
import com.zhang.nong.doctor.com.java.beans.Zhutei;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

public class DemandManActivity extends AppCompatActivity {
    //声明控件
    TextView musernameTextView,mteinumTextView,mcontentionnumTextView,mcolletnumTextView;
    LinearLayout mteiLinearLayout,mconLinearLayout,mcolectLinearLayout;
    //声明头像
    ImageView mmanImageView;
    User user;
    //用户id
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demand_man);
        //初始化控件
        initData();
//        //根据传递过来的用户id从服务器上获取网路数据
//        initman();
//        //根据网路数据填充到相应的控件中
//        initViews();


    }

    private void initViews() {
        musernameTextView.setText(user.getUserName());
        mteinumTextView.setText(user.getZhuteiNum());
        mcontentionnumTextView.setText(user.getAttentionNum());
        mcolletnumTextView.setText(user.getPrivatecollectNum());
        mmanImageView.setImageResource(R.drawable.abcman);



    }



    private void initData() {
        musernameTextView= (TextView) findViewById(R.id.forum_damuser);
        mteinumTextView= (TextView) findViewById(R.id.forum_teinum);
        mcontentionnumTextView= (TextView) findViewById(R.id.forum_contentionnum);
        mcolletnumTextView= (TextView) findViewById(R.id.forum_collectnum);
        mteiLinearLayout= (LinearLayout) findViewById(R.id.forum_usertei);
        mconLinearLayout= (LinearLayout) findViewById(R.id.forum_contentobjict);
        mcolectLinearLayout= (LinearLayout) findViewById(R.id.forum_collectobject);

        //头像
        mmanImageView= (ImageView) findViewById(R.id.image2);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        if (bundle!=null){
            Log.e("demand是否拿到userid","userid"+bundle.getSerializable("userid"));
            id= bundle.getSerializable("userid").toString();
            Log.e("demand是否拿到userid","是的id是"+id);
        }
        //根据id去查询用户信息
        //get请求
        //第一步：设置访问路径以及携带数据
//        RequestParams params = new RequestParams(mPath);
      RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
//        biaoname=user&req=demand&sum=1
        params.addQueryStringParameter("biaoname", "user");
        params.addQueryStringParameter("req", "demand");
        params.addQueryStringParameter("id", id);
        //第二步：开始请求，设置请求方式，同时实现回调函数，这是异步操作
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //访问成功，参数其实就是PrintWriter写回的值
                //把JSON格式的字符串改为Student对象
                Gson gson = new Gson();
                //这是获取一个对象的解析二不是集合
                Type type = new TypeToken<List<User>>() {
                }.getType();
                List<User> list = gson.fromJson(result, type);
                Log.e("demandlist用户的信息",list.toString());
//                user = gson.fromJson(result, User.class);
                user=list.get(0);

//                show(mlist.toString());
                //应该放在获取数据的异步操作中
                //根据网路数据填充到相应的控件中
                initViews();

                Log.e("demand获取了user","已经获取"+user.toString());



            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //访问失败
                Log.e("demandfsd", "错误原因：reply" + ex.getMessage());

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
    public void onclickDemand(View view){
        switch (view.getId()){
            case R.id.forum_usertei:
                Bundle bundle=new Bundle();
                bundle.putSerializable("id",id);
                Intent intent=new Intent(DemandManActivity.this,UserTeiActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

                break;
            case R.id.forum_contentobjict:
                //查询用户关注

                break;
            case (R.id.forum_collectobject):
                //查询用户收藏

                break;
        }
    }
}
