package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionEntity;
@IntfAuto(target = ICollisionEntity.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ICollisionEntityImpl {
    private static BindTable BIND_TABLE = new BindTable(ICollisionEntityImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void ICollisionEntityImpl_change_ownership(ICollisionEntityImpl iCollisionEntityImpl, long j, boolean z);

    private static native void ICollisionEntityImpl_director_connect(ICollisionEntityImpl iCollisionEntityImpl, long j, boolean z, boolean z2);

    private static native void caculateCollisionNative(long j, ICollisionEntityImpl iCollisionEntityImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void enableAreaCollisionNative(long j, ICollisionEntityImpl iCollisionEntityImpl, boolean z);

    private static native int getTypeNative(long j, ICollisionEntityImpl iCollisionEntityImpl);

    private static native boolean isAreaCollisionNative(long j, ICollisionEntityImpl iCollisionEntityImpl);

    private static native void lockItemsNative(long j, ICollisionEntityImpl iCollisionEntityImpl);

    private static native void resetNextPairNative(long j, ICollisionEntityImpl iCollisionEntityImpl);

    private static native boolean testIntersectNative(long j, ICollisionEntityImpl iCollisionEntityImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native void unLockItemsNative(long j, ICollisionEntityImpl iCollisionEntityImpl);

    public ICollisionEntityImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ICollisionEntityImpl) && getUID(this) == getUID((ICollisionEntityImpl) obj);
    }

    private static long getUID(ICollisionEntityImpl iCollisionEntityImpl) {
        long cPtr = getCPtr(iCollisionEntityImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ICollisionEntityImpl iCollisionEntityImpl) {
        if (iCollisionEntityImpl == null) {
            return 0L;
        }
        return iCollisionEntityImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        ICollisionEntityImpl_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ICollisionEntityImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void resetNextPair() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetNextPairNative(j, this);
    }

    public boolean testIntersect(ICollisionItemImpl iCollisionItemImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return testIntersectNative(j, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl);
    }

    @CollisionType.CollisionType1
    public int getType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getTypeNative(j, this);
    }

    public void enableAreaCollision(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableAreaCollisionNative(j, this, z);
    }

    public boolean isAreaCollision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isAreaCollisionNative(j, this);
    }

    public void lockItems() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lockItemsNative(j, this);
    }

    public void unLockItems() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        unLockItemsNative(j, this);
    }

    public void caculateCollision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        caculateCollisionNative(j, this);
    }

    public ICollisionEntityImpl() {
        this(createNativeObj(), true);
        MapSvrJNI.swig_jni_init();
        ICollisionEntityImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
