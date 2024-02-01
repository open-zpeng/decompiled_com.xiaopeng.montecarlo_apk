package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.EventCloudControl;
import com.autonavi.gbl.layer.RouteBlockLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteBlockLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RouteBlockLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteBlockLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteBlockLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteBlockLayerItemImpl_change_ownership(RouteBlockLayerItemImpl routeBlockLayerItemImpl, long j, boolean z);

    private static native void RouteBlockLayerItemImpl_director_connect(RouteBlockLayerItemImpl routeBlockLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, EventCloudControl eventCloudControl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native EventCloudControl mEventCloudGetNative(long j, RouteBlockLayerItemImpl routeBlockLayerItemImpl);

    private static native void mEventCloudSetNative(long j, RouteBlockLayerItemImpl routeBlockLayerItemImpl, long j2, EventCloudControl eventCloudControl);

    private static native boolean mbEnableCollisionGetNative(long j, RouteBlockLayerItemImpl routeBlockLayerItemImpl);

    private static native void mbEnableCollisionSetNative(long j, RouteBlockLayerItemImpl routeBlockLayerItemImpl, boolean z);

    private static native void onVisibleNative(long j, RouteBlockLayerItemImpl routeBlockLayerItemImpl, boolean z);

    private static native void onVisibleSwigExplicitRouteBlockLayerItemImplNative(long j, RouteBlockLayerItemImpl routeBlockLayerItemImpl, boolean z);

    public RouteBlockLayerItemImpl(long j, boolean z) {
        super(RouteBlockLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteBlockLayerItemImpl) {
            return getUID(this) == getUID((RouteBlockLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        long cPtr = getCPtr(routeBlockLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteBlockLayerItemImpl routeBlockLayerItemImpl) {
        if (routeBlockLayerItemImpl == null) {
            return 0L;
        }
        return routeBlockLayerItemImpl.swigCPtr;
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
        RouteBlockLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteBlockLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteBlockLayerItemImpl(EventCloudControl eventCloudControl) {
        this(createNativeObj(0L, eventCloudControl), true);
        LayerSvrJNI.swig_jni_init();
        RouteBlockLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl
    public void onVisible(boolean z) {
        $explicit_onVisible(z);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LayerItemImpl
    public void $explicit_onVisible(boolean z) {
        if (this.swigCPtr == 0) {
            throw new NullPointerException();
        }
        if (getClass() == RouteBlockLayerItemImpl.class) {
            onVisibleNative(this.swigCPtr, this, z);
        } else {
            onVisibleSwigExplicitRouteBlockLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public void setMEventCloud(EventCloudControl eventCloudControl) {
        $explicit_setMEventCloud(eventCloudControl);
    }

    public void $explicit_setMEventCloud(EventCloudControl eventCloudControl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mEventCloudSetNative(j, this, 0L, eventCloudControl);
    }

    public EventCloudControl getMEventCloud() {
        return $explicit_getMEventCloud();
    }

    public EventCloudControl $explicit_getMEventCloud() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mEventCloudGetNative(j, this);
    }

    public void setMbEnableCollision(boolean z) {
        $explicit_setMbEnableCollision(z);
    }

    public void $explicit_setMbEnableCollision(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mbEnableCollisionSetNative(j, this, z);
    }

    public boolean getMbEnableCollision() {
        return $explicit_getMbEnableCollision();
    }

    public boolean $explicit_getMbEnableCollision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mbEnableCollisionGetNative(j, this);
    }
}
