package com.autonavi.gbl.search.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.search.model.SearchChargingLiveStatusResult;
import com.autonavi.gbl.search.observer.IGSearchChargingLiveStatusObserver;
@IntfAuto(target = IGSearchChargingLiveStatusObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGSearchChargingLiveStatusObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IGSearchChargingLiveStatusObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGSearchChargingLiveStatusObserverImpl_change_ownership(IGSearchChargingLiveStatusObserverImpl iGSearchChargingLiveStatusObserverImpl, long j, boolean z);

    private static native void IGSearchChargingLiveStatusObserverImpl_director_connect(IGSearchChargingLiveStatusObserverImpl iGSearchChargingLiveStatusObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGetChargingLiveStatusResultNative(long j, IGSearchChargingLiveStatusObserverImpl iGSearchChargingLiveStatusObserverImpl, int i, int i2, long j2, SearchChargingLiveStatusResult searchChargingLiveStatusResult);

    public IGSearchChargingLiveStatusObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGSearchChargingLiveStatusObserverImpl) && getUID(this) == getUID((IGSearchChargingLiveStatusObserverImpl) obj);
    }

    private static long getUID(IGSearchChargingLiveStatusObserverImpl iGSearchChargingLiveStatusObserverImpl) {
        long cPtr = getCPtr(iGSearchChargingLiveStatusObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGSearchChargingLiveStatusObserverImpl iGSearchChargingLiveStatusObserverImpl) {
        if (iGSearchChargingLiveStatusObserverImpl == null) {
            return 0L;
        }
        return iGSearchChargingLiveStatusObserverImpl.swigCPtr;
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
        IGSearchChargingLiveStatusObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGSearchChargingLiveStatusObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGetChargingLiveStatusResult(int i, int i2, SearchChargingLiveStatusResult searchChargingLiveStatusResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGetChargingLiveStatusResultNative(j, this, i, i2, 0L, searchChargingLiveStatusResult);
    }

    public IGSearchChargingLiveStatusObserverImpl() {
        this(createNativeObj(), true);
        SearchObserverJNI.swig_jni_init();
        IGSearchChargingLiveStatusObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
