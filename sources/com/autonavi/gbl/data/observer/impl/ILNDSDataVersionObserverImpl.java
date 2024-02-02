package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.model.LNDS_NETWORK_ERROR;
import com.autonavi.gbl.data.observer.ILNDSDataVersionObserver;
import java.math.BigInteger;
@IntfAuto(target = ILNDSDataVersionObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILNDSDataVersionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILNDSDataVersionObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILNDSDataVersionObserverImpl_change_ownership(ILNDSDataVersionObserverImpl iLNDSDataVersionObserverImpl, long j, boolean z);

    private static native void ILNDSDataVersionObserverImpl_director_connect(ILNDSDataVersionObserverImpl iLNDSDataVersionObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onLNDSDataVersionNative(long j, ILNDSDataVersionObserverImpl iLNDSDataVersionObserverImpl, BigInteger bigInteger, int i, String str);

    public ILNDSDataVersionObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILNDSDataVersionObserverImpl) && getUID(this) == getUID((ILNDSDataVersionObserverImpl) obj);
    }

    private static long getUID(ILNDSDataVersionObserverImpl iLNDSDataVersionObserverImpl) {
        long cPtr = getCPtr(iLNDSDataVersionObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILNDSDataVersionObserverImpl iLNDSDataVersionObserverImpl) {
        if (iLNDSDataVersionObserverImpl == null) {
            return 0L;
        }
        return iLNDSDataVersionObserverImpl.swigCPtr;
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
        ILNDSDataVersionObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILNDSDataVersionObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onLNDSDataVersion(BigInteger bigInteger, @LNDS_NETWORK_ERROR.LNDS_NETWORK_ERROR1 int i, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onLNDSDataVersionNative(j, this, bigInteger, i, str);
    }

    public ILNDSDataVersionObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        ILNDSDataVersionObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
