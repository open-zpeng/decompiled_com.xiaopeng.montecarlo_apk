package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.observer.IMapEventObserver;
@IntfAuto(target = IMapEventObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapEventObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapEventObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapEventObserverImpl_change_ownership(IMapEventObserverImpl iMapEventObserverImpl, long j, boolean z);

    private static native void IMapEventObserverImpl_director_connect(IMapEventObserverImpl iMapEventObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onMapMoveEndNative(long j, IMapEventObserverImpl iMapEventObserverImpl);

    private static native boolean onMapMoveStartNative(long j, IMapEventObserverImpl iMapEventObserverImpl);

    public IMapEventObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapEventObserverImpl) && getUID(this) == getUID((IMapEventObserverImpl) obj);
    }

    private static long getUID(IMapEventObserverImpl iMapEventObserverImpl) {
        long cPtr = getCPtr(iMapEventObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapEventObserverImpl iMapEventObserverImpl) {
        if (iMapEventObserverImpl == null) {
            return 0L;
        }
        return iMapEventObserverImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
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
        IMapEventObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapEventObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean onMapMoveStart() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onMapMoveStartNative(j, this);
    }

    public boolean onMapMoveEnd() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onMapMoveEndNative(j, this);
    }

    public IMapEventObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IMapEventObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
