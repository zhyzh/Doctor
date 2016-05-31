package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.nong.R;

public class Home_Agricultural_Machinery_Detail_Info_Activity extends AppCompatActivity {

private ImageView iv_agr_mac_detail_info_picture;
private TextView tv_agr_mac_detail_info_type;
private TextView tv_agr_mac_detail_info_master_address;
private TextView tv_agr_mac_detail_info_user_address;
private TextView tv_agr_mac_detail_info_price;
private TextView tv_agr_mac_detail_info_master;
private TextView tv_agr_mac_detail_info_master_phoneNum;
private Button btn_arg_mac_detail_info_callbutton;
private ImageView iv_agr_mac_detail_info_back;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.home_agricultural_machinery_detail_info);
	initViews();
	initData();
	initEvent();
}

private void initViews() {
	//获取返回键按钮
	iv_agr_mac_detail_info_back = (ImageView) findViewById
			(R.id.iv_agr_mac_detail_info_back);
	//获取图片
	iv_agr_mac_detail_info_picture = (ImageView) findViewById
			(R.id.iv_agr_mac_detail_info_picture);
	//农机类型
	tv_agr_mac_detail_info_type = (TextView) findViewById
			(R.id.tv_agr_mac_detail_info_type);
	//获取农机主的位置
	tv_agr_mac_detail_info_master_address = (TextView) findViewById
			(R.id.tv_agr_mac_detail_info_master_address);
	//获取使用者的位置(默认状态是空)
	tv_agr_mac_detail_info_user_address = (TextView) findViewById
			(R.id.tv_agr_mac_detail_info_user_address);
	//服务费用
	tv_agr_mac_detail_info_price = (TextView) findViewById
			(R.id.tv_agr_mac_detail_info_price);
	//联系人
	tv_agr_mac_detail_info_master = (TextView) findViewById
			(R.id.tv_agr_mac_detail_info_master);
	//联系电话
	tv_agr_mac_detail_info_master_phoneNum = (TextView) findViewById
			(R.id.tv_agr_mac_detail_info_master_phoneNum);
	//电话联系按钮
	btn_arg_mac_detail_info_callbutton = (Button) findViewById
			(R.id.bt_arg_mac_detail_info_callbutton);

}

private void initData() {
	Intent intent = getIntent();

	intent.getSerializableExtra("agricultural_machinery_detail");

	tv_agr_mac_detail_info_type.setText("玉米播种机");
	iv_agr_mac_detail_info_picture.setImageResource(R.drawable.home_mac_recommend);
	tv_agr_mac_detail_info_master_address.setText("苏州市相城区什么街道多少号");
	tv_agr_mac_detail_info_user_address.setText("苏州市相城区什么街道多少号");
	tv_agr_mac_detail_info_price.setText("80元/天");
	tv_agr_mac_detail_info_master.setText("多多大姐");
	tv_agr_mac_detail_info_master_phoneNum.setText("12345678901");





}

//设置监听事件
private void initEvent() {
	//监听返回键按钮
	iv_agr_mac_detail_info_back.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//跳转到前一个界面
			 onBackPressed();
			finish();
		}
	});
		//监听电话联系按钮的单击事件
	btn_arg_mac_detail_info_callbutton.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {

		}
	});

}

}
