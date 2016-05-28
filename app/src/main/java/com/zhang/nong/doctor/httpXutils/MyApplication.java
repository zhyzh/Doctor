package com.zhang.nong.doctor.httpXutils;



import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/5/18 0018.
 */
public class MyApplication extends Application {
    //?biaoname=user&req=demand&sum=1查询(get)
    //?biaoname=user&req=add&a=*&b*查询(get)abc是该表属性按顺序的
    //?biaoname=user&req=de&id=**删除(get)
    //?biaoname=user&req=am&a=/b=/c/修改(get)abc是该表属性按顺序的这个需要对数据进行会写
    //?req=login&phone=**&password=***登录(post)
//    private String url = "http://shenwenjie.top/testServlet";
    private String url = "http://10.58.250.148:8080/nongboshi_web_001/servlet/ConServlet";
//    private String url="http://login.guanweiming.top/json/user?action=getAll&username=root&password=root";
    //Application的onCreate早于所有的Activity的onCreate方法
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        // 是否输出debug日志, 开启debug会影响性能.
//        x.Ext.setDebug(BuildConfig.DEBUG);
    }

    public String getUrl() {
        return url;
    }
}
