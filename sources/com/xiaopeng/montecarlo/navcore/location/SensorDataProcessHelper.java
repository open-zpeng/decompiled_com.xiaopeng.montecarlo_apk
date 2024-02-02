package com.xiaopeng.montecarlo.navcore.location;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
/* loaded from: classes2.dex */
public class SensorDataProcessHelper {
    private static final float DETECT_ACCELERATION_MAX = 1.3f;
    private static final float DETECT_GYRORATE_MAX = 60.0f;
    private static final int DETECT_INTERVAL_MAX = 110;
    private static final int DETECT_INTERVAL_MIN = 90;
    private static final int DETECT_TRAFFIC_ACCIDENT_ACCELERATION = 1;
    private static final int DETECT_TRAFFIC_ACCIDENT_GYRORATE = 2;
    private static final L.Tag TAG = new L.Tag("SensorDataProcessHelper");
    private float[] mAccelValues = {0.0f, 0.0f, 0.0f};
    private float[] mGyroValues = {0.0f, 0.0f, 0.0f, 0.0f};
    private int mAccelerationCnt = 0;
    private int mGyroRateCnt = 0;
    private long mPreviousAccelDetectTime = 0;
    private long mPreviousGyroDetectTime = 0;
    private SensorData mSensorData = new SensorData();
    private SensorDataProcessHandler mSensorDataProcessHandler = new SensorDataProcessHandler(WorkThreadUtil.getInstance().getSensorDataProcessThreadLooper());

    public void onDetectTrafficAccident(int i, float[] fArr, float f, long j, long j2) {
        if (1 == i) {
            this.mAccelValues = fArr;
            float sqrt = (float) Math.sqrt(((fArr[0] / 9.8f) * (fArr[0] / 9.8f)) + ((fArr[1] / 9.8f) * (fArr[1] / 9.8f)) + ((fArr[2] / 9.8f) * (fArr[2] / 9.8f)));
            long j3 = j - j2;
            long j4 = j3 - this.mPreviousAccelDetectTime;
            if (sqrt > DETECT_ACCELERATION_MAX) {
                this.mPreviousAccelDetectTime = j3;
                if (j4 < 90 || j4 > 110) {
                    return;
                }
                this.mAccelerationCnt++;
                if (this.mAccelerationCnt >= 3) {
                    this.mPreviousAccelDetectTime = 0L;
                    this.mAccelerationCnt = 0;
                    this.mSensorData.setAccelValues(this.mAccelValues);
                    this.mSensorData.setAcceleration(sqrt);
                    this.mSensorData.setGyroValues(this.mGyroValues);
                    Message obtainMessage = this.mSensorDataProcessHandler.obtainMessage();
                    obtainMessage.obj = this.mSensorData;
                    obtainMessage.what = 1;
                    this.mSensorDataProcessHandler.sendMessage(obtainMessage);
                    return;
                }
                return;
            }
            this.mPreviousAccelDetectTime = 0L;
            this.mAccelerationCnt = 0;
        } else if (4 == i) {
            this.mGyroValues = new float[]{fArr[0], fArr[1], fArr[2], f};
            long j5 = j - j2;
            long j6 = j5 - this.mPreviousGyroDetectTime;
            if (Math.abs(fArr[0]) > DETECT_GYRORATE_MAX || Math.abs(fArr[1]) > DETECT_GYRORATE_MAX || Math.abs(fArr[2]) > DETECT_GYRORATE_MAX) {
                this.mPreviousGyroDetectTime = j5;
                if (j6 < 90 || j6 > 110) {
                    return;
                }
                this.mGyroRateCnt++;
                if (this.mGyroRateCnt >= 3) {
                    this.mPreviousGyroDetectTime = 0L;
                    this.mGyroRateCnt = 0;
                    this.mSensorData.setAccelValues(this.mAccelValues);
                    this.mSensorData.setGyroValues(this.mGyroValues);
                    this.mSensorData.setTemperature(f);
                    Message obtainMessage2 = this.mSensorDataProcessHandler.obtainMessage();
                    obtainMessage2.obj = this.mSensorData;
                    obtainMessage2.what = 2;
                    this.mSensorDataProcessHandler.sendMessage(obtainMessage2);
                    return;
                }
                return;
            }
            this.mPreviousGyroDetectTime = 0L;
            this.mGyroRateCnt = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccelStatData(SensorData sensorData) {
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.ACCELERATION_DETECT, sensorData.mAccelValues, sensorData.mGyroValues);
        L.Tag tag = TAG;
        L.i(tag, "Detect Traffic Accident, acceleration is:" + sensorData.mAcceleration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGyroStatData(SensorData sensorData) {
        DataLogUtil.sendStatData(PageType.NAVI_CRUISE, BtnType.GYRO_RATE_DETECT, sensorData.mAccelValues, sensorData.mGyroValues);
        L.Tag tag = TAG;
        L.i(tag, "Detect Traffic Accident, gyro rate is [" + sensorData.mGyroValues[0] + "," + sensorData.mGyroValues[1] + "," + sensorData.mGyroValues[2] + "," + sensorData.mTemperature + "]");
    }

    /* loaded from: classes2.dex */
    private class SensorDataProcessHandler extends Handler {
        public SensorDataProcessHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i = message.what;
            if (i == 1) {
                SensorDataProcessHelper.this.sendAccelStatData((SensorData) message.obj);
            } else if (i != 2) {
            } else {
                SensorDataProcessHelper.this.sendGyroStatData((SensorData) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SensorData {
        private float[] mAccelValues;
        private float mAcceleration;
        private float[] mGyroValues;
        private float mTemperature;

        public SensorData setAccelValues(float[] fArr) {
            this.mAccelValues = fArr;
            return this;
        }

        public SensorData setAcceleration(float f) {
            this.mAcceleration = f;
            return this;
        }

        public SensorData setGyroValues(float[] fArr) {
            this.mGyroValues = fArr;
            return this;
        }

        public SensorData setTemperature(float f) {
            this.mTemperature = f;
            return this;
        }

        private SensorData() {
        }

        public float[] getAccelValues() {
            return this.mAccelValues;
        }

        public float[] getGyroValues() {
            return this.mGyroValues;
        }

        public float getAcceleration() {
            return this.mAcceleration;
        }

        public float getTemperature() {
            return this.mTemperature;
        }
    }
}
