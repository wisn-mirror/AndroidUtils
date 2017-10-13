package com.wisn.utilstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wisn.utils.Base64Utils;
import com.wisn.utils.DeviceUtils;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            String
                    aa =
                    Base64Utils.encode(
                            "arewqewqr432143213421ewqrew432143qrewqrewqre0043243214321wqrewqrewdmin:4321admin"
                                    .getBytes());
            Log.d(TAG, aa);
            Log.d(TAG, new String(Base64Utils.decode(aa)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onclick(View v) {
        for (int i = 0; i < 5; i++) {
            int processCpuRate = DeviceUtils.getProcessCpuRate();
            Log.d(TAG, "" + processCpuRate);
        }
    }
}
