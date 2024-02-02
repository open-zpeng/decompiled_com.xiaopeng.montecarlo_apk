package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.RouteEndAreaDirection;
import com.autonavi.gbl.layer.router.EndAreaParentLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = EndAreaParentLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IEndAreaParentLayerItem extends IQuadrantLayerItem {
    @RouteEndAreaDirection.RouteEndAreaDirection1
    int getMDirection();

    int getMLeftEnergy();

    double getMOddLength();

    int getMOddNum();

    String getMPoiName();

    long getMTravelTime();

    int getMWeatherID();
}
