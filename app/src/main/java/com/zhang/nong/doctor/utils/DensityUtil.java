package com.zhang.nong.doctor.utils;

import android.content.Context;

/**
 * Created by zhangyunzhen on 2016/5/24.
 */
public class DensityUtil {
/*根据手机的分辨率从dp的单位转化为px（像素）*/
public static int dip2px(Context context,float dpValue){
	final float scale=context.getResources().getDisplayMetrics().density;
	return (int)(dpValue*scale+0.5f);
}
/*根据手机的分辨率从px的单位转化为dp*/

public static int px2dip(Context context,float pxValue){
	final float scale=context.getResources().getDisplayMetrics().density;
	return (int) (pxValue/scale+0.5f);
}

}
