package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.search.XPCoordinate2DDouble;
/* loaded from: classes3.dex */
public class SearchHistoryParam extends SearchRequestParam {
    private boolean mIsLimit;
    private XPCoordinate2DDouble mLocation;

    public XPCoordinate2DDouble getLocation() {
        return this.mLocation;
    }

    public void setLocation(XPCoordinate2DDouble xPCoordinate2DDouble) {
        this.mLocation = xPCoordinate2DDouble;
    }

    public boolean getIsLimit() {
        return this.mIsLimit;
    }

    public void setIsLimit(boolean z) {
        this.mIsLimit = z;
    }
}
