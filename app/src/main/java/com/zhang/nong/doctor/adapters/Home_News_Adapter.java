package com.zhang.nong.doctor.adapters;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by zhangyunzhen on 2016/5/25.
 */
public class Home_News_Adapter extends PagerAdapter {
private List<ImageView> mListDatas;
private ViewPager home_vp_pager;

//返回的是页面的数量
@Override
public int getCount() {
	if (mListDatas != null) {
		return Integer.MAX_VALUE;
	}
	return 0;
}

//标记方法，用来判断缓存的标记
@Override
public boolean isViewFromObject(View view, Object object) {
	//view：显示的view
	//object：标记


	return view == object;
	//有缓存就返回truth，没有缓存就返回false
}

//初始化item(显示的每个条目)
@Override
public Object instantiateItem(ViewGroup container, int position) {

	//初始化，用来添加要显示的view
	position = position % mListDatas.size();
	ImageView iv = mListDatas.get(position);//position：要加载的位置
	//用来添加显示的view
	home_vp_pager.addView(iv);

	//记录缓存标记--return标记
	return iv;
}

//销毁item条目
@Override
public void destroyItem(ViewGroup container, int position, Object object) {
	//销毁移除item
	position = position % mListDatas.size();
	ImageView iv = mListDatas.get(position);
	home_vp_pager.removeView(iv);
	//object：标记


}
}
