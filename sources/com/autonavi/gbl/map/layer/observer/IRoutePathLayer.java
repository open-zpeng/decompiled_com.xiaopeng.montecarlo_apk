package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.layer.model.LayerPriority;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.router.RoutePathLayerRouter;
@IntfAuto(target = RoutePathLayerRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IRoutePathLayer extends IBaseLayer {
    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    boolean getClickable();

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    LayerScale getDisplayScale();

    long getPathID();

    @Override // com.autonavi.gbl.map.layer.observer.IBaseLayer
    LayerPriority getPriority();

    RouteLayerDrawParam getRouteDrawParam();

    boolean getSelectStatus();

    boolean isPathIntersectRect(RectDouble rectDouble);
}
