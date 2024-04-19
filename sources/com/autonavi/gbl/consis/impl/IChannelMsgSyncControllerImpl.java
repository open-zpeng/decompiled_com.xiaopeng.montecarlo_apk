package com.autonavi.gbl.consis.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.consis.ChannelMsgSyncController;
import com.autonavi.gbl.guide.model.NaviType;
import com.autonavi.gbl.guide.model.impl.NaviPathImpl;
@IntfAuto(target = ChannelMsgSyncController.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IChannelMsgSyncControllerImpl {
    private static BindTable BIND_TABLE = new BindTable(IChannelMsgSyncControllerImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native boolean pauseNaviNative(long j, IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl, long j2, int i);

    private static native boolean resumeNaviNative(long j, IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl, long j2, int i);

    private static native void selectMainPathIDNative(long j, IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl, long j2, int i);

    private static native boolean setNaviPathNative(long j, IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl, long j2, NaviPathImpl naviPathImpl, long j3, int i);

    private static native boolean startNaviNative(long j, IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl, long j2, int i, int i2);

    private static native boolean stopNaviNative(long j, IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl, long j2, int i);

    public IChannelMsgSyncControllerImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IChannelMsgSyncControllerImpl) && getUID(this) == getUID((IChannelMsgSyncControllerImpl) obj);
    }

    private static long getUID(IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl) {
        long cPtr = getCPtr(iChannelMsgSyncControllerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IChannelMsgSyncControllerImpl iChannelMsgSyncControllerImpl) {
        if (iChannelMsgSyncControllerImpl == null) {
            return 0L;
        }
        return iChannelMsgSyncControllerImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    protected synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean startNavi(long j, @NaviType.NaviType1 int i, int i2) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return startNaviNative(j2, this, j, i, i2);
    }

    public boolean stopNavi(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return stopNaviNative(j2, this, j, i);
    }

    public boolean pauseNavi(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return pauseNaviNative(j2, this, j, i);
    }

    public boolean resumeNavi(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return resumeNaviNative(j2, this, j, i);
    }

    public boolean setNaviPath(NaviPathImpl naviPathImpl, long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return setNaviPathNative(j2, this, NaviPathImpl.getCPtr(naviPathImpl), naviPathImpl, j, i);
    }

    public void selectMainPathID(long j, int i) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        selectMainPathIDNative(j2, this, j, i);
    }
}
