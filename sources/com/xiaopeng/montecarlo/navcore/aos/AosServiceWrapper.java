package com.xiaopeng.montecarlo.navcore.aos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.gbl.aosclient.BLAosService;
import com.autonavi.gbl.aosclient.model.BLAosCookie;
import com.autonavi.gbl.aosclient.model.BLResponseBase;
import com.autonavi.gbl.aosclient.model.CEtaRequestRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdBindRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdCheckTokenRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickLoginRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdQuickRegisterRequestParam;
import com.autonavi.gbl.aosclient.model.GCarLtdUnbindRequestParam;
import com.autonavi.gbl.aosclient.model.GNavigationEtaqueryReqStartPoints;
import com.autonavi.gbl.aosclient.model.GNavigationEtaqueryRequestParam;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherRequestParam;
import com.autonavi.gbl.aosclient.model.GQueryPersentWeatherResponseParam;
import com.autonavi.gbl.aosclient.model.GWsPpCarltdCheckbindRequestParam;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdBind;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdCheckToken;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdQuickLogin;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdQuickRegister;
import com.autonavi.gbl.aosclient.observer.ICallBackCarLtdUnbind;
import com.autonavi.gbl.aosclient.observer.ICallBackEtaRequest;
import com.autonavi.gbl.aosclient.observer.ICallBackNavigationEtaquery;
import com.autonavi.gbl.aosclient.observer.ICallBackQueryPersentWeather;
import com.autonavi.gbl.aosclient.observer.ICallBackWsPpCarltdCheckbind;
import com.autonavi.gbl.servicemanager.ServiceMgr;
import com.xiaopeng.montecarlo.navcore.bean.search.XPPoiInfo;
import com.xiaopeng.montecarlo.navcore.location.LocationUtils;
import com.xiaopeng.montecarlo.navcore.setting.SettingWrapper;
import com.xiaopeng.montecarlo.navcore.util.BLParams;
import com.xiaopeng.montecarlo.navcore.xptbt.TBTManager;
import com.xiaopeng.montecarlo.root.util.CollectionUtils;
import com.xiaopeng.montecarlo.root.util.GsonUtil;
import com.xiaopeng.montecarlo.root.util.L;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes2.dex */
public class AosServiceWrapper {
    public static final String AOS_SERVICE_SOURCE = "10012";
    public static final int CODE_FAILURE = 2;
    public static final int CODE_SUCCESSFUL = 1;
    private Object mEventObserver = new Object() { // from class: com.xiaopeng.montecarlo.navcore.aos.AosServiceWrapper.1
        @Subscribe(threadMode = ThreadMode.MAIN)
        public void onAosEvent(AosEvent aosEvent) {
            BLResponseBase responseBase = aosEvent.getResponseBase();
            if (responseBase == null) {
                if (L.ENABLE) {
                    L.d(AosServiceWrapper.TAG, "onAosAccountEvent accountAosResult is null");
                }
            } else if (responseBase instanceof GQueryPersentWeatherResponseParam) {
                AosServiceWrapper.this.gQueryPersentWeatherResponseParam((GQueryPersentWeatherResponseParam) responseBase);
            }
        }
    };
    private IBaseAosCallBack mQueryPersentWeatherCallBack;
    private static final AosServiceWrapper sInstance = new AosServiceWrapper();
    private static final L.Tag TAG = new L.Tag("aosserv");

    private AosServiceWrapper() {
    }

    @NonNull
    public static AosServiceWrapper getInstance() {
        return sInstance;
    }

    public void register() {
        if (EventBus.getDefault().isRegistered(this.mEventObserver)) {
            return;
        }
        EventBus.getDefault().register(this.mEventObserver);
    }

