package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTcKoubeiOrderSubmitResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTcKoubeiOrderSubmit;
@IntfAuto(target = ICallBackWsTcKoubeiOrderSubmit.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTcKoubeiOrderSubmitImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTcKoubeiOrderSubmitImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTcKoubeiOrderSubmitImpl_change_ownership(ICallBackWsTcKoubeiOrderSubmitImpl iCallBackWsTcKoubeiOrderSubmitImpl, long j, boolean z);

    private static native void ICallBackWsTcKoubeiOrderSubmitImpl_director_connect(ICallBackWsTcKoubeiOrderSubmitImpl iCallBackWsTcKoubeiOrderSubmitImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTcKoubeiOrderSubmitImpl iCallBackWsTcKoubeiOrderSubmitImpl, long j2, GWsTcKoubeiOrderSubmitResponseParam gWsTcKoubeiOrderSubmitResponseParam);

    public ICallBackWsTcKoubeiOrderSubmitImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTcKoubeiOrderSubmitImpl) && getUID(this) == getUID((ICallBackWsTcKoubeiOrderSubmitImpl) obj);
    }

    private static long getUID(ICallBackWsTcKoubeiOrderSubmitImpl iCallBackWsTcKoubeiOrderSubmitImpl) {
        long cPtr = getCPtr(iCallBackWsTcKoubeiOrderSubmitImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTcKoubeiOrderSubmitImpl iCallBackWsTcKoubeiOrderSubmitImpl) {
        if (iCallBackWsTcKoubeiOrderSubmitImpl == null) {
            return 0L;
        }
        return iCallBackWsTcKoubeiOrderSubmitImpl.swigCPtr;
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
        ICallBackWsTcKoubeiOrderSubmitImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTcKoubeiOrderSubmitImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ICallBackWsTcKoubeiOrderSubmitImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTcKoubeiOrderSubmitImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void onRecvAck(GWsTcKoubeiOrderSubmitResponseParam gWsTcKoubeiOrderSubmitResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTcKoubeiOrderSubmitResponseParam);
    }
}
