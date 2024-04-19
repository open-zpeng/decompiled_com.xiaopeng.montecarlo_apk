package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.MapFuncActiveParam;
import com.autonavi.gbl.map.observer.IBLMapEngineObserver;
@IntfAuto(target = IBLMapEngineObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBLMapEngineObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IBLMapEngineObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IBLMapEngineObserverImpl_change_ownership(IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j, boolean z);

    private static native void IBLMapEngineObserverImpl_director_connect(IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onMapAnimationFinishedNative(long j, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j2);

    private static native void onMapFunctionActivityNative(long j, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j2, long j3, MapFuncActiveParam mapFuncActiveParam);

    private static native void onMapOfflineErrorNative(long j, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j2, String str, int i);

    private static native void onMapOrthoRenderNative(long j, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j2);

    private static native void onMapRenderNative(long j, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j2, int i);

    private static native void onMapTransferParamNative(long j, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j2, int[] iArr);

    private static native void onMapViewDestroyedNative(long j, IBLMapEngineObserverImpl iBLMapEngineObserverImpl, long j2);

    public IBLMapEngineObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBLMapEngineObserverImpl) && getUID(this) == getUID((IBLMapEngineObserverImpl) obj);
    }

    private static long getUID(IBLMapEngineObserverImpl iBLMapEngineObserverImpl) {
        long cPtr = getCPtr(iBLMapEngineObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBLMapEngineObserverImpl iBLMapEngineObserverImpl) {
        if (iBLMapEngineObserverImpl == null) {
            return 0L;
        }
        return iBLMapEngineObserverImpl.swigCPtr;
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
        IBLMapEngineObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IBLMapEngineObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onMapRender(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapRenderNative(j2, this, j, i);
    }

    public void onMapOrthoRender(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapOrthoRenderNative(j2, this, j);
    }

    public void onMapTransferParam(long j, int[] iArr) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapTransferParamNative(j2, this, j, iArr);
    }

    public void onMapOfflineError(long j, String str, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapOfflineErrorNative(j2, this, j, str, i);
    }

    public void onMapAnimationFinished(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapAnimationFinishedNative(j2, this, j);
    }

    public void onMapFunctionActivity(long j, MapFuncActiveParam mapFuncActiveParam) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapFunctionActivityNative(j2, this, j, 0L, mapFuncActiveParam);
    }

    public void onMapViewDestroyed(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onMapViewDestroyedNative(j2, this, j);
    }

    public IBLMapEngineObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IBLMapEngineObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
