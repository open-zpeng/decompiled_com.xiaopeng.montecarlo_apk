package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.OperatorWeather;
import com.autonavi.gbl.map.model.TextBuffer;
import com.autonavi.gbl.map.model.WEATHER_TYPE;
@IntfAuto(target = OperatorWeather.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IOperatorWeatherImpl {
    private static BindTable BIND_TABLE = new BindTable(IOperatorWeatherImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void destroyNativeObj(long j);

    private static native int getAnimationStateNative(long j, IOperatorWeatherImpl iOperatorWeatherImpl);

    private static native void startWeatherEffectNative(long j, IOperatorWeatherImpl iOperatorWeatherImpl, int i, long j2, TextBuffer textBuffer, long j3);

    private static native void stopWeatherEffectNative(long j, IOperatorWeatherImpl iOperatorWeatherImpl, boolean z);

    public IOperatorWeatherImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IOperatorWeatherImpl) && getUID(this) == getUID((IOperatorWeatherImpl) obj);
    }

    private static long getUID(IOperatorWeatherImpl iOperatorWeatherImpl) {
        long cPtr = getCPtr(iOperatorWeatherImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IOperatorWeatherImpl iOperatorWeatherImpl) {
        if (iOperatorWeatherImpl == null) {
            return 0L;
        }
        return iOperatorWeatherImpl.swigCPtr;
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

    public void startWeatherEffect(@WEATHER_TYPE.WEATHER_TYPE1 int i, TextBuffer textBuffer, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        startWeatherEffectNative(j2, this, i, 0L, textBuffer, j);
    }

    public void stopWeatherEffect(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        stopWeatherEffectNative(j, this, z);
    }

    public int getAnimationState() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAnimationStateNative(j, this);
    }
}
