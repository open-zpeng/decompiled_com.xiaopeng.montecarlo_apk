package com.autonavi.gbl.route.observer.impl;

import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.common.path.option.PathInfo;
import com.autonavi.gbl.common.path.option.impl.IRouteOptionImpl;
import com.autonavi.gbl.route.model.BLRerouteRequestInfo;
import com.autonavi.gbl.route.model.ChargingStationID;
import com.autonavi.gbl.route.model.ConsisPathIdentity;
import com.autonavi.gbl.route.model.PathResultData;
import com.autonavi.gbl.route.model.RouteAlongServiceAreaInfo;
import com.autonavi.gbl.route.model.RouteServiceArea;
import com.autonavi.gbl.route.model.WeatherLabelItem;
import com.autonavi.gbl.util.model.BinaryStream;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RouteObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_INaviRerouteObserverImpl_onModifyRerouteOption(INaviRerouteObserverImpl iNaviRerouteObserverImpl, IRouteOptionImpl iRouteOptionImpl) {
        iNaviRerouteObserverImpl.onModifyRerouteOption(iRouteOptionImpl);
    }

    public static void SwigDirector_INaviRerouteObserverImpl_onRerouteInfo(INaviRerouteObserverImpl iNaviRerouteObserverImpl, BLRerouteRequestInfo bLRerouteRequestInfo) {
        iNaviRerouteObserverImpl.onRerouteInfo(bLRerouteRequestInfo);
    }

    public static void SwigDirector_INaviRerouteObserverImpl_onSwitchParallelRoadRerouteInfo(INaviRerouteObserverImpl iNaviRerouteObserverImpl, BLRerouteRequestInfo bLRerouteRequestInfo) {
        iNaviRerouteObserverImpl.onSwitchParallelRoadRerouteInfo(bLRerouteRequestInfo);
    }

    public static void SwigDirector_IRouteWeatherObserverImpl_onWeatherUpdated(IRouteWeatherObserverImpl iRouteWeatherObserverImpl, long j, ArrayList<WeatherLabelItem> arrayList) {
        iRouteWeatherObserverImpl.onWeatherUpdated(j, arrayList);
    }

    public static void SwigDirector_IChargingStationIDObserverImpl_onChargingStationIDUpdated(IChargingStationIDObserverImpl iChargingStationIDObserverImpl, ArrayList<ChargingStationID> arrayList) {
        iChargingStationIDObserverImpl.onChargingStationIDUpdated(arrayList);
    }

    public static void SwigDirector_IRouteServiceAreaObserverImpl_onServiceAreaUpdated(IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl, ArrayList<RouteServiceArea> arrayList) {
        iRouteServiceAreaObserverImpl.onServiceAreaUpdated(arrayList);
    }

    public static void SwigDirector_IRouteServiceAreaObserverImpl_onUpdateAlongServiceArea(IRouteServiceAreaObserverImpl iRouteServiceAreaObserverImpl, ArrayList<RouteAlongServiceAreaInfo> arrayList) {
        iRouteServiceAreaObserverImpl.onUpdateAlongServiceArea(arrayList);
    }

    public static void SwigDirector_IRouteResultObserverImpl_onNewRoute(IRouteResultObserverImpl iRouteResultObserverImpl, PathResultData pathResultData, ArrayList<PathInfo> arrayList, RouteLimitInfo routeLimitInfo) {
        iRouteResultObserverImpl.onNewRoute(pathResultData, arrayList, routeLimitInfo);
    }

    public static void SwigDirector_IRouteResultObserverImpl_onNewRouteError(IRouteResultObserverImpl iRouteResultObserverImpl, PathResultData pathResultData, RouteLimitInfo routeLimitInfo) {
        iRouteResultObserverImpl.onNewRouteError(pathResultData, routeLimitInfo);
    }

    public static void SwigDirector_IRouteConsisAdditionObserverImpl_onSyncRouteSuccess(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, long j, ArrayList<ConsisPathIdentity> arrayList) {
        iRouteConsisAdditionObserverImpl.onSyncRouteSuccess(j, arrayList);
    }

    public static void SwigDirector_IRouteConsisAdditionObserverImpl_onSyncRouteError(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, long j, int i) {
        iRouteConsisAdditionObserverImpl.onSyncRouteError(j, i);
    }

    public static void SwigDirector_IRouteConsisAdditionObserverImpl_onSyncRouteResult(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, long j, String str, ArrayList<PathInfo> arrayList, BinaryStream binaryStream, int i) {
        iRouteConsisAdditionObserverImpl.onSyncRouteResult(j, str, arrayList, binaryStream, i);
    }

    public static void SwigDirector_IRouteConsisAdditionObserverImpl_onSyncRouteOption(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, IRouteOptionImpl iRouteOptionImpl) {
        iRouteConsisAdditionObserverImpl.onSyncRouteOption(iRouteOptionImpl);
    }

    public static void SwigDirector_IRouteConsisAdditionObserverImpl_onGetNaviPath(IRouteConsisAdditionObserverImpl iRouteConsisAdditionObserverImpl, ArrayList<ConsisPathIdentity> arrayList, ArrayList<PathInfo> arrayList2) {
        iRouteConsisAdditionObserverImpl.onGetNaviPath(arrayList, arrayList2);
    }
}
