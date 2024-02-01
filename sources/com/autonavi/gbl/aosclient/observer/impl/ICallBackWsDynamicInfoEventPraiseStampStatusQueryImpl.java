package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoEventPraiseStampStatusQueryResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDynamicInfoEventPraiseStampStatusQuery;
@IntfAuto(target = ICallBackWsDynamicInfoEventPraiseStampStatusQuery.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl_change_ownership(ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl, long j, boolean z);

    private static native void ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl_director_connect(ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl, long j2, GWsDynamicInfoEventPraiseStampStatusQueryResponseParam gWsDynamicInfoEventPraiseStampStatusQueryResponseParam);

    public ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl) && getUID(this) == getUID((ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl) obj);
    }

    private static long getUID(ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl) {
        long cPtr = getCPtr(iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl) {
        if (iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl == null) {
            return 0L;
        }
        return iCallBackWsDynamicInfoEventPraiseStampStatusQueryImpl.swigCPtr;
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
        ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsDynamicInfoEventPraiseStampStatusQueryResponseParam gWsDynamicInfoEventPraiseStampStatusQueryResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsDynamicInfoEventPraiseStampStatusQueryResponseParam);
    }

    public ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsDynamicInfoEventPraiseStampStatusQueryImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
