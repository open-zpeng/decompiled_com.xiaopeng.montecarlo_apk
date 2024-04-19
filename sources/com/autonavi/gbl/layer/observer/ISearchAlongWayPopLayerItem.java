package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.model.AlongWayLabelType;
import com.autonavi.gbl.layer.model.BizDirectionStyle;
import com.autonavi.gbl.layer.model.SearchAlongWayExtraData;
import com.autonavi.gbl.layer.router.SearchAlongWayPopLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IQuadrantLayerItem;
@IntfAuto(target = SearchAlongWayPopLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ISearchAlongWayPopLayerItem extends IQuadrantLayerItem {
    @BizDirectionStyle.BizDirectionStyle1
    int getMDirectionStyle();

    SearchAlongWayExtraData getMExtraData();

    @AlongWayLabelType.AlongWayLabelType1
    int getMLabelType();

    String getMName();

    int getMSearchType();

    int getMTypeCode();
}
