package com.xiaopeng.montecarlo.scenes.navi.explorescene;

import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.network.XPNetworkManager;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviRerouteListener;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
/* loaded from: classes3.dex */
public class ExploreNaviRerouteListener extends NaviRerouteListener {
    private static final int ONLINE_ROUTE_RETRY_TIME = 60000;
    private static final L.Tag TAG = new L.Tag("ExploreNaviRerouteListener");
    private ExploreScenePresenter mPresenter;
    private XCountDownTimer mTimer;
    private XCountDownTimer.ITimerCallback mTimerCallback;

    public ExploreNaviRerouteListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
        this.mTimerCallback = new XCountDownTimer.ITimerCallback() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreNaviRerouteListener.1
            @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
            public void onTick(long j) {
            }

            @Override // com.xiaopeng.montecarlo.root.util.timer.XCountDownTimer.ITimerCallback
            public void onTimeOut() {
                L.i(ExploreNaviRerouteListener.TAG, ">>> onTimeOut retry online route");
                RouteResult routeResult = TBTManager.getInstance().getRouteResult(TBTManager.getInstance().getCurrentNaviId());
                if (routeResult == null) {
                    L.w(ExploreNaviRerouteListener.TAG, "routeResult is empty, skip reroute");
                } else if (!routeResult.mIsLocal || !XPNetworkManager.INSTANCE.isNetworkConnected()) {
                    L.i(ExploreNaviRerouteListener.TAG, "routeResult is online, skip reroute");
                } else {
                    ExploreNaviRerouteListener.this.mPresenter.requestReroute(true);
                }
            }
        };
        this.mTimer = new XCountDownTimer(60000L, this.mTimerCallback);
        this.mPresenter = (ExploreScenePresenter) baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRerouteListener, com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteError(long j, RouteResult routeResult) {
        if (NavCoreUtil.isNetworkError(routeResult.mErrorCode) && XPNetworkManager.INSTANCE.isNetworkConnected()) {
            this.mTimer.reset();
            L.i(TAG, "start retry countdown");
        }
        super.onRerouteError(j, routeResult);
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRerouteListener, com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void stopOnlineRouteRetryTimer() {
        this.mTimer.stop();
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRerouteListener, com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteSuccess(final long j, final RouteResult routeResult) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.explorescene.ExploreNaviRerouteListener.2
            @Override // java.lang.Runnable
            public void run() {
                ExploreNaviRerouteListener.this.mPresenter.clearAlterLabelTableForVui(1);
                ExploreNaviRerouteListener.this.mBaseLogicView.onHideRouting();
                boolean isStartNaviImmediately = ExploreNaviRerouteListener.this.mPresenter.getIsStartNaviImmediately();
                if (L.ENABLE) {
                    L.Tag tag = ExploreNaviRerouteListener.TAG;
                    L.d(tag, "onRerouteSuccess isStartNaviImmediately:" + isStartNaviImmediately + ",routeResult.mPathResult:" + routeResult.mPathResult);
                }
                ExploreNaviRerouteListener.this.mPresenter.setIsStartNaviImmediately(false);
                if (routeResult.mPathResult == null) {
                    return;
                }
                RestrictHelper restrictHelper = ExploreNaviRerouteListener.this.mBaseLogicView.getRestrictHelper();
                if (restrictHelper != null && restrictHelper.isNeedRequestRestrict(routeResult.mRouteType)) {
                    if (restrictHelper.isRestrictedPopShow()) {
                        restrictHelper.hideRestrictedPop();
                    }
                    restrictHelper.requestRestrict(ExploreNaviRerouteListener.this.mPresenter.getRestrictEventCallback(), j);
                }
                ExploreNaviRerouteListener.this.mBaseLogicView.onHideRecommendRoutePop();
                ExploreNaviRerouteListener.this.mPresenter.setIsNeedShowRecommendRoute(false);
                if (ExploreNaviRerouteListener.this.mPresenter.isETARerouteType(routeResult.mRouteType)) {
                    if (ExploreNaviRerouteListener.this.mPresenter.isIgnoreETAReroute(routeResult.mRouteType)) {
                        return;
                    }
                    ExploreNaviRerouteListener.this.mPresenter.onShowRecommendRoute(routeResult.mPathResult, TBTManager.getInstance().getOldNaviVariantPath(), routeResult.mRouteType, routeResult.mExternData);
                    return;
                }
                ExploreNaviRerouteListener.this.mPresenter.onNewRoute(routeResult.mPathResult, TBTManager.getInstance().getOldNaviVariantPath(), routeResult.mRouteType, routeResult.mExternData);
                if (14 != routeResult.mRouteType) {
                    if (routeResult.mIsLocal) {
                        ExploreNaviRerouteListener.this.mPresenter.setTryCountOffline(ExploreNaviRerouteListener.this.mPresenter.getTryCountOffline() + 1);
                    } else {
                        ExploreNaviRerouteListener.this.mPresenter.setTryCountOffline(0);
                    }
                }
                if (isStartNaviImmediately) {
                    if (L.ENABLE) {
                        L.d(ExploreNaviRerouteListener.TAG, "onRerouteSuccess startGuidance");
                    }
                    ExploreNaviRerouteListener.this.mPresenter.setSelectRoute(ExploreNaviRerouteListener.this.mPresenter.getSelectRoute());
                    ExploreNaviRerouteListener.this.mPresenter.startGuidance();
                }
            }
        });
    }
}
