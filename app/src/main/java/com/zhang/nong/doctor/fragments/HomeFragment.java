package com.zhang.nong.doctor.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.activity.Home_agricultural_book_Activity;
import com.zhang.nong.doctor.activity.Home_agricultural_machinery_Activity;
import com.zhang.nong.doctor.activity.Home_agricultural_tool_product_Activity;
import com.zhang.nong.doctor.activity.Home_agricultural_weather_Activity;
import com.zhang.nong.doctor.activity.Home_day_know_Activity;
import com.zhang.nong.doctor.activity.Home_professor_Activity;
import com.zhang.nong.doctor.adapters.Home_recommend_Adapter;
import com.zhang.nong.doctor.com.java.beans.Machine;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by XCF on 2016/5/12.
 */
public class HomeFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private View home_view;
    int[] imgs = {R.drawable.iv_home_view_pager1, R.drawable.iv_home_view_pager2,
            R.drawable.iv_home_view_pager3};
    String[] title_text = {"现代农业的发展", "发展现代农业", "发展专业合作"};
    private List<ImageView> mListDatas;
    private ViewPager home_vp_pager;
    private LinearLayout home_vp_ll_point_container;
    private TextView home_vp_message_tv_title;

    private List<Machine> mMachineList;
    private Machine mMachine, mMachine2;
    private Home_recommend_Adapter mHome_recommend_adapter;
    private ListView mListView;
    private ImageView zhuanjia;
    private ImageView nongzi;
    private ImageView nongji;
    private ImageView dayknow;
    private ImageView agricultural_shuku;
    private ImageView agricultural_weather;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        home_view = inflater.inflate(R.layout.home_main, null);
        initviews();
        initDatas();
        initEvent();
        return home_view;

    }

    //事件
    private void initEvent() {
        //监听点击找专家的图标事件
        zhuanjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到找专家的界面
                Intent intent = new Intent(getActivity(), Home_professor_Activity.class);
                startActivity(intent);
            }
        });
//监听点击农资图标事件
        nongzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到农资界面
                Intent intent = new Intent(getActivity(),
                        Home_agricultural_tool_product_Activity.class);
                startActivity(intent);
            }
        });

        //监听点击农机图标事件
        nongji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到农机界面
                Intent intent = new Intent(getActivity(),
                        Home_agricultural_machinery_Activity.class);
                startActivity(intent);
            }
        });
//监听点击每日知道图标事件
        dayknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到每日知道界面
                Intent intent = new Intent(getActivity(),
                        Home_day_know_Activity.class);
                startActivity(intent);
            }
        });
//监听点击农业书库图标事件
        agricultural_shuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到农业书库界面
                Intent intent = new Intent(getActivity(),
                        Home_agricultural_book_Activity.class);
                startActivity(intent);
            }
        });
