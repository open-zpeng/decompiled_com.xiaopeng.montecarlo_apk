package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.model.PixelPoint;
import com.autonavi.gbl.map.observer.ICollisionItem;
import java.util.ArrayList;
@IntfAuto(target = ICollisionItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CollisionItemImpl extends MixtureSharedBaseImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisionItemImpl.class);
    private transient long swigCPtr;

    private static native long CollisionItemImpl_SWIGUpcast(long j);

    private static native void CollisionItemImpl_change_ownership(CollisionItemImpl collisionItemImpl, long j, boolean z);

    private static native void CollisionItemImpl_director_connect(CollisionItemImpl collisionItemImpl, long j, boolean z, boolean z2);

    private static native void applyOnVisibleNative(long j, CollisionItemImpl collisionItemImpl);

    private static native boolean canAreaCollisionNative(long j, CollisionItemImpl collisionItemImpl);

    private static native boolean canCollisionNative(long j, CollisionItemImpl collisionItemImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native ArrayList<PixelPoint> getBoundNative(long j, CollisionItemImpl collisionItemImpl);

    private static native boolean getOnVisibleNative(long j, CollisionItemImpl collisionItemImpl);

    private static native int getPriorityNative(long j, CollisionItemImpl collisionItemImpl);

    private static native boolean getVisibleNative(long j, CollisionItemImpl collisionItemImpl);

    private static native boolean isAreaCollisionNative(long j, CollisionItemImpl collisionItemImpl);

    private static native void onVisibleNative(long j, CollisionItemImpl collisionItemImpl, boolean z);

    private static native void resetOnVisibleNative(long j, CollisionItemImpl collisionItemImpl, boolean z);

    private static native void setAreaCollisionNative(long j, CollisionItemImpl collisionItemImpl, boolean z);

    public CollisionItemImpl(long j, boolean z) {
        super(CollisionItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CollisionItemImpl) {
            return getUID(this) == getUID((CollisionItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CollisionItemImpl collisionItemImpl) {
        long cPtr = getCPtr(collisionItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CollisionItemImpl collisionItemImpl) {
        if (collisionItemImpl == null) {
            return 0L;
        }
        return collisionItemImpl.swigCPtr;
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
        CollisionItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CollisionItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public CollisionItemImpl() {
        this(createNativeObj(), true);
        MapSvrJNI.swig_jni_init();
        CollisionItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void resetOnVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        resetOnVisibleNative(j, this, z);
    }

    public void onVisible(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        onVisibleNative(j, this, z);
    }

    public boolean getOnVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getOnVisibleNative(j, this);
    }

    public void applyOnVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        applyOnVisibleNative(j, this);
    }

    public ArrayList<PixelPoint> getBound() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getBoundNative(j, this);
    }

    public boolean getVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getVisibleNative(j, this);
    }

    public int getPriority() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getPriorityNative(j, this);
    }

    public boolean isAreaCollision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isAreaCollisionNative(j, this);
    }

    public void setAreaCollision(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAreaCollisionNative(j, this, z);
    }

    public boolean canCollision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return canCollisionNative(j, this);
    }

    public boolean canAreaCollision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return canAreaCollisionNative(j, this);
    }
}
