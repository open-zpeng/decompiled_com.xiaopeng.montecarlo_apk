package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.consis.impl.ChannelParcelImpl;
import com.autonavi.gbl.consis.model.ChannelMsgHead;
import com.autonavi.gbl.consis.observer.IConsisObserver;
@IntfAuto(target = IConsisObserver.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IConsisObserverImpl {
    private static BindTable BIND_TABLE = new BindTable(IConsisObserverImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IConsisObserverImpl_change_ownership(IConsisObserverImpl iConsisObserverImpl, long j, boolean z);

    private static native void IConsisObserverImpl_director_connect(IConsisObserverImpl iConsisObserverImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onReceiveMessageNative(long j, IConsisObserverImpl iConsisObserverImpl, long j2, ChannelMsgHead channelMsgHead, long j3, ChannelParcelImpl channelParcelImpl);

    private static native void onSendMessageNative(long j, IConsisObserverImpl iConsisObserverImpl, long j2, ChannelMsgHead channelMsgHead, long j3, ChannelParcelImpl channelParcelImpl);

    public IConsisObserverImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IConsisObserverImpl) && getUID(this) == getUID((IConsisObserverImpl) obj);
    }

    private static long getUID(IConsisObserverImpl iConsisObserverImpl) {
        long cPtr = getCPtr(iConsisObserverImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IConsisObserverImpl iConsisObserverImpl) {
        if (iConsisObserverImpl == null) {
            return 0L;
        }
        return iConsisObserverImpl.swigCPtr;
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
        IConsisObserverImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IConsisObserverImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onSendMessage(ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onSendMessageNative(j, this, 0L, channelMsgHead, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }

    public void onReceiveMessage(ChannelMsgHead channelMsgHead, ChannelParcelImpl channelParcelImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onReceiveMessageNative(j, this, 0L, channelMsgHead, ChannelParcelImpl.getCPtr(channelParcelImpl), channelParcelImpl);
    }

    public IConsisObserverImpl() {
        this(createNativeObj(), true);
        ConsisObserverJNI.swig_jni_init();
        IConsisObserverImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
