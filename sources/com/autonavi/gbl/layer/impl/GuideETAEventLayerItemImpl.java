package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.GuideETAEventLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideETAEventLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class GuideETAEventLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideETAEventLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideETAEventLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideETAEventLayerItemImpl_change_ownership(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, long j, boolean z);

    private static native void GuideETAEventLayerItemImpl_director_connect(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mTypeGetNative(long j, GuideETAEventLayerItemImpl guideETAEventLayerItemImpl);

    private static native void mTypeSetNative(long j, GuideETAEventLayerItemImpl guideETAEventLayerItemImpl, int i);

    public GuideETAEventLayerItemImpl(long j, boolean z) {
        super(GuideETAEventLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideETAEventLayerItemImpl) {
            return getUID(this) == getUID((GuideETAEventLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        long cPtr = getCPtr(guideETAEventLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideETAEventLayerItemImpl guideETAEventLayerItemImpl) {
        if (guideETAEventLayerItemImpl == null) {
            return 0L;
        }
        return guideETAEventLayerItemImpl.swigCPtr;
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
        GuideETAEventLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideETAEventLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideETAEventLayerItemImpl() {
        this(createNativeObj(), true);
        LayerSvrJNI.swig_jni_init();
        GuideETAEventLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
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
}
