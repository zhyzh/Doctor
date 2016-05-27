package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.zhang.nong.MainActivity;
import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Agricultural_Machinery_Adapter;
import com.zhang.nong.doctor.com.java.beans.Machine;

import java.util.ArrayList;
import java.util.List;

public class Agricultural_Machinery_More_Activity extends AppCompatActivity {
private List<Machine> mMachineList;
private Machine mMachine1, mMachine2, mMachine3;
private Agricultural_Machinery_Adapter mMachinery_Adapter;
private ListView mListView;
private ImageView iv_agricultural_machinery_more_back;
private Spinner mSpinner1,mSpinner2;
private String[][] machinery_class={{"全部"},
		{"翻转犁","开沟机","旋耕机","圆盘犁","铧式犁","栅条犁","田园管理机","浅松机","深松机"},
		{"水稻插秧机","水稻摆秧机","油菜载植机","免耕播种机","小粒种子播种机",
				"地膜覆盖机","残膜回收机","种子处理设备","营养钵压制机"},
		{"施肥机","撒肥机","追肥机","农用飞行器","中耕追肥机"},
		{"除草机","埋藤机","喷雾器","弥雾机","烟雾机","杀虫灯"},
		{"小麦收割机","玉米收割机","玉米剥皮机","水稻收割机","棉花收割机",
				"草莓收割机","采茶机","花卉采收机","甘蔗收获机"},
		{"割草机","玉米脱粒机","大蒜剥皮机","挖掘机","拖拉机","推土机","水泵",
				"榨油机","农用吊车","农用叉车","孵化机"}};

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.agricultural_machinery_more);
	initViews();
	initDatas();
	initEvent();
}

private void initViews() {
	//获取listview
	mListView = (ListView) findViewById(R.id.lv_home_agricultural_machinery_list);


}

private void initDatas() {
	//初始化spinner的数据
	mSpinner1= (Spinner) findViewById(R.id.spinner_machinery_type);
	mSpinner2= (Spinner) findViewById(R.id.spinner_machinery_type_class);

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
			(Agricultural_Machinery_More_Activity.this, mMachineList);
	mListView.setAdapter(mMachinery_Adapter);

}

private void initEvent() {
	//监听spinner1的点击事件
	mSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			//更新spinner2中的数据
			ArrayAdapter<String> adapter=new ArrayAdapter<String>
					(Agricultural_Machinery_More_Activity.this,android.R.layout.simple_spinner_item,
							machinery_class[(int)parent.getSelectedItem()]);
			//设置下拉框的样本
			adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
			//设置spinner2的适配器
			mSpinner2.setAdapter(adapter);

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	});

	//监听事件：当点击返回键的时候，返回到主界面
	iv_agricultural_machinery_more_back.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//跳转页面到主界面
			//跳转到首页界面
			Intent intent = new Intent(Agricultural_Machinery_More_Activity.this,
					MainActivity.class);
			startActivity(intent);
		}
	});
}


}
