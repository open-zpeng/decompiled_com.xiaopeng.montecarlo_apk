package com.autonavi.gbl.route.observer.impl;

import com.autonavi.gbl.common.path.model.RouteLimitInfo;
import com.autonavi.gbl.common.path.option.impl.PathInfoImpl;
import com.autonavi.gbl.route.model.PathResultData;
import com.autonavi.gbl.route.model.WeatherLabelItem;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RouteObserverJNI {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void swig_jni_init() {
    }

    public static void SwigDirector_IRouteWeatherObserverImpl_onWeatherUpdated(IRouteWeatherObserverImpl iRouteWeatherObserverImpl, long j, ArrayList<WeatherLabelItem> arrayList) {
        iRouteWeatherObserverImpl.onWeatherUpdated(j, arrayList);
    }

    public static void SwigDirector_IRouteResultObserverImpl_onNewRoute(IRouteResultObserverImpl iRouteResultObserverImpl, PathResultData pathResultData, ArrayList<PathInfoImpl> arrayList, RouteLimitInfo routeLimitInfo) {
        iRouteResultObserverImpl.onNewRoute(pathResultData, arrayList, routeLimitInfo);
    }

    public static void SwigDirector_IRouteResultObserverImpl_onNewRouteError(IRouteResultObserverImpl iRouteResultObserverImpl, PathResultData pathResultData, RouteLimitInfo routeLimitInfo) {
        iRouteResultObserverImpl.onNewRouteError(pathResultData, routeLimitInfo);
    }
}
