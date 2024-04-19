package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.search.model.SearchAroundRecommendResult;
import com.autonavi.gbl.search.observer.IGSearchAroundRecommendObserver;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchAroundRecommendObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGSearchAroundRecommendObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGSearchAroundRecommendObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGSearchAroundRecommendObserverImpl_change_ownership(IGSearchAroundRecommendObserverImpl iGSearchAroundRecommendObserverImpl, long j, boolean z);

    private static native void IGSearchAroundRecommendObserverImpl_director_connect(IGSearchAroundRecommendObserverImpl iGSearchAroundRecommendObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetAroundRecommendResultNative(long j, IGSearchAroundRecommendObserverImpl iGSearchAroundRecommendObserverImpl, int i, int i2, long j2, SearchAroundRecommendResult searchAroundRecommendResult);

    public IGSearchAroundRecommendObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGSearchAroundRecommendObserverImpl) && getUID(this) == getUID((IGSearchAroundRecommendObserverImpl) obj);
    }

    private static long getUID(IGSearchAroundRecommendObserverImpl iGSearchAroundRecommendObserverImpl) {
        long cPtr = getCPtr(iGSearchAroundRecommendObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGSearchAroundRecommendObserverImpl iGSearchAroundRecommendObserverImpl) {
        if (iGSearchAroundRecommendObserverImpl == null) {
            return 0L;
        }
        return iGSearchAroundRecommendObserverImpl.swigCPtr;
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
        IGSearchAroundRecommendObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGSearchAroundRecommendObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetAroundRecommendResult(int i, @EGErr.EGErr1 int i2, SearchAroundRecommendResult searchAroundRecommendResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetAroundRecommendResultNative(j, this, i, i2, 0L, searchAroundRecommendResult);
    }

    public IGSearchAroundRecommendObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IGSearchAroundRecommendObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
