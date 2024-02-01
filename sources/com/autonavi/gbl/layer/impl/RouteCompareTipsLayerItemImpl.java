package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.RouteCompareTipsLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteCompareTipsLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RouteCompareTipsLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteCompareTipsLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteCompareTipsLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteCompareTipsLayerItemImpl_change_ownership(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, long j, boolean z);

    private static native void RouteCompareTipsLayerItemImpl_director_connect(RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, long j);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native boolean mIsFasterGetNative(long j, RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl);

    private static native void mIsFasterSetNative(long j, RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, boolean z);

    private static native String mLabelContentGetNative(long j, RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl);

    private static native void mLabelContentSetNative(long j, RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, String str);

    private static native int mTravelTimeDiffGetNative(long j, RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl);

    private static native void mTravelTimeDiffSetNative(long j, RouteCompareTipsLayerItemImpl routeCompareTipsLayerItemImpl, int i);

    public RouteCompareTipsLayerItemImpl(long j, boolean z) {
        super(RouteCompareTipsLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        RouteCompareTipsLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteCompareTipsLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteCompareTipsLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerSvrJNI.swig_jni_init();
        RouteCompareTipsLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMLabelContent(String str) {
        $explicit_setMLabelContent(str);
    }

    public void $explicit_setMLabelContent(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLabelContentSetNative(j, this, str);
    }

    public String getMLabelContent() {
        return $explicit_getMLabelContent();
    }

    public String $explicit_getMLabelContent() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLabelContentGetNative(j, this);
    }

    public void setMTravelTimeDiff(int i) {
        $explicit_setMTravelTimeDiff(i);
    }

    public void $explicit_setMTravelTimeDiff(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTravelTimeDiffSetNative(j, this, i);
    }

    public int getMTravelTimeDiff() {
        return $explicit_getMTravelTimeDiff();
    }

    public int $explicit_getMTravelTimeDiff() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTravelTimeDiffGetNative(j, this);
    }

    public void setMIsFaster(boolean z) {
        $explicit_setMIsFaster(z);
    }

    public void $explicit_setMIsFaster(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mIsFasterSetNative(j, this, z);
    }

    public boolean getMIsFaster() {
        return $explicit_getMIsFaster();
    }

    public boolean $explicit_getMIsFaster() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mIsFasterGetNative(j, this);
    }
}
