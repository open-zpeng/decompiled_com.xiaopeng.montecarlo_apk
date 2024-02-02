package com.xiaopeng.montecarlo.views.poicard;

import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.xptbt.RouteManager;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteParams;
import com.xiaopeng.montecarlo.navcore.xptbt.tbtdata.RouteResult;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
/* loaded from: classes3.dex */
public class PoiCardDataProvider implements IPoiCardDataProvider {
    private static final L.Tag TAG = new L.Tag("PoiCardDataProvider");
    long mCurrentRouteRequestId;
    private PoiCardDataProviderListener mDataProviderListener;

    public PoiCardDataProvider(PoiCardDataProviderListener poiCardDataProviderListener) {
        this.mDataProviderListener = poiCardDataProviderListener;
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.IPoiCardDataProvider
    public void route(XPPoiInfo xPPoiInfo, final XPPoiInfo xPPoiInfo2) {
        this.mCurrentRouteRequestId = TBTManager.getInstance().requestRoute(new RouteParams.Builder().setStartInfo(xPPoiInfo).setEndInfo(xPPoiInfo2).setRouteLevel(0).build(), new RouteManager.IRouteResultListener() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardDataProvider.1
            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteSuccess(final long j, final RouteResult routeResult) {
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardDataProvider.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PoiCardDataProvider.this.mCurrentRouteRequestId != j) {
                            L.Tag tag = PoiCardDataProvider.TAG;
                            L.w(tag, "onNewRouteSuccess , request outdated , currentRequestId:" + PoiCardDataProvider.this.mCurrentRouteRequestId + " ,requestId:" + j);
                            TBTManager.getInstance().clearRouteData(j);
                            return;
                        }
                        PoiCardDataProvider.this.mCurrentRouteRequestId = -1L;
                        PoiCardDataProvider.this.handleRouteSilenceSuccess(routeResult, xPPoiInfo2);
                        TBTManager.getInstance().clearRouteData(j);
                    }
                });
            }

            @Override // com.xiaopeng.montecarlo.navcore.xptbt.RouteManager.IRouteResultListener
            public void onNewRouteError(final long j, final RouteResult routeResult) {
                UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.views.poicard.PoiCardDataProvider.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PoiCardDataProvider.this.mCurrentRouteRequestId != j) {
                            L.Tag tag = PoiCardDataProvider.TAG;
                            L.w(tag, "onNewRouteError , request outdated , currentRequestId:" + PoiCardDataProvider.this.mCurrentRouteRequestId + " ,requestId:" + j);
                            if (routeResult.mErrorCode != 37) {
                                TBTManager.getInstance().clearRouteData(j);
                                return;
                            }
                            return;
                        }
                        PoiCardDataProvider.this.mCurrentRouteRequestId = -1L;
                        PoiCardDataProvider.this.handleRouteSilenceFailure(xPPoiInfo2);
                        if (routeResult.mErrorCode != 37) {
                            TBTManager.getInstance().clearRouteData(j);
                        }
                    }
                });
            }
        });
        L.Tag tag = TAG;
        L.i(tag, "<200km silence request route state = " + this.mCurrentRouteRequestId);
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.IPoiCardDataProvider
    public void cancelLastRoute() {
        if (this.mCurrentRouteRequestId != -1) {
            L.Tag tag = TAG;
            L.i(tag, "cancelLastRoute:" + this.mCurrentRouteRequestId);
            TBTManager.getInstance().cancelRequestRoute(this.mCurrentRouteRequestId);
            this.mCurrentRouteRequestId = -1L;
        }
    }

    @Override // com.xiaopeng.montecarlo.views.poicard.IPoiCardDataProvider
    public void reset() {
        this.mDataProviderListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRouteSilenceFailure(XPPoiInfo xPPoiInfo) {
        PoiCardDataProviderListener poiCardDataProviderListener = this.mDataProviderListener;
        if (poiCardDataProviderListener != null) {
            poiCardDataProviderListener.onRouteFailure(xPPoiInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRouteSilenceSuccess(RouteResult routeResult, XPPoiInfo xPPoiInfo) {
        if (routeResult == null || routeResult.mRouteInfos == null) {
            return;
        }
        RouteResult.RouteInfo routeInfo = routeResult.mRouteInfos.get(0);
        PoiCardDataProviderListener poiCardDataProviderListener = this.mDataProviderListener;
        if (poiCardDataProviderListener == null || routeInfo == null) {
            return;
        }
        poiCardDataProviderListener.onRouteSuccess(routeResult.mPathResult.getPath(0), routeResult.mPathResult, routeInfo, xPPoiInfo);
    }
}