    public void unRegister() {
        if (EventBus.getDefault().isRegistered(this.mEventObserver)) {
            EventBus.getDefault().unregister(this.mEventObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gQueryPersentWeatherResponseParam(GQueryPersentWeatherResponseParam gQueryPersentWeatherResponseParam) {
        IBaseAosCallBack iBaseAosCallBack = this.mQueryPersentWeatherCallBack;
        if (iBaseAosCallBack != null) {
            iBaseAosCallBack.onDataFetched(gQueryPersentWeatherResponseParam);
        }
    }

    public void requestQueryPersentWeather(GQueryPersentWeatherRequestParam gQueryPersentWeatherRequestParam, IBaseAosCallBack<GQueryPersentWeatherResponseParam> iBaseAosCallBack, ICallBackQueryPersentWeather iCallBackQueryPersentWeather) {
        getInstance().getBLAosService().sendReqQueryPersentWeather(gQueryPersentWeatherRequestParam, iCallBackQueryPersentWeather);
        this.mQueryPersentWeatherCallBack = iBaseAosCallBack;
    }

    public BLAosService getBLAosService() {
        return (BLAosService) ServiceMgr.getServiceMgrInstance().getBLService(18);
    }

    public long requestCarLtdCheckBind(String str, ICallBackWsPpCarltdCheckbind iCallBackWsPpCarltdCheckbind) {
        GWsPpCarltdCheckbindRequestParam gWsPpCarltdCheckbindRequestParam = new GWsPpCarltdCheckbindRequestParam();
        gWsPpCarltdCheckbindRequestParam.source = AOS_SERVICE_SOURCE;
        gWsPpCarltdCheckbindRequestParam.identify = str;
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap check-bind param= " + GsonUtil.toJson(gWsPpCarltdCheckbindRequestParam));
        }
        return getBLAosService().sendReqWsPpCarltdCheckbind(gWsPpCarltdCheckbindRequestParam, iCallBackWsPpCarltdCheckbind);
    }

    public long requestCarLtdBind(@NonNull GCarLtdBindRequestParam gCarLtdBindRequestParam, ICallBackCarLtdBind iCallBackCarLtdBind) {
        gCarLtdBindRequestParam.source = AOS_SERVICE_SOURCE;
        if (gCarLtdBindRequestParam != null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "bindmap requestCarLtdBind param = " + GsonUtil.toJson(gCarLtdBindRequestParam));
            }
            return getBLAosService().sendReqCarLtdBind(gCarLtdBindRequestParam, iCallBackCarLtdBind);
        }
        return -1L;
    }

    public long requestCarLtdUBind(String str, @Nullable ICallBackCarLtdUnbind iCallBackCarLtdUnbind) {
        GCarLtdUnbindRequestParam gCarLtdUnbindRequestParam = new GCarLtdUnbindRequestParam();
        gCarLtdUnbindRequestParam.auth_id = str;
        gCarLtdUnbindRequestParam.source = AOS_SERVICE_SOURCE;
        if (iCallBackCarLtdUnbind != null) {
            if (L.ENABLE) {
                L.Tag tag = TAG;
                L.d(tag, "bindmap requestCarLtdUBind param = " + GsonUtil.toJson(gCarLtdUnbindRequestParam));
            }
            return getBLAosService().sendReqCarLtdUnbind(gCarLtdUnbindRequestParam, iCallBackCarLtdUnbind);
        }
        return -1L;
    }

    public long requestCarLtdCheckToken(String str, ICallBackCarLtdCheckToken iCallBackCarLtdCheckToken) {
        GCarLtdCheckTokenRequestParam gCarLtdCheckTokenRequestParam = new GCarLtdCheckTokenRequestParam();
        gCarLtdCheckTokenRequestParam.source = AOS_SERVICE_SOURCE;
        gCarLtdCheckTokenRequestParam.token = (System.currentTimeMillis() / 1000) + "";
        gCarLtdCheckTokenRequestParam.identify = str;
        gCarLtdCheckTokenRequestParam.deviceCode = "F0D5BFA02EFDF0D5BFA02EFD";
        if (L.ENABLE) {
            L.Tag tag = TAG;
            L.d(tag, "bindmap 请求check-token param=" + GsonUtil.toJson(gCarLtdCheckTokenRequestParam));
        }
        return getBLAosService().sendReqCarLtdCheckToken(gCarLtdCheckTokenRequestParam, iCallBackCarLtdCheckToken);
    }

