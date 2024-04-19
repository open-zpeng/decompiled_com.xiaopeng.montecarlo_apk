package com.autonavi.gbl.consis.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.consis.observer.IChannelMsgTransfer;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
@IntfAuto(target = IChannelMsgTransfer.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IChannelMsgTransferImpl {
    private static BindTable BIND_TABLE = new BindTable(IChannelMsgTransferImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IChannelMsgTransferImpl_change_ownership(IChannelMsgTransferImpl iChannelMsgTransferImpl, long j, boolean z);

    private static native void IChannelMsgTransferImpl_director_connect(IChannelMsgTransferImpl iChannelMsgTransferImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onPauseNaviNative(long j, IChannelMsgTransferImpl iChannelMsgTransferImpl, long j2, int i);

    private static native boolean onResumeNaviNative(long j, IChannelMsgTransferImpl iChannelMsgTransferImpl, long j2, int i);

    private static native void onSelectMainPathIDNative(long j, IChannelMsgTransferImpl iChannelMsgTransferImpl, long j2, int i);

    private static native boolean onSetNaviPathNative(long j, IChannelMsgTransferImpl iChannelMsgTransferImpl, long j2, NaviPathImpl naviPathImpl, long j3, int i);

    private static native boolean onStartNaviNative(long j, IChannelMsgTransferImpl iChannelMsgTransferImpl, long j2, int i, int i2);

    private static native boolean onStopNaviNative(long j, IChannelMsgTransferImpl iChannelMsgTransferImpl, long j2, int i);

    public IChannelMsgTransferImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChannelMsgTransferImpl) && getUID(this) == getUID((IChannelMsgTransferImpl) obj);
    }

    private static long getUID(IChannelMsgTransferImpl iChannelMsgTransferImpl) {
        long cPtr = getCPtr(iChannelMsgTransferImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChannelMsgTransferImpl iChannelMsgTransferImpl) {
        if (iChannelMsgTransferImpl == null) {
            return 0L;
        }
        return iChannelMsgTransferImpl.swigCPtr;
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
        IChannelMsgTransferImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IChannelMsgTransferImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean onStartNavi(long j, @NaviType.NaviType1 int i, int i2) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return onStartNaviNative(j2, this, j, i, i2);
    }

    public boolean onStopNavi(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return onStopNaviNative(j2, this, j, i);
    }

    public boolean onPauseNavi(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return onPauseNaviNative(j2, this, j, i);
    }

    public boolean onResumeNavi(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return onResumeNaviNative(j2, this, j, i);
    }

    public boolean onSetNaviPath(NaviPathImpl naviPathImpl, long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return onSetNaviPathNative(j2, this, NaviPathImpl.getCPtr(naviPathImpl), naviPathImpl, j, i);
    }

    public void onSelectMainPathID(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        onSelectMainPathIDNative(j2, this, j, i);
    }

    public IChannelMsgTransferImpl() {
        this(createNativeObj(), true);
        ConsisObserverJNI.swig_jni_init();
        IChannelMsgTransferImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
