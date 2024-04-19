package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.pos.model.LocInfo;
import com.autonavi.gbl.pos.observer.IPosLocInfoObserver;
@IntfAuto(target = IPosLocInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosLocInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPosLocInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPosLocInfoObserverImpl_change_ownership(IPosLocInfoObserverImpl iPosLocInfoObserverImpl, long j, boolean z);

    private static native void IPosLocInfoObserverImpl_director_connect(IPosLocInfoObserverImpl iPosLocInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onLocInfoUpdateNative(long j, IPosLocInfoObserverImpl iPosLocInfoObserverImpl, long j2, LocInfo locInfo);

    public IPosLocInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosLocInfoObserverImpl) && getUID(this) == getUID((IPosLocInfoObserverImpl) obj);
    }

    private static long getUID(IPosLocInfoObserverImpl iPosLocInfoObserverImpl) {
        long cPtr = getCPtr(iPosLocInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosLocInfoObserverImpl iPosLocInfoObserverImpl) {
        if (iPosLocInfoObserverImpl == null) {
            return 0L;
        }
        return iPosLocInfoObserverImpl.swigCPtr;
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
        IPosLocInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPosLocInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onLocInfoUpdate(LocInfo locInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onLocInfoUpdateNative(j, this, 0L, locInfo);
    }

    public IPosLocInfoObserverImpl() {
        this(createNativeObj(), true);
        PosObserverJNI.swig_jni_init();
        IPosLocInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