    public long requestCarLtdQuickLogin(@Nullable GCarLtdQuickLoginRequestParam gCarLtdQuickLoginRequestParam, ICallBackCarLtdQuickLogin iCallBackCarLtdQuickLogin) {
        if (gCarLtdQuickLoginRequestParam != null) {
            return getBLAosService().sendReqCarLtdQuickLogin(gCarLtdQuickLoginRequestParam, iCallBackCarLtdQuickLogin);
        }
        return -1L;
    }

    public long requestCarLtdQuickRegister(@Nullable GCarLtdQuickRegisterRequestParam gCarLtdQuickRegisterRequestParam, ICallBackCarLtdQuickRegister iCallBackCarLtdQuickRegister) {
        if (gCarLtdQuickRegisterRequestParam != null) {
            return getBLAosService().sendReqCarLtdQuickRegister(gCarLtdQuickRegisterRequestParam, iCallBackCarLtdQuickRegister);
        }
        return -1L;
    }

    public long sendReqETARequestRequest(XPPoiInfo xPPoiInfo, ICallBackEtaRequest iCallBackEtaRequest) {
        return sendReqETARequestRequest(xPPoiInfo.getDisplayLon(), xPPoiInfo.getDisplayLat(), iCallBackEtaRequest);
    }

    public long sendReqETARequestRequest(double d, double d2, ICallBackEtaRequest iCallBackEtaRequest) {
        XPPoiInfo startPOIFromCurrent = TBTManager.getInstance().getStartPOIFromCurrent();
        return sendReqETARequestRequest(startPOIFromCurrent.getDisplayLon(), startPOIFromCurrent.getDisplayLat(), d, d2, iCallBackEtaRequest);
    }

    public long sendReqETARequestRequest(double d, double d2, double d3, double d4, ICallBackEtaRequest iCallBackEtaRequest) {
        CEtaRequestRequestParam cEtaRequestRequestParam = new CEtaRequestRequestParam();
        cEtaRequestRequestParam.carplate = SettingWrapper.isOpenPlateSwitch() ? SettingWrapper.getLicensePlate() : "";
        cEtaRequestRequestParam.etype = BLParams.ETA_REQUEST_ETYPE_AUTO;
        cEtaRequestRequestParam.multi_routes = "0";
        cEtaRequestRequestParam.start_x = Double.toString(d);
        cEtaRequestRequestParam.start_y = Double.toString(d2);
        cEtaRequestRequestParam.end_x = Double.toString(d3);
        cEtaRequestRequestParam.end_y = Double.toString(d4);
        cEtaRequestRequestParam.start_poi = "";
        cEtaRequestRequestParam.end_poi = "";
        cEtaRequestRequestParam.start_adcode = "";
        cEtaRequestRequestParam.end_adcode = "";
        cEtaRequestRequestParam.taxi_price_flag = "";
        cEtaRequestRequestParam.content_options = "";
        cEtaRequestRequestParam.vehicle_type = "";
        cEtaRequestRequestParam.vehichle_height = "";
        cEtaRequestRequestParam.vehicle_load = "";
        cEtaRequestRequestParam.policy2 = getAosRouteCalcType();
        cEtaRequestRequestParam.sdk_version = "";
        cEtaRequestRequestParam.partial_result = "";
        L.Tag tag = TAG;
        L.i(tag, "requestETA: [" + d + ", " + d2 + "], [" + d3 + ", " + d4 + "], policy: " + cEtaRequestRequestParam.policy2);
        return sendReqETARequestRequest(cEtaRequestRequestParam, iCallBackEtaRequest);
    }

