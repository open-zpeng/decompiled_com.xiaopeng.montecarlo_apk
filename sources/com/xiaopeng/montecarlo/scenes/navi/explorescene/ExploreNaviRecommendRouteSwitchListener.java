package com.xiaopeng.montecarlo.scenes.navi.explorescene;

import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.root.datalog.BtnType;
import com.xiaopeng.montecarlo.root.datalog.DataLogUtil;
import com.xiaopeng.montecarlo.root.datalog.PageType;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviRecommendRouteSwitchListener;
/* loaded from: classes3.dex */
public class ExploreNaviRecommendRouteSwitchListener extends NaviRecommendRouteSwitchListener {
    public ExploreNaviRecommendRouteSwitchListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRecommendRouteSwitchListener, com.xiaopeng.montecarlo.views.RecommendRoutePop.IRecommendRouteSwitchListener
    public void onIgnore() {
        super.onIgnore();
        DataLogUtil.sendStatData(PageType.NAVI_DETECT_ROUTE, BtnType.RECOMMEND_ROUTE_IGNORE, new Object[0]);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRecommendRouteSwitchListener, com.xiaopeng.montecarlo.views.RecommendRoutePop.IRecommendRouteSwitchListener
    public void onSwitch(IVariantPath iVariantPath, int i) {
        super.onSwitch(iVariantPath, i);
        DataLogUtil.sendStatData(PageType.NAVI_DETECT_ROUTE, BtnType.RECOMMEND_ROUTE_SWITCH, new Object[0]);
    }
}
