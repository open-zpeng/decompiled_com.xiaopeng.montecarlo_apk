package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Coord3DDouble;
import com.autonavi.gbl.layer.BizClickLabelInfo;
@IntfAuto(target = BizClickLabelInfo.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class BizClickLabelInfoImpl {
    private static BindTable BIND_TABLE = new BindTable(BizClickLabelInfoImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native boolean isVaildNative(long j, BizClickLabelInfoImpl bizClickLabelInfoImpl);

    private static native int mainkeyGetNative(long j, BizClickLabelInfoImpl bizClickLabelInfoImpl);

    private static native void mainkeySetNative(long j, BizClickLabelInfoImpl bizClickLabelInfoImpl, int i);

    private static native String nameGetNative(long j, BizClickLabelInfoImpl bizClickLabelInfoImpl);

    private static native void nameSetNative(long j, BizClickLabelInfoImpl bizClickLabelInfoImpl, String str);

    private static native Coord3DDouble positionGetNative(long j, BizClickLabelInfoImpl bizClickLabelInfoImpl);

    private static native void positionSetNative(long j, BizClickLabelInfoImpl bizClickLabelInfoImpl, long j2, Coord3DDouble coord3DDouble);

    private static native void resetNative(long j, BizClickLabelInfoImpl bizClickLabelInfoImpl);

    private static native int subkeyGetNative(long j, BizClickLabelInfoImpl bizClickLabelInfoImpl);

    private static native void subkeySetNative(long j, BizClickLabelInfoImpl bizClickLabelInfoImpl, int i);

    public BizClickLabelInfoImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BizClickLabelInfoImpl) && getUID(this) == getUID((BizClickLabelInfoImpl) obj);
    }

    private static long getUID(BizClickLabelInfoImpl bizClickLabelInfoImpl) {
        long cPtr = getCPtr(bizClickLabelInfoImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(BizClickLabelInfoImpl bizClickLabelInfoImpl) {
        if (bizClickLabelInfoImpl == null) {
            return 0L;
        }
        return bizClickLabelInfoImpl.swigCPtr;
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

    public BizClickLabelInfoImpl() {
        this(createNativeObj(), true);
    }

    public void reset() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetNative(j, this);
    }

    public boolean isVaild() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isVaildNative(j, this);
    }

    public void setPosition(Coord3DDouble coord3DDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        positionSetNative(j, this, 0L, coord3DDouble);
    }

    public Coord3DDouble getPosition() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return positionGetNative(j, this);
    }

    public void setName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        nameSetNative(j, this, str);
    }

    public String getName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return nameGetNative(j, this);
    }

    public void setMainkey(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mainkeySetNative(j, this, i);
    }

    public int getMainkey() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mainkeyGetNative(j, this);
    }

    public void setSubkey(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        subkeySetNative(j, this, i);
    }

    public int getSubkey() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return subkeyGetNative(j, this);
    }
}
