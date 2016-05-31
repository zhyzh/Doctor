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
import com.zhang.nong.doctor.adapters.Home_Agr_Book_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Home_Agricultural_Book_Activity extends AppCompatActivity {
    List<String> mList;
    String type1, type2, type3, type4, type5, type6, type7,
            type8, type9, type10, type11, type12, type13, type14;
    Home_Agr_Book_Adapter mBook_adapter;
    private ListView mListView;
    private ImageView iv_home_agr_book_back;
    Spinner spinner_agr_book_type, spinner_agr_book_class;
    private String[][] agr_book_class = {{"稻谷", "麦类", "玉米", "豆类", "高粱、粟、黍", "油料花生", "芝麻", "其他粮油作物"},
            {"根菜类", "白菜类", "绿叶菜类", "葱蒜类", "茄果类", "瓜类", "豆类", "薯芋类", "水生蔬菜", "多年生蔬菜"},
            {"苹果", "柑桔、橙、柚", "梨", "葡萄", "西瓜", "甜瓜", "香蕉", "草莓", "菠萝", "桃"},
            {"鲜花", "花草盆景", "草本植物", "地被植物", "木本植物", "多肉植物", "一二年生草花", "室内观叶植物"},
            {"乔木", "灌木", "果树", "草坪", "树木盆景", "竹类", "球类", "山水盆景", "攀援植物"},
            {"香菇", "平菇", "草菇", "金针菇", "猴头菇", "竹荪", "鸡腿菇", "白灵菇", "灰树花", "姬松茸"}};

    LayoutInflater mInflater;
    private View agr_book_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_agricultural_book);
        mInflater = LayoutInflater.from(this);
        agr_book_title = mInflater.inflate(R.layout.home_agr_book_title, null);

        initViews();
        initData();
        initEvent();
    }

    private void initViews() {
        //获取listview
        mListView = (ListView) findViewById(R.id.lv_agr_book_list);
        //获取返回键按钮
        iv_home_agr_book_back = (ImageView) findViewById
                (R.id.iv_home_agr_book_back);


    }

    //初始化数据
    private void initData() {
        //对适配器中的数据进行模拟
        mList = new ArrayList<String>();
        type1 = new String("果树遇到病虫害应该如何解决");
        type2 = new String("洋芋、芋头、莴笋的复种技术");
        type3 = new String("大棚栽种莴笋的技术");
        type4 = new String("苹果采摘后的处理技术");
        type5 = new String("大豆花荚期的管理措施");
        type6 = new String("白三叶草坪的冬季养护管理");
        type7 = new String("大豆品种--中黄7号");
        type8 = new String("茄子嫁接后的管理技巧");
        type9 = new String("如何种植天麻");
        type10 = new String("防治苹果生蚜虫");
        type11 = new String("八仙花概况介绍");
        type12 = new String("如何种植八仙花");
        type13 = new String("如何管理大棚中的天麻");
        type14 = new String("玉米种子--隆平9号");
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
        mBook_adapter = new Home_Agr_Book_Adapter(Home_Agricultural_Book_Activity.this, mList);
        mListView.addHeaderView(agr_book_title);
        mListView.setAdapter(mBook_adapter);

    }

    //监听事件
    private void initEvent() {

        //点击返回图标进入到主页
        iv_home_agr_book_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();

            }
        });

        //初始化,获取spinner
        spinner_agr_book_type = (Spinner) agr_book_title.findViewById(R.id.spinner_agr_book_type);
        spinner_agr_book_class = (Spinner) agr_book_title.findViewById(R.id.spinner_agr_book_class);
        //点击第一个spinner的时候更新第二个spinner的数据
        spinner_agr_book_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (Home_Agricultural_Book_Activity.this, android.R.layout.simple_spinner_item,
                                agr_book_class[(int) parent.getSelectedItemId()]);
                //设置下拉框的样式
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner_agr_book_class.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    //设置listview中的item的点击事件
    mListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			String string= (String) parent.getItemAtPosition(position);
			Intent intent=new Intent(Home_Agricultural_Book_Activity.this,
					Home_Agricultural_Book_Detail_Activity.class);
			intent.putExtra("Book_Detail",string);
			startActivity(intent);

		}
	});

    }

}
