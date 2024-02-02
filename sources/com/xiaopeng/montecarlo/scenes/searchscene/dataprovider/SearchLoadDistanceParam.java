package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
/* loaded from: classes3.dex */
public class SearchLoadDistanceParam extends SearchRequestParam {
    private XPPoiInfo mEndPoi;
    private boolean mIsHome;
    private XPPoiInfo mStartPoi;

    public SearchLoadDistanceParam() {
        this.mSearchType = 11;
    }

    public XPPoiInfo getStartPoi() {
        return this.mStartPoi;
    }

    public void setStartPoi(XPPoiInfo xPPoiInfo) {
        this.mStartPoi = xPPoiInfo;
    }

    public boolean isHome() {
        return this.mIsHome;
    }

    public void setHome(boolean z) {
        this.mIsHome = z;
    }

    public XPPoiInfo getEndPoi() {
        return this.mEndPoi;
    }

    public void setEndPoi(XPPoiInfo xPPoiInfo) {
        this.mEndPoi = xPPoiInfo;
    }
}
