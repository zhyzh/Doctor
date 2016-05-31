package com.zhang.nong.doctor.activity;
//农机发布

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.zhang.nong.R;

public class Home_Agricultural_Machinery_Publish_Activity extends AppCompatActivity {

    ImageView iv_agr_mac_publish_back;
    Spinner spinner_mac_publish_type, spinner_machinery_type_class;
    String[][] machinery_class = {{"全部"},
            {"翻转犁", "开沟机", "旋耕机", "圆盘犁", "铧式犁", "栅条犁", "田园管理机", "浅松机", "深松机"},
            {"水稻插秧机", "水稻摆秧机", "油菜载植机", "免耕播种机", "小粒种子播种机",
                    "地膜覆盖机", "残膜回收机", "种子处理设备", "营养钵压制机"},
            {"施肥机", "撒肥机", "追肥机", "农用飞行器", "中耕追肥机"},
            {"除草机", "埋藤机", "喷雾器", "弥雾机", "烟雾机", "杀虫灯"},
            {"小麦收割机", "玉米收割机", "玉米剥皮机", "水稻收割机", "棉花收割机",
                    "草莓收割机", "采茶机", "花卉采收机", "甘蔗收获机"},
            {"割草机", "玉米脱粒机", "大蒜剥皮机", "挖掘机", "拖拉机", "推土机", "水泵",
                    "榨油机", "农用吊车", "农用叉车", "孵化机"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_agricultural_machinery_publish);
        initViews();
        initDatas();
        initEvent();
    }

    //初始化
    private void initViews() {
        //初始化返回键
        iv_agr_mac_publish_back = (ImageView) findViewById(R.id.iv_agr_mac_publish_back);
        //初始化spinner列表
        spinner_mac_publish_type = (Spinner) findViewById(R.id.spinner_mac_publish_type);
        spinner_machinery_type_class = (Spinner) findViewById(R.id.spinner_machinery_type_class);
    }

    //数据
    private void initDatas() {

    }

    //需要监听的事件
    private void initEvent() {

        //监听spinner1的点击事件
        spinner_mac_publish_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //更新spinner2中的数据
                ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (Home_Agricultural_Machinery_Publish_Activity.this, android.R.layout.simple_spinner_item,
                                machinery_class[(int) parent.getSelectedItemId()]);
                //设置下拉框的样本
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                //设置spinner2的适配器
                spinner_machinery_type_class.setAdapter(adapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
