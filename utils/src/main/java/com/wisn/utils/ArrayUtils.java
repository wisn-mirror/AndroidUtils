package com.wisn.utils;

import java.util.List;

/**
 * Created by wisn on 2017/10/6.
 */

public class ArrayUtils {
    public static boolean isEmpty(List list){
       if(list==null||list.size()==0)return true;
        return false;
    }
}
