package com.zhang.nong.doctor.MyService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.nong.doctor.com.java.beans.Zhutei;
import com.zhang.nong.doctor.httpXutils.ReplyDemand;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public class ReqService extends Service {
    //声明一个链接网络工具类
    ReplyDemand replydemand = new ReplyDemand();
    String mPath = "http://shenwenjie.top/testServlet";

    //初始化获取网络数据类的对象
    //这里极易包类型转换异常


    List<Zhutei> list;

    MyBinder mBinder;

    //IBinder 接口中抽象方法太多，使用其子类
    public class MyBinder extends Binder {
        //android中四大组件禁止使用构造器初始化,所以这里提供一个共有的方法用来获取当前组件的对象
        public ReqService getMyService() {
            return ReqService.this;
        }
    }

    public ReqService() {

    }
//    1.  启动类型的服务: onCreate()- >onStartCommand()->Service running--调用context.stopService() ->onDestroy()
//
//    2.  绑定类型的服务: onCreate()->onBind()->Service running--调用>onUnbind() -> onDestroy()


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable

    @Override
    public IBinder onBind(Intent intent) {
        mBinder = new MyBinder();
        Log.w("MyService", "MyService onBind..........");
                //获取数据
//                list=replydemand.getTeizhi("1",mPath);

                //get请求
                //第一步：设置访问路径以及携带数据
//        RequestParams params=new RequestParams(mPath);
                RequestParams params = new RequestParams("http://shenwenjie.top/testServlet");
//        biaoname=user&req=demand&sum=1
                params.addQueryStringParameter("biaoname", "zhutei");
                params.addQueryStringParameter("req", "demand");
                params.addQueryStringParameter("sum", "1");
                //第二步：开始请求，设置请求方式，同时实现回调函数
        //这是一个异步操作，他会分两步走，一个执行异步，一个return，但是return之后activity就会拿到一个空的list

                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        //访问成功，参数其实就是PrintWriter写回的值
                        //把JSON格式的字符串改为Student对象
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<Zhutei>>() {
                        }.getType();
                        list = gson.fromJson(result, type);
                        Log.e("服务是否获取了数据",list.toString());
                        //通知activity我已经拿到数据



                        //这是需要我们手动关闭服务


                        stopSelf();


                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        //访问失败
                        Log.e("fsd", "错误原因：" + ex.getMessage());
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



        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public List<Zhutei> getTeizhi() {
        return list;

    }

    public String getservice() {
        return "我是服务";
    }
}
