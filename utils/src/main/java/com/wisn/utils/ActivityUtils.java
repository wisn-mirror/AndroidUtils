package com.wisn.utils;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created by wisn on 2017/10/11.
 */

public class ActivityUtils {
    /**
     * 判断cls是否是处于栈顶的activity
     *
     * @param cls
     */
    public static boolean isTopActivity(Context context, Class cls) {
        ActivityManager manager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);

        List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTaskInfos) {
            if (runningTaskInfo != null) {
                String topClss = runningTaskInfo.topActivity.getClassName();
                return topClss.equals(cls.getName());
            }
        }
        return false;
    }

    /**
     *
     * @param context
     * @return
     */
    public static String getTopActivity(Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);

        List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTaskInfos) {
            if (runningTaskInfo != null) {
                String topClss = runningTaskInfo.topActivity.getClassName();
                return topClss;
            }
        }
        return null;
    }
}
