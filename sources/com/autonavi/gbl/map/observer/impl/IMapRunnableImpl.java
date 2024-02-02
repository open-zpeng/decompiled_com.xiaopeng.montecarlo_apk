package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.observer.IMapRunnable;
@IntfAuto(target = IMapRunnable.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapRunnableImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapRunnableImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapRunnableImpl_change_ownership(IMapRunnableImpl iMapRunnableImpl, long j, boolean z);

    private static native void IMapRunnableImpl_director_connect(IMapRunnableImpl iMapRunnableImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void runNative(long j, IMapRunnableImpl iMapRunnableImpl);

    public IMapRunnableImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapRunnableImpl) && getUID(this) == getUID((IMapRunnableImpl) obj);
    }

    private static long getUID(IMapRunnableImpl iMapRunnableImpl) {
        long cPtr = getCPtr(iMapRunnableImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapRunnableImpl iMapRunnableImpl) {
        if (iMapRunnableImpl == null) {
            return 0L;
        }
        return iMapRunnableImpl.swigCPtr;
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

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        IMapRunnableImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapRunnableImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void run() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        runNative(j, this);
    }

    public IMapRunnableImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IMapRunnableImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
