package com.autonavi.gbl.map.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.layer.creflex.BaseLayerCRfxProto;
import com.autonavi.gbl.map.impl.IMapViewImpl;
import com.autonavi.gbl.map.layer.QuadrantLayer;
import com.autonavi.gbl.map.layer.model.QuadrantLayerShownType;
@IntfAuto(enableCRfx = true, protoOfCRfx = BaseLayerCRfxProto.class, target = QuadrantLayer.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class QuadrantLayerImpl extends BaseLayerImpl {
    private static BindTable BIND_TABLE = new BindTable(QuadrantLayerImpl.class);
    private transient long swigCPtr;

    private static native long QuadrantLayerImpl_SWIGUpcast(long j);

    private static native void QuadrantLayerImpl_change_ownership(QuadrantLayerImpl quadrantLayerImpl, long j, boolean z);

    private static native void QuadrantLayerImpl_director_connect(QuadrantLayerImpl quadrantLayerImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(String str, long j, IMapViewImpl iMapViewImpl);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native void setQuadrantShownTypeNative(long j, QuadrantLayerImpl quadrantLayerImpl, int i);

    private static native void updatePreviewRectNative(long j, QuadrantLayerImpl quadrantLayerImpl, long j2, RectDouble rectDouble);

    public QuadrantLayerImpl(long j, boolean z) {
        super(QuadrantLayerImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof QuadrantLayerImpl) {
            return getUID(this) == getUID((QuadrantLayerImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(QuadrantLayerImpl quadrantLayerImpl) {
        long cPtr = getCPtr(quadrantLayerImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(QuadrantLayerImpl quadrantLayerImpl) {
        if (quadrantLayerImpl == null) {
            return 0L;
        }
        return quadrantLayerImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        QuadrantLayerImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.BaseLayerImpl, com.autonavi.gbl.map.impl.CollisionGroupImpl, com.autonavi.gbl.map.impl.CollisionEntityImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        QuadrantLayerImpl_change_ownership(this, this.swigCPtr, true);
    }

    public QuadrantLayerImpl(String str, IMapViewImpl iMapViewImpl) {
        this(createNativeObj(str, IMapViewImpl.getCPtr(iMapViewImpl), iMapViewImpl), true);
        MapLayerSvrJNI.swig_jni_init();
        QuadrantLayerImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setQuadrantShownType(@QuadrantLayerShownType.QuadrantLayerShownType1 int i) {
        $explicit_setQuadrantShownType(i);
    }

    public void $explicit_setQuadrantShownType(@QuadrantLayerShownType.QuadrantLayerShownType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setQuadrantShownTypeNative(j, this, i);
    }

    public void updatePreviewRect(RectDouble rectDouble) {
        $explicit_updatePreviewRect(rectDouble);
    }

    public void $explicit_updatePreviewRect(RectDouble rectDouble) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        updatePreviewRectNative(j, this, 0L, rectDouble);
    }
}
