package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ChannelMsgHead;
import com.autonavi.gbl.consis.observer.IChannelMessageObserver;
@IntfAuto(target = IChannelMessageObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IChannelMessageObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IChannelMessageObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IChannelMessageObserverImpl_change_ownership(IChannelMessageObserverImpl iChannelMessageObserverImpl, long j, boolean z);

    private static native void IChannelMessageObserverImpl_director_connect(IChannelMessageObserverImpl iChannelMessageObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onNotifyMsgNative(long j, IChannelMessageObserverImpl iChannelMessageObserverImpl, long j2, ChannelMsgHead channelMsgHead, long j3, ChannelParcelImpl channelParcelImpl);

    public IChannelMessageObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChannelMessageObserverImpl) && getUID(this) == getUID((IChannelMessageObserverImpl) obj);
    }

    private static long getUID(IChannelMessageObserverImpl iChannelMessageObserverImpl) {
        long cPtr = getCPtr(iChannelMessageObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChannelMessageObserverImpl iChannelMessageObserverImpl) {
        if (iChannelMessageObserverImpl == null) {
            return 0L;
        }
        return iChannelMessageObserverImpl.swigCPtr;
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
        IChannelMessageObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IChannelMessageObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onNotifyMsg(ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onNotifyMsgNative(j, this, 0L, channelMsgHead, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }

    public IChannelMessageObserverImpl() {
        this(createNativeObj(), true);
        ConsisObserverJNI.swig_jni_init();
        IChannelMessageObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
