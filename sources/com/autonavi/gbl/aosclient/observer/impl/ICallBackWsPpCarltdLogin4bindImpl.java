package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdLogin4bindResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpCarltdLogin4bind;
@IntfAuto(target = ICallBackWsPpCarltdLogin4bind.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsPpCarltdLogin4bindImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsPpCarltdLogin4bindImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsPpCarltdLogin4bindImpl_change_ownership(ICallBackWsPpCarltdLogin4bindImpl iCallBackWsPpCarltdLogin4bindImpl, long j, boolean z);

    private static native void ICallBackWsPpCarltdLogin4bindImpl_director_connect(ICallBackWsPpCarltdLogin4bindImpl iCallBackWsPpCarltdLogin4bindImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsPpCarltdLogin4bindImpl iCallBackWsPpCarltdLogin4bindImpl, long j2, GWsPpCarltdLogin4bindResponseParam gWsPpCarltdLogin4bindResponseParam);

    public ICallBackWsPpCarltdLogin4bindImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsPpCarltdLogin4bindImpl) && getUID(this) == getUID((ICallBackWsPpCarltdLogin4bindImpl) obj);
    }

    private static long getUID(ICallBackWsPpCarltdLogin4bindImpl iCallBackWsPpCarltdLogin4bindImpl) {
        long cPtr = getCPtr(iCallBackWsPpCarltdLogin4bindImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsPpCarltdLogin4bindImpl iCallBackWsPpCarltdLogin4bindImpl) {
        if (iCallBackWsPpCarltdLogin4bindImpl == null) {
            return 0L;
        }
        return iCallBackWsPpCarltdLogin4bindImpl.swigCPtr;
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
        ICallBackWsPpCarltdLogin4bindImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsPpCarltdLogin4bindImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsPpCarltdLogin4bindResponseParam gWsPpCarltdLogin4bindResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsPpCarltdLogin4bindResponseParam);
    }

    public ICallBackWsPpCarltdLogin4bindImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsPpCarltdLogin4bindImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
