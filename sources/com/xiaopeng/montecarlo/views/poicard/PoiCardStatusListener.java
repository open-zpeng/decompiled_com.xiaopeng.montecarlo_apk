package com.xiaopeng.montecarlo.views.poicard;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
/* loaded from: classes3.dex */
public interface PoiCardStatusListener {
    void onPoiCardStatusNone();

    void onPoiCardStatusRefreshing(XPPoiInfo xPPoiInfo, int i);
}
