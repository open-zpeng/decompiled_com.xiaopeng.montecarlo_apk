package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.CollisionGroup;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.model.CollisionType;
import java.util.ArrayList;
@IntfAuto(target = CollisionGroup.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CollisionGroupImpl extends ICollisionEntityImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisionGroupImpl.class);
    private transient long swigCPtr;

    private static native long CollisionGroupImpl_SWIGUpcast(long j);

    private static native void CollisionGroupImpl_change_ownership(CollisionGroupImpl collisionGroupImpl, long j, boolean z);

    private static native void CollisionGroupImpl_director_connect(CollisionGroupImpl collisionGroupImpl, long j, boolean z, boolean z2);

    private static native boolean addCollisionItemNative(long j, CollisionGroupImpl collisionGroupImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native boolean addCollisionItemSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native void applyItemsOnVisibleNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void applyItemsOnVisibleSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void caculateCollisionNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void caculateCollisionSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void clearAllCollisionItemsNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void clearAllCollisionItemsSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void enableAreaCollisionNative(long j, CollisionGroupImpl collisionGroupImpl, boolean z);

    private static native void enableAreaCollisionSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl, boolean z);

    private static native long[] getCollisionItemsNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native long[] getCollisionItemsSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native float getIntersectAreaThresholdNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native float getIntersectAreaThresholdSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void getPriorityNative(long j, CollisionGroupImpl collisionGroupImpl, long j2, LayerPriority layerPriority);

    private static native void getPrioritySwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl, long j2, LayerPriority layerPriority);

    private static native int getTypeNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native int getTypeSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native boolean hasAppliedItemsOnVisibleNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native boolean hasAppliedItemsOnVisibleSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void intersectUINative(long j, CollisionGroupImpl collisionGroupImpl, ArrayList<RectDouble> arrayList);

    private static native void intersectUISwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl, ArrayList<RectDouble> arrayList);

    private static native boolean isAreaCollisionNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native boolean isAreaCollisionSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void lockItemsNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void lockItemsSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native boolean removeCollisionItemNative(long j, CollisionGroupImpl collisionGroupImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native boolean removeCollisionItemSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native void resetNextPairNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void resetNextPairSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void setApplyItemsOnVisibleNative(long j, CollisionGroupImpl collisionGroupImpl, boolean z);

    private static native void setApplyItemsOnVisibleSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl, boolean z);

    private static native void setIntersectAreaThresholdNative(long j, CollisionGroupImpl collisionGroupImpl, float f);

    private static native void setIntersectAreaThresholdSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl, float f);

    private static native boolean testIntersectNative(long j, CollisionGroupImpl collisionGroupImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native boolean testIntersectSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native void unLockItemsNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void unLockItemsSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void updateQuadrantItemsNative(long j, CollisionGroupImpl collisionGroupImpl);

    private static native void updateQuadrantItemsSwigExplicitCollisionGroupImplNative(long j, CollisionGroupImpl collisionGroupImpl);

    public CollisionGroupImpl(long j, boolean z) {
        super(CollisionGroupImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean equals(Object obj) {
        if (obj instanceof CollisionGroupImpl) {
            return getUID(this) == getUID((CollisionGroupImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CollisionGroupImpl collisionGroupImpl) {
        long cPtr = getCPtr(collisionGroupImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CollisionGroupImpl collisionGroupImpl) {
        if (collisionGroupImpl == null) {
            return 0L;
        }
        return collisionGroupImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public synchronized void delete() {
        LogUtils.d(String.format("swigCPtr=%%s, swigCMemOwn=%%s", String.valueOf(this.swigCPtr), String.valueOf(this.swigCMemOwn)));
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        CollisionGroupImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CollisionGroupImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LayerPriority getPriority() {
        return $explicit_getPriority();
    }

    public LayerPriority $explicit_getPriority() {
        LayerPriority layerPriority = new LayerPriority();
        getPriority(layerPriority);
        return layerPriority;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void resetNextPair() {
        $explicit_resetNextPair();
    }

    public void $explicit_resetNextPair() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            resetNextPairNative(this.swigCPtr, this);
        } else {
            resetNextPairSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
    }

    public void intersectUI(ArrayList<RectDouble> arrayList) {
        $explicit_intersectUI(arrayList);
    }

    public void $explicit_intersectUI(ArrayList<RectDouble> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            intersectUINative(this.swigCPtr, this, arrayList);
        } else {
            intersectUISwigExplicitCollisionGroupImplNative(this.swigCPtr, this, arrayList);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean testIntersect(ICollisionItemImpl iCollisionItemImpl) {
        return $explicit_testIntersect(iCollisionItemImpl);
    }

    public boolean $explicit_testIntersect(ICollisionItemImpl iCollisionItemImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionGroupImpl.class ? testIntersectNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl) : testIntersectSwigExplicitCollisionGroupImplNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    @CollisionType.CollisionType1
    public int getType() {
        return $explicit_getType();
    }

    @CollisionType.CollisionType1
    public int $explicit_getType() {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionGroupImpl.class ? getTypeNative(this.swigCPtr, this) : getTypeSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean addCollisionItem(ICollisionItemImpl iCollisionItemImpl) {
        return $explicit_addCollisionItem(iCollisionItemImpl);
    }

    public boolean $explicit_addCollisionItem(ICollisionItemImpl iCollisionItemImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionGroupImpl.class ? addCollisionItemNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl) : addCollisionItemSwigExplicitCollisionGroupImplNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl);
        }
        throw new NullPointerException();
    }

    public boolean removeCollisionItem(ICollisionItemImpl iCollisionItemImpl) {
        return $explicit_removeCollisionItem(iCollisionItemImpl);
    }

    public boolean $explicit_removeCollisionItem(ICollisionItemImpl iCollisionItemImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionGroupImpl.class ? removeCollisionItemNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl) : removeCollisionItemSwigExplicitCollisionGroupImplNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl);
        }
        throw new NullPointerException();
    }

    public void clearAllCollisionItems() {
        $explicit_clearAllCollisionItems();
    }

    public void $explicit_clearAllCollisionItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            clearAllCollisionItemsNative(this.swigCPtr, this);
        } else {
            clearAllCollisionItemsSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void lockItems() {
        $explicit_lockItems();
    }

    public void $explicit_lockItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            lockItemsNative(this.swigCPtr, this);
        } else {
            lockItemsSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void unLockItems() {
        $explicit_unLockItems();
    }

    public void $explicit_unLockItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            unLockItemsNative(this.swigCPtr, this);
        } else {
            unLockItemsSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void caculateCollision() {
        $explicit_caculateCollision();
    }

    public void $explicit_caculateCollision() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            caculateCollisionNative(this.swigCPtr, this);
        } else {
            caculateCollisionSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
    }

    public ArrayList<ICollisionItemImpl> getCollisionItems() {
        return $explicit_getCollisionItems();
    }

    public ArrayList<ICollisionItemImpl> $explicit_getCollisionItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        long[] collisionItemsNative = getClass() == CollisionGroupImpl.class ? getCollisionItemsNative(this.swigCPtr, this) : getCollisionItemsSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        if (collisionItemsNative != null) {
            ArrayList<ICollisionItemImpl> arrayList = new ArrayList<>();
            for (long j : collisionItemsNative) {
                arrayList.add(new ICollisionItemImpl(j, false));
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void enableAreaCollision(boolean z) {
        $explicit_enableAreaCollision(z);
    }

    public void $explicit_enableAreaCollision(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            enableAreaCollisionNative(this.swigCPtr, this, z);
        } else {
            enableAreaCollisionSwigExplicitCollisionGroupImplNative(this.swigCPtr, this, z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean isAreaCollision() {
        return $explicit_isAreaCollision();
    }

    public boolean $explicit_isAreaCollision() {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionGroupImpl.class ? isAreaCollisionNative(this.swigCPtr, this) : isAreaCollisionSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setIntersectAreaThreshold(float f) {
        $explicit_setIntersectAreaThreshold(f);
    }

    public void $explicit_setIntersectAreaThreshold(float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            setIntersectAreaThresholdNative(this.swigCPtr, this, f);
        } else {
            setIntersectAreaThresholdSwigExplicitCollisionGroupImplNative(this.swigCPtr, this, f);
        }
    }

    public float getIntersectAreaThreshold() {
        return $explicit_getIntersectAreaThreshold();
    }

    public float $explicit_getIntersectAreaThreshold() {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionGroupImpl.class ? getIntersectAreaThresholdNative(this.swigCPtr, this) : getIntersectAreaThresholdSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void updateQuadrantItems() {
        $explicit_updateQuadrantItems();
    }

    public void $explicit_updateQuadrantItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            updateQuadrantItemsNative(this.swigCPtr, this);
        } else {
            updateQuadrantItemsSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
    }

    private void getPriority(LayerPriority layerPriority) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            getPriorityNative(this.swigCPtr, this, 0L, layerPriority);
        } else {
            getPrioritySwigExplicitCollisionGroupImplNative(this.swigCPtr, this, 0L, layerPriority);
        }
    }

    public void applyItemsOnVisible() {
        $explicit_applyItemsOnVisible();
    }

    public void $explicit_applyItemsOnVisible() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            applyItemsOnVisibleNative(this.swigCPtr, this);
        } else {
            applyItemsOnVisibleSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
    }

    public void setApplyItemsOnVisible(boolean z) {
        $explicit_setApplyItemsOnVisible(z);
    }

    public void $explicit_setApplyItemsOnVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionGroupImpl.class) {
            setApplyItemsOnVisibleNative(this.swigCPtr, this, z);
        } else {
            setApplyItemsOnVisibleSwigExplicitCollisionGroupImplNative(this.swigCPtr, this, z);
        }
    }

    public boolean hasAppliedItemsOnVisible() {
        return $explicit_hasAppliedItemsOnVisible();
    }

    public boolean $explicit_hasAppliedItemsOnVisible() {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionGroupImpl.class ? hasAppliedItemsOnVisibleNative(this.swigCPtr, this) : hasAppliedItemsOnVisibleSwigExplicitCollisionGroupImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public CollisionGroupImpl() {
        this(createNativeObj(), true);
        MapSvrJNI.swig_jni_init();
        CollisionGroupImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
