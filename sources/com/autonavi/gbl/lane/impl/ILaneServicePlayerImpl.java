package com.autonavi.gbl.lane.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.lane.observer.impl.ILaneServicePlayerObserverImpl;
@IntfAuto(target = com.autonavi.gbl.lane.LaneServicePlayer.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ILaneServicePlayerImpl {
    private static BindTable BIND_TABLE = new BindTable(ILaneServicePlayerImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native boolean enableRepeatPlayNative(long j, ILaneServicePlayerImpl iLaneServicePlayerImpl, boolean z);

    private static native boolean enableServicePlayerInnerSetXNative(long j, ILaneServicePlayerImpl iLaneServicePlayerImpl, boolean z);

    private static native boolean enableUsePlayerResourceNative(long j, ILaneServicePlayerImpl iLaneServicePlayerImpl, boolean z);

    private static native boolean registerServicePlayerNative(long j, ILaneServicePlayerImpl iLaneServicePlayerImpl, long j2, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl);

    private static native boolean setPlayIndexNative(long j, ILaneServicePlayerImpl iLaneServicePlayerImpl, long j2);

    private static native boolean setPlaySpeedNative(long j, ILaneServicePlayerImpl iLaneServicePlayerImpl, float f);

    private static native boolean setPlayerPathNative(long j, ILaneServicePlayerImpl iLaneServicePlayerImpl, String str, int i);

    private static native boolean startPlayNative(long j, ILaneServicePlayerImpl iLaneServicePlayerImpl);

    private static native boolean stopPlayNative(long j, ILaneServicePlayerImpl iLaneServicePlayerImpl);

    private static native boolean unRegisterServicePlayerNative(long j, ILaneServicePlayerImpl iLaneServicePlayerImpl, long j2, ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl);

    public ILaneServicePlayerImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ILaneServicePlayerImpl) && getUID(this) == getUID((ILaneServicePlayerImpl) obj);
    }

    private static long getUID(ILaneServicePlayerImpl iLaneServicePlayerImpl) {
        long cPtr = getCPtr(iLaneServicePlayerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ILaneServicePlayerImpl iLaneServicePlayerImpl) {
        if (iLaneServicePlayerImpl == null) {
            return 0L;
        }
        return iLaneServicePlayerImpl.swigCPtr;
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

    public boolean setPlayerPath(String str, int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setPlayerPathNative(j, this, str, i);
    }

    public boolean enableServicePlayerInnerSetX(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return enableServicePlayerInnerSetXNative(j, this, z);
    }

    public boolean enableUsePlayerResource(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return enableUsePlayerResourceNative(j, this, z);
    }

    public boolean enableRepeatPlay(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return enableRepeatPlayNative(j, this, z);
    }

    public boolean setPlayIndex(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return setPlayIndexNative(j2, this, j);
    }

    public boolean setPlaySpeed(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setPlaySpeedNative(j, this, f);
    }

    public boolean registerServicePlayer(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return registerServicePlayerNative(j, this, ILaneServicePlayerObserverImpl.getCPtr(iLaneServicePlayerObserverImpl), iLaneServicePlayerObserverImpl);
    }

    public boolean unRegisterServicePlayer(ILaneServicePlayerObserverImpl iLaneServicePlayerObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return unRegisterServicePlayerNative(j, this, ILaneServicePlayerObserverImpl.getCPtr(iLaneServicePlayerObserverImpl), iLaneServicePlayerObserverImpl);
    }

    public boolean startPlay() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return startPlayNative(j, this);
    }

    public boolean stopPlay() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return stopPlayNative(j, this);
    }
}
