package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.common.path.model.CameraType;
import com.autonavi.gbl.layer.GuideIntervalCameraLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideIntervalCameraLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class GuideIntervalCameraLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideIntervalCameraLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideIntervalCameraLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideIntervalCameraLayerItemImpl_change_ownership(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, long j, boolean z);

    private static native void GuideIntervalCameraLayerItemImpl_director_connect(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, int i2);

    private static native long createNativeObj1(int i, long j, int i2, int i3);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mCameraTypeGetNative(long j, GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl);

    private static native void mCameraTypeSetNative(long j, GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, int i);

    private static native int mDirectionStyleGetNative(long j, GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl);

    private static native void mDirectionStyleSetNative(long j, GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, int i);

    private static native int mSpeedGetNative(long j, GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl);

    private static native void mSpeedSetNative(long j, GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl, int i);

    public GuideIntervalCameraLayerItemImpl(long j, boolean z) {
        super(GuideIntervalCameraLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideIntervalCameraLayerItemImpl) {
            return getUID(this) == getUID((GuideIntervalCameraLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        long cPtr = getCPtr(guideIntervalCameraLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideIntervalCameraLayerItemImpl guideIntervalCameraLayerItemImpl) {
        if (guideIntervalCameraLayerItemImpl == null) {
            return 0L;
        }
        return guideIntervalCameraLayerItemImpl.swigCPtr;
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
        GuideIntervalCameraLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideIntervalCameraLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideIntervalCameraLayerItemImpl(@CameraType.CameraType1 int i, int i2) {
        this(createNativeObj(i, i2), true);
        LayerSvrJNI.swig_jni_init();
        GuideIntervalCameraLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public GuideIntervalCameraLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j, @CameraType.CameraType1 int i2, int i3) {
        this(createNativeObj1(i, j, i2, i3), true);
        LayerSvrJNI.swig_jni_init();
        GuideIntervalCameraLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMCameraType(@CameraType.CameraType1 int i) {
        $explicit_setMCameraType(i);
    }

    public void $explicit_setMCameraType(@CameraType.CameraType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mCameraTypeSetNative(j, this, i);
    }

    @CameraType.CameraType1
    public int getMCameraType() {
        return $explicit_getMCameraType();
    }

    @CameraType.CameraType1
    public int $explicit_getMCameraType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mCameraTypeGetNative(j, this);
    }

    public void setMSpeed(int i) {
        $explicit_setMSpeed(i);
    }

    public void $explicit_setMSpeed(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mSpeedSetNative(j, this, i);
    }

    public int getMSpeed() {
        return $explicit_getMSpeed();
    }

    public int $explicit_getMSpeed() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mSpeedGetNative(j, this);
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
}
