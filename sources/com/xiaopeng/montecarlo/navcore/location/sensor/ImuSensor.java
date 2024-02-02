package com.xiaopeng.montecarlo.navcore.location.sensor;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.xiaopeng.lib.utils.view.ToastUtils;
import com.xiaopeng.montecarlo.navcore.location.ImuRawData;
import com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor;
import com.xiaopeng.montecarlo.root.util.AfterSalesUtil;
import com.xiaopeng.montecarlo.root.util.ContextUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.RootUtil;
import com.xiaopeng.montecarlo.root.util.StatisticDataUtil;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes2.dex */
public class ImuSensor implements IXpSensor {
    private static final long MS_TO_NS = 1000000;
    private static final long SENSOR_DATA_TIME_GAP = 100;
    private static final long SENSOR_SINGAL_DELAY_WARNING = 1000;
    private static final L.Tag TAG = new L.Tag("ImuSensor");
    private static final int WARNING_COUNT_CONTROL = 600;
    public static volatile long sIMUDelayTime = 100;
    private Handler mHandler;
    private ImuRawData mImuRawData = new ImuRawData();
    private int mImuDataErrorCnt = 0;
    private boolean mStart = false;
    private IXpSensor.ISensorListener mListener = null;
    private int mWarningOutputCounter = 0;
    private volatile boolean mIsDataReady = false;
    private long mPowerOnTime = 0;
    private Runnable mImuSensorRunnable = new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.location.sensor.ImuSensor.1
        @Override // java.lang.Runnable
        public void run() {
            long j;
            do {
                if (ImuSensor.this.mListener == null || !ImuSensor.this.mIsDataReady || 0 == ImuSensor.this.mPowerOnTime) {
                    j = 0;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    float[] acc = ImuSensor.this.mImuRawData.getAcc();
                    float[] gyro = ImuSensor.this.mImuRawData.getGyro();
                    long receivedTime = ImuSensor.this.mImuRawData.getReceivedTime();
                    long j2 = receivedTime / ImuSensor.MS_TO_NS;
                    ImuSensor.this.mListener.onSensorChanged(1, acc, receivedTime, ImuSensor.this.mImuRawData.getImuTemperature(), 0, 0, IXpSensor.XPSensorType.SENSOR_TYPE_IMU);
                    ImuSensor.this.mListener.onSensorChanged(4, gyro, receivedTime, ImuSensor.this.mImuRawData.getImuTemperature(), 0, 0, IXpSensor.XPSensorType.SENSOR_TYPE_IMU);
                    if (currentTimeMillis > j2) {
                        long j3 = currentTimeMillis - j2;
                        if (1000 < j3) {
                            if (ImuSensor.this.mWarningOutputCounter % 600 == 0) {
                                ImuSensor.this.mWarningOutputCounter = 0;
                                L.w(ImuSensor.TAG, "imu sensor data delay, delay:" + j3);
                            }
                            ImuSensor.access$404(ImuSensor.this);
                            j = System.currentTimeMillis() - currentTimeMillis;
                        }
                    }
                    ImuSensor.this.mWarningOutputCounter = 0;
                    j = System.currentTimeMillis() - currentTimeMillis;
                }
                try {
                    Thread.sleep(100 >= j ? 100 - j : 0L);
                } catch (Exception e) {
                    L.w(ImuSensor.TAG, e.getMessage());
                }
            } while (ImuSensor.this.mStart);
        }
    };

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void enableADR(boolean z) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void enableUbxReset(boolean z) {
    }

    static /* synthetic */ int access$404(ImuSensor imuSensor) {
        int i = imuSensor.mWarningOutputCounter + 1;
        imuSensor.mWarningOutputCounter = i;
        return i;
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void open() {
        if (this.mStart) {
            return;
        }
        this.mHandler = new Handler(WorkThreadUtil.getInstance().getUDPClientThreadLooper());
        this.mStart = true;
        L.i(TAG, "open IMU sensor");
        this.mHandler.post(this.mImuSensorRunnable);
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void close() {
        if (this.mStart) {
            this.mStart = false;
            this.mHandler.removeCallbacks(this.mImuSensorRunnable);
        }
        this.mListener = null;
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void setClientListener(IXpSensor.ISensorListener iSensorListener) {
        this.mListener = iSensorListener;
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public IXpSensor.XPSensorType getSensorType() {
        return IXpSensor.XPSensorType.SENSOR_TYPE_IMU;
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void setPowerOnTime(long j) {
        this.mPowerOnTime = j;
    }

    @Override // com.xiaopeng.montecarlo.navcore.location.sensor.IXpSensor
    public void setRawData(boolean z, boolean z2, float[] fArr) {
        if (fArr != null) {
            float f = z ? fArr[1] : fArr[18];
            float f2 = z ? fArr[2] : fArr[22];
            float f3 = z ? fArr[3] : fArr[26];
            float f4 = z ? fArr[4] : fArr[20];
            float f5 = z ? fArr[5] : fArr[24];
            float f6 = z ? fArr[6] : fArr[28];
            if ((f * f) + (f2 * f2) + (f3 * f3) < 0.1f) {
                if (this.mImuDataErrorCnt % 600 == 0 && 0 != this.mPowerOnTime && SystemClock.uptimeMillis() - this.mPowerOnTime > 3000) {
                    this.mImuDataErrorCnt = 0;
                    AfterSalesUtil.getInstance().recordDiagnosisError(9001, "autoPilot IMU error");
                    L.w(TAG, "IMU Raw data error, accel: " + f + "," + f2 + "," + f3 + ", gyro:" + f4 + "," + f5 + "," + f6 + "");
                    final Context context = ContextUtils.getContext();
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.navcore.location.sensor.ImuSensor.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ToastUtils.showToast(context, "底层IMU异常，请检查");
                        }
                    });
                }
                this.mImuDataErrorCnt++;
                return;
            }
            if (!this.mIsDataReady) {
                this.mIsDataReady = true;
            }
            this.mImuRawData.setAcc(f, f2, f3);
            this.mImuRawData.setGyro(f4, f5, f6);
            this.mImuRawData.setImuTemperature(z ? fArr[0] : fArr[5]);
            this.mImuRawData.setImuSdeltamsec(z ? fArr[7] : fArr[34]);
            long currentTimeMillis = (System.currentTimeMillis() - sIMUDelayTime) - (z2 ? 0L : this.mImuRawData.getImuSdeltamsec() * 1000.0f);
            this.mImuRawData.setReceivedTime(MS_TO_NS * currentTimeMillis);
            if (RootUtil.sIsDrTestMode) {
                StatisticDataUtil.setDRIMUTimestamp(currentTimeMillis);
            }
        }
    }
}
