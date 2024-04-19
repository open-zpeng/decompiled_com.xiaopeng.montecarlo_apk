package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.consis.observer.ChannelTransProxy;
@IntfAuto(target = ChannelTransProxy.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IChannelTransProxyImpl {
    private static BindTable BIND_TABLE = new BindTable(IChannelTransProxyImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IChannelTransProxyImpl_change_ownership(IChannelTransProxyImpl iChannelTransProxyImpl, long j, boolean z);

    private static native void IChannelTransProxyImpl_director_connect(IChannelTransProxyImpl iChannelTransProxyImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native long writeDataNative(long j, IChannelTransProxyImpl iChannelTransProxyImpl, long j2, long j3);

    public IChannelTransProxyImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChannelTransProxyImpl) && getUID(this) == getUID((IChannelTransProxyImpl) obj);
    }

    private static long getUID(IChannelTransProxyImpl iChannelTransProxyImpl) {
        long cPtr = getCPtr(iChannelTransProxyImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChannelTransProxyImpl iChannelTransProxyImpl) {
        if (iChannelTransProxyImpl == null) {
            return 0L;
        }
        return iChannelTransProxyImpl.swigCPtr;
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
        IChannelTransProxyImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IChannelTransProxyImpl_change_ownership(this, this.swigCPtr, true);
    }

    public long writeData(long j, long j2) {
        return $explicit_writeData(j, j2);
    }

    public long $explicit_writeData(long j, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        return writeDataNative(j3, this, j, j2);
    }

    public IChannelTransProxyImpl() {
        this(createNativeObj(), true);
        ConsisObserverJNI.swig_jni_init();
        IChannelTransProxyImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
