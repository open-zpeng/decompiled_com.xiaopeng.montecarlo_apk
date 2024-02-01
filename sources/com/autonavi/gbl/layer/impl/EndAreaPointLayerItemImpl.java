package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.EndAreaPointLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = EndAreaPointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class EndAreaPointLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(EndAreaPointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long EndAreaPointLayerItemImpl_SWIGUpcast(long j);

    private static native void EndAreaPointLayerItemImpl_change_ownership(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, long j, boolean z);

    private static native void EndAreaPointLayerItemImpl_director_connect(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(String str, int i);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native String mPoiNameGetNative(long j, EndAreaPointLayerItemImpl endAreaPointLayerItemImpl);

    private static native void mPoiNameSetNative(long j, EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, String str);

    private static native int mPoiTypeGetNative(long j, EndAreaPointLayerItemImpl endAreaPointLayerItemImpl);

    private static native void mPoiTypeSetNative(long j, EndAreaPointLayerItemImpl endAreaPointLayerItemImpl, int i);

    public EndAreaPointLayerItemImpl(long j, boolean z) {
        super(EndAreaPointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof EndAreaPointLayerItemImpl) {
            return getUID(this) == getUID((EndAreaPointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        long cPtr = getCPtr(endAreaPointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(EndAreaPointLayerItemImpl endAreaPointLayerItemImpl) {
        if (endAreaPointLayerItemImpl == null) {
            return 0L;
        }
        return endAreaPointLayerItemImpl.swigCPtr;
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
        EndAreaPointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        EndAreaPointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public EndAreaPointLayerItemImpl(String str, int i) {
        this(createNativeObj(str, i), true);
        LayerSvrJNI.swig_jni_init();
        EndAreaPointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMPoiName(String str) {
        $explicit_setMPoiName(str);
    }

    public void $explicit_setMPoiName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mPoiNameSetNative(j, this, str);
    }

    public String getMPoiName() {
        return $explicit_getMPoiName();
    }

    public String $explicit_getMPoiName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPoiNameGetNative(j, this);
    }

    public void setMPoiType(int i) {
        $explicit_setMPoiType(i);
    }

    public void $explicit_setMPoiType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mPoiTypeSetNative(j, this, i);
    }

    public int getMPoiType() {
        return $explicit_getMPoiType();
    }

    public int $explicit_getMPoiType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPoiTypeGetNative(j, this);
    }
}
