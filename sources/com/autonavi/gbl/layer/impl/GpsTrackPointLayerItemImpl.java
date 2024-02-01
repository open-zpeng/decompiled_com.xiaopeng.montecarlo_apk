package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.GpsTrackPointLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizGpsPointType;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GpsTrackPointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class GpsTrackPointLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GpsTrackPointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GpsTrackPointLayerItemImpl_SWIGUpcast(long j);

    private static native void GpsTrackPointLayerItemImpl_change_ownership(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, long j, boolean z);

    private static native void GpsTrackPointLayerItemImpl_director_connect(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mGpsPointTypeGetNative(long j, GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl);

    private static native void mGpsPointTypeSetNative(long j, GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl, int i);

    public GpsTrackPointLayerItemImpl(long j, boolean z) {
        super(GpsTrackPointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof GpsTrackPointLayerItemImpl) {
            return getUID(this) == getUID((GpsTrackPointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        long cPtr = getCPtr(gpsTrackPointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GpsTrackPointLayerItemImpl gpsTrackPointLayerItemImpl) {
        if (gpsTrackPointLayerItemImpl == null) {
            return 0L;
        }
        return gpsTrackPointLayerItemImpl.swigCPtr;
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
        GpsTrackPointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GpsTrackPointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void setMGpsPointType(@BizGpsPointType.BizGpsPointType1 int i) {
        $explicit_setMGpsPointType(i);
    }

    public void $explicit_setMGpsPointType(@BizGpsPointType.BizGpsPointType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mGpsPointTypeSetNative(j, this, i);
    }

    @BizGpsPointType.BizGpsPointType1
    public int getMGpsPointType() {
        return $explicit_getMGpsPointType();
    }

    @BizGpsPointType.BizGpsPointType1
    public int $explicit_getMGpsPointType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mGpsPointTypeGetNative(j, this);
    }

    public GpsTrackPointLayerItemImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        GpsTrackPointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }
}
