package com.zhang.nong.doctor.activity;
/*主界面的找专家页面*/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.zhang.nong.MainActivity;
import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.Nearby_Pro_Adapter;
import com.zhang.nong.doctor.com.java.beans.Expert;

import java.util.ArrayList;
import java.util.List;


public class Home_professor_Activity extends AppCompatActivity {
private Spinner zhuangjia_spinner1, zhuangjia_spinner2;//两个下拉列表
private String[][] pro_type = {{"全部"},
		{"杨志远", "杨家将", "天虹元", "张磊", "黄小兵", "张杰刚"},
		{"植保(大田)", "植保(果树)", "植保(蔬菜)", "肥料", "育种", "栽培", "园林", "农药"}};
private ImageView zhuanjia_back;//专家界面的返回键
private TextView zhuanjia_advisory;//咨询专家
private List<Expert> mProfessorList;//获取专家的表
private Expert mProfessor1, mProfessor2, mProfessor3;//模拟数据，添加3个专家
private Nearby_Pro_Adapter mNearby_pro_adapter;//专家的适配器
private ListView nearby_pro_list;//专家的列表

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.home_zhuanjia_listview);
	initviews();
	initDatas();
	initEvent();
}

//初始化
private void initviews() {
	//选择专家的类型的两个spinner
	zhuangjia_spinner1 = (Spinner) findViewById(R.id.zhuangjia_spinner1);
	zhuangjia_spinner2 = (Spinner) findViewById(R.id.zhuangjia_spinner2);
	//返回键
	zhuanjia_back = (ImageView) findViewById(R.id.iv_zhuanjia_back);
	//咨询专家
	zhuanjia_advisory = (TextView) findViewById(R.id.tv_nearby_pro_advisory);
	//获取listview
	nearby_pro_list = (ListView) findViewById(R.id.lv_nearby_pro_list);





}

//初始化数据
private void initDatas() {
	//初始化专家列表
	mProfessorList = new ArrayList<>();
	mProfessor1=new Expert
			(1,"杨志远","男","苏州","我是小学生",10,10,10,"sss");
	mProfessor2=new Expert
			(2,"张磊","男","苏州","我是初中学生",10,10,10,"sss");
	mProfessor3=new Expert
			(3,"黄小兵","男","苏州","我是高中学生",10,10,10,"sss");
	mProfessorList.add(mProfessor1);
	mProfessorList.add(mProfessor2);
	mProfessorList.add(mProfessor3);
	mProfessorList.add(mProfessor1);
	mProfessorList.add(mProfessor3);
	mProfessorList.add(mProfessor2);

	//设置适配器
	mNearby_pro_adapter=new Nearby_Pro_Adapter
			(Home_professor_Activity.this,mProfessorList);
	nearby_pro_list.setAdapter(mNearby_pro_adapter);




}

//监听事件
private void initEvent() {
	//设置对返回键监听
	zhuanjia_back.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//跳转到首页界面
			Intent intent = new Intent(Home_professor_Activity.this,
					MainActivity.class);
			startActivity(intent);
		}
	});
	/*//对listview中的咨询项目监听
	zhuanjia_advisory.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//跳转到专家咨询界面
			Intent intent = new Intent(Home_professor_Activity.this,
					Nearby_pro_advisory_Activity.class);
			startActivity(intent);
		}
	});*/


	//对spinner1进行监听看起他选中的是哪一个类型
	zhuangjia_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			//当第一个spinner选中后就更新spinner2的内容
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(Home_professor_Activity.this,
					android.R.layout.simple_spinner_item,
					pro_type[(int) parent.getSelectedItemId()]);
			//设置spinner的下拉框的样式
			adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
			zhuangjia_spinner2.setAdapter(adapter);

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	});

}


}
