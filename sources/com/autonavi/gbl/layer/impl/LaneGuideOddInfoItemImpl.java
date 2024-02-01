package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideOddInfoItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.LaneODDPointType;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LaneGuideOddInfoItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LaneGuideOddInfoItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideOddInfoItemImpl.class);
    private transient long swigCPtr;

    private static native long LaneGuideOddInfoItemImpl_SWIGUpcast(long j);

    private static native void LaneGuideOddInfoItemImpl_change_ownership(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, long j, boolean z);

    private static native void LaneGuideOddInfoItemImpl_director_connect(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int directionTypeGetNative(long j, LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl);

    private static native void directionTypeSetNative(long j, LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, int i);

    private static native String getClassTypeNameNative();

    private static native int typeGetNative(long j, LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl);

    private static native void typeSetNative(long j, LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl, int i);

    public LaneGuideOddInfoItemImpl(long j, boolean z) {
        super(LaneGuideOddInfoItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LaneGuideOddInfoItemImpl) {
            return getUID(this) == getUID((LaneGuideOddInfoItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        long cPtr = getCPtr(laneGuideOddInfoItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LaneGuideOddInfoItemImpl laneGuideOddInfoItemImpl) {
        if (laneGuideOddInfoItemImpl == null) {
            return 0L;
        }
        return laneGuideOddInfoItemImpl.swigCPtr;
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
        LaneGuideOddInfoItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LaneGuideOddInfoItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneGuideOddInfoItemImpl() {
        this(createNativeObj(), true);
        LayerLaneSvrJNI.swig_jni_init();
        LaneGuideOddInfoItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        $explicit_setDirectionType(i);
    }

    public void $explicit_setDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        directionTypeSetNative(j, this, i);
    }

    @BubbleDirectionType.BubbleDirectionType1
    public int getDirectionType() {
        return $explicit_getDirectionType();
    }

    @BubbleDirectionType.BubbleDirectionType1
    public int $explicit_getDirectionType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return directionTypeGetNative(j, this);
    }

    public void setType(@LaneODDPointType.LaneODDPointType1 int i) {
        $explicit_setType(i);
    }

    public void $explicit_setType(@LaneODDPointType.LaneODDPointType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        typeSetNative(j, this, i);
    }

    @LaneODDPointType.LaneODDPointType1
    public int getType() {
        return $explicit_getType();
    }

    @LaneODDPointType.LaneODDPointType1
    public int $explicit_getType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return typeGetNative(j, this);
    }
}
