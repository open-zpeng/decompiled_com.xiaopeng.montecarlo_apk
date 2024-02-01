package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsUserviewFootprintNaviRecordResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsUserviewFootprintNaviRecord;
@IntfAuto(target = ICallBackWsUserviewFootprintNaviRecord.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsUserviewFootprintNaviRecordImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsUserviewFootprintNaviRecordImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsUserviewFootprintNaviRecordImpl_change_ownership(ICallBackWsUserviewFootprintNaviRecordImpl iCallBackWsUserviewFootprintNaviRecordImpl, long j, boolean z);

    private static native void ICallBackWsUserviewFootprintNaviRecordImpl_director_connect(ICallBackWsUserviewFootprintNaviRecordImpl iCallBackWsUserviewFootprintNaviRecordImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsUserviewFootprintNaviRecordImpl iCallBackWsUserviewFootprintNaviRecordImpl, long j2, GWsUserviewFootprintNaviRecordResponseParam gWsUserviewFootprintNaviRecordResponseParam);

    public ICallBackWsUserviewFootprintNaviRecordImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsUserviewFootprintNaviRecordImpl) && getUID(this) == getUID((ICallBackWsUserviewFootprintNaviRecordImpl) obj);
    }

    private static long getUID(ICallBackWsUserviewFootprintNaviRecordImpl iCallBackWsUserviewFootprintNaviRecordImpl) {
        long cPtr = getCPtr(iCallBackWsUserviewFootprintNaviRecordImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsUserviewFootprintNaviRecordImpl iCallBackWsUserviewFootprintNaviRecordImpl) {
        if (iCallBackWsUserviewFootprintNaviRecordImpl == null) {
            return 0L;
        }
        return iCallBackWsUserviewFootprintNaviRecordImpl.swigCPtr;
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
        ICallBackWsUserviewFootprintNaviRecordImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsUserviewFootprintNaviRecordImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsUserviewFootprintNaviRecordResponseParam gWsUserviewFootprintNaviRecordResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsUserviewFootprintNaviRecordResponseParam);
    }

    public ICallBackWsUserviewFootprintNaviRecordImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsUserviewFootprintNaviRecordImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
