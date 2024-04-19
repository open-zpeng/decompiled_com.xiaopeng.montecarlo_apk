package com.xiaopeng.montecarlo.scenes.navi;

import com.xiaopeng.montecarlo.R;
import com.xiaopeng.montecarlo.navcore.util.NavCoreUtil;
import com.xiaopeng.montecarlo.navcore.xptbt.GuideManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.OddDataHelper;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
/* loaded from: classes3.dex */
public class NaviRerouteListener implements GuideManager.IRerouteListener {
    private static final L.Tag TAG = new L.Tag("NaviRerouteListener");
    protected IBaseNaviLogicView mBaseLogicView;
    protected BaseNaviPresenter mBasePresenter;

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteOddError(long j) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteSuccess(long j, RouteResult routeResult) {
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void stopOnlineRouteRetryTimer() {
    }

    public NaviRerouteListener(IBaseNaviLogicView iBaseNaviLogicView, BaseNaviPresenter baseNaviPresenter) {
        this.mBaseLogicView = iBaseNaviLogicView;
        this.mBasePresenter = baseNaviPresenter;
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteError(final long j, final RouteResult routeResult) {
        UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.navi.NaviRerouteListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (routeResult.mErrorCode == 37) {
                    NaviRerouteListener.this.mBaseLogicView.onShowRouting(true);
                    NaviRerouteListener.this.mBaseLogicView.onShowOfflineRouteMsg(0, R.string.route_offline_reroute_msg);
                    return;
                }
                NaviRerouteListener.this.mBaseLogicView.onHideRouting();
                if (!NavCoreUtil.isSilentCalcRoute(routeResult.mRouteType)) {
                    NaviRerouteListener.this.mBaseLogicView.onShowRouteFailMsg(routeResult.mErrorCode);
                }
                TBTManager.getInstance().clearRouteData(j);
            }
        });
    }

    @Override // com.xiaopeng.montecarlo.navcore.xptbt.GuideManager.IRerouteListener
    public void onRerouteOddSuccess(long j, RouteResult routeResult) {
        OddDataHelper.getInstance().updateOddInfo();
    }
}
