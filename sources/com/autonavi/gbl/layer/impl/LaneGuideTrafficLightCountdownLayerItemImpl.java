package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.lane.model.BubbleDirectionType;
import com.autonavi.gbl.layer.LaneGuideTrafficLightCountdownLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.TrafficLightCountDownStatus;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = LaneGuideTrafficLightCountdownLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class LaneGuideTrafficLightCountdownLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(LaneGuideTrafficLightCountdownLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long LaneGuideTrafficLightCountdownLayerItemImpl_SWIGUpcast(long j);

    private static native void LaneGuideTrafficLightCountdownLayerItemImpl_change_ownership(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, long j, boolean z);

    private static native void LaneGuideTrafficLightCountdownLayerItemImpl_director_connect(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, long j);

    private static native void destroyNativeObj(long j);

    private static native int directionTypeGetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl);

    private static native void directionTypeSetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, int i);

    private static native String getClassTypeNameNative();

    private static native long lightAnimationBeginTimeMSGetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl);

    private static native void lightAnimationBeginTimeMSSetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, long j2);

    private static native float lightBodyAlphaGetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl);

    private static native void lightBodyAlphaSetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, float f);

    private static native float lightDirectionAlphaGetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl);

    private static native void lightDirectionAlphaSetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, float f);

    private static native String lightDirectionGetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl);

    private static native void lightDirectionSetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, String str);

    private static native int lightStatusGetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl);

    private static native void lightStatusSetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, int i);

    private static native int remainSecondsGetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl);

    private static native void remainSecondsSetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, int i);

    private static native int waitRoundGetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl);

    private static native void waitRoundSetNative(long j, LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl, int i);

    public LaneGuideTrafficLightCountdownLayerItemImpl(long j, boolean z) {
        super(LaneGuideTrafficLightCountdownLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof LaneGuideTrafficLightCountdownLayerItemImpl) {
            return getUID(this) == getUID((LaneGuideTrafficLightCountdownLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        long cPtr = getCPtr(laneGuideTrafficLightCountdownLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(LaneGuideTrafficLightCountdownLayerItemImpl laneGuideTrafficLightCountdownLayerItemImpl) {
        if (laneGuideTrafficLightCountdownLayerItemImpl == null) {
            return 0L;
        }
        return laneGuideTrafficLightCountdownLayerItemImpl.swigCPtr;
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
        LaneGuideTrafficLightCountdownLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        LaneGuideTrafficLightCountdownLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public LaneGuideTrafficLightCountdownLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerLaneSvrJNI.swig_jni_init();
        LaneGuideTrafficLightCountdownLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        $explicit_setDirectionType(i);
    }

    public void $explicit_setDirectionType(@BubbleDirectionType.BubbleDirectionType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        directionTypeSetNative(j, this, i);
    }

    @BubbleDirectionType.BubbleDirectionType1
    public int getDirectionType() {
        return $explicit_getDirectionType();
    }

    @BubbleDirectionType.BubbleDirectionType1
    public int $explicit_getDirectionType() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return directionTypeGetNative(j, this);
    }

    public void setLightBodyAlpha(float f) {
        $explicit_setLightBodyAlpha(f);
    }

    public void $explicit_setLightBodyAlpha(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lightBodyAlphaSetNative(j, this, f);
    }

    public float getLightBodyAlpha() {
        return $explicit_getLightBodyAlpha();
    }

    public float $explicit_getLightBodyAlpha() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lightBodyAlphaGetNative(j, this);
    }

    public void setLightDirectionAlpha(float f) {
        $explicit_setLightDirectionAlpha(f);
    }

    public void $explicit_setLightDirectionAlpha(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lightDirectionAlphaSetNative(j, this, f);
    }

    public float getLightDirectionAlpha() {
        return $explicit_getLightDirectionAlpha();
    }

    public float $explicit_getLightDirectionAlpha() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lightDirectionAlphaGetNative(j, this);
    }

    public void setLightAnimationBeginTimeMS(long j) {
        $explicit_setLightAnimationBeginTimeMS(j);
    }

    public void $explicit_setLightAnimationBeginTimeMS(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        lightAnimationBeginTimeMSSetNative(j2, this, j);
    }

    public long getLightAnimationBeginTimeMS() {
        return $explicit_getLightAnimationBeginTimeMS();
    }

    public long $explicit_getLightAnimationBeginTimeMS() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lightAnimationBeginTimeMSGetNative(j, this);
    }

    public void setLightStatus(@TrafficLightCountDownStatus.TrafficLightCountDownStatus1 int i) {
        $explicit_setLightStatus(i);
    }

    public void $explicit_setLightStatus(@TrafficLightCountDownStatus.TrafficLightCountDownStatus1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lightStatusSetNative(j, this, i);
    }

    @TrafficLightCountDownStatus.TrafficLightCountDownStatus1
    public int getLightStatus() {
        return $explicit_getLightStatus();
    }

    @TrafficLightCountDownStatus.TrafficLightCountDownStatus1
    public int $explicit_getLightStatus() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lightStatusGetNative(j, this);
    }

    public void setLightDirection(String str) {
        $explicit_setLightDirection(str);
    }

    public void $explicit_setLightDirection(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lightDirectionSetNative(j, this, str);
    }

    public String getLightDirection() {
        return $explicit_getLightDirection();
    }

    public String $explicit_getLightDirection() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return lightDirectionGetNative(j, this);
    }

    public void setRemainSeconds(int i) {
        $explicit_setRemainSeconds(i);
    }

    public void $explicit_setRemainSeconds(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        remainSecondsSetNative(j, this, i);
    }

    public int getRemainSeconds() {
        return $explicit_getRemainSeconds();
    }

    public int $explicit_getRemainSeconds() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return remainSecondsGetNative(j, this);
    }

    public void setWaitRound(int i) {
        $explicit_setWaitRound(i);
    }

    public void $explicit_setWaitRound(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        waitRoundSetNative(j, this, i);
    }

    public int getWaitRound() {
        return $explicit_getWaitRound();
    }

    public int $explicit_getWaitRound() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return waitRoundGetNative(j, this);
    }
}
