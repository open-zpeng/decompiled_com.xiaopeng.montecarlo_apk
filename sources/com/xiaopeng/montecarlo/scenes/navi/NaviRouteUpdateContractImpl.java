package com.xiaopeng.montecarlo.scenes.navi;

import android.os.Bundle;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.base.IRouteUpdateContract;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
/* loaded from: classes2.dex */
public class NaviRouteUpdateContractImpl implements IRouteUpdateContract {
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    public NaviRouteUpdateContractImpl(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.base.IRouteUpdateContract
    public void onRouteUpdate(Bundle bundle) {
        if (bundle != null) {
            this.mBasePresenter.requestReroute((RouteRequest) bundle.getParcelable(RouteBridge.ROUTE_REQUEST), 4, bundle.getBoolean(MapRouteMsg.MAPROUTEMSG_IS_FILTER_CHARGE, true));
        }
    }
}
