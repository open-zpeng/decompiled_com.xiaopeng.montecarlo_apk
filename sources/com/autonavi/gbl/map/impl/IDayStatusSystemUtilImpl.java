package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Coord2DDouble;
import com.autonavi.gbl.map.observer.IDayStatusSystemUtil;
import com.autonavi.gbl.util.model.DateTime;
@IntfAuto(target = IDayStatusSystemUtil.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class IDayStatusSystemUtilImpl {
    private static BindTable BIND_TABLE = new BindTable(IDayStatusSystemUtilImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void IDayStatusSystemUtilImpl_change_ownership(IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl, long j, boolean z);

    private static native void IDayStatusSystemUtilImpl_director_connect(IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean getDateTimeNative(long j, IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl, long j2, DateTime dateTime);

    private static native Coord2DDouble getLonLatNative(long j, IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl);

    public IDayStatusSystemUtilImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IDayStatusSystemUtilImpl) && getUID(this) == getUID((IDayStatusSystemUtilImpl) obj);
    }

    private static long getUID(IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl) {
        long cPtr = getCPtr(iDayStatusSystemUtilImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IDayStatusSystemUtilImpl iDayStatusSystemUtilImpl) {
        if (iDayStatusSystemUtilImpl == null) {
            return 0L;
        }
        return iDayStatusSystemUtilImpl.swigCPtr;
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
        IDayStatusSystemUtilImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        IDayStatusSystemUtilImpl_change_ownership(this, this.swigCPtr, true);
    }

    public Coord2DDouble getLonLat() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getLonLatNative(j, this);
    }

    public boolean getDateTime(DateTime dateTime) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getDateTimeNative(j, this, 0L, dateTime);
    }

    public IDayStatusSystemUtilImpl() {
        this(createNativeObj(), true);
        MapSvrJNI.swig_jni_init();
        IDayStatusSystemUtilImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
