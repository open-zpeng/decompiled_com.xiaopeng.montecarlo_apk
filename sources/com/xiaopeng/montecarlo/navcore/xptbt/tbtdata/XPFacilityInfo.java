package com.xiaopeng.montecarlo.navcore.xptbt.tbtdata;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
/* loaded from: classes3.dex */
public class XPFacilityInfo implements FacilityInfoProvider {
    public int mLimitSpeed;
    public String mName;
    public XPCoordinate2DDouble mPos;
    public int mRemainDist;
    public long mSapaDetail;
    public int mType;

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.FacilityInfoProvider
    public int getRestrictSpeedType() {
        return 4;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj instanceof XPFacilityInfo) {
            XPFacilityInfo xPFacilityInfo = (XPFacilityInfo) obj;
            return this == obj || (this.mType == xPFacilityInfo.mType && (str = this.mName) != null && str.equals(xPFacilityInfo.mName) && this.mLimitSpeed == xPFacilityInfo.mLimitSpeed && NavCoreUtil.isSameXPPosition(this.mPos, xPFacilityInfo.mPos) && this.mSapaDetail == xPFacilityInfo.mSapaDetail);
        }
        return false;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.FacilityInfoProvider
    public int getXPRemainDistance() {
        return this.mRemainDist;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.FacilityInfoProvider
    public int getXPCameraType() {
        return this.mType;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.FacilityInfoProvider
    public int getRestrictSpeed() {
        return this.mLimitSpeed;
    }
}
