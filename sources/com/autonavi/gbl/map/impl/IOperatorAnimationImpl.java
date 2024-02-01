package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.OperatorAnimation;
import com.autonavi.gbl.map.model.AnimationDeviationParam;
import com.autonavi.gbl.map.model.AnimationGeoAndScreenParam;
import com.autonavi.gbl.map.model.AnimationGroupParam;
import com.autonavi.gbl.map.model.AnimationMoveParam;
import com.autonavi.gbl.map.model.AnimationPivotZoomParam;
import com.autonavi.gbl.map.model.AnimationScreenMoveParam;
import com.autonavi.gbl.map.model.AnimationZoomRotateParam;
import com.autonavi.gbl.map.model.MapAnimationGroupType;
@IntfAuto(target = OperatorAnimation.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IOperatorAnimationImpl {
    private static BindTable BIND_TABLE = new BindTable(IOperatorAnimationImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native void addDeviationAnimationNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2, AnimationDeviationParam animationDeviationParam, int i, boolean z, long j3);

    private static native void addGeoAndScreenCenterAnimationNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2, AnimationGeoAndScreenParam animationGeoAndScreenParam, int i, boolean z, long j3);

    private static native void addGroupAnimationNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2, AnimationGroupParam animationGroupParam, long j3, boolean z, long j4);

    private static native void addMoveAnimationNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2, AnimationMoveParam animationMoveParam, int i, boolean z, long j3);

    private static native void addPivotZoomAnimationNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2, AnimationPivotZoomParam animationPivotZoomParam, int i, boolean z, long j3);

    private static native void addScreenMoveAnimationNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2, AnimationScreenMoveParam animationScreenMoveParam, int i, boolean z);

    private static native void addZoomRotateAnimationNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2, AnimationZoomRotateParam animationZoomRotateParam, int i, boolean z, long j3);

    private static native void destroyNativeObj(long j);

    private static native void finishAllAnimation1Native(long j, IOperatorAnimationImpl iOperatorAnimationImpl, boolean z);

    private static native void finishAllAnimationNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, boolean z, long j2);

    private static native int getAnimationCountNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl);

    private static native void removeAllAnimationNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2, boolean z);

    private static native void removeAnimationByTypes1Native(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2);

    private static native void removeAnimationByTypes2Native(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2, long j3, boolean z);

    private static native void removeAnimationByTypesNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, long j2, long j3);

    private static native void removeAnimationNative(long j, IOperatorAnimationImpl iOperatorAnimationImpl, int i);

    public IOperatorAnimationImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IOperatorAnimationImpl) && getUID(this) == getUID((IOperatorAnimationImpl) obj);
    }

    private static long getUID(IOperatorAnimationImpl iOperatorAnimationImpl) {
        long cPtr = getCPtr(iOperatorAnimationImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IOperatorAnimationImpl iOperatorAnimationImpl) {
        if (iOperatorAnimationImpl == null) {
            return 0L;
        }
        return iOperatorAnimationImpl.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public boolean isCMemOwn() {
        return this.swigCMemOwn;
    }

    protected synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void addGroupAnimation(AnimationGroupParam animationGroupParam, long j, boolean z, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        addGroupAnimationNative(j3, this, 0L, animationGroupParam, j, z, j2);
    }

    public void addMoveAnimation(AnimationMoveParam animationMoveParam, int i, boolean z, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        addMoveAnimationNative(j2, this, 0L, animationMoveParam, i, z, j);
    }

    public void addPivotZoomAnimation(AnimationPivotZoomParam animationPivotZoomParam, int i, boolean z, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        addPivotZoomAnimationNative(j2, this, 0L, animationPivotZoomParam, i, z, j);
    }

    public void addZoomRotateAnimation(AnimationZoomRotateParam animationZoomRotateParam, int i, boolean z, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        addZoomRotateAnimationNative(j2, this, 0L, animationZoomRotateParam, i, z, j);
    }

    public void addGeoAndScreenCenterAnimation(AnimationGeoAndScreenParam animationGeoAndScreenParam, int i, boolean z, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        addGeoAndScreenCenterAnimationNative(j2, this, 0L, animationGeoAndScreenParam, i, z, j);
    }

    public void addScreenMoveAnimation(AnimationScreenMoveParam animationScreenMoveParam, int i, boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addScreenMoveAnimationNative(j, this, 0L, animationScreenMoveParam, i, z);
    }

    public void addDeviationAnimation(AnimationDeviationParam animationDeviationParam, int i, boolean z, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        addDeviationAnimationNative(j2, this, 0L, animationDeviationParam, i, z, j);
    }

    public void removeAnimation(@MapAnimationGroupType.MapAnimationGroupType1 int i) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        removeAnimationNative(j, this, i);
    }

    public void removeAnimationByTypes(long j, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        removeAnimationByTypesNative(j3, this, j, j2);
    }

    public void removeAnimationByTypes(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        removeAnimationByTypes1Native(j2, this, j);
    }

    public void removeAnimationByTypes(long j, long j2, boolean z) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        removeAnimationByTypes2Native(j3, this, j, j2, z);
    }

    public void removeAllAnimation(long j, boolean z) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        removeAllAnimationNative(j2, this, j, z);
    }

    public void finishAllAnimation(boolean z, long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        finishAllAnimationNative(j2, this, z, j);
    }

    public void finishAllAnimation(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        finishAllAnimation1Native(j, this, z);
    }

    public int getAnimationCount() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return getAnimationCountNative(j, this);
    }
}
