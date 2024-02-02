package com.xiaopeng.montecarlo.scenes.routescene.routechargeplan;

import com.autonavi.gbl.common.model.Coord2DDouble;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.httpclient.HttpClientManager;
import com.xiaopeng.montecarlo.navcore.httpclient.interfaces.IChargeStationSearchService;
import com.xiaopeng.montecarlo.navcore.httpclient.requests.ChargeSearchByOneRequest;
import com.xiaopeng.montecarlo.navcore.httpclient.responses.ChargeSearchByOneResponse;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.powerdistance.dataprovider.PdExternalData;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.carservice.CarServiceManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.L;
import com.xiaopeng.montecarlo.root.util.UiHandlerUtil;
import com.xiaopeng.montecarlo.root.util.WorkThreadUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class RouteChargeModel {
    private static final int ROUTE_CHARGE_SIZE = 50;
    private static final L.Tag TAG = new L.Tag("ROUTE_CHARGE_Model");
    private IRouteChargeModelCallBack mCallBack;
    private volatile boolean mIsStop = false;
    IChargeStationSearchService mChargeStationSearchService = (IChargeStationSearchService) HttpClientManager.getInstance().getService(IChargeStationSearchService.class);

    /* loaded from: classes3.dex */
    public interface IRouteChargeModelCallBack {
        void onNetworkError();

        void onRouteChargesError();

        void onRouteChargesFetched(RouteChargeResultData routeChargeResultData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RouteChargeModel(IRouteChargeModelCallBack iRouteChargeModelCallBack) {
        this.mCallBack = iRouteChargeModelCallBack;
    }

    private ChargeSearchByOneRequest createRequest(long j, List<Coord2DDouble> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        ArrayList<Coord2DDouble> arrayList = new ArrayList(list);
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        DecimalFormat decimalFormat = new DecimalFormat("#.000000");
        StringBuilder sb = new StringBuilder();
        for (Coord2DDouble coord2DDouble : arrayList) {
            sb.append(decimalFormat.format(coord2DDouble.lon));
            sb.append(",");
            sb.append(decimalFormat.format(coord2DDouble.lat));
            sb.append(LocationUtils.DR_RECORD_DATA_SPLIT_CHAR);
        }
        XPPoiInfo endInfo = TBTManager.getInstance().getEndInfo(TBTManager.getInstance().getCurrentRouteRequestId());
        if (endInfo == null) {
            L.w(TAG, "createParam but end info was null");
            return null;
        }
        sb.append(decimalFormat.format(endInfo.getDisplayLon()));
        sb.append(",");
        sb.append(decimalFormat.format(endInfo.getDisplayLat()));
        return new ChargeSearchByOneRequest().setLat(decimalFormat.format(startPOIFromCurrent.getDisplayLat())).setLng(decimalFormat.format(startPOIFromCurrent.getDisplayLon())).setRemainDis(CarServiceManager.getInstance().getCarRemainDistance()).setPath(sb.toString()).setLocationType(1).setSize(50);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startChargeRequest(final ConcurrentHashMap<Long, PdExternalData> concurrentHashMap) {
        this.mIsStop = false;
        WorkThreadUtil.getInstance().executeCachedTask(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.-$$Lambda$RouteChargeModel$bybRdcSb8Ky3qh1L_YFkxxK0L-0
            @Override // java.lang.Runnable
            public final void run() {
                RouteChargeModel.this.lambda$startChargeRequest$0$RouteChargeModel(concurrentHashMap);
            }
        });
    }

    public /* synthetic */ void lambda$startChargeRequest$0$RouteChargeModel(ConcurrentHashMap concurrentHashMap) {
        for (Long l : concurrentHashMap.keySet()) {
            if (this.mIsStop) {
                return;
            }
            List<Coord2DDouble> routeKeyPoints = RouteChargeHelper.getRouteKeyPoints(concurrentHashMap, l.longValue());
            if (CollectionUtils.isEmpty(routeKeyPoints)) {
                L.w(TAG, "pointMap is empty");
            } else {
                ChargeSearchByOneResponse searchByOne = this.mChargeStationSearchService.searchByOne(createRequest(l.longValue(), routeKeyPoints));
                if (searchByOne != null) {
                    final RouteChargeResultData routeChargeResultData = new RouteChargeResultData(l.longValue());
                    routeChargeResultData.setCharges(searchByOne.getList());
                    routeChargeResultData.setStatus(routeChargeResultData.parseStatus());
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeModel.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RouteChargeModel.this.mCallBack != null) {
                                RouteChargeModel.this.mCallBack.onRouteChargesFetched(routeChargeResultData);
                            }
                        }
                    });
                } else {
                    UiHandlerUtil.getInstance().post(new Runnable() { // from class: com.xiaopeng.montecarlo.scenes.routescene.routechargeplan.RouteChargeModel.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RouteChargeModel.this.mCallBack != null) {
                                RouteChargeModel.this.mCallBack.onNetworkError();
                                RouteChargeModel.this.mCallBack.onRouteChargesError();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        if (L.ENABLE) {
            L.d(TAG, "stop");
        }
        this.mIsStop = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unInit() {
        if (L.ENABLE) {
            L.d(TAG, "unInit");
        }
        stop();
        this.mCallBack = null;
    }
}
