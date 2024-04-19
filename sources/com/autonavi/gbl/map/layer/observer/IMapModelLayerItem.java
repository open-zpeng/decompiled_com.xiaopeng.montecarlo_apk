package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.router.MapModelLayerItemRouter;
@IntfAuto(target = MapModelLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IMapModelLayerItem extends ILayerItem {
    boolean getDepthMask();

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    int getItemType();

    int getModelID();
}
