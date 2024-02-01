package com.autonavi.gbl.aosclient.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherResponseParam;
import com.autonavi.gbl.aosclient.observer.ICallBackQueryPersentWeather;
@IntfAuto(target = ICallBackQueryPersentWeather.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ICallBackQueryPersentWeatherImpl {
    private static BindTable BIND_TABLE = new BindTable(ICallBackQueryPersentWeatherImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICallBackQueryPersentWeatherImpl_change_ownership(ICallBackQueryPersentWeatherImpl iCallBackQueryPersentWeatherImpl, long j, boolean z);

    private static native void ICallBackQueryPersentWeatherImpl_director_connect(ICallBackQueryPersentWeatherImpl iCallBackQueryPersentWeatherImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void onRecvAckNative(long j, ICallBackQueryPersentWeatherImpl iCallBackQueryPersentWeatherImpl, long j2, GQueryPersentWeatherResponseParam gQueryPersentWeatherResponseParam);

    public ICallBackQueryPersentWeatherImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICallBackQueryPersentWeatherImpl) && getUID(this) == getUID((ICallBackQueryPersentWeatherImpl) obj);
    }

    private static long getUID(ICallBackQueryPersentWeatherImpl iCallBackQueryPersentWeatherImpl) {
        long cPtr = getCPtr(iCallBackQueryPersentWeatherImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICallBackQueryPersentWeatherImpl iCallBackQueryPersentWeatherImpl) {
        if (iCallBackQueryPersentWeatherImpl == null) {
            return 0L;
        }
        return iCallBackQueryPersentWeatherImpl.swigCPtr;
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
        ICallBackQueryPersentWeatherImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICallBackQueryPersentWeatherImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void onRecvAck(GQueryPersentWeatherResponseParam gQueryPersentWeatherResponseParam) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onRecvAckNative(j, this, 0L, gQueryPersentWeatherResponseParam);
    }

    public ICallBackQueryPersentWeatherImpl() {
        this(createNativeObj(), true);
        AosObserverJNI.swig_jni_init();
        ICallBackQueryPersentWeatherImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
