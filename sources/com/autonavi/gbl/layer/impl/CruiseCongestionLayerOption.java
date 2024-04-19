package com.autonavi.gbl.layer.impl;
/* loaded from: classes.dex */
public class CruiseCongestionLayerOption {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int mCongestionEndThresholdGetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption);

    private static native void mCongestionEndThresholdSetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption, int i);

    private static native int mCongestionShowTimeoutGetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption);

    private static native void mCongestionShowTimeoutSetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption, int i);

    private static native int mCongestionStartThresholdGetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption);

    private static native void mCongestionStartThresholdSetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption, int i);

    private static native int mDistanceDeviationGetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption);

    private static native void mDistanceDeviationSetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption, int i);

    private static native int mLeaveCongestionThresholdGetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption);

    private static native void mLeaveCongestionThresholdSetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption, int i);

    private static native int mPreviewZoomRecoverTimeoutGetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption);

    private static native void mPreviewZoomRecoverTimeoutSetNative(long j, CruiseCongestionLayerOption cruiseCongestionLayerOption, int i);

    public CruiseCongestionLayerOption(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CruiseCongestionLayerOption cruiseCongestionLayerOption) {
        if (cruiseCongestionLayerOption == null) {
            return 0L;
        }
        return cruiseCongestionLayerOption.swigCPtr;
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

    public CruiseCongestionLayerOption() {
        this(createNativeObj(), true);
    }

    public void setMCongestionShowTimeout(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCongestionShowTimeoutSetNative(j, this, i);
    }

    public int getMCongestionShowTimeout() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCongestionShowTimeoutGetNative(j, this);
    }

    public void setMPreviewZoomRecoverTimeout(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mPreviewZoomRecoverTimeoutSetNative(j, this, i);
    }

    public int getMPreviewZoomRecoverTimeout() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPreviewZoomRecoverTimeoutGetNative(j, this);
    }

    public void setMDistanceDeviation(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDistanceDeviationSetNative(j, this, i);
    }

    public int getMDistanceDeviation() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDistanceDeviationGetNative(j, this);
    }

    public void setMCongestionStartThreshold(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCongestionStartThresholdSetNative(j, this, i);
    }

    public int getMCongestionStartThreshold() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCongestionStartThresholdGetNative(j, this);
    }

    public void setMCongestionEndThreshold(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCongestionEndThresholdSetNative(j, this, i);
    }

    public int getMCongestionEndThreshold() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCongestionEndThresholdGetNative(j, this);
    }

    public void setMLeaveCongestionThreshold(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLeaveCongestionThresholdSetNative(j, this, i);
    }

    public int getMLeaveCongestionThreshold() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLeaveCongestionThresholdGetNative(j, this);
    }
}
