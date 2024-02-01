package com.xiaopeng.montecarlo.navcore.location.sensor;
/* loaded from: classes3.dex */
public interface IXpSensor {
    public static final int FAILURE_COUNTER_DEFAULT = 0;
    public static final int FAILURE_REASON_DEFAULT = 0;

    /* loaded from: classes3.dex */
    public interface ISensorListener {
        void onSensorChanged(int i, float[] fArr, long j, float f, int i2, int i3, XPSensorType xPSensorType);
    }

    /* loaded from: classes3.dex */
    public enum XPSensorType {
        SENSOR_TYPE_UBX,
        SENSOR_TYPE_IMU
    }

    void close();

    void enableADR(boolean z);

    void enableUbxReset(boolean z);

    XPSensorType getSensorType();

    void open();

    void setClientListener(ISensorListener iSensorListener);

    default void setPowerOnTime(long j) {
    }

    void setRawData(boolean z, boolean z2, float[] fArr);
}
