package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.common.model.Vector3i;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.router.RctRouteLayerItemRouter;
@IntfAuto(target = RctRouteLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IRctRouteLayerItem extends ILayerItem {
    boolean getCarPos(Vector3i vector3i, float[] fArr, float[] fArr2);

    @Override // com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    int getItemType();
}
