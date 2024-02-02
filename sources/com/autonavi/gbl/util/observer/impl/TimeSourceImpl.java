package com.autonavi.gbl.util.observer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.util.observer.ITimeSource;
@IntfAuto(target = ITimeSource.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class TimeSourceImpl {
    private static BindTable BIND_TABLE = new BindTable(TimeSourceImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void TimeSourceImpl_change_ownership(TimeSourceImpl timeSourceImpl, long j, boolean z);

    private static native void TimeSourceImpl_director_connect(TimeSourceImpl timeSourceImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native long getLocalTimeUSNative(long j, TimeSourceImpl timeSourceImpl);

    private static native long getTickCountUSNative(long j, TimeSourceImpl timeSourceImpl);

    public TimeSourceImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof TimeSourceImpl) && getUID(this) == getUID((TimeSourceImpl) obj);
    }

    private static long getUID(TimeSourceImpl timeSourceImpl) {
        long cPtr = getCPtr(timeSourceImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(TimeSourceImpl timeSourceImpl) {
        if (timeSourceImpl == null) {
            return 0L;
        }
        return timeSourceImpl.swigCPtr;
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
        TimeSourceImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        TimeSourceImpl_change_ownership(this, this.swigCPtr, true);
    }

    public long getTickCountUS() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTickCountUSNative(j, this);
    }

    public long getLocalTimeUS() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLocalTimeUSNative(j, this);
    }

    public TimeSourceImpl() {
        this(createNativeObj(), true);
        UtilModelObserverJNI.swig_jni_init();
        TimeSourceImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
