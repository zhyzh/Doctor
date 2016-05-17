package com.zhang.nong.doctor.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by XCF on 2016/5/12.
 */
public class MyAdapter extends FragmentPagerAdapter {
    List<Fragment> mList;

    public MyAdapter(FragmentManager fm, List<Fragment> mList) {
        super(fm);
        this.mList = mList;
    }



    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
