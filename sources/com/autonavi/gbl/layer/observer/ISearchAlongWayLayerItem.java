package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.AlongWayLabelType;
import com.autonavi.gbl.layer.model.SearchAlongWayExtraData;
import com.autonavi.gbl.layer.model.SearchAlongwayType;
import com.autonavi.gbl.layer.router.SearchAlongWayLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = SearchAlongWayLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes2.dex */
public interface ISearchAlongWayLayerItem extends IPointLayerItem {
    SearchAlongWayExtraData getMExtraData();

    @AlongWayLabelType.AlongWayLabelType1
    int getMLabelType();

    String getMName();

    @SearchAlongwayType.SearchAlongwayType1
    int getMSearchType();

    int getMTypeCode();
}