    private String getAosRouteCalcType() {
        StringBuilder sb = new StringBuilder();
        int allSettingValue = SettingWrapper.getAllSettingValue();
        boolean isAvoidCongestionEnabled = SettingWrapper.isAvoidCongestionEnabled(allSettingValue);
        boolean isAvoidChargeEnabled = SettingWrapper.isAvoidChargeEnabled(allSettingValue);
        boolean isNoFreewaysEnabled = SettingWrapper.isNoFreewaysEnabled(allSettingValue);
        boolean isHighwayPriorityEnabled = SettingWrapper.isHighwayPriorityEnabled(allSettingValue);
        if (isAvoidCongestionEnabled) {
            sb.append("2");
        }
        if (isAvoidChargeEnabled) {
            if (sb.toString().isEmpty()) {
                sb.append("4");
            } else {
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                sb.append("4");
            }
        }
        if (isNoFreewaysEnabled) {
            if (sb.toString().isEmpty()) {
                sb.append(BLParams.AOS_ROUTE_TYPE_NO_FREEWAY);
            } else {
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                sb.append(BLParams.AOS_ROUTE_TYPE_NO_FREEWAY);
            }
        }
        if (isHighwayPriorityEnabled) {
            if (sb.toString().isEmpty()) {
                sb.append(BLParams.AOS_ROUTE_TYPE_HIGHWAY);
            } else {
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                sb.append(BLParams.AOS_ROUTE_TYPE_HIGHWAY);
            }
        }
        if (sb.toString().isEmpty()) {
            sb.append("1");
        }
        return sb.toString();
    }

    public long sendReqETARequestRequest(CEtaRequestRequestParam cEtaRequestRequestParam, ICallBackEtaRequest iCallBackEtaRequest) {
        return getBLAosService().sendReqEtaRequestRequest(cEtaRequestRequestParam, iCallBackEtaRequest);
    }

    public long requestNToOneETA(List<XPPoiInfo> list, XPPoiInfo xPPoiInfo, ICallBackNavigationEtaquery iCallBackNavigationEtaquery) {
        if (xPPoiInfo == null || CollectionUtils.isEmpty(list)) {
            return -1L;
        }
        GNavigationEtaqueryRequestParam gNavigationEtaqueryRequestParam = new GNavigationEtaqueryRequestParam();
        for (int i = 0; i < list.size(); i++) {
            GNavigationEtaqueryReqStartPoints gNavigationEtaqueryReqStartPoints = new GNavigationEtaqueryReqStartPoints();
            gNavigationEtaqueryReqStartPoints.idx = i;
            gNavigationEtaqueryReqStartPoints.lat = list.get(i).getDisplayLat();
            gNavigationEtaqueryReqStartPoints.lon = list.get(i).getDisplayLon();
            gNavigationEtaqueryReqStartPoints.type = 2;
            gNavigationEtaqueryRequestParam.start.points.add(gNavigationEtaqueryReqStartPoints);
        }
        GNavigationEtaqueryReqStartPoints gNavigationEtaqueryReqStartPoints2 = new GNavigationEtaqueryReqStartPoints();
        gNavigationEtaqueryReqStartPoints2.idx = 0;
        gNavigationEtaqueryReqStartPoints2.lat = xPPoiInfo.getDisplayLat();
        gNavigationEtaqueryReqStartPoints2.lon = xPPoiInfo.getDisplayLon();
        gNavigationEtaqueryReqStartPoints2.type = 2;
        gNavigationEtaqueryRequestParam.end.points.add(gNavigationEtaqueryReqStartPoints2);
        gNavigationEtaqueryRequestParam.OneToN = "1";
        return sendReqNavigationETAQuery(gNavigationEtaqueryRequestParam, iCallBackNavigationEtaquery);
    }

