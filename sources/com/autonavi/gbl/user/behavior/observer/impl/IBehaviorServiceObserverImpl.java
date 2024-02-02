package com.autonavi.gbl.user.behavior.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.user.behavior.model.FavoriteType;
import com.autonavi.gbl.user.behavior.model.SimpleFavoriteItem;
import com.autonavi.gbl.user.behavior.observer.IBehaviorServiceObserver;
import com.autonavi.gbl.user.syncsdk.model.SyncEventType;
import com.autonavi.gbl.user.syncsdk.model.SyncRet;
import java.util.ArrayList;
@IntfAuto(target = IBehaviorServiceObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IBehaviorServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IBehaviorServiceObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IBehaviorServiceObserverImpl_change_ownership(IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl, long j, boolean z);

    private static native void IBehaviorServiceObserverImpl_director_connect(IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void notify1Native(long j, IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl, int i, ArrayList<SimpleFavoriteItem> arrayList, boolean z);

    private static native void notifyNative(long j, IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl, int i, int i2);

    public IBehaviorServiceObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IBehaviorServiceObserverImpl) && getUID(this) == getUID((IBehaviorServiceObserverImpl) obj);
    }

    private static long getUID(IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl) {
        long cPtr = getCPtr(iBehaviorServiceObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IBehaviorServiceObserverImpl iBehaviorServiceObserverImpl) {
        if (iBehaviorServiceObserverImpl == null) {
            return 0L;
        }
        return iBehaviorServiceObserverImpl.swigCPtr;
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
        IBehaviorServiceObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IBehaviorServiceObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void notify(@SyncEventType.SyncEventType1 int i, @SyncRet.SyncRet1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notifyNative(j, this, i, i2);
    }

    public void notify(@FavoriteType.FavoriteType1 int i, ArrayList<SimpleFavoriteItem> arrayList, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        notify1Native(j, this, i, arrayList, z);
    }

    public IBehaviorServiceObserverImpl() {
        this(createNativeObj(), true);
        BehaviorObserverJNI.swig_jni_init();
        IBehaviorServiceObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
