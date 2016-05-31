package com.zhang.nong.doctor.guide;
/***
 * 主要实现啦splish动画
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.zhang.nong.MainActivity;
import com.zhang.nong.R;
import com.zhang.nong.doctor.utils.MyConstants;
import com.zhang.nong.doctor.utils.SpTools;

public class SplishActivity extends AppCompatActivity {

private AnimationSet set;
private ImageView iv_mainview;

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.home_start_splish);
	iv_mainview = (ImageView) findViewById(R.id.iv_splash_mainview);
	startAnim();//开始播放动画
	initEvent();//初始化事件

}

private void initEvent() {
	//设置动画监听播放完毕的事件
	set.setAnimationListener(new Animation.AnimationListener() {
		@Override
		public void onAnimationStart(Animation animation) {
			//开始
		}

		@Override
		//监听动画播放完毕的事件
		public void onAnimationEnd(Animation animation) {
			//结束跳转到新手引导页
			if (SpTools.getBoolean(getApplicationContext(), MyConstants.ISSETUP, false)) {
				//true设置过，直接进入主界面
				Intent main = new Intent(SplishActivity.this, MainActivity.class);
				startActivity(main);//启动主界面
			} else {
				//false 没有设置过，进入设置向导页面
				Intent intent = new Intent(SplishActivity.this,
						GuideActivity.class);
				startActivity(intent);//启动设置向导界面

			}
			//关闭自己
			finish();
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			//重复的页面

		}
	});

}

private void startAnim() {
	//动画集合
	set = new AnimationSet(false);

	//旋转动画
	RotateAnimation rotate = new RotateAnimation(0, 360,
			Animation.RELATIVE_TO_SELF, 0.5f,
			Animation.RELATIVE_TO_SELF, 0.5f);
	//动画时间
	rotate.setDuration(3000);
	//保持动画状态
	rotate.setFillAfter(true);
	//缩放动画
	ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1,
			Animation.RELATIVE_TO_SELF, 0.5f,
			Animation.RELATIVE_TO_SELF, 0.5f);
	scale.setDuration(2000);
	scale.setFillAfter(true);
	//渐变的动画
	AlphaAnimation alpha = new AlphaAnimation(0, 1);
	alpha.setDuration(2000);
	alpha.setFillAfter(true);
	//添加动画设置到集合中
	set.addAnimation(rotate);
	set.addAnimation(scale);
	set.addAnimation(alpha);
	//启动动画设置
	iv_mainview.startAnimation(set);


}
}
