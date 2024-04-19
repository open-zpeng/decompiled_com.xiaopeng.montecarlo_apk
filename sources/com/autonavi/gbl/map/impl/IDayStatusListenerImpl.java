package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.DAY_STATUS;
import com.autonavi.gbl.map.observer.IDayStatusListener;
@IntfAuto(target = IDayStatusListener.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IDayStatusListenerImpl {
    private static BindTable BIND_TABLE = new BindTable(IDayStatusListenerImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDayStatusListenerImpl_change_ownership(IDayStatusListenerImpl iDayStatusListenerImpl, long j, boolean z);

    private static native void IDayStatusListenerImpl_director_connect(IDayStatusListenerImpl iDayStatusListenerImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean onDayStatusNative(long j, IDayStatusListenerImpl iDayStatusListenerImpl, int i);

    public IDayStatusListenerImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDayStatusListenerImpl) && getUID(this) == getUID((IDayStatusListenerImpl) obj);
    }

    private static long getUID(IDayStatusListenerImpl iDayStatusListenerImpl) {
        long cPtr = getCPtr(iDayStatusListenerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDayStatusListenerImpl iDayStatusListenerImpl) {
        if (iDayStatusListenerImpl == null) {
            return 0L;
        }
        return iDayStatusListenerImpl.swigCPtr;
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
        IDayStatusListenerImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDayStatusListenerImpl_change_ownership(this, this.swigCPtr, true);
    }

    public boolean onDayStatus(@DAY_STATUS.DAY_STATUS1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return onDayStatusNative(j, this, i);
    }

    public IDayStatusListenerImpl() {
        this(createNativeObj(), true);
        MapSvrJNI.swig_jni_init();
        IDayStatusListenerImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
