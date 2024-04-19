package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.RouteNumberLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = RouteNumberLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IRouteNumberLayerItem extends IPointLayerItem {
    boolean getIsSelectedPath();

    long getPathID();

    int getRouteNumberId();
}
