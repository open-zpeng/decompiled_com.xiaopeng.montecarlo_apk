package com.xiaopeng.montecarlo.views.poicard;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IPathResult;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
/* loaded from: classes3.dex */
public interface PoiCardDataProviderListener {
    void onRouteFailure(XPPoiInfo xPPoiInfo);

    void onRouteSuccess(IVariantPath iVariantPath, IPathResult iPathResult, RouteResult.RouteInfo routeInfo, XPPoiInfo xPPoiInfo);
}
