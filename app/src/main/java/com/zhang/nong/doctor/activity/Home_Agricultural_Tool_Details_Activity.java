package com.zhang.nong.doctor.activity;
/*农资详情页*/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.nong.R;

public class Home_Agricultural_Tool_Details_Activity extends AppCompatActivity {

    private ImageView iv_agricultural_tool_details_back;
    private TextView tv_agr_tool_details_title;
    private TextView tv_agr_tool_details_address;
    private TextView tv_agr_tool_details_product;
    private TextView tv_agr_tool_details_host;
    private TextView tv_agr_tool_details_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_agricultural_tool_details);
        initViews();
        initDatas();
        initEvent();
    }


    private void initViews() {
        //农资站的名字标题
        tv_agr_tool_details_title = (TextView) findViewById(R.id.tv_agr_tool_details_title);
        //农资站的地址
        tv_agr_tool_details_address = (TextView) findViewById(R.id.tv_agr_tool_details_address);
        //农资站的主营项目
        tv_agr_tool_details_product = (TextView) findViewById(R.id.tv_agr_tool_details_product);
        //农资站的联系人
        tv_agr_tool_details_host = (TextView) findViewById(R.id.tv_agr_tool_details_host);
        //农资站的联系电话
        tv_agr_tool_details_phone = (TextView) findViewById(R.id.tv_agr_tool_details_phone);

        //取得返回键
        iv_agricultural_tool_details_back = (ImageView) findViewById
                (R.id.iv_agricultural_tool_details_back);

    }

    private void initDatas() {

        //对item的事件的回应
        Intent intent = getIntent();
        intent.getSerializableExtra("Agricultural_Tool_Details");
        tv_agr_tool_details_title.setText("农资连锁超市老翟服务站");
        tv_agr_tool_details_address.setText("苏州市吴中区新华路5号");
        tv_agr_tool_details_product.setText("农药、化肥、种子、薄膜");
        tv_agr_tool_details_host.setText("老翟");
        tv_agr_tool_details_phone.setText("13123235656");



    }

    private void initEvent() {
        //给农资详情列表的返回键设置监听事件
        iv_agricultural_tool_details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回到农资列表
                onBackPressed();
                Home_Agricultural_Tool_Details_Activity.this.finish();
            }
        });


    }


}
