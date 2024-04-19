package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.search.model.SearchAlongWayResult;
import com.autonavi.gbl.search.observer.IGSearchAlongWayObserver;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchAlongWayObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGSearchAlongWayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGSearchAlongWayObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGSearchAlongWayObserverImpl_change_ownership(IGSearchAlongWayObserverImpl iGSearchAlongWayObserverImpl, long j, boolean z);

    private static native void IGSearchAlongWayObserverImpl_director_connect(IGSearchAlongWayObserverImpl iGSearchAlongWayObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetAlongWayResultNative(long j, IGSearchAlongWayObserverImpl iGSearchAlongWayObserverImpl, int i, int i2, long j2, SearchAlongWayResult searchAlongWayResult);

    public IGSearchAlongWayObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGSearchAlongWayObserverImpl) && getUID(this) == getUID((IGSearchAlongWayObserverImpl) obj);
    }

    private static long getUID(IGSearchAlongWayObserverImpl iGSearchAlongWayObserverImpl) {
        long cPtr = getCPtr(iGSearchAlongWayObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGSearchAlongWayObserverImpl iGSearchAlongWayObserverImpl) {
        if (iGSearchAlongWayObserverImpl == null) {
            return 0L;
        }
        return iGSearchAlongWayObserverImpl.swigCPtr;
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
        IGSearchAlongWayObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGSearchAlongWayObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetAlongWayResult(int i, @EGErr.EGErr1 int i2, SearchAlongWayResult searchAlongWayResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetAlongWayResultNative(j, this, i, i2, 0L, searchAlongWayResult);
    }

    public IGSearchAlongWayObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IGSearchAlongWayObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
