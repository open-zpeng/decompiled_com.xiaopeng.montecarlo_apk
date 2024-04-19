package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.card.model.CustomTextureParam;
import com.autonavi.gbl.layer.model.PrepareLayerMarkerParam;
import com.autonavi.gbl.layer.router.PrepareLayerParamInnerRouter;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
@IntfAuto(target = PrepareLayerParamInnerRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IPrepareLayerParamInner extends IPrepareLayerParam {
    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerParam
    int get3DModelId(BaseLayer baseLayer, LayerItem layerItem, String str);

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerParam
    boolean getNewStaticMarkerId(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo, String[] strArr);

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerParam
    float getPointMarkerScaleFactor();

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerParam
    boolean getPrepareLayerParam(LayerItem layerItem, PrepareLayerMarkerParam prepareLayerMarkerParam);

    @Override // com.autonavi.gbl.layer.observer.IPrepareLayerParam
    float getRouteWidthScaleFactor(int i);

    boolean isDynamicMarker(String str);

    boolean isEnglish();

    boolean isInForeground();

    boolean isNightMode();

    boolean isRouteCacheStyleEnabled();

    boolean isRouteStyleNightMode();

    boolean isStaticMarker(String str);

    boolean updateCardContent(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo, CustomTextureParam customTextureParam);
}
