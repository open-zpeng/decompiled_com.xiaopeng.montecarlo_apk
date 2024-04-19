package com.autonavi.gbl.route.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.route.model.WeatherLabelItem;
import com.autonavi.gbl.route.router.RouteWeatherObserverRouter;
import java.util.ArrayList;
@IntfAuto(target = RouteWeatherObserverRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteWeatherObserver {
    void onWeatherUpdated(long j, ArrayList<WeatherLabelItem> arrayList);
}
