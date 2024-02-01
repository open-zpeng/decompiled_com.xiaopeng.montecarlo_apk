package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.RestAreaInfo;
import com.autonavi.gbl.layer.RouteRestAreaLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteRestAreaLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RouteRestAreaLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteRestAreaLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteRestAreaLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteRestAreaLayerItemImpl_change_ownership(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, long j, boolean z);

    private static native void RouteRestAreaLayerItemImpl_director_connect(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, RestAreaInfo restAreaInfo);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native RestAreaInfo mRestAreaInfoGetNative(long j, RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl);

    private static native void mRestAreaInfoSetNative(long j, RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl, long j2, RestAreaInfo restAreaInfo);

    public RouteRestAreaLayerItemImpl(long j, boolean z) {
        super(RouteRestAreaLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteRestAreaLayerItemImpl) {
            return getUID(this) == getUID((RouteRestAreaLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        long cPtr = getCPtr(routeRestAreaLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteRestAreaLayerItemImpl routeRestAreaLayerItemImpl) {
        if (routeRestAreaLayerItemImpl == null) {
            return 0L;
        }
        return routeRestAreaLayerItemImpl.swigCPtr;
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
        RouteRestAreaLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteRestAreaLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteRestAreaLayerItemImpl(RestAreaInfo restAreaInfo) {
        this(createNativeObj(0L, restAreaInfo), true);
        LayerSvrJNI.swig_jni_init();
        RouteRestAreaLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMRestAreaInfo(RestAreaInfo restAreaInfo) {
        $explicit_setMRestAreaInfo(restAreaInfo);
    }

    public void $explicit_setMRestAreaInfo(RestAreaInfo restAreaInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mRestAreaInfoSetNative(j, this, 0L, restAreaInfo);
    }

    public RestAreaInfo getMRestAreaInfo() {
        return $explicit_getMRestAreaInfo();
    }

    public RestAreaInfo $explicit_getMRestAreaInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mRestAreaInfoGetNative(j, this);
    }
}
