package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.util.ObjLifeStateDispatcher;
import com.autonavi.gbl.util.model.ObjLifeState;
import com.autonavi.gbl.util.observer.impl.IObjLifeStateObserverImpl;
@IntfAuto(target = ObjLifeStateDispatcher.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IObjLifeStateDispatcherImpl {
    private static BindTable BIND_TABLE = new BindTable(IObjLifeStateDispatcherImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addObserverNative(long j, IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl, long j2, IObjLifeStateObserverImpl iObjLifeStateObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native void dispatchStateNative(long j, IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl, int i, long j2, String str);

    private static native long getInstanceNative();

    private static native long getObserverCountNative(long j, IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl);

    private static native boolean removeObserverNative(long j, IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl, long j2, IObjLifeStateObserverImpl iObjLifeStateObserverImpl);

    public IObjLifeStateDispatcherImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IObjLifeStateDispatcherImpl) && getUID(this) == getUID((IObjLifeStateDispatcherImpl) obj);
    }

    private static long getUID(IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl) {
        long cPtr = getCPtr(iObjLifeStateDispatcherImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IObjLifeStateDispatcherImpl iObjLifeStateDispatcherImpl) {
        if (iObjLifeStateDispatcherImpl == null) {
            return 0L;
        }
        return iObjLifeStateDispatcherImpl.swigCPtr;
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

    public static IObjLifeStateDispatcherImpl getInstance() {
        long instanceNative = getInstanceNative();
        if (instanceNative == 0) {
            return null;
        }
        return new IObjLifeStateDispatcherImpl(instanceNative, false);
    }

    public boolean addObserver(IObjLifeStateObserverImpl iObjLifeStateObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IObjLifeStateObserverImpl.getCPtr(iObjLifeStateObserverImpl), iObjLifeStateObserverImpl);
    }

    public boolean removeObserver(IObjLifeStateObserverImpl iObjLifeStateObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeObserverNative(j, this, IObjLifeStateObserverImpl.getCPtr(iObjLifeStateObserverImpl), iObjLifeStateObserverImpl);
    }

    public long getObserverCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getObserverCountNative(j, this);
    }

    public void dispatchState(@ObjLifeState.ObjLifeState1 int i, long j, String str) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        dispatchStateNative(j2, this, i, j, str);
    }
}
