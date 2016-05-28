package com.zhang.nong.doctor.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zhang.nong.R;


/**
 * Created by XCF on 2016/5/12.
 */
public class MineFragment extends Fragment {
Button mButton;

//onCreateView设置当前碎片对应的布局文件
@Nullable
@Override
public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.mine_mine,null);
    mButton = (Button) view.findViewById(R.id.button);
 /*   mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
//            intent.setAction(getActivity(), GoodActivity.class);
            startActivity(intent);

        }
    });*/
    return view;

}
}
