package com.zhang.nong.doctor.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.com.java.beans.User;

public class DemandManActivity extends AppCompatActivity {
    //声明控件
    TextView musernameTextView,mteinumTextView,mcontentionnumTextView,mcolletnumTextView;
    //声明头像
    ImageView mmanImageView;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demand_man);
        //初始化控件
        initData();
        //根据传递过来的用户id从服务器上获取网路数据
        initman();
        //根据网路数据填充到相应的控件中
        initViews();

    }

    private void initViews() {
        musernameTextView.setText(user.getUserName());
        mteinumTextView.setText(user.getZhuteiNum());
        mcontentionnumTextView.setText(user.getAttentionNum());
        mcolletnumTextView.setText(user.getPrivatecollectNum());
        mmanImageView.setImageResource(R.drawable.abcman);


    }

    private void initman() {
        //这里先模拟网路获取数据

        user=new User(1,"李四","男","18625355","****","574","52","323","3","df","43","34");

    }

    private void initData() {
        musernameTextView= (TextView) findViewById(R.id.forum_damuser);
        mteinumTextView= (TextView) findViewById(R.id.forum_teinum);
        mcontentionnumTextView= (TextView) findViewById(R.id.forum_contentionnum);
        mcolletnumTextView= (TextView) findViewById(R.id.forum_collectnum);
        //头像
        mmanImageView= (ImageView) findViewById(R.id.image2);


    }
}
