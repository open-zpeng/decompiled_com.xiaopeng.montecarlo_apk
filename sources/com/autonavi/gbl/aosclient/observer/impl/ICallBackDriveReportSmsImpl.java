package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GDriveReportSmsResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackDriveReportSms;
@IntfAuto(target = ICallBackDriveReportSms.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackDriveReportSmsImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackDriveReportSmsImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackDriveReportSmsImpl_change_ownership(ICallBackDriveReportSmsImpl iCallBackDriveReportSmsImpl, long j, boolean z);

    private static native void ICallBackDriveReportSmsImpl_director_connect(ICallBackDriveReportSmsImpl iCallBackDriveReportSmsImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackDriveReportSmsImpl iCallBackDriveReportSmsImpl, long j2, GDriveReportSmsResponseParam gDriveReportSmsResponseParam);

    public ICallBackDriveReportSmsImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackDriveReportSmsImpl) && getUID(this) == getUID((ICallBackDriveReportSmsImpl) obj);
    }

    private static long getUID(ICallBackDriveReportSmsImpl iCallBackDriveReportSmsImpl) {
        long cPtr = getCPtr(iCallBackDriveReportSmsImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackDriveReportSmsImpl iCallBackDriveReportSmsImpl) {
        if (iCallBackDriveReportSmsImpl == null) {
            return 0L;
        }
        return iCallBackDriveReportSmsImpl.swigCPtr;
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
        ICallBackDriveReportSmsImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackDriveReportSmsImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GDriveReportSmsResponseParam gDriveReportSmsResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gDriveReportSmsResponseParam);
    }

    public ICallBackDriveReportSmsImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackDriveReportSmsImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
