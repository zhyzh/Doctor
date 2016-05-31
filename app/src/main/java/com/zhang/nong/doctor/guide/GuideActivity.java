package com.zhang.nong.doctor.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhang.nong.MainActivity;
import com.zhang.nong.R;
import com.zhang.nong.doctor.utils.DensityUtil;
import com.zhang.nong.doctor.utils.MyConstants;
import com.zhang.nong.doctor.utils.SpTools;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {
//图片数据
private static final int[] pics = new int[]{R.mipmap.guide_1,
		R.mipmap.guide_2, R.mipmap.guide_3};
private ViewPager vp_guids;
private ArrayList<ImageView> guids;
private LinearLayout ll_points;// 引导圆点的父控件
private View v_redpoint;// 小红点
private Button bt_startExp;// 开始体验
private MyAdapter adapter;//适配器
private int disPoints;//点于点之间的距离

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题
	setContentView(R.layout.home_start_guide);
	initViews();//初始化界面
	initData();//初始化数据
	initEvent();//初始化组件的事件
}

/**
 * 初始化界面
 */
private void initViews() {
	//viewpager组件
	vp_guids = (ViewPager) findViewById(R.id.vp_guide_pages);
	//动态加点容器
	ll_points = (LinearLayout) findViewById(R.id.ll_guide_points);
	//红色点的容器
	v_redpoint = findViewById(R.id.v_guide_redpoint);
	//button按钮开始体验
	bt_startExp = (Button) findViewById(R.id.bt_guide_startexp);


}

//初始化数据
private void initData() {
//定义viewpager使用的容器
	guids = new ArrayList<ImageView>();

	// 初始化引导页的3个页面容器中的数据
	for (int i = 0; i<pics.length; i++) {
		ImageView iv_temp = new ImageView(getApplicationContext());
		iv_temp.setBackgroundResource(pics[i]);// 设置引导页背景
		guids.add(iv_temp);//添加界面数据

		//给点的容器linearlayout初始化添加灰色点
		View v_point = new View(getApplicationContext());
		v_point.setBackgroundResource(R.drawable.gray_point);// 设置引导页默认圆点
		int dp=10;
		//设置灰点的宽度
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				DensityUtil.dip2px(getApplicationContext(),dp),
				DensityUtil.dip2px(getApplicationContext(),dp));

		//第一个点不需要指定点间隔
		if (i>0) {
			params.leftMargin = 10;// 设置圆点间隔
		}

		v_point.setLayoutParams(params);// 设置圆点的大小

		ll_points.addView(v_point);// 将圆点添加给线性布局
	}

	//创建viewpager的适配器
	adapter = new MyAdapter();
	//设置适配器
	vp_guids.setAdapter(adapter);


}


private void initEvent() {

	//监听布局完成触发的结果
	v_redpoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
		@Override
		public void onGlobalLayout() {
			//取消注册界面发生的变化的回调

				v_redpoint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
			//计算点于点之间的距离
			disPoints = (ll_points.getChildAt(1).getLeft()-ll_points.getChildAt(0).getLeft());


		}
	});

	//给按钮添加点击事件
	bt_startExp.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			//保存设置的状态
			SpTools.setBoolean(getApplicationContext(), MyConstants.ISSETUP, true);//保存设置完成的状态

			// 进入主界面
			Intent main = new Intent(GuideActivity.this, MainActivity.class);
			startActivity(main);//启动主界面
			finish();//关闭自己

		}
	});
	//viewpager的页面页码改变事件
	vp_guids.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			//在页面滑动的时候触发的事件。
			// position：当前的viewpager停留位置
			// positionOffset ：偏移的比例值
			// positionOffsetPixels偏移的像素
			float leftMargin=disPoints*(position+positionOffset);
			//设置红点的左边距
			RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) v_redpoint.getLayoutParams();
			layoutParams.leftMargin=Math.round(leftMargin);//对float类型四舍五入

			//重新设置布局
			v_redpoint.setLayoutParams(layoutParams);

		}

		@Override
		public void onPageSelected(int position) {
			//当前的viewpager显示的页面
			//如果viewpager滑动到第三个界面(最后一页)的时候显示button
			if (position == guids.size() - 1) {
				bt_startExp.setVisibility(View.VISIBLE);//设置按钮显示

			} else {
				//不是最后一页就隐藏button按钮
				bt_startExp.setVisibility(View.GONE);
			}


		}

		@Override
		public void onPageScrollStateChanged(int state) {
			//
		}
	});
}


/**
 * 创建ViewPager数据适配器
 *
 *
 */
private class MyAdapter extends PagerAdapter {

	@Override
	public int getCount() {
		//返回数据的个数
		return pics.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		//判断缓存和过滤的作用
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		//container就是所谓的viewpager
		container.addView(guids.get(position));//获取view并添加到view中
		return guids.get(position);//返回view
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);//从viewpager中移除
	}
}


}
