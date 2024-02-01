package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.OperatorCollision;
@IntfAuto(target = OperatorCollision.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IOperatorCollisionImpl {
    private static BindTable BIND_TABLE = new BindTable(IOperatorCollisionImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean addEntityNative(long j, IOperatorCollisionImpl iOperatorCollisionImpl, long j2, CollisionEntityImpl collisionEntityImpl);

    private static native void calculateNative(long j, IOperatorCollisionImpl iOperatorCollisionImpl);

    private static native void destroyNativeObj(long j);

    private static native void initCalculateNative(long j, IOperatorCollisionImpl iOperatorCollisionImpl);

    private static native boolean removeEntityNative(long j, IOperatorCollisionImpl iOperatorCollisionImpl, long j2, CollisionEntityImpl collisionEntityImpl);

    public IOperatorCollisionImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IOperatorCollisionImpl) && getUID(this) == getUID((IOperatorCollisionImpl) obj);
    }

    private static long getUID(IOperatorCollisionImpl iOperatorCollisionImpl) {
        long cPtr = getCPtr(iOperatorCollisionImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IOperatorCollisionImpl iOperatorCollisionImpl) {
        if (iOperatorCollisionImpl == null) {
            return 0L;
        }
        return iOperatorCollisionImpl.swigCPtr;
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

    public boolean addEntity(CollisionEntityImpl collisionEntityImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addEntityNative(j, this, CollisionEntityImpl.getCPtr(collisionEntityImpl), collisionEntityImpl);
    }

    public boolean removeEntity(CollisionEntityImpl collisionEntityImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return removeEntityNative(j, this, CollisionEntityImpl.getCPtr(collisionEntityImpl), collisionEntityImpl);
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
