package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.RangeOnMapPolygonPointLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = RangeOnMapPolygonPointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class RangeOnMapPolygonPointLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(RangeOnMapPolygonPointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long RangeOnMapPolygonPointLayerItemImpl_SWIGUpcast(long j);

    private static native void RangeOnMapPolygonPointLayerItemImpl_change_ownership(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, long j, boolean z);

    private static native void RangeOnMapPolygonPointLayerItemImpl_director_connect(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(float f, String[] strArr);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native float mEnergyGetNative(long j, RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl);

    private static native void mEnergySetNative(long j, RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, float f);

    private static native String mRetainEnergyGetNative(long j, RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl);

    private static native void mRetainEnergySetNative(long j, RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl, String str);

    public RangeOnMapPolygonPointLayerItemImpl(long j, boolean z) {
        super(RangeOnMapPolygonPointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof RangeOnMapPolygonPointLayerItemImpl) {
            return getUID(this) == getUID((RangeOnMapPolygonPointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        long cPtr = getCPtr(rangeOnMapPolygonPointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(RangeOnMapPolygonPointLayerItemImpl rangeOnMapPolygonPointLayerItemImpl) {
        if (rangeOnMapPolygonPointLayerItemImpl == null) {
            return 0L;
        }
        return rangeOnMapPolygonPointLayerItemImpl.swigCPtr;
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
        RangeOnMapPolygonPointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        RangeOnMapPolygonPointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public RangeOnMapPolygonPointLayerItemImpl(float f, String[] strArr) {
        this(createNativeObj(f, strArr), true);
        LayerSvrJNI.swig_jni_init();
        RangeOnMapPolygonPointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMEnergy(float f) {
        $explicit_setMEnergy(f);
    }

    public void $explicit_setMEnergy(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mEnergySetNative(j, this, f);
    }

    public float getMEnergy() {
        return $explicit_getMEnergy();
    }

    public float $explicit_getMEnergy() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mEnergyGetNative(j, this);
    }

    public void setMRetainEnergy(String str) {
        $explicit_setMRetainEnergy(str);
    }

    public void $explicit_setMRetainEnergy(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mRetainEnergySetNative(j, this, str);
    }

    public String getMRetainEnergy() {
        return $explicit_getMRetainEnergy();
    }

    public String $explicit_getMRetainEnergy() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mRetainEnergyGetNative(j, this);
    }
}
