package com.wisn.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wisn on 2017/10/13.
 */

public class DeviceUtils {

    /**
     * 检测GPS是否打开
     *
     * @return
     */
    public static boolean isGpsEnabled(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        List<String> accessibleProviders = lm.getProviders(true);
        for (String name : accessibleProviders) {
            if ("gps".equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the network operator name.
     *
     * @return - Network operator name.
     */
    public static String getNetworkOperatorName(Context context) {
        TelephonyManager
                telephonyManager =
                (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getSimOperatorName();
    }

    /**
     * Returns the device model.
     *
     * @return - Device model.
     */
    public static String getDeviceModel() {
        return android.os.Build.MODEL;
    }

    /**
     * Returns the device manufacturer.
     *
     * @return - Device manufacturer.
     */
    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }


    /**
     * Returns the OS version.
     *
     * @return - Device OS version.
     */
    public static String getOsVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * Returns the SDK Version number.
     *
     * @return - Device android SDK version number.
     */
    public static int getSdkVersion() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * Returns the IMEI Number.
     *
     * @return - Device IMEI number.
     */
    public static String getDeviceId(Context context) {
        String deviceId = null;
        TelephonyManager
                telephonyManager =
                (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            deviceId = telephonyManager.getDeviceId();
        }
        if (deviceId == null || deviceId.isEmpty()) {
            deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        Pattern p = Pattern.compile("IMEI", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(deviceId);
        deviceId = m.replaceAll(" ").replace(":", " ");
        return deviceId.trim();
    }

    /**
     * Returns the IMSI Number.
     *
     * @return - Device IMSI number.
     */
    public static String getIMSINumber(Context context) {
        TelephonyManager
                telephonyManager =
                (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getSubscriberId();
    }

    /**
     * Returns the device WiFi MAC.
     *
     * @return - Device WiFi MAC.
     */
    public static String getMACAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        return wInfo.getMacAddress();
    }

    /**
     * Returns the SIM serial number.
     *
     * @return - Device SIM serial number.
     */
    public static String getSimSerialNumber(Context context) {
        TelephonyManager
                telephonyManager =
                (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getSimSerialNumber();
    }

    /**
     * Returns the hardware serial number.
     *
     * @return - Hardware serial number.
     */
    public static String getDeviceSerialNumber() {
        return Build.SERIAL;
    }

    /**
     * Returns all the sensors available on the device as a List.
     *
     * @return - List of all the sensors available on the device.
     */
    public static List<Sensor> getAllSensors(Context context) {
        SensorManager sensorManager =
                (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);

        return sensorManager.getSensorList(Sensor.TYPE_ALL);
    }

}
