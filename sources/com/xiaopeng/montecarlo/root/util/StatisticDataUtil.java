package com.xiaopeng.montecarlo.root.util;

import android.os.SystemClock;
/* loaded from: classes2.dex */
public class StatisticDataUtil {
    private static final long NAVI_INFO_OUTPUT_MIN_TIME = 15000;
    public static long sDREspSpeedInputCount;
    public static long sDREspSpeedInputTotalDelayTime;
    public static long sDRGnssInputCount;
    public static long sDRGnssTimestamp;
    public static long sDRIMUTimestamp;
    private static long sDRImuSensorInputCount;
    private static long sDRImuSensorInputTotalDelayTime;
    public static long sDRImuSensorOutputCount;
    public static long sDRImuSensorOutputTime;
    public static long sDRLastEspSpeedInputTime;
    public static long sDRLastGnssInputTime;
    public static long sDRLastGnssInputTotalDelayTime;
    private static long sDRLastImuSensorInputTime;
    private static long sDRLastScuSpeedInputTime;
    private static long sDRScuSpeedInputCount;
    private static long sDRScuSpeedInputTotalDelayTime;
    private static long sLastNaviInfoTimeStamp;

    public static long getDRLastImuSensorInputTime() {
        return sDRLastImuSensorInputTime;
    }

    public static long getDRImuSensorInputCount() {
        return sDRImuSensorInputCount;
    }

    public static long getDRImuSensorInputTotalDelayTime() {
        return sDRImuSensorInputTotalDelayTime;
    }

    public static long getDRLastScuSpeedInputTime() {
        return sDRLastScuSpeedInputTime;
    }

    public static long getDRScuSpeedInputCount() {
        return sDRScuSpeedInputCount;
    }

    public static long getDRScuSpeedInputTotalDelayTime() {
        return sDRScuSpeedInputTotalDelayTime;
    }

    public static long getDRLastEspSpeedInputTime() {
        return sDRLastEspSpeedInputTime;
    }

    public static long getDREspSpeedInputCount() {
        return sDREspSpeedInputCount;
    }

    public static long getDREspSpeedInputTotalDelayTime() {
        return sDREspSpeedInputTotalDelayTime;
    }

    public static long getDRLastGnssInputTime() {
        return sDRLastGnssInputTime;
    }

    public static long getDRGnssInputCount() {
        return sDRGnssInputCount;
    }

    public static long getDRLastGnssInputTotalDelayTime() {
        return sDRLastGnssInputTotalDelayTime;
    }

    public static long getDRGnssTimestamp() {
        return sDRGnssTimestamp;
    }

    public static void setDRGnssTimestamp(long j) {
        sDRGnssTimestamp = j;
    }

    public static long getDRIMUTimestamp() {
        return sDRIMUTimestamp;
    }

    public static void setDRIMUTimestamp(long j) {
        sDRIMUTimestamp = j;
    }

    public static void updateDRImuSensorInputTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = sDRLastImuSensorInputTime;
        if (0 != j) {
            sDRImuSensorInputTotalDelayTime += currentTimeMillis - j;
        }
        sDRImuSensorInputCount++;
        sDRLastImuSensorInputTime = currentTimeMillis;
    }

    public static void updateDRScuSpeedInputTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = sDRLastScuSpeedInputTime;
        if (0 != j) {
            sDRScuSpeedInputTotalDelayTime += currentTimeMillis - j;
        }
        sDRScuSpeedInputCount++;
        sDRLastScuSpeedInputTime = currentTimeMillis;
    }

    public static void updateDREspSpeedInputTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = sDRLastEspSpeedInputTime;
        if (0 != j) {
            sDREspSpeedInputTotalDelayTime += currentTimeMillis - j;
        }
        sDREspSpeedInputCount++;
        sDRLastEspSpeedInputTime = currentTimeMillis;
    }

    public static void updateDRGnssInputTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = sDRLastGnssInputTime;
        if (0 != j) {
            sDRLastGnssInputTotalDelayTime += currentTimeMillis - j;
        }
        sDRGnssInputCount++;
        sDRLastGnssInputTime = currentTimeMillis;
    }

    public static void resetDRStatistic() {
        sDRLastImuSensorInputTime = 0L;
        sDRImuSensorInputCount = 0L;
        sDRImuSensorInputTotalDelayTime = 0L;
        sDRLastScuSpeedInputTime = 0L;
        sDRScuSpeedInputCount = 0L;
        sDRScuSpeedInputTotalDelayTime = 0L;
        sDRLastEspSpeedInputTime = 0L;
        sDREspSpeedInputCount = 0L;
        sDREspSpeedInputTotalDelayTime = 0L;
        sDRLastGnssInputTime = 0L;
        sDRGnssInputCount = 0L;
        sDRLastGnssInputTotalDelayTime = 0L;
    }

    public static boolean needOutputNaviInfo() {
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = uptimeMillis - sLastNaviInfoTimeStamp >= NAVI_INFO_OUTPUT_MIN_TIME;
        if (z) {
            sLastNaviInfoTimeStamp = uptimeMillis;
        }
        return z;
    }
}
