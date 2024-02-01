package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.observer.ChannelProxyAdapter;
@IntfAuto(target = ChannelProxyAdapter.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IChannelProxyAdapterImpl {
    private static BindTable BIND_TABLE = new BindTable(IChannelProxyAdapterImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IChannelProxyAdapterImpl_change_ownership(IChannelProxyAdapterImpl iChannelProxyAdapterImpl, long j, boolean z);

    private static native void IChannelProxyAdapterImpl_director_connect(IChannelProxyAdapterImpl iChannelProxyAdapterImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native long writeDataNative(long j, IChannelProxyAdapterImpl iChannelProxyAdapterImpl, byte[] bArr);

    public IChannelProxyAdapterImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChannelProxyAdapterImpl) && getUID(this) == getUID((IChannelProxyAdapterImpl) obj);
    }

    private static long getUID(IChannelProxyAdapterImpl iChannelProxyAdapterImpl) {
        long cPtr = getCPtr(iChannelProxyAdapterImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChannelProxyAdapterImpl iChannelProxyAdapterImpl) {
        if (iChannelProxyAdapterImpl == null) {
            return 0L;
        }
        return iChannelProxyAdapterImpl.swigCPtr;
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
        IChannelProxyAdapterImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IChannelProxyAdapterImpl_change_ownership(this, this.swigCPtr, true);
    }

    public long writeData(byte[] bArr) {
        return $explicit_writeData(bArr);
    }

    public long $explicit_writeData(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return writeDataNative(j, this, bArr);
    }

    public IChannelProxyAdapterImpl() {
        this(createNativeObj(), true);
        ConsisObserverJNI.swig_jni_init();
        IChannelProxyAdapterImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
