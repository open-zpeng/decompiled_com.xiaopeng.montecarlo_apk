package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class NaviRecommendParkingListener implements IRecommendParkingListener {
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    @Override // com.xiaopeng.montecarlo.scenes.navi.IRecommendParkingListener
    public void onHideRecommendParking() {
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IRecommendParkingListener
    public void onShowRecommendParking(List<XPPoiInfo> list, boolean z) {
    }

    public NaviRecommendParkingListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }
}
