package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = QuadrantLayerItemImpl.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class QuadrantLayerItem extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(QuadrantLayerItem.class);
    private transient long swigCPtr;

    private static native long QuadrantLayerItem_SWIGUpcast(long j);

    private static native void QuadrantLayerItem_change_ownership(QuadrantLayerItem quadrantLayerItem, long j, boolean z);

    private static native void QuadrantLayerItem_director_connect(QuadrantLayerItem quadrantLayerItem, long j, boolean z, boolean z2);

    private static native void addIntersectAreaNative(long j, QuadrantLayerItem quadrantLayerItem, float f);

    private static native void addIntersectAreaSwigExplicitQuadrantLayerItemNative(long j, QuadrantLayerItem quadrantLayerItem, float f);

    private static native boolean checkShowFlagNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native boolean checkShowFlagSwigExplicitQuadrantLayerItemNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native long createNativeObj(int i, long j);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native float getIntersectAreaNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native float getIntersectAreaSwigExplicitQuadrantLayerItemNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native long getQuadrantGroupIdNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native long getQuadrantGroupIdSwigExplicitQuadrantLayerItemNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native int getQuadrantTypeNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native int getQuadrantTypeSwigExplicitQuadrantLayerItemNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native boolean isIdleNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native boolean isIdleSwigExplicitQuadrantLayerItemNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native void onVisibleNative(long j, QuadrantLayerItem quadrantLayerItem, boolean z);

    private static native void onVisibleSwigExplicitQuadrantLayerItemNative(long j, QuadrantLayerItem quadrantLayerItem, boolean z);

    private static native void resetIntersectAreaNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native void resetIntersectAreaSwigExplicitQuadrantLayerItemNative(long j, QuadrantLayerItem quadrantLayerItem);

    private static native void setIdleNative(long j, QuadrantLayerItem quadrantLayerItem, boolean z);

    private static native void setIdleSwigExplicitQuadrantLayerItemNative(long j, QuadrantLayerItem quadrantLayerItem, boolean z);

    public QuadrantLayerItem(long j, boolean z) {
        super(QuadrantLayerItem_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof QuadrantLayerItem) {
            return getUID(this) == getUID((QuadrantLayerItem) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(QuadrantLayerItem quadrantLayerItem) {
        long cPtr = getCPtr(quadrantLayerItem);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(QuadrantLayerItem quadrantLayerItem) {
        if (quadrantLayerItem == null) {
            return 0L;
        }
        return quadrantLayerItem.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        QuadrantLayerItem_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        QuadrantLayerItem_change_ownership(this, this.swigCPtr, true);
    }

    public QuadrantLayerItem(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        MapLayerSvrJNI.swig_jni_init();
        QuadrantLayerItem_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void onVisible(boolean z) {
        $explicit_onVisible(z);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_onVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == QuadrantLayerItem.class) {
            onVisibleNative(this.swigCPtr, this, z);
        } else {
            onVisibleSwigExplicitQuadrantLayerItemNative(this.swigCPtr, this, z);
        }
    }

    public void setIdle(boolean z) {
        $explicit_setIdle(z);
    }

    public void $explicit_setIdle(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == QuadrantLayerItem.class) {
            setIdleNative(this.swigCPtr, this, z);
        } else {
            setIdleSwigExplicitQuadrantLayerItemNative(this.swigCPtr, this, z);
        }
    }

    public boolean isIdle() {
        return $explicit_isIdle();
    }

    public boolean $explicit_isIdle() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItem.class ? isIdleNative(this.swigCPtr, this) : isIdleSwigExplicitQuadrantLayerItemNative(this.swigCPtr, this);
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
        if (getClass() == QuadrantLayerItem.class) {
            addIntersectAreaNative(this.swigCPtr, this, f);
        } else {
            addIntersectAreaSwigExplicitQuadrantLayerItemNative(this.swigCPtr, this, f);
        }
    }

    public float getIntersectArea() {
        return $explicit_getIntersectArea();
    }

    public float $explicit_getIntersectArea() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItem.class ? getIntersectAreaNative(this.swigCPtr, this) : getIntersectAreaSwigExplicitQuadrantLayerItemNative(this.swigCPtr, this);
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
        if (getClass() == QuadrantLayerItem.class) {
            resetIntersectAreaNative(this.swigCPtr, this);
        } else {
            resetIntersectAreaSwigExplicitQuadrantLayerItemNative(this.swigCPtr, this);
        }
    }

    public boolean checkShowFlag() {
        return $explicit_checkShowFlag();
    }

    public boolean $explicit_checkShowFlag() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItem.class ? checkShowFlagNative(this.swigCPtr, this) : checkShowFlagSwigExplicitQuadrantLayerItemNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public long getQuadrantGroupId() {
        return $explicit_getQuadrantGroupId();
    }

    public long $explicit_getQuadrantGroupId() {
        if (this.swigCPtr != 0) {
            return getClass() == QuadrantLayerItem.class ? getQuadrantGroupIdNative(this.swigCPtr, this) : getQuadrantGroupIdSwigExplicitQuadrantLayerItemNative(this.swigCPtr, this);
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
            return getClass() == QuadrantLayerItem.class ? getQuadrantTypeNative(this.swigCPtr, this) : getQuadrantTypeSwigExplicitQuadrantLayerItemNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }
}
