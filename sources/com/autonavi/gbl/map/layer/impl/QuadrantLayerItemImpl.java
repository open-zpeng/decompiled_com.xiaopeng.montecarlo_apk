package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.IntersectValueType;
import com.autonavi.gbl.map.layer.model.PointLayerItemType;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = QuadrantLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class QuadrantLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(QuadrantLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long QuadrantLayerItemImpl_SWIGUpcast(long j);

    private static native void QuadrantLayerItemImpl_change_ownership(QuadrantLayerItemImpl quadrantLayerItemImpl, long j, boolean z);

    private static native void QuadrantLayerItemImpl_director_connect(QuadrantLayerItemImpl quadrantLayerItemImpl, long j, boolean z, boolean z2);

    private static native void addIntersectAreaExNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, float f);

    private static native void addIntersectAreaExSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, float f);

    private static native void addIntersectAreaNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, float f);

    private static native void addIntersectAreaSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, float f);

    private static native void addIntersectValueNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, int i, float f);

    private static native void addIntersectValueSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, int i, float f);

    private static native boolean canAreaCollisionNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native boolean canAreaCollisionSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native boolean canCollisionNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native boolean canCollisionSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native boolean checkShowFlagNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native boolean checkShowFlagSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native long createNativeObj(int i, long j);

    private static native long createNativeObj1(int i, int i2, long j);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native float getIntersectAreaExNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native float getIntersectAreaExSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native float getIntersectAreaNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native float getIntersectAreaSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native float getIntersectValueNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, int i);

    private static native float getIntersectValueSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, int i);

    private static native long getQuadrantGroupIdNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native long getQuadrantGroupIdSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native int getQuadrantTypeNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native int getQuadrantTypeSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native boolean isIdleNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native boolean isIdleSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native void resetIntersectAreaExNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native void resetIntersectAreaExSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native void resetIntersectAreaNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native void resetIntersectAreaSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl);

    private static native void resetIntersectValueNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, int i);

    private static native void resetIntersectValueSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, int i);

    private static native void resetOnVisibleNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z);

    private static native void resetOnVisibleSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z);

    private static native void setIdleNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z);

    private static native void setIdleSwigExplicitQuadrantLayerItemImplNative(long j, QuadrantLayerItemImpl quadrantLayerItemImpl, boolean z);

    public QuadrantLayerItemImpl(long j, boolean z) {
        super(QuadrantLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof QuadrantLayerItemImpl) {
            return getUID(this) == getUID((QuadrantLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        long cPtr = getCPtr(quadrantLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(QuadrantLayerItemImpl quadrantLayerItemImpl) {
        if (quadrantLayerItemImpl == null) {
            return 0L;
        }
        return quadrantLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        QuadrantLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        QuadrantLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public QuadrantLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        MapLayerSvrJNI.swig_jni_init();
        QuadrantLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public QuadrantLayerItemImpl(@PointLayerItemType.PointLayerItemType1 int i, @QuadrantType.QuadrantType1 int i2, long j) {
        this(createNativeObj1(i, i2, j), true);
        MapLayerSvrJNI.swig_jni_init();
        QuadrantLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void resetOnVisible(boolean z) {
        $explicit_resetOnVisible(z);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_resetOnVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == QuadrantLayerItemImpl.class) {
            resetOnVisibleNative(this.swigCPtr, this, z);
        } else {
            resetOnVisibleSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public void setIdle(boolean z) {
        $explicit_setIdle(z);
    }

    public void $explicit_setIdle(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == QuadrantLayerItemImpl.class) {
            setIdleNative(this.swigCPtr, this, z);
        } else {
            setIdleSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public boolean isIdle() {
        return $explicit_isIdle();
    }

    public boolean $explicit_isIdle() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItemImpl.class ? isIdleNative(this.swigCPtr, this) : isIdleSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void addIntersectArea(float f) {
        $explicit_addIntersectArea(f);
    }

    public void $explicit_addIntersectArea(float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == QuadrantLayerItemImpl.class) {
            addIntersectAreaNative(this.swigCPtr, this, f);
        } else {
            addIntersectAreaSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this, f);
        }
    }

    public float getIntersectArea() {
        return $explicit_getIntersectArea();
    }

    public float $explicit_getIntersectArea() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItemImpl.class ? getIntersectAreaNative(this.swigCPtr, this) : getIntersectAreaSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void resetIntersectArea() {
        $explicit_resetIntersectArea();
    }

    public void $explicit_resetIntersectArea() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == QuadrantLayerItemImpl.class) {
            resetIntersectAreaNative(this.swigCPtr, this);
        } else {
            resetIntersectAreaSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void addIntersectAreaEx(float f) {
        $explicit_addIntersectAreaEx(f);
    }

    public void $explicit_addIntersectAreaEx(float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == QuadrantLayerItemImpl.class) {
            addIntersectAreaExNative(this.swigCPtr, this, f);
        } else {
            addIntersectAreaExSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this, f);
        }
    }

    public float getIntersectAreaEx() {
        return $explicit_getIntersectAreaEx();
    }

    public float $explicit_getIntersectAreaEx() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItemImpl.class ? getIntersectAreaExNative(this.swigCPtr, this) : getIntersectAreaExSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void resetIntersectAreaEx() {
        $explicit_resetIntersectAreaEx();
    }

    public void $explicit_resetIntersectAreaEx() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == QuadrantLayerItemImpl.class) {
            resetIntersectAreaExNative(this.swigCPtr, this);
        } else {
            resetIntersectAreaExSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void addIntersectValue(@IntersectValueType.IntersectValueType1 int i, float f) {
        $explicit_addIntersectValue(i, f);
    }

    public void $explicit_addIntersectValue(@IntersectValueType.IntersectValueType1 int i, float f) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == QuadrantLayerItemImpl.class) {
            addIntersectValueNative(this.swigCPtr, this, i, f);
        } else {
            addIntersectValueSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this, i, f);
        }
    }

    public float getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        return $explicit_getIntersectValue(i);
    }

    public float $explicit_getIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItemImpl.class ? getIntersectValueNative(this.swigCPtr, this, i) : getIntersectValueSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this, i);
        }
        throw new NullPointerException();
    }

    public void resetIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        $explicit_resetIntersectValue(i);
    }

    public void $explicit_resetIntersectValue(@IntersectValueType.IntersectValueType1 int i) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == QuadrantLayerItemImpl.class) {
            resetIntersectValueNative(this.swigCPtr, this, i);
        } else {
            resetIntersectValueSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this, i);
        }
    }

    public boolean checkShowFlag() {
        return $explicit_checkShowFlag();
    }

    public boolean $explicit_checkShowFlag() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItemImpl.class ? checkShowFlagNative(this.swigCPtr, this) : checkShowFlagSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public long getQuadrantGroupId() {
        return $explicit_getQuadrantGroupId();
    }

    public long $explicit_getQuadrantGroupId() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItemImpl.class ? getQuadrantGroupIdNative(this.swigCPtr, this) : getQuadrantGroupIdSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @QuadrantType.QuadrantType1
    public int getQuadrantType() {
        return $explicit_getQuadrantType();
    }

    @QuadrantType.QuadrantType1
    public int $explicit_getQuadrantType() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItemImpl.class ? getQuadrantTypeNative(this.swigCPtr, this) : getQuadrantTypeSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canCollision() {
        return $explicit_canCollision();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean $explicit_canCollision() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItemImpl.class ? canCollisionNative(this.swigCPtr, this) : canCollisionSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public boolean canAreaCollision() {
        return $explicit_canAreaCollision();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public boolean $explicit_canAreaCollision() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItemImpl.class ? canAreaCollisionNative(this.swigCPtr, this) : canAreaCollisionSwigExplicitQuadrantLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }
}
