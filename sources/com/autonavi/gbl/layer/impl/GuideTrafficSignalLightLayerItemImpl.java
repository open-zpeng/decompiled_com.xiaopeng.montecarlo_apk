package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.GuideTrafficSignalLightLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.TrafficLightCountDownStatus;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = GuideTrafficSignalLightLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class GuideTrafficSignalLightLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(GuideTrafficSignalLightLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long GuideTrafficSignalLightLayerItemImpl_SWIGUpcast(long j);

    private static native void GuideTrafficSignalLightLayerItemImpl_change_ownership(GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl, long j, boolean z);

    private static native void GuideTrafficSignalLightLayerItemImpl_director_connect(GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl, long j, boolean z, boolean z2);

    private static native float arrowDirectionAlphaGetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl);

    private static native void arrowDirectionAlphaSetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl, float f);

    private static native long createNativeObj(int i);

    private static native int crossManeuverIDGetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl);

    private static native void crossManeuverIDSetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl, int i);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native float lightAlphaGetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl);

    private static native void lightAlphaSetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl, float f);

    private static native int lightCountDownGetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl);

    private static native void lightCountDownSetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl, int i);

    private static native int trafficLightStatusGetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl);

    private static native void trafficLightStatusSetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl, int i);

    private static native long waitRoundCountGetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl);

    private static native void waitRoundCountSetNative(long j, GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl, long j2);

    public GuideTrafficSignalLightLayerItemImpl(long j, boolean z) {
        super(GuideTrafficSignalLightLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof GuideTrafficSignalLightLayerItemImpl) {
            return getUID(this) == getUID((GuideTrafficSignalLightLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl) {
        long cPtr = getCPtr(guideTrafficSignalLightLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(GuideTrafficSignalLightLayerItemImpl guideTrafficSignalLightLayerItemImpl) {
        if (guideTrafficSignalLightLayerItemImpl == null) {
            return 0L;
        }
        return guideTrafficSignalLightLayerItemImpl.swigCPtr;
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
        GuideTrafficSignalLightLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GuideTrafficSignalLightLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public GuideTrafficSignalLightLayerItemImpl(@QuadrantType.QuadrantType1 int i) {
        this(createNativeObj(i), true);
        LayerSvrJNI.swig_jni_init();
        GuideTrafficSignalLightLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setWaitRoundCount(long j) {
        $explicit_setWaitRoundCount(j);
    }

    public void $explicit_setWaitRoundCount(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        waitRoundCountSetNative(j2, this, j);
    }

    public long getWaitRoundCount() {
        return $explicit_getWaitRoundCount();
    }

    public long $explicit_getWaitRoundCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return waitRoundCountGetNative(j, this);
    }

    public void setCrossManeuverID(int i) {
        $explicit_setCrossManeuverID(i);
    }

    public void $explicit_setCrossManeuverID(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        crossManeuverIDSetNative(j, this, i);
    }

    public int getCrossManeuverID() {
        return $explicit_getCrossManeuverID();
    }

    public int $explicit_getCrossManeuverID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return crossManeuverIDGetNative(j, this);
    }

    public void setTrafficLightStatus(@TrafficLightCountDownStatus.TrafficLightCountDownStatus1 int i) {
        $explicit_setTrafficLightStatus(i);
    }

    public void $explicit_setTrafficLightStatus(@TrafficLightCountDownStatus.TrafficLightCountDownStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        trafficLightStatusSetNative(j, this, i);
    }

    @TrafficLightCountDownStatus.TrafficLightCountDownStatus1
    public int getTrafficLightStatus() {
        return $explicit_getTrafficLightStatus();
    }

    @TrafficLightCountDownStatus.TrafficLightCountDownStatus1
    public int $explicit_getTrafficLightStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return trafficLightStatusGetNative(j, this);
    }

    public void setLightCountDown(int i) {
        $explicit_setLightCountDown(i);
    }

    public void $explicit_setLightCountDown(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lightCountDownSetNative(j, this, i);
    }

    public int getLightCountDown() {
        return $explicit_getLightCountDown();
    }

    public int $explicit_getLightCountDown() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lightCountDownGetNative(j, this);
    }

    public void setLightAlpha(float f) {
        $explicit_setLightAlpha(f);
    }

    public void $explicit_setLightAlpha(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lightAlphaSetNative(j, this, f);
    }

    public float getLightAlpha() {
        return $explicit_getLightAlpha();
    }

    public float $explicit_getLightAlpha() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lightAlphaGetNative(j, this);
    }

    public void setArrowDirectionAlpha(float f) {
        $explicit_setArrowDirectionAlpha(f);
    }

    public void $explicit_setArrowDirectionAlpha(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        arrowDirectionAlphaSetNative(j, this, f);
    }

    public float getArrowDirectionAlpha() {
        return $explicit_getArrowDirectionAlpha();
    }

    public float $explicit_getArrowDirectionAlpha() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return arrowDirectionAlphaGetNative(j, this);
    }
}
