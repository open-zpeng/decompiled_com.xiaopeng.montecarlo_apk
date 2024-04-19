package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.PrepareLayerStyleInnerRouter;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
import com.autonavi.gbl.map.layer.model.RouteLayerStyle;
import com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle;
@IntfAuto(target = PrepareLayerStyleInnerRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IPrepareLayerStyleInner extends IPrepareLayerStyle {
    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    void clearLayerItem(BaseLayer baseLayer, LayerItem layerItem);

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    void clearLayerItems(BaseLayer baseLayer);

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    void clearLayerStyle(BaseLayer baseLayer, LayerItem layerItem);

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    int get3DModelId(BaseLayer baseLayer, LayerItem layerItem, String str);

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    String getCommonInfo(String str);

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    String getLayerStyle(BaseLayer baseLayer, LayerItem layerItem, boolean z);

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    int getMarkerId(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo);

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    boolean getRouteLayerStyle(BaseLayer baseLayer, LayerItem layerItem, RouteLayerStyle routeLayerStyle);

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    boolean isRouteCacheStyleEnabled();

    @Override // com.autonavi.gbl.map.layer.observer.IPrepareLayerStyle
    boolean isRouteStyleNightMode();

    void setParam(PrepareLayerParam prepareLayerParam);
}
