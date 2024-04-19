package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.ViaETALayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.ViaETADirection;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = ViaETALayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class ViaETALayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ViaETALayerItemImpl.class);
    private transient long swigCPtr;

    private static native long ViaETALayerItemImpl_SWIGUpcast(long j);

    private static native void ViaETALayerItemImpl_change_ownership(ViaETALayerItemImpl viaETALayerItemImpl, long j, boolean z);

    private static native void ViaETALayerItemImpl_director_connect(ViaETALayerItemImpl viaETALayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, long j);

    private static native long createNativeObj1(int i);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mDirectionGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void mDirectionSetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, int i);

    private static native int mLeftEnergyGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void mLeftEnergySetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, int i);

    private static native long mTravelTimeGetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl);

    private static native void mTravelTimeSetNative(long j, ViaETALayerItemImpl viaETALayerItemImpl, long j2);

    public ViaETALayerItemImpl(long j, boolean z) {
        super(ViaETALayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        ViaETALayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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
