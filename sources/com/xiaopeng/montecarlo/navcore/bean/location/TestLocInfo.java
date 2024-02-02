package com.xiaopeng.montecarlo.navcore.bean.location;

import com.autonavi.common.tool.FDManager;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class TestLocInfo {
    private static final float ACCEL_G_VALUE = 9.80665f;
    public static final float ACCEL_XYZ_MAX_VALUE = 4.0f;
    public static final float ACCEL_XYZ_MIN_VALUE = -4.0f;
    public static final int CNO_THRESHOLD_MIN_VALUE = 36;
    public static final float GYR_MAX_TEMP = 80.0f;
    public static final float GYR_MIN_TEMP = -40.0f;
    public static final float GYR_XYZ_MAX_ANGLE = 250.0f;
    public static final float GYR_XYZ_MIN_ANGLE = -250.0f;
    public static final int LOC_ACCURACY_MIN_VALUE = 20;
    public static final float LOC_HDOP_MAX_DISTANCE = 5.0f;
    public static final int LOC_SATELITE_CNO_MIN_VALUE = 40;
    public static final int LOC_SATELITE_CNO_NORMAL_COUNT = 5;
    public static final float LOC_SPEED_MAX_DISTANCE = 1.0f;
    private final Object $lock = new Object[0];
    private long mTtffStartTime = 0;
    private long mTtffEndTime = 0;
    private long mTtffTime = 0;
    private int mLocSuccessCount = 0;
    private int mLocFailCount = 0;
    private int mLocAccuracyOverCount = 0;
    private int mLocCnoUnexpectCount = 0;
    private int mLocSateLiteCount = 0;
    private int mLocGpsSateLiteCount = 0;
    private int mLocCpsSateLiteCount = 0;
    private int mLocGalSateLiteCount = 0;
    private int mLocSateLiteCnoAve = 0;
    private int mLocSateLiteCnoMax = 0;
    private int mLocHdopUnexpectCount = 0;
    private int mLocSpeedUnexpectCount = 0;
    private int mGyrXyzUnexpectCount = 0;
    private int mGyrTmepUnexpectCount = 0;
    private int mAccelSpeedUnexpectCount = 0;
    private int mLocDropFrameCount = 0;
    private int mLocGnssOutageCount = 0;
    private int mLocInfoErrorCount = 0;

    public static boolean isAccelXyzNormal(float f, float f2, float f3) {
        float f4 = f / ACCEL_G_VALUE;
        float f5 = f2 / ACCEL_G_VALUE;
        float f6 = f3 / ACCEL_G_VALUE;
        return f4 >= -4.0f && f4 <= 4.0f && f5 >= -4.0f && f5 <= 4.0f && f6 >= -4.0f && f6 <= 4.0f;
    }

    public static boolean isGyrTempNormal(float f) {
        return f >= -40.0f && f <= 80.0f;
    }

    public static boolean isGyrXyzNormal(float f, float f2, float f3) {
        return f >= -250.0f && f <= 250.0f && f2 >= -250.0f && f2 <= 250.0f && f3 >= -250.0f && f3 <= 250.0f;
    }

    public void autoIncrementSuccessCount() {
        synchronized (this.$lock) {
            this.mLocSuccessCount++;
        }
    }

    public void autoIncrementFailCount() {
        synchronized (this.$lock) {
            this.mLocFailCount++;
        }
    }

    public void autoAccuraryOverCount() {
        synchronized (this.$lock) {
            this.mLocAccuracyOverCount++;
        }
    }

    public void autoLocCnoUnexpectCount() {
        synchronized (this.$lock) {
            this.mLocCnoUnexpectCount++;
        }
    }

    public void autoLocHdopUnexpectCount() {
        synchronized (this.$lock) {
            this.mLocHdopUnexpectCount++;
        }
    }

    public void autoLocSpeedUnexpectCount() {
        synchronized (this.$lock) {
            this.mLocSpeedUnexpectCount++;
        }
    }

    public void autoGyrXyzUnexpectCount() {
        synchronized (this.$lock) {
            this.mGyrXyzUnexpectCount++;
        }
    }

    public void autoGyrTmepUnexpectCount() {
        synchronized (this.$lock) {
            this.mGyrTmepUnexpectCount++;
        }
    }

    public void autoAccelSpeedUnexpectCount() {
        synchronized (this.$lock) {
            this.mAccelSpeedUnexpectCount++;
        }
    }

    public void autoLocDropFrameCount() {
        synchronized (this.$lock) {
            this.mLocDropFrameCount++;
        }
    }

    public void autoLocGnssOutageCount() {
        synchronized (this.$lock) {
            this.mLocGnssOutageCount++;
        }
    }

    public void autoLocInfoErrorCount() {
        synchronized (this.$lock) {
            this.mLocInfoErrorCount++;
        }
    }

    public long getTtffStartTime() {
        long j;
        synchronized (this.$lock) {
            j = this.mTtffStartTime;
        }
        return j;
    }

    public void setTtffStartTime(long j) {
        synchronized (this.$lock) {
            this.mTtffStartTime = j;
        }
    }

    public long getTtffEndTime() {
        long j;
        synchronized (this.$lock) {
            j = this.mTtffEndTime;
        }
        return j;
    }

    public void setTtffEndTime(long j) {
        synchronized (this.$lock) {
            this.mTtffEndTime = j;
        }
    }

    public long getTtffTime() {
        long j;
        synchronized (this.$lock) {
            j = this.mTtffTime;
        }
        return j;
    }

    public void setTtffTime(long j) {
        synchronized (this.$lock) {
            this.mTtffTime = j;
        }
    }

    public int getLocSuccessCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocSuccessCount;
        }
        return i;
    }

    public void setLocSuccessCount(int i) {
        synchronized (this.$lock) {
            this.mLocSuccessCount = i;
        }
    }

    public int getLocFailCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocFailCount;
        }
        return i;
    }

    public void setLocFailCount(int i) {
        synchronized (this.$lock) {
            this.mLocFailCount = i;
        }
    }

    public int getLocAccuracyOverCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocAccuracyOverCount;
        }
        return i;
    }

    public void setLocAccuracyOverCount(int i) {
        synchronized (this.$lock) {
            this.mLocAccuracyOverCount = i;
        }
    }

    public int getLocCnoUnexpectCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocCnoUnexpectCount;
        }
        return i;
    }

    public void setLocCnoUnexpectCount(int i) {
        synchronized (this.$lock) {
            this.mLocCnoUnexpectCount = i;
        }
    }

    public int getLocSateLiteCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocSateLiteCount;
        }
        return i;
    }

    public void setLocSateLiteCount(int i) {
        synchronized (this.$lock) {
            this.mLocSateLiteCount = i;
        }
    }

    public int getLocGpsSateLiteCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocGpsSateLiteCount;
        }
        return i;
    }

    public void setLocGpsSateLiteCount(int i) {
        synchronized (this.$lock) {
            this.mLocGpsSateLiteCount = i;
        }
    }

    public int getLocCpsSateLiteCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocCpsSateLiteCount;
        }
        return i;
    }

    public void setLocCpsSateLiteCount(int i) {
        synchronized (this.$lock) {
            this.mLocCpsSateLiteCount = i;
        }
    }

    public int getLocGalSateLiteCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocGalSateLiteCount;
        }
        return i;
    }

    public void setLocGalSateLiteCount(int i) {
        synchronized (this.$lock) {
            this.mLocGalSateLiteCount = i;
        }
    }

    public int getLocSateLiteCnoAve() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocSateLiteCnoAve;
        }
        return i;
    }

    public void setLocSateLiteCnoAve(int i) {
        synchronized (this.$lock) {
            this.mLocSateLiteCnoAve = i;
        }
    }

    public int getLocSateLiteCnoMax() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocSateLiteCnoMax;
        }
        return i;
    }

    public void setLocSateLiteCnoMax(int i) {
        synchronized (this.$lock) {
            this.mLocSateLiteCnoMax = i;
        }
    }

    public int getLocHdopUnexpectCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocHdopUnexpectCount;
        }
        return i;
    }

    public void setLocHdopUnexpectCount(int i) {
        synchronized (this.$lock) {
            this.mLocHdopUnexpectCount = i;
        }
    }

    public int getLocSpeedUnexpectCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocSpeedUnexpectCount;
        }
        return i;
    }

    public void setLocSpeedUnexpectCount(int i) {
        synchronized (this.$lock) {
            this.mLocSpeedUnexpectCount = i;
        }
    }

    public int getGyrXyzUnexpectCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mGyrXyzUnexpectCount;
        }
        return i;
    }

    public void setGyrXyzUnexpectCount(int i) {
        synchronized (this.$lock) {
            this.mGyrXyzUnexpectCount = i;
        }
    }

    public int getGyrTmepUnexpectCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mGyrTmepUnexpectCount;
        }
        return i;
    }

    public void setGyrTmepUnexpectCount(int i) {
        synchronized (this.$lock) {
            this.mGyrTmepUnexpectCount = i;
        }
    }

    public int getAccelSpeedUnexpectCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mAccelSpeedUnexpectCount;
        }
        return i;
    }

    public void setAccelSpeedUnexpectCount(int i) {
        synchronized (this.$lock) {
            this.mAccelSpeedUnexpectCount = i;
        }
    }

    public int getLocDropFrameCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocDropFrameCount;
        }
        return i;
    }

    public void setLocDropFrameCount(int i) {
        synchronized (this.$lock) {
            this.mLocDropFrameCount = i;
        }
    }

    public int getLocGnssOutageCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocGnssOutageCount;
        }
        return i;
    }

    public void setLocGnssOutageCount(int i) {
        synchronized (this.$lock) {
            this.mLocGnssOutageCount = i;
        }
    }

    public int getLocInfoErrorCount() {
        int i;
        synchronized (this.$lock) {
            i = this.mLocInfoErrorCount;
        }
        return i;
    }

    public void setLocInfoErrorCount(int i) {
        synchronized (this.$lock) {
            this.mLocInfoErrorCount = i;
        }
    }

    private String formatTime(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        int i2 = calendar.get(5);
        int i3 = calendar.get(11);
        int i4 = calendar.get(12);
        int i5 = calendar.get(13);
        int i6 = calendar.get(14);
        return "" + i + "." + (calendar.get(2) + 1) + "." + i2 + " " + i3 + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + i4 + LocationUtils.DR_RECORD_VALUE_SPLIT_CHAR + i5 + "." + i6;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("首次定位起始时间: " + formatTime(getTtffStartTime()));
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("首次定位结束时间: " + formatTime(getTtffEndTime()));
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("首次定位消耗的时间: " + RootUtil.formatDoubleToString(getTtffTime() / 1000.0d, -1, 3) + "s");
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("定位成功的次数: " + getLocSuccessCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("定位失败的次数: " + getLocFailCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("定位精度超出范围（20米）的次数: " + getLocAccuracyOverCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("载噪比异常次数: " + getLocCnoUnexpectCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("可视卫星的数量: " + getLocSateLiteCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("GPS可视卫星的数量: " + getLocGpsSateLiteCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("北斗可视卫星的数量: " + getLocCpsSateLiteCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("伽利略可视卫星的数量: " + getLocGalSateLiteCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("参与定位卫星的CNo平均值: " + getLocSateLiteCnoAve());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("参与定位卫星的CNo最大值: " + getLocSateLiteCnoMax());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("HDOP异常的次数: " + getLocHdopUnexpectCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("定位速度异常（大于1.0）的次数: " + getLocSpeedUnexpectCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("定位丢帧的次数: " + getLocDropFrameCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("陀螺仪各轴异常的次数: " + getGyrXyzUnexpectCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("陀螺仪温度异常次数: " + getGyrTmepUnexpectCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("加速度计各轴异常次数: " + getAccelSpeedUnexpectCount());
        return sb.toString().replace("\\n", FDManager.LINE_SEPERATOR);
    }

    public String toVehicleString() {
        StringBuilder sb = new StringBuilder();
        sb.append("首次定位起始时间: " + formatTime(getTtffStartTime()));
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("首次定位结束时间: " + formatTime(getTtffEndTime()));
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("首次定位消耗的时间: " + RootUtil.formatDoubleToString(getTtffTime() / 1000, -1, 3) + "s");
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("陀螺仪各轴异常的次数: " + getGyrXyzUnexpectCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("陀螺仪温度异常次数: " + getGyrTmepUnexpectCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("加速度计各轴异常次数: " + getAccelSpeedUnexpectCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("Gnss消息中断次数: " + getLocGnssOutageCount());
        sb.append(FDManager.LINE_SEPERATOR);
        sb.append("定位消息数据错误次数: " + getLocInfoErrorCount());
        return sb.toString().replace("\\n", FDManager.LINE_SEPERATOR);
    }
}
