package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.observer.MapDataProvider;
@IntfAuto(target = MapDataProvider.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IMapDataProviderImpl {
    private static BindTable BIND_TABLE = new BindTable(IMapDataProviderImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IMapDataProviderImpl_change_ownership(IMapDataProviderImpl iMapDataProviderImpl, long j, boolean z);

    private static native void IMapDataProviderImpl_director_connect(IMapDataProviderImpl iMapDataProviderImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public IMapDataProviderImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IMapDataProviderImpl) && getUID(this) == getUID((IMapDataProviderImpl) obj);
    }

    private static long getUID(IMapDataProviderImpl iMapDataProviderImpl) {
        long cPtr = getCPtr(iMapDataProviderImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IMapDataProviderImpl iMapDataProviderImpl) {
        if (iMapDataProviderImpl == null) {
            return 0L;
        }
        return iMapDataProviderImpl.swigCPtr;
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
        IMapDataProviderImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IMapDataProviderImpl_change_ownership(this, this.swigCPtr, true);
    }

    public IMapDataProviderImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        IMapDataProviderImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
