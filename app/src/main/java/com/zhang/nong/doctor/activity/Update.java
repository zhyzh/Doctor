package com.zhang.nong.doctor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.UpdateAdapter2;
import com.zhang.nong.doctor.com.java.beans.MyDataaa;

import java.util.ArrayList;
import java.util.List;

public class Update extends AppCompatActivity {
    //第一步：找数据来源
    List<MyDataaa> mList = null;
    //第二步：找每一行视图
    //第三步：确定适配器：万能适配器：BaseAdapter
    UpdateAdapter2 mAdapter;
    ListView mListView;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.mine_update_message);
        mListView = (ListView) findViewById(R.id.listview);
        mImageView = (ImageView) findViewById(R.id.imageview);
        initData();//自定义初始化的方法
        mAdapter = new UpdateAdapter2(Update.this, mList);
        mListView.setAdapter(mAdapter);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //parent:代表整个listview,view:代表当前行的视图，position：代表用户单击了哪一行，从0开始，id表示每一行的id
//                MyDataaa myData = mList.get(position);
//                Intent intent = new Intent(Update.this,InformationActivity.class);
//                intent.putExtra("data",myData);
//                startActivity(intent);
                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        intent.setClass(Update.this, UpdateHeadeActivity.class);
                        startActivity(intent);
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        intent.setClass(Update.this, Mine_SexActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.setClass(Update.this, PassWordActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent.setClass(Update.this, AddressActivity.class);
                        startActivity(intent);
                        break;


                }
            }
        });
    }

    private void initData() {
        mList = new ArrayList<>();
        MyDataaa d1 = new MyDataaa("头像", R.mipmap.bg_next);
        MyDataaa d2 = new MyDataaa("昵称", R.mipmap.bg_next);
        MyDataaa d3 = new MyDataaa("真实姓名", R.mipmap.bg_next);
        MyDataaa d4 = new MyDataaa("手机号码", R.mipmap.bg_next);
        MyDataaa d5 = new MyDataaa("性别", R.mipmap.bg_next);
        MyDataaa d6 = new MyDataaa("修改密码", R.mipmap.bg_next);
        MyDataaa d7 = new MyDataaa("所在地", R.mipmap.bg_next);
        mList.add(d1);
        mList.add(d2);
        mList.add(d3);
        mList.add(d4);
        mList.add(d5);
        mList.add(d6);
        mList.add(d7);
    }
}
