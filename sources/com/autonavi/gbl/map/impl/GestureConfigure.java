package com.autonavi.gbl.map.impl;
/* loaded from: classes2.dex */
public class GestureConfigure {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    private static native boolean b3DMovingHidePoiGetNative(long j, GestureConfigure gestureConfigure);

    private static native void b3DMovingHidePoiSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean b3DSlidingHidePoiGetNative(long j, GestureConfigure gestureConfigure);

    private static native void b3DSlidingHidePoiSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean bDoublePressZoomInByTouchPointGetNative(long j, GestureConfigure gestureConfigure);

    private static native void bDoublePressZoomInByTouchPointSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean bLockMapMoveGetNative(long j, GestureConfigure gestureConfigure);

    private static native void bLockMapMoveSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean bLockMapPinchZoomGetNative(long j, GestureConfigure gestureConfigure);

    private static native void bLockMapPinchZoomSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean bLockMapPitchAngleGetNative(long j, GestureConfigure gestureConfigure);

    private static native void bLockMapPitchAngleSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean bLockMapRollAngleGetNative(long j, GestureConfigure gestureConfigure);

    private static native void bLockMapRollAngleSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean bMapLabelClickableGetNative(long j, GestureConfigure gestureConfigure);

    private static native void bMapLabelClickableSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean bSlidingEnableGetNative(long j, GestureConfigure gestureConfigure);

    private static native void bSlidingEnableSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean bTouchEnableGetNative(long j, GestureConfigure gestureConfigure);

    private static native void bTouchEnableSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean bTwoFingerPressZoomOutByTouchPointGetNative(long j, GestureConfigure gestureConfigure);

    private static native void bTwoFingerPressZoomOutByTouchPointSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native boolean bTwoFingerScaleRotateByTouchPointGetNative(long j, GestureConfigure gestureConfigure);

    private static native void bTwoFingerScaleRotateByTouchPointSetNative(long j, GestureConfigure gestureConfigure, boolean z);

    private static native long createNativeObj();

    private static native void destroyNativeObj(long j);

    private static native float fSlidingRateGetNative(long j, GestureConfigure gestureConfigure);

    private static native void fSlidingRateSetNative(long j, GestureConfigure gestureConfigure, float f);

    private static native long nLongPressTimeOutGetNative(long j, GestureConfigure gestureConfigure);

    private static native void nLongPressTimeOutSetNative(long j, GestureConfigure gestureConfigure, long j2);

    private static native long nSinglePressTimeOutGetNative(long j, GestureConfigure gestureConfigure);

    private static native void nSinglePressTimeOutSetNative(long j, GestureConfigure gestureConfigure, long j2);

    private static native long nTwoFingerPressDeltaXGetNative(long j, GestureConfigure gestureConfigure);

    private static native void nTwoFingerPressDeltaXSetNative(long j, GestureConfigure gestureConfigure, long j2);

    private static native long nTwoFingerPressDeltaYGetNative(long j, GestureConfigure gestureConfigure);

    private static native void nTwoFingerPressDeltaYSetNative(long j, GestureConfigure gestureConfigure, long j2);

    private static native long nTwoFingerPressTimeOutGetNative(long j, GestureConfigure gestureConfigure);

    private static native void nTwoFingerPressTimeOutSetNative(long j, GestureConfigure gestureConfigure, long j2);

    public GestureConfigure(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(GestureConfigure gestureConfigure) {
        if (gestureConfigure == null) {
            return 0L;
        }
        return gestureConfigure.swigCPtr;
    }

    public boolean isRecycled() {
        return this.swigCPtr == 0;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                destroyNativeObj(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setBTouchEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bTouchEnableSetNative(j, this, z);
    }

    public boolean getBTouchEnable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bTouchEnableGetNative(j, this);
    }

    public void setBLockMapRollAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bLockMapRollAngleSetNative(j, this, z);
    }

