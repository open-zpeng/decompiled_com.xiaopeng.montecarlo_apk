package com.autonavi.gbl.user.usertrack.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.user.usertrack.model.GpsTrackPoint;
import com.autonavi.gbl.user.usertrack.observer.IGpsInfoGetter;
@IntfAuto(target = IGpsInfoGetter.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IGpsInfoGetterImpl {
    private static BindTable BIND_TABLE = new BindTable(IGpsInfoGetterImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IGpsInfoGetterImpl_change_ownership(IGpsInfoGetterImpl iGpsInfoGetterImpl, long j, boolean z);

    private static native void IGpsInfoGetterImpl_director_connect(IGpsInfoGetterImpl iGpsInfoGetterImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native GpsTrackPoint getGpsTrackPointNative(long j, IGpsInfoGetterImpl iGpsInfoGetterImpl);

    public IGpsInfoGetterImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IGpsInfoGetterImpl) && getUID(this) == getUID((IGpsInfoGetterImpl) obj);
    }

    private static long getUID(IGpsInfoGetterImpl iGpsInfoGetterImpl) {
        long cPtr = getCPtr(iGpsInfoGetterImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IGpsInfoGetterImpl iGpsInfoGetterImpl) {
        if (iGpsInfoGetterImpl == null) {
            return 0L;
        }
        return iGpsInfoGetterImpl.swigCPtr;
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
        IGpsInfoGetterImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IGpsInfoGetterImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GpsTrackPoint getGpsTrackPoint() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getGpsTrackPointNative(j, this);
    }

    public IGpsInfoGetterImpl() {
        this(createNativeObj(), true);
        UsertrackObserverJNI.swig_jni_init();
        IGpsInfoGetterImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
