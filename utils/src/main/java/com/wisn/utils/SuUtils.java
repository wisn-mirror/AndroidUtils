package com.wisn.utils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by wisn on 2017/3/13.
 * system need rooted
 */

public class SuUtils {

    public static String TAG = "SuUtils";
    private static Process process;

    /**
     * 结束进程,执行操作调用即可
     */
    public static void kill(String packageName) {
        initProcess();
        killProcess(packageName);
        close();
    }

    /**
     *
     * @param packageName
     */
    public static void enable(String packageName) {
        initProcess();
        enableApp(packageName);
        close();
    }

    /**
     *
     * @param packageName
     */
    public static void disable(String packageName) {
        initProcess();
        disableApp(packageName);
        close();
    }

    /**
     *
     * @param packageName
     */
    public static void unInstall(String packageName) {
        initProcess();
        work(" uninstall " + packageName + " \n");
        close();

    }


    /**
     * @param pid
     */
    public static void killProcessByPID(int pid) {
        //android.os.Process.killProcess(pid);
        initProcess();
        String cmd = " kill  " + pid + " \n";
        work(cmd);
        close();
    }

    /**
     * 结束进程
     */
    private static void killProcess(String packageName) {
        String cmd = "am force-stop  " + packageName + " \n";
        work(cmd);
    }


    /**
     * 初始化进程
     */
    private static void initProcess() {
        if (process == null)
            try {
                process = Runtime.getRuntime().exec("su");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    /**
     * @param packageName
     */
    private static void enableApp(String packageName) {
        String cmd = "pm enable  " + packageName + " \n";
        work(cmd);

    }

    /**
     * @param packageName
     */
    private static void disableApp(String packageName) {
        String cmd = "pm disable  " + packageName + " \n";
        work(cmd);
    }

    /**
     * 结束进程
     */
    private static void work(String cmd) {
        OutputStream out = process.getOutputStream();
        String cmds = cmd + " \n";
        try {
            out.write(cmds.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭输出流
     */
    private static void close() {
        if (process != null)
            try {
                process.getOutputStream().close();
                process = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
