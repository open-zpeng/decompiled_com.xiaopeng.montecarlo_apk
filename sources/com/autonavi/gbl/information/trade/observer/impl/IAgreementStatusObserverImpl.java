package com.autonavi.gbl.information.trade.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.information.trade.model.AgreementStatusResult;
import com.autonavi.gbl.information.trade.observer.IAgreementStatusObserver;
@IntfAuto(target = IAgreementStatusObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IAgreementStatusObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IAgreementStatusObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IAgreementStatusObserverImpl_change_ownership(IAgreementStatusObserverImpl iAgreementStatusObserverImpl, long j, boolean z);

    private static native void IAgreementStatusObserverImpl_director_connect(IAgreementStatusObserverImpl iAgreementStatusObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onResultNative(long j, IAgreementStatusObserverImpl iAgreementStatusObserverImpl, long j2, AgreementStatusResult agreementStatusResult);

    public IAgreementStatusObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IAgreementStatusObserverImpl) && getUID(this) == getUID((IAgreementStatusObserverImpl) obj);
    }

    private static long getUID(IAgreementStatusObserverImpl iAgreementStatusObserverImpl) {
        long cPtr = getCPtr(iAgreementStatusObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IAgreementStatusObserverImpl iAgreementStatusObserverImpl) {
        if (iAgreementStatusObserverImpl == null) {
            return 0L;
        }
        return iAgreementStatusObserverImpl.swigCPtr;
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
        IAgreementStatusObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IAgreementStatusObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onResult(AgreementStatusResult agreementStatusResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onResultNative(j, this, 0L, agreementStatusResult);
    }

    public IAgreementStatusObserverImpl() {
        this(createNativeObj(), true);
        InformationTradeObserverJNI.swig_jni_init();
        IAgreementStatusObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
