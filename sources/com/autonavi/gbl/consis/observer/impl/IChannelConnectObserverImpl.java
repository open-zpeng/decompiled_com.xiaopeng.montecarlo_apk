package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ConnectMsgHead;
import com.autonavi.gbl.consis.observer.IChannelConnectObserver;
@IntfAuto(target = IChannelConnectObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IChannelConnectObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IChannelConnectObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IChannelConnectObserverImpl_change_ownership(IChannelConnectObserverImpl iChannelConnectObserverImpl, long j, boolean z);

    private static native void IChannelConnectObserverImpl_director_connect(IChannelConnectObserverImpl iChannelConnectObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onChannelConnectNative(long j, IChannelConnectObserverImpl iChannelConnectObserverImpl, long j2, ConnectMsgHead connectMsgHead, long j3, IChannelTransProxyImpl iChannelTransProxyImpl);

    private static native void onChannelDestroyNative(long j, IChannelConnectObserverImpl iChannelConnectObserverImpl, long j2, ConnectMsgHead connectMsgHead, long j3, IChannelTransProxyImpl iChannelTransProxyImpl);

    private static native void onCustomDataIncomeNative(long j, IChannelConnectObserverImpl iChannelConnectObserverImpl, long j2, ChannelParcelImpl channelParcelImpl, long j3, IChannelTransProxyImpl iChannelTransProxyImpl);

    public IChannelConnectObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChannelConnectObserverImpl) && getUID(this) == getUID((IChannelConnectObserverImpl) obj);
    }

    private static long getUID(IChannelConnectObserverImpl iChannelConnectObserverImpl) {
        long cPtr = getCPtr(iChannelConnectObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChannelConnectObserverImpl iChannelConnectObserverImpl) {
        if (iChannelConnectObserverImpl == null) {
            return 0L;
        }
        return iChannelConnectObserverImpl.swigCPtr;
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
        IChannelConnectObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IChannelConnectObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onCustomDataIncome(ChannelParcelImpl channelParcelImpl, IChannelTransProxyImpl iChannelTransProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onCustomDataIncomeNative(j, this, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl, IChannelTransProxyImpl.getCPtr(iChannelTransProxyImpl), iChannelTransProxyImpl);
    }

    public void onChannelConnect(ConnectMsgHead connectMsgHead, IChannelTransProxyImpl iChannelTransProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onChannelConnectNative(j, this, 0L, connectMsgHead, IChannelTransProxyImpl.getCPtr(iChannelTransProxyImpl), iChannelTransProxyImpl);
    }

    public void onChannelDestroy(ConnectMsgHead connectMsgHead, IChannelTransProxyImpl iChannelTransProxyImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onChannelDestroyNative(j, this, 0L, connectMsgHead, IChannelTransProxyImpl.getCPtr(iChannelTransProxyImpl), iChannelTransProxyImpl);
    }

    public IChannelConnectObserverImpl() {
        this(createNativeObj(), true);
        ConsisObserverJNI.swig_jni_init();
        IChannelConnectObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
