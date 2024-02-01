package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoCongestionGroupChatUserRemoveResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDynamicInfoCongestionGroupChatUserRemove;
@IntfAuto(target = ICallBackWsDynamicInfoCongestionGroupChatUserRemove.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl_change_ownership(ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl, long j, boolean z);

    private static native void ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl_director_connect(ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl, long j2, GWsDynamicInfoCongestionGroupChatUserRemoveResponseParam gWsDynamicInfoCongestionGroupChatUserRemoveResponseParam);

    public ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl) && getUID(this) == getUID((ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl) obj);
    }

    private static long getUID(ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl) {
        long cPtr = getCPtr(iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl) {
        if (iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl == null) {
            return 0L;
        }
        return iCallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl.swigCPtr;
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
        ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsDynamicInfoCongestionGroupChatUserRemoveResponseParam gWsDynamicInfoCongestionGroupChatUserRemoveResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsDynamicInfoCongestionGroupChatUserRemoveResponseParam);
    }

    public ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsDynamicInfoCongestionGroupChatUserRemoveImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
