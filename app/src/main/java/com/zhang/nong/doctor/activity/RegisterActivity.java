package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.zhang.nong.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by XCF on 2016/5/21.
 */
public class RegisterActivity extends Activity {

    EditText mEditText1, mEditText2, mEditText3, mEditText4;
    Button mButton1, mButton2;
    //短信验证
    String APPKEY = "1235b640f2252";
    String APPSECRET = "07cb1913babb2ebfe1d013c341a5ac88";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_register);

        SMSSDK.initSDK(this, APPKEY, APPSECRET, true);

        mEditText1 = (EditText) findViewById(R.id.edittext1);
        mEditText2 = (EditText) findViewById(R.id.edittext2);
        mEditText3 = (EditText) findViewById(R.id.edittext3);
        mEditText4 = (EditText) findViewById(R.id.edittext4);

        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);

        initListeners();

    }

    private void initListeners() {
        mEditText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (mEditText1.getText().toString().trim().length() < 4) {
                        Toast.makeText(RegisterActivity.this, "用户名不能小于4个字符", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (mEditText2.getText().toString().trim().length() < 6) {
                        Toast.makeText(RegisterActivity.this, "密码不能小于8个字符", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mEditText3.getText().toString().trim().equals(mEditText2.getText().toString().trim())) {
                        Toast.makeText(RegisterActivity.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterPage registerPage = new RegisterPage();
                registerPage.setRegisterCallback(new EventHandler() {
                    @Override
                    public void afterEvent(int event, int result, Object data) {
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            HashMap<String, Object> maps = (HashMap<String, Object>) data;
                            String country = (String) maps.get("country");
                            String phone = (String) maps.get("phone");
                            submitUserInfo(country, phone);

                        }
                    }


                });//5.验证成功，显示成功
                registerPage.show(RegisterActivity.this);


                mButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!checkEdit()) {
                            return;
                        }
                        String httpUrl = "http://shenwenjie.top/testServlet";
                        HttpPost httpRequest = new HttpPost(httpUrl);
                        List<NameValuePair> params = new ArrayList<NameValuePair>();
                        params.add(new BasicNameValuePair("username", mEditText1.getText().toString().trim()));
                        params.add(new BasicNameValuePair("password", mEditText2.getText().toString().trim()));

                        HttpEntity httpEntity = null;
                        try {
                            httpEntity = new UrlEncodedFormEntity(params, "utf8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        httpRequest.setEntity(httpEntity);
                        HttpClient httpClient = new DefaultHttpClient();
                        HttpResponse httpResponse = null;
                        try {
                            httpResponse = httpClient.execute(httpRequest);
                        } catch (ClientProtocolException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (httpResponse.getStatusLine().getStatusCode() == 200){
                            String strResult = null;
                            try {
                                strResult = EntityUtils.toString(httpResponse.getEntity());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(RegisterActivity.this, strResult, Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RegisterActivity.this, "请求错误", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }

            private boolean checkEdit() {
                if (mEditText1.getText().toString().trim().equals("")) {
                    Toast.makeText(RegisterActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                } else if (mEditText2.getText().toString().trim().equals("")) {
                    Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (!mEditText3.getText().toString().trim().equals(mEditText2.getText().toString().trim())) {
                    Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                } else {
                    return true;
                }
                return false;
            }
        });
    }

    public void back(View view) {
        finish();
    }

    public void submitUserInfo(String country, String phone) {
        Random r = new Random();
        String uid = Math.abs(r.nextInt()) + "";
        String nickName = "xcf";
        SMSSDK.submitUserInfo(uid, nickName, null, country, phone);
    }


}