package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.auto.util.LogUtils;
import com.autonavi.gbl.guide.model.TrafficLight;
import com.autonavi.gbl.layer.GuideTrafficLightLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItem;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideTrafficLightLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes.dex */
public class GuideTrafficLightLayerItemImpl extends QuadrantLayerItem {
    private static BindTable BIND_TABLE = new BindTable(GuideTrafficLightLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideTrafficLightLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideTrafficLightLayerItemImpl_change_ownership(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, long j, boolean z);

    private static native void GuideTrafficLightLayerItemImpl_director_connect(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, int i2, int i3);

    private static native long createNativeObj1(int i, int i2);

    private static native long createNativeObj2(int i, long j, int i2, int i3);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mDirectionStyleGetNative(long j, GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl);

    private static native void mDirectionStyleSetNative(long j, GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, int i);

    private static native int mLightCountDownGetNative(long j, GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl);

    private static native void mLightCountDownSetNative(long j, GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, int i);

    private static native int mLightStatusGetNative(long j, GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl);

    private static native void mLightStatusSetNative(long j, GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl, int i);

    public GuideTrafficLightLayerItemImpl(long j, boolean z) {
        super(GuideTrafficLightLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideTrafficLightLayerItemImpl) {
            return getUID(this) == getUID((GuideTrafficLightLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        long cPtr = getCPtr(guideTrafficLightLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideTrafficLightLayerItemImpl guideTrafficLightLayerItemImpl) {
        if (guideTrafficLightLayerItemImpl == null) {
            return 0L;
        }
        return guideTrafficLightLayerItemImpl.swigCPtr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
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

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        GuideTrafficLightLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItem, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.ICollisionItemImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideTrafficLightLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideTrafficLightLayerItemImpl(@TrafficLight.TrafficLight1 int i, int i2, @BizDirectionStyle.BizDirectionStyle1 int i3) {
        this(createNativeObj(i, i2, i3), true);
        LayerSvrJNI.swig_jni_init();
        GuideTrafficLightLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public GuideTrafficLightLayerItemImpl(@TrafficLight.TrafficLight1 int i, int i2) {
        this(createNativeObj1(i, i2), true);
        LayerSvrJNI.swig_jni_init();
        GuideTrafficLightLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public GuideTrafficLightLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j, @TrafficLight.TrafficLight1 int i2, int i3) {
        this(createNativeObj2(i, j, i2, i3), true);
        LayerSvrJNI.swig_jni_init();
        GuideTrafficLightLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
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

    public void setMLightStatus(@TrafficLight.TrafficLight1 int i) {
        $explicit_setMLightStatus(i);
    }

    public void $explicit_setMLightStatus(@TrafficLight.TrafficLight1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLightStatusSetNative(j, this, i);
    }

    @TrafficLight.TrafficLight1
    public int getMLightStatus() {
        return $explicit_getMLightStatus();
    }

    @TrafficLight.TrafficLight1
    public int $explicit_getMLightStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLightStatusGetNative(j, this);
    }

    public void setMLightCountDown(int i) {
        $explicit_setMLightCountDown(i);
    }

    public void $explicit_setMLightCountDown(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLightCountDownSetNative(j, this, i);
    }

    public int getMLightCountDown() {
        return $explicit_getMLightCountDown();
    }

    public int $explicit_getMLightCountDown() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLightCountDownGetNative(j, this);
    }
}
