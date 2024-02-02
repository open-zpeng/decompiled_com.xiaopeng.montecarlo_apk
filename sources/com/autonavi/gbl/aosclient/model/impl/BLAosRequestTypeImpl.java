package com.autonavi.gbl.aosclient.model.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.aosclient.model.BLAosRequestType;
import com.autonavi.gbl.aosclient.model.EGAOSREQUESTTYPE;
import com.autonavi.gbl.aosclient.model.EGAOSSERVER;
@IntfAuto(target = BLAosRequestType.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class BLAosRequestTypeImpl {
    private static BindTable BIND_TABLE = new BindTable(BLAosRequestTypeImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int getServerByReqTypeNative(int i);

    private static native String getString8Native(int i);

    private static native short[] getStringNative(int i);

    public BLAosRequestTypeImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BLAosRequestTypeImpl) && getUID(this) == getUID((BLAosRequestTypeImpl) obj);
    }

    private static long getUID(BLAosRequestTypeImpl bLAosRequestTypeImpl) {
        long cPtr = getCPtr(bLAosRequestTypeImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BLAosRequestTypeImpl bLAosRequestTypeImpl) {
        if (bLAosRequestTypeImpl == null) {
            return 0L;
        }
        return bLAosRequestTypeImpl.swigCPtr;
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

    public BLAosRequestTypeImpl() {
        this(createNativeObj(), true);
    }

    public static short[] getString(@EGAOSREQUESTTYPE.EGAOSREQUESTTYPE1 int i) {
        return getStringNative(i);
    }

    public static String getString8(@EGAOSREQUESTTYPE.EGAOSREQUESTTYPE1 int i) {
        return getString8Native(i);
    }

    @EGAOSSERVER.EGAOSSERVER1
    public static int getServerByReqType(@EGAOSREQUESTTYPE.EGAOSREQUESTTYPE1 int i) {
        return getServerByReqTypeNative(i);
    }
}
