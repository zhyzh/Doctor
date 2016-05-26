package com.zhang.nong.doctor.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhang.nong.R;

public class ForumnewteiActivity extends AppCompatActivity {
    //发帖的布局

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_newtei);
    }

    public void onbak(View view) {
        onBackPressed();
    }
}
