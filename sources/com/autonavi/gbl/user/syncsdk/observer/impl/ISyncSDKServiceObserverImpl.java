package com.autonavi.gbl.user.syncsdk.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import com.autonavi.gbl.user.syncsdk.observer.ISyncSDKServiceObserver;
@IntfAuto(target = ISyncSDKServiceObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ISyncSDKServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ISyncSDKServiceObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ISyncSDKServiceObserverImpl_change_ownership(ISyncSDKServiceObserverImpl iSyncSDKServiceObserverImpl, long j, boolean z);

    private static native void ISyncSDKServiceObserverImpl_director_connect(ISyncSDKServiceObserverImpl iSyncSDKServiceObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void notifyNative(long j, ISyncSDKServiceObserverImpl iSyncSDKServiceObserverImpl, int i, int i2);

    public ISyncSDKServiceObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ISyncSDKServiceObserverImpl) && getUID(this) == getUID((ISyncSDKServiceObserverImpl) obj);
    }

    private static long getUID(ISyncSDKServiceObserverImpl iSyncSDKServiceObserverImpl) {
        long cPtr = getCPtr(iSyncSDKServiceObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ISyncSDKServiceObserverImpl iSyncSDKServiceObserverImpl) {
        if (iSyncSDKServiceObserverImpl == null) {
            return 0L;
        }
        return iSyncSDKServiceObserverImpl.swigCPtr;
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
        ISyncSDKServiceObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ISyncSDKServiceObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyNative(j, this, i, i2);
    }

    public ISyncSDKServiceObserverImpl() {
        this(createNativeObj(), true);
        SyncsdkObserverJNI.swig_jni_init();
        ISyncSDKServiceObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
