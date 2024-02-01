package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.observer.ILNDSGlobalFileUpdateObserver;
import java.math.BigInteger;
@IntfAuto(target = ILNDSGlobalFileUpdateObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILNDSGlobalFileUpdateObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILNDSGlobalFileUpdateObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILNDSGlobalFileUpdateObserverImpl_change_ownership(ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl, long j, boolean z);

    private static native void ILNDSGlobalFileUpdateObserverImpl_director_connect(ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onGlobalFileUpdateNative(long j, ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl, BigInteger bigInteger, int i);

    private static native void onGlobalFileVersionNative(long j, ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl, BigInteger bigInteger, String str);

    private static native void onTileGlobalFileUpdateNative(long j, ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl, BigInteger bigInteger, int i);

    public ILNDSGlobalFileUpdateObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILNDSGlobalFileUpdateObserverImpl) && getUID(this) == getUID((ILNDSGlobalFileUpdateObserverImpl) obj);
    }

    private static long getUID(ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl) {
        long cPtr = getCPtr(iLNDSGlobalFileUpdateObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILNDSGlobalFileUpdateObserverImpl iLNDSGlobalFileUpdateObserverImpl) {
        if (iLNDSGlobalFileUpdateObserverImpl == null) {
            return 0L;
        }
        return iLNDSGlobalFileUpdateObserverImpl.swigCPtr;
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
        ILNDSGlobalFileUpdateObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILNDSGlobalFileUpdateObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onGlobalFileUpdate(BigInteger bigInteger, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGlobalFileUpdateNative(j, this, bigInteger, i);
    }

    public void onGlobalFileVersion(BigInteger bigInteger, String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onGlobalFileVersionNative(j, this, bigInteger, str);
    }

    public void onTileGlobalFileUpdate(BigInteger bigInteger, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onTileGlobalFileUpdateNative(j, this, bigInteger, i);
    }

    public ILNDSGlobalFileUpdateObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        ILNDSGlobalFileUpdateObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
