package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.nong.R;
import com.zhang.nong.doctor.adapters.UpdateAdapter;
import com.zhang.nong.doctor.com.java.beans.Collect;
import com.zhang.nong.doctor.com.java.beans.Log;
import com.zhang.nong.doctor.com.java.beans.MyDataaa;
import com.zhang.nong.doctor.com.java.beans.User;
import com.zhang.nong.doctor.httpXutils.MyApplication;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends Activity {
    public static final String TAG = "collection";
    //第一步：找数据来源
    List<Log> mList = null;
    //第二步：找每一行视图
    //第三步：确定适配器：万能适配器：BaseAdapter
    UpdateAdapter mAdapter;
    ListView mListView;
    ImageView mImageView;
    String mPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_collect);
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
               Log myData = mList.get(position);
                Toast.makeText(CollectActivity.this,myData.getTitle(),Toast.LENGTH_SHORT).show();;
                //Intent intent = new Intent(CollectActivity.this,InformationActivity.class);
               // intent.putExtra("data",myData);
               // startActivity(intent);
            }
        });
    }

    private void initData() {
        mList = new ArrayList<>();
//        MyDataaa d1 = new MyDataaa("如何注重植物营养",R.mipmap.bg_next);
//        MyDataaa d2 = new MyDataaa("西红柿种植注意事项",R.mipmap.bg_next);
//        MyDataaa d3 = new MyDataaa("玉米生长周期",R.mipmap.bg_next);
//        MyDataaa d4 = new MyDataaa("水稻种植手册",R.mipmap.bg_next);
//
//        mList.add(d1);
//        mList.add(d2);
//        mList.add(d3);
//        mList.add(d4);
        //get请求
        //第一步：设置访问路径以及携带数据
        MyApplication myApplication = (MyApplication) getApplication();
        mPath = myApplication.getUrl();
        RequestParams params=new RequestParams(mPath);
      //RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
        //biaoname=user&req=demand&sum=1
        params.addQueryStringParameter("biaoname","collect");
        params.addQueryStringParameter("req","demand");
        params.addQueryStringParameter("sum","1");
        params.addQueryStringParameter("id","2");
        //第二步：开始请求，设置请求方式，同时实现回调函数
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //访问成功，参数其实就是PrintWriter写回的值
                //把JSON格式的字符串改为Student对象
                Gson gson = new Gson();
                Type type = new TypeToken<List<Log>>(){}.getType();
                mList  = gson.fromJson(result,type);
                //已经获取到了服务器传递回来的数据，及时刷新界面
                mAdapter.notifyDataSetChanged();
                //tv.setText(list.toString());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //访问失败
                android.util.Log.e(TAG,"错误原因：" + ex.getMessage() );
            }

            @Override
            public void onCancelled(CancelledException cex) {
                //访问取消
            }

            @Override
            public void onFinished() {
                //访问完成
            }
        });
    }

    public void back(View view) {
        finish();
    }
}
