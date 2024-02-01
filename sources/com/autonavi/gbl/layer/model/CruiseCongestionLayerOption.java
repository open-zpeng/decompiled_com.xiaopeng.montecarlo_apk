package com.autonavi.gbl.layer.model;

import com.xiaopeng.montecarlo.util.NaviUtil;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class CruiseCongestionLayerOption implements Serializable {
    public int mCongestionEndThreshold;
    public int mCongestionShowTimeout;
    public int mCongestionStartThreshold;
    public int mDistanceDeviation;
    public int mLeaveCongestionThreshold;
    public int mPreviewZoomRecoverTimeout;

    public CruiseCongestionLayerOption() {
        this.mCongestionShowTimeout = NaviUtil.DISTANCE_120KM;
        this.mPreviewZoomRecoverTimeout = 30000;
        this.mDistanceDeviation = 10;
        this.mCongestionStartThreshold = 10;
        this.mCongestionEndThreshold = 50;
        this.mLeaveCongestionThreshold = 10;
    }

    public CruiseCongestionLayerOption(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mCongestionShowTimeout = i;
        this.mPreviewZoomRecoverTimeout = i2;
        this.mDistanceDeviation = i3;
        this.mCongestionStartThreshold = i4;
        this.mCongestionEndThreshold = i5;
        this.mLeaveCongestionThreshold = i6;
    }
}
