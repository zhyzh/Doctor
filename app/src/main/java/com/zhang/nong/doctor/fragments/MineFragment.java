package com.zhang.nong.doctor.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zhang.nong.R;
import com.zhang.nong.doctor.activity.LoginActivity;


/**
 * Created by XCF on 2016/5/12.
 */
public class MineFragment extends Fragment {
    TextView mTextView1, mTextView2, mTextView3, mTextView4;
    FragmentActivity mFeedBackActivity;
    Button mButton;

//onCreateView设置当前碎片对应的布局文件
@Nullable
@Override
public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.mine_mine,null);
    mButton = (Button) view.findViewById(R.id.button);
    mTextView1 = (TextView) view.findViewById(R.id.textview1);
    mTextView2 = (TextView) view.findViewById(R.id.textview2);
    mTextView3 = (TextView) view.findViewById(R.id.textview3);
    mTextView4 = (TextView) view.findViewById(R.id.textview4);

    initListener();
    return view;

}

    private void initListener() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
