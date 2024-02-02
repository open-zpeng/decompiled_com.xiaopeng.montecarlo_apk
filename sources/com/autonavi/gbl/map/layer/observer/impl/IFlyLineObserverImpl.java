package com.autonavi.gbl.map.layer.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.map.layer.observer.IFlyLineObserver;
@IntfAuto(target = IFlyLineObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IFlyLineObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IFlyLineObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IFlyLineObserverImpl_change_ownership(IFlyLineObserverImpl iFlyLineObserverImpl, long j, boolean z);

    private static native void IFlyLineObserverImpl_director_connect(IFlyLineObserverImpl iFlyLineObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onEndChangeNative(long j, IFlyLineObserverImpl iFlyLineObserverImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void onFlyLineClickNative(long j, IFlyLineObserverImpl iFlyLineObserverImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void onStartChangeNative(long j, IFlyLineObserverImpl iFlyLineObserverImpl, long j2, Coord3DDouble coord3DDouble);

    public IFlyLineObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IFlyLineObserverImpl) && getUID(this) == getUID((IFlyLineObserverImpl) obj);
    }

    private static long getUID(IFlyLineObserverImpl iFlyLineObserverImpl) {
        long cPtr = getCPtr(iFlyLineObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IFlyLineObserverImpl iFlyLineObserverImpl) {
        if (iFlyLineObserverImpl == null) {
            return 0L;
        }
        return iFlyLineObserverImpl.swigCPtr;
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
        IFlyLineObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IFlyLineObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onFlyLineClick(Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onFlyLineClickNative(j, this, 0L, coord3DDouble);
    }

    public void onStartChange(Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onStartChangeNative(j, this, 0L, coord3DDouble);
    }

    public void onEndChange(Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onEndChangeNative(j, this, 0L, coord3DDouble);
    }

    public IFlyLineObserverImpl() {
        this(createNativeObj(), true);
        MapLayerObserverJNI.swig_jni_init();
        IFlyLineObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
