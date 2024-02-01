package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchDetailInfoResult;
import com.autonavi.gbl.search.observer.IGSearchDetailInfoObserver;
@IntfAuto(target = IGSearchDetailInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGSearchDetailInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGSearchDetailInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGSearchDetailInfoObserverImpl_change_ownership(IGSearchDetailInfoObserverImpl iGSearchDetailInfoObserverImpl, long j, boolean z);

    private static native void IGSearchDetailInfoObserverImpl_director_connect(IGSearchDetailInfoObserverImpl iGSearchDetailInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetDetailInfoResultNative(long j, IGSearchDetailInfoObserverImpl iGSearchDetailInfoObserverImpl, int i, int i2, long j2, SearchDetailInfoResult searchDetailInfoResult);

    public IGSearchDetailInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGSearchDetailInfoObserverImpl) && getUID(this) == getUID((IGSearchDetailInfoObserverImpl) obj);
    }

    private static long getUID(IGSearchDetailInfoObserverImpl iGSearchDetailInfoObserverImpl) {
        long cPtr = getCPtr(iGSearchDetailInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGSearchDetailInfoObserverImpl iGSearchDetailInfoObserverImpl) {
        if (iGSearchDetailInfoObserverImpl == null) {
            return 0L;
        }
        return iGSearchDetailInfoObserverImpl.swigCPtr;
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
        IGSearchDetailInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGSearchDetailInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetDetailInfoResult(int i, int i2, SearchDetailInfoResult searchDetailInfoResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetDetailInfoResultNative(j, this, i, i2, 0L, searchDetailInfoResult);
    }

    public IGSearchDetailInfoObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IGSearchDetailInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