    public boolean getBLockMapRollAngle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bLockMapRollAngleGetNative(j, this);
    }

    public void setBLockMapPitchAngle(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bLockMapPitchAngleSetNative(j, this, z);
    }

    public boolean getBLockMapPitchAngle() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bLockMapPitchAngleGetNative(j, this);
    }

    public void setBLockMapPinchZoom(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bLockMapPinchZoomSetNative(j, this, z);
    }

    public boolean getBLockMapPinchZoom() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bLockMapPinchZoomGetNative(j, this);
    }

    public void setBLockMapMove(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bLockMapMoveSetNative(j, this, z);
    }

    public boolean getBLockMapMove() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bLockMapMoveGetNative(j, this);
    }

    public void setBSlidingEnable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bSlidingEnableSetNative(j, this, z);
    }

    public boolean getBSlidingEnable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bSlidingEnableGetNative(j, this);
    }

    public void setB3DMovingHidePoi(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        b3DMovingHidePoiSetNative(j, this, z);
    }

    public boolean getB3DMovingHidePoi() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return b3DMovingHidePoiGetNative(j, this);
    }

    public void setB3DSlidingHidePoi(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        b3DSlidingHidePoiSetNative(j, this, z);
    }

    public boolean getB3DSlidingHidePoi() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return b3DSlidingHidePoiGetNative(j, this);
    }

    public void setBMapLabelClickable(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bMapLabelClickableSetNative(j, this, z);
    }

    public boolean getBMapLabelClickable() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bMapLabelClickableGetNative(j, this);
    }

    public void setBDoublePressZoomInByTouchPoint(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bDoublePressZoomInByTouchPointSetNative(j, this, z);
    }

    public boolean getBDoublePressZoomInByTouchPoint() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bDoublePressZoomInByTouchPointGetNative(j, this);
    }

    public void setBTwoFingerPressZoomOutByTouchPoint(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bTwoFingerPressZoomOutByTouchPointSetNative(j, this, z);
    }

    public boolean getBTwoFingerPressZoomOutByTouchPoint() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bTwoFingerPressZoomOutByTouchPointGetNative(j, this);
    }

    public void setBTwoFingerScaleRotateByTouchPoint(boolean z) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        bTwoFingerScaleRotateByTouchPointSetNative(j, this, z);
    }

    public boolean getBTwoFingerScaleRotateByTouchPoint() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return bTwoFingerScaleRotateByTouchPointGetNative(j, this);
    }

    public void setNSinglePressTimeOut(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        nSinglePressTimeOutSetNative(j2, this, j);
    }

    public long getNSinglePressTimeOut() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return nSinglePressTimeOutGetNative(j, this);
    }

    public void setNLongPressTimeOut(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        nLongPressTimeOutSetNative(j2, this, j);
    }

    public long getNLongPressTimeOut() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return nLongPressTimeOutGetNative(j, this);
    }

    public void setNTwoFingerPressTimeOut(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        nTwoFingerPressTimeOutSetNative(j2, this, j);
    }

    public long getNTwoFingerPressTimeOut() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return nTwoFingerPressTimeOutGetNative(j, this);
    }

    public void setNTwoFingerPressDeltaX(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        nTwoFingerPressDeltaXSetNative(j2, this, j);
    }

    public long getNTwoFingerPressDeltaX() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return nTwoFingerPressDeltaXGetNative(j, this);
    }

    public void setNTwoFingerPressDeltaY(long j) {
        long j2 = this.swigCPtr;
        if (j2 == 0) {
            throw new NullPointerException();
        }
        nTwoFingerPressDeltaYSetNative(j2, this, j);
    }

    public long getNTwoFingerPressDeltaY() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return nTwoFingerPressDeltaYGetNative(j, this);
    }

    public void setFSlidingRate(float f) {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        fSlidingRateSetNative(j, this, f);
    }

    public float getFSlidingRate() {
        long j = this.swigCPtr;
        if (j == 0) {
            throw new NullPointerException();
        }
        return fSlidingRateGetNative(j, this);
    }

    public GestureConfigure() {
        this(createNativeObj(), true);
    }
}
