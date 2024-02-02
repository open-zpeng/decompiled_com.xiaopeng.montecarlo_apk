package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes2.dex */
public class NaviTrafficEventHandler {
    private static final L.Tag TAG = new L.Tag("NaviTrafficEventHandler");
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    public NaviTrafficEventHandler(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }
}
