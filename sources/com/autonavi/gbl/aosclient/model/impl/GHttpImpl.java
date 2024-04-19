package com.autonavi.gbl.aosclient.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.EGHTTPCLIENTSTATUS;
import com.autonavi.gbl.aosclient.model.ENETWORKSTATUS;
import com.autonavi.gbl.aosclient.model.GHttp;
@IntfAuto(target = GHttp.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class GHttpImpl {
    private static BindTable BIND_TABLE = new BindTable(GHttpImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean checkCanDeleteNative(int i);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native short[] getStringNative(int i);

    private static native String getStringUtf8Native(int i);

    public GHttpImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof GHttpImpl) && getUID(this) == getUID((GHttpImpl) obj);
    }

    private static long getUID(GHttpImpl gHttpImpl) {
        long cPtr = getCPtr(gHttpImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GHttpImpl gHttpImpl) {
        if (gHttpImpl == null) {
            return 0L;
        }
        return gHttpImpl.swigCPtr;
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

    public GHttpImpl() {
        this(createNativeObj(), true);
    }

    public static short[] getString(@EGHTTPCLIENTSTATUS.EGHTTPCLIENTSTATUS1 int i) {
        return getStringNative(i);
    }

    public static String getStringUtf8(@ENETWORKSTATUS.ENETWORKSTATUS1 int i) {
        return getStringUtf8Native(i);
    }

    public static boolean checkCanDelete(@EGHTTPCLIENTSTATUS.EGHTTPCLIENTSTATUS1 int i) {
        return checkCanDeleteNative(i);
    }
}
