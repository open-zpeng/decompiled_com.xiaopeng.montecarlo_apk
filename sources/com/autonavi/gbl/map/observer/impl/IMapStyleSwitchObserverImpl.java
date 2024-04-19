package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.observer.IMapStyleSwitchObserver;
@IntfAuto(target = IMapStyleSwitchObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapStyleSwitchObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapStyleSwitchObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapStyleSwitchObserverImpl_change_ownership(IMapStyleSwitchObserverImpl iMapStyleSwitchObserverImpl, long j, boolean z);

    private static native void IMapStyleSwitchObserverImpl_director_connect(IMapStyleSwitchObserverImpl iMapStyleSwitchObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onMapStyleSwitchCompleteNative(long j, IMapStyleSwitchObserverImpl iMapStyleSwitchObserverImpl, int i);

    public IMapStyleSwitchObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapStyleSwitchObserverImpl) && getUID(this) == getUID((IMapStyleSwitchObserverImpl) obj);
    }

    private static long getUID(IMapStyleSwitchObserverImpl iMapStyleSwitchObserverImpl) {
        long cPtr = getCPtr(iMapStyleSwitchObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapStyleSwitchObserverImpl iMapStyleSwitchObserverImpl) {
        if (iMapStyleSwitchObserverImpl == null) {
            return 0L;
        }
        return iMapStyleSwitchObserverImpl.swigCPtr;
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
        IMapStyleSwitchObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapStyleSwitchObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onMapStyleSwitchComplete(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onMapStyleSwitchCompleteNative(j, this, i);
    }

    public IMapStyleSwitchObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IMapStyleSwitchObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
