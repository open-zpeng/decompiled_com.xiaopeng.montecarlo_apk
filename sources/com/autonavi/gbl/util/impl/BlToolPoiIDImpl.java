package com.autonavi.gbl.util.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.util.BlToolPoiID;
@IntfAuto(target = BlToolPoiID.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class BlToolPoiIDImpl {
    private static BindTable BIND_TABLE = new BindTable(BlToolPoiIDImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String poiIDToEventID1Native(String str);

    private static native String poiIDToEventIDNative(String str, long j);

    public BlToolPoiIDImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BlToolPoiIDImpl) && getUID(this) == getUID((BlToolPoiIDImpl) obj);
    }

    private static long getUID(BlToolPoiIDImpl blToolPoiIDImpl) {
        long cPtr = getCPtr(blToolPoiIDImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BlToolPoiIDImpl blToolPoiIDImpl) {
        if (blToolPoiIDImpl == null) {
            return 0L;
        }
        return blToolPoiIDImpl.swigCPtr;
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

    public BlToolPoiIDImpl() {
        this(createNativeObj(), true);
    }

    public static String poiIDToEventID(String str, long j) {
        return poiIDToEventIDNative(str, j);
    }

    public static String poiIDToEventID(String str) {
        return poiIDToEventID1Native(str);
    }
}
