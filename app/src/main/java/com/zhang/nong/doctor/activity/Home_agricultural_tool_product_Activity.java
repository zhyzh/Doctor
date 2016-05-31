package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Home_Agricultural_Tool_Adapter;
import com.zhang.nong.doctor.com.java.beans.Farmmessage;

import java.util.ArrayList;
import java.util.List;

public class Home_Agricultural_Tool_Product_Activity extends AppCompatActivity {
     List<Farmmessage> mFarmmessageList;
     Farmmessage mFarmmessage1, mFarmmessage2, mFarmmessage3;
     Home_Agricultural_Tool_Adapter mTool_adapter;
    private ListView mListView;
    private ImageView iv_agricultural_tool_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_agricultural_tool_product);

        initViews();
        initData();
        initEvent();

    }

    private void initViews() {
        //初始化返回键
        iv_agricultural_tool_back = (ImageView) findViewById(R.id.iv_agricultural_tool_back);
        //初始化listview
        mListView = (ListView) findViewById(R.id.lv_agricultural_tool_list);
    }

    private void initData() {
        mFarmmessageList = new ArrayList<>();
        mFarmmessage1 = new Farmmessage(1, "农资连锁超市老翟服务站", "我是老翟",
                "农药化肥", "苏州市吴中区新华路5号", "123456", "老翟");
        mFarmmessage2 = new Farmmessage(2, "金群农资公司", "我是老翟",
                "农药化肥", "苏州市太仓市新华路5号", "123456", "老翟");
        mFarmmessage3 = new Farmmessage(3, "常熟农资NO.052", "我是老翟",
                "农药化肥", "苏州市常熟市新华路5号", "123456", "老翟");
        //添加数据到集合中
        mFarmmessageList.add(mFarmmessage1);
        mFarmmessageList.add(mFarmmessage2);
        mFarmmessageList.add(mFarmmessage3);
        mFarmmessageList.add(mFarmmessage1);
        mFarmmessageList.add(mFarmmessage2);
        mFarmmessageList.add(mFarmmessage3);

        mFarmmessageList.add(mFarmmessage1);
        mFarmmessageList.add(mFarmmessage2);
        mFarmmessageList.add(mFarmmessage3);
        mFarmmessageList.add(mFarmmessage1);
        mFarmmessageList.add(mFarmmessage2);
        mFarmmessageList.add(mFarmmessage3);

        mFarmmessageList.add(mFarmmessage1);
        mFarmmessageList.add(mFarmmessage2);
        mFarmmessageList.add(mFarmmessage3);
        mFarmmessageList.add(mFarmmessage1);
        mFarmmessageList.add(mFarmmessage2);
        mFarmmessageList.add(mFarmmessage3);


        //设置适配器
        mTool_adapter = new Home_Agricultural_Tool_Adapter
                (Home_Agricultural_Tool_Product_Activity.this, mFarmmessageList);
        mListView.setAdapter(mTool_adapter);


    }

    private void initEvent() {

        //设置返回键监听事件
        iv_agricultural_tool_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到首页
                onBackPressed();
                Home_Agricultural_Tool_Product_Activity.this.finish();
            }
        });
        //设置item的监听事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取列表当前行绑定的数据
                Farmmessage farmmessage = (Farmmessage) parent.getItemAtPosition(position);
                //定义意图
                Intent intent = new Intent(Home_Agricultural_Tool_Product_Activity.this,
                        Home_Agricultural_Tool_Details_Activity.class);
                //传值
                intent.putExtra("Agricultural_Tool_Details", farmmessage);
                //启动跳转
                startActivity(intent);


            }
        });


    }
}
