package com.autonavi.gbl.data.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.data.model.LNDSNearCityInfo;
import com.autonavi.gbl.data.model.LndsNetWorkError;
import com.autonavi.gbl.data.observer.ILNDSNearCityListObserver;
import java.math.BigInteger;
import java.util.ArrayList;
@IntfAuto(target = ILNDSNearCityListObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILNDSNearCityListObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(ILNDSNearCityListObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ILNDSNearCityListObserverImpl_change_ownership(ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl, long j, boolean z);

    private static native void ILNDSNearCityListObserverImpl_director_connect(ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onNearCityRequestErrorNative(long j, ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl, BigInteger bigInteger, int i);

    private static native boolean onNearCityRequestSuccessNative(long j, ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl, BigInteger bigInteger, ArrayList<LNDSNearCityInfo> arrayList);

    public ILNDSNearCityListObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILNDSNearCityListObserverImpl) && getUID(this) == getUID((ILNDSNearCityListObserverImpl) obj);
    }

    private static long getUID(ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl) {
        long cPtr = getCPtr(iLNDSNearCityListObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILNDSNearCityListObserverImpl iLNDSNearCityListObserverImpl) {
        if (iLNDSNearCityListObserverImpl == null) {
            return 0L;
        }
        return iLNDSNearCityListObserverImpl.swigCPtr;
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
        ILNDSNearCityListObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ILNDSNearCityListObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean onNearCityRequestSuccess(BigInteger bigInteger, ArrayList<LNDSNearCityInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onNearCityRequestSuccessNative(j, this, bigInteger, arrayList);
    }

    public boolean onNearCityRequestError(BigInteger bigInteger, @LndsNetWorkError.LndsNetWorkError1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onNearCityRequestErrorNative(j, this, bigInteger, i);
    }

    public ILNDSNearCityListObserverImpl() {
        this(createNativeObj(), true);
        DataObserverJNI.swig_jni_init();
        ILNDSNearCityListObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
