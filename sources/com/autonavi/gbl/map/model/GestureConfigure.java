package com.autonavi.gbl.map.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class GestureConfigure implements Serializable {
    public boolean b3DMovingHidePoi;
    public boolean b3DSlidingHidePoi;
    public boolean bDoublePressZoomInByTouchPoint;
    public boolean bLockMapMove;
    public boolean bLockMapPinchZoom;
    public boolean bLockMapPitchAngle;
    public boolean bLockMapRollAngle;
    public boolean bMapLabelClickable;
    public boolean bSlidingEnable;
    public boolean bTouchEnable;
    public boolean bTwoFingerPressZoomOutByTouchPoint;
    public boolean bTwoFingerScaleRotateByTouchPoint;
    public float fRotateEnterThreshold;
    public float fSlidingRate;
    public long nLongPressTimeOut;
    public long nSinglePressTimeOut;
    public long nTwoFingerPressDeltaX;
    public long nTwoFingerPressDeltaY;
    public long nTwoFingerPressTimeOut;

    public GestureConfigure() {
        this.bTouchEnable = true;
        this.bLockMapRollAngle = false;
        this.bLockMapPitchAngle = false;
        this.bLockMapPinchZoom = false;
        this.bLockMapMove = false;
        this.bSlidingEnable = false;
        this.b3DMovingHidePoi = true;
        this.b3DSlidingHidePoi = true;
        this.bMapLabelClickable = true;
        this.bDoublePressZoomInByTouchPoint = false;
        this.bTwoFingerPressZoomOutByTouchPoint = false;
        this.bTwoFingerScaleRotateByTouchPoint = false;
        this.nSinglePressTimeOut = 200L;
        this.nLongPressTimeOut = 1000L;
        this.nTwoFingerPressTimeOut = 200L;
        this.nTwoFingerPressDeltaX = 15L;
        this.nTwoFingerPressDeltaY = 15L;
        this.fSlidingRate = 1.0f;
        this.fRotateEnterThreshold = 4.0f;
    }

    public GestureConfigure(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, long j, long j2, long j3, long j4, long j5, float f, float f2) {
        this.bTouchEnable = z;
        this.bLockMapRollAngle = z2;
        this.bLockMapPitchAngle = z3;
        this.bLockMapPinchZoom = z4;
        this.bLockMapMove = z5;
        this.bSlidingEnable = z6;
        this.b3DMovingHidePoi = z7;
        this.b3DSlidingHidePoi = z8;
        this.bMapLabelClickable = z9;
        this.bDoublePressZoomInByTouchPoint = z10;
        this.bTwoFingerPressZoomOutByTouchPoint = z11;
        this.bTwoFingerScaleRotateByTouchPoint = z12;
        this.nSinglePressTimeOut = j;
        this.nLongPressTimeOut = j2;
        this.nTwoFingerPressTimeOut = j3;
        this.nTwoFingerPressDeltaX = j4;
        this.nTwoFingerPressDeltaY = j5;
        this.fSlidingRate = f;
        this.fRotateEnterThreshold = f2;
    }
}
