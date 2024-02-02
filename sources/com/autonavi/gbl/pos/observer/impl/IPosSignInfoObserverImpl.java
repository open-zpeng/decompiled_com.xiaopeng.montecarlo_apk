package com.autonavi.gbl.pos.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.pos.model.LocSignData;
import com.autonavi.gbl.pos.observer.IPosSignInfoObserver;
@IntfAuto(target = IPosSignInfoObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPosSignInfoObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPosSignInfoObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPosSignInfoObserverImpl_change_ownership(IPosSignInfoObserverImpl iPosSignInfoObserverImpl, long j, boolean z);

    private static native void IPosSignInfoObserverImpl_director_connect(IPosSignInfoObserverImpl iPosSignInfoObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onSignInfoUpdateNative(long j, IPosSignInfoObserverImpl iPosSignInfoObserverImpl, long j2, LocSignData locSignData);

    public IPosSignInfoObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPosSignInfoObserverImpl) && getUID(this) == getUID((IPosSignInfoObserverImpl) obj);
    }

    private static long getUID(IPosSignInfoObserverImpl iPosSignInfoObserverImpl) {
        long cPtr = getCPtr(iPosSignInfoObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPosSignInfoObserverImpl iPosSignInfoObserverImpl) {
        if (iPosSignInfoObserverImpl == null) {
            return 0L;
        }
        return iPosSignInfoObserverImpl.swigCPtr;
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
        IPosSignInfoObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPosSignInfoObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onSignInfoUpdate(LocSignData locSignData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onSignInfoUpdateNative(j, this, 0L, locSignData);
    }

    public IPosSignInfoObserverImpl() {
        this(createNativeObj(), true);
        PosObserverJNI.swig_jni_init();
        IPosSignInfoObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
