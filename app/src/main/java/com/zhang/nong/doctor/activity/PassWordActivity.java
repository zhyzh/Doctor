package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhang.nong.R;

import java.util.HashMap;
import java.util.Random;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class PassWordActivity extends Activity {

    EditText mEditText1, mEditText2, mEditText3, mEditText4, mEditText5;
    Button mButton1, mButton2;
    //短信验证
    String APPKEY = "1235b640f2252";
    String APPSECRET = "07cb1913babb2ebfe1d013c341a5ac88";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_password);

        SMSSDK.initSDK(this, APPKEY, APPSECRET, true);

        mEditText1 = (EditText) findViewById(R.id.edittext1);
        mEditText2 = (EditText) findViewById(R.id.edittext2);
        mEditText3 = (EditText) findViewById(R.id.edittext3);
        mEditText4 = (EditText) findViewById(R.id.edittext4);
        mEditText5 = (EditText) findViewById(R.id.edittext5);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        initListener();
    }

    private void initListener() {
       /* mEditText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (mEditText1.getText().toString().trim().length() < 4) {
                        Toast.makeText(PassWordActivity.this, "手机号码不能小于4个字符", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });*/
        mEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (mEditText2.getText().toString().trim().length() < 6) {
                        Toast.makeText(PassWordActivity.this, "密码不能小于8个字符", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (mEditText3.getText().toString().trim().length() < 6) {
                        Toast.makeText(PassWordActivity.this, "密码不能小于8个字符", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mEditText4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (!mEditText4.getText().toString().trim().equals(mEditText3.getText().toString().trim())) {
                        Toast.makeText(PassWordActivity.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
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
                });
                //5.验证成功，显示成功
                registerPage.show(PassWordActivity.this);

                mButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!checkEdit()) {
                            return;
                        }
                    }
                });
            }

            private boolean checkEdit() {
                if (mEditText1.getText().toString().trim().equals("")) {
                    Toast.makeText(PassWordActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                } else if (mEditText3.getText().toString().trim().equals("")) {
                    Toast.makeText(PassWordActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (!mEditText4.getText().toString().trim().equals(mEditText3.getText().toString().trim())) {
                    Toast.makeText(PassWordActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                } else {
                    return true;
                }
                return false;
            }


            public void back(View view) {
                finish();
            }

        });
    }

    public void submitUserInfo(String country, String phone) {
        Random r = new Random();
        String uid = Math.abs(r.nextInt()) + "";
        String nickName = "xcf";
        SMSSDK.submitUserInfo(uid, nickName, null, country, phone);
    }
}
