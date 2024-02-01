package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.CruiseCongestionExtend;
@IntfAuto(target = CruiseCongestionExtend.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CruiseCongestionExtendImpl {
    private static BindTable BIND_TABLE = new BindTable(CruiseCongestionExtendImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getStringNative(long j, CruiseCongestionExtendImpl cruiseCongestionExtendImpl);

    private static native boolean isEmptyNative(long j, CruiseCongestionExtendImpl cruiseCongestionExtendImpl);

    private static native String mExtendGetNative(long j, CruiseCongestionExtendImpl cruiseCongestionExtendImpl);

    private static native void mExtendSetNative(long j, CruiseCongestionExtendImpl cruiseCongestionExtendImpl, String str);

    private static native boolean parseNative(long j, CruiseCongestionExtendImpl cruiseCongestionExtendImpl, String str);

    public CruiseCongestionExtendImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof CruiseCongestionExtendImpl) && getUID(this) == getUID((CruiseCongestionExtendImpl) obj);
    }

    private static long getUID(CruiseCongestionExtendImpl cruiseCongestionExtendImpl) {
        long cPtr = getCPtr(cruiseCongestionExtendImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CruiseCongestionExtendImpl cruiseCongestionExtendImpl) {
        if (cruiseCongestionExtendImpl == null) {
            return 0L;
        }
        return cruiseCongestionExtendImpl.swigCPtr;
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

    public CruiseCongestionExtendImpl() {
        this(createNativeObj(), true);
    }

    public boolean parse(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return parseNative(j, this, str);
    }

    public boolean isEmpty() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isEmptyNative(j, this);
    }

    public String getString() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getStringNative(j, this);
    }

    public void setMExtend(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mExtendSetNative(j, this, str);
    }

    public String getMExtend() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mExtendGetNative(j, this);
    }
}
