package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintSwitchResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsUserviewFootprintSwitch;
@IntfAuto(target = ICallBackWsUserviewFootprintSwitch.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsUserviewFootprintSwitchImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsUserviewFootprintSwitchImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsUserviewFootprintSwitchImpl_change_ownership(ICallBackWsUserviewFootprintSwitchImpl iCallBackWsUserviewFootprintSwitchImpl, long j, boolean z);

    private static native void ICallBackWsUserviewFootprintSwitchImpl_director_connect(ICallBackWsUserviewFootprintSwitchImpl iCallBackWsUserviewFootprintSwitchImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsUserviewFootprintSwitchImpl iCallBackWsUserviewFootprintSwitchImpl, long j2, GWsUserviewFootprintSwitchResponseParam gWsUserviewFootprintSwitchResponseParam);

    public ICallBackWsUserviewFootprintSwitchImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsUserviewFootprintSwitchImpl) && getUID(this) == getUID((ICallBackWsUserviewFootprintSwitchImpl) obj);
    }

    private static long getUID(ICallBackWsUserviewFootprintSwitchImpl iCallBackWsUserviewFootprintSwitchImpl) {
        long cPtr = getCPtr(iCallBackWsUserviewFootprintSwitchImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsUserviewFootprintSwitchImpl iCallBackWsUserviewFootprintSwitchImpl) {
        if (iCallBackWsUserviewFootprintSwitchImpl == null) {
            return 0L;
        }
        return iCallBackWsUserviewFootprintSwitchImpl.swigCPtr;
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
        ICallBackWsUserviewFootprintSwitchImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsUserviewFootprintSwitchImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsUserviewFootprintSwitchResponseParam gWsUserviewFootprintSwitchResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsUserviewFootprintSwitchResponseParam);
    }

    public ICallBackWsUserviewFootprintSwitchImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsUserviewFootprintSwitchImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
