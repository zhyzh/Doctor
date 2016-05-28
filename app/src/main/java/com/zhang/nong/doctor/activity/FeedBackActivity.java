package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zhang.nong.R;


/**
 * Created by XCF on 2016/5/18.
 */
public class FeedBackActivity extends Activity{
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_feedback);
        mImageView = (ImageView) findViewById(R.id.imageview);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void back(View view) {

    }
}
