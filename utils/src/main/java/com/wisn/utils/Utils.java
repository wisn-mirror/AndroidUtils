package com.wisn.utils;

import android.app.Application;

/**
 * Created by wisn on 2017/10/17.
 */

public class Utils {
    private  static Application application;
    public static void init(Application application){
        Utils.application=application;
    }
    public static Application getApp(){
        return application;
    }
}
