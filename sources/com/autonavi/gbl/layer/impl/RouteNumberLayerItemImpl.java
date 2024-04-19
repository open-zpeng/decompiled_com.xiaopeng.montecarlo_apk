package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.RouteNumberLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteNumberLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class RouteNumberLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteNumberLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteNumberLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteNumberLayerItemImpl_change_ownership(RouteNumberLayerItemImpl routeNumberLayerItemImpl, long j, boolean z);

    private static native void RouteNumberLayerItemImpl_director_connect(RouteNumberLayerItemImpl routeNumberLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(boolean z, int i);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native boolean isSelectedPathGetNative(long j, RouteNumberLayerItemImpl routeNumberLayerItemImpl);

    private static native void isSelectedPathSetNative(long j, RouteNumberLayerItemImpl routeNumberLayerItemImpl, boolean z);

    private static native long pathIDGetNative(long j, RouteNumberLayerItemImpl routeNumberLayerItemImpl);

    private static native void pathIDSetNative(long j, RouteNumberLayerItemImpl routeNumberLayerItemImpl, long j2);

    private static native int routeNumberIdGetNative(long j, RouteNumberLayerItemImpl routeNumberLayerItemImpl);

    private static native void routeNumberIdSetNative(long j, RouteNumberLayerItemImpl routeNumberLayerItemImpl, int i);

    public RouteNumberLayerItemImpl(long j, boolean z) {
        super(RouteNumberLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteNumberLayerItemImpl) {
            return getUID(this) == getUID((RouteNumberLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        long cPtr = getCPtr(routeNumberLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteNumberLayerItemImpl routeNumberLayerItemImpl) {
        if (routeNumberLayerItemImpl == null) {
            return 0L;
        }
        return routeNumberLayerItemImpl.swigCPtr;
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
        RouteNumberLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteNumberLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteNumberLayerItemImpl(boolean z, int i) {
        this(createNativeObj(z, i), true);
        LayerSvrJNI.swig_jni_init();
        RouteNumberLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setIsSelectedPath(boolean z) {
        $explicit_setIsSelectedPath(z);
    }

    public void $explicit_setIsSelectedPath(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        isSelectedPathSetNative(j, this, z);
    }

    public boolean getIsSelectedPath() {
        return $explicit_getIsSelectedPath();
    }

    public boolean $explicit_getIsSelectedPath() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isSelectedPathGetNative(j, this);
    }

    public void setRouteNumberId(int i) {
        $explicit_setRouteNumberId(i);
    }

    public void $explicit_setRouteNumberId(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        routeNumberIdSetNative(j, this, i);
    }

    public int getRouteNumberId() {
        return $explicit_getRouteNumberId();
    }

    public int $explicit_getRouteNumberId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return routeNumberIdGetNative(j, this);
    }

    public void setPathID(long j) {
        $explicit_setPathID(j);
    }

    public void $explicit_setPathID(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        pathIDSetNative(j2, this, j);
    }

    public long getPathID() {
        return $explicit_getPathID();
    }

    public long $explicit_getPathID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return pathIDGetNative(j, this);
    }
}
