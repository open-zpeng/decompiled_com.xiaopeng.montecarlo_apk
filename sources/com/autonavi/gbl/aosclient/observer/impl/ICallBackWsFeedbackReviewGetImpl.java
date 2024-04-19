package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsFeedbackReviewGetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsFeedbackReviewGet;
@IntfAuto(target = ICallBackWsFeedbackReviewGet.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsFeedbackReviewGetImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsFeedbackReviewGetImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsFeedbackReviewGetImpl_change_ownership(ICallBackWsFeedbackReviewGetImpl iCallBackWsFeedbackReviewGetImpl, long j, boolean z);

    private static native void ICallBackWsFeedbackReviewGetImpl_director_connect(ICallBackWsFeedbackReviewGetImpl iCallBackWsFeedbackReviewGetImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsFeedbackReviewGetImpl iCallBackWsFeedbackReviewGetImpl, long j2, GWsFeedbackReviewGetResponseParam gWsFeedbackReviewGetResponseParam);

    public ICallBackWsFeedbackReviewGetImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsFeedbackReviewGetImpl) && getUID(this) == getUID((ICallBackWsFeedbackReviewGetImpl) obj);
    }

    private static long getUID(ICallBackWsFeedbackReviewGetImpl iCallBackWsFeedbackReviewGetImpl) {
        long cPtr = getCPtr(iCallBackWsFeedbackReviewGetImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsFeedbackReviewGetImpl iCallBackWsFeedbackReviewGetImpl) {
        if (iCallBackWsFeedbackReviewGetImpl == null) {
            return 0L;
        }
        return iCallBackWsFeedbackReviewGetImpl.swigCPtr;
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
        ICallBackWsFeedbackReviewGetImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsFeedbackReviewGetImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsFeedbackReviewGetResponseParam gWsFeedbackReviewGetResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsFeedbackReviewGetResponseParam);
    }

    public ICallBackWsFeedbackReviewGetImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsFeedbackReviewGetImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
