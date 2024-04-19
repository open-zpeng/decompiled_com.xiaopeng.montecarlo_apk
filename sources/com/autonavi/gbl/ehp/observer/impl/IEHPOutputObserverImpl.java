package com.autonavi.gbl.ehp.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.ehp.observer.IEHPOutputObserver;
@IntfAuto(target = IEHPOutputObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IEHPOutputObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IEHPOutputObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IEHPOutputObserverImpl_change_ownership(IEHPOutputObserverImpl iEHPOutputObserverImpl, long j, boolean z);

    private static native void IEHPOutputObserverImpl_director_connect(IEHPOutputObserverImpl iEHPOutputObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void outputNative(long j, IEHPOutputObserverImpl iEHPOutputObserverImpl, String str, byte[] bArr);

    public IEHPOutputObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IEHPOutputObserverImpl) && getUID(this) == getUID((IEHPOutputObserverImpl) obj);
    }

    private static long getUID(IEHPOutputObserverImpl iEHPOutputObserverImpl) {
        long cPtr = getCPtr(iEHPOutputObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IEHPOutputObserverImpl iEHPOutputObserverImpl) {
        if (iEHPOutputObserverImpl == null) {
            return 0L;
        }
        return iEHPOutputObserverImpl.swigCPtr;
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
        IEHPOutputObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IEHPOutputObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void output(String str, byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        outputNative(j, this, str, bArr);
    }

    public IEHPOutputObserverImpl() {
        this(createNativeObj(), true);
        EhpObserverJNI.swig_jni_init();
        IEHPOutputObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
