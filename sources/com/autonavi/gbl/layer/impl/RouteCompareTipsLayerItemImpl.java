package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.RouteCompareTipsLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteCompareTipsLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class RouteCompareTipsLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteCompareTipsLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteCompareTipsLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteCompareTipsLayerItemImpl_change_ownership(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, long j, boolean z);

    private static native void RouteCompareTipsLayerItemImpl_director_connect(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(boolean z, String str);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native boolean mIsNewRouteGetNative(long j, RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl);

    private static native void mIsNewRouteSetNative(long j, RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, boolean z);

    private static native String mTipNameGetNative(long j, RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl);

    private static native void mTipNameSetNative(long j, RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, String str);

    public RouteCompareTipsLayerItemImpl(long j, boolean z) {
        super(RouteCompareTipsLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteCompareTipsLayerItemImpl) {
            return getUID(this) == getUID((RouteCompareTipsLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        long cPtr = getCPtr(routeCompareTipsLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl) {
        if (routeCompareTipsLayerItemImpl == null) {
            return 0L;
        }
        return routeCompareTipsLayerItemImpl.swigCPtr;
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
        RouteCompareTipsLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteCompareTipsLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteCompareTipsLayerItemImpl(boolean z, String str) {
        this(createNativeObj(z, str), true);
        LayerSvrJNI.swig_jni_init();
        RouteCompareTipsLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMIsNewRoute(boolean z) {
        $explicit_setMIsNewRoute(z);
    }

    public void $explicit_setMIsNewRoute(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mIsNewRouteSetNative(j, this, z);
    }

    public boolean getMIsNewRoute() {
        return $explicit_getMIsNewRoute();
    }

    public boolean $explicit_getMIsNewRoute() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mIsNewRouteGetNative(j, this);
    }

    public void setMTipName(String str) {
        $explicit_setMTipName(str);
    }

    public void $explicit_setMTipName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTipNameSetNative(j, this, str);
    }

    public String getMTipName() {
        return $explicit_getMTipName();
    }

    public String $explicit_getMTipName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTipNameGetNative(j, this);
    }
}
