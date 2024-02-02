package com.autonavi.gbl.common.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.WorkPath;
@IntfAuto(target = WorkPath.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class WorkPathImpl {
    private static BindTable BIND_TABLE = new BindTable(WorkPathImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native String cacheGetNative(long j, WorkPathImpl workPathImpl);

    private static native void cacheSetNative(long j, WorkPathImpl workPathImpl, String str);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String naviGetNative(long j, WorkPathImpl workPathImpl);

    private static native void naviSetNative(long j, WorkPathImpl workPathImpl, String str);

    private static native String resGetNative(long j, WorkPathImpl workPathImpl);

    private static native void resSetNative(long j, WorkPathImpl workPathImpl, String str);

    public WorkPathImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof WorkPathImpl) && getUID(this) == getUID((WorkPathImpl) obj);
    }

    private static long getUID(WorkPathImpl workPathImpl) {
        long cPtr = getCPtr(workPathImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(WorkPathImpl workPathImpl) {
        if (workPathImpl == null) {
            return 0L;
        }
        return workPathImpl.swigCPtr;
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

    public void setNavi(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        naviSetNative(j, this, str);
    }

    public String getNavi() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return naviGetNative(j, this);
    }

    public void setRes(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resSetNative(j, this, str);
    }

    public String getRes() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return resGetNative(j, this);
    }

    public void setCache(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        cacheSetNative(j, this, str);
    }

    public String getCache() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return cacheGetNative(j, this);
    }

    public WorkPathImpl() {
        this(createNativeObj(), true);
    }
}
