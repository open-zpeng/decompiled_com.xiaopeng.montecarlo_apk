package com.autonavi.gbl.layer.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.EndAreaParentLayerItem;
import com.autonavi.gbl.layer.creflex.LayerItemCRfxProto;
import com.autonavi.gbl.layer.model.RouteEndAreaDirection;
import com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl;
import com.autonavi.gbl.map.layer.model.QuadrantType;
@IntfAuto(enableCRfx = false, protoOfCRfx = LayerItemCRfxProto.class, target = EndAreaParentLayerItem.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class EndAreaParentLayerItemImpl extends QuadrantLayerItemImpl {
    private static BindTable BIND_TABLE = new BindTable(EndAreaParentLayerItemImpl.class);
    private transient long swigCPtr;

    private static native long EndAreaParentLayerItemImpl_SWIGUpcast(long j);

    private static native void EndAreaParentLayerItemImpl_change_ownership(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, long j, boolean z);

    private static native void EndAreaParentLayerItemImpl_director_connect(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, long j, boolean z, boolean z2);

    private static native long createNativeObj(int i, long j);

    private static native long createNativeObj1(int i);

    private static native void destroyNativeObj(long j);

    private static native String getClassTypeNameNative();

    private static native int mDirectionGetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl);

    private static native void mDirectionSetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, int i);

    private static native int mLeftEnergyGetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl);

    private static native void mLeftEnergySetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, int i);

    private static native double mOddLengthGetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl);

    private static native void mOddLengthSetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, double d);

    private static native int mOddNumGetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl);

    private static native void mOddNumSetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, int i);

    private static native String mPoiNameGetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl);

    private static native void mPoiNameSetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, String str);

    private static native long mTravelTimeGetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl);

    private static native void mTravelTimeSetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, long j2);

    private static native int mWeatherIDGetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl);

    private static native void mWeatherIDSetNative(long j, EndAreaParentLayerItemImpl endAreaParentLayerItemImpl, int i);

    public EndAreaParentLayerItemImpl(long j, boolean z) {
        super(EndAreaParentLayerItemImpl_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public boolean equals(Object obj) {
        if (obj instanceof EndAreaParentLayerItemImpl) {
            return getUID(this) == getUID((EndAreaParentLayerItemImpl) obj);
        }
        return super.equals(obj);
    }

    private static long getUID(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        long cPtr = getCPtr(endAreaParentLayerItemImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(EndAreaParentLayerItemImpl endAreaParentLayerItemImpl) {
        if (endAreaParentLayerItemImpl == null) {
            return 0L;
        }
        return endAreaParentLayerItemImpl.swigCPtr;
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
        EndAreaParentLayerItemImpl_change_ownership(this, this.swigCPtr, false);
    }

    @Override // com.autonavi.gbl.map.layer.impl.QuadrantLayerItemImpl, com.autonavi.gbl.map.layer.impl.PointLayerItemImpl, com.autonavi.gbl.map.layer.impl.LayerItemImpl, com.autonavi.gbl.map.impl.CollisionItemImpl, com.autonavi.gbl.map.impl.MixtureSharedBaseImpl
    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        EndAreaParentLayerItemImpl_change_ownership(this, this.swigCPtr, true);
    }

    public EndAreaParentLayerItemImpl(@QuadrantType.QuadrantType1 int i, long j) {
        this(createNativeObj(i, j), true);
        LayerSvrJNI.swig_jni_init();
        EndAreaParentLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public EndAreaParentLayerItemImpl(@QuadrantType.QuadrantType1 int i) {
        this(createNativeObj1(i), true);
        LayerSvrJNI.swig_jni_init();
        EndAreaParentLayerItemImpl_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public static String getClassTypeName() {
        return getClassTypeNameNative();
    }

    public void setMPoiName(String str) {
        $explicit_setMPoiName(str);
    }

    public void $explicit_setMPoiName(String str) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mPoiNameSetNative(j, this, str);
    }

    public String getMPoiName() {
        return $explicit_getMPoiName();
    }

    public String $explicit_getMPoiName() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mPoiNameGetNative(j, this);
    }

    public void setMTravelTime(long j) {
        $explicit_setMTravelTime(j);
    }

    public void $explicit_setMTravelTime(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        mTravelTimeSetNative(j2, this, j);
    }

    public long getMTravelTime() {
        return $explicit_getMTravelTime();
    }

    public long $explicit_getMTravelTime() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mTravelTimeGetNative(j, this);
    }

    public void setMLeftEnergy(int i) {
        $explicit_setMLeftEnergy(i);
    }

    public void $explicit_setMLeftEnergy(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mLeftEnergySetNative(j, this, i);
    }

    public int getMLeftEnergy() {
        return $explicit_getMLeftEnergy();
    }

    public int $explicit_getMLeftEnergy() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mLeftEnergyGetNative(j, this);
    }

    public void setMOddNum(int i) {
        $explicit_setMOddNum(i);
    }

    public void $explicit_setMOddNum(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mOddNumSetNative(j, this, i);
    }

    public int getMOddNum() {
        return $explicit_getMOddNum();
    }

    public int $explicit_getMOddNum() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mOddNumGetNative(j, this);
    }

    public void setMOddLength(double d) {
        $explicit_setMOddLength(d);
    }

    public void $explicit_setMOddLength(double d) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mOddLengthSetNative(j, this, d);
    }

    public double getMOddLength() {
        return $explicit_getMOddLength();
    }

    public double $explicit_getMOddLength() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mOddLengthGetNative(j, this);
    }

    public void setMDirection(@RouteEndAreaDirection.RouteEndAreaDirection1 int i) {
        $explicit_setMDirection(i);
    }

    public void $explicit_setMDirection(@RouteEndAreaDirection.RouteEndAreaDirection1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mDirectionSetNative(j, this, i);
    }

    @RouteEndAreaDirection.RouteEndAreaDirection1
    public int getMDirection() {
        return $explicit_getMDirection();
    }

    @RouteEndAreaDirection.RouteEndAreaDirection1
    public int $explicit_getMDirection() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mDirectionGetNative(j, this);
    }

    public void setMWeatherID(int i) {
        $explicit_setMWeatherID(i);
    }

    public void $explicit_setMWeatherID(int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        mWeatherIDSetNative(j, this, i);
    }

    public int getMWeatherID() {
        return $explicit_getMWeatherID();
    }

    public int $explicit_getMWeatherID() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return mWeatherIDGetNative(j, this);
    }
}
