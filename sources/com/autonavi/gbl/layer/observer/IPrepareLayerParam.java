package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.PrepareLayerMarkerParam;
import com.autonavi.gbl.layer.router.PrepareLayerParamRouter;
import com.autonavi.gbl.map.layer.BaseLayer;
import com.autonavi.gbl.map.layer.LayerItem;
import com.autonavi.gbl.map.layer.model.ItemStyleInfo;
@IntfAuto(target = PrepareLayerParamRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface IPrepareLayerParam {
    int get3DModelId(BaseLayer baseLayer, LayerItem layerItem, String str);

    boolean getNewStaticMarkerId(BaseLayer baseLayer, LayerItem layerItem, ItemStyleInfo itemStyleInfo, String[] strArr);

    float getPointMarkerScaleFactor();

    boolean getPrepareLayerParam(LayerItem layerItem, PrepareLayerMarkerParam prepareLayerMarkerParam);

    float getRouteWidthScaleFactor(int i);
}
