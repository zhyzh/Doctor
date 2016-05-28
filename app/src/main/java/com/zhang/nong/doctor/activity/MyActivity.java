package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhang.nong.R;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_acvivity);
    }

    public void back(View view) {
        Intent intent = new Intent(MyActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
