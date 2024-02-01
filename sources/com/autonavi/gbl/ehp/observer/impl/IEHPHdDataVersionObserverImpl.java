package com.autonavi.gbl.ehp.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.ehp.observer.IEHPHdDataVersionObserver;
@IntfAuto(target = IEHPHdDataVersionObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IEHPHdDataVersionObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IEHPHdDataVersionObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IEHPHdDataVersionObserverImpl_change_ownership(IEHPHdDataVersionObserverImpl iEHPHdDataVersionObserverImpl, long j, boolean z);

    private static native void IEHPHdDataVersionObserverImpl_director_connect(IEHPHdDataVersionObserverImpl iEHPHdDataVersionObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onHdDataVersionNative(long j, IEHPHdDataVersionObserverImpl iEHPHdDataVersionObserverImpl, String str);

    public IEHPHdDataVersionObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IEHPHdDataVersionObserverImpl) && getUID(this) == getUID((IEHPHdDataVersionObserverImpl) obj);
    }

    private static long getUID(IEHPHdDataVersionObserverImpl iEHPHdDataVersionObserverImpl) {
        long cPtr = getCPtr(iEHPHdDataVersionObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IEHPHdDataVersionObserverImpl iEHPHdDataVersionObserverImpl) {
        if (iEHPHdDataVersionObserverImpl == null) {
            return 0L;
        }
        return iEHPHdDataVersionObserverImpl.swigCPtr;
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
        IEHPHdDataVersionObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IEHPHdDataVersionObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onHdDataVersion(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onHdDataVersionNative(j, this, str);
    }

    public IEHPHdDataVersionObserverImpl() {
        this(createNativeObj(), true);
        EhpObserverJNI.swig_jni_init();
        IEHPHdDataVersionObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
