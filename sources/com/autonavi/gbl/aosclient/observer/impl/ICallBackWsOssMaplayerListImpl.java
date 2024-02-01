package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsOssMaplayerListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsOssMaplayerList;
@IntfAuto(target = ICallBackWsOssMaplayerList.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsOssMaplayerListImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsOssMaplayerListImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsOssMaplayerListImpl_change_ownership(ICallBackWsOssMaplayerListImpl iCallBackWsOssMaplayerListImpl, long j, boolean z);

    private static native void ICallBackWsOssMaplayerListImpl_director_connect(ICallBackWsOssMaplayerListImpl iCallBackWsOssMaplayerListImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsOssMaplayerListImpl iCallBackWsOssMaplayerListImpl, long j2, GWsOssMaplayerListResponseParam gWsOssMaplayerListResponseParam);

    public ICallBackWsOssMaplayerListImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsOssMaplayerListImpl) && getUID(this) == getUID((ICallBackWsOssMaplayerListImpl) obj);
    }

    private static long getUID(ICallBackWsOssMaplayerListImpl iCallBackWsOssMaplayerListImpl) {
        long cPtr = getCPtr(iCallBackWsOssMaplayerListImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsOssMaplayerListImpl iCallBackWsOssMaplayerListImpl) {
        if (iCallBackWsOssMaplayerListImpl == null) {
            return 0L;
        }
        return iCallBackWsOssMaplayerListImpl.swigCPtr;
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
        ICallBackWsOssMaplayerListImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsOssMaplayerListImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsOssMaplayerListResponseParam gWsOssMaplayerListResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsOssMaplayerListResponseParam);
    }

    public ICallBackWsOssMaplayerListImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsOssMaplayerListImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
