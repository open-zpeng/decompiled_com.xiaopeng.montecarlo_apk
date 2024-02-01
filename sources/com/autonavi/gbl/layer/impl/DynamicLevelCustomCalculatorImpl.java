package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.DynamicLevelCustomCalculator;
import com.autonavi.gbl.layer.model.DynamicLevelCalcResult;
@IntfAuto(target = DynamicLevelCustomCalculator.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class DynamicLevelCustomCalculatorImpl {
    private static BindTable BIND_TABLE = new BindTable(DynamicLevelCustomCalculatorImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void DynamicLevelCustomCalculatorImpl_change_ownership(DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl, long j, boolean z);

    private static native void DynamicLevelCustomCalculatorImpl_director_connect(DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl, long j, boolean z, boolean z2);

    private static native boolean calculateCruiseDynamicLevelNative(long j, DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl, int i, long j2, DynamicLevelCalcResult dynamicLevelCalcResult);

    private static native boolean calculateGuide2DNorthUpDynamicLevelNative(long j, DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl, int i, long j2, DynamicLevelCalcResult dynamicLevelCalcResult);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public DynamicLevelCustomCalculatorImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DynamicLevelCustomCalculatorImpl) && getUID(this) == getUID((DynamicLevelCustomCalculatorImpl) obj);
    }

    private static long getUID(DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl) {
        long cPtr = getCPtr(dynamicLevelCustomCalculatorImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(DynamicLevelCustomCalculatorImpl dynamicLevelCustomCalculatorImpl) {
        if (dynamicLevelCustomCalculatorImpl == null) {
            return 0L;
        }
        return dynamicLevelCustomCalculatorImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        DynamicLevelCustomCalculatorImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        DynamicLevelCustomCalculatorImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean calculateCruiseDynamicLevel(int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        return $explicit_calculateCruiseDynamicLevel(i, dynamicLevelCalcResult);
    }

    public boolean $explicit_calculateCruiseDynamicLevel(int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return calculateCruiseDynamicLevelNative(j, this, i, 0L, dynamicLevelCalcResult);
    }

    public boolean calculateGuide2DNorthUpDynamicLevel(int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        return $explicit_calculateGuide2DNorthUpDynamicLevel(i, dynamicLevelCalcResult);
    }

    public boolean $explicit_calculateGuide2DNorthUpDynamicLevel(int i, DynamicLevelCalcResult dynamicLevelCalcResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return calculateGuide2DNorthUpDynamicLevelNative(j, this, i, 0L, dynamicLevelCalcResult);
    }

    public DynamicLevelCustomCalculatorImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        DynamicLevelCustomCalculatorImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
