package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.zhang.nong.R;

/**
 * Created by XCF on 2016/5/25.
 */
public class AddressActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_address);
    }

    public void back(View view) {
        finish();
    }
}
