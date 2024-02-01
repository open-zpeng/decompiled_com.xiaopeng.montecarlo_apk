package com.xiaopeng.montecarlo.scenes.navi;
/* loaded from: classes3.dex */
public abstract class NaviSpeechEventHandler implements INaviSpeechEventHandler {
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    public NaviSpeechEventHandler(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }
}
