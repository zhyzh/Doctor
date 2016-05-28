package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.UpdateAdapter;
import com.zhang.nong.doctor.com.java.beans.MyDataaa;
import com.zhang.nong.doctor.com.java.beans.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XCF on 2016/5/21.
 */
public class PeopleCenterActivity extends Activity {
    TextView mTextView;
    ImageView mImageView1, mImageView2, mImageView3, mImageView4;
    List<MyDataaa> mList = null;
    //第二步：找每一行视图
    //第三步：确定适配器：万能适配器：BaseAdapter
    UpdateAdapter mAdapter;
    ListView mListView;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_peoplecenter);

        mTextView = (TextView) findViewById(R.id.name);
        mImageView1 = (ImageView) findViewById(R.id.shoucang);
        mImageView2 = (ImageView) findViewById(R.id.guanzhu);
        mListView = (ListView) findViewById(R.id.listview);

      //  mTextView.setText(user.getUserName());

        initData();//自定义初始化的方法
        mAdapter = new UpdateAdapter(PeopleCenterActivity.this, mList);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                switch (position) {
                    case 0:

                        break;
                    case 1:
                        intent.setClass(PeopleCenterActivity.this, Update.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.setClass(PeopleCenterActivity.this, HelpCenterActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.setClass(PeopleCenterActivity.this, AboutActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.setClass(PeopleCenterActivity.this, FeedBackActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        });
    }



    private void initData() {
        mList = new ArrayList<>();
        MyDataaa d1 = new MyDataaa("我的农机", R.mipmap.bg_next);
        MyDataaa d2 = new MyDataaa("修改信息", R.mipmap.bg_next);
        MyDataaa d3 = new MyDataaa("帮助中心", R.mipmap.bg_next);
        MyDataaa d4 = new MyDataaa("关于我们", R.mipmap.bg_next);
        MyDataaa d5 = new MyDataaa("意见反馈", R.mipmap.bg_next);

        mList.add(d1);
        mList.add(d2);
        mList.add(d3);
        mList.add(d4);
        mList.add(d5);
        //获取登录界面传值过来的user对象
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        if (bundle!=null){
            user= (User) bundle.getSerializable("pravite");
            Log.e("是否拿到user信息","是的user为"+user.toString());

        }
    }

    public void back(View view) {
        finish();
    }

    public void back1(View view) {
        Intent intent = new Intent(PeopleCenterActivity.this,CollectActivity.class);
        startActivity(intent);
    }

    public void back2(View view) {
        Intent intent = new Intent(PeopleCenterActivity.this,AttentionActivity.class);
        startActivity(intent);
    }

    public void back3(View view) {
    }

    public void back4(View view) {
    }
}

