package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.RouteIndoorParkEndLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteIndoorParkEndLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class RouteIndoorParkEndLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteIndoorParkEndLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteIndoorParkEndLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteIndoorParkEndLayerItemImpl_change_ownership(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, long j, boolean z);

    private static native void RouteIndoorParkEndLayerItemImpl_director_connect(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native int floorNumberGetNative(long j, RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl);

    private static native void floorNumberSetNative(long j, RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl, int i);

    private static native String getClassTypeNameNative();

    public RouteIndoorParkEndLayerItemImpl(long j, boolean z) {
        super(RouteIndoorParkEndLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteIndoorParkEndLayerItemImpl) {
            return getUID(this) == getUID((RouteIndoorParkEndLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        long cPtr = getCPtr(routeIndoorParkEndLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteIndoorParkEndLayerItemImpl routeIndoorParkEndLayerItemImpl) {
        if (routeIndoorParkEndLayerItemImpl == null) {
            return 0L;
        }
        return routeIndoorParkEndLayerItemImpl.swigCPtr;
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
        RouteIndoorParkEndLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteIndoorParkEndLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteIndoorParkEndLayerItemImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        RouteIndoorParkEndLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setFloorNumber(int i) {
        $explicit_setFloorNumber(i);
    }

    public void $explicit_setFloorNumber(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        floorNumberSetNative(j, this, i);
    }

    public int getFloorNumber() {
        return $explicit_getFloorNumber();
    }

    public int $explicit_getFloorNumber() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return floorNumberGetNative(j, this);
    }
}
