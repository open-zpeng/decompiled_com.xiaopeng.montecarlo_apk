package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.ViaRoadInfo;
import com.autonavi.gbl.layer.RouteViaRoadLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteViaRoadLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RouteViaRoadLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteViaRoadLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteViaRoadLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteViaRoadLayerItemImpl_change_ownership(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, long j, boolean z);

    private static native void RouteViaRoadLayerItemImpl_director_connect(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, ViaRoadInfo viaRoadInfo, int i);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mDirectionStyleGetNative(long j, RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl);

    private static native void mDirectionStyleSetNative(long j, RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, int i);

    private static native ViaRoadInfo mViaRoadInfoGetNative(long j, RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl);

    private static native void mViaRoadInfoSetNative(long j, RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl, long j2, ViaRoadInfo viaRoadInfo);

    public RouteViaRoadLayerItemImpl(long j, boolean z) {
        super(RouteViaRoadLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteViaRoadLayerItemImpl) {
            return getUID(this) == getUID((RouteViaRoadLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        long cPtr = getCPtr(routeViaRoadLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteViaRoadLayerItemImpl routeViaRoadLayerItemImpl) {
        if (routeViaRoadLayerItemImpl == null) {
            return 0L;
        }
        return routeViaRoadLayerItemImpl.swigCPtr;
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
        RouteViaRoadLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteViaRoadLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteViaRoadLayerItemImpl(ViaRoadInfo viaRoadInfo, @BizDirectionStyle.BizDirectionStyle1 int i) {
        this(createNativeObj(0L, viaRoadInfo, i), true);
        LayerSvrJNI.swig_jni_init();
        RouteViaRoadLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMViaRoadInfo(ViaRoadInfo viaRoadInfo) {
        $explicit_setMViaRoadInfo(viaRoadInfo);
    }

    public void $explicit_setMViaRoadInfo(ViaRoadInfo viaRoadInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mViaRoadInfoSetNative(j, this, 0L, viaRoadInfo);
    }

    public ViaRoadInfo getMViaRoadInfo() {
        return $explicit_getMViaRoadInfo();
    }

    public ViaRoadInfo $explicit_getMViaRoadInfo() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mViaRoadInfoGetNative(j, this);
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        $explicit_setMDirectionStyle(i);
    }

    public void $explicit_setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDirectionStyleSetNative(j, this, i);
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        return $explicit_getMDirectionStyle();
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int $explicit_getMDirectionStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDirectionStyleGetNative(j, this);
    }
}
