package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.GuideMixForkLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.PointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideMixForkLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class GuideMixForkLayerItemImpl extends PointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideMixForkLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideMixForkLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideMixForkLayerItemImpl_change_ownership(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, long j, boolean z);

    private static native void GuideMixForkLayerItemImpl_director_connect(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, int i2, int i3);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mDirectionStyleGetNative(long j, GuideMixForkLayerItemImpl guideMixForkLayerItemImpl);

    private static native void mDirectionStyleSetNative(long j, GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, int i);

    private static native int mDistanceGetNative(long j, GuideMixForkLayerItemImpl guideMixForkLayerItemImpl);

    private static native void mDistanceSetNative(long j, GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, int i);

    private static native int mRoadClassGetNative(long j, GuideMixForkLayerItemImpl guideMixForkLayerItemImpl);

    private static native void mRoadClassSetNative(long j, GuideMixForkLayerItemImpl guideMixForkLayerItemImpl, int i);

    public GuideMixForkLayerItemImpl(long j, boolean z) {
        super(GuideMixForkLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideMixForkLayerItemImpl) {
            return getUID(this) == getUID((GuideMixForkLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        long cPtr = getCPtr(guideMixForkLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideMixForkLayerItemImpl guideMixForkLayerItemImpl) {
        if (guideMixForkLayerItemImpl == null) {
            return 0L;
        }
        return guideMixForkLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        GuideMixForkLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideMixForkLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideMixForkLayerItemImpl(@BizDirectionStyle.BizDirectionStyle1 int i, int i2, int i3) {
        this(createNativeObj(i, i2, i3), true);
        LayerSvrJNI.swig_jni_init();
        GuideMixForkLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        $explicit_setMDirectionStyle(i);
    }

    public void $explicit_setMDirectionStyle(@BizDirectionStyle.BizDirectionStyle1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDirectionStyleSetNative(j, this, i);
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int getMDirectionStyle() {
        return $explicit_getMDirectionStyle();
    }

    @BizDirectionStyle.BizDirectionStyle1
    public int $explicit_getMDirectionStyle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDirectionStyleGetNative(j, this);
    }

    public void setMDistance(int i) {
        $explicit_setMDistance(i);
    }

    public void $explicit_setMDistance(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDistanceSetNative(j, this, i);
    }

    public int getMDistance() {
        return $explicit_getMDistance();
    }

    public int $explicit_getMDistance() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDistanceGetNative(j, this);
    }

    public void setMRoadClass(int i) {
        $explicit_setMRoadClass(i);
    }

    public void $explicit_setMRoadClass(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mRoadClassSetNative(j, this, i);
    }

    public int getMRoadClass() {
        return $explicit_getMRoadClass();
    }

    public int $explicit_getMRoadClass() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mRoadClassGetNative(j, this);
    }
}
