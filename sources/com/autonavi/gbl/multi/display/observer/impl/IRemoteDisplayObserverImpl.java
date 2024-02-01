package com.autonavi.gbl.multi.display.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.multi.display.model.DisplayType;
import com.autonavi.gbl.multi.display.observer.IRemoteDisplayObserver;
@IntfAuto(target = IRemoteDisplayObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IRemoteDisplayObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IRemoteDisplayObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IRemoteDisplayObserverImpl_change_ownership(IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl, long j, boolean z);

    private static native void IRemoteDisplayObserverImpl_director_connect(IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRemoteDisplayCreatedNative(long j, IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl, int i, int i2);

    private static native void onRemoteDisplayDestroyedNative(long j, IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl, int i, int i2);

    public IRemoteDisplayObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IRemoteDisplayObserverImpl) && getUID(this) == getUID((IRemoteDisplayObserverImpl) obj);
    }

    private static long getUID(IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl) {
        long cPtr = getCPtr(iRemoteDisplayObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IRemoteDisplayObserverImpl iRemoteDisplayObserverImpl) {
        if (iRemoteDisplayObserverImpl == null) {
            return 0L;
        }
        return iRemoteDisplayObserverImpl.swigCPtr;
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
        IRemoteDisplayObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IRemoteDisplayObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRemoteDisplayCreated(int i, @DisplayType.DisplayType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRemoteDisplayCreatedNative(j, this, i, i2);
    }

    public void onRemoteDisplayDestroyed(int i, @DisplayType.DisplayType1 int i2) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRemoteDisplayDestroyedNative(j, this, i, i2);
    }

    public IRemoteDisplayObserverImpl() {
        this(createNativeObj(), true);
        MultiDisplayObserverJNI.swig_jni_init();
        IRemoteDisplayObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
