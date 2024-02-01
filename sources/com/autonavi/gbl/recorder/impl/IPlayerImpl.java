package com.autonavi.gbl.recorder.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.recorder.Player;
import com.autonavi.gbl.recorder.model.PlayParam;
import com.autonavi.gbl.recorder.observer.impl.IPlayerObserverImpl;
@IntfAuto(target = Player.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IPlayerImpl {
    private static BindTable BIND_TABLE = new BindTable(IPlayerImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native int addObserverNative(long j, IPlayerImpl iPlayerImpl, long j2, IPlayerObserverImpl iPlayerObserverImpl);

    private static native void destroyNativeObj(long j);

    private static native int getParamNative(long j, IPlayerImpl iPlayerImpl, long j2, PlayParam playParam);

    private static native int pauseNative(long j, IPlayerImpl iPlayerImpl);

    private static native int removeObserverNative(long j, IPlayerImpl iPlayerImpl, long j2, IPlayerObserverImpl iPlayerObserverImpl);

    private static native int resumeNative(long j, IPlayerImpl iPlayerImpl);

    private static native int seekToNative(long j, IPlayerImpl iPlayerImpl, long j2);

    private static native int setParamNative(long j, IPlayerImpl iPlayerImpl, long j2, PlayParam playParam);

    private static native int setPlaySpeedNative(long j, IPlayerImpl iPlayerImpl, float f);

    private static native int startNative(long j, IPlayerImpl iPlayerImpl);

    private static native int stopNative(long j, IPlayerImpl iPlayerImpl);

    public IPlayerImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IPlayerImpl) && getUID(this) == getUID((IPlayerImpl) obj);
    }

    private static long getUID(IPlayerImpl iPlayerImpl) {
        long cPtr = getCPtr(iPlayerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IPlayerImpl iPlayerImpl) {
        if (iPlayerImpl == null) {
            return 0L;
        }
        return iPlayerImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public int seekTo(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        return seekToNative(j2, this, j);
    }

    public int setPlaySpeed(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setPlaySpeedNative(j, this, f);
    }

    public int setParam(PlayParam playParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return setParamNative(j, this, 0L, playParam);
    }

    public PlayParam getParam() {
        PlayParam playParam = new PlayParam();
        if (Integer.valueOf(getParam(playParam)).intValue() == 0) {
            return playParam;
        }
        return null;
    }

    private int getParam(PlayParam playParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getParamNative(j, this, 0L, playParam);
    }

    public int addObserver(IPlayerObserverImpl iPlayerObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addObserverNative(j, this, IPlayerObserverImpl.getCPtr(iPlayerObserverImpl), iPlayerObserverImpl);
    }

    public int removeObserver(IPlayerObserverImpl iPlayerObserverImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeObserverNative(j, this, IPlayerObserverImpl.getCPtr(iPlayerObserverImpl), iPlayerObserverImpl);
    }

    public int start() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return startNative(j, this);
    }

    public int stop() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return stopNative(j, this);
    }

    public int pause() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return pauseNative(j, this);
    }

    public int resume() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return resumeNative(j, this);
    }
}
