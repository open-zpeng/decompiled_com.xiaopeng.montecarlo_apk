package com.autonavi.gbl.map.layer.impl;
/* loaded from: classes.dex */
public class IPointItemAnimationObserver {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native void onProcessAnimationEventNative(long j, IPointItemAnimationObserver iPointItemAnimationObserver);

    public IPointItemAnimationObserver(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IPointItemAnimationObserver iPointItemAnimationObserver) {
        if (iPointItemAnimationObserver == null) {
            return 0L;
        }
        return iPointItemAnimationObserver.swigCPtr;
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

    public void onProcessAnimationEvent() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onProcessAnimationEventNative(j, this);
    }
}
