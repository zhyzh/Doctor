package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.zhang.nong.R;

import java.util.ArrayList;

/**
 * Created by XCF on 2016/5/20.
 */
public class GuideActivity extends Activity {

    private static final int[] mImageIds = new int[]{R.mipmap.aa,
            R.mipmap.bb, R.mipmap.cc, R.mipmap.dd, R.mipmap.ee};

    ViewPager mViewPager;
    ArrayList<ImageView> mImageViewList;
    Button mButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity_guide);
        mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        mButton = (Button) findViewById(R.id.button);

        initViews();
        initListeners();
        mViewPager.setAdapter(new GuideAdapter());
        mViewPager.setOnPageChangeListener(new GuidePageListemer());

    }

    private void initListeners() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //更新SharedPreferences，表示已经展示了新手引导
                SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
                sp.edit().putBoolean("activity_splash", true).commit();
                //跳转页面
                Intent intent = new Intent();
                intent.setClass(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    //viewpager的滑动监听GuidePageListener
   class GuidePageListemer implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == mImageIds.length - 1) {// 最后一个页面
                mButton.setVisibility(View.VISIBLE);// 显示开始体验的按钮
            } else {
                mButton.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    /**
     * 初始化界面
     */
    private void initViews() {
        mImageViewList = new ArrayList<>();

        // 初始化引导页的5个页面
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(mImageIds[i]);// 设置引导页背景
            mImageViewList.add(image);
        }
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageIds.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mImageViewList.get(position));
            return mImageViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


}
