package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.layer.SpeedCarLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = SpeedCarLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class SpeedCarLayerItemImpl extends NaviPointLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(SpeedCarLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long SpeedCarLayerItemImpl_SWIGUpcast(long j);

    private static native void SpeedCarLayerItemImpl_change_ownership(SpeedCarLayerItemImpl speedCarLayerItemImpl, long j, boolean z);

    private static native void SpeedCarLayerItemImpl_director_connect(SpeedCarLayerItemImpl speedCarLayerItemImpl, long j, boolean z, boolean z2);

    private static native boolean bBackGroundGetNative(long j, SpeedCarLayerItemImpl speedCarLayerItemImpl);

    private static native void bBackGroundSetNative(long j, SpeedCarLayerItemImpl speedCarLayerItemImpl, boolean z);

    private static native long createNativeObj(boolean z);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    public SpeedCarLayerItemImpl(long j, boolean z) {
        super(SpeedCarLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof SpeedCarLayerItemImpl) {
            return getUID(this) == getUID((SpeedCarLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        long cPtr = getCPtr(speedCarLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(SpeedCarLayerItemImpl speedCarLayerItemImpl) {
        if (speedCarLayerItemImpl == null) {
            return 0L;
        }
        return speedCarLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        SpeedCarLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.NaviPointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        SpeedCarLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public SpeedCarLayerItemImpl(boolean z) {
        this(createNativeObj(z), true);
        LayerSvrJNI.swig_jni_init();
        SpeedCarLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setBBackGround(boolean z) {
        $explicit_setBBackGround(z);
    }

    public void $explicit_setBBackGround(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bBackGroundSetNative(j, this, z);
    }

    public boolean getBBackGround() {
        return $explicit_getBBackGround();
    }

    public boolean $explicit_getBBackGround() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bBackGroundGetNative(j, this);
    }
}
