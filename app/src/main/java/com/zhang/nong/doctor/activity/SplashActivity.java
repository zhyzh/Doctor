package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.zhang.nong.R;


public class SplashActivity extends AppCompatActivity {
    LinearLayout mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_acitvity_splash);
        mRoot = (LinearLayout) findViewById(R.id.root);
        startAnim();
    }

    /**
     * 开启动画
     */
    private void startAnim() {

        AnimationSet set = new AnimationSet(false);
        //旋转动画
//        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
//                0.5f);
//        rotateAnimation.setDuration(2000);//动画时间
//        rotateAnimation.setFillAfter(true);//保持动画状态

        //缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        scaleAnimation.setDuration(2000);//动画时间
        scaleAnimation.setFillAfter(true);//保持动画状态

        //渐变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(5000);//动画时间
        alphaAnimation.setFillAfter(true);//保持动画状态

       // set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);
        //设置动画监听
        set.setAnimationListener(new Animation.AnimationListener() {
            //动画开始执行时调用
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                jumpNextPage();//跳转下一页面
            }
            //动画执行结束
            @Override
            public void onAnimationRepeat(Animation animation) {
                startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                finish();
            }
        });
        //启动动画
        mRoot.startAnimation(set);

    }

    private void jumpNextPage() {
        //判断之前有没有显示过新手引导页
        SharedPreferences sp = getSharedPreferences("config",MODE_PRIVATE);
        boolean userGuide = sp.getBoolean("activity_splash",false);
        if (!userGuide){
            //跳到新手引导页
            startActivity(new Intent(SplashActivity.this,GuideActivity.class));
        }else {
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        }

        finish();
    }
}
