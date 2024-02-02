package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.OperatorScale;
@IntfAuto(target = OperatorScale.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class OperatorScaleImpl {
    private static BindTable BIND_TABLE = new BindTable(OperatorScaleImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native int getCurrentScaleNative(long j, OperatorScaleImpl operatorScaleImpl);

    private static native double getMetersPerScalePixelNative(long j, OperatorScaleImpl operatorScaleImpl);

    private static native int getScaleLineLengthByAdjustNative(long j, OperatorScaleImpl operatorScaleImpl, int i, int i2, int[] iArr);

    private static native int getScaleLineLengthNative(long j, OperatorScaleImpl operatorScaleImpl);

    private static native int getScaleNative(long j, OperatorScaleImpl operatorScaleImpl, int i);

    public OperatorScaleImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof OperatorScaleImpl) && getUID(this) == getUID((OperatorScaleImpl) obj);
    }

    private static long getUID(OperatorScaleImpl operatorScaleImpl) {
        long cPtr = getCPtr(operatorScaleImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(OperatorScaleImpl operatorScaleImpl) {
        if (operatorScaleImpl == null) {
            return 0L;
        }
        return operatorScaleImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public int getCurrentScale() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getCurrentScaleNative(j, this);
    }

    public int getScale(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getScaleNative(j, this, i);
    }

    public double getMetersPerScalePixel() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getMetersPerScalePixelNative(j, this);
    }

    public int getScaleLineLength() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getScaleLineLengthNative(j, this);
    }

    public int getScaleLineLengthByAdjust(int i, int i2) {
        int[] iArr = new int[1];
        Integer.valueOf(getScaleLineLengthByAdjust(i, i2, iArr));
        return iArr[0];
    }

    private int getScaleLineLengthByAdjust(int i, int i2, int[] iArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getScaleLineLengthByAdjustNative(j, this, i, i2, iArr);
    }
}
