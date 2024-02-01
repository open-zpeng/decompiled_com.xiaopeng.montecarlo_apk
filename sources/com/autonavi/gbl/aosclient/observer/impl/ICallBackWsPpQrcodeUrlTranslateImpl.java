package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GWsPpQrcodeUrlTranslateResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpQrcodeUrlTranslate;
@IntfAuto(target = ICallBackWsPpQrcodeUrlTranslate.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsPpQrcodeUrlTranslateImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsPpQrcodeUrlTranslateImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsPpQrcodeUrlTranslateImpl_change_ownership(ICallBackWsPpQrcodeUrlTranslateImpl iCallBackWsPpQrcodeUrlTranslateImpl, long j, boolean z);

    private static native void ICallBackWsPpQrcodeUrlTranslateImpl_director_connect(ICallBackWsPpQrcodeUrlTranslateImpl iCallBackWsPpQrcodeUrlTranslateImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsPpQrcodeUrlTranslateImpl iCallBackWsPpQrcodeUrlTranslateImpl, long j2, GWsPpQrcodeUrlTranslateResponseParam gWsPpQrcodeUrlTranslateResponseParam);

    public ICallBackWsPpQrcodeUrlTranslateImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsPpQrcodeUrlTranslateImpl) && getUID(this) == getUID((ICallBackWsPpQrcodeUrlTranslateImpl) obj);
    }

    private static long getUID(ICallBackWsPpQrcodeUrlTranslateImpl iCallBackWsPpQrcodeUrlTranslateImpl) {
        long cPtr = getCPtr(iCallBackWsPpQrcodeUrlTranslateImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsPpQrcodeUrlTranslateImpl iCallBackWsPpQrcodeUrlTranslateImpl) {
        if (iCallBackWsPpQrcodeUrlTranslateImpl == null) {
            return 0L;
        }
        return iCallBackWsPpQrcodeUrlTranslateImpl.swigCPtr;
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
        ICallBackWsPpQrcodeUrlTranslateImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsPpQrcodeUrlTranslateImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsPpQrcodeUrlTranslateResponseParam gWsPpQrcodeUrlTranslateResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsPpQrcodeUrlTranslateResponseParam);
    }

    public ICallBackWsPpQrcodeUrlTranslateImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsPpQrcodeUrlTranslateImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
