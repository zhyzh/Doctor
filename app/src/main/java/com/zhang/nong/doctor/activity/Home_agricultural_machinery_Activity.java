package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhang.nong.MainActivity;
import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Agricultural_Machinery_Adapter;
import com.zhang.nong.doctor.com.java.beans.Machine;

import java.util.ArrayList;
import java.util.List;

public class Home_agricultural_machinery_Activity extends AppCompatActivity {
private ImageView iv_agricultural_machinery_back;
private List<Machine> mMachineList;
private Machine mMachine1, mMachine2, mMachine3;
private Agricultural_Machinery_Adapter mMachinery_Adapter;
private ListView mListView;
private ImageView iv_agricultural_machinery_publish;
private TextView tv_agricultural_machinery_more;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.home_agricultural_machinery);
	initviews();
	initDatas();
	initEvent();
}

private void initviews() {
//初始化返回键
	iv_agricultural_machinery_back = (ImageView) findViewById
			(R.id.iv_agricultural_machinery_back);
	//初始化发布键
	iv_agricultural_machinery_publish = (ImageView) findViewById
			(R.id.iv_agricultural_machinery_publish);
	//初始化更多键
	tv_agricultural_machinery_more = (TextView) findViewById
			(R.id.tv_agricultural_machinery_more);
	//获取listview
	mListView = (ListView) findViewById(R.id.lv_home_agricultural_machinery_list);


}

private void initDatas() {
	//初始化农机发布列表
	mMachineList = new ArrayList<>();
	//模拟数据
	mMachine1 = new Machine(1, 1, 1, "农用飞行器", 500, "苏州市相城区什么街道多少号", "123456", "2016.05.23");
	mMachine2 = new Machine(2, 2, 2, "玉米播种机", 50, "苏州市相城区什么街道多少号", "123456", "2016.05.23");
	mMachine3 = new Machine(3, 3, 3, "小麦收割机", 100, "苏州市相城区什么街道多少号", "123456", "2016.05.23");
	//添加数据到集合中
	mMachineList.add(mMachine1);
	mMachineList.add(mMachine2);
	mMachineList.add(mMachine3);
	mMachineList.add(mMachine1);
	mMachineList.add(mMachine2);
	mMachineList.add(mMachine3);
	//设置适配器
	mMachinery_Adapter = new Agricultural_Machinery_Adapter
			(Home_agricultural_machinery_Activity.this, mMachineList);
	mListView.setAdapter(mMachinery_Adapter);

}

private void initEvent() {
	//监听事件：当点击返回键的时候，返回到主界面
	iv_agricultural_machinery_back.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//跳转页面到主界面
			//跳转到首页界面
			Intent intent = new Intent(Home_agricultural_machinery_Activity.this,
					MainActivity.class);
			startActivity(intent);
		}
	});
	//监听发布按钮的点击事件
	iv_agricultural_machinery_publish.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//跳转到发布界面
			Intent intent = new Intent(Home_agricultural_machinery_Activity.this,
					Agricultural_Machinery_Publish_Activity.class);
			startActivity(intent);

		}
	});
	//监听点击更多事件
	tv_agricultural_machinery_more.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//进行跳转到农机列表中
			Intent intent = new Intent(Home_agricultural_machinery_Activity.this,
					Agricultural_Machinery_More_Activity.class);
			startActivity(intent);
		}
	});


}


}
