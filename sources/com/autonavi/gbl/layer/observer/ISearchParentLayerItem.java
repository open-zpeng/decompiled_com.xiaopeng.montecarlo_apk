package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.SearchParentLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = SearchParentLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ISearchParentLayerItem extends IPointLayerItem {
    int getMIndex();

    String getMMarkerBGRes();

    String getMText();
}
