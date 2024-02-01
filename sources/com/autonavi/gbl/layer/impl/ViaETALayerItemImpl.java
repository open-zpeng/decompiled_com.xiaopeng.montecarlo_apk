package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.ViaETALayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.ViaETADirection;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
import com.autonavi.gbl.map.layer.model.ViaETAPathPointType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = ViaETALayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ViaETALayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ViaETALayerItemImpl.class);
    private transient long swigCPtr;

    private static native long ViaETALayerItemImpl_SWIGUpcast(long j);

    private static native void ViaETALayerItemImpl_change_ownership(ViaETALayerItemImpl viaETALayerItemImpl, long j, boolean z);

    private static native void ViaETALayerItemImpl_director_connect(ViaETALayerItemImpl viaETALayerItemImpl, long j, boolean z, boolean z2);

    private static native short chargePercentGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void chargePercentSetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, short s);

    private static native int chargeTimeGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void chargeTimeSetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, int i);

    private static native long createNativeObj(int i, long j);

    private static native long createNativeObj1(int i);

    private static native void destroyNativeObj(long j);

    private static native int eTypeGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void eTypeSetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, int i);

    private static native String getClassTypeNameNative();

    private static native double leftEnergyPercentGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void leftEnergyPercentSetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, double d);

    private static native int mDirectionGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void mDirectionSetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, int i);

    private static native int mLeftEnergyGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void mLeftEnergySetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, int i);

    private static native long mTravelTimeGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void mTravelTimeSetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, long j2);

    private static native int viaIndexGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void viaIndexSetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, int i);

    public ViaETALayerItemImpl(long j, boolean z) {
        super(ViaETALayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof ViaETALayerItemImpl) {
            return getUID(this) == getUID((ViaETALayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(ViaETALayerItemImpl viaETALayerItemImpl) {
        long cPtr = getCPtr(viaETALayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ViaETALayerItemImpl viaETALayerItemImpl) {
        if (viaETALayerItemImpl == null) {
            return 0L;
        }
        return viaETALayerItemImpl.swigCPtr;
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
        ViaETALayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ViaETALayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ViaETALayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerSvrJNI.swig_jni_init();
        ViaETALayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public ViaETALayerItemImpl(@QuadrantType.QuadrantType1 int i) {
        this(createNativeObj1(i), true);
        LayerSvrJNI.swig_jni_init();
        ViaETALayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setViaIndex(int i) {
        $explicit_setViaIndex(i);
    }

    public void $explicit_setViaIndex(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        viaIndexSetNative(j, this, i);
    }

    public int getViaIndex() {
        return $explicit_getViaIndex();
    }

    public int $explicit_getViaIndex() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return viaIndexGetNative(j, this);
    }

    public void setEType(@ViaETAPathPointType.ViaETAPathPointType1 int i) {
        $explicit_setEType(i);
    }

    public void $explicit_setEType(@ViaETAPathPointType.ViaETAPathPointType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        eTypeSetNative(j, this, i);
    }

    @ViaETAPathPointType.ViaETAPathPointType1
    public int getEType() {
        return $explicit_getEType();
    }

    @ViaETAPathPointType.ViaETAPathPointType1
    public int $explicit_getEType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return eTypeGetNative(j, this);
    }

    public void setChargePercent(short s) {
        $explicit_setChargePercent(s);
    }

    public void $explicit_setChargePercent(short s) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        chargePercentSetNative(j, this, s);
    }

    public short getChargePercent() {
        return $explicit_getChargePercent();
    }

    public short $explicit_getChargePercent() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return chargePercentGetNative(j, this);
    }

    public void setChargeTime(int i) {
        $explicit_setChargeTime(i);
    }

    public void $explicit_setChargeTime(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        chargeTimeSetNative(j, this, i);
    }

    public int getChargeTime() {
        return $explicit_getChargeTime();
    }

    public int $explicit_getChargeTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return chargeTimeGetNative(j, this);
    }

    public void setMTravelTime(long j) {
        $explicit_setMTravelTime(j);
    }

    public void $explicit_setMTravelTime(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mTravelTimeSetNative(j2, this, j);
    }

    public long getMTravelTime() {
        return $explicit_getMTravelTime();
    }

    public long $explicit_getMTravelTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTravelTimeGetNative(j, this);
    }

    public void setMLeftEnergy(int i) {
        $explicit_setMLeftEnergy(i);
    }

    public void $explicit_setMLeftEnergy(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLeftEnergySetNative(j, this, i);
    }

    public int getMLeftEnergy() {
        return $explicit_getMLeftEnergy();
    }

    public int $explicit_getMLeftEnergy() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLeftEnergyGetNative(j, this);
    }

    public void setLeftEnergyPercent(double d) {
        $explicit_setLeftEnergyPercent(d);
    }

    public void $explicit_setLeftEnergyPercent(double d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        leftEnergyPercentSetNative(j, this, d);
    }

    public double getLeftEnergyPercent() {
        return $explicit_getLeftEnergyPercent();
    }

    public double $explicit_getLeftEnergyPercent() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return leftEnergyPercentGetNative(j, this);
    }

    public void setMDirection(@ViaETADirection.ViaETADirection1 int i) {
        $explicit_setMDirection(i);
    }

    public void $explicit_setMDirection(@ViaETADirection.ViaETADirection1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDirectionSetNative(j, this, i);
    }

    @ViaETADirection.ViaETADirection1
    public int getMDirection() {
        return $explicit_getMDirection();
    }

    @ViaETADirection.ViaETADirection1
    public int $explicit_getMDirection() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDirectionGetNative(j, this);
    }
}
