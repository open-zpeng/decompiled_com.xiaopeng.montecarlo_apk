package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.RectDouble;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.layer.model.LayerScale;
import com.autonavi.gbl.map.layer.model.RouteLayerDrawParam;
import com.autonavi.gbl.map.router.RouteLayerItemRouter;
@IntfAuto(target = RouteLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IRouteLayerItem extends ILayerItem {
    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem
    LayerScale getDisplayScale();

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    int getItemType();

    RouteLayerDrawParam getRouteDrawParam();

    boolean getSelectStatus();

    boolean isPathIntersectRect(RectDouble rectDouble);
}
