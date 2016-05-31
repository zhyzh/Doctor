package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Home_Day_Know_Date_Type_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Home_Day_Know_Date_Type_Activity extends AppCompatActivity {
    List<String> mList;
    String date_type1, date_type2, date_type3;
    Home_Day_Know_Date_Type_Adapter mDate_type_adapter;
    private ListView mListView;
    private ImageView iv_home_day_konw_type_back;
    TextView iv_home_day_konw_type_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_day_know_date_type);


        initViews();
        initDatas();
        initEvent();

    }

    private void initViews() {
        //获取返回键的id
        iv_home_day_konw_type_back = (ImageView) findViewById
                (R.id.iv_home_day_konw_type_back);
        //标题
        iv_home_day_konw_type_title = (TextView) findViewById
                (R.id.iv_home_day_konw_type_title);


        //获取listview的id
        mListView = (ListView) findViewById(R.id.lv_day_know_date_type_list);

    }

    private void initDatas() {
        mList = new ArrayList<>();
        //初始化数据
        date_type1 = new String("水稻播种前为什么要晒种");
        date_type2 = new String("水稻播种前应该如何晒种");
        date_type3 = new String("水稻播种前应该如何选种");
        //添加到集合中
        mList.add(date_type1);
        mList.add(date_type2);
        mList.add(date_type3);
        mList.add(date_type1);
        mList.add(date_type2);
        mList.add(date_type3);

         mList.add(date_type1);
        mList.add(date_type2);
        mList.add(date_type3);
        mList.add(date_type1);
        mList.add(date_type2);
        mList.add(date_type3);

         mList.add(date_type1);
        mList.add(date_type2);
        mList.add(date_type3);
        mList.add(date_type1);
        mList.add(date_type2);
        mList.add(date_type3);


        //设置适配器
        mDate_type_adapter = new Home_Day_Know_Date_Type_Adapter(Home_Day_Know_Date_Type_Activity.this, mList);
        mListView.setAdapter(mDate_type_adapter);

        //设置进入本页面的事件
        Intent intent = getIntent();
        intent.getSerializableExtra("day_know_type");


    }

    private void initEvent() {
        //监听返回键单击事件
        iv_home_day_konw_type_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
                finish();

            }
        });
        //设置监听item的点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String string = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(Home_Day_Know_Date_Type_Activity.this,
                        Home_Day_Know_Date_Type_Detail_Activity.class);
                intent.putExtra("Day_Know_Date_Type_Detail", string);
                startActivity(intent);
            }
        });

    }

}
