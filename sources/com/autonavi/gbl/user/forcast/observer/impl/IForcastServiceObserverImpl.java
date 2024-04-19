package com.autonavi.gbl.user.forcast.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.user.forcast.model.ForcastArrivedData;
import com.autonavi.gbl.user.forcast.observer.IForcastServiceObserver;
import com.autonavi.gbl.util.model.ErrorCode;
@IntfAuto(target = IForcastServiceObserver.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IForcastServiceObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IForcastServiceObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IForcastServiceObserverImpl_change_ownership(IForcastServiceObserverImpl iForcastServiceObserverImpl, long j, boolean z);

    private static native void IForcastServiceObserverImpl_director_connect(IForcastServiceObserverImpl iForcastServiceObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onForcastArrivedDataNative(long j, IForcastServiceObserverImpl iForcastServiceObserverImpl, long j2, ForcastArrivedData forcastArrivedData);

    private static native void onInitNative(long j, IForcastServiceObserverImpl iForcastServiceObserverImpl, int i);

    private static native void onSetLoginInfoNative(long j, IForcastServiceObserverImpl iForcastServiceObserverImpl, int i);

    public IForcastServiceObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IForcastServiceObserverImpl) && getUID(this) == getUID((IForcastServiceObserverImpl) obj);
    }

    private static long getUID(IForcastServiceObserverImpl iForcastServiceObserverImpl) {
        long cPtr = getCPtr(iForcastServiceObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IForcastServiceObserverImpl iForcastServiceObserverImpl) {
        if (iForcastServiceObserverImpl == null) {
            return 0L;
        }
        return iForcastServiceObserverImpl.swigCPtr;
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
        IForcastServiceObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IForcastServiceObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onInit(@ErrorCode.ErrorCode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onInitNative(j, this, i);
    }

    public void onSetLoginInfo(@ErrorCode.ErrorCode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onSetLoginInfoNative(j, this, i);
    }

    public void onForcastArrivedData(ForcastArrivedData forcastArrivedData) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onForcastArrivedDataNative(j, this, 0L, forcastArrivedData);
    }

    public IForcastServiceObserverImpl() {
        this(createNativeObj(), true);
        ForcastObserverJNI.swig_jni_init();
        IForcastServiceObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
