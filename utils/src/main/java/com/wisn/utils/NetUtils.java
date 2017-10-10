package com.wisn.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wisn on 2017/6/16.
 */

public class NetUtils {

    /**
     * 判断服务器是否链接正常
     *
     * @param path
     *
     * @return
     */
    public static boolean isConnectServer(String path) {
        boolean isconnect = false;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(path);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(20000);
            if (200 == urlConnection.getResponseCode()) {
                isconnect = true;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            return isconnect;
        }
    }

    /**
     * 检测网络是否连接
     *
     * @return
     */
    public static  boolean isNetConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo[] infos = cm.getAllNetworkInfo();
            if (infos != null) {
                for (NetworkInfo ni : infos) {
                    if (ni.isConnected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 检测wifi是否连接
     *
     * @return
     */
    public static boolean isWifiConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null
                && networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检测3G是否连接
     *
     * @return
     */
    public static boolean is3gConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null
                && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            }
        }
        return false;
    }
}
