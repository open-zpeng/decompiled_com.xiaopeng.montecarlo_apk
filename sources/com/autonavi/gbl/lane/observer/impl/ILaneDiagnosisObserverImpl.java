package com.autonavi.gbl.lane.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.observer.ILaneDiagnosisObserver;
@IntfAuto(target = ILaneDiagnosisObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneDiagnosisObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneDiagnosisObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILaneDiagnosisObserverImpl_change_ownership(ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl, long j, boolean z);

    private static native void ILaneDiagnosisObserverImpl_director_connect(ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onUpdateDiagnosisNative(long j, ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl, String str);

    public ILaneDiagnosisObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneDiagnosisObserverImpl) && getUID(this) == getUID((ILaneDiagnosisObserverImpl) obj);
    }

    private static long getUID(ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl) {
        long cPtr = getCPtr(iLaneDiagnosisObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneDiagnosisObserverImpl iLaneDiagnosisObserverImpl) {
        if (iLaneDiagnosisObserverImpl == null) {
            return 0L;
        }
        return iLaneDiagnosisObserverImpl.swigCPtr;
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
        ILaneDiagnosisObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILaneDiagnosisObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onUpdateDiagnosis(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onUpdateDiagnosisNative(j, this, str);
    }

    public ILaneDiagnosisObserverImpl() {
        this(createNativeObj(), true);
        LaneObserverJNI.swig_jni_init();
        ILaneDiagnosisObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
