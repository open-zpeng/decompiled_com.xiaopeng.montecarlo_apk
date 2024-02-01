package com.autonavi.gbl.aosclient.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.aosclient.BLAosDataTool;
@IntfAuto(target = BLAosDataTool.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class BLAosDataToolImpl {
    private static BindTable BIND_TABLE = new BindTable(BLAosDataToolImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getSessionidNative(String str);

    public BLAosDataToolImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BLAosDataToolImpl) && getUID(this) == getUID((BLAosDataToolImpl) obj);
    }

    private static long getUID(BLAosDataToolImpl bLAosDataToolImpl) {
        long cPtr = getCPtr(bLAosDataToolImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BLAosDataToolImpl bLAosDataToolImpl) {
        if (bLAosDataToolImpl == null) {
            return 0L;
        }
        return bLAosDataToolImpl.swigCPtr;
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

    public BLAosDataToolImpl() {
        this(createNativeObj(), true);
    }

    public static String getSessionid(String str) {
        return getSessionidNative(str);
    }
}
