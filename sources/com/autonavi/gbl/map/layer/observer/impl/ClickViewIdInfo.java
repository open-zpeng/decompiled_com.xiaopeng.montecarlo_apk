package com.autonavi.gbl.map.layer.observer.impl;
/* loaded from: classes2.dex */
public class ClickViewIdInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native String bgMarkerClickViewIdGetNative(long j, ClickViewIdInfo clickViewIdInfo);

    private static native void bgMarkerClickViewIdSetNative(long j, ClickViewIdInfo clickViewIdInfo, String str);

    private static native String bubbleMarkerClickViewIdGetNative(long j, ClickViewIdInfo clickViewIdInfo);

    private static native void bubbleMarkerClickViewIdSetNative(long j, ClickViewIdInfo clickViewIdInfo, String str);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String poiMarkerClickViewIdGetNative(long j, ClickViewIdInfo clickViewIdInfo);

    private static native void poiMarkerClickViewIdSetNative(long j, ClickViewIdInfo clickViewIdInfo, String str);

    public ClickViewIdInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClickViewIdInfo clickViewIdInfo) {
        if (clickViewIdInfo == null) {
            return 0L;
        }
        return clickViewIdInfo.swigCPtr;
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

    public void setPoiMarkerClickViewId(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        poiMarkerClickViewIdSetNative(j, this, str);
    }

    public String getPoiMarkerClickViewId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return poiMarkerClickViewIdGetNative(j, this);
    }

    public void setBgMarkerClickViewId(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bgMarkerClickViewIdSetNative(j, this, str);
    }

    public String getBgMarkerClickViewId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bgMarkerClickViewIdGetNative(j, this);
    }

    public void setBubbleMarkerClickViewId(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bubbleMarkerClickViewIdSetNative(j, this, str);
    }

    public String getBubbleMarkerClickViewId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bubbleMarkerClickViewIdGetNative(j, this);
    }

    public ClickViewIdInfo() {
        this(createNativeObj(), true);
    }
}
