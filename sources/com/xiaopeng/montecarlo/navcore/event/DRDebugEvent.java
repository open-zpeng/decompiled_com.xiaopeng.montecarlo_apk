package com.xiaopeng.montecarlo.navcore.event;

import android.location.Location;
/* loaded from: classes2.dex */
public class DRDebugEvent {
    public static final int DR_ADR_MODE_STATUS = 3;
    public static final int DR_CALIBRATION_SPEED = 4;
    public static final int DR_SENSOR_CALLBACK_MESSAGE = 0;
    public static final int DR_STOP_SHOW = 1;
    public static final int LOCATION_INFO = 2;
    public String mADRMessage;
    public float mCalibrationSpeed;
    public String mDRMessage;
    public Location mLocation;
    private int mType;

    public DRDebugEvent(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }
}
