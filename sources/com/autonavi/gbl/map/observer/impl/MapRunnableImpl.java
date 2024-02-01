package com.autonavi.gbl.map.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.observer.IMapRunnable;
@IntfAuto(target = IMapRunnable.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class MapRunnableImpl {
    private static BindTable BIND_TABLE = new BindTable(MapRunnableImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void MapRunnableImpl_change_ownership(MapRunnableImpl mapRunnableImpl, long j, boolean z);

    private static native void MapRunnableImpl_director_connect(MapRunnableImpl mapRunnableImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void runNative(long j, MapRunnableImpl mapRunnableImpl);

    public MapRunnableImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof MapRunnableImpl) && getUID(this) == getUID((MapRunnableImpl) obj);
    }

    private static long getUID(MapRunnableImpl mapRunnableImpl) {
        long cPtr = getCPtr(mapRunnableImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(MapRunnableImpl mapRunnableImpl) {
        if (mapRunnableImpl == null) {
            return 0L;
        }
        return mapRunnableImpl.swigCPtr;
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
        MapRunnableImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MapRunnableImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void run() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        runNative(j, this);
    }

    public MapRunnableImpl() {
        this(createNativeObj(), true);
        MapObserverJNI.swig_jni_init();
        MapRunnableImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
