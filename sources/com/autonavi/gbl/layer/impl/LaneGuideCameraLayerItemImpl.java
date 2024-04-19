package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.model.BreakRuleCameraSubType;
import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideCameraLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LaneGuideCameraLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class LaneGuideCameraLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideCameraLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LaneGuideCameraLayerItemImpl_SWIGUpcast(long j);

    private static native void LaneGuideCameraLayerItemImpl_change_ownership(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, long j, boolean z);

    private static native void LaneGuideCameraLayerItemImpl_director_connect(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mBreakSubTypeGetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl);

    private static native void mBreakSubTypeSetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, int i);

    private static native long mCameraIdGetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl);

    private static native void mCameraIdSetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, long j2);

    private static native int mCameraSpeedGetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl);

    private static native void mCameraSpeedSetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, int i);

    private static native int mCameraTypeGetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl);

    private static native void mCameraTypeSetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, int i);

    private static native int mDirectionTypeGetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl);

    private static native void mDirectionTypeSetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, int i);

    private static native int mDistanceGetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl);

    private static native void mDistanceSetNative(long j, LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl, int i);

    public LaneGuideCameraLayerItemImpl(long j, boolean z) {
        super(LaneGuideCameraLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof LaneGuideCameraLayerItemImpl) {
            return getUID(this) == getUID((LaneGuideCameraLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        long cPtr = getCPtr(laneGuideCameraLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LaneGuideCameraLayerItemImpl laneGuideCameraLayerItemImpl) {
        if (laneGuideCameraLayerItemImpl == null) {
            return 0L;
        }
        return laneGuideCameraLayerItemImpl.swigCPtr;
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
        LaneGuideCameraLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LaneGuideCameraLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneGuideCameraLayerItemImpl() {
        this(createNativeObj(), true);
        LayerLaneSvrJNI.swig_jni_init();
        LaneGuideCameraLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        $explicit_setMDirectionType(i);
    }

    public void $explicit_setMDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDirectionTypeSetNative(j, this, i);
    }

    @BubbleDirectionType.BubbleDirectionType1
    public int getMDirectionType() {
        return $explicit_getMDirectionType();
    }

    @BubbleDirectionType.BubbleDirectionType1
    public int $explicit_getMDirectionType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDirectionTypeGetNative(j, this);
    }

    public void setMCameraType(@CameraType.CameraType1 int i) {
        $explicit_setMCameraType(i);
    }

    public void $explicit_setMCameraType(@CameraType.CameraType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCameraTypeSetNative(j, this, i);
    }

    @CameraType.CameraType1
    public int getMCameraType() {
        return $explicit_getMCameraType();
    }

    @CameraType.CameraType1
    public int $explicit_getMCameraType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCameraTypeGetNative(j, this);
    }

    public void setMBreakSubType(@BreakRuleCameraSubType.BreakRuleCameraSubType1 int i) {
        $explicit_setMBreakSubType(i);
    }

    public void $explicit_setMBreakSubType(@BreakRuleCameraSubType.BreakRuleCameraSubType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mBreakSubTypeSetNative(j, this, i);
    }

    @BreakRuleCameraSubType.BreakRuleCameraSubType1
    public int getMBreakSubType() {
        return $explicit_getMBreakSubType();
    }

    @BreakRuleCameraSubType.BreakRuleCameraSubType1
    public int $explicit_getMBreakSubType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mBreakSubTypeGetNative(j, this);
    }

    public void setMCameraSpeed(int i) {
        $explicit_setMCameraSpeed(i);
    }

    public void $explicit_setMCameraSpeed(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCameraSpeedSetNative(j, this, i);
    }

    public int getMCameraSpeed() {
        return $explicit_getMCameraSpeed();
    }

    public int $explicit_getMCameraSpeed() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCameraSpeedGetNative(j, this);
    }

    public void setMDistance(int i) {
        $explicit_setMDistance(i);
    }

    public void $explicit_setMDistance(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDistanceSetNative(j, this, i);
    }

    public int getMDistance() {
        return $explicit_getMDistance();
    }

    public int $explicit_getMDistance() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDistanceGetNative(j, this);
    }

    public void setMCameraId(long j) {
        $explicit_setMCameraId(j);
    }

    public void $explicit_setMCameraId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mCameraIdSetNative(j2, this, j);
    }

    public long getMCameraId() {
        return $explicit_getMCameraId();
    }

    public long $explicit_getMCameraId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCameraIdGetNative(j, this);
    }
}
