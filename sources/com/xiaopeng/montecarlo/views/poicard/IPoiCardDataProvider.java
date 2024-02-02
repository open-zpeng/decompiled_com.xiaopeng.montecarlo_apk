package com.xiaopeng.montecarlo.views.poicard;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
/* loaded from: classes3.dex */
public interface IPoiCardDataProvider {
    void cancelLastRoute();

    void reset();

    void route(XPPoiInfo xPPoiInfo, XPPoiInfo xPPoiInfo2);
}
