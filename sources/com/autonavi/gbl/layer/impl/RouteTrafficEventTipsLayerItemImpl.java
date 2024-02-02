package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.RouteTrafficEventTipsLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.RouteTrafficEventTipsPoint;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteTrafficEventTipsLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class RouteTrafficEventTipsLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteTrafficEventTipsLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteTrafficEventTipsLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteTrafficEventTipsLayerItemImpl_change_ownership(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, long j, boolean z);

    private static native void RouteTrafficEventTipsLayerItemImpl_director_connect(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, RouteTrafficEventTipsPoint routeTrafficEventTipsPoint);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native RouteTrafficEventTipsPoint mTrafficEventTipsInfoGetNative(long j, RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl);

    private static native void mTrafficEventTipsInfoSetNative(long j, RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl, long j2, RouteTrafficEventTipsPoint routeTrafficEventTipsPoint);

    public RouteTrafficEventTipsLayerItemImpl(long j, boolean z) {
        super(RouteTrafficEventTipsLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteTrafficEventTipsLayerItemImpl) {
            return getUID(this) == getUID((RouteTrafficEventTipsLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        long cPtr = getCPtr(routeTrafficEventTipsLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteTrafficEventTipsLayerItemImpl routeTrafficEventTipsLayerItemImpl) {
        if (routeTrafficEventTipsLayerItemImpl == null) {
            return 0L;
        }
        return routeTrafficEventTipsLayerItemImpl.swigCPtr;
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
        RouteTrafficEventTipsLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteTrafficEventTipsLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteTrafficEventTipsLayerItemImpl(RouteTrafficEventTipsPoint routeTrafficEventTipsPoint) {
        this(createNativeObj(0L, routeTrafficEventTipsPoint), true);
        LayerSvrJNI.swig_jni_init();
        RouteTrafficEventTipsLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMTrafficEventTipsInfo(RouteTrafficEventTipsPoint routeTrafficEventTipsPoint) {
        $explicit_setMTrafficEventTipsInfo(routeTrafficEventTipsPoint);
    }

    public void $explicit_setMTrafficEventTipsInfo(RouteTrafficEventTipsPoint routeTrafficEventTipsPoint) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTrafficEventTipsInfoSetNative(j, this, 0L, routeTrafficEventTipsPoint);
    }

    public RouteTrafficEventTipsPoint getMTrafficEventTipsInfo() {
        return $explicit_getMTrafficEventTipsInfo();
    }

    public RouteTrafficEventTipsPoint $explicit_getMTrafficEventTipsInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTrafficEventTipsInfoGetNative(j, this);
    }
}
