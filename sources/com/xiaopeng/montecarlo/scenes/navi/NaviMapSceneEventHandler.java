package com.xiaopeng.montecarlo.scenes.navi;
/* loaded from: classes2.dex */
public abstract class NaviMapSceneEventHandler implements IMapSceneEventHandler {
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    public NaviMapSceneEventHandler(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }
}
