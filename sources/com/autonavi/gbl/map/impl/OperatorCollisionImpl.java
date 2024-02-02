package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.OperatorCollision;
@IntfAuto(target = OperatorCollision.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class OperatorCollisionImpl {
    private static BindTable BIND_TABLE = new BindTable(OperatorCollisionImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addEntityNative(long j, OperatorCollisionImpl operatorCollisionImpl, long j2, ICollisionEntityImpl iCollisionEntityImpl);

    private static native void calculateNative(long j, OperatorCollisionImpl operatorCollisionImpl);

    private static native void destroyNativeObj(long j);

    private static native void initCalculateNative(long j, OperatorCollisionImpl operatorCollisionImpl);

    private static native boolean removeEntityNative(long j, OperatorCollisionImpl operatorCollisionImpl, long j2, ICollisionEntityImpl iCollisionEntityImpl);

    public OperatorCollisionImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof OperatorCollisionImpl) && getUID(this) == getUID((OperatorCollisionImpl) obj);
    }

    private static long getUID(OperatorCollisionImpl operatorCollisionImpl) {
        long cPtr = getCPtr(operatorCollisionImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(OperatorCollisionImpl operatorCollisionImpl) {
        if (operatorCollisionImpl == null) {
            return 0L;
        }
        return operatorCollisionImpl.swigCPtr;
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

    public boolean addEntity(ICollisionEntityImpl iCollisionEntityImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addEntityNative(j, this, ICollisionEntityImpl.getCPtr(iCollisionEntityImpl), iCollisionEntityImpl);
    }

    public boolean removeEntity(ICollisionEntityImpl iCollisionEntityImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeEntityNative(j, this, ICollisionEntityImpl.getCPtr(iCollisionEntityImpl), iCollisionEntityImpl);
    }

    public void initCalculate() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        initCalculateNative(j, this);
    }

    public void calculate() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        calculateNative(j, this);
    }
}
