package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.EnergyKeyPointLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = EnergyKeyPointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class EnergyKeyPointLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(EnergyKeyPointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long EnergyKeyPointLayerItemImpl_SWIGUpcast(long j);

    private static native void EnergyKeyPointLayerItemImpl_change_ownership(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, long j, boolean z);

    private static native void EnergyKeyPointLayerItemImpl_director_connect(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(float f);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native float mKeyPercentGetNative(long j, EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl);

    private static native void mKeyPercentSetNative(long j, EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl, float f);

    public EnergyKeyPointLayerItemImpl(long j, boolean z) {
        super(EnergyKeyPointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof EnergyKeyPointLayerItemImpl) {
            return getUID(this) == getUID((EnergyKeyPointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        long cPtr = getCPtr(energyKeyPointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(EnergyKeyPointLayerItemImpl energyKeyPointLayerItemImpl) {
        if (energyKeyPointLayerItemImpl == null) {
            return 0L;
        }
        return energyKeyPointLayerItemImpl.swigCPtr;
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
        EnergyKeyPointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        EnergyKeyPointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public EnergyKeyPointLayerItemImpl(float f) {
        this(createNativeObj(f), true);
        LayerSvrJNI.swig_jni_init();
        EnergyKeyPointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMKeyPercent(float f) {
        $explicit_setMKeyPercent(f);
    }

    public void $explicit_setMKeyPercent(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mKeyPercentSetNative(j, this, f);
    }

    public float getMKeyPercent() {
        return $explicit_getMKeyPercent();
    }

    public float $explicit_getMKeyPercent() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mKeyPercentGetNative(j, this);
    }
}
