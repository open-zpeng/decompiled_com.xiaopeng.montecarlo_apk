package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsTserviceInternalLinkCarReportResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsTserviceInternalLinkCarReport;
@IntfAuto(target = ICallBackWsTserviceInternalLinkCarReport.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsTserviceInternalLinkCarReportImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsTserviceInternalLinkCarReportImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsTserviceInternalLinkCarReportImpl_change_ownership(ICallBackWsTserviceInternalLinkCarReportImpl iCallBackWsTserviceInternalLinkCarReportImpl, long j, boolean z);

    private static native void ICallBackWsTserviceInternalLinkCarReportImpl_director_connect(ICallBackWsTserviceInternalLinkCarReportImpl iCallBackWsTserviceInternalLinkCarReportImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsTserviceInternalLinkCarReportImpl iCallBackWsTserviceInternalLinkCarReportImpl, long j2, GWsTserviceInternalLinkCarReportResponseParam gWsTserviceInternalLinkCarReportResponseParam);

    public ICallBackWsTserviceInternalLinkCarReportImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsTserviceInternalLinkCarReportImpl) && getUID(this) == getUID((ICallBackWsTserviceInternalLinkCarReportImpl) obj);
    }

    private static long getUID(ICallBackWsTserviceInternalLinkCarReportImpl iCallBackWsTserviceInternalLinkCarReportImpl) {
        long cPtr = getCPtr(iCallBackWsTserviceInternalLinkCarReportImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsTserviceInternalLinkCarReportImpl iCallBackWsTserviceInternalLinkCarReportImpl) {
        if (iCallBackWsTserviceInternalLinkCarReportImpl == null) {
            return 0L;
        }
        return iCallBackWsTserviceInternalLinkCarReportImpl.swigCPtr;
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
        ICallBackWsTserviceInternalLinkCarReportImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsTserviceInternalLinkCarReportImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsTserviceInternalLinkCarReportResponseParam gWsTserviceInternalLinkCarReportResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsTserviceInternalLinkCarReportResponseParam);
    }

    public ICallBackWsTserviceInternalLinkCarReportImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsTserviceInternalLinkCarReportImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
