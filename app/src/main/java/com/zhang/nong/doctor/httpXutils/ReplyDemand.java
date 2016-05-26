package com.zhang.nong.doctor.httpXutils;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.nong.doctor.com.java.beans.Reply;
import com.zhang.nong.doctor.com.java.beans.User;
import com.zhang.nong.doctor.com.java.beans.Zhutei;

import org.apache.http.client.HttpClient;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public class ReplyDemand {
    private static final String TAG = "XUTILS";
    private HttpClient client;
    String mPath;

    List<Reply> mReplyList;
    //获取帖子
    List<Zhutei> mZhuteis;

    public List<Reply> getRreply(String sum, String Path) {
        //get请求
        //第一步：设置访问路径以及携带数据
        mPath = Path;
        RequestParams params = new RequestParams(mPath);
        params.addQueryStringParameter("biaoname", "user");
        params.addQueryStringParameter("req", "demand");
        params.addQueryStringParameter("sum", sum);
        //第二步：开始请求，设置请求方式，同时实现回调函数
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                //访问成功，参数其实就是PrintWriter写回的值
                //把JSON格式的字符串改为Student对象
                Gson gson = new Gson();

                //是获取帖子的集合
                Type type = new TypeToken<List<Reply>>() {
                }.getType();
                //把字符解析成帖子的集合
                mReplyList = gson.fromJson(result, type);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //访问失败
                Log.e(TAG, "错误原因：" + ex.getMessage());
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

        return mReplyList;


    }

    //获取帖子的网络数据
    public List<Zhutei> getTeizhi() {
        //get请求
        //第一步：设置访问路径以及携带数据
//        RequestParams params=new RequestParams(mPath);
      RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
//        biaoname=user&req=demand&sum=1
        params.addQueryStringParameter("biaoname","zhutei");
        params.addQueryStringParameter("req","demand");
        params.addQueryStringParameter("sum","1");
        //第二步：开始请求，设置请求方式，同时实现回调函数
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //访问成功，参数其实就是PrintWriter写回的值
                //把JSON格式的字符串改为Student对象
                Gson gson = new Gson();
                Type type = new TypeToken<List<Zhutei>>(){}.getType();
                mZhuteis= gson.fromJson(result,type);


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //访问失败
                Log.e("fsd","错误原因：" + ex.getMessage() );
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

        return mZhuteis;


    }

}
