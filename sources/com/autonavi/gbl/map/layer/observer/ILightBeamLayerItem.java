package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.router.LightBeamLayerItemRouter;
@IntfAuto(target = LightBeamLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ILightBeamLayerItem extends ILayerItem {
    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    int getItemType();
}
