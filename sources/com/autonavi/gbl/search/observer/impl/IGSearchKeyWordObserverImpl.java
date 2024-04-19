package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.search.model.SearchKeywordResult;
import com.autonavi.gbl.search.observer.IGSearchKeyWordObserver;
import com.autonavi.gbl.util.model.EGErr;
@IntfAuto(target = IGSearchKeyWordObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGSearchKeyWordObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGSearchKeyWordObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGSearchKeyWordObserverImpl_change_ownership(IGSearchKeyWordObserverImpl iGSearchKeyWordObserverImpl, long j, boolean z);

    private static native void IGSearchKeyWordObserverImpl_director_connect(IGSearchKeyWordObserverImpl iGSearchKeyWordObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetKeyWordResultNative(long j, IGSearchKeyWordObserverImpl iGSearchKeyWordObserverImpl, int i, int i2, long j2, SearchKeywordResult searchKeywordResult);

    public IGSearchKeyWordObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGSearchKeyWordObserverImpl) && getUID(this) == getUID((IGSearchKeyWordObserverImpl) obj);
    }

    private static long getUID(IGSearchKeyWordObserverImpl iGSearchKeyWordObserverImpl) {
        long cPtr = getCPtr(iGSearchKeyWordObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGSearchKeyWordObserverImpl iGSearchKeyWordObserverImpl) {
        if (iGSearchKeyWordObserverImpl == null) {
            return 0L;
        }
        return iGSearchKeyWordObserverImpl.swigCPtr;
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
        IGSearchKeyWordObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGSearchKeyWordObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetKeyWordResult(int i, @EGErr.EGErr1 int i2, SearchKeywordResult searchKeywordResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetKeyWordResultNative(j, this, i, i2, 0L, searchKeywordResult);
    }

    public IGSearchKeyWordObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IGSearchKeyWordObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
