package com.autonavi.gbl.activation.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.activation.model.AuthenticationGoodsInfo;
import com.autonavi.gbl.activation.model.AuthenticationResult;
import com.autonavi.gbl.activation.observer.IAuthenticationObserver;
import java.util.ArrayList;
@IntfAuto(target = IAuthenticationObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IAuthenticationObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IAuthenticationObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IAuthenticationObserverImpl_change_ownership(IAuthenticationObserverImpl iAuthenticationObserverImpl, long j, boolean z);

    private static native void IAuthenticationObserverImpl_director_connect(IAuthenticationObserverImpl iAuthenticationObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onErrorNative(long j, IAuthenticationObserverImpl iAuthenticationObserverImpl, long j2, AuthenticationResult authenticationResult);

    private static native void onStatusUpdatedNative(long j, IAuthenticationObserverImpl iAuthenticationObserverImpl, int i, ArrayList<AuthenticationGoodsInfo> arrayList);

    public IAuthenticationObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IAuthenticationObserverImpl) && getUID(this) == getUID((IAuthenticationObserverImpl) obj);
    }

    private static long getUID(IAuthenticationObserverImpl iAuthenticationObserverImpl) {
        long cPtr = getCPtr(iAuthenticationObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IAuthenticationObserverImpl iAuthenticationObserverImpl) {
        if (iAuthenticationObserverImpl == null) {
            return 0L;
        }
        return iAuthenticationObserverImpl.swigCPtr;
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
        IAuthenticationObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IAuthenticationObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onStatusUpdated(int i, ArrayList<AuthenticationGoodsInfo> arrayList) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onStatusUpdatedNative(j, this, i, arrayList);
    }

    public void onError(AuthenticationResult authenticationResult) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onErrorNative(j, this, 0L, authenticationResult);
    }

    public IAuthenticationObserverImpl() {
        this(createNativeObj(), true);
        ActivationObserverJNI.swig_jni_init();
        IAuthenticationObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
