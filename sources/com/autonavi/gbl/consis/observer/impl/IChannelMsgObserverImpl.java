package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ChannelMsgHead;
import com.autonavi.gbl.consis.observer.IChannelMsgObserver;
@IntfAuto(target = IChannelMsgObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IChannelMsgObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IChannelMsgObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IChannelMsgObserverImpl_change_ownership(IChannelMsgObserverImpl iChannelMsgObserverImpl, long j, boolean z);

    private static native void IChannelMsgObserverImpl_director_connect(IChannelMsgObserverImpl iChannelMsgObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int onNotifyMsgNative(long j, IChannelMsgObserverImpl iChannelMsgObserverImpl, long j2, ChannelMsgHead channelMsgHead, long j3, ChannelParcelImpl channelParcelImpl);

    public IChannelMsgObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChannelMsgObserverImpl) && getUID(this) == getUID((IChannelMsgObserverImpl) obj);
    }

    private static long getUID(IChannelMsgObserverImpl iChannelMsgObserverImpl) {
        long cPtr = getCPtr(iChannelMsgObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChannelMsgObserverImpl iChannelMsgObserverImpl) {
        if (iChannelMsgObserverImpl == null) {
            return 0L;
        }
        return iChannelMsgObserverImpl.swigCPtr;
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
        IChannelMsgObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IChannelMsgObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public int onNotifyMsg(ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onNotifyMsgNative(j, this, 0L, channelMsgHead, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }

    public IChannelMsgObserverImpl() {
        this(createNativeObj(), true);
        ConsisObserverJNI.swig_jni_init();
        IChannelMsgObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