    public long requestOneToNETA(XPPoiInfo xPPoiInfo, List<XPPoiInfo> list, ICallBackNavigationEtaquery iCallBackNavigationEtaquery) {
        if (xPPoiInfo == null || CollectionUtils.isEmpty(list)) {
            return -1L;
        }
        GNavigationEtaqueryRequestParam gNavigationEtaqueryRequestParam = new GNavigationEtaqueryRequestParam();
        GNavigationEtaqueryReqStartPoints gNavigationEtaqueryReqStartPoints = new GNavigationEtaqueryReqStartPoints();
        gNavigationEtaqueryReqStartPoints.idx = 0;
        gNavigationEtaqueryReqStartPoints.lat = xPPoiInfo.getDisplayLat();
        gNavigationEtaqueryReqStartPoints.lon = xPPoiInfo.getDisplayLon();
        gNavigationEtaqueryReqStartPoints.type = 2;
        gNavigationEtaqueryRequestParam.start.points.add(gNavigationEtaqueryReqStartPoints);
        for (int i = 0; i < list.size(); i++) {
            GNavigationEtaqueryReqStartPoints gNavigationEtaqueryReqStartPoints2 = new GNavigationEtaqueryReqStartPoints();
            gNavigationEtaqueryReqStartPoints2.idx = i;
            gNavigationEtaqueryReqStartPoints2.lat = list.get(i).getDisplayLat();
            gNavigationEtaqueryReqStartPoints2.lon = list.get(i).getDisplayLon();
            gNavigationEtaqueryReqStartPoints2.type = 2;
            gNavigationEtaqueryRequestParam.end.points.add(gNavigationEtaqueryReqStartPoints2);
        }
        gNavigationEtaqueryRequestParam.OneToN = "1";
        return sendReqNavigationETAQuery(gNavigationEtaqueryRequestParam, iCallBackNavigationEtaquery);
    }

    public long requestOneToNETA(List<XPPoiInfo> list, ICallBackNavigationEtaquery iCallBackNavigationEtaquery) {
        return requestOneToNETA(TBTManager.getInstance().getStartPOIFromCurrent(), list, iCallBackNavigationEtaquery);
    }

    public long requestETA(List<XPPoiInfo> list, List<XPPoiInfo> list2, List<XPPoiInfo> list3, String str, ICallBackNavigationEtaquery iCallBackNavigationEtaquery) {
        if (CollectionUtils.isEmpty(list) || CollectionUtils.isEmpty(list2)) {
            return -1L;
        }
        GNavigationEtaqueryRequestParam gNavigationEtaqueryRequestParam = new GNavigationEtaqueryRequestParam();
        for (int i = 0; i < list.size(); i++) {
            GNavigationEtaqueryReqStartPoints gNavigationEtaqueryReqStartPoints = new GNavigationEtaqueryReqStartPoints();
            gNavigationEtaqueryReqStartPoints.idx = i;
            gNavigationEtaqueryReqStartPoints.lat = list.get(i).getDisplayLat();
            gNavigationEtaqueryReqStartPoints.lon = list.get(i).getDisplayLon();
            gNavigationEtaqueryReqStartPoints.type = 2;
            gNavigationEtaqueryRequestParam.start.points.add(gNavigationEtaqueryReqStartPoints);
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            GNavigationEtaqueryReqStartPoints gNavigationEtaqueryReqStartPoints2 = new GNavigationEtaqueryReqStartPoints();
            gNavigationEtaqueryReqStartPoints2.idx = i2;
            gNavigationEtaqueryReqStartPoints2.lat = list2.get(i2).getDisplayLat();
            gNavigationEtaqueryReqStartPoints2.lon = list2.get(i2).getDisplayLon();
            gNavigationEtaqueryReqStartPoints2.type = 2;
            gNavigationEtaqueryRequestParam.end.points.add(gNavigationEtaqueryReqStartPoints2);
        }
        if (CollectionUtils.isNotEmpty(list3)) {
            for (int i3 = 0; i3 < list3.size(); i3++) {
                GNavigationEtaqueryReqStartPoints gNavigationEtaqueryReqStartPoints3 = new GNavigationEtaqueryReqStartPoints();
                gNavigationEtaqueryReqStartPoints3.idx = i3;
                gNavigationEtaqueryReqStartPoints3.lat = list3.get(i3).getDisplayLat();
                gNavigationEtaqueryReqStartPoints3.lon = list3.get(i3).getDisplayLon();
                gNavigationEtaqueryReqStartPoints3.type = 2;
                gNavigationEtaqueryRequestParam.via.points.add(gNavigationEtaqueryReqStartPoints3);
            }
        }
        gNavigationEtaqueryRequestParam.OneToN = str;
        return sendReqNavigationETAQuery(gNavigationEtaqueryRequestParam, iCallBackNavigationEtaquery);
    }

