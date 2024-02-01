package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.observer.IConsisMessageAdapter;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
@IntfAuto(target = IConsisMessageAdapter.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IConsisMessageAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(IConsisMessageAdapterImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IConsisMessageAdapterImpl_change_ownership(IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j, boolean z);

    private static native void IConsisMessageAdapterImpl_director_connect(IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onPauseNaviNative(long j, IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j2, int i);

    private static native boolean onResumeNaviNative(long j, IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j2, int i);

    private static native void onSelectMainPathIDNative(long j, IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j2, int i);

    private static native boolean onSetNaviPathNative(long j, IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j2, NaviPathImpl naviPathImpl, int i);

    private static native boolean onStartNaviNative(long j, IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j2, int i, int i2);

    private static native boolean onStopNaviNative(long j, IConsisMessageAdapterImpl iConsisMessageAdapterImpl, long j2, int i);

    public IConsisMessageAdapterImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IConsisMessageAdapterImpl) && getUID(this) == getUID((IConsisMessageAdapterImpl) obj);
    }

    private static long getUID(IConsisMessageAdapterImpl iConsisMessageAdapterImpl) {
        long cPtr = getCPtr(iConsisMessageAdapterImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IConsisMessageAdapterImpl iConsisMessageAdapterImpl) {
        if (iConsisMessageAdapterImpl == null) {
            return 0L;
        }
        return iConsisMessageAdapterImpl.swigCPtr;
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
        IConsisMessageAdapterImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IConsisMessageAdapterImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean onStartNavi(long j, @NaviType.NaviType1 int i, int i2) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return onStartNaviNative(j2, this, j, i, i2);
    }

    public boolean onStopNavi(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return onStopNaviNative(j2, this, j, i);
    }

    public boolean onPauseNavi(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return onPauseNaviNative(j2, this, j, i);
    }

    public boolean onResumeNavi(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return onResumeNaviNative(j2, this, j, i);
    }

    public boolean onSetNaviPath(NaviPathImpl naviPathImpl, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onSetNaviPathNative(j, this, NaviPathImpl.getCPtr(naviPathImpl), naviPathImpl, i);
    }

    public void onSelectMainPathID(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onSelectMainPathIDNative(j2, this, j, i);
    }

    public IConsisMessageAdapterImpl() {
        this(createNativeObj(), true);
        ConsisObserverJNI.swig_jni_init();
        IConsisMessageAdapterImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
