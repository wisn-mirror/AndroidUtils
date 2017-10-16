package com.wisn.utilstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wisn.utils.Base64Utils;
import com.wisn.utils.DateUtils;
import com.wisn.utils.DeviceUtils;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View v) {
        try {
            testDeviceUtils();
            testBase64Utils();
            testDateUtils();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testDeviceUtils() {
        for (int i = 0; i < 5; i++) {
            int processCpuRate = DeviceUtils.getProcessCpuRate();
            Log.d(TAG, "" + processCpuRate);
        }
    }

    public void testDateUtils() {
        String date1 = "2017-10-16 13:20:22";
        String date2 = "2017-10-15 13:20:23";
        String date3 = "2017-10-16 19:20:22";
        String date4 = "2017-01-16 13:20:22";
        Calendar c1 = DateUtils.getCalendarByStr(date1, "yyyy-MM-dd HH:mm:ss");
        Calendar c2 = DateUtils.getCalendarByStr(date2, "yyyy-MM-dd HH:mm:ss");
        Calendar c3 = DateUtils.getCalendarByStr(date3, "yyyy-MM-dd HH:mm:ss");
        Calendar c4 = DateUtils.getCalendarByStr(date4, "yyyy-MM-dd HH:mm:ss");
        Log.d(TAG, date1 + date2 + "isSameDay" + DateUtils.isSameDay(c1, c2));
        Log.d(TAG, date1 + date3 + "isSameDay" + DateUtils.isSameDay(c1, c3));
        Log.d(TAG, date1 + date4 + "isSameDay" + DateUtils.isSameDay(c1, c4));
        Log.d(TAG, date1 + date2 + "isBefore " + DateUtils.isBefore(c1, c2));
        Log.d(TAG, date1 + date3 + "isBefore " + DateUtils.isBefore(c1, c3));
        Log.d(TAG, date1 + date4 + "isBefore " + DateUtils.isBefore(c1, c4));
    }

    private void testBase64Utils() throws UnsupportedEncodingException {
        String
                aa =
                Base64Utils.encode(
                        "arewqewqr432143213421ewqrew432143qrewqrewqre0043243214321wqrewqrewdmin:4321admin"
                                .getBytes());
        Log.d(TAG, aa);
        Log.d(TAG, new String(Base64Utils.decode(aa)));
    }
}
