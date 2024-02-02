package com.xiaopeng.montecarlo.scenes.navi;
/* loaded from: classes2.dex */
public class NaviParallelRoadEventHandler implements IParallelRoadEventHandler {
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    public NaviParallelRoadEventHandler(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.IParallelRoadEventHandler
    public void onRoadSwitchFinish() {
        this.mBasePresenter.requestReroute(4, 2, false);
    }
}
