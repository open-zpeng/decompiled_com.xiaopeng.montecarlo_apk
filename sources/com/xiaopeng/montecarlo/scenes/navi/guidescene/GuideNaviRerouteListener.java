package com.xiaopeng.montecarlo.scenes.navi.guidescene;

import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.IVariantPath;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.scenes.navi.BaseNaviPresenter;
import com.xiaopeng.montecarlo.scenes.navi.IBaseNaviLogicView;
import com.xiaopeng.montecarlo.scenes.navi.NaviRerouteListener;
import com.xiaopeng.montecarlo.scenes.navi.guidescene.INaviContract;
import com.xiaopeng.montecarlo.scenes.restrictscene.RestrictHelper;
import com.xiaopeng.montecarlo.stat.NaviStatUtil;
/* loaded from: classes3.dex */
public class GuideNaviRerouteListener extends NaviRerouteListener {
    private static final L.Tag TAG = new L.Tag("GuideNaviRerouteListener");
    private INaviContract.LogicView mLogicView;
    private NaviScenePresenter mPresenter;

    public GuideNaviRerouteListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        super(iBaseNaviLogicView, baseNaviPresenter);
        this.mPresenter = (NaviScenePresenter) baseNaviPresenter;
        this.mLogicView = (INaviContract.LogicView) iBaseNaviLogicView;
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRerouteListener, com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteSuccess(final long j, final RouteResult routeResult) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviRerouteListener.1
            @Override // java.lang.Runnable
            public void run() {
                IVariantPath oldNaviVariantPath;
                if (L.ENABLE) {
                    L.Tag tag = GuideNaviRerouteListener.TAG;
                    L.d(tag, "onRerouteSuccess() requestId: " + j + ", mRouteType: " + routeResult.mRouteType + "; :" + routeResult.mIsLocal);
                }
                GuideNaviRerouteListener.this.mPresenter.clearAlterLabelTableForVui(1);
                GuideNaviRerouteListener.this.mLogicView.onHideRouting();
                if (routeResult.mPathResult == null) {
                    L.i(GuideNaviRerouteListener.TAG, "onRerouteSuccess() routeResult.mPathResult is null");
                    return;
                }
                int i = routeResult.mRouteType;
                RestrictHelper restrictHelper = GuideNaviRerouteListener.this.mLogicView.getRestrictHelper();
                if (restrictHelper != null && restrictHelper.isNeedRequestRestrict(i)) {
                    if (restrictHelper.isRestrictedPopShow()) {
                        restrictHelper.hideRestrictedPop();
                    }
                    restrictHelper.requestRestrict(GuideNaviRerouteListener.this.mPresenter.getRestrictEventCallback(), j);
                }
                if (i != 14) {
                    GuideNaviRerouteListener.this.mLogicView.onHideRecommendRoutePop();
                }
                GuideNaviRerouteListener.this.mPresenter.setIsNeedShowRecommendRoute(false);
                if (GuideNaviRerouteListener.this.mPresenter.isETARerouteType(i)) {
                    if (GuideNaviRerouteListener.this.mPresenter.isIgnoreETAReroute(i)) {
                        L.i(GuideNaviRerouteListener.TAG, "RECOMMEND_ROUTE ignore TMC reroute since radar is open or speech dialog on");
                        return;
                    }
                    if (5 == i) {
                        oldNaviVariantPath = TBTManager.getInstance().getCurrentNaviVariantPath();
                    } else {
                        oldNaviVariantPath = TBTManager.getInstance().getOldNaviVariantPath();
                    }
                    GuideNaviRerouteListener.this.mPresenter.onShowRecommendRoute(routeResult.mPathResult, oldNaviVariantPath, i, routeResult.mExternData);
                    return;
                }
                GuideNaviRerouteListener.this.mPresenter.onNewRouteUpdateUI();
                if (14 != i) {
                    if (routeResult.mIsLocal) {
                        GuideNaviRerouteListener.this.mPresenter.setTryCountOffline(GuideNaviRerouteListener.this.mPresenter.getTryCountOffline() + 1);
                        GuideNaviRerouteListener.this.mLogicView.onShowOfflineRoutePanel(true);
                        return;
                    }
                    if (L.ENABLE) {
                        L.d(GuideNaviRerouteListener.TAG, "onRerouteSuccess() onHideOfflineRoutePanel()");
                    }
                    GuideNaviRerouteListener.this.mPresenter.setTryCountOffline(0);
                    GuideNaviRerouteListener.this.mLogicView.onHideOfflineRoutePanel();
                }
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.scenes.navi.NaviRerouteListener, com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteError(final long j, final RouteResult routeResult) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.guidescene.GuideNaviRerouteListener.2
            @Override // java.lang.Runnable
            public void run() {
                if (822083620 == routeResult.mErrorCode) {
                    GuideNaviRerouteListener.this.mLogicView.onShowRouting(true);
                    GuideNaviRerouteListener.this.mLogicView.onShowOfflineRouteMsg(0, R.string.route_offline_reroute_msg);
                } else {
                    GuideNaviRerouteListener.this.mLogicView.onHideRouting();
                    if (CollectionUtils.isEmpty(TBTManager.getInstance().getViaInfos(j))) {
                        NaviStatUtil.sendStatDataWhenRouteFailure(GuideNaviRerouteListener.this.mLogicView.getMainContext(), NavCoreUtil.isSilentCalcRoute(routeResult.mRouteType));
                    } else {
                        NaviStatUtil.sendStatDataWhenRouteFailureForWaypoint(GuideNaviRerouteListener.this.mLogicView.getMainContext(), NavCoreUtil.isSilentCalcRoute(routeResult.mRouteType));
                    }
                    int i = routeResult.mRouteType;
                    if (!NavCoreUtil.isSilentCalcRoute(i) && !GuideNaviRerouteListener.this.mPresenter.isOfflineReroute()) {
                        GuideNaviRerouteListener.this.mLogicView.onShowRouteFailMsg(routeResult.mErrorCode);
                    }
                    TBTManager.getInstance().clearRouteData(j);
                    if (14 != i && GuideNaviRerouteListener.this.mLogicView.isOfflineRoutePanelExpand()) {
                        GuideNaviRerouteListener.this.mLogicView.onShowOfflineRoutePanel(true);
                    }
                }
                GuideNaviRerouteListener.this.mPresenter.setOfflineReroute(false);
            }
        });
    }
}
