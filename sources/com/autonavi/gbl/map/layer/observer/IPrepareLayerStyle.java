package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
import com.autonavi.gbl.map.router.PrepareLayerStyleRouter;
@IntfAuto(target = PrepareLayerStyleRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IPrepareLayerStyle {
    default void clearLayerItem(BaseLayer baseLayer, LayerItem layerItem) {
    }

    default void clearLayerItems(BaseLayer baseLayer) {
    }

    default void clearLayerStyle(BaseLayer baseLayer, LayerItem layerItem) {
    }

    int get3DModelId(BaseLayer baseLayer, LayerItem layerItem, String str);

    String getCommonInfo(String str);

    String getLayerStyle(BaseLayer baseLayer, LayerItem layerItem, boolean z);

    int getMarkerId(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo);

    boolean getRouteLayerStyle(BaseLayer baseLayer, LayerItem layerItem, RouteLayerStyle routeLayerStyle);

    boolean isRouteCacheStyleEnabled();

    boolean isRouteStyleNightMode();

    boolean switchStyle(int i);
}
