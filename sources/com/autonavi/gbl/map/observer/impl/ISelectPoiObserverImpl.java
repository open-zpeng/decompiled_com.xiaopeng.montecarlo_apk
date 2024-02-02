package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.SelectOutInfo;
import com.autonavi.gbl.map.observer.ISelectPoiObserver;
@IntfAuto(target = ISelectPoiObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ISelectPoiObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ISelectPoiObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ISelectPoiObserverImpl_change_ownership(ISelectPoiObserverImpl iSelectPoiObserverImpl, long j, boolean z);

    private static native void ISelectPoiObserverImpl_director_connect(ISelectPoiObserverImpl iSelectPoiObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onSelectPoiOutNative(long j, ISelectPoiObserverImpl iSelectPoiObserverImpl, long j2, long j3, SelectOutInfo selectOutInfo);

    public ISelectPoiObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ISelectPoiObserverImpl) && getUID(this) == getUID((ISelectPoiObserverImpl) obj);
    }

    private static long getUID(ISelectPoiObserverImpl iSelectPoiObserverImpl) {
        long cPtr = getCPtr(iSelectPoiObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ISelectPoiObserverImpl iSelectPoiObserverImpl) {
        if (iSelectPoiObserverImpl == null) {
            return 0L;
        }
        return iSelectPoiObserverImpl.swigCPtr;
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
        ISelectPoiObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ISelectPoiObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onSelectPoiOut(long j, SelectOutInfo selectOutInfo) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onSelectPoiOutNative(j2, this, j, 0L, selectOutInfo);
    }

    public ISelectPoiObserverImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        ISelectPoiObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
