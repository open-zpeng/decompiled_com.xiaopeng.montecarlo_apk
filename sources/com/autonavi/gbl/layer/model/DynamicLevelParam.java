package com.autonavi.gbl.layer.model;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class DynamicLevelParam implements Serializable {
    public int m2DTo3DPitchAngleDiff;
    public int mLeftScreenCenterDiff;
    public float mLeftScreenScale;
    public float mLevelFar3DCarUp;
    public int mLongDisToNaviPoint;
    public int mNaviPointOffsetToScreenTop;
    public float mNormalRoadMaxLevel2DCarUp;
    public float mNormalRoadMaxLevel3DCarUp;
    public float mNormalRoadMinLevel2DCarUp;
    public float mNormalRoadMinLevel2DNorthUp;
    public float mNormalRoadMinLevel3DCarUp;
    public int mPitchAngleDiff;
    public float mPitchFar3DCarUp;
    public float mPitchNear3DCarUp;
    public float mPitchSpeedWay3DCarUp;
    public int mRightScreenCenterDiff;
    public float mRightScreenScale;
    public float mSlipRoadKeepLevel;
    public int mSlowZoomLevelDiff;
    public float mSpeedWayLevelOutsideRange;
    public float mSpeedWayMaxLevel2DCarUp;
    public float mSpeedWayMaxLevel3DCarUp;
    public float mSpeedWayMinLevel2DCarUp;
    public float mSpeedWayMinLevel2DNorthUp;
    public float mSpeedWayMinLevel3DCarUp;
    public int mZoomLevelDiff;

    public DynamicLevelParam() {
        this.mZoomLevelDiff = 10;
        this.mPitchAngleDiff = 20;
        this.mSlowZoomLevelDiff = 20;
        this.m2DTo3DPitchAngleDiff = 10;
        this.mRightScreenCenterDiff = 20;
        this.mLeftScreenCenterDiff = 10;
        this.mNaviPointOffsetToScreenTop = 160;
        this.mLeftScreenScale = 0.5f;
        this.mRightScreenScale = 0.691f;
        this.mNormalRoadMaxLevel2DCarUp = 17.0f;
        this.mNormalRoadMinLevel2DCarUp = 15.0f;
        this.mSpeedWayMaxLevel2DCarUp = 17.0f;
        this.mSpeedWayMinLevel2DCarUp = 13.0f;
        this.mNormalRoadMaxLevel3DCarUp = 17.0f;
        this.mNormalRoadMinLevel3DCarUp = 14.0f;
        this.mSpeedWayMaxLevel3DCarUp = 17.0f;
        this.mSpeedWayMinLevel3DCarUp = 14.0f;
        this.mPitchSpeedWay3DCarUp = 45.0f;
        this.mPitchFar3DCarUp = 65.0f;
        this.mLevelFar3DCarUp = 17.0f;
        this.mPitchNear3DCarUp = 30.0f;
        this.mNormalRoadMinLevel2DNorthUp = 15.0f;
        this.mSpeedWayMinLevel2DNorthUp = 14.0f;
        this.mSpeedWayLevelOutsideRange = 14.0f;
        this.mLongDisToNaviPoint = 500;
        this.mSlipRoadKeepLevel = 17.0f;
    }

    public DynamicLevelParam(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i8, float f18) {
        this.mZoomLevelDiff = i;
        this.mPitchAngleDiff = i2;
        this.mSlowZoomLevelDiff = i3;
        this.m2DTo3DPitchAngleDiff = i4;
        this.mRightScreenCenterDiff = i5;
        this.mLeftScreenCenterDiff = i6;
        this.mNaviPointOffsetToScreenTop = i7;
        this.mLeftScreenScale = f;
        this.mRightScreenScale = f2;
        this.mNormalRoadMaxLevel2DCarUp = f3;
        this.mNormalRoadMinLevel2DCarUp = f4;
        this.mSpeedWayMaxLevel2DCarUp = f5;
        this.mSpeedWayMinLevel2DCarUp = f6;
        this.mNormalRoadMaxLevel3DCarUp = f7;
        this.mNormalRoadMinLevel3DCarUp = f8;
        this.mSpeedWayMaxLevel3DCarUp = f9;
        this.mSpeedWayMinLevel3DCarUp = f10;
        this.mPitchSpeedWay3DCarUp = f11;
        this.mPitchFar3DCarUp = f12;
        this.mLevelFar3DCarUp = f13;
        this.mPitchNear3DCarUp = f14;
        this.mNormalRoadMinLevel2DNorthUp = f15;
        this.mSpeedWayMinLevel2DNorthUp = f16;
        this.mSpeedWayLevelOutsideRange = f17;
        this.mLongDisToNaviPoint = i8;
        this.mSlipRoadKeepLevel = f18;
    }
}
