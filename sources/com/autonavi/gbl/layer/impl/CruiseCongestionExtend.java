package com.autonavi.gbl.layer.impl;
/* loaded from: classes.dex */
public class CruiseCongestionExtend {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean isEmptyNative(long j, CruiseCongestionExtend cruiseCongestionExtend);

    private static native String mExtendGetNative(long j, CruiseCongestionExtend cruiseCongestionExtend);

    private static native void mExtendSetNative(long j, CruiseCongestionExtend cruiseCongestionExtend, String str);

    private static native boolean parseNative(long j, CruiseCongestionExtend cruiseCongestionExtend, String str);

    private static native String toStringNative(long j, CruiseCongestionExtend cruiseCongestionExtend);

    public CruiseCongestionExtend(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CruiseCongestionExtend cruiseCongestionExtend) {
        if (cruiseCongestionExtend == null) {
            return 0L;
        }
        return cruiseCongestionExtend.swigCPtr;
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

    public CruiseCongestionExtend() {
        this(createNativeObj(), true);
    }

    public boolean parse(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return parseNative(j, this, str);
    }

    public boolean isEmpty() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isEmptyNative(j, this);
    }

    public String toString() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return toStringNative(j, this);
    }

    public void setMExtend(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mExtendSetNative(j, this, str);
    }

    public String getMExtend() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mExtendGetNative(j, this);
    }
}
