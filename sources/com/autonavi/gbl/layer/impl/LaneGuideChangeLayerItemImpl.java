package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.lane.model.LaneChangeGuidanceType;
import com.autonavi.gbl.layer.LaneGuideChangeLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LaneGuideChangeLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LaneGuideChangeLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideChangeLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LaneGuideChangeLayerItemImpl_SWIGUpcast(long j);

    private static native void LaneGuideChangeLayerItemImpl_change_ownership(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, long j, boolean z);

    private static native void LaneGuideChangeLayerItemImpl_director_connect(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, long j, boolean z, boolean z2);

    private static native int bubbleSideGetNative(long j, LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl);

    private static native void bubbleSideSetNative(long j, LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, int i);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int sceneTypeGetNative(long j, LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl);

    private static native void sceneTypeSetNative(long j, LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl, int i);

    public LaneGuideChangeLayerItemImpl(long j, boolean z) {
        super(LaneGuideChangeLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LaneGuideChangeLayerItemImpl) {
            return getUID(this) == getUID((LaneGuideChangeLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        long cPtr = getCPtr(laneGuideChangeLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LaneGuideChangeLayerItemImpl laneGuideChangeLayerItemImpl) {
        if (laneGuideChangeLayerItemImpl == null) {
            return 0L;
        }
        return laneGuideChangeLayerItemImpl.swigCPtr;
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
        LaneGuideChangeLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LaneGuideChangeLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneGuideChangeLayerItemImpl() {
        this(createNativeObj(), true);
        LayerLaneSvrJNI.swig_jni_init();
        LaneGuideChangeLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setSceneType(@LaneChangeGuidanceType.LaneChangeGuidanceType1 int i) {
        $explicit_setSceneType(i);
    }

    public void $explicit_setSceneType(@LaneChangeGuidanceType.LaneChangeGuidanceType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        sceneTypeSetNative(j, this, i);
    }

    @LaneChangeGuidanceType.LaneChangeGuidanceType1
    public int getSceneType() {
        return $explicit_getSceneType();
    }

    @LaneChangeGuidanceType.LaneChangeGuidanceType1
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
}
