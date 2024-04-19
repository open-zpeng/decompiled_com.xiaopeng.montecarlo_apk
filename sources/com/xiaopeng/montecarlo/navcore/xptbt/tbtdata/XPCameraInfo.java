package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes3.dex */
public class XPCameraInfo implements FacilityInfoProvider {
    public int mAverageSpeed;
    public XPCoordinate2DDouble mCoord2D;
    public XPCoord3DDouble mCoord3D;
    public int mDistance;
    public int mReasonableSpeedInRemainDist;
    public int mRemainDistance;
    public int mRoadClass;
    public int[] mSpeed;
    public int mType;

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.FacilityInfoProvider
    public int getRestrictSpeedType() {
        return 0;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.FacilityInfoProvider
    public int getXPRemainDistance() {
        return this.mDistance;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.FacilityInfoProvider
    public int getXPCameraType() {
        return this.mType;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.FacilityInfoProvider
    public int getRestrictSpeed() {
        int[] iArr = this.mSpeed;
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        return iArr[0];
    }
}
