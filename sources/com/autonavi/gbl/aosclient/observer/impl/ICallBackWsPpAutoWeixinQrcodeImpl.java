package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.GWsPpAutoWeixinQrcodeResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpAutoWeixinQrcode;
@IntfAuto(target = ICallBackWsPpAutoWeixinQrcode.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackWsPpAutoWeixinQrcodeImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackWsPpAutoWeixinQrcodeImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackWsPpAutoWeixinQrcodeImpl_change_ownership(ICallBackWsPpAutoWeixinQrcodeImpl iCallBackWsPpAutoWeixinQrcodeImpl, long j, boolean z);

    private static native void ICallBackWsPpAutoWeixinQrcodeImpl_director_connect(ICallBackWsPpAutoWeixinQrcodeImpl iCallBackWsPpAutoWeixinQrcodeImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackWsPpAutoWeixinQrcodeImpl iCallBackWsPpAutoWeixinQrcodeImpl, long j2, GWsPpAutoWeixinQrcodeResponseParam gWsPpAutoWeixinQrcodeResponseParam);

    public ICallBackWsPpAutoWeixinQrcodeImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackWsPpAutoWeixinQrcodeImpl) && getUID(this) == getUID((ICallBackWsPpAutoWeixinQrcodeImpl) obj);
    }

    private static long getUID(ICallBackWsPpAutoWeixinQrcodeImpl iCallBackWsPpAutoWeixinQrcodeImpl) {
        long cPtr = getCPtr(iCallBackWsPpAutoWeixinQrcodeImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackWsPpAutoWeixinQrcodeImpl iCallBackWsPpAutoWeixinQrcodeImpl) {
        if (iCallBackWsPpAutoWeixinQrcodeImpl == null) {
            return 0L;
        }
        return iCallBackWsPpAutoWeixinQrcodeImpl.swigCPtr;
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
        ICallBackWsPpAutoWeixinQrcodeImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackWsPpAutoWeixinQrcodeImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GWsPpAutoWeixinQrcodeResponseParam gWsPpAutoWeixinQrcodeResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gWsPpAutoWeixinQrcodeResponseParam);
    }

    public ICallBackWsPpAutoWeixinQrcodeImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackWsPpAutoWeixinQrcodeImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
