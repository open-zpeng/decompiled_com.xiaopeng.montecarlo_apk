package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.ForbiddenTurnType;
import com.autonavi.gbl.lane.model.LaneRestrictedType;
import com.autonavi.gbl.lane.model.LimitTimeType;
import com.autonavi.gbl.layer.LaneGuideRestrictedLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LaneGuideRestrictedLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LaneGuideRestrictedLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideRestrictedLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LaneGuideRestrictedLayerItemImpl_SWIGUpcast(long j);

    private static native void LaneGuideRestrictedLayerItemImpl_change_ownership(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, long j, boolean z);

    private static native void LaneGuideRestrictedLayerItemImpl_director_connect(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, long j, boolean z, boolean z2);

    private static native int bubbleSideGetNative(long j, LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl);

    private static native void bubbleSideSetNative(long j, LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, int i);

    private static native long createNativeObj(int i, long j);

    private static native void destroyNativeObj(long j);

    private static native int forbiddenTypeGetNative(long j, LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl);

    private static native void forbiddenTypeSetNative(long j, LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, int i);

    private static native String getClassTypeNameNative();

    private static native int limitTypeGetNative(long j, LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl);

    private static native void limitTypeSetNative(long j, LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, int i);

    private static native int sceneTypeGetNative(long j, LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl);

    private static native void sceneTypeSetNative(long j, LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl, int i);

    public LaneGuideRestrictedLayerItemImpl(long j, boolean z) {
        super(LaneGuideRestrictedLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LaneGuideRestrictedLayerItemImpl) {
            return getUID(this) == getUID((LaneGuideRestrictedLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        long cPtr = getCPtr(laneGuideRestrictedLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LaneGuideRestrictedLayerItemImpl laneGuideRestrictedLayerItemImpl) {
        if (laneGuideRestrictedLayerItemImpl == null) {
            return 0L;
        }
        return laneGuideRestrictedLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        LaneGuideRestrictedLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LaneGuideRestrictedLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneGuideRestrictedLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerLaneSvrJNI.swig_jni_init();
        LaneGuideRestrictedLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setSceneType(@LaneRestrictedType.LaneRestrictedType1 int i) {
        $explicit_setSceneType(i);
    }

    public void $explicit_setSceneType(@LaneRestrictedType.LaneRestrictedType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        sceneTypeSetNative(j, this, i);
    }

    @LaneRestrictedType.LaneRestrictedType1
    public int getSceneType() {
        return $explicit_getSceneType();
    }

    @LaneRestrictedType.LaneRestrictedType1
    public int $explicit_getSceneType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return sceneTypeGetNative(j, this);
    }

    public void setBubbleSide(@BubbleDirectionType.BubbleDirectionType1 int i) {
        $explicit_setBubbleSide(i);
    }

    public void $explicit_setBubbleSide(@BubbleDirectionType.BubbleDirectionType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bubbleSideSetNative(j, this, i);
    }

    @BubbleDirectionType.BubbleDirectionType1
    public int getBubbleSide() {
        return $explicit_getBubbleSide();
    }

    @BubbleDirectionType.BubbleDirectionType1
    public int $explicit_getBubbleSide() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bubbleSideGetNative(j, this);
    }

    public void setForbiddenType(@ForbiddenTurnType.ForbiddenTurnType1 int i) {
        $explicit_setForbiddenType(i);
    }

    public void $explicit_setForbiddenType(@ForbiddenTurnType.ForbiddenTurnType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        forbiddenTypeSetNative(j, this, i);
    }

    @ForbiddenTurnType.ForbiddenTurnType1
    public int getForbiddenType() {
        return $explicit_getForbiddenType();
    }

    @ForbiddenTurnType.ForbiddenTurnType1
    public int $explicit_getForbiddenType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return forbiddenTypeGetNative(j, this);
    }

    public void setLimitType(@LimitTimeType.LimitTimeType1 int i) {
        $explicit_setLimitType(i);
    }

    public void $explicit_setLimitType(@LimitTimeType.LimitTimeType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        limitTypeSetNative(j, this, i);
    }

    @LimitTimeType.LimitTimeType1
    public int getLimitType() {
        return $explicit_getLimitType();
    }

    @LimitTimeType.LimitTimeType1
    public int $explicit_getLimitType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return limitTypeGetNative(j, this);
    }
}
