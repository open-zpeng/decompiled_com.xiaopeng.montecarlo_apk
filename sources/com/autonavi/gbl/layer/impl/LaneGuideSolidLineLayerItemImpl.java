package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideSolidLineLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LaneGuideSolidLineLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LaneGuideSolidLineLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideSolidLineLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LaneGuideSolidLineLayerItemImpl_SWIGUpcast(long j);

    private static native void LaneGuideSolidLineLayerItemImpl_change_ownership(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, long j, boolean z);

    private static native void LaneGuideSolidLineLayerItemImpl_director_connect(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, long j, boolean z, boolean z2);

    private static native int bubbleSideGetNative(long j, LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl);

    private static native void bubbleSideSetNative(long j, LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl, int i);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    public LaneGuideSolidLineLayerItemImpl(long j, boolean z) {
        super(LaneGuideSolidLineLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LaneGuideSolidLineLayerItemImpl) {
            return getUID(this) == getUID((LaneGuideSolidLineLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        long cPtr = getCPtr(laneGuideSolidLineLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LaneGuideSolidLineLayerItemImpl laneGuideSolidLineLayerItemImpl) {
        if (laneGuideSolidLineLayerItemImpl == null) {
            return 0L;
        }
        return laneGuideSolidLineLayerItemImpl.swigCPtr;
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
        LaneGuideSolidLineLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LaneGuideSolidLineLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneGuideSolidLineLayerItemImpl() {
        this(createNativeObj(), true);
        LayerLaneSvrJNI.swig_jni_init();
        LaneGuideSolidLineLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
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
