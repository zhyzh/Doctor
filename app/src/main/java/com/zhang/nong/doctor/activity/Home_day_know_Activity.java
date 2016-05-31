package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Home_Day_Know_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Home_Day_Know_Activity extends AppCompatActivity {
    List<String> mList;
    String type1, type2, type3, type4, type5, type6, type7,
            type8, type9, type10, type11, type12, type13, type14;
    Home_Day_Know_Adapter mKnow_adapter;
    private ListView mListView;
    private ImageView iv_home_day_konw_back;
    Spinner spinner_day_know_type, spinner_day_know_class;
    private String[][] day_know_class = {{"稻谷", "麦类", "玉米", "豆类", "高粱、粟、黍", "油料花生", "芝麻", "其他粮油作物"},
            {"根菜类", "白菜类", "绿叶菜类", "葱蒜类", "茄果类", "瓜类", "豆类", "薯芋类", "水生蔬菜", "多年生蔬菜"},
            {"苹果", "柑桔、橙、柚", "梨", "葡萄", "西瓜", "甜瓜", "香蕉", "草莓", "菠萝", "桃"},
            {"鲜花", "花草盆景", "草本植物", "地被植物", "木本植物", "多肉植物", "一二年生草花", "室内观叶植物"},
            {"乔木", "灌木", "果树", "草坪", "树木盆景", "竹类", "球类", "山水盆景", "攀援植物"},
            {"香菇", "平菇", "草菇", "金针菇", "猴头菇", "竹荪", "鸡腿菇", "白灵菇", "灰树花", "姬松茸"}};

    private View day_know_title;
    LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_day_know);
        mInflater = LayoutInflater.from(this);
        day_know_title = mInflater.inflate(R.layout.home_day_know_title, null);
        initViews();
        initDatas();
        initEvent();
    }

    private void initViews() {
        //获取listview
        mListView = (ListView) findViewById(R.id.lv_day_know_list);
        //获取返回键按钮
        iv_home_day_konw_back = (ImageView) findViewById
                (R.id.iv_home_day_konw_back);


    }

    //初始化数据
    private void initDatas() {
        mList = new ArrayList<>();
        type1 = new String("浸种期");
        type2 = new String("催芽期");
        type3 = new String("移栽到苗床");
        type4 = new String("幼苗期");
        type5 = new String("移栽幼苗");
        type6 = new String("分蘖期");
        type7 = new String("拔节期");
        type8 = new String("育穗期");
        type9 = new String("抽穗期");
        type10 = new String("扬花期");
        type11 = new String("乳熟期");
        type12 = new String("蜡熟期");
        type13 = new String("完熟期");
        type14 = new String("枯熟期");
        //添加数据到集合中
        mList.add(type1);
        mList.add(type2);
        mList.add(type3);
        mList.add(type4);
        mList.add(type5);
        mList.add(type6);
        mList.add(type7);
        mList.add(type8);
        mList.add(type9);
        mList.add(type10);
        mList.add(type11);
        mList.add(type12);
        mList.add(type13);
        mList.add(type14);

        //设置适配器
        mKnow_adapter = new Home_Day_Know_Adapter(Home_Day_Know_Activity.this, mList);
        mListView.addHeaderView(day_know_title);
        mListView.setAdapter(mKnow_adapter);

    }

    //监听事件
    private void initEvent() {
        //点击返回图标进入到主页
        iv_home_day_konw_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();//关闭本页面
            }
        });
        //获取spinner
        spinner_day_know_type = (Spinner) day_know_title.findViewById(R.id.spinner_day_know_type);
        spinner_day_know_class = (Spinner) day_know_title.findViewById(R.id.spinner_day_know_class);
        //点击第一个spinner的时候更新第二个spinner的数据
        spinner_day_know_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (Home_Day_Know_Activity.this, android.R.layout.simple_spinner_item,
                                day_know_class[(int) parent.getSelectedItemId()]);
                //设置下拉框的样式
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner_day_know_class.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //监听每日知道中的item的点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //取得列表当前行绑定的数据
                String string = (String) parent.getItemAtPosition(position);

                //定义意图
                Intent intent = new Intent(Home_Day_Know_Activity.this,
                        Home_Day_Know_Date_Type_Activity.class);
                //传值
                intent.putExtra("day_know_type", string);

                startActivity(intent);
            }
        });
    }

}