    public long sendReqNavigationETAQuery(GNavigationEtaqueryRequestParam gNavigationEtaqueryRequestParam, ICallBackNavigationEtaquery iCallBackNavigationEtaquery) {
        int allSettingValue = SettingWrapper.getAllSettingValue();
        boolean isAvoidCongestionEnabled = SettingWrapper.isAvoidCongestionEnabled(allSettingValue);
        boolean isAvoidChargeEnabled = SettingWrapper.isAvoidChargeEnabled(allSettingValue);
        boolean isNoFreewaysEnabled = SettingWrapper.isNoFreewaysEnabled(allSettingValue);
        boolean isHighwayPriorityEnabled = SettingWrapper.isHighwayPriorityEnabled(allSettingValue);
        StringBuilder sb = new StringBuilder(BLParams.ETA_ROUTE_TYPE_NONE);
        if (isHighwayPriorityEnabled) {
            sb.append(BLParams.ETA_ROUTE_TYPE_HIWAY_FIRST);
        } else {
            if (isNoFreewaysEnabled) {
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                sb.append(BLParams.ETA_ROUTE_TYPE_NO_HIWAY);
            }
            if (isAvoidChargeEnabled) {
                sb.append(LocationUtils.DR_RECORD_TIMETICK_SPLIT_CHAR);
                sb.append(BLParams.ETA_ROUTE_TYPE_AVOID_CHARGE);
            }
        }
        gNavigationEtaqueryRequestParam.route.option = sb.toString();
        gNavigationEtaqueryRequestParam.route.strategy = isAvoidCongestionEnabled ? 0 : isHighwayPriorityEnabled ? 1 : 2;
        gNavigationEtaqueryRequestParam.client.div = "";
        gNavigationEtaqueryRequestParam.client.source = "";
        gNavigationEtaqueryRequestParam.client.uuid = "";
        gNavigationEtaqueryRequestParam.vehicle.axis = "";
        gNavigationEtaqueryRequestParam.vehicle.weight = "";
        gNavigationEtaqueryRequestParam.vehicle.width = "";
        gNavigationEtaqueryRequestParam.vehicle.height = "";
        gNavigationEtaqueryRequestParam.vehicle.load = "";
        gNavigationEtaqueryRequestParam.vehicle.plate = SettingWrapper.isOpenPlateSwitch() ? SettingWrapper.getLicensePlate() : "";
        gNavigationEtaqueryRequestParam.vehicle.size = "";
        L.Tag tag = TAG;
        L.i(tag, "sendReqNavigationETAQuery: option: " + gNavigationEtaqueryRequestParam.route.option + ", strategy: " + gNavigationEtaqueryRequestParam.route.strategy);
        return getBLAosService().sendReqNavigationEtaquery(gNavigationEtaqueryRequestParam, iCallBackNavigationEtaquery);
    }

    public BLAosCookie getCookie() {
        return getBLAosService().getCookie();
    }

    public int abortRequest(long j) {
        return getBLAosService().abortRequest(j);
    }
}
