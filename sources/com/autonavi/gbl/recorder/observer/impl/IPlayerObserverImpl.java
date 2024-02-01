package com.autonavi.gbl.recorder.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.recorder.model.PlayProgress;
import com.autonavi.gbl.recorder.observer.IPlayerObserver;
@IntfAuto(target = IPlayerObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPlayerObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IPlayerObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IPlayerObserverImpl_change_ownership(IPlayerObserverImpl iPlayerObserverImpl, long j, boolean z);

    private static native void IPlayerObserverImpl_director_connect(IPlayerObserverImpl iPlayerObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onPlayProgressNative(long j, IPlayerObserverImpl iPlayerObserverImpl, long j2, PlayProgress playProgress);

    public IPlayerObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPlayerObserverImpl) && getUID(this) == getUID((IPlayerObserverImpl) obj);
    }

    private static long getUID(IPlayerObserverImpl iPlayerObserverImpl) {
        long cPtr = getCPtr(iPlayerObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPlayerObserverImpl iPlayerObserverImpl) {
        if (iPlayerObserverImpl == null) {
            return 0L;
        }
        return iPlayerObserverImpl.swigCPtr;
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
        IPlayerObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IPlayerObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onPlayProgress(PlayProgress playProgress) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onPlayProgressNative(j, this, 0L, playProgress);
    }

    public IPlayerObserverImpl() {
        this(createNativeObj(), true);
        RecorderObserverJNI.swig_jni_init();
        IPlayerObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
