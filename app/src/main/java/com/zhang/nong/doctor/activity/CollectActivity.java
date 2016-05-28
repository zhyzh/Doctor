package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.UpdateAdapter;
import com.zhang.nong.doctor.com.java.beans.MyDataaa;
import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends Activity {
    //第一步：找数据来源
    List<MyDataaa> mList = null;
    //第二步：找每一行视图
    //第三步：确定适配器：万能适配器：BaseAdapter
    UpdateAdapter mAdapter;
    ListView mListView;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        mListView = (ListView) findViewById(R.id.listview);
        mImageView = (ImageView) findViewById(R.id.imageview);
        initData();//自定义初始化的方法
        mAdapter = new UpdateAdapter(CollectActivity.this,mList);
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
                MyDataaa myData = mList.get(position);
                //Intent intent = new Intent(CollectActivity.this,InformationActivity.class);
               // intent.putExtra("data",myData);
               // startActivity(intent);
            }
        });
    }

    private void initData() {
        mList = new ArrayList<>();
        MyDataaa d1 = new MyDataaa("如何注重植物营养",R.mipmap.bg_next);
        MyDataaa d2 = new MyDataaa("西红柿种植注意事项",R.mipmap.bg_next);
        MyDataaa d3 = new MyDataaa("玉米生长周期",R.mipmap.bg_next);
        MyDataaa d4 = new MyDataaa("水稻种植手册",R.mipmap.bg_next);

        mList.add(d1);
        mList.add(d2);
        mList.add(d3);
        mList.add(d4);
    }

    public void back(View view) {
        finish();
    }
}