//监听点击农事天气图标事件
        agricultural_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到农事天气界面
                Intent intent = new Intent(getActivity(),
                        Home_agricultural_weather_Activity.class);
                startActivity(intent);
            }
        });

    }

    //初始化数据
    private void initDatas() {

        //对轮播图初始化数据

        mListDatas = new ArrayList<ImageView>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView iv = new ImageView(getContext());
            iv.setImageResource(imgs[i]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            mListDatas.add(iv);

            //添加圆点
            View point = new View(getContext());
            point.setBackgroundResource(R.drawable.home_vp_message_point_narmal);
            LinearLayout.LayoutParams params = new LinearLayout.
                    LayoutParams(10, 10);
            if (i != 0) {
                params.leftMargin = 10;//设置圆点之间的距离，为向左10dp
            } else {
                point.setBackgroundResource(R.drawable.
                        home_vp_message_point_selectl);
                home_vp_message_tv_title.setText(title_text[i]);
            }
            home_vp_ll_point_container.addView(point, params);
        }

        //设置数据方式
        home_vp_pager.setAdapter(new MyAdapter());
//设置监听器
        home_vp_pager.setOnPageChangeListener(this);

        //设置默认选中的中间的item
        int middle = Integer.MAX_VALUE / 2;
        int extra = middle % mListDatas.size();
        int item = middle - extra;
        home_vp_pager.setCurrentItem(item);


        //获取网络数据农机
        mMachineList = new ArrayList<>();
        mMachine = new Machine(1, 1, 1, "收割机", 30, "苏州", "14154", "15545");
        mMachine2 = new Machine(2, 2, 3, "开沟机", 30, "苏州", "14154", "15545");
        mMachineList.add(mMachine);
        mMachineList.add(mMachine2);
        mMachineList.add(mMachine);
        mMachineList.add(mMachine2);
        mMachineList.add(mMachine);
        mMachineList.add(mMachine2);
        //设置适配器
        mHome_recommend_adapter = new Home_recommend_Adapter(getActivity(), mMachineList);
        mListView.setAdapter(mHome_recommend_adapter);

    }

    private void initviews() {
        home_vp_pager = (ViewPager) home_view.findViewById(R.id.home_vp_pager);
        home_vp_ll_point_container = (LinearLayout) home_view.findViewById
                (R.id.home_vp_ll_point_container);
        home_vp_message_tv_title = (TextView) home_view.findViewById
                (R.id.home_vp_message_tv_title);
        mListView = (ListView) home_view.findViewById(R.id.home_commend_listview);
        //获取找专家
        zhuanjia = (ImageView) home_view.findViewById(R.id.iv_home_doctor);
        //农资
        nongzi = (ImageView) home_view.findViewById(R.id.iv_home_agricultural);
        //农机服务
        nongji = (ImageView) home_view.findViewById(R.id.iv_home_marchinery);
        //每日知道
        dayknow = (ImageView) home_view.findViewById(R.id.iv_home_day);
        //农业书库
        agricultural_shuku = (ImageView) home_view.findViewById(R.id.iv_home_book);
        //天气
        agricultural_weather = (ImageView) home_view.findViewById(R.id.iv_home_weather);


    }

    //轮播图的适配器
    class MyAdapter extends PagerAdapter {
        //返回的是页面的数量
        @Override
        public int getCount() {
            if (mListDatas != null) {
                return Integer.MAX_VALUE;
            }
            return 0;
        }

        //标记方法，用来判断缓存的标记
        @Override
        public boolean isViewFromObject(View view, Object object) {
            //view：显示的view
            //object：标记


            return view == object;
            //有缓存就返回truth，没有缓存就返回false
        }

        //初始化item(显示的每个条目)
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            //初始化，用来添加要显示的view
            position = position % mListDatas.size();
            ImageView iv = mListDatas.get(position);//position：要加载的位置
            //用来添加显示的view
            home_vp_pager.addView(iv);

            //记录缓存标记--return标记
            return iv;
        }

        //销毁item条目
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //销毁移除item
            position = position % mListDatas.size();
            ImageView iv = mListDatas.get(position);
            home_vp_pager.removeView(iv);
            //object：标记


        }
    }

    //下面这三个方法都属于回调方法，
    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {
        //当viewpager滚动时的回调
//postion表示当前选中的位置；positionOffset滑动的百分比；positionOffsetPixels偏移的距离，滑动的像素
    }

    @Override
    public void onPageSelected(int position) {
//当viewpager选中某一个页面时的回调
        //设置选中的点的样式

        position = position % mListDatas.size();
        int count = home_vp_ll_point_container.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = home_vp_ll_point_container.getChildAt(i);

            view.setBackgroundResource(position == i ?
                    R.drawable.home_vp_message_point_selectl :
                    R.drawable.home_vp_message_point_narmal);
        }
        home_vp_message_tv_title.setText(title_text[position]);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
//当viewpager滑动状态改变时的回调
        /**
         * 有三个状态值：
         * SCROLL_STATE_IDLE：闲置状态
         * #SCROLL_STATE_DRAGGING：拖动状态
         *#SCROLL_STATE_SETTLING：固定状态
         */
    }

}
