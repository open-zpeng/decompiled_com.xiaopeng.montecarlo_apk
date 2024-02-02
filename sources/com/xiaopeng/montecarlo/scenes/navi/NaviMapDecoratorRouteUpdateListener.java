package com.xiaopeng.montecarlo.scenes.navi;

import android.os.Bundle;
import com.xiaopeng.montecarlo.aimessage.type.MapRouteMsg;
import com.xiaopeng.montecarlo.bridge.RouteBridge;
import com.xiaopeng.montecarlo.mapoverlay.DecoratorType;
import com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator;
import com.xiaopeng.montecarlo.scenes.routescene.RouteRequest;
/* loaded from: classes2.dex */
public class NaviMapDecoratorRouteUpdateListener implements BaseMapDecorator.IMapDecoratorRouteUpdateListener {
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    public NaviMapDecoratorRouteUpdateListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorRouteUpdateListener
    public void onRouteUpdate(DecoratorType decoratorType, Bundle bundle) {
        if (bundle != null) {
            this.mBasePresenter.requestReroute((RouteRequest) bundle.getParcelable(RouteBridge.ROUTE_REQUEST), 0, bundle.getBoolean(MapRouteMsg.MAPROUTEMSG_IS_FILTER_CHARGE, true));
        }
    }

    @Override // com.xiaopeng.montecarlo.mapoverlay.base.BaseMapDecorator.IMapDecoratorRouteUpdateListener
    public void onDestinationUpdate(DecoratorType decoratorType, Bundle bundle) {
        onRouteUpdate(decoratorType, bundle);
    }
}
