package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.AvoidJamCloudControl;
import com.autonavi.gbl.layer.RouteJamPointLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteJamPointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RouteJamPointLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteJamPointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteJamPointLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteJamPointLayerItemImpl_change_ownership(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, long j, boolean z);

    private static native void RouteJamPointLayerItemImpl_director_connect(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, AvoidJamCloudControl avoidJamCloudControl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native AvoidJamCloudControl mAvoidJamCloudGetNative(long j, RouteJamPointLayerItemImpl routeJamPointLayerItemImpl);

    private static native void mAvoidJamCloudSetNative(long j, RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, long j2, AvoidJamCloudControl avoidJamCloudControl);

    private static native boolean mbEnableCollisionGetNative(long j, RouteJamPointLayerItemImpl routeJamPointLayerItemImpl);

    private static native void mbEnableCollisionSetNative(long j, RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, boolean z);

    private static native void onVisibleNative(long j, RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, boolean z);

    private static native void onVisibleSwigExplicitRouteJamPointLayerItemImplNative(long j, RouteJamPointLayerItemImpl routeJamPointLayerItemImpl, boolean z);

    public RouteJamPointLayerItemImpl(long j, boolean z) {
        super(RouteJamPointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteJamPointLayerItemImpl) {
            return getUID(this) == getUID((RouteJamPointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        long cPtr = getCPtr(routeJamPointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteJamPointLayerItemImpl routeJamPointLayerItemImpl) {
        if (routeJamPointLayerItemImpl == null) {
            return 0L;
        }
        return routeJamPointLayerItemImpl.swigCPtr;
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
        RouteJamPointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteJamPointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteJamPointLayerItemImpl(AvoidJamCloudControl avoidJamCloudControl) {
        this(createNativeObj(0L, avoidJamCloudControl), true);
        LayerSvrJNI.swig_jni_init();
        RouteJamPointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
        if (getClass() == RouteJamPointLayerItemImpl.class) {
            onVisibleNative(this.swigCPtr, this, z);
        } else {
            onVisibleSwigExplicitRouteJamPointLayerItemImplNative(this.swigCPtr, this, z);
        }
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMAvoidJamCloud(AvoidJamCloudControl avoidJamCloudControl) {
        $explicit_setMAvoidJamCloud(avoidJamCloudControl);
    }

    public void $explicit_setMAvoidJamCloud(AvoidJamCloudControl avoidJamCloudControl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mAvoidJamCloudSetNative(j, this, 0L, avoidJamCloudControl);
    }

    public AvoidJamCloudControl getMAvoidJamCloud() {
        return $explicit_getMAvoidJamCloud();
    }

    public AvoidJamCloudControl $explicit_getMAvoidJamCloud() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mAvoidJamCloudGetNative(j, this);
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
