package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.model.MapNum;
import com.autonavi.gbl.data.observer.IMapNumObserver;
@IntfAuto(target = IMapNumObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IMapNumObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapNumObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapNumObserverImpl_change_ownership(IMapNumObserverImpl iMapNumObserverImpl, long j, boolean z);

    private static native void IMapNumObserverImpl_director_connect(IMapNumObserverImpl iMapNumObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRequestMapNumNative(long j, IMapNumObserverImpl iMapNumObserverImpl, int i, long j2, MapNum mapNum);

    public IMapNumObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapNumObserverImpl) && getUID(this) == getUID((IMapNumObserverImpl) obj);
    }

    private static long getUID(IMapNumObserverImpl iMapNumObserverImpl) {
        long cPtr = getCPtr(iMapNumObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapNumObserverImpl iMapNumObserverImpl) {
        if (iMapNumObserverImpl == null) {
            return 0L;
        }
        return iMapNumObserverImpl.swigCPtr;
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
        IMapNumObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapNumObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRequestMapNum(int i, MapNum mapNum) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRequestMapNumNative(j, this, i, 0L, mapNum);
    }

    public IMapNumObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        IMapNumObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
