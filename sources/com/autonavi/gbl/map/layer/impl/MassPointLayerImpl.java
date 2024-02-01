package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.creflex.BaseLayerCRfxProto;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.MassPointLayer;
@IntfAuto(enableCRfx = true, protoOfCRfx = BaseLayerCRfxProto.class, target = MassPointLayer.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class MassPointLayerImpl extends BaseLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(MassPointLayerImpl.class);
    private transient long swigCPtr;

    private static native long MassPointLayerImpl_SWIGUpcast(long j);

    private static native void MassPointLayerImpl_change_ownership(MassPointLayerImpl massPointLayerImpl, long j, boolean z);

    private static native void MassPointLayerImpl_director_connect(MassPointLayerImpl massPointLayerImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(String str, long j, IMapViewImpl iMapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native void enableAngleOfCenterChangedNative(long j, MassPointLayerImpl massPointLayerImpl, long j2);

    private static native void enableLengthOfCenterChangedNative(long j, MassPointLayerImpl massPointLayerImpl, long j2);

    private static native void enableMoveOfCenterChangedNative(long j, MassPointLayerImpl massPointLayerImpl, boolean z);

    private static native String getClassTypeNameNative();

    private static native void recalculateAllItemsCollisionNative(long j, MassPointLayerImpl massPointLayerImpl);

    public MassPointLayerImpl(long j, boolean z) {
        super(MassPointLayerImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof MassPointLayerImpl) {
            return getUID(this) == getUID((MassPointLayerImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(MassPointLayerImpl massPointLayerImpl) {
        long cPtr = getCPtr(massPointLayerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(MassPointLayerImpl massPointLayerImpl) {
        if (massPointLayerImpl == null) {
            return 0L;
        }
        return massPointLayerImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        MassPointLayerImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        MassPointLayerImpl_change_ownership(this, this.swigCPtr, true);
    }

    public MassPointLayerImpl(String str, IMapViewImpl iMapViewImpl) {
        this(createNativeObj(str, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl), true);
        MapLayerSvrJNI.swig_jni_init();
        MassPointLayerImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void enableLengthOfCenterChanged(long j) {
        $explicit_enableLengthOfCenterChanged(j);
    }

    public void $explicit_enableLengthOfCenterChanged(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        enableLengthOfCenterChangedNative(j2, this, j);
    }

    public void enableAngleOfCenterChanged(long j) {
        $explicit_enableAngleOfCenterChanged(j);
    }

    public void $explicit_enableAngleOfCenterChanged(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        enableAngleOfCenterChangedNative(j2, this, j);
    }

    public void enableMoveOfCenterChanged(boolean z) {
        $explicit_enableMoveOfCenterChanged(z);
    }

    public void $explicit_enableMoveOfCenterChanged(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableMoveOfCenterChangedNative(j, this, z);
    }

    public void recalculateAllItemsCollision() {
        $explicit_recalculateAllItemsCollision();
    }

    public void $explicit_recalculateAllItemsCollision() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        recalculateAllItemsCollisionNative(j, this);
    }
}
