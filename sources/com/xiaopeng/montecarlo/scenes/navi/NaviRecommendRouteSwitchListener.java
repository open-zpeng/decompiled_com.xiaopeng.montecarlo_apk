package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.navcore.control.BizControlWrapper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.views.RecommendRoutePop;
/* loaded from: classes3.dex */
public class NaviRecommendRouteSwitchListener implements RecommendRoutePop.IRecommendRouteSwitchListener {
    private static final L.Tag TAG = new L.Tag("NaviRecommendRouteSwitchListener");
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    public NaviRecommendRouteSwitchListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.views.RecommendRoutePop.IRecommendRouteSwitchListener
    public void onIgnore() {
        if (L.ENABLE) {
            L.d(TAG, "RecommendRoute: onIgnore");
        }
        this.mBasePresenter.stopTimer();
        this.mBaseLogicView.getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, 6031L);
    }

    @Override // com.xiaopeng.montecarlo.views.RecommendRoutePop.IRecommendRouteSwitchListener
    public void onSwitch(IVariantPath iVariantPath, int i) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "RecommendRoute onSwitch: " + i);
        }
        this.mBasePresenter.stopTimer();
        this.mBaseLogicView.getMapView().getBizControlManager().clearAllItems(BizControlWrapper.BIZ_CONTROL_TYPE_GUIDEROUTE, 6031L);
    }
}
