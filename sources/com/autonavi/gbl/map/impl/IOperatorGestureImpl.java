package com.autonavi.gbl.map.impl;

import com.autonavi.auto.intfauto.BindTable;
import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.OperatorGesture;
import com.autonavi.gbl.map.model.GestureConfigure;
import com.autonavi.gbl.map.model.GestureInfo;
import com.autonavi.gbl.map.model.TouchEvent;
@IntfAuto(target = OperatorGesture.class, type = BuildType.CPROXY)
/* loaded from: classes2.dex */
public class IOperatorGestureImpl {
    private static BindTable BIND_TABLE = new BindTable(IOperatorGestureImpl.class);
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native long addGestureNative(long j, IOperatorGestureImpl iOperatorGestureImpl, long j2, GestureInfo gestureInfo);

    private static native void addMapGestureNative(long j, IOperatorGestureImpl iOperatorGestureImpl, int i, float f, float f2, float f3);

    private static native void addTouchEventNative(long j, IOperatorGestureImpl iOperatorGestureImpl, long j2, TouchEvent touchEvent);

    private static native void destroyNativeObj(long j);

    private static native void enableSlidingNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native void getGestureConfigureNative(long j, IOperatorGestureImpl iOperatorGestureImpl, long j2, GestureConfigure gestureConfigure);

    private static native void hidePoiOn3DMovingNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native void hidePoiOn3DSlidingNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native boolean isMapMoveLockedNative(long j, IOperatorGestureImpl iOperatorGestureImpl);

    private static native boolean isMapPinchZoomLockedNative(long j, IOperatorGestureImpl iOperatorGestureImpl);

    private static native boolean isMapPitchAngleLockedNative(long j, IOperatorGestureImpl iOperatorGestureImpl);

    private static native boolean isMapRollAngleLockedNative(long j, IOperatorGestureImpl iOperatorGestureImpl);

    private static native boolean isPoiHiddenOn3DMovingNative(long j, IOperatorGestureImpl iOperatorGestureImpl);

    private static native boolean isPoiHiddenOn3DSlidingNative(long j, IOperatorGestureImpl iOperatorGestureImpl);

    private static native boolean isSlidingEnabledNative(long j, IOperatorGestureImpl iOperatorGestureImpl);

    private static native void lockMapMoveNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native void lockMapPinchZoomNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native void lockMapPitchAngleNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native void lockMapRollAngleNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native void setAxisOfTwoFingersPressNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native void setAxisOfTwoFingersScaleRotateNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native void setAxisOfZoomInOnDoublePressNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native void setGestureConfigureNative(long j, IOperatorGestureImpl iOperatorGestureImpl, long j2, GestureConfigure gestureConfigure);

    private static native void setLongPressTimeOutNative(long j, IOperatorGestureImpl iOperatorGestureImpl, long j2);

    private static native void setMapLabelClickableNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    private static native void setMaxValidOffsetOfTwoFingersPressNative(long j, IOperatorGestureImpl iOperatorGestureImpl, long j2, long j3);

    private static native void setSinglePressTimeOutNative(long j, IOperatorGestureImpl iOperatorGestureImpl, long j2);

    private static native void setTimeOutOfTwoFingersPressNative(long j, IOperatorGestureImpl iOperatorGestureImpl, long j2);

    private static native void setTouchEnableNative(long j, IOperatorGestureImpl iOperatorGestureImpl, boolean z);

    public IOperatorGestureImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public int hashCode() {
        long uid = getUID(this);
        return (int) (uid ^ (uid >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof IOperatorGestureImpl) && getUID(this) == getUID((IOperatorGestureImpl) obj);
    }

    private static long getUID(IOperatorGestureImpl iOperatorGestureImpl) {
        long cPtr = getCPtr(iOperatorGestureImpl);
        return cPtr < 0 ? cPtr + 4294967296L : cPtr;
    }

    public static long getCPtr(IOperatorGestureImpl iOperatorGestureImpl) {
        if (iOperatorGestureImpl == null) {
            return 0L;
        }
        return iOperatorGestureImpl.swigCPtr;
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

    public void setTouchEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setTouchEnableNative(j, this, z);
    }

    public void addTouchEvent(TouchEvent touchEvent) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addTouchEventNative(j, this, 0L, touchEvent);
    }

    public long addGesture(GestureInfo gestureInfo) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return addGestureNative(j, this, 0L, gestureInfo);
    }

    public void addMapGesture(int i, float f, float f2, float f3) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        addMapGestureNative(j, this, i, f, f2, f3);
    }

    public void setGestureConfigure(GestureConfigure gestureConfigure) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setGestureConfigureNative(j, this, 0L, gestureConfigure);
    }

    public GestureConfigure getGestureConfigure() {
        GestureConfigure gestureConfigure = new GestureConfigure();
        getGestureConfigure(gestureConfigure);
        return gestureConfigure;
    }

    private void getGestureConfigure(GestureConfigure gestureConfigure) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        getGestureConfigureNative(j, this, 0L, gestureConfigure);
    }

    public void enableSliding(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        enableSlidingNative(j, this, z);
    }

    public boolean isSlidingEnabled() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isSlidingEnabledNative(j, this);
    }

    public void lockMapRollAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lockMapRollAngleNative(j, this, z);
    }

    public boolean isMapRollAngleLocked() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isMapRollAngleLockedNative(j, this);
    }

    public void lockMapPitchAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lockMapPitchAngleNative(j, this, z);
    }

    public boolean isMapPitchAngleLocked() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isMapPitchAngleLockedNative(j, this);
    }

    public void lockMapMove(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lockMapMoveNative(j, this, z);
    }

    public boolean isMapMoveLocked() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isMapMoveLockedNative(j, this);
    }

    public void lockMapPinchZoom(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        lockMapPinchZoomNative(j, this, z);
    }

    public boolean isMapPinchZoomLocked() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isMapPinchZoomLockedNative(j, this);
    }

    public void hidePoiOn3DMoving(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        hidePoiOn3DMovingNative(j, this, z);
    }

    public boolean isPoiHiddenOn3DMoving() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isPoiHiddenOn3DMovingNative(j, this);
    }

    public void hidePoiOn3DSliding(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        hidePoiOn3DSlidingNative(j, this, z);
    }

    public boolean isPoiHiddenOn3DSliding() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return isPoiHiddenOn3DSlidingNative(j, this);
    }

    public void setAxisOfZoomInOnDoublePress(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAxisOfZoomInOnDoublePressNative(j, this, z);
    }

    public void setAxisOfTwoFingersPress(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAxisOfTwoFingersPressNative(j, this, z);
    }

    public void setAxisOfTwoFingersScaleRotate(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setAxisOfTwoFingersScaleRotateNative(j, this, z);
    }

    public void setMapLabelClickable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        setMapLabelClickableNative(j, this, z);
    }

    public void setLongPressTimeOut(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setLongPressTimeOutNative(j2, this, j);
    }

    public void setSinglePressTimeOut(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setSinglePressTimeOutNative(j2, this, j);
    }

    public void setTimeOutOfTwoFingersPress(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        setTimeOutOfTwoFingersPressNative(j2, this, j);
    }

    public void setMaxValidOffsetOfTwoFingersPress(long j, long j2) {
        long j3 = this.swigCPtr;
        if (j3 == 0) {
            throw new NullPointerException();
        }
        setMaxValidOffsetOfTwoFingersPressNative(j3, this, j, j2);
    }
}
