package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhang.nong.R;

public class Mine_MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_mine);
    }

    public void back(View view) {
        Intent intent = new Intent(Mine_MyActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
