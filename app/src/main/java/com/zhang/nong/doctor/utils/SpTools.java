package com.zhang.nong.doctor.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhangyunzhen on 2016/5/24.
 */
public class SpTools {
/*
* key就是关键字，value就是对应的值*/
public static void setBoolean(Context context,String key, boolean value){
	SharedPreferences sp = context.getSharedPreferences
			(MyConstants.CONFIGFILF, Context.MODE_PRIVATE);
	sp.edit().putBoolean(key,value).commit();
	//提交保存键值对

};

/*
* key就是关键字，defValue设置的默认值*/
public static boolean getBoolean(Context context,String key, boolean defValue){
	SharedPreferences sp = context.getSharedPreferences
			(MyConstants.CONFIGFILF, Context.MODE_PRIVATE);
	return sp.getBoolean(key,defValue);
};
}
