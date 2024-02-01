package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchNaviInfoResult;
import com.autonavi.gbl.search.observer.IGSearchNaviInfoObserver;
@IntfAuto(target = IGSearchNaviInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGSearchNaviInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGSearchNaviInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGSearchNaviInfoObserverImpl_change_ownership(IGSearchNaviInfoObserverImpl iGSearchNaviInfoObserverImpl, long j, boolean z);

    private static native void IGSearchNaviInfoObserverImpl_director_connect(IGSearchNaviInfoObserverImpl iGSearchNaviInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetNaviInfoResultNative(long j, IGSearchNaviInfoObserverImpl iGSearchNaviInfoObserverImpl, int i, int i2, long j2, SearchNaviInfoResult searchNaviInfoResult);

    public IGSearchNaviInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGSearchNaviInfoObserverImpl) && getUID(this) == getUID((IGSearchNaviInfoObserverImpl) obj);
    }

    private static long getUID(IGSearchNaviInfoObserverImpl iGSearchNaviInfoObserverImpl) {
        long cPtr = getCPtr(iGSearchNaviInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGSearchNaviInfoObserverImpl iGSearchNaviInfoObserverImpl) {
        if (iGSearchNaviInfoObserverImpl == null) {
            return 0L;
        }
        return iGSearchNaviInfoObserverImpl.swigCPtr;
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
        IGSearchNaviInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGSearchNaviInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetNaviInfoResult(int i, int i2, SearchNaviInfoResult searchNaviInfoResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetNaviInfoResultNative(j, this, i, i2, 0L, searchNaviInfoResult);
    }

    public IGSearchNaviInfoObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IGSearchNaviInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
