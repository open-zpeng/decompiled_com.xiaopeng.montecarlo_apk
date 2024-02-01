package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.JniUtil;
import com.autonavi.gbl.util.observer.impl.IJniExceptionObserverImpl;
@IntfAuto(target = JniUtil.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IJniUtilImpl {
    private static BindTable BIND_TABLE = new BindTable(IJniUtilImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addObserverNative(long j, IJniUtilImpl iJniUtilImpl, long j2, IJniExceptionObserverImpl iJniExceptionObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native long getInstanceNative();

    private static native boolean removeObserverNative(long j, IJniUtilImpl iJniUtilImpl, long j2, IJniExceptionObserverImpl iJniExceptionObserverImpl);

    public IJniUtilImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IJniUtilImpl) && getUID(this) == getUID((IJniUtilImpl) obj);
    }

    private static long getUID(IJniUtilImpl iJniUtilImpl) {
        long cPtr = getCPtr(iJniUtilImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IJniUtilImpl iJniUtilImpl) {
        if (iJniUtilImpl == null) {
            return 0L;
        }
        return iJniUtilImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public static IJniUtilImpl getInstance() {
        long instanceNative = getInstanceNative();
        if (instanceNative == 0) {
            return null;
        }
        return new IJniUtilImpl(instanceNative, false);
    }

    public boolean addObserver(IJniExceptionObserverImpl iJniExceptionObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IJniExceptionObserverImpl.getCPtr(iJniExceptionObserverImpl), iJniExceptionObserverImpl);
    }

    public boolean removeObserver(IJniExceptionObserverImpl iJniExceptionObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeObserverNative(j, this, IJniExceptionObserverImpl.getCPtr(iJniExceptionObserverImpl), iJniExceptionObserverImpl);
    }
}
