package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.router.RoutePathLayerRouter;
@IntfAuto(target = RoutePathLayerRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRoutePathLayer extends IBaseLayer {
    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    boolean getClickable();

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    LayerScale getDisplayScale();

    boolean getOddVisible();

    long getPathID();

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer, com.autonavi.gbl.map.observer.ICollisionGroup
    LayerPriority getPriority();

    RouteLayerDrawParam getRouteDrawParam();

    boolean getSelectStatus();

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    boolean getVisible();

    boolean isPathIntersectRect(RectDouble rectDouble);
}
