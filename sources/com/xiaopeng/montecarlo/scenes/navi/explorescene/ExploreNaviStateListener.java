package com.xiaopeng.montecarlo.scenes.navi.explorescene;

import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviStateListener;
/* loaded from: classes2.dex */
public class ExploreNaviStateListener extends NaviStateListener {
    private ExploreScenePresenter mPresenter;

    public ExploreNaviStateListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
        this.mPresenter = (ExploreScenePresenter) baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviStateListener, com.xiaopeng.montecarlo.navcore.state.IStateListener
    public void onStateChange(int i) {
        super.onStateChange(i);
        if (i != 0) {
            this.mPresenter.updatePreviewByCurrentLocation();
        }
    }
}
