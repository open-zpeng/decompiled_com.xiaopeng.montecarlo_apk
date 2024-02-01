package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.GuideFamiliarRouteLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideFamiliarRouteLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class GuideFamiliarRouteLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideFamiliarRouteLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideFamiliarRouteLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideFamiliarRouteLayerItemImpl_change_ownership(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, long j, boolean z);

    private static native void GuideFamiliarRouteLayerItemImpl_director_connect(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, long j, boolean z, boolean z2);

    private static native int boardStyleGetNative(long j, GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl);

    private static native void boardStyleSetNative(long j, GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, int i);

    private static native long createNativeObj(int i, long j);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native long pathIdGetNative(long j, GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl);

    private static native void pathIdSetNative(long j, GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl, long j2);

    public GuideFamiliarRouteLayerItemImpl(long j, boolean z) {
        super(GuideFamiliarRouteLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideFamiliarRouteLayerItemImpl) {
            return getUID(this) == getUID((GuideFamiliarRouteLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        long cPtr = getCPtr(guideFamiliarRouteLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideFamiliarRouteLayerItemImpl guideFamiliarRouteLayerItemImpl) {
        if (guideFamiliarRouteLayerItemImpl == null) {
            return 0L;
        }
        return guideFamiliarRouteLayerItemImpl.swigCPtr;
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
        GuideFamiliarRouteLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideFamiliarRouteLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideFamiliarRouteLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerSvrJNI.swig_jni_init();
        GuideFamiliarRouteLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setPathId(long j) {
        $explicit_setPathId(j);
    }

    public void $explicit_setPathId(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        pathIdSetNative(j2, this, j);
    }

    public long getPathId() {
        return $explicit_getPathId();
    }

    public long $explicit_getPathId() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return pathIdGetNative(j, this);
    }

    public void setBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        $explicit_setBoardStyle(i);
    }

    public void $explicit_setBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        boardStyleSetNative(j, this, i);
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int getBoardStyle() {
        return $explicit_getBoardStyle();
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int $explicit_getBoardStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return boardStyleGetNative(j, this);
    }
}
