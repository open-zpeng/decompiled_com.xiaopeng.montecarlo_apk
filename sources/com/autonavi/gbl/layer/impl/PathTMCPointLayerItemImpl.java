package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.PathTMCPointLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = PathTMCPointLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class PathTMCPointLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(PathTMCPointLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long PathTMCPointLayerItemImpl_SWIGUpcast(long j);

    private static native void PathTMCPointLayerItemImpl_change_ownership(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, long j, boolean z);

    private static native void PathTMCPointLayerItemImpl_director_connect(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, long j, boolean z, boolean z2);

    private static native boolean checkShowFlagNative(long j, PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl);

    private static native boolean checkShowFlagSwigExplicitPathTMCPointLayerItemImplNative(long j, PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl);

    private static native long createNativeObj(int i, long j, int i2);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mBoardStyleGetNative(long j, PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl);

    private static native void mBoardStyleSetNative(long j, PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl, int i);

    public PathTMCPointLayerItemImpl(long j, boolean z) {
        super(PathTMCPointLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof PathTMCPointLayerItemImpl) {
            return getUID(this) == getUID((PathTMCPointLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        long cPtr = getCPtr(pathTMCPointLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(PathTMCPointLayerItemImpl pathTMCPointLayerItemImpl) {
        if (pathTMCPointLayerItemImpl == null) {
            return 0L;
        }
        return pathTMCPointLayerItemImpl.swigCPtr;
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
        PathTMCPointLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        PathTMCPointLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public PathTMCPointLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j, @BizDirectionStyle.BizDirectionStyle1 int i2) {
        this(createNativeObj(i, j, i2), true);
        LayerSvrJNI.swig_jni_init();
        PathTMCPointLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public boolean checkShowFlag() {
        return $explicit_checkShowFlag();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl
    public boolean $explicit_checkShowFlag() {
        if (this.swigCPtr != 0) {
            return getClass() == PathTMCPointLayerItemImpl.class ? checkShowFlagNative(this.swigCPtr, this) : checkShowFlagSwigExplicitPathTMCPointLayerItemImplNative(this.swigCPtr, this);
        }
        throw new NullPointerException();
    }

    public void setMBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        $explicit_setMBoardStyle(i);
    }

    public void $explicit_setMBoardStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mBoardStyleSetNative(j, this, i);
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int getMBoardStyle() {
        return $explicit_getMBoardStyle();
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int $explicit_getMBoardStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mBoardStyleGetNative(j, this);
    }
}
