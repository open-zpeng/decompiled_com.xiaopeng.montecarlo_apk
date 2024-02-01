package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.observer.IChannelProxyObserver;
@IntfAuto(target = IChannelProxyObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IChannelProxyObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IChannelProxyObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IChannelProxyObserverImpl_change_ownership(IChannelProxyObserverImpl iChannelProxyObserverImpl, long j, boolean z);

    private static native void IChannelProxyObserverImpl_director_connect(IChannelProxyObserverImpl iChannelProxyObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onChannelProxyConnectNative(long j, IChannelProxyObserverImpl iChannelProxyObserverImpl, String str);

    private static native void onChannelProxyDisconnectNative(long j, IChannelProxyObserverImpl iChannelProxyObserverImpl, String str);

    public IChannelProxyObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChannelProxyObserverImpl) && getUID(this) == getUID((IChannelProxyObserverImpl) obj);
    }

    private static long getUID(IChannelProxyObserverImpl iChannelProxyObserverImpl) {
        long cPtr = getCPtr(iChannelProxyObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChannelProxyObserverImpl iChannelProxyObserverImpl) {
        if (iChannelProxyObserverImpl == null) {
            return 0L;
        }
        return iChannelProxyObserverImpl.swigCPtr;
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
        IChannelProxyObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IChannelProxyObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onChannelProxyConnect(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onChannelProxyConnectNative(j, this, str);
    }

    public void onChannelProxyDisconnect(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onChannelProxyDisconnectNative(j, this, str);
    }

    public IChannelProxyObserverImpl() {
        this(createNativeObj(), true);
        ConsisObserverJNI.swig_jni_init();
        IChannelProxyObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
