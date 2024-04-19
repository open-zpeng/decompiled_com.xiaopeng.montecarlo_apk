package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsTserviceTeamDismissResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceTeamDismiss;
@IntfAuto(target = ICallBackWsTserviceTeamDismiss.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceTeamDismissImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceTeamDismissImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceTeamDismissImpl_change_ownership(ICallBackWsTserviceTeamDismissImpl iCallBackWsTserviceTeamDismissImpl, long j, boolean z);

    private static native void ICallBackWsTserviceTeamDismissImpl_director_connect(ICallBackWsTserviceTeamDismissImpl iCallBackWsTserviceTeamDismissImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceTeamDismissImpl iCallBackWsTserviceTeamDismissImpl, long j2, GWsTserviceTeamDismissResponseParam gWsTserviceTeamDismissResponseParam);

    public ICallBackWsTserviceTeamDismissImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceTeamDismissImpl) && getUID(this) == getUID((ICallBackWsTserviceTeamDismissImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceTeamDismissImpl iCallBackWsTserviceTeamDismissImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceTeamDismissImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceTeamDismissImpl iCallBackWsTserviceTeamDismissImpl) {
        if (iCallBackWsTserviceTeamDismissImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceTeamDismissImpl.swigCPtr;
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
        ICallBackWsTserviceTeamDismissImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceTeamDismissImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceTeamDismissResponseParam gWsTserviceTeamDismissResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceTeamDismissResponseParam);
    }

    public ICallBackWsTserviceTeamDismissImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceTeamDismissImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
