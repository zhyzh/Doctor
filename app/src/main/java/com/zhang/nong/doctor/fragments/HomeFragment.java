package com.zhang.nong.doctor.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.activity.ActivityNews;
import com.zhang.nong.doctor.activity.Home_Agricultural_Machinery_Detail_Info_Activity;
import com.zhang.nong.doctor.activity.Home_Agricultural_Book_Activity;
import com.zhang.nong.doctor.activity.Home_Agricultural_Machinery_Activity;
import com.zhang.nong.doctor.activity.Home_Agricultural_Tool_Product_Activity;
import com.zhang.nong.doctor.activity.Home_Agricultural_Weather_Activity;
import com.zhang.nong.doctor.activity.Home_Day_Know_Activity;
import com.zhang.nong.doctor.activity.Home_professor_Activity;
import com.zhang.nong.doctor.adapters.Home_recommend_Adapter;
import com.zhang.nong.doctor.com.java.beans.Machine;
import com.zhang.nong.doctor.packaging.Home_Image_CycleView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by XCF on 2016/5/12.
 */
public class HomeFragment extends Fragment {
    private Home_Image_CycleView mCycleView;
    private View home_view;
     List<Machine> mMachineList;
     Machine mMachine, mMachine2;
     Home_recommend_Adapter mHome_recommend_adapter;
    private ListView mListView;
    private ImageView zhuanjia;
    private ImageView nongzi;
    private ImageView nongji;
    private ImageView dayknow;
    private ImageView agricultural_shuku;
    private ImageView agricultural_weather;
     ImageView iv_home_search;
    ImageView iv_home_message;

    private LayoutInflater mInflater;
    private View headView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        home_view = inflater.inflate(R.layout.home_main, null);

        mInflater = LayoutInflater.from(getContext());


        initviews();
        initDatas();
        initEvent();
        return home_view;

    }

    private void initviews() {

        headView = mInflater.inflate(R.layout.home_title_bar, null);
        mCycleView = (Home_Image_CycleView) headView.findViewById(R.id.home_icv_topView);
        mListView = (ListView) home_view.findViewById(R.id.home_commend_listview);
        //获取找专家
        zhuanjia = (ImageView) headView.findViewById(R.id.iv_home_doctor);
        //农资
        nongzi = (ImageView) headView.findViewById(R.id.iv_home_agricultural);
        //农机服务
        nongji = (ImageView) headView.findViewById(R.id.iv_home_marchinery);
        //每日知道
        dayknow = (ImageView) headView.findViewById(R.id.iv_home_day);
        //农业书库
        agricultural_shuku = (ImageView) headView.findViewById(R.id.iv_home_book);
        //天气
        agricultural_weather = (ImageView) headView.findViewById(R.id.iv_home_weather);
        //获取搜索图标
        iv_home_search = (ImageView) home_view.findViewById(R.id.iv_home_search);
        //获取消息图标
        iv_home_message= (ImageView) home_view.findViewById(R.id.iv_home_message);

    }

    //初始化数据
    private void initDatas() {

        //获取本地的轮播图片
        List<Home_Image_CycleView.ImageInfo> list = new ArrayList<Home_Image_CycleView.ImageInfo>();

        //res图片资源
        list.add(new Home_Image_CycleView.ImageInfo(R.drawable.iv_home_view_pager1, "现代农业", ""));
        list.add(new Home_Image_CycleView.ImageInfo(R.drawable.iv_home_view_pager2, "发展现代农业", ""));
        list.add(new Home_Image_CycleView.ImageInfo(R.drawable.iv_home_view_pager3, "发展专业合作", ""));

        mCycleView.loadData(list, new Home_Image_CycleView.LoadImageCallBack() {
            @Override
            public ImageView loadAndDisplay(Home_Image_CycleView.ImageInfo imageInfo) {

                //本地图片
                ImageView imageView = new ImageView(getActivity());
                imageView.setImageResource(Integer.parseInt(imageInfo.image.toString()));
                return imageView;

            }
        });


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
        mListView.addHeaderView(headView);//添加头布局
        mListView.setAdapter(mHome_recommend_adapter);

    }

    //事件
    private void initEvent() {
        //点击消息调转到消息界面
        iv_home_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //页面跳转
                Intent intent=new Intent(getActivity(), ActivityNews.class);
                startActivity(intent);
            }
        });

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
                        Home_Agricultural_Tool_Product_Activity.class);
                startActivity(intent);

            }
        });

        //监听点击农机图标事件
        nongji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到农机界面
                Intent intent = new Intent(getActivity(),
                        Home_Agricultural_Machinery_Activity.class);
                startActivity(intent);

            }
        });
        //监听点击每日知道图标事件
        dayknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到每日知道界面
                Intent intent = new Intent(getActivity(),
                        Home_Day_Know_Activity.class);
                startActivity(intent);

            }
        });
        //监听点击农业书库图标事件
        agricultural_shuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到农业书库界面
                Intent intent = new Intent(getActivity(),
                        Home_Agricultural_Book_Activity.class);
                startActivity(intent);

            }
        });
        //监听点击农事天气图标事件
        agricultural_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到农事天气界面
                Intent intent = new Intent(getActivity(),
                        Home_Agricultural_Weather_Activity.class);
                startActivity(intent);

            }
        });
        //监听listview单击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //取得列表当前行绑定的数据
                Machine machine = (Machine) parent.getItemAtPosition(position);

                //定义意图
                Intent intent = new Intent(getActivity(), Home_Agricultural_Machinery_Detail_Info_Activity.class);
                //传值
                intent.putExtra("agricultural_machinery_detail", machine);

                getActivity().startActivity(intent);
            }
        });


    }


}
