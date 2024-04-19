package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.RouteIndoorParkLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteIndoorParkLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class RouteIndoorParkLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteIndoorParkLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteIndoorParkLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteIndoorParkLayerItemImpl_change_ownership(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, long j, boolean z);

    private static native void RouteIndoorParkLayerItemImpl_director_connect(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, long j, boolean z, boolean z2);

    private static native int boardStyleGetNative(long j, RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl);

    private static native void boardStyleSetNative(long j, RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, int i);

    private static native long createNativeObj(int i, long j);

    private static native int curFloorNumberGetNative(long j, RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl);

    private static native void curFloorNumberSetNative(long j, RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, int i);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native boolean isUpstairsGetNative(long j, RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl);

    private static native void isUpstairsSetNative(long j, RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, boolean z);

    private static native int toFloorNumberGetNative(long j, RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl);

    private static native void toFloorNumberSetNative(long j, RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl, int i);

    public RouteIndoorParkLayerItemImpl(long j, boolean z) {
        super(RouteIndoorParkLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteIndoorParkLayerItemImpl) {
            return getUID(this) == getUID((RouteIndoorParkLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        long cPtr = getCPtr(routeIndoorParkLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteIndoorParkLayerItemImpl routeIndoorParkLayerItemImpl) {
        if (routeIndoorParkLayerItemImpl == null) {
            return 0L;
        }
        return routeIndoorParkLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        RouteIndoorParkLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteIndoorParkLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteIndoorParkLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerSvrJNI.swig_jni_init();
        RouteIndoorParkLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setToFloorNumber(int i) {
        $explicit_setToFloorNumber(i);
    }

    public void $explicit_setToFloorNumber(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        toFloorNumberSetNative(j, this, i);
    }

    public int getToFloorNumber() {
        return $explicit_getToFloorNumber();
    }

    public int $explicit_getToFloorNumber() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return toFloorNumberGetNative(j, this);
    }

    public void setCurFloorNumber(int i) {
        $explicit_setCurFloorNumber(i);
    }

    public void $explicit_setCurFloorNumber(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        curFloorNumberSetNative(j, this, i);
    }

    public int getCurFloorNumber() {
        return $explicit_getCurFloorNumber();
    }

    public int $explicit_getCurFloorNumber() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return curFloorNumberGetNative(j, this);
    }

    public void setIsUpstairs(boolean z) {
        $explicit_setIsUpstairs(z);
    }

    public void $explicit_setIsUpstairs(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        isUpstairsSetNative(j, this, z);
    }

    public boolean getIsUpstairs() {
        return $explicit_getIsUpstairs();
    }

    public boolean $explicit_getIsUpstairs() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isUpstairsGetNative(j, this);
    }

    public void setBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        $explicit_setBoardStyle(i);
    }

    public void $explicit_setBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        boardStyleSetNative(j, this, i);
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int getBoardStyle() {
        return $explicit_getBoardStyle();
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int $explicit_getBoardStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return boardStyleGetNative(j, this);
    }
}
