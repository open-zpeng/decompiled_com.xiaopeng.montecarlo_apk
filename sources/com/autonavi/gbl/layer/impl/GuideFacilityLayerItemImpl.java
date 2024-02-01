package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.path.model.FacilityType;
import com.autonavi.gbl.layer.GuideFacilityLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideFacilityLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class GuideFacilityLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideFacilityLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideFacilityLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideFacilityLayerItemImpl_change_ownership(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, long j, boolean z);

    private static native void GuideFacilityLayerItemImpl_director_connect(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mDistanceGetNative(long j, GuideFacilityLayerItemImpl guideFacilityLayerItemImpl);

    private static native void mDistanceSetNative(long j, GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, int i);

    private static native int mTypeGetNative(long j, GuideFacilityLayerItemImpl guideFacilityLayerItemImpl);

    private static native void mTypeSetNative(long j, GuideFacilityLayerItemImpl guideFacilityLayerItemImpl, int i);

    public GuideFacilityLayerItemImpl(long j, boolean z) {
        super(GuideFacilityLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideFacilityLayerItemImpl) {
            return getUID(this) == getUID((GuideFacilityLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        long cPtr = getCPtr(guideFacilityLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideFacilityLayerItemImpl guideFacilityLayerItemImpl) {
        if (guideFacilityLayerItemImpl == null) {
            return 0L;
        }
        return guideFacilityLayerItemImpl.swigCPtr;
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
        GuideFacilityLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideFacilityLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideFacilityLayerItemImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        GuideFacilityLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMDistance(int i) {
        $explicit_setMDistance(i);
    }

    public void $explicit_setMDistance(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDistanceSetNative(j, this, i);
    }

    public int getMDistance() {
        return $explicit_getMDistance();
    }

    public int $explicit_getMDistance() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDistanceGetNative(j, this);
    }

    public void setMType(@FacilityType.FacilityType1 int i) {
        $explicit_setMType(i);
    }

    public void $explicit_setMType(@FacilityType.FacilityType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTypeSetNative(j, this, i);
    }

    @FacilityType.FacilityType1
    public int getMType() {
        return $explicit_getMType();
    }

    @FacilityType.FacilityType1
    public int $explicit_getMType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTypeGetNative(j, this);
    }
}
