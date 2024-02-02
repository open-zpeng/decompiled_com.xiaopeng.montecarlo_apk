package com.autonavi.gbl.layer.observer;

import com.autonavi.auto.intfauto.BuildType;
import com.autonavi.auto.intfauto.IntfAuto;
import com.autonavi.gbl.layer.router.SearchChildLayerItemRouter;
import com.autonavi.gbl.map.layer.observer.IPointLayerItem;
@IntfAuto(target = SearchChildLayerItemRouter.class, type = BuildType.JINTF)
/* loaded from: classes.dex */
public interface ISearchChildLayerItem extends IPointLayerItem {
    int getMChildType();

    String getMShortName();
}
