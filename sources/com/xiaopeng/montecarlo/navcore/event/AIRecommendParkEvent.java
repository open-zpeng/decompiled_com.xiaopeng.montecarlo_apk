package com.xiaopeng.montecarlo.navcore.event;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
/* loaded from: classes2.dex */
public class AIRecommendParkEvent {
    private XPPoiInfo mEndInfo;
    private XPPoiInfo mStartInfo;

    public AIRecommendParkEvent(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2) {
        this.mStartInfo = xPPoiInfo;
        this.mEndInfo = xPPoiInfo2;
    }

    public XPPoiInfo getStartInfo() {
        return this.mStartInfo;
    }

    public void setStartInfo(XPPoiInfo xPPoiInfo) {
        this.mStartInfo = xPPoiInfo;
    }

    public XPPoiInfo getEndInfo() {
        return this.mEndInfo;
    }

    public void setEndInfo(XPPoiInfo xPPoiInfo) {
        this.mEndInfo = xPPoiInfo;
    }
}
