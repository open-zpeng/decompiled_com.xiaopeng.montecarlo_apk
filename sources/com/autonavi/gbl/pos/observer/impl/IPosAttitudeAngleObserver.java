package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.gbl.pos.model.RawAttitudeAngle;
/* loaded from: classes2.dex */
public class IPosAttitudeAngleObserver {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native void onAttitudeAngleUpdateNative(long j, IPosAttitudeAngleObserver iPosAttitudeAngleObserver, long j2, RawAttitudeAngle rawAttitudeAngle);

    public IPosAttitudeAngleObserver(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IPosAttitudeAngleObserver iPosAttitudeAngleObserver) {
        if (iPosAttitudeAngleObserver == null) {
            return 0L;
        }
        return iPosAttitudeAngleObserver.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void onAttitudeAngleUpdate(RawAttitudeAngle rawAttitudeAngle) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onAttitudeAngleUpdateNative(j, this, 0L, rawAttitudeAngle);
    }
}
