package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.User;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by XCF on 2016/5/21.
 */
public class LoginActivity extends Activity {
    public static final String SAVE = "save";
    ImageView mImageView;
    TextView mTextView1, mTextView2;
    Button mButton;
    EditText mEditText1, mEditText2;
    CheckBox mCheckBox1, mCheckBox2;
    String phone, password;
    User user;
    SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_login);
        mImageView = (ImageView) findViewById(R.id.imageview);
        mTextView1 = (TextView) findViewById(R.id.textview1);
        mTextView2 = (TextView) findViewById(R.id.textview2);

        mEditText1 = (EditText) findViewById(R.id.edittext1);
        mEditText2 = (EditText) findViewById(R.id.edittext2);
        mCheckBox2 = (CheckBox) findViewById(R.id.checkbox1);

        mButton = (Button) findViewById(R.id.button);
        initData();
        initListeners();

    }

    private void initListeners() {
        mCheckBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //用户选择记住用户名和密码
                    if (mEditText1.equals(user.getPhone()) && mTextView2.equals(user.getPassword())){
                        //第一个参数：偏好设置文件的名称;第二个参数：文件访问模式
                        mSharedPreferences = getSharedPreferences(SAVE,MODE_PRIVATE);
                    }
                } else {
                    //用户取消记住用户名和密码
                }
            }
        });


        mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        mTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, PassWordActivity.class);
                startActivity(intent);
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(LoginActivity.this,"sfsg",Toast.LENGTH_SHORT).show();
                //用户单击了登录
                String phone = mEditText1.getText().toString();
                String password = mEditText2.getText().toString();
                //Toast.makeText(LoginActivity.this, phone + "-" + password, Toast.LENGTH_SHORT).show();
                //用post请求进行登录
                //POST请求
                //第一步：设置访问路径以及携带数据
                RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
                //RequestParams params=new RequestParams(mPath);
                params.addBodyParameter("req", "login");
                params.addBodyParameter("password", password);
                params.addBodyParameter("phone", phone);
                //第二步：开始请求，设置请求方式，同时实现回调函数
                x.http().post(params, new Callback.CommonCallback<String>() {

                    @Override
                    public void onSuccess(String result) {
                        // Log.e("zzia0", result);
                        //访问成功，参数其实就是PrintWriter写回的值
                        //把JSON格式的字符串改为Student对象
                        Gson gson = new Gson();
                        //Type type = new TypeToken<User>(){}.getType();
                        //解析一个对象跟解析集合不一样，比较简单

                        user = gson.fromJson(result, User.class);
                        // Log.e("zzia1", user.toString());
                        if (user != null) {
                            //Toast.makeText(LoginActivity.this, "获取了用户信息" + user.toString(), Toast.LENGTH_SHORT).show();
                            //拿到用户信息需要传值到用户界面
                            Bundle bundle = new Bundle();
                            //把对象放到bundle
                            bundle.putSerializable("pravite", user);
                            Intent intent = new Intent();
                            //把携带信息放到意图中
                            intent.putExtras(bundle);
                            intent.setClass(LoginActivity.this, PeopleCenterActivity.class);
                            startActivity(intent);

                        } else {
                            //登录失败：重新输入
                            //清空用户名和密码
                            mEditText1.setText("");
                            mEditText2.setText("");
                            //如何把光标移到用户名位置处（用户名输入框获取焦点）
                            mEditText1.requestFocus();
                            Toast.makeText(LoginActivity.this, "账号密码有误", Toast.LENGTH_SHORT).show();
                        }

                        //要把获取的user对象传递到用户界面进行显示


                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        ex.printStackTrace();

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                        Log.e("aa", "onCancelled");
                    }

                    @Override
                    public void onFinished() {


                        Log.e("aa", "onFinished");
                    }
                });
////
//                //POST请求
//                //第一步：设置访问路径以及携带数据
//        RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
////                RequestParams params=new RequestParams(mPath);
//                params.addBodyParameter("req","login");
//                params.addBodyParameter("password","123");
//                params.addBodyParameter("phone","123");
//                //第二步：开始请求，设置请求方式，同时实现回调函数
//                x.http().post(params, new Callback.CommonCallback<String>() {
//
//                    @Override
//                    public void onSuccess(String result) {
//                        Log.e("zzia0",result);
//                        //访问成功，参数其实就是PrintWriter写回的值
//                        //把JSON格式的字符串改为Student对象
//                        Gson gson = new Gson();
////                Type type = new TypeToken<User>(){}.getType();
//                        //解析一个对象跟解析集合不一样，比较简单
//
//                        user= gson.fromJson(result,User.class);
//                        Log.e("zzia1",user.toString());
//                        Toast.makeText(LoginActivity.this,user.toString(),Toast.LENGTH_SHORT).show();
//
//                        Intent intent = new Intent();
//                        intent.setClass(LoginActivity.this, PeopleCenterActivity.class);
//                        startActivity(intent);
//
//
//
//                    }
//                    @Override
//                    public void onError(Throwable ex, boolean isOnCallback) {
//                        ex.printStackTrace();
//
//                    }
//                    @Override
//                    public void onCancelled(CancelledException cex) {
//                        Log.e("aa","onCancelled");
//                    }
//                    @Override
//                    public void onFinished() {
//
//
//                        Log.e("aa","onFinished");
//                    }
//                });

            }
        });
    }

    private void initData() {
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


}
