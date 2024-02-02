package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.search.model.SearchDeepInfoResult;
import com.autonavi.gbl.search.observer.IGSearchDeepInfoObserver;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchDeepInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGSearchDeepInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGSearchDeepInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGSearchDeepInfoObserverImpl_change_ownership(IGSearchDeepInfoObserverImpl iGSearchDeepInfoObserverImpl, long j, boolean z);

    private static native void IGSearchDeepInfoObserverImpl_director_connect(IGSearchDeepInfoObserverImpl iGSearchDeepInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetDeepInfoResultNative(long j, IGSearchDeepInfoObserverImpl iGSearchDeepInfoObserverImpl, int i, int i2, long j2, SearchDeepInfoResult searchDeepInfoResult);

    public IGSearchDeepInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGSearchDeepInfoObserverImpl) && getUID(this) == getUID((IGSearchDeepInfoObserverImpl) obj);
    }

    private static long getUID(IGSearchDeepInfoObserverImpl iGSearchDeepInfoObserverImpl) {
        long cPtr = getCPtr(iGSearchDeepInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGSearchDeepInfoObserverImpl iGSearchDeepInfoObserverImpl) {
        if (iGSearchDeepInfoObserverImpl == null) {
            return 0L;
        }
        return iGSearchDeepInfoObserverImpl.swigCPtr;
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
        IGSearchDeepInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGSearchDeepInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetDeepInfoResult(int i, @EGErr.EGErr1 int i2, SearchDeepInfoResult searchDeepInfoResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetDeepInfoResultNative(j, this, i, i2, 0L, searchDeepInfoResult);
    }

    public IGSearchDeepInfoObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IGSearchDeepInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
