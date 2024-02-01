package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsDynamicInfoCongestionGroupChatUserAddV3;
@IntfAuto(target = ICallBackWsDynamicInfoCongestionGroupChatUserAddV3.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl_change_ownership(ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl, long j, boolean z);

    private static native void ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl_director_connect(ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl, long j2, GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam gWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam);

    public ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl) && getUID(this) == getUID((ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl) obj);
    }

    private static long getUID(ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl) {
        long cPtr = getCPtr(iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl) {
        if (iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl == null) {
            return 0L;
        }
        return iCallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl.swigCPtr;
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
        ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam gWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsDynamicInfoCongestionGroupChatUserAddV3ResponseParam);
    }

    public ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsDynamicInfoCongestionGroupChatUserAddV3Impl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
