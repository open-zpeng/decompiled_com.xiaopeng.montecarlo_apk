package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.CustomPlaneLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = CustomPlaneLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CustomPlaneLayerItemImpl extends RasterImageLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomPlaneLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long CustomPlaneLayerItemImpl_SWIGUpcast(long j);

    private static native void CustomPlaneLayerItemImpl_change_ownership(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, long j, boolean z);

    private static native void CustomPlaneLayerItemImpl_director_connect(CustomPlaneLayerItemImpl customPlaneLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mTypeGetNative(long j, CustomPlaneLayerItemImpl customPlaneLayerItemImpl);

    private static native void mTypeSetNative(long j, CustomPlaneLayerItemImpl customPlaneLayerItemImpl, int i);

    private static native String mValueGetNative(long j, CustomPlaneLayerItemImpl customPlaneLayerItemImpl);

    private static native void mValueSetNative(long j, CustomPlaneLayerItemImpl customPlaneLayerItemImpl, String str);

    public CustomPlaneLayerItemImpl(long j, boolean z) {
        super(CustomPlaneLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CustomPlaneLayerItemImpl) {
            return getUID(this) == getUID((CustomPlaneLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        long cPtr = getCPtr(customPlaneLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CustomPlaneLayerItemImpl customPlaneLayerItemImpl) {
        if (customPlaneLayerItemImpl == null) {
            return 0L;
        }
        return customPlaneLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        CustomPlaneLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.RasterImageLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CustomPlaneLayerItemImpl_change_ownership(this, this.swigCPtr, true);
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

    public CustomPlaneLayerItemImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        CustomPlaneLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }
}
