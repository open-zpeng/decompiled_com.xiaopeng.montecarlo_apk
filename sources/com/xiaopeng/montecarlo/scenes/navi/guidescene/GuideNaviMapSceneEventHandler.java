package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import com.xiaopeng.montecarlo.navcore.speech.stat.SpeechStatProxy;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviMapSceneEventHandler;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract;
/* loaded from: classes3.dex */
public class GuideNaviMapSceneEventHandler extends NaviMapSceneEventHandler {
    private static final L.Tag TAG = new L.Tag("GuideNaviMapSceneEventHandler");
    private INaviContract.LogicView mLogicView;
    private NaviScenePresenter mPresenter;

    public GuideNaviMapSceneEventHandler(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
        this.mPresenter = (NaviScenePresenter) baseNaviPresenter;
        this.mLogicView = (INaviContract.LogicView) iBaseNaviLogicView;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IMapSceneEventHandler
    public void onSwitchOverview() {
        this.mPresenter.switchOverView();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IMapSceneEventHandler
    public void onSwitchOverview(boolean z) {
        if (z) {
            this.mPresenter.enterOverViewMode();
            SpeechStatProxy.getInstance().sendStatDataForSpeech(6, 2);
            return;
        }
        this.mPresenter.exitOverviewMode();
        SpeechStatProxy.getInstance().sendStatDataForSpeech(7, 2);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IMapSceneEventHandler
    public void exitCross3D() {
        if (this.mLogicView.is3DCrossShow()) {
            this.mPresenter.exitCross3D();
        }
    }
}
