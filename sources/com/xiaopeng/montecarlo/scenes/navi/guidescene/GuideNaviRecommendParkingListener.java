package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviRecommendParkingListener;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract;
import java.util.List;
/* loaded from: classes2.dex */
public class GuideNaviRecommendParkingListener extends NaviRecommendParkingListener {
    private INaviContract.LogicView mLogicView;
    private NaviScenePresenter mPresenter;

    public GuideNaviRecommendParkingListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
        this.mPresenter = (NaviScenePresenter) baseNaviPresenter;
        this.mLogicView = (INaviContract.LogicView) iBaseNaviLogicView;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRecommendParkingListener, com.xiaopeng.montecarlo.scenes.navi.IRecommendParkingListener
    public void onShowRecommendParking(List<XPPoiInfo> list, boolean z) {
        if (CollectionUtils.isNotEmpty(list)) {
            this.mPresenter.showRecommendParkImage(list, z);
            this.mPresenter.showRecommendParkingFocus(0);
            this.mLogicView.onShowRecommendParking(list, z);
        }
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRecommendParkingListener, com.xiaopeng.montecarlo.scenes.navi.IRecommendParkingListener
    public void onHideRecommendParking() {
        this.mLogicView.onHideRecommendParking();
        this.mPresenter.hideRecommendParkImage();
    }
}
