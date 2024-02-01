package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.CustomCircleLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = CustomCircleLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CustomCircleLayerItemImpl extends SectorLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomCircleLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long CustomCircleLayerItemImpl_SWIGUpcast(long j);

    private static native void CustomCircleLayerItemImpl_change_ownership(CustomCircleLayerItemImpl customCircleLayerItemImpl, long j, boolean z);

    private static native void CustomCircleLayerItemImpl_director_connect(CustomCircleLayerItemImpl customCircleLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mTypeGetNative(long j, CustomCircleLayerItemImpl customCircleLayerItemImpl);

    private static native void mTypeSetNative(long j, CustomCircleLayerItemImpl customCircleLayerItemImpl, int i);

    private static native String mValueGetNative(long j, CustomCircleLayerItemImpl customCircleLayerItemImpl);

    private static native void mValueSetNative(long j, CustomCircleLayerItemImpl customCircleLayerItemImpl, String str);

    public CustomCircleLayerItemImpl(long j, boolean z) {
        super(CustomCircleLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CustomCircleLayerItemImpl) {
            return getUID(this) == getUID((CustomCircleLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        long cPtr = getCPtr(customCircleLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CustomCircleLayerItemImpl customCircleLayerItemImpl) {
        if (customCircleLayerItemImpl == null) {
            return 0L;
        }
        return customCircleLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        CustomCircleLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.SectorLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CustomCircleLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public void setMType(int i) {
        $explicit_setMType(i);
    }

    public void $explicit_setMType(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTypeSetNative(j, this, i);
    }

    public int getMType() {
        return $explicit_getMType();
    }

    public int $explicit_getMType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTypeGetNative(j, this);
    }

    public void setMValue(String str) {
        $explicit_setMValue(str);
    }

    public void $explicit_setMValue(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mValueSetNative(j, this, str);
    }

    public String getMValue() {
        return $explicit_getMValue();
    }

    public String $explicit_getMValue() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mValueGetNative(j, this);
    }

    public CustomCircleLayerItemImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        CustomCircleLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }
}
