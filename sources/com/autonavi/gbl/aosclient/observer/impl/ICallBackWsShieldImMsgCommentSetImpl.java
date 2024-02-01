package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsShieldImMsgCommentSetResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsShieldImMsgCommentSet;
@IntfAuto(target = ICallBackWsShieldImMsgCommentSet.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsShieldImMsgCommentSetImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsShieldImMsgCommentSetImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsShieldImMsgCommentSetImpl_change_ownership(ICallBackWsShieldImMsgCommentSetImpl iCallBackWsShieldImMsgCommentSetImpl, long j, boolean z);

    private static native void ICallBackWsShieldImMsgCommentSetImpl_director_connect(ICallBackWsShieldImMsgCommentSetImpl iCallBackWsShieldImMsgCommentSetImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsShieldImMsgCommentSetImpl iCallBackWsShieldImMsgCommentSetImpl, long j2, GWsShieldImMsgCommentSetResponseParam gWsShieldImMsgCommentSetResponseParam);

    public ICallBackWsShieldImMsgCommentSetImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsShieldImMsgCommentSetImpl) && getUID(this) == getUID((ICallBackWsShieldImMsgCommentSetImpl) obj);
    }

    private static long getUID(ICallBackWsShieldImMsgCommentSetImpl iCallBackWsShieldImMsgCommentSetImpl) {
        long cPtr = getCPtr(iCallBackWsShieldImMsgCommentSetImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsShieldImMsgCommentSetImpl iCallBackWsShieldImMsgCommentSetImpl) {
        if (iCallBackWsShieldImMsgCommentSetImpl == null) {
            return 0L;
        }
        return iCallBackWsShieldImMsgCommentSetImpl.swigCPtr;
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
        ICallBackWsShieldImMsgCommentSetImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsShieldImMsgCommentSetImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsShieldImMsgCommentSetResponseParam gWsShieldImMsgCommentSetResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsShieldImMsgCommentSetResponseParam);
    }

    public ICallBackWsShieldImMsgCommentSetImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsShieldImMsgCommentSetImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
