package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.root.network.IXPNetworkListener;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
/* loaded from: classes3.dex */
public class NaviXPNetworkListener implements IXPNetworkListener {
    private static final L.Tag TAG = new L.Tag("NaviXPNetworkListener");
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    public NaviXPNetworkListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.root.network.IXPNetworkListener
    public void onNetworkChanged(XPNetworkManager.XPNetworkType xPNetworkType, boolean z) {
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "onNetworkChanged isNetworkConnect:" + z);
        }
        if (z) {
            this.mBasePresenter.requestReroute(true);
        }
    }
}
