package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsNavigationDynamicDataResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsNavigationDynamicData;
@IntfAuto(target = ICallBackWsNavigationDynamicData.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsNavigationDynamicDataImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsNavigationDynamicDataImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsNavigationDynamicDataImpl_change_ownership(ICallBackWsNavigationDynamicDataImpl iCallBackWsNavigationDynamicDataImpl, long j, boolean z);

    private static native void ICallBackWsNavigationDynamicDataImpl_director_connect(ICallBackWsNavigationDynamicDataImpl iCallBackWsNavigationDynamicDataImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsNavigationDynamicDataImpl iCallBackWsNavigationDynamicDataImpl, long j2, GWsNavigationDynamicDataResponseParam gWsNavigationDynamicDataResponseParam);

    public ICallBackWsNavigationDynamicDataImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsNavigationDynamicDataImpl) && getUID(this) == getUID((ICallBackWsNavigationDynamicDataImpl) obj);
    }

    private static long getUID(ICallBackWsNavigationDynamicDataImpl iCallBackWsNavigationDynamicDataImpl) {
        long cPtr = getCPtr(iCallBackWsNavigationDynamicDataImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsNavigationDynamicDataImpl iCallBackWsNavigationDynamicDataImpl) {
        if (iCallBackWsNavigationDynamicDataImpl == null) {
            return 0L;
        }
        return iCallBackWsNavigationDynamicDataImpl.swigCPtr;
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
        ICallBackWsNavigationDynamicDataImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsNavigationDynamicDataImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsNavigationDynamicDataResponseParam gWsNavigationDynamicDataResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsNavigationDynamicDataResponseParam);
    }

    public ICallBackWsNavigationDynamicDataImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsNavigationDynamicDataImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
