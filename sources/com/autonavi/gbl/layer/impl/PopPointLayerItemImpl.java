package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.PopPointLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = PopPointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class PopPointLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PopPointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long PopPointLayerItemImpl_SWIGUpcast(long j);

    private static native void PopPointLayerItemImpl_change_ownership(PopPointLayerItemImpl popPointLayerItemImpl, long j, boolean z);

    private static native void PopPointLayerItemImpl_director_connect(PopPointLayerItemImpl popPointLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(String str);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native String mTextGetNative(long j, PopPointLayerItemImpl popPointLayerItemImpl);

    private static native void mTextSetNative(long j, PopPointLayerItemImpl popPointLayerItemImpl, String str);

    public PopPointLayerItemImpl(long j, boolean z) {
        super(PopPointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof PopPointLayerItemImpl) {
            return getUID(this) == getUID((PopPointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(PopPointLayerItemImpl popPointLayerItemImpl) {
        long cPtr = getCPtr(popPointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(PopPointLayerItemImpl popPointLayerItemImpl) {
        if (popPointLayerItemImpl == null) {
            return 0L;
        }
        return popPointLayerItemImpl.swigCPtr;
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
        PopPointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        PopPointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public PopPointLayerItemImpl(String str) {
        this(createNativeObj(str), true);
        LayerSvrJNI.swig_jni_init();
        PopPointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMText(String str) {
        $explicit_setMText(str);
    }

    public void $explicit_setMText(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mTextSetNative(j, this, str);
    }

    public String getMText() {
        return $explicit_getMText();
    }

    public String $explicit_getMText() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTextGetNative(j, this);
    }
}
