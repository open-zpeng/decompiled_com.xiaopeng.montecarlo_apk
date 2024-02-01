package com.autonavi.gbl.map.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.map.layer.model.LayerItemType;
import com.autonavi.gbl.map.router.ClusterPointLayerItemRouter;
import java.util.ArrayList;
@IntfAuto(target = ClusterPointLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface IClusterPointLayerItem extends IPointLayerItem {
    int getClusterPointSize();

    @Override // com.autonavi.gbl.map.layer.observer.IPointLayerItem, com.autonavi.gbl.map.layer.observer.ILayerItem, com.autonavi.gbl.map.layer.observer.IArrowLayerItem
    @LayerItemType.LayerItemType1
    int getItemType();

    ArrayList<String> getVecOriginalItemID();
}
