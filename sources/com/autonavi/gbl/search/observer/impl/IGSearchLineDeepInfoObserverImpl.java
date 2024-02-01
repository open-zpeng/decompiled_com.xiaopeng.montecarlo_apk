package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchLineDeepInfoResult;
import com.autonavi.gbl.search.observer.IGSearchLineDeepInfoObserver;
@IntfAuto(target = IGSearchLineDeepInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGSearchLineDeepInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGSearchLineDeepInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGSearchLineDeepInfoObserverImpl_change_ownership(IGSearchLineDeepInfoObserverImpl iGSearchLineDeepInfoObserverImpl, long j, boolean z);

    private static native void IGSearchLineDeepInfoObserverImpl_director_connect(IGSearchLineDeepInfoObserverImpl iGSearchLineDeepInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetLineDeepInfoResultNative(long j, IGSearchLineDeepInfoObserverImpl iGSearchLineDeepInfoObserverImpl, int i, int i2, long j2, SearchLineDeepInfoResult searchLineDeepInfoResult);

    public IGSearchLineDeepInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGSearchLineDeepInfoObserverImpl) && getUID(this) == getUID((IGSearchLineDeepInfoObserverImpl) obj);
    }

    private static long getUID(IGSearchLineDeepInfoObserverImpl iGSearchLineDeepInfoObserverImpl) {
        long cPtr = getCPtr(iGSearchLineDeepInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGSearchLineDeepInfoObserverImpl iGSearchLineDeepInfoObserverImpl) {
        if (iGSearchLineDeepInfoObserverImpl == null) {
            return 0L;
        }
        return iGSearchLineDeepInfoObserverImpl.swigCPtr;
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
        IGSearchLineDeepInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGSearchLineDeepInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetLineDeepInfoResult(int i, int i2, SearchLineDeepInfoResult searchLineDeepInfoResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetLineDeepInfoResultNative(j, this, i, i2, 0L, searchLineDeepInfoResult);
    }

    public IGSearchLineDeepInfoObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IGSearchLineDeepInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
