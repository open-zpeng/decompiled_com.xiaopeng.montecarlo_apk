package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.AuthTokenInfo;
import com.autonavi.gbl.aosclient.model.GWsAuthcarServicelistResponseParam;
import com.autonavi.gbl.aosclient.model.GWsAuthcarTokenResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackAuthentication;
@IntfAuto(target = ICallBackAuthentication.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackAuthenticationImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackAuthenticationImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackAuthenticationImpl_change_ownership(ICallBackAuthenticationImpl iCallBackAuthenticationImpl, long j, boolean z);

    private static native void ICallBackAuthenticationImpl_director_connect(ICallBackAuthenticationImpl iCallBackAuthenticationImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onAuthcarTokenErrorNative(long j, ICallBackAuthenticationImpl iCallBackAuthenticationImpl, long j2, AuthTokenInfo authTokenInfo);

    private static native void onAuthcarTokenErrorSwigExplicitICallBackAuthenticationImplNative(long j, ICallBackAuthenticationImpl iCallBackAuthenticationImpl, long j2, AuthTokenInfo authTokenInfo);

    private static native void onRecvAuthcarServerlistNative(long j, ICallBackAuthenticationImpl iCallBackAuthenticationImpl, long j2, GWsAuthcarServicelistResponseParam gWsAuthcarServicelistResponseParam);

    private static native void onRecvAuthcarTokenNative(long j, ICallBackAuthenticationImpl iCallBackAuthenticationImpl, long j2, GWsAuthcarTokenResponseParam gWsAuthcarTokenResponseParam);

    public ICallBackAuthenticationImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackAuthenticationImpl) && getUID(this) == getUID((ICallBackAuthenticationImpl) obj);
    }

    private static long getUID(ICallBackAuthenticationImpl iCallBackAuthenticationImpl) {
        long cPtr = getCPtr(iCallBackAuthenticationImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackAuthenticationImpl iCallBackAuthenticationImpl) {
        if (iCallBackAuthenticationImpl == null) {
            return 0L;
        }
        return iCallBackAuthenticationImpl.swigCPtr;
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
        ICallBackAuthenticationImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackAuthenticationImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAuthcarServerlist(GWsAuthcarServicelistResponseParam gWsAuthcarServicelistResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAuthcarServerlistNative(j, this, 0L, gWsAuthcarServicelistResponseParam);
    }

    public void onRecvAuthcarToken(GWsAuthcarTokenResponseParam gWsAuthcarTokenResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAuthcarTokenNative(j, this, 0L, gWsAuthcarTokenResponseParam);
    }

    public void onAuthcarTokenError(AuthTokenInfo authTokenInfo) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == ICallBackAuthenticationImpl.class) {
            onAuthcarTokenErrorNative(this.swigCPtr, this, 0L, authTokenInfo);
        } else {
            onAuthcarTokenErrorSwigExplicitICallBackAuthenticationImplNative(this.swigCPtr, this, 0L, authTokenInfo);
        }
    }

    public ICallBackAuthenticationImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackAuthenticationImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
