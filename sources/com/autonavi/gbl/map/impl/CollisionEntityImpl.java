package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.CollisionType;
import com.autonavi.gbl.map.observer.ICollisionEntity;
@IntfAuto(target = ICollisionEntity.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CollisionEntityImpl extends MixtureSharedBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisionEntityImpl.class);
    private transient long swigCPtr;

    private static native long CollisionEntityImpl_SWIGUpcast(long j);

    private static native void CollisionEntityImpl_change_ownership(CollisionEntityImpl collisionEntityImpl, long j, boolean z);

    private static native void CollisionEntityImpl_director_connect(CollisionEntityImpl collisionEntityImpl, long j, boolean z, boolean z2);

    private static native void caculateCollisionNative(long j, CollisionEntityImpl collisionEntityImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void enableAreaCollisionNative(long j, CollisionEntityImpl collisionEntityImpl, boolean z);

    private static native void enableCollisionNative(long j, CollisionEntityImpl collisionEntityImpl, boolean z);

    private static native int getTypeNative(long j, CollisionEntityImpl collisionEntityImpl);

    private static native boolean isAreaCollisionNative(long j, CollisionEntityImpl collisionEntityImpl);

    private static native boolean isCollisionNative(long j, CollisionEntityImpl collisionEntityImpl);

    private static native void lockItemsNative(long j, CollisionEntityImpl collisionEntityImpl);

    private static native void resetNextPairNative(long j, CollisionEntityImpl collisionEntityImpl);

    private static native boolean testIntersectNative(long j, CollisionEntityImpl collisionEntityImpl, long j2, CollisionItemImpl collisionItemImpl);

    private static native void unLockItemsNative(long j, CollisionEntityImpl collisionEntityImpl);

    public CollisionEntityImpl(long j, boolean z) {
        super(CollisionEntityImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CollisionEntityImpl) {
            return getUID(this) == getUID((CollisionEntityImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CollisionEntityImpl collisionEntityImpl) {
        long cPtr = getCPtr(collisionEntityImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CollisionEntityImpl collisionEntityImpl) {
        if (collisionEntityImpl == null) {
            return 0L;
        }
        return collisionEntityImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        CollisionEntityImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CollisionEntityImpl_change_ownership(this, this.swigCPtr, true);
    }

    public CollisionEntityImpl() {
        this(createNativeObj(), true);
        MapSvrJNI.swig_jni_init();
        CollisionEntityImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void resetNextPair() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetNextPairNative(j, this);
    }

    public boolean testIntersect(CollisionItemImpl collisionItemImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return testIntersectNative(j, this, CollisionItemImpl.getCPtr(collisionItemImpl), collisionItemImpl);
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

    public void enableCollision(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableCollisionNative(j, this, z);
    }

    public boolean isCollision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isCollisionNative(j, this);
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
}
