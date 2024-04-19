package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.map.CollisionCombination;
import com.autonavi.gbl.map.model.CollisionType;
import java.util.ArrayList;
@IntfAuto(target = CollisionCombination.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CollisionCombinationImpl extends ICollisionEntityImpl {
    private static BindTable BIND_TABLE = new BindTable(CollisionCombinationImpl.class);
    private transient long swigCPtr;

    private static native long CollisionCombinationImpl_SWIGUpcast(long j);

    private static native void CollisionCombinationImpl_change_ownership(CollisionCombinationImpl collisionCombinationImpl, long j, boolean z);

    private static native void CollisionCombinationImpl_director_connect(CollisionCombinationImpl collisionCombinationImpl, long j, boolean z, boolean z2);

    private static native boolean addGroupNative(long j, CollisionCombinationImpl collisionCombinationImpl, long j2, CollisionGroupImpl collisionGroupImpl);

    private static native boolean addGroupSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl, long j2, CollisionGroupImpl collisionGroupImpl);

    private static native void applyItemsOnVisibleNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native void caculateCollisionNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native void caculateCollisionSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native void clearAreaCollisionRecordNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native void enableAreaCollisionNative(long j, CollisionCombinationImpl collisionCombinationImpl, boolean z);

    private static native void enableAreaCollisionSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl, boolean z);

    private static native long[] getGroupsNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native long[] getGroupsSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native int getTypeNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native int getTypeSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native boolean isAreaCollisionNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native boolean isAreaCollisionSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native boolean isCollidedByFocusItemNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native boolean isCollidedByFocusItemSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native void lockItemsNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native void lockItemsSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native void onRecoverCollisonItemNative(long j, CollisionCombinationImpl collisionCombinationImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native void onRecoverCollisonItemSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native void recoverAreaCollisionRecordNative(long j, CollisionCombinationImpl collisionCombinationImpl, long j2, ICollisionItemImpl iCollisionItemImpl, long j3, CollisionCombinationImpl collisionCombinationImpl2);

    private static native void removeCollisionItemsNative(long j, CollisionCombinationImpl collisionCombinationImpl, long[] jArr);

    private static native void removeCollisionItemsSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl, long[] jArr);

    private static native boolean removeGroupNative(long j, CollisionCombinationImpl collisionCombinationImpl, long j2, CollisionGroupImpl collisionGroupImpl);

    private static native boolean removeGroupSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl, long j2, CollisionGroupImpl collisionGroupImpl);

    private static native void resetNextPairNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native void resetNextPairSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native void setCollidedByFocusItemNative(long j, CollisionCombinationImpl collisionCombinationImpl, boolean z);

    private static native void setCollidedByFocusItemSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl, boolean z);

    private static native boolean testIntersectNative(long j, CollisionCombinationImpl collisionCombinationImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native boolean testIntersectSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl, long j2, ICollisionItemImpl iCollisionItemImpl);

    private static native void unLockItemsNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    private static native void unLockItemsSwigExplicitCollisionCombinationImplNative(long j, CollisionCombinationImpl collisionCombinationImpl);

    public CollisionCombinationImpl(long j, boolean z) {
        super(CollisionCombinationImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean equals(Object obj) {
        if (obj instanceof CollisionCombinationImpl) {
            return getUID(this) == getUID((CollisionCombinationImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CollisionCombinationImpl collisionCombinationImpl) {
        long cPtr = getCPtr(collisionCombinationImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CollisionCombinationImpl collisionCombinationImpl) {
        if (collisionCombinationImpl == null) {
            return 0L;
        }
        return collisionCombinationImpl.swigCPtr;
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
        CollisionCombinationImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CollisionCombinationImpl_change_ownership(this, this.swigCPtr, true);
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void resetNextPair() {
        $explicit_resetNextPair();
    }

    public void $explicit_resetNextPair() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionCombinationImpl.class) {
            resetNextPairNative(this.swigCPtr, this);
        } else {
            resetNextPairSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean testIntersect(ICollisionItemImpl iCollisionItemImpl) {
        return $explicit_testIntersect(iCollisionItemImpl);
    }

    public boolean $explicit_testIntersect(ICollisionItemImpl iCollisionItemImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionCombinationImpl.class ? testIntersectNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl) : testIntersectSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl);
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
            return getClass() == CollisionCombinationImpl.class ? getTypeNative(this.swigCPtr, this) : getTypeSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean addGroup(CollisionGroupImpl collisionGroupImpl) {
        return $explicit_addGroup(collisionGroupImpl);
    }

    public boolean $explicit_addGroup(CollisionGroupImpl collisionGroupImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionCombinationImpl.class ? addGroupNative(this.swigCPtr, this, CollisionGroupImpl.getCPtr(collisionGroupImpl), collisionGroupImpl) : addGroupSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this, CollisionGroupImpl.getCPtr(collisionGroupImpl), collisionGroupImpl);
        }
        throw new NullPointerException();
    }

    public boolean removeGroup(CollisionGroupImpl collisionGroupImpl) {
        return $explicit_removeGroup(collisionGroupImpl);
    }

    public boolean $explicit_removeGroup(CollisionGroupImpl collisionGroupImpl) {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionCombinationImpl.class ? removeGroupNative(this.swigCPtr, this, CollisionGroupImpl.getCPtr(collisionGroupImpl), collisionGroupImpl) : removeGroupSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this, CollisionGroupImpl.getCPtr(collisionGroupImpl), collisionGroupImpl);
        }
        throw new NullPointerException();
    }

    public ArrayList<CollisionGroupImpl> getGroups() {
        return $explicit_getGroups();
    }

    public ArrayList<CollisionGroupImpl> $explicit_getGroups() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        long[] groupsNative = getClass() == CollisionCombinationImpl.class ? getGroupsNative(this.swigCPtr, this) : getGroupsSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this);
        if (groupsNative != null) {
            ArrayList<CollisionGroupImpl> arrayList = new ArrayList<>();
            for (long j : groupsNative) {
                arrayList.add(new CollisionGroupImpl(j, false));
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
        if (getClass() == CollisionCombinationImpl.class) {
            enableAreaCollisionNative(this.swigCPtr, this, z);
        } else {
            enableAreaCollisionSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this, z);
        }
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public boolean isAreaCollision() {
        return $explicit_isAreaCollision();
    }

    public boolean $explicit_isAreaCollision() {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionCombinationImpl.class ? isAreaCollisionNative(this.swigCPtr, this) : isAreaCollisionSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setCollidedByFocusItem(boolean z) {
        $explicit_setCollidedByFocusItem(z);
    }

    public void $explicit_setCollidedByFocusItem(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionCombinationImpl.class) {
            setCollidedByFocusItemNative(this.swigCPtr, this, z);
        } else {
            setCollidedByFocusItemSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this, z);
        }
    }

    public boolean isCollidedByFocusItem() {
        return $explicit_isCollidedByFocusItem();
    }

    public boolean $explicit_isCollidedByFocusItem() {
        if (this.swigCPtr != 0) {
            return getClass() == CollisionCombinationImpl.class ? isCollidedByFocusItemNative(this.swigCPtr, this) : isCollidedByFocusItemSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.impl.ICollisionEntityImpl
    public void lockItems() {
        $explicit_lockItems();
    }

    public void $explicit_lockItems() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionCombinationImpl.class) {
            lockItemsNative(this.swigCPtr, this);
        } else {
            lockItemsSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this);
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
        if (getClass() == CollisionCombinationImpl.class) {
            unLockItemsNative(this.swigCPtr, this);
        } else {
            unLockItemsSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this);
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
        if (getClass() == CollisionCombinationImpl.class) {
            caculateCollisionNative(this.swigCPtr, this);
        } else {
            caculateCollisionSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this);
        }
    }

    public void removeCollisionItems(ArrayList<ICollisionItemImpl> arrayList) {
        $explicit_removeCollisionItems(arrayList);
    }

    public void $explicit_removeCollisionItems(ArrayList<ICollisionItemImpl> arrayList) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        long[] jArr = null;
        if (arrayList != null) {
            int size = arrayList.size();
            long[] jArr2 = new long[size];
            for (int i = 0; i < size; i++) {
                jArr2[i] = ICollisionItemImpl.getCPtr(arrayList.get(i));
            }
            jArr = jArr2;
        }
        if (getClass() == CollisionCombinationImpl.class) {
            removeCollisionItemsNative(this.swigCPtr, this, jArr);
        } else {
            removeCollisionItemsSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this, jArr);
        }
    }

    public void onRecoverCollisonItem(ICollisionItemImpl iCollisionItemImpl) {
        $explicit_onRecoverCollisonItem(iCollisionItemImpl);
    }

    public void $explicit_onRecoverCollisonItem(ICollisionItemImpl iCollisionItemImpl) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == CollisionCombinationImpl.class) {
            onRecoverCollisonItemNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl);
        } else {
            onRecoverCollisonItemSwigExplicitCollisionCombinationImplNative(this.swigCPtr, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl);
        }
    }

    public void clearAreaCollisionRecord() {
        $explicit_clearAreaCollisionRecord();
    }

    public void $explicit_clearAreaCollisionRecord() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        clearAreaCollisionRecordNative(j, this);
    }

    public void recoverAreaCollisionRecord(ICollisionItemImpl iCollisionItemImpl, CollisionCombinationImpl collisionCombinationImpl) {
        $explicit_recoverAreaCollisionRecord(iCollisionItemImpl, collisionCombinationImpl);
    }

    public void $explicit_recoverAreaCollisionRecord(ICollisionItemImpl iCollisionItemImpl, CollisionCombinationImpl collisionCombinationImpl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        recoverAreaCollisionRecordNative(j, this, ICollisionItemImpl.getCPtr(iCollisionItemImpl), iCollisionItemImpl, getCPtr(collisionCombinationImpl), collisionCombinationImpl);
    }

    public void applyItemsOnVisible() {
        $explicit_applyItemsOnVisible();
    }

    public void $explicit_applyItemsOnVisible() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        applyItemsOnVisibleNative(j, this);
    }

    public CollisionCombinationImpl() {
        this(createNativeObj(), true);
        MapSvrJNI.swig_jni_init();
        CollisionCombinationImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
