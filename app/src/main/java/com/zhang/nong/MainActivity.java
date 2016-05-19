package com.zhang.nong;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhang.nong.doctor.adapters.MyAdapter;
import com.zhang.nong.doctor.fragments.ForumFragment;
import com.zhang.nong.doctor.fragments.HomeFragment;
import com.zhang.nong.doctor.fragments.MineFragment;
import com.zhang.nong.doctor.fragments.ReferFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RadioGroup mRadioGroup;//这是我修改的

    ViewPager mViewPager;
    List<Fragment> mList;
    HomeFragment mHomeFragment;
    ReferFragment mReferFragment;
    ForumFragment mForumFragment;
    MineFragment mMineFragment;

    android.support.v4.app.FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListeners();
    }

    private void initData() {
        mList = new ArrayList<>();
        mHomeFragment = new HomeFragment();
        mReferFragment = new ReferFragment();
        mForumFragment = new ForumFragment();
        mMineFragment = new MineFragment();

        mList.add(mHomeFragment);
        mList.add(mReferFragment);
        mList.add(mForumFragment);
        mList.add(mMineFragment);

        //初始化适配器
        mFragmentManager = getSupportFragmentManager();
        mAdapter = new MyAdapter(mFragmentManager,mList);
        mViewPager.setAdapter(mAdapter);


    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.group);
        mViewPager = (ViewPager) findViewById(R.id.middle);



    }

    private void initListeners() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetViewPager(checkedId);
            }
        });
        //滑动ViewPage的时候及时修改底部导航栏对应的图标
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //根据当前位置设置默认选中单选按钮
                resetRadioButton(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void resetViewPager(int checkedId) {
        switch (checkedId){
            case R.id.home:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.refer:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.forum:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.mine:
                mViewPager.setCurrentItem(3);
                break;
        }
    }

    private void resetRadioButton(int position) {
        //获取position位置处对于的单选按钮
        RadioButton radioButton = (RadioButton) mRadioGroup.getChildAt(position);
        //设置当前单选按钮默认选中
        radioButton.setChecked(true);
    }
}
