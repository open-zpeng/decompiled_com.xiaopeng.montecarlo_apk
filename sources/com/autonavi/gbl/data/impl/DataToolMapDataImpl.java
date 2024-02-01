package com.autonavi.gbl.data.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.data.DataToolMapData;
@IntfAuto(target = DataToolMapData.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class DataToolMapDataImpl {
    private static BindTable BIND_TABLE = new BindTable(DataToolMapDataImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void cityDataShiftNative(String str, String str2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    public DataToolMapDataImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DataToolMapDataImpl) && getUID(this) == getUID((DataToolMapDataImpl) obj);
    }

    private static long getUID(DataToolMapDataImpl dataToolMapDataImpl) {
        long cPtr = getCPtr(dataToolMapDataImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(DataToolMapDataImpl dataToolMapDataImpl) {
        if (dataToolMapDataImpl == null) {
            return 0L;
        }
        return dataToolMapDataImpl.swigCPtr;
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

    public static void cityDataShift(String str, String str2) {
        cityDataShiftNative(str, str2);
    }

    public DataToolMapDataImpl() {
        this(createNativeObj(), true);
    }
}
