package com.wisn.utilstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wisn.utils.Base64Utils;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            String aa = Base64Utils.encode("admin:admin".getBytes());
            Log.d(TAG, aa);
            Log.d(TAG, new String(Base64Utils.decode(aa)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
