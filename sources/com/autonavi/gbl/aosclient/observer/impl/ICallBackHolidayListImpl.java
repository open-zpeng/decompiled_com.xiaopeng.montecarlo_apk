package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GHolidayListResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackHolidayList;
@IntfAuto(target = ICallBackHolidayList.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackHolidayListImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackHolidayListImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackHolidayListImpl_change_ownership(ICallBackHolidayListImpl iCallBackHolidayListImpl, long j, boolean z);

    private static native void ICallBackHolidayListImpl_director_connect(ICallBackHolidayListImpl iCallBackHolidayListImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackHolidayListImpl iCallBackHolidayListImpl, long j2, GHolidayListResponseParam gHolidayListResponseParam);

    public ICallBackHolidayListImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackHolidayListImpl) && getUID(this) == getUID((ICallBackHolidayListImpl) obj);
    }

    private static long getUID(ICallBackHolidayListImpl iCallBackHolidayListImpl) {
        long cPtr = getCPtr(iCallBackHolidayListImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackHolidayListImpl iCallBackHolidayListImpl) {
        if (iCallBackHolidayListImpl == null) {
            return 0L;
        }
        return iCallBackHolidayListImpl.swigCPtr;
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
        ICallBackHolidayListImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackHolidayListImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GHolidayListResponseParam gHolidayListResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gHolidayListResponseParam);
    }

    public ICallBackHolidayListImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackHolidayListImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
