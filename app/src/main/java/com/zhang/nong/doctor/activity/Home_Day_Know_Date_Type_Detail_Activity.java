package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.nong.R;

public class Home_Day_Know_Date_Type_Detail_Activity extends AppCompatActivity {

    private ImageView iv_day_know_date_type_detail_back;
    private TextView tv_day_know_date_type_detail_title;
    private TextView tv_day_know_date_type_detail_text_title;
    private TextView tv_day_know_date_type_detail_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_day_know_date_type_detail);
        initViews();
        initData();
        initEvent();
    }

    private void initViews() {
        //初始化返回键
        iv_day_know_date_type_detail_back = (ImageView) findViewById
                (R.id.iv_day_know_date_type_detail_back);
        //初始化头部标题
        tv_day_know_date_type_detail_title = (TextView) findViewById
                (R.id.tv_day_know_date_type_detail_title);
        //初始化详情标题
        tv_day_know_date_type_detail_text_title = (TextView) findViewById
                (R.id.tv_day_know_date_type_detail_text_title);
        //初始化详情内容
        tv_day_know_date_type_detail_text = (TextView) findViewById
                (R.id.tv_day_know_date_type_detail_text);

    }

    private void initData() {
        Intent intent = getIntent();
        intent.getSerializableExtra("Day_Know_Date_Type_Detail");
        tv_day_know_date_type_detail_title.setText("浸种");
        tv_day_know_date_type_detail_text_title.setText(R.string.day_know_date_type_detail_title);
        tv_day_know_date_type_detail_text.setText(R.string.day_know_date_type_detail);

    }

    private void initEvent() {
        //监听返回键的点击事件
        iv_day_know_date_type_detail_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回到前一页面
                onBackPressed();
                finish();
            }
        });


    }

}
