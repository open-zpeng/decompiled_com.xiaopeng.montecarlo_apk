package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.ForbiddenCloudControl;
import com.autonavi.gbl.layer.RouteForbiddenLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RouteForbiddenLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class RouteForbiddenLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RouteForbiddenLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RouteForbiddenLayerItemImpl_SWIGUpcast(long j);

    private static native void RouteForbiddenLayerItemImpl_change_ownership(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, long j, boolean z);

    private static native void RouteForbiddenLayerItemImpl_director_connect(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, ForbiddenCloudControl forbiddenCloudControl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native ForbiddenCloudControl mForbiddenCloudGetNative(long j, RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl);

    private static native void mForbiddenCloudSetNative(long j, RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl, long j2, ForbiddenCloudControl forbiddenCloudControl);

    public RouteForbiddenLayerItemImpl(long j, boolean z) {
        super(RouteForbiddenLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof RouteForbiddenLayerItemImpl) {
            return getUID(this) == getUID((RouteForbiddenLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        long cPtr = getCPtr(routeForbiddenLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RouteForbiddenLayerItemImpl routeForbiddenLayerItemImpl) {
        if (routeForbiddenLayerItemImpl == null) {
            return 0L;
        }
        return routeForbiddenLayerItemImpl.swigCPtr;
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
        RouteForbiddenLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RouteForbiddenLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RouteForbiddenLayerItemImpl(ForbiddenCloudControl forbiddenCloudControl) {
        this(createNativeObj(0L, forbiddenCloudControl), true);
        LayerSvrJNI.swig_jni_init();
        RouteForbiddenLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMForbiddenCloud(ForbiddenCloudControl forbiddenCloudControl) {
        $explicit_setMForbiddenCloud(forbiddenCloudControl);
    }

    public void $explicit_setMForbiddenCloud(ForbiddenCloudControl forbiddenCloudControl) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mForbiddenCloudSetNative(j, this, 0L, forbiddenCloudControl);
    }

    public ForbiddenCloudControl getMForbiddenCloud() {
        return $explicit_getMForbiddenCloud();
    }

    public ForbiddenCloudControl $explicit_getMForbiddenCloud() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mForbiddenCloudGetNative(j, this);
    }
}
