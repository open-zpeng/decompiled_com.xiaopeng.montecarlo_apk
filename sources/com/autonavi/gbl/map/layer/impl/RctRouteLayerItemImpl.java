package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.model.Vector3i;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.impl.MapViewImpl;
import com.autonavi.gbl.map.layer.RctRouteLayerItem;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.RealCityNaviInfo;
import com.autonavi.gbl.map.layer.model.RealCityTmcParam;
@IntfAuto(enableCRfx = true, protoOfCRfx = LayerItemCRfxProto.class, target = RctRouteLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RctRouteLayerItemImpl extends LayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RctRouteLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RctRouteLayerItemImpl_SWIGUpcast(long j);

    private static native void RctRouteLayerItemImpl_change_ownership(RctRouteLayerItemImpl rctRouteLayerItemImpl, long j, boolean z);

    private static native void RctRouteLayerItemImpl_director_connect(RctRouteLayerItemImpl rctRouteLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, MapViewImpl mapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native boolean getCarPosNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, long j2, Vector3i vector3i, float[] fArr, float[] fArr2);

    private static native boolean getCarPosSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, long j2, Vector3i vector3i, float[] fArr, float[] fArr2);

    private static native String getClassTypeNameNative();

    private static native int getItemTypeNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native int getItemTypeSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native void pauseNaviNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native void pauseNaviSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native void resumeNaviNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native void resumeNaviSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native boolean setFlyRouteNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, byte[] bArr);

    private static native boolean setFlyRouteSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, byte[] bArr);

    private static native boolean setFlyTmcNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, byte[] bArr, long j2, RealCityTmcParam realCityTmcParam, int i);

    private static native boolean setFlyTmcSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, byte[] bArr, long j2, RealCityTmcParam realCityTmcParam, int i);

    private static native boolean setGpsPosNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, long j2, Vector3i vector3i, float f);

    private static native boolean setGpsPosSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, long j2, Vector3i vector3i, float f);

    private static native boolean setRctNaviModeNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, int i);

    private static native boolean setRctNaviModeSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, int i);

    private static native void setRtcBinaryDataNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, byte[] bArr);

    private static native void showRtcArrow3DNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, boolean z);

    private static native void showRtcSkeletonNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, boolean z);

    private static native void startNaviNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native void startNaviSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native void stopNaviNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native void stopNaviSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native void updataNaviInfoNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, long j2, RealCityNaviInfo realCityNaviInfo);

    private static native void updataNaviInfoSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl, long j2, RealCityNaviInfo realCityNaviInfo);

    private static native void updateStyleNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    private static native void updateStyleSwigExplicitRctRouteLayerItemImplNative(long j, RctRouteLayerItemImpl rctRouteLayerItemImpl);

    public RctRouteLayerItemImpl(long j, boolean z) {
        super(RctRouteLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof RctRouteLayerItemImpl) {
            return getUID(this) == getUID((RctRouteLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        long cPtr = getCPtr(rctRouteLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RctRouteLayerItemImpl rctRouteLayerItemImpl) {
        if (rctRouteLayerItemImpl == null) {
            return 0L;
        }
        return rctRouteLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        RctRouteLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RctRouteLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RctRouteLayerItemImpl(MapViewImpl mapViewImpl) {
        this(createNativeObj(MapViewImpl.getCPtr(mapViewImpl), mapViewImpl), true);
        MapLayerSvrJNI.swig_jni_init();
        RctRouteLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int getItemType() {
        return $explicit_getItemType();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    @LayerItemType.LayerItemType1
    public int $explicit_getItemType() {
        if (this.swigCPtr != 0) {
            return getClass() == RctRouteLayerItemImpl.class ? getItemTypeNative(this.swigCPtr, this) : getItemTypeSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public boolean setFlyRoute(byte[] bArr) {
        return $explicit_setFlyRoute(bArr);
    }

    public boolean $explicit_setFlyRoute(byte[] bArr) {
        if (this.swigCPtr != 0) {
            return getClass() == RctRouteLayerItemImpl.class ? setFlyRouteNative(this.swigCPtr, this, bArr) : setFlyRouteSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this, bArr);
        }
        throw new NullPointerException();
    }

    public boolean setFlyTmc(byte[] bArr, RealCityTmcParam realCityTmcParam, int i) {
        return $explicit_setFlyTmc(bArr, realCityTmcParam, i);
    }

    public boolean $explicit_setFlyTmc(byte[] bArr, RealCityTmcParam realCityTmcParam, int i) {
        if (this.swigCPtr != 0) {
            return getClass() == RctRouteLayerItemImpl.class ? setFlyTmcNative(this.swigCPtr, this, bArr, 0L, realCityTmcParam, i) : setFlyTmcSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this, bArr, 0L, realCityTmcParam, i);
        }
        throw new NullPointerException();
    }

    public void updataNaviInfo(RealCityNaviInfo realCityNaviInfo) {
        $explicit_updataNaviInfo(realCityNaviInfo);
    }

    public void $explicit_updataNaviInfo(RealCityNaviInfo realCityNaviInfo) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RctRouteLayerItemImpl.class) {
            updataNaviInfoNative(this.swigCPtr, this, 0L, realCityNaviInfo);
        } else {
            updataNaviInfoSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this, 0L, realCityNaviInfo);
        }
    }

    public boolean setRctNaviMode(int i) {
        return $explicit_setRctNaviMode(i);
    }

    public boolean $explicit_setRctNaviMode(int i) {
        if (this.swigCPtr != 0) {
            return getClass() == RctRouteLayerItemImpl.class ? setRctNaviModeNative(this.swigCPtr, this, i) : setRctNaviModeSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this, i);
        }
        throw new NullPointerException();
    }

    public boolean setGpsPos(Vector3i vector3i, float f) {
        return $explicit_setGpsPos(vector3i, f);
    }

    public boolean $explicit_setGpsPos(Vector3i vector3i, float f) {
        if (this.swigCPtr != 0) {
            return getClass() == RctRouteLayerItemImpl.class ? setGpsPosNative(this.swigCPtr, this, 0L, vector3i, f) : setGpsPosSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this, 0L, vector3i, f);
        }
        throw new NullPointerException();
    }

    public boolean getCarPos(Vector3i vector3i, float[] fArr, float[] fArr2) {
        return $explicit_getCarPos(vector3i, fArr, fArr2);
    }

    public boolean $explicit_getCarPos(Vector3i vector3i, float[] fArr, float[] fArr2) {
        if (this.swigCPtr != 0) {
            return getClass() == RctRouteLayerItemImpl.class ? getCarPosNative(this.swigCPtr, this, 0L, vector3i, fArr, fArr2) : getCarPosSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this, 0L, vector3i, fArr, fArr2);
        }
        throw new NullPointerException();
    }

    public void startNavi() {
        $explicit_startNavi();
    }

    public void $explicit_startNavi() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RctRouteLayerItemImpl.class) {
            startNaviNative(this.swigCPtr, this);
        } else {
            startNaviSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void pauseNavi() {
        $explicit_pauseNavi();
    }

    public void $explicit_pauseNavi() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RctRouteLayerItemImpl.class) {
            pauseNaviNative(this.swigCPtr, this);
        } else {
            pauseNaviSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void resumeNavi() {
        $explicit_resumeNavi();
    }

    public void $explicit_resumeNavi() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RctRouteLayerItemImpl.class) {
            resumeNaviNative(this.swigCPtr, this);
        } else {
            resumeNaviSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void stopNavi() {
        $explicit_stopNavi();
    }

    public void $explicit_stopNavi() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RctRouteLayerItemImpl.class) {
            stopNaviNative(this.swigCPtr, this);
        } else {
            stopNaviSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this);
        }
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void updateStyle() {
        $explicit_updateStyle();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_updateStyle() {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RctRouteLayerItemImpl.class) {
            updateStyleNative(this.swigCPtr, this);
        } else {
            updateStyleSwigExplicitRctRouteLayerItemImplNative(this.swigCPtr, this);
        }
    }

    public void showRtcSkeleton(boolean z) {
        $explicit_showRtcSkeleton(z);
    }

    public void $explicit_showRtcSkeleton(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showRtcSkeletonNative(j, this, z);
    }

    public void showRtcArrow3D(boolean z) {
        $explicit_showRtcArrow3D(z);
    }

    public void $explicit_showRtcArrow3D(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        showRtcArrow3DNative(j, this, z);
    }

    public void setRtcBinaryData(byte[] bArr) {
        $explicit_setRtcBinaryData(bArr);
    }

    public void $explicit_setRtcBinaryData(byte[] bArr) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setRtcBinaryDataNative(j, this, bArr);
    }
}
