package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhang.nong.R;


/**
 * Created by XCF on 2016/5/21.
 */
public class UpdateMessageActivity extends Activity {

    TextView mTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_update_message);
        mTextView3 = (TextView) findViewById(R.id.textview3);
        initListener();
    }

    private void initListener() {
        mTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(UpdateMessageActivity.this,InformationActivity.class);
//                startActivity(intent);
            }
        });
    }


    public void xiangqing(View view) {
        Intent intent = new Intent();
        intent.setClass(UpdateMessageActivity.this,InformationActivity.class);
        startActivity(intent);

    }
}
