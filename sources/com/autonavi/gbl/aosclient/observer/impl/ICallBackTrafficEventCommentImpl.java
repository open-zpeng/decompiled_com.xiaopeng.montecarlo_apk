package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GTrafficEventCommentResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackTrafficEventComment;
@IntfAuto(target = ICallBackTrafficEventComment.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackTrafficEventCommentImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackTrafficEventCommentImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackTrafficEventCommentImpl_change_ownership(ICallBackTrafficEventCommentImpl iCallBackTrafficEventCommentImpl, long j, boolean z);

    private static native void ICallBackTrafficEventCommentImpl_director_connect(ICallBackTrafficEventCommentImpl iCallBackTrafficEventCommentImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackTrafficEventCommentImpl iCallBackTrafficEventCommentImpl, long j2, GTrafficEventCommentResponseParam gTrafficEventCommentResponseParam);

    public ICallBackTrafficEventCommentImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackTrafficEventCommentImpl) && getUID(this) == getUID((ICallBackTrafficEventCommentImpl) obj);
    }

    private static long getUID(ICallBackTrafficEventCommentImpl iCallBackTrafficEventCommentImpl) {
        long cPtr = getCPtr(iCallBackTrafficEventCommentImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackTrafficEventCommentImpl iCallBackTrafficEventCommentImpl) {
        if (iCallBackTrafficEventCommentImpl == null) {
            return 0L;
        }
        return iCallBackTrafficEventCommentImpl.swigCPtr;
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
        ICallBackTrafficEventCommentImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackTrafficEventCommentImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GTrafficEventCommentResponseParam gTrafficEventCommentResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gTrafficEventCommentResponseParam);
    }

    public ICallBackTrafficEventCommentImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackTrafficEventCommentImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
