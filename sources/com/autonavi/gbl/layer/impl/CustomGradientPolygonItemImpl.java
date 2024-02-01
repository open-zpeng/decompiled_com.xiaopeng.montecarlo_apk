package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.CustomGradientPolygonItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = CustomGradientPolygonItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class CustomGradientPolygonItemImpl extends PolygonGradientItemImpl {
    private static BindTable BIND_TABLE = new BindTable(CustomGradientPolygonItemImpl.class);
    private transient long swigCPtr;

    private static native long CustomGradientPolygonItemImpl_SWIGUpcast(long j);

    private static native void CustomGradientPolygonItemImpl_change_ownership(CustomGradientPolygonItemImpl customGradientPolygonItemImpl, long j, boolean z);

    private static native void CustomGradientPolygonItemImpl_director_connect(CustomGradientPolygonItemImpl customGradientPolygonItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(long j, IMapViewImpl iMapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mTypeGetNative(long j, CustomGradientPolygonItemImpl customGradientPolygonItemImpl);

    private static native void mTypeSetNative(long j, CustomGradientPolygonItemImpl customGradientPolygonItemImpl, int i);

    private static native String mValueGetNative(long j, CustomGradientPolygonItemImpl customGradientPolygonItemImpl);

    private static native void mValueSetNative(long j, CustomGradientPolygonItemImpl customGradientPolygonItemImpl, String str);

    public CustomGradientPolygonItemImpl(long j, boolean z) {
        super(CustomGradientPolygonItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof CustomGradientPolygonItemImpl) {
            return getUID(this) == getUID((CustomGradientPolygonItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(CustomGradientPolygonItemImpl customGradientPolygonItemImpl) {
        long cPtr = getCPtr(customGradientPolygonItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(CustomGradientPolygonItemImpl customGradientPolygonItemImpl) {
        if (customGradientPolygonItemImpl == null) {
            return 0L;
        }
        return customGradientPolygonItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        CustomGradientPolygonItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PolygonGradientItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        CustomGradientPolygonItemImpl_change_ownership(this, this.swigCPtr, true);
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

    public CustomGradientPolygonItemImpl(IMapViewImpl iMapViewImpl) {
        this(createNativeObj(IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl), true);
        LayerSvrJNI.swig_jni_init();
        CustomGradientPolygonItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }
}
