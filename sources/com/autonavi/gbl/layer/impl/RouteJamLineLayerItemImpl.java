package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.model.AvoidJamCloudControl;
import com.autonavi.gbl.layer.RouteJamLineLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.LineLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteJamLineLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class RouteJamLineLayerItemImpl extends LineLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteJamLineLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteJamLineLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteJamLineLayerItemImpl_change_ownership(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, long j, boolean z);

    private static native void RouteJamLineLayerItemImpl_director_connect(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, AvoidJamCloudControl avoidJamCloudControl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native AvoidJamCloudControl mAvoidJamCloudGetNative(long j, RouteJamLineLayerItemImpl routeJamLineLayerItemImpl);

    private static native void mAvoidJamCloudSetNative(long j, RouteJamLineLayerItemImpl routeJamLineLayerItemImpl, long j2, AvoidJamCloudControl avoidJamCloudControl);

    public RouteJamLineLayerItemImpl(long j, boolean z) {
        super(RouteJamLineLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteJamLineLayerItemImpl) {
            return getUID(this) == getUID((RouteJamLineLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        long cPtr = getCPtr(routeJamLineLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteJamLineLayerItemImpl routeJamLineLayerItemImpl) {
        if (routeJamLineLayerItemImpl == null) {
            return 0L;
        }
        return routeJamLineLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        RouteJamLineLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.LineLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteJamLineLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteJamLineLayerItemImpl(AvoidJamCloudControl avoidJamCloudControl) {
        this(createNativeObj(0L, avoidJamCloudControl), true);
        LayerSvrJNI.swig_jni_init();
        RouteJamLineLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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
}
