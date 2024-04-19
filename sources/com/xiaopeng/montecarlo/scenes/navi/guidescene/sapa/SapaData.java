package com.xiaopeng.montecarlo.scenes.navi.guidescene.sapa;

import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.XPFacilityInfo;
/* loaded from: classes3.dex */
public class SapaData {
    public SapaChargeInfo mCharegeInfo = new SapaChargeInfo();
    public int mIndex;
    public int mSaIndex;
    public int mSaWithChargeIndex;
    public XPFacilityInfo mXPFacilityInfo;

    public SapaData(int i, int i2, int i3, XPFacilityInfo xPFacilityInfo) {
        this.mIndex = i;
        this.mSaIndex = i2;
        this.mSaWithChargeIndex = i3;
        this.mXPFacilityInfo = xPFacilityInfo;
    }

    /* loaded from: classes3.dex */
    public class SapaChargeInfo {
        public String mId = null;
        public int mFastFreeNums = 0;
        public int mSlowFreeNums = 0;
        public int mUltraFreeNums = 0;
        public int mFastTotalNums = 0;
        public int mSlowTotalNums = 0;
        public int mUltraTotalNums = 0;

        public SapaChargeInfo() {
        }
    }
}
