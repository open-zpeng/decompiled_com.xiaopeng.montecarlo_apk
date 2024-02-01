package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.RouteWeatherLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
import com.autonavi.gbl.route.model.WeatherLabelItem;
@IntfAuto(target = RouteWeatherLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRouteWeatherLayerItem extends IPointLayerItem {
    WeatherLabelItem getMWeatherInfo();
}
