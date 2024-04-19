package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.LaneRoutePathPointItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizRouteMapMode;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
import com.autonavi.gbl.map.layer.model.PathPointType;
import com.autonavi.gbl.map.layer.model.RouteLayerScene;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LaneRoutePathPointItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class LaneRoutePathPointItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneRoutePathPointItemImpl.class);
    private transient long swigCPtr;

    private static native long LaneRoutePathPointItemImpl_SWIGUpcast(long j);

    private static native void LaneRoutePathPointItemImpl_change_ownership(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, long j, boolean z);

    private static native void LaneRoutePathPointItemImpl_director_connect(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native boolean mIsNaviGetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl);

    private static native void mIsNaviSetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, boolean z);

    private static native int mLeftEnergyGetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl);

    private static native void mLeftEnergySetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, int i);

    private static native int mModeGetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl);

    private static native void mModeSetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, int i);

    private static native int mSceneGetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl);

    private static native void mSceneSetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, int i);

    private static native int mTotalCountGetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl);

    private static native void mTotalCountSetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, int i);

    private static native int mTypeGetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl);

    private static native void mTypeSetNative(long j, LaneRoutePathPointItemImpl laneRoutePathPointItemImpl, int i);

    public LaneRoutePathPointItemImpl(long j, boolean z) {
        super(LaneRoutePathPointItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof LaneRoutePathPointItemImpl) {
            return getUID(this) == getUID((LaneRoutePathPointItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        long cPtr = getCPtr(laneRoutePathPointItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LaneRoutePathPointItemImpl laneRoutePathPointItemImpl) {
        if (laneRoutePathPointItemImpl == null) {
            return 0L;
        }
        return laneRoutePathPointItemImpl.swigCPtr;
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
        LaneRoutePathPointItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LaneRoutePathPointItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneRoutePathPointItemImpl() {
        this(createNativeObj(), true);
        LayerLaneSvrJNI.swig_jni_init();
        LaneRoutePathPointItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMIsNavi(boolean z) {
        $explicit_setMIsNavi(z);
    }

    public void $explicit_setMIsNavi(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mIsNaviSetNative(j, this, z);
    }

    public boolean getMIsNavi() {
        return $explicit_getMIsNavi();
    }

    public boolean $explicit_getMIsNavi() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mIsNaviGetNative(j, this);
    }

    public void setMMode(@BizRouteMapMode.BizRouteMapMode1 int i) {
        $explicit_setMMode(i);
    }

    public void $explicit_setMMode(@BizRouteMapMode.BizRouteMapMode1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mModeSetNative(j, this, i);
    }

    @BizRouteMapMode.BizRouteMapMode1
    public int getMMode() {
        return $explicit_getMMode();
    }

    @BizRouteMapMode.BizRouteMapMode1
    public int $explicit_getMMode() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mModeGetNative(j, this);
    }

    public void setMScene(@RouteLayerScene.RouteLayerScene1 int i) {
        $explicit_setMScene(i);
    }

    public void $explicit_setMScene(@RouteLayerScene.RouteLayerScene1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mSceneSetNative(j, this, i);
    }

    @RouteLayerScene.RouteLayerScene1
    public int getMScene() {
        return $explicit_getMScene();
    }

    @RouteLayerScene.RouteLayerScene1
    public int $explicit_getMScene() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mSceneGetNative(j, this);
    }

    public void setMType(@PathPointType.PathPointType1 int i) {
        $explicit_setMType(i);
    }

    public void $explicit_setMType(@PathPointType.PathPointType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTypeSetNative(j, this, i);
    }

    @PathPointType.PathPointType1
    public int getMType() {
        return $explicit_getMType();
    }

    @PathPointType.PathPointType1
    public int $explicit_getMType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTypeGetNative(j, this);
    }

    public void setMLeftEnergy(int i) {
        $explicit_setMLeftEnergy(i);
    }

    public void $explicit_setMLeftEnergy(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLeftEnergySetNative(j, this, i);
    }

    public int getMLeftEnergy() {
        return $explicit_getMLeftEnergy();
    }

    public int $explicit_getMLeftEnergy() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLeftEnergyGetNative(j, this);
    }

    public void setMTotalCount(int i) {
        $explicit_setMTotalCount(i);
    }

    public void $explicit_setMTotalCount(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTotalCountSetNative(j, this, i);
    }

    public int getMTotalCount() {
        return $explicit_getMTotalCount();
    }

    public int $explicit_getMTotalCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTotalCountGetNative(j, this);
    }
}
