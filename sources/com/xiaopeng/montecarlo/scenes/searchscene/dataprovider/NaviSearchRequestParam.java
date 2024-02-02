package com.xiaopeng.montecarlo.scenes.searchscene.dataprovider;

import com.xiaopeng.montecarlo.navcore.search.param.XPNaviSearchParam;
/* loaded from: classes3.dex */
public class NaviSearchRequestParam extends SearchRequestParam {
    private XPNaviSearchParam mXPNaviSearchParam;

    public NaviSearchRequestParam(XPNaviSearchParam xPNaviSearchParam) {
        this.mXPNaviSearchParam = xPNaviSearchParam;
    }

    public XPNaviSearchParam getNaviSearchParam() {
        return this.mXPNaviSearchParam;
    }
}
