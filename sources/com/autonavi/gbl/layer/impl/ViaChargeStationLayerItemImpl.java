package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.ViaChargeStationLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = ViaChargeStationLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class ViaChargeStationLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(ViaChargeStationLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long ViaChargeStationLayerItemImpl_SWIGUpcast(long j);

    private static native void ViaChargeStationLayerItemImpl_change_ownership(ViaChargeStationLayerItemImpl viaChargeStationLayerItemImpl, long j, boolean z);

    private static native void ViaChargeStationLayerItemImpl_director_connect(ViaChargeStationLayerItemImpl viaChargeStationLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(boolean z);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native boolean isEagleEyeGetNative(long j, ViaChargeStationLayerItemImpl viaChargeStationLayerItemImpl);

    private static native void isEagleEyeSetNative(long j, ViaChargeStationLayerItemImpl viaChargeStationLayerItemImpl, boolean z);

    public ViaChargeStationLayerItemImpl(long j, boolean z) {
        super(ViaChargeStationLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof ViaChargeStationLayerItemImpl) {
            return getUID(this) == getUID((ViaChargeStationLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(ViaChargeStationLayerItemImpl viaChargeStationLayerItemImpl) {
        long cPtr = getCPtr(viaChargeStationLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(ViaChargeStationLayerItemImpl viaChargeStationLayerItemImpl) {
        if (viaChargeStationLayerItemImpl == null) {
            return 0L;
        }
        return viaChargeStationLayerItemImpl.swigCPtr;
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
        ViaChargeStationLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ViaChargeStationLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public ViaChargeStationLayerItemImpl(boolean z) {
        this(createNativeObj(z), true);
        LayerSvrJNI.swig_jni_init();
        ViaChargeStationLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setIsEagleEye(boolean z) {
        $explicit_setIsEagleEye(z);
    }

    public void $explicit_setIsEagleEye(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        isEagleEyeSetNative(j, this, z);
    }

    public boolean getIsEagleEye() {
        return $explicit_getIsEagleEye();
    }

    public boolean $explicit_getIsEagleEye() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isEagleEyeGetNative(j, this);
    }
}
