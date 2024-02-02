package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.search.model.SearchNearestResult;
import com.autonavi.gbl.search.observer.IGSearchNearestObserver;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchNearestObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGSearchNearestObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGSearchNearestObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGSearchNearestObserverImpl_change_ownership(IGSearchNearestObserverImpl iGSearchNearestObserverImpl, long j, boolean z);

    private static native void IGSearchNearestObserverImpl_director_connect(IGSearchNearestObserverImpl iGSearchNearestObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetNearestResultNative(long j, IGSearchNearestObserverImpl iGSearchNearestObserverImpl, int i, int i2, long j2, SearchNearestResult searchNearestResult);

    public IGSearchNearestObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGSearchNearestObserverImpl) && getUID(this) == getUID((IGSearchNearestObserverImpl) obj);
    }

    private static long getUID(IGSearchNearestObserverImpl iGSearchNearestObserverImpl) {
        long cPtr = getCPtr(iGSearchNearestObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGSearchNearestObserverImpl iGSearchNearestObserverImpl) {
        if (iGSearchNearestObserverImpl == null) {
            return 0L;
        }
        return iGSearchNearestObserverImpl.swigCPtr;
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
        IGSearchNearestObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGSearchNearestObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetNearestResult(int i, @EGErr.EGErr1 int i2, SearchNearestResult searchNearestResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetNearestResultNative(j, this, i, i2, 0L, searchNearestResult);
    }

    public IGSearchNearestObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IGSearchNearestObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
