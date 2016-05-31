package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.nong.R;

public class Home_Agricultural_Book_Detail_Activity extends AppCompatActivity {

private ImageView iv_agr_book_detail_back;
private ImageView iv_agr_book_detail_coolect;
private TextView tv_agr_book_detail_text_title;
private TextView tv_agr_book_detail_text_detail;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.home_agricultural_book_detail);
	initViews();
	initData();
	initEvent();
}

private void initViews() {
	//返回键
	iv_agr_book_detail_back = (ImageView) findViewById
			(R.id.iv_agr_book_detail_back);
	//收藏键
	iv_agr_book_detail_coolect = (ImageView) findViewById
			(R.id.iv_agr_book_detail_coolect);
	//文章标题
	tv_agr_book_detail_text_title = (TextView) findViewById
			(R.id.tv_agr_book_detail_text_title);
	//文章内容详情
	tv_agr_book_detail_text_detail = (TextView) findViewById
			(R.id.tv_agr_book_detail_text_detail);

}

private void initData() {
Intent intent=getIntent();
	intent.getSerializableExtra("Book_Detail");
	tv_agr_book_detail_text_title.setText(R.string.agr_book_detail_text_title);
	tv_agr_book_detail_text_detail.setText(R.string.agr_book_detail_text_detail);

}

private void initEvent() {
	//设置监听返回键的点击事件
	iv_agr_book_detail_back.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			onBackPressed();
			finish();
		}
	});

}

}
